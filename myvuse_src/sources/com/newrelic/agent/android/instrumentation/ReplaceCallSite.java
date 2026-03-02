package com.newrelic.agent.android.instrumentation;

/* JADX INFO: loaded from: classes6.dex */
public @interface ReplaceCallSite {
    boolean isStatic() default false;

    String scope() default "";
}
