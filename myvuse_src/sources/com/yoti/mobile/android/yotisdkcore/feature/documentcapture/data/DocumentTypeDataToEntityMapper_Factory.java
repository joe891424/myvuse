package com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class DocumentTypeDataToEntityMapper_Factory implements Factory<DocumentTypeDataToEntityMapper> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeDataToEntityMapper_Factory$a */
    private static final class C4991a {

        /* JADX INFO: renamed from: a */
        private static final DocumentTypeDataToEntityMapper_Factory f7616a = new DocumentTypeDataToEntityMapper_Factory();
    }

    public static DocumentTypeDataToEntityMapper_Factory create() {
        return C4991a.f7616a;
    }

    public static DocumentTypeDataToEntityMapper newInstance() {
        return new DocumentTypeDataToEntityMapper();
    }

    @Override // javax.inject.Provider
    public DocumentTypeDataToEntityMapper get() {
        return newInstance();
    }
}
