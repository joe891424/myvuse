package com.wheelpicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class LoopView extends View {
    ArrayList arrayList;
    int change;
    int colorBlack;
    int colorGray;
    int colorGrayLight;
    Context context;

    /* JADX INFO: renamed from: dy */
    float f5847dy;
    int firstLineY;
    private GestureDetector gestureDetector;
    int halfCircumference;
    Handler handler;
    int initPosition;
    boolean isLoop;
    int itemCount;
    float lineSpacingMultiplier;
    LoopListener loopListener;
    ScheduledExecutorService mExecutor;
    private ScheduledFuture<?> mFuture;
    int maxTextHeight;
    int maxTextWidth;
    int measuredHeight;
    int measuredWidth;
    Paint paintA;
    Paint paintB;
    Paint paintC;
    int preCurrentIndex;

    /* JADX INFO: renamed from: r */
    private Rect f5848r;
    int radius;
    int secondLineY;
    private int selectedItem;
    private GestureDetector.SimpleOnGestureListener simpleOnGestureListener;
    int textSize;
    int totalScrollY;

    /* JADX INFO: renamed from: y1 */
    float f5849y1;

    /* JADX INFO: renamed from: y2 */
    float f5850y2;

    public LoopView(Context context) {
        super(context);
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.lineSpacingMultiplier = 2.0f;
        this.f5848r = new Rect();
        initLoopView(context);
    }

    public LoopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.lineSpacingMultiplier = 2.0f;
        this.f5848r = new Rect();
        initLoopView(context);
    }

    public LoopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.lineSpacingMultiplier = 2.0f;
        this.f5848r = new Rect();
        initLoopView(context);
    }

    private void initLoopView(Context context) {
        this.textSize = 0;
        this.colorGray = -5263441;
        this.colorBlack = -13553359;
        this.colorGrayLight = -3815995;
        this.isLoop = false;
        this.initPosition = 0;
        this.itemCount = 7;
        this.f5849y1 = 0.0f;
        this.f5850y2 = 0.0f;
        this.f5847dy = 0.0f;
        this.totalScrollY = 0;
        this.simpleOnGestureListener = new LoopViewGestureListener(this);
        this.handler = new MessageHandler(this, context);
        this.context = context;
        setTextSize(16.0f);
        Paint paint = new Paint();
        this.paintA = paint;
        paint.setColor(this.colorGrayLight);
        Paint paint2 = new Paint();
        this.paintB = paint2;
        paint2.setTextSize(this.textSize);
        this.paintC = new Paint();
        this.paintA.setTextSize(this.textSize);
        setLayerType(1, null);
        GestureDetector gestureDetector = new GestureDetector(context, this.simpleOnGestureListener);
        this.gestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
    }

    static int getSelectedItem(LoopView loopView) {
        return loopView.selectedItem;
    }

    static void smoothScroll(LoopView loopView) {
        loopView.smoothScroll();
    }

    private void initData() {
        if (this.arrayList == null) {
            return;
        }
        this.paintA.setAntiAlias(true);
        this.paintB.setAntiAlias(true);
        this.paintC.setAntiAlias(true);
        this.paintC.setTypeface(Typeface.MONOSPACE);
        this.paintC.setTextSize(this.textSize);
        measureTextWidthHeight();
        int i = this.maxTextHeight;
        float f = this.lineSpacingMultiplier;
        int i2 = (int) (i * f * (this.itemCount - 1));
        this.halfCircumference = i2;
        int i3 = (int) (((double) (i2 * 2)) / 3.141592653589793d);
        this.measuredHeight = i3;
        this.radius = (int) (((double) i2) / 3.141592653589793d);
        this.firstLineY = (int) ((i3 - (i * f)) / 1.92f);
        this.secondLineY = (int) ((i3 + (f * i)) / 1.92f);
        if (this.initPosition == -1) {
            if (this.isLoop) {
                this.initPosition = (this.arrayList.size() + 1) / 2;
            } else {
                this.initPosition = 0;
            }
        }
        this.preCurrentIndex = this.initPosition;
    }

    private void measureTextWidthHeight() {
        Rect rect = new Rect();
        for (int i = 0; i < this.arrayList.size(); i++) {
            String str = (String) this.arrayList.get(i);
            this.paintB.getTextBounds(str, 0, str.length(), rect);
            int iWidth = rect.width();
            if (iWidth > this.maxTextWidth) {
                this.maxTextWidth = iWidth;
            }
            this.paintB.getTextBounds("星期", 0, 2, rect);
            int iHeight = rect.height();
            if (iHeight > this.maxTextHeight) {
                this.maxTextHeight = iHeight;
            }
        }
    }

    private void smoothScroll() {
        int i = (int) (this.totalScrollY % (this.lineSpacingMultiplier * this.maxTextHeight));
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new MTimer(this, i), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.mFuture;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.mFuture.cancel(true);
        this.mFuture = null;
    }

    public final int getSelectedItem() {
        return this.selectedItem;
    }

    protected final void smoothScroll(float f) {
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new LoopTimerTask(this, f), 0L, 20, TimeUnit.MILLISECONDS);
    }

    protected final void itemSelected() {
        if (this.loopListener != null) {
            postDelayed(new LoopRunnable(this), 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        ArrayList arrayList = this.arrayList;
        if (arrayList == null) {
            super.onDraw(canvas);
            return;
        }
        String[] strArr = new String[this.itemCount];
        int i = (int) (this.totalScrollY / (this.lineSpacingMultiplier * this.maxTextHeight));
        this.change = i;
        int size = this.initPosition + (i % arrayList.size());
        this.preCurrentIndex = size;
        if (!this.isLoop) {
            if (size < 0) {
                this.preCurrentIndex = 0;
            }
            if (this.preCurrentIndex > this.arrayList.size() - 1) {
                this.preCurrentIndex = this.arrayList.size() - 1;
            }
        } else {
            if (size < 0) {
                this.preCurrentIndex = this.arrayList.size() + this.preCurrentIndex;
            }
            if (this.preCurrentIndex > this.arrayList.size() - 1) {
                this.preCurrentIndex -= this.arrayList.size();
            }
        }
        int i2 = (int) (this.totalScrollY % (this.lineSpacingMultiplier * this.maxTextHeight));
        int i3 = 0;
        while (true) {
            int i4 = this.itemCount;
            if (i3 >= i4) {
                break;
            }
            int size2 = this.preCurrentIndex - ((i4 / 2) - i3);
            if (this.isLoop) {
                if (size2 < 0) {
                    size2 += this.arrayList.size();
                }
                if (size2 > this.arrayList.size() - 1) {
                    size2 -= this.arrayList.size();
                }
                strArr[i3] = (String) this.arrayList.get(size2);
            } else if (size2 < 0) {
                strArr[i3] = "";
            } else if (size2 > this.arrayList.size() - 1) {
                strArr[i3] = "";
            } else {
                strArr[i3] = (String) this.arrayList.get(size2);
            }
            i3++;
        }
        int i5 = this.firstLineY;
        canvas.drawLine(0.0f, i5, this.measuredWidth, i5, this.paintC);
        int i6 = this.secondLineY;
        canvas.drawLine(0.0f, i6, this.measuredWidth, i6, this.paintC);
        for (int i7 = 0; i7 < this.itemCount; i7++) {
            canvas.save();
            float f = this.maxTextHeight * this.lineSpacingMultiplier;
            double d = (((double) ((i7 * f) - i2)) * 3.141592653589793d) / ((double) this.halfCircumference);
            float f2 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
            if (f2 >= 90.0f || f2 <= -90.0f) {
                canvas.restore();
            } else {
                int iCos = (int) ((((double) this.radius) - (Math.cos(d) * ((double) this.radius))) - ((Math.sin(d) * ((double) this.maxTextHeight)) / 2.0d));
                canvas.translate(0.0f, iCos);
                canvas.scale(1.0f, (float) Math.sin(d));
                int i8 = this.firstLineY;
                if (iCos <= i8 && this.maxTextHeight + iCos >= i8) {
                    canvas.save();
                    canvas.clipRect(0, 0, this.measuredWidth, this.firstLineY - iCos);
                    drawCenter(canvas, this.paintA, strArr[i7], this.maxTextHeight);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0, this.firstLineY - iCos, this.measuredWidth, (int) f);
                    drawCenter(canvas, this.paintB, strArr[i7], this.maxTextHeight);
                    canvas.restore();
                } else {
                    int i9 = this.secondLineY;
                    if (iCos <= i9 && this.maxTextHeight + iCos >= i9) {
                        canvas.save();
                        canvas.clipRect(0, 0, this.measuredWidth, this.secondLineY - iCos);
                        drawCenter(canvas, this.paintB, strArr[i7], this.maxTextHeight);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0, this.secondLineY - iCos, this.measuredWidth, (int) f);
                        drawCenter(canvas, this.paintA, strArr[i7], this.maxTextHeight);
                        canvas.restore();
                    } else if (iCos >= i8 && this.maxTextHeight + iCos <= i9) {
                        canvas.clipRect(0, 0, this.measuredWidth, (int) f);
                        drawCenter(canvas, this.paintB, strArr[i7], this.maxTextHeight);
                        this.selectedItem = this.arrayList.indexOf(strArr[i7]);
                    } else {
                        canvas.clipRect(0, 0, this.measuredWidth, (int) f);
                        drawCenter(canvas, this.paintA, strArr[i7], this.maxTextHeight);
                    }
                }
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    private void drawCenter(Canvas canvas, Paint paint, String str, int i) {
        canvas.getClipBounds(this.f5848r);
        int iWidth = this.f5848r.width();
        paint.setTextAlign(Paint.Align.LEFT);
        paint.getTextBounds(str, 0, str.length(), this.f5848r);
        canvas.drawText(str, ((iWidth / 2.0f) - (this.f5848r.width() / 2.0f)) - this.f5848r.left, i, paint);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        initData();
        this.measuredWidth = getMeasuredWidth();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int size;
        int i;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5849y1 = motionEvent.getRawY();
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (action == 2) {
            float rawY = motionEvent.getRawY();
            this.f5850y2 = rawY;
            float f = this.f5849y1 - rawY;
            this.f5847dy = f;
            this.f5849y1 = rawY;
            int i2 = (int) (this.totalScrollY + f);
            this.totalScrollY = i2;
            if (!this.isLoop && i2 < (i = ((int) (this.initPosition * this.lineSpacingMultiplier * this.maxTextHeight)) * (-1))) {
                this.totalScrollY = i;
            }
        } else {
            if (!this.gestureDetector.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
                smoothScroll();
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            return true;
        }
        if (!this.isLoop && this.totalScrollY >= (size = (int) (((this.arrayList.size() - 1) - this.initPosition) * this.lineSpacingMultiplier * this.maxTextHeight))) {
            this.totalScrollY = size;
        }
        invalidate();
        if (!this.gestureDetector.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
            smoothScroll();
        }
        return true;
    }

    public final void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
    }

    public final void setLoop(boolean z) {
        this.isLoop = z;
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
        }
    }

    public final void setInitPosition(int i) {
        this.initPosition = i;
    }

    public final void setListener(LoopListener loopListener) {
        this.loopListener = loopListener;
    }

    public final void setArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
        initData();
        invalidate();
    }

    public final void setSelectedItemTextColor(int i) {
        this.paintB.setColor(i);
    }

    public final void setSelectedItemTextSize(int i) {
        this.paintB.setTextSize(i * getResources().getDisplayMetrics().scaledDensity);
    }

    public final void setSelectedItemFont(Typeface typeface) {
        this.paintB.setTypeface(typeface);
    }

    public final void setItemTextColor(int i) {
        this.paintA.setColor(i);
    }

    public final void setItemTextSize(int i) {
        this.paintA.setTextSize(i * getResources().getDisplayMetrics().scaledDensity);
    }

    public final void setItemFont(Typeface typeface) {
        this.paintA.setTypeface(typeface);
    }

    public final void setIndicatorColor(int i) {
        this.paintC.setColor(i);
    }

    public final void setIndicatorWidth(int i) {
        this.paintC.setStrokeWidth(i);
    }

    public final void hideIndicator() {
        this.paintC.setColor(0);
    }

    public final void setSelectedItem(int i) {
        this.totalScrollY = (int) ((i - this.initPosition) * this.lineSpacingMultiplier * this.maxTextHeight);
        invalidate();
        smoothScroll();
    }
}
