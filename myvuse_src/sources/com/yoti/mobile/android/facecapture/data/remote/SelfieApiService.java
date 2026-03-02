package com.yoti.mobile.android.facecapture.data.remote;

import com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureResourceRequestParams;
import com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureResourceResponse;
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
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J(\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH'¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/data/remote/SelfieApiService;", "", "createFaceCaptureResource", "Lio/reactivex/Single;", "Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureResourceResponse;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureResourceRequestParams;", "uploadFaceCapture", "Lio/reactivex/Completable;", "resourceId", "", "faceCaptureImage", "Lokhttp3/MultipartBody$Part;", "securityContent", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface SelfieApiService {
    @POST(FaceCaptureApiDefsKt.URL_SELFIE_CAPTURE_RESOURCE_CREATION)
    Single<FaceCaptureResourceResponse> createFaceCaptureResource(@Body FaceCaptureResourceRequestParams params);

    @PUT(FaceCaptureApiDefsKt.URL_SELFIE_CAPTURE_UPLOAD)
    @Multipart
    Completable uploadFaceCapture(@Path(RemoteDefsKt.PATH_RESOURCE_ID_KEY) String resourceId, @Part MultipartBody.Part faceCaptureImage, @Part MultipartBody.Part securityContent);
}
