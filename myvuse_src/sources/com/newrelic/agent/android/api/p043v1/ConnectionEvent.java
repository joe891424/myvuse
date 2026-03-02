package com.newrelic.agent.android.api.p043v1;

import com.newrelic.agent.android.api.common.ConnectionState;
import java.util.EventObject;

/* JADX INFO: loaded from: classes6.dex */
public final class ConnectionEvent extends EventObject {
    private static final long serialVersionUID = 1;
    private final ConnectionState connectionState;

    public ConnectionEvent(Object obj) {
        this(obj, null);
    }

    public ConnectionEvent(Object obj, ConnectionState connectionState) {
        super(obj);
        this.connectionState = connectionState;
    }

    public ConnectionState getConnectionState() {
        return this.connectionState;
    }
}
