/*
 * Copyright (c) 2015 PocketHub
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pockethub.android.ui.gist;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import com.github.pockethub.android.ui.base.FragmentPagerAdapter;
import com.meisolsson.githubsdk.model.Gist;
import com.meisolsson.githubsdk.model.GistFile;
import java.util.Map;
import static com.github.pockethub.android.Intents.EXTRA_GIST_FILE;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

/**
 * Pager adapter for all the files in a given gist
 */
public class GistFilesPagerAdapter extends FragmentPagerAdapter {

    private final GistFile[] files;

    /**
     * @param activity
     * @param gist
     */
    public GistFilesPagerAdapter(AppCompatActivity activity, Gist gist) {
        super(activity);
        Map<String, GistFile> gistFiles = gist.files();
        if ((ListenerUtil.mutListener.listen(860) ? (gistFiles != null || !gistFiles.isEmpty()) : (gistFiles != null && !gistFiles.isEmpty()))) {
            files = gistFiles.values().toArray(new GistFile[gistFiles.size()]);
        } else {
            files = new GistFile[0];
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return files[position].filename();
    }

    @Override
    public Fragment getItem(final int position) {
        GistFile file = files[position];
        Fragment fragment = new GistFileFragment();
        Bundle args = new Bundle();
        if (!ListenerUtil.mutListener.listen(861)) {
            args.putParcelable(EXTRA_GIST_FILE, file);
        }
        if (!ListenerUtil.mutListener.listen(862)) {
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return files.length;
    }
}
