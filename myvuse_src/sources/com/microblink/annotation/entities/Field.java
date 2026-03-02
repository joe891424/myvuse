package com.microblink.annotation.entities;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface Field {

    /* JADX INFO: compiled from: line */
    public enum Nullability {
        NonNull("@NonNull"),
        Nullable("@Nullable");

        public final String annotationName;

        Nullability(String str) {
            this.annotationName = str;
        }
    }

    String getterPrefix() default "";

    String nativeName() default "";

    Nullability nullability() default Nullability.NonNull;

    String[] requires() default {""};
}
