package com.newrelic.com.google.gson.internal.reflect;

import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: classes6.dex */
final class PreJava9ReflectionAccessor extends ReflectionAccessor {
    PreJava9ReflectionAccessor() {
    }

    @Override // com.newrelic.com.google.gson.internal.reflect.ReflectionAccessor
    public void makeAccessible(AccessibleObject accessibleObject) {
        accessibleObject.setAccessible(true);
    }
}
