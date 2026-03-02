package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class ImageUtils {
    private static final GmsLogger zza = new GmsLogger("MLKitImageUtils", "");
    private static ImageUtils zzb = new ImageUtils();

    private ImageUtils() {
    }

    public static ImageUtils getInstance() {
        return zzb;
    }

    public IObjectWrapper getImageDataWrapper(InputImage inputImage) throws MlKitException {
        int format = inputImage.getFormat();
        if (format == -1) {
            return ObjectWrapper.wrap((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal()));
        }
        if (format != 17) {
            if (format == 35) {
                return ObjectWrapper.wrap(inputImage.getMediaImage());
            }
            if (format != 842094169) {
                int format2 = inputImage.getFormat();
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unsupported image format: ");
                sb.append(format2);
                throw new MlKitException(sb.toString(), 3);
            }
        }
        return ObjectWrapper.wrap((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()));
    }

    public int getMobileVisionImageFormat(InputImage inputImage) {
        return inputImage.getFormat();
    }

    public int getMobileVisionImageSize(InputImage inputImage) {
        if (inputImage.getFormat() == -1) {
            return ((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal())).getAllocationByteCount();
        }
        if (inputImage.getFormat() == 17 || inputImage.getFormat() == 842094169) {
            return ((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer())).limit();
        }
        if (inputImage.getFormat() != 35) {
            return 0;
        }
        return (((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()))[0].getBuffer().limit() * 3) / 2;
    }

    public Matrix getUprightRotationMatrix(int i, int i2, int i3) {
        if (i3 == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((-i) / 2.0f, (-i2) / 2.0f);
        matrix.postRotate(i3 * 90);
        int i4 = i3 % 2;
        int i5 = i4 != 0 ? i2 : i;
        if (i4 == 0) {
            i = i2;
        }
        matrix.postTranslate(i5 / 2.0f, i / 2.0f);
        return matrix;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069 A[Catch: FileNotFoundException -> 0x00c5, TryCatch #1 {FileNotFoundException -> 0x00c5, blocks: (B:3:0x0002, B:5:0x0014, B:30:0x0070, B:31:0x0085, B:42:0x00b6, B:44:0x00c0, B:33:0x008a, B:34:0x008e, B:35:0x0095, B:36:0x0099, B:37:0x00a0, B:38:0x00a4, B:40:0x00ab, B:29:0x0069, B:26:0x0042), top: B:52:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a A[Catch: FileNotFoundException -> 0x00c5, TryCatch #1 {FileNotFoundException -> 0x00c5, blocks: (B:3:0x0002, B:5:0x0014, B:30:0x0070, B:31:0x0085, B:42:0x00b6, B:44:0x00c0, B:33:0x008a, B:34:0x008e, B:35:0x0095, B:36:0x0099, B:37:0x00a0, B:38:0x00a4, B:40:0x00ab, B:29:0x0069, B:26:0x0042), top: B:52:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e A[Catch: FileNotFoundException -> 0x00c5, TryCatch #1 {FileNotFoundException -> 0x00c5, blocks: (B:3:0x0002, B:5:0x0014, B:30:0x0070, B:31:0x0085, B:42:0x00b6, B:44:0x00c0, B:33:0x008a, B:34:0x008e, B:35:0x0095, B:36:0x0099, B:37:0x00a0, B:38:0x00a4, B:40:0x00ab, B:29:0x0069, B:26:0x0042), top: B:52:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0095 A[Catch: FileNotFoundException -> 0x00c5, TryCatch #1 {FileNotFoundException -> 0x00c5, blocks: (B:3:0x0002, B:5:0x0014, B:30:0x0070, B:31:0x0085, B:42:0x00b6, B:44:0x00c0, B:33:0x008a, B:34:0x008e, B:35:0x0095, B:36:0x0099, B:37:0x00a0, B:38:0x00a4, B:40:0x00ab, B:29:0x0069, B:26:0x0042), top: B:52:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099 A[Catch: FileNotFoundException -> 0x00c5, TryCatch #1 {FileNotFoundException -> 0x00c5, blocks: (B:3:0x0002, B:5:0x0014, B:30:0x0070, B:31:0x0085, B:42:0x00b6, B:44:0x00c0, B:33:0x008a, B:34:0x008e, B:35:0x0095, B:36:0x0099, B:37:0x00a0, B:38:0x00a4, B:40:0x00ab, B:29:0x0069, B:26:0x0042), top: B:52:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a0 A[Catch: FileNotFoundException -> 0x00c5, TryCatch #1 {FileNotFoundException -> 0x00c5, blocks: (B:3:0x0002, B:5:0x0014, B:30:0x0070, B:31:0x0085, B:42:0x00b6, B:44:0x00c0, B:33:0x008a, B:34:0x008e, B:35:0x0095, B:36:0x0099, B:37:0x00a0, B:38:0x00a4, B:40:0x00ab, B:29:0x0069, B:26:0x0042), top: B:52:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a4 A[Catch: FileNotFoundException -> 0x00c5, TryCatch #1 {FileNotFoundException -> 0x00c5, blocks: (B:3:0x0002, B:5:0x0014, B:30:0x0070, B:31:0x0085, B:42:0x00b6, B:44:0x00c0, B:33:0x008a, B:34:0x008e, B:35:0x0095, B:36:0x0099, B:37:0x00a0, B:38:0x00a4, B:40:0x00ab, B:29:0x0069, B:26:0x0042), top: B:52:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab A[Catch: FileNotFoundException -> 0x00c5, TryCatch #1 {FileNotFoundException -> 0x00c5, blocks: (B:3:0x0002, B:5:0x0014, B:30:0x0070, B:31:0x0085, B:42:0x00b6, B:44:0x00c0, B:33:0x008a, B:34:0x008e, B:35:0x0095, B:36:0x0099, B:37:0x00a0, B:38:0x00a4, B:40:0x00ab, B:29:0x0069, B:26:0x0042), top: B:52:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap zza(android.content.ContentResolver r11, android.net.Uri r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.common.internal.ImageUtils.zza(android.content.ContentResolver, android.net.Uri):android.graphics.Bitmap");
    }
}
