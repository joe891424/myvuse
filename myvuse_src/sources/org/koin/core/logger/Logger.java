package org.koin.core.logger;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rj\u0002`\u000eJ\u001c\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\f\u001a\u00060\rj\u0002`\u000eH\u0002J\u0012\u0010\u0010\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rj\u0002`\u000eJ\u0012\u0010\u0011\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rj\u0002`\u000eJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0003J\u001c\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\f\u001a\u00060\rj\u0002`\u000eH&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0015"}, m5598d2 = {"Lorg/koin/core/logger/Logger;", "", FirebaseAnalytics.Param.LEVEL, "Lorg/koin/core/logger/Level;", "(Lorg/koin/core/logger/Level;)V", "getLevel", "()Lorg/koin/core/logger/Level;", "setLevel", "canLog", "", "debug", "", NotificationCompat.CATEGORY_MESSAGE, "", "Lorg/koin/core/logger/MESSAGE;", "doLog", "error", "info", "isAt", "lvl", "log", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
public abstract class Logger {
    private Level level;

    /* JADX WARN: Multi-variable type inference failed */
    public Logger() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public abstract void log(Level level, String msg);

    public Logger(Level level) {
        Intrinsics.checkParameterIsNotNull(level, "level");
        this.level = level;
    }

    public /* synthetic */ Logger(Level level, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Level.INFO : level);
    }

    public final Level getLevel() {
        return this.level;
    }

    public final void setLevel(Level level) {
        Intrinsics.checkParameterIsNotNull(level, "<set-?>");
        this.level = level;
    }

    private final boolean canLog(Level level) {
        return this.level.compareTo(level) <= 0;
    }

    private final void doLog(Level level, String msg) {
        if (canLog(level)) {
            log(level, msg);
        }
    }

    public final void debug(String msg) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        doLog(Level.DEBUG, msg);
    }

    public final void info(String msg) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        doLog(Level.INFO, msg);
    }

    public final void error(String msg) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        doLog(Level.ERROR, msg);
    }

    public final boolean isAt(Level lvl) {
        Intrinsics.checkParameterIsNotNull(lvl, "lvl");
        return this.level.compareTo(lvl) <= 0;
    }
}
