package com.yoti.mobile.android.documentcapture.sup.view.review;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class PageNumberIndicatorFormatter_Factory implements Factory<PageNumberIndicatorFormatter> {

    private static final class InstanceHolder {
        private static final PageNumberIndicatorFormatter_Factory INSTANCE = new PageNumberIndicatorFormatter_Factory();

        private InstanceHolder() {
        }
    }

    public static PageNumberIndicatorFormatter_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PageNumberIndicatorFormatter newInstance() {
        return new PageNumberIndicatorFormatter();
    }

    @Override // javax.inject.Provider
    public PageNumberIndicatorFormatter get() {
        return newInstance();
    }
}
