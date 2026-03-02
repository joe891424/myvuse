package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import com.facebook.react.uimanager.ViewProps;
import com.yoti.mobile.android.common.p049ui.widgets.utils.StylingTransformation;
import io.branch.rnbranch.RNBranchModule;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a7\u0010\f\u001a\u00020\u0005*\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, m5598d2 = {"", "Lcom/yoti/mobile/android/common/ui/widgets/StringTransformation;", "transformation", ViewProps.TRANSFORM, "(Ljava/lang/String;Lcom/yoti/mobile/android/common/ui/widgets/StringTransformation;)Ljava/lang/String;", "", "", "Lcom/yoti/mobile/android/common/ui/widgets/utils/StylingTransformation;", "stylingTransformations", "Landroid/content/Context;", "context", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "a", "(Ljava/lang/CharSequence;Ljava/util/List;Landroid/content/Context;Ljava/util/List;)Ljava/lang/CharSequence;", "uiWidgets_release"}, m5599k = 2, m5600mv = {1, 4, 2})
public final class CompoundTextResourceKt {

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StringTransformation.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[StringTransformation.NONE.ordinal()] = 1;
            iArr[StringTransformation.FIRST_LETTER_CAPS.ordinal()] = 2;
            iArr[StringTransformation.LOWER_CASE_ALL.ordinal()] = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static final CharSequence m4390a(CharSequence charSequence, List<? extends StylingTransformation> list, Context context, List<String> list2) {
        return list.isEmpty() ? charSequence : m4390a(list.get(0).execute(charSequence, list2, context), list.subList(1, list.size()), context, list2);
    }

    public static final String transform(String transform, StringTransformation transformation) {
        String strValueOf;
        Intrinsics.checkNotNullParameter(transform, "$this$transform");
        Intrinsics.checkNotNullParameter(transformation, "transformation");
        int i = WhenMappings.$EnumSwitchMapping$0[transformation.ordinal()];
        if (i == 1) {
            return transform;
        }
        if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
            String lowerCase = transform.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        if (transform.length() <= 0) {
            return transform;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = transform.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            Locale locale2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale2, "Locale.US");
            strValueOf = CharsKt.titlecase(cCharAt, locale2);
        } else {
            strValueOf = String.valueOf(cCharAt);
        }
        StringBuilder sbAppend = sb.append(strValueOf.toString());
        String strSubstring = transform.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return sbAppend.append(strSubstring).toString();
    }
}
