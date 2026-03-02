package com.yoti.mobile.android.yotisdkcore.applicant_profile.view;

import com.yoti.mobile.android.yotisdkcore.applicant_profile.domain.model.DateOfBirthEntity;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/view/ApplicantProfileDateOfBirthFormatter;", "", "()V", "format", "", "dateOfBirthEntity", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/DateOfBirthEntity;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ApplicantProfileDateOfBirthFormatter {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DateOfBirthEntity.DatePatternType.values().length];
            iArr[DateOfBirthEntity.DatePatternType.PATTERN_YYYY_MM_DD.ordinal()] = 1;
            iArr[DateOfBirthEntity.DatePatternType.PATTERN_YYYY_MM.ordinal()] = 2;
            iArr[DateOfBirthEntity.DatePatternType.PATTERN_YYYY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public ApplicantProfileDateOfBirthFormatter() {
    }

    public final String format(DateOfBirthEntity dateOfBirthEntity) {
        String str;
        Intrinsics.checkNotNullParameter(dateOfBirthEntity, "dateOfBirthEntity");
        int i = WhenMappings.$EnumSwitchMapping$0[dateOfBirthEntity.getPatternType().ordinal()];
        if (i == 1) {
            str = "dd/MM/yyyy";
        } else if (i == 2) {
            str = "MM/yyyy";
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = "yyyy";
        }
        String str2 = new SimpleDateFormat(str, Locale.getDefault()).format(dateOfBirthEntity.getDate());
        Intrinsics.checkNotNullExpressionValue(str2, "SimpleDateFormat(\n      …t(dateOfBirthEntity.date)");
        return str2;
    }
}
