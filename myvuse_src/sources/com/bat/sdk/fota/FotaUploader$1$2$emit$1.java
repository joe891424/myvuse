package com.bat.sdk.fota;

import com.bat.sdk.fota.FotaUploader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: FotaUploader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.fota.FotaUploader$1$2", m5608f = "FotaUploader.kt", m5609i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, m5610l = {54, LockFreeTaskQueueCore.CLOSED_SHIFT, 74, 87}, m5611m = "emit", m5612n = {"this", "it", "completeCommand", "this", "it", "chunks", "chunkRequest", "this", "it", "chunks"}, m5613s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
final class FotaUploader$1$2$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FotaUploader.C15091.AnonymousClass2<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FotaUploader$1$2$emit$1(FotaUploader.C15091.AnonymousClass2<? super T> anonymousClass2, Continuation<? super FotaUploader$1$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((FotaUploader.FotaData) null, (Continuation<? super Unit>) this);
    }
}
