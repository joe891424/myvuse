package com.yoti.mobile.android.common.p049ui.widgets;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;

/* JADX INFO: loaded from: classes5.dex */
public class YotiPinEntry extends ConstraintLayout {

    /* JADX INFO: renamed from: A */
    private String f6158A;

    /* JADX INFO: renamed from: B */
    private int f6159B;

    /* JADX INFO: renamed from: C */
    private String[] f6160C;

    /* JADX INFO: renamed from: D */
    private View.OnKeyListener f6161D;

    /* JADX INFO: renamed from: E */
    private TextWatcher f6162E;

    /* JADX INFO: renamed from: F */
    private View.OnFocusChangeListener f6163F;

    /* JADX INFO: renamed from: G */
    private View.OnClickListener f6164G;

    /* JADX INFO: renamed from: a */
    private AppCompatTextView[] f6165a;

    /* JADX INFO: renamed from: b */
    private LottieAnimationView[] f6166b;

    /* JADX INFO: renamed from: c */
    private EditText f6167c;

    /* JADX INFO: renamed from: d */
    private LottieAnimationView f6168d;

    /* JADX INFO: renamed from: e */
    private TextView f6169e;

    /* JADX INFO: renamed from: f */
    private LottieAnimationView f6170f;

    /* JADX INFO: renamed from: g */
    private YotiPinEntryListener f6171g;

    /* JADX INFO: renamed from: h */
    private boolean f6172h;

    /* JADX INFO: renamed from: i */
    private boolean f6173i;

    /* JADX INFO: renamed from: j */
    private boolean f6174j;

    /* JADX INFO: renamed from: k */
    private Handler f6175k;

    /* JADX INFO: renamed from: l */
    private Handler f6176l;

    /* JADX INFO: renamed from: m */
    private RunnableC4530t f6177m;

    /* JADX INFO: renamed from: n */
    private EnumC4527q f6178n;

    /* JADX INFO: renamed from: o */
    private boolean f6179o;

    /* JADX INFO: renamed from: p */
    private boolean f6180p;

    /* JADX INFO: renamed from: q */
    private int f6181q;

    /* JADX INFO: renamed from: r */
    private int f6182r;

    /* JADX INFO: renamed from: s */
    private int f6183s;

    /* JADX INFO: renamed from: t */
    private int f6184t;

    /* JADX INFO: renamed from: u */
    private String f6185u;

    /* JADX INFO: renamed from: v */
    private String f6186v;

    /* JADX INFO: renamed from: w */
    private String f6187w;

    /* JADX INFO: renamed from: x */
    private String f6188x;

    /* JADX INFO: renamed from: y */
    private String f6189y;

    /* JADX INFO: renamed from: z */
    private String f6190z;

    public interface YotiPinEntryListener {
        boolean isAccessibilityEnabled();

        void onPinCodeEntryComplete(String str);

        void onPinVisibilityToggledToHidden();

        void onPinVisibilityToggledToVisible();

        void onTransitionToErrorStateComplete();

        void onTransitionToSuccessStateComplete();
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$a */
    class ViewOnClickListenerC4511a implements View.OnClickListener {
        ViewOnClickListenerC4511a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LottieAnimationView lottieAnimationView;
            String str;
            LottieAnimationView lottieAnimationView2;
            Resources resources;
            int i;
            if (YotiPinEntry.this.f6174j || YotiPinEntry.this.f6167c.getText().length() == 5) {
                return;
            }
            YotiPinEntry.this.f6174j = true;
            if (YotiPinEntry.this.f6172h) {
                YotiPinEntry.this.f6172h = false;
                lottieAnimationView = YotiPinEntry.this.f6168d;
                str = YotiPinEntry.this.f6188x;
            } else {
                YotiPinEntry.this.f6172h = true;
                lottieAnimationView = YotiPinEntry.this.f6168d;
                str = YotiPinEntry.this.f6187w;
            }
            lottieAnimationView.setAnimation(str);
            YotiPinEntry.this.f6168d.setSpeed(1.0f);
            YotiPinEntry.this.f6168d.playAnimation();
            if (YotiPinEntry.this.f6167c.getText().length() == 0) {
                YotiPinEntry.this.f6174j = false;
            } else {
                YotiPinEntry yotiPinEntry = YotiPinEntry.this;
                yotiPinEntry.m4524a(yotiPinEntry.f6167c.getText());
            }
            if (YotiPinEntry.this.f6172h) {
                YotiPinEntry.this.f6171g.onPinVisibilityToggledToHidden();
                lottieAnimationView2 = YotiPinEntry.this.f6168d;
                resources = YotiPinEntry.this.getResources();
                i = C4584R.string.btn_show_pin;
            } else {
                YotiPinEntry.this.f6171g.onPinVisibilityToggledToVisible();
                lottieAnimationView2 = YotiPinEntry.this.f6168d;
                resources = YotiPinEntry.this.getResources();
                i = C4584R.string.btn_hide_pin;
            }
            lottieAnimationView2.setContentDescription(resources.getString(i));
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$b */
    class C4512b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ LottieAnimationView f6192a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ AppCompatTextView f6193b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ boolean f6194c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ String f6195d;

        C4512b(LottieAnimationView lottieAnimationView, AppCompatTextView appCompatTextView, boolean z, String str) {
            this.f6192a = lottieAnimationView;
            this.f6193b = appCompatTextView;
            this.f6194c = z;
            this.f6195d = str;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6192a.removeAnimatorListener(this);
            YotiPinEntry.this.setPinDigitEmptyDrawable(this.f6192a);
            this.f6193b.setText("");
            if (this.f6194c) {
                YotiPinEntry.this.m4541a(this.f6195d);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6192a.removeAnimatorListener(this);
            YotiPinEntry.this.setPinDigitEmptyDrawable(this.f6192a);
            this.f6193b.setText("");
            if (this.f6194c) {
                YotiPinEntry.this.m4541a(this.f6195d);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$c */
    class C4513c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ LottieAnimationView f6197a;

        C4513c(YotiPinEntry yotiPinEntry, LottieAnimationView lottieAnimationView) {
            this.f6197a = lottieAnimationView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6197a.removeAnimatorListener(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6197a.removeAnimatorListener(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$d */
    class C4514d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ LottieAnimationView f6198a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ AppCompatTextView f6199b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ String f6200c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ boolean f6201d;

        /* JADX INFO: renamed from: e */
        final /* synthetic */ String f6202e;

        C4514d(LottieAnimationView lottieAnimationView, AppCompatTextView appCompatTextView, String str, boolean z, String str2) {
            this.f6198a = lottieAnimationView;
            this.f6199b = appCompatTextView;
            this.f6200c = str;
            this.f6201d = z;
            this.f6202e = str2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6198a.removeAnimatorListener(this);
            this.f6199b.setText(this.f6200c);
            if (this.f6201d) {
                YotiPinEntry.this.m4541a(this.f6202e);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6198a.removeAnimatorListener(this);
            this.f6199b.setText(this.f6200c);
            if (this.f6201d) {
                YotiPinEntry.this.m4541a(this.f6202e);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f6198a.setBackground(null);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$e */
    class RunnableC4515e implements Runnable {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f6204a;

        RunnableC4515e(String str) {
            this.f6204a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (YotiPinEntry.this.f6171g != null) {
                YotiPinEntry.this.f6171g.onPinCodeEntryComplete(this.f6204a);
            }
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$f */
    class RunnableC4516f implements Runnable {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ View f6206a;

        RunnableC4516f(View view) {
            this.f6206a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            InputMethodManager inputMethodManager;
            if (!this.f6206a.requestFocus() || (inputMethodManager = (InputMethodManager) YotiPinEntry.this.getContext().getSystemService("input_method")) == null || inputMethodManager.showSoftInput(YotiPinEntry.this.f6167c, 1)) {
                return;
            }
            YotiPinEntry yotiPinEntry = YotiPinEntry.this;
            yotiPinEntry.f6177m = yotiPinEntry.new RunnableC4530t(inputMethodManager, yotiPinEntry.f6167c);
            YotiPinEntry.this.f6176l.postDelayed(YotiPinEntry.this.f6177m, 100L);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$g */
    static /* synthetic */ class C4517g {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f6208a;

        static {
            int[] iArr = new int[EnumC4527q.values().length];
            f6208a = iArr;
            try {
                iArr[EnumC4527q.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6208a[EnumC4527q.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$h */
    class C4518h implements Animator.AnimatorListener {
        C4518h() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            YotiPinEntry.this.m4546b(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            YotiPinEntry.this.m4546b(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$i */
    class RunnableC4519i implements Runnable {
        RunnableC4519i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            YotiPinEntry.this.f6171g.onTransitionToSuccessStateComplete();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$j */
    class C4520j implements Animator.AnimatorListener {
        C4520j() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            YotiPinEntry.this.m4522a(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            YotiPinEntry.this.m4522a(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$k */
    class ViewOnKeyListenerC4521k implements View.OnKeyListener {
        ViewOnKeyListenerC4521k() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            return i != 4 && YotiPinEntry.this.f6174j;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$l */
    class C4522l implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ LottieAnimationView f6213a;

        C4522l(LottieAnimationView lottieAnimationView) {
            this.f6213a = lottieAnimationView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6213a.removeAnimatorListener(this);
            YotiPinEntry.this.setPinDigitEmptyDrawable(this.f6213a);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6213a.removeAnimatorListener(this);
            YotiPinEntry.this.setPinDigitEmptyDrawable(this.f6213a);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$m */
    class RunnableC4523m implements Runnable {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ LottieAnimationView f6215a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f6216b;

        RunnableC4523m(LottieAnimationView lottieAnimationView, String str) {
            this.f6215a = lottieAnimationView;
            this.f6216b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6215a.setAnimation(this.f6216b);
            this.f6215a.setVisibility(0);
            this.f6215a.setSpeed(1.0f);
            this.f6215a.playAnimation();
            if (YotiPinEntry.this.m4556d()) {
                return;
            }
            YotiPinEntry yotiPinEntry = YotiPinEntry.this;
            yotiPinEntry.m4526a(yotiPinEntry.f6167c);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$n */
    class RunnableC4524n implements Runnable {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ LottieAnimationView f6218a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f6219b;

        /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$n$a */
        class a implements Animator.AnimatorListener {
            a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                RunnableC4524n.this.f6218a.removeAnimatorListener(this);
                RunnableC4524n runnableC4524n = RunnableC4524n.this;
                YotiPinEntry.this.setPinDigitEmptyDrawable(runnableC4524n.f6218a);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RunnableC4524n.this.f6218a.removeAnimatorListener(this);
                RunnableC4524n runnableC4524n = RunnableC4524n.this;
                YotiPinEntry.this.setPinDigitEmptyDrawable(runnableC4524n.f6218a);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        RunnableC4524n(LottieAnimationView lottieAnimationView, String str) {
            this.f6218a = lottieAnimationView;
            this.f6219b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6218a.setAnimation(this.f6219b);
            this.f6218a.addAnimatorListener(new a());
            this.f6218a.setVisibility(0);
            this.f6218a.setSpeed(1.0f);
            this.f6218a.playAnimation();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$o */
    class C4525o implements TextWatcher {
        C4525o() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            synchronized (this) {
                YotiPinEntry.this.m4525a(editable, editable.length() == 5 && YotiPinEntry.this.f6171g != null);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$p */
    class ViewOnFocusChangeListenerC4526p implements View.OnFocusChangeListener {
        ViewOnFocusChangeListenerC4526p() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            int i = C4517g.f6208a[YotiPinEntry.this.f6178n.ordinal()];
            if (i == 1) {
                YotiPinEntry.this.showSuccessState();
            } else if (i != 2) {
                YotiPinEntry.this.m4558e();
            } else {
                YotiPinEntry.this.showErrorState();
            }
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$q */
    private enum EnumC4527q {
        NONE,
        SUCCESS,
        ERROR
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$r */
    private class C4528r implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a */
        private LottieAnimationView f6228a;

        /* JADX INFO: renamed from: b */
        private TextView f6229b;

        /* JADX INFO: renamed from: c */
        private int f6230c;

        C4528r(LottieAnimationView lottieAnimationView, TextView textView, int i) {
            this.f6228a = lottieAnimationView;
            this.f6229b = textView;
            this.f6230c = i;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            YotiPinEntry.this.setPinDigitEmptyDrawable(this.f6228a);
            YotiPinEntry.this.m4528a(this.f6228a, this.f6229b, this.f6230c, this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            YotiPinEntry.this.setPinDigitEmptyDrawable(this.f6228a);
            YotiPinEntry.this.m4528a(this.f6228a, this.f6229b, this.f6230c, this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$s */
    private enum EnumC4529s {
        NONE,
        ADDED,
        REMOVED
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$t */
    private class RunnableC4530t implements Runnable {

        /* JADX INFO: renamed from: a */
        private InputMethodManager f6236a;

        /* JADX INFO: renamed from: b */
        private View f6237b;

        RunnableC4530t(InputMethodManager inputMethodManager, View view) {
            this.f6236a = inputMethodManager;
            this.f6237b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            InputMethodManager inputMethodManager = this.f6236a;
            if (inputMethodManager == null || inputMethodManager.showSoftInput(this.f6237b, 1)) {
                return;
            }
            YotiPinEntry.this.f6176l.postDelayed(YotiPinEntry.this.f6177m, 100L);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiPinEntry$u */
    private class C4531u implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a */
        private LottieAnimationView f6239a;

        /* JADX INFO: renamed from: b */
        private TextView f6240b;

        /* JADX INFO: renamed from: c */
        private int f6241c;

        /* JADX INFO: renamed from: d */
        private String f6242d;

        C4531u(LottieAnimationView lottieAnimationView, TextView textView, int i, String str) {
            this.f6239a = lottieAnimationView;
            this.f6240b = textView;
            this.f6241c = i;
            this.f6242d = str;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            YotiPinEntry.this.m4528a(this.f6239a, this.f6240b, this.f6241c, this);
            if (YotiPinEntry.this.f6172h) {
                return;
            }
            this.f6239a.setBackground(null);
            this.f6240b.setText(this.f6242d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            YotiPinEntry.this.m4528a(this.f6239a, this.f6240b, this.f6241c, this);
            if (YotiPinEntry.this.f6172h) {
                return;
            }
            this.f6239a.setBackground(null);
            this.f6240b.setText(this.f6242d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public YotiPinEntry(Context context) {
        this(context, null);
    }

    public YotiPinEntry(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YotiPinEntry(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6165a = new AppCompatTextView[5];
        this.f6166b = new LottieAnimationView[5];
        this.f6161D = new ViewOnKeyListenerC4521k();
        this.f6162E = new C4525o();
        this.f6163F = new ViewOnFocusChangeListenerC4526p();
        this.f6164G = new ViewOnClickListenerC4511a();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C4584R.styleable.YotiPinEntry);
        try {
            this.f6179o = typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiPinEntry_pin_delay_initial_view_visibility, false);
            this.f6180p = typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.YotiPinEntry_pin_delay_digits, false);
            this.f6181q = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiPinEntry_pin_initial_visibility_wait_duration, 500);
            this.f6182r = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiPinEntry_pin_visibility_wait_duration_increment, 30);
            this.f6183s = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiPinEntry_pin_visibility_toggle_initial_wait_duration, 300);
            this.f6184t = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiPinEntry_pin_delay_before_success_state_callback_called, 500);
            String string = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiPinEntry_pin_red_cross_animation_name);
            this.f6185u = string;
            if (string == null) {
                this.f6185u = "ico_cross_red.json";
            }
            String string2 = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiPinEntry_pin_green_tick_animation_name);
            this.f6186v = string2;
            if (string2 == null) {
                this.f6186v = "ico_tick_green.json";
            }
            String string3 = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiPinEntry_pin_visibility_hide_animation_name);
            this.f6187w = string3;
            if (string3 == null) {
                this.f6187w = "ico_pin_hide.json";
            }
            String string4 = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiPinEntry_pin_visibility_show_animation_name);
            this.f6188x = string4;
            if (string4 == null) {
                this.f6188x = "ico_pin_show.json";
            }
            String string5 = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiPinEntry_pin_open_animation_name);
            this.f6189y = string5;
            if (string5 == null) {
                this.f6189y = "ico_pin_open.json";
            }
            String string6 = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiPinEntry_pin_digit_empty_animation_name);
            this.f6190z = string6;
            if (string6 == null) {
                this.f6190z = "ico_pin_digit_empty.json";
            }
            String string7 = typedArrayObtainStyledAttributes.getString(C4584R.styleable.YotiPinEntry_pin_digit_filled_animation_name);
            this.f6158A = string7;
            if (string7 == null) {
                this.f6158A = "ico_pin_digit_filled.json";
            }
            this.f6159B = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.YotiPinEntry_pin_alpha_animation_duration, 250);
            typedArrayObtainStyledAttributes.recycle();
            m4523a(context);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private LottieAnimationView m4517a(int i) {
        return this.f6166b[i];
    }

    /* JADX INFO: renamed from: a */
    private EnumC4529s m4519a(String str, String str2) {
        return str.equals(str2) ? EnumC4529s.NONE : (!str.equals("") || str2.equals("")) ? (str.equals("") || !str2.equals("")) ? EnumC4529s.NONE : EnumC4529s.ADDED : EnumC4529s.REMOVED;
    }

    /* JADX INFO: renamed from: a */
    private void m4521a() {
        this.f6165a[0] = (AppCompatTextView) findViewById(C4584R.id.pinDigitOne);
        this.f6165a[1] = (AppCompatTextView) findViewById(C4584R.id.pinDigitTwo);
        this.f6165a[2] = (AppCompatTextView) findViewById(C4584R.id.pinDigitThree);
        this.f6165a[3] = (AppCompatTextView) findViewById(C4584R.id.pinDigitFour);
        this.f6165a[4] = (AppCompatTextView) findViewById(C4584R.id.pinDigitFive);
        for (AppCompatTextView appCompatTextView : this.f6165a) {
            appCompatTextView.setElevation(0.0f);
        }
        this.f6166b[0] = (LottieAnimationView) findViewById(C4584R.id.pinDigitOneAnimation);
        this.f6166b[1] = (LottieAnimationView) findViewById(C4584R.id.pinDigitTwoAnimation);
        this.f6166b[2] = (LottieAnimationView) findViewById(C4584R.id.pinDigitThreeAnimation);
        this.f6166b[3] = (LottieAnimationView) findViewById(C4584R.id.pinDigitFourAnimation);
        this.f6166b[4] = (LottieAnimationView) findViewById(C4584R.id.pinDigitFiveAnimation);
        m4560f();
        EditText editText = (EditText) findViewById(C4584R.id.pinEntryEditText);
        this.f6167c = editText;
        editText.addTextChangedListener(this.f6162E);
        this.f6167c.setOnFocusChangeListener(this.f6163F);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(C4584R.id.pinEntryVisibilityToggle);
        this.f6168d = lottieAnimationView;
        lottieAnimationView.setOnClickListener(this.f6164G);
        this.f6168d.setContentDescription(getResources().getString(C4584R.string.btn_show_pin));
        this.f6169e = (TextView) findViewById(C4584R.id.pinEntryHintText);
        this.f6170f = (LottieAnimationView) findViewById(C4584R.id.pinEntryStatusIndicator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m4522a(Animator.AnimatorListener animatorListener) {
        this.f6170f.removeAnimatorListener(animatorListener);
        YotiPinEntryListener yotiPinEntryListener = this.f6171g;
        if (yotiPinEntryListener != null) {
            yotiPinEntryListener.onTransitionToErrorStateComplete();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4523a(Context context) {
        LayoutInflater.from(context).inflate(C4584R.layout.yoti_pin_entry, (ViewGroup) this, true);
        m4521a();
        this.f6172h = true;
        this.f6173i = false;
        this.f6174j = false;
        this.f6175k = new Handler();
        this.f6176l = new Handler();
        this.f6178n = EnumC4527q.NONE;
        this.f6160C = new String[5];
        for (int i = 0; i < 5; i++) {
            this.f6160C[i] = "";
            this.f6165a[i].setTag(Integer.valueOf(i));
        }
        this.f6167c.setOnKeyListener(this.f6161D);
        if (!m4556d()) {
            this.f6167c.clearFocus();
        }
        showPinEmptyState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m4524a(Editable editable) {
        m4545b();
        for (int i = 0; i < 5; i++) {
            AppCompatTextView appCompatTextViewM4544b = m4544b(i);
            LottieAnimationView lottieAnimationViewM4517a = m4517a(i);
            if (editable.length() <= i) {
                appCompatTextViewM4544b.setText("");
            } else if (this.f6172h) {
                appCompatTextViewM4544b.setText("");
                m4529a(lottieAnimationViewM4517a, appCompatTextViewM4544b, editable.length());
            } else {
                lottieAnimationViewM4517a.setBackground(null);
                m4530a(lottieAnimationViewM4517a, appCompatTextViewM4544b, editable.length(), String.valueOf(editable.charAt(i)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m4525a(Editable editable, boolean z) {
        m4545b();
        int i = 0;
        while (i < 5) {
            AppCompatTextView appCompatTextViewM4544b = m4544b(i);
            LottieAnimationView lottieAnimationViewM4517a = m4517a(i);
            String strValueOf = i < editable.length() ? String.valueOf(editable.charAt(i)) : "";
            EnumC4529s enumC4529sM4519a = m4519a(strValueOf, this.f6160C[i]);
            this.f6160C[((Integer) appCompatTextViewM4544b.getTag()).intValue()] = strValueOf;
            m4534a(enumC4529sM4519a, this.f6172h, lottieAnimationViewM4517a, appCompatTextViewM4544b, strValueOf, z, editable.toString());
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m4526a(View view) {
        Handler handler = this.f6176l;
        if (handler != null) {
            handler.postDelayed(new RunnableC4516f(view), 100L);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4527a(LottieAnimationView lottieAnimationView, int i, String str) {
        this.f6175k.postDelayed(new RunnableC4523m(lottieAnimationView, str), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m4528a(LottieAnimationView lottieAnimationView, View view, int i, Animator.AnimatorListener animatorListener) {
        lottieAnimationView.removeAnimatorListener(animatorListener);
        if (m4542a(view, i)) {
            this.f6174j = false;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4529a(LottieAnimationView lottieAnimationView, TextView textView, int i) {
        lottieAnimationView.setAnimation(this.f6158A);
        lottieAnimationView.addAnimatorListener(new C4528r(lottieAnimationView, textView, i));
        lottieAnimationView.setSpeed(1.0f);
        lottieAnimationView.playAnimation();
    }

    /* JADX INFO: renamed from: a */
    private void m4530a(LottieAnimationView lottieAnimationView, TextView textView, int i, String str) {
        lottieAnimationView.setAnimation(this.f6158A);
        lottieAnimationView.addAnimatorListener(new C4531u(lottieAnimationView, textView, i, str));
        lottieAnimationView.setSpeed(-1.0f);
        lottieAnimationView.playAnimation();
    }

    /* JADX INFO: renamed from: a */
    private void m4531a(LottieAnimationView lottieAnimationView, AppCompatTextView appCompatTextView) {
        if (lottieAnimationView.isAnimating()) {
            lottieAnimationView.cancelAnimation();
        }
        appCompatTextView.setText("");
        lottieAnimationView.setAnimation(this.f6158A);
        lottieAnimationView.addAnimatorListener(new C4513c(this, lottieAnimationView));
        lottieAnimationView.setSpeed(-1.0f);
        lottieAnimationView.playAnimation();
    }

    /* JADX INFO: renamed from: a */
    private void m4532a(LottieAnimationView lottieAnimationView, AppCompatTextView appCompatTextView, String str, boolean z, String str2) {
        lottieAnimationView.setAnimation(this.f6190z);
        lottieAnimationView.addAnimatorListener(new C4514d(lottieAnimationView, appCompatTextView, str, z, str2));
        lottieAnimationView.setSpeed(-1.0f);
        lottieAnimationView.playAnimation();
    }

    /* JADX INFO: renamed from: a */
    private void m4533a(LottieAnimationView lottieAnimationView, AppCompatTextView appCompatTextView, boolean z, String str) {
        lottieAnimationView.setAnimation(this.f6158A);
        lottieAnimationView.addAnimatorListener(new C4512b(lottieAnimationView, appCompatTextView, z, str));
        lottieAnimationView.setSpeed(1.0f);
        lottieAnimationView.playAnimation();
    }

    /* JADX INFO: renamed from: a */
    private void m4534a(EnumC4529s enumC4529s, boolean z, LottieAnimationView lottieAnimationView, AppCompatTextView appCompatTextView, String str, boolean z2, String str2) {
        if (enumC4529s == EnumC4529s.NONE) {
            return;
        }
        if (z) {
            if (enumC4529s == EnumC4529s.ADDED) {
                m4533a(lottieAnimationView, appCompatTextView, z2, str2);
                return;
            } else {
                if (enumC4529s == EnumC4529s.REMOVED) {
                    m4531a(lottieAnimationView, appCompatTextView);
                    return;
                }
                return;
            }
        }
        if (enumC4529s == EnumC4529s.ADDED) {
            m4532a(lottieAnimationView, appCompatTextView, str, z2, str2);
        } else if (enumC4529s == EnumC4529s.REMOVED) {
            m4548b(lottieAnimationView, appCompatTextView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m4541a(String str) {
        Handler handler = this.f6175k;
        if (handler != null) {
            handler.post(new RunnableC4515e(str));
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m4542a(View view, int i) {
        return ((Integer) view.getTag()).intValue() == i - 1;
    }

    /* JADX INFO: renamed from: b */
    private AppCompatTextView m4544b(int i) {
        return this.f6165a[i];
    }

    /* JADX INFO: renamed from: b */
    private void m4545b() {
        if (this.f6173i || this.f6174j) {
            return;
        }
        if (this.f6169e.getVisibility() == 0) {
            hideHintText();
        }
        if (EnumC4527q.NONE.equals(this.f6178n)) {
            return;
        }
        resetState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m4546b(Animator.AnimatorListener animatorListener) {
        this.f6170f.removeAnimatorListener(animatorListener);
        if (this.f6171g != null) {
            this.f6175k.postDelayed(new RunnableC4519i(), this.f6184t);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4547b(LottieAnimationView lottieAnimationView, int i, String str) {
        this.f6175k.postDelayed(new RunnableC4524n(lottieAnimationView, str), i);
    }

    /* JADX INFO: renamed from: b */
    private void m4548b(LottieAnimationView lottieAnimationView, AppCompatTextView appCompatTextView) {
        if (lottieAnimationView.isAnimating()) {
            lottieAnimationView.cancelAnimation();
        }
        appCompatTextView.setText("");
        lottieAnimationView.setAnimation(this.f6190z);
        lottieAnimationView.setSpeed(1.0f);
        lottieAnimationView.playAnimation();
    }

    /* JADX INFO: renamed from: c */
    private void m4553c() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f6167c.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public boolean m4556d() {
        YotiPinEntryListener yotiPinEntryListener = this.f6171g;
        return yotiPinEntryListener != null && yotiPinEntryListener.isAccessibilityEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m4558e() {
        this.f6167c.setBackgroundResource(C4584R.drawable.pin_entry_border);
    }

    /* JADX INFO: renamed from: f */
    private void m4560f() {
        for (LottieAnimationView lottieAnimationView : this.f6166b) {
            lottieAnimationView.setVisibility(4);
            lottieAnimationView.setAnimation(this.f6190z);
        }
    }

    /* JADX INFO: renamed from: g */
    private void m4562g() {
        int i = this.f6181q;
        if (!this.f6180p) {
            i += this.f6182r;
        }
        for (LottieAnimationView lottieAnimationView : this.f6166b) {
            if (this.f6180p) {
                i += this.f6182r;
            }
            m4547b(lottieAnimationView, i, this.f6190z);
        }
        m4527a(this.f6168d, this.f6183s, this.f6189y);
    }

    /* JADX INFO: renamed from: h */
    private void m4564h() {
        for (LottieAnimationView lottieAnimationView : this.f6166b) {
            lottieAnimationView.addAnimatorListener(new C4522l(lottieAnimationView));
            lottieAnimationView.setSpeed(1.0f);
            lottieAnimationView.playAnimation();
        }
        this.f6168d.setAnimation(this.f6189y);
        this.f6168d.setVisibility(0);
        this.f6168d.setSpeed(1.0f);
        this.f6168d.playAnimation();
        if (m4556d()) {
            return;
        }
        m4526a(this.f6167c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPinDigitEmptyDrawable(View view) {
        view.setVisibility(0);
        view.setBackground(ContextCompat.getDrawable(getContext(), C4584R.drawable.pin_digit_empty_bitmap));
    }

    public void animateShakeWrongPin() {
        Vibrator vibrator = (Vibrator) getContext().getSystemService("vibrator");
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), C4584R.anim.pin_entry_error_shake);
        if (vibrator != null && vibrator.hasVibrator()) {
            vibrator.vibrate(500L);
        }
        for (LottieAnimationView lottieAnimationView : this.f6166b) {
            lottieAnimationView.startAnimation(animationLoadAnimation);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        m4553c();
        super.clearFocus();
        this.f6167c.clearFocus();
    }

    public void clearPin() {
        this.f6173i = true;
        this.f6167c.setText("");
        this.f6173i = false;
    }

    public void close() {
        this.f6175k.removeCallbacksAndMessages(null);
        this.f6175k = null;
        this.f6171g = null;
        RunnableC4530t runnableC4530t = this.f6177m;
        if (runnableC4530t != null) {
            this.f6176l.removeCallbacks(runnableC4530t);
            this.f6176l = null;
        }
    }

    public void hideHintText() {
        com.yoti.mobile.android.common.p049ui.widgets.utils.AnimationUtils.animateToTransparent(this.f6169e, this.f6159B, 8);
    }

    public void onPause() {
        if (m4556d()) {
            m4553c();
            this.f6167c.clearFocus();
        }
    }

    public void onResume() {
        if (!super.isEnabled() || m4556d()) {
            return;
        }
        m4526a(this.f6167c);
    }

    public void resetState() {
        this.f6178n = EnumC4527q.NONE;
        com.yoti.mobile.android.common.p049ui.widgets.utils.AnimationUtils.animateToTransparent(this.f6170f, this.f6159B, 4);
        m4558e();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (super.isEnabled() == z) {
            return;
        }
        this.f6167c.setEnabled(z);
        this.f6167c.setFocusable(z);
        this.f6167c.setFocusableInTouchMode(z);
        com.yoti.mobile.android.common.p049ui.widgets.utils.AnimationUtils.animateAlpha(this, z ? 0.5f : 1.0f, z ? 1.0f : 0.5f, this.f6159B);
        super.setEnabled(z);
    }

    public void setHintText(int i) {
        this.f6169e.setText(getResources().getString(i));
        com.yoti.mobile.android.common.p049ui.widgets.utils.AnimationUtils.animateAlpha(this.f6169e, 0.0f, 1.0f, this.f6159B);
    }

    public void setListener(YotiPinEntryListener yotiPinEntryListener) {
        this.f6171g = yotiPinEntryListener;
    }

    public void showErrorState() {
        EnumC4527q enumC4527q = this.f6178n;
        EnumC4527q enumC4527q2 = EnumC4527q.ERROR;
        if (enumC4527q != enumC4527q2) {
            this.f6170f.setAnimation(this.f6185u);
            this.f6170f.setAlpha(1.0f);
            this.f6170f.setVisibility(0);
            this.f6170f.addAnimatorListener(new C4520j());
            this.f6170f.setSpeed(1.0f);
            this.f6170f.playAnimation();
            this.f6178n = enumC4527q2;
        }
        if (this.f6167c.isFocused()) {
            m4558e();
        } else {
            this.f6167c.setBackgroundResource(C4584R.drawable.pin_entry_border_error);
        }
    }

    public void showPinEmptyState() {
        if (this.f6179o) {
            m4562g();
        } else {
            m4564h();
        }
    }

    public void showSuccessState() {
        EnumC4527q enumC4527q = this.f6178n;
        EnumC4527q enumC4527q2 = EnumC4527q.SUCCESS;
        if (enumC4527q != enumC4527q2) {
            this.f6170f.setAnimation(this.f6186v);
            this.f6170f.setAlpha(1.0f);
            this.f6170f.setVisibility(0);
            this.f6170f.addAnimatorListener(new C4518h());
            this.f6170f.setSpeed(1.0f);
            this.f6170f.playAnimation();
            this.f6178n = enumC4527q2;
        }
        if (this.f6167c.isFocused()) {
            m4558e();
        } else {
            this.f6167c.setBackgroundResource(C4584R.drawable.pin_entry_border_success);
        }
    }
}
