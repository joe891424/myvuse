package com.shazam.android.widget.text.reflow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.transition.PathMotion;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.shazam.android.widget.text.reflow.ReflowTextAnimatorHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class ReflowTextAnimatorHelper {
    private static final char ELLIPSIS = 8230;
    private static final boolean IS_LOLLIPOP_OR_ABOVE = true;
    private static final int OPACITY_MID_TRANSITION = 204;
    private static final int OPAQUE = 255;
    private static final float STAGGER_DECAY = 0.8f;
    private static final int TRANSPARENT = 0;
    private final AnimatorSet animator;
    private final BoundsCalculator boundsCalculator;
    private boolean calculateDuration;
    private long duration;
    private Bitmap endText;
    private final TextSizeGetter fontSizeGetter;
    private final boolean freezeOnLastFrame;
    private final long maxDuration;
    private final long minDuration;
    private final boolean showLayers;
    private final TextView sourceView;
    private long staggerDelay;
    private Bitmap startText;
    private final TextView targetView;
    private final TextColorGetter textColorGetter;
    private final long velocity;

    private ReflowTextAnimatorHelper(Builder builder) {
        this.animator = new AnimatorSet();
        this.showLayers = builder.showLayers;
        this.sourceView = builder.sourceView;
        this.targetView = builder.targetView;
        this.minDuration = builder.minDuration;
        this.maxDuration = builder.maxDuration;
        this.calculateDuration = builder.calculateDuration;
        this.staggerDelay = builder.staggerDelay;
        this.velocity = builder.velocity;
        this.freezeOnLastFrame = builder.freezeOnLastFrame;
        this.fontSizeGetter = builder.fontSizeGetter;
        this.textColorGetter = builder.textColorGetter;
        this.boundsCalculator = builder.boundsCalculator;
    }

    public Animator createAnimator() {
        this.duration = this.calculateDuration ? calculateDuration(this.boundsCalculator.calculate(this.sourceView), this.boundsCalculator.calculate(this.targetView)) : -1L;
        this.startText = createBitmap(this.sourceView);
        this.endText = createBitmap(this.targetView);
        this.targetView.setWillNotDraw(true);
        ((ViewGroup) this.targetView.getParent()).setClipChildren(false);
        this.animator.playTogether(createRunAnimators(this.targetView, this.startText, this.endText, getRuns()));
        if (!this.freezeOnLastFrame) {
            this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.shazam.android.widget.text.reflow.ReflowTextAnimatorHelper.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ReflowTextAnimatorHelper.this.unfreeze();
                }
            });
        }
        return this.animator;
    }

    public void unfreeze() {
        this.targetView.setWillNotDraw(false);
        this.targetView.getOverlay().clear();
        ((ViewGroup) this.targetView.getParent()).setClipChildren(true);
        Bitmap bitmap = this.startText;
        if (bitmap != null) {
            bitmap.recycle();
            this.startText = null;
        }
        Bitmap bitmap2 = this.endText;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.endText = null;
        }
    }

    private List<Run> getRuns() {
        int i = 1;
        int iMax = Math.max(this.sourceView.getLayout().getLineVisibleEnd(this.sourceView.getLayout().getLineCount() - 1), this.targetView.getLayout().getLineVisibleEnd(this.targetView.getLayout().getLineCount() - 1));
        ArrayList arrayList = new ArrayList();
        Layout layout = this.sourceView.getLayout();
        Layout layout2 = this.targetView.getLayout();
        int lineTop = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int startOffsetLeft = -1;
        int startOffsetLeft2 = -1;
        int primaryHorizontal = 0;
        int lineTop2 = 0;
        int primaryHorizontal2 = 0;
        int i5 = 0;
        while (i2 < iMax) {
            int i6 = i2 == iMax + (-1) ? i : 0;
            int lineForOffset = layout.getLineForOffset(i2);
            int i7 = iMax;
            Layout layoutCreateUnrestrictedLayout = (i6 == 0 && layout.getText().charAt(i2) == 8230) ? createUnrestrictedLayout(this.sourceView) : layout;
            int lineForOffset2 = layout2.getLineForOffset(i2);
            ArrayList arrayList2 = arrayList;
            layout2 = (i6 == 0 && layout2.getText().charAt(i2) == 8230) ? createUnrestrictedLayout(this.targetView) : layout2;
            if (lineForOffset == i3 && lineForOffset2 == i4 && i6 == 0) {
                arrayList = arrayList2;
                i = 1;
            } else {
                if (i6 != 0) {
                    i2++;
                }
                int iMin = Math.min(i3, layoutCreateUnrestrictedLayout.getLineCount() - 1);
                int iMin2 = Math.min(i4, layout2.getLineCount() - 1);
                int lineBottom = layoutCreateUnrestrictedLayout.getLineBottom(iMin);
                int lineBottom2 = layout2.getLineBottom(iMin2);
                if (iMin == 0 && startOffsetLeft == -1) {
                    startOffsetLeft = getStartOffsetLeft(layoutCreateUnrestrictedLayout, iMin);
                }
                if (iMin2 == 0 && startOffsetLeft2 == -1) {
                    startOffsetLeft2 = getStartOffsetLeft(layout2, iMin2);
                }
                int i8 = i5;
                Rect rect = new Rect(primaryHorizontal, lineTop2, primaryHorizontal + getSectionWidth(layoutCreateUnrestrictedLayout, i8, i2), lineBottom);
                rect.offset(this.sourceView.getCompoundPaddingLeft() + startOffsetLeft, this.sourceView.getCompoundPaddingTop());
                Rect rect2 = new Rect(primaryHorizontal2, lineTop, getSectionWidth(layout2, i8, i2) + primaryHorizontal2, lineBottom2);
                rect2.offset(this.targetView.getCompoundPaddingLeft() + startOffsetLeft2, this.targetView.getCompoundPaddingTop());
                boolean z = lineBottom <= this.sourceView.getMeasuredHeight();
                boolean z2 = lineBottom2 <= this.targetView.getMeasuredHeight();
                if (!z && !z2) {
                    return arrayList2;
                }
                Run run = new Run(rect, z, rect2, z2);
                arrayList = arrayList2;
                arrayList.add(run);
                primaryHorizontal = (int) layoutCreateUnrestrictedLayout.getPrimaryHorizontal(i2);
                lineTop2 = layoutCreateUnrestrictedLayout.getLineTop(lineForOffset);
                primaryHorizontal2 = (int) layout2.getPrimaryHorizontal(i2);
                lineTop = layout2.getLineTop(lineForOffset2);
                i3 = lineForOffset;
                i4 = lineForOffset2;
                i5 = i2;
                i = 1;
                startOffsetLeft = 0;
                startOffsetLeft2 = 0;
            }
            i2 += i;
            layout = layoutCreateUnrestrictedLayout;
            iMax = i7;
        }
        return arrayList;
    }

    private int getStartOffsetLeft(Layout layout, int i) {
        return (int) layout.getLineLeft(i);
    }

    private static int getSectionWidth(Layout layout, int i, int i2) {
        return (int) Layout.getDesiredWidth(layout.getText(), i, i2, layout.getPaint());
    }

    private static Layout createUnrestrictedLayout(TextView textView) {
        CharSequence text = textView.getText();
        Layout layout = textView.getLayout();
        layout.getPaint();
        return StaticLayout.Builder.obtain(text, 0, text.length(), layout.getPaint(), layout.getWidth()).setAlignment(layout.getAlignment()).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency()).build();
    }

    private static void drawLayerBounds(Canvas canvas, Rect rect, int i, Paint paint, Paint paint2, Paint paint3) {
        Rect rect2 = new Rect(rect.left + 1, rect.top + 1, rect.right - 1, rect.bottom - 1);
        canvas.drawRect(rect2, paint);
        canvas.drawRect(rect2, paint2);
        canvas.drawText("" + i, rect.left + 6, rect.top + 21, paint3);
    }

    private List<Animator> createRunAnimators(View view, Bitmap bitmap, Bitmap bitmap2, List<Run> list) {
        int i;
        int i2;
        boolean z;
        int i3;
        boolean z2;
        boolean z3;
        Rect rectCalculate = this.boundsCalculator.calculate(this.sourceView);
        Rect rectCalculate2 = this.boundsCalculator.calculate(this.targetView);
        ArrayList arrayList = new ArrayList(list.size());
        int i4 = rectCalculate2.left - rectCalculate.left;
        int i5 = rectCalculate2.top - rectCalculate.top;
        int i6 = 1;
        boolean z4 = rectCalculate.centerY() > rectCalculate2.centerY();
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        if (this.showLayers) {
            Paint paint = new Paint();
            paint.setTextSize(20.0f);
            paint.setColor(-16777216);
            Paint paint2 = new Paint();
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(1.0f);
            paint2.setColor(-2130771968);
            Paint paint3 = new Paint();
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setStrokeWidth(1.0f);
            paint3.setColor(-2130771968);
            int[] intArray = this.sourceView.getResources().getIntArray(C4396R.array.debug_colors);
            Canvas canvas = new Canvas(bitmap);
            Canvas canvas2 = new Canvas(bitmap2);
            Paint paint4 = new Paint();
            int i7 = 1;
            int i8 = 0;
            for (Run run : list) {
                int i9 = i8 + 1;
                paint4.setColor(intArray[i8 % intArray.length]);
                paint4.setAlpha(128);
                Paint paint5 = paint4;
                Canvas canvas3 = canvas2;
                int i10 = i7;
                drawLayerBounds(canvas, run.getStart(), i10, paint5, paint2, paint);
                drawLayerBounds(canvas3, run.getEnd(), i10, paint5, paint2, paint);
                i7++;
                canvas2 = canvas3;
                paint4 = paint5;
                i8 = i9;
                canvas = canvas;
                intArray = intArray;
            }
        }
        int size = z4 ? 0 : list.size() - 1;
        long j = 0;
        boolean z5 = true;
        boolean z6 = true;
        while (true) {
            if ((!z4 || size >= list.size()) && (z4 || size < 0)) {
                break;
            }
            Run run2 = list.get(size);
            if (run2.isStartVisible() || run2.isEndVisible()) {
                SwitchDrawable switchDrawable = new SwitchDrawable(bitmap, run2.getStart(), this.fontSizeGetter.get(this.sourceView), bitmap2, run2.getEnd(), this.fontSizeGetter.get(this.targetView), this.textColorGetter.get(this.sourceView), this.textColorGetter.get(this.targetView));
                i = size;
                switchDrawable.setBounds(run2.getStart().left, run2.getStart().top, run2.getStart().right, run2.getStart().bottom);
                view.getOverlay().add(switchDrawable);
                i2 = i5;
                z = z4;
                i3 = 1;
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(switchDrawable, getPathValuesHolder(run2, i5, i4), PropertyValuesHolder.ofInt(SwitchDrawable.WIDTH, run2.getStart().width(), run2.getEnd().width()), PropertyValuesHolder.ofInt(SwitchDrawable.HEIGHT, run2.getStart().height(), run2.getEnd().height()), PropertyValuesHolder.ofFloat(SwitchDrawable.PROGRESS, 0.0f, 1.0f));
                boolean z7 = run2.getStart().centerX() + i4 < run2.getEnd().centerX();
                if (run2.isStartVisible() && run2.isEndVisible() && !z5 && z7 != z6) {
                    long j2 = this.staggerDelay;
                    j += j2;
                    this.staggerDelay = (long) (j2 * STAGGER_DECAY);
                }
                objectAnimatorOfPropertyValuesHolder.setStartDelay(j);
                long jMax = Math.max(this.minDuration, this.duration - (j / 2));
                if (this.calculateDuration) {
                    objectAnimatorOfPropertyValuesHolder.setDuration(jMax);
                }
                arrayList.add(objectAnimatorOfPropertyValuesHolder);
                if (run2.isStartVisible() != run2.isEndVisible()) {
                    ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(switchDrawable, SwitchDrawable.ALPHA, run2.isStartVisible() ? 255 : 0, run2.isEndVisible() ? 255 : 0);
                    if (this.calculateDuration) {
                        objectAnimatorOfInt.setDuration((this.duration + j) / 2);
                    }
                    if (!run2.isStartVisible()) {
                        z2 = false;
                        switchDrawable.setAlpha(0);
                        objectAnimatorOfInt.setStartDelay((this.duration + j) / 2);
                    } else {
                        z2 = false;
                        objectAnimatorOfInt.setStartDelay(j);
                    }
                    arrayList.add(objectAnimatorOfInt);
                } else {
                    z2 = false;
                    ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(switchDrawable, SwitchDrawable.ALPHA, 255, 204, 255);
                    objectAnimatorOfInt2.setStartDelay(j);
                    if (this.calculateDuration) {
                        objectAnimatorOfInt2.setDuration(this.duration + j);
                    }
                    objectAnimatorOfInt2.setInterpolator(linearInterpolator);
                    arrayList.add(objectAnimatorOfInt2);
                }
                z6 = z7;
                z3 = z2;
            } else {
                z = z4;
                i2 = i5;
                i = size;
                i3 = i6;
                z3 = z5;
            }
            size = i + (z ? i3 : -1);
            z5 = z3;
            z4 = z;
            i5 = i2;
            i6 = i3;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Path getPath(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(f, f2);
        path.lineTo(f3, f4);
        return path;
    }

    private PropertyValuesHolder getPathValuesHolder(Run run, int i, int i2) {
        if (IS_LOLLIPOP_OR_ABOVE) {
            return PropertyValuesHolder.ofObject(SwitchDrawable.TOP_LEFT, (TypeConverter) null, new PathMotion() { // from class: com.shazam.android.widget.text.reflow.ReflowTextAnimatorHelper.2
                @Override // android.transition.PathMotion
                public Path getPath(float f, float f2, float f3, float f4) {
                    return ReflowTextAnimatorHelper.getPath(f, f2, f3, f4);
                }
            }.getPath(run.getEnd().left - i2, run.getEnd().top - i, run.getStart().left, run.getStart().top));
        }
        return PropertyValuesHolder.ofObject(SwitchDrawable.TOP_LEFT, new TypeEvaluator<PointF>() { // from class: com.shazam.android.widget.text.reflow.ReflowTextAnimatorHelper.3
            private final PointF point = new PointF();

            @Override // android.animation.TypeEvaluator
            public PointF evaluate(float f, PointF pointF, PointF pointF2) {
                this.point.set(pointF.x + ((pointF2.x - pointF.x) * f), pointF.y + ((pointF2.y - pointF.y) * f));
                return this.point;
            }
        }, new PointF(run.getStart().left, run.getStart().top), new PointF(run.getEnd().left - i2, run.getEnd().top - i));
    }

    private Bitmap createBitmap(View view) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight() * (this.showLayers ? 3 : 1), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    private long calculateDuration(Rect rect, Rect rect2) {
        return Math.max(this.minDuration, Math.min(this.maxDuration, (long) ((((float) Math.hypot(rect.exactCenterX() - rect2.exactCenterX(), rect.exactCenterY() - rect2.exactCenterY())) / this.velocity) * 1000.0f)));
    }

    public static class Builder {
        private static final boolean DEFAULT_CALCULATE_DURATION = true;
        private static final long DEFAULT_MAX_DURATION = 400;
        private static final long DEFAULT_MIN_DURATION = 200;
        private static final long DEFAULT_STAGGER = 40;
        private static final long DEFAULT_VELOCITY = 700;
        private TextView sourceView;
        private TextView targetView;
        private static final TextSizeGetter DEFAULT_FONT_SIZE_GETTER = new TextSizeGetter() { // from class: com.shazam.android.widget.text.reflow.ReflowTextAnimatorHelper$Builder$$ExternalSyntheticLambda1
            @Override // com.shazam.android.widget.text.reflow.TextSizeGetter
            public final float get(TextView textView) {
                return textView.getTextSize();
            }
        };
        private static final TextColorGetter DEFAULT_TEXT_COLOR_GETTER = new TextColorGetter() { // from class: com.shazam.android.widget.text.reflow.ReflowTextAnimatorHelper$Builder$$ExternalSyntheticLambda2
            @Override // com.shazam.android.widget.text.reflow.TextColorGetter
            public final int get(TextView textView) {
                return textView.getCurrentTextColor();
            }
        };
        private boolean showLayers = false;
        private long minDuration = DEFAULT_MIN_DURATION;
        private long maxDuration = 400;
        private long staggerDelay = DEFAULT_STAGGER;
        private long velocity = 700;
        private boolean freezeOnLastFrame = false;
        private boolean calculateDuration = true;
        private TextSizeGetter fontSizeGetter = DEFAULT_FONT_SIZE_GETTER;
        private TextColorGetter textColorGetter = DEFAULT_TEXT_COLOR_GETTER;
        private BoundsCalculator boundsCalculator = new BoundsCalculator() { // from class: com.shazam.android.widget.text.reflow.ReflowTextAnimatorHelper$Builder$$ExternalSyntheticLambda0
            @Override // com.shazam.android.widget.text.reflow.BoundsCalculator
            public final Rect calculate(View view) {
                return ReflowTextAnimatorHelper.Builder.lambda$new$0(view);
            }
        };

        static /* synthetic */ Rect lambda$new$0(View view) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int i = iArr[0];
            return new Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight());
        }

        public Builder(TextView textView, TextView textView2) {
            this.sourceView = textView;
            this.targetView = textView2;
            if (textView == null) {
                throw new IllegalArgumentException("Source view can't be null");
            }
            ViewCompat.isLaidOut(textView);
            TextView textView3 = this.targetView;
            if (textView3 == null) {
                throw new IllegalArgumentException("Target view can't be null");
            }
            ViewCompat.isLaidOut(textView3);
        }

        public Builder debug(boolean z) {
            this.showLayers = z;
            return this;
        }

        public Builder withDuration(long j, long j2) {
            this.minDuration = j;
            this.maxDuration = j2;
            return this;
        }

        public Builder calculateDuration(boolean z) {
            this.calculateDuration = z;
            return this;
        }

        public Builder setBoundsCalculator(BoundsCalculator boundsCalculator) {
            this.boundsCalculator = boundsCalculator;
            return this;
        }

        public Builder withStaggerDelay(long j) {
            this.staggerDelay = j;
            return this;
        }

        public void setFontSizeGetter(TextSizeGetter textSizeGetter) {
            this.fontSizeGetter = textSizeGetter;
        }

        public Builder setTextColorGetter(TextColorGetter textColorGetter) {
            this.textColorGetter = textColorGetter;
            return this;
        }

        public Builder withVelocity(long j) {
            this.velocity = j;
            return this;
        }

        public Builder withFreezeOnLastFrame(boolean z) {
            this.freezeOnLastFrame = z;
            return this;
        }

        public ReflowTextAnimatorHelper build() {
            return new ReflowTextAnimatorHelper(this);
        }

        public Animator buildAnimator() {
            if (this.freezeOnLastFrame) {
                throw new IllegalStateException("Use build() to retain ability to unfreeze() the Helper.");
            }
            return build().createAnimator();
        }
    }
}
