package com.yoti.mobile.android.liveness.domain;

import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import com.yoti.mobile.android.yotidocs.common.SingleUseCase;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001a\b\u0007\u0012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u000bR\u0019\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\b\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/domain/CreateLivenessResourceInteractor;", "Lcom/yoti/mobile/android/yotidocs/common/SingleUseCase;", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;", "", "livenessResourceCreationRepository", "Lcom/yoti/mobile/android/liveness/domain/ILivenessResourceCreationRepository;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Lcom/yoti/mobile/android/liveness/domain/ILivenessResourceCreationRepository;)V", "buildUseCase", "Lio/reactivex/Single;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "(Lkotlin/Unit;)Lio/reactivex/Single;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class CreateLivenessResourceInteractor extends SingleUseCase<ILivenessResourceEntity, Unit> {
    private final ILivenessResourceCreationRepository<ILivenessResourceEntity> livenessResourceCreationRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public CreateLivenessResourceInteractor(ILivenessResourceCreationRepository<ILivenessResourceEntity> livenessResourceCreationRepository) {
        super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(livenessResourceCreationRepository, "livenessResourceCreationRepository");
        this.livenessResourceCreationRepository = livenessResourceCreationRepository;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.SingleUseCase
    public Single<ILivenessResourceEntity> buildUseCase(Unit params) {
        return this.livenessResourceCreationRepository.createLivenessResource();
    }
}
