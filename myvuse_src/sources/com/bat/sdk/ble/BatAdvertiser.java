package com.bat.sdk.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Context;
import android.os.ParcelUuid;
import com.bat.sdk.logging.Logger;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.api.common.CarrierType;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatAdvertiser.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m5598d2 = {"Lcom/bat/sdk/ble/BatAdvertiser;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "advertiser", "Landroid/bluetooth/le/BluetoothLeAdvertiser;", "advertisingCallback", "Landroid/bluetooth/le/AdvertiseCallback;", "startAdvertising", "", AnalyticsAttribute.UUID_ATTRIBUTE, "", "advertiseCallback", "stopAdvertising", "checkAdvertiseCapability", "", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class BatAdvertiser {
    private static final String TAG = "BatAdvertiser";
    private BluetoothLeAdvertiser advertiser;
    private AdvertiseCallback advertisingCallback;
    private BluetoothAdapter bluetoothAdapter;

    public BatAdvertiser(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.advertisingCallback = new AdvertiseCallback() { // from class: com.bat.sdk.ble.BatAdvertiser$advertisingCallback$1
            @Override // android.bluetooth.le.AdvertiseCallback
            public void onStartSuccess(AdvertiseSettings settingsInEffect) {
            }

            @Override // android.bluetooth.le.AdvertiseCallback
            public void onStartFailure(int errorCode) {
                LogInstrumentation.m2728e("BatAdvertiser", "Advertising onStartFailure: " + errorCode);
            }
        };
        if (this.advertiser == null) {
            Object systemService = context.getSystemService(CarrierType.BLUETOOTH);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
            BluetoothManager bluetoothManager = (BluetoothManager) systemService;
            this.bluetoothAdapter = bluetoothManager.getAdapter();
            this.advertiser = bluetoothManager.getAdapter().getBluetoothLeAdvertiser();
        }
        if (checkAdvertiseCapability()) {
            return;
        }
        Logger.INSTANCE.log(TAG, "Advertising is not working on this phone");
        this.advertiser = null;
    }

    public static /* synthetic */ void startAdvertising$default(BatAdvertiser batAdvertiser, String str, AdvertiseCallback advertiseCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            advertiseCallback = batAdvertiser.advertisingCallback;
        }
        batAdvertiser.startAdvertising(str, advertiseCallback);
    }

    public final void startAdvertising(String uuid, AdvertiseCallback advertiseCallback) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(advertiseCallback, "advertiseCallback");
        Logger.INSTANCE.log(TAG, "[_startAdvertising] Starting Advertising");
        if (this.advertiser == null) {
            return;
        }
        try {
            AdvertiseSettings advertiseSettingsBuild = new AdvertiseSettings.Builder().setAdvertiseMode(2).setTxPowerLevel(3).setConnectable(false).setTimeout(0).build();
            Intrinsics.checkNotNullExpressionValue(advertiseSettingsBuild, "build(...)");
            AdvertiseData advertiseDataBuild = new AdvertiseData.Builder().setIncludeDeviceName(false).setIncludeTxPowerLevel(false).addServiceUuid(new ParcelUuid(UUID.fromString(uuid))).build();
            Intrinsics.checkNotNullExpressionValue(advertiseDataBuild, "build(...)");
            BluetoothLeAdvertiser bluetoothLeAdvertiser = this.advertiser;
            Intrinsics.checkNotNull(bluetoothLeAdvertiser);
            bluetoothLeAdvertiser.startAdvertising(advertiseSettingsBuild, advertiseDataBuild, advertiseCallback);
        } catch (Exception e) {
            Logger.INSTANCE.log(TAG, "startAdvertising exception " + e);
        }
    }

    public static /* synthetic */ void stopAdvertising$default(BatAdvertiser batAdvertiser, AdvertiseCallback advertiseCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            advertiseCallback = batAdvertiser.advertisingCallback;
        }
        batAdvertiser.stopAdvertising(advertiseCallback);
    }

    public final void stopAdvertising(AdvertiseCallback advertiseCallback) {
        Intrinsics.checkNotNullParameter(advertiseCallback, "advertiseCallback");
        Logger.INSTANCE.log(TAG, "[stopAdvertising]");
        BluetoothLeAdvertiser bluetoothLeAdvertiser = this.advertiser;
        Intrinsics.checkNotNull(bluetoothLeAdvertiser);
        bluetoothLeAdvertiser.stopAdvertising(advertiseCallback);
    }

    private final boolean checkAdvertiseCapability() {
        BluetoothAdapter bluetoothAdapter = this.bluetoothAdapter;
        Intrinsics.checkNotNull(bluetoothAdapter);
        if (bluetoothAdapter.isMultipleAdvertisementSupported()) {
            return true;
        }
        Logger.INSTANCE.log(TAG, "Advertising not supported");
        return false;
    }
}
