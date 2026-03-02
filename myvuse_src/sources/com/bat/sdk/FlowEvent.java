package com.bat.sdk;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FlowEvent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\nR\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/bat/sdk/FlowEvent;", ExifInterface.GPS_DIRECTION_TRUE, "", "v", "consumed", "", "<init>", "(Ljava/lang/Object;Z)V", "Ljava/lang/Object;", "consume", "()Ljava/lang/Object;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class FlowEvent<T> {
    private boolean consumed;
    private final T v;

    public FlowEvent(T t, boolean z) {
        this.v = t;
        this.consumed = z;
    }

    public /* synthetic */ FlowEvent(Object obj, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? false : z);
    }

    public final T consume() {
        T t = this.v;
        if (this.consumed) {
            t = null;
        }
        this.consumed = true;
        return t;
    }
}
