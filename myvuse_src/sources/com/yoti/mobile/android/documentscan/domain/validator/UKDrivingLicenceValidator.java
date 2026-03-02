package com.yoti.mobile.android.documentscan.domain.validator;

import com.yoti.mobile.android.commons.util.C4588L;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bH\u0002J\u0012\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bH\u0002J\u0012\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bH\u0002J\u0012\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bH\u0002J\u0018\u0010\f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b0\rH\u0002J\u0018\u0010\u000e\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b0\rH\u0002J\u0012\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bH\u0002J\u0012\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bH\u0002J\u0012\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bH\u0002J\u0012\u0010\u0012\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bH\u0002J\u0012\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bH\u0002J\u0012\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bH\u0002J\u0012\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bH\u0002J\u0012\u0010\u0016\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bH\u0002J\u0012\u0010\u0017\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bH\u0002J\u0006\u0010\u0018\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/domain/validator/UKDrivingLicenceValidator;", "", "UKDrivingLicence", "Lcom/yoti/mobile/android/documentscan/domain/validator/UKDrivingLicence;", "(Lcom/yoti/mobile/android/documentscan/domain/validator/UKDrivingLicence;)V", "matchingDayOfBirth", "Lkotlin/Function0;", "Lcom/yoti/mobile/android/documentscan/domain/validator/ValidationResult;", "Lcom/yoti/mobile/android/documentscan/domain/validator/Validation;", "matchingMonthOfBirth", "matchingSurname", "matchingYearOfBirth", "prepareValidationForDVA", "", "prepareValidationForDVLA", "validDVACharacters", "validDVALength", "validDVLACharacters", "validDVLALength", "validDayOfBirth", "validInitials", "validMonthOfBirth", "validSurname", "validYearOfBirth", "validate", "Issuer", "UKDrivingLicenceValidationResult", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class UKDrivingLicenceValidator {

    /* JADX INFO: renamed from: a */
    private final C4738d f6949a;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/domain/validator/UKDrivingLicenceValidator$Issuer;", "", "issuerName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "DVLA", "DVLNI", "DVA", "IOM_DOT", "IOM_MOT", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
    public enum Issuer {
        DVLA("DVLA"),
        DVLNI("DVLNI"),
        DVA("DVA"),
        IOM_DOT("IOM DOT"),
        IOM_MOT("IOM MOT");

        Issuer(String str) {
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/domain/validator/UKDrivingLicenceValidator$UKDrivingLicenceValidationResult;", "", "(Ljava/lang/String;I)V", "MismatchedSurname", "MismatchedYearOfBirth", "MismatchedMonthOfBirth", "MismatchedDayOfBirth", "MismatchedInitials", "InvalidSurname", "InvalidYearOfBirth", "InvalidMonthOfBirth", "InvalidDayOfBirth", "InvalidLength", "AlphaCharactersPresent", "NonASCIIAlphaNumericCharactersPresent", "ValidDrivingLicence", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
    public enum UKDrivingLicenceValidationResult {
        MismatchedSurname,
        MismatchedYearOfBirth,
        MismatchedMonthOfBirth,
        MismatchedDayOfBirth,
        MismatchedInitials,
        InvalidSurname,
        InvalidYearOfBirth,
        InvalidMonthOfBirth,
        InvalidDayOfBirth,
        InvalidLength,
        AlphaCharactersPresent,
        NonASCIIAlphaNumericCharactersPresent,
        ValidDrivingLicence
    }

    public UKDrivingLicenceValidator(C4738d UKDrivingLicence) {
        Intrinsics.checkParameterIsNotNull(UKDrivingLicence, "UKDrivingLicence");
        this.f6949a = UKDrivingLicence;
    }

    /* JADX INFO: renamed from: b */
    private final Function0<C4756v> m4858b() {
        return new C4741g(this);
    }

    /* JADX INFO: renamed from: c */
    private final Function0<C4756v> m4859c() {
        return new C4742h(this);
    }

    /* JADX INFO: renamed from: d */
    private final Function0<C4756v> m4860d() {
        return new C4743i(this);
    }

    /* JADX INFO: renamed from: e */
    private final Function0<C4756v> m4861e() {
        return new C4744j(this);
    }

    /* JADX INFO: renamed from: f */
    private final List<Function0<C4756v>> m4862f() {
        return CollectionsKt.listOf((Object[]) new Function0[]{m4865i(), m4864h()});
    }

    /* JADX INFO: renamed from: g */
    private final List<Function0<C4756v>> m4863g() {
        return CollectionsKt.listOf((Object[]) new Function0[]{m4867k(), m4866j(), m4871o(), m4860d(), m4872p(), m4861e(), m4870n(), m4859c(), m4868l(), m4858b(), m4869m()});
    }

    /* JADX INFO: renamed from: h */
    private final Function0<C4756v> m4864h() {
        return new C4745k(this);
    }

    /* JADX INFO: renamed from: i */
    private final Function0<C4756v> m4865i() {
        return new C4746l(this);
    }

    /* JADX INFO: renamed from: j */
    private final Function0<C4756v> m4866j() {
        return new C4747m(this);
    }

    /* JADX INFO: renamed from: k */
    private final Function0<C4756v> m4867k() {
        return new C4748n(this);
    }

    /* JADX INFO: renamed from: l */
    private final Function0<C4756v> m4868l() {
        return new C4749o(this);
    }

    /* JADX INFO: renamed from: m */
    private final Function0<C4756v> m4869m() {
        return new C4750p(this);
    }

    /* JADX INFO: renamed from: n */
    private final Function0<C4756v> m4870n() {
        return new C4751q(this);
    }

    /* JADX INFO: renamed from: o */
    private final Function0<C4756v> m4871o() {
        return new C4752r(this);
    }

    /* JADX INFO: renamed from: p */
    private final Function0<C4756v> m4872p() {
        return new C4753s(this);
    }

    /* JADX INFO: renamed from: a */
    public final C4756v m4873a() {
        Object next;
        C4756v c4756v;
        int i = C4740f.$EnumSwitchMapping$0[this.f6949a.m4885f().ordinal()];
        Iterator<T> it2 = (i != 1 ? (i == 2 || i == 3) ? m4862f() : CollectionsKt.emptyList() : m4863g()).iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (!((C4756v) ((Function0) next).invoke()).m4892a()) {
                break;
            }
        }
        Function0 function0 = (Function0) next;
        if (function0 == null || (c4756v = (C4756v) function0.invoke()) == null) {
            c4756v = new C4756v(true, UKDrivingLicenceValidationResult.ValidDrivingLicence);
        }
        C4588L.logDebug("LicenceValidator", "Validation result - " + c4756v);
        return c4756v;
    }
}
