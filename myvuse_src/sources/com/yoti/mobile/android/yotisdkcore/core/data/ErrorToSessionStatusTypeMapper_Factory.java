package com.yoti.mobile.android.yotisdkcore.core.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class ErrorToSessionStatusTypeMapper_Factory implements Factory<ErrorToSessionStatusTypeMapper> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper_Factory$a */
    private static final class C4973a {

        /* JADX INFO: renamed from: a */
        private static final ErrorToSessionStatusTypeMapper_Factory f7604a = new ErrorToSessionStatusTypeMapper_Factory();
    }

    public static ErrorToSessionStatusTypeMapper_Factory create() {
        return C4973a.f7604a;
    }

    public static ErrorToSessionStatusTypeMapper newInstance() {
        return new ErrorToSessionStatusTypeMapper();
    }

    @Override // javax.inject.Provider
    public ErrorToSessionStatusTypeMapper get() {
        return newInstance();
    }
}
