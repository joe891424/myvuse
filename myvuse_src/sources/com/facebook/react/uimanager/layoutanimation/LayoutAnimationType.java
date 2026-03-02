package com.facebook.react.uimanager.layoutanimation;

/* JADX INFO: loaded from: classes3.dex */
enum LayoutAnimationType {
    CREATE,
    UPDATE,
    DELETE;

    /* JADX INFO: renamed from: com.facebook.react.uimanager.layoutanimation.LayoutAnimationType$1 */
    static /* synthetic */ class C20831 {

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$react$uimanager$layoutanimation$LayoutAnimationType */
        static final /* synthetic */ int[] f2127x364296ff;

        static {
            int[] iArr = new int[LayoutAnimationType.values().length];
            f2127x364296ff = iArr;
            try {
                iArr[LayoutAnimationType.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2127x364296ff[LayoutAnimationType.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2127x364296ff[LayoutAnimationType.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static String toString(LayoutAnimationType layoutAnimationType) {
        int i = C20831.f2127x364296ff[layoutAnimationType.ordinal()];
        if (i == 1) {
            return "create";
        }
        if (i == 2) {
            return "update";
        }
        if (i == 3) {
            return "delete";
        }
        throw new IllegalArgumentException("Unsupported LayoutAnimationType: " + layoutAnimationType);
    }
}
