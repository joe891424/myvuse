package com.yoti.mobile.android.documentcapture.sup.p057di;

import android.app.Activity;
import android.content.Context;
import com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreSession;
import com.yoti.mobile.android.documentcapture.sup.view.SupDocumentCaptureActivity;
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
@Metadata(m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0014R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/di/SupDocumentCaptureSession;", "Lcom/yoti/mobile/android/yotisdkcore/feature/SingleComponentFeatureSession;", "Lcom/yoti/mobile/android/documentcapture/sup/di/SupDocumentCaptureComponent;", "Lcom/yoti/mobile/android/documentcapture/sup/view/SupDocumentCaptureActivity;", "()V", "coreSession", "Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreSession;", "getCoreSession", "()Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreSession;", "setCoreSession", "(Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreSession;)V", "featureConfigurationKey", "", "getFeatureConfigurationKey", "()Ljava/lang/String;", "buildFeatureComponent", "activity", "Landroid/app/Activity;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "buildNonIdDocumentCaptureComponent", "appContext", "Landroid/content/Context;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "destroy", "", "Companion", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentCaptureSession extends SingleComponentFeatureSession<SupDocumentCaptureComponent, SupDocumentCaptureActivity> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile SupDocumentCaptureSession INSTANCE;

    @Inject
    public DocumentCaptureCoreSession coreSession;

    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/di/SupDocumentCaptureSession$Companion;", "", "()V", "value", "Lcom/yoti/mobile/android/documentcapture/sup/di/SupDocumentCaptureSession;", "INSTANCE", "setINSTANCE", "(Lcom/yoti/mobile/android/documentcapture/sup/di/SupDocumentCaptureSession;)V", "instance", "getInstance", "()Lcom/yoti/mobile/android/documentcapture/sup/di/SupDocumentCaptureSession;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setINSTANCE(SupDocumentCaptureSession supDocumentCaptureSession) {
            synchronized (this) {
                SupDocumentCaptureSession.INSTANCE = supDocumentCaptureSession;
            }
        }

        public final SupDocumentCaptureSession getInstance() {
            SupDocumentCaptureSession supDocumentCaptureSession = SupDocumentCaptureSession.INSTANCE;
            if (supDocumentCaptureSession == null) {
                synchronized (this) {
                    supDocumentCaptureSession = new SupDocumentCaptureSession(null);
                    SupDocumentCaptureSession.INSTANCE.setINSTANCE(supDocumentCaptureSession);
                }
            }
            return supDocumentCaptureSession;
        }
    }

    private SupDocumentCaptureSession() {
        super(Reflection.getOrCreateKotlinClass(SupDocumentCaptureActivity.class));
    }

    public /* synthetic */ SupDocumentCaptureSession(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final SupDocumentCaptureComponent buildNonIdDocumentCaptureComponent(Context appContext, DocumentCaptureConfiguration featureConfiguration) {
        SupDocumentCaptureComponent supDocumentCaptureComponentBuild = DaggerSupDocumentCaptureComponent.builder().commonModule(new CommonModule(appContext)).remoteModule(new RemoteModule(featureConfiguration.getSession())).countryHelperModule(new CountryHelperModule(appContext)).resourceConfigurationModule(new ResourceConfigurationModule(appContext, featureConfiguration.getRequirementId())).supDocumentCaptureModule(new SupDocumentCaptureModule(featureConfiguration)).build();
        Intrinsics.checkNotNullExpressionValue(supDocumentCaptureComponentBuild, "builder()\n            .c…on))\n            .build()");
        return supDocumentCaptureComponentBuild;
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
        return "SupDocumentCaptureSession.featureConfiguration";
    }

    public final void setCoreSession(DocumentCaptureCoreSession documentCaptureCoreSession) {
        Intrinsics.checkNotNullParameter(documentCaptureCoreSession, "<set-?>");
        this.coreSession = documentCaptureCoreSession;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.yotisdkcore.feature.SingleComponentFeatureSession
    public SupDocumentCaptureComponent buildFeatureComponent(Activity activity, IFeatureConfiguration featureConfiguration) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Context appContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        SupDocumentCaptureComponent supDocumentCaptureComponentBuildNonIdDocumentCaptureComponent = buildNonIdDocumentCaptureComponent(appContext, (DocumentCaptureConfiguration) featureConfiguration);
        supDocumentCaptureComponentBuildNonIdDocumentCaptureComponent.inject(this);
        getCoreSession().buildDocumentCaptureCoreComponent();
        return supDocumentCaptureComponentBuildNonIdDocumentCaptureComponent;
    }
}
