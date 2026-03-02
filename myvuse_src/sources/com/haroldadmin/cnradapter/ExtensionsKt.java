package com.haroldadmin.cnradapter;

import androidx.exifinterface.media.ExifInterface;
import com.haroldadmin.cnradapter.NetworkResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: Extensions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0083\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2(\u0010\f\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00040\rH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a4\u0010\u0010\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0086\u0002¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m5598d2 = {"executeWithRetry", "Lcom/haroldadmin/cnradapter/NetworkResponse;", ExifInterface.GPS_DIRECTION_TRUE, "U", "", "times", "", "initialDelay", "", "maxDelay", "factor", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(IJJDLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "(Lcom/haroldadmin/cnradapter/NetworkResponse;)Ljava/lang/Object;", "coroutines-network-response-adapter"}, m5599k = 2, m5600mv = {1, 1, 16})
public final class ExtensionsKt {

    /* JADX INFO: renamed from: com.haroldadmin.cnradapter.ExtensionsKt$executeWithRetry$1 */
    /* JADX INFO: compiled from: Extensions.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\b\b\u0001\u0010\u0003*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2(\u0010\u000b\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000e0\rH\u0086H"}, m5598d2 = {"executeWithRetry", "", ExifInterface.GPS_DIRECTION_TRUE, "U", "times", "", "initialDelay", "", "maxDelay", "factor", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "continuation"}, m5599k = 3, m5600mv = {1, 1, 16})
    @DebugMetadata(m5607c = "com.haroldadmin.cnradapter.ExtensionsKt", m5608f = "Extensions.kt", m5609i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, m5610l = {26, 28}, m5611m = "executeWithRetry", m5612n = {"times", "initialDelay", "maxDelay", "factor", "block", "currentDelay", "it", "times", "initialDelay", "maxDelay", "factor", "block", "currentDelay", "it", "response"}, m5613s = {"I$0", "J$0", "J$1", "D$0", "L$0", "L$1", "I$3", "I$0", "J$0", "J$1", "D$0", "L$0", "L$1", "I$3", "L$2"})
    public static final class C35801 extends ContinuationImpl {
        double D$0;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C35801(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExtensionsKt.executeWithRetry(0, 0L, 0L, 0.0d, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0127 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0102 -> B:28:0x0112). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T, U> java.lang.Object executeWithRetry(int r20, long r21, long r23, double r25, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.haroldadmin.cnradapter.NetworkResponse<? extends T, ? extends U>>, ? extends java.lang.Object> r27, kotlin.coroutines.Continuation<? super com.haroldadmin.cnradapter.NetworkResponse<? extends T, ? extends U>> r28) {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.haroldadmin.cnradapter.ExtensionsKt.executeWithRetry(int, long, long, double, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object executeWithRetry$$forInline(int i, long j, long j2, double d, Function1 function1, Continuation continuation) {
        int i2 = i - 1;
        for (int i3 = 0; i3 < i2; i3++) {
            InlineMarker.mark(0);
            Object objInvoke = function1.invoke(continuation);
            InlineMarker.mark(1);
            NetworkResponse networkResponse = (NetworkResponse) objInvoke;
            if (!(networkResponse instanceof NetworkResponse.NetworkError)) {
                return networkResponse;
            }
            InlineMarker.mark(0);
            DelayKt.delay(j, continuation);
            InlineMarker.mark(2);
            InlineMarker.mark(1);
            j = RangesKt.coerceAtMost((long) (j * d), j2);
        }
        return function1.invoke(continuation);
    }

    public static final <T, U> T invoke(NetworkResponse<? extends T, ? extends U> invoke) {
        Intrinsics.checkParameterIsNotNull(invoke, "$this$invoke");
        if (invoke instanceof NetworkResponse.Success) {
            return (T) ((NetworkResponse.Success) invoke).getBody();
        }
        return null;
    }

    public static /* synthetic */ Object executeWithRetry$default(int i, long j, long j2, double d, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 10;
        }
        if ((i2 & 2) != 0) {
            j = 100;
        }
        if ((i2 & 4) != 0) {
            j2 = 1000;
        }
        if ((i2 & 8) != 0) {
            d = 2.0d;
        }
        int i3 = i - 1;
        for (int i4 = 0; i4 < i3; i4++) {
            InlineMarker.mark(0);
            Object objInvoke = function1.invoke(continuation);
            InlineMarker.mark(1);
            NetworkResponse networkResponse = (NetworkResponse) objInvoke;
            if (!(networkResponse instanceof NetworkResponse.NetworkError)) {
                return networkResponse;
            }
            InlineMarker.mark(0);
            DelayKt.delay(j, continuation);
            InlineMarker.mark(2);
            InlineMarker.mark(1);
            j = RangesKt.coerceAtMost((long) (j * d), j2);
        }
        return function1.invoke(continuation);
    }
}
