package com.bat.sdk.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bat.sdk.BatSdk;
import com.bat.sdk.ble.BondState;
import com.bat.sdk.logging.Logger;
import com.newrelic.agent.android.api.common.CarrierType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: Bonding.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0010\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fJ\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001e"}, m5598d2 = {"Lcom/bat/sdk/ble/Bonding;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "bondStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bat/sdk/ble/BondState;", "getBondStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "bondingDevice", "Lcom/bat/sdk/ble/BatDevice;", "isReceiverRegistered", "", "receiver", "com/bat/sdk/ble/Bonding$receiver$1", "Lcom/bat/sdk/ble/Bonding$receiver$1;", "getRemoteBtDevice", "Landroid/bluetooth/BluetoothDevice;", "address", "", "getBondStatus", "", "bond", "", "batDevice", "stopObservingBondState", "observeBondState", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class Bonding {
    private static final int BOND_NONE_DEFAULT_REASON = 11111111;
    private static final String EXTRA_REASON = "android.bluetooth.device.extra.REASON";
    private final MutableStateFlow<BondState> bondStateFlow;
    private BatDevice bondingDevice;
    private final Context context;
    private boolean isReceiverRegistered;
    private final Bonding$receiver$1 receiver;

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bat.sdk.ble.Bonding$receiver$1] */
    public Bonding(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.bondStateFlow = StateFlowKt.MutableStateFlow(BondState.Default.INSTANCE);
        this.receiver = new BroadcastReceiver() { // from class: com.bat.sdk.ble.Bonding$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Integer numValueOf = intent != null ? Integer.valueOf(intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1)) : null;
                if (numValueOf != null && numValueOf.intValue() == 10) {
                    this.this$0.stopObservingBondState();
                    int intExtra = intent.getIntExtra("android.bluetooth.device.extra.REASON", 11111111);
                    Logger logger = Logger.INSTANCE;
                    String name = getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    logger.log(name, "[Bonding] bonding failed: " + intExtra);
                    this.this$0.getBondStateFlow().setValue(new BondState.Failed(intExtra));
                    return;
                }
                if (numValueOf != null && numValueOf.intValue() == 11) {
                    this.this$0.getBondStateFlow().setValue(BondState.Bonding.INSTANCE);
                    return;
                }
                if (numValueOf != null && numValueOf.intValue() == 12) {
                    this.this$0.stopObservingBondState();
                    MutableStateFlow<BondState> bondStateFlow = this.this$0.getBondStateFlow();
                    BatDevice batDevice = this.this$0.bondingDevice;
                    Intrinsics.checkNotNull(batDevice);
                    bondStateFlow.setValue(new BondState.Bonded(batDevice));
                    GattManager gattManager = BatSdk.INSTANCE.getGattManager();
                    Intrinsics.checkNotNull(gattManager);
                    BatDevice batDevice2 = this.this$0.bondingDevice;
                    Intrinsics.checkNotNull(batDevice2);
                    gattManager.refreshCacheAndDiscoverServices(batDevice2.getAddress());
                }
            }
        };
    }

    public final MutableStateFlow<BondState> getBondStateFlow() {
        return this.bondStateFlow;
    }

    public final BluetoothDevice getRemoteBtDevice(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Object systemService = this.context.getSystemService(CarrierType.BLUETOOTH);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothDevice remoteDevice = ((BluetoothManager) systemService).getAdapter().getRemoteDevice(address);
        Intrinsics.checkNotNullExpressionValue(remoteDevice, "getRemoteDevice(...)");
        return remoteDevice;
    }

    public final int getBondStatus(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        BluetoothDevice remoteBtDevice = getRemoteBtDevice(address);
        if (remoteBtDevice.getBondState() == 12) {
            return 12;
        }
        return remoteBtDevice.getBondState() == 11 ? 11 : 10;
    }

    public final void bond(BatDevice batDevice) {
        Intrinsics.checkNotNullParameter(batDevice, "batDevice");
        this.bondingDevice = batDevice;
        if (getBondStatus(batDevice.getAddress()) == 12) {
            this.bondStateFlow.setValue(new BondState.Bonded(batDevice));
            return;
        }
        getRemoteBtDevice(batDevice.getAddress()).createBond();
        this.bondStateFlow.setValue(BondState.Bonding.INSTANCE);
        observeBondState(batDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopObservingBondState() {
        if (this.isReceiverRegistered) {
            this.context.unregisterReceiver(this.receiver);
            this.isReceiverRegistered = false;
        }
    }

    public final void observeBondState(BatDevice batDevice) {
        Intrinsics.checkNotNullParameter(batDevice, "batDevice");
        this.bondingDevice = batDevice;
        if (this.isReceiverRegistered) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        this.context.registerReceiver(this.receiver, intentFilter);
        this.isReceiverRegistered = true;
    }
}
