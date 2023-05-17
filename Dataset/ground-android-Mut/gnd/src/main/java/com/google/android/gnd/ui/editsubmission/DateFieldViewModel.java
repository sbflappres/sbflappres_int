/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.gnd.ui.editsubmission;

import android.content.res.Resources;
import com.google.android.gnd.model.submission.DateResponse;
import com.google.android.gnd.rx.Nil;
import com.google.android.gnd.rx.annotations.Hot;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.Date;
import javax.inject.Inject;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class DateFieldViewModel extends AbstractFieldViewModel {

    @Hot
    private final Subject<Nil> showDialogClicks = PublishSubject.create();

    @Inject
    DateFieldViewModel(Resources resources) {
        super(resources);
    }

    public void updateResponse(Date date) {
        if (!ListenerUtil.mutListener.listen(348)) {
            setResponse(DateResponse.fromDate(date));
        }
    }

    public void onShowDialogClick() {
        if (!ListenerUtil.mutListener.listen(349)) {
            showDialogClicks.onNext(Nil.NIL);
        }
    }

    public Observable<Nil> getShowDialogClicks() {
        return showDialogClicks;
    }
}
