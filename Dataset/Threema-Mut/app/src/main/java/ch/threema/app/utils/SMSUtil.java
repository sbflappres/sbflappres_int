/*  _____ _
 * |_   _| |_  _ _ ___ ___ _ __  __ _
 *   | | | ' \| '_/ -_) -_) '  \/ _` |_
 *   |_| |_||_|_| \___\___|_|_|_\__,_(_)
 *
 * Threema for Android
 * Copyright (c) 2013-2021 Threema GmbH
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

import android.telephony.SmsMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public abstract class SMSUtil {

    /**
     *  Parse a cursor and create a threema sms if the sender is "threema" and the code in the body
     *
     *  @param smsMessage
     *  @return
     */
    public static String getCodeFromMessage(SmsMessage smsMessage) {
        String body = smsMessage.getDisplayMessageBody();
        Pattern codePattern = Pattern.compile(".*https://myid.threema.ch/l/vm\\?code=(\\d{6})", Pattern.CASE_INSENSITIVE);
        Matcher m = codePattern.matcher(body);
        if (!ListenerUtil.mutListener.listen(55448)) {
            if (m.find()) {
                String code = m.group(1);
                if (!ListenerUtil.mutListener.listen(55447)) {
                    if ((ListenerUtil.mutListener.listen(55446) ? (code.length() >= 0) : (ListenerUtil.mutListener.listen(55445) ? (code.length() <= 0) : (ListenerUtil.mutListener.listen(55444) ? (code.length() < 0) : (ListenerUtil.mutListener.listen(55443) ? (code.length() != 0) : (ListenerUtil.mutListener.listen(55442) ? (code.length() == 0) : (code.length() > 0))))))) {
                        return code;
                    }
                }
            }
        }
        return null;
    }
}
