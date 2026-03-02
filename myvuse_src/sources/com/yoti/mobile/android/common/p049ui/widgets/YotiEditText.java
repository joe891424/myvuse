package com.yoti.mobile.android.common.p049ui.widgets;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.color.MaterialColors;
import com.yoti.mobile.android.common.p049ui.widgets.utils.AnimationUtils;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;

/* JADX INFO: loaded from: classes5.dex */
public class YotiEditText extends ConstraintLayout {

    /* JADX INFO: renamed from: A */
    private String f6043A;

    /* JADX INFO: renamed from: B */
    private LottieAnimationView f6044B;

    /* JADX INFO: renamed from: C */
    private LottieAnimationView f6045C;

    /* JADX INFO: renamed from: D */
    private ConstraintLayout f6046D;

    /* JADX INFO: renamed from: E */
    private View f6047E;

    /* JADX INFO: renamed from: F */
    private TextView f6048F;

    /* JADX INFO: renamed from: G */
    private TextView f6049G;

    /* JADX INFO: renamed from: H */
    private boolean f6050H;

    /* JADX INFO: renamed from: I */
    private boolean f6051I;

    /* JADX INFO: renamed from: J */
    private Runnable f6052J;

    /* JADX INFO: renamed from: K */
    private AnimationCompletionListener f6053K;

    /* JADX INFO: renamed from: L */
    private boolean f6054L;

    /* JADX INFO: renamed from: M */
    private boolean f6055M;

    /* JADX INFO: renamed from: N */
    private ILabelDrawListener f6056N;

    /* JADX INFO: renamed from: a */
    private int f6057a;

    /* JADX INFO: renamed from: b */
    private final int f6058b;

    /* JADX INFO: renamed from: c */
    private final int f6059c;

    /* JADX INFO: renamed from: d */
    private final int f6060d;

    /* JADX INFO: renamed from: e */
    private final int f6061e;

    /* JADX INFO: renamed from: f */
    private int f6062f;

    /* JADX INFO: renamed from: g */
    private boolean f6063g;

    /* JADX INFO: renamed from: h */
    private boolean f6064h;

    /* JADX INFO: renamed from: i */
    private int f6065i;

    /* JADX INFO: renamed from: j */
    private int f6066j;

    /* JADX INFO: renamed from: k */
    private int f6067k;

    /* JADX INFO: renamed from: l */
    private String f6068l;

    /* JADX INFO: renamed from: m */
    private String f6069m;

    /* JADX INFO: renamed from: n */
    private String f6070n;

    /* JADX INFO: renamed from: o */
    private String f6071o;

    /* JADX INFO: renamed from: p */
    private String f6072p;

    /* JADX INFO: renamed from: q */
    private boolean f6073q;

    /* JADX INFO: renamed from: r */
    private boolean f6074r;

    /* JADX INFO: renamed from: s */
    private boolean f6075s;

    /* JADX INFO: renamed from: t */
    private Drawable f6076t;

    /* JADX INFO: renamed from: u */
    private int f6077u;

    /* JADX INFO: renamed from: v */
    private boolean f6078v;

    /* JADX INFO: renamed from: w */
    private int f6079w;

    /* JADX INFO: renamed from: x */
    private int f6080x;

    /* JADX INFO: renamed from: y */
    private TextView f6081y;

    /* JADX INFO: renamed from: z */
    private EditText f6082z;

    public interface ILabelDrawListener {
        void onLabelDraw();
    }

    public interface YotiEditTextSubmitAction {
        void invoke();
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiEditText$a */
    class C4486a extends AnimationUtils.OnTransitionStart {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ int f6083a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f6084b;

        C4486a(int i, int i2) {
            this.f6083a = i;
            this.f6084b = i2;
        }

        @Override // com.yoti.mobile.android.common.ui.widgets.utils.AnimationUtils.OnTransitionStart, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            if (YotiEditText.this.f6062f == C4584R.layout.input_field_focused) {
                YotiEditText.this.m4454d();
            }
            if (this.f6083a == C4584R.layout.input_field_default) {
                YotiEditText.this.m4435A();
            }
            if (this.f6084b == C4584R.layout.input_field_default) {
                YotiEditText.this.m4492z();
            }
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(YotiEditText.this.getContext(), this.f6083a);
            constraintSet.applyTo(YotiEditText.this.f6046D);
        }

        @Override // com.yoti.mobile.android.common.ui.widgets.utils.AnimationUtils.OnTransitionStart, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            if (this.f6083a == C4584R.layout.input_field_default) {
                AnimationUtils.animateAlpha(YotiEditText.this.f6082z, 1.0f, 0.0f, 250L);
                AnimationUtils.animateTextSize(YotiEditText.this.f6081y, 14, 17, 250L);
            }
            if (this.f6084b == C4584R.layout.input_field_default) {
                AnimationUtils.animateAlpha(YotiEditText.this.f6082z, 0.0f, 1.0f, 250L);
                AnimationUtils.animateTextSize(YotiEditText.this.f6081y, 17, 14, 250L);
            }
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiEditText$b */
    class C4487b extends AccessibilityDelegateCompat {
        C4487b() {
        }

        /* JADX INFO: renamed from: a */
        private String m4493a(String str, String str2) {
            return (str2 == null ? new StringBuilder().append((Object) YotiEditText.this.f6081y.getText()).append(str) : new StringBuilder().append((Object) YotiEditText.this.f6081y.getText()).append(str2)).append(". ").append(YotiEditText.this.getContext().getString(C4584R.string.loc_editbox_default_accessibility)).toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public /* synthetic */ void m4494a() {
            if (YotiEditText.this.f6082z.getText() == null || YotiEditText.this.f6082z.getText().length() <= 0) {
                return;
            }
            YotiEditText.this.f6082z.setSelection(YotiEditText.this.f6082z.getText().length());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            if (accessibilityEvent.getEventType() == 1) {
                YotiEditText.this.f6082z.setImportantForAccessibility(1);
                YotiEditText.this.m4475o();
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setText(m4493a((YotiEditText.this.f6049G.getVisibility() != 0 || YotiEditText.this.f6072p == null) ? "" : ". " + YotiEditText.this.f6072p, ((YotiEditText.this.f6048F.getVisibility() == 0 && YotiEditText.this.f6048F.getAlpha() == 1.0f) || YotiEditText.this.isValidationTickOnScreen()) ? String.format(YotiEditText.this.getContext().getString(C4584R.string.loc_editbox_error_accessibility), YotiEditText.this.f6048F.getText().toString()) : null));
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (128 == accessibilityEvent.getEventType() && view == YotiEditText.this.f6082z) {
                YotiEditText.this.getHandler().postDelayed(new Runnable() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiEditText$b$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m4494a();
                    }
                }, 500L);
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiEditText$c */
    class C4488c extends AccessibilityDelegateCompat {
        C4488c() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setText(String.format(YotiEditText.this.getContext().getString(C4584R.string.loc_editbox_editing_accessibility), YotiEditText.this.f6082z.getText(), YotiEditText.this.f6081y.getText()));
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiEditText$d */
    class ViewOnClickListenerC4489d implements View.OnClickListener {
        ViewOnClickListenerC4489d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (YotiEditText.this.f6050H) {
                YotiEditText.this.m4452c();
                YotiEditText.this.m4448b();
            }
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiEditText$e */
    class ViewOnFocusChangeListenerC4490e implements View.OnFocusChangeListener {
        ViewOnFocusChangeListenerC4490e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (YotiEditText.this.f6063g) {
                YotiEditText yotiEditText = YotiEditText.this;
                if (z) {
                    yotiEditText.m4475o();
                } else {
                    yotiEditText.m4477p();
                    YotiEditText.this.f6082z.setImportantForAccessibility(2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiEditText$f */
    class C4491f implements TextWatcher {
        C4491f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String string = editable.toString();
            if (string.isEmpty()) {
                YotiEditText.this.m4458f();
            } else {
                YotiEditText.this.m4483s();
            }
            if (YotiEditText.this.m4450b(string) && string.isEmpty()) {
                YotiEditText.this.setAsNeutral();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiEditText$g */
    class ViewTreeObserverOnGlobalLayoutListenerC4492g implements ViewTreeObserver.OnGlobalLayoutListener {
        ViewTreeObserverOnGlobalLayoutListenerC4492g() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            YotiEditText.this.f6056N.onLabelDraw();
            YotiEditText.this.f6081y.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiEditText$h */
    class C4493h implements Animator.AnimatorListener {
        C4493h() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (YotiEditText.this.f6053K != null) {
                YotiEditText.this.f6053K.onAnimationComplete();
                YotiEditText.this.f6053K = null;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            YotiEditText.this.f6048F.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiEditText$i */
    class C4494i extends AnimationUtils.OnAnimationEnd {
        C4494i() {
        }

        @Override // com.yoti.mobile.android.common.ui.widgets.utils.AnimationUtils.OnAnimationEnd, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            YotiEditText.this.f6048F.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiEditText$j */
    class C4495j extends AnimationUtils.OnAnimationStart {
        C4495j() {
        }

        @Override // com.yoti.mobile.android.common.ui.widgets.utils.AnimationUtils.OnAnimationStart, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            YotiEditText.this.f6049G.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiEditText$k */
    class C4496k extends AnimationUtils.OnAnimationEnd {
        C4496k() {
        }

        @Override // com.yoti.mobile.android.common.ui.widgets.utils.AnimationUtils.OnAnimationEnd, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            YotiEditText.this.f6049G.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiEditText$l */
    class C4497l implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ int f6096a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f6097b;

        C4497l(int i, int i2) {
            this.f6096a = i;
            this.f6097b = i2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            YotiEditText.this.f6082z.setAlpha(this.f6096a);
            YotiEditText.this.f6081y.setTextSize(this.f6097b);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiEditText$m */
    private static class C4498m extends View.BaseSavedState {
        public static final Parcelable.Creator<C4498m> CREATOR = new a();

        /* JADX INFO: renamed from: a */
        String f6099a;

        /* JADX INFO: renamed from: b */
        int f6100b;

        /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiEditText$m$a */
        static class a implements Parcelable.Creator<C4498m> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C4498m createFromParcel(Parcel parcel) {
                return new C4498m(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C4498m[] newArray(int i) {
                return new C4498m[i];
            }
        }

        private C4498m(Parcel parcel) {
            super(parcel);
            this.f6099a = parcel.readString();
            this.f6100b = parcel.readInt();
        }

        /* synthetic */ C4498m(Parcel parcel, ViewOnClickListenerC4489d viewOnClickListenerC4489d) {
            this(parcel);
        }

        C4498m(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f6099a);
            parcel.writeInt(this.f6100b);
        }
    }

    public YotiEditText(Context context) {
        super(context);
        this.f6057a = 0;
        this.f6058b = C4584R.layout.input_field_default;
        this.f6059c = C4584R.layout.input_field_focused;
        this.f6060d = C4584R.layout.input_field_validation;
        this.f6061e = C4584R.layout.input_field_validation_invalid;
        this.f6062f = 0;
        this.f6063g = true;
        this.f6064h = false;
        this.f6043A = null;
        this.f6052J = null;
        this.f6053K = null;
        this.f6056N = null;
        m4465j();
    }

    public YotiEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6057a = 0;
        this.f6058b = C4584R.layout.input_field_default;
        this.f6059c = C4584R.layout.input_field_focused;
        this.f6060d = C4584R.layout.input_field_validation;
        this.f6061e = C4584R.layout.input_field_validation_invalid;
        this.f6062f = 0;
        this.f6063g = true;
        this.f6064h = false;
        this.f6043A = null;
        this.f6052J = null;
        this.f6053K = null;
        this.f6056N = null;
        m4442a(attributeSet);
        m4465j();
    }

    public YotiEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6057a = 0;
        this.f6058b = C4584R.layout.input_field_default;
        this.f6059c = C4584R.layout.input_field_focused;
        this.f6060d = C4584R.layout.input_field_validation;
        this.f6061e = C4584R.layout.input_field_validation_invalid;
        this.f6062f = 0;
        this.f6063g = true;
        this.f6064h = false;
        this.f6043A = null;
        this.f6052J = null;
        this.f6053K = null;
        this.f6056N = null;
        m4442a(attributeSet);
        m4465j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: A */
    public void m4435A() {
        if (this.f6081y.getTextSize() == 17.0f && this.f6082z.getAlpha() == 0.0f) {
            return;
        }
        this.f6082z.setAlpha(0.0f);
        this.f6081y.setTextSize(17.0f);
    }

    /* JADX INFO: renamed from: a */
    private void m4437a() {
        Handler handler;
        if (!m4456e() || (handler = getHandler()) == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiEditText$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4472m();
            }
        }, 1000L);
    }

    /* JADX INFO: renamed from: a */
    private void m4438a(int i) {
        m4441a(i, 0L);
    }

    /* JADX INFO: renamed from: a */
    private void m4439a(int i, int i2) {
        if (i2 == C4584R.layout.input_field_default) {
            Animator.AnimatorListener animatorListenerM4447b = m4447b(0, 17);
            AnimationUtils.animateTextSize(this.f6081y, 14, 17, 250L);
            AnimationUtils.animateAlpha(this.f6082z, 1.0f, 0.0f, 250L, animatorListenerM4447b);
        }
        if (i == C4584R.layout.input_field_default) {
            Animator.AnimatorListener animatorListenerM4447b2 = m4447b(1, 14);
            AnimationUtils.animateTextSize(this.f6081y, 17, 14, 250L);
            AnimationUtils.animateAlpha(this.f6082z, 0.0f, 1.0f, 250L, animatorListenerM4447b2);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4440a(int i, int i2, long j) {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(250L);
        if (j <= 0) {
            j = 0;
        }
        changeBounds.setStartDelay(j);
        changeBounds.addListener(new C4486a(i2, i));
        TransitionManager.beginDelayedTransition(this.f6046D, changeBounds);
    }

    /* JADX INFO: renamed from: a */
    private void m4441a(int i, long j) {
        int i2 = this.f6062f;
        if (i2 == i) {
            return;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(getContext(), i);
        constraintSet.setVisibility(this.f6049G.getId(), this.f6049G.getVisibility());
        constraintSet.setVisibility(this.f6048F.getId(), this.f6048F.getVisibility());
        constraintSet.setVisibility(this.f6045C.getId(), this.f6045C.getVisibility());
        constraintSet.applyTo(this.f6046D);
        if (j == 0) {
            m4439a(i2, i);
        } else {
            m4440a(i2, i, j);
        }
        this.f6062f = i;
        if (i != this.f6058b) {
            m4483s();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4442a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, C4584R.styleable.YotiEditText, 0, 0);
        try {
            this.f6065i = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiEditText_android_inputType, 0);
            this.f6066j = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiEditText_android_imeOptions, 0);
            this.f6067k = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiEditText_android_nextFocusDown, -1);
            this.f6068l = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiEditText_label);
            this.f6069m = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiEditText_error);
            this.f6070n = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiEditText_errorEmpty);
            this.f6071o = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiEditText_errorMaxCharacters);
            this.f6072p = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiEditText_hint);
            this.f6073q = typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiEditText_inputDisabled, false);
            this.f6074r = typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiEditText_isCharacterInputAllowedWhenValid, true);
            this.f6075s = typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiEditText_accessibilityDropdown, false);
            this.f6076t = typedArrayObtainStyledAttributes.getDrawable(C4584R.styleable.YotiEditText_icon);
            this.f6077u = typedArrayObtainStyledAttributes.getColor(C4584R.styleable.YotiEditText_iconTint, MaterialColors.getColor(this, C4584R.attr.icon_neutral_mid));
            this.f6078v = typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiEditText_multiline, false);
            this.f6079w = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiEditText_minLines, 1);
            this.f6080x = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiEditText_maxCharacters, -1);
            this.f6064h = typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiEditText_autoInvalid, false);
            this.f6054L = typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiEditText_allowEmptyErrorState, true);
            this.f6055M = typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiEditText_allowMultiLineErrorMessage, false);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4443a(String str) {
        if (str != null && !str.isEmpty()) {
            if (this.f6048F.getVisibility() == 0 && this.f6048F.getAlpha() == 1.0f) {
                if (this.f6048F.getText().equals(str)) {
                    return;
                }
                this.f6048F.setText(str);
                return;
            }
            this.f6048F.setText(str);
            AnimationUtils.animateAlpha(this.f6048F, 0.0f, 1.0f, 250L, new C4493h());
        }
        m4462h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ boolean m4444a(YotiEditTextSubmitAction yotiEditTextSubmitAction, TextView textView, int i, KeyEvent keyEvent) {
        if (yotiEditTextSubmitAction == null || i != 6) {
            return false;
        }
        yotiEditTextSubmitAction.invoke();
        return true;
    }

    /* JADX INFO: renamed from: b */
    private Animator.AnimatorListener m4447b(int i, int i2) {
        return new C4497l(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m4448b() {
        announceForAccessibility(getContext().getString(C4584R.string.loc_editbox_cleared_accessibility));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public boolean m4450b(String str) {
        if (this.f6080x <= -1) {
            return true;
        }
        if (str.length() > this.f6080x) {
            m4489w();
            return false;
        }
        if (this.f6057a != 2) {
            return false;
        }
        setAsInFocus();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m4452c() {
        this.f6082z.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m4454d() {
        if (m4456e()) {
            this.f6082z.setImportantForAccessibility(1);
            this.f6082z.sendAccessibilityEvent(128);
        }
    }

    /* JADX INFO: renamed from: e */
    private boolean m4456e() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        return accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m4458f() {
        if (this.f6073q || this.f6045C.getVisibility() == 8 || this.f6078v || !this.f6050H) {
            return;
        }
        this.f6045C.reverseAnimationSpeed();
        this.f6045C.playAnimation();
        this.f6050H = false;
        this.f6045C.setImportantForAccessibility(2);
    }

    /* JADX INFO: renamed from: g */
    private void m4460g() {
        if (this.f6048F.getVisibility() == 8 || this.f6048F.getAlpha() == 0.0f) {
            return;
        }
        AnimationUtils.animateAlpha(this.f6048F, 1.0f, 0.0f, 250L, new C4494i());
        m4485t();
    }

    private String getContentDescriptionForDropdown() {
        return getContext().getString(C4584R.string.loc_dropdown_default_accessibility, this.f6081y.getText(), TextUtils.isEmpty(this.f6072p) ? "" : this.f6072p);
    }

    /* JADX INFO: renamed from: h */
    private void m4462h() {
        String str = this.f6072p;
        if (str == null || str.isEmpty() || this.f6049G.getVisibility() == 8) {
            return;
        }
        AnimationUtils.animateAlpha(this.f6049G, 1.0f, 0.0f, 250L, new C4496k());
    }

    /* JADX INFO: renamed from: i */
    private void m4463i() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f6082z.getWindowToken(), 0);
        }
    }

    /* JADX INFO: renamed from: j */
    private void m4465j() {
        this.f6062f = C4584R.layout.input_field_default;
        ConstraintLayout.inflate(getContext(), this.f6062f, this);
        this.f6044B = (LottieAnimationView) findViewById(C4584R.id.uicomponent_input_field_validation_tick);
        this.f6048F = (TextView) findViewById(C4584R.id.uicomponent_input_field_error_msg);
        setErrorText(this.f6069m);
        if (this.f6055M) {
            this.f6048F.setMaxLines(2);
        }
        this.f6081y = (TextView) findViewById(C4584R.id.uicomponent_input_field_label);
        setLabelText(this.f6068l);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(C4584R.id.uicomponent_input_field_end_icon);
        this.f6045C = lottieAnimationView;
        lottieAnimationView.setOnClickListener(new ViewOnClickListenerC4489d());
        this.f6045C.setImageTintMode(PorterDuff.Mode.SRC_IN);
        this.f6045C.setColorFilter(this.f6077u);
        EditText editText = (EditText) findViewById(C4584R.id.uicomponent_input_field_input);
        this.f6082z = editText;
        editText.setOnFocusChangeListener(new ViewOnFocusChangeListenerC4490e());
        this.f6082z.setInputType(this.f6065i);
        this.f6082z.setImeOptions(this.f6066j);
        this.f6082z.setNextFocusDownId(this.f6067k);
        this.f6082z.setSaveEnabled(false);
        this.f6046D = (ConstraintLayout) findViewById(C4584R.id.uicomponent_input_field_constraint_layout);
        this.f6049G = (TextView) findViewById(C4584R.id.uicomponent_input_field_hint_msg);
        setHintText(this.f6072p);
        this.f6047E = findViewById(C4584R.id.uicomponent_input_field_background);
        if (this.f6073q) {
            setAsInputDisabled();
        }
        if (this.f6078v) {
            m4480q();
        }
        if (this.f6056N != null) {
            m4481r();
        }
        if (this.f6075s) {
            setContentDescription(getContentDescriptionForDropdown());
        } else {
            m4467k();
            m4469l();
        }
        this.f6082z.addTextChangedListener(new C4491f());
    }

    /* JADX INFO: renamed from: k */
    private void m4467k() {
        ViewCompat.setAccessibilityDelegate(this.f6046D, new C4487b());
    }

    /* JADX INFO: renamed from: l */
    private void m4469l() {
        ViewCompat.setAccessibilityDelegate(this.f6082z, new C4488c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m */
    public /* synthetic */ void m4472m() {
        this.f6046D.sendAccessibilityEvent(32768);
        ViewCompat.setAccessibilityLiveRegion(this.f6046D, 1);
    }

    /* JADX INFO: renamed from: n */
    private void m4474n() {
        setInputFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f6082z.getText().toString().length())});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o */
    public void m4475o() {
        int i = this.f6062f;
        if (i == this.f6058b || i == this.f6061e) {
            setAsInFocus();
            m4438a(this.f6059c);
            m4491y();
            if (isValidationTickOnScreen()) {
                AnimationUtils.animateTextSize(this.f6081y, 17, 14, 250L);
                this.f6044B.removeCallbacks(this.f6052J);
                this.f6044B.setSpeed(-1.0f);
                this.f6044B.playAnimation();
            }
        } else {
            m4454d();
        }
        this.f6082z.requestFocus();
        m4488v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: p */
    public void m4477p() {
        int i;
        View view;
        int i2;
        if (hasFocus()) {
            if (this.f6082z.length() == 0 && this.f6054L) {
                setAsEmptyInvalid();
                return;
            }
            if (this.f6051I) {
                m4487u();
            }
            if (this.f6062f == this.f6060d) {
                int i3 = this.f6057a;
                if (i3 == 1) {
                    view = this.f6047E;
                    i2 = C4584R.drawable.input_field_background_valid;
                } else if (i3 == 2) {
                    view = this.f6047E;
                    i2 = C4584R.drawable.input_field_background_invalid;
                } else {
                    view = this.f6047E;
                    i2 = C4584R.drawable.input_field_background_default;
                }
                view.setBackgroundResource(i2);
            } else {
                if (this.f6082z.length() > 0) {
                    this.f6047E.setBackgroundResource(C4584R.drawable.input_field_background_default);
                    i = this.f6059c;
                } else {
                    this.f6047E.setBackgroundResource(C4584R.drawable.input_field_background_default);
                    i = this.f6058b;
                }
                m4438a(i);
            }
            m4463i();
            m4458f();
        }
    }

    /* JADX INFO: renamed from: q */
    private void m4480q() {
        this.f6082z.setInputType(131073);
        this.f6082z.setSingleLine(false);
        this.f6082z.setMinLines(this.f6079w);
        this.f6082z.setGravity(48);
    }

    /* JADX INFO: renamed from: r */
    private void m4481r() {
        this.f6081y.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC4492g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s */
    public void m4483s() {
        if (this.f6073q || this.f6078v || this.f6050H || this.f6082z.getInputType() == 131072 || this.f6082z.getText().toString().isEmpty()) {
            return;
        }
        this.f6045C.setVisibility(0);
        if (!this.f6075s) {
            this.f6045C.setImportantForAccessibility(1);
        }
        this.f6045C.setSpeed(1.0f);
        this.f6045C.playAnimation();
        this.f6050H = true;
    }

    /* JADX INFO: renamed from: t */
    private void m4485t() {
        String str = this.f6072p;
        if (str == null || str.isEmpty() || this.f6049G.getVisibility() == 0) {
            return;
        }
        AnimationUtils.animateAlpha(this.f6049G, 0.0f, 1.0f, 250L, new C4495j());
    }

    /* JADX INFO: renamed from: u */
    private void m4487u() {
        this.f6051I = false;
        boolean z = this.f6062f == this.f6061e;
        if (z) {
            AnimationUtils.animateTextSize(this.f6081y, 17, 14, 250L);
        } else if (this.f6057a != 2) {
            this.f6044B.removeCallbacks(this.f6052J);
            this.f6044B.clearAnimation();
            this.f6052J = AnimationUtils.animateFromJson(this.f6044B, "ico_cross_red.json", 100L);
            this.f6043A = "ico_cross_red.json";
        }
        this.f6047E.setBackgroundResource(C4584R.drawable.input_field_background_in_focus);
        m4443a(this.f6069m);
        this.f6057a = 2;
        m4438a(this.f6060d);
        if (z) {
            this.f6048F.setAlpha(1.0f);
        }
        m4437a();
    }

    /* JADX INFO: renamed from: v */
    private void m4488v() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.f6082z, 1);
        }
    }

    /* JADX INFO: renamed from: w */
    private void m4489w() {
        String str = this.f6071o;
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f6069m = String.format(this.f6071o, Integer.valueOf(this.f6082z.getText().length() - this.f6080x));
        setAsInvalidNow();
    }

    /* JADX INFO: renamed from: x */
    private void m4490x() {
        setInputFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
    }

    /* JADX INFO: renamed from: y */
    private void m4491y() {
        if ((this.f6048F.getVisibility() == 0 && this.f6048F.getAlpha() == 1.0f) || this.f6082z.length() == 0 || this.f6062f == this.f6060d) {
            return;
        }
        m4485t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: z */
    public void m4492z() {
        if (this.f6081y.getTextSize() == 14.0f && this.f6082z.getAlpha() == 1.0f) {
            return;
        }
        this.f6082z.setAlpha(1.0f);
        this.f6081y.setTextSize(14.0f);
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        this.f6082z.addTextChangedListener(textWatcher);
    }

    public int getLabelLineCount() {
        return this.f6081y.getLineCount();
    }

    public String getLabelText() {
        TextView textView = this.f6081y;
        if (textView == null) {
            return null;
        }
        return textView.getText().toString();
    }

    public String getText() {
        return this.f6082z.getText().toString();
    }

    public void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f6082z.getWindowToken(), 0);
        }
    }

    public boolean isMessageLengthValid() {
        return this.f6080x == -1 || this.f6082z.getText().length() <= this.f6080x;
    }

    public boolean isValidationTickOnScreen() {
        return this.f6044B.getProgress() > 0.5f;
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z && this.f6082z.getText().length() > 0) {
            m4438a(this.f6058b);
            m4483s();
        }
        if (z) {
            requestInputFocus();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f6063g) {
            return true;
        }
        if (this.f6082z.isFocused()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        m4475o();
        return true;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        C4498m c4498m = (C4498m) parcelable;
        super.onRestoreInstanceState(c4498m.getSuperState());
        if (TextUtils.isEmpty(c4498m.f6099a)) {
            m4452c();
        } else {
            setText(c4498m.f6099a);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        C4498m c4498m = new C4498m(super.onSaveInstanceState());
        c4498m.f6099a = this.f6082z.getText().toString();
        return c4498m;
    }

    public void removeMaxCharactersAllowed() {
        this.f6080x = -1;
        this.f6071o = null;
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        this.f6082z.removeTextChangedListener(textWatcher);
    }

    public boolean requestInputFocus() {
        boolean zRequestFocus = this.f6082z.requestFocus();
        if (zRequestFocus) {
            setAsInFocus();
            m4438a(this.f6059c);
        }
        return zRequestFocus;
    }

    public void resetToDefaultState() {
        setAsNeutral();
        this.f6047E.setBackgroundResource(C4584R.drawable.input_field_background_default);
    }

    public void scheduleInvalidOnFocusLost() {
        m4490x();
        if (this.f6080x <= -1 || this.f6082z.length() <= this.f6080x) {
            setAsNeutral();
            if (this.f6064h) {
                this.f6051I = true;
            }
        }
    }

    public void setAsDisabled() {
        this.f6063g = false;
        AnimationUtils.animateAlpha(this.f6046D, 1.0f, 0.5f, 250L);
        m4458f();
        this.f6046D.setImportantForAccessibility(4);
    }

    public void setAsEmptyInvalid() {
        this.f6057a = 2;
        if (this.f6062f != this.f6060d && !isValidationTickOnScreen()) {
            this.f6044B.removeCallbacks(this.f6052J);
            this.f6044B.clearAnimation();
            this.f6052J = AnimationUtils.animateFromJson(this.f6044B, "ico_cross_red.json", 100L);
            this.f6043A = "ico_cross_red.json";
        }
        AnimationUtils.animateTextSize(this.f6081y, 14, 17, 250L);
        this.f6047E.setBackgroundResource(C4584R.drawable.input_field_background_invalid);
        m4438a(this.f6061e);
        String str = this.f6070n;
        m4443a((str == null || str.isEmpty()) ? this.f6069m : this.f6070n);
        m4463i();
        m4458f();
        m4462h();
        m4437a();
    }

    public void setAsEnabled() {
        this.f6063g = true;
        AnimationUtils.animateAlpha(this.f6046D, 0.5f, 1.0f, 250L);
        this.f6046D.setImportantForAccessibility(1);
    }

    public void setAsInFocus() {
        if (this.f6057a != 1) {
            this.f6057a = 0;
        }
        this.f6047E.setBackgroundResource(C4584R.drawable.input_field_background_in_focus);
        m4483s();
        m4491y();
    }

    public void setAsInputDisabled() {
        this.f6063g = false;
        m4458f();
        if (this.f6076t != null) {
            this.f6045C.reverseAnimationSpeed();
            this.f6045C.playAnimation();
            this.f6050H = false;
            this.f6045C.setImageDrawable(this.f6076t);
            this.f6045C.setVisibility(0);
            this.f6045C.setImportantForAccessibility(1);
        }
        this.f6046D.setImportantForAccessibility(4);
    }

    public void setAsInvalid() {
        m4490x();
        if (!this.f6073q) {
            this.f6051I = true;
        } else {
            m4487u();
            this.f6047E.setBackgroundResource(C4584R.drawable.input_field_background_invalid);
        }
    }

    public void setAsInvalidNow() {
        m4487u();
    }

    public void setAsInvalidNow(AnimationCompletionListener animationCompletionListener) {
        this.f6053K = animationCompletionListener;
        m4487u();
    }

    public void setAsNeutral() {
        this.f6051I = false;
        m4490x();
        if (this.f6057a == 2) {
            m4460g();
        }
        this.f6057a = 0;
        this.f6047E.setBackgroundResource(C4584R.drawable.input_field_background_in_focus);
        m4441a(this.f6059c, this.f6062f == this.f6060d ? 100L : 0L);
        if (isValidationTickOnScreen()) {
            this.f6044B.removeCallbacks(this.f6052J);
            this.f6044B.setSpeed(-1.0f);
            this.f6044B.playAnimation();
            this.f6043A = null;
        } else {
            this.f6044B.setProgress(0.0f);
        }
        m4485t();
        if (this.f6073q) {
            this.f6047E.setBackgroundResource(C4584R.drawable.input_field_background_in_focus);
        }
    }

    public void setAsValid() {
        this.f6051I = false;
        if (!this.f6074r) {
            m4474n();
        }
        if (this.f6057a == 1 && this.f6062f == this.f6060d && isValidationTickOnScreen()) {
            return;
        }
        this.f6057a = 1;
        m4438a(this.f6060d);
        m4460g();
        this.f6047E.setBackgroundResource(C4584R.drawable.input_field_background_in_focus);
        if (isValidationTickOnScreen() && "ico_tick_green.json".equals(this.f6043A)) {
            this.f6044B.setProgress(1.0f);
        } else {
            this.f6044B.removeCallbacks(this.f6052J);
            this.f6044B.clearAnimation();
            this.f6052J = AnimationUtils.animateFromJson(this.f6044B, "ico_tick_green.json", 100L);
            this.f6043A = "ico_tick_green.json";
        }
        if (this.f6073q) {
            this.f6047E.setBackgroundResource(C4584R.drawable.input_field_background_valid);
        }
    }

    public void setAutoInvalidOnFocusLost(boolean z) {
        this.f6064h = z;
    }

    public void setCursorVisible(boolean z) {
        this.f6082z.setCursorVisible(z);
    }

    public void setEmptyErrorText(int i) {
        setEmptyErrorText(getContext().getString(i));
    }

    public void setEmptyErrorText(String str) {
        this.f6070n = str;
        this.f6048F.setText(str);
    }

    public void setEndIcon(Drawable drawable) {
        this.f6076t = drawable;
        if (this.f6073q) {
            setAsInputDisabled();
        }
    }

    public void setErrorText(String str) {
        this.f6069m = str;
        this.f6048F.setText(str);
    }

    public void setHint(int i) {
        this.f6081y.setText(i);
    }

    public void setHint(String str) {
        this.f6081y.setText(str);
    }

    public void setHintText(String str) {
        this.f6072p = str;
        this.f6049G.setText(str);
        m4485t();
    }

    public void setImeOptions(int i) {
        this.f6082z.setImeOptions(i);
    }

    public void setInputEnabled(boolean z) {
        this.f6073q = !z;
        if (z) {
            return;
        }
        setAsInputDisabled();
    }

    public void setInputFilters(InputFilter[] inputFilterArr) {
        this.f6082z.setFilters(inputFilterArr);
    }

    public void setInputType(int i) {
        this.f6082z.setInputType(i);
    }

    public void setIsCharacterInputAllowedWhenValid(boolean z) {
        this.f6074r = z;
    }

    public void setLabelDrawListener(ILabelDrawListener iLabelDrawListener) {
        this.f6056N = iLabelDrawListener;
        m4481r();
    }

    public void setLabelText(String str) {
        this.f6068l = str;
        this.f6081y.setText(str);
    }

    public void setMaxCharactersAllowed(int i, String str) {
        this.f6080x = i;
        this.f6071o = str;
        m4450b(this.f6082z.getText().toString());
    }

    @Deprecated
    public void setRightIcon(Drawable drawable) {
        setEndIcon(drawable);
    }

    public void setSelection(int i) {
        this.f6082z.setSelection(i);
    }

    public void setSubmitAction(final YotiEditTextSubmitAction yotiEditTextSubmitAction) {
        if (yotiEditTextSubmitAction != null) {
            setImeOptions(6);
        }
        this.f6082z.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiEditText$$ExternalSyntheticLambda1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return YotiEditText.m4444a(yotiEditTextSubmitAction, textView, i, keyEvent);
            }
        });
    }

    public void setText(String str) {
        if (this.f6062f == this.f6058b) {
            m4438a(this.f6059c);
        }
        this.f6082z.setText(str);
        if (this.f6073q && str.isEmpty()) {
            setAsEmptyInvalid();
        }
    }

    public void showSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager;
        if (!this.f6082z.requestFocus() || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.showSoftInput(this.f6082z, 1);
    }
}
