/*  _____ _
 * |_   _| |_  _ _ ___ ___ _ __  __ _
 *   | | | ' \| '_/ -_) -_) '  \/ _` |_
 *   |_| |_||_|_| \___\___|_|_|_\__,_(_)
 *
 * Threema for Android
 * Copyright (c) 2014-2021 Threema GmbH
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
import android.os.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.threema.app.ThreemaApplication;
import ch.threema.app.exceptions.FileSystemNotPresentException;
import ch.threema.app.managers.ServiceManager;
import ch.threema.app.routines.SynchronizeContactsRoutine;
import ch.threema.app.services.PreferenceService;
import ch.threema.app.services.SynchronizeContactsService;
import ch.threema.localcrypto.MasterKeyLockedException;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class SynchronizeContactsUtil {

    private static final Logger logger = LoggerFactory.getLogger(SynchronizeContactsUtil.class);

    public static void startDirectly() {
        SynchronizeContactsRoutine routine = getSynchronizeContactsRoutine();
        if (!ListenerUtil.mutListener.listen(55591)) {
            if (routine != null) {
                if (!ListenerUtil.mutListener.listen(55590)) {
                    routine.run();
                }
            }
        }
    }

    public static void startDirectly(String forIdentity) {
        SynchronizeContactsRoutine routine = getSynchronizeContactsRoutine();
        if (!ListenerUtil.mutListener.listen(55594)) {
            if (routine != null) {
                if (!ListenerUtil.mutListener.listen(55592)) {
                    routine.addProcessIdentity(forIdentity);
                }
                if (!ListenerUtil.mutListener.listen(55593)) {
                    routine.run();
                }
            }
        }
    }

    private static SynchronizeContactsService getSynchronizeContactsService() {
        ServiceManager serviceManager = ThreemaApplication.getServiceManager();
        if (!ListenerUtil.mutListener.listen(55595)) {
            if (serviceManager == null) {
                return null;
            }
        }
        try {
            SynchronizeContactsService synchronizeContactsService = serviceManager.getSynchronizeContactsService();
            return synchronizeContactsService;
        } catch (MasterKeyLockedException | FileSystemNotPresentException e) {
            if (!ListenerUtil.mutListener.listen(55596)) {
                // do nothing
                logger.error("Exception", e);
            }
        }
        return null;
    }

    private static SynchronizeContactsRoutine getSynchronizeContactsRoutine() {
        ServiceManager serviceManager = ThreemaApplication.getServiceManager();
        if (!ListenerUtil.mutListener.listen(55597)) {
            if (serviceManager == null) {
                return null;
            }
        }
        PreferenceService preferenceService = serviceManager.getPreferenceService();
        if (!ListenerUtil.mutListener.listen(55598)) {
            if (preferenceService == null) {
                return null;
            }
        }
        if (!ListenerUtil.mutListener.listen(55600)) {
            if (preferenceService.isSyncContacts()) {
                SynchronizeContactsService synchronizeContactsService = getSynchronizeContactsService();
                if (!ListenerUtil.mutListener.listen(55599)) {
                    if (synchronizeContactsService != null) {
                        return synchronizeContactsService.instantiateSynchronization();
                    }
                }
            }
        }
        return null;
    }

    public static boolean isRestrictedProfile(Context context) {
        UserManager um = (UserManager) context.getSystemService(Context.USER_SERVICE);
        Bundle restrictions = um.getUserRestrictions();
        if (!ListenerUtil.mutListener.listen(55601)) {
            if (restrictions.getBoolean(UserManager.DISALLOW_MODIFY_ACCOUNTS, false)) {
                // cannot add accounts or modify sync profiles
                return true;
            }
        }
        return false;
    }
}
