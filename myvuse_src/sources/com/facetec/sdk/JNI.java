package com.facetec.sdk;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class JNI {

    /* JADX INFO: renamed from: V */
    private static final Map<Object, String> f2300V;

    /* JADX INFO: renamed from: com.facetec.sdk.JNI$I */
    @Retention(RetentionPolicy.RUNTIME)
    @interface InterfaceC2128I {
        /* JADX INFO: renamed from: I */
        long m1430I();
    }

    static native void finalizeNativeMethods(Class<C2140af> cls, Class<C2187ca> cls2);

    private static native void registerNativeMethod(long j, String str, String str2);

    JNI() {
    }

    static {
        HashMap map = new HashMap();
        f2300V = map;
        map.put(Boolean.TYPE, "Z");
        map.put(Byte.TYPE, "B");
        map.put(Character.TYPE, "C");
        map.put(Double.TYPE, "D");
        map.put(Float.TYPE, "F");
        map.put(Integer.TYPE, "I");
        map.put(Long.TYPE, "J");
        map.put(Short.TYPE, ExifInterface.LATITUDE_SOUTH);
        map.put(Void.TYPE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
    }

    private static String Code(Class<?> cls) {
        if (cls.isArray()) {
            return new StringBuilder("[").append(Code(cls.getComponentType())).toString();
        }
        if (cls.isPrimitive()) {
            return f2300V.get(cls);
        }
        return new StringBuilder("L").append(cls.getName().replace('.', '/')).append(';').toString();
    }

    /* JADX INFO: renamed from: B */
    static void m1429B(long j, Method method) {
        StringBuilder sb = new StringBuilder("(");
        for (Class<?> cls : method.getParameterTypes()) {
            sb.append(Code(cls));
        }
        sb.append(')').append(Code(method.getReturnType()));
        registerNativeMethod(j, method.getName(), sb.toString());
    }
}
