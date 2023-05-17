/*
 * Copyright 2020 Google LLC
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

package com.google.android.gnd;

import android.content.Context;
import androidx.room.Room;
import com.google.android.gnd.persistence.local.LocalDatabaseModule;
import com.google.android.gnd.persistence.local.room.LocalDatabase;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.testing.TestInstallIn;
import javax.inject.Singleton;

@Module
@TestInstallIn(components = SingletonComponent.class, replaces = LocalDatabaseModule.class)
abstract class TestLocalDatabaseModule {

  @Provides
  @Singleton
  static LocalDatabase localDatabaseProvider(@ApplicationContext Context context) {
    return Room.inMemoryDatabaseBuilder(context, LocalDatabase.class)
        .allowMainThreadQueries()
        .build();
  }
}
