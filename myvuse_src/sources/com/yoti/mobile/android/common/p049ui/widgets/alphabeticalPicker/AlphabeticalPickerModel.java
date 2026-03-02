package com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker;

import com.yoti.mobile.android.common.p049ui.widgets.utils.StringUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerModel;", "", "", "getMainText", "()Ljava/lang/String;", "getSubText", "", "isSection", "()Z", "other", "", "compareTo", "(Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerModel;)I", "<init>", "()V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public abstract class AlphabeticalPickerModel implements Comparable<AlphabeticalPickerModel> {
    @Override // java.lang.Comparable
    public int compareTo(AlphabeticalPickerModel other) {
        Intrinsics.checkNotNullParameter(other, "other");
        String strNormalize$default = StringUtilsKt.normalize$default(getMainText(), null, 1, null);
        String strNormalize$default2 = StringUtilsKt.normalize$default(other.getMainText(), null, 1, null);
        String s1 = AlphabeticalPickerModelKt.f6288a.matcher(strNormalize$default).replaceAll("");
        String s2 = AlphabeticalPickerModelKt.f6288a.matcher(strNormalize$default2).replaceAll("");
        Intrinsics.checkNotNullExpressionValue(s1, "s1");
        Intrinsics.checkNotNullExpressionValue(s2, "s2");
        return StringsKt.compareTo(s1, s2, true);
    }

    public abstract String getMainText();

    public String getSubText() {
        return null;
    }

    public boolean isSection() {
        return false;
    }
}
