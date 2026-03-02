package com.horcrux.svg;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Region;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.StandardCharsets;
import com.p035BV.LinearGradient.LinearGradientManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.annotation.Nonnull;
import org.jose4j.jwk.EllipticCurveJsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes2.dex */
class RNSVGRenderableManager extends ReactContextBaseJavaModule {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int EOF = -1;

    RNSVGRenderableManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNSVGRenderableManager";
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean isPointInFill(int i, ReadableMap readableMap) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return false;
        }
        float f = renderableViewByTag.mScale;
        return renderableViewByTag.hitTest(new float[]{((float) readableMap.getDouble(EllipticCurveJsonWebKey.X_MEMBER_NAME)) * f, ((float) readableMap.getDouble(EllipticCurveJsonWebKey.Y_MEMBER_NAME)) * f}) != -1;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean isPointInStroke(int i, ReadableMap readableMap) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return false;
        }
        try {
            renderableViewByTag.getPath(null, null);
            renderableViewByTag.initBounds();
            double d = renderableViewByTag.mScale;
            int i2 = (int) (readableMap.getDouble(EllipticCurveJsonWebKey.X_MEMBER_NAME) * d);
            int i3 = (int) (readableMap.getDouble(EllipticCurveJsonWebKey.Y_MEMBER_NAME) * d);
            Region region = renderableViewByTag.mStrokeRegion;
            return region != null && region.contains(i2, i3);
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return false;
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public float getTotalLength(int i) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return 0.0f;
        }
        try {
            return new PathMeasure(renderableViewByTag.getPath(null, null), false).getLength() / renderableViewByTag.mScale;
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return -1.0f;
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getPointAtLength(int i, ReadableMap readableMap) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        try {
            PathMeasure pathMeasure = new PathMeasure(renderableViewByTag.getPath(null, null), false);
            float f = (float) readableMap.getDouble("length");
            float f2 = renderableViewByTag.mScale;
            pathMeasure.getPosTan(Math.max(0.0f, Math.min(f, pathMeasure.getLength())), new float[2], new float[2]);
            double dAtan2 = Math.atan2(r0[1], r0[0]);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble(EllipticCurveJsonWebKey.X_MEMBER_NAME, r3[0] / f2);
            writableMapCreateMap.putDouble(EllipticCurveJsonWebKey.Y_MEMBER_NAME, r3[1] / f2);
            writableMapCreateMap.putDouble(LinearGradientManager.PROP_ANGLE, dAtan2);
            return writableMapCreateMap;
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return Arguments.createMap();
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getBBox(int i, ReadableMap readableMap) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        boolean z = readableMap.getBoolean("fill");
        boolean z2 = readableMap.getBoolean("stroke");
        boolean z3 = readableMap.getBoolean("markers");
        boolean z4 = readableMap.getBoolean("clipped");
        try {
            renderableViewByTag.getPath(null, null);
            float f = renderableViewByTag.mScale;
            renderableViewByTag.initBounds();
            RectF rectF = new RectF();
            RectF rectF2 = renderableViewByTag.mFillBounds;
            RectF rectF3 = renderableViewByTag.mStrokeBounds;
            RectF rectF4 = renderableViewByTag.mMarkerBounds;
            RectF rectF5 = renderableViewByTag.mClipBounds;
            if (z && rectF2 != null) {
                rectF.union(rectF2);
            }
            if (z2 && rectF3 != null) {
                rectF.union(rectF3);
            }
            if (z3 && rectF4 != null) {
                rectF.union(rectF4);
            }
            if (z4 && rectF5 != null) {
                rectF.intersect(rectF5);
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble(EllipticCurveJsonWebKey.X_MEMBER_NAME, rectF.left / f);
            writableMapCreateMap.putDouble(EllipticCurveJsonWebKey.Y_MEMBER_NAME, rectF.top / f);
            writableMapCreateMap.putDouble("width", rectF.width() / f);
            writableMapCreateMap.putDouble("height", rectF.height() / f);
            return writableMapCreateMap;
        } catch (NullPointerException unused) {
            renderableViewByTag.invalidate();
            return Arguments.createMap();
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getCTM(int i) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        float f = renderableViewByTag.mScale;
        Matrix matrix = new Matrix(renderableViewByTag.mCTM);
        matrix.preConcat(renderableViewByTag.getSvgView().mInvViewBoxMatrix);
        matrix.getValues(new float[9]);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("a", r6[0]);
        writableMapCreateMap.putDouble("b", r6[3]);
        writableMapCreateMap.putDouble("c", r6[1]);
        writableMapCreateMap.putDouble("d", r6[4]);
        writableMapCreateMap.putDouble(RsaJsonWebKey.EXPONENT_MEMBER_NAME, r6[2] / f);
        writableMapCreateMap.putDouble("f", r6[5] / f);
        return writableMapCreateMap;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getScreenCTM(int i) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return Arguments.createMap();
        }
        renderableViewByTag.mCTM.getValues(new float[9]);
        float f = renderableViewByTag.mScale;
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("a", r0[0]);
        writableMapCreateMap.putDouble("b", r0[3]);
        writableMapCreateMap.putDouble("c", r0[1]);
        writableMapCreateMap.putDouble("d", r0[4]);
        writableMapCreateMap.putDouble(RsaJsonWebKey.EXPONENT_MEMBER_NAME, r0[2] / f);
        writableMapCreateMap.putDouble("f", r0[5] / f);
        return writableMapCreateMap;
    }

    @ReactMethod
    public void getRawResource(String str, Promise promise) {
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Resources resources = reactApplicationContext.getResources();
            InputStream inputStreamOpenRawResource = resources.openRawResource(resources.getIdentifier(str, "raw", reactApplicationContext.getPackageName()));
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpenRawResource, StandardCharsets.UTF_8);
                char[] cArr = new char[4096];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = inputStreamReader.read(cArr, 0, 4096);
                    if (i != -1) {
                        sb.append(cArr, 0, i);
                    } else {
                        promise.resolve(sb.toString());
                        try {
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                }
            } finally {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException unused2) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject(e);
        }
    }
}
