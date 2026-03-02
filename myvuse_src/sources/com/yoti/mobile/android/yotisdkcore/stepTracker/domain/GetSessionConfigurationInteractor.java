package com.yoti.mobile.android.yotisdkcore.stepTracker.domain;

import com.yoti.mobile.android.yotidocs.common.SingleUseCase;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.domain.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/GetSessionConfigurationInteractor;", "Lcom/yoti/mobile/android/yotidocs/common/SingleUseCase;", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity;", "Ljava/lang/Void;", "sessionConfigurationRepository", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionConfigurationRepository;", "filterProcessor", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/SessionConfigurationFilterProcessor;", "(Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionConfigurationRepository;Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/SessionConfigurationFilterProcessor;)V", "buildUseCase", "Lio/reactivex/Single;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class GetSessionConfigurationInteractor extends SingleUseCase<SessionConfigurationEntity, Void> {

    /* JADX INFO: renamed from: a */
    private final ISessionConfigurationRepository f7687a;

    /* JADX INFO: renamed from: b */
    private final SessionConfigurationFilterProcessor f7688b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public GetSessionConfigurationInteractor(ISessionConfigurationRepository sessionConfigurationRepository, SessionConfigurationFilterProcessor filterProcessor) {
        super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(sessionConfigurationRepository, "sessionConfigurationRepository");
        Intrinsics.checkNotNullParameter(filterProcessor, "filterProcessor");
        this.f7687a = sessionConfigurationRepository;
        this.f7688b = filterProcessor;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.SingleUseCase
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Single<SessionConfigurationEntity> buildUseCase(Void r3) {
        Single<SessionConfigurationEntity> sessionConfiguration = this.f7687a.getSessionConfiguration();
        final SessionConfigurationFilterProcessor sessionConfigurationFilterProcessor = this.f7688b;
        Single map = sessionConfiguration.map(new Function() { // from class: com.yoti.mobile.android.yotisdkcore.stepTracker.domain.b$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return sessionConfigurationFilterProcessor.m5171a((SessionConfigurationEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "sessionConfigurationRepo…ilterProcessor :: filter)");
        return map;
    }
}
