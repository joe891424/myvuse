package com.yoti.mobile.android.yotidocs.common.error;

import android.os.Parcel;
import android.os.Parcelable;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\r¨\u0006\u001f"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "Landroid/os/Parcelable;", "failureType", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "isRetryAllowed", "", HexAttribute.HEX_ATTR_CAUSE, "", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;ZLjava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "getFailureType", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class YdsFailure implements Parcelable {
    public static final Parcelable.Creator<YdsFailure> CREATOR = new Creator();

    /* JADX INFO: renamed from: a */
    private final YdsFailureType f7485a;

    /* JADX INFO: renamed from: b */
    private final boolean f7486b;

    /* JADX INFO: renamed from: c */
    private final Throwable f7487c;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<YdsFailure> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final YdsFailure createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new YdsFailure((YdsFailureType) parcel.readParcelable(YdsFailure.class.getClassLoader()), parcel.readInt() != 0, (Throwable) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final YdsFailure[] newArray(int i) {
            return new YdsFailure[i];
        }
    }

    public YdsFailure() {
        this(null, false, null, 7, null);
    }

    public YdsFailure(YdsFailureType failureType, boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(failureType, "failureType");
        this.f7485a = failureType;
        this.f7486b = z;
        this.f7487c = th;
    }

    public /* synthetic */ YdsFailure(YdsFailureType ydsFailureType, boolean z, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? YdsFailureType.TechnicalProblem.INSTANCE : ydsFailureType, (i & 2) != 0 ? true : z, (i & 4) != 0 ? null : th);
    }

    public static /* synthetic */ YdsFailure copy$default(YdsFailure ydsFailure, YdsFailureType ydsFailureType, boolean z, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            ydsFailureType = ydsFailure.f7485a;
        }
        if ((i & 2) != 0) {
            z = ydsFailure.f7486b;
        }
        if ((i & 4) != 0) {
            th = ydsFailure.f7487c;
        }
        return ydsFailure.copy(ydsFailureType, z, th);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final YdsFailureType getF7485a() {
        return this.f7485a;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getF7486b() {
        return this.f7486b;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Throwable getF7487c() {
        return this.f7487c;
    }

    public final YdsFailure copy(YdsFailureType failureType, boolean isRetryAllowed, Throwable cause) {
        Intrinsics.checkNotNullParameter(failureType, "failureType");
        return new YdsFailure(failureType, isRetryAllowed, cause);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YdsFailure)) {
            return false;
        }
        YdsFailure ydsFailure = (YdsFailure) other;
        return Intrinsics.areEqual(this.f7485a, ydsFailure.f7485a) && this.f7486b == ydsFailure.f7486b && Intrinsics.areEqual(this.f7487c, ydsFailure.f7487c);
    }

    public final Throwable getCause() {
        return this.f7487c;
    }

    public final YdsFailureType getFailureType() {
        return this.f7485a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = this.f7485a.hashCode() * 31;
        boolean z = this.f7486b;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        Throwable th = this.f7487c;
        return i + (th == null ? 0 : th.hashCode());
    }

    public final boolean isRetryAllowed() {
        return this.f7486b;
    }

    public String toString() {
        return "YdsFailure(failureType=" + this.f7485a + ", isRetryAllowed=" + this.f7486b + ", cause=" + this.f7487c + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.f7485a, flags);
        parcel.writeInt(this.f7486b ? 1 : 0);
        parcel.writeSerializable(this.f7487c);
    }
}
