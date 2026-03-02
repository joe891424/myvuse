package com.yoti.mobile.android.yotisdkcore.core.data.remote;

import com.yoti.mobile.android.yotisdkcore.core.data.model.SessionConfiguration;
import io.reactivex.Single;
import kotlin.Metadata;
import retrofit2.http.GET;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/remote/SdkCoreApiService;", "", "getSessionConfiguration", "Lio/reactivex/Single;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/SessionConfiguration;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface SdkCoreApiService {
    @GET(SdkCoreApiServiceDefsKt.URL_SESSION_CONFIGURATION)
    Single<SessionConfiguration> getSessionConfiguration();
}
