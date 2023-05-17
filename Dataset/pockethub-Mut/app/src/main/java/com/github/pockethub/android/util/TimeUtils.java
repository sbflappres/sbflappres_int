/*
 * Copyright (c) 2015 PocketHub
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pockethub.android.util;

import android.text.format.DateUtils;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static android.text.format.DateUtils.FORMAT_NUMERIC_DATE;
import static android.text.format.DateUtils.FORMAT_SHOW_DATE;
import static android.text.format.DateUtils.FORMAT_SHOW_YEAR;
import static android.text.format.DateUtils.MINUTE_IN_MILLIS;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

/**
 * Utilities for dealing with dates and times
 */
public class TimeUtils {

    /**
     * Get relative time for date
     *
     * @param date
     * @return relative time
     */
    public static CharSequence getRelativeTime(final Date date) {
        long now = System.currentTimeMillis();
        if ((ListenerUtil.mutListener.listen(1872) ? (Math.abs((ListenerUtil.mutListener.listen(1867) ? (now % date.getTime()) : (ListenerUtil.mutListener.listen(1866) ? (now / date.getTime()) : (ListenerUtil.mutListener.listen(1865) ? (now * date.getTime()) : (ListenerUtil.mutListener.listen(1864) ? (now + date.getTime()) : (now - date.getTime())))))) >= TimeUnit.MINUTES.toMillis(1)) : (ListenerUtil.mutListener.listen(1871) ? (Math.abs((ListenerUtil.mutListener.listen(1867) ? (now % date.getTime()) : (ListenerUtil.mutListener.listen(1866) ? (now / date.getTime()) : (ListenerUtil.mutListener.listen(1865) ? (now * date.getTime()) : (ListenerUtil.mutListener.listen(1864) ? (now + date.getTime()) : (now - date.getTime())))))) <= TimeUnit.MINUTES.toMillis(1)) : (ListenerUtil.mutListener.listen(1870) ? (Math.abs((ListenerUtil.mutListener.listen(1867) ? (now % date.getTime()) : (ListenerUtil.mutListener.listen(1866) ? (now / date.getTime()) : (ListenerUtil.mutListener.listen(1865) ? (now * date.getTime()) : (ListenerUtil.mutListener.listen(1864) ? (now + date.getTime()) : (now - date.getTime())))))) < TimeUnit.MINUTES.toMillis(1)) : (ListenerUtil.mutListener.listen(1869) ? (Math.abs((ListenerUtil.mutListener.listen(1867) ? (now % date.getTime()) : (ListenerUtil.mutListener.listen(1866) ? (now / date.getTime()) : (ListenerUtil.mutListener.listen(1865) ? (now * date.getTime()) : (ListenerUtil.mutListener.listen(1864) ? (now + date.getTime()) : (now - date.getTime())))))) != TimeUnit.MINUTES.toMillis(1)) : (ListenerUtil.mutListener.listen(1868) ? (Math.abs((ListenerUtil.mutListener.listen(1867) ? (now % date.getTime()) : (ListenerUtil.mutListener.listen(1866) ? (now / date.getTime()) : (ListenerUtil.mutListener.listen(1865) ? (now * date.getTime()) : (ListenerUtil.mutListener.listen(1864) ? (now + date.getTime()) : (now - date.getTime())))))) == TimeUnit.MINUTES.toMillis(1)) : (Math.abs((ListenerUtil.mutListener.listen(1867) ? (now % date.getTime()) : (ListenerUtil.mutListener.listen(1866) ? (now / date.getTime()) : (ListenerUtil.mutListener.listen(1865) ? (now * date.getTime()) : (ListenerUtil.mutListener.listen(1864) ? (now + date.getTime()) : (now - date.getTime())))))) > TimeUnit.MINUTES.toMillis(1)))))))) {
            return DateUtils.getRelativeTimeSpanString(date.getTime(), now, MINUTE_IN_MILLIS, FORMAT_SHOW_DATE | FORMAT_SHOW_YEAR | FORMAT_NUMERIC_DATE);
        } else {
            return "just now";
        }
    }
}
