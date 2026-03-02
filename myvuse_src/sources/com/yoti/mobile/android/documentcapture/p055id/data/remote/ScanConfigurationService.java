package com.yoti.mobile.android.documentcapture.p055id.data.remote;

import com.yoti.mobile.android.documentcapture.data.remote.model.ScanConfigurationRequestParams;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.ScanConfiguration;
import com.yoti.mobile.android.remote.SingleService;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/ScanConfigurationService;", "Lcom/yoti/mobile/android/remote/SingleService;", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/ScanConfiguration;", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/ScanConfigurationRequestParams;", "apiService", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/DocumentCaptureApiService;", "(Lcom/yoti/mobile/android/documentcapture/id/data/remote/DocumentCaptureApiService;)V", "buildRequest", "Lio/reactivex/Single;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ScanConfigurationService extends SingleService<ScanConfiguration, ScanConfigurationRequestParams> {
    private final DocumentCaptureApiService apiService;

    @Inject
    public ScanConfigurationService(DocumentCaptureApiService apiService) {
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        this.apiService = apiService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.remote.SingleService
    public Single<ScanConfiguration> buildRequest(ScanConfigurationRequestParams params) {
        Single<ScanConfiguration> scanConfiguration;
        if (params != null && (scanConfiguration = this.apiService.getScanConfiguration(params)) != null) {
            return scanConfiguration;
        }
        Single<ScanConfiguration> singleError = Single.error(new IllegalArgumentException("Session Id and SessionToken are mandatory to do the execute"));
        Intrinsics.checkNotNullExpressionValue(singleError, "error(IllegalArgumentExc…tory to do the execute\"))");
        return singleError;
    }
}
