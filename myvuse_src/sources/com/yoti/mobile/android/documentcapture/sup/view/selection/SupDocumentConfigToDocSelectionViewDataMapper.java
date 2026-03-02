package com.yoti.mobile.android.documentcapture.sup.view.selection;

import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.common.p049ui.widgets.StringTransformation;
import com.yoti.mobile.android.documentcapture.sup.C4653R;
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
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/selection/SupDocumentConfigToDocSelectionViewDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewData;", "countryEntityToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountryEntityToViewDataMapper;", "objectiveTypeToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeEntityToViewDataMapper;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/CountryEntityToViewDataMapper;Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeEntityToViewDataMapper;)V", "map", "from", "mapTitle", "Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "document", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "objective", "Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentConfigToDocSelectionViewDataMapper implements Mapper<DocumentResourceConfigEntity, DocumentSelectionViewData> {
    private final CountryEntityToViewDataMapper countryEntityToViewDataMapper;
    private final CaptureObjectiveTypeEntityToViewDataMapper objectiveTypeToViewDataMapper;

    @Inject
    public SupDocumentConfigToDocSelectionViewDataMapper(CountryEntityToViewDataMapper countryEntityToViewDataMapper, CaptureObjectiveTypeEntityToViewDataMapper objectiveTypeToViewDataMapper) {
        Intrinsics.checkNotNullParameter(countryEntityToViewDataMapper, "countryEntityToViewDataMapper");
        Intrinsics.checkNotNullParameter(objectiveTypeToViewDataMapper, "objectiveTypeToViewDataMapper");
        this.countryEntityToViewDataMapper = countryEntityToViewDataMapper;
        this.objectiveTypeToViewDataMapper = objectiveTypeToViewDataMapper;
    }

    private final CompoundTextResource mapTitle(DocumentTypeViewData document, CaptureObjectiveTypeViewData objective) {
        return document != null ? new CompoundTextResource(C4653R.string.yds_non_id_document_education_header, CollectionsKt.listOf((Object[]) new CompoundTextResource.StringResId[]{new CompoundTextResource.StringResId(objective.getHeaderResId()), new CompoundTextResource.StringResId(DocumentTypeViewData.getDocumentName$default(document, null, 1, null).getLowercaseName())}), StringTransformation.FIRST_LETTER_CAPS, null, 8, null) : new CompoundTextResource(C4653R.string.yds_non_id_document_selection_header, CollectionsKt.listOf(new CompoundTextResource.StringResId(objective.getHeaderResId())), StringTransformation.FIRST_LETTER_CAPS, null, 8, null);
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public DocumentSelectionViewData map(DocumentResourceConfigEntity from) {
        Object next;
        List<DocumentViewData> documents;
        Intrinsics.checkNotNullParameter(from, "from");
        List<CountryViewData> listMapList = this.countryEntityToViewDataMapper.mapList(from.getCountries());
        CountryViewData countryViewData = (CountryViewData) CollectionsKt.singleOrNull((List) listMapList);
        DocumentViewData documentViewData = (countryViewData == null || (documents = countryViewData.getDocuments()) == null) ? null : (DocumentViewData) CollectionsKt.singleOrNull((List) documents);
        CaptureObjectiveTypeViewData map = this.objectiveTypeToViewDataMapper.map(from.getObjective());
        CountryNotListedViewData countryNotListedViewData = new CountryNotListedViewData(C4653R.string.yds_country_selection_option_country_isnt_listed, null, 2, null);
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
        CountryViewData countryViewData2 = (CountryViewData) next;
        CompoundTextResource compoundTextResourceMapTitle = mapTitle(documentViewData != null ? documentViewData.getDocumentType() : null, map);
        DocumentScreen documentScreen = DocumentScreen.DOCUMENT_SELECTION;
        List<DocumentViewData> documents2 = countryViewData2 != null ? countryViewData2.getDocuments() : null;
        if (documents2 == null) {
            documents2 = CollectionsKt.emptyList();
        }
        return new DocumentSelectionViewData(compoundTextResourceMapTitle, map, countryViewData2, listMapList, countryNotListedViewData, new DoNotHaveDocumentsViewData(documentScreen, documents2));
    }
}
