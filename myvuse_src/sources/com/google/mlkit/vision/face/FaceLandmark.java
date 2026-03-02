package com.google.mlkit.vision.face;

import android.graphics.PointF;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.internal.mlkit_vision_face.zze;
import com.google.android.gms.internal.mlkit_vision_face.zzf;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes2.dex */
public class FaceLandmark {
    public static final int LEFT_CHEEK = 1;
    public static final int LEFT_EAR = 3;
    public static final int LEFT_EYE = 4;
    public static final int MOUTH_BOTTOM = 0;
    public static final int MOUTH_LEFT = 5;
    public static final int MOUTH_RIGHT = 11;
    public static final int NOSE_BASE = 6;
    public static final int RIGHT_CHEEK = 7;
    public static final int RIGHT_EAR = 9;
    public static final int RIGHT_EYE = 10;
    private final int zza;
    private final PointF zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
    @Retention(RetentionPolicy.CLASS)
    public @interface LandmarkType {
    }

    FaceLandmark(int i, PointF pointF) {
        this.zza = i;
        this.zzb = pointF;
    }

    public int getLandmarkType() {
        return this.zza;
    }

    public PointF getPosition() {
        return this.zzb;
    }

    public String toString() {
        zze zzeVarZza = zzf.zza("FaceLandmark");
        zzeVarZza.zzd("type", this.zza);
        zzeVarZza.zza(ViewProps.POSITION, this.zzb);
        return zzeVarZza.toString();
    }
}
