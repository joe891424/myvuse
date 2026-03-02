package com.google.android.gms.vision.face;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.zzbw;
import com.google.android.gms.internal.vision.zzcb;
import com.google.android.gms.internal.vision.zzcc;
import com.google.android.gms.internal.vision.zzci;
import com.google.android.gms.internal.vision.zzck;
import com.google.android.gms.internal.vision.zzcp;
import com.google.android.gms.internal.vision.zzct;
import com.google.android.gms.internal.vision.zzfi;
import com.google.android.gms.internal.vision.zzim;
import com.google.android.gms.internal.vision.zzjb;
import com.google.android.gms.internal.vision.zzmt;
import com.google.android.gms.internal.vision.zznb;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.clearcut.LogUtils;
import com.google.android.gms.vision.face.internal.client.FaceParcel;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzg;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class NativeFaceDetectorV2Impl extends zzg {
    private static final GmsLogger zza = new GmsLogger("NativeFaceDetectorV2Imp", "");
    private final long zzb;
    private final DynamiteClearcutLogger zzc;
    private final zzci.zzd zzd;
    private final FaceDetectorV2Jni zze;

    /* JADX INFO: renamed from: com.google.android.gms.vision.face.NativeFaceDetectorV2Impl$1 */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    static /* synthetic */ class C23061 {
        static final /* synthetic */ int[] zza;
        static final /* synthetic */ int[] zzb;

        static {
            int[] iArr = new int[zzci.zzb.zzc.values().length];
            zzb = iArr;
            try {
                iArr[zzci.zzb.zzc.FACE_OVAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                zzb[zzci.zzb.zzc.LEFT_EYEBROW_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                zzb[zzci.zzb.zzc.LEFT_EYEBROW_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                zzb[zzci.zzb.zzc.RIGHT_EYEBROW_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                zzb[zzci.zzb.zzc.RIGHT_EYEBROW_BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                zzb[zzci.zzb.zzc.LEFT_EYE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                zzb[zzci.zzb.zzc.RIGHT_EYE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                zzb[zzci.zzb.zzc.UPPER_LIP_TOP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                zzb[zzci.zzb.zzc.UPPER_LIP_BOTTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                zzb[zzci.zzb.zzc.LOWER_LIP_TOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                zzb[zzci.zzb.zzc.LOWER_LIP_BOTTOM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                zzb[zzci.zzb.zzc.NOSE_BRIDGE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                zzb[zzci.zzb.zzc.NOSE_BOTTOM.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                zzb[zzci.zzb.zzc.LEFT_CHEEK_CENTER.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                zzb[zzci.zzb.zzc.RIGHT_CHEEK_CENTER.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr2 = new int[zzmt.zze.zzb.values().length];
            zza = iArr2;
            try {
                iArr2[zzmt.zze.zzb.LEFT_EYE.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                zza[zzmt.zze.zzb.RIGHT_EYE.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                zza[zzmt.zze.zzb.NOSE_TIP.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                zza[zzmt.zze.zzb.LOWER_LIP.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                zza[zzmt.zze.zzb.MOUTH_LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                zza[zzmt.zze.zzb.MOUTH_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                zza[zzmt.zze.zzb.LEFT_EAR_TRAGION.ordinal()] = 7;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                zza[zzmt.zze.zzb.RIGHT_EAR_TRAGION.ordinal()] = 8;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                zza[zzmt.zze.zzb.LEFT_CHEEK_CENTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                zza[zzmt.zze.zzb.RIGHT_CHEEK_CENTER.ordinal()] = 10;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                zza[zzmt.zze.zzb.LEFT_EAR_TOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                zza[zzmt.zze.zzb.RIGHT_EAR_TOP.ordinal()] = 12;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    NativeFaceDetectorV2Impl(Context context, Context context2, DynamiteClearcutLogger dynamiteClearcutLogger, zzf zzfVar, FaceDetectorV2Jni faceDetectorV2Jni) {
        zzci.zzg zzgVar = (zzci.zzg) ((zzjb) zzci.zzg.zza().zza("models").zzf());
        zzci.zzd.zza zzaVarZzc = zzci.zzd.zzc().zza(zzci.zze.zza().zza(zzgVar).zzb(zzgVar).zzc(zzgVar)).zza(zzci.zza.zza().zza(zzgVar).zzb(zzgVar)).zza(zzci.zzf.zza().zza(zzgVar).zzb(zzgVar).zzc(zzgVar).zzd(zzgVar)).zza(zzfVar.zzd).zzb(zzfVar.zze).zza(zzfVar.zzf).zzc(true);
        int i = zzfVar.zza;
        if (i == 0) {
            zzaVarZzc.zza(zzct.FAST);
        } else if (i == 1) {
            zzaVarZzc.zza(zzct.ACCURATE);
        } else if (i == 2) {
            zzaVarZzc.zza(zzct.SELFIE);
        }
        int i2 = zzfVar.zzb;
        if (i2 == 0) {
            zzaVarZzc.zza(zzcp.NO_LANDMARK);
        } else if (i2 == 1) {
            zzaVarZzc.zza(zzcp.ALL_LANDMARKS);
        } else if (i2 == 2) {
            zzaVarZzc.zza(zzcp.CONTOUR_LANDMARKS);
        }
        int i3 = zzfVar.zzc;
        if (i3 == 0) {
            zzaVarZzc.zza(zzck.NO_CLASSIFICATION);
        } else if (i3 == 1) {
            zzaVarZzc.zza(zzck.ALL_CLASSIFICATIONS);
        }
        zzci.zzd zzdVar = (zzci.zzd) ((zzjb) zzaVarZzc.zzf());
        this.zzd = zzdVar;
        this.zzb = faceDetectorV2Jni.zza(zzdVar, context2.getAssets());
        this.zzc = dynamiteClearcutLogger;
        this.zze = faceDetectorV2Jni;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final boolean zza(int i) throws RemoteException {
        return true;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final void zza() throws RemoteException {
        this.zze.zza(this.zzb);
    }

    private static zzcc zzb(int i) {
        if (i == 0) {
            return zzcc.ROTATION_0;
        }
        if (i == 1) {
            return zzcc.ROTATION_270;
        }
        if (i == 2) {
            return zzcc.ROTATION_180;
        }
        if (i == 3) {
            return zzcc.ROTATION_90;
        }
        throw new IllegalArgumentException("Unsupported rotation degree.");
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, zzs zzsVar) throws RemoteException {
        zzci.zzc zzcVarZza;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            ByteBuffer byteBuffer = (ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper);
            zzcb.zza zzaVarZza = zzcb.zza().zza(zzsVar.zza).zzb(zzsVar.zzb).zza(zzb(zzsVar.zze)).zza(zzbw.NV21);
            if (zzsVar.zzd > 0) {
                zzaVarZza.zza(zzsVar.zzd * 1000);
            }
            zzcb zzcbVar = (zzcb) ((zzjb) zzaVarZza.zzf());
            if (byteBuffer.isDirect()) {
                zzcVarZza = this.zze.zza(this.zzb, byteBuffer, zzcbVar);
            } else if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
                zzcVarZza = this.zze.zza(this.zzb, byteBuffer.array(), zzcbVar);
            } else {
                byte[] bArr = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr);
                zzcVarZza = this.zze.zza(this.zzb, bArr, zzcbVar);
            }
            FaceParcel[] faceParcelArrZza = zza(zzcVarZza, this.zzd.zzb(), this.zzd.zza());
            zza(this.zzc, zzsVar, faceParcelArrZza, null, SystemClock.elapsedRealtime() - jElapsedRealtime);
            return faceParcelArrZza;
        } catch (Exception e) {
            zza.m2360e("NativeFaceDetectorV2Imp", "Native face detection v2 failed", e);
            return new FaceParcel[0];
        }
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i, int i2, int i3, int i4, int i5, int i6, zzs zzsVar) {
        zzci.zzc zzcVarZza;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            ByteBuffer byteBuffer = (ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper);
            ByteBuffer byteBuffer2 = (ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper2);
            ByteBuffer byteBuffer3 = (ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper3);
            zzcb.zza zzaVarZza = zzcb.zza().zza(zzsVar.zza).zzb(zzsVar.zzb).zza(zzb(zzsVar.zze));
            if (zzsVar.zzd > 0) {
                zzaVarZza.zza(zzsVar.zzd * 1000);
            }
            zzcb zzcbVar = (zzcb) ((zzjb) zzaVarZza.zzf());
            if (byteBuffer.isDirect()) {
                zzcVarZza = this.zze.zza(this.zzb, byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3, i4, i5, i6, zzcbVar);
            } else if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
                byte[] bArrArray = null;
                byte[] bArrArray2 = (byteBuffer2 != null && byteBuffer2.hasArray() && byteBuffer2.arrayOffset() == 0) ? byteBuffer2.array() : null;
                if (byteBuffer3 != null && byteBuffer3.hasArray() && byteBuffer3.arrayOffset() == 0) {
                    bArrArray = byteBuffer3.array();
                }
                zzcVarZza = this.zze.zza(this.zzb, byteBuffer.array(), bArrArray2, bArrArray, i, i2, i3, i4, i5, i6, zzcbVar);
            } else {
                byte[] bArr = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr);
                byte[] bArr2 = new byte[byteBuffer2.remaining()];
                byteBuffer.get(bArr);
                byte[] bArr3 = new byte[byteBuffer3.remaining()];
                byteBuffer.get(bArr);
                zzcVarZza = this.zze.zza(this.zzb, bArr, bArr2, bArr3, i, i2, i3, i4, i5, i6, zzcbVar);
            }
            FaceParcel[] faceParcelArrZza = zza(zzcVarZza, this.zzd.zzb(), this.zzd.zza());
            zza(this.zzc, zzsVar, faceParcelArrZza, null, SystemClock.elapsedRealtime() - jElapsedRealtime);
            return faceParcelArrZza;
        } catch (Exception e) {
            zza.m2360e("NativeFaceDetectorV2Imp", "Native face detection v2 failed", e);
            return new FaceParcel[0];
        }
    }

    private static FaceParcel[] zza(zzci.zzc zzcVar, zzck zzckVar, zzcp zzcpVar) {
        float f;
        float f2;
        float f3;
        zznb zznbVar;
        LandmarkParcel[] landmarkParcelArr;
        com.google.android.gms.vision.face.internal.client.zza[] zzaVarArr;
        int i;
        zznb zznbVar2;
        List<zzmt.zze> list;
        int i2;
        zzcp zzcpVar2 = zzcpVar;
        zznb zznbVarZza = zzcVar.zza();
        FaceParcel[] faceParcelArr = new FaceParcel[zznbVarZza.zzb()];
        int i3 = 0;
        while (i3 < zznbVarZza.zzb()) {
            zzmt zzmtVarZza = zznbVarZza.zza(i3);
            zzmt.zzb zzbVarZzb = zzmtVarZza.zzb();
            float fZza = zzbVarZzb.zza() + ((zzbVarZzb.zzc() - zzbVarZzb.zza()) / 2.0f);
            float fZzb = zzbVarZzb.zzb() + ((zzbVarZzb.zzd() - zzbVarZzb.zzb()) / 2.0f);
            float fZzc = zzbVarZzb.zzc() - zzbVarZzb.zza();
            float fZzd = zzbVarZzb.zzd() - zzbVarZzb.zzb();
            if (zzckVar == zzck.ALL_CLASSIFICATIONS) {
                float fZzb2 = -1.0f;
                float fZzb3 = -1.0f;
                float fZzb4 = -1.0f;
                for (zzmt.zza zzaVar : zzmtVarZza.zzu()) {
                    if (zzaVar.zza().equals("joy")) {
                        fZzb4 = zzaVar.zzb();
                    } else if (zzaVar.zza().equals("left_eye_closed")) {
                        fZzb2 = 1.0f - zzaVar.zzb();
                    } else if (zzaVar.zza().equals("right_eye_closed")) {
                        fZzb3 = 1.0f - zzaVar.zzb();
                    }
                }
                f = fZzb2;
                f2 = fZzb3;
                f3 = fZzb4;
            } else {
                f = -1.0f;
                f2 = -1.0f;
                f3 = -1.0f;
            }
            float fZze = zzmtVarZza.zzd() ? zzmtVarZza.zze() : -1.0f;
            if (zzcpVar2 == zzcp.ALL_LANDMARKS) {
                List<zzmt.zze> listZzc = zzmtVarZza.zzc();
                ArrayList arrayList = new ArrayList();
                int i4 = 0;
                while (i4 < listZzc.size()) {
                    zzmt.zze zzeVar = listZzc.get(i4);
                    zzmt.zze.zzb zzbVarZzc = zzeVar.zzc();
                    switch (C23061.zza[zzbVarZzc.ordinal()]) {
                        case 1:
                            zznbVar2 = zznbVarZza;
                            list = listZzc;
                            i2 = 4;
                            break;
                        case 2:
                            zznbVar2 = zznbVarZza;
                            list = listZzc;
                            i2 = 10;
                            break;
                        case 3:
                            zznbVar2 = zznbVarZza;
                            list = listZzc;
                            i2 = 6;
                            break;
                        case 4:
                            zznbVar2 = zznbVarZza;
                            list = listZzc;
                            i2 = 0;
                            break;
                        case 5:
                            zznbVar2 = zznbVarZza;
                            list = listZzc;
                            i2 = 5;
                            break;
                        case 6:
                            zznbVar2 = zznbVarZza;
                            list = listZzc;
                            i2 = 11;
                            break;
                        case 7:
                            zznbVar2 = zznbVarZza;
                            list = listZzc;
                            i2 = 3;
                            break;
                        case 8:
                            zznbVar2 = zznbVarZza;
                            list = listZzc;
                            i2 = 9;
                            break;
                        case 9:
                            zznbVar2 = zznbVarZza;
                            list = listZzc;
                            i2 = 1;
                            break;
                        case 10:
                            zznbVar2 = zznbVarZza;
                            list = listZzc;
                            i2 = 7;
                            break;
                        case 11:
                            zznbVar2 = zznbVarZza;
                            list = listZzc;
                            i2 = 2;
                            break;
                        case 12:
                            zznbVar2 = zznbVarZza;
                            list = listZzc;
                            i2 = 8;
                            break;
                        default:
                            GmsLogger gmsLogger = zza;
                            String strValueOf = String.valueOf(zzbVarZzc);
                            zznbVar2 = zznbVarZza;
                            list = listZzc;
                            gmsLogger.m2357d("NativeFaceDetectorV2Imp", new StringBuilder(String.valueOf(strValueOf).length() + 23).append("Unknown landmark type: ").append(strValueOf).toString());
                            i2 = -1;
                            break;
                    }
                    if (i2 >= 0) {
                        arrayList.add(new LandmarkParcel(-1, zzeVar.zza(), zzeVar.zzb(), i2));
                    }
                    i4++;
                    listZzc = list;
                    zznbVarZza = zznbVar2;
                }
                zznbVar = zznbVarZza;
                landmarkParcelArr = (LandmarkParcel[]) arrayList.toArray(new LandmarkParcel[0]);
            } else {
                zznbVar = zznbVarZza;
                landmarkParcelArr = new LandmarkParcel[0];
            }
            if (zzcpVar2 == zzcp.CONTOUR_LANDMARKS) {
                List list2 = (List) zzmtVarZza.zzb((zzim) zzci.zza);
                com.google.android.gms.vision.face.internal.client.zza[] zzaVarArr2 = new com.google.android.gms.vision.face.internal.client.zza[list2.size()];
                int i5 = 0;
                while (i5 < list2.size()) {
                    zzci.zzb zzbVar = (zzci.zzb) list2.get(i5);
                    PointF[] pointFArr = new PointF[zzbVar.zzc()];
                    int i6 = 0;
                    while (i6 < zzbVar.zzc()) {
                        zzci.zzb.C5978zzb c5978zzb = zzbVar.zzb().get(i6);
                        pointFArr[i6] = new PointF(c5978zzb.zza(), c5978zzb.zzb());
                        i6++;
                        list2 = list2;
                    }
                    List list3 = list2;
                    zzci.zzb.zzc zzcVarZza = zzbVar.zza();
                    switch (C23061.zzb[zzcVarZza.ordinal()]) {
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
                            zza.m2359e("NativeFaceDetectorV2Imp", new StringBuilder(33).append("Unknown contour type: ").append(zzcVarZza.zza()).toString());
                            i = -1;
                            break;
                    }
                    zzaVarArr2[i5] = new com.google.android.gms.vision.face.internal.client.zza(pointFArr, i);
                    i5++;
                    list2 = list3;
                }
                zzaVarArr = zzaVarArr2;
            } else {
                zzaVarArr = new com.google.android.gms.vision.face.internal.client.zza[0];
            }
            faceParcelArr[i3] = new FaceParcel(3, (int) zzmtVarZza.zzv(), fZza, fZzb, fZzc, fZzd, zzmtVarZza.zzs(), -zzmtVarZza.zzf(), zzmtVarZza.zzt(), landmarkParcelArr, f, f2, f3, zzaVarArr, fZze);
            i3++;
            zzcpVar2 = zzcpVar;
            zznbVarZza = zznbVar;
        }
        return faceParcelArr;
    }

    private static void zza(DynamiteClearcutLogger dynamiteClearcutLogger, zzs zzsVar, FaceParcel[] faceParcelArr, String str, long j) {
        if (zzsVar.zzc <= 2 || faceParcelArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (FaceParcel faceParcel : faceParcelArr) {
                zzfi.zzm zzmVar = (zzfi.zzm) ((zzjb) zzfi.zzm.zza().zza((int) (faceParcel.zzb - (faceParcel.zzd / 2.0f))).zzb((int) (faceParcel.zzc - (faceParcel.zze / 2.0f))).zzf());
                zzfi.zzm zzmVar2 = (zzfi.zzm) ((zzjb) zzfi.zzm.zza().zza((int) (faceParcel.zzb + (faceParcel.zzd / 2.0f))).zzb((int) (faceParcel.zzc - (faceParcel.zze / 2.0f))).zzf());
                zzfi.zzm zzmVar3 = (zzfi.zzm) ((zzjb) zzfi.zzm.zza().zza((int) (faceParcel.zzb + (faceParcel.zzd / 2.0f))).zzb((int) (faceParcel.zzc + (faceParcel.zze / 2.0f))).zzf());
                arrayList.add((zzfi.zzn) ((zzjb) zzfi.zzn.zza().zza(zzfi.zzd.zza().zza(zzmVar).zza(zzmVar2).zza(zzmVar3).zza((zzfi.zzm) ((zzjb) zzfi.zzm.zza().zza((int) (faceParcel.zzb - (faceParcel.zzd / 2.0f))).zzb((int) (faceParcel.zzc + (faceParcel.zze / 2.0f))).zzf()))).zza(faceParcel.zza).zza((zzfi.zzh) ((zzjb) zzfi.zzh.zza().zzd(faceParcel.zzf).zze(faceParcel.zzg).zzf(faceParcel.zzh).zza(faceParcel.zzj).zzb(faceParcel.zzk).zzc(faceParcel.zzl).zzf())).zzf()));
            }
            dynamiteClearcutLogger.zza(3, LogUtils.zza(j, faceParcelArr.length, null, OptionalModuleUtils.FACE, arrayList, zzsVar));
        }
    }
}
