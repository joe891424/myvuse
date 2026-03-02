package com.microblink.blinkid.secured;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import com.microblink.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class lllllIIIlI {
    private static Constructor<?> IlIllIlIIl;
    private static Method IllIIIIllI;
    private static Constructor<?> IllIIIllII;
    private static Class<?> llIIIlllll;
    private static Constructor<?> llIIlIlIIl;

    static {
        try {
            Class<?> cls = Class.forName("android.hardware.camera2.utils.TypeReference");
            llIIIlllll = cls;
            IllIIIIllI = cls.getMethod("createSpecializedTypeReference", Type.class);
            llIIlIlIIl = CameraCharacteristics.Key.class.getDeclaredConstructor(String.class, llIIIlllll);
            IlIllIlIIl = CaptureRequest.Key.class.getDeclaredConstructor(String.class, llIIIlllll);
            IllIIIllII = CaptureResult.Key.class.getDeclaredConstructor(String.class, llIIIlllll);
        } catch (ClassNotFoundException e) {
            Log.m2710e(lllllIIIlI.class, e, "Failed to find desired class!", new Object[0]);
        } catch (NoSuchMethodException e2) {
            Log.m2710e(lllllIIIlI.class, e2, "Failed to find desired method!", new Object[0]);
        }
    }

    lllllIIIlI() {
    }

    static Object llIIlIlIIl(Object[] objArr) {
        Constructor<?> constructor;
        if (objArr.length < 3) {
            throw new RuntimeException("Illegal arguments to createKey");
        }
        String str = (String) objArr[0];
        Type type = (Type) objArr[1];
        int iIntValue = ((Integer) objArr[2]).intValue();
        Method method = IllIIIIllI;
        if (method == null) {
            Log.m2709e(lllllIIIlI.class, "Unable to invoke method createSpecializedTypeReference", new Object[0]);
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, type);
            if (iIntValue == 0) {
                Constructor<?> constructor2 = llIIlIlIIl;
                if (constructor2 != null) {
                    return constructor2.newInstance(str, objInvoke);
                }
                return null;
            }
            if (iIntValue != 1) {
                if (iIntValue == 2 && (constructor = IllIIIllII) != null) {
                    return constructor.newInstance(str, objInvoke);
                }
                return null;
            }
            Constructor<?> constructor3 = IlIllIlIIl;
            if (constructor3 != null) {
                return constructor3.newInstance(str, objInvoke);
            }
            return null;
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            Log.m2710e(lllllIIIlI.class, e, "Failed to invoke reflection method!", new Object[0]);
            return null;
        }
    }
}
