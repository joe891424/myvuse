package com.google.mlkit.vision.face.internal;

import android.content.Context;
import android.media.Image;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.vision.dynamite.face.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_face.zzby;
import com.google.android.gms.internal.mlkit_vision_face.zzbz;
import com.google.android.gms.internal.mlkit_vision_face.zzca;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;
import com.google.android.gms.internal.mlkit_vision_face.zzgv;
import com.google.android.gms.internal.mlkit_vision_face.zzhb;
import com.google.android.gms.internal.mlkit_vision_face.zzhc;
import com.google.android.gms.internal.mlkit_vision_face.zzhe;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzho;
import com.google.android.gms.internal.mlkit_vision_face.zziq;
import com.google.android.gms.internal.mlkit_vision_face.zziu;
import com.google.android.gms.internal.mlkit_vision_face.zziv;
import com.google.android.gms.internal.mlkit_vision_face.zziw;
import com.google.android.gms.internal.mlkit_vision_face.zzje;
import com.google.android.gms.internal.mlkit_vision_face.zzjf;
import com.google.android.gms.internal.mlkit_vision_face.zzjg;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.BitmapInStreamingChecker;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzg extends MLTask<List<Face>, InputImage> {
    static final AtomicBoolean zza = new AtomicBoolean(true);
    private static final ImageUtils zzg = ImageUtils.getInstance();
    private final Context zzb;
    private final FaceDetectorOptions zzc;
    private final zziw zzd;
    private final zzjg zze;
    private final zza zzf;
    private FaceDetector zzh;
    private FaceDetector zzi;
    private com.google.android.gms.internal.mlkit_vision_face.zzh<Boolean> zzj;
    private final BitmapInStreamingChecker zzk;

    public zzg(Context context, FaceDetectorOptions faceDetectorOptions) {
        zziw zziwVarZza = zzje.zza("play-services-mlkit-face-detection");
        zzjg zzjgVarZza = zzjg.zza();
        this.zzj = com.google.android.gms.internal.mlkit_vision_face.zzh.zzc();
        this.zzk = new BitmapInStreamingChecker();
        Preconditions.checkNotNull(context, "Application context can not be null");
        Preconditions.checkNotNull(faceDetectorOptions, "FaceDetectorOptions can not be null");
        this.zzb = context;
        this.zzc = faceDetectorOptions;
        this.zzd = zziwVarZza;
        this.zze = zzjgVarZza;
        this.zzf = new zza(context, faceDetectorOptions);
    }

    static void zze(List<Face> list) {
        Iterator<Face> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().zzc(-1);
        }
    }

    static int zzf(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        StringBuilder sb = new StringBuilder(34);
        sb.append("Invalid landmark type: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    static int zzg(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        StringBuilder sb = new StringBuilder(40);
        sb.append("Invalid classification type: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    private final synchronized void zzj(final zzhb zzhbVar, long j, final InputImage inputImage, final int i, final int i2) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zzd.zza(new zziv(this, jElapsedRealtime, zzhbVar, i, i2, inputImage) { // from class: com.google.mlkit.vision.face.internal.zze
            private final zzg zza;
            private final long zzb;
            private final zzhb zzc;
            private final int zzd;
            private final int zze;
            private final InputImage zzf;

            {
                this.zza = this;
                this.zzb = jElapsedRealtime;
                this.zzc = zzhbVar;
                this.zzd = i;
                this.zze = i2;
                this.zzf = inputImage;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zziv
            public final zziq zza() {
                return this.zza.zzi(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
            }
        }, zzhc.ON_DEVICE_FACE_DETECT);
        zzbz zzbzVar = new zzbz();
        zzbzVar.zza(zzhbVar);
        zzbzVar.zzb(Boolean.valueOf(zza.get()));
        ImageUtils imageUtils = zzg;
        zzbzVar.zzc(zzjf.zza(imageUtils.getMobileVisionImageFormat(inputImage), imageUtils.getMobileVisionImageSize(inputImage)));
        zzbzVar.zze(Integer.valueOf(i));
        zzbzVar.zzf(Integer.valueOf(i2));
        zzbzVar.zzd(zzh.zza(this.zzc));
        this.zzd.zzb(zzbzVar.zzg(), jElapsedRealtime, zzhc.AGGREGATED_ON_DEVICE_FACE_DETECTION, new zziu(this) { // from class: com.google.mlkit.vision.face.internal.zzf
            private final zzg zza;

            {
                this.zza = this;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.zziu
            public final zziq zza(Object obj, int i3, zzgi zzgiVar) {
                return this.zza.zzh((zzca) obj, i3, zzgiVar);
            }
        });
    }

    private static int zzk(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        StringBuilder sb = new StringBuilder(30);
        sb.append("Invalid mode type: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final synchronized void load() throws MlKitException {
        if (!this.zzj.zza()) {
            this.zzj = com.google.android.gms.internal.mlkit_vision_face.zzh.zzd(Boolean.valueOf(DynamiteModule.getLocalVersion(this.zzb, ModuleDescriptor.MODULE_ID) > 0));
        }
        if (this.zzc.zzb() == 2) {
            if (this.zzi == null) {
                this.zzi = new FaceDetector.Builder(this.zzb).setLandmarkType(2).setMode(2).setTrackingEnabled(false).setProminentFaceOnly(true).build();
            }
            if ((this.zzc.zza() == 2 || this.zzc.zzc() == 2 || this.zzc.zzd() == 2) && this.zzh == null) {
                this.zzh = new FaceDetector.Builder(this.zzb).setLandmarkType(zzf(this.zzc.zza())).setClassificationType(zzg(this.zzc.zzc())).setMode(zzk(this.zzc.zzd())).setMinFaceSize(this.zzc.zzf()).setTrackingEnabled(this.zzc.zze()).build();
            }
        } else if (this.zzh == null) {
            this.zzh = new FaceDetector.Builder(this.zzb).setLandmarkType(zzf(this.zzc.zza())).setClassificationType(zzg(this.zzc.zzc())).setMode(zzk(this.zzc.zzd())).setMinFaceSize(this.zzc.zzf()).setTrackingEnabled(this.zzc.zze()).build();
        }
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final synchronized void release() {
        FaceDetector faceDetector = this.zzh;
        if (faceDetector != null) {
            faceDetector.release();
            this.zzh = null;
        }
        FaceDetector faceDetector2 = this.zzi;
        if (faceDetector2 != null) {
            faceDetector2.release();
            this.zzi = null;
        }
        zza.set(true);
    }

    final synchronized List<Face> zzc(FaceDetector faceDetector, InputImage inputImage, long j) throws MlKitException {
        ArrayList arrayList;
        if (!faceDetector.isOperational()) {
            if (this.zzj.zzb(false).booleanValue()) {
                zzj(zzhb.UNKNOWN_ERROR, j, inputImage, 0, 0);
                throw new MlKitException("Loading local face module failed.", 14);
            }
            zzj(zzhb.MODEL_NOT_DOWNLOADED, j, inputImage, 0, 0);
            throw new MlKitException("Waiting for the face detection model to be downloaded. Please wait.", 14);
        }
        SparseArray<com.google.android.gms.vision.face.Face> sparseArrayDetect = faceDetector.detect(inputImage.getFormat() == 35 ? new Frame.Builder().setPlanes((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()), inputImage.getWidth(), inputImage.getHeight(), CommonConvertUtils.convertToAndroidImageFormat(inputImage.getFormat())).setRotation(CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees())).setTimestampMillis(SystemClock.elapsedRealtime()).build() : new Frame.Builder().setImageData((ByteBuffer) Preconditions.checkNotNull(inputImage.getFormat() == 17 ? inputImage.getByteBuffer() : ImageConvertUtils.getInstance().convertToNv21Buffer(inputImage, false)), inputImage.getWidth(), inputImage.getHeight(), 17).setRotation(CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees())).build());
        arrayList = new ArrayList();
        for (int i = 0; i < sparseArrayDetect.size(); i++) {
            arrayList.add(new Face(sparseArrayDetect.get(sparseArrayDetect.keyAt(i))));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0135 A[Catch: all -> 0x0155, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000f, B:9:0x0014, B:10:0x0026, B:11:0x0027, B:13:0x0031, B:15:0x003d, B:17:0x0042, B:19:0x0046, B:23:0x0052, B:24:0x0059, B:26:0x005c, B:52:0x012f, B:59:0x0143, B:58:0x013e, B:55:0x0135, B:29:0x0069, B:30:0x0070, B:31:0x0079, B:33:0x007f, B:34:0x008a, B:36:0x0090, B:38:0x009c, B:40:0x00a2, B:42:0x00b0, B:44:0x00fd, B:46:0x010b, B:49:0x011d, B:51:0x0128), top: B:65:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013e A[Catch: all -> 0x0155, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000f, B:9:0x0014, B:10:0x0026, B:11:0x0027, B:13:0x0031, B:15:0x003d, B:17:0x0042, B:19:0x0046, B:23:0x0052, B:24:0x0059, B:26:0x005c, B:52:0x012f, B:59:0x0143, B:58:0x013e, B:55:0x0135, B:29:0x0069, B:30:0x0070, B:31:0x0079, B:33:0x007f, B:34:0x008a, B:36:0x0090, B:38:0x009c, B:40:0x00a2, B:42:0x00b0, B:44:0x00fd, B:46:0x010b, B:49:0x011d, B:51:0x0128), top: B:65:0x0005 }] */
    @Override // com.google.mlkit.common.sdkinternal.MLTask
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.util.List<com.google.mlkit.vision.face.Face> run(com.google.mlkit.vision.common.InputImage r20) throws com.google.mlkit.common.MlKitException {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.face.internal.zzg.run(com.google.mlkit.vision.common.InputImage):java.util.List");
    }

    final /* synthetic */ zziq zzh(zzca zzcaVar, int i, zzgi zzgiVar) {
        zzhe zzheVar = new zzhe();
        zzheVar.zzc(this.zzj.zzb(false));
        zzby zzbyVar = new zzby();
        zzbyVar.zzb(Integer.valueOf(i));
        zzbyVar.zza(zzcaVar);
        zzbyVar.zzc(zzgiVar);
        zzheVar.zze(zzbyVar.zzd());
        return zziq.zzc(zzheVar);
    }

    final /* synthetic */ zziq zzi(long j, zzhb zzhbVar, int i, int i2, InputImage inputImage) {
        zzhn zzhnVar = new zzhn();
        zzgv zzgvVar = new zzgv();
        zzgvVar.zza(Long.valueOf(j));
        zzgvVar.zzb(zzhbVar);
        zzgvVar.zzc(Boolean.valueOf(zza.get()));
        zzgvVar.zzd(true);
        zzgvVar.zze(true);
        zzhnVar.zza(zzgvVar.zzf());
        zzhnVar.zzc(zzh.zza(this.zzc));
        zzhnVar.zzd(Integer.valueOf(i));
        zzhnVar.zze(Integer.valueOf(i2));
        ImageUtils imageUtils = zzg;
        zzhnVar.zzb(zzjf.zza(imageUtils.getMobileVisionImageFormat(inputImage), imageUtils.getMobileVisionImageSize(inputImage)));
        zzho zzhoVarZzf = zzhnVar.zzf();
        zzhe zzheVar = new zzhe();
        zzheVar.zzc(this.zzj.zzb(false));
        zzheVar.zzd(zzhoVarZzf);
        return zziq.zzc(zzheVar);
    }
}
