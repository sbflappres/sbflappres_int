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
package ch.threema.app.utils;

import android.content.Context;
import android.os.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import ch.threema.app.R;
import ch.threema.app.ThreemaApplication;
import ch.threema.app.services.AppRestrictionService;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class AppRestrictionUtil {

    private static final Logger logger = LoggerFactory.getLogger(AppRestrictionUtil.class);

    public static boolean isAddContactDisabled(Context context) {
        return getBoolRestriction(context, R.string.restriction__disable_add_contact);
    }

    public static boolean isCreateGroupDisabled(Context context) {
        return getBoolRestriction(context, R.string.restriction__disable_create_group);
    }

    public static boolean isBackupsDisabled(Context context) {
        return getBoolRestriction(context, R.string.restriction__disable_backups);
    }

    public static boolean isDataBackupsDisabled(Context context) {
        return getBoolRestriction(context, R.string.restriction__disable_data_backups);
    }

    public static boolean isIdBackupsDisabled(Context context) {
        return getBoolRestriction(context, R.string.restriction__disable_id_export);
    }

    public static boolean isExportDisabled(Context context) {
        return getBoolRestriction(context, R.string.restriction__disable_export);
    }

    public static boolean isSaveToGalleryDisabled(Context context) {
        return getBoolRestriction(context, R.string.restriction__disable_save_to_gallery);
    }

    public static boolean isMessagePreviewDisabled(Context context) {
        return getBoolRestriction(context, R.string.restriction__disable_message_preview);
    }

    public static boolean isCallsDisabled(Context context) {
        return getBoolRestriction(context, R.string.restriction__disable_calls);
    }

    public static boolean isReadonlyProfile(Context context) {
        return getBoolRestriction(context, R.string.restriction__readonly_profile);
    }

    public static boolean isWebDisabled(Context context) {
        return getBoolRestriction(context, R.string.restriction__disable_web);
    }

    public static boolean isShareMediaDisabled(Context context) {
        return getBoolRestriction(context, R.string.restriction__disable_share_media);
    }

    public static boolean isVideoCallsDisabled() {
        return getBoolRestriction(ThreemaApplication.getAppContext(), R.string.restriction__disable_video_calls);
    }

    public static boolean isWorkDirectoryDisabled() {
        return getBoolRestriction(ThreemaApplication.getAppContext(), R.string.restriction__disable_work_directory);
    }

    /**
     *  Check if a valid Threema Safe password pattern has been set by means of app restrictions
     *  @param context Context
     *  @return true if a password pattern has been set and its syntax is valid, false otherwise
     */
    public static boolean isSafePasswordPatternSet(Context context) {
        if (!ListenerUtil.mutListener.listen(49248)) {
            if ((ListenerUtil.mutListener.listen(49246) ? (ConfigUtils.isWorkRestricted() || !TestUtil.empty(getSafePasswordPattern(context))) : (ConfigUtils.isWorkRestricted() && !TestUtil.empty(getSafePasswordPattern(context))))) {
                // check validity of regex pattern
                try {
                    if (!ListenerUtil.mutListener.listen(49247)) {
                        Pattern.compile(getSafePasswordPattern(context));
                    }
                    return true;
                } catch (PatternSyntaxException ignored) {
                }
            }
        }
        return false;
    }

    static String getSafePasswordPattern(Context context) {
        return getStringRestriction(context.getString(R.string.restriction__safe_password_pattern));
    }

    public static String getSafePasswordMessage(Context context) {
        String message = getStringRestriction(context.getString(R.string.restriction__safe_password_message));
        if (!ListenerUtil.mutListener.listen(49249)) {
            if (TestUtil.empty(message)) {
                return context.getString(R.string.password_does_not_comply);
            }
        }
        return message;
    }

    /**
     *  Return a list of allowed signaling hosts for Threema Web (or null if no restrictions apply).
     */
    @Nullable
    public static List<String> getWebHosts(@NonNull Context context) {
        final String stringRestriction = getStringRestriction(context.getString(R.string.restriction__web_hosts));
        if (!ListenerUtil.mutListener.listen(49254)) {
            if ((ListenerUtil.mutListener.listen(49250) ? (stringRestriction != null || !stringRestriction.isEmpty()) : (stringRestriction != null && !stringRestriction.isEmpty()))) {
                List<String> hosts = new ArrayList<>();
                if (!ListenerUtil.mutListener.listen(49253)) {
                    {
                        long _loopCounter564 = 0;
                        for (String host : stringRestriction.split(",")) {
                            ListenerUtil.loopListener.listen("_loopCounter564", ++_loopCounter564);
                            final String trimmed = host.trim();
                            if (!ListenerUtil.mutListener.listen(49252)) {
                                if (!trimmed.isEmpty()) {
                                    if (!ListenerUtil.mutListener.listen(49251)) {
                                        hosts.add(trimmed);
                                    }
                                }
                            }
                        }
                    }
                }
                return hosts.isEmpty() ? null : hosts;
            }
        }
        return null;
    }

    /**
     *  Return true in one of the following three cases:
     *
     *  - Threema Web signaling host whitelist is empty
     *  - Hostname is contained in whitelist
     *  - A suffix pattern in the whitelist matches the hostname
     */
    public static boolean isWebHostAllowed(@NonNull Context context, @NonNull String hostname) {
        final List<String> whitelist = getWebHosts(context);
        if (!ListenerUtil.mutListener.listen(49256)) {
            if (whitelist == null) {
                if (!ListenerUtil.mutListener.listen(49255)) {
                    logger.debug("No Threema Web signaling server whitelist set by MDM");
                }
                return true;
            }
        }
        if (!ListenerUtil.mutListener.listen(49257)) {
            logger.info("Validating Threema Web signaling server against whitelist");
        }
        if (!ListenerUtil.mutListener.listen(49258)) {
            logger.debug("Whitelist: {}", whitelist);
        }
        if (!ListenerUtil.mutListener.listen(49264)) {
            {
                long _loopCounter565 = 0;
                for (String pattern : whitelist) {
                    ListenerUtil.loopListener.listen("_loopCounter565", ++_loopCounter565);
                    if (!ListenerUtil.mutListener.listen(49260)) {
                        if (pattern.equals(hostname)) {
                            if (!ListenerUtil.mutListener.listen(49259)) {
                                logger.debug("Host {} matched pattern {}", hostname, pattern);
                            }
                            return true;
                        }
                    }
                    if (!ListenerUtil.mutListener.listen(49263)) {
                        if ((ListenerUtil.mutListener.listen(49261) ? (pattern.startsWith("*") || hostname.endsWith(pattern.substring(1))) : (pattern.startsWith("*") && hostname.endsWith(pattern.substring(1))))) {
                            if (!ListenerUtil.mutListener.listen(49262)) {
                                logger.debug("Host {} matched pattern {}", hostname, pattern);
                            }
                            return true;
                        }
                    }
                }
            }
        }
        if (!ListenerUtil.mutListener.listen(49265)) {
            logger.warn("Threema Web signaling server \"{}\" blocked by MDM", hostname);
        }
        return false;
    }

    /**
     *  get boolean value for restriction
     *  @param context
     *  @param restriction
     *  @return true if restriction value is set to true, false otherwise or if restriction does not exist or app is not restricted
     */
    public static boolean getBoolRestriction(Context context, @StringRes int restriction) {
        if (!ListenerUtil.mutListener.listen(49267)) {
            if (ConfigUtils.isWorkRestricted()) {
                Boolean restrictionValue = getBooleanRestriction(context.getString(restriction));
                return ((ListenerUtil.mutListener.listen(49266) ? (restrictionValue != null || restrictionValue) : (restrictionValue != null && restrictionValue)));
            }
        }
        return false;
    }

    /**
     *  Get a string restriction
     *  @param string Restriction key
     *  @return Restriction value or null if restriction is empty or has not been set
     */
    @Nullable
    public static String getStringRestriction(String string) {
        Bundle appRestrictions = AppRestrictionService.getInstance().getAppRestrictions();
        if (!ListenerUtil.mutListener.listen(49270)) {
            if ((ListenerUtil.mutListener.listen(49268) ? (appRestrictions != null || appRestrictions.containsKey(string)) : (appRestrictions != null && appRestrictions.containsKey(string)))) {
                String preset = appRestrictions.getString(string);
                if (!ListenerUtil.mutListener.listen(49269)) {
                    if (!TestUtil.empty(preset)) {
                        return preset;
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    public static Boolean getBooleanRestriction(String string) {
        Bundle appRestrictions = AppRestrictionService.getInstance().getAppRestrictions();
        if (!ListenerUtil.mutListener.listen(49272)) {
            if ((ListenerUtil.mutListener.listen(49271) ? (appRestrictions != null || appRestrictions.containsKey(string)) : (appRestrictions != null && appRestrictions.containsKey(string)))) {
                return appRestrictions.getBoolean(string);
            }
        }
        return null;
    }
}
