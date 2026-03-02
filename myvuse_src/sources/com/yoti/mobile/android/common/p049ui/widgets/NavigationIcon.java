package com.yoti.mobile.android.common.p049ui.widgets;

import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "", "", "b", "I", "getNavDescription", "()I", "navDescription", "a", "getIcon", "icon", "<init>", "(Ljava/lang/String;III)V", "NONE", "INVISBLE", "CLOSE_BLUE", "BACK_BLUE", "CLOSE_BLACK", "BACK_BLACK", "CLOSE_WHITE", "BACK_WHITE", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public enum NavigationIcon {
    NONE(0, 0),
    INVISBLE(C4584R.drawable.ic_action_invisible, 0),
    CLOSE_BLUE(C4584R.drawable.ic_action_dismiss_cross_blue, C4584R.string.loc_navigation_close_accessibility),
    BACK_BLUE(C4584R.drawable.ic_action_back_arrow_blue, 0, 2, null),
    CLOSE_BLACK(C4584R.drawable.ic_action_dismiss_cross_black, C4584R.string.loc_navigation_close_accessibility),
    BACK_BLACK(C4584R.drawable.ic_action_back_arrow_black, 0, 2, null),
    CLOSE_WHITE(C4584R.drawable.ic_action_dismiss_cross_white, C4584R.string.loc_navigation_close_accessibility),
    BACK_WHITE(C4584R.drawable.ic_action_back_arrow_white, 0, 2, null);


    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int icon;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int navDescription;

    NavigationIcon(int i, int i2) {
        this.icon = i;
        this.navDescription = i2;
    }

    /* synthetic */ NavigationIcon(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? C4584R.string.loc_navigation_up_accessibility : i2);
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getNavDescription() {
        return this.navDescription;
    }
}
