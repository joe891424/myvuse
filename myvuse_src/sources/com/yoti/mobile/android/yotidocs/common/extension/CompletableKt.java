package com.yoti.mobile.android.yotidocs.common.extension;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsError;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¨\u0006\u0006"}, m5598d2 = {"onErrorMapToErrorEntity", "Lio/reactivex/Completable;", "mapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "common_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class CompletableKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static final CompletableSource m5087a(Mapper mapper, Throwable error) {
        Intrinsics.checkNotNullParameter(mapper, "$mapper");
        Intrinsics.checkNotNullParameter(error, "error");
        return Completable.error((Throwable) mapper.map(error));
    }

    public static final Completable onErrorMapToErrorEntity(Completable completable, final Mapper<? super Throwable, ? extends YotiDocsError> mapper) {
        Intrinsics.checkNotNullParameter(completable, "<this>");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Completable onErrorMapToErrorEntity = completable.onErrorResumeNext(new Function() { // from class: com.yoti.mobile.android.yotidocs.common.extension.CompletableKt$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CompletableKt.m5087a(mapper, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorMapToErrorEntity, "onErrorMapToErrorEntity");
        return onErrorMapToErrorEntity;
    }
}
