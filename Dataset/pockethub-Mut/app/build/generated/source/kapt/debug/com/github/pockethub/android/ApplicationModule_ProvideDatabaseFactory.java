package com.github.pockethub.android;

import android.content.Context;
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
public final class ApplicationModule_ProvideDatabaseFactory implements Factory<Database> {
  private final Provider<Context> contextProvider;

  public ApplicationModule_ProvideDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public Database get() {
    return provideDatabase(contextProvider.get());
  }

  public static ApplicationModule_ProvideDatabaseFactory create(Provider<Context> contextProvider) {
    return new ApplicationModule_ProvideDatabaseFactory(contextProvider);
  }

  public static Database provideDatabase(Context context) {
    return Preconditions.checkNotNull(ApplicationModule.provideDatabase(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
