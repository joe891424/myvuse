package com.yoti.mobile.android.common.p049ui.widgets;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "All functionality included in YotiOptionButton", replaceWith = @ReplaceWith(expression = "YotiOptionButton", imports = {"com.yoti.mobile.android.common.ui.widgets.button.YotiOptionButton"}))
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiSelectionProgressButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "a", "()Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "", "showProgress", "()V", "hideProgress", "", "text", "setText", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "textView", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "drawableStart", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiSelectionProgressButton extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private Drawable drawableStart;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private TextView textView;

    /* JADX INFO: renamed from: c */
    private HashMap f6268c;

    public YotiSelectionProgressButton(Context context) {
        this(context, null, 0, 6, null);
    }

    public YotiSelectionProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiSelectionProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        int[] iArr = {R.attr.text, R.attr.drawableStart};
        ConstraintLayout.inflate(context, C4584R.layout.view_selection_progress_button, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        CharSequence text = typedArrayObtainStyledAttributes.getText(0);
        this.drawableStart = typedArrayObtainStyledAttributes.getDrawable(1);
        ImageView icon = (ImageView) findViewById(C4584R.id.icon);
        Drawable drawable = this.drawableStart;
        if (drawable != null) {
            icon.setImageDrawable(drawable);
        } else {
            Intrinsics.checkNotNullExpressionValue(icon, "icon");
            icon.setVisibility(8);
        }
        View viewFindViewById = findViewById(C4584R.id.buttonText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.buttonText)");
        TextView textView = (TextView) viewFindViewById;
        this.textView = textView;
        textView.setText(text);
        typedArrayObtainStyledAttributes.recycle();
    }

    public /* synthetic */ YotiSelectionProgressButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: renamed from: a */
    private final CircularProgressDrawable m4584a() {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        circularProgressDrawable.setStyle(1);
        int centerRadius = ((int) (circularProgressDrawable.getCenterRadius() + circularProgressDrawable.getStrokeWidth())) * 2;
        circularProgressDrawable.setColorSchemeColors(ContextCompat.getColor(getContext(), C4584R.color.yoti_grey_dark));
        circularProgressDrawable.setBounds(0, 0, centerRadius, centerRadius);
        return circularProgressDrawable;
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6268c;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6268c == null) {
            this.f6268c = new HashMap();
        }
        View view = (View) this.f6268c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6268c.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void hideProgress() {
        DrawableContainer drawableContainer = this.textView.getCompoundDrawables()[2];
        if (drawableContainer != 0) {
            drawableContainer.setCallback(null);
        }
        if (drawableContainer instanceof Animatable) {
            ((Animatable) drawableContainer).stop();
        }
        this.textView.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, getContext().getDrawable(C4584R.drawable.ic_ico_chevron_right), (Drawable) null);
    }

    public final void setText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.textView.setText(text);
    }

    public final void showProgress() {
        CircularProgressDrawable circularProgressDrawableM4584a = m4584a();
        circularProgressDrawableM4584a.setCallback(new Drawable.Callback() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiSelectionProgressButton.showProgress.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable who) {
                Intrinsics.checkNotNullParameter(who, "who");
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable who, Runnable what, long when) {
                Intrinsics.checkNotNullParameter(who, "who");
                Intrinsics.checkNotNullParameter(what, "what");
                YotiSelectionProgressButton.this.invalidate();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable who, Runnable what) {
                Intrinsics.checkNotNullParameter(who, "who");
                Intrinsics.checkNotNullParameter(what, "what");
            }
        });
        if (circularProgressDrawableM4584a instanceof Animatable) {
            circularProgressDrawableM4584a.start();
        }
        this.textView.setCompoundDrawables(null, null, circularProgressDrawableM4584a, null);
    }
}
