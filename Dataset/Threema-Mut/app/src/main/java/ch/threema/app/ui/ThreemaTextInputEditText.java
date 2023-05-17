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
package ch.threema.app.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.AttributeSet;
import com.google.android.material.textfield.TextInputEditText;
import androidx.preference.PreferenceManager;
import ch.threema.app.R;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class ThreemaTextInputEditText extends TextInputEditText {

    public ThreemaTextInputEditText(Context context) {
        super(context);
        if (!ListenerUtil.mutListener.listen(47503)) {
            init(context);
        }
    }

    public ThreemaTextInputEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!ListenerUtil.mutListener.listen(47504)) {
            init(context);
        }
    }

    public ThreemaTextInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!ListenerUtil.mutListener.listen(47505)) {
            init(context);
        }
    }

    private void init(Context context) {
        // PreferenceService may not yet be available at this time
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (!ListenerUtil.mutListener.listen(47508)) {
            if ((ListenerUtil.mutListener.listen(47506) ? (sharedPreferences != null || sharedPreferences.getBoolean(getResources().getString(R.string.preferences__incognito_keyboard), false)) : (sharedPreferences != null && sharedPreferences.getBoolean(getResources().getString(R.string.preferences__incognito_keyboard), false)))) {
                if (!ListenerUtil.mutListener.listen(47507)) {
                    setImeOptions(getImeOptions() | 0x1000000);
                }
            }
        }
    }

    @Override
    @TargetApi(Build.VERSION_CODES.O)
    public int getAutofillType() {
        // disable Autofill in EditText due to privacy and TransactionTooLargeException as well as bug https://issuetracker.google.com/issues/67675432
        return AUTOFILL_TYPE_NONE;
    }

    /**
     *  Get a password or passphrase from the EditText without using a String, as Strings are immutable
     *  See https://docs.oracle.com/javase/1.5.0/docs/guide/security/jce/JCERefGuide.html#PBEEx
     *  @return passphrase as char array
     */
    public char[] getPassphrase() {
        int length = length();
        char[] passphrase = new char[length];
        if (!ListenerUtil.mutListener.listen(47516)) {
            if ((ListenerUtil.mutListener.listen(47514) ? ((ListenerUtil.mutListener.listen(47513) ? (length >= 0) : (ListenerUtil.mutListener.listen(47512) ? (length <= 0) : (ListenerUtil.mutListener.listen(47511) ? (length < 0) : (ListenerUtil.mutListener.listen(47510) ? (length != 0) : (ListenerUtil.mutListener.listen(47509) ? (length == 0) : (length > 0)))))) || getText() != null) : ((ListenerUtil.mutListener.listen(47513) ? (length >= 0) : (ListenerUtil.mutListener.listen(47512) ? (length <= 0) : (ListenerUtil.mutListener.listen(47511) ? (length < 0) : (ListenerUtil.mutListener.listen(47510) ? (length != 0) : (ListenerUtil.mutListener.listen(47509) ? (length == 0) : (length > 0)))))) && getText() != null))) {
                if (!ListenerUtil.mutListener.listen(47515)) {
                    getText().getChars(0, length, passphrase, 0);
                }
            }
        }
        return passphrase;
    }
}
