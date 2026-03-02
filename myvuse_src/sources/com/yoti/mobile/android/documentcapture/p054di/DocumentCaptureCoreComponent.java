package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment;
import com.yoti.mobile.android.documentcapture.view.selection.CountrySelectionFragment;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment;
import com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadErrorFragment;
import com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadFragment;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Component(modules = {DocumentCaptureCoreModule.class})
@Singleton
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreComponent;", "", "inject", "", "additionalInstructionsFragment", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsFragment;", "educationalFragment", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalFragment;", "requirementsFragment", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsFragment;", "countryListFragment", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionFragment;", "configurationFragment", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionFragment;", "errorFragment", "Lcom/yoti/mobile/android/documentcapture/view/upload/DocumentUploadErrorFragment;", "fragment", "Lcom/yoti/mobile/android/documentcapture/view/upload/DocumentUploadFragment;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface DocumentCaptureCoreComponent {
    void inject(AdditionalInstructionsFragment additionalInstructionsFragment);

    void inject(DocumentEducationalFragment educationalFragment);

    void inject(DocumentRequirementsFragment requirementsFragment);

    void inject(CountrySelectionFragment countryListFragment);

    void inject(DocumentSelectionFragment configurationFragment);

    void inject(DocumentUploadErrorFragment errorFragment);

    void inject(DocumentUploadFragment fragment);
}
