package com.bat.sdk.persistence.repository;

import com.bat.sdk.domain.SdkLog;
import com.bat.sdk.persistence.SdkDatabase;
import com.bat.sdk.persistence.dto.SdkLogDto;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkLogRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m5598d2 = {"Lcom/bat/sdk/persistence/repository/SdkLogRepository;", "", "sdkDatabase", "Lcom/bat/sdk/persistence/SdkDatabase;", "<init>", "(Lcom/bat/sdk/persistence/SdkDatabase;)V", "saveLogs", "", "getSaveLogs", "()Z", "setSaveLogs", "(Z)V", "loadAll", "", "Lcom/bat/sdk/domain/SdkLog;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "", "log", "(Lcom/bat/sdk/domain/SdkLog;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class SdkLogRepository {
    private boolean saveLogs;
    private final SdkDatabase sdkDatabase;

    /* JADX INFO: renamed from: com.bat.sdk.persistence.repository.SdkLogRepository$loadAll$1 */
    /* JADX INFO: compiled from: SdkLogRepository.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.persistence.repository.SdkLogRepository", m5608f = "SdkLogRepository.kt", m5609i = {}, m5610l = {17}, m5611m = "loadAll", m5612n = {}, m5613s = {})
    static final class C15761 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C15761(Continuation<? super C15761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SdkLogRepository.this.loadAll(this);
        }
    }

    public SdkLogRepository(SdkDatabase sdkDatabase) {
        Intrinsics.checkNotNullParameter(sdkDatabase, "sdkDatabase");
        this.sdkDatabase = sdkDatabase;
        this.saveLogs = true;
    }

    public final boolean getSaveLogs() {
        return this.saveLogs;
    }

    public final void setSaveLogs(boolean z) {
        this.saveLogs = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadAll(kotlin.coroutines.Continuation<? super java.util.List<com.bat.sdk.domain.SdkLog>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bat.sdk.persistence.repository.SdkLogRepository.C15761
            if (r0 == 0) goto L14
            r0 = r5
            com.bat.sdk.persistence.repository.SdkLogRepository$loadAll$1 r0 = (com.bat.sdk.persistence.repository.SdkLogRepository.C15761) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.bat.sdk.persistence.repository.SdkLogRepository$loadAll$1 r0 = new com.bat.sdk.persistence.repository.SdkLogRepository$loadAll$1
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
            com.bat.sdk.persistence.dao.SdkLogsDao r5 = r5.generalLogDao()
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
            com.bat.sdk.persistence.dto.SdkLogDto r1 = (com.bat.sdk.persistence.dto.SdkLogDto) r1
            com.bat.sdk.domain.SdkLog r1 = r1.toGeneralLog()
            r0.add(r1)
            goto L57
        L6b:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.persistence.repository.SdkLogRepository.loadAll(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object save(SdkLog sdkLog, Continuation<? super Unit> continuation) {
        if (this.saveLogs) {
            Object objInsert = this.sdkDatabase.generalLogDao().insert(SdkLogDto.INSTANCE.fromGeneralLog(sdkLog), continuation);
            return objInsert == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInsert : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final Object clear(Continuation<? super Unit> continuation) {
        Object objDeleteAll = this.sdkDatabase.generalLogDao().deleteAll(continuation);
        return objDeleteAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteAll : Unit.INSTANCE;
    }
}
