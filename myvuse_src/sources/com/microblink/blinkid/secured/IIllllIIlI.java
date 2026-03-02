package com.microblink.blinkid.secured;

import android.content.Context;
import android.os.Parcelable;
import com.microblink.blinkid.secured.llllllIlll;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.blinkid.generic.classinfo.ClassInfo;
import com.microblink.entities.recognizers.blinkid.generic.classinfo.ClassInfoResult;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
final class IIllllIIlI implements lIllIlIlII {
    private final IIIIlIlIII IlIllIlIIl = new IIIIlIlIII();
    private final IlIllIIlIl llIIlIlIIl;

    IIllllIIlI(Context context) {
        this.llIIlIlIIl = new IlIllIIlIl(context);
    }

    @Override // com.microblink.blinkid.secured.lIllIlIlII
    public void llIIlIlIIl() {
        this.llIIlIlIIl.llIIlIlIIl();
    }

    @Override // com.microblink.blinkid.secured.lIllIlIlII
    public void llIIlIlIIl(RecognizerBundle recognizerBundle, lIIlIIIIlI liiliiiili) {
        IIIIlIlIII iIIIlIlIII = this.IlIllIlIIl;
        Recognizer<Recognizer.Result>[] recognizers = recognizerBundle.getRecognizers();
        ArrayList arrayList = new ArrayList();
        for (Recognizer<Recognizer.Result> recognizer : recognizers) {
            String name = recognizer.getName();
            HashMap map = new HashMap();
            Parcelable parcelable = (Recognizer.Result) recognizer.getResult();
            if (parcelable instanceof ClassInfoResult) {
                ClassInfo classInfo = ((ClassInfoResult) parcelable).getClassInfo();
                map.put("country", classInfo.getCountry().name());
                map.put("region", classInfo.getRegion().name());
                map.put("type", classInfo.getType().name());
            }
            if (map.isEmpty()) {
                map = null;
            }
            IlIIlIIIll ilIIlIIIll = new IlIIlIIIll(name, map);
            boolean zIsExcludedFromPing = recognizer.isExcludedFromPing();
            Recognizer.Result.State resultState = recognizer.getResult().getResultState();
            int i = llllllIlll.llIIlIlIIl.llIIlIlIIl[resultState.ordinal()];
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2 && i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException("Unexpected value: " + resultState);
                    }
                    i2 = 3;
                }
            }
            arrayList.add(new lIIllIllIl(ilIIlIIIll, zIsExcludedFromPing, i2));
        }
        this.llIIlIlIIl.llIIlIlIIl(iIIIlIlIII.llIIlIlIIl(arrayList, liiliiiili));
    }
}
