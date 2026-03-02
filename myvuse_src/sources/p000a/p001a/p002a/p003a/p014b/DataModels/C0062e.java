package p000a.p001a.p002a.p003a.p014b.DataModels;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: renamed from: a.a.a.a.b.a.e */
/* JADX INFO: loaded from: classes.dex */
public class C0062e implements Parcelable {
    public static final Parcelable.Creator<C0062e> CREATOR = new a();

    /* JADX INFO: renamed from: a */
    public String f171a;

    /* JADX INFO: renamed from: b */
    public ArrayList<C0061d> f172b = new ArrayList<>();

    /* JADX INFO: renamed from: a.a.a.a.b.a.e$a */
    public class a implements Parcelable.Creator<C0062e> {
        @Override // android.os.Parcelable.Creator
        public C0062e createFromParcel(Parcel parcel) {
            return new C0062e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C0062e[] newArray(int i) {
            return new C0062e[i];
        }
    }

    public C0062e() {
    }

    public C0062e(Parcel parcel) {
        this.f171a = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f171a);
    }
}
