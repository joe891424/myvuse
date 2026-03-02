package com.microblink.entities.recognizers.blinkid.documentface;

import com.microblink.geometry.Quadrilateral;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
class DocumentFaceRecognizerTemplate {

    /* JADX INFO: compiled from: line */
    static class Result {
        Result() {
        }

        private static native float[] documentLocationNativeGet(long j);

        private static native float[] faceLocationNativeGet(long j);

        public Quadrilateral getDocumentLocation() {
            return new Quadrilateral(documentLocationNativeGet(0L));
        }

        public Quadrilateral getFaceLocation() {
            return new Quadrilateral(faceLocationNativeGet(0L));
        }

        public String toString() {
            return "Document face recognizer";
        }
    }

    public DocumentFaceRecognizerTemplate(DocumentFaceDetectorType documentFaceDetectorType) {
        this();
        setDetectorType(documentFaceDetectorType);
    }

    private static native int detectorTypeNativeGet(long j);

    private static native void detectorTypeNativeSet(long j, int i);

    public DocumentFaceDetectorType getDetectorType() {
        return DocumentFaceDetectorType.values()[detectorTypeNativeGet(0L)];
    }

    public void setDetectorType(DocumentFaceDetectorType documentFaceDetectorType) {
        detectorTypeNativeSet(0L, documentFaceDetectorType.ordinal());
    }

    private DocumentFaceRecognizerTemplate() {
    }
}
