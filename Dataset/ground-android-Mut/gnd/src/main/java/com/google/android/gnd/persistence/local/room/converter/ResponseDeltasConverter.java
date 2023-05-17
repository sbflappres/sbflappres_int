/*
 * Copyright 2019 Google LLC
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
package com.google.android.gnd.persistence.local.room.converter;

import static com.google.android.gnd.util.Enums.toEnum;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gnd.model.submission.ResponseDelta;
import com.google.android.gnd.model.task.Field;
import com.google.android.gnd.model.task.Task;
import com.google.android.gnd.persistence.local.LocalDataConsistencyException;
import com.google.android.gnd.persistence.remote.DataStoreException;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

/**
 * Converts between {@link ResponseDelta}s and JSON strings used to represent them in the local db.
 */
public class ResponseDeltasConverter {

    private static final String KEY_FIELD_TYPE = "fieldType";

    private static final String KEY_NEW_RESPONSE = "newResponse";

    @NonNull
    public static String toString(@NonNull ImmutableList<ResponseDelta> responseDeltas) {
        JSONObject json = new JSONObject();
        if (!ListenerUtil.mutListener.listen(1322)) {
            {
                long _loopCounter39 = 0;
                for (ResponseDelta delta : responseDeltas) {
                    ListenerUtil.loopListener.listen("_loopCounter39", ++_loopCounter39);
                    try {
                        JSONObject newJson = new JSONObject();
                        if (!ListenerUtil.mutListener.listen(1320)) {
                            newJson.put(KEY_FIELD_TYPE, delta.getFieldType().name()).put(KEY_NEW_RESPONSE, delta.getNewResponse().map(ResponseJsonConverter::toJsonObject).orElse(JSONObject.NULL));
                        }
                        if (!ListenerUtil.mutListener.listen(1321)) {
                            json.put(delta.getFieldId(), newJson);
                        }
                    } catch (JSONException e) {
                        if (!ListenerUtil.mutListener.listen(1319)) {
                            Timber.e(e, "Error building JSON");
                        }
                    }
                }
            }
        }
        return json.toString();
    }

    @NonNull
    public static ImmutableList<ResponseDelta> fromString(Task task, @Nullable String jsonString) {
        ImmutableList.Builder<ResponseDelta> deltas = ImmutableList.builder();
        if (!ListenerUtil.mutListener.listen(1323)) {
            if (jsonString == null) {
                return deltas.build();
            }
        }
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            Iterator<String> keys = jsonObject.keys();
            if (!ListenerUtil.mutListener.listen(1327)) {
                {
                    long _loopCounter40 = 0;
                    while (keys.hasNext()) {
                        ListenerUtil.loopListener.listen("_loopCounter40", ++_loopCounter40);
                        try {
                            String fieldId = keys.next();
                            Field field = task.getField(fieldId).orElseThrow(() -> new LocalDataConsistencyException("Unknown field id " + fieldId));
                            JSONObject jsonDelta = jsonObject.getJSONObject(fieldId);
                            if (!ListenerUtil.mutListener.listen(1326)) {
                                deltas.add(ResponseDelta.builder().setFieldId(fieldId).setFieldType(toEnum(Field.Type.class, jsonDelta.getString(KEY_FIELD_TYPE))).setNewResponse(ResponseJsonConverter.toResponse(field, jsonDelta.get(KEY_NEW_RESPONSE))).build());
                            }
                        } catch (LocalDataConsistencyException | DataStoreException e) {
                            if (!ListenerUtil.mutListener.listen(1325)) {
                                Timber.d("Bad response in local db: " + e.getMessage());
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            if (!ListenerUtil.mutListener.listen(1324)) {
                Timber.e(e, "Error parsing JSON string");
            }
        }
        return deltas.build();
    }
}
