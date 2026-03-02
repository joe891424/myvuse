package com.yoti.mobile.android.yotisdkcore.core.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.commonui.UiSessionConfiguration;
import com.yoti.mobile.android.remote.model.Session;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.LivenessResourceConfigEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0010HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÂ\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001J\u0013\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020+HÖ\u0001J\t\u00100\u001a\u00020\u0007HÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020+HÖ\u0001R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u00066"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "uiSessionConfiguration", "Lcom/yoti/mobile/android/commonui/UiSessionConfiguration;", "session", "Lcom/yoti/mobile/android/remote/model/Session;", "requirementId", "", "requireBiometricConsent", "", "biometricPolicyUsUrl", "isSingleStepFlow", "useBackCamera", "isAutomaticCapture", "_isMoreAboutVerificationEnabled", "livenessType", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$LivenessTypeEntity;", "(Lcom/yoti/mobile/android/commonui/UiSessionConfiguration;Lcom/yoti/mobile/android/remote/model/Session;Ljava/lang/String;ZLjava/lang/String;ZZZZLcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$LivenessTypeEntity;)V", "getBiometricPolicyUsUrl", "()Ljava/lang/String;", "()Z", "isMoreAboutVerificationEnabled", "getLivenessType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$LivenessTypeEntity;", "getRequireBiometricConsent", "getRequirementId", "getSession", "()Lcom/yoti/mobile/android/remote/model/Session;", "getUiSessionConfiguration", "()Lcom/yoti/mobile/android/commonui/UiSessionConfiguration;", "getUseBackCamera", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class LivenessFeatureConfiguration implements IFeatureConfiguration {
    public static final Parcelable.Creator<LivenessFeatureConfiguration> CREATOR = new Creator();
    private final boolean _isMoreAboutVerificationEnabled;
    private final String biometricPolicyUsUrl;
    private final boolean isAutomaticCapture;
    private final boolean isSingleStepFlow;
    private final LivenessResourceConfigEntity.LivenessTypeEntity livenessType;
    private final boolean requireBiometricConsent;
    private final String requirementId;
    private final Session session;
    private final UiSessionConfiguration uiSessionConfiguration;
    private final boolean useBackCamera;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<LivenessFeatureConfiguration> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LivenessFeatureConfiguration createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LivenessFeatureConfiguration((UiSessionConfiguration) parcel.readParcelable(LivenessFeatureConfiguration.class.getClassLoader()), (Session) parcel.readParcelable(LivenessFeatureConfiguration.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, LivenessResourceConfigEntity.LivenessTypeEntity.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LivenessFeatureConfiguration[] newArray(int i) {
            return new LivenessFeatureConfiguration[i];
        }
    }

    public LivenessFeatureConfiguration(UiSessionConfiguration uiSessionConfiguration, Session session, String requirementId, boolean z, String biometricPolicyUsUrl, boolean z2, boolean z3, boolean z4, boolean z5, LivenessResourceConfigEntity.LivenessTypeEntity livenessType) {
        Intrinsics.checkNotNullParameter(uiSessionConfiguration, "uiSessionConfiguration");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        Intrinsics.checkNotNullParameter(biometricPolicyUsUrl, "biometricPolicyUsUrl");
        Intrinsics.checkNotNullParameter(livenessType, "livenessType");
        this.uiSessionConfiguration = uiSessionConfiguration;
        this.session = session;
        this.requirementId = requirementId;
        this.requireBiometricConsent = z;
        this.biometricPolicyUsUrl = biometricPolicyUsUrl;
        this.isSingleStepFlow = z2;
        this.useBackCamera = z3;
        this.isAutomaticCapture = z4;
        this._isMoreAboutVerificationEnabled = z5;
        this.livenessType = livenessType;
    }

    public /* synthetic */ LivenessFeatureConfiguration(UiSessionConfiguration uiSessionConfiguration, Session session, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, boolean z5, LivenessResourceConfigEntity.LivenessTypeEntity livenessTypeEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UiSessionConfiguration(null, null, false, 7, null) : uiSessionConfiguration, session, str, z, str2, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? false : z3, (i & 128) != 0 ? true : z4, (i & 256) != 0 ? true : z5, livenessTypeEntity);
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    private final boolean get_isMoreAboutVerificationEnabled() {
        return this._isMoreAboutVerificationEnabled;
    }

    public final UiSessionConfiguration component1() {
        return getUiSessionConfiguration();
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final LivenessResourceConfigEntity.LivenessTypeEntity getLivenessType() {
        return this.livenessType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Session getSession() {
        return this.session;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRequirementId() {
        return this.requirementId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getRequireBiometricConsent() {
        return this.requireBiometricConsent;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBiometricPolicyUsUrl() {
        return this.biometricPolicyUsUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsSingleStepFlow() {
        return this.isSingleStepFlow;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getUseBackCamera() {
        return this.useBackCamera;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsAutomaticCapture() {
        return this.isAutomaticCapture;
    }

    public final LivenessFeatureConfiguration copy(UiSessionConfiguration uiSessionConfiguration, Session session, String requirementId, boolean requireBiometricConsent, String biometricPolicyUsUrl, boolean isSingleStepFlow, boolean useBackCamera, boolean isAutomaticCapture, boolean _isMoreAboutVerificationEnabled, LivenessResourceConfigEntity.LivenessTypeEntity livenessType) {
        Intrinsics.checkNotNullParameter(uiSessionConfiguration, "uiSessionConfiguration");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        Intrinsics.checkNotNullParameter(biometricPolicyUsUrl, "biometricPolicyUsUrl");
        Intrinsics.checkNotNullParameter(livenessType, "livenessType");
        return new LivenessFeatureConfiguration(uiSessionConfiguration, session, requirementId, requireBiometricConsent, biometricPolicyUsUrl, isSingleStepFlow, useBackCamera, isAutomaticCapture, _isMoreAboutVerificationEnabled, livenessType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LivenessFeatureConfiguration)) {
            return false;
        }
        LivenessFeatureConfiguration livenessFeatureConfiguration = (LivenessFeatureConfiguration) other;
        return Intrinsics.areEqual(getUiSessionConfiguration(), livenessFeatureConfiguration.getUiSessionConfiguration()) && Intrinsics.areEqual(this.session, livenessFeatureConfiguration.session) && Intrinsics.areEqual(this.requirementId, livenessFeatureConfiguration.requirementId) && this.requireBiometricConsent == livenessFeatureConfiguration.requireBiometricConsent && Intrinsics.areEqual(this.biometricPolicyUsUrl, livenessFeatureConfiguration.biometricPolicyUsUrl) && this.isSingleStepFlow == livenessFeatureConfiguration.isSingleStepFlow && this.useBackCamera == livenessFeatureConfiguration.useBackCamera && this.isAutomaticCapture == livenessFeatureConfiguration.isAutomaticCapture && this._isMoreAboutVerificationEnabled == livenessFeatureConfiguration._isMoreAboutVerificationEnabled && this.livenessType == livenessFeatureConfiguration.livenessType;
    }

    public final String getBiometricPolicyUsUrl() {
        return this.biometricPolicyUsUrl;
    }

    public final LivenessResourceConfigEntity.LivenessTypeEntity getLivenessType() {
        return this.livenessType;
    }

    public final boolean getRequireBiometricConsent() {
        return this.requireBiometricConsent;
    }

    public final String getRequirementId() {
        return this.requirementId;
    }

    public final Session getSession() {
        return this.session;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration
    public UiSessionConfiguration getUiSessionConfiguration() {
        return this.uiSessionConfiguration;
    }

    public final boolean getUseBackCamera() {
        return this.useBackCamera;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((getUiSessionConfiguration().hashCode() * 31) + this.session.hashCode()) * 31) + this.requirementId.hashCode()) * 31;
        boolean z = this.requireBiometricConsent;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + this.biometricPolicyUsUrl.hashCode()) * 31;
        boolean z2 = this.isSingleStepFlow;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        int i = (iHashCode2 + r12) * 31;
        boolean z3 = this.useBackCamera;
        ?? r13 = z3;
        if (z3) {
            r13 = 1;
        }
        int i2 = (i + r13) * 31;
        boolean z4 = this.isAutomaticCapture;
        ?? r14 = z4;
        if (z4) {
            r14 = 1;
        }
        int i3 = (i2 + r14) * 31;
        boolean z5 = this._isMoreAboutVerificationEnabled;
        return ((i3 + (z5 ? 1 : z5)) * 31) + this.livenessType.hashCode();
    }

    public final boolean isAutomaticCapture() {
        return this.isAutomaticCapture;
    }

    public final boolean isMoreAboutVerificationEnabled() {
        return this._isMoreAboutVerificationEnabled && this.livenessType != LivenessResourceConfigEntity.LivenessTypeEntity.STATIC;
    }

    public final boolean isSingleStepFlow() {
        return this.isSingleStepFlow;
    }

    public String toString() {
        return "LivenessFeatureConfiguration(uiSessionConfiguration=" + getUiSessionConfiguration() + ", session=" + this.session + ", requirementId=" + this.requirementId + ", requireBiometricConsent=" + this.requireBiometricConsent + ", biometricPolicyUsUrl=" + this.biometricPolicyUsUrl + ", isSingleStepFlow=" + this.isSingleStepFlow + ", useBackCamera=" + this.useBackCamera + ", isAutomaticCapture=" + this.isAutomaticCapture + ", _isMoreAboutVerificationEnabled=" + this._isMoreAboutVerificationEnabled + ", livenessType=" + this.livenessType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.uiSessionConfiguration, flags);
        parcel.writeParcelable(this.session, flags);
        parcel.writeString(this.requirementId);
        parcel.writeInt(this.requireBiometricConsent ? 1 : 0);
        parcel.writeString(this.biometricPolicyUsUrl);
        parcel.writeInt(this.isSingleStepFlow ? 1 : 0);
        parcel.writeInt(this.useBackCamera ? 1 : 0);
        parcel.writeInt(this.isAutomaticCapture ? 1 : 0);
        parcel.writeInt(this._isMoreAboutVerificationEnabled ? 1 : 0);
        parcel.writeString(this.livenessType.name());
    }
}
