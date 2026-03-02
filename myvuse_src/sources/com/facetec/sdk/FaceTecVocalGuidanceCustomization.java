package com.facetec.sdk;

/* JADX INFO: loaded from: classes3.dex */
public class FaceTecVocalGuidanceCustomization {
    public VocalGuidanceMode mode = VocalGuidanceMode.MINIMAL_VOCAL_GUIDANCE;
    public int pleaseFrameYourFaceInTheOvalSoundFile = -1;
    public int pleaseMoveCloserSoundFile = -1;
    public int pleaseRetrySoundFile = -1;
    public int uploadingSoundFile = -1;
    public int facescanSuccessfulSoundFile = -1;
    public int pleasePressTheButtonToStartSoundFile = -1;

    public enum VocalGuidanceMode {
        MINIMAL_VOCAL_GUIDANCE("MINIMAL_VOCAL_GUIDANCE"),
        FULL_VOCAL_GUIDANCE("FULL_VOCAL_GUIDANCE"),
        NO_VOCAL_GUIDANCE("NO_VOCAL_GUIDANCE");


        /* JADX INFO: renamed from: B */
        private final String f2250B;

        VocalGuidanceMode(String str) {
            this.f2250B = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.f2250B;
        }
    }
}
