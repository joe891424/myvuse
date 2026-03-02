package com.yoti.mobile.android.documentcapture.view.educational;

import com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.CountryEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.CountryViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentResourceConfigEntityToEducationalViewDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewData;", "documentEducationalArgumentsToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalArgumentsToViewDataMapper;", "countryEntityToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountryEntityToViewDataMapper;", "objectiveTypeEntityToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeEntityToViewDataMapper;", "(Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalArgumentsToViewDataMapper;Lcom/yoti/mobile/android/documentcapture/view/selection/CountryEntityToViewDataMapper;Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeEntityToViewDataMapper;)V", "map", "from", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentResourceConfigEntityToEducationalViewDataMapper implements Mapper<DocumentResourceConfigEntity, DocumentEducationalViewData> {
    private final CountryEntityToViewDataMapper countryEntityToViewDataMapper;
    private final DocumentEducationalArgumentsToViewDataMapper documentEducationalArgumentsToViewDataMapper;
    private final CaptureObjectiveTypeEntityToViewDataMapper objectiveTypeEntityToViewDataMapper;

    @Inject
    public DocumentResourceConfigEntityToEducationalViewDataMapper(DocumentEducationalArgumentsToViewDataMapper documentEducationalArgumentsToViewDataMapper, CountryEntityToViewDataMapper countryEntityToViewDataMapper, CaptureObjectiveTypeEntityToViewDataMapper objectiveTypeEntityToViewDataMapper) {
        Intrinsics.checkNotNullParameter(documentEducationalArgumentsToViewDataMapper, "documentEducationalArgumentsToViewDataMapper");
        Intrinsics.checkNotNullParameter(countryEntityToViewDataMapper, "countryEntityToViewDataMapper");
        Intrinsics.checkNotNullParameter(objectiveTypeEntityToViewDataMapper, "objectiveTypeEntityToViewDataMapper");
        this.documentEducationalArgumentsToViewDataMapper = documentEducationalArgumentsToViewDataMapper;
        this.countryEntityToViewDataMapper = countryEntityToViewDataMapper;
        this.objectiveTypeEntityToViewDataMapper = objectiveTypeEntityToViewDataMapper;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public DocumentEducationalViewData map(DocumentResourceConfigEntity from) {
        List<DocumentViewData> documents;
        Intrinsics.checkNotNullParameter(from, "from");
        List<CountryViewData> listMapList = this.countryEntityToViewDataMapper.mapList(from.getCountries());
        DocumentEducationalArgumentsToViewDataMapper documentEducationalArgumentsToViewDataMapper = this.documentEducationalArgumentsToViewDataMapper;
        CountryViewData countryViewData = (CountryViewData) CollectionsKt.singleOrNull((List) listMapList);
        DocumentViewData documentViewData = (countryViewData == null || (documents = countryViewData.getDocuments()) == null) ? null : (DocumentViewData) CollectionsKt.singleOrNull((List) documents);
        if (documentViewData == null) {
            throw new IllegalArgumentException("A single country with a single document must exist".toString());
        }
        DocumentResourceConfigEntity.CountryEntity country = from.getCountry();
        String iso3Code = country != null ? country.getIso3Code() : null;
        if (iso3Code != null) {
            return documentEducationalArgumentsToViewDataMapper.map(new DocumentEducationalArguments(documentViewData, iso3Code, this.objectiveTypeEntityToViewDataMapper.map(from.getObjective())));
        }
        throw new IllegalArgumentException("Country iso3Code must not be null".toString());
    }
}
