package com.yoti.mobile.android.yotisdkcore.core.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class StateTypeToEntityMapper_Factory implements Factory<StateTypeToEntityMapper> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.data.StateTypeToEntityMapper_Factory$a */
    private static final class C4976a {

        /* JADX INFO: renamed from: a */
        private static final StateTypeToEntityMapper_Factory f7607a = new StateTypeToEntityMapper_Factory();
    }

    public static StateTypeToEntityMapper_Factory create() {
        return C4976a.f7607a;
    }

    public static StateTypeToEntityMapper newInstance() {
        return new StateTypeToEntityMapper();
    }

    @Override // javax.inject.Provider
    public StateTypeToEntityMapper get() {
        return newInstance();
    }
}
