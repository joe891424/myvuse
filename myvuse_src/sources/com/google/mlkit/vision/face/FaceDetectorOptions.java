package com.google.mlkit.vision.face;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.mlkit_vision_face.zze;
import com.google.android.gms.internal.mlkit_vision_face.zzf;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes2.dex */
public class FaceDetectorOptions {
    public static final int CLASSIFICATION_MODE_ALL = 2;
    public static final int CLASSIFICATION_MODE_NONE = 1;
    public static final int CONTOUR_MODE_ALL = 2;
    public static final int CONTOUR_MODE_NONE = 1;
    public static final int LANDMARK_MODE_ALL = 2;
    public static final int LANDMARK_MODE_NONE = 1;
    public static final int PERFORMANCE_MODE_ACCURATE = 2;
    public static final int PERFORMANCE_MODE_FAST = 1;
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final boolean zze;
    private final float zzf;
    private final Executor zzg;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
    public static class Builder {
        private int zza = 1;
        private int zzb = 1;
        private int zzc = 1;
        private int zzd = 1;
        private boolean zze = false;
        private float zzf = 0.1f;
        private Executor zzg;

        public FaceDetectorOptions build() {
            return new FaceDetectorOptions(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, null);
        }

        public Builder enableTracking() {
            this.zze = true;
            return this;
        }

        public Builder setClassificationMode(int i) {
            this.zzc = i;
            return this;
        }

        public Builder setContourMode(int i) {
            this.zzb = i;
            return this;
        }

        public Builder setExecutor(Executor executor) {
            this.zzg = executor;
            return this;
        }

        public Builder setLandmarkMode(int i) {
            this.zza = i;
            return this;
        }

        public Builder setMinFaceSize(float f) {
            this.zzf = f;
            return this;
        }

        public Builder setPerformanceMode(int i) {
            this.zzd = i;
            return this;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
    @Retention(RetentionPolicy.CLASS)
    public @interface ClassificationMode {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
    @Retention(RetentionPolicy.CLASS)
    public @interface ContourMode {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
    @Retention(RetentionPolicy.CLASS)
    public @interface LandmarkMode {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
    @Retention(RetentionPolicy.CLASS)
    public @interface PerformanceMode {
    }

    /* synthetic */ FaceDetectorOptions(int i, int i2, int i3, int i4, boolean z, float f, Executor executor, zza zzaVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = z;
        this.zzf = f;
        this.zzg = executor;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FaceDetectorOptions)) {
            return false;
        }
        FaceDetectorOptions faceDetectorOptions = (FaceDetectorOptions) obj;
        return Float.floatToIntBits(this.zzf) == Float.floatToIntBits(faceDetectorOptions.zzf) && this.zza == faceDetectorOptions.zza && this.zzb == faceDetectorOptions.zzb && this.zzd == faceDetectorOptions.zzd && this.zze == faceDetectorOptions.zze && this.zzc == faceDetectorOptions.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Float.floatToIntBits(this.zzf)), Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzd), Boolean.valueOf(this.zze), Integer.valueOf(this.zzc));
    }

    public String toString() {
        zze zzeVarZza = zzf.zza("FaceDetectorOptions");
        zzeVarZza.zzd("landmarkMode", this.zza);
        zzeVarZza.zzd("contourMode", this.zzb);
        zzeVarZza.zzd("classificationMode", this.zzc);
        zzeVarZza.zzd("performanceMode", this.zzd);
        zzeVarZza.zzb("trackingEnabled", this.zze);
        zzeVarZza.zzc("minFaceSize", this.zzf);
        return zzeVarZza.toString();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final boolean zze() {
        return this.zze;
    }

    public final float zzf() {
        return this.zzf;
    }

    public final Executor zzg() {
        return this.zzg;
    }
}
