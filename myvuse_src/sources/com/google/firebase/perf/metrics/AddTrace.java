package com.google.firebase.perf.metrics;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@Retention(RetentionPolicy.CLASS)
public @interface AddTrace {
    boolean enabled() default true;

    String name();
}
