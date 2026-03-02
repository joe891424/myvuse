package com.newrelic.agent.android.crash;

import com.newrelic.agent.android.payload.PayloadStore;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface CrashStore extends PayloadStore<Crash> {
    @Override // com.newrelic.agent.android.payload.PayloadStore
    void clear();

    @Override // com.newrelic.agent.android.payload.PayloadStore
    int count();

    @Override // com.newrelic.agent.android.payload.PayloadStore
    void delete(Crash crash);

    @Override // com.newrelic.agent.android.payload.PayloadStore
    List<Crash> fetchAll();

    @Override // com.newrelic.agent.android.payload.PayloadStore
    boolean store(Crash crash);
}
