package com.newrelic.agent.android.payload;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface PayloadStore<T> {
    void clear();

    int count();

    void delete(T t);

    List<T> fetchAll();

    boolean store(T t);
}
