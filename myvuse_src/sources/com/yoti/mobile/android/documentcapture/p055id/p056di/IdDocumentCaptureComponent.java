package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.documentcapture.p055id.view.IdDocumentCaptureActivity;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentPageReviewFragment;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanFragment;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.automation.AutomationScanFragment;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.DocumentTextExtractionErrorFragment;
import com.yoti.mobile.android.documentcapture.p055id.view.verify.VerifyYourDetailsFragment;
import com.yoti.mobile.android.yotisdkcore.feature.FeatureComponent;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Component(modules = {IdDocumentCaptureModule.class})
@Singleton
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentCaptureComponent;", "Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureComponent;", "inject", "", "session", "Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentCaptureSession;", "featureActivity", "Lcom/yoti/mobile/android/documentcapture/id/view/IdDocumentCaptureActivity;", "documentPageReviewFragment", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentPageReviewFragment;", "scanFragment", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanFragment;", "automationScanFragment", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/automation/AutomationScanFragment;", "documentTextExtractionErrorFragment", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/DocumentTextExtractionErrorFragment;", "fragment", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/VerifyYourDetailsFragment;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IdDocumentCaptureComponent extends FeatureComponent {
    void inject(IdDocumentCaptureSession session);

    void inject(IdDocumentCaptureActivity featureActivity);

    void inject(DocumentPageReviewFragment documentPageReviewFragment);

    void inject(DocumentScanFragment scanFragment);

    void inject(AutomationScanFragment automationScanFragment);

    void inject(DocumentTextExtractionErrorFragment documentTextExtractionErrorFragment);

    void inject(VerifyYourDetailsFragment fragment);
}
