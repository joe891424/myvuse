package com.bat.sdk.fota;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bat.sdk.FlowEvent;
import com.bat.sdk.JavaUtils;
import com.bat.sdk.ble.BleRequest;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.client.CharacteristicClient;
import com.bat.sdk.client.ota.OtaControlClient;
import com.bat.sdk.client.ota.OtaNewClient;
import com.bat.sdk.client.ota.OtaPayloadClient;
import com.bat.sdk.fota.FirmwareUploadState;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.FotaControl;
import com.bat.sdk.model.FotaVersion;
import com.bat.sdk.presentation.PresentationUtils;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: FotaUploader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001 B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006!"}, m5598d2 = {"Lcom/bat/sdk/fota/FotaUploader;", "", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "otaNewClient", "Lcom/bat/sdk/client/ota/OtaNewClient;", "otaControlClient", "Lcom/bat/sdk/client/ota/OtaControlClient;", "otaPayloadClient", "Lcom/bat/sdk/client/ota/OtaPayloadClient;", "<init>", "(Lcom/bat/sdk/ble/GattManager;Lcom/bat/sdk/client/ota/OtaNewClient;Lcom/bat/sdk/client/ota/OtaControlClient;Lcom/bat/sdk/client/ota/OtaPayloadClient;)V", "_uploadStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bat/sdk/fota/FirmwareUploadState;", "uploadStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getUploadStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_resultStateFlow", "Lcom/bat/sdk/FlowEvent;", "Lcom/bat/sdk/fota/FirmwareUploadResult;", "resultStateFlow", "getResultStateFlow", "upload", "", "context", "Landroid/content/Context;", "deviceAddress", "", "setupData", "Lcom/bat/sdk/fota/FotaSetupData;", "FotaData", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class FotaUploader {
    private final MutableStateFlow<FlowEvent<FirmwareUploadResult>> _resultStateFlow;
    private final MutableStateFlow<FirmwareUploadState> _uploadStateFlow;
    private final GattManager gattManager;
    private final OtaControlClient otaControlClient;
    private final OtaNewClient otaNewClient;
    private final OtaPayloadClient otaPayloadClient;
    private final StateFlow<FlowEvent<FirmwareUploadResult>> resultStateFlow;
    private final StateFlow<FirmwareUploadState> uploadStateFlow;

    public FotaUploader(GattManager gattManager, OtaNewClient otaNewClient, OtaControlClient otaControlClient, OtaPayloadClient otaPayloadClient) {
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        Intrinsics.checkNotNullParameter(otaNewClient, "otaNewClient");
        Intrinsics.checkNotNullParameter(otaControlClient, "otaControlClient");
        Intrinsics.checkNotNullParameter(otaPayloadClient, "otaPayloadClient");
        this.gattManager = gattManager;
        this.otaNewClient = otaNewClient;
        this.otaControlClient = otaControlClient;
        this.otaPayloadClient = otaPayloadClient;
        MutableStateFlow<FirmwareUploadState> MutableStateFlow = StateFlowKt.MutableStateFlow(new FirmwareUploadState.Idle(""));
        this._uploadStateFlow = MutableStateFlow;
        this.uploadStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<FlowEvent<FirmwareUploadResult>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._resultStateFlow = MutableStateFlow2;
        this.resultStateFlow = FlowKt.asStateFlow(MutableStateFlow2);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C15091(null), 3, null);
    }

    public final StateFlow<FirmwareUploadState> getUploadStateFlow() {
        return this.uploadStateFlow;
    }

    public final StateFlow<FlowEvent<FirmwareUploadResult>> getResultStateFlow() {
        return this.resultStateFlow;
    }

    /* JADX INFO: renamed from: com.bat.sdk.fota.FotaUploader$1 */
    /* JADX INFO: compiled from: FotaUploader.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.fota.FotaUploader$1", m5608f = "FotaUploader.kt", m5609i = {}, m5610l = {41}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C15091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C15091(Continuation<? super C15091> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FotaUploader.this.new C15091(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.combine(FotaUploader.this.otaControlClient.getFlow(), FotaUploader.this.getUploadStateFlow(), new AnonymousClass1(null)).collect(new AnonymousClass2(FotaUploader.this), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.sdk.fota.FotaUploader$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: FotaUploader.kt */
        @Metadata(m5597d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012%\u0010\u0002\u001a!0\u0003R\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b2\u0015\u0010\t\u001a\u00110\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000bH\n"}, m5598d2 = {"<anonymous>", "Lcom/bat/sdk/fota/FotaUploader$FotaData;", "otaControl", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/FotaControl;", "Lkotlin/ParameterName;", "name", "a", "uploadState", "Lcom/bat/sdk/fota/FirmwareUploadState;", "b"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.sdk.fota.FotaUploader$1$1", m5608f = "FotaUploader.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function3<CharacteristicClient<FotaControl, FotaControl>.Response, FirmwareUploadState, Continuation<? super FotaData>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(CharacteristicClient<FotaControl, FotaControl>.Response response, FirmwareUploadState firmwareUploadState, Continuation<? super FotaData> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = response;
                anonymousClass1.L$1 = firmwareUploadState;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return new FotaData((CharacteristicClient.Response) this.L$0, (FirmwareUploadState) this.L$1);
            }
        }

        /* JADX INFO: renamed from: com.bat.sdk.fota.FotaUploader$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: FotaUploader.kt */
        @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
        static final class AnonymousClass2<T> implements FlowCollector {
            final /* synthetic */ FotaUploader this$0;

            AnonymousClass2(FotaUploader fotaUploader) {
                this.this$0 = fotaUploader;
            }

            /* JADX WARN: Removed duplicated region for block: B:47:0x01a7  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x0230  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.bat.sdk.fota.FotaUploader.FotaData r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
                /*
                    Method dump skipped, instruction units count: 822
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.fota.FotaUploader.C15091.AnonymousClass2.emit(com.bat.sdk.fota.FotaUploader$FotaData, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((FotaData) obj, (Continuation<? super Unit>) continuation);
            }

            /* JADX INFO: renamed from: com.bat.sdk.fota.FotaUploader$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: FotaUploader.kt */
            @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
            @DebugMetadata(m5607c = "com.bat.sdk.fota.FotaUploader$1$2$1", m5608f = "FotaUploader.kt", m5609i = {}, m5610l = {88}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ FotaData $it;
                int label;
                final /* synthetic */ FotaUploader this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(FotaUploader fotaUploader, FotaData fotaData, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = fotaUploader;
                    this.$it = fotaData;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$it, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    this.this$0.otaControlClient.write(this.$it.getOtaControl().getDeviceAddress(), FotaControl.Complete.INSTANCE);
                    this.this$0._uploadStateFlow.setValue(new FirmwareUploadState.Finishing(this.$it.getOtaControl().getDeviceAddress()));
                    return Unit.INSTANCE;
                }
            }
        }
    }

    public final void upload(Context context, String deviceAddress, FotaSetupData setupData) throws IOException {
        byte[] byteArray;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(setupData, "setupData");
        Logger.INSTANCE.log("uploading firmware");
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(setupData.getFileUri(), RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME);
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            Logger.INSTANCE.log("file descriptor is null");
            return;
        }
        int statSize = (int) parcelFileDescriptorOpenFileDescriptor.getStatSize();
        byte[] bArr = new byte[statSize];
        new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).read(bArr);
        Logger.INSTANCE.log("file is read: " + statSize);
        ArrayList arrayList = new ArrayList();
        int length = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, statSize - 1, ISO7816Kt.INS_CREATE_FILE);
        if (progressionLastElement >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + ISO7816Kt.INS_CREATE_FILE;
                if (i + 223 >= statSize) {
                    byteArray = CollectionsKt.toByteArray(ArraysKt.slice(bArr, RangesKt.until(i, statSize)));
                } else {
                    byteArray = CollectionsKt.toByteArray(ArraysKt.slice(bArr, RangesKt.until(i, i2)));
                }
                arrayList.add(byteArray);
                if (i == progressionLastElement) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        Logger.INSTANCE.log("file is split into chunks");
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            length += ((byte[]) it2.next()).length;
        }
        if (length != statSize) {
            Logger.INSTANCE.log("chunks size is not equal to original bytes size");
        } else {
            Logger.INSTANCE.log("chunk size is fine");
        }
        byte[] md5Bytes = JavaUtils.getMd5Bytes(bArr);
        int versionMajor = setupData.getVersionMajor();
        int versionMinor = setupData.getVersionMinor();
        int versionRevision = setupData.getVersionRevision();
        String gitTag = setupData.getGitTag();
        int fileObjectId = setupData.getFileObjectId();
        Intrinsics.checkNotNull(md5Bytes);
        FotaVersion fotaVersion = new FotaVersion(versionMajor, versionMinor, versionRevision, gitTag, statSize, fileObjectId, md5Bytes);
        Logger.INSTANCE.log("starting upload");
        String strExtractFilename = PresentationUtils.INSTANCE.extractFilename(context, setupData.getFileUri());
        if (strExtractFilename == null) {
            strExtractFilename = "could not get filename";
        }
        FirmwareUploadState.Started started = new FirmwareUploadState.Started(deviceAddress, strExtractFilename, fotaVersion, arrayList);
        this.otaControlClient.setIndicationEnabled(deviceAddress, true);
        this.gattManager.enqueue(new BleRequest.Mtu(deviceAddress, 240));
        this.otaNewClient.write(deviceAddress, fotaVersion);
        this._uploadStateFlow.setValue(started);
    }

    /* JADX INFO: compiled from: FotaUploader.kt */
    @Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u0002\u001a\u00120\u0003R\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000e\u001a\u00120\u0003R\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u00120\u0003R\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R!\u0010\u0002\u001a\u00120\u0003R\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, m5598d2 = {"Lcom/bat/sdk/fota/FotaUploader$FotaData;", "", "otaControl", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/FotaControl;", "uploadState", "Lcom/bat/sdk/fota/FirmwareUploadState;", "<init>", "(Lcom/bat/sdk/client/CharacteristicClient$Response;Lcom/bat/sdk/fota/FirmwareUploadState;)V", "getOtaControl", "()Lcom/bat/sdk/client/CharacteristicClient$Response;", "getUploadState", "()Lcom/bat/sdk/fota/FirmwareUploadState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class FotaData {
        private final CharacteristicClient<FotaControl, FotaControl>.Response otaControl;
        private final FirmwareUploadState uploadState;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FotaData copy$default(FotaData fotaData, CharacteristicClient.Response response, FirmwareUploadState firmwareUploadState, int i, Object obj) {
            if ((i & 1) != 0) {
                response = fotaData.otaControl;
            }
            if ((i & 2) != 0) {
                firmwareUploadState = fotaData.uploadState;
            }
            return fotaData.copy(response, firmwareUploadState);
        }

        public final CharacteristicClient<FotaControl, FotaControl>.Response component1() {
            return this.otaControl;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final FirmwareUploadState getUploadState() {
            return this.uploadState;
        }

        public final FotaData copy(CharacteristicClient<FotaControl, FotaControl>.Response otaControl, FirmwareUploadState uploadState) {
            Intrinsics.checkNotNullParameter(otaControl, "otaControl");
            Intrinsics.checkNotNullParameter(uploadState, "uploadState");
            return new FotaData(otaControl, uploadState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FotaData)) {
                return false;
            }
            FotaData fotaData = (FotaData) other;
            return Intrinsics.areEqual(this.otaControl, fotaData.otaControl) && Intrinsics.areEqual(this.uploadState, fotaData.uploadState);
        }

        public int hashCode() {
            return (this.otaControl.hashCode() * 31) + this.uploadState.hashCode();
        }

        public String toString() {
            return "FotaData(otaControl=" + this.otaControl + ", uploadState=" + this.uploadState + ')';
        }

        public FotaData(CharacteristicClient<FotaControl, FotaControl>.Response otaControl, FirmwareUploadState uploadState) {
            Intrinsics.checkNotNullParameter(otaControl, "otaControl");
            Intrinsics.checkNotNullParameter(uploadState, "uploadState");
            this.otaControl = otaControl;
            this.uploadState = uploadState;
        }

        public final CharacteristicClient<FotaControl, FotaControl>.Response getOtaControl() {
            return this.otaControl;
        }

        public final FirmwareUploadState getUploadState() {
            return this.uploadState;
        }
    }
}
