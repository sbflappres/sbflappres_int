package com.github.pockethub.android.ui.item.issue;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.github.pockethub.android.R;
import com.github.pockethub.android.core.issue.IssueUtils;
import com.github.pockethub.android.util.AvatarLoader;
import com.meisolsson.githubsdk.model.Issue;
import com.meisolsson.githubsdk.model.IssueState;
import com.xwray.groupie.kotlinandroidextensions.Item;
import com.xwray.groupie.kotlinandroidextensions.ViewHolder;
import kotlinx.android.synthetic.main.issue_details.*;
import kotlinx.android.synthetic.main.issue_number.*;
import kotlinx.android.synthetic.main.repo_issue_item.*;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/github/pockethub/android/ui/item/issue/IssueItem;", "Lcom/xwray/groupie/kotlinandroidextensions/Item;", "avatarLoader", "Lcom/github/pockethub/android/util/AvatarLoader;", "issue", "Lcom/meisolsson/githubsdk/model/Issue;", "showLabels", "", "(Lcom/github/pockethub/android/util/AvatarLoader;Lcom/meisolsson/githubsdk/model/Issue;Z)V", "getIssue", "()Lcom/meisolsson/githubsdk/model/Issue;", "bind", "", "holder", "Lcom/xwray/groupie/kotlinandroidextensions/ViewHolder;", "position", "", "getLayout", "app_debug"})
public class IssueItem extends com.xwray.groupie.kotlinandroidextensions.Item {
    private final com.github.pockethub.android.util.AvatarLoader avatarLoader = null;
    @org.jetbrains.annotations.NotNull()
    private final com.meisolsson.githubsdk.model.Issue issue = null;
    private final boolean showLabels = false;
    
    @java.lang.Override()
    public int getLayout() {
        return 0;
    }
    
    @java.lang.Override()
    public void bind(@org.jetbrains.annotations.NotNull()
    com.xwray.groupie.kotlinandroidextensions.ViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.meisolsson.githubsdk.model.Issue getIssue() {
        return null;
    }
    
    public IssueItem(@org.jetbrains.annotations.NotNull()
    com.github.pockethub.android.util.AvatarLoader avatarLoader, @org.jetbrains.annotations.NotNull()
    com.meisolsson.githubsdk.model.Issue issue, boolean showLabels) {
        super();
    }
    
    public IssueItem(@org.jetbrains.annotations.NotNull()
    com.github.pockethub.android.util.AvatarLoader avatarLoader, @org.jetbrains.annotations.NotNull()
    com.meisolsson.githubsdk.model.Issue issue) {
        super();
    }
}