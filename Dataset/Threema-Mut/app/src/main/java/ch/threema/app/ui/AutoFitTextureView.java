/*  _____ _
 * |_   _| |_  _ _ ___ ___ _ __  __ _
 *   | | | ' \| '_/ -_) -_) '  \/ _` |_
 *   |_| |_||_|_| \___\___|_|_|_\__,_(_)
 *
 * Threema for Android
 * Copyright (c) 2019-2021 Threema GmbH
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

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

/**
 * A {@link TextureView} that can be adjusted to a specified aspect ratio.
 */
public class AutoFitTextureView extends TextureView {

    private int mRatioWidth = 0;

    private int mRatioHeight = 0;

    public AutoFitTextureView(Context context) {
        this(context, null);
    }

    public AutoFitTextureView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoFitTextureView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     *  Sets the aspect ratio for this view. The size of the view will be measured based on the ratio
     *  calculated from the parameters. Note that the actual sizes of parameters don't matter, that
     *  is, calling setAspectRatio(2, 3) and setAspectRatio(4, 6) make the same result.
     *
     *  @param width  Relative horizontal size
     *  @param height Relative vertical size
     */
    public void setAspectRatio(int width, int height) {
        if (!ListenerUtil.mutListener.listen(44377)) {
            if ((ListenerUtil.mutListener.listen(44376) ? ((ListenerUtil.mutListener.listen(44370) ? (width >= 0) : (ListenerUtil.mutListener.listen(44369) ? (width <= 0) : (ListenerUtil.mutListener.listen(44368) ? (width > 0) : (ListenerUtil.mutListener.listen(44367) ? (width != 0) : (ListenerUtil.mutListener.listen(44366) ? (width == 0) : (width < 0)))))) && (ListenerUtil.mutListener.listen(44375) ? (height >= 0) : (ListenerUtil.mutListener.listen(44374) ? (height <= 0) : (ListenerUtil.mutListener.listen(44373) ? (height > 0) : (ListenerUtil.mutListener.listen(44372) ? (height != 0) : (ListenerUtil.mutListener.listen(44371) ? (height == 0) : (height < 0))))))) : ((ListenerUtil.mutListener.listen(44370) ? (width >= 0) : (ListenerUtil.mutListener.listen(44369) ? (width <= 0) : (ListenerUtil.mutListener.listen(44368) ? (width > 0) : (ListenerUtil.mutListener.listen(44367) ? (width != 0) : (ListenerUtil.mutListener.listen(44366) ? (width == 0) : (width < 0)))))) || (ListenerUtil.mutListener.listen(44375) ? (height >= 0) : (ListenerUtil.mutListener.listen(44374) ? (height <= 0) : (ListenerUtil.mutListener.listen(44373) ? (height > 0) : (ListenerUtil.mutListener.listen(44372) ? (height != 0) : (ListenerUtil.mutListener.listen(44371) ? (height == 0) : (height < 0))))))))) {
                throw new IllegalArgumentException("Size cannot be negative.");
            }
        }
        if (!ListenerUtil.mutListener.listen(44378)) {
            mRatioWidth = width;
        }
        if (!ListenerUtil.mutListener.listen(44379)) {
            mRatioHeight = height;
        }
        if (!ListenerUtil.mutListener.listen(44380)) {
            requestLayout();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!ListenerUtil.mutListener.listen(44381)) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (!ListenerUtil.mutListener.listen(44426)) {
            if ((ListenerUtil.mutListener.listen(44392) ? ((ListenerUtil.mutListener.listen(44386) ? (0 >= mRatioWidth) : (ListenerUtil.mutListener.listen(44385) ? (0 <= mRatioWidth) : (ListenerUtil.mutListener.listen(44384) ? (0 > mRatioWidth) : (ListenerUtil.mutListener.listen(44383) ? (0 < mRatioWidth) : (ListenerUtil.mutListener.listen(44382) ? (0 != mRatioWidth) : (0 == mRatioWidth)))))) && (ListenerUtil.mutListener.listen(44391) ? (0 >= mRatioHeight) : (ListenerUtil.mutListener.listen(44390) ? (0 <= mRatioHeight) : (ListenerUtil.mutListener.listen(44389) ? (0 > mRatioHeight) : (ListenerUtil.mutListener.listen(44388) ? (0 < mRatioHeight) : (ListenerUtil.mutListener.listen(44387) ? (0 != mRatioHeight) : (0 == mRatioHeight))))))) : ((ListenerUtil.mutListener.listen(44386) ? (0 >= mRatioWidth) : (ListenerUtil.mutListener.listen(44385) ? (0 <= mRatioWidth) : (ListenerUtil.mutListener.listen(44384) ? (0 > mRatioWidth) : (ListenerUtil.mutListener.listen(44383) ? (0 < mRatioWidth) : (ListenerUtil.mutListener.listen(44382) ? (0 != mRatioWidth) : (0 == mRatioWidth)))))) || (ListenerUtil.mutListener.listen(44391) ? (0 >= mRatioHeight) : (ListenerUtil.mutListener.listen(44390) ? (0 <= mRatioHeight) : (ListenerUtil.mutListener.listen(44389) ? (0 > mRatioHeight) : (ListenerUtil.mutListener.listen(44388) ? (0 < mRatioHeight) : (ListenerUtil.mutListener.listen(44387) ? (0 != mRatioHeight) : (0 == mRatioHeight))))))))) {
                if (!ListenerUtil.mutListener.listen(44425)) {
                    setMeasuredDimension(width, height);
                }
            } else {
                if (!ListenerUtil.mutListener.listen(44424)) {
                    if ((ListenerUtil.mutListener.listen(44405) ? (width >= (ListenerUtil.mutListener.listen(44400) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) % mRatioHeight) : (ListenerUtil.mutListener.listen(44399) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) * mRatioHeight) : (ListenerUtil.mutListener.listen(44398) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) - mRatioHeight) : (ListenerUtil.mutListener.listen(44397) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) + mRatioHeight) : ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) / mRatioHeight)))))) : (ListenerUtil.mutListener.listen(44404) ? (width <= (ListenerUtil.mutListener.listen(44400) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) % mRatioHeight) : (ListenerUtil.mutListener.listen(44399) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) * mRatioHeight) : (ListenerUtil.mutListener.listen(44398) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) - mRatioHeight) : (ListenerUtil.mutListener.listen(44397) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) + mRatioHeight) : ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) / mRatioHeight)))))) : (ListenerUtil.mutListener.listen(44403) ? (width > (ListenerUtil.mutListener.listen(44400) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) % mRatioHeight) : (ListenerUtil.mutListener.listen(44399) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) * mRatioHeight) : (ListenerUtil.mutListener.listen(44398) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) - mRatioHeight) : (ListenerUtil.mutListener.listen(44397) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) + mRatioHeight) : ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) / mRatioHeight)))))) : (ListenerUtil.mutListener.listen(44402) ? (width != (ListenerUtil.mutListener.listen(44400) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) % mRatioHeight) : (ListenerUtil.mutListener.listen(44399) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) * mRatioHeight) : (ListenerUtil.mutListener.listen(44398) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) - mRatioHeight) : (ListenerUtil.mutListener.listen(44397) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) + mRatioHeight) : ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) / mRatioHeight)))))) : (ListenerUtil.mutListener.listen(44401) ? (width == (ListenerUtil.mutListener.listen(44400) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) % mRatioHeight) : (ListenerUtil.mutListener.listen(44399) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) * mRatioHeight) : (ListenerUtil.mutListener.listen(44398) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) - mRatioHeight) : (ListenerUtil.mutListener.listen(44397) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) + mRatioHeight) : ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) / mRatioHeight)))))) : (width < (ListenerUtil.mutListener.listen(44400) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) % mRatioHeight) : (ListenerUtil.mutListener.listen(44399) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) * mRatioHeight) : (ListenerUtil.mutListener.listen(44398) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) - mRatioHeight) : (ListenerUtil.mutListener.listen(44397) ? ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) + mRatioHeight) : ((ListenerUtil.mutListener.listen(44396) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44395) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44394) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44393) ? (height + mRatioWidth) : (height * mRatioWidth))))) / mRatioHeight)))))))))))) {
                        if (!ListenerUtil.mutListener.listen(44423)) {
                            setMeasuredDimension(width, (ListenerUtil.mutListener.listen(44422) ? ((ListenerUtil.mutListener.listen(44418) ? (width % mRatioHeight) : (ListenerUtil.mutListener.listen(44417) ? (width / mRatioHeight) : (ListenerUtil.mutListener.listen(44416) ? (width - mRatioHeight) : (ListenerUtil.mutListener.listen(44415) ? (width + mRatioHeight) : (width * mRatioHeight))))) % mRatioWidth) : (ListenerUtil.mutListener.listen(44421) ? ((ListenerUtil.mutListener.listen(44418) ? (width % mRatioHeight) : (ListenerUtil.mutListener.listen(44417) ? (width / mRatioHeight) : (ListenerUtil.mutListener.listen(44416) ? (width - mRatioHeight) : (ListenerUtil.mutListener.listen(44415) ? (width + mRatioHeight) : (width * mRatioHeight))))) * mRatioWidth) : (ListenerUtil.mutListener.listen(44420) ? ((ListenerUtil.mutListener.listen(44418) ? (width % mRatioHeight) : (ListenerUtil.mutListener.listen(44417) ? (width / mRatioHeight) : (ListenerUtil.mutListener.listen(44416) ? (width - mRatioHeight) : (ListenerUtil.mutListener.listen(44415) ? (width + mRatioHeight) : (width * mRatioHeight))))) - mRatioWidth) : (ListenerUtil.mutListener.listen(44419) ? ((ListenerUtil.mutListener.listen(44418) ? (width % mRatioHeight) : (ListenerUtil.mutListener.listen(44417) ? (width / mRatioHeight) : (ListenerUtil.mutListener.listen(44416) ? (width - mRatioHeight) : (ListenerUtil.mutListener.listen(44415) ? (width + mRatioHeight) : (width * mRatioHeight))))) + mRatioWidth) : ((ListenerUtil.mutListener.listen(44418) ? (width % mRatioHeight) : (ListenerUtil.mutListener.listen(44417) ? (width / mRatioHeight) : (ListenerUtil.mutListener.listen(44416) ? (width - mRatioHeight) : (ListenerUtil.mutListener.listen(44415) ? (width + mRatioHeight) : (width * mRatioHeight))))) / mRatioWidth))))));
                        }
                    } else {
                        if (!ListenerUtil.mutListener.listen(44414)) {
                            setMeasuredDimension((ListenerUtil.mutListener.listen(44413) ? ((ListenerUtil.mutListener.listen(44409) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44408) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44407) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44406) ? (height + mRatioWidth) : (height * mRatioWidth))))) % mRatioHeight) : (ListenerUtil.mutListener.listen(44412) ? ((ListenerUtil.mutListener.listen(44409) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44408) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44407) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44406) ? (height + mRatioWidth) : (height * mRatioWidth))))) * mRatioHeight) : (ListenerUtil.mutListener.listen(44411) ? ((ListenerUtil.mutListener.listen(44409) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44408) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44407) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44406) ? (height + mRatioWidth) : (height * mRatioWidth))))) - mRatioHeight) : (ListenerUtil.mutListener.listen(44410) ? ((ListenerUtil.mutListener.listen(44409) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44408) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44407) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44406) ? (height + mRatioWidth) : (height * mRatioWidth))))) + mRatioHeight) : ((ListenerUtil.mutListener.listen(44409) ? (height % mRatioWidth) : (ListenerUtil.mutListener.listen(44408) ? (height / mRatioWidth) : (ListenerUtil.mutListener.listen(44407) ? (height - mRatioWidth) : (ListenerUtil.mutListener.listen(44406) ? (height + mRatioWidth) : (height * mRatioWidth))))) / mRatioHeight))))), height);
                        }
                    }
                }
            }
        }
    }
}
