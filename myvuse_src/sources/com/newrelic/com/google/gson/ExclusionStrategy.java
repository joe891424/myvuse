package com.newrelic.com.google.gson;

/* JADX INFO: loaded from: classes6.dex */
public interface ExclusionStrategy {
    boolean shouldSkipClass(Class<?> cls);

    boolean shouldSkipField(FieldAttributes fieldAttributes);
}
