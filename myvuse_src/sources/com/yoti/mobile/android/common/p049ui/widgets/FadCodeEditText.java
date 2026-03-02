package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Vibrator;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewKt;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.color.MaterialColors;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\bB'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J!\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u000bJ\r\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u000bJ\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\"¨\u0006("}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/FadCodeEditText;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", "a", "(Landroid/util/AttributeSet;I)V", "b", "()V", "c", "onAttachedToWindow", "onPause", "onDetachedFromWindow", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "showErrorState", "showDefaultState", ViewProps.ENABLED, "setEnabled", "(Z)V", "Landroid/text/TextWatcher;", "textWatcher", "addTextChangedListener", "(Landroid/text/TextWatcher;)V", "", "getText", "()Ljava/lang/String;", "Lcom/yoti/mobile/android/common/ui/widgets/FadCodeEditText$a;", "Lcom/yoti/mobile/android/common/ui/widgets/FadCodeEditText$a;", "state", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class FadCodeEditText extends ConstraintLayout implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private EnumC4476a state;

    /* JADX INFO: renamed from: b */
    private HashMap f5933b;

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.FadCodeEditText$a */
    private enum EnumC4476a {
        DEFAULT,
        ERROR
    }

    public FadCodeEditText(Context context) {
        this(context, null, 0, 6, null);
    }

    public FadCodeEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FadCodeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.state = EnumC4476a.DEFAULT;
        ConstraintLayout.inflate(context, C4584R.layout.yoti_fad_code_edit_text_default, this);
        m4392a(attributeSet, i);
    }

    public /* synthetic */ FadCodeEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: renamed from: a */
    private final void m4391a() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(context, InputMethodManager.class);
        if (inputMethodManager != null) {
            EditText field_input = (EditText) _$_findCachedViewById(C4584R.id.field_input);
            Intrinsics.checkNotNullExpressionValue(field_input, "field_input");
            inputMethodManager.hideSoftInputFromWindow(field_input.getWindowToken(), 0);
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m4392a(AttributeSet attrs, int defStyleAttr) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int[] iArr = C4584R.styleable.FadCodeEditText;
        Intrinsics.checkNotNullExpressionValue(iArr, "R.styleable.FadCodeEditText");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr, defStyleAttr, 0);
        ((EditText) _$_findCachedViewById(C4584R.id.field_input)).setTextSize(0, typedArrayObtainStyledAttributes.getDimension(C4584R.styleable.FadCodeEditText_android_textSize, typedArrayObtainStyledAttributes.getResources().getDimension(FadCodeEditTextKt.f5937a)));
        String string = typedArrayObtainStyledAttributes.getString(C4584R.styleable.FadCodeEditText_errorMessage);
        if (string != null) {
            TextView error_msg = (TextView) _$_findCachedViewById(C4584R.id.error_msg);
            Intrinsics.checkNotNullExpressionValue(error_msg, "error_msg");
            error_msg.setText(string);
        }
        String string2 = typedArrayObtainStyledAttributes.getString(C4584R.styleable.FadCodeEditText_android_hint);
        if (string2 != null) {
            EditText field_input = (EditText) _$_findCachedViewById(C4584R.id.field_input);
            Intrinsics.checkNotNullExpressionValue(field_input, "field_input");
            field_input.setHint(string2);
        }
        int i = typedArrayObtainStyledAttributes.getInt(C4584R.styleable.FadCodeEditText_maxDigits, Integer.MAX_VALUE);
        EditText field_input2 = (EditText) _$_findCachedViewById(C4584R.id.field_input);
        Intrinsics.checkNotNullExpressionValue(field_input2, "field_input");
        field_input2.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(i)});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(C4584R.styleable.FadCodeEditText_android_enabled, true);
        EditText field_input3 = (EditText) _$_findCachedViewById(C4584R.id.field_input);
        Intrinsics.checkNotNullExpressionValue(field_input3, "field_input");
        field_input3.setEnabled(z);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: b */
    private final void m4393b() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(context, InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput((EditText) _$_findCachedViewById(C4584R.id.field_input), 1);
        }
    }

    /* JADX INFO: renamed from: c */
    private final void m4394c() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Vibrator vibrator = (Vibrator) ContextCompat.getSystemService(context, Vibrator.class);
        if (vibrator != null) {
            vibrator.hasVibrator();
            vibrator.vibrate(500);
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f5933b;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5933b == null) {
            this.f5933b = new HashMap();
        }
        View view = (View) this.f5933b.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5933b.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "textWatcher");
        ((EditText) _$_findCachedViewById(C4584R.id.field_input)).addTextChangedListener(textWatcher);
    }

    public final String getText() {
        EditText field_input = (EditText) _$_findCachedViewById(C4584R.id.field_input);
        Intrinsics.checkNotNullExpressionValue(field_input, "field_input");
        return field_input.getText().toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleOwner lifecycleOwnerFindViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(this);
        Intrinsics.checkNotNull(lifecycleOwnerFindViewTreeLifecycleOwner);
        lifecycleOwnerFindViewTreeLifecycleOwner.getLifecycle().addObserver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LifecycleOwner lifecycleOwnerFindViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(this);
        Intrinsics.checkNotNull(lifecycleOwnerFindViewTreeLifecycleOwner);
        lifecycleOwnerFindViewTreeLifecycleOwner.getLifecycle().removeObserver(this);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        EditText field_input = (EditText) _$_findCachedViewById(C4584R.id.field_input);
        Intrinsics.checkNotNullExpressionValue(field_input, "field_input");
        if (!field_input.isEnabled()) {
            return true;
        }
        ((EditText) _$_findCachedViewById(C4584R.id.field_input)).requestFocus();
        if (this.state == EnumC4476a.ERROR) {
            ((EditText) _$_findCachedViewById(C4584R.id.field_input)).setText("");
        }
        m4393b();
        return true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        ((EditText) _$_findCachedViewById(C4584R.id.field_input)).setText("");
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        EditText field_input = (EditText) _$_findCachedViewById(C4584R.id.field_input);
        Intrinsics.checkNotNullExpressionValue(field_input, "field_input");
        field_input.setEnabled(enabled);
    }

    public final void showDefaultState() {
        EnumC4476a enumC4476a = this.state;
        EnumC4476a enumC4476a2 = EnumC4476a.DEFAULT;
        if (enumC4476a != enumC4476a2) {
            this.state = enumC4476a2;
            TextView error_msg = (TextView) _$_findCachedViewById(C4584R.id.error_msg);
            Intrinsics.checkNotNullExpressionValue(error_msg, "error_msg");
            error_msg.setVisibility(4);
            EditText field_input = (EditText) _$_findCachedViewById(C4584R.id.field_input);
            Intrinsics.checkNotNullExpressionValue(field_input, "field_input");
            field_input.setBackground(ContextCompat.getDrawable(getContext(), C4584R.drawable.input_field_background));
            ((EditText) _$_findCachedViewById(C4584R.id.field_input)).setTextColor(MaterialColors.getColor(this, C4584R.attr.typography_neutral_contrast));
        }
    }

    public final void showErrorState() {
        if (this.state == EnumC4476a.DEFAULT) {
            m4394c();
        }
        this.state = EnumC4476a.ERROR;
        EditText field_input = (EditText) _$_findCachedViewById(C4584R.id.field_input);
        Intrinsics.checkNotNullExpressionValue(field_input, "field_input");
        field_input.setBackground(ContextCompat.getDrawable(getContext(), C4584R.drawable.input_field_background_error));
        ((EditText) _$_findCachedViewById(C4584R.id.field_input)).setTextColor(MaterialColors.getColor(this, C4584R.attr.typography_error));
        TextView error_msg = (TextView) _$_findCachedViewById(C4584R.id.error_msg);
        Intrinsics.checkNotNullExpressionValue(error_msg, "error_msg");
        error_msg.setVisibility(0);
        m4391a();
    }
}
