package com.yoti.mobile.android.yotidocs.common.error;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class ExceptionToFailureMapper_Factory implements Factory<ExceptionToFailureMapper> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper_Factory$a */
    private static final class C4956a {

        /* JADX INFO: renamed from: a */
        private static final ExceptionToFailureMapper_Factory f7484a = new ExceptionToFailureMapper_Factory();
    }

    public static ExceptionToFailureMapper_Factory create() {
        return C4956a.f7484a;
    }

    public static ExceptionToFailureMapper newInstance() {
        return new ExceptionToFailureMapper();
    }

    @Override // javax.inject.Provider
    public ExceptionToFailureMapper get() {
        return newInstance();
    }
}
