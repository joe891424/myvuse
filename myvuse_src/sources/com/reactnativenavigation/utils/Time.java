package com.reactnativenavigation.utils;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.reactnativenavigation.utils.Functions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class Time {
    private static Map<String, Long> tagsToStartTime = new HashMap();
    private static Now now = new Now();
    private static AtomicInteger count = new AtomicInteger();

    public static <T> T log(String str, Functions.Unit<T> unit) {
        int iIncrementAndGet = count.incrementAndGet();
        log(str + iIncrementAndGet);
        T t = unit.get();
        log(str + iIncrementAndGet);
        return t;
    }

    public static void log(String str, Functions.Func func) {
        int iIncrementAndGet = count.incrementAndGet();
        log(str + iIncrementAndGet);
        func.run();
        log(str + iIncrementAndGet);
    }

    public static void log(String str) {
        if (tagsToStartTime.containsKey(str)) {
            LogInstrumentation.m2730i(str, "Elapsed: " + (now() - time(str)) + "ms");
        } else {
            LogInstrumentation.m2732v(str, "logging start");
        }
        tagsToStartTime.put(str, Long.valueOf(now()));
    }

    private static long now() {
        return now.now();
    }

    private static long time(String str) {
        return tagsToStartTime.get(str).longValue();
    }
}
