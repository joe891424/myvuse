package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class DocumentCaptureStepEnumerator_Factory implements Factory<DocumentCaptureStepEnumerator> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.DocumentCaptureStepEnumerator_Factory$a */
    private static final class C5018a {

        /* JADX INFO: renamed from: a */
        private static final DocumentCaptureStepEnumerator_Factory f7755a = new DocumentCaptureStepEnumerator_Factory();
    }

    public static DocumentCaptureStepEnumerator_Factory create() {
        return C5018a.f7755a;
    }

    public static DocumentCaptureStepEnumerator newInstance() {
        return new DocumentCaptureStepEnumerator();
    }

    @Override // javax.inject.Provider
    public DocumentCaptureStepEnumerator get() {
        return newInstance();
    }
}
