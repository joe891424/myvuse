package com.horcrux.svg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.annotations.ReactProp;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

/* JADX INFO: loaded from: classes2.dex */
class UseView extends RenderableView {

    /* JADX INFO: renamed from: mH */
    private SVGLength f4008mH;
    private String mHref;

    /* JADX INFO: renamed from: mW */
    private SVGLength f4009mW;

    /* JADX INFO: renamed from: mX */
    private SVGLength f4010mX;

    /* JADX INFO: renamed from: mY */
    private SVGLength f4011mY;

    public UseView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "href")
    public void setHref(String str) {
        this.mHref = str;
        invalidate();
    }

    @ReactProp(name = EllipticCurveJsonWebKey.X_MEMBER_NAME)
    public void setX(Dynamic dynamic) {
        this.f4010mX = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = EllipticCurveJsonWebKey.Y_MEMBER_NAME)
    public void setY(Dynamic dynamic) {
        this.f4011mY = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.f4009mW = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.f4008mH = SVGLength.from(dynamic);
        invalidate();
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    void draw(Canvas canvas, Paint paint, float f) {
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.mHref);
        if (definedTemplate == null) {
            FLog.m1317w(ReactConstants.TAG, "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.mHref + " is not defined.");
            return;
        }
        definedTemplate.clearCache();
        canvas.translate((float) relativeOnWidth(this.f4010mX), (float) relativeOnHeight(this.f4011mY));
        boolean z = definedTemplate instanceof RenderableView;
        if (z) {
            ((RenderableView) definedTemplate).mergeProperties(this);
        }
        int iSaveAndSetupCanvas = definedTemplate.saveAndSetupCanvas(canvas, this.mCTM);
        clip(canvas, paint);
        if (definedTemplate instanceof SymbolView) {
            ((SymbolView) definedTemplate).drawSymbol(canvas, paint, f, (float) relativeOnWidth(this.f4009mW), (float) relativeOnHeight(this.f4008mH));
        } else {
            definedTemplate.draw(canvas, paint, f * this.mOpacity);
        }
        setClientRect(definedTemplate.getClientRect());
        definedTemplate.restoreCanvas(canvas, iSaveAndSetupCanvas);
        if (z) {
            ((RenderableView) definedTemplate).resetProperties();
        }
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    int hitTest(float[] fArr) {
        if (this.mInvertible && this.mTransformInvertible) {
            float[] fArr2 = new float[2];
            this.mInvMatrix.mapPoints(fArr2, fArr);
            this.mInvTransform.mapPoints(fArr2);
            VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.mHref);
            if (definedTemplate == null) {
                FLog.m1317w(ReactConstants.TAG, "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.mHref + " is not defined.");
                return -1;
            }
            int iHitTest = definedTemplate.hitTest(fArr2);
            if (iHitTest != -1) {
                return (definedTemplate.isResponsible() || iHitTest != definedTemplate.getId()) ? iHitTest : getId();
            }
        }
        return -1;
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.mHref);
        if (definedTemplate == null) {
            FLog.m1317w(ReactConstants.TAG, "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.mHref + " is not defined.");
            return null;
        }
        Path path = definedTemplate.getPath(canvas, paint);
        Path path2 = new Path();
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) relativeOnWidth(this.f4010mX), (float) relativeOnHeight(this.f4011mY));
        path.transform(matrix, path2);
        return path2;
    }
}
