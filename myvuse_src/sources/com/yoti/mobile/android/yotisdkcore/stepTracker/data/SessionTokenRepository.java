package com.yoti.mobile.android.yotisdkcore.stepTracker.data;

import com.yoti.mobile.android.remote.CompletableService;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import com.yoti.mobile.android.yotidocs.common.extension.CompletableKt;
import com.yoti.mobile.android.yotisdkcore.stepTracker.data.remote.DeleteSessionTokenService;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.ISessionTokenRepository;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.data.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/data/SessionTokenRepository;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/ISessionTokenRepository;", "deleteSessionTokenService", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/data/remote/DeleteSessionTokenService;", "remoteExceptionToEntityMapper", "Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/data/remote/DeleteSessionTokenService;Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;)V", "deleteSessionToken", "Lio/reactivex/Completable;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SessionTokenRepository implements ISessionTokenRepository {

    /* JADX INFO: renamed from: a */
    private final DeleteSessionTokenService f7622a;

    /* JADX INFO: renamed from: b */
    private final RemoteExceptionToEntityMapper f7623b;

    @Inject
    public SessionTokenRepository(DeleteSessionTokenService deleteSessionTokenService, RemoteExceptionToEntityMapper remoteExceptionToEntityMapper) {
        Intrinsics.checkNotNullParameter(deleteSessionTokenService, "deleteSessionTokenService");
        Intrinsics.checkNotNullParameter(remoteExceptionToEntityMapper, "remoteExceptionToEntityMapper");
        this.f7622a = deleteSessionTokenService;
        this.f7623b = remoteExceptionToEntityMapper;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.domain.ISessionTokenRepository
    /* JADX INFO: renamed from: a */
    public Completable mo5131a() {
        return CompletableKt.onErrorMapToErrorEntity(CompletableService.execute$default(this.f7622a, null, 1, null), this.f7623b);
    }
}
