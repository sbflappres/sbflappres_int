/*  _____ _
 * |_   _| |_  _ _ ___ ___ _ __  __ _
 *   | | | ' \| '_/ -_) -_) '  \/ _` |_
 *   |_| |_||_|_| \___\___|_|_|_\__,_(_)
 *
 * Threema for Android
 * Copyright (c) 2019-2021 Threema GmbH
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
package ch.threema.app.archive;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import java.util.List;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ch.threema.app.ThreemaApplication;
import ch.threema.app.managers.ServiceManager;
import ch.threema.app.services.ConversationService;
import ch.threema.app.utils.TestUtil;
import ch.threema.base.ThreemaException;
import ch.threema.storage.models.ConversationModel;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

/**
 * A Repository is a class that abstracts access to multiple data sources.
 *
 * The Repository is not part of the Architecture Components libraries, but is a
 * suggested best practice for code separation and architecture. A Repository class
 * handles data operations. It provides a clean API to the rest of the app for app data.
 */
class ArchiveRepository {

    private MutableLiveData<List<ConversationModel>> conversationModels;

    private ConversationService conversationService;

    private String filter = null;

    ArchiveRepository() {
        ServiceManager serviceManager = ThreemaApplication.getServiceManager();
        if (!ListenerUtil.mutListener.listen(10012)) {
            if (serviceManager != null) {
                if (!ListenerUtil.mutListener.listen(10008)) {
                    conversationService = null;
                }
                try {
                    if (!ListenerUtil.mutListener.listen(10009)) {
                        conversationService = serviceManager.getConversationService();
                    }
                } catch (ThreemaException e) {
                    return;
                }
                if (!ListenerUtil.mutListener.listen(10011)) {
                    if (conversationService != null) {
                        if (!ListenerUtil.mutListener.listen(10010)) {
                            conversationModels = new MutableLiveData<List<ConversationModel>>() {

                                @Nullable
                                @Override
                                public List<ConversationModel> getValue() {
                                    return conversationService.getArchived(null);
                                }
                            };
                        }
                    }
                }
            }
        }
    }

    LiveData<List<ConversationModel>> getConversationModels() {
        return conversationModels;
    }

    @SuppressLint("StaticFieldLeak")
    public void onDataChanged() {
        if (!ListenerUtil.mutListener.listen(10014)) {
            new AsyncTask<String, Void, Void>() {

                @Override
                protected Void doInBackground(String... strings) {
                    if (!ListenerUtil.mutListener.listen(10013)) {
                        conversationModels.postValue(conversationService.getArchived(filter));
                    }
                    return null;
                }
            }.execute();
        }
    }

    public void setFilter(String constraint) {
        if (!ListenerUtil.mutListener.listen(10017)) {
            if (!TestUtil.empty(constraint)) {
                if (!ListenerUtil.mutListener.listen(10016)) {
                    this.filter = constraint.trim();
                }
            } else {
                if (!ListenerUtil.mutListener.listen(10015)) {
                    this.filter = null;
                }
            }
        }
    }
}
