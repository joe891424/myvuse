package com.horcrux.svg;

import android.graphics.Matrix;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.Brush;
import javax.annotation.Nullable;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

/* JADX INFO: loaded from: classes2.dex */
class MaskView extends GroupView {
    private static final float[] sRawMatrix = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* JADX INFO: renamed from: mH */
    SVGLength f3983mH;
    private Brush.BrushUnits mMaskContentUnits;
    private Brush.BrushUnits mMaskUnits;
    private Matrix mMatrix;

    /* JADX INFO: renamed from: mW */
    SVGLength f3984mW;

    /* JADX INFO: renamed from: mX */
    SVGLength f3985mX;

    /* JADX INFO: renamed from: mY */
    SVGLength f3986mY;

    public MaskView(ReactContext reactContext) {
        super(reactContext);
        this.mMatrix = null;
    }

    @ReactProp(name = EllipticCurveJsonWebKey.X_MEMBER_NAME)
    public void setX(Dynamic dynamic) {
        this.f3985mX = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = EllipticCurveJsonWebKey.Y_MEMBER_NAME)
    public void setY(Dynamic dynamic) {
        this.f3986mY = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.f3984mW = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.f3983mH = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "maskUnits")
    public void setMaskUnits(int i) {
        if (i == 0) {
            this.mMaskUnits = Brush.BrushUnits.OBJECT_BOUNDING_BOX;
        } else if (i == 1) {
            this.mMaskUnits = Brush.BrushUnits.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "maskContentUnits")
    public void setMaskContentUnits(int i) {
        if (i == 0) {
            this.mMaskContentUnits = Brush.BrushUnits.OBJECT_BOUNDING_BOX;
        } else if (i == 1) {
            this.mMaskContentUnits = Brush.BrushUnits.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    @ReactProp(name = "maskTransform")
    public void setMaskTransform(@Nullable ReadableArray readableArray) {
        if (readableArray != null) {
            float[] fArr = sRawMatrix;
            int matrixData = PropHelper.toMatrixData(readableArray, fArr, this.mScale);
            if (matrixData == 6) {
                if (this.mMatrix == null) {
                    this.mMatrix = new Matrix();
                }
                this.mMatrix.setValues(fArr);
            } else if (matrixData != -1) {
                FLog.m1317w(ReactConstants.TAG, "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.mMatrix = null;
        }
        invalidate();
    }

    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.VirtualView
    void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineMask(this, this.mName);
        }
    }
}
