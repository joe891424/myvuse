package com.yoti.mobile.android.yotisdkcore.core.data.remote;

import com.yoti.mobile.android.remote.SingleService;
import com.yoti.mobile.android.yotisdkcore.core.data.model.SessionConfiguration;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/remote/SessionConfigurationService;", "Lcom/yoti/mobile/android/remote/SingleService;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/SessionConfiguration;", "Ljava/lang/Void;", "sdkCoreApiService", "Lcom/yoti/mobile/android/yotisdkcore/core/data/remote/SdkCoreApiService;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/remote/SdkCoreApiService;)V", "buildRequest", "Lio/reactivex/Single;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SessionConfigurationService extends SingleService<SessionConfiguration, Void> {
    private final SdkCoreApiService sdkCoreApiService;

    @Inject
    public SessionConfigurationService(SdkCoreApiService sdkCoreApiService) {
        Intrinsics.checkNotNullParameter(sdkCoreApiService, "sdkCoreApiService");
        this.sdkCoreApiService = sdkCoreApiService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.remote.SingleService
    public Single<SessionConfiguration> buildRequest(Void params) {
        return this.sdkCoreApiService.getSessionConfiguration();
    }
}
