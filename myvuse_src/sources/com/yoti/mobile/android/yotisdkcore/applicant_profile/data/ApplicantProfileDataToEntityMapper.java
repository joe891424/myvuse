package com.yoti.mobile.android.yotisdkcore.applicant_profile.data;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.model.AddressFormat;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.model.ApplicantProfile;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.model.StructuredPostalAddress;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.domain.model.AddressFormatEntity;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.domain.model.ApplicantProfileEntity;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.domain.model.DateOfBirthEntity;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.domain.model.StructuredPostalAddressEntity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\fH\u0002¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/ApplicantProfileDataToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/ApplicantProfile;", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/ApplicantProfileEntity;", "()V", "map", "from", "mapAddressFormat", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/AddressFormatEntity;", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/AddressFormat;", "mapStructuredPostalAddress", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/StructuredPostalAddressEntity;", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/StructuredPostalAddress;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ApplicantProfileDataToEntityMapper implements Mapper<ApplicantProfile, ApplicantProfileEntity> {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AddressFormat.values().length];
            iArr[AddressFormat.FORMAT_1.ordinal()] = 1;
            iArr[AddressFormat.FORMAT_2.ordinal()] = 2;
            iArr[AddressFormat.FORMAT_3.ordinal()] = 3;
            iArr[AddressFormat.FORMAT_4.ordinal()] = 4;
            iArr[AddressFormat.UNKNOWN.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public ApplicantProfileDataToEntityMapper() {
    }

    private final AddressFormatEntity mapAddressFormat(AddressFormat from) {
        int i = WhenMappings.$EnumSwitchMapping$0[from.ordinal()];
        if (i == 1) {
            return AddressFormatEntity.FORMAT_1;
        }
        if (i == 2) {
            return AddressFormatEntity.FORMAT_2;
        }
        if (i == 3) {
            return AddressFormatEntity.FORMAT_3;
        }
        if (i == 4) {
            return AddressFormatEntity.FORMAT_4;
        }
        if (i == 5) {
            return AddressFormatEntity.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final StructuredPostalAddressEntity mapStructuredPostalAddress(StructuredPostalAddress from) {
        return new StructuredPostalAddressEntity(mapAddressFormat(from.getAddressFormat()), from.getSubBuilding(), from.getBuildingNumber(), from.getBuilding(), from.getStreet(), from.getAddressLine1(), from.getAddressLine2(), from.getAddressLine3(), from.getAddressLine4(), from.getAddressLine5(), from.getTownCity(), from.getState(), from.getPostalCode(), from.getCountry(), from.getFormattedAddress());
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public ApplicantProfileEntity map(ApplicantProfile from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return new ApplicantProfileEntity(from.getFullName(), new DateOfBirthEntity(from.getDateOfBirth()), mapStructuredPostalAddress(from.getStructuredPostalAddress()));
    }
}
