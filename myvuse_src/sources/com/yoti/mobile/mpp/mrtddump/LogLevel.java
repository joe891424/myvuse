package com.yoti.mobile.mpp.mrtddump;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/LogLevel;", "", "minLevelToLog", "", "(Ljava/lang/String;II)V", "getMinLevelToLog", "()I", "NONE", "WARN", "DEBUG", "ALL", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public enum LogLevel {
    NONE(6),
    WARN(4),
    DEBUG(2),
    ALL(0);

    private final int minLevelToLog;

    LogLevel(int i) {
        this.minLevelToLog = i;
    }

    public final int getMinLevelToLog() {
        return this.minLevelToLog;
    }
}
