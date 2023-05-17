/*  _____ _
 * |_   _| |_  _ _ ___ ___ _ __  __ _
 *   | | | ' \| '_/ -_) -_) '  \/ _` |_
 *   |_| |_||_|_| \___\___|_|_|_\__,_(_)
 *
 * Threema for Android
 * Copyright (c) 2016-2021 Threema GmbH
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
package ch.threema.app.webclient.services.instance.message.receiver;

import android.content.Context;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import org.msgpack.core.MessagePackException;
import org.msgpack.value.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import ch.threema.app.services.PreferenceService;
import ch.threema.app.webclient.Protocol;
import ch.threema.app.webclient.converter.ClientInfo;
import ch.threema.app.webclient.converter.MsgpackObjectBuilder;
import ch.threema.app.webclient.exceptions.ConversionException;
import ch.threema.app.webclient.services.instance.MessageDispatcher;
import ch.threema.app.webclient.services.instance.MessageReceiver;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

/**
 * Webclient sending all client information.
 */
@WorkerThread
public class ClientInfoRequestHandler extends MessageReceiver {

    private static final Logger logger = LoggerFactory.getLogger(ClientInfoRequestHandler.class);

    private final MessageDispatcher dispatcher;

    private final PreferenceService preferenceService;

    private final Context appContext;

    private final Listener listener;

    @WorkerThread
    public interface Listener {

        void onReceived(@NonNull String userAgent);

        void onAnswered(@Nullable String pushToken);
    }

    @AnyThread
    public ClientInfoRequestHandler(MessageDispatcher dispatcher, PreferenceService preferenceService, Context appContext, Listener listener) {
        super(Protocol.SUB_TYPE_CLIENT_INFO);
        this.dispatcher = dispatcher;
        this.preferenceService = preferenceService;
        this.appContext = appContext;
        this.listener = listener;
    }

    @Override
    protected void receive(Map<String, Value> message) throws MessagePackException {
        if (!ListenerUtil.mutListener.listen(63120)) {
            logger.info("Received client information request");
        }
        Map<String, Value> data = this.getData(message, false, new String[] { Protocol.ARGUMENT_USER_AGENT, Protocol.ARGUMENT_BROWSER_NAME, Protocol.ARGUMENT_BROWSER_VERSION });
        if (!ListenerUtil.mutListener.listen(63122)) {
            if (this.listener != null) {
                // TODO: Store detected browser!
                final String userAgent = data.get(Protocol.ARGUMENT_USER_AGENT).asStringValue().asString();
                if (!ListenerUtil.mutListener.listen(63121)) {
                    this.listener.onReceived(userAgent);
                }
            }
        }
        if (!ListenerUtil.mutListener.listen(63123)) {
            this.respond();
        }
    }

    private void respond() {
        // Get the "current" Push Token from application
        final String currentPushToken = this.preferenceService.getPushToken();
        if (!ListenerUtil.mutListener.listen(63126)) {
            if ((ListenerUtil.mutListener.listen(63124) ? (currentPushToken == null && currentPushToken.isEmpty()) : (currentPushToken == null || currentPushToken.isEmpty()))) {
                if (!ListenerUtil.mutListener.listen(63125)) {
                    logger.warn("Warning: Push token is null or empty");
                }
            }
        }
        try {
            final MsgpackObjectBuilder data = ClientInfo.convert(this.appContext, currentPushToken);
            if (!ListenerUtil.mutListener.listen(63128)) {
                this.send(this.dispatcher, data, null);
            }
            if (!ListenerUtil.mutListener.listen(63130)) {
                if (this.listener != null) {
                    if (!ListenerUtil.mutListener.listen(63129)) {
                        this.listener.onAnswered(currentPushToken);
                    }
                }
            }
        } catch (ConversionException e) {
            if (!ListenerUtil.mutListener.listen(63127)) {
                logger.error("Could not convert ClientInfo", e);
            }
        }
    }

    @Override
    protected boolean maybeNeedsConnection() {
        return false;
    }
}
