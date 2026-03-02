package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.documentcapture.view.selection.DocumentRequirementViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.core.view.localisation.LocalisedCountriesProvider;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0002J\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/CountryEntityToViewDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$CountryEntity;", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountryViewData;", "localisedCountriesProvider", "Lcom/yoti/mobile/android/yotisdkcore/core/view/localisation/LocalisedCountriesProvider;", "documentTypeEntityToViewDataMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeEntityToViewDataMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/localisation/LocalisedCountriesProvider;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeEntityToViewDataMapper;)V", "map", "from", "mapDocumentRequirements", "", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementViewData;", "documentRequirements", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentRequirementEntity;", "mapList", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class CountryEntityToViewDataMapper implements Mapper<DocumentResourceConfigEntity.CountryEntity, CountryViewData> {
    private final DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper;
    private final LocalisedCountriesProvider localisedCountriesProvider;

    @Inject
    public CountryEntityToViewDataMapper(LocalisedCountriesProvider localisedCountriesProvider, DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper) {
        Intrinsics.checkNotNullParameter(localisedCountriesProvider, "localisedCountriesProvider");
        Intrinsics.checkNotNullParameter(documentTypeEntityToViewDataMapper, "documentTypeEntityToViewDataMapper");
        this.localisedCountriesProvider = localisedCountriesProvider;
        this.documentTypeEntityToViewDataMapper = documentTypeEntityToViewDataMapper;
    }

    private final Set<DocumentRequirementViewData> mapDocumentRequirements(Set<? extends DocumentResourceConfigEntity.DocumentRequirementEntity> documentRequirements) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (DocumentResourceConfigEntity.DocumentRequirementEntity documentRequirementEntity : documentRequirements) {
            if (!(documentRequirementEntity instanceof DocumentResourceConfigEntity.DocumentRequirementEntity.DateFromEntity)) {
                throw new NoWhenBranchMatchedException();
            }
            linkedHashSet.add(new DocumentRequirementViewData.DateFromViewData(((DocumentResourceConfigEntity.DocumentRequirementEntity.DateFromEntity) documentRequirementEntity).getDate()));
        }
        return linkedHashSet;
    }

    public final List<CountryViewData> mapList(List<DocumentResourceConfigEntity.CountryEntity> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = from.iterator();
        while (it2.hasNext()) {
            CountryViewData map = map((DocumentResourceConfigEntity.CountryEntity) it2.next());
            if (map != null) {
                arrayList.add(map);
            }
        }
        return arrayList;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public CountryViewData map(DocumentResourceConfigEntity.CountryEntity from) {
        Intrinsics.checkNotNullParameter(from, "from");
        String localizedCountryName = this.localisedCountriesProvider.getLocalizedCountryName(from.getIso3Code());
        if (localizedCountryName == null) {
            return null;
        }
        String iso3Code = from.getIso3Code();
        List<DocumentResourceConfigEntity.DocumentEntity> supportedDocuments = from.getSupportedDocuments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(supportedDocuments, 10));
        for (DocumentResourceConfigEntity.DocumentEntity documentEntity : supportedDocuments) {
            arrayList.add(new DocumentViewData(this.documentTypeEntityToViewDataMapper.map(documentEntity.getDocumentType()), mapDocumentRequirements(documentEntity.getDocumentRequirements())));
        }
        return new CountryViewData(iso3Code, localizedCountryName, arrayList);
    }
}
