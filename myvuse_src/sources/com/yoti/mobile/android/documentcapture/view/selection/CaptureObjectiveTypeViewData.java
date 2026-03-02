package com.yoti.mobile.android.documentcapture.view.selection;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.commonui.UiSessionConfiguration;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutFragmentArgs;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutFragmentContent;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutItem;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'PROOF_OF_IDENTITY' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J#\u0010\n\u001a\u00020\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "", "Landroid/os/Parcelable;", "headerResId", "", "moreAboutResConfig", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentContent;", "(Ljava/lang/String;IILcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentContent;)V", "getHeaderResId", "()I", "configureUi", "logo", "showIdentityCheck", "", "(Ljava/lang/Integer;Z)Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentContent;", "describeContents", "getEducationalRequirements", "", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "getMoreAboutFragmentArgs", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentArgs;", "uiSessionConfig", "Lcom/yoti/mobile/android/commonui/UiSessionConfiguration;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "PROOF_OF_IDENTITY", "PROOF_OF_ADDRESS", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class CaptureObjectiveTypeViewData implements Parcelable {
    private static final /* synthetic */ CaptureObjectiveTypeViewData[] $VALUES = $values();
    public static final Parcelable.Creator<CaptureObjectiveTypeViewData> CREATOR = new Parcelable.Creator<CaptureObjectiveTypeViewData>() { // from class: com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeViewData.Creator
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CaptureObjectiveTypeViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return CaptureObjectiveTypeViewData.valueOf(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CaptureObjectiveTypeViewData[] newArray(int i) {
            return new CaptureObjectiveTypeViewData[i];
        }
    };
    public static final CaptureObjectiveTypeViewData PROOF_OF_ADDRESS;
    public static final CaptureObjectiveTypeViewData PROOF_OF_IDENTITY;
    private final int headerResId;
    private final MoreAboutFragmentContent moreAboutResConfig;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DocumentTypeViewData.values().length];
            iArr[DocumentTypeViewData.COUNCIL_TAX_BILL.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CaptureObjectiveTypeViewData.values().length];
            iArr2[CaptureObjectiveTypeViewData.PROOF_OF_ADDRESS.ordinal()] = 1;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private static final /* synthetic */ CaptureObjectiveTypeViewData[] $values() {
        return new CaptureObjectiveTypeViewData[]{PROOF_OF_IDENTITY, PROOF_OF_ADDRESS};
    }

    static {
        int i = 56;
        DefaultConstructorMarker defaultConstructorMarker = null;
        NavigationIcon navigationIcon = null;
        PROOF_OF_IDENTITY = new CaptureObjectiveTypeViewData("PROOF_OF_IDENTITY", 0, C4597R.string.yds_non_id_document_objective_prove_your_identity, new MoreAboutFragmentContent(new MoreAboutItem.MoreAboutTitleItem(C4597R.string.yds_verification_info_header), CollectionsKt.listOf(new MoreAboutItem.MoreAboutDescItem(C4597R.string.yds_document_verification_info_description)), CollectionsKt.listOf((Object[]) new MoreAboutItem.MoreAboutAccordionItem[]{new MoreAboutItem.MoreAboutAccordionItem(C4597R.string.yds_document_verification_info_add_photo_header, C4597R.string.yds_document_verification_info_add_photo_description), new MoreAboutItem.MoreAboutAccordionItem(C4597R.string.yds_document_verification_info_privacy_header, C4597R.string.yds_document_verification_info_privacy_description), new MoreAboutItem.MoreAboutAccordionItem(C4597R.string.yds_document_verification_info_epassport_header, C4597R.string.yds_document_verification_info_epassport_description), new MoreAboutItem.MoreAboutAccordionItem(C4597R.string.yds_verification_info_yoti_header, C4597R.string.yds_document_verification_info_yoti_description), new MoreAboutItem.MoreAboutAccordionItem(C4597R.string.yds_verification_info_security_header, C4597R.string.yds_verification_info_security_description)}), null, 0, navigationIcon, i, defaultConstructorMarker));
        PROOF_OF_ADDRESS = new CaptureObjectiveTypeViewData("PROOF_OF_ADDRESS", 1, C4597R.string.yds_non_id_document_objective_prove_your_address, new MoreAboutFragmentContent(new MoreAboutItem.MoreAboutTitleItem(C4597R.string.yds_verification_info_header), CollectionsKt.listOf(new MoreAboutItem.MoreAboutDescItem(C4597R.string.yds_non_id_document_verification_info_description)), CollectionsKt.listOf((Object[]) new MoreAboutItem.MoreAboutAccordionItem[]{new MoreAboutItem.MoreAboutAccordionItem(C4597R.string.yds_non_id_document_verification_info_add_photo_header, C4597R.string.yds_non_id_document_verification_info_add_photo_description), new MoreAboutItem.MoreAboutAccordionItem(C4597R.string.yds_non_id_document_verification_info_requirements_header, C4597R.string.yds_non_id_document_verification_info_requirements_description), new MoreAboutItem.MoreAboutAccordionItem(C4597R.string.yds_non_id_document_verification_info_privacy_header, C4597R.string.yds_non_id_document_verification_info_privacy_description), new MoreAboutItem.MoreAboutAccordionItem(C4597R.string.yds_verification_info_yoti_header, C4597R.string.yds_non_id_document_verification_info_yoti_description), new MoreAboutItem.MoreAboutAccordionItem(C4597R.string.yds_verification_info_security_header, C4597R.string.yds_verification_info_security_description)}), null, 0, navigationIcon, i, defaultConstructorMarker));
    }

    private CaptureObjectiveTypeViewData(String str, int i, int i2, MoreAboutFragmentContent moreAboutFragmentContent) {
        this.headerResId = i2;
        this.moreAboutResConfig = moreAboutFragmentContent;
    }

    private final MoreAboutFragmentContent configureUi(Integer logo, boolean showIdentityCheck) {
        MoreAboutFragmentContent moreAboutFragmentContent = this.moreAboutResConfig;
        return MoreAboutFragmentContent.copy$default(moreAboutFragmentContent, null, null, CollectionsKt.plus((Collection) moreAboutFragmentContent.getAccordionItems(), (Iterable) (showIdentityCheck ? CollectionsKt.listOf((Object[]) new MoreAboutItem.MoreAboutAccordionItem[]{new MoreAboutItem.MoreAboutAccordionItem(C4597R.string.yds_verification_info_your_details_header, C4597R.string.yds_verification_info_your_details_description), new MoreAboutItem.MoreAboutAccordionItem(C4597R.string.yds_verification_info_who_verifies_your_identity_header, C4597R.string.yds_verification_info_who_verifies_your_identity_description)}) : CollectionsKt.emptyList())), logo != null ? new MoreAboutItem.MoreAboutLogoItem(logo.intValue()) : null, 0, null, 51, null);
    }

    static /* synthetic */ MoreAboutFragmentContent configureUi$default(CaptureObjectiveTypeViewData captureObjectiveTypeViewData, Integer num, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: configureUi");
        }
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return captureObjectiveTypeViewData.configureUi(num, z);
    }

    public static CaptureObjectiveTypeViewData valueOf(String str) {
        return (CaptureObjectiveTypeViewData) Enum.valueOf(CaptureObjectiveTypeViewData.class, str);
    }

    public static CaptureObjectiveTypeViewData[] values() {
        return (CaptureObjectiveTypeViewData[]) $VALUES.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final List<Integer> getEducationalRequirements(DocumentTypeViewData documentType) {
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        if (WhenMappings.$EnumSwitchMapping$1[ordinal()] == 1) {
            return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(C4597R.string.yds_non_id_document_education_document_name_requirement), Integer.valueOf(C4597R.string.yds_non_id_document_education_document_address_requirement), Integer.valueOf(C4597R.string.yds_non_id_document_education_document_company_requirement), Integer.valueOf(WhenMappings.$EnumSwitchMapping$0[documentType.ordinal()] == 1 ? C4597R.string.f6638x69856a64 : C4597R.string.yds_non_id_document_education_document_date_requirement)});
        }
        return null;
    }

    public final int getHeaderResId() {
        return this.headerResId;
    }

    public final MoreAboutFragmentArgs getMoreAboutFragmentArgs(UiSessionConfiguration uiSessionConfig) {
        Intrinsics.checkNotNullParameter(uiSessionConfig, "uiSessionConfig");
        return new MoreAboutFragmentArgs(configureUi(uiSessionConfig.getLogo(), uiSessionConfig.getShowIdentityCheck()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(name());
    }
}
