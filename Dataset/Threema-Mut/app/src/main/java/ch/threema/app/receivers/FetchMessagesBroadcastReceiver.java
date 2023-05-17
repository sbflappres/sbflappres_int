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
package ch.threema.app.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.threema.app.services.PollingHelper;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class FetchMessagesBroadcastReceiver extends BroadcastReceiver {

    private static final Logger logger = LoggerFactory.getLogger(AlarmManagerBroadcastReceiver.class);

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!ListenerUtil.mutListener.listen(34380)) {
            logger.info("FetchMessagesBroadcastReceiver: onReceive");
        }
        PollingHelper pollingHelper = new PollingHelper(context, "Retry from AlarmManager");
        if (!ListenerUtil.mutListener.listen(34381)) {
            pollingHelper.poll(true);
        }
    }
}
