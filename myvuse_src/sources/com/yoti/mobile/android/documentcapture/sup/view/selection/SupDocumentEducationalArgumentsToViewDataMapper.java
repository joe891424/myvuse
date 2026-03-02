package com.yoti.mobile.android.documentcapture.sup.view.selection;

import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.common.p049ui.widgets.StringTransformation;
import com.yoti.mobile.android.documentcapture.sup.C4653R;
import com.yoti.mobile.android.documentcapture.view.DocumentScreen;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalArguments;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalArgumentsToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DoNotHaveDocumentsViewData;
import com.yoti.mobile.android.yotisdkcore.core.view.localisation.LocalisedCountriesProvider;
import java.io.Serializable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/selection/SupDocumentEducationalArgumentsToViewDataMapper;", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalArgumentsToViewDataMapper;", "localisedCountriesProvider", "Lcom/yoti/mobile/android/yotisdkcore/core/view/localisation/LocalisedCountriesProvider;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/localisation/LocalisedCountriesProvider;)V", "map", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewData;", "from", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalArguments;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentEducationalArgumentsToViewDataMapper implements DocumentEducationalArgumentsToViewDataMapper {
    private final LocalisedCountriesProvider localisedCountriesProvider;

    @Inject
    public SupDocumentEducationalArgumentsToViewDataMapper(LocalisedCountriesProvider localisedCountriesProvider) {
        Intrinsics.checkNotNullParameter(localisedCountriesProvider, "localisedCountriesProvider");
        this.localisedCountriesProvider = localisedCountriesProvider;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public DocumentEducationalViewData map(DocumentEducationalArguments from) {
        Intrinsics.checkNotNullParameter(from, "from");
        String localizedCountryName = this.localisedCountriesProvider.getLocalizedCountryName(from.getCountryIso3Code());
        if (localizedCountryName == null) {
            localizedCountryName = "";
        }
        return new DocumentEducationalViewData(new CompoundTextResource(C4653R.string.yds_non_id_document_education_header, CollectionsKt.listOf((Object[]) new Serializable[]{new CompoundTextResource.StringResId(from.getDocumentName()), localizedCountryName}), StringTransformation.FIRST_LETTER_CAPS, null, 8, null), new CompoundTextResource(C4653R.string.yds_non_id_document_education_description, (StringTransformation) null, 2, (DefaultConstructorMarker) null), from.getObjective().getEducationalRequirements(from.getDocumentViewData().getDocumentType()), C4653R.string.yds_common_continue, null, from.getDocumentViewData(), from.getObjective(), new DoNotHaveDocumentsViewData(DocumentScreen.DOCUMENT_EDUCATIONAL, CollectionsKt.listOf(from.getDocumentViewData())), 16, null);
    }
}
