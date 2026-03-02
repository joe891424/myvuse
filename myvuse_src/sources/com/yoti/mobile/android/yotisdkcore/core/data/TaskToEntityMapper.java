package com.yoti.mobile.android.yotisdkcore.core.data;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.core.data.model.Task;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.TaskEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.TaskTypeEntity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/TaskToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Task;", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/TaskEntity;", "stateTypeToEntityMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/StateTypeToEntityMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/StateTypeToEntityMapper;)V", "map", "from", "mapTaskTypeToEntity", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/TaskTypeEntity;", "taskType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Task$TaskType;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TaskToEntityMapper implements Mapper<Task, TaskEntity> {
    private final StateTypeToEntityMapper stateTypeToEntityMapper;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Task.TaskType.values().length];
            iArr[Task.TaskType.ID_DOCUMENT_TEXT_DATA_EXTRACTION.ordinal()] = 1;
            iArr[Task.TaskType.SUPPLEMENTARY_DOCUMENT_TEXT_DATA_EXTRACTION.ordinal()] = 2;
            iArr[Task.TaskType.UNKNOWN.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public TaskToEntityMapper(StateTypeToEntityMapper stateTypeToEntityMapper) {
        Intrinsics.checkNotNullParameter(stateTypeToEntityMapper, "stateTypeToEntityMapper");
        this.stateTypeToEntityMapper = stateTypeToEntityMapper;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public TaskEntity map(Task from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return new TaskEntity(mapTaskTypeToEntity(from.getType()), this.stateTypeToEntityMapper.map(from.getState()));
    }

    public final TaskTypeEntity mapTaskTypeToEntity(Task.TaskType taskType) {
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        int i = WhenMappings.$EnumSwitchMapping$0[taskType.ordinal()];
        if (i == 1) {
            return TaskTypeEntity.ID_DOCUMENT_TEXT_DATA_EXTRACTION;
        }
        if (i == 2) {
            return TaskTypeEntity.SUPPLEMENTARY_DOCUMENT_TEXT_DATA_EXTRACTION;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException("TaskType.UNKNOWN cannot be mapped");
    }
}
