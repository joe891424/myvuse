package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.google.android.material.button.MaterialButton;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;

/* JADX INFO: loaded from: classes5.dex */
public class YotiButton extends MaterialButton {

    /* JADX INFO: renamed from: a */
    private Drawable f6016a;

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiButton$a */
    class C4481a implements Drawable.Callback {
        C4481a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            YotiButton.this.invalidate();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        }
    }

    public YotiButton(Context context) {
        super(context);
    }

    public YotiButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C4584R.styleable.YotiButton, 0, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiButton_textUnderline, false);
            typedArrayObtainStyledAttributes.recycle();
            setTextUnderline(z);
            this.f6016a = getIcon();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private CircularProgressDrawable m4414a() {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        circularProgressDrawable.setStyle(0);
        int centerRadius = ((int) (circularProgressDrawable.getCenterRadius() + circularProgressDrawable.getStrokeWidth())) * 2;
        circularProgressDrawable.setColorSchemeColors(getTextColors().getDefaultColor());
        circularProgressDrawable.setBounds(0, 0, centerRadius, centerRadius);
        return circularProgressDrawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private void m4415a(Drawable drawable) {
        drawable.setCallback(new C4481a());
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        super.setIcon(drawable);
        setIconGravity(3);
        if (this.f6016a == null) {
            m4417c();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4416b() {
        setPaddingRelative(getPaddingStart() - getContext().getResources().getDimensionPixelSize(C4584R.dimen.loading_padding_end), getPaddingTop(), getPaddingEnd(), getPaddingBottom());
    }

    /* JADX INFO: renamed from: c */
    private void m4417c() {
        setPaddingRelative(getPaddingStart() + getContext().getResources().getDimensionPixelSize(C4584R.dimen.loading_padding_end), getPaddingTop(), getPaddingEnd(), getPaddingBottom());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void hideProgress() {
        Drawable icon = getIcon();
        if (icon instanceof Animatable) {
            ((Animatable) icon).stop();
            icon.setCallback(null);
        }
        super.setIcon(this.f6016a);
        setIconGravity(3);
        if (this.f6016a == null) {
            m4416b();
        }
    }

    public void setDrawableTint(int i) {
        for (Drawable drawable : getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setIcon(Drawable drawable) {
        super.setIcon(drawable);
        this.f6016a = drawable;
    }

    public void setTextUnderline(boolean z) {
        setPaintFlags(z ? getPaintFlags() | 8 : getPaintFlags() & (-9));
    }

    public void showProgress() {
        m4415a(m4414a());
    }
}
