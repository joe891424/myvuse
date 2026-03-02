package io.reactivex.rxkotlin;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: disposable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0001H\u0086\u0002¨\u0006\u0007"}, m5598d2 = {"addTo", "Lio/reactivex/disposables/Disposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "plusAssign", "", "disposable", "rxkotlin"}, m5599k = 2, m5600mv = {1, 1, 15})
public final class DisposableKt {
    public static final void plusAssign(CompositeDisposable plusAssign, Disposable disposable) {
        Intrinsics.checkParameterIsNotNull(plusAssign, "$this$plusAssign");
        Intrinsics.checkParameterIsNotNull(disposable, "disposable");
        plusAssign.add(disposable);
    }

    public static final Disposable addTo(Disposable addTo, CompositeDisposable compositeDisposable) {
        Intrinsics.checkParameterIsNotNull(addTo, "$this$addTo");
        Intrinsics.checkParameterIsNotNull(compositeDisposable, "compositeDisposable");
        compositeDisposable.add(addTo);
        return addTo;
    }
}
