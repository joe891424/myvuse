package com.google.mlkit.vision.face;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.mlkit_vision_face.zze;
import com.google.android.gms.internal.mlkit_vision_face.zzf;
import com.google.android.gms.vision.face.Contour;
import com.google.android.gms.vision.face.Landmark;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes2.dex */
public class Face {
    private final Rect zza;
    private int zzb;
    private float zzc;
    private float zzd;
    private float zze;
    private final float zzf;
    private final float zzg;
    private final float zzh;
    private final SparseArray<FaceLandmark> zzi = new SparseArray<>();
    private final SparseArray<FaceContour> zzj = new SparseArray<>();

    public Face(com.google.android.gms.vision.face.Face face) {
        int i;
        PointF position = face.getPosition();
        this.zza = new Rect((int) position.x, (int) position.y, (int) (position.x + face.getWidth()), (int) (position.y + face.getHeight()));
        this.zzb = face.getId();
        for (Landmark landmark : face.getLandmarks()) {
            if (zzd(landmark.getType()) && landmark.getPosition() != null) {
                this.zzi.put(landmark.getType(), new FaceLandmark(landmark.getType(), new PointF(landmark.getPosition().x, landmark.getPosition().y)));
            }
        }
        for (Contour contour : face.getContours()) {
            switch (contour.getType()) {
                case 1:
                    i = 1;
                    break;
                case 2:
                    i = 2;
                    break;
                case 3:
                    i = 3;
                    break;
                case 4:
                    i = 4;
                    break;
                case 5:
                    i = 5;
                    break;
                case 6:
                    i = 6;
                    break;
                case 7:
                    i = 7;
                    break;
                case 8:
                    i = 8;
                    break;
                case 9:
                    i = 9;
                    break;
                case 10:
                    i = 10;
                    break;
                case 11:
                    i = 11;
                    break;
                case 12:
                    i = 12;
                    break;
                case 13:
                    i = 13;
                    break;
                case 14:
                    i = 14;
                    break;
                case 15:
                    i = 15;
                    break;
                default:
                    i = -1;
                    break;
            }
            if (i > 0) {
                PointF[] positions = contour.getPositions();
                ArrayList arrayList = new ArrayList();
                if (positions != null) {
                    for (PointF pointF : positions) {
                        arrayList.add(new PointF(pointF.x, pointF.y));
                    }
                    this.zzj.put(i, new FaceContour(i, arrayList));
                }
            }
        }
        this.zzf = face.getEulerX();
        this.zzg = face.getEulerY();
        this.zzh = face.getEulerZ();
        this.zze = face.getIsSmilingProbability();
        this.zzd = face.getIsLeftEyeOpenProbability();
        this.zzc = face.getIsRightEyeOpenProbability();
    }

    private static boolean zzd(int i) {
        return i == 0 || i == 1 || i == 7 || i == 3 || i == 9 || i == 4 || i == 10 || i == 5 || i == 11 || i == 6;
    }

    public List<FaceContour> getAllContours() {
        ArrayList arrayList = new ArrayList();
        int size = this.zzj.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.zzj.valueAt(i));
        }
        return arrayList;
    }

    public List<FaceLandmark> getAllLandmarks() {
        ArrayList arrayList = new ArrayList();
        int size = this.zzi.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.zzi.valueAt(i));
        }
        return arrayList;
    }

    public Rect getBoundingBox() {
        return this.zza;
    }

    public FaceContour getContour(int i) {
        return this.zzj.get(i);
    }

    public float getHeadEulerAngleX() {
        return this.zzf;
    }

    public float getHeadEulerAngleY() {
        return this.zzg;
    }

    public float getHeadEulerAngleZ() {
        return this.zzh;
    }

    public FaceLandmark getLandmark(int i) {
        return this.zzi.get(i);
    }

    public Float getLeftEyeOpenProbability() {
        float f = this.zzd;
        if (f == -1.0f) {
            return null;
        }
        return Float.valueOf(f);
    }

    public Float getRightEyeOpenProbability() {
        float f = this.zzc;
        if (f == -1.0f) {
            return null;
        }
        return Float.valueOf(f);
    }

    public Float getSmilingProbability() {
        float f = this.zze;
        if (f == -1.0f) {
            return null;
        }
        return Float.valueOf(f);
    }

    public Integer getTrackingId() {
        int i = this.zzb;
        if (i == -1) {
            return null;
        }
        return Integer.valueOf(i);
    }

    public String toString() {
        zze zzeVarZza = zzf.zza("Face");
        zzeVarZza.zza("boundingBox", this.zza);
        zzeVarZza.zzd("trackingId", this.zzb);
        zzeVarZza.zzc("rightEyeOpenProbability", this.zzc);
        zzeVarZza.zzc("leftEyeOpenProbability", this.zzd);
        zzeVarZza.zzc("smileProbability", this.zze);
        zzeVarZza.zzc("eulerX", this.zzf);
        zzeVarZza.zzc("eulerY", this.zzg);
        zzeVarZza.zzc("eulerZ", this.zzh);
        zze zzeVarZza2 = zzf.zza("Landmarks");
        for (int i = 0; i <= 11; i++) {
            if (zzd(i)) {
                StringBuilder sb = new StringBuilder(20);
                sb.append("landmark_");
                sb.append(i);
                zzeVarZza2.zza(sb.toString(), getLandmark(i));
            }
        }
        zzeVarZza.zza("landmarks", zzeVarZza2.toString());
        zze zzeVarZza3 = zzf.zza("Contours");
        for (int i2 = 1; i2 <= 15; i2++) {
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append("Contour_");
            sb2.append(i2);
            zzeVarZza3.zza(sb2.toString(), getContour(i2));
        }
        zzeVarZza.zza("contours", zzeVarZza3.toString());
        return zzeVarZza.toString();
    }

    public final SparseArray<FaceContour> zza() {
        return this.zzj;
    }

    public final void zzb(SparseArray<FaceContour> sparseArray) {
        this.zzj.clear();
        for (int i = 0; i < sparseArray.size(); i++) {
            this.zzj.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
        }
    }

    public final void zzc(int i) {
        this.zzb = -1;
    }
}
