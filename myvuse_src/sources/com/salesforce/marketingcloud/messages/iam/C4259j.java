package com.salesforce.marketingcloud.messages.iam;

import android.os.Parcel;
import android.os.Parcelable;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.j */
/* JADX INFO: loaded from: classes6.dex */
public class C4259j implements Parcelable {
    public static final Parcelable.Creator<C4259j> CREATOR = new a();

    /* JADX INFO: renamed from: e */
    public static final String f5246e = "buttonClicked";

    /* JADX INFO: renamed from: f */
    public static final String f5247f = "dismissed";

    /* JADX INFO: renamed from: g */
    public static final String f5248g = "autoDismissed";

    /* JADX INFO: renamed from: h */
    public static final String f5249h = "unknown";

    /* JADX INFO: renamed from: a */
    final String f5250a;

    /* JADX INFO: renamed from: b */
    final InAppMessage.Button f5251b;

    /* JADX INFO: renamed from: c */
    final long f5252c;

    /* JADX INFO: renamed from: d */
    final Date f5253d;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.j$a */
    class a implements Parcelable.Creator<C4259j> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C4259j createFromParcel(Parcel parcel) {
            return new C4259j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C4259j[] newArray(int i) {
            return new C4259j[i];
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.j$b */
    @Retention(RetentionPolicy.SOURCE)
    @interface b {
    }

    protected C4259j(Parcel parcel) {
        this.f5250a = parcel.readString();
        this.f5251b = (InAppMessage.Button) parcel.readParcelable(InAppMessage.Button.class.getClassLoader());
        this.f5252c = parcel.readLong();
        this.f5253d = new Date(parcel.readLong());
    }

    /* JADX INFO: renamed from: a */
    static C4259j m3755a(Date date, long j) {
        return new C4259j(f5248g, date, j, null);
    }

    /* JADX INFO: renamed from: e */
    static C4259j m3758e() {
        return new C4259j("unknown", new Date(), -1L, null);
    }

    /* JADX INFO: renamed from: b */
    public long m3760b() {
        return this.f5252c;
    }

    /* JADX INFO: renamed from: c */
    public Date m3761c() {
        return this.f5253d;
    }

    /* JADX INFO: renamed from: d */
    public String m3762d() {
        return this.f5250a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5250a);
        parcel.writeParcelable(this.f5251b, i);
        parcel.writeLong(this.f5252c);
        parcel.writeLong(this.f5253d.getTime());
    }

    private C4259j(String str, Date date, long j, InAppMessage.Button button) {
        this.f5250a = str;
        this.f5252c = j;
        this.f5251b = button;
        this.f5253d = date;
    }

    /* JADX INFO: renamed from: a */
    static C4259j m3756a(Date date, long j, InAppMessage.Button button) {
        return new C4259j(f5246e, date, j, button);
    }

    /* JADX INFO: renamed from: b */
    static C4259j m3757b(Date date, long j) {
        return new C4259j("dismissed", date, j, null);
    }

    /* JADX INFO: renamed from: a */
    public InAppMessage.Button m3759a() {
        return this.f5251b;
    }
}
