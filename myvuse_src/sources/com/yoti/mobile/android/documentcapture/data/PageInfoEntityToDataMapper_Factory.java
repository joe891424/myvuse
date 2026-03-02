package com.yoti.mobile.android.documentcapture.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class PageInfoEntityToDataMapper_Factory implements Factory<PageInfoEntityToDataMapper> {

    private static final class InstanceHolder {
        private static final PageInfoEntityToDataMapper_Factory INSTANCE = new PageInfoEntityToDataMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static PageInfoEntityToDataMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PageInfoEntityToDataMapper newInstance() {
        return new PageInfoEntityToDataMapper();
    }

    @Override // javax.inject.Provider
    public PageInfoEntityToDataMapper get() {
        return newInstance();
    }
}
