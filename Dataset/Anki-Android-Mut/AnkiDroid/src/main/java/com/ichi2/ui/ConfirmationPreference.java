/**
 * *************************************************************************************
 *  Copyright (c) 2018 Mike Hardy <mike@mikehardy.net>                                   *
 *                                                                                       *
 *  This program is free software; you can redistribute it and/or modify it under        *
 *  the terms of the GNU General Public License as published by the Free Software        *
 *  Foundation; either version 3 of the License, or (at your option) any later           *
 *  version.                                                                             *
 *                                                                                       *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY      *
 *  WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A      *
 *  PARTICULAR PURPOSE. See the GNU General Public License for more details.             *
 *                                                                                       *
 *  You should have received a copy of the GNU General Public License along with         *
 *  this program.  If not, see <http://www.gnu.org/licenses/>.                           *
 * **************************************************************************************
 */
package com.ichi2.ui;

import android.content.Context;
import android.util.AttributeSet;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

// TODO Tracked in https://github.com/ankidroid/Anki-Android/issues/5019
@SuppressWarnings("deprecation")
public class ConfirmationPreference extends android.preference.DialogPreference {

    private Runnable cancelHandler = () -> {
    };

    private Runnable okHandler = () -> {
    };

    public ConfirmationPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCancelHandler(Runnable cancelHandler) {
        if (!ListenerUtil.mutListener.listen(25096)) {
            this.cancelHandler = cancelHandler;
        }
    }

    public void setOkHandler(Runnable okHandler) {
        if (!ListenerUtil.mutListener.listen(25097)) {
            this.okHandler = okHandler;
        }
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        if (!ListenerUtil.mutListener.listen(25100)) {
            if (positiveResult) {
                if (!ListenerUtil.mutListener.listen(25099)) {
                    okHandler.run();
                }
            } else {
                if (!ListenerUtil.mutListener.listen(25098)) {
                    cancelHandler.run();
                }
            }
        }
    }
}
