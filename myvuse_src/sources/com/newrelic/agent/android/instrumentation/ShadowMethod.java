package com.newrelic.agent.android.instrumentation;

/* JADX INFO: loaded from: classes6.dex */
public @interface ShadowMethod {
    boolean isStatic() default false;

    String scope() default "";
}
