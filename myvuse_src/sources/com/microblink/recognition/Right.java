package com.microblink.recognition;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public enum Right {
    /* JADX INFO: Fake field, exist only in values array */
    TIMESTAMP_USED(0, "licence key is time restricted"),
    PING_USED(1, "licence key requires regular network ping"),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_MULTIPLE_APPS(3, "allow using license key in multiple applications"),
    IS_TRIAL(4, "license key is trial"),
    ALLOW_CUSTOM_UI(10, "allow custom camera overlay when using library"),
    ALLOW_REMOVE_DEMO_OVERLAY(11, "allow removing demo overlay from RecognizerRunnerView"),
    ALLOW_REMOVE_PRODUCTION_OVERLAY(12, "allow removing production overlay from camera"),
    ALLOW_IMAGE_UPLOAD(13, "allow image upload after successful scanning");

    private String IlIllIlIIl;
    private int llIIlIlIIl;

    Right(int i, String str) {
        this.llIIlIlIIl = i;
        this.IlIllIlIIl = str;
    }

    public static Right fromIntValue(int i) {
        for (Right right : values()) {
            if (right.llIIlIlIIl == i) {
                return right;
            }
        }
        return null;
    }

    public int llIIlIlIIl() {
        return this.llIIlIlIIl;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.IlIllIlIIl;
    }
}
