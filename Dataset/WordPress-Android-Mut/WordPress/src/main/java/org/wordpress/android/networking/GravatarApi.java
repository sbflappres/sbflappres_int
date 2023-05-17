package org.wordpress.android.networking;

import android.os.Handler;
import android.os.Looper;
import org.wordpress.android.analytics.AnalyticsTracker;
import org.wordpress.android.util.AppLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class GravatarApi {

    public static final String API_BASE_URL = "https://api.gravatar.com/v1/";

    private static final int DEFAULT_TIMEOUT = 15000;

    public interface GravatarUploadListener {

        void onSuccess();

        void onError();
    }

    private static OkHttpClient createClient(final String accessToken) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        if (!ListenerUtil.mutListener.listen(2685)) {
            // https://github.com/square/okhttp/issues/3146#issuecomment-311158567
            httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).readTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(0, 1, TimeUnit.NANOSECONDS));
        }
        if (!ListenerUtil.mutListener.listen(2686)) {
            // add oAuth token usage
            httpClientBuilder.addInterceptor(new Interceptor() {

                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder().header("Authorization", "Bearer " + accessToken).method(original.method(), original.body());
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }
        return httpClientBuilder.build();
    }

    public static Request prepareGravatarUpload(String email, File file) {
        return new Request.Builder().url(API_BASE_URL + "upload-image").post(new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("account", email).addFormDataPart("filedata", file.getName(), new StreamingRequest(file)).build()).build();
    }

    public static void uploadGravatar(final File file, final String email, final String accessToken, final GravatarUploadListener gravatarUploadListener) {
        Request request = prepareGravatarUpload(email, file);
        if (!ListenerUtil.mutListener.listen(2703)) {
            createClient(accessToken).newCall(request).enqueue(new Callback() {

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    if (!ListenerUtil.mutListener.listen(2691)) {
                        if (!response.isSuccessful()) {
                            Map<String, Object> properties = new HashMap<>();
                            if (!ListenerUtil.mutListener.listen(2687)) {
                                properties.put("network_response_code", response.code());
                            }
                            // response's body can only be read once so, keep it in a local variable
                            String responseBody;
                            try {
                                responseBody = response.body().string();
                            } catch (IOException e) {
                                responseBody = "null";
                            }
                            if (!ListenerUtil.mutListener.listen(2688)) {
                                properties.put("network_response_body", responseBody);
                            }
                            if (!ListenerUtil.mutListener.listen(2689)) {
                                AnalyticsTracker.track(AnalyticsTracker.Stat.ME_GRAVATAR_UPLOAD_UNSUCCESSFUL, properties);
                            }
                            if (!ListenerUtil.mutListener.listen(2690)) {
                                AppLog.w(AppLog.T.API, "Network call unsuccessful trying to upload Gravatar: " + responseBody);
                            }
                        }
                    }
                    if (!ListenerUtil.mutListener.listen(2695)) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {

                            @Override
                            public void run() {
                                if (!ListenerUtil.mutListener.listen(2694)) {
                                    if (response.isSuccessful()) {
                                        if (!ListenerUtil.mutListener.listen(2693)) {
                                            gravatarUploadListener.onSuccess();
                                        }
                                    } else {
                                        if (!ListenerUtil.mutListener.listen(2692)) {
                                            gravatarUploadListener.onError();
                                        }
                                    }
                                }
                            }
                        });
                    }
                }

                @Override
                public void onFailure(okhttp3.Call call, final IOException e) {
                    String exceptionClass = e != null ? e.getClass().getCanonicalName() : "null";
                    String exceptionMessage = e != null ? e.getMessage() : "null";
                    if (!ListenerUtil.mutListener.listen(2696)) {
                        AppLog.w(AppLog.T.API, "Network call failure trying to upload Gravatar!" + exceptionMessage);
                    }
                    if (!ListenerUtil.mutListener.listen(2700)) {
                        // Don't track exceptions caused by poor internet connectivity
                        if (!(e instanceof java.net.UnknownHostException)) {
                            Map<String, Object> properties = new HashMap<>();
                            if (!ListenerUtil.mutListener.listen(2697)) {
                                properties.put("network_exception_class", exceptionClass);
                            }
                            if (!ListenerUtil.mutListener.listen(2698)) {
                                properties.put("network_exception_message", exceptionMessage);
                            }
                            if (!ListenerUtil.mutListener.listen(2699)) {
                                AnalyticsTracker.track(AnalyticsTracker.Stat.ME_GRAVATAR_UPLOAD_EXCEPTION, properties);
                            }
                        }
                    }
                    if (!ListenerUtil.mutListener.listen(2702)) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {

                            @Override
                            public void run() {
                                if (!ListenerUtil.mutListener.listen(2701)) {
                                    gravatarUploadListener.onError();
                                }
                            }
                        });
                    }
                }
            });
        }
    }
}
