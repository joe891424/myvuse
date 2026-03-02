package com.microblink.view.viewfinder;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.microblink.library.C3714R;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class ViewfinderShapeView extends View {
    private Paint IlIllIlIIl;
    private Xfermode IllIIIIllI;
    private Paint IllIIIllII;
    private Paint lIlIIIIlIl;
    private ShapeType llIIIlllll;
    private float llIIlIIlll;
    private Paint llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    public enum ShapeType {
        RECTANGLE(0),
        CIRCLE(1);

        public final int value;

        ShapeType(int i) {
            this.value = i;
        }

        public static ShapeType fromValue(int i) {
            for (ShapeType shapeType : values()) {
                if (shapeType.value == i) {
                    return shapeType;
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: line */
    static /* synthetic */ class llIIlIlIIl {
        static final /* synthetic */ int[] llIIlIlIIl;

        static {
            int[] iArr = new int[ShapeType.values().length];
            llIIlIlIIl = iArr;
            try {
                iArr[ShapeType.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                llIIlIlIIl[ShapeType.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ViewfinderShapeView(Context context) {
        this(context, null);
    }

    private void llIIlIlIIl(ShapeType shapeType, Canvas canvas, Paint paint, float f, float f2, float f3) {
        int i = llIIlIlIIl.llIIlIlIIl[shapeType.ordinal()];
        if (i == 1) {
            canvas.drawCircle(f / 2.0f, f2 / 2.0f, (Math.min(f, f2) / 2.0f) - f3, paint);
        } else {
            if (i != 2) {
                return;
            }
            RectF rectF = new RectF(f3, f3, f - f3, f2 - f3);
            float f4 = this.llIIlIIlll;
            canvas.drawRoundRect(rectF, f4, f4, paint);
        }
    }

    public int getBorderColor() {
        return this.llIIlIlIIl.getColor();
    }

    public float getBorderWidth() {
        return this.llIIlIlIIl.getStrokeWidth();
    }

    public float getInnerAlpha() {
        return this.IlIllIlIIl.getAlpha() / 255.0f;
    }

    public int getInnerColor() {
        return this.IlIllIlIIl.getColor();
    }

    public int getOuterColor() {
        return this.IllIIIllII.getColor();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
        canvas2.drawPaint(this.IllIIIllII);
        this.lIlIIIIlIl.setXfermode(this.IllIIIIllI);
        this.lIlIIIIlIl.setStyle(Paint.Style.FILL);
        float f = width;
        float f2 = height;
        llIIlIlIIl(this.llIIIlllll, canvas2, this.lIlIIIIlIl, f, f2, 1.0f);
        float strokeWidth = this.llIIlIlIIl.getStrokeWidth();
        llIIlIlIIl(this.llIIIlllll, canvas2, this.IlIllIlIIl, f, f2, strokeWidth);
        llIIlIlIIl(this.llIIIlllll, canvas2, this.llIIlIlIIl, f, f2, strokeWidth / 2.0f);
        this.lIlIIIIlIl.setXfermode(null);
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, this.lIlIIIIlIl);
    }

    public void setBorderColor(int i) {
        this.llIIlIlIIl.setColor(i);
        invalidate();
    }

    public void setBorderWidth(float f) {
        this.llIIlIlIIl.setStrokeWidth(f);
        invalidate();
    }

    public void setInnerAlpha(float f) {
        this.IlIllIlIIl.setAlpha(Math.round(f * 255.0f));
        invalidate();
    }

    public void setInnerColor(int i) {
        this.IlIllIlIIl.setColor(i);
        invalidate();
    }

    public void setOuterColor(int i) {
        this.IllIIIllII.setColor(i);
        invalidate();
    }

    public ViewfinderShapeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewfinderShapeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.IllIIIIllI = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.lIlIIIIlIl = new Paint(1);
        Resources resources = getResources();
        int integer = resources.getInteger(C3714R.integer.mb_default_shape_type);
        int color = ContextCompat.getColor(context, C3714R.color.mb_default_selfie_overlay_shape_inner_color);
        int color2 = ContextCompat.getColor(context, C3714R.color.mb_default_selfie_overlay_shape_outer_color);
        int color3 = ContextCompat.getColor(context, C3714R.color.mb_default_selfie_overlay_shape_border_color);
        float dimension = resources.getDimension(C3714R.dimen.mb_default_selfie_overlay_shape_border_width);
        float dimension2 = resources.getDimension(C3714R.dimen.mb_default_selfie_overlay_shape_corner_radius);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3714R.styleable.ViewfinderShapeView, i, 0);
        this.llIIIlllll = ShapeType.fromValue(typedArrayObtainStyledAttributes.getInteger(C3714R.styleable.ViewfinderShapeView_mb_shapeType, integer));
        this.llIIlIIlll = typedArrayObtainStyledAttributes.getDimension(C3714R.styleable.ViewfinderShapeView_mb_cornerRadius, dimension2);
        Paint paint = new Paint(1);
        this.llIIlIlIIl = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.llIIlIlIIl.setColor(typedArrayObtainStyledAttributes.getColor(C3714R.styleable.ViewfinderShapeView_mb_borderColor, color3));
        this.llIIlIlIIl.setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(C3714R.styleable.ViewfinderShapeView_mb_borderWidth, dimension));
        Paint paint2 = new Paint(1);
        this.IlIllIlIIl = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.IlIllIlIIl.setColor(typedArrayObtainStyledAttributes.getColor(C3714R.styleable.ViewfinderShapeView_mb_innerColor, color));
        Paint paint3 = new Paint(1);
        this.IllIIIllII = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.IllIIIllII.setColor(typedArrayObtainStyledAttributes.getColor(C3714R.styleable.ViewfinderShapeView_mb_outerColor, color2));
        typedArrayObtainStyledAttributes.recycle();
    }
}
