package com.yoti.mobile.android.yotidocs.common.extension;

import androidx.exifinterface.media.ExifInterface;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsError;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¨\u0006\u0007"}, m5598d2 = {"onErrorMapToErrorEntity", "Lio/reactivex/Flowable;", ExifInterface.GPS_DIRECTION_TRUE, "mapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "common_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FlowableKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static final Publisher m5088a(Mapper mapper, Throwable error) {
        Intrinsics.checkNotNullParameter(mapper, "$mapper");
        Intrinsics.checkNotNullParameter(error, "error");
        return Flowable.error((Throwable) mapper.map(error));
    }

    public static final <T> Flowable<T> onErrorMapToErrorEntity(Flowable<T> flowable, final Mapper<? super Throwable, ? extends YotiDocsError> mapper) {
        Intrinsics.checkNotNullParameter(flowable, "<this>");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Flowable<T> onErrorMapToErrorEntity = flowable.onErrorResumeNext(new Function() { // from class: com.yoti.mobile.android.yotidocs.common.extension.FlowableKt$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FlowableKt.m5088a(mapper, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorMapToErrorEntity, "onErrorMapToErrorEntity");
        return onErrorMapToErrorEntity;
    }
}
