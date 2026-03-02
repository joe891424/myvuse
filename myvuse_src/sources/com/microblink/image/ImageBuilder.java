package com.microblink.image;

import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.geometry.Rectangle;
import com.microblink.hardware.orientation.Orientation;
import java.nio.ByteBuffer;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class ImageBuilder {
    static {
        IIIlIllllI.llIIlIlIIl();
    }

    public static Image buildImageFromCamera1NV21Frame(byte[] bArr, int i, int i2, Orientation orientation, Rectangle rectangle) {
        int bitsPerPixel = ((i * i2) * android.graphics.ImageFormat.getBitsPerPixel(17)) / 8;
        if (bArr.length != bitsPerPixel) {
            throw new IllegalArgumentException("Wrong size of imageBuffer! For image size " + i + EllipticCurveJsonWebKey.X_MEMBER_NAME + i2 + ", the expected buffer size is " + Integer.toString(bitsPerPixel));
        }
        if (orientation == null || orientation == Orientation.ORIENTATION_UNKNOWN) {
            throw new IllegalArgumentException("Image orientation cannot be null nor unknown");
        }
        if (rectangle == null) {
            rectangle = Rectangle.getDefaultROI();
        }
        if (!rectangle.isRelative()) {
            throw new IllegalArgumentException("Scanning region must be given in relative coordinates, i.e. following must hold true: x + width <= 1.f && y + height <= 1.f");
        }
        long jBuildNativeImageFromCamera1Buffer = buildNativeImageFromCamera1Buffer(i, i2, bArr, orientation.intValue(), rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        if (jBuildNativeImageFromCamera1Buffer != 0) {
            return buildImageFromNativeContext(jBuildNativeImageFromCamera1Buffer, true, bArr);
        }
        throw new RuntimeException("Failed to create native image. Please check log for details.");
    }

    public static Image buildImageFromCamera2Image(android.media.Image image, Orientation orientation, Rectangle rectangle) {
        if (image.getFormat() != 35) {
            throw new IllegalArgumentException("Camera2 image must be in YUV_420_888 format. Other formats are not supported!");
        }
        if (orientation == null || orientation == Orientation.ORIENTATION_UNKNOWN) {
            throw new IllegalArgumentException("Image orientation cannot be null nor unknown");
        }
        Rectangle defaultROI = rectangle == null ? Rectangle.getDefaultROI() : rectangle;
        if (!defaultROI.isRelative()) {
            throw new IllegalArgumentException("Scanning region must be given in relative coordinates, i.e. following must hold true: x + width <= 1.f && y + height <= 1.f");
        }
        long jBuildNativeImageFromCamera2Image = buildNativeImageFromCamera2Image(image.getWidth(), image.getHeight(), orientation.intValue(), defaultROI.getX(), defaultROI.getY(), defaultROI.getWidth(), defaultROI.getHeight(), image.getPlanes()[0].getBuffer(), image.getPlanes()[0].getRowStride(), image.getPlanes()[0].getPixelStride(), image.getPlanes()[1].getBuffer(), image.getPlanes()[1].getRowStride(), image.getPlanes()[1].getPixelStride(), image.getPlanes()[2].getBuffer(), image.getPlanes()[2].getRowStride(), image.getPlanes()[2].getPixelStride());
        if (jBuildNativeImageFromCamera2Image != 0) {
            return buildImageFromNativeContext(jBuildNativeImageFromCamera2Image, true, image);
        }
        throw new RuntimeException("Failed to create native image. Please check log for details.");
    }

    public static Image buildImageFromJpegBytes(byte[] bArr, int i) {
        if (bArr == null) {
            throw new RuntimeException("Failed to create native image. Jpeg bytes null.");
        }
        long jBuildNativeImageFromJpegBytes = buildNativeImageFromJpegBytes(bArr, bArr.length, i);
        if (jBuildNativeImageFromJpegBytes != 0) {
            return buildImageFromNativeContext(jBuildNativeImageFromJpegBytes, true, bArr);
        }
        throw new RuntimeException("Failed to create native image. Please check log for details.");
    }

    public static Image buildImageFromNativeContext(long j, boolean z, Object obj) {
        Image image = new Image(j, z);
        image.lllIlIlIIl = obj;
        return image;
    }

    private static native long buildNativeImageFromCamera1Buffer(int i, int i2, byte[] bArr, int i3, float f, float f2, float f3, float f4);

    private static native long buildNativeImageFromCamera2Image(int i, int i2, int i3, float f, float f2, float f3, float f4, ByteBuffer byteBuffer, int i4, int i5, ByteBuffer byteBuffer2, int i6, int i7, ByteBuffer byteBuffer3, int i8, int i9);

    private static native long buildNativeImageFromJpegBytes(byte[] bArr, int i, int i2);
}
