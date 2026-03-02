package com.yoti.mobile.android.documentscan.domain.validator;

import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.f */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4740f {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[UKDrivingLicenceValidator.Issuer.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[UKDrivingLicenceValidator.Issuer.DVLA.ordinal()] = 1;
        iArr[UKDrivingLicenceValidator.Issuer.DVLNI.ordinal()] = 2;
        iArr[UKDrivingLicenceValidator.Issuer.DVA.ordinal()] = 3;
    }
}
