/*  _____ _
 * |_   _| |_  _ _ ___ ___ _ __  __ _
 *   | | | ' \| '_/ -_) -_) '  \/ _` |_
 *   |_| |_||_|_| \___\___|_|_|_\__,_(_)
 *
 * Threema for Android
 * Copyright (c) 2017-2021 Threema GmbH
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
package ch.threema.app.voip.util;

import android.os.Build;
import android.util.Log;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

/**
 * AppRTCUtils provides helper functions for managing thread safety.
 */
public final class AppRTCUtils {

    private AppRTCUtils() {
    }

    /**
     *  Helper method which throws an exception  when an assertion has failed.
     */
    public static void assertIsTrue(boolean condition) {
        if (!ListenerUtil.mutListener.listen(59798)) {
            if (!condition) {
                throw new AssertionError("Expected condition to be true");
            }
        }
    }

    /**
     *  Helper method for building a string of thread information.
     */
    public static String getThreadInfo() {
        return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + "]";
    }

    /**
     *  Information about the current build, taken from system properties.
     */
    public static void logDeviceInfo(String tag) {
        if (!ListenerUtil.mutListener.listen(59799)) {
            Log.d(tag, "Android SDK: " + Build.VERSION.SDK_INT + ", " + "Release: " + Build.VERSION.RELEASE + ", " + "Brand: " + Build.BRAND + ", " + "Device: " + Build.DEVICE + ", " + "Id: " + Build.ID + ", " + "Hardware: " + Build.HARDWARE + ", " + "Manufacturer: " + Build.MANUFACTURER + ", " + "Model: " + Build.MODEL + ", " + "Product: " + Build.PRODUCT);
        }
    }
}
