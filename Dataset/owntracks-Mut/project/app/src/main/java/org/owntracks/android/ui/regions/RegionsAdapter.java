package org.owntracks.android.ui.regions;

import androidx.annotation.NonNull;
import android.view.View;
import org.owntracks.android.BR;
import org.owntracks.android.R;
import org.owntracks.android.data.WaypointModel;
import org.owntracks.android.ui.base.BaseAdapter;
import org.owntracks.android.ui.base.BaseAdapterItemView;
import java.util.List;
import io.objectbox.reactive.DataObserver;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

class RegionsAdapter extends BaseAdapter<WaypointModel> implements DataObserver<List<WaypointModel>> {

    RegionsAdapter(ClickListener clickListener) {
        super(BaseAdapterItemView.of(BR.waypoint, R.layout.ui_row_region));
        if (!ListenerUtil.mutListener.listen(2267)) {
            setClickListener(clickListener);
        }
    }

    @Override
    public void onData(@NonNull List<WaypointModel> data) {
        if (!ListenerUtil.mutListener.listen(2268)) {
            setItems(data);
        }
    }

    interface ClickListener extends BaseAdapter.ClickListener<WaypointModel> {

        void onClick(@NonNull WaypointModel object, @NonNull View view, boolean longClick);
    }
}
