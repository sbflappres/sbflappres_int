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
package ch.threema.app.webclient.converter;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import ch.threema.app.utils.QuoteUtil.QuoteContent;
import ch.threema.app.webclient.exceptions.ConversionException;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

@AnyThread
public class Quote extends Converter {

    private static final String FIELD_IDENTITY = "identity";

    private static final String FIELD_TEXT = "text";

    private static final String FIELD_MESSAGE_ID = "messageId";

    private static final String FIELD_MESSAGE = "message";

    /**
     *  Create a Quote object.
     */
    public static MsgpackObjectBuilder convert(@NonNull QuoteContent quoteContent) throws ConversionException {
        final MsgpackObjectBuilder builder = new MsgpackObjectBuilder();
        if (!ListenerUtil.mutListener.listen(62978)) {
            builder.put(FIELD_IDENTITY, quoteContent.identity);
        }
        if (!ListenerUtil.mutListener.listen(62979)) {
            builder.put(FIELD_TEXT, quoteContent.quotedText);
        }
        if (!ListenerUtil.mutListener.listen(62984)) {
            if (quoteContent.isQuoteV2()) {
                if (!ListenerUtil.mutListener.listen(62980)) {
                    builder.put(FIELD_MESSAGE_ID, quoteContent.quotedMessageId);
                }
                if (!ListenerUtil.mutListener.listen(62983)) {
                    if ((ListenerUtil.mutListener.listen(62981) ? (quoteContent.quotedMessageModel != null || quoteContent.receiverType != null) : (quoteContent.quotedMessageModel != null && quoteContent.receiverType != null))) {
                        if (!ListenerUtil.mutListener.listen(62982)) {
                            builder.put(FIELD_MESSAGE, Message.convert(quoteContent.quotedMessageModel, quoteContent.receiverType, false, Message.DETAILS_NO_QUOTE));
                        }
                    }
                }
            }
        }
        return builder;
    }
}
