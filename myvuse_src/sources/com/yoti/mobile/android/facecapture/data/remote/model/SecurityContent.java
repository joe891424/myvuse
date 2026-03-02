package com.yoti.mobile.android.facecapture.data.remote.model;

import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.LivenessResourceConfigEntity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/data/remote/model/SecurityContent;", "", "value", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Factory", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class SecurityContent {
    private final String name;
    private final String value;

    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/data/remote/model/SecurityContent$Factory;", "", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;)V", "create", "Lcom/yoti/mobile/android/facecapture/data/remote/model/SecurityContent;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Factory {
        private final LivenessFeatureConfiguration featureConfiguration;

        @Inject
        public Factory(LivenessFeatureConfiguration featureConfiguration) {
            Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
            this.featureConfiguration = featureConfiguration;
        }

        public final SecurityContent create() {
            LivenessResourceConfigEntity.LivenessTypeEntity livenessType = this.featureConfiguration.getLivenessType();
            if (livenessType != LivenessResourceConfigEntity.LivenessTypeEntity.STATIC) {
                livenessType = null;
            }
            if (livenessType != null) {
                return new SecurityContent(SecurityContentKt.SECURITY_CONTENT_VALUE, SecurityContentKt.SECURITY_CONTENT_NAME);
            }
            return null;
        }
    }

    public SecurityContent(String value, String name) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(name, "name");
        this.value = value;
        this.name = name;
    }

    public static /* synthetic */ SecurityContent copy$default(SecurityContent securityContent, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = securityContent.value;
        }
        if ((i & 2) != 0) {
            str2 = securityContent.name;
        }
        return securityContent.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final SecurityContent copy(String value, String name) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(name, "name");
        return new SecurityContent(value, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SecurityContent)) {
            return false;
        }
        SecurityContent securityContent = (SecurityContent) other;
        return Intrinsics.areEqual(this.value, securityContent.value) && Intrinsics.areEqual(this.name, securityContent.name);
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "SecurityContent(value=" + this.value + ", name=" + this.name + ')';
    }
}
