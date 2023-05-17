/* Copyright (C) 2014  olie.xdev <olie.xdev@googlemail.com>
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
package com.health.openscale.gui.measurement;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import com.health.openscale.R;
import com.health.openscale.core.datatypes.ScaleMeasurement;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class CommentMeasurementView extends MeasurementView {

    // Don't change key value, it may be stored persistent in preferences
    public static final String KEY = "comment";

    private String comment;

    public CommentMeasurementView(Context context) {
        super(context, R.string.label_comment, R.drawable.ic_comment);
    }

    @Override
    public String getKey() {
        return KEY;
    }

    private void setValue(String newComment, boolean callListener) {
        if (!ListenerUtil.mutListener.listen(6823)) {
            if (!newComment.equals(comment)) {
                if (!ListenerUtil.mutListener.listen(6821)) {
                    comment = newComment;
                }
                if (!ListenerUtil.mutListener.listen(6822)) {
                    setValueView(comment, callListener);
                }
            }
        }
    }

    @Override
    public void loadFrom(ScaleMeasurement measurement, ScaleMeasurement previousMeasurement) {
        if (!ListenerUtil.mutListener.listen(6824)) {
            setValue(measurement.getComment(), false);
        }
    }

    @Override
    public void saveTo(ScaleMeasurement measurement) {
        if (!ListenerUtil.mutListener.listen(6825)) {
            measurement.setComment(comment);
        }
    }

    @Override
    public void clearIn(ScaleMeasurement measurement) {
        if (!ListenerUtil.mutListener.listen(6826)) {
            measurement.setComment("");
        }
    }

    @Override
    public void restoreState(Bundle state) {
        if (!ListenerUtil.mutListener.listen(6827)) {
            setValue(state.getString(getKey()), true);
        }
    }

    @Override
    public void saveState(Bundle state) {
        if (!ListenerUtil.mutListener.listen(6828)) {
            state.putString(getKey(), comment);
        }
    }

    @Override
    public String getValueAsString(boolean withUnit) {
        return comment;
    }

    @Override
    protected View getInputView() {
        EditText input = new EditText(getContext());
        if (!ListenerUtil.mutListener.listen(6829)) {
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        }
        if (!ListenerUtil.mutListener.listen(6830)) {
            input.setHint(R.string.info_enter_comment);
        }
        if (!ListenerUtil.mutListener.listen(6831)) {
            input.setText(getValueAsString(false));
        }
        if (!ListenerUtil.mutListener.listen(6832)) {
            input.setSelectAllOnFocus(true);
        }
        return input;
    }

    @Override
    protected boolean validateAndSetInput(View view) {
        EditText editText = (EditText) view;
        if (!ListenerUtil.mutListener.listen(6833)) {
            setValue(editText.getText().toString(), true);
        }
        return true;
    }
}
