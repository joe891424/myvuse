package com.newrelic.agent.android.api.p043v1;

/* JADX INFO: loaded from: classes6.dex */
public interface ConnectionListener {
    void connected(ConnectionEvent connectionEvent);

    void disconnected(ConnectionEvent connectionEvent);
}
