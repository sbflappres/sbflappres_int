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
package ch.threema.app.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ch.threema.app.R;
import ch.threema.app.services.ContactService;
import ch.threema.app.services.GroupService;
import ch.threema.app.services.UserService;
import ch.threema.app.ui.AvatarView;
import ch.threema.app.utils.AdapterUtil;
import ch.threema.app.utils.NameUtil;
import ch.threema.storage.models.ContactModel;
import ch.threema.storage.models.GroupModel;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class MentionSelectorAdapter extends AbstractRecyclerAdapter<ContactModel, RecyclerView.ViewHolder> {

    private UserService userService;

    private ContactService contactService;

    private GroupService groupService;

    private GroupModel groupModel;

    private OnClickListener onClickListener;

    private Context context;

    public static class ItemHolder extends RecyclerView.ViewHolder {

        public final View view;

        public final TextView nameView, idView;

        public final AvatarView avatarView;

        public ItemHolder(View view) {
            super(view);
            this.view = view;
            this.nameView = itemView.findViewById(R.id.group_name);
            this.avatarView = itemView.findViewById(R.id.avatar_view);
            this.idView = itemView.findViewById(R.id.threemaid);
        }
    }

    public MentionSelectorAdapter(Context context, UserService userService, ContactService contactService, GroupService groupService, GroupModel groupModel) {
        if (!ListenerUtil.mutListener.listen(9240)) {
            this.context = context;
        }
        if (!ListenerUtil.mutListener.listen(9241)) {
            this.userService = userService;
        }
        if (!ListenerUtil.mutListener.listen(9242)) {
            this.contactService = contactService;
        }
        if (!ListenerUtil.mutListener.listen(9243)) {
            this.groupService = groupService;
        }
        if (!ListenerUtil.mutListener.listen(9244)) {
            this.groupModel = groupModel;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_group_detail, parent, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ItemHolder itemHolder = (ItemHolder) holder;
        final ContactModel contactModel = getEntity(position);
        Bitmap avatar;
        final String name = NameUtil.getQuoteName(contactModel, this.userService);
        if (!ListenerUtil.mutListener.listen(9245)) {
            itemHolder.nameView.setText(name);
        }
        if (contactModel.getIdentity().equals(ContactService.ALL_USERS_PLACEHOLDER_ID)) {
            avatar = this.groupService.getAvatar(groupModel, false);
            if (!ListenerUtil.mutListener.listen(9249)) {
                itemHolder.idView.setText("");
            }
            if (!ListenerUtil.mutListener.listen(9252)) {
                if (avatar != null) {
                    if (!ListenerUtil.mutListener.listen(9251)) {
                        itemHolder.avatarView.setImageBitmap(avatar);
                    }
                } else {
                    if (!ListenerUtil.mutListener.listen(9250)) {
                        itemHolder.avatarView.setImageResource(R.drawable.ic_group);
                    }
                }
            }
            if (!ListenerUtil.mutListener.listen(9253)) {
                itemHolder.avatarView.setBadgeVisible(false);
            }
        } else {
            avatar = this.contactService.getAvatar(contactModel, false);
            if (!ListenerUtil.mutListener.listen(9246)) {
                itemHolder.idView.setText(contactModel.getIdentity());
            }
            if (!ListenerUtil.mutListener.listen(9247)) {
                itemHolder.avatarView.setImageBitmap(avatar);
            }
            if (!ListenerUtil.mutListener.listen(9248)) {
                itemHolder.avatarView.setBadgeVisible(contactService.showBadge(contactModel));
            }
        }
        if (!ListenerUtil.mutListener.listen(9254)) {
            AdapterUtil.styleContact(itemHolder.nameView, contactModel);
        }
        if (!ListenerUtil.mutListener.listen(9255)) {
            itemHolder.view.setOnClickListener(v -> onClickListener.onItemClick(v, contactModel));
        }
    }

    public void setOnClickListener(OnClickListener listener) {
        if (!ListenerUtil.mutListener.listen(9256)) {
            onClickListener = listener;
        }
    }

    public interface OnClickListener {

        void onItemClick(View v, ContactModel contactModel);
    }
}
