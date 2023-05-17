package com.github.pockethub.android;

import android.content.Context;
import com.meisolsson.githubsdk.service.issues.IssueService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GitHubModule_ProvidesIssueServiceFactory implements Factory<IssueService> {
  private final GitHubModule module;

  private final Provider<Context> contextProvider;

  public GitHubModule_ProvidesIssueServiceFactory(GitHubModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public IssueService get() {
    return providesIssueService(module, contextProvider.get());
  }

  public static GitHubModule_ProvidesIssueServiceFactory create(GitHubModule module,
      Provider<Context> contextProvider) {
    return new GitHubModule_ProvidesIssueServiceFactory(module, contextProvider);
  }

  public static IssueService providesIssueService(GitHubModule instance, Context context) {
    return Preconditions.checkNotNull(instance.providesIssueService(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
