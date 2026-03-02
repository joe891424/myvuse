package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.util.SizeF;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;
import androidx.core.util.Preconditions;
import com.facebook.imagepipeline.common.RotationOptions;

/* JADX INFO: loaded from: classes.dex */
final class PreviewTransformation {
    private static final PreviewView.ScaleType DEFAULT_SCALE_TYPE = PreviewView.ScaleType.FILL_CENTER;
    private static final int FLOAT_NUMBER_PER_VERTEX = 2;
    private static final String TAG = "PreviewTransform";
    private boolean mIsFrontCamera;
    private int mPreviewRotationDegrees;
    private Size mResolution;
    private PreviewView.ScaleType mScaleType = DEFAULT_SCALE_TYPE;
    private Rect mSurfaceCropRect;
    private int mTargetRotation;

    PreviewTransformation() {
    }

    void setTransformationInfo(SurfaceRequest.TransformationInfo transformationInfo, Size resolution, boolean isFrontCamera) {
        Logger.m1137d(TAG, "Transformation info set: " + transformationInfo + " " + resolution + " " + isFrontCamera);
        this.mSurfaceCropRect = transformationInfo.getCropRect();
        this.mPreviewRotationDegrees = transformationInfo.getRotationDegrees();
        this.mTargetRotation = transformationInfo.getTargetRotation();
        this.mResolution = resolution;
        this.mIsFrontCamera = isFrontCamera;
    }

    Matrix getTextureViewCorrectionMatrix() {
        Preconditions.checkState(isTransformationInfoReady());
        Matrix matrix = new Matrix();
        float[] fArrSizeToVertices = sizeToVertices(this.mResolution);
        matrix.setPolyToPoly(fArrSizeToVertices, 0, createRotatedVertices(fArrSizeToVertices, -rotationValueToRotationDegrees(this.mTargetRotation)), 0, 4);
        return matrix;
    }

    void transformView(Size previewViewSize, int layoutDirection, View preview) {
        if (isTransformationInfoReady()) {
            if (preview instanceof TextureView) {
                ((TextureView) preview).setTransform(getTextureViewCorrectionMatrix());
            } else {
                Display display = preview.getDisplay();
                if (display != null && display.getRotation() != this.mTargetRotation) {
                    Logger.m1139e(TAG, "Non-display rotation not supported with SurfaceView / PERFORMANCE mode.");
                }
            }
            RectF transformedSurfaceRect = getTransformedSurfaceRect(previewViewSize, layoutDirection);
            preview.setPivotX(0.0f);
            preview.setPivotY(0.0f);
            preview.setScaleX(transformedSurfaceRect.width() / this.mResolution.getWidth());
            preview.setScaleY(transformedSurfaceRect.height() / this.mResolution.getHeight());
            preview.setTranslationX(transformedSurfaceRect.left - preview.getLeft());
            preview.setTranslationY(transformedSurfaceRect.top - preview.getTop());
        }
    }

    void setScaleType(PreviewView.ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    PreviewView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    private RectF getTransformedSurfaceRect(Size previewViewSize, int layoutDirection) {
        Preconditions.checkState(isTransformationInfoReady());
        Matrix surfaceToPreviewViewMatrix = getSurfaceToPreviewViewMatrix(previewViewSize, layoutDirection);
        float[] fArrSizeToVertices = sizeToVertices(this.mResolution);
        surfaceToPreviewViewMatrix.mapPoints(fArrSizeToVertices);
        return verticesToRect(fArrSizeToVertices);
    }

    private Matrix getSurfaceToPreviewViewMatrix(Size previewViewSize, int layoutDirection) {
        float[] fArrRectToVertices;
        Preconditions.checkState(isTransformationInfoReady());
        Matrix matrix = new Matrix();
        if (isCropRectAspectRatioMatchPreviewView(previewViewSize)) {
            fArrRectToVertices = sizeToVertices(previewViewSize);
        } else {
            fArrRectToVertices = rectToVertices(getPreviewViewCropRectForMismatchedAspectRatios(previewViewSize, layoutDirection));
        }
        matrix.setPolyToPoly(rectToVertices(new RectF(this.mSurfaceCropRect)), 0, createRotatedVertices(fArrRectToVertices, this.mPreviewRotationDegrees), 0, 4);
        if (this.mIsFrontCamera) {
            if (is90or270(this.mPreviewRotationDegrees)) {
                matrix.preScale(1.0f, -1.0f, this.mSurfaceCropRect.centerX(), this.mSurfaceCropRect.centerY());
            } else {
                matrix.preScale(-1.0f, 1.0f, this.mSurfaceCropRect.centerX(), this.mSurfaceCropRect.centerY());
            }
        }
        return matrix;
    }

    RectF getPreviewViewCropRectForMismatchedAspectRatios(Size previewViewSize, int layoutDirection) {
        RectF rectF = new RectF(0.0f, 0.0f, previewViewSize.getWidth(), previewViewSize.getHeight());
        SizeF rotatedCropRectSize = getRotatedCropRectSize();
        RectF rectF2 = new RectF(0.0f, 0.0f, rotatedCropRectSize.getWidth(), rotatedCropRectSize.getHeight());
        Matrix matrix = new Matrix();
        setMatrixRectToRect(matrix, rectF2, rectF, this.mScaleType);
        matrix.mapRect(rectF2);
        return layoutDirection == 1 ? flipHorizontally(rectF2, previewViewSize.getWidth() / 2.0f) : rectF2;
    }

    /* JADX INFO: renamed from: androidx.camera.view.PreviewTransformation$1 */
    static /* synthetic */ class C05041 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$view$PreviewView$ScaleType;

        static {
            int[] iArr = new int[PreviewView.ScaleType.values().length];
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType = iArr;
            try {
                iArr[PreviewView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static void setMatrixRectToRect(Matrix matrix, RectF source, RectF destination, PreviewView.ScaleType scaleType) {
        Matrix.ScaleToFit scaleToFit;
        switch (C05041.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[scaleType.ordinal()]) {
            case 1:
            case 2:
                scaleToFit = Matrix.ScaleToFit.CENTER;
                break;
            case 3:
            case 4:
                scaleToFit = Matrix.ScaleToFit.END;
                break;
            case 5:
            case 6:
                scaleToFit = Matrix.ScaleToFit.START;
                break;
            default:
                Logger.m1139e(TAG, "Unexpected crop rect: " + scaleType);
                scaleToFit = Matrix.ScaleToFit.FILL;
                break;
        }
        if (scaleType == PreviewView.ScaleType.FIT_CENTER || scaleType == PreviewView.ScaleType.FIT_START || scaleType == PreviewView.ScaleType.FIT_END) {
            matrix.setRectToRect(source, destination, scaleToFit);
        } else {
            matrix.setRectToRect(destination, source, scaleToFit);
            matrix.invert(matrix);
        }
    }

    private static RectF flipHorizontally(RectF original, float flipLineX) {
        float f = flipLineX + flipLineX;
        return new RectF(f - original.right, original.top, f - original.left, original.bottom);
    }

    private SizeF getRotatedCropRectSize() {
        Preconditions.checkNotNull(this.mSurfaceCropRect);
        if (is90or270(this.mPreviewRotationDegrees)) {
            return new SizeF(this.mSurfaceCropRect.height(), this.mSurfaceCropRect.width());
        }
        return new SizeF(this.mSurfaceCropRect.width(), this.mSurfaceCropRect.height());
    }

    boolean isCropRectAspectRatioMatchPreviewView(Size previewViewSize) {
        float width = previewViewSize.getWidth() / previewViewSize.getHeight();
        SizeF rotatedCropRectSize = getRotatedCropRectSize();
        return width >= (rotatedCropRectSize.getWidth() - 0.5f) / (rotatedCropRectSize.getHeight() + 0.5f) && width <= (rotatedCropRectSize.getWidth() + 0.5f) / (rotatedCropRectSize.getHeight() - 0.5f);
    }

    Bitmap createTransformedBitmap(Bitmap original, Size previewViewSize, int layoutDirection) {
        if (!isTransformationInfoReady()) {
            return original;
        }
        Matrix textureViewCorrectionMatrix = getTextureViewCorrectionMatrix();
        RectF transformedSurfaceRect = getTransformedSurfaceRect(previewViewSize, layoutDirection);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(previewViewSize.getWidth(), previewViewSize.getHeight(), original.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        matrix.postConcat(textureViewCorrectionMatrix);
        matrix.postScale(transformedSurfaceRect.width() / this.mResolution.getWidth(), transformedSurfaceRect.height() / this.mResolution.getHeight());
        matrix.postTranslate(transformedSurfaceRect.left, transformedSurfaceRect.top);
        canvas.drawBitmap(original, matrix, new Paint(7));
        return bitmapCreateBitmap;
    }

    Matrix getPreviewViewToNormalizedSurfaceMatrix(Size previewViewSize, int layoutDirection) {
        if (!isTransformationInfoReady()) {
            return null;
        }
        Matrix matrix = new Matrix();
        getSurfaceToPreviewViewMatrix(previewViewSize, layoutDirection).invert(matrix);
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(new RectF(0.0f, 0.0f, this.mResolution.getWidth(), this.mResolution.getHeight()), new RectF(0.0f, 0.0f, 1.0f, 1.0f), Matrix.ScaleToFit.FILL);
        matrix.postConcat(matrix2);
        return matrix;
    }

    static int rotationValueToRotationDegrees(int rotationValue) {
        if (rotationValue == 0) {
            return 0;
        }
        if (rotationValue == 1) {
            return 90;
        }
        if (rotationValue == 2) {
            return RotationOptions.ROTATE_180;
        }
        if (rotationValue == 3) {
            return RotationOptions.ROTATE_270;
        }
        throw new IllegalStateException("Unexpected rotation value " + rotationValue);
    }

    private static boolean is90or270(int rotationDegrees) {
        if (rotationDegrees == 90 || rotationDegrees == 270) {
            return true;
        }
        if (rotationDegrees == 0 || rotationDegrees == 180) {
            return false;
        }
        throw new IllegalArgumentException("Invalid rotation degrees: " + rotationDegrees);
    }

    static float[] sizeToVertices(Size size) {
        return new float[]{0.0f, 0.0f, size.getWidth(), 0.0f, size.getWidth(), size.getHeight(), 0.0f, size.getHeight()};
    }

    private static float[] rectToVertices(RectF rectF) {
        return new float[]{rectF.left, rectF.top, rectF.right, rectF.top, rectF.right, rectF.bottom, rectF.left, rectF.bottom};
    }

    private static RectF verticesToRect(float[] vertices) {
        return new RectF(min(vertices[0], vertices[2], vertices[4], vertices[6]), min(vertices[1], vertices[3], vertices[5], vertices[7]), max(vertices[0], vertices[2], vertices[4], vertices[6]), max(vertices[1], vertices[3], vertices[5], vertices[7]));
    }

    private static float max(float value1, float value2, float value3, float value4) {
        return Math.max(Math.max(value1, value2), Math.max(value3, value4));
    }

    private static float min(float value1, float value2, float value3, float value4) {
        return Math.min(Math.min(value1, value2), Math.min(value3, value4));
    }

    private boolean isTransformationInfoReady() {
        return (this.mSurfaceCropRect == null || this.mResolution == null) ? false : true;
    }

    private static float[] createRotatedVertices(float[] original, int rotationDegrees) {
        float[] fArr = new float[original.length];
        int i = ((-rotationDegrees) / 90) * 2;
        for (int i2 = 0; i2 < original.length; i2++) {
            int length = (i2 + i) % original.length;
            if (length < 0) {
                length += original.length;
            }
            fArr[length] = original[i2];
        }
        return fArr;
    }
}
