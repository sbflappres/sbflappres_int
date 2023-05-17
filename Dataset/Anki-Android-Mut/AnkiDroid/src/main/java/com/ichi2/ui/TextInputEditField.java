/*
 Copyright (c) 2020 David Allison <davidallisongithub@gmail.com>

 This program is free software; you can redistribute it and/or modify it under
 the terms of the GNU General Public License as published by the Free Software
 Foundation; either version 3 of the License, or (at your option) any later
 version.

 This program is distributed in the hope that it will be useful, but WITHOUT ANY
 WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 PARTICULAR PURPOSE. See the GNU General Public License for more details.

 You should have received a copy of the GNU General Public License along with
 this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ichi2.ui;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.autofill.AutofillValue;
import com.google.android.material.textfield.TextInputEditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class TextInputEditField extends TextInputEditText {

    @RequiresApi(Build.VERSION_CODES.O)
    private AutoFillListener mAutoFillListener;

    public TextInputEditField(@NonNull Context context) {
        super(context);
    }

    public TextInputEditField(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TextInputEditField(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void autofill(AutofillValue value) {
        if (!ListenerUtil.mutListener.listen(25497)) {
            super.autofill(value);
        }
        if (!ListenerUtil.mutListener.listen(25505)) {
            if ((ListenerUtil.mutListener.listen(25502) ? (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O) : (ListenerUtil.mutListener.listen(25501) ? (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) : (ListenerUtil.mutListener.listen(25500) ? (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) : (ListenerUtil.mutListener.listen(25499) ? (Build.VERSION.SDK_INT != Build.VERSION_CODES.O) : (ListenerUtil.mutListener.listen(25498) ? (Build.VERSION.SDK_INT == Build.VERSION_CODES.O) : (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O))))))) {
                if (!ListenerUtil.mutListener.listen(25504)) {
                    if (mAutoFillListener != null) {
                        if (!ListenerUtil.mutListener.listen(25503)) {
                            mAutoFillListener.onAutoFill(value);
                        }
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @FunctionalInterface
    public interface AutoFillListener {

        void onAutoFill(@NonNull AutofillValue value);
    }

    @RequiresApi(Build.VERSION_CODES.O)
    public void setAutoFillListener(@NonNull AutoFillListener listener) {
        if (!ListenerUtil.mutListener.listen(25506)) {
            this.mAutoFillListener = listener;
        }
    }
}
