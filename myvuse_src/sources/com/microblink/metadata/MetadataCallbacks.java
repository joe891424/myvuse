package com.microblink.metadata;

import com.microblink.metadata.detection.FailedDetectionCallback;
import com.microblink.metadata.detection.points.PointsDetectionCallback;
import com.microblink.metadata.detection.quad.QuadDetectionCallback;
import com.microblink.metadata.glare.GlareCallback;
import com.microblink.metadata.image.DebugImageCallback;
import com.microblink.metadata.ocr.OcrCallback;
import com.microblink.metadata.recognition.FirstSideRecognitionCallback;
import com.microblink.metadata.text.DebugTextCallback;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class MetadataCallbacks {
    private FailedDetectionCallback IIlIIIllIl;
    private FirstSideRecognitionCallback IlIllIlIIl;
    private DebugTextCallback IllIIIIllI;
    private GlareCallback IllIIIllII;
    private QuadDetectionCallback lIlIIIIlIl;
    private DebugImageCallback llIIIlllll;
    private PointsDetectionCallback llIIlIIlll;
    private OcrCallback llIIlIlIIl;

    public DebugImageCallback getDebugImageCallback() {
        return this.llIIIlllll;
    }

    public DebugTextCallback getDebugTextCallback() {
        return this.IllIIIIllI;
    }

    public FailedDetectionCallback getFailedDetectionCallback() {
        return this.IIlIIIllIl;
    }

    public FirstSideRecognitionCallback getFirstSideRecognitionCallback() {
        return this.IlIllIlIIl;
    }

    public GlareCallback getGlareCallback() {
        return this.IllIIIllII;
    }

    public OcrCallback getOcrCallback() {
        return this.llIIlIlIIl;
    }

    public PointsDetectionCallback getPointsDetectionCallback() {
        return this.llIIlIIlll;
    }

    public QuadDetectionCallback getQuadDetectionCallback() {
        return this.lIlIIIIlIl;
    }

    public void setDebugImageCallback(DebugImageCallback debugImageCallback) {
        this.llIIIlllll = debugImageCallback;
    }

    public void setDebugTextCallback(DebugTextCallback debugTextCallback) {
        this.IllIIIIllI = debugTextCallback;
    }

    public void setFailedDetectionCallback(FailedDetectionCallback failedDetectionCallback) {
        this.IIlIIIllIl = failedDetectionCallback;
    }

    public void setFirstSideRecognitionCallback(FirstSideRecognitionCallback firstSideRecognitionCallback) {
        this.IlIllIlIIl = firstSideRecognitionCallback;
    }

    public void setGlareCallback(GlareCallback glareCallback) {
        this.IllIIIllII = glareCallback;
    }

    public void setOcrCallback(OcrCallback ocrCallback) {
        this.llIIlIlIIl = ocrCallback;
    }

    public void setPointsDetectionCallback(PointsDetectionCallback pointsDetectionCallback) {
        this.llIIlIIlll = pointsDetectionCallback;
    }

    public void setQuadDetectionCallback(QuadDetectionCallback quadDetectionCallback) {
        this.lIlIIIIlIl = quadDetectionCallback;
    }
}
