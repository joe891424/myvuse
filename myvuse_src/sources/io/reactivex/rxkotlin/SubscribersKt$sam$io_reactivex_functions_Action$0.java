package io.reactivex.rxkotlin;

import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: subscribers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 15})
final class SubscribersKt$sam$io_reactivex_functions_Action$0 implements Action {
    private final /* synthetic */ Function0 function;

    SubscribersKt$sam$io_reactivex_functions_Action$0(Function0 function0) {
        this.function = function0;
    }

    @Override // io.reactivex.functions.Action
    public final /* synthetic */ void run() {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(), "invoke(...)");
    }
}
