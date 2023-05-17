/* Copyright (C) 2019  olie.xdev <olie.xdev@googlemail.com>
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.health.openscale.gui.slides;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.health.openscale.R;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class OpenSourceIntroSlide extends Fragment {

    private static final String ARG_LAYOUT_RES_ID = "layoutResId";

    private int layoutResId;

    private TextView slideMainText;

    public static OpenSourceIntroSlide newInstance(int layoutResId) {
        OpenSourceIntroSlide sampleSlide = new OpenSourceIntroSlide();
        Bundle args = new Bundle();
        if (!ListenerUtil.mutListener.listen(8835)) {
            args.putInt(ARG_LAYOUT_RES_ID, layoutResId);
        }
        if (!ListenerUtil.mutListener.listen(8836)) {
            sampleSlide.setArguments(args);
        }
        return sampleSlide;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (!ListenerUtil.mutListener.listen(8837)) {
            super.onCreate(savedInstanceState);
        }
        if (!ListenerUtil.mutListener.listen(8840)) {
            if ((ListenerUtil.mutListener.listen(8838) ? (getArguments() != null || getArguments().containsKey(ARG_LAYOUT_RES_ID)) : (getArguments() != null && getArguments().containsKey(ARG_LAYOUT_RES_ID)))) {
                if (!ListenerUtil.mutListener.listen(8839)) {
                    layoutResId = getArguments().getInt(ARG_LAYOUT_RES_ID);
                }
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layoutResId, container, false);
        if (!ListenerUtil.mutListener.listen(8841)) {
            slideMainText = view.findViewById(R.id.slideMainText);
        }
        if (!ListenerUtil.mutListener.listen(8842)) {
            slideMainText.setLinksClickable(true);
        }
        if (!ListenerUtil.mutListener.listen(8843)) {
            slideMainText.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return view;
    }
}
