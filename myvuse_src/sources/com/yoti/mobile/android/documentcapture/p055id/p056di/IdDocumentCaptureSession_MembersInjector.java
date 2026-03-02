package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreSession;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentCaptureSession_MembersInjector implements MembersInjector<IdDocumentCaptureSession> {
    private final Provider<DocumentCaptureCoreSession> coreSessionProvider;

    public IdDocumentCaptureSession_MembersInjector(Provider<DocumentCaptureCoreSession> provider) {
        this.coreSessionProvider = provider;
    }

    public static MembersInjector<IdDocumentCaptureSession> create(Provider<DocumentCaptureCoreSession> provider) {
        return new IdDocumentCaptureSession_MembersInjector(provider);
    }

    public static void injectCoreSession(IdDocumentCaptureSession idDocumentCaptureSession, DocumentCaptureCoreSession documentCaptureCoreSession) {
        idDocumentCaptureSession.coreSession = documentCaptureCoreSession;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(IdDocumentCaptureSession idDocumentCaptureSession) {
        injectCoreSession(idDocumentCaptureSession, this.coreSessionProvider.get());
    }
}
