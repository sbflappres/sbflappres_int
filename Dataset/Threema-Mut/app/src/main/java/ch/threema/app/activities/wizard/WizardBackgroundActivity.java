/*  _____ _
 * |_   _| |_  _ _ ___ ___ _ __  __ _
 *   | | | ' \| '_/ -_) -_) '  \/ _` |_
 *   |_| |_||_|_| \___\___|_|_|_\__,_(_)
 *
 * Threema for Android
 * Copyright (c) 2015-2021 Threema GmbH
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
package ch.threema.app.activities.wizard;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.threema.app.R;
import ch.threema.app.ThreemaApplication;
import ch.threema.app.activities.ThreemaAppCompatActivity;
import ch.threema.app.managers.ServiceManager;
import ch.threema.app.services.FileService;
import ch.threema.app.services.PreferenceService;
import ch.threema.app.services.UserService;
import ch.threema.app.utils.LogUtil;
import ch.threema.app.utils.TestUtil;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public abstract class WizardBackgroundActivity extends ThreemaAppCompatActivity {

    private static final Logger logger = LoggerFactory.getLogger(WizardBackgroundActivity.class);

    protected ServiceManager serviceManager;

    protected PreferenceService preferenceService;

    protected UserService userService;

    protected FileService fileService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (!ListenerUtil.mutListener.listen(684)) {
            if (!requiredInstances()) {
                if (!ListenerUtil.mutListener.listen(683)) {
                    finish();
                }
            }
        }
        if (!ListenerUtil.mutListener.listen(685)) {
            super.onCreate(savedInstanceState);
        }
    }

    @Override
    protected void onStart() {
        if (!ListenerUtil.mutListener.listen(686)) {
            super.onStart();
        }
        HorizontalScrollView hsv = findViewById(R.id.background_image);
        if (!ListenerUtil.mutListener.listen(688)) {
            // disable scrolling
            if (hsv != null) {
                if (!ListenerUtil.mutListener.listen(687)) {
                    hsv.setOnTouchListener(new View.OnTouchListener() {

                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            return true;
                        }
                    });
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
    }

    private boolean requiredInstances() {
        if (!ListenerUtil.mutListener.listen(690)) {
            if (!this.checkInstances()) {
                if (!ListenerUtil.mutListener.listen(689)) {
                    this.instantiate();
                }
            }
        }
        return this.checkInstances();
    }

    private boolean checkInstances() {
        return TestUtil.required(this.preferenceService, this.userService, this.fileService);
    }

    private void instantiate() {
        if (!ListenerUtil.mutListener.listen(691)) {
            serviceManager = ThreemaApplication.getServiceManager();
        }
        if (!ListenerUtil.mutListener.listen(696)) {
            if (serviceManager != null) {
                if (!ListenerUtil.mutListener.listen(692)) {
                    this.preferenceService = serviceManager.getPreferenceService();
                }
                try {
                    if (!ListenerUtil.mutListener.listen(694)) {
                        this.userService = serviceManager.getUserService();
                    }
                    if (!ListenerUtil.mutListener.listen(695)) {
                        this.fileService = serviceManager.getFileService();
                    }
                } catch (Exception e) {
                    if (!ListenerUtil.mutListener.listen(693)) {
                        logger.error("Exception", e);
                    }
                }
            }
        }
    }
}
