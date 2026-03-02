package com.microblink.blinkid.secured;

import com.microblink.entities.recognizers.Recognizer;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class llllllIlll {

    /* JADX INFO: compiled from: line */
    static /* synthetic */ class llIIlIlIIl {
        static final /* synthetic */ int[] llIIlIlIIl;

        static {
            int[] iArr = new int[Recognizer.Result.State.values().length];
            llIIlIlIIl = iArr;
            try {
                iArr[Recognizer.Result.State.Empty.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                llIIlIlIIl[Recognizer.Result.State.Uncertain.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                llIIlIlIIl[Recognizer.Result.State.StageValid.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                llIIlIlIIl[Recognizer.Result.State.Valid.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static llIlIlIlII llIIlIlIIl(lIIllIllIl liillillil, long j, long j2, long j3) {
        return new llIlIlIlII(liillillil.llIIlIlIIl(), new lIlIIIIIll(j, j2, j3));
    }
}
