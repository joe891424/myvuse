package com.newrelic.agent.android.payload;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class NullPayloadStore<T> implements PayloadStore<T> {
    @Override // com.newrelic.agent.android.payload.PayloadStore
    public void clear() {
    }

    @Override // com.newrelic.agent.android.payload.PayloadStore
    public int count() {
        return 0;
    }

    @Override // com.newrelic.agent.android.payload.PayloadStore
    public void delete(T t) {
    }

    @Override // com.newrelic.agent.android.payload.PayloadStore
    public boolean store(T t) {
        return true;
    }

    @Override // com.newrelic.agent.android.payload.PayloadStore
    public List<T> fetchAll() {
        return new ArrayList();
    }
}
