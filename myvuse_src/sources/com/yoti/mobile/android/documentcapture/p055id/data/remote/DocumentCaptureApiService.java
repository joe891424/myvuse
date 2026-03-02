package com.yoti.mobile.android.documentcapture.p055id.data.remote;

import com.yoti.mobile.android.documentcapture.data.remote.model.AssessmentsResults;
import com.yoti.mobile.android.documentcapture.data.remote.model.ScanConfigurationRequestParams;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.OcrResult;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.ScanConfiguration;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.TextExtractionResponse;
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
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH'J\u001c\u0010\u000b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\nH'J,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u0013H'J2\u0010\u0014\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\t\u001a\u00020\nH'J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\b\b\u0001\u0010\u0018\u001a\u00020\u0019H'J\u001c\u0010\u001a\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u001b\u001a\u00020\u001cH'¨\u0006\u001d"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/DocumentCaptureApiService;", "", "createDocumentFrame", "Lio/reactivex/Completable;", "resourceId", "", "pageNumber", "", "frameNumber", "image", "Lokhttp3/MultipartBody$Part;", "createDocumentNfc", "chipData", "createDocumentOCR", "Lio/reactivex/Single;", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse;", DocumentCaptureApiDefsKt.QUERY_PARAMETER_OVERRIDE_DOCUMENT_TYPE, "", "ocrData", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/OcrResult;", "createDocumentPage", "imageProperties", "getScanConfiguration", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/ScanConfiguration;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "Lcom/yoti/mobile/android/documentcapture/data/remote/model/ScanConfigurationRequestParams;", "setAssessmentsResults", "results", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/AssessmentsResults;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface DocumentCaptureApiService {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Completable createDocumentPage$default(DocumentCaptureApiService documentCaptureApiService, String str, int i, MultipartBody.Part part, MultipartBody.Part part2, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDocumentPage");
            }
            if ((i2 & 4) != 0) {
                part = null;
            }
            return documentCaptureApiService.createDocumentPage(str, i, part, part2);
        }
    }

    @PUT(DocumentCaptureApiDefsKt.URL_UPLOAD_DOCUMENT_FRAME)
    @Multipart
    Completable createDocumentFrame(@Path(RemoteDefsKt.PATH_RESOURCE_ID_KEY) String resourceId, @Path(RemoteDefsKt.PATH_PAGE_INDEX_KEY) int pageNumber, @Path(RemoteDefsKt.PATH_FRAME_INDEX_KEY) int frameNumber, @Part MultipartBody.Part image);

    @PUT(DocumentCaptureApiDefsKt.URL_UPLOAD_DOCUMENT_CHIPDATA)
    @Multipart
    Completable createDocumentNfc(@Path(RemoteDefsKt.PATH_RESOURCE_ID_KEY) String resourceId, @Part MultipartBody.Part chipData);

    @PUT(DocumentCaptureApiDefsKt.URL_UPLOAD_DOCUMENT_OCRDATA)
    Single<TextExtractionResponse> createDocumentOCR(@Path(RemoteDefsKt.PATH_RESOURCE_ID_KEY) String resourceId, @Query(DocumentCaptureApiDefsKt.QUERY_PARAMETER_OVERRIDE_DOCUMENT_TYPE) boolean overrideDocumentType, @Body OcrResult ocrData);

    @PUT(DocumentCaptureApiDefsKt.URL_UPLOAD_DOCUMENT_IMAGE)
    @Multipart
    Completable createDocumentPage(@Path(RemoteDefsKt.PATH_RESOURCE_ID_KEY) String resourceId, @Path(RemoteDefsKt.PATH_PAGE_INDEX_KEY) int pageNumber, @Part MultipartBody.Part imageProperties, @Part MultipartBody.Part image);

    @POST(DocumentCaptureApiDefsKt.URL_SCAN_CONFIGURATION)
    Single<ScanConfiguration> getScanConfiguration(@Body ScanConfigurationRequestParams params);

    @PUT(DocumentCaptureApiDefsKt.URL_SET_ASSESSMENTS_STATE)
    Completable setAssessmentsResults(@Path(RemoteDefsKt.PATH_RESOURCE_ID_KEY) String resourceId, @Body AssessmentsResults results);
}
