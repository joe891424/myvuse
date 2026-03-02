package com.yoti.mobile.android.documentcapture.sup.data.remote;

import com.yoti.mobile.android.documentcapture.data.remote.model.AssessmentsResults;
import com.yoti.mobile.android.documentcapture.data.remote.model.ScanConfigurationRequestParams;
import com.yoti.mobile.android.documentcapture.sup.data.remote.model.OcrData;
import com.yoti.mobile.android.documentcapture.sup.data.remote.model.SupDocumentScanConfiguration;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H'J2\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u000b2\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\f\u001a\u00020\u0007H'J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H'J\u001c\u0010\u0012\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0013\u001a\u00020\u0014H'J\u001c\u0010\u0015\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0016\u001a\u00020\u0017H'¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/data/remote/SupDocumentCaptureApiService;", "", "createDocumentFile", "Lio/reactivex/Completable;", "resourceId", "", "imageProperties", "Lokhttp3/MultipartBody$Part;", "file", "createDocumentImage", "pageNumber", "", "image", "getScanConfiguration", "Lio/reactivex/Single;", "Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/SupDocumentScanConfiguration;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "Lcom/yoti/mobile/android/documentcapture/data/remote/model/ScanConfigurationRequestParams;", "setAssessmentsResults", "results", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/AssessmentsResults;", "startTextExtractionTask", "ocrData", "Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/OcrData;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface SupDocumentCaptureApiService {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Completable createDocumentFile$default(SupDocumentCaptureApiService supDocumentCaptureApiService, String str, MultipartBody.Part part, MultipartBody.Part part2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDocumentFile");
            }
            if ((i & 2) != 0) {
                part = null;
            }
            return supDocumentCaptureApiService.createDocumentFile(str, part, part2);
        }

        public static /* synthetic */ Completable createDocumentImage$default(SupDocumentCaptureApiService supDocumentCaptureApiService, String str, int i, MultipartBody.Part part, MultipartBody.Part part2, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDocumentImage");
            }
            if ((i2 & 4) != 0) {
                part = null;
            }
            return supDocumentCaptureApiService.createDocumentImage(str, i, part, part2);
        }
    }

    @PUT(SupDocumentCaptureApiDefsKt.URL_UPLOAD_DOCUMENT_FILE)
    @Multipart
    Completable createDocumentFile(@Path(RemoteDefsKt.PATH_RESOURCE_ID_KEY) String resourceId, @Part MultipartBody.Part imageProperties, @Part MultipartBody.Part file);

    @PUT(SupDocumentCaptureApiDefsKt.URL_UPLOAD_DOCUMENT_IMAGE)
    @Multipart
    Completable createDocumentImage(@Path(RemoteDefsKt.PATH_RESOURCE_ID_KEY) String resourceId, @Path(RemoteDefsKt.PATH_PAGE_INDEX_KEY) int pageNumber, @Part MultipartBody.Part imageProperties, @Part MultipartBody.Part image);

    @POST(SupDocumentCaptureApiDefsKt.URL_SCAN_CONFIGURATION)
    Single<SupDocumentScanConfiguration> getScanConfiguration(@Body ScanConfigurationRequestParams params);

    @PUT(SupDocumentCaptureApiDefsKt.URL_SET_ASSESSMENTS_STATE)
    Completable setAssessmentsResults(@Path(RemoteDefsKt.PATH_RESOURCE_ID_KEY) String resourceId, @Body AssessmentsResults results);

    @PUT(SupDocumentCaptureApiDefsKt.URL_TEXT_EXTRACTION_TASK)
    Completable startTextExtractionTask(@Path(RemoteDefsKt.PATH_RESOURCE_ID_KEY) String resourceId, @Body OcrData ocrData);
}
