/*
 *  Copyright (c) 2020 David Allison <davidallisongithub@gmail.com>
 *
 *  This program is free software; you can redistribute it and/or modify it under
 *  the terms of the GNU General Public License as published by the Free Software
 *  Foundation; either version 3 of the License, or (at your option) any later
 *  version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY
 *  WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 *  PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with
 *  this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ichi2.anki.dialogs;

import android.content.res.Resources;
import com.ichi2.anki.R;
import com.ichi2.libanki.Card;
import com.ichi2.libanki.sched.SchedV2;
import com.ichi2.utils.FunctionalInterfaces.Consumer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.CheckResult;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class RescheduleDialog extends IntegerDialog {

    private RescheduleDialog() {
        super();
    }

    @NonNull
    @CheckResult
    public static RescheduleDialog rescheduleSingleCard(Resources resources, Card currentCard, Consumer<Integer> consumer) {
        RescheduleDialog rescheduleDialog = new RescheduleDialog();
        String content = getContentString(resources, currentCard);
        if (!ListenerUtil.mutListener.listen(966)) {
            rescheduleDialog.setArgs(resources.getQuantityString(R.plurals.reschedule_cards_dialog_title, 1), resources.getString(R.string.reschedule_card_dialog_message), 4, content);
        }
        if (!ListenerUtil.mutListener.listen(968)) {
            if (consumer != null) {
                if (!ListenerUtil.mutListener.listen(967)) {
                    rescheduleDialog.setCallbackRunnable(consumer);
                }
            }
        }
        return rescheduleDialog;
    }

    @NonNull
    @CheckResult
    public static RescheduleDialog rescheduleMultipleCards(Resources resources, Consumer<Integer> consumer, int cardCount) {
        RescheduleDialog rescheduleDialog = new RescheduleDialog();
        if (!ListenerUtil.mutListener.listen(969)) {
            rescheduleDialog.setArgs(resources.getQuantityString(R.plurals.reschedule_cards_dialog_title, cardCount), resources.getString(R.string.reschedule_card_dialog_message), 4);
        }
        if (!ListenerUtil.mutListener.listen(971)) {
            if (consumer != null) {
                if (!ListenerUtil.mutListener.listen(970)) {
                    rescheduleDialog.setCallbackRunnable(consumer);
                }
            }
        }
        return rescheduleDialog;
    }

    @Nullable
    private static String getContentString(Resources resources, Card currentCard) {
        if (!ListenerUtil.mutListener.listen(972)) {
            if (currentCard.isNew()) {
                return resources.getString(R.string.reschedule_card_dialog_new_card_warning);
            }
        }
        if (!ListenerUtil.mutListener.listen(973)) {
            // DEFECT: We should be able to calculate this for all card types - not yet performed for non-review or dynamic cards
            if (!currentCard.isReview()) {
                return null;
            }
        }
        String message = resources.getString(R.string.reschedule_card_dialog_warning_ease_reset, (ListenerUtil.mutListener.listen(977) ? (SchedV2.RESCHEDULE_FACTOR % 10) : (ListenerUtil.mutListener.listen(976) ? (SchedV2.RESCHEDULE_FACTOR * 10) : (ListenerUtil.mutListener.listen(975) ? (SchedV2.RESCHEDULE_FACTOR - 10) : (ListenerUtil.mutListener.listen(974) ? (SchedV2.RESCHEDULE_FACTOR + 10) : (SchedV2.RESCHEDULE_FACTOR / 10))))));
        if (!ListenerUtil.mutListener.listen(978)) {
            if (currentCard.isInDynamicDeck()) {
                return message;
            }
        }
        return message + "\n\n" + resources.getQuantityString(R.plurals.reschedule_card_dialog_interval, currentCard.getIvl(), currentCard.getIvl());
    }
}
