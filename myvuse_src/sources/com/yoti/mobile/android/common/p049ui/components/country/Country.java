package com.yoti.mobile.android.common.p049ui.components.country;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerModel;

/* JADX INFO: loaded from: classes5.dex */
public class Country extends AlphabeticalPickerModel implements Parcelable {
    public static final Parcelable.Creator<Country> CREATOR = new C4470a();

    /* JADX INFO: renamed from: a */
    private String f5878a;

    /* JADX INFO: renamed from: b */
    private String f5879b;

    /* JADX INFO: renamed from: c */
    private int f5880c;

    /* JADX INFO: renamed from: d */
    private String f5881d;

    /* JADX INFO: renamed from: e */
    private String f5882e;

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.components.country.Country$a */
    static class C4470a implements Parcelable.Creator<Country> {
        C4470a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Country createFromParcel(Parcel parcel) {
            return new Country(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Country[] newArray(int i) {
            return new Country[i];
        }
    }

    protected Country(Parcel parcel) {
        this.f5878a = parcel.readString();
        this.f5879b = parcel.readString();
        this.f5880c = parcel.readInt();
        this.f5881d = parcel.readString();
        this.f5882e = parcel.readString();
    }

    public Country(String str, String str2, int i, String str3, String str4) {
        this.f5878a = str;
        this.f5879b = str2;
        this.f5880c = i;
        this.f5881d = str3;
        this.f5882e = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDemonym() {
        return this.f5882e;
    }

    public String getIso2Code() {
        return this.f5878a;
    }

    public String getIso3Code() {
        return this.f5879b;
    }

    @Override // com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerModel
    public String getMainText() {
        return this.f5881d;
    }

    public String getName() {
        return this.f5881d;
    }

    public int getPhoneCode() {
        return this.f5880c;
    }

    @Override // com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker.AlphabeticalPickerModel
    public String getSubText() {
        return String.format("+%1$s", Integer.valueOf(this.f5880c));
    }

    public String toString() {
        return this.f5881d != null ? this.f5878a + " = " + this.f5881d + " (+" + this.f5880c + ")" : super.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5878a);
        parcel.writeString(this.f5879b);
        parcel.writeInt(this.f5880c);
        parcel.writeString(this.f5881d);
        parcel.writeString(this.f5882e);
    }
}
