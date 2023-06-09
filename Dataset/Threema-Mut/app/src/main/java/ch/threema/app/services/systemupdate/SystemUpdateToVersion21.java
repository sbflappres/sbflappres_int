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
package ch.threema.app.services.systemupdate;

import net.sqlcipher.database.SQLiteDatabase;
import java.sql.SQLException;
import ch.threema.app.services.UpdateSystemService;
import ch.threema.storage.DatabaseServiceNew;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class SystemUpdateToVersion21 implements UpdateSystemService.SystemUpdate {

    private final DatabaseServiceNew databaseService;

    private final SQLiteDatabase sqLiteDatabase;

    public SystemUpdateToVersion21(DatabaseServiceNew databaseService, SQLiteDatabase sqLiteDatabase) {
        this.databaseService = databaseService;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @Override
    public boolean runDirectly() throws SQLException {
        if (!ListenerUtil.mutListener.listen(36143)) {
            {
                long _loopCounter328 = 0;
                for (String s : this.databaseService.getGroupRequestSyncLogModelFactory().getStatements()) {
                    ListenerUtil.loopListener.listen("_loopCounter328", ++_loopCounter328);
                    if (!ListenerUtil.mutListener.listen(36142)) {
                        this.sqLiteDatabase.execSQL(s);
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean runASync() {
        return true;
    }

    @Override
    public String getText() {
        return "version 21";
    }
}
