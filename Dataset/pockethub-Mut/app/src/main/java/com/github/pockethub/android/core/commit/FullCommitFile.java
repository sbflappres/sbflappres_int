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
package com.github.pockethub.android.core.commit;

import android.util.SparseArray;
import com.meisolsson.githubsdk.model.GitHubFile;
import com.meisolsson.githubsdk.model.git.GitComment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

/**
 * Commit file with comments
 */
public class FullCommitFile {

    private final SparseArray<List<GitComment>> comments = new SparseArray<>(4);

    private final GitHubFile file;

    /**
     * Create file
     *
     * @param file
     */
    public FullCommitFile(final GitHubFile file) {
        this.file = file;
    }

    /**
     * Get comments for line
     *
     * @param line
     * @return comments
     */
    public List<GitComment> get(final int line) {
        List<GitComment> lineComments = comments.get(line);
        return lineComments != null ? lineComments : Collections.emptyList();
    }

    /**
     * Add comment to file
     *
     * @param comment
     * @return this file
     */
    public FullCommitFile add(final GitComment comment) {
        int line = (int) comment.position();
        if (!ListenerUtil.mutListener.listen(322)) {
            if ((ListenerUtil.mutListener.listen(317) ? (line <= 0) : (ListenerUtil.mutListener.listen(316) ? (line > 0) : (ListenerUtil.mutListener.listen(315) ? (line < 0) : (ListenerUtil.mutListener.listen(314) ? (line != 0) : (ListenerUtil.mutListener.listen(313) ? (line == 0) : (line >= 0))))))) {
                List<GitComment> lineComments = comments.get(line);
                if (!ListenerUtil.mutListener.listen(320)) {
                    if (lineComments == null) {
                        if (!ListenerUtil.mutListener.listen(318)) {
                            lineComments = new ArrayList<>(4);
                        }
                        if (!ListenerUtil.mutListener.listen(319)) {
                            comments.put(line, lineComments);
                        }
                    }
                }
                if (!ListenerUtil.mutListener.listen(321)) {
                    lineComments.add(comment);
                }
            }
        }
        return this;
    }

    /**
     * @return file
     */
    public GitHubFile getFile() {
        return file;
    }
}
