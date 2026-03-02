package com.yoti.mobile.android.documentscan.domain.validator;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.t */
/* JADX INFO: loaded from: classes5.dex */
public final class C4754t {

    /* JADX INFO: renamed from: a */
    private final String f6974a;

    /* JADX INFO: renamed from: b */
    private final String f6975b;

    public C4754t(String namePrefix, String givenNames) {
        Intrinsics.checkParameterIsNotNull(namePrefix, "namePrefix");
        Intrinsics.checkParameterIsNotNull(givenNames, "givenNames");
        this.f6974a = namePrefix;
        this.f6975b = givenNames;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4754t)) {
            return false;
        }
        C4754t c4754t = (C4754t) obj;
        return Intrinsics.areEqual(this.f6974a, c4754t.f6974a) && Intrinsics.areEqual(this.f6975b, c4754t.f6975b);
    }

    public int hashCode() {
        String str = this.f6974a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f6975b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "UkDlInitialResult(namePrefix=" + this.f6974a + ", givenNames=" + this.f6975b + ")";
    }
}
