package com.yoti.mobile.android.yotisdkcore.core.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class SourceTypeToEntityMapper_Factory implements Factory<SourceTypeToEntityMapper> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.data.SourceTypeToEntityMapper_Factory$a */
    private static final class C4975a {

        /* JADX INFO: renamed from: a */
        private static final SourceTypeToEntityMapper_Factory f7606a = new SourceTypeToEntityMapper_Factory();
    }

    public static SourceTypeToEntityMapper_Factory create() {
        return C4975a.f7606a;
    }

    public static SourceTypeToEntityMapper newInstance() {
        return new SourceTypeToEntityMapper();
    }

    @Override // javax.inject.Provider
    public SourceTypeToEntityMapper get() {
        return newInstance();
    }
}
