package com.yoti.mobile.android.yotisdkcore.core.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/TaskEntity;", "", "type", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/TaskTypeEntity;", "state", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;", "(Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/TaskTypeEntity;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;)V", "getState", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;", "getType", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/TaskTypeEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class TaskEntity {
    private final StateTypeEntity state;
    private final TaskTypeEntity type;

    public TaskEntity(TaskTypeEntity type, StateTypeEntity state) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        this.type = type;
        this.state = state;
    }

    public static /* synthetic */ TaskEntity copy$default(TaskEntity taskEntity, TaskTypeEntity taskTypeEntity, StateTypeEntity stateTypeEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            taskTypeEntity = taskEntity.type;
        }
        if ((i & 2) != 0) {
            stateTypeEntity = taskEntity.state;
        }
        return taskEntity.copy(taskTypeEntity, stateTypeEntity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TaskTypeEntity getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StateTypeEntity getState() {
        return this.state;
    }

    public final TaskEntity copy(TaskTypeEntity type, StateTypeEntity state) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        return new TaskEntity(type, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskEntity)) {
            return false;
        }
        TaskEntity taskEntity = (TaskEntity) other;
        return this.type == taskEntity.type && this.state == taskEntity.state;
    }

    public final StateTypeEntity getState() {
        return this.state;
    }

    public final TaskTypeEntity getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.state.hashCode();
    }

    public String toString() {
        return "TaskEntity(type=" + this.type + ", state=" + this.state + ')';
    }
}
