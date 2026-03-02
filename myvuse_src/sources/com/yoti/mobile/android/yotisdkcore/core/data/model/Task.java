package com.yoti.mobile.android.yotisdkcore.core.data.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÂ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Task;", "", "_type", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Task$TaskType;", "_state", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/StateType;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Task$TaskType;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/StateType;)V", "state", "getState", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/StateType;", "type", "getType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Task$TaskType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TaskType", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class Task {

    @SerializedName("state")
    private final StateType _state;

    @SerializedName("type")
    private final TaskType _type;

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Task$TaskType;", "", "(Ljava/lang/String;I)V", "ID_DOCUMENT_TEXT_DATA_EXTRACTION", "SUPPLEMENTARY_DOCUMENT_TEXT_DATA_EXTRACTION", "UNKNOWN", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum TaskType {
        ID_DOCUMENT_TEXT_DATA_EXTRACTION,
        SUPPLEMENTARY_DOCUMENT_TEXT_DATA_EXTRACTION,
        UNKNOWN
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Task() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public Task(TaskType taskType, StateType stateType) {
        this._type = taskType;
        this._state = stateType;
    }

    public /* synthetic */ Task(TaskType taskType, StateType stateType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? TaskType.UNKNOWN : taskType, (i & 2) != 0 ? StateType.UNKNOWN : stateType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final TaskType get_type() {
        return this._type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final StateType get_state() {
        return this._state;
    }

    public static /* synthetic */ Task copy$default(Task task, TaskType taskType, StateType stateType, int i, Object obj) {
        if ((i & 1) != 0) {
            taskType = task._type;
        }
        if ((i & 2) != 0) {
            stateType = task._state;
        }
        return task.copy(taskType, stateType);
    }

    public final Task copy(TaskType _type, StateType _state) {
        return new Task(_type, _state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Task)) {
            return false;
        }
        Task task = (Task) other;
        return this._type == task._type && this._state == task._state;
    }

    public final StateType getState() {
        StateType stateType = this._state;
        return stateType == null ? StateType.UNKNOWN : stateType;
    }

    public final TaskType getType() {
        TaskType taskType = this._type;
        return taskType == null ? TaskType.UNKNOWN : taskType;
    }

    public int hashCode() {
        TaskType taskType = this._type;
        int iHashCode = (taskType == null ? 0 : taskType.hashCode()) * 31;
        StateType stateType = this._state;
        return iHashCode + (stateType != null ? stateType.hashCode() : 0);
    }

    public String toString() {
        return "Task(_type=" + this._type + ", _state=" + this._state + ')';
    }
}
