package com.newrelic.agent.android.ndk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.newrelic.agent.android.hybrid.data.HexAttribute;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManagedContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 +2\u00020\u0001:\u0001+B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010(\u001a\u00020 2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0010\u0010)\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010 R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010¨\u0006,"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/ManagedContext;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "anrMonitor", "", "getAnrMonitor", "()Z", "setAnrMonitor", "(Z)V", HexAttribute.HEX_ATTR_JSERROR_BUILDID, "", "getBuildId", "()Ljava/lang/String;", "setBuildId", "(Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "expirationPeriod", "", "getExpirationPeriod", "()J", "setExpirationPeriod", "(J)V", "nativeReportListener", "Lcom/newrelic/agent/android/ndk/AgentNDKListener;", "getNativeReportListener", "()Lcom/newrelic/agent/android/ndk/AgentNDKListener;", "setNativeReportListener", "(Lcom/newrelic/agent/android/ndk/AgentNDKListener;)V", "reportsDir", "Ljava/io/File;", "getReportsDir", "()Ljava/io/File;", "setReportsDir", "(Ljava/io/File;)V", "sessionId", "getSessionId", "setSessionId", "getNativeLibraryDir", "getNativeReportsDir", "rootDir", "Companion", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ManagedContext {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long DEFAULT_TTL = TimeUnit.SECONDS.convert(7, TimeUnit.DAYS);
    private boolean anrMonitor;
    private String buildId;
    private final Context context;
    private long expirationPeriod;
    private AgentNDKListener nativeReportListener;
    private File reportsDir;
    private String sessionId;

    /* JADX WARN: Multi-variable type inference failed */
    public ManagedContext() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ManagedContext(Context context) {
        this.context = context;
        this.reportsDir = getNativeReportsDir(context == null ? null : context.getCacheDir());
        this.anrMonitor = true;
        this.expirationPeriod = DEFAULT_TTL;
    }

    public /* synthetic */ ManagedContext(Context context, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : context);
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final String getBuildId() {
        return this.buildId;
    }

    public final void setBuildId(String str) {
        this.buildId = str;
    }

    public final File getReportsDir() {
        return this.reportsDir;
    }

    public final void setReportsDir(File file) {
        this.reportsDir = file;
    }

    public final AgentNDKListener getNativeReportListener() {
        return this.nativeReportListener;
    }

    public final void setNativeReportListener(AgentNDKListener agentNDKListener) {
        this.nativeReportListener = agentNDKListener;
    }

    public final boolean getAnrMonitor() {
        return this.anrMonitor;
    }

    public final void setAnrMonitor(boolean z) {
        this.anrMonitor = z;
    }

    public final long getExpirationPeriod() {
        return this.expirationPeriod;
    }

    public final void setExpirationPeriod(long j) {
        this.expirationPeriod = j;
    }

    public final File getNativeReportsDir(File rootDir) {
        return new File(Intrinsics.stringPlus(rootDir == null ? null : rootDir.getAbsolutePath(), "/newrelic/nativeReporting"));
    }

    public final File getNativeLibraryDir(Context context) {
        String str;
        Intrinsics.checkNotNull(context);
        String packageName = context.getPackageName();
        if (packageName == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = packageManager == null ? null : packageManager.getApplicationInfo(packageName, 1024);
        if (applicationInfo != null && (str = applicationInfo.nativeLibraryDir) != null) {
            return new File(str);
        }
        return new File("./");
    }

    /* JADX INFO: compiled from: ManagedContext.kt */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/newrelic/agent/android/ndk/ManagedContext$Companion;", "", "()V", "DEFAULT_TTL", "", "getDEFAULT_TTL", "()J", "agent-ndk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getDEFAULT_TTL() {
            return ManagedContext.DEFAULT_TTL;
        }
    }
}
