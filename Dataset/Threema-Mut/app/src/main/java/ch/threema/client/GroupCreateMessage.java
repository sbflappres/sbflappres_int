/*  _____ _
 * |_   _| |_  _ _ ___ ___ _ __  __ _
 *   | | | ' \| '_/ -_) -_) '  \/ _` |_
 *   |_| |_||_|_| \___\___|_|_|_\__,_(_)
 *
 * Threema Java Client
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
package ch.threema.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

/**
 * A group creation message.
 */
public class GroupCreateMessage extends AbstractGroupMessage {

    private static final Logger logger = LoggerFactory.getLogger(GroupCreateMessage.class);

    private String[] members;

    public GroupCreateMessage() {
        super();
    }

    @Override
    public int getType() {
        return ProtocolDefines.MSGTYPE_GROUP_CREATE;
    }

    @Override
    public byte[] getBody() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            if (!ListenerUtil.mutListener.listen(68302)) {
                bos.write(getGroupId().getGroupId());
            }
            if (!ListenerUtil.mutListener.listen(68304)) {
                {
                    long _loopCounter856 = 0;
                    for (String member : members) {
                        ListenerUtil.loopListener.listen("_loopCounter856", ++_loopCounter856);
                        if (!ListenerUtil.mutListener.listen(68303)) {
                            bos.write(member.getBytes(StandardCharsets.US_ASCII));
                        }
                    }
                }
            }
            return bos.toByteArray();
        } catch (Exception e) {
            if (!ListenerUtil.mutListener.listen(68301)) {
                logger.error(e.getMessage());
            }
            return null;
        }
    }

    public String[] getMembers() {
        return members;
    }

    public void setMembers(String[] members) {
        if (!ListenerUtil.mutListener.listen(68305)) {
            this.members = members;
        }
    }
}
