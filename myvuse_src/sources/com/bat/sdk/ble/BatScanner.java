package com.bat.sdk.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.ParcelUuid;
import android.util.SparseArray;
import com.bat.sdk.FlowEvent;
import com.bat.sdk.ble.BatScanner;
import com.bat.sdk.ble.advertising.DeviceAdvertisingData;
import com.bat.sdk.ble.advertising.DeviceAdvertisingDataDecoder;
import com.bat.sdk.ble.advertising.SmartBoxDataDecoder;
import com.bat.sdk.logging.Logger;
import com.newrelic.agent.android.api.common.CarrierType;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetch;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: BatScanner.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002*\u0001\"\u0018\u00002\u00020\u0001:\u00016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010$\u001a\u00020%2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u000bJ$\u0010$\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u000b2\u0006\u0010!\u001a\u00020,J\u0010\u0010-\u001a\u00020%2\b\b\u0002\u0010.\u001a\u00020,J\u0010\u0010/\u001a\u00020%2\b\b\u0002\u0010.\u001a\u00020,J\u0006\u00100\u001a\u00020%J\u0018\u00101\u001a\u0004\u0018\u0001022\f\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#¨\u00067"}, m5598d2 = {"Lcom/bat/sdk/ble/BatScanner;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "scanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "getScanner", "()Landroid/bluetooth/le/BluetoothLeScanner;", "batDevices", "", "Lcom/bat/sdk/ble/BatDevice;", "_resultsStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "resultsStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getResultsStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_scanningStateFlow", "", "scanningStateFlow", "getScanningStateFlow", "_errorEventStateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/bat/sdk/FlowEvent;", "Lcom/bat/sdk/ble/BatScanner$ErrorType;", "errorEventStateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getErrorEventStateFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "advertisingDataDecoders", "Lcom/bat/sdk/ble/advertising/DeviceAdvertisingDataDecoder;", "scanCallback", "com/bat/sdk/ble/BatScanner$scanCallback$1", "Lcom/bat/sdk/ble/BatScanner$scanCallback$1;", "start", "", "uuids", "Ljava/util/UUID;", "scanSettings", "Landroid/bluetooth/le/ScanSettings;", "filters", "Landroid/bluetooth/le/ScanFilter;", "Landroid/bluetooth/le/ScanCallback;", BackgroundFetch.ACTION_STOP, "customScanCallback", "flush", "clear", "decodeData", "Lcom/bat/sdk/ble/advertising/DeviceAdvertisingData;", "manufacturerSpecificData", "Landroid/util/SparseArray;", "", "ErrorType", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class BatScanner {
    private final MutableSharedFlow<FlowEvent<ErrorType>> _errorEventStateFlow;
    private final MutableStateFlow<List<BatDevice>> _resultsStateFlow;
    private final MutableStateFlow<Boolean> _scanningStateFlow;
    private final List<DeviceAdvertisingDataDecoder> advertisingDataDecoders;
    private List<BatDevice> batDevices;
    private final Context context;
    private final SharedFlow<FlowEvent<ErrorType>> errorEventStateFlow;
    private final StateFlow<List<BatDevice>> resultsStateFlow;
    private final BatScanner$scanCallback$1 scanCallback;
    private final StateFlow<Boolean> scanningStateFlow;

    /* JADX WARN: Type inference failed for: r4v10, types: [com.bat.sdk.ble.BatScanner$scanCallback$1] */
    public BatScanner(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.batDevices = CollectionsKt.emptyList();
        MutableStateFlow<List<BatDevice>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._resultsStateFlow = MutableStateFlow;
        this.resultsStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._scanningStateFlow = MutableStateFlow2;
        this.scanningStateFlow = FlowKt.asStateFlow(MutableStateFlow2);
        MutableSharedFlow<FlowEvent<ErrorType>> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 1, BufferOverflow.DROP_OLDEST, 1, null);
        this._errorEventStateFlow = mutableSharedFlowMutableSharedFlow$default;
        this.errorEventStateFlow = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        this.advertisingDataDecoders = CollectionsKt.listOf(new SmartBoxDataDecoder());
        this.scanCallback = new ScanCallback() { // from class: com.bat.sdk.ble.BatScanner$scanCallback$1
            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(int callbackType, ScanResult result) {
                String deviceName;
                ScanRecord scanRecord;
                SparseArray<byte[]> manufacturerSpecificData;
                BluetoothDevice device;
                String address;
                ScanRecord scanRecord2;
                super.onScanResult(callbackType, result);
                String str = "";
                if (result == null || (scanRecord2 = result.getScanRecord()) == null || (deviceName = scanRecord2.getDeviceName()) == null) {
                    deviceName = "";
                }
                if (result != null && (device = result.getDevice()) != null && (address = device.getAddress()) != null) {
                    str = address;
                }
                List listPlus = CollectionsKt.plus((Collection<? extends BatDevice>) this.this$0.batDevices, new BatDevice(deviceName, str, result != null ? result.getRssi() : 0, (result == null || (scanRecord = result.getScanRecord()) == null || (manufacturerSpecificData = scanRecord.getManufacturerSpecificData()) == null) ? null : this.this$0.decodeData(manufacturerSpecificData)));
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                for (Object obj : listPlus) {
                    if (hashSet.add(((BatDevice) obj).getName())) {
                        arrayList.add(obj);
                    }
                }
                HashSet hashSet2 = new HashSet();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if (hashSet2.add(((BatDevice) obj2).getAddress())) {
                        arrayList2.add(obj2);
                    }
                }
                this.this$0.batDevices = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.bat.sdk.ble.BatScanner$scanCallback$1$onScanResult$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((BatDevice) t).getName(), ((BatDevice) t2).getName());
                    }
                });
                this.this$0._resultsStateFlow.setValue(this.this$0.batDevices);
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onBatchScanResults(List<ScanResult> results) {
                String deviceName;
                super.onBatchScanResults(results);
                if (results == null) {
                    Logger logger = Logger.INSTANCE;
                    String name = getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    logger.log(name, "scan results are null");
                    return;
                }
                Logger logger2 = Logger.INSTANCE;
                String name2 = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                logger2.log(name2, "scan results are available: " + results.size());
                List<ScanResult> list = results;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (ScanResult scanResult : list) {
                    ScanRecord scanRecord = scanResult.getScanRecord();
                    if (scanRecord == null || (deviceName = scanRecord.getDeviceName()) == null) {
                        deviceName = "";
                    }
                    String address = scanResult.getDevice().getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                    arrayList.add(new BatDevice(deviceName, address, scanResult.getRssi(), null, 8, null));
                }
                List listPlus = CollectionsKt.plus((Collection) this.this$0.batDevices, (Iterable) arrayList);
                HashSet hashSet = new HashSet();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listPlus) {
                    if (hashSet.add(((BatDevice) obj).getName())) {
                        arrayList2.add(obj);
                    }
                }
                HashSet hashSet2 = new HashSet();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : arrayList2) {
                    if (hashSet2.add(((BatDevice) obj2).getAddress())) {
                        arrayList3.add(obj2);
                    }
                }
                this.this$0.batDevices = CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: com.bat.sdk.ble.BatScanner$scanCallback$1$onBatchScanResults$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((BatDevice) t).getName(), ((BatDevice) t2).getName());
                    }
                });
                Logger logger3 = Logger.INSTANCE;
                String name3 = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                logger3.log(name3, "updating scan results: " + this.this$0.batDevices.size());
                this.this$0._resultsStateFlow.setValue(this.this$0.batDevices);
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanFailed(int errorCode) {
                super.onScanFailed(errorCode);
                Logger logger = Logger.INSTANCE;
                String name = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                logger.log(name, "scan failed: " + errorCode);
                this.this$0._scanningStateFlow.setValue(false);
                this.this$0._errorEventStateFlow.tryEmit(new FlowEvent(new BatScanner.ErrorType.ScanFailed(errorCode), false, 2, null));
            }
        };
    }

    private final BluetoothLeScanner getScanner() {
        Object systemService = this.context.getSystemService(CarrierType.BLUETOOTH);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothManager bluetoothManager = (BluetoothManager) systemService;
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        if ((adapter != null ? adapter.getBluetoothLeScanner() : null) == null) {
            this._errorEventStateFlow.tryEmit(new FlowEvent<>(ErrorType.ScannerInitializationFailed.INSTANCE, false, 2, null));
        }
        BluetoothAdapter adapter2 = bluetoothManager.getAdapter();
        if (adapter2 != null) {
            return adapter2.getBluetoothLeScanner();
        }
        return null;
    }

    public final StateFlow<List<BatDevice>> getResultsStateFlow() {
        return this.resultsStateFlow;
    }

    public final StateFlow<Boolean> getScanningStateFlow() {
        return this.scanningStateFlow;
    }

    public final SharedFlow<FlowEvent<ErrorType>> getErrorEventStateFlow() {
        return this.errorEventStateFlow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void start$default(BatScanner batScanner, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        batScanner.start(list);
    }

    public final void start(List<UUID> uuids) {
        Intrinsics.checkNotNullParameter(uuids, "uuids");
        if (this.scanningStateFlow.getValue().booleanValue()) {
            Logger logger = Logger.INSTANCE;
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            logger.log(name, "cannot start scanner, scan is already in progress");
            return;
        }
        ScanSettings scanSettingsBuild = new ScanSettings.Builder().setScanMode(2).build();
        List<UUID> list = uuids;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(new ScanFilter.Builder().setServiceUuid(new ParcelUuid((UUID) it2.next())).build());
        }
        ArrayList arrayList2 = arrayList;
        this._scanningStateFlow.setValue(true);
        BluetoothLeScanner scanner = getScanner();
        if (scanner != null) {
            scanner.startScan(arrayList2, scanSettingsBuild, this.scanCallback);
        }
    }

    public final void start(ScanSettings scanSettings, List<ScanFilter> filters, ScanCallback scanCallback) {
        Intrinsics.checkNotNullParameter(scanSettings, "scanSettings");
        Intrinsics.checkNotNullParameter(filters, "filters");
        Intrinsics.checkNotNullParameter(scanCallback, "scanCallback");
        if (this.scanningStateFlow.getValue().booleanValue()) {
            Logger logger = Logger.INSTANCE;
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            logger.log(name, "cannot start scanner, scan is already in progress");
            return;
        }
        this._scanningStateFlow.setValue(true);
        BluetoothLeScanner scanner = getScanner();
        if (scanner != null) {
            scanner.startScan(filters, scanSettings, scanCallback);
        }
    }

    public static /* synthetic */ void stop$default(BatScanner batScanner, ScanCallback scanCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            scanCallback = batScanner.scanCallback;
        }
        batScanner.stop(scanCallback);
    }

    public final void stop(ScanCallback customScanCallback) {
        Intrinsics.checkNotNullParameter(customScanCallback, "customScanCallback");
        if (!this.scanningStateFlow.getValue().booleanValue()) {
            Logger logger = Logger.INSTANCE;
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            logger.log(name, "cannot stop scanner, it's not running");
            return;
        }
        this._scanningStateFlow.setValue(false);
        BluetoothLeScanner scanner = getScanner();
        if (scanner != null) {
            scanner.stopScan(customScanCallback);
        }
    }

    public static /* synthetic */ void flush$default(BatScanner batScanner, ScanCallback scanCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            scanCallback = batScanner.scanCallback;
        }
        batScanner.flush(scanCallback);
    }

    public final void flush(ScanCallback customScanCallback) {
        Intrinsics.checkNotNullParameter(customScanCallback, "customScanCallback");
        if (!this.scanningStateFlow.getValue().booleanValue()) {
            Logger logger = Logger.INSTANCE;
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            logger.log(name, "cannot flush scanner, it's not running");
            return;
        }
        BluetoothLeScanner scanner = getScanner();
        if (scanner != null) {
            scanner.flushPendingScanResults(customScanCallback);
        }
    }

    public final void clear() {
        this.batDevices = CollectionsKt.emptyList();
        this._resultsStateFlow.setValue(CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceAdvertisingData decodeData(SparseArray<byte[]> manufacturerSpecificData) {
        Object next;
        Iterator<T> it2 = this.advertisingDataDecoders.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (((DeviceAdvertisingDataDecoder) next).canDecode(manufacturerSpecificData)) {
                break;
            }
        }
        DeviceAdvertisingDataDecoder deviceAdvertisingDataDecoder = (DeviceAdvertisingDataDecoder) next;
        if (deviceAdvertisingDataDecoder != null) {
            return deviceAdvertisingDataDecoder.decode(manufacturerSpecificData);
        }
        return null;
    }

    /* JADX INFO: compiled from: BatScanner.kt */
    @Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/ble/BatScanner$ErrorType;", "", "ScanFailed", "ScannerInitializationFailed", "Lcom/bat/sdk/ble/BatScanner$ErrorType$ScanFailed;", "Lcom/bat/sdk/ble/BatScanner$ErrorType$ScannerInitializationFailed;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public interface ErrorType {

        /* JADX INFO: compiled from: BatScanner.kt */
        @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/ble/BatScanner$ErrorType$ScanFailed;", "Lcom/bat/sdk/ble/BatScanner$ErrorType;", "errorCode", "", "<init>", "(I)V", "getErrorCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final /* data */ class ScanFailed implements ErrorType {
            private final int errorCode;

            public static /* synthetic */ ScanFailed copy$default(ScanFailed scanFailed, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = scanFailed.errorCode;
                }
                return scanFailed.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getErrorCode() {
                return this.errorCode;
            }

            public final ScanFailed copy(int errorCode) {
                return new ScanFailed(errorCode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ScanFailed) && this.errorCode == ((ScanFailed) other).errorCode;
            }

            public int hashCode() {
                return Integer.hashCode(this.errorCode);
            }

            public String toString() {
                return "ScanFailed(errorCode=" + this.errorCode + ')';
            }

            public ScanFailed(int i) {
                this.errorCode = i;
            }

            public final int getErrorCode() {
                return this.errorCode;
            }
        }

        /* JADX INFO: compiled from: BatScanner.kt */
        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/ble/BatScanner$ErrorType$ScannerInitializationFailed;", "Lcom/bat/sdk/ble/BatScanner$ErrorType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class ScannerInitializationFailed implements ErrorType {
            public static final ScannerInitializationFailed INSTANCE = new ScannerInitializationFailed();

            private ScannerInitializationFailed() {
            }
        }
    }
}
