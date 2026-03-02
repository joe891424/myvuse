package com.horcrux.svg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/* JADX INFO: loaded from: classes2.dex */
class PathView extends RenderableView {
    private Path mPath;

    public PathView(ReactContext reactContext) {
        super(reactContext);
        PathParser.mScale = this.mScale;
        this.mPath = new Path();
    }

    @ReactProp(name = "d")
    public void setD(String str) {
        this.mPath = PathParser.parse(str);
        this.elements = PathParser.elements;
        invalidate();
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        return this.mPath;
    }
}
