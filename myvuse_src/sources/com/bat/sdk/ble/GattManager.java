package com.bat.sdk.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.bat.sdk.BatSdk;
import com.bat.sdk.ble.BleRequest;
import com.bat.sdk.ble.ConnectionState;
import com.bat.sdk.ble.DiscoveryServicesState;
import com.bat.sdk.client.AgeChallengeClient;
import com.bat.sdk.client.AgeSignatureClient;
import com.bat.sdk.client.BatteryClient;
import com.bat.sdk.client.BuzzerClient;
import com.bat.sdk.client.CloudClient;
import com.bat.sdk.client.DeviceInfoClient;
import com.bat.sdk.client.ErrorClient;
import com.bat.sdk.client.FindVapeClient;
import com.bat.sdk.client.HapticClient;
import com.bat.sdk.client.LedClient;
import com.bat.sdk.client.LockClient;
import com.bat.sdk.client.LogsClient;
import com.bat.sdk.client.PodConnectionClient;
import com.bat.sdk.client.PowerSaveModeClient;
import com.bat.sdk.client.PuffsClient;
import com.bat.sdk.client.ResetClient;
import com.bat.sdk.client.SessionIndicationClient;
import com.bat.sdk.client.TimeClient;
import com.bat.sdk.client.TimeoutAutoLockClient;
import com.bat.sdk.client.payload.PayloadChallengeClient;
import com.bat.sdk.client.payload.PayloadClient;
import com.bat.sdk.client.payload.PayloadControlClient;
import com.bat.sdk.client.payload.PayloadVersionClient;
import com.bat.sdk.devices.BatVocabulary;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import com.facebook.react.uimanager.ViewProps;
import com.heanoria.library.reactnative.locationenabler.AndroidLocationEnablerModule;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.api.common.CarrierType;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.yoti.mobile.android.facecapture.view.capture.util.FaceCaptureConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: GattManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J:\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\u0018\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$J\u000e\u00100\u001a\u00020&2\u0006\u0010*\u001a\u00020\u001fJ\u0006\u00101\u001a\u00020&J\u0018\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020\u001f2\b\b\u0002\u00104\u001a\u00020.J\u000e\u00105\u001a\u00020&2\u0006\u00103\u001a\u00020\u001fJ\u0006\u00106\u001a\u00020&J\u0006\u00107\u001a\u00020&J\u000e\u00108\u001a\u00020&2\u0006\u00103\u001a\u00020\u001fJ\u000e\u00109\u001a\u00020&2\u0006\u0010*\u001a\u00020\u001fJ\u000e\u0010:\u001a\u00020&2\u0006\u00103\u001a\u00020\u001fJ\u000e\u0010;\u001a\u00020.2\u0006\u00103\u001a\u00020\u001fJ\u0016\u0010<\u001a\u00020.2\u0006\u00103\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020&2\u0006\u00103\u001a\u00020\u001fJ\u000e\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u00020\u001aJ,\u0010B\u001a\u00020&2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020,2\u0014\b\u0002\u0010/\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0DJ\u001e\u0010E\u001a\u00020&2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020,2\u0006\u0010F\u001a\u00020%J\u001e\u0010G\u001a\u00020&2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020,2\u0006\u0010H\u001a\u00020.J\u001e\u0010I\u001a\u00020&2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020,2\u0006\u0010H\u001a\u00020.J\u000e\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020LJ\u001e\u0010M\u001a\u00020&2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010O\u001a\u00020\u001aH\u0002J\u0010\u0010P\u001a\u00020&2\u0006\u0010Q\u001a\u00020\u001aH\u0002J\u0010\u0010R\u001a\u00020&2\u0006\u0010S\u001a\u00020\u001aH\u0002J\u000e\u0010T\u001a\u00020&2\u0006\u00103\u001a\u00020\u001fJ\u0010\u0010U\u001a\u00020&2\u0006\u00103\u001a\u00020\u001fH\u0002J\u0010\u0010V\u001a\u00020&2\u0006\u00103\u001a\u00020\u001fH\u0002J\u000e\u0010W\u001a\u00020.2\u0006\u00103\u001a\u00020\u001fJ\u0006\u0010X\u001a\u00020.J\u0006\u0010Y\u001a\u00020.J\u0006\u0010Z\u001a\u00020.J\u0016\u0010[\u001a\u00020.2\u0006\u00103\u001a\u00020\u001f2\u0006\u0010\\\u001a\u00020\u001fJ\u0010\u0010]\u001a\u00020&2\u0006\u00103\u001a\u00020\u001fH\u0002J\u0010\u0010^\u001a\u00020&2\u0006\u00103\u001a\u00020\u001fH\u0002J\u0006\u0010_\u001a\u00020&J\u0006\u0010`\u001a\u00020&J\u0012\u0010a\u001a\u00020&2\b\u0010b\u001a\u0004\u0018\u00010cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010!\u001a2\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020#0\"\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$0\u00190\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000¨\u0006d"}, m5598d2 = {"Lcom/bat/sdk/ble/GattManager;", "Landroid/bluetooth/BluetoothGattCallback;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "_devices", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/bat/sdk/ble/BleDeviceData;", "devices", "Lkotlinx/coroutines/flow/StateFlow;", "getDevices", "()Lkotlinx/coroutines/flow/StateFlow;", "_connectedDevice", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "connectedDevice", "Lkotlinx/coroutines/flow/SharedFlow;", "getConnectedDevice", "()Lkotlinx/coroutines/flow/SharedFlow;", "_gatErrorStateFlow", "Lcom/bat/sdk/ble/GattError;", "gatErrorStateFlow", "getGatErrorStateFlow", "requests", "", "Lcom/bat/sdk/ble/BleRequest;", "pendingRequests", "completedRequests", "deviceRequestsTimeouts", "", "", "", "notificationCallbacks", "Lkotlin/Pair;", "Ljava/util/UUID;", "Lkotlin/Function2;", "", "", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "listenTo", "deviceAddress", "characteristic", "Lcom/bat/sdk/ble/BatCharacteristic;", "cleanPreviousCallbacks", "", "callback", "clearRequestsForDevice", "clearAllRequests", "connect", "address", "autoConnect", "disconnect", "disconnectAll", "closeGattAll", "closeGatt", "discoverServices", "refreshCacheAndDiscoverServices", "isDeviceConnected", "isDeviceType", "type", "Lcom/bat/sdk/model/DeviceType;", "unbondPairedDevice", "enqueue", "request", "enqueueRead", "batCharacteristic", "Lkotlin/Function1;", "enqueueWrite", "bytes", "enqueueNotify", ViewProps.ENABLED, "enqueueIndicate", "process", AndroidLocationEnablerModule.LOCATION_INTERVAL_DURATION_PARAMS_KEY, "", "removeFromList", "list", "element", "deleteCompletedRequests", "completedRequest", "completeRequest", "pendingRequest", "refreshDeviceCache", "subscribeAll", "unsubscribeAll", "isRequestPresent", "isRequestReadDeviceInfoPresent", "isRequestProximityUnlockPresent", "isRequestPodConnectionPresent", "isCharacteristicPresent", AnalyticsAttribute.UUID_ATTRIBUTE, "cleanCharacteristics", "clearNotificationCallbacks", "printRequestList", "printPendingRequests", "printGatServices", "gatt", "Landroid/bluetooth/BluetoothGatt;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class GattManager extends BluetoothGattCallback {
    private MutableSharedFlow<BleDeviceData> _connectedDevice;
    private MutableStateFlow<List<BleDeviceData>> _devices;
    private MutableStateFlow<GattError> _gatErrorStateFlow;
    private BluetoothAdapter bluetoothAdapter;
    private final List<BleRequest> completedRequests;
    private final SharedFlow<BleDeviceData> connectedDevice;
    private final Context context;
    private final Map<String, Integer> deviceRequestsTimeouts;
    private final StateFlow<List<BleDeviceData>> devices;
    private final StateFlow<GattError> gatErrorStateFlow;
    private Map<Pair<String, UUID>, List<Function2<String, byte[], Unit>>> notificationCallbacks;
    private final List<BleRequest> pendingRequests;
    private final List<BleRequest> requests;

    public GattManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        MutableStateFlow<List<BleDeviceData>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._devices = MutableStateFlow;
        this.devices = FlowKt.asStateFlow(MutableStateFlow);
        MutableSharedFlow<BleDeviceData> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 6, null);
        this._connectedDevice = mutableSharedFlowMutableSharedFlow$default;
        this.connectedDevice = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        MutableStateFlow<GattError> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._gatErrorStateFlow = MutableStateFlow2;
        this.gatErrorStateFlow = FlowKt.asStateFlow(MutableStateFlow2);
        this.requests = new ArrayList();
        this.pendingRequests = new ArrayList();
        this.completedRequests = new ArrayList();
        this.deviceRequestsTimeouts = new LinkedHashMap();
        this.notificationCallbacks = new LinkedHashMap();
    }

    public final StateFlow<List<BleDeviceData>> getDevices() {
        return this.devices;
    }

    public final SharedFlow<BleDeviceData> getConnectedDevice() {
        return this.connectedDevice;
    }

    public final StateFlow<GattError> getGatErrorStateFlow() {
        return this.gatErrorStateFlow;
    }

    public static /* synthetic */ void listenTo$default(GattManager gattManager, String str, BatCharacteristic batCharacteristic, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        gattManager.listenTo(str, batCharacteristic, z, function2);
    }

    public final void listenTo(String deviceAddress, BatCharacteristic characteristic, boolean cleanPreviousCallbacks, Function2<? super String, ? super byte[], Unit> callback) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Pair<String, UUID> pair = new Pair<>(deviceAddress, characteristic.getUuid());
        if (!cleanPreviousCallbacks && this.notificationCallbacks.containsKey(pair)) {
            List<Function2<String, byte[], Unit>> list = this.notificationCallbacks.get(pair);
            Intrinsics.checkNotNull(list);
            list.add(callback);
            return;
        }
        this.notificationCallbacks.put(pair, CollectionsKt.mutableListOf(callback));
    }

    public final void clearRequestsForDevice(final String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "cleared all requests for " + deviceAddress);
        CollectionsKt.removeAll((List) this.requests, new Function1() { // from class: com.bat.sdk.ble.GattManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(GattManager.clearRequestsForDevice$lambda$0(deviceAddress, (BleRequest) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clearRequestsForDevice$lambda$0(String deviceAddress, BleRequest it2) {
        Intrinsics.checkNotNullParameter(deviceAddress, "$deviceAddress");
        Intrinsics.checkNotNullParameter(it2, "it");
        return Intrinsics.areEqual(it2.getDeviceAddress(), deviceAddress);
    }

    public final void clearAllRequests() {
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "cleared all requests for all devices");
        this.requests.clear();
    }

    public static /* synthetic */ void connect$default(GattManager gattManager, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        gattManager.connect(str, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void connect(java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.ble.GattManager.connect(java.lang.String, boolean):void");
    }

    /* JADX INFO: renamed from: com.bat.sdk.ble.GattManager$disconnect$1 */
    /* JADX INFO: compiled from: GattManager.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.ble.GattManager$disconnect$1", m5608f = "GattManager.kt", m5609i = {}, m5610l = {463}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $address;
        int label;
        final /* synthetic */ GattManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14991(String str, GattManager gattManager, Continuation<? super C14991> continuation) {
            super(2, continuation);
            this.$address = str;
            this.this$0 = gattManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C14991(this.$address, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object next;
            BluetoothGatt gatt;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PuffsClient puffsClient = BatSdk.INSTANCE.getPuffsClient();
                if (puffsClient != null) {
                    puffsClient.setIndicationEnabled(this.$address, false);
                }
                LogsClient logsClient = BatSdk.INSTANCE.getLogsClient();
                if (logsClient != null) {
                    logsClient.setIndicationEnabled(this.$address, false);
                }
                this.label = 1;
                if (DelayKt.delay(FaceCaptureConstants.DURATION_FACE_DETECT_SHIMMER_ANIMATION_MS, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Iterable iterable = (Iterable) this.this$0._devices.getValue();
            String str = this.$address;
            Iterator it2 = iterable.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (Intrinsics.areEqual(((BleDeviceData) next).getAddress(), str)) {
                    break;
                }
            }
            BleDeviceData bleDeviceData = (BleDeviceData) next;
            if (bleDeviceData != null && (gatt = bleDeviceData.getGatt()) != null) {
                gatt.disconnect();
            }
            return Unit.INSTANCE;
        }
    }

    public final void disconnect(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "disconnect for " + address);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C14991(address, this, null), 3, null);
    }

    public final void disconnectAll() {
        List<BleDeviceData> value;
        ArrayList arrayList;
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "BLE - disconnect all devices");
        MutableStateFlow<List<BleDeviceData>> mutableStateFlow = this._devices;
        do {
            value = mutableStateFlow.getValue();
            List<BleDeviceData> list = value;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (BleDeviceData bleDeviceData : list) {
                arrayList.add(bleDeviceData.copy((189 & 1) != 0 ? bleDeviceData.gatt : null, (189 & 2) != 0 ? bleDeviceData.connectionState : ConnectionState.Disconnected.INSTANCE, (189 & 4) != 0 ? bleDeviceData.name : null, (189 & 8) != 0 ? bleDeviceData.rssi : 0, (189 & 16) != 0 ? bleDeviceData.deviceType : null, (189 & 32) != 0 ? bleDeviceData.services : null, (189 & 64) != 0 ? bleDeviceData.discoveryServicesState : DiscoveryServicesState.NotDiscovered.INSTANCE, (189 & 128) != 0 ? bleDeviceData.btCallback : null));
            }
        } while (!mutableStateFlow.compareAndSet(value, arrayList));
        Iterator<T> it2 = this._devices.getValue().iterator();
        while (it2.hasNext()) {
            disconnect(((BleDeviceData) it2.next()).getAddress());
        }
    }

    public final void closeGattAll() {
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "BLE - Close all gatt and disconnect all");
        disconnectAll();
        for (BleDeviceData bleDeviceData : this._devices.getValue()) {
            Logger.INSTANCE.log("close device " + bleDeviceData.getAddress());
            BluetoothGatt gatt = bleDeviceData.getGatt();
            if (gatt != null) {
                gatt.close();
            }
            bleDeviceData.setGatt(null);
            bleDeviceData.setBtCallback(null);
            cleanCharacteristics(bleDeviceData.getAddress());
            clearNotificationCallbacks(bleDeviceData.getAddress());
        }
        this._devices.setValue(CollectionsKt.emptyList());
        this.notificationCallbacks = new LinkedHashMap();
    }

    public final void closeGatt(String address) {
        Object next;
        Intrinsics.checkNotNullParameter(address, "address");
        Iterator<T> it2 = this._devices.getValue().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            } else {
                next = it2.next();
                if (Intrinsics.areEqual(((BleDeviceData) next).getAddress(), address)) {
                    break;
                }
            }
        }
        BleDeviceData bleDeviceData = (BleDeviceData) next;
        Logger.INSTANCE.log("close device " + (bleDeviceData != null ? bleDeviceData.getAddress() : null));
        if (bleDeviceData != null) {
            BluetoothGatt gatt = bleDeviceData.getGatt();
            if (gatt != null) {
                gatt.close();
            }
            bleDeviceData.setGatt(null);
            bleDeviceData.setBtCallback(null);
            MutableStateFlow<List<BleDeviceData>> mutableStateFlow = this._devices;
            mutableStateFlow.setValue(CollectionsKt.minus(mutableStateFlow.getValue(), bleDeviceData));
            cleanCharacteristics(bleDeviceData.getAddress());
            clearNotificationCallbacks(bleDeviceData.getAddress());
        }
    }

    public final void discoverServices(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Logger.INSTANCE.log("enqueue discover services for " + deviceAddress);
        enqueue(new BleRequest.DiscoverServices(deviceAddress));
    }

    /* JADX INFO: renamed from: com.bat.sdk.ble.GattManager$refreshCacheAndDiscoverServices$1 */
    /* JADX INFO: compiled from: GattManager.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.ble.GattManager$refreshCacheAndDiscoverServices$1", m5608f = "GattManager.kt", m5609i = {0}, m5610l = {525}, m5611m = "invokeSuspend", m5612n = {"$this$launch"}, m5613s = {"L$0"})
    static final class C15001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $address;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15001(String str, Continuation<? super C15001> continuation) {
            super(2, continuation);
            this.$address = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15001 c15001 = GattManager.this.new C15001(this.$address, continuation);
            c15001.L$0 = obj;
            return c15001;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                GattManager.this.refreshDeviceCache(this.$address);
                this.L$0 = coroutineScope2;
                this.label = 1;
                if (DelayKt.delay(FaceCaptureConstants.DURATION_FACE_DETECT_SHIMMER_ANIMATION_MS, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Logger logger = Logger.INSTANCE;
            String name = coroutineScope.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            logger.log(name, "Start discovering services " + this.$address);
            GattManager.this.discoverServices(this.$address);
            return Unit.INSTANCE;
        }
    }

    public final void refreshCacheAndDiscoverServices(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C15001(address, null), 3, null);
    }

    public final boolean isDeviceConnected(String address) {
        Object next;
        Intrinsics.checkNotNullParameter(address, "address");
        Object systemService = this.context.getSystemService(CarrierType.BLUETOOTH);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothManager bluetoothManager = (BluetoothManager) systemService;
        Iterator<T> it2 = this.devices.getValue().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (Intrinsics.areEqual(((BleDeviceData) next).getAddress(), address)) {
                break;
            }
        }
        BleDeviceData bleDeviceData = (BleDeviceData) next;
        if (bleDeviceData == null || bleDeviceData.getGatt() == null) {
            return false;
        }
        BluetoothGatt gatt = bleDeviceData.getGatt();
        int connectionState = bluetoothManager.getConnectionState(gatt != null ? gatt.getDevice() : null, 7);
        return (Intrinsics.areEqual(bleDeviceData.getConnectionState(), ConnectionState.Disconnected.INSTANCE) || Intrinsics.areEqual(bleDeviceData.getConnectionState(), ConnectionState.Disconnecting.INSTANCE) || connectionState == 0 || connectionState == 3) ? false : true;
    }

    public final boolean isDeviceType(String address, DeviceType type) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(type, "type");
        for (BleDeviceData bleDeviceData : this.devices.getValue()) {
            if (Intrinsics.areEqual(bleDeviceData.getAddress(), address)) {
                return Intrinsics.areEqual(bleDeviceData.getDeviceType(), type);
            }
        }
        return false;
    }

    public final void unbondPairedDevice(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "unbond device " + address);
        BluetoothAdapter bluetoothAdapter = this.bluetoothAdapter;
        Object obj = null;
        if (bluetoothAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bluetoothAdapter");
            bluetoothAdapter = null;
        }
        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
        Intrinsics.checkNotNullExpressionValue(bondedDevices, "getBondedDevices(...)");
        Iterator<T> it2 = bondedDevices.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            BluetoothDevice bluetoothDevice = (BluetoothDevice) next;
            if (Intrinsics.areEqual(bluetoothDevice.getAddress(), address) && bluetoothDevice.getBondState() == 12) {
                obj = next;
                break;
            }
        }
        BluetoothDevice bluetoothDevice2 = (BluetoothDevice) obj;
        if (bluetoothDevice2 == null) {
            Logger logger2 = Logger.INSTANCE;
            String name2 = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            logger2.log(name2, "device " + address + " is not bonded");
            return;
        }
        try {
            Method method = bluetoothDevice2.getClass().getMethod("removeBond", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(method, "getMethod(...)");
            method.invoke(bluetoothDevice2, new Object[0]);
        } catch (Exception e) {
            Logger logger3 = Logger.INSTANCE;
            String name3 = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
            StringBuilder sb = new StringBuilder("Removing has been failed. ");
            String message = e.getMessage();
            Intrinsics.checkNotNull(message);
            logger3.log(name3, sb.append(message).toString());
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void enqueue(BleRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Logger.INSTANCE.log("enqueuing " + request + " for " + request.getDeviceAddress());
        this.requests.add(request);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void enqueueRead$default(GattManager gattManager, String str, BatCharacteristic batCharacteristic, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: com.bat.sdk.ble.GattManager$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return GattManager.enqueueRead$lambda$14((byte[]) obj2);
                }
            };
        }
        gattManager.enqueueRead(str, batCharacteristic, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit enqueueRead$lambda$14(byte[] it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Unit.INSTANCE;
    }

    public final void enqueueRead(String deviceAddress, BatCharacteristic batCharacteristic, Function1<? super byte[], Unit> callback) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(batCharacteristic, "batCharacteristic");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger.INSTANCE.log("enqueue read from " + batCharacteristic.getName() + " for " + deviceAddress);
        this.requests.add(new BleRequest.Read(deviceAddress, batCharacteristic, callback));
    }

    public final void enqueueWrite(String deviceAddress, BatCharacteristic batCharacteristic, byte[] bytes) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(batCharacteristic, "batCharacteristic");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Logger.INSTANCE.log("enqueue write to " + batCharacteristic.getName() + " for " + deviceAddress + ", bytes:" + ConversionExtensionsKt.toHex(bytes));
        this.requests.add(new BleRequest.Write(deviceAddress, batCharacteristic, bytes));
    }

    public final void enqueueNotify(String deviceAddress, BatCharacteristic batCharacteristic, boolean enabled) {
        BleRequest.DisableNotification disableNotification;
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(batCharacteristic, "batCharacteristic");
        Logger.INSTANCE.log("enqueue notify " + enabled + " for " + batCharacteristic.getName() + " for " + deviceAddress);
        if (enabled) {
            disableNotification = new BleRequest.EnableNotification(deviceAddress, batCharacteristic);
        } else {
            disableNotification = new BleRequest.DisableNotification(deviceAddress, batCharacteristic);
        }
        this.requests.add(disableNotification);
    }

    public final void enqueueIndicate(String deviceAddress, BatCharacteristic batCharacteristic, boolean enabled) {
        BleRequest.DisableIndication disableIndication;
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(batCharacteristic, "batCharacteristic");
        Logger.INSTANCE.log("enqueue indicate " + enabled + " for " + batCharacteristic.getName() + " for " + deviceAddress);
        if (enabled) {
            disableIndication = new BleRequest.EnableIndication(deviceAddress, batCharacteristic);
        } else {
            disableIndication = new BleRequest.DisableIndication(deviceAddress, batCharacteristic);
        }
        this.requests.add(disableIndication);
    }

    public final void process(long interval) {
        Object next;
        Object next2;
        Object next3;
        List<BleDeviceData> value;
        ArrayList arrayList;
        Iterator<T> it2 = this.completedRequests.iterator();
        while (it2.hasNext()) {
            deleteCompletedRequests((BleRequest) it2.next());
        }
        Iterator<BleRequest> it3 = this.pendingRequests.iterator();
        if (it3.hasNext()) {
            BleRequest next4 = it3.next();
            if (this.completedRequests.contains(next4)) {
                Logger logger = Logger.INSTANCE;
                String name = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                BleRequest bleRequest = next4;
                logger.log(name, "CompletedReq list contains pendingRequest:" + bleRequest.getDeviceAddress() + SafeJsonPrimitive.NULL_CHAR + bleRequest.getBatCharacteristic() + SafeJsonPrimitive.NULL_CHAR + bleRequest.getMillisCount());
                return;
            }
            Iterator<T> it4 = this._devices.getValue().iterator();
            while (true) {
                if (!it4.hasNext()) {
                    next3 = null;
                    break;
                }
                next3 = it4.next();
                BleRequest bleRequest2 = next4;
                if (Intrinsics.areEqual(((BleDeviceData) next3).getAddress(), bleRequest2 != null ? bleRequest2.getDeviceAddress() : null)) {
                    break;
                }
            }
            BleDeviceData bleDeviceData = (BleDeviceData) next3;
            if ((bleDeviceData != null ? bleDeviceData.getConnectionState() : null) instanceof ConnectionState.Connected) {
                BleRequest bleRequest3 = next4;
                bleRequest3.setMillisCount(bleRequest3.getMillisCount() + interval);
                if (bleRequest3.getMillisCount() > bleRequest3.getTimeout()) {
                    this.deviceRequestsTimeouts.put(bleRequest3.getDeviceAddress(), Integer.valueOf(this.deviceRequestsTimeouts.getOrDefault(bleRequest3.getDeviceAddress(), 0).intValue() + 1));
                    Logger logger2 = Logger.INSTANCE;
                    String name2 = getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    logger2.log(name2, "request " + next4 + " timed out for " + bleRequest3.getDeviceAddress() + " - requestsTimingOut: " + this.deviceRequestsTimeouts.get(bleRequest3.getDeviceAddress()) + " millCount:" + bleRequest3.getMillisCount());
                    removeFromList(this.requests, bleRequest3);
                    it3.remove();
                    if (this.deviceRequestsTimeouts.getOrDefault(bleRequest3.getDeviceAddress(), 0).intValue() >= 10) {
                        Logger logger3 = Logger.INSTANCE;
                        String name3 = getClass().getName();
                        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                        logger3.log(name3, "Disconnecting device " + bleRequest3.getDeviceAddress() + " too much timeouts");
                        disconnect(bleRequest3.getDeviceAddress());
                        MutableStateFlow<List<BleDeviceData>> mutableStateFlow = this._devices;
                        do {
                            value = mutableStateFlow.getValue();
                            List<BleDeviceData> list = value;
                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            for (BleDeviceData bleDeviceDataCopy : list) {
                                if (Intrinsics.areEqual(bleDeviceDataCopy.getAddress(), bleRequest3.getDeviceAddress())) {
                                    Logger.INSTANCE.log("Disconnecting device " + bleRequest3.getDeviceAddress() + " update device list");
                                    bleDeviceDataCopy = bleDeviceDataCopy.copy((189 & 1) != 0 ? bleDeviceDataCopy.gatt : null, (189 & 2) != 0 ? bleDeviceDataCopy.connectionState : ConnectionState.Disconnected.INSTANCE, (189 & 4) != 0 ? bleDeviceDataCopy.name : null, (189 & 8) != 0 ? bleDeviceDataCopy.rssi : 0, (189 & 16) != 0 ? bleDeviceDataCopy.deviceType : null, (189 & 32) != 0 ? bleDeviceDataCopy.services : null, (189 & 64) != 0 ? bleDeviceDataCopy.discoveryServicesState : DiscoveryServicesState.NotDiscovered.INSTANCE, (189 & 128) != 0 ? bleDeviceDataCopy.btCallback : null);
                                }
                                arrayList.add(bleDeviceDataCopy);
                            }
                        } while (!mutableStateFlow.compareAndSet(value, arrayList));
                        if (next4 != null) {
                            this.deviceRequestsTimeouts.remove(bleRequest3.getDeviceAddress());
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            Logger logger4 = Logger.INSTANCE;
            StringBuilder sbAppend = new StringBuilder("removeFromList ").append(next4).append(" device ");
            BleRequest bleRequest4 = next4;
            logger4.log(sbAppend.append(bleRequest4.getDeviceAddress()).append(SafeJsonPrimitive.NULL_CHAR).toString());
            removeFromList(this.requests, bleRequest4);
            it3.remove();
            return;
        }
        BleRequest bleRequest5 = (BleRequest) CollectionsKt.firstOrNull((List) this.requests);
        if (bleRequest5 == null) {
            return;
        }
        Logger logger5 = Logger.INSTANCE;
        String name4 = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
        logger5.log(name4, "processing " + bleRequest5 + " for " + bleRequest5.getDeviceAddress() + ", total requests: " + this.requests.size());
        Iterator<T> it5 = this._devices.getValue().iterator();
        while (true) {
            if (it5.hasNext()) {
                next = it5.next();
                if (Intrinsics.areEqual(((BleDeviceData) next).getAddress(), bleRequest5 != null ? bleRequest5.getDeviceAddress() : null)) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        BleDeviceData bleDeviceData2 = (BleDeviceData) next;
        if (!((bleDeviceData2 != null ? bleDeviceData2.getConnectionState() : null) instanceof ConnectionState.Connected)) {
            removeFromList(this.requests, bleRequest5);
            Logger.INSTANCE.log("can't execute request for device " + bleRequest5.getDeviceAddress() + " - device is not in CONNECTED state");
            return;
        }
        Iterator<T> it6 = this._devices.getValue().iterator();
        while (true) {
            if (it6.hasNext()) {
                next2 = it6.next();
                if (Intrinsics.areEqual(((BleDeviceData) next2).getAddress(), bleRequest5 != null ? bleRequest5.getDeviceAddress() : null)) {
                    break;
                }
            } else {
                next2 = null;
                break;
            }
        }
        BleDeviceData bleDeviceData3 = (BleDeviceData) next2;
        if (bleDeviceData3 == null) {
            return;
        }
        if (bleRequest5.getNeedsPending()) {
            Logger logger6 = Logger.INSTANCE;
            String name5 = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name5, "getName(...)");
            StringBuilder sbAppend2 = new StringBuilder("Executing request ").append(bleRequest5.getBatCharacteristic()).append(", ").append(bleRequest5.getDeviceAddress()).append(", ");
            BluetoothGatt gatt = bleDeviceData3.getGatt();
            Intrinsics.checkNotNull(gatt);
            logger6.log(name5, sbAppend2.append(gatt.getDevice().getAddress()).toString());
            BluetoothGatt gatt2 = bleDeviceData3.getGatt();
            Intrinsics.checkNotNull(gatt2);
            List<BluetoothGattService> services = gatt2.getServices();
            Intrinsics.checkNotNullExpressionValue(services, "getServices(...)");
            Iterator<T> it7 = services.iterator();
            while (it7.hasNext()) {
                List<BluetoothGattCharacteristic> characteristics = ((BluetoothGattService) it7.next()).getCharacteristics();
                Intrinsics.checkNotNullExpressionValue(characteristics, "getCharacteristics(...)");
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                    UUID uuid = bluetoothGattCharacteristic.getUuid();
                    BatCharacteristic batCharacteristic = bleRequest5.getBatCharacteristic();
                    if (Intrinsics.areEqual(uuid, batCharacteristic != null ? batCharacteristic.getUuid() : null)) {
                        Logger logger7 = Logger.INSTANCE;
                        String name6 = getClass().getName();
                        Intrinsics.checkNotNullExpressionValue(name6, "getName(...)");
                        StringBuilder sbAppend3 = new StringBuilder().append(bleRequest5.getBatCharacteristic()).append(", gatt:").append(bleDeviceData3.getGatt()).append(", gatt:");
                        BluetoothGatt gatt3 = bleDeviceData3.getGatt();
                        Intrinsics.checkNotNull(gatt3);
                        logger7.log(name6, sbAppend3.append(gatt3.getDevice().getAddress()).append(", gatChar:").append(bluetoothGattCharacteristic.getUuid()).toString());
                    }
                }
            }
            BluetoothGatt gatt4 = bleDeviceData3.getGatt();
            Intrinsics.checkNotNull(gatt4);
            if (bleRequest5.execute(gatt4)) {
                this.pendingRequests.add(bleRequest5);
                return;
            } else {
                if (bleRequest5.getCanSkip()) {
                    removeFromList(this.requests, bleRequest5);
                    return;
                }
                return;
            }
        }
        Logger logger8 = Logger.INSTANCE;
        StringBuilder sbAppend4 = new StringBuilder("Executing no needs pending request ").append(bleRequest5.getBatCharacteristic()).append(", ").append(bleRequest5.getDeviceAddress()).append(", ");
        BluetoothGatt gatt5 = bleDeviceData3.getGatt();
        Intrinsics.checkNotNull(gatt5);
        logger8.log(sbAppend4.append(gatt5.getDevice().getAddress()).toString());
        BluetoothGatt gatt6 = bleDeviceData3.getGatt();
        Intrinsics.checkNotNull(gatt6);
        List<BluetoothGattService> services2 = gatt6.getServices();
        Intrinsics.checkNotNullExpressionValue(services2, "getServices(...)");
        Iterator<T> it8 = services2.iterator();
        while (it8.hasNext()) {
            List<BluetoothGattCharacteristic> characteristics2 = ((BluetoothGattService) it8.next()).getCharacteristics();
            Intrinsics.checkNotNullExpressionValue(characteristics2, "getCharacteristics(...)");
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : characteristics2) {
                UUID uuid2 = bluetoothGattCharacteristic2.getUuid();
                BatCharacteristic batCharacteristic2 = bleRequest5.getBatCharacteristic();
                if (Intrinsics.areEqual(uuid2, batCharacteristic2 != null ? batCharacteristic2.getUuid() : null)) {
                    Logger.INSTANCE.log(bleRequest5.getBatCharacteristic() + ", gatt:" + bleDeviceData3.getGatt() + ", gatChar:" + bluetoothGattCharacteristic2);
                }
            }
        }
        BluetoothGatt gatt7 = bleDeviceData3.getGatt();
        Intrinsics.checkNotNull(gatt7);
        boolean zExecute = bleRequest5.execute(gatt7);
        removeFromList(this.requests, bleRequest5);
        if (zExecute) {
            return;
        }
        Logger logger9 = Logger.INSTANCE;
        String name7 = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name7, "getName(...)");
        logger9.log(name7, "request is not executed " + bleRequest5 + " addr:" + bleRequest5.getDeviceAddress());
    }

    private final void removeFromList(List<BleRequest> list, BleRequest element) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(list.get(i), element)) {
                arrayList.add(list.get(i));
            }
        }
        list.removeAll(arrayList);
    }

    private final void deleteCompletedRequests(BleRequest completedRequest) {
        BluetoothGattCharacteristic gattCharacteristic;
        byte[] value;
        if (this.completedRequests.contains(completedRequest)) {
            Logger logger = Logger.INSTANCE;
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            StringBuilder sbAppend = new StringBuilder("completed request: ").append(completedRequest).append(" for ").append(completedRequest.getDeviceAddress()).append(", characteristic:").append(completedRequest.getBatCharacteristic()).append(", value:");
            BatCharacteristic batCharacteristic = completedRequest.getBatCharacteristic();
            logger.log(name, sbAppend.append((batCharacteristic == null || (gattCharacteristic = batCharacteristic.getGattCharacteristic()) == null || (value = gattCharacteristic.getValue()) == null) ? null : ConversionExtensionsKt.toHex(value)).toString());
            removeFromList(this.requests, completedRequest);
            removeFromList(this.pendingRequests, completedRequest);
            removeFromList(this.completedRequests, completedRequest);
            this.deviceRequestsTimeouts.remove(completedRequest.getDeviceAddress());
            if (completedRequest instanceof BleRequest.DiscoverServices) {
                Logger logger2 = Logger.INSTANCE;
                String name2 = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                logger2.log(name2, "completeRequest activate subscribe notifications after discovery services req completed " + completedRequest.getDeviceAddress());
                subscribeAll(completedRequest.getDeviceAddress());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completeRequest(BleRequest pendingRequest) {
        this.completedRequests.add(pendingRequest);
    }

    public final void refreshDeviceCache(String address) {
        StateFlow<List<BleDeviceData>> stateFlow;
        List<BleDeviceData> value;
        Object next;
        Intrinsics.checkNotNullParameter(address, "address");
        GattManager gattManager = BatSdk.INSTANCE.getGattManager();
        BluetoothGatt gatt = null;
        if (gattManager != null && (stateFlow = gattManager.devices) != null && (value = stateFlow.getValue()) != null) {
            Iterator<T> it2 = value.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (Intrinsics.areEqual(((BleDeviceData) next).getAddress(), address)) {
                        break;
                    }
                }
            }
            BleDeviceData bleDeviceData = (BleDeviceData) next;
            if (bleDeviceData != null) {
                gatt = bleDeviceData.getGatt();
            }
        }
        Logger.INSTANCE.log("Refreshing device cache, gatt:" + gatt);
        if (gatt != null) {
            try {
                Logger.INSTANCE.log("refreshing device cache");
                Object objInvoke = gatt.getClass().getMethod("refresh", new Class[0]).invoke(gatt, new Object[0]);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            } catch (Exception e) {
                Logger.INSTANCE.log("error while refreshing device cache: " + e);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void subscribeAll(String address) {
        BatteryClient batteryClient = BatSdk.INSTANCE.getBatteryClient();
        if (batteryClient != null) {
            batteryClient.setSubscriptionEnabled(address, true);
        }
        PowerSaveModeClient powerSaveModeClient = BatSdk.INSTANCE.getPowerSaveModeClient();
        if (powerSaveModeClient != null) {
            powerSaveModeClient.setSubscriptionEnabled(address, true);
        }
        LedClient ledClient = BatSdk.INSTANCE.getLedClient();
        if (ledClient != null) {
            ledClient.setSubscriptionEnabled(address, true);
        }
        PodConnectionClient podConnectionClient = BatSdk.INSTANCE.getPodConnectionClient();
        if (podConnectionClient != null) {
            podConnectionClient.setSubscriptionEnabled(address, true);
        }
        CloudClient cloudClient = BatSdk.INSTANCE.getCloudClient();
        if (cloudClient != null) {
            cloudClient.setSubscriptionEnabled(address, true);
        }
        DeviceInfoClient deviceInfoClient = BatSdk.INSTANCE.getDeviceInfoClient();
        if (deviceInfoClient != null) {
            deviceInfoClient.setSubscriptionEnabled(address, true);
        }
        ErrorClient errorClient = BatSdk.INSTANCE.getErrorClient();
        if (errorClient != null) {
            errorClient.setSubscriptionEnabled(address, true);
        }
        LogsClient logsClient = BatSdk.INSTANCE.getLogsClient();
        if (logsClient != null) {
            logsClient.setSubscriptionEnabled(address, true);
        }
        FindVapeClient findVapeClient = BatSdk.INSTANCE.getFindVapeClient();
        if (findVapeClient != null) {
            findVapeClient.setSubscriptionEnabled(address, true);
        }
        LockClient lockClient = BatSdk.INSTANCE.getLockClient();
        if (lockClient != null) {
            lockClient.setSubscriptionEnabled(address, true);
        }
        LedClient ledClient2 = BatSdk.INSTANCE.getLedClient();
        if (ledClient2 != null) {
            ledClient2.setSubscriptionEnabled(address, true);
        }
        PuffsClient puffsClient = BatSdk.INSTANCE.getPuffsClient();
        if (puffsClient != null) {
            puffsClient.setSubscriptionEnabled(address, true);
        }
        SessionIndicationClient sessionIndicationClient = BatSdk.INSTANCE.getSessionIndicationClient();
        if (sessionIndicationClient != null) {
            sessionIndicationClient.setSubscriptionEnabled(address, true);
        }
        PayloadChallengeClient payloadChallengeClient = BatSdk.INSTANCE.getPayloadChallengeClient();
        if (payloadChallengeClient != null) {
            payloadChallengeClient.setSubscriptionEnabled(address, true);
        }
        PayloadControlClient payloadControlClient = BatSdk.INSTANCE.getPayloadControlClient();
        if (payloadControlClient != null) {
            payloadControlClient.setSubscriptionEnabled(address, true);
        }
        PodConnectionClient podConnectionClient2 = BatSdk.INSTANCE.getPodConnectionClient();
        if (podConnectionClient2 != null) {
            podConnectionClient2.setSubscriptionEnabled(address, true);
        }
    }

    private final void unsubscribeAll(String address) {
        BatteryClient batteryClient = BatSdk.INSTANCE.getBatteryClient();
        if (batteryClient != null) {
            batteryClient.setSubscriptionEnabled(address, false);
        }
        PowerSaveModeClient powerSaveModeClient = BatSdk.INSTANCE.getPowerSaveModeClient();
        if (powerSaveModeClient != null) {
            powerSaveModeClient.setSubscriptionEnabled(address, false);
        }
        LedClient ledClient = BatSdk.INSTANCE.getLedClient();
        if (ledClient != null) {
            ledClient.setSubscriptionEnabled(address, false);
        }
        PodConnectionClient podConnectionClient = BatSdk.INSTANCE.getPodConnectionClient();
        if (podConnectionClient != null) {
            podConnectionClient.setSubscriptionEnabled(address, false);
        }
        CloudClient cloudClient = BatSdk.INSTANCE.getCloudClient();
        if (cloudClient != null) {
            cloudClient.setSubscriptionEnabled(address, false);
        }
        DeviceInfoClient deviceInfoClient = BatSdk.INSTANCE.getDeviceInfoClient();
        if (deviceInfoClient != null) {
            deviceInfoClient.setSubscriptionEnabled(address, false);
        }
        ErrorClient errorClient = BatSdk.INSTANCE.getErrorClient();
        if (errorClient != null) {
            errorClient.setSubscriptionEnabled(address, false);
        }
        LogsClient logsClient = BatSdk.INSTANCE.getLogsClient();
        if (logsClient != null) {
            logsClient.setSubscriptionEnabled(address, false);
        }
        FindVapeClient findVapeClient = BatSdk.INSTANCE.getFindVapeClient();
        if (findVapeClient != null) {
            findVapeClient.setSubscriptionEnabled(address, false);
        }
        LockClient lockClient = BatSdk.INSTANCE.getLockClient();
        if (lockClient != null) {
            lockClient.setSubscriptionEnabled(address, false);
        }
        LedClient ledClient2 = BatSdk.INSTANCE.getLedClient();
        if (ledClient2 != null) {
            ledClient2.setSubscriptionEnabled(address, false);
        }
        PuffsClient puffsClient = BatSdk.INSTANCE.getPuffsClient();
        if (puffsClient != null) {
            puffsClient.setSubscriptionEnabled(address, false);
        }
        SessionIndicationClient sessionIndicationClient = BatSdk.INSTANCE.getSessionIndicationClient();
        if (sessionIndicationClient != null) {
            sessionIndicationClient.setSubscriptionEnabled(address, true);
        }
        PayloadChallengeClient payloadChallengeClient = BatSdk.INSTANCE.getPayloadChallengeClient();
        if (payloadChallengeClient != null) {
            payloadChallengeClient.setSubscriptionEnabled(address, false);
        }
        PayloadControlClient payloadControlClient = BatSdk.INSTANCE.getPayloadControlClient();
        if (payloadControlClient != null) {
            payloadControlClient.setSubscriptionEnabled(address, false);
        }
        PodConnectionClient podConnectionClient2 = BatSdk.INSTANCE.getPodConnectionClient();
        if (podConnectionClient2 != null) {
            podConnectionClient2.setSubscriptionEnabled(address, false);
        }
    }

    public final boolean isRequestPresent(String address) {
        Object obj;
        Object next;
        Intrinsics.checkNotNullParameter(address, "address");
        Iterator<T> it2 = this.requests.iterator();
        while (true) {
            obj = null;
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (Intrinsics.areEqual(((BleRequest) next).getDeviceAddress(), address)) {
                break;
            }
        }
        if (next != null) {
            Iterator<T> it3 = this.pendingRequests.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next2 = it3.next();
                if (Intrinsics.areEqual(((BleRequest) next2).getDeviceAddress(), address)) {
                    obj = next2;
                    break;
                }
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean isRequestReadDeviceInfoPresent() {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
        Iterator<T> it2 = this.requests.iterator();
        while (true) {
            obj = null;
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            BatCharacteristic batCharacteristic = ((BleRequest) next).getBatCharacteristic();
            if (StringsKt.compareTo(String.valueOf(batCharacteristic != null ? batCharacteristic.getUuid() : null), BatVocabulary.EPod3.Characteristics.deviceInfoCharacteristic, true) == 0) {
                break;
            }
        }
        if (next != null) {
            Iterator<T> it3 = this.pendingRequests.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it3.next();
                BatCharacteristic batCharacteristic2 = ((BleRequest) next2).getBatCharacteristic();
                if (StringsKt.compareTo(String.valueOf(batCharacteristic2 != null ? batCharacteristic2.getUuid() : null), BatVocabulary.EPod3.Characteristics.deviceInfoCharacteristic, true) == 0) {
                    break;
                }
            }
            if (next2 != null) {
                Iterator<T> it4 = this.requests.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it4.next();
                    BatCharacteristic batCharacteristic3 = ((BleRequest) next3).getBatCharacteristic();
                    if (StringsKt.compareTo(String.valueOf(batCharacteristic3 != null ? batCharacteristic3.getUuid() : null), BatVocabulary.EPod2.Characteristics.deviceInfoCharacteristic, true) == 0) {
                        break;
                    }
                }
                if (next3 != null) {
                    Iterator<T> it5 = this.pendingRequests.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            next4 = null;
                            break;
                        }
                        next4 = it5.next();
                        BatCharacteristic batCharacteristic4 = ((BleRequest) next4).getBatCharacteristic();
                        if (StringsKt.compareTo(String.valueOf(batCharacteristic4 != null ? batCharacteristic4.getUuid() : null), BatVocabulary.EPod2.Characteristics.deviceInfoCharacteristic, true) == 0) {
                            break;
                        }
                    }
                    if (next4 != null) {
                        Iterator<T> it6 = this.requests.iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                next5 = null;
                                break;
                            }
                            next5 = it6.next();
                            BatCharacteristic batCharacteristic5 = ((BleRequest) next5).getBatCharacteristic();
                            if (StringsKt.compareTo(String.valueOf(batCharacteristic5 != null ? batCharacteristic5.getUuid() : null), BatVocabulary.SmartBox.Characteristics.deviceInfoCharacteristic, true) == 0) {
                                break;
                            }
                        }
                        if (next5 != null) {
                            Iterator<T> it7 = this.pendingRequests.iterator();
                            while (true) {
                                if (!it7.hasNext()) {
                                    break;
                                }
                                Object next6 = it7.next();
                                BatCharacteristic batCharacteristic6 = ((BleRequest) next6).getBatCharacteristic();
                                if (StringsKt.compareTo(String.valueOf(batCharacteristic6 != null ? batCharacteristic6.getUuid() : null), BatVocabulary.SmartBox.Characteristics.deviceInfoCharacteristic, true) == 0) {
                                    obj = next6;
                                    break;
                                }
                            }
                            if (obj != null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean isRequestProximityUnlockPresent() {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
        Iterator<T> it2 = this.requests.iterator();
        while (true) {
            obj = null;
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            BatCharacteristic batCharacteristic = ((BleRequest) next).getBatCharacteristic();
            if (StringsKt.compareTo(String.valueOf(batCharacteristic != null ? batCharacteristic.getUuid() : null), BatVocabulary.EPod3.Characteristics.lockCharacteristic, true) == 0) {
                break;
            }
        }
        if (next != null) {
            Iterator<T> it3 = this.pendingRequests.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it3.next();
                BatCharacteristic batCharacteristic2 = ((BleRequest) next2).getBatCharacteristic();
                if (StringsKt.compareTo(String.valueOf(batCharacteristic2 != null ? batCharacteristic2.getUuid() : null), BatVocabulary.EPod3.Characteristics.lockCharacteristic, true) == 0) {
                    break;
                }
            }
            if (next2 != null) {
                Iterator<T> it4 = this.requests.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it4.next();
                    BatCharacteristic batCharacteristic3 = ((BleRequest) next3).getBatCharacteristic();
                    if (StringsKt.compareTo(String.valueOf(batCharacteristic3 != null ? batCharacteristic3.getUuid() : null), BatVocabulary.EPod2.Characteristics.lockCharacteristic, true) == 0) {
                        break;
                    }
                }
                if (next3 != null) {
                    Iterator<T> it5 = this.pendingRequests.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            next4 = null;
                            break;
                        }
                        next4 = it5.next();
                        BatCharacteristic batCharacteristic4 = ((BleRequest) next4).getBatCharacteristic();
                        if (StringsKt.compareTo(String.valueOf(batCharacteristic4 != null ? batCharacteristic4.getUuid() : null), BatVocabulary.EPod2.Characteristics.lockCharacteristic, true) == 0) {
                            break;
                        }
                    }
                    if (next4 != null) {
                        Iterator<T> it6 = this.requests.iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                next5 = null;
                                break;
                            }
                            next5 = it6.next();
                            BatCharacteristic batCharacteristic5 = ((BleRequest) next5).getBatCharacteristic();
                            if (StringsKt.compareTo(String.valueOf(batCharacteristic5 != null ? batCharacteristic5.getUuid() : null), BatVocabulary.SmartBox.Characteristics.lockCharacteristic, true) == 0) {
                                break;
                            }
                        }
                        if (next5 != null) {
                            Iterator<T> it7 = this.pendingRequests.iterator();
                            while (true) {
                                if (!it7.hasNext()) {
                                    break;
                                }
                                Object next6 = it7.next();
                                BatCharacteristic batCharacteristic6 = ((BleRequest) next6).getBatCharacteristic();
                                if (StringsKt.compareTo(String.valueOf(batCharacteristic6 != null ? batCharacteristic6.getUuid() : null), BatVocabulary.SmartBox.Characteristics.lockCharacteristic, true) == 0) {
                                    obj = next6;
                                    break;
                                }
                            }
                            if (obj != null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean isRequestPodConnectionPresent() {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        Iterator<T> it2 = this.requests.iterator();
        while (true) {
            obj = null;
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            BatCharacteristic batCharacteristic = ((BleRequest) next).getBatCharacteristic();
            if (StringsKt.compareTo(String.valueOf(batCharacteristic != null ? batCharacteristic.getUuid() : null), BatVocabulary.EPod3.Characteristics.podCharacteristic, true) == 0) {
                break;
            }
        }
        if (next != null) {
            Iterator<T> it3 = this.pendingRequests.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it3.next();
                BatCharacteristic batCharacteristic2 = ((BleRequest) next2).getBatCharacteristic();
                if (StringsKt.compareTo(String.valueOf(batCharacteristic2 != null ? batCharacteristic2.getUuid() : null), BatVocabulary.EPod3.Characteristics.podCharacteristic, true) == 0) {
                    break;
                }
            }
            if (next2 != null) {
                Iterator<T> it4 = this.requests.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it4.next();
                    BatCharacteristic batCharacteristic3 = ((BleRequest) next3).getBatCharacteristic();
                    if (StringsKt.compareTo(String.valueOf(batCharacteristic3 != null ? batCharacteristic3.getUuid() : null), BatVocabulary.SmartBox.Characteristics.podCharacteristic, true) == 0) {
                        break;
                    }
                }
                if (next3 != null) {
                    Iterator<T> it5 = this.pendingRequests.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        Object next4 = it5.next();
                        BatCharacteristic batCharacteristic4 = ((BleRequest) next4).getBatCharacteristic();
                        if (StringsKt.compareTo(String.valueOf(batCharacteristic4 != null ? batCharacteristic4.getUuid() : null), BatVocabulary.SmartBox.Characteristics.podCharacteristic, true) == 0) {
                            obj = next4;
                            break;
                        }
                    }
                    if (obj != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean isCharacteristicPresent(String address, String uuid) {
        List<BluetoothGattService> services;
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        for (BleDeviceData bleDeviceData : this._devices.getValue()) {
            BluetoothGatt gatt = bleDeviceData.getGatt();
            if (gatt != null && (services = gatt.getServices()) != null) {
                Iterator<T> it2 = services.iterator();
                while (it2.hasNext()) {
                    List<BluetoothGattCharacteristic> characteristics = ((BluetoothGattService) it2.next()).getCharacteristics();
                    Intrinsics.checkNotNullExpressionValue(characteristics, "getCharacteristics(...)");
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                        if (Intrinsics.areEqual(bleDeviceData.getAddress(), address)) {
                            String string = bluetoothGattCharacteristic.getUuid().toString();
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            if (StringsKt.contains((CharSequence) string, (CharSequence) uuid, true)) {
                                Logger.INSTANCE.log("Characteristic uuid:" + uuid + " found in " + address);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        Logger.INSTANCE.log("Characteristic uuid:" + uuid + " NOT found in " + address);
        return false;
    }

    private final void cleanCharacteristics(String address) {
        AgeChallengeClient ageChallengeClient = BatSdk.INSTANCE.getAgeChallengeClient();
        if (ageChallengeClient != null) {
            ageChallengeClient.clean(address);
        }
        AgeSignatureClient ageSignatureClient = BatSdk.INSTANCE.getAgeSignatureClient();
        if (ageSignatureClient != null) {
            ageSignatureClient.clean(address);
        }
        BatteryClient batteryClient = BatSdk.INSTANCE.getBatteryClient();
        if (batteryClient != null) {
            batteryClient.clean(address);
        }
        BuzzerClient buzzerClient = BatSdk.INSTANCE.getBuzzerClient();
        if (buzzerClient != null) {
            buzzerClient.clean(address);
        }
        PowerSaveModeClient powerSaveModeClient = BatSdk.INSTANCE.getPowerSaveModeClient();
        if (powerSaveModeClient != null) {
            powerSaveModeClient.clean(address);
        }
        CloudClient cloudClient = BatSdk.INSTANCE.getCloudClient();
        if (cloudClient != null) {
            cloudClient.clean(address);
        }
        DeviceInfoClient deviceInfoClient = BatSdk.INSTANCE.getDeviceInfoClient();
        if (deviceInfoClient != null) {
            deviceInfoClient.clean(address);
        }
        ErrorClient errorClient = BatSdk.INSTANCE.getErrorClient();
        if (errorClient != null) {
            errorClient.clean(address);
        }
        FindVapeClient findVapeClient = BatSdk.INSTANCE.getFindVapeClient();
        if (findVapeClient != null) {
            findVapeClient.clean(address);
        }
        HapticClient hapticClient = BatSdk.INSTANCE.getHapticClient();
        if (hapticClient != null) {
            hapticClient.clean(address);
        }
        LedClient ledClient = BatSdk.INSTANCE.getLedClient();
        if (ledClient != null) {
            ledClient.clean(address);
        }
        LockClient lockClient = BatSdk.INSTANCE.getLockClient();
        if (lockClient != null) {
            lockClient.clean(address);
        }
        LogsClient logsClient = BatSdk.INSTANCE.getLogsClient();
        if (logsClient != null) {
            logsClient.clean(address);
        }
        PodConnectionClient podConnectionClient = BatSdk.INSTANCE.getPodConnectionClient();
        if (podConnectionClient != null) {
            podConnectionClient.clean(address);
        }
        SessionIndicationClient sessionIndicationClient = BatSdk.INSTANCE.getSessionIndicationClient();
        if (sessionIndicationClient != null) {
            sessionIndicationClient.clean(address);
        }
        PuffsClient puffsClient = BatSdk.INSTANCE.getPuffsClient();
        if (puffsClient != null) {
            puffsClient.clean(address);
        }
        ResetClient resetClient = BatSdk.INSTANCE.getResetClient();
        if (resetClient != null) {
            resetClient.clean(address);
        }
        TimeClient timeClient = BatSdk.INSTANCE.getTimeClient();
        if (timeClient != null) {
            timeClient.clean(address);
        }
        PayloadChallengeClient payloadChallengeClient = BatSdk.INSTANCE.getPayloadChallengeClient();
        if (payloadChallengeClient != null) {
            payloadChallengeClient.clean(address);
        }
        PayloadClient payloadClient = BatSdk.INSTANCE.getPayloadClient();
        if (payloadClient != null) {
            payloadClient.clean(address);
        }
        PayloadControlClient payloadControlClient = BatSdk.INSTANCE.getPayloadControlClient();
        if (payloadControlClient != null) {
            payloadControlClient.clean(address);
        }
        PayloadVersionClient payloadVersionClient = BatSdk.INSTANCE.getPayloadVersionClient();
        if (payloadVersionClient != null) {
            payloadVersionClient.clean(address);
        }
        TimeoutAutoLockClient timeoutAutoLockClient = BatSdk.INSTANCE.getTimeoutAutoLockClient();
        if (timeoutAutoLockClient != null) {
            timeoutAutoLockClient.clean(address);
        }
    }

    private final void clearNotificationCallbacks(String address) {
        ArrayList<Pair> arrayList = new ArrayList();
        for (Pair pair : MapsKt.toList(this.notificationCallbacks)) {
            if (Intrinsics.areEqual(((Pair) pair.getFirst()).getFirst(), address)) {
                arrayList.add(pair.getFirst());
            }
        }
        for (Pair pair2 : arrayList) {
            Logger.INSTANCE.log("notificationCallbackRemove " + ((String) pair2.getFirst()) + ", " + pair2.getSecond());
            this.notificationCallbacks.remove(pair2);
        }
    }

    public final void printRequestList() {
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "request list size: " + this.requests.size());
        for (BleRequest bleRequest : this.requests) {
            Logger logger2 = Logger.INSTANCE;
            String name2 = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            StringBuilder sbAppend = new StringBuilder("Request :").append(bleRequest.getDeviceAddress()).append(", ");
            BatCharacteristic batCharacteristic = bleRequest.getBatCharacteristic();
            logger2.log(name2, sbAppend.append(batCharacteristic != null ? batCharacteristic.getUuid() : null).toString());
        }
    }

    public final void printPendingRequests() {
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "pendingrequest list size: " + this.pendingRequests.size());
        for (BleRequest bleRequest : this.pendingRequests) {
            Logger logger2 = Logger.INSTANCE;
            String name2 = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            StringBuilder sbAppend = new StringBuilder("PendingRequest :").append(bleRequest.getDeviceAddress()).append(", ");
            BatCharacteristic batCharacteristic = bleRequest.getBatCharacteristic();
            logger2.log(name2, sbAppend.append(batCharacteristic != null ? batCharacteristic.getUuid() : null).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void printGatServices(BluetoothGatt gatt) {
        List<BluetoothGattService> services;
        byte[] value;
        if (gatt == null || (services = gatt.getServices()) == null) {
            return;
        }
        for (BluetoothGattService bluetoothGattService : services) {
            List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
            Intrinsics.checkNotNullExpressionValue(characteristics, "getCharacteristics(...)");
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                Logger logger = Logger.INSTANCE;
                String name = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                String hex = null;
                StringBuilder sbAppend = new StringBuilder(" connect service:").append(bluetoothGattService).append(", ").append(bluetoothGattService != null ? bluetoothGattService.getUuid() : null).append(", char:").append(bluetoothGattCharacteristic).append(", ").append(bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null).append(", ");
                if (bluetoothGattCharacteristic != null && (value = bluetoothGattCharacteristic.getValue()) != null) {
                    hex = ConversionExtensionsKt.toHex(value);
                }
                logger.log(name, sbAppend.append(hex).toString());
            }
        }
    }
}
