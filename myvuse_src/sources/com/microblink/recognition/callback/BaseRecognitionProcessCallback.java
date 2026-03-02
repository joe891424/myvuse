package com.microblink.recognition.callback;

import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.blinkid.secured.IlIlIlllIl;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.geometry.Rectangle;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.metadata.detection.quad.DisplayableQuadDetection;
import com.microblink.recognition.NativeRecognizerWrapper;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseRecognitionProcessCallback {

    @Deprecated
    static final int DETECTION_METADATA = 3;

    @Deprecated
    static final int GLARE_METADATA = 5;

    @Deprecated
    static final int IMAGE_METADATA = 0;
    private static final int NO_MIRROR = 0;

    @Deprecated
    static final int OCR_METADATA = 2;

    @Deprecated
    static final int PARTIAL_RESULT_METADATA = 4;

    @Deprecated
    static final int TEXT_METADATA = 1;
    private static final int XY_MIRROR = 3;
    private static final int X_MIRROR = 1;
    private static final int Y_MIRROR = 2;
    NativeCancelDelegate mCancelDelegate = new NativeCancelDelegate();
    private IlIlIlllIl mLicenseInformationCallback;
    MetadataCallbacks mMetadataCallbacks;
    long mNativeContext;
    NativeRecognizerWrapper mNativeRecognizerWrapper;

    static {
        IIIlIllllI.IllIIIllII();
    }

    BaseRecognitionProcessCallback(IlIlIlllIl ilIlIlllIl, Rectangle rectangle, RecognizerBundle.RecognitionDebugMode recognitionDebugMode) {
        this.mNativeContext = 0L;
        this.mLicenseInformationCallback = ilIlIlllIl;
        this.mNativeContext = nativeConstruct(recognitionDebugMode.ordinal());
        setScanningRegion(rectangle);
        setVisiblePartRelativeDestination(null);
    }

    private native long nativeConstruct(int i);

    private static native void nativeDestruct(long j);

    private static native void nativeSetBaseCallbacks(long j, boolean z, boolean z2, boolean z3, boolean z4, boolean z5);

    private static native void nativeSetMirrorType(long j, int i);

    private static native void nativeSetScanningRegion(long j, float f, float f2, float f3, float f4);

    private static native void nativeSetVisiblePartRelativeDestination(long j, float f, float f2, float f3, float f4);

    public void dispose() {
        long j = this.mNativeContext;
        if (j != 0) {
            nativeDestruct(j);
            this.mNativeContext = 0L;
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        dispose();
    }

    public NativeCancelDelegate getCancelDelegate() {
        return this.mCancelDelegate;
    }

    public long getNativeContext() {
        return this.mNativeContext;
    }

    public void onDebugText(String str) {
        this.mMetadataCallbacks.getDebugTextCallback().onDebugText(str);
    }

    public void onDetectionFailed() {
        this.mMetadataCallbacks.getFailedDetectionCallback().onDetectionFailed();
    }

    public void onImage(long j) {
        Image imageBuildImageFromNativeContext = ImageBuilder.buildImageFromNativeContext(j, false, null);
        this.mMetadataCallbacks.getDebugImageCallback().onImageAvailable(imageBuildImageFromNativeContext);
        imageBuildImageFromNativeContext.dispose();
    }

    public void onLicenseInfo(String str) {
        this.mLicenseInformationCallback.onLicenseInformation(str);
    }

    public void onPointsDetection(int i, float[] fArr, float[] fArr2, int i2) {
        this.mMetadataCallbacks.getPointsDetectionCallback().onPointsDetection(new DisplayablePointsDetection(i, fArr, fArr2, i2));
    }

    public void onQuadDetection(int i, float[] fArr, float[] fArr2) {
        this.mMetadataCallbacks.getQuadDetectionCallback().onQuadDetection(new DisplayableQuadDetection(i, fArr, fArr2));
    }

    public void setCameraOptions(boolean z, boolean z2) {
        if (z) {
            nativeSetMirrorType(this.mNativeContext, z2 ? 1 : 2);
        } else if (z2) {
            nativeSetMirrorType(this.mNativeContext, 3);
        } else {
            nativeSetMirrorType(this.mNativeContext, 0);
        }
    }

    public void setMetadataCallbacks(MetadataCallbacks metadataCallbacks) {
        this.mMetadataCallbacks = metadataCallbacks;
        nativeSetBaseCallbacks(this.mNativeContext, metadataCallbacks.getFailedDetectionCallback() != null, metadataCallbacks.getPointsDetectionCallback() != null, this.mMetadataCallbacks.getQuadDetectionCallback() != null, this.mMetadataCallbacks.getDebugTextCallback() != null, this.mMetadataCallbacks.getDebugImageCallback() != null);
    }

    public void setNativeRecognizerWrapper(NativeRecognizerWrapper nativeRecognizerWrapper) {
        this.mNativeRecognizerWrapper = nativeRecognizerWrapper;
    }

    public void setScanningRegion(Rectangle rectangle) {
        if (rectangle == null) {
            rectangle = Rectangle.getDefaultROI();
        }
        nativeSetScanningRegion(this.mNativeContext, rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    public void setVisiblePartRelativeDestination(Rectangle rectangle) {
        if (rectangle == null) {
            rectangle = Rectangle.getDefaultROI();
        }
        nativeSetVisiblePartRelativeDestination(this.mNativeContext, rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }
}
