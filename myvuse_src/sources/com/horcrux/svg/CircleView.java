package com.horcrux.svg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes2.dex */
class CircleView extends RenderableView {
    private SVGLength mCx;
    private SVGLength mCy;

    /* JADX INFO: renamed from: mR */
    private SVGLength f3972mR;

    public CircleView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "cx")
    public void setCx(Dynamic dynamic) {
        this.mCx = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "cy")
    public void setCy(Dynamic dynamic) {
        this.mCy = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME)
    public void setR(Dynamic dynamic) {
        this.f3972mR = SVGLength.from(dynamic);
        invalidate();
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        path.addCircle((float) relativeOnWidth(this.mCx), (float) relativeOnHeight(this.mCy), (float) relativeOnOther(this.f3972mR), Path.Direction.CW);
        return path;
    }
}
