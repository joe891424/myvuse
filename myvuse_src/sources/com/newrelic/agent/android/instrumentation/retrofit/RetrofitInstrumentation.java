package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import retrofit.RestAdapter;
import retrofit.client.Client;

/* JADX INFO: loaded from: classes6.dex */
public final class RetrofitInstrumentation {
    private static final AgentLog log = AgentLogManager.getAgentLog();

    private RetrofitInstrumentation() {
    }

    public static RestAdapter.Builder setClient(RestAdapter.Builder builder, Client client) {
        return new RestAdapterBuilderExtension(builder).setClient(client);
    }
}
