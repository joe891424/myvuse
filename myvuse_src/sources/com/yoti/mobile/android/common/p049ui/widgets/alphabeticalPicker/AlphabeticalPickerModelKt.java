package com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0016\u0010\u0003\u001a\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, m5598d2 = {"Ljava/util/regex/Pattern;", "a", "Ljava/util/regex/Pattern;", "removeAccentPattern", "uiWidgets_release"}, m5599k = 2, m5600mv = {1, 4, 2})
public final class AlphabeticalPickerModelKt {

    /* JADX INFO: renamed from: a */
    private static final Pattern f6288a;

    static {
        Pattern patternCompile = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        Intrinsics.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\\\\p{InC…iningDiacriticalMarks}+\")");
        f6288a = patternCompile;
    }
}
