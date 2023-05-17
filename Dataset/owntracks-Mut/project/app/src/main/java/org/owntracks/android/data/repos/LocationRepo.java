package org.owntracks.android.data.repos;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.greenrobot.eventbus.EventBus;
import javax.inject.Singleton;
import javax.inject.Inject;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

@Singleton
public class LocationRepo {

    private final EventBus eventBus;

    private Location currentLocation;

    @Inject
    public LocationRepo(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Nullable
    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    public boolean hasLocation() {
        return this.currentLocation != null;
    }

    public long getCurrentLocationTime() {
        return hasLocation() ? this.currentLocation.getTime() : 0;
    }

    public void setCurrentLocation(@NonNull Location l) {
        if (!ListenerUtil.mutListener.listen(0)) {
            this.currentLocation = l;
        }
        if (!ListenerUtil.mutListener.listen(1)) {
            eventBus.postSticky(l);
        }
    }
}
