package com.yoti.mobile.android.yotisdkcore.core.data;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class TaskToEntityMapper_Factory implements Factory<TaskToEntityMapper> {
    private final Provider<StateTypeToEntityMapper> stateTypeToEntityMapperProvider;

    public TaskToEntityMapper_Factory(Provider<StateTypeToEntityMapper> provider) {
        this.stateTypeToEntityMapperProvider = provider;
    }

    public static TaskToEntityMapper_Factory create(Provider<StateTypeToEntityMapper> provider) {
        return new TaskToEntityMapper_Factory(provider);
    }

    public static TaskToEntityMapper newInstance(StateTypeToEntityMapper stateTypeToEntityMapper) {
        return new TaskToEntityMapper(stateTypeToEntityMapper);
    }

    @Override // javax.inject.Provider
    public TaskToEntityMapper get() {
        return newInstance(this.stateTypeToEntityMapperProvider.get());
    }
}
