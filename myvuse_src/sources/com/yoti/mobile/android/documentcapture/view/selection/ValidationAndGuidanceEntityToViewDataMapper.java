package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.commonui.AppBarConfig;
import com.yoti.mobile.android.commonui.GuidelinesItem;
import com.yoti.mobile.android.commonui.GuidelinesViewData;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.domain.model.ApplicantProfileEntity;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.view.ApplicantProfileAddressFormatter;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.view.ApplicantProfileDateOfBirthFormatter;
import com.yoti.mobile.android.yotisdkcore.core.view.localisation.LocalisedCountriesProvider;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/ValidationAndGuidanceEntityToViewDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/view/selection/ValidationAndGuidanceEntityToViewDataMapper$MapperParams;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementsViewData;", "documentTypeEntityToViewDataMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeEntityToViewDataMapper;", "localisedCountriesProvider", "Lcom/yoti/mobile/android/yotisdkcore/core/view/localisation/LocalisedCountriesProvider;", "applicantProfileAddressFormatter", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/view/ApplicantProfileAddressFormatter;", "applicantProfileDateOfBirthFormatter", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/view/ApplicantProfileDateOfBirthFormatter;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeEntityToViewDataMapper;Lcom/yoti/mobile/android/yotisdkcore/core/view/localisation/LocalisedCountriesProvider;Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/view/ApplicantProfileAddressFormatter;Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/view/ApplicantProfileDateOfBirthFormatter;)V", "map", "from", "mapCompoundText", "Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$CompoundTextEntity;", "values", "Lcom/yoti/mobile/android/documentcapture/view/selection/ValidationAndGuidanceEntityToViewDataMapper$MapperParams$DynamicCopyValues;", "MapperParams", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ValidationAndGuidanceEntityToViewDataMapper implements Mapper<MapperParams, DocumentRequirementsViewData> {
    private final ApplicantProfileAddressFormatter applicantProfileAddressFormatter;
    private final ApplicantProfileDateOfBirthFormatter applicantProfileDateOfBirthFormatter;
    private final DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper;
    private final LocalisedCountriesProvider localisedCountriesProvider;

    @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/ValidationAndGuidanceEntityToViewDataMapper$MapperParams;", "", "validationAndGuidance", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity;", "dynamicCopyValues", "Lcom/yoti/mobile/android/documentcapture/view/selection/ValidationAndGuidanceEntityToViewDataMapper$MapperParams$DynamicCopyValues;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity;Lcom/yoti/mobile/android/documentcapture/view/selection/ValidationAndGuidanceEntityToViewDataMapper$MapperParams$DynamicCopyValues;)V", "getDynamicCopyValues", "()Lcom/yoti/mobile/android/documentcapture/view/selection/ValidationAndGuidanceEntityToViewDataMapper$MapperParams$DynamicCopyValues;", "getValidationAndGuidance", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DynamicCopyValues", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class MapperParams {
        private final DynamicCopyValues dynamicCopyValues;
        private final DocumentResourceConfigEntity.ValidationAndGuidanceEntity validationAndGuidance;

        @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/ValidationAndGuidanceEntityToViewDataMapper$MapperParams$DynamicCopyValues;", "", "countryIso3Code", "", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "applicantProfileEntity", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/ApplicantProfileEntity;", "(Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/ApplicantProfileEntity;)V", "getApplicantProfileEntity", "()Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/ApplicantProfileEntity;", "getCountryIso3Code", "()Ljava/lang/String;", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class DynamicCopyValues {
            private final ApplicantProfileEntity applicantProfileEntity;
            private final String countryIso3Code;
            private final DocumentResourceConfigEntity.DocumentTypeEntity documentType;

            public DynamicCopyValues(String countryIso3Code, DocumentResourceConfigEntity.DocumentTypeEntity documentType, ApplicantProfileEntity applicantProfileEntity) {
                Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
                Intrinsics.checkNotNullParameter(documentType, "documentType");
                this.countryIso3Code = countryIso3Code;
                this.documentType = documentType;
                this.applicantProfileEntity = applicantProfileEntity;
            }

            public static /* synthetic */ DynamicCopyValues copy$default(DynamicCopyValues dynamicCopyValues, String str, DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity, ApplicantProfileEntity applicantProfileEntity, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = dynamicCopyValues.countryIso3Code;
                }
                if ((i & 2) != 0) {
                    documentTypeEntity = dynamicCopyValues.documentType;
                }
                if ((i & 4) != 0) {
                    applicantProfileEntity = dynamicCopyValues.applicantProfileEntity;
                }
                return dynamicCopyValues.copy(str, documentTypeEntity, applicantProfileEntity);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getCountryIso3Code() {
                return this.countryIso3Code;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final DocumentResourceConfigEntity.DocumentTypeEntity getDocumentType() {
                return this.documentType;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final ApplicantProfileEntity getApplicantProfileEntity() {
                return this.applicantProfileEntity;
            }

            public final DynamicCopyValues copy(String countryIso3Code, DocumentResourceConfigEntity.DocumentTypeEntity documentType, ApplicantProfileEntity applicantProfileEntity) {
                Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
                Intrinsics.checkNotNullParameter(documentType, "documentType");
                return new DynamicCopyValues(countryIso3Code, documentType, applicantProfileEntity);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DynamicCopyValues)) {
                    return false;
                }
                DynamicCopyValues dynamicCopyValues = (DynamicCopyValues) other;
                return Intrinsics.areEqual(this.countryIso3Code, dynamicCopyValues.countryIso3Code) && this.documentType == dynamicCopyValues.documentType && Intrinsics.areEqual(this.applicantProfileEntity, dynamicCopyValues.applicantProfileEntity);
            }

            public final ApplicantProfileEntity getApplicantProfileEntity() {
                return this.applicantProfileEntity;
            }

            public final String getCountryIso3Code() {
                return this.countryIso3Code;
            }

            public final DocumentResourceConfigEntity.DocumentTypeEntity getDocumentType() {
                return this.documentType;
            }

            public int hashCode() {
                int iHashCode = ((this.countryIso3Code.hashCode() * 31) + this.documentType.hashCode()) * 31;
                ApplicantProfileEntity applicantProfileEntity = this.applicantProfileEntity;
                return iHashCode + (applicantProfileEntity == null ? 0 : applicantProfileEntity.hashCode());
            }

            public String toString() {
                return "DynamicCopyValues(countryIso3Code=" + this.countryIso3Code + ", documentType=" + this.documentType + ", applicantProfileEntity=" + this.applicantProfileEntity + ')';
            }
        }

        public MapperParams(DocumentResourceConfigEntity.ValidationAndGuidanceEntity validationAndGuidance, DynamicCopyValues dynamicCopyValues) {
            Intrinsics.checkNotNullParameter(validationAndGuidance, "validationAndGuidance");
            Intrinsics.checkNotNullParameter(dynamicCopyValues, "dynamicCopyValues");
            this.validationAndGuidance = validationAndGuidance;
            this.dynamicCopyValues = dynamicCopyValues;
        }

        public static /* synthetic */ MapperParams copy$default(MapperParams mapperParams, DocumentResourceConfigEntity.ValidationAndGuidanceEntity validationAndGuidanceEntity, DynamicCopyValues dynamicCopyValues, int i, Object obj) {
            if ((i & 1) != 0) {
                validationAndGuidanceEntity = mapperParams.validationAndGuidance;
            }
            if ((i & 2) != 0) {
                dynamicCopyValues = mapperParams.dynamicCopyValues;
            }
            return mapperParams.copy(validationAndGuidanceEntity, dynamicCopyValues);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentResourceConfigEntity.ValidationAndGuidanceEntity getValidationAndGuidance() {
            return this.validationAndGuidance;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final DynamicCopyValues getDynamicCopyValues() {
            return this.dynamicCopyValues;
        }

        public final MapperParams copy(DocumentResourceConfigEntity.ValidationAndGuidanceEntity validationAndGuidance, DynamicCopyValues dynamicCopyValues) {
            Intrinsics.checkNotNullParameter(validationAndGuidance, "validationAndGuidance");
            Intrinsics.checkNotNullParameter(dynamicCopyValues, "dynamicCopyValues");
            return new MapperParams(validationAndGuidance, dynamicCopyValues);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MapperParams)) {
                return false;
            }
            MapperParams mapperParams = (MapperParams) other;
            return Intrinsics.areEqual(this.validationAndGuidance, mapperParams.validationAndGuidance) && Intrinsics.areEqual(this.dynamicCopyValues, mapperParams.dynamicCopyValues);
        }

        public final DynamicCopyValues getDynamicCopyValues() {
            return this.dynamicCopyValues;
        }

        public final DocumentResourceConfigEntity.ValidationAndGuidanceEntity getValidationAndGuidance() {
            return this.validationAndGuidance;
        }

        public int hashCode() {
            return (this.validationAndGuidance.hashCode() * 31) + this.dynamicCopyValues.hashCode();
        }

        public String toString() {
            return "MapperParams(validationAndGuidance=" + this.validationAndGuidance + ", dynamicCopyValues=" + this.dynamicCopyValues + ')';
        }
    }

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DocumentResourceConfigEntity.ValidationAndGuidanceEntity.DynamicValueTypeEntity.values().length];
            iArr[DocumentResourceConfigEntity.ValidationAndGuidanceEntity.DynamicValueTypeEntity.DOCUMENT_NAME.ordinal()] = 1;
            iArr[DocumentResourceConfigEntity.ValidationAndGuidanceEntity.DynamicValueTypeEntity.COUNTRY_NAME.ordinal()] = 2;
            iArr[DocumentResourceConfigEntity.ValidationAndGuidanceEntity.DynamicValueTypeEntity.APPLICANT_FULL_NAME.ordinal()] = 3;
            iArr[DocumentResourceConfigEntity.ValidationAndGuidanceEntity.DynamicValueTypeEntity.APPLICANT_ADDRESS.ordinal()] = 4;
            iArr[DocumentResourceConfigEntity.ValidationAndGuidanceEntity.DynamicValueTypeEntity.APPLICANT_DATE_OF_BIRTH.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public ValidationAndGuidanceEntityToViewDataMapper(DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper, LocalisedCountriesProvider localisedCountriesProvider, ApplicantProfileAddressFormatter applicantProfileAddressFormatter, ApplicantProfileDateOfBirthFormatter applicantProfileDateOfBirthFormatter) {
        Intrinsics.checkNotNullParameter(documentTypeEntityToViewDataMapper, "documentTypeEntityToViewDataMapper");
        Intrinsics.checkNotNullParameter(localisedCountriesProvider, "localisedCountriesProvider");
        Intrinsics.checkNotNullParameter(applicantProfileAddressFormatter, "applicantProfileAddressFormatter");
        Intrinsics.checkNotNullParameter(applicantProfileDateOfBirthFormatter, "applicantProfileDateOfBirthFormatter");
        this.documentTypeEntityToViewDataMapper = documentTypeEntityToViewDataMapper;
        this.localisedCountriesProvider = localisedCountriesProvider;
        this.applicantProfileAddressFormatter = applicantProfileAddressFormatter;
        this.applicantProfileDateOfBirthFormatter = applicantProfileDateOfBirthFormatter;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource mapCompoundText(com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity.ValidationAndGuidanceEntity.CompoundTextEntity r12, com.yoti.mobile.android.documentcapture.view.selection.ValidationAndGuidanceEntityToViewDataMapper.MapperParams.DynamicCopyValues r13) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.view.selection.ValidationAndGuidanceEntityToViewDataMapper.mapCompoundText(com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity$ValidationAndGuidanceEntity$CompoundTextEntity, com.yoti.mobile.android.documentcapture.view.selection.ValidationAndGuidanceEntityToViewDataMapper$MapperParams$DynamicCopyValues):com.yoti.mobile.android.common.ui.widgets.CompoundTextResource");
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public DocumentRequirementsViewData map(MapperParams from) {
        Intrinsics.checkNotNullParameter(from, "from");
        CompoundTextResource compoundTextResourceMapCompoundText = mapCompoundText(from.getValidationAndGuidance().getValidationConfiguration().getTitle(), from.getDynamicCopyValues());
        if (compoundTextResourceMapCompoundText == null) {
            throw new IllegalArgumentException("Invalid title CompoundText".toString());
        }
        List<DocumentResourceConfigEntity.ValidationAndGuidanceEntity.EducationalItemEntity> items = from.getValidationAndGuidance().getValidationConfiguration().getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        Iterator<T> it2 = items.iterator();
        while (true) {
            CompoundTextResource compoundTextResourceMapCompoundText2 = null;
            if (!it2.hasNext()) {
                break;
            }
            DocumentResourceConfigEntity.ValidationAndGuidanceEntity.EducationalItemEntity educationalItemEntity = (DocumentResourceConfigEntity.ValidationAndGuidanceEntity.EducationalItemEntity) it2.next();
            int iconResId = educationalItemEntity.getIconResId();
            int titleResId = educationalItemEntity.getTitleResId();
            DocumentResourceConfigEntity.ValidationAndGuidanceEntity.CompoundTextEntity text = educationalItemEntity.getText();
            CompoundTextResource compoundTextResourceMapCompoundText3 = text != null ? mapCompoundText(text, from.getDynamicCopyValues()) : null;
            DocumentResourceConfigEntity.ValidationAndGuidanceEntity.CompoundTextEntity textSecondary = educationalItemEntity.getTextSecondary();
            if (textSecondary != null) {
                compoundTextResourceMapCompoundText2 = mapCompoundText(textSecondary, from.getDynamicCopyValues());
            }
            arrayList.add(new RequirementListItem(iconResId, titleResId, compoundTextResourceMapCompoundText3, compoundTextResourceMapCompoundText2));
        }
        int i = C4597R.string.android_yds_document_validation_start_scan;
        int i2 = C4597R.string.android_yds_document_validation_secondary_cta;
        CompoundTextResource compoundTextResourceMapCompoundText4 = mapCompoundText(from.getValidationAndGuidance().getGuidanceConfiguration().getTitle(), from.getDynamicCopyValues());
        if (compoundTextResourceMapCompoundText4 == null) {
            throw new IllegalArgumentException("Invalid title CompoundText".toString());
        }
        List<DocumentResourceConfigEntity.ValidationAndGuidanceEntity.EducationalItemEntity> items2 = from.getValidationAndGuidance().getGuidanceConfiguration().getItems();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items2, 10));
        for (DocumentResourceConfigEntity.ValidationAndGuidanceEntity.EducationalItemEntity educationalItemEntity2 : items2) {
            int iconResId2 = educationalItemEntity2.getIconResId();
            Integer numValueOf = Integer.valueOf(educationalItemEntity2.getTitleResId());
            DocumentResourceConfigEntity.ValidationAndGuidanceEntity.CompoundTextEntity text2 = educationalItemEntity2.getText();
            arrayList2.add(new GuidelinesItem(iconResId2, numValueOf, text2 != null ? mapCompoundText(text2, from.getDynamicCopyValues()) : null));
        }
        return new DocumentRequirementsViewData(compoundTextResourceMapCompoundText, arrayList, i, i2, new GuidelinesViewData(compoundTextResourceMapCompoundText4, (Integer) null, (List<GuidelinesItem>) arrayList2, from.getValidationAndGuidance().getGuidanceConfiguration().getLayoutType() == DocumentResourceConfigEntity.ValidationAndGuidanceEntity.EducationalConfigurationEntity.LayoutTypeEntity.LIST, true, C4597R.string.yds_common_got_it, C4597R.drawable.icon_tick_white, (AppBarConfig) null));
    }
}
