package com.yoti.mobile.android.facecapture.data.remote;

import com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureResourceRequestParams;
import com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureResourceResponse;
import com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureUploadResponse;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/data/remote/SelfieApiServiceAdapter;", "Lcom/yoti/mobile/android/facecapture/data/remote/IFaceCaptureApiService;", "apiService", "Lcom/yoti/mobile/android/facecapture/data/remote/SelfieApiService;", "(Lcom/yoti/mobile/android/facecapture/data/remote/SelfieApiService;)V", "createFaceCaptureResource", "Lio/reactivex/Single;", "Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureResourceResponse;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureResourceRequestParams;", "uploadFaceCapture", "Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureUploadResponse;", "resourceId", "", "faceCaptureImage", "Lokhttp3/MultipartBody$Part;", "securityContent", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SelfieApiServiceAdapter implements IFaceCaptureApiService {
    private final SelfieApiService apiService;

    @Inject
    public SelfieApiServiceAdapter(SelfieApiService apiService) {
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        this.apiService = apiService;
    }

    @Override // com.yoti.mobile.android.facecapture.data.remote.IFaceCaptureApiService
    public Single<FaceCaptureResourceResponse> createFaceCaptureResource(FaceCaptureResourceRequestParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return this.apiService.createFaceCaptureResource(params);
    }

    @Override // com.yoti.mobile.android.facecapture.data.remote.IFaceCaptureApiService
    public Single<FaceCaptureUploadResponse> uploadFaceCapture(String resourceId, MultipartBody.Part faceCaptureImage, MultipartBody.Part securityContent) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(faceCaptureImage, "faceCaptureImage");
        Single<FaceCaptureUploadResponse> singleDefault = this.apiService.uploadFaceCapture(resourceId, faceCaptureImage, securityContent).toSingleDefault(new FaceCaptureUploadResponse(null, true, 0));
        Intrinsics.checkNotNullExpressionValue(singleDefault, "apiService.uploadFaceCap…      )\n                )");
        return singleDefault;
    }
}
