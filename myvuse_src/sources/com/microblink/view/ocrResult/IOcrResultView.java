package com.microblink.view.ocrResult;

import com.microblink.metadata.ocr.DisplayableOcrResult;
import com.microblink.view.viewfinder.IDetectionView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface IOcrResultView extends IDetectionView {
    void addOcrResult(DisplayableOcrResult displayableOcrResult);

    void setOcrResult(DisplayableOcrResult displayableOcrResult);
}
