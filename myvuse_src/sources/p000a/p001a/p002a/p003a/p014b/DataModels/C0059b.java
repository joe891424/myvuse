package p000a.p001a.p002a.p003a.p014b.DataModels;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: renamed from: a.a.a.a.b.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0059b implements Parcelable {
    public static final Parcelable.Creator<C0059b> CREATOR = new a();

    /* JADX INFO: renamed from: a */
    public String f142a;

    /* JADX INFO: renamed from: b */
    public String f143b;

    /* JADX INFO: renamed from: c */
    public String f144c;

    /* JADX INFO: renamed from: d */
    public String f145d;

    /* JADX INFO: renamed from: e */
    public String f146e;

    /* JADX INFO: renamed from: f */
    public ArrayList<C0061d> f147f = new ArrayList<>();

    /* JADX INFO: renamed from: a.a.a.a.b.a.b$a */
    public class a implements Parcelable.Creator<C0059b> {
        @Override // android.os.Parcelable.Creator
        public C0059b createFromParcel(Parcel parcel) {
            return new C0059b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C0059b[] newArray(int i) {
            return new C0059b[i];
        }
    }

    public C0059b() {
    }

    public C0059b(Parcel parcel) {
        this.f142a = parcel.readString();
        this.f143b = parcel.readString();
        this.f144c = parcel.readString();
        this.f145d = parcel.readString();
        this.f146e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "OTConsentPreferencesCustomPreferencesModel{Id='" + this.f142a + "', Name='" + this.f143b + "', Description='" + this.f144c + "', SelectionType='" + this.f145d + "', Required='" + this.f146e + "', otConsentPreferencesOptionsModels=" + this.f147f + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f142a);
        parcel.writeString(this.f143b);
        parcel.writeString(this.f144c);
        parcel.writeString(this.f145d);
        parcel.writeString(this.f146e);
    }
}
