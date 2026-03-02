package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import com.yoti.mobile.android.common.p049ui.components.utils.IDemonymProvider;
import com.yoti.mobile.android.remote.model.Session;
import com.yoti.mobile.android.yotisdkcore.core.view.ObjectiveEntityToViewDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.DocumentCaptureProperties;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.UiSessionProperties;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class DocumentResourceConfigEntityToViewDataMapper_Factory implements Factory<DocumentResourceConfigEntityToViewDataMapper> {

    /* JADX INFO: renamed from: a */
    private final Provider<DocumentTypeEntityToViewDataMapper> f7756a;

    /* JADX INFO: renamed from: b */
    private final Provider<ObjectiveEntityToViewDataMapper> f7757b;

    /* JADX INFO: renamed from: c */
    private final Provider<DocumentCaptureStepEnumerator> f7758c;

    /* JADX INFO: renamed from: d */
    private final Provider<IDemonymProvider> f7759d;

    /* JADX INFO: renamed from: e */
    private final Provider<Session> f7760e;

    /* JADX INFO: renamed from: f */
    private final Provider<DocumentCaptureProperties> f7761f;

    /* JADX INFO: renamed from: g */
    private final Provider<UiSessionProperties> f7762g;

    public DocumentResourceConfigEntityToViewDataMapper_Factory(Provider<DocumentTypeEntityToViewDataMapper> provider, Provider<ObjectiveEntityToViewDataMapper> provider2, Provider<DocumentCaptureStepEnumerator> provider3, Provider<IDemonymProvider> provider4, Provider<Session> provider5, Provider<DocumentCaptureProperties> provider6, Provider<UiSessionProperties> provider7) {
        this.f7756a = provider;
        this.f7757b = provider2;
        this.f7758c = provider3;
        this.f7759d = provider4;
        this.f7760e = provider5;
        this.f7761f = provider6;
        this.f7762g = provider7;
    }

    public static DocumentResourceConfigEntityToViewDataMapper_Factory create(Provider<DocumentTypeEntityToViewDataMapper> provider, Provider<ObjectiveEntityToViewDataMapper> provider2, Provider<DocumentCaptureStepEnumerator> provider3, Provider<IDemonymProvider> provider4, Provider<Session> provider5, Provider<DocumentCaptureProperties> provider6, Provider<UiSessionProperties> provider7) {
        return new DocumentResourceConfigEntityToViewDataMapper_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static DocumentResourceConfigEntityToViewDataMapper newInstance(DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper, ObjectiveEntityToViewDataMapper objectiveEntityToViewDataMapper, DocumentCaptureStepEnumerator documentCaptureStepEnumerator, IDemonymProvider iDemonymProvider, Session session, DocumentCaptureProperties documentCaptureProperties, UiSessionProperties uiSessionProperties) {
        return new DocumentResourceConfigEntityToViewDataMapper(documentTypeEntityToViewDataMapper, objectiveEntityToViewDataMapper, documentCaptureStepEnumerator, iDemonymProvider, session, documentCaptureProperties, uiSessionProperties);
    }

    @Override // javax.inject.Provider
    public DocumentResourceConfigEntityToViewDataMapper get() {
        return newInstance(this.f7756a.get(), this.f7757b.get(), this.f7758c.get(), this.f7759d.get(), this.f7760e.get(), this.f7761f.get(), this.f7762g.get());
    }
}
