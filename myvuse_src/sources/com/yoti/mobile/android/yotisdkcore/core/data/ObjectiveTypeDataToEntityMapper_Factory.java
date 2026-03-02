package com.yoti.mobile.android.yotisdkcore.core.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class ObjectiveTypeDataToEntityMapper_Factory implements Factory<ObjectiveTypeDataToEntityMapper> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.data.ObjectiveTypeDataToEntityMapper_Factory$a */
    private static final class C4974a {

        /* JADX INFO: renamed from: a */
        private static final ObjectiveTypeDataToEntityMapper_Factory f7605a = new ObjectiveTypeDataToEntityMapper_Factory();
    }

    public static ObjectiveTypeDataToEntityMapper_Factory create() {
        return C4974a.f7605a;
    }

    public static ObjectiveTypeDataToEntityMapper newInstance() {
        return new ObjectiveTypeDataToEntityMapper();
    }

    @Override // javax.inject.Provider
    public ObjectiveTypeDataToEntityMapper get() {
        return newInstance();
    }
}
