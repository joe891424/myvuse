package com.newrelic.agent.android.ndk;

import kotlin.Metadata;

/* JADX INFO: compiled from: AgentNDKListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&¨\u0006\n"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/AgentNDKListener;", "", "onApplicationNotResponding", "", "anrAsString", "", "onNativeCrash", "crashAsString", "onNativeException", "exceptionAsString", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface AgentNDKListener {
    boolean onApplicationNotResponding(String anrAsString);

    boolean onNativeCrash(String crashAsString);

    boolean onNativeException(String exceptionAsString);
}
