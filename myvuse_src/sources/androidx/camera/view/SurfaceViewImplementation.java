package androidx.camera.view;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewViewImplementation;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

/* JADX INFO: loaded from: classes.dex */
final class SurfaceViewImplementation extends PreviewViewImplementation {
    private static final String TAG = "SurfaceViewImpl";
    private PreviewViewImplementation.OnSurfaceNotInUseListener mOnSurfaceNotInUseListener;
    final SurfaceRequestCallback mSurfaceRequestCallback;
    SurfaceView mSurfaceView;

    @Override // androidx.camera.view.PreviewViewImplementation
    void onAttachedToWindow() {
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    void onDetachedFromWindow() {
    }

    SurfaceViewImplementation(FrameLayout parent, PreviewTransformation previewTransform) {
        super(parent, previewTransform);
        this.mSurfaceRequestCallback = new SurfaceRequestCallback();
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    void onSurfaceRequested(final SurfaceRequest surfaceRequest, PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener) {
        this.mResolution = surfaceRequest.getResolution();
        this.mOnSurfaceNotInUseListener = onSurfaceNotInUseListener;
        initializePreview();
        surfaceRequest.addRequestCancellationListener(ContextCompat.getMainExecutor(this.mSurfaceView.getContext()), new Runnable() { // from class: androidx.camera.view.SurfaceViewImplementation$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.notifySurfaceNotInUse();
            }
        });
        this.mSurfaceView.post(new Runnable() { // from class: androidx.camera.view.SurfaceViewImplementation$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1162x6305943b(surfaceRequest);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onSurfaceRequested$0$androidx-camera-view-SurfaceViewImplementation */
    /* synthetic */ void m1162x6305943b(SurfaceRequest surfaceRequest) {
        this.mSurfaceRequestCallback.setSurfaceRequest(surfaceRequest);
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    void initializePreview() {
        Preconditions.checkNotNull(this.mParent);
        Preconditions.checkNotNull(this.mResolution);
        SurfaceView surfaceView = new SurfaceView(this.mParent.getContext());
        this.mSurfaceView = surfaceView;
        surfaceView.setLayoutParams(new FrameLayout.LayoutParams(this.mResolution.getWidth(), this.mResolution.getHeight()));
        this.mParent.removeAllViews();
        this.mParent.addView(this.mSurfaceView);
        this.mSurfaceView.getHolder().addCallback(this.mSurfaceRequestCallback);
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    View getPreview() {
        return this.mSurfaceView;
    }

    void notifySurfaceNotInUse() {
        PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener = this.mOnSurfaceNotInUseListener;
        if (onSurfaceNotInUseListener != null) {
            onSurfaceNotInUseListener.onSurfaceNotInUse();
            this.mOnSurfaceNotInUseListener = null;
        }
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    Bitmap getPreviewBitmap() {
        SurfaceView surfaceView = this.mSurfaceView;
        if (surfaceView == null || surfaceView.getHolder().getSurface() == null || !this.mSurfaceView.getHolder().getSurface().isValid()) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.mSurfaceView.getWidth(), this.mSurfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        PixelCopy.request(this.mSurfaceView, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: androidx.camera.view.SurfaceViewImplementation$$ExternalSyntheticLambda2
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                SurfaceViewImplementation.lambda$getPreviewBitmap$1(i);
            }
        }, this.mSurfaceView.getHandler());
        return bitmapCreateBitmap;
    }

    static /* synthetic */ void lambda$getPreviewBitmap$1(int i) {
        if (i == 0) {
            Logger.m1137d(TAG, "PreviewView.SurfaceViewImplementation.getBitmap() succeeded");
        } else {
            Logger.m1139e(TAG, "PreviewView.SurfaceViewImplementation.getBitmap() failed with error " + i);
        }
    }

    class SurfaceRequestCallback implements SurfaceHolder.Callback {
        private Size mCurrentSurfaceSize;
        private SurfaceRequest mSurfaceRequest;
        private Size mTargetSize;
        private boolean mWasSurfaceProvided = false;

        SurfaceRequestCallback() {
        }

        void setSurfaceRequest(SurfaceRequest surfaceRequest) {
            cancelPreviousRequest();
            this.mSurfaceRequest = surfaceRequest;
            Size resolution = surfaceRequest.getResolution();
            this.mTargetSize = resolution;
            this.mWasSurfaceProvided = false;
            if (tryToComplete()) {
                return;
            }
            Logger.m1137d(SurfaceViewImplementation.TAG, "Wait for new Surface creation.");
            SurfaceViewImplementation.this.mSurfaceView.getHolder().setFixedSize(resolution.getWidth(), resolution.getHeight());
        }

        private boolean tryToComplete() {
            Surface surface = SurfaceViewImplementation.this.mSurfaceView.getHolder().getSurface();
            if (!canProvideSurface()) {
                return false;
            }
            Logger.m1137d(SurfaceViewImplementation.TAG, "Surface set on Preview.");
            this.mSurfaceRequest.provideSurface(surface, ContextCompat.getMainExecutor(SurfaceViewImplementation.this.mSurfaceView.getContext()), new Consumer() { // from class: androidx.camera.view.SurfaceViewImplementation$SurfaceRequestCallback$$ExternalSyntheticLambda0
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.m1163x982c86c5((SurfaceRequest.Result) obj);
                }
            });
            this.mWasSurfaceProvided = true;
            SurfaceViewImplementation.this.onSurfaceProvided();
            return true;
        }

        /* JADX INFO: renamed from: lambda$tryToComplete$0$androidx-camera-view-SurfaceViewImplementation$SurfaceRequestCallback */
        /* synthetic */ void m1163x982c86c5(SurfaceRequest.Result result) {
            Logger.m1137d(SurfaceViewImplementation.TAG, "Safe to release surface.");
            SurfaceViewImplementation.this.notifySurfaceNotInUse();
        }

        private boolean canProvideSurface() {
            Size size;
            return (this.mWasSurfaceProvided || this.mSurfaceRequest == null || (size = this.mTargetSize) == null || !size.equals(this.mCurrentSurfaceSize)) ? false : true;
        }

        private void cancelPreviousRequest() {
            if (this.mSurfaceRequest != null) {
                Logger.m1137d(SurfaceViewImplementation.TAG, "Request canceled: " + this.mSurfaceRequest);
                this.mSurfaceRequest.willNotProvideSurface();
            }
        }

        private void invalidateSurface() {
            if (this.mSurfaceRequest != null) {
                Logger.m1137d(SurfaceViewImplementation.TAG, "Surface invalidated " + this.mSurfaceRequest);
                this.mSurfaceRequest.getDeferrableSurface().close();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Logger.m1137d(SurfaceViewImplementation.TAG, "Surface created.");
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {
            Logger.m1137d(SurfaceViewImplementation.TAG, "Surface changed. Size: " + width + EllipticCurveJsonWebKey.X_MEMBER_NAME + height);
            this.mCurrentSurfaceSize = new Size(width, height);
            tryToComplete();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Logger.m1137d(SurfaceViewImplementation.TAG, "Surface destroyed.");
            if (this.mWasSurfaceProvided) {
                invalidateSurface();
            } else {
                cancelPreviousRequest();
            }
            this.mWasSurfaceProvided = false;
            this.mSurfaceRequest = null;
            this.mCurrentSurfaceSize = null;
            this.mTargetSize = null;
        }
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    ListenableFuture<Void> waitForNextFrame() {
        return Futures.immediateFuture(null);
    }
}
