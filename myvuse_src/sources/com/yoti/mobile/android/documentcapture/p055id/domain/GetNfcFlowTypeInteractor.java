package com.yoti.mobile.android.documentcapture.p055id.domain;

import com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentEntity;
import com.yoti.mobile.android.mrtd.domain.INfcStateRepository;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086Bø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0019\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/GetNfcFlowTypeInteractor;", "", "nfcStateRepository", "Lcom/yoti/mobile/android/mrtd/domain/INfcStateRepository;", "nfcPassportCountriesRepository", "Lcom/yoti/mobile/android/documentcapture/id/domain/INfcPassportCountriesRepository;", "(Lcom/yoti/mobile/android/mrtd/domain/INfcStateRepository;Lcom/yoti/mobile/android/documentcapture/id/domain/INfcPassportCountriesRepository;)V", "invoke", "Lcom/yoti/mobile/android/documentcapture/id/domain/NfcFlowType;", "scanDocumentEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentEntity;", "(Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNfcFlowExecutable", "", "isNfcFlowMandatory", "isNfcSupportedByBackend", "scanConfig", "isNfcSupportedByClient", "isNfcSupportedByDevice", "isNfcSupportedByScan", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class GetNfcFlowTypeInteractor {
    private final INfcPassportCountriesRepository nfcPassportCountriesRepository;
    private final INfcStateRepository nfcStateRepository;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.domain.GetNfcFlowTypeInteractor$invoke$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.domain.GetNfcFlowTypeInteractor", m5608f = "GetNfcFlowTypeInteractor.kt", m5609i = {}, m5610l = {20}, m5611m = "invoke", m5612n = {}, m5613s = {})
    static final class C46271 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C46271(Continuation<? super C46271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetNfcFlowTypeInteractor.this.invoke(null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.domain.GetNfcFlowTypeInteractor$isNfcFlowMandatory$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.domain.GetNfcFlowTypeInteractor", m5608f = "GetNfcFlowTypeInteractor.kt", m5609i = {0}, m5610l = {35}, m5611m = "isNfcFlowMandatory", m5612n = {"iso3Code"}, m5613s = {"L$0"})
    static final class C46281 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C46281(Continuation<? super C46281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetNfcFlowTypeInteractor.this.isNfcFlowMandatory(null, this);
        }
    }

    @Inject
    public GetNfcFlowTypeInteractor(INfcStateRepository nfcStateRepository, INfcPassportCountriesRepository nfcPassportCountriesRepository) {
        Intrinsics.checkNotNullParameter(nfcStateRepository, "nfcStateRepository");
        Intrinsics.checkNotNullParameter(nfcPassportCountriesRepository, "nfcPassportCountriesRepository");
        this.nfcStateRepository = nfcStateRepository;
        this.nfcPassportCountriesRepository = nfcPassportCountriesRepository;
    }

    private final boolean isNfcFlowExecutable(IdDocumentEntity scanDocumentEntity) {
        return isNfcSupportedByBackend(scanDocumentEntity) && isNfcSupportedByClient(scanDocumentEntity) && isNfcSupportedByDevice() && isNfcSupportedByScan(scanDocumentEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object isNfcFlowMandatory(com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentEntity r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.yoti.mobile.android.documentcapture.p055id.domain.GetNfcFlowTypeInteractor.C46281
            if (r0 == 0) goto L13
            r0 = r6
            com.yoti.mobile.android.documentcapture.id.domain.GetNfcFlowTypeInteractor$isNfcFlowMandatory$1 r0 = (com.yoti.mobile.android.documentcapture.p055id.domain.GetNfcFlowTypeInteractor.C46281) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.documentcapture.id.domain.GetNfcFlowTypeInteractor$isNfcFlowMandatory$1 r0 = new com.yoti.mobile.android.documentcapture.id.domain.GetNfcFlowTypeInteractor$isNfcFlowMandatory$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L62
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            com.yoti.mobile.android.documentcapture.id.domain.model.OcrResultEntity r6 = r5.getOcrData()
            if (r6 == 0) goto L4d
            com.yoti.mobile.android.documentcapture.id.domain.model.DocumentFieldsEntity r6 = r6.getDocumentFields()
            if (r6 == 0) goto L4d
            java.lang.String r6 = r6.getIssuingCountryIso3Code()
            if (r6 != 0) goto L4b
            goto L4d
        L4b:
            r5 = r6
            goto L55
        L4d:
            com.yoti.mobile.android.documentcapture.domain.model.DocumentResourceInfoEntity r5 = r5.getResourceInfo()
            java.lang.String r5 = r5.getCountryIso3Code()
        L55:
            com.yoti.mobile.android.documentcapture.id.domain.INfcPassportCountriesRepository r6 = r4.nfcPassportCountriesRepository
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.getNfcPassportCountries(r0)
            if (r6 != r1) goto L62
            return r1
        L62:
            com.yoti.mobile.android.documentcapture.id.domain.model.NfcPassportCountries r6 = (com.yoti.mobile.android.documentcapture.p055id.domain.model.NfcPassportCountries) r6
            boolean r5 = r6.isNfcPassportCountry(r5)
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.domain.GetNfcFlowTypeInteractor.isNfcFlowMandatory(com.yoti.mobile.android.documentcapture.id.domain.model.IdDocumentEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean isNfcSupportedByBackend(IdDocumentEntity scanConfig) {
        return scanConfig.getNfcAvailable();
    }

    private final boolean isNfcSupportedByClient(IdDocumentEntity scanConfig) {
        return scanConfig.getResourceInfo().getDocumentType() == DocumentResourceConfigEntity.DocumentTypeEntity.PASSPORT;
    }

    private final boolean isNfcSupportedByDevice() {
        return this.nfcStateRepository.getState().getHasAdapter();
    }

    private final boolean isNfcSupportedByScan(IdDocumentEntity scanConfig) {
        return scanConfig.isOcrDataValidForNfcRead();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentEntity r5, kotlin.coroutines.Continuation<? super com.yoti.mobile.android.documentcapture.p055id.domain.NfcFlowType> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.yoti.mobile.android.documentcapture.p055id.domain.GetNfcFlowTypeInteractor.C46271
            if (r0 == 0) goto L13
            r0 = r6
            com.yoti.mobile.android.documentcapture.id.domain.GetNfcFlowTypeInteractor$invoke$1 r0 = (com.yoti.mobile.android.documentcapture.p055id.domain.GetNfcFlowTypeInteractor.C46271) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.documentcapture.id.domain.GetNfcFlowTypeInteractor$invoke$1 r0 = new com.yoti.mobile.android.documentcapture.id.domain.GetNfcFlowTypeInteractor$invoke$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r4.isNfcFlowExecutable(r5)
            if (r6 == 0) goto L51
            r0.label = r3
            java.lang.Object r6 = r4.isNfcFlowMandatory(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r5 = r6.booleanValue()
            if (r5 == 0) goto L4e
            com.yoti.mobile.android.documentcapture.id.domain.NfcFlowType r5 = com.yoti.mobile.android.documentcapture.p055id.domain.NfcFlowType.ALWAYS
            goto L53
        L4e:
            com.yoti.mobile.android.documentcapture.id.domain.NfcFlowType r5 = com.yoti.mobile.android.documentcapture.p055id.domain.NfcFlowType.USER_PROMPT
            goto L53
        L51:
            com.yoti.mobile.android.documentcapture.id.domain.NfcFlowType r5 = com.yoti.mobile.android.documentcapture.p055id.domain.NfcFlowType.NEVER
        L53:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.domain.GetNfcFlowTypeInteractor.invoke(com.yoti.mobile.android.documentcapture.id.domain.model.IdDocumentEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
