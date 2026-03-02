package com.yoti.mobile.android.documentcapture.p055id.domain.model;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/NfcPassportCountries;", "", "countries", "", "", "(Ljava/util/Set;)V", "getCountries", "()Ljava/util/Set;", "component1", "copy", "equals", "", "other", "hashCode", "", "isNfcPassportCountry", "iso3Code", "toString", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class NfcPassportCountries {
    private final Set<String> countries;

    public NfcPassportCountries(Set<String> countries) {
        Intrinsics.checkNotNullParameter(countries, "countries");
        this.countries = countries;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NfcPassportCountries copy$default(NfcPassportCountries nfcPassportCountries, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = nfcPassportCountries.countries;
        }
        return nfcPassportCountries.copy(set);
    }

    public final Set<String> component1() {
        return this.countries;
    }

    public final NfcPassportCountries copy(Set<String> countries) {
        Intrinsics.checkNotNullParameter(countries, "countries");
        return new NfcPassportCountries(countries);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NfcPassportCountries) && Intrinsics.areEqual(this.countries, ((NfcPassportCountries) other).countries);
    }

    public final Set<String> getCountries() {
        return this.countries;
    }

    public int hashCode() {
        return this.countries.hashCode();
    }

    public final boolean isNfcPassportCountry(String iso3Code) {
        Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
        return this.countries.contains(iso3Code);
    }

    public String toString() {
        return "NfcPassportCountries(countries=" + this.countries + ')';
    }
}
