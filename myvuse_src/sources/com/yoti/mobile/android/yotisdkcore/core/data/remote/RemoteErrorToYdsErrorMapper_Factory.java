package com.yoti.mobile.android.yotisdkcore.core.data.remote;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoteErrorToYdsErrorMapper_Factory implements Factory<RemoteErrorToYdsErrorMapper> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.data.remote.RemoteErrorToYdsErrorMapper_Factory$a */
    private static final class C4977a {

        /* JADX INFO: renamed from: a */
        private static final RemoteErrorToYdsErrorMapper_Factory f7608a = new RemoteErrorToYdsErrorMapper_Factory();
    }

    public static RemoteErrorToYdsErrorMapper_Factory create() {
        return C4977a.f7608a;
    }

    public static RemoteErrorToYdsErrorMapper newInstance() {
        return new RemoteErrorToYdsErrorMapper();
    }

    @Override // javax.inject.Provider
    public RemoteErrorToYdsErrorMapper get() {
        return newInstance();
    }
}
