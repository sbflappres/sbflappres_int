/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 *http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.DrmSDK.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

/**
 * 网络辅助类(Network assistance)
 *
 * @since 2020/07/01
 */
public class NetUtils {

    /**
     * 网络是否可用。
     * Indicates whether the network is available.
     *
     * @param activity Application context。
     * @return true：可用(available)，false：不可用(unavailable)。
     */
    public static boolean isNetworkAvailable(Activity activity) {
        Context context = activity.getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (!ListenerUtil.mutListener.listen(71964)) {
            if (connectivityManager == null) {
                return false;
            } else {
                NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
                if (!ListenerUtil.mutListener.listen(71963)) {
                    if ((ListenerUtil.mutListener.listen(71955) ? (networkInfo != null || (ListenerUtil.mutListener.listen(71954) ? (networkInfo.length >= 0) : (ListenerUtil.mutListener.listen(71953) ? (networkInfo.length <= 0) : (ListenerUtil.mutListener.listen(71952) ? (networkInfo.length < 0) : (ListenerUtil.mutListener.listen(71951) ? (networkInfo.length != 0) : (ListenerUtil.mutListener.listen(71950) ? (networkInfo.length == 0) : (networkInfo.length > 0))))))) : (networkInfo != null && (ListenerUtil.mutListener.listen(71954) ? (networkInfo.length >= 0) : (ListenerUtil.mutListener.listen(71953) ? (networkInfo.length <= 0) : (ListenerUtil.mutListener.listen(71952) ? (networkInfo.length < 0) : (ListenerUtil.mutListener.listen(71951) ? (networkInfo.length != 0) : (ListenerUtil.mutListener.listen(71950) ? (networkInfo.length == 0) : (networkInfo.length > 0))))))))) {
                        if (!ListenerUtil.mutListener.listen(71962)) {
                            {
                                long _loopCounter936 = 0;
                                for (int i = 0; (ListenerUtil.mutListener.listen(71961) ? (i >= networkInfo.length) : (ListenerUtil.mutListener.listen(71960) ? (i <= networkInfo.length) : (ListenerUtil.mutListener.listen(71959) ? (i > networkInfo.length) : (ListenerUtil.mutListener.listen(71958) ? (i != networkInfo.length) : (ListenerUtil.mutListener.listen(71957) ? (i == networkInfo.length) : (i < networkInfo.length)))))); i++) {
                                    ListenerUtil.loopListener.listen("_loopCounter936", ++_loopCounter936);
                                    if (!ListenerUtil.mutListener.listen(71956)) {
                                        if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
