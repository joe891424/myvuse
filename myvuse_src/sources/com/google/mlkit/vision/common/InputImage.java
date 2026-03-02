package com.google.mlkit.vision.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_common.zzgw;
import com.google.android.gms.internal.mlkit_vision_common.zzgy;
import com.google.mlkit.common.sdkinternal.MLTaskInput;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class InputImage implements MLTaskInput {
    public static final int IMAGE_FORMAT_BITMAP = -1;
    public static final int IMAGE_FORMAT_NV21 = 17;
    public static final int IMAGE_FORMAT_YUV_420_888 = 35;
    public static final int IMAGE_FORMAT_YV12 = 842094169;
    private volatile Bitmap zza;
    private volatile ByteBuffer zzb;
    private volatile zza zzc;
    private final int zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;

    /* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
    @Retention(RetentionPolicy.CLASS)
    public @interface ImageFormat {
    }

    private InputImage(Bitmap bitmap, int i) {
        this.zza = (Bitmap) Preconditions.checkNotNull(bitmap);
        this.zzd = bitmap.getWidth();
        this.zze = bitmap.getHeight();
        this.zzf = i;
        this.zzg = -1;
    }

    public static InputImage fromBitmap(Bitmap bitmap, int i) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(bitmap, i);
        zza(-1, 1, jElapsedRealtime, -1, -1, bitmap.getAllocationByteCount(), i);
        return inputImage;
    }

    public static InputImage fromByteArray(byte[] bArr, int i, int i2, int i3, int i4) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(ByteBuffer.wrap((byte[]) Preconditions.checkNotNull(bArr)), i, i2, i3, i4);
        zza(i4, 2, jElapsedRealtime, i2, i, bArr.length, i3);
        return inputImage;
    }

    public static InputImage fromByteBuffer(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(byteBuffer, i, i2, i3, i4);
        zza(i4, 3, jElapsedRealtime, i2, i, byteBuffer.limit(), i3);
        return inputImage;
    }

    public static InputImage fromFilePath(Context context, Uri uri) throws IOException {
        Preconditions.checkNotNull(context, "Please provide a valid Context");
        Preconditions.checkNotNull(uri, "Please provide a valid imageUri");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Bitmap bitmapZza = ImageUtils.getInstance().zza(context.getContentResolver(), uri);
        InputImage inputImage = new InputImage(bitmapZza, 0);
        zza(-1, 4, jElapsedRealtime, -1, -1, bitmapZza.getAllocationByteCount(), 0);
        return inputImage;
    }

    public static InputImage fromMediaImage(Image image, int i) {
        int i2;
        boolean z;
        InputImage inputImage;
        int iLimit;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Preconditions.checkNotNull(image, "Please provide a valid image");
        boolean z2 = true;
        if (i == 0 || i == 90 || i == 180) {
            i2 = i;
            z = true;
        } else if (i == 270) {
            z = true;
            i2 = 270;
        } else {
            i2 = i;
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid rotation. Only 0, 90, 180, 270 are supported currently.");
        if (image.getFormat() != 256 && image.getFormat() != 35) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "Only JPEG and YUV_420_888 are supported now");
        Image.Plane[] planes = image.getPlanes();
        if (image.getFormat() == 256) {
            iLimit = image.getPlanes()[0].getBuffer().limit();
            inputImage = new InputImage(ImageConvertUtils.getInstance().convertJpegToUpRightBitmap(image, i2), 0);
        } else {
            for (Image.Plane plane : planes) {
                if (plane.getBuffer() != null) {
                    plane.getBuffer().rewind();
                }
            }
            inputImage = new InputImage(image, image.getWidth(), image.getHeight(), i2);
            iLimit = (image.getPlanes()[0].getBuffer().limit() * 3) / 2;
        }
        int i3 = iLimit;
        InputImage inputImage2 = inputImage;
        zza(image.getFormat(), 5, jElapsedRealtime, image.getHeight(), image.getWidth(), i3, i2);
        return inputImage2;
    }

    private static void zza(int i, int i2, long j, int i3, int i4, int i5, int i6) {
        zzgy.zza(zzgw.zza("vision-common"), i, i2, j, i3, i4, i5, i6);
    }

    public Bitmap getBitmapInternal() {
        return this.zza;
    }

    public ByteBuffer getByteBuffer() {
        return this.zzb;
    }

    public int getFormat() {
        return this.zzg;
    }

    public int getHeight() {
        return this.zze;
    }

    public Image getMediaImage() {
        if (this.zzc == null) {
            return null;
        }
        return this.zzc.zza();
    }

    public Image.Plane[] getPlanes() {
        if (this.zzc == null) {
            return null;
        }
        return this.zzc.zzb();
    }

    public int getRotationDegrees() {
        return this.zzf;
    }

    public int getWidth() {
        return this.zzd;
    }

    private InputImage(Image image, int i, int i2, int i3) {
        Preconditions.checkNotNull(image);
        this.zzc = new zza(image);
        this.zzd = i;
        this.zze = i2;
        this.zzf = i3;
        this.zzg = 35;
    }

    private InputImage(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        boolean z = true;
        if (i4 != 842094169) {
            if (i4 == 17) {
                i4 = 17;
            } else {
                z = false;
            }
        }
        Preconditions.checkArgument(z);
        this.zzb = (ByteBuffer) Preconditions.checkNotNull(byteBuffer);
        byteBuffer.rewind();
        this.zzd = i;
        this.zze = i2;
        this.zzf = i3;
        this.zzg = i4;
    }
}
