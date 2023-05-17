/*  _____ _
 * |_   _| |_  _ _ ___ ___ _ __  __ _
 *   | | | ' \| '_/ -_) -_) '  \/ _` |_
 *   |_| |_||_|_| \___\___|_|_|_\__,_(_)
 *
 * Threema for Android
 * Copyright (c) 2020-2021 Threema GmbH
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package ch.threema.app.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.format.DateUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import ch.threema.app.R;
import ch.threema.app.ThreemaApplication;
import ch.threema.app.receivers.SendTextToContactBroadcastReceiver;
import ch.threema.app.utils.ConfigUtils;
import ch.threema.app.utils.LocaleUtil;
import static ch.threema.app.services.NotificationService.NOTIFICATION_CHANNEL_ALERT;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class BackgroundErrorNotification {

    public static final String EXTRA_TEXT_TO_SEND = "text";

    public static final String EXTRA_NOTIFICATION_ID = "notId";

    /**
     *  Show a notification for an error that happened in the background.
     *
     *  If `sendToSupport` is set, tapping on the notification action will result
     *  in a message being composed to the support.
     *
     *  @param appContext The application context.
     *  @param title Notification title.
     *  @param text Notification body (without instructions on how to contact support).
     *  @param scope The scope where the error occurred, e.g. "VoipCallService".
     *  @param sendToSupport Whether a "send to support" action should be shown or not.
     *  @param exception An optional throwable. If set, a stack trace will be included in the support text.
     */
    public static void showNotification(@NonNull Context appContext, @NonNull String title, @NonNull String text, @NonNull String scope, boolean sendToSupport, @Nullable Throwable exception) {
        final NotificationManager notificationManager = (NotificationManager) appContext.getSystemService(Context.NOTIFICATION_SERVICE);
        if (!ListenerUtil.mutListener.listen(31513)) {
            if (notificationManager == null) {
                throw new RuntimeException("Could not show notification: Notification manager is null");
            }
        }
        final NotificationCompat.Builder builder = new NotificationBuilderWrapper(appContext, NOTIFICATION_CHANNEL_ALERT, null).setSmallIcon(R.drawable.ic_notification_small).setTicker(text).setContentTitle(appContext.getString(R.string.error) + ": " + title).setContentText(text).setTimeoutAfter((ListenerUtil.mutListener.listen(31517) ? (30 % DateUtils.MINUTE_IN_MILLIS) : (ListenerUtil.mutListener.listen(31516) ? (30 / DateUtils.MINUTE_IN_MILLIS) : (ListenerUtil.mutListener.listen(31515) ? (30 - DateUtils.MINUTE_IN_MILLIS) : (ListenerUtil.mutListener.listen(31514) ? (30 + DateUtils.MINUTE_IN_MILLIS) : (30 * DateUtils.MINUTE_IN_MILLIS)))))).setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE).setColor(appContext.getResources().getColor(R.color.material_red)).setPriority(NotificationCompat.PRIORITY_HIGH).setStyle(new NotificationCompat.BigTextStyle().bigText(text)).setAutoCancel(true);
        if (!ListenerUtil.mutListener.listen(31529)) {
            if (sendToSupport) {
                // The text should contain all the necessary information.
                final String separator = "\n------\n";
                final StringBuilder supportChannelText = new StringBuilder();
                if (!ListenerUtil.mutListener.listen(31518)) {
                    supportChannelText.append("Hello Threema Support!\n\nAn error occurred in ").append(scope).append(":");
                }
                if (!ListenerUtil.mutListener.listen(31519)) {
                    supportChannelText.append(separator).append(text).append(separator);
                }
                if (!ListenerUtil.mutListener.listen(31521)) {
                    if (exception != null) {
                        if (!ListenerUtil.mutListener.listen(31520)) {
                            supportChannelText.append(exception.toString()).append(separator);
                        }
                    }
                }
                if (!ListenerUtil.mutListener.listen(31522)) {
                    supportChannelText.append("My phone model: ").append(ConfigUtils.getDeviceInfo(appContext, false));
                }
                if (!ListenerUtil.mutListener.listen(31523)) {
                    supportChannelText.append("\nMy app version: ").append(ConfigUtils.getFullAppVersion(appContext));
                }
                if (!ListenerUtil.mutListener.listen(31524)) {
                    supportChannelText.append("\nMy app language: ").append(LocaleUtil.getAppLanguage());
                }
                // Reuse the AppLinksActivity class that handles universal links
                Intent replyIntent = new Intent(appContext, SendTextToContactBroadcastReceiver.class);
                if (!ListenerUtil.mutListener.listen(31525)) {
                    replyIntent.putExtra(EXTRA_TEXT_TO_SEND, supportChannelText.toString());
                }
                if (!ListenerUtil.mutListener.listen(31526)) {
                    replyIntent.putExtra(EXTRA_NOTIFICATION_ID, NotificationIDs.BACKGROUND_ERROR);
                }
                if (!ListenerUtil.mutListener.listen(31527)) {
                    replyIntent.putExtra(ThreemaApplication.INTENT_DATA_CONTACT, "*SUPPORT");
                }
                PendingIntent pendingIntent = PendingIntent.getBroadcast(appContext, (int) System.nanoTime(), replyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                // The intent should be triggered by tapping on a notification action
                final NotificationCompat.Action action = new NotificationCompat.Action.Builder(// NOTE: Do *not* use a vector drawable here, it crashes on Android 4!
                R.drawable.ic_send_grey600_24dp, appContext.getString(R.string.send_to_support), pendingIntent).build();
                if (!ListenerUtil.mutListener.listen(31528)) {
                    builder.addAction(action);
                }
            }
        }
        if (!ListenerUtil.mutListener.listen(31530)) {
            notificationManager.notify(NotificationIDs.BACKGROUND_ERROR, builder.build());
        }
    }

    /**
     *  Like {@link #showNotification(Context, String, String, String, boolean, Throwable)},
     *  but accepts string resource references instead of strings.
     */
    public static void showNotification(@NonNull Context appContext, @StringRes int title, @StringRes int text, @NonNull String scope, boolean sendToSupport, @Nullable Throwable throwable) {
        if (!ListenerUtil.mutListener.listen(31531)) {
            showNotification(appContext, appContext.getString(title), appContext.getString(text), scope, sendToSupport, throwable);
        }
    }
}
