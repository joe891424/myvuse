package com.horcrux.svg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

/* JADX INFO: loaded from: classes2.dex */
class ImageView extends RenderableView {
    private String mAlign;

    /* JADX INFO: renamed from: mH */
    private SVGLength f3979mH;
    private int mImageHeight;
    private int mImageWidth;
    private final AtomicBoolean mLoading;
    private int mMeetOrSlice;

    /* JADX INFO: renamed from: mW */
    private SVGLength f3980mW;

    /* JADX INFO: renamed from: mX */
    private SVGLength f3981mX;

    /* JADX INFO: renamed from: mY */
    private SVGLength f3982mY;
    private String uriString;

    public ImageView(ReactContext reactContext) {
        super(reactContext);
        this.mLoading = new AtomicBoolean(false);
    }

    @ReactProp(name = EllipticCurveJsonWebKey.X_MEMBER_NAME)
    public void setX(Dynamic dynamic) {
        this.f3981mX = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = EllipticCurveJsonWebKey.Y_MEMBER_NAME)
    public void setY(Dynamic dynamic) {
        this.f3982mY = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.f3980mW = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.f3979mH = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = ReactVideoViewManager.PROP_SRC)
    public void setSrc(@Nullable ReadableMap readableMap) {
        if (readableMap != null) {
            String string = readableMap.getString("uri");
            this.uriString = string;
            if (string == null || string.isEmpty()) {
                return;
            }
            if (readableMap.hasKey("width") && readableMap.hasKey("height")) {
                this.mImageWidth = readableMap.getInt("width");
                this.mImageHeight = readableMap.getInt("height");
            } else {
                this.mImageWidth = 0;
                this.mImageHeight = 0;
            }
            if (Uri.parse(this.uriString).getScheme() == null) {
                ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(this.mContext, this.uriString);
            }
        }
    }

    @ReactProp(name = "align")
    public void setAlign(String str) {
        this.mAlign = str;
        invalidate();
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(int i) {
        this.mMeetOrSlice = i;
        invalidate();
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    void draw(Canvas canvas, Paint paint, float f) {
        if (this.mLoading.get()) {
            return;
        }
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        ImageRequest imageRequestFromUri = ImageRequest.fromUri(new ImageSource(this.mContext, this.uriString).getUri());
        if (imagePipeline.isInBitmapMemoryCache(imageRequestFromUri)) {
            tryRenderFromBitmapCache(imagePipeline, imageRequestFromUri, canvas, paint, f * this.mOpacity);
        } else {
            loadBitmap(imagePipeline, imageRequestFromUri);
        }
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        this.mPath = new Path();
        this.mPath.addRect(getRect(), Path.Direction.CW);
        return this.mPath;
    }

    private void loadBitmap(ImagePipeline imagePipeline, ImageRequest imageRequest) {
        this.mLoading.set(true);
        imagePipeline.fetchDecodedImage(imageRequest, this.mContext).subscribe(new BaseBitmapDataSubscriber() { // from class: com.horcrux.svg.ImageView.1
            @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
            public void onNewResultImpl(Bitmap bitmap) {
                ImageView.this.mLoading.set(false);
                SvgView svgView = ImageView.this.getSvgView();
                if (svgView != null) {
                    svgView.invalidate();
                }
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                ImageView.this.mLoading.set(false);
                FLog.m1320w(ReactConstants.TAG, dataSource.getFailureCause(), "RNSVG: fetchDecodedImage failed!", new Object[0]);
            }
        }, UiThreadImmediateExecutorService.getInstance());
    }

    @Nonnull
    private RectF getRect() {
        double dRelativeOnWidth = relativeOnWidth(this.f3981mX);
        double dRelativeOnHeight = relativeOnHeight(this.f3982mY);
        double dRelativeOnWidth2 = relativeOnWidth(this.f3980mW);
        double dRelativeOnHeight2 = relativeOnHeight(this.f3979mH);
        if (dRelativeOnWidth2 == 0.0d) {
            dRelativeOnWidth2 = this.mImageWidth * this.mScale;
        }
        if (dRelativeOnHeight2 == 0.0d) {
            dRelativeOnHeight2 = this.mImageHeight * this.mScale;
        }
        return new RectF((float) dRelativeOnWidth, (float) dRelativeOnHeight, (float) (dRelativeOnWidth + dRelativeOnWidth2), (float) (dRelativeOnHeight + dRelativeOnHeight2));
    }

    private void doRender(Canvas canvas, Paint paint, Bitmap bitmap, float f) {
        if (this.mImageWidth == 0 || this.mImageHeight == 0) {
            this.mImageWidth = bitmap.getWidth();
            this.mImageHeight = bitmap.getHeight();
        }
        RectF rect = getRect();
        RectF rectF = new RectF(0.0f, 0.0f, this.mImageWidth, this.mImageHeight);
        ViewBox.getTransform(rectF, rect, this.mAlign, this.mMeetOrSlice).mapRect(rectF);
        canvas.clipPath(getPath(canvas, paint));
        Path clipPath = getClipPath(canvas, paint);
        if (clipPath != null) {
            canvas.clipPath(clipPath);
        }
        Paint paint2 = new Paint();
        paint2.setAlpha((int) (f * 255.0f));
        canvas.drawBitmap(bitmap, (Rect) null, rectF, paint2);
        this.mCTM.mapRect(rectF);
        setClientRect(rectF);
    }

    private void tryRenderFromBitmapCache(ImagePipeline imagePipeline, ImageRequest imageRequest, Canvas canvas, Paint paint, float f) {
        DataSource<CloseableReference<CloseableImage>> dataSourceFetchImageFromBitmapCache = imagePipeline.fetchImageFromBitmapCache(imageRequest, this.mContext);
        try {
            try {
                CloseableReference<CloseableImage> result = dataSourceFetchImageFromBitmapCache.getResult();
                if (result == null) {
                    return;
                }
                try {
                    try {
                        CloseableImage closeableImage = result.get();
                        if (closeableImage instanceof CloseableBitmap) {
                            Bitmap underlyingBitmap = ((CloseableBitmap) closeableImage).getUnderlyingBitmap();
                            if (underlyingBitmap == null) {
                                return;
                            }
                            doRender(canvas, paint, underlyingBitmap, f);
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                } finally {
                    CloseableReference.closeSafely(result);
                }
                CloseableReference.closeSafely(result);
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        } finally {
            dataSourceFetchImageFromBitmapCache.close();
        }
    }
}
