/*  _____ _
 * |_   _| |_  _ _ ___ ___ _ __  __ _
 *   | | | ' \| '_/ -_) -_) '  \/ _` |_
 *   |_| |_||_|_| \___\___|_|_|_\__,_(_)
 *
 * Threema for Android
 * Copyright (c) 2018-2021 Threema GmbH
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
package ch.threema.app.asynctasks;

import android.os.AsyncTask;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import ch.threema.app.R;
import ch.threema.app.dialogs.GenericProgressDialog;
import ch.threema.app.listeners.ConversationListener;
import ch.threema.app.managers.ListenerManager;
import ch.threema.app.services.GroupService;
import ch.threema.app.utils.DialogUtil;
import ch.threema.storage.models.GroupModel;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class DeleteMyGroupAsyncTask extends AsyncTask<Void, Void, Void> {

    private static final String DIALOG_TAG = "lg";

    private final GroupModel groupModel;

    private final GroupService groupService;

    private final AppCompatActivity activity;

    private final Fragment fragment;

    private final Runnable runOnCompletion;

    public DeleteMyGroupAsyncTask(GroupModel groupModel, GroupService groupService, AppCompatActivity activity, Fragment fragment, Runnable runOnCompletion) {
        this.groupModel = groupModel;
        this.groupService = groupService;
        this.activity = activity;
        this.fragment = fragment;
        this.runOnCompletion = runOnCompletion;
    }

    @Override
    protected void onPreExecute() {
        if (!ListenerUtil.mutListener.listen(10146)) {
            GenericProgressDialog.newInstance(R.string.action_delete_group, R.string.please_wait).show(activity != null ? activity.getSupportFragmentManager() : fragment.getFragmentManager(), DIALOG_TAG);
        }
    }

    @Override
    protected Void doInBackground(Void... params) {
        if (!ListenerUtil.mutListener.listen(10147)) {
            groupService.removeAllMembersAndLeave(groupModel);
        }
        if (!ListenerUtil.mutListener.listen(10148)) {
            groupService.remove(groupModel);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (!ListenerUtil.mutListener.listen(10149)) {
            DialogUtil.dismissDialog(activity != null ? activity.getSupportFragmentManager() : fragment.getFragmentManager(), DIALOG_TAG, true);
        }
        if (!ListenerUtil.mutListener.listen(10151)) {
            ListenerManager.conversationListeners.handle(new ListenerManager.HandleListener<ConversationListener>() {

                @Override
                public void handle(ConversationListener listener) {
                    if (!ListenerUtil.mutListener.listen(10150)) {
                        listener.onModifiedAll();
                    }
                }
            });
        }
        if (!ListenerUtil.mutListener.listen(10153)) {
            if (runOnCompletion != null) {
                if (!ListenerUtil.mutListener.listen(10152)) {
                    runOnCompletion.run();
                }
            }
        }
    }
}
