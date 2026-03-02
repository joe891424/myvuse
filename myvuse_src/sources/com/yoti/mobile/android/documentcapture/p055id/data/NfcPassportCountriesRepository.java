package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.documentcapture.p055id.domain.INfcPassportCountriesRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/NfcPassportCountriesRepository;", "Lcom/yoti/mobile/android/documentcapture/id/domain/INfcPassportCountriesRepository;", "dataSource", "Lcom/yoti/mobile/android/documentcapture/id/data/INfcPassportCountriesDataSource;", "(Lcom/yoti/mobile/android/documentcapture/id/data/INfcPassportCountriesDataSource;)V", "getNfcPassportCountries", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/NfcPassportCountries;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NfcPassportCountriesRepository implements INfcPassportCountriesRepository {
    private final INfcPassportCountriesDataSource dataSource;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.data.NfcPassportCountriesRepository$getNfcPassportCountries$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.data.NfcPassportCountriesRepository", m5608f = "NfcPassportCountriesRepository.kt", m5609i = {}, m5610l = {14}, m5611m = "getNfcPassportCountries", m5612n = {}, m5613s = {})
    static final class C46091 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C46091(Continuation<? super C46091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NfcPassportCountriesRepository.this.getNfcPassportCountries(this);
        }
    }

    @Inject
    public NfcPassportCountriesRepository(INfcPassportCountriesDataSource dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.dataSource = dataSource;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.yoti.mobile.android.documentcapture.p055id.domain.INfcPassportCountriesRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getNfcPassportCountries(kotlin.coroutines.Continuation<? super com.yoti.mobile.android.documentcapture.p055id.domain.model.NfcPassportCountries> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.yoti.mobile.android.documentcapture.p055id.data.NfcPassportCountriesRepository.C46091
            if (r0 == 0) goto L13
            r0 = r5
            com.yoti.mobile.android.documentcapture.id.data.NfcPassportCountriesRepository$getNfcPassportCountries$1 r0 = (com.yoti.mobile.android.documentcapture.p055id.data.NfcPassportCountriesRepository.C46091) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.documentcapture.id.data.NfcPassportCountriesRepository$getNfcPassportCountries$1 r0 = new com.yoti.mobile.android.documentcapture.id.data.NfcPassportCountriesRepository$getNfcPassportCountries$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            com.yoti.mobile.android.documentcapture.id.data.INfcPassportCountriesDataSource r5 = r4.dataSource
            r0.label = r3
            java.lang.Object r5 = r5.getCountries(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Set r5 = kotlin.collections.CollectionsKt.toSet(r5)
            com.yoti.mobile.android.documentcapture.id.domain.model.NfcPassportCountries r0 = new com.yoti.mobile.android.documentcapture.id.domain.model.NfcPassportCountries
            r0.<init>(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.data.NfcPassportCountriesRepository.getNfcPassportCountries(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
