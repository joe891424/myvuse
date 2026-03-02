package com.yoti.mobile.android.yotisdkcore.core.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.commonui.UiSessionConfiguration;
import com.yoti.mobile.android.remote.model.Session;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0097\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0002\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003Jc\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\"HÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"HÖ\u0001R\u0014\u0010\u000e\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0010R\u0014\u0010\n\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0010R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0014\u0010\u000b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0010R\u0014\u0010\r\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006-"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "uiSessionConfiguration", "Lcom/yoti/mobile/android/commonui/UiSessionConfiguration;", "session", "Lcom/yoti/mobile/android/remote/model/Session;", "requirementId", "", "isSingleStepFlow", "", "isSelectableDocumentFlow", "isSupplementaryDocumentUploadAllowed", "isMoreAboutVerificationEnabled", "isValidationAndGuidanceEnabled", "isDoNotHaveDocumentOptionEnabled", "(Lcom/yoti/mobile/android/commonui/UiSessionConfiguration;Lcom/yoti/mobile/android/remote/model/Session;Ljava/lang/String;ZZZZZZ)V", "()Z", "getRequirementId", "()Ljava/lang/String;", "getSession", "()Lcom/yoti/mobile/android/remote/model/Session;", "getUiSessionConfiguration", "()Lcom/yoti/mobile/android/commonui/UiSessionConfiguration;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public /* data */ class DocumentCaptureConfiguration implements IFeatureConfiguration {
    public static final Parcelable.Creator<DocumentCaptureConfiguration> CREATOR = new Creator();
    private final boolean isDoNotHaveDocumentOptionEnabled;
    private final boolean isMoreAboutVerificationEnabled;
    private final boolean isSelectableDocumentFlow;
    private final boolean isSingleStepFlow;
    private final boolean isSupplementaryDocumentUploadAllowed;
    private final boolean isValidationAndGuidanceEnabled;
    private final String requirementId;
    private final Session session;
    private final UiSessionConfiguration uiSessionConfiguration;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<DocumentCaptureConfiguration> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentCaptureConfiguration createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DocumentCaptureConfiguration((UiSessionConfiguration) parcel.readParcelable(DocumentCaptureConfiguration.class.getClassLoader()), (Session) parcel.readParcelable(DocumentCaptureConfiguration.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentCaptureConfiguration[] newArray(int i) {
            return new DocumentCaptureConfiguration[i];
        }
    }

    public DocumentCaptureConfiguration(UiSessionConfiguration uiSessionConfiguration, Session session, String requirementId, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(uiSessionConfiguration, "uiSessionConfiguration");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        this.uiSessionConfiguration = uiSessionConfiguration;
        this.session = session;
        this.requirementId = requirementId;
        this.isSingleStepFlow = z;
        this.isSelectableDocumentFlow = z2;
        this.isSupplementaryDocumentUploadAllowed = z3;
        this.isMoreAboutVerificationEnabled = z4;
        this.isValidationAndGuidanceEnabled = z5;
        this.isDoNotHaveDocumentOptionEnabled = z6;
    }

    public /* synthetic */ DocumentCaptureConfiguration(UiSessionConfiguration uiSessionConfiguration, Session session, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UiSessionConfiguration(null, null, false, 7, null) : uiSessionConfiguration, session, str, (i & 8) != 0 ? false : z, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? true : z3, (i & 64) != 0 ? true : z4, (i & 128) != 0 ? false : z5, (i & 256) != 0 ? true : z6);
    }

    public static /* synthetic */ DocumentCaptureConfiguration copy$default(DocumentCaptureConfiguration documentCaptureConfiguration, UiSessionConfiguration uiSessionConfiguration, Session session, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
        if (obj == null) {
            return documentCaptureConfiguration.copy((i & 1) != 0 ? documentCaptureConfiguration.getUiSessionConfiguration() : uiSessionConfiguration, (i & 2) != 0 ? documentCaptureConfiguration.getSession() : session, (i & 4) != 0 ? documentCaptureConfiguration.getRequirementId() : str, (i & 8) != 0 ? documentCaptureConfiguration.getIsSingleStepFlow() : z, (i & 16) != 0 ? documentCaptureConfiguration.getIsSelectableDocumentFlow() : z2, (i & 32) != 0 ? documentCaptureConfiguration.getIsSupplementaryDocumentUploadAllowed() : z3, (i & 64) != 0 ? documentCaptureConfiguration.getIsMoreAboutVerificationEnabled() : z4, (i & 128) != 0 ? documentCaptureConfiguration.getIsValidationAndGuidanceEnabled() : z5, (i & 256) != 0 ? documentCaptureConfiguration.getIsDoNotHaveDocumentOptionEnabled() : z6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    public final UiSessionConfiguration component1() {
        return getUiSessionConfiguration();
    }

    public final Session component2() {
        return getSession();
    }

    public final String component3() {
        return getRequirementId();
    }

    public final boolean component4() {
        return getIsSingleStepFlow();
    }

    public final boolean component5() {
        return getIsSelectableDocumentFlow();
    }

    public final boolean component6() {
        return getIsSupplementaryDocumentUploadAllowed();
    }

    public final boolean component7() {
        return getIsMoreAboutVerificationEnabled();
    }

    public final boolean component8() {
        return getIsValidationAndGuidanceEnabled();
    }

    public final boolean component9() {
        return getIsDoNotHaveDocumentOptionEnabled();
    }

    public final DocumentCaptureConfiguration copy(UiSessionConfiguration uiSessionConfiguration, Session session, String requirementId, boolean isSingleStepFlow, boolean isSelectableDocumentFlow, boolean isSupplementaryDocumentUploadAllowed, boolean isMoreAboutVerificationEnabled, boolean isValidationAndGuidanceEnabled, boolean isDoNotHaveDocumentOptionEnabled) {
        Intrinsics.checkNotNullParameter(uiSessionConfiguration, "uiSessionConfiguration");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        return new DocumentCaptureConfiguration(uiSessionConfiguration, session, requirementId, isSingleStepFlow, isSelectableDocumentFlow, isSupplementaryDocumentUploadAllowed, isMoreAboutVerificationEnabled, isValidationAndGuidanceEnabled, isDoNotHaveDocumentOptionEnabled);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentCaptureConfiguration)) {
            return false;
        }
        DocumentCaptureConfiguration documentCaptureConfiguration = (DocumentCaptureConfiguration) other;
        return Intrinsics.areEqual(getUiSessionConfiguration(), documentCaptureConfiguration.getUiSessionConfiguration()) && Intrinsics.areEqual(getSession(), documentCaptureConfiguration.getSession()) && Intrinsics.areEqual(getRequirementId(), documentCaptureConfiguration.getRequirementId()) && getIsSingleStepFlow() == documentCaptureConfiguration.getIsSingleStepFlow() && getIsSelectableDocumentFlow() == documentCaptureConfiguration.getIsSelectableDocumentFlow() && getIsSupplementaryDocumentUploadAllowed() == documentCaptureConfiguration.getIsSupplementaryDocumentUploadAllowed() && getIsMoreAboutVerificationEnabled() == documentCaptureConfiguration.getIsMoreAboutVerificationEnabled() && getIsValidationAndGuidanceEnabled() == documentCaptureConfiguration.getIsValidationAndGuidanceEnabled() && getIsDoNotHaveDocumentOptionEnabled() == documentCaptureConfiguration.getIsDoNotHaveDocumentOptionEnabled();
    }

    public String getRequirementId() {
        return this.requirementId;
    }

    public Session getSession() {
        return this.session;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration
    public UiSessionConfiguration getUiSessionConfiguration() {
        return this.uiSessionConfiguration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((getUiSessionConfiguration().hashCode() * 31) + getSession().hashCode()) * 31) + getRequirementId().hashCode()) * 31;
        boolean isSingleStepFlow = getIsSingleStepFlow();
        ?? r1 = isSingleStepFlow;
        if (isSingleStepFlow) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean isSelectableDocumentFlow = getIsSelectableDocumentFlow();
        ?? r12 = isSelectableDocumentFlow;
        if (isSelectableDocumentFlow) {
            r12 = 1;
        }
        int i2 = (i + r12) * 31;
        boolean isSupplementaryDocumentUploadAllowed = getIsSupplementaryDocumentUploadAllowed();
        ?? r13 = isSupplementaryDocumentUploadAllowed;
        if (isSupplementaryDocumentUploadAllowed) {
            r13 = 1;
        }
        int i3 = (i2 + r13) * 31;
        boolean isMoreAboutVerificationEnabled = getIsMoreAboutVerificationEnabled();
        ?? r14 = isMoreAboutVerificationEnabled;
        if (isMoreAboutVerificationEnabled) {
            r14 = 1;
        }
        int i4 = (i3 + r14) * 31;
        boolean isValidationAndGuidanceEnabled = getIsValidationAndGuidanceEnabled();
        ?? r15 = isValidationAndGuidanceEnabled;
        if (isValidationAndGuidanceEnabled) {
            r15 = 1;
        }
        int i5 = (i4 + r15) * 31;
        boolean isDoNotHaveDocumentOptionEnabled = getIsDoNotHaveDocumentOptionEnabled();
        return i5 + (isDoNotHaveDocumentOptionEnabled ? 1 : isDoNotHaveDocumentOptionEnabled);
    }

    /* JADX INFO: renamed from: isDoNotHaveDocumentOptionEnabled, reason: from getter */
    public boolean getIsDoNotHaveDocumentOptionEnabled() {
        return this.isDoNotHaveDocumentOptionEnabled;
    }

    /* JADX INFO: renamed from: isMoreAboutVerificationEnabled, reason: from getter */
    public boolean getIsMoreAboutVerificationEnabled() {
        return this.isMoreAboutVerificationEnabled;
    }

    /* JADX INFO: renamed from: isSelectableDocumentFlow, reason: from getter */
    public boolean getIsSelectableDocumentFlow() {
        return this.isSelectableDocumentFlow;
    }

    /* JADX INFO: renamed from: isSingleStepFlow, reason: from getter */
    public boolean getIsSingleStepFlow() {
        return this.isSingleStepFlow;
    }

    /* JADX INFO: renamed from: isSupplementaryDocumentUploadAllowed, reason: from getter */
    public boolean getIsSupplementaryDocumentUploadAllowed() {
        return this.isSupplementaryDocumentUploadAllowed;
    }

    /* JADX INFO: renamed from: isValidationAndGuidanceEnabled, reason: from getter */
    public boolean getIsValidationAndGuidanceEnabled() {
        return this.isValidationAndGuidanceEnabled;
    }

    public String toString() {
        return "DocumentCaptureConfiguration(uiSessionConfiguration=" + getUiSessionConfiguration() + ", session=" + getSession() + ", requirementId=" + getRequirementId() + ", isSingleStepFlow=" + getIsSingleStepFlow() + ", isSelectableDocumentFlow=" + getIsSelectableDocumentFlow() + ", isSupplementaryDocumentUploadAllowed=" + getIsSupplementaryDocumentUploadAllowed() + ", isMoreAboutVerificationEnabled=" + getIsMoreAboutVerificationEnabled() + ", isValidationAndGuidanceEnabled=" + getIsValidationAndGuidanceEnabled() + ", isDoNotHaveDocumentOptionEnabled=" + getIsDoNotHaveDocumentOptionEnabled() + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.uiSessionConfiguration, flags);
        parcel.writeParcelable(this.session, flags);
        parcel.writeString(this.requirementId);
        parcel.writeInt(this.isSingleStepFlow ? 1 : 0);
        parcel.writeInt(this.isSelectableDocumentFlow ? 1 : 0);
        parcel.writeInt(this.isSupplementaryDocumentUploadAllowed ? 1 : 0);
        parcel.writeInt(this.isMoreAboutVerificationEnabled ? 1 : 0);
        parcel.writeInt(this.isValidationAndGuidanceEnabled ? 1 : 0);
        parcel.writeInt(this.isDoNotHaveDocumentOptionEnabled ? 1 : 0);
    }
}
