package com.yoti.mobile.android.remote;

import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Completable;
import kotlin.Metadata;

/* JADX INFO: compiled from: CompletableService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000H$¢\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0007¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/CompletableService;", "Params", "", "()V", "buildRequest", "Lio/reactivex/Completable;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "(Ljava/lang/Object;)Lio/reactivex/Completable;", "execute", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class CompletableService<Params> {
    protected abstract Completable buildRequest(Params params);

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Completable buildRequest$default(CompletableService completableService, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildRequest");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        return completableService.buildRequest(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Completable execute$default(CompletableService completableService, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        return completableService.execute(obj);
    }

    public final Completable execute(Params params) {
        return buildRequest(params);
    }
}
