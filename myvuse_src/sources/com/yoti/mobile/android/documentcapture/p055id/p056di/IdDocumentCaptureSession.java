package com.yoti.mobile.android.documentcapture.p055id.p056di;

import android.app.Activity;
import android.content.Context;
import com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreSession;
import com.yoti.mobile.android.documentcapture.p055id.view.IdDocumentCaptureActivity;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.SingleComponentFeatureSession;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0014R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentCaptureSession;", "Lcom/yoti/mobile/android/yotisdkcore/feature/SingleComponentFeatureSession;", "Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentCaptureComponent;", "Lcom/yoti/mobile/android/documentcapture/id/view/IdDocumentCaptureActivity;", "()V", "coreSession", "Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreSession;", "getCoreSession", "()Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreSession;", "setCoreSession", "(Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreSession;)V", "featureConfigurationKey", "", "getFeatureConfigurationKey", "()Ljava/lang/String;", "idDocumentCaptureComponent", "buildFeatureComponent", "activity", "Landroid/app/Activity;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "buildIdDocumentCaptureComponent", "appContext", "Landroid/content/Context;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "destroy", "", "Companion", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentCaptureSession extends SingleComponentFeatureSession<IdDocumentCaptureComponent, IdDocumentCaptureActivity> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile IdDocumentCaptureSession INSTANCE;

    @Inject
    public DocumentCaptureCoreSession coreSession;
    private IdDocumentCaptureComponent idDocumentCaptureComponent;

    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentCaptureSession$Companion;", "", "()V", "value", "Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentCaptureSession;", "INSTANCE", "setINSTANCE", "(Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentCaptureSession;)V", "instance", "getInstance", "()Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentCaptureSession;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setINSTANCE(IdDocumentCaptureSession idDocumentCaptureSession) {
            synchronized (this) {
                IdDocumentCaptureSession.INSTANCE = idDocumentCaptureSession;
            }
        }

        public final IdDocumentCaptureSession getInstance() {
            IdDocumentCaptureSession idDocumentCaptureSession = IdDocumentCaptureSession.INSTANCE;
            if (idDocumentCaptureSession == null) {
                synchronized (this) {
                    idDocumentCaptureSession = new IdDocumentCaptureSession(null);
                    IdDocumentCaptureSession.INSTANCE.setINSTANCE(idDocumentCaptureSession);
                }
            }
            return idDocumentCaptureSession;
        }
    }

    private IdDocumentCaptureSession() {
        super(Reflection.getOrCreateKotlinClass(IdDocumentCaptureActivity.class));
    }

    public /* synthetic */ IdDocumentCaptureSession(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final IdDocumentCaptureComponent buildIdDocumentCaptureComponent(Context appContext, DocumentCaptureConfiguration featureConfiguration) {
        IdDocumentCaptureComponent idDocumentCaptureComponentBuild = DaggerIdDocumentCaptureComponent.builder().idDocumentCaptureModule(new IdDocumentCaptureModule(featureConfiguration)).countryHelperModule(new CountryHelperModule(appContext)).resourceConfigurationModule(new ResourceConfigurationModule(appContext, featureConfiguration.getRequirementId())).commonModule(new CommonModule(appContext)).remoteModule(new RemoteModule(featureConfiguration.getSession())).build();
        Intrinsics.checkNotNullExpressionValue(idDocumentCaptureComponentBuild, "builder()\n            .i…on))\n            .build()");
        return idDocumentCaptureComponentBuild;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.feature.FeatureSession
    protected void destroy() {
        getCoreSession().destroy();
        INSTANCE.setINSTANCE(null);
    }

    public final DocumentCaptureCoreSession getCoreSession() {
        DocumentCaptureCoreSession documentCaptureCoreSession = this.coreSession;
        if (documentCaptureCoreSession != null) {
            return documentCaptureCoreSession;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coreSession");
        return null;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.feature.FeatureSession
    /* JADX INFO: renamed from: getFeatureConfigurationKey */
    protected String getF7754b() {
        return "IdDocumentCaptureSession.featureConfiguration";
    }

    public final void setCoreSession(DocumentCaptureCoreSession documentCaptureCoreSession) {
        Intrinsics.checkNotNullParameter(documentCaptureCoreSession, "<set-?>");
        this.coreSession = documentCaptureCoreSession;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.yotisdkcore.feature.SingleComponentFeatureSession
    public IdDocumentCaptureComponent buildFeatureComponent(Activity activity, IFeatureConfiguration featureConfiguration) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Context appContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        IdDocumentCaptureComponent idDocumentCaptureComponentBuildIdDocumentCaptureComponent = buildIdDocumentCaptureComponent(appContext, (DocumentCaptureConfiguration) featureConfiguration);
        this.idDocumentCaptureComponent = idDocumentCaptureComponentBuildIdDocumentCaptureComponent;
        if (idDocumentCaptureComponentBuildIdDocumentCaptureComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("idDocumentCaptureComponent");
            idDocumentCaptureComponentBuildIdDocumentCaptureComponent = null;
        }
        idDocumentCaptureComponentBuildIdDocumentCaptureComponent.inject(this);
        getCoreSession().buildDocumentCaptureCoreComponent();
        IdDocumentCaptureComponent idDocumentCaptureComponent = this.idDocumentCaptureComponent;
        if (idDocumentCaptureComponent != null) {
            return idDocumentCaptureComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("idDocumentCaptureComponent");
        return null;
    }
}
