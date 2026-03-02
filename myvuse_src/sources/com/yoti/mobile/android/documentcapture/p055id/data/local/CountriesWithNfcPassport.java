package com.yoti.mobile.android.documentcapture.p055id.data.local;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/local/CountriesWithNfcPassport;", "", "version", "", "countries", "", "", "(ILjava/util/List;)V", "getCountries", "()Ljava/util/List;", "getVersion", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class CountriesWithNfcPassport {

    @SerializedName("passportSkipNFCSelection")
    private final List<String> countries;

    @SerializedName("version")
    private final int version;

    public CountriesWithNfcPassport(int i, List<String> countries) {
        Intrinsics.checkNotNullParameter(countries, "countries");
        this.version = i;
        this.countries = countries;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CountriesWithNfcPassport copy$default(CountriesWithNfcPassport countriesWithNfcPassport, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = countriesWithNfcPassport.version;
        }
        if ((i2 & 2) != 0) {
            list = countriesWithNfcPassport.countries;
        }
        return countriesWithNfcPassport.copy(i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final List<String> component2() {
        return this.countries;
    }

    public final CountriesWithNfcPassport copy(int version, List<String> countries) {
        Intrinsics.checkNotNullParameter(countries, "countries");
        return new CountriesWithNfcPassport(version, countries);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountriesWithNfcPassport)) {
            return false;
        }
        CountriesWithNfcPassport countriesWithNfcPassport = (CountriesWithNfcPassport) other;
        return this.version == countriesWithNfcPassport.version && Intrinsics.areEqual(this.countries, countriesWithNfcPassport.countries);
    }

    public final List<String> getCountries() {
        return this.countries;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (Integer.hashCode(this.version) * 31) + this.countries.hashCode();
    }

    public String toString() {
        return "CountriesWithNfcPassport(version=" + this.version + ", countries=" + this.countries + ')';
    }
}
