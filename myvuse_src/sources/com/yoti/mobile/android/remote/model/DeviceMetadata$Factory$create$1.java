package com.yoti.mobile.android.remote.model;

import com.yoti.mobile.android.remote.model.DeviceMetadata;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: DeviceMetadata.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.yoti.mobile.android.remote.model.DeviceMetadata$Factory", m5608f = "DeviceMetadata.kt", m5609i = {0}, m5610l = {48}, m5611m = "create", m5612n = {"this"}, m5613s = {"L$0"})
final class DeviceMetadata$Factory$create$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceMetadata.Factory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeviceMetadata$Factory$create$1(DeviceMetadata.Factory factory, Continuation<? super DeviceMetadata$Factory$create$1> continuation) {
        super(continuation);
        this.this$0 = factory;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.create(this);
    }
}
