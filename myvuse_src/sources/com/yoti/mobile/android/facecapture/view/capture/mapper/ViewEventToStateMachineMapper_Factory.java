package com.yoti.mobile.android.facecapture.view.capture.mapper;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewEventToStateMachineMapper_Factory implements Factory<ViewEventToStateMachineMapper> {

    private static final class InstanceHolder {
        private static final ViewEventToStateMachineMapper_Factory INSTANCE = new ViewEventToStateMachineMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static ViewEventToStateMachineMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ViewEventToStateMachineMapper newInstance() {
        return new ViewEventToStateMachineMapper();
    }

    @Override // javax.inject.Provider
    public ViewEventToStateMachineMapper get() {
        return newInstance();
    }
}
