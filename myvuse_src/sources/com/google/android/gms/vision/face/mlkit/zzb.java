package com.google.android.gms.vision.face.mlkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.Image;
import android.os.Build;
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
import com.google.android.gms.internal.vision.zzfz;
import com.google.android.gms.internal.vision.zzgb;
import com.google.android.gms.internal.vision.zzgd;
import com.google.android.gms.internal.vision.zzgf;
import com.google.android.gms.internal.vision.zzgg;
import com.google.android.gms.internal.vision.zzgn;
import com.google.android.gms.internal.vision.zzim;
import com.google.android.gms.internal.vision.zzjb;
import com.google.android.gms.internal.vision.zzjk;
import com.google.android.gms.internal.vision.zzmt;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.internal.vision.zzw;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.clearcut.LogUtils;
import com.google.android.gms.vision.face.FaceDetectorV2Jni;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzb extends zzgg {
    private static final GmsLogger zza = new GmsLogger("FaceDetector", "");
    private final Context zzb;
    private final zzci.zzd zzc;
    private final FaceDetectorV2Jni zzd;
    private final DynamiteClearcutLogger zze;
    private long zzf = -1;

    zzb(Context context, zzgd zzgdVar, FaceDetectorV2Jni faceDetectorV2Jni, DynamiteClearcutLogger dynamiteClearcutLogger) {
        this.zzb = context;
        boolean z = false;
        boolean z2 = zzgdVar.zzd() == 2;
        zzci.zzg zzgVar = (zzci.zzg) ((zzjb) zzci.zzg.zza().zza("models").zzf());
        zzci.zzd.zza zzaVarZza = zzci.zzd.zzc().zza(zzci.zze.zza().zza(zzgVar).zzb(zzgVar).zzc(zzgVar)).zza(zzci.zza.zza().zza(zzgVar).zzb(zzgVar)).zza(zzci.zzf.zza().zza(zzgVar).zzb(zzgVar).zzc(zzgVar).zzd(zzgVar)).zza(z2);
        if (!z2 && zzgdVar.zze()) {
            z = true;
        }
        zzci.zzd.zza zzaVarZzc = zzaVarZza.zzb(z).zza(zzgdVar.zzf()).zzc(true);
        if (z2) {
            zzaVarZzc.zza(zzct.SELFIE).zza(zzcp.CONTOUR_LANDMARKS);
        } else {
            int iZza = zzgdVar.zza();
            if (iZza == 1) {
                zzaVarZzc.zza(zzct.FAST);
            } else if (iZza == 2) {
                zzaVarZzc.zza(zzct.ACCURATE);
            }
            int iZzb = zzgdVar.zzb();
            if (iZzb == 1) {
                zzaVarZzc.zza(zzcp.NO_LANDMARK);
            } else if (iZzb == 2) {
                zzaVarZzc.zza(zzcp.ALL_LANDMARKS);
            }
            int iZzc = zzgdVar.zzc();
            if (iZzc == 1) {
                zzaVarZzc.zza(zzck.NO_CLASSIFICATION);
            } else if (iZzc == 2) {
                zzaVarZzc.zza(zzck.ALL_CLASSIFICATIONS);
            }
        }
        this.zzc = (zzci.zzd) ((zzjb) zzaVarZzc.zzf());
        this.zzd = faceDetectorV2Jni;
        this.zze = dynamiteClearcutLogger;
    }

    @Override // com.google.android.gms.internal.vision.zzgh
    public final void zza() {
        this.zzf = this.zzd.zza(this.zzc, this.zzb.getAssets());
    }

    @Override // com.google.android.gms.internal.vision.zzgh
    public final void zzb() {
        long j = this.zzf;
        if (j > 0) {
            this.zzd.zza(j);
            this.zzf = -1L;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzgh
    public final List<zzgf> zza(IObjectWrapper iObjectWrapper, zzfz zzfzVar) throws zzjk, RemoteException {
        List<zzgf> listZza;
        zzci.zzc zzcVarZza;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int iZza = zzfzVar.zza();
        if (iZza == -1) {
            listZza = zza(zzw.zza((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), true), zzfzVar, zzbw.NV21);
        } else if (iZza == 17) {
            listZza = zza((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzfzVar, zzbw.NV21);
        } else if (iZza == 35) {
            Image.Plane[] planes = ((Image) ObjectWrapper.unwrap(iObjectWrapper)).getPlanes();
            ByteBuffer buffer = planes[0].getBuffer();
            ByteBuffer buffer2 = planes[1].getBuffer();
            ByteBuffer buffer3 = planes[2].getBuffer();
            zzcb.zza zzaVarZza = zzcb.zza().zza(zzfzVar.zzb()).zzb(zzfzVar.zzc()).zza(zza(zzfzVar.zzd()));
            if (zzfzVar.zze() > 0) {
                zzaVarZza.zza(zzfzVar.zze() * 1000);
            }
            zzcb zzcbVar = (zzcb) ((zzjb) zzaVarZza.zzf());
            if (buffer.isDirect()) {
                zzcVarZza = this.zzd.zza(this.zzf, buffer, buffer2, buffer3, planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzcbVar);
            } else if (buffer.hasArray() && buffer.arrayOffset() == 0) {
                zzcVarZza = this.zzd.zza(this.zzf, buffer.array(), buffer2.array(), buffer3.array(), planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzcbVar);
            } else {
                byte[] bArr = new byte[buffer.remaining()];
                buffer.get(bArr);
                byte[] bArr2 = new byte[buffer2.remaining()];
                buffer.get(bArr);
                byte[] bArr3 = new byte[buffer3.remaining()];
                buffer.get(bArr);
                zzcVarZza = this.zzd.zza(this.zzf, bArr, bArr2, bArr3, planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzcbVar);
            }
            listZza = zzcVarZza != null ? zza(zzcVarZza) : new ArrayList<>();
        } else if (iZza == 842094169) {
            listZza = zza((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzfzVar, zzbw.YV12);
        } else {
            String string = new StringBuilder(55).append("Unsupported image format ").append(zzfzVar.zza()).append(" at API ").append(Build.VERSION.SDK_INT).toString();
            LogInstrumentation.m2728e("FaceDetector", string);
            throw com.google.android.gms.vision.internal.zza.zza(string);
        }
        DynamiteClearcutLogger dynamiteClearcutLogger = this.zze;
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        ArrayList arrayList = new ArrayList();
        for (zzgf zzgfVar : listZza) {
            Rect rectZzb = zzgfVar.zzb();
            arrayList.add((zzfi.zzn) ((zzjb) zzfi.zzn.zza().zza(zzgfVar.zza()).zza((zzfi.zzd) ((zzjb) zzfi.zzd.zza().zza(zzfi.zzm.zza().zza(rectZzb.left).zzb(rectZzb.top)).zza(zzfi.zzm.zza().zza(rectZzb.right).zzb(rectZzb.top)).zza(zzfi.zzm.zza().zza(rectZzb.right).zzb(rectZzb.bottom)).zza(zzfi.zzm.zza().zza(rectZzb.left).zzb(rectZzb.bottom)).zzf())).zza((zzfi.zzh) ((zzjb) zzfi.zzh.zza().zzf(zzgfVar.zze()).zzd(zzgfVar.zzd()).zze(-zzgfVar.zzc()).zza(zzgfVar.zzf()).zzb(zzgfVar.zzg()).zzc(zzgfVar.zzh()).zzf())).zzf()));
        }
        dynamiteClearcutLogger.zza(3, (zzfi.zzo) ((zzjb) LogUtils.zza(jElapsedRealtime2, listZza.size(), null, OptionalModuleUtils.FACE, arrayList, new zzs(zzfzVar.zzb(), zzfzVar.zzc(), 0, zzfzVar.zze(), zzfzVar.zzd())).zzl().zza(true).zzf()));
        return listZza;
    }

    private final List<zzgf> zza(ByteBuffer byteBuffer, zzfz zzfzVar, zzbw zzbwVar) throws zzjk, RemoteException {
        zzci.zzc zzcVarZza;
        zzcb.zza zzaVarZza = zzcb.zza().zza(zzfzVar.zzb()).zzb(zzfzVar.zzc()).zza(zza(zzfzVar.zzd())).zza(zzbwVar);
        if (zzfzVar.zze() > 0) {
            zzaVarZza.zza(zzfzVar.zze() * 1000);
        }
        zzcb zzcbVar = (zzcb) ((zzjb) zzaVarZza.zzf());
        if (byteBuffer.isDirect()) {
            zzcVarZza = this.zzd.zza(this.zzf, byteBuffer, zzcbVar);
        } else if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            zzcVarZza = this.zzd.zza(this.zzf, byteBuffer.array(), zzcbVar);
        } else {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            zzcVarZza = this.zzd.zza(this.zzf, bArr, zzcbVar);
        }
        return zzcVarZza != null ? zza(zzcVarZza) : new ArrayList();
    }

    private static zzcc zza(int i) {
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
        throw new IllegalArgumentException(new StringBuilder(40).append("Unsupported rotation degree: ").append(i).toString());
    }

    private final List<zzgf> zza(zzci.zzc zzcVar) {
        float f;
        float f2;
        float f3;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i;
        int i2;
        ArrayList arrayList3 = new ArrayList();
        for (zzmt zzmtVar : zzcVar.zza().zza()) {
            int i3 = -1;
            if (this.zzc.zzb() == zzck.ALL_CLASSIFICATIONS) {
                float fZzb = -1.0f;
                float fZzb2 = -1.0f;
                float fZzb3 = -1.0f;
                for (zzmt.zza zzaVar : zzmtVar.zzu()) {
                    String strZza = zzaVar.zza();
                    strZza.hashCode();
                    switch (strZza) {
                        case "left_eye_closed":
                            fZzb = 1.0f - zzaVar.zzb();
                            break;
                        case "right_eye_closed":
                            fZzb2 = 1.0f - zzaVar.zzb();
                            break;
                        case "joy":
                            fZzb3 = zzaVar.zzb();
                            break;
                    }
                }
                f = fZzb;
                f2 = fZzb2;
                f3 = fZzb3;
            } else {
                f = -1.0f;
                f2 = -1.0f;
                f3 = -1.0f;
            }
            if (this.zzc.zza() == zzcp.ALL_LANDMARKS) {
                List<zzmt.zze> listZzc = zzmtVar.zzc();
                ArrayList arrayList4 = new ArrayList();
                for (zzmt.zze zzeVar : listZzc) {
                    zzmt.zze.zzb zzbVarZzc = zzeVar.zzc();
                    switch (zza.zza[zzbVarZzc.ordinal()]) {
                        case 1:
                            i2 = 4;
                            break;
                        case 2:
                            i2 = 10;
                            break;
                        case 3:
                            i2 = 6;
                            break;
                        case 4:
                            i2 = 0;
                            break;
                        case 5:
                            i2 = 5;
                            break;
                        case 6:
                            i2 = 11;
                            break;
                        case 7:
                            i2 = 2;
                            break;
                        case 8:
                            i2 = 3;
                            break;
                        case 9:
                            i2 = 8;
                            break;
                        case 10:
                            i2 = 9;
                            break;
                        case 11:
                            i2 = 1;
                            break;
                        case 12:
                            i2 = 7;
                            break;
                        default:
                            GmsLogger gmsLogger = zza;
                            String strValueOf = String.valueOf(zzbVarZzc);
                            gmsLogger.m2357d("FaceDetector", new StringBuilder(String.valueOf(strValueOf).length() + 23).append("Unknown landmark type: ").append(strValueOf).toString());
                            i2 = -1;
                            break;
                    }
                    if (i2 >= 0) {
                        arrayList4.add(new zzgn(i2, new PointF(zzeVar.zza(), zzeVar.zzb())));
                    }
                }
                arrayList = arrayList4;
            } else {
                arrayList = new ArrayList();
            }
            if (this.zzc.zza() == zzcp.CONTOUR_LANDMARKS) {
                List<zzci.zzb> list = (List) zzmtVar.zzb((zzim) zzci.zza);
                ArrayList arrayList5 = new ArrayList();
                for (zzci.zzb zzbVar : list) {
                    zzci.zzb.zzc zzcVarZza = zzbVar.zza();
                    switch (zza.zzb[zzcVarZza.ordinal()]) {
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
                            zza.m2357d("FaceDetector", new StringBuilder(33).append("Unknown contour type: ").append(zzcVarZza.zza()).toString());
                            i = i3;
                            break;
                    }
                    if (i != i3) {
                        ArrayList arrayList6 = new ArrayList();
                        for (zzci.zzb.C5978zzb c5978zzb : zzbVar.zzb()) {
                            arrayList6.add(new PointF(c5978zzb.zza(), c5978zzb.zzb()));
                        }
                        arrayList5.add(new zzgb(i, arrayList6));
                        i3 = -1;
                    }
                }
                arrayList2 = arrayList5;
            } else {
                arrayList2 = new ArrayList();
            }
            zzmt.zzb zzbVarZzb = zzmtVar.zzb();
            arrayList3.add(new zzgf((int) zzmtVar.zzv(), new Rect((int) zzbVarZzb.zza(), (int) zzbVarZzb.zzb(), (int) zzbVarZzb.zzc(), (int) zzbVarZzb.zzd()), zzmtVar.zzf(), zzmtVar.zzs(), zzmtVar.zzt(), f, f2, f3, zzmtVar.zzd() ? zzmtVar.zze() : -1.0f, arrayList, arrayList2));
        }
        return arrayList3;
    }
}
