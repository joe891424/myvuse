package com.bat.sdk.persistence.repository;

import com.bat.sdk.ble.BatDevice;
import com.bat.sdk.persistence.SdkDatabase;
import com.bat.sdk.persistence.dto.BatDeviceDto;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatDevicesRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m5598d2 = {"Lcom/bat/sdk/persistence/repository/BatDevicesRepository;", "", "sdkDatabase", "Lcom/bat/sdk/persistence/SdkDatabase;", "<init>", "(Lcom/bat/sdk/persistence/SdkDatabase;)V", "save", "", "device", "Lcom/bat/sdk/ble/BatDevice;", "(Lcom/bat/sdk/ble/BatDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "load", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class BatDevicesRepository {
    private final SdkDatabase sdkDatabase;

    /* JADX INFO: renamed from: com.bat.sdk.persistence.repository.BatDevicesRepository$load$1 */
    /* JADX INFO: compiled from: BatDevicesRepository.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.persistence.repository.BatDevicesRepository", m5608f = "BatDevicesRepository.kt", m5609i = {}, m5610l = {27}, m5611m = "load", m5612n = {}, m5613s = {})
    static final class C15651 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C15651(Continuation<? super C15651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BatDevicesRepository.this.load(this);
        }
    }

    public BatDevicesRepository(SdkDatabase sdkDatabase) {
        Intrinsics.checkNotNullParameter(sdkDatabase, "sdkDatabase");
        this.sdkDatabase = sdkDatabase;
    }

    public final Object save(BatDevice batDevice, Continuation<? super Unit> continuation) {
        Object objInsert = this.sdkDatabase.batDeviceDao().insert(BatDeviceDto.INSTANCE.fromBatDevice(batDevice), continuation);
        return objInsert == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInsert : Unit.INSTANCE;
    }

    public final Object delete(BatDevice batDevice, Continuation<? super Unit> continuation) {
        Object objDeleteByName = this.sdkDatabase.batDeviceDao().deleteByName(batDevice.getName(), continuation);
        return objDeleteByName == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteByName : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object load(kotlin.coroutines.Continuation<? super java.util.List<com.bat.sdk.ble.BatDevice>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bat.sdk.persistence.repository.BatDevicesRepository.C15651
            if (r0 == 0) goto L14
            r0 = r5
            com.bat.sdk.persistence.repository.BatDevicesRepository$load$1 r0 = (com.bat.sdk.persistence.repository.BatDevicesRepository.C15651) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.bat.sdk.persistence.repository.BatDevicesRepository$load$1 r0 = new com.bat.sdk.persistence.repository.BatDevicesRepository$load$1
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
            com.bat.sdk.persistence.dao.BatDeviceDao r5 = r5.batDeviceDao()
            r0.label = r3
            java.lang.Object r5 = r5.loadAll(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            java.util.List r5 = (java.util.List) r5
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r5 = r5.iterator()
        L59:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L6d
            java.lang.Object r1 = r5.next()
            com.bat.sdk.persistence.dto.BatDeviceDto r1 = (com.bat.sdk.persistence.dto.BatDeviceDto) r1
            com.bat.sdk.ble.BatDevice r1 = r1.toBatDevice()
            r0.add(r1)
            goto L59
        L6d:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.persistence.repository.BatDevicesRepository.load(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
