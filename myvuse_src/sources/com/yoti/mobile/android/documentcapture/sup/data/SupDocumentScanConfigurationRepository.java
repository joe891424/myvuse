package com.yoti.mobile.android.documentcapture.sup.data;

import androidx.exifinterface.media.ExifInterface;
import com.yoti.mobile.android.documentcapture.data.remote.model.ScanConfigurationRequestParams;
import com.yoti.mobile.android.documentcapture.domain.IScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.sup.data.cache.SupDocumentScanConfigurationCacheDataSource;
import com.yoti.mobile.android.documentcapture.sup.data.remote.SupDocumentScanConfigurationService;
import com.yoti.mobile.android.documentcapture.sup.data.remote.model.SupDocumentScanConfiguration;
import com.yoti.mobile.android.documentcapture.sup.domain.ISupDocumentScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.sup.domain.model.SupDocumentScanConfigurationEntity;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import com.yoti.mobile.android.yotidocs.common.extension.SingleKt;
import com.yoti.mobile.android.yotisdkcore.core.p085di.RequirementId;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B9\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/data/SupDocumentScanConfigurationRepository;", "Lcom/yoti/mobile/android/documentcapture/domain/IScanConfigurationRepository;", "Lcom/yoti/mobile/android/documentcapture/sup/domain/model/SupDocumentScanConfigurationEntity;", "Lcom/yoti/mobile/android/documentcapture/sup/domain/ISupDocumentScanConfigurationRepository;", "configurationService", "Lcom/yoti/mobile/android/documentcapture/sup/data/remote/SupDocumentScanConfigurationService;", "configurationCacheDataSource", "Lcom/yoti/mobile/android/documentcapture/sup/data/cache/SupDocumentScanConfigurationCacheDataSource;", "requirementId", "", "scanConfigDataToEntityMapper", "Lcom/yoti/mobile/android/documentcapture/sup/data/SupDocumentScanConfigDataToEntityMapper;", "documentTypeEntityToDataMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeEntityToDataMapper;", "exceptionToEntityMapper", "Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;", "(Lcom/yoti/mobile/android/documentcapture/sup/data/remote/SupDocumentScanConfigurationService;Lcom/yoti/mobile/android/documentcapture/sup/data/cache/SupDocumentScanConfigurationCacheDataSource;Ljava/lang/String;Lcom/yoti/mobile/android/documentcapture/sup/data/SupDocumentScanConfigDataToEntityMapper;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeEntityToDataMapper;Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;)V", "getScanConfiguration", "Lio/reactivex/Single;", "countryIso3Code", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "getScanConfigurationFlow", "Lkotlinx/coroutines/flow/Flow;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentScanConfigurationRepository implements IScanConfigurationRepository<SupDocumentScanConfigurationEntity>, ISupDocumentScanConfigurationRepository {
    private final SupDocumentScanConfigurationCacheDataSource configurationCacheDataSource;
    private final SupDocumentScanConfigurationService configurationService;
    private final DocumentTypeEntityToDataMapper documentTypeEntityToDataMapper;
    private final RemoteExceptionToEntityMapper exceptionToEntityMapper;
    private final String requirementId;
    private final SupDocumentScanConfigDataToEntityMapper scanConfigDataToEntityMapper;

    @Inject
    public SupDocumentScanConfigurationRepository(SupDocumentScanConfigurationService configurationService, SupDocumentScanConfigurationCacheDataSource configurationCacheDataSource, @RequirementId String requirementId, SupDocumentScanConfigDataToEntityMapper scanConfigDataToEntityMapper, DocumentTypeEntityToDataMapper documentTypeEntityToDataMapper, RemoteExceptionToEntityMapper exceptionToEntityMapper) {
        Intrinsics.checkNotNullParameter(configurationService, "configurationService");
        Intrinsics.checkNotNullParameter(configurationCacheDataSource, "configurationCacheDataSource");
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        Intrinsics.checkNotNullParameter(scanConfigDataToEntityMapper, "scanConfigDataToEntityMapper");
        Intrinsics.checkNotNullParameter(documentTypeEntityToDataMapper, "documentTypeEntityToDataMapper");
        Intrinsics.checkNotNullParameter(exceptionToEntityMapper, "exceptionToEntityMapper");
        this.configurationService = configurationService;
        this.configurationCacheDataSource = configurationCacheDataSource;
        this.requirementId = requirementId;
        this.scanConfigDataToEntityMapper = scanConfigDataToEntityMapper;
        this.documentTypeEntityToDataMapper = documentTypeEntityToDataMapper;
        this.exceptionToEntityMapper = exceptionToEntityMapper;
        configurationCacheDataSource.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getScanConfiguration$lambda-0, reason: not valid java name */
    public static final SupDocumentScanConfigurationEntity m6827getScanConfiguration$lambda0(SupDocumentScanConfigurationRepository this$0, SupDocumentScanConfiguration it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it2, "it");
        this$0.configurationCacheDataSource.setSupDocumentScanConfiguration(it2);
        return this$0.scanConfigDataToEntityMapper.map(it2);
    }

    @Override // com.yoti.mobile.android.documentcapture.domain.IScanConfigurationRepository
    public Single<SupDocumentScanConfigurationEntity> getScanConfiguration(String countryIso3Code, DocumentResourceConfigEntity.DocumentTypeEntity documentType) {
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Single<R> map = this.configurationService.execute(new ScanConfigurationRequestParams(this.requirementId, countryIso3Code, this.documentTypeEntityToDataMapper.map(documentType))).map(new Function() { // from class: com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SupDocumentScanConfigurationRepository.m6827getScanConfiguration$lambda0(this.f$0, (SupDocumentScanConfiguration) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "configurationService\n   …map(it)\n                }");
        return SingleKt.onErrorMapToErrorEntity(map, this.exceptionToEntityMapper);
    }

    @Override // com.yoti.mobile.android.documentcapture.sup.domain.ISupDocumentScanConfigurationRepository
    public Flow<SupDocumentScanConfigurationEntity> getScanConfigurationFlow() {
        final Flow<SupDocumentScanConfiguration> supDocumentScanConfigurationFlow = this.configurationCacheDataSource.getSupDocumentScanConfigurationFlow();
        return new Flow<SupDocumentScanConfigurationEntity>() { // from class: com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository$getScanConfigurationFlow$$inlined$map$1

            /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository$getScanConfigurationFlow$$inlined$map$1$2, reason: invalid class name */
            @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m5598d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ SupDocumentScanConfigurationRepository this$0;

                /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository$getScanConfigurationFlow$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository$getScanConfigurationFlow$$inlined$map$1$2", m5608f = "SupDocumentScanConfigurationRepository.kt", m5609i = {}, m5610l = {ISO7816Kt.INS_CREATE_FILE}, m5611m = "emit", m5612n = {}, m5613s = {})
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
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, SupDocumentScanConfigurationRepository supDocumentScanConfigurationRepository) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = supDocumentScanConfigurationRepository;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.yoti.mobile.android.documentcapture.sup.data.C4654x45109495.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository$getScanConfigurationFlow$$inlined$map$1$2$1 r0 = (com.yoti.mobile.android.documentcapture.sup.data.C4654x45109495.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository$getScanConfigurationFlow$$inlined$map$1$2$1 r0 = new com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository$getScanConfigurationFlow$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4f
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        com.yoti.mobile.android.documentcapture.sup.data.remote.model.SupDocumentScanConfiguration r5 = (com.yoti.mobile.android.documentcapture.sup.data.remote.model.SupDocumentScanConfiguration) r5
                        if (r5 == 0) goto L45
                        com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository r2 = r4.this$0
                        com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigDataToEntityMapper r2 = com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository.access$getScanConfigDataToEntityMapper$p(r2)
                        com.yoti.mobile.android.documentcapture.sup.domain.model.SupDocumentScanConfigurationEntity r5 = r2.map(r5)
                        goto L46
                    L45:
                        r5 = 0
                    L46:
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4f
                        return r1
                    L4f:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.sup.data.C4654x45109495.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super SupDocumentScanConfigurationEntity> flowCollector, Continuation continuation) {
                Object objCollect = supDocumentScanConfigurationFlow.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }
}
