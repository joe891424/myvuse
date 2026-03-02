package com.yoti.mobile.android.common.p049ui.widgets;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;

/* JADX INFO: loaded from: classes5.dex */
public class YotiRadioButton extends RelativeLayout implements Checkable {

    /* JADX INFO: renamed from: h */
    private static final int[] f6244h = {R.attr.state_checked};

    /* JADX INFO: renamed from: a */
    private ViewGroup f6245a;

    /* JADX INFO: renamed from: b */
    private RadioButton f6246b;

    /* JADX INFO: renamed from: c */
    private TextView f6247c;

    /* JADX INFO: renamed from: d */
    private LottieAnimationView f6248d;

    /* JADX INFO: renamed from: e */
    private OnCheckedChangeListener f6249e;

    /* JADX INFO: renamed from: f */
    private int f6250f;

    /* JADX INFO: renamed from: g */
    private int f6251g;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(YotiRadioButton yotiRadioButton, boolean z);
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiRadioButton$a */
    class C4532a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiRadioButton$a$a */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                YotiRadioButton.this.f6248d.removeAnimatorListener(this);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                YotiRadioButton.this.f6248d.removeAnimatorListener(this);
            }
        }

        C4532a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (YotiRadioButton.this.getParent() instanceof YotiRadioGroup) {
                ((YotiRadioGroup) YotiRadioButton.this.getParent()).onChildCheckedChanged(YotiRadioButton.this, z);
            }
            if (YotiRadioButton.this.f6249e != null) {
                YotiRadioButton.this.f6249e.onCheckedChanged(YotiRadioButton.this, z);
            }
            YotiRadioButton.this.f6248d.setAnimation(z ? "lottie/radiobutton_indicator_selected.json" : "lottie/radiobutton_indicator_unselected.json");
            YotiRadioButton.this.f6248d.addAnimatorListener(new a());
            YotiRadioButton.this.f6248d.playAnimation();
            YotiRadioButton.this.m4573a(z);
            if (z) {
                YotiRadioButton.this.f6245a.sendAccessibilityEvent(8);
            }
        }
    }

    public YotiRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6250f = 0;
        this.f6251g = 0;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C4584R.styleable.YotiRadioButton, 0, 0);
        try {
            CharSequence text = typedArrayObtainStyledAttributes.getText(C4584R.styleable.YotiRadioButton_android_text);
            CharSequence text2 = typedArrayObtainStyledAttributes.getText(C4584R.styleable.YotiRadioButton_radioAdditionalText);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(C4584R.styleable.YotiRadioButton_radioTextAppearance, C4584R.style.Yoti_v3_Font_DisplayRegular);
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(C4584R.styleable.YotiRadioButton_radioAdditionalTextAppearance, C4584R.style.Yoti_v3_Font_DisplayRegular);
            boolean z = typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiRadioButton_radioTextSingleLine, true);
            RelativeLayout.inflate(context, typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiRadioButton_radioMultiLine, false) ? C4584R.layout.yoti_radiobutton_multiline : typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiRadioButton_radioInverted, false) ? C4584R.layout.yoti_radiobutton_inversed : C4584R.layout.yoti_radiobutton, this);
            this.f6245a = (ViewGroup) findViewById(C4584R.id.rootView);
            this.f6246b = (RadioButton) findViewById(C4584R.id.radio_button);
            this.f6247c = (TextView) findViewById(C4584R.id.tv_additional);
            this.f6248d = (LottieAnimationView) findViewById(C4584R.id.radiobutton_indicator);
            this.f6246b.setSingleLine(z);
            this.f6246b.setOnCheckedChangeListener(new C4532a());
            this.f6246b.setText(text);
            setAdditionalText(text2);
            TextViewCompat.setTextAppearance(this.f6246b, resourceId);
            TextViewCompat.setTextAppearance(this.f6247c, resourceId2);
            m4573a(this.f6246b.isChecked());
            if (typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiRadioButton_radioMultiLineWithSpaceAdjustment, false)) {
                m4570a(typedArrayObtainStyledAttributes, context);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4570a(TypedArray typedArray, Context context) {
        this.f6246b.setMinimumHeight(0);
        float dimension = typedArray.getDimension(C4584R.styleable.YotiRadioButton_radioTextStartMargin, context.getResources().getDimensionPixelSize(C4584R.dimen.radiobutton_text_start_margin_default));
        float dimension2 = typedArray.getDimension(C4584R.styleable.YotiRadioButton_radioTextTopMargin, context.getResources().getDimensionPixelSize(C4584R.dimen.radiobutton_text_top_margin_default));
        float dimension3 = typedArray.getDimension(C4584R.styleable.YotiRadioButton_radioAdditionalTextTopMargin, context.getResources().getDimensionPixelSize(C4584R.dimen.radiobutton_additional_text_top_margin_default));
        float dimension4 = typedArray.getDimension(C4584R.styleable.YotiRadioButton_radioAdditionalTextBottomMargin, context.getResources().getDimensionPixelSize(C4584R.dimen.radiobutton_additional_text_bottom_margin_default));
        float dimension5 = typedArray.getDimension(C4584R.styleable.YotiRadioButton_radioIconStartMargin, context.getResources().getDimensionPixelSize(C4584R.dimen.radiobutton_icon_start_margin_default));
        float dimension6 = typedArray.getDimension(C4584R.styleable.YotiRadioButton_radioIconEndMargin, context.getResources().getDimensionPixelSize(C4584R.dimen.radiobutton_icon_end_margin_default));
        m4571a(this.f6246b, dimension, dimension2, 0.0f, 0.0f);
        m4571a(this.f6247c, 0.0f, dimension3, 0.0f, dimension4);
        m4571a(this.f6248d, dimension5, 0.0f, dimension6, 0.0f);
    }

    /* JADX INFO: renamed from: a */
    private void m4571a(View view, float f, float f2, float f3, float f4) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        int i = (int) f;
        int i2 = (int) f3;
        layoutParams.setMargins(i, (int) f2, i2, (int) f4);
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(i2);
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m4573a(boolean z) {
        String string = this.f6246b.getText().toString();
        if (this.f6247c.getVisibility() != 8 && this.f6247c.getText().length() > 0) {
            string = string + ", " + this.f6247c.getText().toString();
        }
        this.f6245a.setContentDescription(z ? getResources().getString(C4584R.string.loc_radio_button_selected_accessibility, string, Integer.valueOf(this.f6250f), Integer.valueOf(this.f6251g)) : getResources().getString(C4584R.string.loc_radio_button_default_accessibility, string, Integer.valueOf(this.f6250f), Integer.valueOf(this.f6251g)));
    }

    public void bindForAccessibility(int i, int i2) {
        this.f6250f = i;
        this.f6251g = i2;
        m4573a(isChecked());
    }

    public RadioButton getRadioButton() {
        return this.f6246b;
    }

    public String getText() {
        return getRadioButton().getText().toString();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return getRadioButton().isChecked();
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (getRadioButton() == null || !isChecked()) {
            return super.onCreateDrawableState(i);
        }
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        View.mergeDrawableStates(iArrOnCreateDrawableState, f6244h);
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.f6248d.getProgress() > 0.0f && this.f6248d.getProgress() < 1.0f) {
            this.f6248d.setProgress(1.0f);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return motionEvent.getActionMasked() == 0;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return this.f6246b.performClick();
    }

    public void setAdditionalText(CharSequence charSequence) {
        this.f6247c.setText(charSequence);
        this.f6247c.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public void setAdditionalTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.f6247c, i);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        getRadioButton().setChecked(z);
        refreshDrawableState();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f6246b.setEnabled(z);
        this.f6247c.setEnabled(z);
        this.f6248d.setAlpha(z ? 1.0f : 0.5f);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f6249e = onCheckedChangeListener;
    }

    public void setText(int i) {
        getRadioButton().setText(i);
    }

    public void setText(CharSequence charSequence) {
        getRadioButton().setText(charSequence);
    }

    public void setTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.f6246b, i);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        getRadioButton().toggle();
    }
}
