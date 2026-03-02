package com.yoti.mobile.android.yotisdkcore.stepTracker.domain;

import com.yoti.mobile.android.yotidocs.common.CompletableUseCase;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.domain.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B#\b\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/FinishSessionInteractor;", "Lcom/yoti/mobile/android/yotidocs/common/CompletableUseCase;", "", "tokenRepository", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/ISessionTokenRepository;", "sessionStatusRepository", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionStatusRepository;", "sessionConfigurationRepository", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionConfigurationRepository;", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/ISessionTokenRepository;Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionStatusRepository;Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionConfigurationRepository;)V", "buildUseCase", "Lio/reactivex/Completable;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "(Lkotlin/Unit;)Lio/reactivex/Completable;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FinishSessionInteractor extends CompletableUseCase<Unit> {

    /* JADX INFO: renamed from: a */
    private final ISessionTokenRepository f7684a;

    /* JADX INFO: renamed from: b */
    private final ISessionStatusRepository f7685b;

    /* JADX INFO: renamed from: c */
    private final ISessionConfigurationRepository f7686c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public FinishSessionInteractor(ISessionTokenRepository iSessionTokenRepository, ISessionStatusRepository sessionStatusRepository, ISessionConfigurationRepository sessionConfigurationRepository) {
        super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(sessionStatusRepository, "sessionStatusRepository");
        Intrinsics.checkNotNullParameter(sessionConfigurationRepository, "sessionConfigurationRepository");
        this.f7684a = iSessionTokenRepository;
        this.f7685b = sessionStatusRepository;
        this.f7686c = sessionConfigurationRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static final void m5167a(FinishSessionInteractor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f7685b.setSessionStatus(SessionStatusType.SESSION_FINISHED_BUT_STILL_OPEN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static final void m5168a(FinishSessionInteractor this$0, CompletableObserver completableObserver) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(completableObserver, "completableObserver");
        this$0.f7686c.clearSessionConfiguration();
        this$0.f7685b.setSessionStatus(SessionStatusType.SESSION_FINISHED_WITH_SUCCESS);
        completableObserver.onComplete();
    }

    @Override // com.yoti.mobile.android.yotidocs.common.CompletableUseCase
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Completable buildUseCase(Unit unit) {
        Completable completableMo5131a;
        ISessionTokenRepository iSessionTokenRepository = this.f7684a;
        Completable completableAndThen = (iSessionTokenRepository == null || (completableMo5131a = iSessionTokenRepository.mo5131a()) == null) ? null : completableMo5131a.andThen(new CompletableSource() { // from class: com.yoti.mobile.android.yotisdkcore.stepTracker.domain.a$$ExternalSyntheticLambda0
            @Override // io.reactivex.CompletableSource
            public final void subscribe(CompletableObserver completableObserver) {
                FinishSessionInteractor.m5168a(this.f$0, completableObserver);
            }
        });
        if (completableAndThen != null) {
            return completableAndThen;
        }
        Completable completableFromRunnable = Completable.fromRunnable(new Runnable() { // from class: com.yoti.mobile.android.yotisdkcore.stepTracker.domain.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FinishSessionInteractor.m5167a(this.f$0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(completableFromRunnable, "fromRunnable {\n        s…HED_BUT_STILL_OPEN)\n    }");
        return completableFromRunnable;
    }
}
