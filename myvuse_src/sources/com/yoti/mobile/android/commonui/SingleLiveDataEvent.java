package com.yoti.mobile.android.commonui;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.yoti.mobile.android.commons.util.C4588L;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: SingleLiveDataEvent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0010*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0010B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0007J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\rH\u0017J\u0019\u0010\u000e\u001a\u00020\b2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0017¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/SingleLiveDataEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "value", "(Ljava/lang/Object;)V", "mPending", "Ljava/util/concurrent/atomic/AtomicBoolean;", NotificationCompat.CATEGORY_CALL, "", "observe", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "setValue", RsaJsonWebKey.FACTOR_CRT_COEFFICIENT, "Companion", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SingleLiveDataEvent<T> extends MutableLiveData<T> {
    private static final String TAG = "SingleLiveDataEvent";
    private final AtomicBoolean mPending;

    /* JADX WARN: Illegal instructions before constructor call */
    public SingleLiveDataEvent() {
        DefaultConstructorMarker defaultConstructorMarker = null;
        this(defaultConstructorMarker, 1, defaultConstructorMarker);
    }

    public /* synthetic */ SingleLiveDataEvent(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }

    public SingleLiveDataEvent(T t) {
        super(t);
        this.mPending = new AtomicBoolean(t != null);
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(LifecycleOwner owner, final Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (hasActiveObservers()) {
            C4588L.logWarning$default(TAG, "Multiple observers registered but only one will be notified of changes.", null, 4, null);
        }
        super.observe(owner, new Observer() { // from class: com.yoti.mobile.android.commonui.SingleLiveDataEvent$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SingleLiveDataEvent.m6790observe$lambda0(this.f$0, observer, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: observe$lambda-0, reason: not valid java name */
    public static final void m6790observe$lambda0(SingleLiveDataEvent this$0, Observer observer, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        if (this$0.mPending.compareAndSet(true, false)) {
            observer.onChanged(obj);
        }
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T t) {
        this.mPending.set(true);
        super.setValue(t);
    }

    public final void call() {
        setValue(null);
    }
}
