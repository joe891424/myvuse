package com.yoti.mobile.android.commons.async;

import com.salesforce.marketingcloud.UrlHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThreadScheduler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00020\u0007j\u0002`\bH&¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\u00020\u00022\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00020\u0007j\u0002`\bH&¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00020\u0007j\u0002`\bH\u0016¢\u0006\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/async/ThreadScheduler;", "Lkotlin/Any;", "", "cancelAllScheduled", "()V", "", "delayMs", "Lkotlin/Function0;", "Lcom/yoti/mobile/android/commons/async/Action;", UrlHandler.ACTION, "scheduleDelayed", "(JLkotlin/Function0;)V", "scheduleImmediate", "(Lkotlin/Function0;)V", "intervalMs", "scheduleRepeating", "commons-async_release"}, m5599k = 1, m5600mv = {1, 1, 15}, m5601pn = "", m5602xi = 0, m5603xs = "")
public interface ThreadScheduler {

    /* JADX INFO: compiled from: ThreadScheduler.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 1, 15}, m5601pn = "", m5602xi = 0, m5603xs = "")
    public static final class DefaultImpls {
        public static void scheduleRepeating(final ThreadScheduler threadScheduler, final long j, final Function0<Unit> action) {
            Intrinsics.checkParameterIsNotNull(action, "action");
            threadScheduler.scheduleImmediate(new Function0<Unit>() { // from class: com.yoti.mobile.android.commons.async.ThreadScheduler.scheduleRepeating.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public void invoke2() {
                    action.invoke();
                    ThreadScheduler.this.scheduleDelayed(j, this);
                }
            });
        }
    }

    void cancelAllScheduled();

    void scheduleDelayed(long j, Function0<Unit> function0);

    void scheduleImmediate(Function0<Unit> function0);

    void scheduleRepeating(long j, Function0<Unit> function0);
}
