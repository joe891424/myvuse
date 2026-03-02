package com.yoti.mobile.android.documentcapture.p055id.view.selection;

import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.common.p049ui.widgets.StringTransformation;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.view.DocumentScreen;
import com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeViewData;
import com.yoti.mobile.android.documentcapture.view.selection.CountryEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.CountryNotListedViewData;
import com.yoti.mobile.android.documentcapture.view.selection.CountryViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DoNotHaveDocumentsViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/selection/IdDocConfigToDocSelectionViewDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewData;", "countryEntityToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountryEntityToViewDataMapper;", "objectiveTypeEntityToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeEntityToViewDataMapper;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/CountryEntityToViewDataMapper;Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeEntityToViewDataMapper;)V", "map", "from", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocConfigToDocSelectionViewDataMapper implements Mapper<DocumentResourceConfigEntity, DocumentSelectionViewData> {
    private final CountryEntityToViewDataMapper countryEntityToViewDataMapper;
    private final CaptureObjectiveTypeEntityToViewDataMapper objectiveTypeEntityToViewDataMapper;

    @Inject
    public IdDocConfigToDocSelectionViewDataMapper(CountryEntityToViewDataMapper countryEntityToViewDataMapper, CaptureObjectiveTypeEntityToViewDataMapper objectiveTypeEntityToViewDataMapper) {
        Intrinsics.checkNotNullParameter(countryEntityToViewDataMapper, "countryEntityToViewDataMapper");
        Intrinsics.checkNotNullParameter(objectiveTypeEntityToViewDataMapper, "objectiveTypeEntityToViewDataMapper");
        this.countryEntityToViewDataMapper = countryEntityToViewDataMapper;
        this.objectiveTypeEntityToViewDataMapper = objectiveTypeEntityToViewDataMapper;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public DocumentSelectionViewData map(DocumentResourceConfigEntity from) {
        Object next;
        Intrinsics.checkNotNullParameter(from, "from");
        List<CountryViewData> listMapList = this.countryEntityToViewDataMapper.mapList(from.getCountries());
        CountryNotListedViewData countryNotListedViewData = new CountryNotListedViewData(C4608R.string.yds_country_selection_option_country_isnt_listed, null, 2, null);
        Iterator<T> it2 = listMapList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            String iso3Code = ((CountryViewData) next).getIso3Code();
            DocumentResourceConfigEntity.CountryEntity preselectedCountry = from.getPreselectedCountry();
            if (Intrinsics.areEqual(iso3Code, preselectedCountry != null ? preselectedCountry.getIso3Code() : null)) {
                break;
            }
        }
        CountryViewData countryViewData = (CountryViewData) next;
        CompoundTextResource compoundTextResource = new CompoundTextResource(C4608R.string.yds_document_selection_header, (StringTransformation) null, 2, (DefaultConstructorMarker) null);
        CaptureObjectiveTypeViewData map = this.objectiveTypeEntityToViewDataMapper.map(from.getObjective());
        DocumentScreen documentScreen = DocumentScreen.DOCUMENT_SELECTION;
        List<DocumentViewData> documents = countryViewData != null ? countryViewData.getDocuments() : null;
        if (documents == null) {
            documents = CollectionsKt.emptyList();
        }
        return new DocumentSelectionViewData(compoundTextResource, map, countryViewData, listMapList, countryNotListedViewData, new DoNotHaveDocumentsViewData(documentScreen, documents));
    }
}
