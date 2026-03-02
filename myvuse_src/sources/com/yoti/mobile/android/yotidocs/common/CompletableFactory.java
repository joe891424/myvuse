package com.yoti.mobile.android.yotidocs.common;

import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/CompletableFactory;", "", "()V", "create", "Lio/reactivex/Completable;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class CompletableFactory {
    public static final CompletableFactory INSTANCE = new CompletableFactory();

    private CompletableFactory() {
    }

    public static /* synthetic */ Completable create$default(CompletableFactory completableFactory, Exception exc, int i, Object obj) {
        if ((i & 1) != 0) {
            exc = null;
        }
        return completableFactory.create(exc);
    }

    public final Completable create(Exception exception) {
        Completable completableComplete;
        if (exception == null || (completableComplete = Completable.error(exception)) == null) {
            completableComplete = Completable.complete();
        }
        Intrinsics.checkNotNullExpressionValue(completableComplete, "exception?.let {\n       …?: Completable.complete()");
        return completableComplete;
    }
}
