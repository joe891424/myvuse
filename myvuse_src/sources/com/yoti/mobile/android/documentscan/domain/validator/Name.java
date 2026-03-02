package com.yoti.mobile.android.documentscan.domain.validator;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J%\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/domain/validator/Name;", "", "salutation", "", "names", "", "(Ljava/lang/String;Ljava/util/List;)V", "getNames", "()Ljava/util/List;", "getSalutation", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class Name {
    private final List<String> names;
    private final String salutation;

    public Name(String str, List<String> names) {
        Intrinsics.checkParameterIsNotNull(names, "names");
        this.salutation = str;
        this.names = names;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Name copy$default(Name name, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = name.salutation;
        }
        if ((i & 2) != 0) {
            list = name.names;
        }
        return name.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSalutation() {
        return this.salutation;
    }

    public final List<String> component2() {
        return this.names;
    }

    public final Name copy(String salutation, List<String> names) {
        Intrinsics.checkParameterIsNotNull(names, "names");
        return new Name(salutation, names);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Name)) {
            return false;
        }
        Name name = (Name) other;
        return Intrinsics.areEqual(this.salutation, name.salutation) && Intrinsics.areEqual(this.names, name.names);
    }

    public final List<String> getNames() {
        return this.names;
    }

    public final String getSalutation() {
        return this.salutation;
    }

    public int hashCode() {
        String str = this.salutation;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.names;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "Name(salutation=" + this.salutation + ", names=" + this.names + ")";
    }
}
