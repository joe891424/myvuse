package com.yoti.mobile.android.liveness.zoom.data.remote;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yoti.mobile.android.liveness.data.remote.model.LivenessUploadResponse;
import com.yoti.mobile.android.liveness.zoom.data.remote.model.LivenessFaceTecResource;
import com.yoti.mobile.android.liveness.zoom.data.remote.model.LivenessFaceTecResourceRequestParams;
import com.yoti.mobile.android.remote.RemoteDefsKt;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J&\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\bH'J\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u0011H'¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/data/remote/LivenessFaceTecApiService;", "", "createLivenessFaceTecFacemap", "Lio/reactivex/Single;", "Lcom/yoti/mobile/android/liveness/data/remote/model/LivenessUploadResponse;", "resourceId", "", "facemap", "Lokhttp3/MultipartBody$Part;", "createLivenessFaceTecFrame", "Lio/reactivex/Completable;", "pageNumber", "", TypedValues.AttributesType.S_FRAME, "createLivenessFaceTecResource", "Lcom/yoti/mobile/android/liveness/zoom/data/remote/model/LivenessFaceTecResource;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "Lcom/yoti/mobile/android/liveness/zoom/data/remote/model/LivenessFaceTecResourceRequestParams;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface LivenessFaceTecApiService {
    @POST(LivenessFaceTecApiDefsKt.URL_UPLOAD_LIVENESS_FACETEC_FACEMAP)
    @Multipart
    Single<LivenessUploadResponse> createLivenessFaceTecFacemap(@Path(RemoteDefsKt.PATH_RESOURCE_ID_KEY) String resourceId, @Part MultipartBody.Part facemap);

    @PUT(LivenessFaceTecApiDefsKt.URL_UPLOAD_LIVENESS_FACETEC_FRAME)
    @Multipart
    Completable createLivenessFaceTecFrame(@Path(RemoteDefsKt.PATH_RESOURCE_ID_KEY) String resourceId, @Path(RemoteDefsKt.PATH_PAGE_INDEX_KEY) int pageNumber, @Part MultipartBody.Part frame);

    @POST(LivenessFaceTecApiDefsKt.URL_FACETEC_LIVENESS_RESOURCE_CREATION)
    Single<LivenessFaceTecResource> createLivenessFaceTecResource(@Body LivenessFaceTecResourceRequestParams params);
}
