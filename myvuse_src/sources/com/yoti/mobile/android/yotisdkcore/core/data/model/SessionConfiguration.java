package com.yoti.mobile.android.yotisdkcore.core.data.model;

import com.google.gson.annotations.SerializedName;
import com.yoti.mobile.android.remote.RemoteDefsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÂ\u0003J\u0013\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000eHÆ\u0003JS\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\t8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/SessionConfiguration;", "", "sessionTokenTtl", "", "sessionId", "", "capture", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Capture;", "requestedChecks", "", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/CheckType;", "sdkConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Configuration;", "ibvOptions", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/IbvOptions;", "(ILjava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Capture;Ljava/util/List;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Configuration;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/IbvOptions;)V", "getIbvOptions", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/IbvOptions;", "getRequestedChecks", "()Ljava/util/List;", "resourcesConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration;", "getResourcesConfiguration", "getSdkConfiguration", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Configuration;", "getSessionId", "()Ljava/lang/String;", "getSessionTokenTtl", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class SessionConfiguration {

    @SerializedName("capture")
    private final Capture capture;

    @SerializedName("ibv_options")
    private final IbvOptions ibvOptions;

    @SerializedName("requested_checks")
    private final List<CheckType> requestedChecks;

    @SerializedName("sdk_config")
    private final Configuration sdkConfiguration;

    @SerializedName(RemoteDefsKt.PATH_SESSION_ID_KEY)
    private final String sessionId;

    @SerializedName("client_session_token_ttl")
    private final int sessionTokenTtl;

    /* JADX WARN: Multi-variable type inference failed */
    public SessionConfiguration(int i, String sessionId, Capture capture, List<? extends CheckType> list, Configuration configuration, IbvOptions ibvOptions) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(capture, "capture");
        this.sessionTokenTtl = i;
        this.sessionId = sessionId;
        this.capture = capture;
        this.requestedChecks = list;
        this.sdkConfiguration = configuration;
        this.ibvOptions = ibvOptions;
    }

    public /* synthetic */ SessionConfiguration(int i, String str, Capture capture, List list, Configuration configuration, IbvOptions ibvOptions, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, capture, (i2 & 8) != 0 ? null : list, (i2 & 16) != 0 ? null : configuration, (i2 & 32) != 0 ? null : ibvOptions);
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final Capture getCapture() {
        return this.capture;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SessionConfiguration copy$default(SessionConfiguration sessionConfiguration, int i, String str, Capture capture, List list, Configuration configuration, IbvOptions ibvOptions, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = sessionConfiguration.sessionTokenTtl;
        }
        if ((i2 & 2) != 0) {
            str = sessionConfiguration.sessionId;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            capture = sessionConfiguration.capture;
        }
        Capture capture2 = capture;
        if ((i2 & 8) != 0) {
            list = sessionConfiguration.requestedChecks;
        }
        List list2 = list;
        if ((i2 & 16) != 0) {
            configuration = sessionConfiguration.sdkConfiguration;
        }
        Configuration configuration2 = configuration;
        if ((i2 & 32) != 0) {
            ibvOptions = sessionConfiguration.ibvOptions;
        }
        return sessionConfiguration.copy(i, str2, capture2, list2, configuration2, ibvOptions);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSessionTokenTtl() {
        return this.sessionTokenTtl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final List<CheckType> component4() {
        return this.requestedChecks;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Configuration getSdkConfiguration() {
        return this.sdkConfiguration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final IbvOptions getIbvOptions() {
        return this.ibvOptions;
    }

    public final SessionConfiguration copy(int sessionTokenTtl, String sessionId, Capture capture, List<? extends CheckType> requestedChecks, Configuration sdkConfiguration, IbvOptions ibvOptions) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(capture, "capture");
        return new SessionConfiguration(sessionTokenTtl, sessionId, capture, requestedChecks, sdkConfiguration, ibvOptions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionConfiguration)) {
            return false;
        }
        SessionConfiguration sessionConfiguration = (SessionConfiguration) other;
        return this.sessionTokenTtl == sessionConfiguration.sessionTokenTtl && Intrinsics.areEqual(this.sessionId, sessionConfiguration.sessionId) && Intrinsics.areEqual(this.capture, sessionConfiguration.capture) && Intrinsics.areEqual(this.requestedChecks, sessionConfiguration.requestedChecks) && Intrinsics.areEqual(this.sdkConfiguration, sessionConfiguration.sdkConfiguration) && Intrinsics.areEqual(this.ibvOptions, sessionConfiguration.ibvOptions);
    }

    public final IbvOptions getIbvOptions() {
        return this.ibvOptions;
    }

    public final List<CheckType> getRequestedChecks() {
        return this.requestedChecks;
    }

    public final List<ResourceConfiguration> getResourcesConfiguration() {
        List<ResourceConfiguration> resourceConfigs = this.capture.getResourceConfigs();
        for (ResourceConfiguration resourceConfiguration : resourceConfigs) {
            resourceConfiguration.setBiometricConsent(this.capture.getBiometricConsent());
            Configuration configuration = this.sdkConfiguration;
            resourceConfiguration.setPresetIssuingCountry(configuration != null ? configuration.getPresetIssuingCountry() : null);
        }
        return resourceConfigs;
    }

    public final Configuration getSdkConfiguration() {
        return this.sdkConfiguration;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getSessionTokenTtl() {
        return this.sessionTokenTtl;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.sessionTokenTtl) * 31) + this.sessionId.hashCode()) * 31) + this.capture.hashCode()) * 31;
        List<CheckType> list = this.requestedChecks;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Configuration configuration = this.sdkConfiguration;
        int iHashCode3 = (iHashCode2 + (configuration == null ? 0 : configuration.hashCode())) * 31;
        IbvOptions ibvOptions = this.ibvOptions;
        return iHashCode3 + (ibvOptions != null ? ibvOptions.hashCode() : 0);
    }

    public String toString() {
        return "SessionConfiguration(sessionTokenTtl=" + this.sessionTokenTtl + ", sessionId=" + this.sessionId + ", capture=" + this.capture + ", requestedChecks=" + this.requestedChecks + ", sdkConfiguration=" + this.sdkConfiguration + ", ibvOptions=" + this.ibvOptions + ')';
    }
}
