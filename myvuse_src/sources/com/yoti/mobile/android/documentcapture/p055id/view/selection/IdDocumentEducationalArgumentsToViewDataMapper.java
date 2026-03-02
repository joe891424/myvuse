package com.yoti.mobile.android.documentcapture.p055id.view.selection;

import com.yoti.mobile.android.common.p049ui.components.utils.Demonym;
import com.yoti.mobile.android.common.p049ui.components.utils.IDemonymProvider;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.commonui.MediaResource;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.view.DocumentScreen;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalArguments;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalArgumentsToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DoNotHaveDocumentsViewData;
import com.yoti.mobile.android.yotisdkcore.core.p085di.YdsDemonymProvider;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import java.io.Serializable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/selection/IdDocumentEducationalArgumentsToViewDataMapper;", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalArgumentsToViewDataMapper;", "demonymProvider", "Lcom/yoti/mobile/android/common/ui/components/utils/IDemonymProvider;", "(Lcom/yoti/mobile/android/common/ui/components/utils/IDemonymProvider;)V", "map", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewData;", "from", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalArguments;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentEducationalArgumentsToViewDataMapper implements DocumentEducationalArgumentsToViewDataMapper {
    private final IDemonymProvider demonymProvider;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DocumentTypeViewData.values().length];
            iArr[DocumentTypeViewData.AADHAAR.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public IdDocumentEducationalArgumentsToViewDataMapper(@YdsDemonymProvider IDemonymProvider demonymProvider) {
        Intrinsics.checkNotNullParameter(demonymProvider, "demonymProvider");
        this.demonymProvider = demonymProvider;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public DocumentEducationalViewData map(DocumentEducationalArguments from) {
        Intrinsics.checkNotNullParameter(from, "from");
        DocumentTypeViewData documentType = from.getDocumentViewData().getDocumentType();
        MediaResource mediaResource = WhenMappings.$EnumSwitchMapping$0[documentType.ordinal()] == 1 ? new MediaResource(MediaResource.MediaType.VIDEO, C4608R.raw.yds_aadhaar_educational) : null;
        Demonym demonym = this.demonymProvider.getDemonym(from.getCountryIso3Code());
        return new DocumentEducationalViewData((documentType.getImplicitNationality() || demonym == null) ? new CompoundTextResource(C4608R.string.yds_document_education_header, CollectionsKt.listOf(new CompoundTextResource.StringResId(from.getDocumentName())), null, null, 12, null) : new CompoundTextResource(C4608R.string.yds_document_education_demonym_header, CollectionsKt.listOf((Object[]) new Serializable[]{demonym.getName(), new CompoundTextResource.StringResId(from.getDocumentName())}), null, null, 12, null), new CompoundTextResource(C4608R.string.yds_document_education_one_page_description, CollectionsKt.listOf(new CompoundTextResource.StringResId(from.getDocumentName())), null, null, 12, null), null, C4608R.string.yds_document_education_primary_cta, mediaResource, from.getDocumentViewData(), from.getObjective(), new DoNotHaveDocumentsViewData(DocumentScreen.DOCUMENT_EDUCATIONAL, CollectionsKt.listOf(from.getDocumentViewData())), 4, null);
    }
}
