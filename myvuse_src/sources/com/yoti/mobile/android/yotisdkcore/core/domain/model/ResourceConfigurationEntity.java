package com.yoti.mobile.android.yotisdkcore.core.domain.model;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\tJ\u0014\u0010!\u001a\u00020\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00000\bR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000b¨\u0006#"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/ResourceConfigurationEntity;", "", "feature", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/FeatureTypeEntity;", "isRefreshable", "", "(Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/FeatureTypeEntity;Z)V", "allowedSources", "", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SourceTypeEntity;", "getAllowedSources", "()Ljava/util/List;", "getFeature", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/FeatureTypeEntity;", "isCompleted", "()Z", "objective", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/CaptureObjectiveTypeEntity;", "getObjective", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/CaptureObjectiveTypeEntity;", "requirementId", "", "getRequirementId", "()Ljava/lang/String;", "state", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;", "getState", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;", "tasks", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/TaskEntity;", "getTasks", "isResourceCreationEnabled", "allowedSource", "shouldRefreshConfigurationAfterComplete", "resources", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class ResourceConfigurationEntity {
    private final FeatureTypeEntity feature;
    private final boolean isRefreshable;

    public ResourceConfigurationEntity(FeatureTypeEntity feature, boolean z) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        this.feature = feature;
        this.isRefreshable = z;
    }

    public /* synthetic */ ResourceConfigurationEntity(FeatureTypeEntity featureTypeEntity, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(featureTypeEntity, (i & 2) != 0 ? false : z);
    }

    public abstract List<SourceTypeEntity> getAllowedSources();

    public FeatureTypeEntity getFeature() {
        return this.feature;
    }

    public abstract CaptureObjectiveTypeEntity getObjective();

    public abstract String getRequirementId();

    public abstract StateTypeEntity getState();

    public abstract List<TaskEntity> getTasks();

    public final boolean isCompleted() {
        return getState() == StateTypeEntity.COMPLETE;
    }

    /* JADX INFO: renamed from: isRefreshable, reason: from getter */
    public final boolean getIsRefreshable() {
        return this.isRefreshable;
    }

    public final boolean isResourceCreationEnabled(SourceTypeEntity allowedSource) {
        Intrinsics.checkNotNullParameter(allowedSource, "allowedSource");
        return getAllowedSources().contains(allowedSource);
    }

    public final boolean shouldRefreshConfigurationAfterComplete(List<? extends ResourceConfigurationEntity> resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (this.isRefreshable && (!(resources instanceof Collection) || !resources.isEmpty())) {
            for (ResourceConfigurationEntity resourceConfigurationEntity : resources) {
                if (!Intrinsics.areEqual(resourceConfigurationEntity, this) && resourceConfigurationEntity.isRefreshable && !resourceConfigurationEntity.isCompleted()) {
                    return true;
                }
            }
        }
        return false;
    }
}
