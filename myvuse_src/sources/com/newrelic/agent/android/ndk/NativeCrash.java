package com.newrelic.agent.android.ndk;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.crash.Crash;
import com.newrelic.agent.android.harvest.crash.ThreadInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeCrash.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B7\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/NativeCrash;", "Lcom/newrelic/agent/android/crash/Crash;", "crashAsJson", "", "(Ljava/lang/String;)V", "nativeException", "Lcom/newrelic/agent/android/ndk/NativeException;", "sessionAttributes", "", "Lcom/newrelic/agent/android/analytics/AnalyticsAttribute;", "events", "", "Lcom/newrelic/agent/android/analytics/AnalyticsEvent;", "(Lcom/newrelic/agent/android/ndk/NativeException;Ljava/util/Set;Ljava/util/Collection;)V", "getNativeException", "()Lcom/newrelic/agent/android/ndk/NativeException;", "extractNativeThreads", "", "Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;", "extractThreads", "throwable", "", "Companion", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NativeCrash extends Crash {
    private final NativeException nativeException;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String CRASH_DELIMITER = "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***";
    private static final String BUILD_FINGERPRINT = System.getProperty("ro.build.fingerprint", "FIXME");
    private static final String REVISION = System.getProperty("ro.revision", "-1");

    public final NativeException getNativeException() {
        return this.nativeException;
    }

    public /* synthetic */ NativeCrash(NativeException nativeException, HashSet hashSet, HashSet hashSet2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nativeException, (i & 2) != 0 ? new HashSet() : hashSet, (i & 4) != 0 ? new HashSet() : hashSet2);
    }

    public NativeCrash(NativeException nativeException, Set<? extends AnalyticsAttribute> set, Collection<? extends AnalyticsEvent> collection) {
        super(nativeException, set, collection, true);
        this.nativeException = nativeException;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NativeCrash(String crashAsJson) {
        this(new NativeException(crashAsJson), null, null, 6, null);
        Intrinsics.checkNotNullParameter(crashAsJson, "crashAsJson");
    }

    public final List<ThreadInfo> extractNativeThreads(NativeException nativeException) {
        Intrinsics.checkNotNullParameter(nativeException, "nativeException");
        NativeStackTrace nativeStackTrace = nativeException.getNativeStackTrace();
        if (nativeStackTrace != null) {
            return nativeStackTrace.getThreads();
        }
        return new ArrayList();
    }

    @Override // com.newrelic.agent.android.crash.Crash
    public List<ThreadInfo> extractThreads(Throwable throwable) {
        if (throwable instanceof NativeException) {
            return extractNativeThreads((NativeException) throwable);
        }
        List<ThreadInfo> listExtractThreads = super.extractThreads(throwable);
        Intrinsics.checkNotNullExpressionValue(listExtractThreads, "super.extractThreads(throwable)");
        return listExtractThreads;
    }

    /* JADX INFO: compiled from: NativeCrash.kt */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/NativeCrash$Companion;", "", "()V", "BUILD_FINGERPRINT", "", "kotlin.jvm.PlatformType", "getBUILD_FINGERPRINT", "()Ljava/lang/String;", "CRASH_DELIMITER", "getCRASH_DELIMITER", "REVISION", "getREVISION", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getCRASH_DELIMITER() {
            return NativeCrash.CRASH_DELIMITER;
        }

        public final String getBUILD_FINGERPRINT() {
            return NativeCrash.BUILD_FINGERPRINT;
        }

        public final String getREVISION() {
            return NativeCrash.REVISION;
        }
    }
}
