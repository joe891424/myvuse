package com.microblink.metadata.detection;

import com.microblink.metadata.DisplayableObject;
import com.microblink.view.recognition.DetectionStatus;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DisplayableDetection extends DisplayableObject {
    protected DetectionStatus IlIllIlIIl;

    protected DisplayableDetection(int i, float[] fArr) {
        super(fArr);
        this.IlIllIlIIl = DetectionStatus.values()[i];
    }

    public final DetectionStatus getDetectionStatus() {
        return this.IlIllIlIIl;
    }
}
