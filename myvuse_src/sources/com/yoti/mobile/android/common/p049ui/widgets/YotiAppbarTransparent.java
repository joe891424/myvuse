package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/YotiAppbarTransparent;", "Lcom/yoti/mobile/android/common/ui/widgets/CommonYotiAppBar;", "", "getDefaultSeparatorVisibility", "()I", "defaultSeparatorVisibility", "getLayoutRes", "layoutRes", "getDefaultStyleRes", "defaultStyleRes", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class YotiAppbarTransparent extends CommonYotiAppBar {

    /* JADX INFO: renamed from: b */
    private HashMap f6012b;

    public YotiAppbarTransparent(Context context) {
        this(context, null, 0, 6, null);
    }

    public YotiAppbarTransparent(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiAppbarTransparent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ YotiAppbarTransparent(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.yoti.mobile.android.common.p049ui.widgets.CommonYotiAppBar
    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f6012b;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.yoti.mobile.android.common.p049ui.widgets.CommonYotiAppBar
    public View _$_findCachedViewById(int i) {
        if (this.f6012b == null) {
            this.f6012b = new HashMap();
        }
        View view = (View) this.f6012b.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f6012b.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // com.yoti.mobile.android.common.p049ui.widgets.CommonYotiAppBar
    public int getDefaultSeparatorVisibility() {
        return 4;
    }

    @Override // com.yoti.mobile.android.common.p049ui.widgets.CommonYotiAppBar
    public int getDefaultStyleRes() {
        return C4584R.style.Yoti_v3_AppBar_Transparent;
    }

    @Override // com.yoti.mobile.android.common.p049ui.widgets.CommonYotiAppBar
    public int getLayoutRes() {
        return C4584R.layout.yoti_appbar_transparent;
    }
}
