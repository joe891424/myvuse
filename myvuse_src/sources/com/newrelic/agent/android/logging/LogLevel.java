package com.newrelic.agent.android.logging;

/* JADX INFO: loaded from: classes6.dex */
public enum LogLevel {
    NONE(0),
    ERROR(1),
    WARN(2),
    INFO(3),
    VERBOSE(4),
    DEBUG(5);

    static final LogLevel[] levels = values();
    final int value;

    LogLevel(int i) {
        this.value = i;
    }
}
