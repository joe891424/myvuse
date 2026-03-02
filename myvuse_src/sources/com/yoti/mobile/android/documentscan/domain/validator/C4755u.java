package com.yoti.mobile.android.documentscan.domain.validator;

import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.u */
/* JADX INFO: loaded from: classes5.dex */
public final class C4755u {
    /* JADX INFO: renamed from: a */
    public final C4754t m4891a(String initials, String givenNames, String namePrefix) {
        Intrinsics.checkParameterIsNotNull(initials, "initials");
        Intrinsics.checkParameterIsNotNull(givenNames, "givenNames");
        Intrinsics.checkParameterIsNotNull(namePrefix, "namePrefix");
        List<String> listSplit$default = StringsKt.split$default((CharSequence) givenNames, new String[]{" "}, false, 0, 6, (Object) null);
        char[] charArray = "999999".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
        Character chFirstOrNull = StringsKt.firstOrNull(namePrefix);
        char cCharValue = chFirstOrNull != null ? chFirstOrNull.charValue() : '9';
        charArray[0] = cCharValue;
        charArray[3] = cCharValue;
        int i = 4;
        int i2 = 1;
        for (String str : listSplit$default) {
            if (i2 <= 3) {
                int i3 = i2 + 1;
                charArray[i2] = StringsKt.first(str);
                for (String str2 : StringsKt.split$default((CharSequence) str, new String[]{"-"}, false, 0, 6, (Object) null)) {
                    if (i < charArray.length) {
                        charArray[i] = StringsKt.first(str2);
                        i++;
                    }
                }
                i2 = i3;
            }
        }
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) new String(charArray), initials, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            throw new IllegalStateException("Candidate[" + ((Object) charArray) + "] doesn't contain initials: " + initials);
        }
        if (iIndexOf$default != 0) {
            if (iIndexOf$default != 2) {
                return new C4754t(namePrefix, givenNames);
            }
            throw new IllegalStateException("Candidate[" + ((Object) charArray) + "] doesn't contain initials: " + initials);
        }
        String strSubstring = new String(charArray).substring(1, 3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return !Intrinsics.areEqual(strSubstring, initials) ? new C4754t("", namePrefix + SafeJsonPrimitive.NULL_CHAR + givenNames) : new C4754t(namePrefix, givenNames);
    }
}
