package com.salesforce.marketingcloud.proximity;

import android.os.Parcel;
import android.os.Parcelable;
import com.salesforce.marketingcloud.messages.Region;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.proximity.c */
/* JADX INFO: loaded from: classes6.dex */
public final class C4278c implements Parcelable {
    public static final Parcelable.Creator<C4278c> CREATOR = new a();

    /* JADX INFO: renamed from: a */
    private final String f5442a;

    /* JADX INFO: renamed from: b */
    private final String f5443b;

    /* JADX INFO: renamed from: c */
    private final int f5444c;

    /* JADX INFO: renamed from: d */
    private final int f5445d;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.proximity.c$a */
    public static final class a implements Parcelable.Creator<C4278c> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C4278c createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new C4278c(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C4278c[] newArray(int i) {
            return new C4278c[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C4278c(Region region) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(region, "region");
        String strM3630id = region.m3630id();
        String strProximityUuid = region.proximityUuid();
        if (strProximityUuid == null) {
            throw new IllegalArgumentException("Not a beacon region");
        }
        this(strM3630id, strProximityUuid, region.major(), region.minor());
    }

    /* JADX INFO: renamed from: a */
    public final String m3900a() {
        return this.f5442a;
    }

    /* JADX INFO: renamed from: b */
    public final String m3901b() {
        return this.f5443b;
    }

    /* JADX INFO: renamed from: c */
    public final int m3902c() {
        return this.f5444c;
    }

    /* JADX INFO: renamed from: d */
    public final int m3903d() {
        return this.f5445d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: renamed from: e */
    public final String m3904e() {
        return this.f5443b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4278c)) {
            return false;
        }
        C4278c c4278c = (C4278c) obj;
        return Intrinsics.areEqual(this.f5442a, c4278c.f5442a) && Intrinsics.areEqual(this.f5443b, c4278c.f5443b) && this.f5444c == c4278c.f5444c && this.f5445d == c4278c.f5445d;
    }

    /* JADX INFO: renamed from: f */
    public final String m3905f() {
        return this.f5442a;
    }

    /* JADX INFO: renamed from: g */
    public final int m3906g() {
        return this.f5444c;
    }

    /* JADX INFO: renamed from: h */
    public final int m3907h() {
        return this.f5445d;
    }

    public int hashCode() {
        return (((((this.f5442a.hashCode() * 31) + this.f5443b.hashCode()) * 31) + Integer.hashCode(this.f5444c)) * 31) + Integer.hashCode(this.f5445d);
    }

    public String toString() {
        return "BeaconRegion(id=" + this.f5442a + ", guid=" + this.f5443b + ", major=" + this.f5444c + ", minor=" + this.f5445d + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f5442a);
        out.writeString(this.f5443b);
        out.writeInt(this.f5444c);
        out.writeInt(this.f5445d);
    }

    public C4278c(String id, String guid, int i, int i2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(guid, "guid");
        this.f5442a = id;
        this.f5443b = guid;
        this.f5444c = i;
        this.f5445d = i2;
    }

    /* JADX INFO: renamed from: a */
    public final C4278c m3899a(String id, String guid, int i, int i2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(guid, "guid");
        return new C4278c(id, guid, i, i2);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ C4278c m3898a(C4278c c4278c, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = c4278c.f5442a;
        }
        if ((i3 & 2) != 0) {
            str2 = c4278c.f5443b;
        }
        if ((i3 & 4) != 0) {
            i = c4278c.f5444c;
        }
        if ((i3 & 8) != 0) {
            i2 = c4278c.f5445d;
        }
        return c4278c.m3899a(str, str2, i, i2);
    }
}
