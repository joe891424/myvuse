package com.yoti.mobile.android.documentcapture.p055id.data;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.DocumentFields;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.GenderType;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.Mrz;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.MrzType;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.OcrResult;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.OcrResultType;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.AddressEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.DocumentFieldsEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.GenderTypeEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.HolderEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.OcrOriginEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.OcrResultEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.OcrResultTypeEntity;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/OcrResultEntityToDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/OcrResultEntity;", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/OcrResult;", "addressEntityToDataMapper", "Lcom/yoti/mobile/android/documentcapture/id/data/AddressEntityToDataMapper;", "documentTypeEntityToDataMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeEntityToDataMapper;", "(Lcom/yoti/mobile/android/documentcapture/id/data/AddressEntityToDataMapper;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeEntityToDataMapper;)V", "map", "from", "mapDocumentFieldsEntityToDocumentFields", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/DocumentFields;", "documentFieldsEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/DocumentFieldsEntity;", "ocrOriginEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/OcrOriginEntity;", "mapGenderTypeEntityToGenderType", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/GenderType;", "genderTypeEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/GenderTypeEntity;", "mapOcrResultTypeEntityToOcrResultType", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/OcrResultType;", "ocrResultTypeEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/OcrResultTypeEntity;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class OcrResultEntityToDataMapper implements Mapper<OcrResultEntity, OcrResult> {
    private final AddressEntityToDataMapper addressEntityToDataMapper;
    private final DocumentTypeEntityToDataMapper documentTypeEntityToDataMapper;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[OcrResultTypeEntity.values().length];
            iArr[OcrResultTypeEntity.NOT_ATTEMPTED.ordinal()] = 1;
            iArr[OcrResultTypeEntity.SUCCESS.ordinal()] = 2;
            iArr[OcrResultTypeEntity.FAILURE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[GenderTypeEntity.values().length];
            iArr2[GenderTypeEntity.MALE.ordinal()] = 1;
            iArr2[GenderTypeEntity.FEMALE.ordinal()] = 2;
            iArr2[GenderTypeEntity.TRANSGENDER.ordinal()] = 3;
            iArr2[GenderTypeEntity.OTHER.ordinal()] = 4;
            iArr2[GenderTypeEntity.UNSPECIFIED.ordinal()] = 5;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Inject
    public OcrResultEntityToDataMapper(AddressEntityToDataMapper addressEntityToDataMapper, DocumentTypeEntityToDataMapper documentTypeEntityToDataMapper) {
        Intrinsics.checkNotNullParameter(addressEntityToDataMapper, "addressEntityToDataMapper");
        Intrinsics.checkNotNullParameter(documentTypeEntityToDataMapper, "documentTypeEntityToDataMapper");
        this.addressEntityToDataMapper = addressEntityToDataMapper;
        this.documentTypeEntityToDataMapper = documentTypeEntityToDataMapper;
    }

    private final DocumentFields mapDocumentFieldsEntityToDocumentFields(DocumentFieldsEntity documentFieldsEntity, OcrOriginEntity ocrOriginEntity) {
        DocumentFields documentFields = new DocumentFields(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
        documentFields.setIssuingDate(documentFieldsEntity.getIssueDate());
        documentFields.setExpirationDate(documentFieldsEntity.getExpiryDate());
        documentFields.setIssuingAuthority(documentFieldsEntity.getIssuingAuthority());
        documentFields.setDocumentNumber(documentFieldsEntity.getDocumentNumber());
        documentFields.setIssuingCountryIso3Code(documentFieldsEntity.getIssuingCountryIso3Code());
        documentFields.setDocumentType(this.documentTypeEntityToDataMapper.map(ocrOriginEntity.getDocumentTypeEntity()));
        String mrz = documentFieldsEntity.getMrz();
        Mrz mrz2 = null;
        if (mrz != null) {
            List listSplit$default = StringsKt.split$default((CharSequence) mrz, new String[]{ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listSplit$default) {
                String str = (String) obj;
                if (str != null && str.length() != 0) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            if (size == 2) {
                mrz2 = new Mrz(MrzType.TD3, (String) arrayList.get(0), (String) arrayList.get(1), null, 8, null);
            } else if (size == 3) {
                mrz2 = new Mrz(MrzType.TD1, (String) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2));
            }
        }
        documentFields.setMrz(mrz2);
        AddressEntity address = documentFieldsEntity.getAddress();
        if (address != null) {
            documentFields.setAddress(this.addressEntityToDataMapper.map(address));
        }
        HolderEntity holder = documentFieldsEntity.getHolder();
        if (holder != null) {
            documentFields.setNamePrefix(holder.getPrefix());
            documentFields.setFirstName(holder.getFirstName());
            documentFields.setGivenNames(holder.getGivenNames());
            documentFields.setMiddleName(holder.getMiddleNames());
            documentFields.setFamilyName(holder.getFamilyName());
            documentFields.setNameSuffix(holder.getSuffix());
            documentFields.setFullName(holder.getFullName());
            documentFields.setBirthDate(holder.getDateOfBirth());
            documentFields.setBirthPlace(holder.getPlaceOfBirth());
            documentFields.setGender(mapGenderTypeEntityToGenderType(holder.getGender()));
            documentFields.setNationality(holder.getNationalityIso3Code());
        }
        HolderEntity holderAlias = documentFieldsEntity.getHolderAlias();
        if (holderAlias != null) {
            documentFields.setFirstNameAlias(holderAlias.getFirstName());
            documentFields.setMiddleNameAlias(holderAlias.getMiddleNames());
            documentFields.setFamilyNameAlias(holderAlias.getFamilyName());
        }
        return documentFields;
    }

    private final GenderType mapGenderTypeEntityToGenderType(GenderTypeEntity genderTypeEntity) {
        int i = genderTypeEntity == null ? -1 : WhenMappings.$EnumSwitchMapping$1[genderTypeEntity.ordinal()];
        if (i != -1) {
            if (i == 1) {
                return GenderType.MALE;
            }
            if (i == 2) {
                return GenderType.FEMALE;
            }
            if (i == 3) {
                return GenderType.TRANSGENDER;
            }
            if (i == 4) {
                return GenderType.OTHER;
            }
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return null;
    }

    private final OcrResultType mapOcrResultTypeEntityToOcrResultType(OcrResultTypeEntity ocrResultTypeEntity) {
        int i = WhenMappings.$EnumSwitchMapping$0[ocrResultTypeEntity.ordinal()];
        if (i == 1) {
            return OcrResultType.NOT_ATTEMPTED;
        }
        if (i == 2) {
            return OcrResultType.SUCCESS;
        }
        if (i == 3) {
            return OcrResultType.FAILURE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public OcrResult map(OcrResultEntity from) {
        Intrinsics.checkNotNullParameter(from, "from");
        OcrResultType ocrResultTypeMapOcrResultTypeEntityToOcrResultType = mapOcrResultTypeEntityToOcrResultType(from.getResult());
        DocumentFieldsEntity documentFields = from.getDocumentFields();
        return new OcrResult(ocrResultTypeMapOcrResultTypeEntityToOcrResultType, documentFields != null ? mapDocumentFieldsEntityToDocumentFields(documentFields, from.getOrigin()) : null);
    }
}
