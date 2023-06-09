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
package com.github.pockethub.android.tests.ref;

import androidx.test.filters.SmallTest;
import com.github.pockethub.android.core.ref.RefUtils;
import com.github.pockethub.android.tests.MutTest;
import com.meisolsson.githubsdk.model.git.GitReference;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


/**
 * Tests of {@link RefUtils}
 */
@SmallTest
public class RefUtilsTest extends MutTest {

    /**
     * Verify {@link RefUtils#isBranch(GitReference)}
     */
    @Test
    public void testIsBranch() {
        assertFalse(RefUtils.isBranch(null));
        assertFalse(RefUtils.isBranch(GitReference.builder().build()));
        assertFalse(RefUtils.isBranch(createGitReference("")));
        assertFalse(RefUtils.isBranch(createGitReference("navigation_drawer_header_background")));
        assertFalse(RefUtils.isBranch(createGitReference("refs/tags/v1")));
        assertFalse(RefUtils.isBranch(createGitReference("refs/b1")));
        assertTrue(RefUtils.isBranch(createGitReference("refs/heads/b2")));
    }

    /**
     * Verify {@link RefUtils#isTag(GitReference)}
     */
    @Test
    public void testIsTag() {
        assertFalse(RefUtils.isTag((GitReference) null));
        assertFalse(RefUtils.isTag(GitReference.builder().build()));
        assertFalse(RefUtils.isTag(createGitReference("")));
        assertFalse(RefUtils.isTag(createGitReference("navigation_drawer_header_background")));
        assertFalse(RefUtils.isTag(createGitReference("refs/b1")));
        assertFalse(RefUtils.isTag(createGitReference("refs/heads/b2")));
        assertTrue(RefUtils.isTag(createGitReference("refs/tags/v1")));
    }

    /**
     * Verify {@link RefUtils#isValid(GitReference)}
     */
    @Test
    public void testIsValid() {
        assertFalse(RefUtils.isValid(null));
        assertFalse(RefUtils.isValid(GitReference.builder().build()));
        assertFalse(RefUtils.isValid(createGitReference("")));
        assertFalse(RefUtils.isValid(createGitReference("refs/pull/6/merge")));
        assertFalse(RefUtils.isValid(createGitReference("refs/pull/6/head")));
        assertTrue(RefUtils.isValid(createGitReference("refs/pull")));
        assertTrue(RefUtils.isValid(createGitReference("refs/heads/b1")));
        assertTrue(RefUtils.isValid(createGitReference("refs/tags/v1")));
    }

    /**
     * Verify {@link RefUtils#getName(GitReference)}
     */
    @Test
    public void testGetName() {
        assertNull(RefUtils.getName((GitReference) null));
        assertNull(RefUtils.getName(GitReference.builder().build()));
        assertEquals("", RefUtils.getName(createGitReference("")));
        assertEquals("unchanged",
            RefUtils.getName(createGitReference("unchanged")));
        assertEquals("branch",
            RefUtils.getName(createGitReference("refs/heads/branch")));
        assertEquals("tag",
            RefUtils.getName(createGitReference("refs/tags/tag")));
        assertEquals("notes",
            RefUtils.getName(createGitReference("refs/notes")));

    }

    /**
     * Verify {@link RefUtils#getPath(GitReference)}
     */
    @Test
    public void testGetPath() {
        assertNull(RefUtils.getPath(null));
        assertNull(RefUtils.getPath(GitReference.builder().build()));
        assertEquals("", RefUtils.getPath(createGitReference("")));
        assertEquals("unchanged",
            RefUtils.getPath(createGitReference("unchanged")));
        assertEquals("heads/branch",
            RefUtils.getPath(createGitReference("refs/heads/branch")));
        assertEquals("tags/tag",
            RefUtils.getPath(createGitReference("refs/tags/tag")));
        assertEquals("notes",
            RefUtils.getPath(createGitReference("refs/notes")));

    }

    private GitReference createGitReference(String ref){
        return GitReference.builder()
                .ref(ref)
                .build();
    }
}
