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
import ch.threema.storage.factories.ModelFactory;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class SystemUpdateToVersion8 implements UpdateSystemService.SystemUpdate {

    private final DatabaseServiceNew databaseService;

    private final SQLiteDatabase sqLiteDatabase;

    public SystemUpdateToVersion8(DatabaseServiceNew databaseServiceNew, SQLiteDatabase sqLiteDatabase) {
        this.databaseService = databaseServiceNew;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @Override
    public boolean runASync() {
        return true;
    }

    @Override
    public boolean runDirectly() throws SQLException {
        if (!ListenerUtil.mutListener.listen(36501)) {
            {
                long _loopCounter357 = 0;
                for (ModelFactory f : new ModelFactory[] { this.databaseService.getGroupModelFactory(), this.databaseService.getGroupMemberModelFactory(), this.databaseService.getGroupMessageModelFactory() }) {
                    ListenerUtil.loopListener.listen("_loopCounter357", ++_loopCounter357);
                    if (!ListenerUtil.mutListener.listen(36500)) {
                        {
                            long _loopCounter356 = 0;
                            for (String s : f.getStatements()) {
                                ListenerUtil.loopListener.listen("_loopCounter356", ++_loopCounter356);
                                if (!ListenerUtil.mutListener.listen(36499)) {
                                    this.sqLiteDatabase.execSQL(s);
                                }
                            }
                        }
                    }
                }
            }
        }
        ;
        return true;
    }

    @Override
    public String getText() {
        return "version 8";
    }
}
