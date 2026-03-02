package com.newrelic.com.google.gson;

import com.newrelic.com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes6.dex */
public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}
