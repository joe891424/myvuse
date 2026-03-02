package com.yoti.mobile.android.yotisdkcore.validity_checks.data;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.p082c.domain.model.RequirementsEntity;
import com.yoti.mobile.android.yotisdkcore.validity_checks.data.model.DocumentSchemeValidityCheck;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.data.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/DocumentSchemeValidityCheckDataToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck;", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/model/RequirementsEntity;", "()V", "map", "from", "mapConstrainType", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/model/RequirementsEntity$DateRequirementEntity$ConstraintTypeEntity;", "constraint", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck$DateRequirement$ConstraintType;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentSchemeValidityCheckDataToEntityMapper implements Mapper<DocumentSchemeValidityCheck, RequirementsEntity> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.data.b$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f7881a;

        static {
            int[] iArr = new int[DocumentSchemeValidityCheck.a.EnumC6029a.values().length];
            iArr[DocumentSchemeValidityCheck.a.EnumC6029a.WITHIN_X_MONTHS_OF_BIRTH.ordinal()] = 1;
            iArr[DocumentSchemeValidityCheck.a.EnumC6029a.WITHIN_X_MONTHS.ordinal()] = 2;
            iArr[DocumentSchemeValidityCheck.a.EnumC6029a.UNKNOWN.ordinal()] = 3;
            f7881a = iArr;
        }
    }

    @Inject
    public DocumentSchemeValidityCheckDataToEntityMapper() {
    }

    /* JADX INFO: renamed from: a */
    private final RequirementsEntity.a.EnumC6025a m5350a(DocumentSchemeValidityCheck.a.EnumC6029a enumC6029a) {
        int i = a.f7881a[enumC6029a.ordinal()];
        if (i == 1) {
            return RequirementsEntity.a.EnumC6025a.WITHIN_X_MONTHS_OF_BIRTH;
        }
        if (i == 2) {
            return RequirementsEntity.a.EnumC6025a.WITHIN_X_MONTHS;
        }
        if (i == 3) {
            return RequirementsEntity.a.EnumC6025a.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RequirementsEntity map(DocumentSchemeValidityCheck from) {
        RequirementsEntity.a aVar;
        Intrinsics.checkNotNullParameter(from, "from");
        DocumentSchemeValidityCheck.a f7890a = from.getF7886a().getF7890a();
        RequirementsEntity.a aVar2 = null;
        if (f7890a != null) {
            aVar = new RequirementsEntity.a(m5350a(f7890a.m5353a()), f7890a.getF7888b());
        } else {
            aVar = null;
        }
        DocumentSchemeValidityCheck.a f7891b = from.getF7886a().getF7891b();
        if (f7891b != null) {
            aVar2 = new RequirementsEntity.a(m5350a(f7891b.m5353a()), f7891b.getF7888b());
        }
        return new RequirementsEntity(aVar, aVar2);
    }
}
