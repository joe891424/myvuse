package com.yoti.mobile.android.commonui.extension;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Lifecycle.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aE\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\u0010\n\u001aE\u0010\u000b\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\u0010\n¨\u0006\f"}, m5598d2 = {"observe", "", ExifInterface.GPS_DIRECTION_TRUE, "", "L", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LifecycleOwner;", "liveData", "body", "Lkotlin/Function1;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function1;)V", "observeOnce", "commonUI_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LifecycleKt {
    public static final <T, L extends LiveData<T>> void observe(LifecycleOwner lifecycleOwner, L liveData, final Function1<? super T, Unit> body) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(body, "body");
        liveData.observe(lifecycleOwner, new Observer() { // from class: com.yoti.mobile.android.commonui.extension.LifecycleKt$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LifecycleKt.m6798observe$lambda0(body, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: observe$lambda-0, reason: not valid java name */
    public static final void m6798observe$lambda0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final <T, L extends LiveData<T>> void observeOnce(final LifecycleOwner lifecycleOwner, final L liveData, final Function1<? super T, Unit> body) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(body, "body");
        liveData.observe(lifecycleOwner, new Observer() { // from class: com.yoti.mobile.android.commonui.extension.LifecycleKt$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LifecycleKt.m6799observeOnce$lambda1(body, liveData, lifecycleOwner, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: observeOnce$lambda-1, reason: not valid java name */
    public static final void m6799observeOnce$lambda1(Function1 body, LiveData liveData, LifecycleOwner this_observeOnce, Object obj) {
        Intrinsics.checkNotNullParameter(body, "$body");
        Intrinsics.checkNotNullParameter(liveData, "$liveData");
        Intrinsics.checkNotNullParameter(this_observeOnce, "$this_observeOnce");
        body.invoke(obj);
        liveData.removeObservers(this_observeOnce);
    }
}
