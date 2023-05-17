/*  _____ _
 * |_   _| |_  _ _ ___ ___ _ __  __ _
 *   | | | ' \| '_/ -_) -_) '  \/ _` |_
 *   |_| |_||_|_| \___\___|_|_|_\__,_(_)
 *
 * Threema for Android
 * Copyright (c) 2020-2021 Threema GmbH
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
package ch.threema.app.mediaattacher;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import ch.threema.app.R;
import ch.threema.app.ui.CheckableFrameLayout;
import ch.threema.app.ui.MediaItem;
import ch.threema.app.ui.SquareImageView;
import ch.threema.app.utils.StringConversionUtil;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class MediaAttachAdapter extends RecyclerView.Adapter<MediaAttachAdapter.MediaGalleryHolder> {

    private static final Logger logger = LoggerFactory.getLogger(MediaAttachAdapter.class);

    private final Context context;

    private List<MediaAttachItem> mediaItems;

    private final MediaAttachAdapter.ItemClickListener clickListener;

    private final MediaAttachViewModel mediaAttachViewModel;

    public MediaAttachAdapter(Context context, MediaAttachAdapter.ItemClickListener clickListener) {
        this.context = context;
        if (!ListenerUtil.mutListener.listen(29669)) {
            this.mediaItems = new ArrayList<>();
        }
        this.clickListener = clickListener;
        this.mediaAttachViewModel = new ViewModelProvider((MediaSelectionBaseActivity) context).get(MediaAttachViewModel.class);
    }

    public interface ItemClickListener {

        void onItemLongClick(View view, int position, MediaAttachItem mediaAttachItem);

        void onItemChecked(int count);
    }

    public static class MediaGalleryHolder extends RecyclerView.ViewHolder {

        SquareImageView imageView;

        FrameLayout mediaFrame;

        CheckableFrameLayout contentView;

        LinearLayout gifIndicator;

        LinearLayout videoIndicator;

        ImageView loadErrorIndicator;

        TextView videoDuration;

        int itemId;

        public MediaGalleryHolder(@NonNull View itemView) {
            super(itemView);
            if (!ListenerUtil.mutListener.listen(29670)) {
                contentView = (CheckableFrameLayout) itemView;
            }
            if (!ListenerUtil.mutListener.listen(29671)) {
                mediaFrame = itemView.findViewById(R.id.media_frame);
            }
            if (!ListenerUtil.mutListener.listen(29672)) {
                imageView = itemView.findViewById(R.id.image_view);
            }
            if (!ListenerUtil.mutListener.listen(29673)) {
                gifIndicator = itemView.findViewById(R.id.gif_marker_container);
            }
            if (!ListenerUtil.mutListener.listen(29674)) {
                videoIndicator = itemView.findViewById(R.id.video_marker_container);
            }
            if (!ListenerUtil.mutListener.listen(29675)) {
                loadErrorIndicator = itemView.findViewById(R.id.load_error_indicator);
            }
            if (!ListenerUtil.mutListener.listen(29676)) {
                videoDuration = itemView.findViewById(R.id.video_duration_text);
            }
        }
    }

    @NonNull
    @Override
    public MediaAttachAdapter.MediaGalleryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_media_attach_gallery, parent, false);
        return new MediaAttachAdapter.MediaGalleryHolder(itemView);
    }

    @Override
    public void onViewRecycled(@NonNull MediaGalleryHolder holder) {
        if (!ListenerUtil.mutListener.listen(29677)) {
            super.onViewRecycled(holder);
        }
        if (!ListenerUtil.mutListener.listen(29678)) {
            // cancel pending loads when item is out of view
            Glide.with(context).clear(holder.imageView);
        }
    }

    /**
     *  This method is called for every media attach item that is scrolled into view.
     */
    @Override
    public void onBindViewHolder(@NonNull MediaGalleryHolder holder, int position) {
        if (!ListenerUtil.mutListener.listen(29705)) {
            if ((ListenerUtil.mutListener.listen(29683) ? (mediaItems.size() >= 0) : (ListenerUtil.mutListener.listen(29682) ? (mediaItems.size() <= 0) : (ListenerUtil.mutListener.listen(29681) ? (mediaItems.size() < 0) : (ListenerUtil.mutListener.listen(29680) ? (mediaItems.size() != 0) : (ListenerUtil.mutListener.listen(29679) ? (mediaItems.size() == 0) : (mediaItems.size() > 0))))))) {
                final MediaAttachItem mediaAttachItem = mediaItems.get(position);
                if (!ListenerUtil.mutListener.listen(29684)) {
                    // required item ID to check on recycling
                    holder.itemId = mediaAttachItem.getId();
                }
                CheckableFrameLayout contentView = holder.contentView;
                SquareImageView imageView = holder.imageView;
                LinearLayout gifIndicator = holder.gifIndicator;
                LinearLayout videoIndicator = holder.videoIndicator;
                ImageView loadErrorIndicator = holder.loadErrorIndicator;
                TextView videoDuration = holder.videoDuration;
                try {
                    if (!ListenerUtil.mutListener.listen(29704)) {
                        Glide.with(context).load(mediaAttachItem.getUri()).transition(withCrossFade()).centerInside().addListener(new RequestListener<Drawable>() {

                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                if (!ListenerUtil.mutListener.listen(29686)) {
                                    logger.error("Glide Loading Exception ", e);
                                }
                                if (!ListenerUtil.mutListener.listen(29687)) {
                                    loadErrorIndicator.setVisibility(View.VISIBLE);
                                }
                                if (!ListenerUtil.mutListener.listen(29688)) {
                                    gifIndicator.setVisibility(View.GONE);
                                }
                                if (!ListenerUtil.mutListener.listen(29689)) {
                                    videoIndicator.setVisibility(View.GONE);
                                }
                                if (!ListenerUtil.mutListener.listen(29690)) {
                                    // redraw setChecked state in case holder is being recycled and reset click listeners
                                    contentView.setChecked(mediaAttachViewModel.getSelectedMediaItemsHashMap().containsKey(mediaAttachItem.getId()));
                                }
                                if (!ListenerUtil.mutListener.listen(29691)) {
                                    contentView.setOnClickListener(null);
                                }
                                if (!ListenerUtil.mutListener.listen(29692)) {
                                    contentView.setOnLongClickListener(null);
                                }
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                if (!ListenerUtil.mutListener.listen(29693)) {
                                    loadErrorIndicator.setVisibility(View.GONE);
                                }
                                if (!ListenerUtil.mutListener.listen(29694)) {
                                    contentView.setOnClickListener(view -> {
                                        toggleItemChecked(mediaAttachItem);
                                        contentView.toggle();
                                    });
                                }
                                if (!ListenerUtil.mutListener.listen(29695)) {
                                    contentView.setOnLongClickListener(view -> {
                                        clickListener.onItemLongClick(view, holder.getAdapterPosition(), mediaAttachItem);
                                        return true;
                                    });
                                }
                                if (!ListenerUtil.mutListener.listen(29698)) {
                                    if (mediaAttachItem.getType() == MediaItem.TYPE_GIF) {
                                        if (!ListenerUtil.mutListener.listen(29697)) {
                                            gifIndicator.setVisibility(View.VISIBLE);
                                        }
                                    } else {
                                        if (!ListenerUtil.mutListener.listen(29696)) {
                                            gifIndicator.setVisibility(View.GONE);
                                        }
                                    }
                                }
                                if (!ListenerUtil.mutListener.listen(29702)) {
                                    if (mediaAttachItem.getType() == MediaItem.TYPE_VIDEO) {
                                        if (!ListenerUtil.mutListener.listen(29700)) {
                                            videoDuration.setText(StringConversionUtil.getDurationString(mediaAttachItem.getDuration()));
                                        }
                                        if (!ListenerUtil.mutListener.listen(29701)) {
                                            videoIndicator.setVisibility(View.VISIBLE);
                                        }
                                    } else {
                                        if (!ListenerUtil.mutListener.listen(29699)) {
                                            videoIndicator.setVisibility(View.GONE);
                                        }
                                    }
                                }
                                if (!ListenerUtil.mutListener.listen(29703)) {
                                    contentView.setChecked(mediaAttachViewModel.getSelectedMediaItemsHashMap().containsKey(mediaAttachItem.getId()));
                                }
                                return false;
                            }
                        }).into(imageView);
                    }
                } catch (RejectedExecutionException e) {
                    if (!ListenerUtil.mutListener.listen(29685)) {
                        logger.error("thumbnail task failed " + e);
                    }
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return mediaItems.size();
    }

    public List<MediaAttachItem> getMediaItems() {
        return mediaItems;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void setMediaItems(List<MediaAttachItem> items) {
        if (!ListenerUtil.mutListener.listen(29706)) {
            mediaItems = items;
        }
        if (!ListenerUtil.mutListener.listen(29707)) {
            notifyDataSetChanged();
        }
    }

    private void toggleItemChecked(MediaAttachItem mediaAttachItem) {
        if (!ListenerUtil.mutListener.listen(29710)) {
            if (mediaAttachViewModel.getSelectedMediaItemsHashMap().containsKey(mediaAttachItem.getId())) {
                if (!ListenerUtil.mutListener.listen(29709)) {
                    mediaAttachViewModel.removeSelectedMediaItem(mediaAttachItem.getId());
                }
            } else {
                if (!ListenerUtil.mutListener.listen(29708)) {
                    mediaAttachViewModel.addSelectedMediaItem(mediaAttachItem.getId(), mediaAttachItem);
                }
            }
        }
        if (!ListenerUtil.mutListener.listen(29711)) {
            clickListener.onItemChecked(mediaAttachViewModel.getSelectedMediaItemsHashMap().size());
        }
    }
}
