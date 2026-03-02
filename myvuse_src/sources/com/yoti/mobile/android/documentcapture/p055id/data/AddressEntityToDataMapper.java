package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.Address;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.AddressFormatType;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.AddressEntity;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.DemonymProviderKt;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewDataKt;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\f\u0010\u0013\u001a\u00020\u0003*\u00020\u0002H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/AddressEntityToDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity;", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/Address;", "()V", "FORMAT_1_COUNTRIES", "", "", "FORMAT_2_COUNTRIES", "FORMAT_3_COUNTRIES", "map", "from", "mapToFormat1", "addressEntity", "country", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity$CountryEntity;", "mapToFormat2", "mapToFormat3", "mapToFormat4", "mapToStructuredAddress", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AddressEntityToDataMapper implements Mapper<AddressEntity, Address> {
    private final List<String> FORMAT_1_COUNTRIES = CollectionsKt.listOf((Object[]) new String[]{DemonymProviderKt.UK_ISO3_CODE, "JEY", "IMN"});
    private final List<String> FORMAT_2_COUNTRIES = CollectionsKt.listOf("IND");
    private final List<String> FORMAT_3_COUNTRIES = CollectionsKt.listOf(DocumentTypeViewDataKt.USA_ISO3CODE);

    @Inject
    public AddressEntityToDataMapper() {
    }

    private final Address mapToFormat1(AddressEntity addressEntity, AddressEntity.CountryEntity country) {
        AddressFormatType addressFormatType = AddressFormatType.FORMAT_1;
        String building = addressEntity.getBuilding();
        List<String> lines = addressEntity.getLines();
        String str = lines != null ? (String) CollectionsKt.getOrNull(lines, 0) : null;
        List<String> lines2 = addressEntity.getLines();
        String str2 = lines2 != null ? (String) CollectionsKt.getOrNull(lines2, 1) : null;
        List<String> lines3 = addressEntity.getLines();
        return new Address(addressFormatType, null, null, null, building, null, null, str, str2, lines3 != null ? (String) CollectionsKt.getOrNull(lines3, 2) : null, null, null, null, null, addressEntity.getTown(), null, null, addressEntity.getCounty(), addressEntity.getPostcode(), null, country.getIso3Code(), country.getName(), null, addressEntity.getFullAddress(), 4832366, null);
    }

    private final Address mapToFormat2(AddressEntity addressEntity, AddressEntity.CountryEntity country) {
        AddressFormatType addressFormatType = AddressFormatType.FORMAT_2;
        String careOf = addressEntity.getCareOf();
        String building = addressEntity.getBuilding();
        List<String> lines = addressEntity.getLines();
        return new Address(addressFormatType, careOf, null, null, building, lines != null ? CollectionsKt.joinToString$default(lines, " ", null, null, 0, null, null, 62, null) : null, addressEntity.getLandmark(), null, null, null, null, null, null, addressEntity.getLocality(), addressEntity.getTown(), addressEntity.getSubDistrict(), addressEntity.getDistrict(), addressEntity.getCounty(), addressEntity.getPostcode(), addressEntity.getPostOffice(), country.getIso3Code(), country.getName(), null, addressEntity.getFullAddress(), 4202380, null);
    }

    private final Address mapToFormat3(AddressEntity addressEntity, AddressEntity.CountryEntity country) {
        AddressFormatType addressFormatType = AddressFormatType.FORMAT_3;
        List<String> lines = addressEntity.getLines();
        String str = lines != null ? (String) CollectionsKt.getOrNull(lines, 0) : null;
        List<String> lines2 = addressEntity.getLines();
        return new Address(addressFormatType, null, null, null, null, null, null, str, lines2 != null ? (String) CollectionsKt.getOrNull(lines2, 1) : null, null, null, null, null, null, addressEntity.getTown(), null, null, addressEntity.getCounty(), addressEntity.getPostcode(), null, country.getIso3Code(), country.getName(), null, addressEntity.getFullAddress(), 4832894, null);
    }

    private final Address mapToFormat4(AddressEntity addressEntity, AddressEntity.CountryEntity country) {
        AddressFormatType addressFormatType = AddressFormatType.FORMAT_4;
        List<String> lines = addressEntity.getLines();
        String str = lines != null ? (String) CollectionsKt.getOrNull(lines, 0) : null;
        List<String> lines2 = addressEntity.getLines();
        String str2 = lines2 != null ? (String) CollectionsKt.getOrNull(lines2, 1) : null;
        List<String> lines3 = addressEntity.getLines();
        String str3 = lines3 != null ? (String) CollectionsKt.getOrNull(lines3, 2) : null;
        List<String> lines4 = addressEntity.getLines();
        String str4 = lines4 != null ? (String) CollectionsKt.getOrNull(lines4, 3) : null;
        List<String> lines5 = addressEntity.getLines();
        String str5 = lines5 != null ? (String) CollectionsKt.getOrNull(lines5, 4) : null;
        List<String> lines6 = addressEntity.getLines();
        return new Address(addressFormatType, null, null, null, null, null, null, str, str2, str3, str4, str5, lines6 != null ? (String) CollectionsKt.getOrNull(lines6, 5) : null, null, null, null, null, null, addressEntity.getPostcode(), null, country.getIso3Code(), country.getName(), null, addressEntity.getFullAddress(), 4972670, null);
    }

    private final Address mapToStructuredAddress(AddressEntity addressEntity) {
        return this.FORMAT_1_COUNTRIES.contains(addressEntity.getCountry().getIso3Code()) ? mapToFormat1(addressEntity, addressEntity.getCountry()) : this.FORMAT_2_COUNTRIES.contains(addressEntity.getCountry().getIso3Code()) ? mapToFormat2(addressEntity, addressEntity.getCountry()) : this.FORMAT_3_COUNTRIES.contains(addressEntity.getCountry().getIso3Code()) ? mapToFormat3(addressEntity, addressEntity.getCountry()) : mapToFormat4(addressEntity, addressEntity.getCountry());
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public Address map(AddressEntity from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return mapToStructuredAddress(from);
    }
}
