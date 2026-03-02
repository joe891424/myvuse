package com.microblink.metadata.ocr;

import com.microblink.metadata.DisplayableObject;
import com.microblink.results.ocr.OcrResult;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class DisplayableOcrResult extends DisplayableObject {
    private OcrResult IlIllIlIIl;
    private String IllIIIllII;

    public DisplayableOcrResult(OcrResult ocrResult, String str, float[] fArr) {
        super(fArr);
        this.IlIllIlIIl = ocrResult;
        this.IllIIIllII = str;
    }

    public OcrResult getOcrResult() {
        return this.IlIllIlIIl;
    }

    public String getResultName() {
        return this.IllIIIllII;
    }
}
