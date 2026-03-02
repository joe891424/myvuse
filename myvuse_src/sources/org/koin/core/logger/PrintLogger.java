package org.koin.core.logger;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrintLogger.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016¨\u0006\n"}, m5598d2 = {"Lorg/koin/core/logger/PrintLogger;", "Lorg/koin/core/logger/Logger;", FirebaseAnalytics.Param.LEVEL, "Lorg/koin/core/logger/Level;", "(Lorg/koin/core/logger/Level;)V", "log", "", NotificationCompat.CATEGORY_MESSAGE, "", "Lorg/koin/core/logger/MESSAGE;", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class PrintLogger extends Logger {
    /* JADX WARN: Multi-variable type inference failed */
    public PrintLogger() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrintLogger(Level level) {
        super(level);
        Intrinsics.checkParameterIsNotNull(level, "level");
    }

    public /* synthetic */ PrintLogger(Level level, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Level.INFO : level);
    }

    @Override // org.koin.core.logger.Logger
    public void log(Level level, String msg) {
        Intrinsics.checkParameterIsNotNull(level, "level");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        if (getLevel().compareTo(level) <= 0) {
            (level.compareTo(Level.ERROR) >= 0 ? System.err : System.out).println("[" + level + "] [Koin] " + msg);
        }
    }
}
