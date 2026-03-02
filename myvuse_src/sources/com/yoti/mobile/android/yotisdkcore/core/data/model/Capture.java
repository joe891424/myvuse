package com.yoti.mobile.android.yotisdkcore.core.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÂ\u0003J%\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Capture;", "", "resourceConfigs", "", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration;", "_biometricConsent", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/BiometricConsent;", "(Ljava/util/List;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/BiometricConsent;)V", "biometricConsent", "getBiometricConsent", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/BiometricConsent;", "getResourceConfigs", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class Capture {

    @SerializedName("biometric_consent")
    private final BiometricConsent _biometricConsent;

    @SerializedName("required_resources")
    private final List<ResourceConfiguration> resourceConfigs;

    public Capture(List<ResourceConfiguration> resourceConfigs, BiometricConsent biometricConsent) {
        Intrinsics.checkNotNullParameter(resourceConfigs, "resourceConfigs");
        this.resourceConfigs = resourceConfigs;
        this._biometricConsent = biometricConsent;
    }

    public /* synthetic */ Capture(List list, BiometricConsent biometricConsent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : biometricConsent);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final BiometricConsent get_biometricConsent() {
        return this._biometricConsent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Capture copy$default(Capture capture, List list, BiometricConsent biometricConsent, int i, Object obj) {
        if ((i & 1) != 0) {
            list = capture.resourceConfigs;
        }
        if ((i & 2) != 0) {
            biometricConsent = capture._biometricConsent;
        }
        return capture.copy(list, biometricConsent);
    }

    public final List<ResourceConfiguration> component1() {
        return this.resourceConfigs;
    }

    public final Capture copy(List<ResourceConfiguration> resourceConfigs, BiometricConsent _biometricConsent) {
        Intrinsics.checkNotNullParameter(resourceConfigs, "resourceConfigs");
        return new Capture(resourceConfigs, _biometricConsent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Capture)) {
            return false;
        }
        Capture capture = (Capture) other;
        return Intrinsics.areEqual(this.resourceConfigs, capture.resourceConfigs) && this._biometricConsent == capture._biometricConsent;
    }

    public final BiometricConsent getBiometricConsent() {
        BiometricConsent biometricConsent = this._biometricConsent;
        return biometricConsent == null ? BiometricConsent.UNKNOWN : biometricConsent;
    }

    public final List<ResourceConfiguration> getResourceConfigs() {
        return this.resourceConfigs;
    }

    public int hashCode() {
        int iHashCode = this.resourceConfigs.hashCode() * 31;
        BiometricConsent biometricConsent = this._biometricConsent;
        return iHashCode + (biometricConsent == null ? 0 : biometricConsent.hashCode());
    }

    public String toString() {
        return "Capture(resourceConfigs=" + this.resourceConfigs + ", _biometricConsent=" + this._biometricConsent + ')';
    }
}
