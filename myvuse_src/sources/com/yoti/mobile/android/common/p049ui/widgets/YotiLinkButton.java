package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.button.MaterialButton;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiLinkButton;", "Lcom/google/android/material/button/MaterialButton;", "", "underline", "", "setTextUnderline", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiLinkButton extends MaterialButton {

    /* JADX INFO: renamed from: a */
    private HashMap f6136a;

    public YotiLinkButton(Context context) {
        this(context, null, 0, 6, null);
    }

    public YotiLinkButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiLinkButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, C4584R.styleable.YotiLinkButton, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArray, "typedArray");
        boolean z = typedArray.getBoolean(C4584R.styleable.YotiLinkButton_linkButtonTextUnderline, false);
        typedArray.recycle();
        setTextUnderline(z);
    }

    public /* synthetic */ YotiLinkButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6136a;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f6136a == null) {
            this.f6136a = new HashMap();
        }
        View view = (View) this.f6136a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6136a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void setTextUnderline(boolean underline) {
        setPaintFlags(underline ? getPaintFlags() | 8 : getPaintFlags() & (-9));
    }
}
