package com.yoti.mobile.android.documentscan.ui.helpers.scan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.color.MaterialColors;
import com.yoti.mobile.android.documentscan.C4695R;

/* JADX INFO: loaded from: classes5.dex */
public class DocumentScanOverlayView extends View {
    private static final float TEXT_HORIZONTAL_MARGIN_PCT = 0.05f;
    private boolean mActiveState;
    private Paint mBackgroundPaint;
    private IScanFrameShape mCornerPath;
    private float mDocumentRatio;
    private RectF mDocumentRect;
    private RectF mMessageTextBounds;
    private int mMessageTextExpectedSize;
    private Layout mMessageTextLayout;
    private TextPaint mMessageTextPaint;
    private int mMessageTextRes;
    private float mMessageTextSpacing;
    private RectF mTitleTextBounds;
    private int mTitleTextExpectedSize;
    private Layout mTitleTextLayout;
    private TextPaint mTitleTextPaint;
    private int mTitleTextRes;
    private float scanRectMarginBottom;
    private float scanRectMarginHorizontal;
    private float scanRectMarginTop;

    public DocumentScanOverlayView(Context context) {
        super(context);
        this.mDocumentRect = new RectF();
        this.scanRectMarginTop = getResources().getDimension(C4695R.dimen.document_reader_scan_vertical_margin);
        this.scanRectMarginBottom = getResources().getDimension(C4695R.dimen.document_reader_scan_vertical_margin);
        this.scanRectMarginHorizontal = getResources().getDimension(C4695R.dimen.document_reader_scan_horizontal_margin);
        this.mTitleTextBounds = new RectF();
        this.mMessageTextBounds = new RectF();
        init();
    }

    public DocumentScanOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDocumentRect = new RectF();
        this.scanRectMarginTop = getResources().getDimension(C4695R.dimen.document_reader_scan_vertical_margin);
        this.scanRectMarginBottom = getResources().getDimension(C4695R.dimen.document_reader_scan_vertical_margin);
        this.scanRectMarginHorizontal = getResources().getDimension(C4695R.dimen.document_reader_scan_horizontal_margin);
        this.mTitleTextBounds = new RectF();
        this.mMessageTextBounds = new RectF();
        init();
    }

    public DocumentScanOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDocumentRect = new RectF();
        this.scanRectMarginTop = getResources().getDimension(C4695R.dimen.document_reader_scan_vertical_margin);
        this.scanRectMarginBottom = getResources().getDimension(C4695R.dimen.document_reader_scan_vertical_margin);
        this.scanRectMarginHorizontal = getResources().getDimension(C4695R.dimen.document_reader_scan_horizontal_margin);
        this.mTitleTextBounds = new RectF();
        this.mMessageTextBounds = new RectF();
        init();
    }

    private void init() {
        Paint paint = new Paint(1);
        this.mBackgroundPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        int color = ResourcesCompat.getColor(getResources(), C4695R.color.yoti_white, null);
        this.mTitleTextExpectedSize = getResources().getDimensionPixelSize(C4695R.dimen.yoti_document_reader_title_size);
        TextPaint textPaint = new TextPaint();
        this.mTitleTextPaint = textPaint;
        textPaint.setColor(color);
        this.mTitleTextPaint.setStyle(Paint.Style.FILL);
        this.mTitleTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.mTitleTextPaint.setTextSize(this.mTitleTextExpectedSize);
        this.mTitleTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mMessageTextExpectedSize = getResources().getDimensionPixelSize(C4695R.dimen.yoti_document_reader_text_size);
        TextPaint textPaint2 = new TextPaint();
        this.mMessageTextPaint = textPaint2;
        textPaint2.setColor(color);
        this.mMessageTextPaint.setStyle(Paint.Style.FILL);
        this.mMessageTextPaint.setTextSize(this.mMessageTextExpectedSize);
        this.mMessageTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mMessageTextSpacing = getResources().getDimensionPixelSize(C4695R.dimen.yoti_document_reader_text_spacing);
    }

    private void measureMessageText() {
        if (this.mMessageTextBounds.width() == 0.0f || this.mMessageTextBounds.height() == 0.0f || this.mTitleTextRes == 0) {
            return;
        }
        this.mMessageTextLayout = scaleTextPaint(this.mMessageTextPaint, getResources().getString(this.mMessageTextRes), this.mMessageTextExpectedSize, this.mMessageTextBounds, true);
    }

    private void measureTitleText() {
        if (this.mTitleTextBounds.width() == 0.0f || this.mTitleTextBounds.height() == 0.0f || this.mTitleTextRes == 0) {
            return;
        }
        this.mTitleTextLayout = scaleTextPaint(this.mTitleTextPaint, getResources().getString(this.mTitleTextRes), this.mTitleTextExpectedSize, this.mTitleTextBounds, false);
    }

    private void resolveWindowSize(int i, int i2, int i3, int i4, float f) {
        float f2 = i3 - i;
        float f3 = this.scanRectMarginHorizontal;
        while (true) {
            float f4 = f2 - (f3 * 2.0f);
            float f5 = f4 * f;
            if (this.scanRectMarginTop + f5 <= getHeight() - this.scanRectMarginBottom) {
                RectF rectF = this.mDocumentRect;
                float f6 = i + this.scanRectMarginHorizontal;
                float f7 = i2 + this.scanRectMarginTop;
                rectF.set(f6, f7, f4 + f6, f5 + f7);
                RectF rectF2 = this.mDocumentRect;
                float fHeight = rectF2.top + (rectF2.height() / 2.0f);
                RectF rectF3 = this.mTitleTextBounds;
                RectF rectF4 = this.mDocumentRect;
                rectF3.set(rectF4.left, rectF4.top, rectF4.right, fHeight);
                RectF rectF5 = this.mMessageTextBounds;
                RectF rectF6 = this.mDocumentRect;
                rectF5.set(rectF6.left, fHeight, rectF6.right, rectF6.bottom);
                this.mMessageTextBounds.inset(this.mMessageTextBounds.width() * TEXT_HORIZONTAL_MARGIN_PCT, 0.0f);
                this.mCornerPath.setCorners(this.mDocumentRect);
                measureTitleText();
                measureMessageText();
                postInvalidate();
                return;
            }
            f3 = this.scanRectMarginHorizontal + 1.0f;
            this.scanRectMarginHorizontal = f3;
        }
    }

    private Layout scaleTextPaint(TextPaint textPaint, String str, int i, RectF rectF, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return new StaticLayout(str, textPaint, (int) rectF.width(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }
        int length = !z ? str.split("\\n").length : Integer.MAX_VALUE;
        while (i > 0) {
            textPaint.setTextSize(i);
            StaticLayout staticLayout = new StaticLayout(str, textPaint, (int) rectF.width(), Layout.Alignment.ALIGN_NORMAL, 1.0f, this.mMessageTextSpacing, false);
            if (staticLayout.getLineCount() <= length && rectF.width() >= staticLayout.getWidth() && rectF.height() >= staticLayout.getHeight()) {
                return staticLayout;
            }
            i--;
        }
        return new StaticLayout(str, textPaint, (int) rectF.width(), Layout.Alignment.ALIGN_NORMAL, 1.0f, this.mMessageTextSpacing, false);
    }

    public RectF getScanWindowPosition() {
        return this.mDocumentRect;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDocumentRect != null) {
            canvas.save();
            canvas.clipPath(this.mCornerPath.getShape(), Region.Op.DIFFERENCE);
            canvas.drawPaint(this.mBackgroundPaint);
            canvas.restore();
            if (this.mTitleTextLayout != null) {
                canvas.save();
                canvas.translate(this.mTitleTextBounds.centerX(), this.mTitleTextBounds.centerY() - (this.mTitleTextLayout.getHeight() / 2));
                this.mTitleTextLayout.draw(canvas);
                canvas.restore();
            }
            if (this.mMessageTextLayout != null) {
                canvas.save();
                canvas.translate(this.mMessageTextBounds.centerX(), this.mMessageTextBounds.top);
                this.mMessageTextLayout.draw(canvas);
                canvas.restore();
            }
            this.mCornerPath.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float f = this.mDocumentRatio;
        if (f > 0.0f) {
            resolveWindowSize(i, i2, i3, i4, f);
        }
    }

    public void setActive(boolean z) {
        if (this.mActiveState == z) {
            return;
        }
        this.mActiveState = z;
        if (z) {
            this.mCornerPath.activate();
        } else {
            this.mCornerPath.deactivate();
        }
        postInvalidate();
    }

    public void setBackground(Integer num) {
        this.mBackgroundPaint.setColor(MaterialColors.getColor(this, num.intValue()));
    }

    public void setDocumentRatio(float f) {
        this.mDocumentRatio = f;
        this.mCornerPath.setRatio(f);
        if (getWidth() > 0) {
            resolveWindowSize(getLeft(), getTop(), getRight(), getBottom(), f);
        }
    }

    public void setOverlayMessage(int i, int i2) {
        this.mTitleTextRes = i;
        this.mMessageTextRes = i2;
        measureTitleText();
        measureMessageText();
        Rect rect = new Rect();
        this.mDocumentRect.round(rect);
        invalidate(rect);
    }

    public void setScanFrameMargins(float f, float f2, float f3) {
        this.scanRectMarginTop = f;
        this.scanRectMarginBottom = f2;
        this.scanRectMarginHorizontal = f3;
    }

    public void setScanFrameShape(IScanFrameShape iScanFrameShape) {
        this.mCornerPath = iScanFrameShape;
    }
}
