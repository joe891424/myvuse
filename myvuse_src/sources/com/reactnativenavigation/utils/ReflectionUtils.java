package com.reactnativenavigation.utils;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes6.dex */
public class ReflectionUtils {
    public static void setField(Object obj, String str, Object obj2) {
        try {
            Field field = getField(obj.getClass(), str);
            if (field == null) {
                return;
            }
            field.setAccessible(true);
            field.set(obj, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getDeclaredField(Object obj, String str) {
        try {
            Field field = getField(obj.getClass(), str);
            if (field == null) {
                return null;
            }
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Field getField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            return getField(cls.getSuperclass(), str);
        } catch (Exception unused2) {
            return null;
        }
    }
}
