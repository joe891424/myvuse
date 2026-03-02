package com.yoti.mobile.android.facecapture.data;

import com.yoti.mobile.android.facecapture.data.remote.FaceCaptureResourceResponseToEntityMapper;
import com.yoti.mobile.android.facecapture.data.remote.IFaceCaptureApiService;
import com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureResourceRequestParams;
import com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureResourceResponse;
import com.yoti.mobile.android.facecapture.domain.model.FaceCaptureResourceEntity;
import com.yoti.mobile.android.liveness.domain.ILivenessResourceCreationRepository;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import com.yoti.mobile.android.yotidocs.common.extension.SingleKt;
import com.yoti.mobile.android.yotisdkcore.core.p085di.RequirementId;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/data/FaceCaptureResourceRepository;", "Lcom/yoti/mobile/android/liveness/domain/ILivenessResourceCreationRepository;", "Lcom/yoti/mobile/android/facecapture/domain/model/FaceCaptureResourceEntity;", "requirementId", "", "faceCaptureApiService", "Lcom/yoti/mobile/android/facecapture/data/remote/IFaceCaptureApiService;", "faceCaptureResourceResponseToEntityMapper", "Lcom/yoti/mobile/android/facecapture/data/remote/FaceCaptureResourceResponseToEntityMapper;", "exceptionToEntityMapper", "Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;", "(Ljava/lang/String;Lcom/yoti/mobile/android/facecapture/data/remote/IFaceCaptureApiService;Lcom/yoti/mobile/android/facecapture/data/remote/FaceCaptureResourceResponseToEntityMapper;Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;)V", "createLivenessResource", "Lio/reactivex/Single;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureResourceRepository implements ILivenessResourceCreationRepository<FaceCaptureResourceEntity> {
    private final RemoteExceptionToEntityMapper exceptionToEntityMapper;
    private final IFaceCaptureApiService faceCaptureApiService;
    private final FaceCaptureResourceResponseToEntityMapper faceCaptureResourceResponseToEntityMapper;
    private final String requirementId;

    @Inject
    public FaceCaptureResourceRepository(@RequirementId String requirementId, IFaceCaptureApiService faceCaptureApiService, FaceCaptureResourceResponseToEntityMapper faceCaptureResourceResponseToEntityMapper, RemoteExceptionToEntityMapper exceptionToEntityMapper) {
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        Intrinsics.checkNotNullParameter(faceCaptureApiService, "faceCaptureApiService");
        Intrinsics.checkNotNullParameter(faceCaptureResourceResponseToEntityMapper, "faceCaptureResourceResponseToEntityMapper");
        Intrinsics.checkNotNullParameter(exceptionToEntityMapper, "exceptionToEntityMapper");
        this.requirementId = requirementId;
        this.faceCaptureApiService = faceCaptureApiService;
        this.faceCaptureResourceResponseToEntityMapper = faceCaptureResourceResponseToEntityMapper;
        this.exceptionToEntityMapper = exceptionToEntityMapper;
    }

    @Override // com.yoti.mobile.android.liveness.domain.ILivenessResourceCreationRepository
    public Single<FaceCaptureResourceEntity> createLivenessResource() {
        Single<FaceCaptureResourceResponse> singleCreateFaceCaptureResource = this.faceCaptureApiService.createFaceCaptureResource(new FaceCaptureResourceRequestParams(this.requirementId));
        final FaceCaptureResourceResponseToEntityMapper faceCaptureResourceResponseToEntityMapper = this.faceCaptureResourceResponseToEntityMapper;
        Single<R> map = singleCreateFaceCaptureResource.map(new Function() { // from class: com.yoti.mobile.android.facecapture.data.FaceCaptureResourceRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return faceCaptureResourceResponseToEntityMapper.map((FaceCaptureResourceResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "faceCaptureApiService.cr…ponseToEntityMapper::map)");
        return SingleKt.onErrorMapToErrorEntity(map, this.exceptionToEntityMapper);
    }
}
