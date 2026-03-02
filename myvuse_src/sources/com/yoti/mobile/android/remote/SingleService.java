package com.yoti.mobile.android.remote;

import androidx.exifinterface.media.ExifInterface;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: compiled from: SingleService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00002\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0001H$¢\u0006\u0002\u0010\bJ\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\b¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/SingleService;", ExifInterface.GPS_DIRECTION_TRUE, "Params", "", "()V", "buildRequest", "Lio/reactivex/Single;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "(Ljava/lang/Object;)Lio/reactivex/Single;", "execute", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class SingleService<T, Params> {
    protected abstract Single<T> buildRequest(Params params);

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Single buildRequest$default(SingleService singleService, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildRequest");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        return singleService.buildRequest(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Single execute$default(SingleService singleService, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        return singleService.execute(obj);
    }

    public final Single<T> execute(Params params) {
        return buildRequest(params);
    }
}
