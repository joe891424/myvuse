package com.bat.sdk.persistence.repository;

import androidx.exifinterface.media.ExifInterface;
import com.bat.sdk.model.ErrorRecord;
import com.bat.sdk.persistence.SdkDatabase;
import com.bat.sdk.persistence.dto.ErrorRecordDto;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ErrorRecordRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000fJ\u001c\u0010\u0010\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\tH\u0086@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0013\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/bat/sdk/persistence/repository/ErrorRecordRepository;", "", "sdkDatabase", "Lcom/bat/sdk/persistence/SdkDatabase;", "<init>", "(Lcom/bat/sdk/persistence/SdkDatabase;)V", "insertErrorRecords", "", FirebaseAnalytics.Param.ITEMS, "", "Lcom/bat/sdk/model/ErrorRecord;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getErrorRecords", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeErrorRecords", "Lkotlinx/coroutines/flow/Flow;", "deleteErrorRecordByIds", "ids", "", "deleteAllErrorRecords", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class ErrorRecordRepository {
    private final SdkDatabase sdkDatabase;

    /* JADX INFO: renamed from: com.bat.sdk.persistence.repository.ErrorRecordRepository$getErrorRecords$1 */
    /* JADX INFO: compiled from: ErrorRecordRepository.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.persistence.repository.ErrorRecordRepository", m5608f = "ErrorRecordRepository.kt", m5609i = {}, m5610l = {21}, m5611m = "getErrorRecords", m5612n = {}, m5613s = {})
    static final class C15661 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C15661(Continuation<? super C15661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ErrorRecordRepository.this.getErrorRecords(this);
        }
    }

    public ErrorRecordRepository(SdkDatabase sdkDatabase) {
        Intrinsics.checkNotNullParameter(sdkDatabase, "sdkDatabase");
        this.sdkDatabase = sdkDatabase;
    }

    public final Object insertErrorRecords(List<ErrorRecord> list, Continuation<? super Unit> continuation) {
        List<ErrorRecord> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList.add(ErrorRecordDto.INSTANCE.fromErrorRecord((ErrorRecord) it2.next()));
        }
        Object objInsert = this.sdkDatabase.errorRecordDao().insert(arrayList, continuation);
        return objInsert == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInsert : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getErrorRecords(kotlin.coroutines.Continuation<? super java.util.List<com.bat.sdk.model.ErrorRecord>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bat.sdk.persistence.repository.ErrorRecordRepository.C15661
            if (r0 == 0) goto L14
            r0 = r5
            com.bat.sdk.persistence.repository.ErrorRecordRepository$getErrorRecords$1 r0 = (com.bat.sdk.persistence.repository.ErrorRecordRepository.C15661) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.bat.sdk.persistence.repository.ErrorRecordRepository$getErrorRecords$1 r0 = new com.bat.sdk.persistence.repository.ErrorRecordRepository$getErrorRecords$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            com.bat.sdk.persistence.SdkDatabase r5 = r4.sdkDatabase
            com.bat.sdk.persistence.dao.ErrorRecordDao r5 = r5.errorRecordDao()
            r0.label = r3
            java.lang.Object r5 = r5.getAll(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r5 = r5.iterator()
        L57:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L6b
            java.lang.Object r1 = r5.next()
            com.bat.sdk.persistence.dto.ErrorRecordDto r1 = (com.bat.sdk.persistence.dto.ErrorRecordDto) r1
            com.bat.sdk.model.ErrorRecord r1 = r1.toErrorRecord()
            r0.add(r1)
            goto L57
        L6b:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.persistence.repository.ErrorRecordRepository.getErrorRecords(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow<List<ErrorRecord>> observeErrorRecords() {
        final Flow<List<ErrorRecordDto>> flowObserveAll = this.sdkDatabase.errorRecordDao().observeAll();
        return (Flow) new Flow<List<? extends ErrorRecord>>() { // from class: com.bat.sdk.persistence.repository.ErrorRecordRepository$observeErrorRecords$$inlined$map$1

            /* JADX INFO: renamed from: com.bat.sdk.persistence.repository.ErrorRecordRepository$observeErrorRecords$$inlined$map$1$2 */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m5598d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
            public static final class C15672<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.bat.sdk.persistence.repository.ErrorRecordRepository$observeErrorRecords$$inlined$map$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
                @DebugMetadata(m5607c = "com.bat.sdk.persistence.repository.ErrorRecordRepository$observeErrorRecords$$inlined$map$1$2", m5608f = "ErrorRecordRepository.kt", m5609i = {}, m5610l = {223}, m5611m = "emit", m5612n = {}, m5613s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C15672.this.emit(null, this);
                    }
                }

                public C15672(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.bat.sdk.persistence.repository.ErrorRecordRepository$observeErrorRecords$$inlined$map$1.C15672.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r7
                        com.bat.sdk.persistence.repository.ErrorRecordRepository$observeErrorRecords$$inlined$map$1$2$1 r0 = (com.bat.sdk.persistence.repository.ErrorRecordRepository$observeErrorRecords$$inlined$map$1.C15672.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r7 = r0.label
                        int r7 = r7 - r2
                        r0.label = r7
                        goto L19
                    L14:
                        com.bat.sdk.persistence.repository.ErrorRecordRepository$observeErrorRecords$$inlined$map$1$2$1 r0 = new com.bat.sdk.persistence.repository.ErrorRecordRepository$observeErrorRecords$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L19:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L6e
                    L2a:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L32:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.util.List r6 = (java.util.List) r6
                        java.lang.Iterable r6 = (java.lang.Iterable) r6
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r4 = 10
                        int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r4)
                        r2.<init>(r4)
                        java.util.Collection r2 = (java.util.Collection) r2
                        java.util.Iterator r6 = r6.iterator()
                    L4f:
                        boolean r4 = r6.hasNext()
                        if (r4 == 0) goto L63
                        java.lang.Object r4 = r6.next()
                        com.bat.sdk.persistence.dto.ErrorRecordDto r4 = (com.bat.sdk.persistence.dto.ErrorRecordDto) r4
                        com.bat.sdk.model.ErrorRecord r4 = r4.toErrorRecord()
                        r2.add(r4)
                        goto L4f
                    L63:
                        java.util.List r2 = (java.util.List) r2
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r2, r0)
                        if (r6 != r1) goto L6e
                        return r1
                    L6e:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.persistence.repository.ErrorRecordRepository$observeErrorRecords$$inlined$map$1.C15672.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends ErrorRecord>> flowCollector, Continuation continuation) {
                Object objCollect = flowObserveAll.collect(new C15672(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    public final Object deleteErrorRecordByIds(List<Long> list, Continuation<? super Unit> continuation) {
        Object objDeleteByIds = this.sdkDatabase.errorRecordDao().deleteByIds(list, continuation);
        return objDeleteByIds == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteByIds : Unit.INSTANCE;
    }

    public final Object deleteAllErrorRecords(Continuation<? super Unit> continuation) {
        Object objDeleteAll = this.sdkDatabase.errorRecordDao().deleteAll(continuation);
        return objDeleteAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteAll : Unit.INSTANCE;
    }
}
