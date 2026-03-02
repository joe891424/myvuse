package com.yoti.mobile.android.documentcapture.p055id.data.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/Mrz;", "", "type", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/MrzType;", "line1", "", "line2", "line3", "(Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/MrzType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLine1", "()Ljava/lang/String;", "getLine2", "getLine3", "getType", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/MrzType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class Mrz {

    @SerializedName("line1")
    private final String line1;

    @SerializedName("line2")
    private final String line2;

    @SerializedName("line3")
    private final String line3;

    @SerializedName("type")
    private final MrzType type;

    public Mrz() {
        this(null, null, null, null, 15, null);
    }

    public Mrz(MrzType mrzType, String str, String str2, String str3) {
        this.type = mrzType;
        this.line1 = str;
        this.line2 = str2;
        this.line3 = str3;
    }

    public static /* synthetic */ Mrz copy$default(Mrz mrz, MrzType mrzType, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            mrzType = mrz.type;
        }
        if ((i & 2) != 0) {
            str = mrz.line1;
        }
        if ((i & 4) != 0) {
            str2 = mrz.line2;
        }
        if ((i & 8) != 0) {
            str3 = mrz.line3;
        }
        return mrz.copy(mrzType, str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MrzType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLine1() {
        return this.line1;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLine2() {
        return this.line2;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLine3() {
        return this.line3;
    }

    public final Mrz copy(MrzType type, String line1, String line2, String line3) {
        return new Mrz(type, line1, line2, line3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Mrz)) {
            return false;
        }
        Mrz mrz = (Mrz) other;
        return this.type == mrz.type && Intrinsics.areEqual(this.line1, mrz.line1) && Intrinsics.areEqual(this.line2, mrz.line2) && Intrinsics.areEqual(this.line3, mrz.line3);
    }

    public final String getLine1() {
        return this.line1;
    }

    public final String getLine2() {
        return this.line2;
    }

    public final String getLine3() {
        return this.line3;
    }

    public final MrzType getType() {
        return this.type;
    }

    public int hashCode() {
        MrzType mrzType = this.type;
        int iHashCode = (mrzType == null ? 0 : mrzType.hashCode()) * 31;
        String str = this.line1;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.line2;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.line3;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "Mrz(type=" + this.type + ", line1=" + this.line1 + ", line2=" + this.line2 + ", line3=" + this.line3 + ')';
    }

    public /* synthetic */ Mrz(MrzType mrzType, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mrzType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }
}
