package com.google.android.gms.vision.face;

import android.content.res.AssetManager;
import android.os.RemoteException;
import com.google.android.gms.internal.vision.zzcb;
import com.google.android.gms.internal.vision.zzci;
import com.google.android.gms.internal.vision.zzio;
import com.google.android.gms.internal.vision.zzjk;
import com.google.android.gms.vision.C2304L;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public class FaceDetectorV2Jni {
    private final zzio zza;

    public FaceDetectorV2Jni() {
        zzio zzioVarZza = zzio.zza();
        this.zza = zzioVarZza;
        zzioVarZza.zza(zzci.zza);
    }

    private native void closeDetectorJni(long j);

    private native byte[] detectFacesImageByteArrayJni(long j, byte[] bArr, byte[] bArr2);

    private native byte[] detectFacesImageByteArrayMultiPlanesJni(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr4);

    private native byte[] detectFacesImageByteBufferJni(long j, ByteBuffer byteBuffer, byte[] bArr);

    private native byte[] detectFacesImageByteBufferMultiPlanesJni(long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr);

    private native long initDetectorJni(byte[] bArr, AssetManager assetManager);

    public final long zza(zzci.zzd zzdVar, AssetManager assetManager) {
        C2304L.m2397v("%s initialize.start()", "FaceDetectorV2Jni");
        long jInitDetectorJni = initDetectorJni(zzdVar.zzh(), assetManager);
        C2304L.m2397v("%s initialize.end()", "FaceDetectorV2Jni");
        return jInitDetectorJni;
    }

    public final zzci.zzc zza(long j, ByteBuffer byteBuffer, zzcb zzcbVar) throws zzjk, RemoteException {
        C2304L.m2397v("%s detectFacesImageByteBuffer.start()", "FaceDetectorV2Jni");
        zzci.zzc zzcVarZza = null;
        try {
            byte[] bArrDetectFacesImageByteBufferJni = detectFacesImageByteBufferJni(j, byteBuffer, zzcbVar.zzh());
            if (bArrDetectFacesImageByteBufferJni != null && bArrDetectFacesImageByteBufferJni.length > 0) {
                zzcVarZza = zzci.zzc.zza(bArrDetectFacesImageByteBufferJni, this.zza);
            }
        } catch (zzjk e) {
            C2304L.m2394e("%s detectFacesImageByteBuffer failed to parse result: %s", "FaceDetectorV2Jni", e.getMessage());
        }
        C2304L.m2397v("%s detectFacesImageByteBuffer.end()", "FaceDetectorV2Jni");
        return zzcVarZza;
    }

    public final zzci.zzc zza(long j, byte[] bArr, zzcb zzcbVar) throws zzjk, RemoteException {
        C2304L.m2397v("%s detectFacesImageByteArray.start()", "FaceDetectorV2Jni");
        zzci.zzc zzcVarZza = null;
        try {
            byte[] bArrDetectFacesImageByteArrayJni = detectFacesImageByteArrayJni(j, bArr, zzcbVar.zzh());
            if (bArrDetectFacesImageByteArrayJni != null && bArrDetectFacesImageByteArrayJni.length > 0) {
                zzcVarZza = zzci.zzc.zza(bArrDetectFacesImageByteArrayJni, this.zza);
            }
        } catch (zzjk e) {
            C2304L.m2394e("%s detectFacesImageByteArray failed to parse result: %s", "FaceDetectorV2Jni", e.getMessage());
        }
        C2304L.m2397v("%s detectFacesImageByteArray.end()", "FaceDetectorV2Jni");
        return zzcVarZza;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.vision.zzci.zzc zza(long r17, java.nio.ByteBuffer r19, java.nio.ByteBuffer r20, java.nio.ByteBuffer r21, int r22, int r23, int r24, int r25, int r26, int r27, com.google.android.gms.internal.vision.zzcb r28) throws com.google.android.gms.internal.vision.zzjk {
        /*
            r16 = this;
            java.lang.String r1 = "FaceDetectorV2Jni"
            java.lang.Object[] r0 = new java.lang.Object[]{r1}
            java.lang.String r2 = "%s detectFacesImageByteBufferMultiPlanes.start()"
            com.google.android.gms.vision.C2304L.m2397v(r2, r0)
            r2 = 0
            byte[] r15 = r28.zzh()     // Catch: com.google.android.gms.internal.vision.zzjk -> L3e
            r3 = r16
            r4 = r17
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r14 = r27
            byte[] r0 = r3.detectFacesImageByteBufferMultiPlanesJni(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch: com.google.android.gms.internal.vision.zzjk -> L3e
            if (r0 == 0) goto L3b
            int r3 = r0.length     // Catch: com.google.android.gms.internal.vision.zzjk -> L3e
            if (r3 <= 0) goto L3b
            r3 = r16
            com.google.android.gms.internal.vision.zzio r4 = r3.zza     // Catch: com.google.android.gms.internal.vision.zzjk -> L39
            com.google.android.gms.internal.vision.zzci$zzc r0 = com.google.android.gms.internal.vision.zzci.zzc.zza(r0, r4)     // Catch: com.google.android.gms.internal.vision.zzjk -> L39
            r2 = r0
            goto L4e
        L39:
            r0 = move-exception
            goto L41
        L3b:
            r3 = r16
            goto L4e
        L3e:
            r0 = move-exception
            r3 = r16
        L41:
            java.lang.String r0 = r0.getMessage()
            java.lang.Object[] r0 = new java.lang.Object[]{r1, r0}
            java.lang.String r4 = "%s detectFacesImageByteBufferMultiPlanes failed to parse result: %s"
            com.google.android.gms.vision.C2304L.m2394e(r4, r0)
        L4e:
            java.lang.String r0 = "%s detectFacesImageByteBuffer.end()"
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            com.google.android.gms.vision.C2304L.m2397v(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.face.FaceDetectorV2Jni.zza(long, java.nio.ByteBuffer, java.nio.ByteBuffer, java.nio.ByteBuffer, int, int, int, int, int, int, com.google.android.gms.internal.vision.zzcb):com.google.android.gms.internal.vision.zzci$zzc");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.vision.zzci.zzc zza(long r17, byte[] r19, byte[] r20, byte[] r21, int r22, int r23, int r24, int r25, int r26, int r27, com.google.android.gms.internal.vision.zzcb r28) throws com.google.android.gms.internal.vision.zzjk {
        /*
            r16 = this;
            java.lang.String r1 = "FaceDetectorV2Jni"
            java.lang.Object[] r0 = new java.lang.Object[]{r1}
            java.lang.String r2 = "%s detectFacesImageByteArrayMultiPlanes.start()"
            com.google.android.gms.vision.C2304L.m2397v(r2, r0)
            r2 = 0
            byte[] r15 = r28.zzh()     // Catch: com.google.android.gms.internal.vision.zzjk -> L3e
            r3 = r16
            r4 = r17
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r14 = r27
            byte[] r0 = r3.detectFacesImageByteArrayMultiPlanesJni(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch: com.google.android.gms.internal.vision.zzjk -> L3e
            if (r0 == 0) goto L3b
            int r3 = r0.length     // Catch: com.google.android.gms.internal.vision.zzjk -> L3e
            if (r3 <= 0) goto L3b
            r3 = r16
            com.google.android.gms.internal.vision.zzio r4 = r3.zza     // Catch: com.google.android.gms.internal.vision.zzjk -> L39
            com.google.android.gms.internal.vision.zzci$zzc r0 = com.google.android.gms.internal.vision.zzci.zzc.zza(r0, r4)     // Catch: com.google.android.gms.internal.vision.zzjk -> L39
            r2 = r0
            goto L4e
        L39:
            r0 = move-exception
            goto L41
        L3b:
            r3 = r16
            goto L4e
        L3e:
            r0 = move-exception
            r3 = r16
        L41:
            java.lang.String r0 = r0.getMessage()
            java.lang.Object[] r0 = new java.lang.Object[]{r1, r0}
            java.lang.String r4 = "%s detectFacesImageByteArrayMultiPlanes failed to parse result: %s"
            com.google.android.gms.vision.C2304L.m2394e(r4, r0)
        L4e:
            java.lang.String r0 = "%s detectFacesImageByteArrayMultiPlanes.end()"
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            com.google.android.gms.vision.C2304L.m2397v(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.face.FaceDetectorV2Jni.zza(long, byte[], byte[], byte[], int, int, int, int, int, int, com.google.android.gms.internal.vision.zzcb):com.google.android.gms.internal.vision.zzci$zzc");
    }

    public final void zza(long j) {
        C2304L.m2397v("%s closeDetector.start()", "FaceDetectorV2Jni");
        closeDetectorJni(j);
        C2304L.m2397v("%s closeDetector.end()", "FaceDetectorV2Jni");
    }
}
