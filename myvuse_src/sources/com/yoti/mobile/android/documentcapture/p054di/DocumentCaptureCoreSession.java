package com.yoti.mobile.android.documentcapture.p054di;

import android.content.Context;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreSession;", "", "appContext", "Landroid/content/Context;", "selectionDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentSelectionDependenciesProvider;", "scanDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentScanDependenciesProvider;", "uploadDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentUploadDependenciesProvider;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "(Landroid/content/Context;Lcom/yoti/mobile/android/documentcapture/di/IDocumentSelectionDependenciesProvider;Lcom/yoti/mobile/android/documentcapture/di/IDocumentScanDependenciesProvider;Lcom/yoti/mobile/android/documentcapture/di/IDocumentUploadDependenciesProvider;Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;)V", "featureComponent", "Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreComponent;", "getFeatureComponent", "()Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreComponent;", "setFeatureComponent", "(Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreComponent;)V", "buildDocumentCaptureCoreComponent", "", "destroy", "Companion", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentCaptureCoreSession {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile DocumentCaptureCoreSession INSTANCE;
    private final Context appContext;
    public DocumentCaptureCoreComponent featureComponent;
    private final DocumentCaptureConfiguration featureConfiguration;
    private final IDocumentScanDependenciesProvider scanDependenciesProvider;
    private final IDocumentSelectionDependenciesProvider selectionDependenciesProvider;
    private final IDocumentUploadDependenciesProvider uploadDependenciesProvider;

    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreSession$Companion;", "", "()V", "value", "Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreSession;", "INSTANCE", "setINSTANCE", "(Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreSession;)V", "instance", "getInstance", "()Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreSession;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setINSTANCE(DocumentCaptureCoreSession documentCaptureCoreSession) {
            synchronized (this) {
                DocumentCaptureCoreSession.INSTANCE = documentCaptureCoreSession;
            }
        }

        public final DocumentCaptureCoreSession getInstance() throws IllegalStateException {
            DocumentCaptureCoreSession documentCaptureCoreSession = DocumentCaptureCoreSession.INSTANCE;
            if (documentCaptureCoreSession != null) {
                return documentCaptureCoreSession;
            }
            throw new IllegalStateException("DocumentCaptureCoreSession class constructor has to be called before access to its instance");
        }
    }

    @Inject
    public DocumentCaptureCoreSession(Context appContext, IDocumentSelectionDependenciesProvider selectionDependenciesProvider, IDocumentScanDependenciesProvider scanDependenciesProvider, IDocumentUploadDependenciesProvider uploadDependenciesProvider, DocumentCaptureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(selectionDependenciesProvider, "selectionDependenciesProvider");
        Intrinsics.checkNotNullParameter(scanDependenciesProvider, "scanDependenciesProvider");
        Intrinsics.checkNotNullParameter(uploadDependenciesProvider, "uploadDependenciesProvider");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.appContext = appContext;
        this.selectionDependenciesProvider = selectionDependenciesProvider;
        this.scanDependenciesProvider = scanDependenciesProvider;
        this.uploadDependenciesProvider = uploadDependenciesProvider;
        this.featureConfiguration = featureConfiguration;
        INSTANCE.setINSTANCE(this);
    }

    public final void buildDocumentCaptureCoreComponent() {
        DocumentCaptureCoreComponent documentCaptureCoreComponentBuild = DaggerDocumentCaptureCoreComponent.builder().documentCaptureCoreModule(new DocumentCaptureCoreModule(this.featureConfiguration)).resourceConfigurationModule(new ResourceConfigurationModule(this.appContext, this.featureConfiguration.getRequirementId())).selectionModule(new SelectionModule(this.selectionDependenciesProvider)).scanModule(new ScanModule(this.scanDependenciesProvider)).uploadModule(new UploadModule(this.uploadDependenciesProvider)).remoteModule(new RemoteModule(this.featureConfiguration.getSession())).commonModule(new CommonModule(this.appContext)).build();
        Intrinsics.checkNotNullExpressionValue(documentCaptureCoreComponentBuild, "builder()\n              …\n                .build()");
        setFeatureComponent(documentCaptureCoreComponentBuild);
    }

    public final void destroy() {
        INSTANCE.setINSTANCE(null);
    }

    public final DocumentCaptureCoreComponent getFeatureComponent() {
        DocumentCaptureCoreComponent documentCaptureCoreComponent = this.featureComponent;
        if (documentCaptureCoreComponent != null) {
            return documentCaptureCoreComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureComponent");
        return null;
    }

    public final void setFeatureComponent(DocumentCaptureCoreComponent documentCaptureCoreComponent) {
        Intrinsics.checkNotNullParameter(documentCaptureCoreComponent, "<set-?>");
        this.featureComponent = documentCaptureCoreComponent;
    }
}
