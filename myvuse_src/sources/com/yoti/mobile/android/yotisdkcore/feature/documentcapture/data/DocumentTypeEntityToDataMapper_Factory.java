package com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class DocumentTypeEntityToDataMapper_Factory implements Factory<DocumentTypeEntityToDataMapper> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper_Factory$a */
    private static final class C4992a {

        /* JADX INFO: renamed from: a */
        private static final DocumentTypeEntityToDataMapper_Factory f7617a = new DocumentTypeEntityToDataMapper_Factory();
    }

    public static DocumentTypeEntityToDataMapper_Factory create() {
        return C4992a.f7617a;
    }

    public static DocumentTypeEntityToDataMapper newInstance() {
        return new DocumentTypeEntityToDataMapper();
    }

    @Override // javax.inject.Provider
    public DocumentTypeEntityToDataMapper get() {
        return newInstance();
    }
}
