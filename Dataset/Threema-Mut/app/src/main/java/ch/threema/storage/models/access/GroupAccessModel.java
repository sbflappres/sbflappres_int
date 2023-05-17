/*  _____ _
 * |_   _| |_  _ _ ___ ___ _ __  __ _
 *   | | | ' \| '_/ -_) -_) '  \/ _` |_
 *   |_| |_||_|_| \___\___|_|_|_\__,_(_)
 *
 * Threema for Android
 * Copyright (c) 2015-2021 Threema GmbH
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
package ch.threema.storage.models.access;

import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class GroupAccessModel {

    private Access canReceiveMessage = new Access();

    private Access canSendMessage = new Access();

    public GroupAccessModel setCanReceiveMessageAccess(Access access) {
        if (!ListenerUtil.mutListener.listen(70555)) {
            this.canReceiveMessage = access;
        }
        return this;
    }

    public Access getCanReceiveMessageAccess() {
        return this.canReceiveMessage;
    }

    public GroupAccessModel setCanSendMessageAccess(Access access) {
        if (!ListenerUtil.mutListener.listen(70556)) {
            this.canSendMessage = access;
        }
        return this;
    }

    public Access getCanSendMessageAccess() {
        return this.canSendMessage;
    }
}
