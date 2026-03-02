package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreSession;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentCaptureSession_MembersInjector implements MembersInjector<SupDocumentCaptureSession> {
    private final Provider<DocumentCaptureCoreSession> coreSessionProvider;

    public SupDocumentCaptureSession_MembersInjector(Provider<DocumentCaptureCoreSession> provider) {
        this.coreSessionProvider = provider;
    }

    public static MembersInjector<SupDocumentCaptureSession> create(Provider<DocumentCaptureCoreSession> provider) {
        return new SupDocumentCaptureSession_MembersInjector(provider);
    }

    public static void injectCoreSession(SupDocumentCaptureSession supDocumentCaptureSession, DocumentCaptureCoreSession documentCaptureCoreSession) {
        supDocumentCaptureSession.coreSession = documentCaptureCoreSession;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SupDocumentCaptureSession supDocumentCaptureSession) {
        injectCoreSession(supDocumentCaptureSession, this.coreSessionProvider.get());
    }
}
