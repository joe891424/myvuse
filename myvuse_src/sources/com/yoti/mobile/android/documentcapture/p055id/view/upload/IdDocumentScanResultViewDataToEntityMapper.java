package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import android.graphics.RectF;
import androidx.autofill.HintConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.yoti.mobile.android.common.p049ui.components.country.Country;
import com.yoti.mobile.android.common.p049ui.components.utils.CountryCodeHelper;
import com.yoti.mobile.android.documentcapture.domain.model.CoordinateEntity;
import com.yoti.mobile.android.documentcapture.domain.model.FrameEntity;
import com.yoti.mobile.android.documentcapture.domain.model.PageDimensionsEntity;
import com.yoti.mobile.android.documentcapture.domain.model.PageRegionEntity;
import com.yoti.mobile.android.documentcapture.domain.model.PageRegionTypeEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.AddressEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.GenderTypeEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.HolderEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentEntity;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentTypeViewDataToEntityMapper;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.model.result.DateResult;
import com.yoti.mobile.android.documentscan.model.result.Gender;
import com.yoti.mobile.android.documentscan.model.result.Holder;
import com.yoti.mobile.android.documentscan.model.result.MetaData;
import com.yoti.mobile.android.yotidocs.common.ImageDimensions;
import com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader;
import com.yoti.mobile.android.yotidocs.common.SuspendMapper;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.ForComputation;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ#\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J%\u0010/\u001a\b\u0012\u0004\u0012\u000201002\f\u00102\u001a\b\u0012\u0004\u0012\u00020300H\u0082@ø\u0001\u0000¢\u0006\u0002\u00104J\u001b\u00105\u001a\u0004\u0018\u00010,2\u0006\u00106\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ/\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010\u0014\u001a\u00020\u00152\f\u00102\u001a\b\u0012\u0004\u0012\u00020300H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000203H\u0002J)\u0010?\u001a\u0004\u0018\u00010@2\f\u00102\u001a\b\u0012\u0004\u0012\u000203002\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010AJ/\u0010B\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010C\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010F\u001a\u0004\u0018\u00010(H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006G"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/IdDocumentScanResultViewDataToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/SuspendMapper;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentEntity;", "documentTypeViewDataToEntityMapper", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentTypeViewDataToEntityMapper;", "countryCodeHelper", "Lcom/yoti/mobile/android/common/ui/components/utils/CountryCodeHelper;", "imageDimensionsReader", "Lcom/yoti/mobile/android/yotidocs/common/ImageDimensionsReader;", "computationContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentTypeViewDataToEntityMapper;Lcom/yoti/mobile/android/common/ui/components/utils/CountryCodeHelper;Lcom/yoti/mobile/android/yotidocs/common/ImageDimensionsReader;Lkotlin/coroutines/CoroutineContext;)V", "map", "from", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapAddressViewDataToEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity;", "address", "Lcom/yoti/mobile/android/documentscan/model/result/Address;", "documentOriginIso3Code", "", "(Lcom/yoti/mobile/android/documentscan/model/result/Address;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapCountryCodeToCountryEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity$CountryEntity;", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapCountryViewDataToEntity", "country", "Lcom/yoti/mobile/android/documentscan/model/result/Country;", "(Lcom/yoti/mobile/android/documentscan/model/result/Country;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapDateViewDataToDate", "Ljava/util/Date;", "dateResult", "Lcom/yoti/mobile/android/documentscan/model/result/DateResult;", "mapGenderViewDataToEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/GenderTypeEntity;", HintConstants.AUTOFILL_HINT_GENDER, "Lcom/yoti/mobile/android/documentscan/model/result/Gender;", "mapHolderViewDataToEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/HolderEntity;", "holder", "Lcom/yoti/mobile/android/documentscan/model/result/Holder;", "mapImageDimensionsToPageDimensionsEntity", "Lcom/yoti/mobile/android/documentcapture/domain/model/PageDimensionsEntity;", "imageDimensions", "Lcom/yoti/mobile/android/yotidocs/common/ImageDimensions;", "mapImageResultsToEntity", "", "Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentPageEntity;", "scanResults", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapMainImageViewDataToPageDimensionsEntity", "mainImagePath", "mapOcrResultsToEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/OcrResultEntity;", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapPageRegionViewDataToEntity", "Lcom/yoti/mobile/android/documentcapture/domain/model/PageRegionEntity;", "documentCaptureResult", "mapScanResultsToEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/DocumentFieldsEntity;", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mergeCapturedAddressIntoEntity", "previousAddressEntity", "(Lcom/yoti/mobile/android/documentscan/model/result/Address;Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mergeCapturedHolderIntoEntity", "previousHolderEntity", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentScanResultViewDataToEntityMapper implements SuspendMapper<DocumentScanResultViewData, IdDocumentEntity> {
    private final CoroutineContext computationContext;
    private final CountryCodeHelper countryCodeHelper;
    private final DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper;
    private final ImageDimensionsReader imageDimensionsReader;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Gender.values().length];
            iArr[Gender.MALE.ordinal()] = 1;
            iArr[Gender.FEMALE.ordinal()] = 2;
            iArr[Gender.TRANSGENDER.ordinal()] = 3;
            iArr[Gender.OTHER.ordinal()] = 4;
            iArr[Gender.UNSPECIFIED.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$map$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper", m5608f = "IdDocumentScanResultViewDataToEntityMapper.kt", m5609i = {0, 0, 1, 1, 1}, m5610l = {52, 56}, m5611m = "map", m5612n = {"this", "from", "this", "from", "images"}, m5613s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class C46381 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C46381(Continuation<? super C46381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IdDocumentScanResultViewDataToEntityMapper.this.map((DocumentScanResultViewData) null, (Continuation<? super IdDocumentEntity>) this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapAddressViewDataToEntity$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper", m5608f = "IdDocumentScanResultViewDataToEntityMapper.kt", m5609i = {0}, m5610l = {219}, m5611m = "mapAddressViewDataToEntity", m5612n = {"address"}, m5613s = {"L$0"})
    static final class C46391 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C46391(Continuation<? super C46391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IdDocumentScanResultViewDataToEntityMapper.this.mapAddressViewDataToEntity(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapCountryCodeToCountryEntity$2 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/AddressEntity$CountryEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapCountryCodeToCountryEntity$2", m5608f = "IdDocumentScanResultViewDataToEntityMapper.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46402 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AddressEntity.CountryEntity>, Object> {
        final /* synthetic */ String $countryCode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C46402(String str, Continuation<? super C46402> continuation) {
            super(2, continuation);
            this.$countryCode = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IdDocumentScanResultViewDataToEntityMapper.this.new C46402(this.$countryCode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AddressEntity.CountryEntity> continuation) {
            return ((C46402) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Country countryForCode = IdDocumentScanResultViewDataToEntityMapper.this.countryCodeHelper.getCountryForCode(this.$countryCode);
            String name = countryForCode.getName();
            Intrinsics.checkNotNullExpressionValue(name, "name");
            String iso3Code = countryForCode.getIso3Code();
            Intrinsics.checkNotNullExpressionValue(iso3Code, "iso3Code");
            return new AddressEntity.CountryEntity(name, iso3Code, countryForCode.getIso2Code());
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapCountryViewDataToEntity$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper", m5608f = "IdDocumentScanResultViewDataToEntityMapper.kt", m5609i = {0, 0}, m5610l = {241, 242}, m5611m = "mapCountryViewDataToEntity", m5612n = {"this", "documentOriginIso3Code"}, m5613s = {"L$0", "L$1"})
    static final class C46411 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C46411(Continuation<? super C46411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IdDocumentScanResultViewDataToEntityMapper.this.mapCountryViewDataToEntity(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapImageResultsToEntity$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper", m5608f = "IdDocumentScanResultViewDataToEntityMapper.kt", m5609i = {0, 0}, m5610l = {84}, m5611m = "mapImageResultsToEntity", m5612n = {"this", "destination$iv$iv"}, m5613s = {"L$0", "L$1"})
    static final class C46421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C46421(Continuation<? super C46421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IdDocumentScanResultViewDataToEntityMapper.this.mapImageResultsToEntity(null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapMainImageViewDataToPageDimensionsEntity$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper", m5608f = "IdDocumentScanResultViewDataToEntityMapper.kt", m5609i = {0}, m5610l = {140}, m5611m = "mapMainImageViewDataToPageDimensionsEntity", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C46431 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C46431(Continuation<? super C46431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IdDocumentScanResultViewDataToEntityMapper.this.mapMainImageViewDataToPageDimensionsEntity(null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapOcrResultsToEntity$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper", m5608f = "IdDocumentScanResultViewDataToEntityMapper.kt", m5609i = {0, 0, 0}, m5610l = {95}, m5611m = "mapOcrResultsToEntity", m5612n = {"this", "documentType", "documentOriginIso3Code"}, m5613s = {"L$0", "L$1", "L$2"})
    static final class C46441 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C46441(Continuation<? super C46441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IdDocumentScanResultViewDataToEntityMapper.this.mapOcrResultsToEntity(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapScanResultsToEntity$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper", m5608f = "IdDocumentScanResultViewDataToEntityMapper.kt", m5609i = {0, 0, 0, 0, 0, 0, 0}, m5610l = {161}, m5611m = "mapScanResultsToEntity", m5612n = {"this", "documentOriginIso3Code", "documentFieldsEntity", "holderEntity", "holderAliasEntity", "addressEntity", "documentCaptureResult"}, m5613s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7"})
    static final class C46451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C46451(Continuation<? super C46451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IdDocumentScanResultViewDataToEntityMapper.this.mapScanResultsToEntity(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mergeCapturedAddressIntoEntity$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper", m5608f = "IdDocumentScanResultViewDataToEntityMapper.kt", m5609i = {0}, m5610l = {JfifUtil.MARKER_SOFn}, m5611m = "mergeCapturedAddressIntoEntity", m5612n = {"previousAddressEntity"}, m5613s = {"L$0"})
    static final class C46461 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C46461(Continuation<? super C46461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IdDocumentScanResultViewDataToEntityMapper.this.mergeCapturedAddressIntoEntity(null, null, null, this);
        }
    }

    @Inject
    public IdDocumentScanResultViewDataToEntityMapper(DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper, CountryCodeHelper countryCodeHelper, ImageDimensionsReader imageDimensionsReader, @ForComputation CoroutineContext computationContext) {
        Intrinsics.checkNotNullParameter(documentTypeViewDataToEntityMapper, "documentTypeViewDataToEntityMapper");
        Intrinsics.checkNotNullParameter(countryCodeHelper, "countryCodeHelper");
        Intrinsics.checkNotNullParameter(imageDimensionsReader, "imageDimensionsReader");
        Intrinsics.checkNotNullParameter(computationContext, "computationContext");
        this.documentTypeViewDataToEntityMapper = documentTypeViewDataToEntityMapper;
        this.countryCodeHelper = countryCodeHelper;
        this.imageDimensionsReader = imageDimensionsReader;
        this.computationContext = computationContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mapAddressViewDataToEntity(com.yoti.mobile.android.documentscan.model.result.Address r20, java.lang.String r21, kotlin.coroutines.Continuation<? super com.yoti.mobile.android.documentcapture.p055id.domain.model.AddressEntity> r22) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.mapAddressViewDataToEntity(com.yoti.mobile.android.documentscan.model.result.Address, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object mapCountryCodeToCountryEntity(String str, Continuation<? super AddressEntity.CountryEntity> continuation) {
        return BuildersKt.withContext(this.computationContext, new C46402(str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a5 A[PHI: r12
      0x00a5: PHI (r12v6 java.lang.Object) = (r12v4 java.lang.Object), (r12v1 java.lang.Object) binds: [B:37:0x00a2, B:12:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mapCountryViewDataToEntity(com.yoti.mobile.android.documentscan.model.result.Country r10, java.lang.String r11, kotlin.coroutines.Continuation<? super com.yoti.mobile.android.documentcapture.id.domain.model.AddressEntity.CountryEntity> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.C46411
            if (r0 == 0) goto L13
            r0 = r12
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapCountryViewDataToEntity$1 r0 = (com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.C46411) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapCountryViewDataToEntity$1 r0 = new com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapCountryViewDataToEntity$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L43
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r12)
            goto La5
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            java.lang.Object r10 = r0.L$1
            r11 = r10
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r10 = r0.L$0
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper r10 = (com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper) r10
            kotlin.ResultKt.throwOnFailure(r12)
            goto L90
        L43:
            kotlin.ResultKt.throwOnFailure(r12)
            if (r10 == 0) goto L97
            java.lang.String r12 = r10.getAlpha2()
            if (r12 == 0) goto L7b
            java.util.Locale r2 = new java.util.Locale
            java.lang.String r6 = "en"
            r2.<init>(r6, r12)
            java.util.Locale r2 = com.yoti.mobile.android.yotidocs.common.extension.LocaleExtensionKt.validate(r2)
            if (r2 == 0) goto L75
            java.util.Locale r6 = java.util.Locale.UK
            java.lang.String r6 = r2.getDisplayCountry(r6)
            com.yoti.mobile.android.documentcapture.id.domain.model.AddressEntity$CountryEntity r7 = new com.yoti.mobile.android.documentcapture.id.domain.model.AddressEntity$CountryEntity
            java.lang.String r8 = "countryName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
            java.lang.String r2 = r2.getISO3Country()
            java.lang.String r8 = "locale.isO3Country"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)
            r7.<init>(r6, r2, r12)
            goto L76
        L75:
            r7 = r5
        L76:
            if (r7 != 0) goto L79
            goto L7b
        L79:
            r10 = r9
            goto L93
        L7b:
            java.lang.String r10 = r10.getAlpha3()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r0.L$0 = r9
            r0.L$1 = r11
            r0.label = r4
            java.lang.Object r12 = r9.mapCountryCodeToCountryEntity(r10, r0)
            if (r12 != r1) goto L8f
            return r1
        L8f:
            r10 = r9
        L90:
            r7 = r12
            com.yoti.mobile.android.documentcapture.id.domain.model.AddressEntity$CountryEntity r7 = (com.yoti.mobile.android.documentcapture.id.domain.model.AddressEntity.CountryEntity) r7
        L93:
            if (r7 != 0) goto L96
            goto L98
        L96:
            return r7
        L97:
            r10 = r9
        L98:
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r12 = r10.mapCountryCodeToCountryEntity(r11, r0)
            if (r12 != r1) goto La5
            return r1
        La5:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.mapCountryViewDataToEntity(com.yoti.mobile.android.documentscan.model.result.Country, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Date mapDateViewDataToDate(DateResult dateResult) {
        Long timeStamp;
        if (dateResult == null || (timeStamp = dateResult.getTimeStamp()) == null) {
            return null;
        }
        return new Date(timeStamp.longValue() * 1000);
    }

    private final GenderTypeEntity mapGenderViewDataToEntity(Gender gender) {
        int i = gender == null ? -1 : WhenMappings.$EnumSwitchMapping$0[gender.ordinal()];
        if (i == 1) {
            return GenderTypeEntity.MALE;
        }
        if (i == 2) {
            return GenderTypeEntity.FEMALE;
        }
        if (i == 3) {
            return GenderTypeEntity.TRANSGENDER;
        }
        if (i == 4) {
            return GenderTypeEntity.OTHER;
        }
        if (i != 5) {
            return null;
        }
        return GenderTypeEntity.UNSPECIFIED;
    }

    private final HolderEntity mapHolderViewDataToEntity(Holder holder) {
        String prefix = holder.getPrefix();
        String firstName = holder.getFirstName();
        String givenNames = holder.getGivenNames();
        String middleNames = holder.getMiddleNames();
        String familyName = holder.getFamilyName();
        String suffix = holder.getSuffix();
        String fullName = holder.getFullName();
        Date dateMapDateViewDataToDate = mapDateViewDataToDate(holder.getDateOfBirth());
        String placeOfBirth = holder.getPlaceOfBirth();
        GenderTypeEntity genderTypeEntityMapGenderViewDataToEntity = mapGenderViewDataToEntity(holder.getGender());
        com.yoti.mobile.android.documentscan.model.result.Country nationality = holder.getNationality();
        return new HolderEntity(prefix, firstName, givenNames, middleNames, familyName, suffix, fullName, dateMapDateViewDataToDate, placeOfBirth, genderTypeEntityMapGenderViewDataToEntity, nationality != null ? nationality.getAlpha3() : null);
    }

    private final PageDimensionsEntity mapImageDimensionsToPageDimensionsEntity(ImageDimensions imageDimensions) {
        return new PageDimensionsEntity(imageDimensions.getWidth(), imageDimensions.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00bd -> B:21:0x00be). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mapImageResultsToEntity(java.util.List<com.yoti.mobile.android.documentscan.model.DocumentCaptureResult> r12, kotlin.coroutines.Continuation<? super java.util.List<com.yoti.mobile.android.documentcapture.domain.model.DocumentPageEntity>> r13) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.mapImageResultsToEntity(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mapMainImageViewDataToPageDimensionsEntity(java.lang.String r5, kotlin.coroutines.Continuation<? super com.yoti.mobile.android.documentcapture.domain.model.PageDimensionsEntity> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.C46431
            if (r0 == 0) goto L13
            r0 = r6
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapMainImageViewDataToPageDimensionsEntity$1 r0 = (com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.C46431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapMainImageViewDataToPageDimensionsEntity$1 r0 = new com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapMainImageViewDataToPageDimensionsEntity$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper r5 = (com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader r6 = r4.imageDimensionsReader
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.getDimensions(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r5 = r4
        L46:
            com.yoti.mobile.android.commons.functional.Either r6 = (com.yoti.mobile.android.commons.functional.Either) r6
            boolean r0 = r6 instanceof com.yoti.mobile.android.commons.functional.Either.Failure
            if (r0 == 0) goto L56
            com.yoti.mobile.android.commons.functional.Either$Failure r6 = (com.yoti.mobile.android.commons.functional.Either.Failure) r6
            java.lang.Object r5 = r6.getFailResult()
            com.yoti.mobile.android.yotidocs.common.ImageDecodeError r5 = (com.yoti.mobile.android.yotidocs.common.ImageDecodeError) r5
            r5 = 0
            goto L66
        L56:
            boolean r0 = r6 instanceof com.yoti.mobile.android.commons.functional.Either.Success
            if (r0 == 0) goto L67
            com.yoti.mobile.android.commons.functional.Either$Success r6 = (com.yoti.mobile.android.commons.functional.Either.Success) r6
            java.lang.Object r6 = r6.getSuccessResult()
            com.yoti.mobile.android.yotidocs.common.ImageDimensions r6 = (com.yoti.mobile.android.yotidocs.common.ImageDimensions) r6
            com.yoti.mobile.android.documentcapture.domain.model.PageDimensionsEntity r5 = r5.mapImageDimensionsToPageDimensionsEntity(r6)
        L66:
            return r5
        L67:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.mapMainImageViewDataToPageDimensionsEntity(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mapOcrResultsToEntity(com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData r5, java.lang.String r6, java.util.List<com.yoti.mobile.android.documentscan.model.DocumentCaptureResult> r7, kotlin.coroutines.Continuation<? super com.yoti.mobile.android.documentcapture.p055id.domain.model.OcrResultEntity> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.C46441
            if (r0 == 0) goto L13
            r0 = r8
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapOcrResultsToEntity$1 r0 = (com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.C46441) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapOcrResultsToEntity$1 r0 = new com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mapOcrResultsToEntity$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.L$2
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r0.L$1
            com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData r5 = (com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData) r5
            java.lang.Object r7 = r0.L$0
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper r7 = (com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L51
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r8 = r4.mapScanResultsToEntity(r7, r6, r0)
            if (r8 != r1) goto L50
            return r1
        L50:
            r7 = r4
        L51:
            com.yoti.mobile.android.documentcapture.id.domain.model.DocumentFieldsEntity r8 = (com.yoti.mobile.android.documentcapture.p055id.domain.model.DocumentFieldsEntity) r8
            com.yoti.mobile.android.documentcapture.id.domain.model.OcrResultEntity r0 = new com.yoti.mobile.android.documentcapture.id.domain.model.OcrResultEntity
            com.yoti.mobile.android.documentcapture.id.domain.model.OcrOriginEntity r1 = new com.yoti.mobile.android.documentcapture.id.domain.model.OcrOriginEntity
            com.yoti.mobile.android.documentcapture.view.selection.DocumentTypeViewDataToEntityMapper r7 = r7.documentTypeViewDataToEntityMapper
            com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity$DocumentTypeEntity r5 = r7.map(r5)
            r1.<init>(r5, r6)
            r0.<init>(r1, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.mapOcrResultsToEntity(com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData, java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final PageRegionEntity mapPageRegionViewDataToEntity(DocumentCaptureResult documentCaptureResult) {
        FrameEntity frameEntity;
        RectF cropRegion;
        MetaData metaData = documentCaptureResult.getMetaData();
        if (metaData == null || (cropRegion = metaData.getCropRegion()) == null) {
            frameEntity = null;
        } else {
            frameEntity = new FrameEntity(new CoordinateEntity(cropRegion.left, cropRegion.bottom), new CoordinateEntity(cropRegion.right, cropRegion.bottom), new CoordinateEntity(cropRegion.left, cropRegion.top), new CoordinateEntity(cropRegion.right, cropRegion.top));
        }
        return new PageRegionEntity(PageRegionTypeEntity.FULL_DOCUMENT, frameEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:23:0x00d4, B:29:0x00e0], limit reached: 58 */
    /* JADX WARN: Path cross not found for [B:39:0x0114, B:42:0x0121], limit reached: 58 */
    /* JADX WARN: Path cross not found for [B:50:0x013b, B:53:0x0148], limit reached: 58 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r0v11, types: [T, com.yoti.mobile.android.documentcapture.id.domain.model.HolderEntity] */
    /* JADX WARN: Type inference failed for: r0v13, types: [T, com.yoti.mobile.android.documentcapture.id.domain.model.DocumentFieldsEntity] */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, com.yoti.mobile.android.documentcapture.id.domain.model.HolderEntity] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00ad -> B:21:0x00b0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mapScanResultsToEntity(java.util.List<com.yoti.mobile.android.documentscan.model.DocumentCaptureResult> r25, java.lang.String r26, kotlin.coroutines.Continuation<? super com.yoti.mobile.android.documentcapture.p055id.domain.model.DocumentFieldsEntity> r27) {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.mapScanResultsToEntity(java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mergeCapturedAddressIntoEntity(com.yoti.mobile.android.documentscan.model.result.Address r5, com.yoti.mobile.android.documentcapture.p055id.domain.model.AddressEntity r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.yoti.mobile.android.documentcapture.p055id.domain.model.AddressEntity> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.C46461
            if (r0 == 0) goto L13
            r0 = r8
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mergeCapturedAddressIntoEntity$1 r0 = (com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.C46461) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mergeCapturedAddressIntoEntity$1 r0 = new com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$mergeCapturedAddressIntoEntity$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            r6 = r5
            com.yoti.mobile.android.documentcapture.id.domain.model.AddressEntity r6 = (com.yoti.mobile.android.documentcapture.p055id.domain.model.AddressEntity) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L46
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r8)
            if (r5 == 0) goto L4d
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r8 = r4.mapAddressViewDataToEntity(r5, r7, r0)
            if (r8 != r1) goto L46
            return r1
        L46:
            com.yoti.mobile.android.documentcapture.id.domain.model.AddressEntity r8 = (com.yoti.mobile.android.documentcapture.p055id.domain.model.AddressEntity) r8
            com.yoti.mobile.android.documentcapture.id.domain.model.AddressEntity r5 = com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapperKt.merge(r6, r8)
            goto L4e
        L4d:
            r5 = 0
        L4e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.mergeCapturedAddressIntoEntity(com.yoti.mobile.android.documentscan.model.result.Address, com.yoti.mobile.android.documentcapture.id.domain.model.AddressEntity, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final HolderEntity mergeCapturedHolderIntoEntity(Holder holder, HolderEntity previousHolderEntity) {
        if (holder != null) {
            return IdDocumentScanResultViewDataToEntityMapperKt.merge(previousHolderEntity, mapHolderViewDataToEntity(holder));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.yoti.mobile.android.yotidocs.common.SuspendMapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object map(com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultViewData r11, kotlin.coroutines.Continuation<? super com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentEntity> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.C46381
            if (r0 == 0) goto L13
            r0 = r12
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$map$1 r0 = (com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.C46381) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$map$1 r0 = new com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper$map$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r11 = r0.L$2
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r1 = r0.L$1
            com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanResultViewData r1 = (com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultViewData) r1
            java.lang.Object r0 = r0.L$0
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper r0 = (com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper) r0
            kotlin.ResultKt.throwOnFailure(r12)
            r5 = r11
            goto L83
        L39:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L41:
            java.lang.Object r11 = r0.L$1
            com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanResultViewData r11 = (com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultViewData) r11
            java.lang.Object r2 = r0.L$0
            com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper r2 = (com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L62
        L4d:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.List r12 = r11.getScanResults()
            r0.L$0 = r10
            r0.L$1 = r11
            r0.label = r4
            java.lang.Object r12 = r10.mapImageResultsToEntity(r12, r0)
            if (r12 != r1) goto L61
            return r1
        L61:
            r2 = r10
        L62:
            java.util.List r12 = (java.util.List) r12
            com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData r4 = r11.getDocumentType()
            java.lang.String r5 = r11.getCountryIso3Code()
            java.util.List r6 = r11.getScanResults()
            r0.L$0 = r2
            r0.L$1 = r11
            r0.L$2 = r12
            r0.label = r3
            java.lang.Object r0 = r2.mapOcrResultsToEntity(r4, r5, r6, r0)
            if (r0 != r1) goto L7f
            return r1
        L7f:
            r1 = r11
            r5 = r12
            r12 = r0
            r0 = r2
        L83:
            r8 = r12
            com.yoti.mobile.android.documentcapture.id.domain.model.OcrResultEntity r8 = (com.yoti.mobile.android.documentcapture.p055id.domain.model.OcrResultEntity) r8
            java.lang.String r11 = r1.getResourceId()
            java.lang.String r12 = r1.getCountryIso3Code()
            com.yoti.mobile.android.documentcapture.view.selection.DocumentTypeViewDataToEntityMapper r0 = r0.documentTypeViewDataToEntityMapper
            com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData r2 = r1.getDocumentType()
            com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity$DocumentTypeEntity r0 = r0.map(r2)
            com.yoti.mobile.android.documentcapture.domain.model.DocumentResourceInfoEntity r4 = new com.yoti.mobile.android.documentcapture.domain.model.DocumentResourceInfoEntity
            r4.<init>(r11, r0, r12)
            boolean r6 = r1.getOcrRequired()
            java.util.Map r9 = r1.getMrtdCaptureResult()
            boolean r7 = r1.getNfcAvailable()
            com.yoti.mobile.android.documentcapture.id.domain.model.IdDocumentEntity r11 = new com.yoti.mobile.android.documentcapture.id.domain.model.IdDocumentEntity
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper.map(com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanResultViewData, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
