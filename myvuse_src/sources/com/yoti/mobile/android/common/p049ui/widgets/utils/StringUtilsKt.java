package com.yoti.mobile.android.common.p049ui.widgets.utils;

import java.text.Normalizer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m5598d2 = {"", "Ljava/text/Normalizer$Form;", "form", "normalize", "(Ljava/lang/String;Ljava/text/Normalizer$Form;)Ljava/lang/String;", "uiWidgets_release"}, m5599k = 2, m5600mv = {1, 4, 2})
public final class StringUtilsKt {
    public static final String normalize(String normalize, Normalizer.Form form) {
        Intrinsics.checkNotNullParameter(normalize, "$this$normalize");
        Intrinsics.checkNotNullParameter(form, "form");
        String strNormalize = Normalizer.normalize(normalize, form);
        Intrinsics.checkNotNullExpressionValue(strNormalize, "Normalizer.normalize(this, form)");
        return strNormalize;
    }

    public static /* synthetic */ String normalize$default(String str, Normalizer.Form form, int i, Object obj) {
        if ((i & 1) != 0) {
            form = Normalizer.Form.NFD;
        }
        return normalize(str, form);
    }
}
