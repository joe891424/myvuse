package com.newrelic.agent.android.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class NamedThreadFactory implements ThreadFactory {
    final String namePrefix;
    final AtomicInteger threadNumber = new AtomicInteger(1);
    final ThreadGroup group = Thread.currentThread().getThreadGroup();

    public NamedThreadFactory(String str) {
        this.namePrefix = "NR_" + str + "-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
