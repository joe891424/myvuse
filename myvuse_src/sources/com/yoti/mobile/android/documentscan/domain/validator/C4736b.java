package com.yoti.mobile.android.documentscan.domain.validator;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.b */
/* JADX INFO: loaded from: classes5.dex */
public final class C4736b {
    /* JADX INFO: renamed from: a */
    private final int m4876a(int i, List<String> list, C4735a c4735a) {
        int iM4876a;
        if (!list.isEmpty() && c4735a.m4874a() != null) {
            Map<String, C4735a> mapM4874a = c4735a.m4874a();
            String str = (String) CollectionsKt.first((List) list);
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String upperCase = str.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
            C4735a c4735a2 = mapM4874a.get(upperCase);
            if (c4735a2 != null && (iM4876a = m4876a(i + 1, CollectionsKt.drop(list, 1), c4735a2)) != 0) {
                return iM4876a;
            }
        }
        if (c4735a.m4875b()) {
            return i;
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    private final int m4877a(List<String> list) {
        return m4876a(0, list, C4737c.f6952a);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v7, types: [T, java.util.List] */
    /* JADX INFO: renamed from: a */
    public final Name m4878a(String givenNames) {
        Intrinsics.checkParameterIsNotNull(givenNames, "givenNames");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String strReplace$default = StringsKt.replace$default(StringsKt.trim((CharSequence) givenNames).toString(), ".", "", false, 4, (Object) null);
        Integer numValueOf = Integer.valueOf(StringsKt.indexOf$default((CharSequence) strReplace$default, "/", 0, false, 6, (Object) null));
        String strJoinToString$default = null;
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            objectRef.element = StringsKt.split$default((CharSequence) strReplace$default, new String[]{" "}, false, 0, 6, (Object) null);
            int iM4877a = m4877a((List<String>) objectRef.element);
            if (iM4877a > 0) {
                strJoinToString$default = CollectionsKt.joinToString$default(((List) objectRef.element).subList(0, iM4877a), " ", null, null, 0, null, null, 62, null);
                objectRef.element = CollectionsKt.drop((List) objectRef.element, iM4877a);
            }
            return new Name(strJoinToString$default, (List) objectRef.element);
        }
        int iIntValue = numValueOf.intValue();
        if (strReplace$default == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strReplace$default.substring(0, iIntValue);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        objectRef.element = StringsKt.split$default((CharSequence) strSubstring, new String[]{" "}, false, 0, 6, (Object) null);
        int i = iIntValue + 1;
        if (strReplace$default == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring2 = strReplace$default.substring(i);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return new Name(strSubstring2, (List) objectRef.element);
    }
}
