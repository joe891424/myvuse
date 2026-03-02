package com.yoti.mobile.android.documentscan.domain.validator;

import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;
import java.io.IOException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.m */
/* JADX INFO: loaded from: classes5.dex */
final class C4747m extends Lambda implements Function0<C4756v> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ UKDrivingLicenceValidator f6967a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4747m(UKDrivingLicenceValidator uKDrivingLicenceValidator) {
        super(0);
        this.f6967a = uKDrivingLicenceValidator;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final C4756v invoke() throws IOException {
        String strM4881b = this.f6967a.f6949a.m4881b();
        StringBuilder sb = new StringBuilder();
        int length = strM4881b.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = strM4881b.charAt(i);
            if (!Character.isLetterOrDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "filterTo(StringBuilder(), predicate).toString()");
        return new C4756v(StringsKt.isBlank(string), UKDrivingLicenceValidator.UKDrivingLicenceValidationResult.NonASCIIAlphaNumericCharactersPresent);
    }
}
