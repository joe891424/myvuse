package com.yoti.mobile.android.commons.async;

import android.os.Handler;
import android.os.Looper;
import com.salesforce.marketingcloud.UrlHandler;
import com.yoti.mobile.android.commons.async.ThreadScheduler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LooperThreadScheduler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00020\u0007j\u0002`\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\u00020\u00022\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00020\u0007j\u0002`\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/async/LooperThreadScheduler;", "Lcom/yoti/mobile/android/commons/async/ThreadScheduler;", "", "cancelAllScheduled", "()V", "", "delayMs", "Lkotlin/Function0;", "Lcom/yoti/mobile/android/commons/async/Action;", UrlHandler.ACTION, "scheduleDelayed", "(JLkotlin/Function0;)V", "scheduleImmediate", "(Lkotlin/Function0;)V", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Landroid/os/Looper;", "looper", "<init>", "(Landroid/os/Looper;)V", "commons-async_release"}, m5599k = 1, m5600mv = {1, 1, 15}, m5601pn = "", m5602xi = 0, m5603xs = "")
public final class LooperThreadScheduler implements ThreadScheduler {

    /* JADX INFO: renamed from: a */
    private final Handler f6497a;

    /* JADX WARN: Multi-variable type inference failed */
    public LooperThreadScheduler() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public LooperThreadScheduler(Looper looper) {
        Intrinsics.checkParameterIsNotNull(looper, "looper");
        this.f6497a = new Handler(looper);
    }

    @Override // com.yoti.mobile.android.commons.async.ThreadScheduler
    public void cancelAllScheduled() {
        this.f6497a.removeCallbacksAndMessages(null);
    }

    @Override // com.yoti.mobile.android.commons.async.ThreadScheduler
    public void scheduleDelayed(long j, Function0<Unit> action) {
        Intrinsics.checkParameterIsNotNull(action, "action");
        this.f6497a.postDelayed(new RunnableC4567a(action), j);
    }

    @Override // com.yoti.mobile.android.commons.async.ThreadScheduler
    public void scheduleImmediate(Function0<Unit> action) {
        Intrinsics.checkParameterIsNotNull(action, "action");
        this.f6497a.post(new RunnableC4567a(action));
    }

    @Override // com.yoti.mobile.android.commons.async.ThreadScheduler
    public void scheduleRepeating(long j, Function0<Unit> action) {
        Intrinsics.checkParameterIsNotNull(action, "action");
        ThreadScheduler.DefaultImpls.scheduleRepeating(this, j, action);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LooperThreadScheduler(Looper looper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            looper = Looper.getMainLooper();
            Intrinsics.checkExpressionValueIsNotNull(looper, "Looper.getMainLooper()");
        }
        this(looper);
    }
}
