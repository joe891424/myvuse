package com.yoti.mobile.android.common.p049ui.widgets;

import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'SUCCESS' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\b\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0003\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006j\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/ChipStyle;", "", "", "b", "I", "getTextColorAttr", "()I", "textColorAttr", "c", "getTintColorAttr", "tintColorAttr", "a", "getBackgroundColorAttr", "backgroundColorAttr", "<init>", "(Ljava/lang/String;IIII)V", "STANDARD", "SUCCESS", "WARNING", "CRITICAL", "NEUTRAL", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class ChipStyle {
    public static final ChipStyle CRITICAL;
    public static final ChipStyle NEUTRAL;
    public static final ChipStyle STANDARD;
    public static final ChipStyle SUCCESS;
    public static final ChipStyle WARNING;

    /* JADX INFO: renamed from: d */
    private static final /* synthetic */ ChipStyle[] f5917d;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int backgroundColorAttr;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int textColorAttr;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int tintColorAttr;

    static {
        ChipStyle chipStyle = new ChipStyle("STANDARD", 0, C4584R.attr.background_emphasis, C4584R.attr.typography_dark_standard, 0, 4, null);
        STANDARD = chipStyle;
        int i = 4;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i2 = 0;
        ChipStyle chipStyle2 = new ChipStyle("SUCCESS", 1, C4584R.attr.background_success, C4584R.attr.typography_dark_success, i2, i, defaultConstructorMarker);
        SUCCESS = chipStyle2;
        int i3 = 4;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        int i4 = 0;
        ChipStyle chipStyle3 = new ChipStyle("WARNING", 2, C4584R.attr.background_warning, C4584R.attr.typography_dark_warning, i4, i3, defaultConstructorMarker2);
        WARNING = chipStyle3;
        ChipStyle chipStyle4 = new ChipStyle("CRITICAL", 3, C4584R.attr.background_error, C4584R.attr.typography_dark_critical, i2, i, defaultConstructorMarker);
        CRITICAL = chipStyle4;
        ChipStyle chipStyle5 = new ChipStyle("NEUTRAL", 4, C4584R.attr.background_neutral2, C4584R.attr.typography_dark_neutral, i4, i3, defaultConstructorMarker2);
        NEUTRAL = chipStyle5;
        f5917d = new ChipStyle[]{chipStyle, chipStyle2, chipStyle3, chipStyle4, chipStyle5};
    }

    private ChipStyle(String str, int i, int i2, int i3, int i4) {
        this.backgroundColorAttr = i2;
        this.textColorAttr = i3;
        this.tintColorAttr = i4;
    }

    /* synthetic */ ChipStyle(String str, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i3, (i5 & 4) != 0 ? i3 : i4);
    }

    public static ChipStyle valueOf(String str) {
        return (ChipStyle) Enum.valueOf(ChipStyle.class, str);
    }

    public static ChipStyle[] values() {
        return (ChipStyle[]) f5917d.clone();
    }

    public final int getBackgroundColorAttr() {
        return this.backgroundColorAttr;
    }

    public final int getTextColorAttr() {
        return this.textColorAttr;
    }

    public final int getTintColorAttr() {
        return this.tintColorAttr;
    }
}
