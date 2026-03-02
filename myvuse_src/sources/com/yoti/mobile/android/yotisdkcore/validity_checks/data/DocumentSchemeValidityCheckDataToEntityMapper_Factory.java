package com.yoti.mobile.android.yotisdkcore.validity_checks.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class DocumentSchemeValidityCheckDataToEntityMapper_Factory implements Factory<DocumentSchemeValidityCheckDataToEntityMapper> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.data.DocumentSchemeValidityCheckDataToEntityMapper_Factory$a */
    private static final class C5046a {

        /* JADX INFO: renamed from: a */
        private static final DocumentSchemeValidityCheckDataToEntityMapper_Factory f7874a = new DocumentSchemeValidityCheckDataToEntityMapper_Factory();
    }

    public static DocumentSchemeValidityCheckDataToEntityMapper_Factory create() {
        return C5046a.f7874a;
    }

    public static DocumentSchemeValidityCheckDataToEntityMapper newInstance() {
        return new DocumentSchemeValidityCheckDataToEntityMapper();
    }

    @Override // javax.inject.Provider
    public DocumentSchemeValidityCheckDataToEntityMapper get() {
        return newInstance();
    }
}
