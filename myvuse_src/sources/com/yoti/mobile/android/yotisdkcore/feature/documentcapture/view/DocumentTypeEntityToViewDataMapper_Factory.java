package com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class DocumentTypeEntityToViewDataMapper_Factory implements Factory<DocumentTypeEntityToViewDataMapper> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper_Factory$a */
    private static final class C4993a {

        /* JADX INFO: renamed from: a */
        private static final DocumentTypeEntityToViewDataMapper_Factory f7618a = new DocumentTypeEntityToViewDataMapper_Factory();
    }

    public static DocumentTypeEntityToViewDataMapper_Factory create() {
        return C4993a.f7618a;
    }

    public static DocumentTypeEntityToViewDataMapper newInstance() {
        return new DocumentTypeEntityToViewDataMapper();
    }

    @Override // javax.inject.Provider
    public DocumentTypeEntityToViewDataMapper get() {
        return newInstance();
    }
}
