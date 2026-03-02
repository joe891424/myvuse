package com.yoti.mobile.android.liveness.zoom.data;

import com.yoti.mobile.android.liveness.domain.ILivenessResourceCreationRepository;
import com.yoti.mobile.android.liveness.zoom.data.remote.LivenessFaceTecResourceCreationService;
import com.yoti.mobile.android.liveness.zoom.data.remote.model.LivenessFaceTecResource;
import com.yoti.mobile.android.liveness.zoom.data.remote.model.LivenessFaceTecResourceRequestParams;
import com.yoti.mobile.android.liveness.zoom.domain.model.LivenessFaceTecResourceEntity;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import com.yoti.mobile.android.yotidocs.common.extension.SingleKt;
import com.yoti.mobile.android.yotisdkcore.core.p085di.RequirementId;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00020\u00020\rH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/data/LivenessFaceTecResourceCreationRepository;", "Lcom/yoti/mobile/android/liveness/domain/ILivenessResourceCreationRepository;", "Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecResourceEntity;", "requirementId", "", "livenessResourceCreationService", "Lcom/yoti/mobile/android/liveness/zoom/data/remote/LivenessFaceTecResourceCreationService;", "livenessResourceMapper", "Lcom/yoti/mobile/android/liveness/zoom/data/LivenessFaceTecResourceToEntityMapper;", "exceptionToEntityMapper", "Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;", "(Ljava/lang/String;Lcom/yoti/mobile/android/liveness/zoom/data/remote/LivenessFaceTecResourceCreationService;Lcom/yoti/mobile/android/liveness/zoom/data/LivenessFaceTecResourceToEntityMapper;Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;)V", "createLivenessResource", "Lio/reactivex/Single;", "kotlin.jvm.PlatformType", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessFaceTecResourceCreationRepository implements ILivenessResourceCreationRepository<LivenessFaceTecResourceEntity> {
    private final RemoteExceptionToEntityMapper exceptionToEntityMapper;
    private final LivenessFaceTecResourceCreationService livenessResourceCreationService;
    private final LivenessFaceTecResourceToEntityMapper livenessResourceMapper;
    private final String requirementId;

    @Inject
    public LivenessFaceTecResourceCreationRepository(@RequirementId String requirementId, LivenessFaceTecResourceCreationService livenessResourceCreationService, LivenessFaceTecResourceToEntityMapper livenessResourceMapper, RemoteExceptionToEntityMapper exceptionToEntityMapper) {
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        Intrinsics.checkNotNullParameter(livenessResourceCreationService, "livenessResourceCreationService");
        Intrinsics.checkNotNullParameter(livenessResourceMapper, "livenessResourceMapper");
        Intrinsics.checkNotNullParameter(exceptionToEntityMapper, "exceptionToEntityMapper");
        this.requirementId = requirementId;
        this.livenessResourceCreationService = livenessResourceCreationService;
        this.livenessResourceMapper = livenessResourceMapper;
        this.exceptionToEntityMapper = exceptionToEntityMapper;
    }

    @Override // com.yoti.mobile.android.liveness.domain.ILivenessResourceCreationRepository
    public Single<LivenessFaceTecResourceEntity> createLivenessResource() {
        Single<LivenessFaceTecResource> singleExecute = this.livenessResourceCreationService.execute(new LivenessFaceTecResourceRequestParams(null, this.requirementId, 1, null));
        final LivenessFaceTecResourceToEntityMapper livenessFaceTecResourceToEntityMapper = this.livenessResourceMapper;
        Single<R> map = singleExecute.map(new Function() { // from class: com.yoti.mobile.android.liveness.zoom.data.LivenessFaceTecResourceCreationRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return livenessFaceTecResourceToEntityMapper.map((LivenessFaceTecResource) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "livenessResourceCreation…essResourceMapper :: map)");
        return SingleKt.onErrorMapToErrorEntity(map, this.exceptionToEntityMapper);
    }
}
