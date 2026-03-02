package com.horcrux.svg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/* JADX INFO: loaded from: classes2.dex */
class EllipseView extends RenderableView {
    private SVGLength mCx;
    private SVGLength mCy;
    private SVGLength mRx;
    private SVGLength mRy;

    public EllipseView(ReactContext reactContext) {
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

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        double dRelativeOnWidth = relativeOnWidth(this.mCx);
        double dRelativeOnHeight = relativeOnHeight(this.mCy);
        double dRelativeOnWidth2 = relativeOnWidth(this.mRx);
        double dRelativeOnHeight2 = relativeOnHeight(this.mRy);
        path.addOval(new RectF((float) (dRelativeOnWidth - dRelativeOnWidth2), (float) (dRelativeOnHeight - dRelativeOnHeight2), (float) (dRelativeOnWidth + dRelativeOnWidth2), (float) (dRelativeOnHeight + dRelativeOnHeight2)), Path.Direction.CW);
        return path;
    }
}
