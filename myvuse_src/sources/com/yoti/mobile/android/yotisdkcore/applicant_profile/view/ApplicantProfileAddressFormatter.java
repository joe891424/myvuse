package com.yoti.mobile.android.yotisdkcore.applicant_profile.view;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.domain.model.AddressFormatEntity;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.domain.model.StructuredPostalAddressEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004J \u0010\t\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000b2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0014\u0010\f\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0014\u0010\r\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0014\u0010\u000e\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0014\u0010\u000f\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0014\u0010\u0010\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u0004*\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/view/ApplicantProfileAddressFormatter;", "", "()V", "format", "", "addressEntity", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/StructuredPostalAddressEntity;", "lineSeparator", "fieldSeparator", "joinFields", "fields", "", "formatLine1", "formatLine2", "formatLine3", "formatLine4", "formatLine5", "stripDuplicateOrEmptyAddressField", "field", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ApplicantProfileAddressFormatter {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.applicant_profile.view.ApplicantProfileAddressFormatter$a */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m5598d2 = {"<anonymous>", "", "it", "", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    static final class C4961a extends Lambda implements Function1<String, CharSequence> {

        /* JADX INFO: renamed from: a */
        public static final C4961a f7568a = new C4961a();

        C4961a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(String it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            return it2;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.applicant_profile.view.ApplicantProfileAddressFormatter$b */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, m5598d2 = {"<anonymous>", "", "it", "", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    static final class C4962b extends Lambda implements Function1<String, CharSequence> {

        /* JADX INFO: renamed from: a */
        public static final C4962b f7569a = new C4962b();

        C4962b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(String str) {
            Intrinsics.checkNotNull(str);
            return str;
        }
    }

    @Inject
    public ApplicantProfileAddressFormatter() {
    }

    public static /* synthetic */ String format$default(ApplicantProfileAddressFormatter applicantProfileAddressFormatter, StructuredPostalAddressEntity structuredPostalAddressEntity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
        }
        if ((i & 4) != 0) {
            str2 = ", ";
        }
        return applicantProfileAddressFormatter.format(structuredPostalAddressEntity, str, str2);
    }

    private final String formatLine1(StructuredPostalAddressEntity structuredPostalAddressEntity, String str) {
        return joinFields(CollectionsKt.listOf((Object[]) new String[]{stripDuplicateOrEmptyAddressField(structuredPostalAddressEntity, structuredPostalAddressEntity.getSubBuilding()), stripDuplicateOrEmptyAddressField(structuredPostalAddressEntity, structuredPostalAddressEntity.getBuilding()), structuredPostalAddressEntity.getAddressLine1()}), str);
    }

    private final String formatLine2(StructuredPostalAddressEntity structuredPostalAddressEntity, String str) {
        return joinFields(CollectionsKt.listOf((Object[]) new String[]{stripDuplicateOrEmptyAddressField(structuredPostalAddressEntity, structuredPostalAddressEntity.getBuildingNumber()), stripDuplicateOrEmptyAddressField(structuredPostalAddressEntity, structuredPostalAddressEntity.getStreet()), structuredPostalAddressEntity.getAddressLine2()}), str);
    }

    private final String formatLine3(StructuredPostalAddressEntity structuredPostalAddressEntity, String str) {
        return joinFields(CollectionsKt.listOf((Object[]) new String[]{structuredPostalAddressEntity.getTownCity(), structuredPostalAddressEntity.getState(), structuredPostalAddressEntity.getAddressLine3()}), str);
    }

    private final String formatLine4(StructuredPostalAddressEntity structuredPostalAddressEntity, String str) {
        return joinFields(CollectionsKt.listOf((Object[]) new String[]{structuredPostalAddressEntity.getPostalCode(), structuredPostalAddressEntity.getAddressLine4()}), str);
    }

    private final String formatLine5(StructuredPostalAddressEntity structuredPostalAddressEntity, String str) {
        return joinFields(CollectionsKt.listOf((Object[]) new String[]{structuredPostalAddressEntity.getCountry(), structuredPostalAddressEntity.getAddressLine5()}), str);
    }

    private final String joinFields(List<String> fields, String fieldSeparator) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : fields) {
            String str = (String) obj;
            if (!(str == null || StringsKt.isBlank(str))) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, fieldSeparator, null, null, 0, null, C4962b.f7569a, 30, null);
    }

    private final String stripDuplicateOrEmptyAddressField(StructuredPostalAddressEntity structuredPostalAddressEntity, String str) {
        if (str != null && !StringsKt.isBlank(str)) {
            List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{structuredPostalAddressEntity.getAddressLine1(), structuredPostalAddressEntity.getAddressLine2(), structuredPostalAddressEntity.getAddressLine3(), structuredPostalAddressEntity.getAddressLine4(), structuredPostalAddressEntity.getAddressLine5()});
            if ((listListOf instanceof Collection) && listListOf.isEmpty()) {
                return str;
            }
            for (String str2 : listListOf) {
                if (str2 != null ? StringsKt.contains$default((CharSequence) str2, (CharSequence) str, false, 2, (Object) null) : false) {
                }
            }
            return str;
        }
        return null;
    }

    public final String format(StructuredPostalAddressEntity addressEntity, String lineSeparator, String fieldSeparator) {
        Intrinsics.checkNotNullParameter(addressEntity, "addressEntity");
        Intrinsics.checkNotNullParameter(lineSeparator, "lineSeparator");
        Intrinsics.checkNotNullParameter(fieldSeparator, "fieldSeparator");
        if (addressEntity.getAddressFormat() == AddressFormatEntity.FORMAT_2) {
            return addressEntity.getFormattedAddress();
        }
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{formatLine1(addressEntity, fieldSeparator), formatLine2(addressEntity, fieldSeparator), formatLine3(addressEntity, fieldSeparator), formatLine4(addressEntity, fieldSeparator), formatLine5(addressEntity, fieldSeparator)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, lineSeparator, null, null, 0, null, C4961a.f7568a, 30, null);
    }
}
