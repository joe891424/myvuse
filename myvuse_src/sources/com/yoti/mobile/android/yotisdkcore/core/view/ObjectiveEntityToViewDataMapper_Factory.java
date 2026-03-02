package com.yoti.mobile.android.yotisdkcore.core.view;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class ObjectiveEntityToViewDataMapper_Factory implements Factory<ObjectiveEntityToViewDataMapper> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.view.ObjectiveEntityToViewDataMapper_Factory$a */
    private static final class C4984a {

        /* JADX INFO: renamed from: a */
        private static final ObjectiveEntityToViewDataMapper_Factory f7610a = new ObjectiveEntityToViewDataMapper_Factory();
    }

    public static ObjectiveEntityToViewDataMapper_Factory create() {
        return C4984a.f7610a;
    }

    public static ObjectiveEntityToViewDataMapper newInstance() {
        return new ObjectiveEntityToViewDataMapper();
    }

    @Override // javax.inject.Provider
    public ObjectiveEntityToViewDataMapper get() {
        return newInstance();
    }
}
