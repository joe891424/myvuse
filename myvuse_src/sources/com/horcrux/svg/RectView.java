package com.horcrux.svg;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

/* JADX INFO: loaded from: classes2.dex */
class RectView extends RenderableView {

    /* JADX INFO: renamed from: mH */
    private SVGLength f3996mH;
    private SVGLength mRx;
    private SVGLength mRy;

    /* JADX INFO: renamed from: mW */
    private SVGLength f3997mW;

    /* JADX INFO: renamed from: mX */
    private SVGLength f3998mX;

    /* JADX INFO: renamed from: mY */
    private SVGLength f3999mY;

    public RectView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = EllipticCurveJsonWebKey.X_MEMBER_NAME)
    public void setX(Dynamic dynamic) {
        this.f3998mX = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = EllipticCurveJsonWebKey.Y_MEMBER_NAME)
    public void setY(Dynamic dynamic) {
        this.f3999mY = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.f3997mW = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.f3996mH = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "rx")
    public void setRx(Dynamic dynamic) {
        this.mRx = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "ry")
    public void setRy(Dynamic dynamic) {
        this.mRy = SVGLength.from(dynamic);
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.graphics.Path getPath(android.graphics.Canvas r20, android.graphics.Paint r21) {
        /*
            r19 = this;
            r0 = r19
            android.graphics.Path r9 = new android.graphics.Path
            r9.<init>()
            com.horcrux.svg.SVGLength r1 = r0.f3998mX
            double r1 = r0.relativeOnWidth(r1)
            com.horcrux.svg.SVGLength r3 = r0.f3999mY
            double r3 = r0.relativeOnHeight(r3)
            com.horcrux.svg.SVGLength r5 = r0.f3997mW
            double r5 = r0.relativeOnWidth(r5)
            com.horcrux.svg.SVGLength r7 = r0.f3996mH
            double r7 = r0.relativeOnHeight(r7)
            com.horcrux.svg.SVGLength r10 = r0.mRx
            if (r10 != 0) goto L3d
            com.horcrux.svg.SVGLength r11 = r0.mRy
            if (r11 == 0) goto L28
            goto L3d
        L28:
            float r10 = (float) r1
            float r11 = (float) r3
            double r1 = r1 + r5
            float r5 = (float) r1
            double r3 = r3 + r7
            float r6 = (float) r3
            android.graphics.Path$Direction r7 = android.graphics.Path.Direction.CW
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r5
            r5 = r6
            r6 = r7
            r1.addRect(r2, r3, r4, r5, r6)
            r9.close()
            goto L80
        L3d:
            if (r10 != 0) goto L47
            com.horcrux.svg.SVGLength r10 = r0.mRy
            double r10 = r0.relativeOnHeight(r10)
        L45:
            r12 = r10
            goto L5a
        L47:
            com.horcrux.svg.SVGLength r11 = r0.mRy
            if (r11 != 0) goto L50
            double r10 = r0.relativeOnWidth(r10)
            goto L45
        L50:
            double r10 = r0.relativeOnWidth(r10)
            com.horcrux.svg.SVGLength r12 = r0.mRy
            double r12 = r0.relativeOnHeight(r12)
        L5a:
            r14 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r16 = r5 / r14
            int r18 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r18 <= 0) goto L64
            r10 = r16
        L64:
            double r14 = r7 / r14
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 <= 0) goto L6b
            r12 = r14
        L6b:
            float r14 = (float) r1
            float r15 = (float) r3
            double r1 = r1 + r5
            float r5 = (float) r1
            double r3 = r3 + r7
            float r6 = (float) r3
            float r7 = (float) r10
            float r8 = (float) r12
            android.graphics.Path$Direction r10 = android.graphics.Path.Direction.CW
            r1 = r9
            r2 = r14
            r3 = r15
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            r1.addRoundRect(r2, r3, r4, r5, r6, r7, r8)
        L80:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.RectView.getPath(android.graphics.Canvas, android.graphics.Paint):android.graphics.Path");
    }
}
