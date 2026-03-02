package com.bat.sdk;

import android.content.Context;
import android.net.Uri;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.ble.companionApp.BatCompanionDeviceManager;
import com.bat.sdk.domain.device.FirmwareInstallationState;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.presentation.FirmwareService;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import no.nordicsemi.android.dfu.DfuProgressListener;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import no.nordicsemi.android.dfu.DfuServiceListenerHelper;

/* JADX INFO: compiled from: FirmwareManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003*\u0001\u0019\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001b"}, m5598d2 = {"Lcom/bat/sdk/FirmwareManager;", "", "context", "Landroid/content/Context;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Landroid/content/Context;Lcom/bat/sdk/ble/GattManager;)V", "_installationStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "installationStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInstallationStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", AnalyticsAttribute.APP_INSTALL_ATTRIBUTE, "", "deviceAddress", "", "uri", "Landroid/net/Uri;", "resetInstallationState", "registerInstallationListener", "unregisterInstallationListener", "installationListener", "com/bat/sdk/FirmwareManager$installationListener$1", "Lcom/bat/sdk/FirmwareManager$installationListener$1;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class FirmwareManager {
    private final MutableStateFlow<FirmwareInstallationState> _installationStateFlow;
    private final Context context;
    private final GattManager gattManager;
    private final FirmwareManager$installationListener$1 installationListener;
    private final StateFlow<FirmwareInstallationState> installationStateFlow;

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bat.sdk.FirmwareManager$installationListener$1] */
    public FirmwareManager(Context context, GattManager gattManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.context = context;
        this.gattManager = gattManager;
        MutableStateFlow<FirmwareInstallationState> MutableStateFlow = StateFlowKt.MutableStateFlow(new FirmwareInstallationState.Idle(""));
        this._installationStateFlow = MutableStateFlow;
        this.installationStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.installationListener = new DfuProgressListener() { // from class: com.bat.sdk.FirmwareManager$installationListener$1
            @Override // no.nordicsemi.android.dfu.DfuProgressListener
            public void onDeviceConnecting(String address) {
                Intrinsics.checkNotNullParameter(address, "address");
                Logger logger = Logger.INSTANCE;
                String name = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                logger.log(name, "firmware manager: onDeviceConnecting - " + address);
                this.this$0._installationStateFlow.setValue(new FirmwareInstallationState.DeviceConnecting(address));
            }

            @Override // no.nordicsemi.android.dfu.DfuProgressListener
            public void onDeviceConnected(String address) {
                Intrinsics.checkNotNullParameter(address, "address");
                Logger.INSTANCE.log("firmware manager: onDeviceConnected - " + address + " - wait(400)");
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new FirmwareManager$installationListener$1$onDeviceConnected$1(this.this$0, address, null), 2, null);
            }

            @Override // no.nordicsemi.android.dfu.DfuProgressListener
            public void onDfuProcessStarting(String address) {
                Intrinsics.checkNotNullParameter(address, "address");
                Logger.INSTANCE.log("firmware manager: onDfuProcessStarting - " + address);
                this.this$0._installationStateFlow.setValue(new FirmwareInstallationState.DfuProcessStarting(address));
            }

            @Override // no.nordicsemi.android.dfu.DfuProgressListener
            public void onDfuProcessStarted(String address) {
                Intrinsics.checkNotNullParameter(address, "address");
                Logger.INSTANCE.log("firmware manager: onDfuProcessStarted - " + address);
                this.this$0._installationStateFlow.setValue(new FirmwareInstallationState.DfuProcessStarted(address));
            }

            @Override // no.nordicsemi.android.dfu.DfuProgressListener
            public void onEnablingDfuMode(String address) {
                Intrinsics.checkNotNullParameter(address, "address");
                Logger.INSTANCE.log("firmware manager: onEnablingDfuMode - " + address);
                this.this$0._installationStateFlow.setValue(new FirmwareInstallationState.EnablingDfuMode(address));
            }

            @Override // no.nordicsemi.android.dfu.DfuProgressListener
            public void onProgressChanged(String deviceAddress, int percent, float speed, float avgSpeed, int currentPart, int partsTotal) {
                Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
                FirmwareInstallationState.Progress progress = new FirmwareInstallationState.Progress(deviceAddress, percent, speed, avgSpeed, currentPart, partsTotal);
                Logger.INSTANCE.log("firmware manager: onProgressChanged - " + progress);
                this.this$0._installationStateFlow.setValue(progress);
            }

            @Override // no.nordicsemi.android.dfu.DfuProgressListener
            public void onFirmwareValidating(String address) {
                Intrinsics.checkNotNullParameter(address, "address");
                Logger.INSTANCE.log("firmware manager: onFirmwareValidating - " + address);
                this.this$0._installationStateFlow.setValue(new FirmwareInstallationState.FirmwareValidating(address));
            }

            @Override // no.nordicsemi.android.dfu.DfuProgressListener
            public void onDeviceDisconnecting(String address) {
                Intrinsics.checkNotNullParameter(address, "address");
                Logger.INSTANCE.log("firmware manager: onDeviceDisconnecting - " + address);
                this.this$0._installationStateFlow.setValue(new FirmwareInstallationState.DeviceDisconnecting(address));
            }

            @Override // no.nordicsemi.android.dfu.DfuProgressListener
            public void onDeviceDisconnected(String address) {
                Intrinsics.checkNotNullParameter(address, "address");
                Logger.INSTANCE.log("firmware manager: onDeviceDisconnected - " + address + " - wait(400)");
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new FirmwareManager$installationListener$1$onDeviceDisconnected$1(this.this$0, address, null), 2, null);
            }

            @Override // no.nordicsemi.android.dfu.DfuProgressListener
            public void onDfuCompleted(String address) {
                Intrinsics.checkNotNullParameter(address, "address");
                Logger.INSTANCE.log("firmware manager: onDfuCompleted - " + address + " - wait(1400)");
                BatCompanionDeviceManager companionDeviceManager = BatSdk.INSTANCE.getCompanionDeviceManager();
                if (companionDeviceManager != null) {
                    companionDeviceManager.stopObservingDevice(address);
                }
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new FirmwareManager$installationListener$1$onDfuCompleted$1(this.this$0, address, null), 2, null);
                this.this$0.unregisterInstallationListener();
            }

            @Override // no.nordicsemi.android.dfu.DfuProgressListener
            public void onDfuAborted(String address) {
                Intrinsics.checkNotNullParameter(address, "address");
                Logger.INSTANCE.log("firmware manager: onDfuAborted - " + address + " - wait(200) - wait(200)");
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new FirmwareManager$installationListener$1$onDfuAborted$1(address, this.this$0, null), 2, null);
                this.this$0.unregisterInstallationListener();
            }

            @Override // no.nordicsemi.android.dfu.DfuProgressListener
            public void onError(String address, int error, int errorType, String message) {
                Intrinsics.checkNotNullParameter(address, "address");
                BatCompanionDeviceManager companionDeviceManager = BatSdk.INSTANCE.getCompanionDeviceManager();
                if (companionDeviceManager != null) {
                    companionDeviceManager.stopObservingDevice(address);
                }
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new FirmwareManager$installationListener$1$onError$1(this.this$0, address, error, errorType, message, null), 2, null);
                this.this$0.unregisterInstallationListener();
            }
        };
    }

    public final StateFlow<FirmwareInstallationState> getInstallationStateFlow() {
        return this.installationStateFlow;
    }

    public final void install(String deviceAddress, Uri uri) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.gattManager.clearRequestsForDevice(deviceAddress);
        this._installationStateFlow.setValue(new FirmwareInstallationState.Idle(deviceAddress));
        registerInstallationListener();
        BatCompanionDeviceManager companionDeviceManager = BatSdk.INSTANCE.getCompanionDeviceManager();
        if (companionDeviceManager != null) {
            companionDeviceManager.startObservingDevice(deviceAddress);
        }
        DfuServiceInitiator dfuServiceInitiator = new DfuServiceInitiator(deviceAddress);
        dfuServiceInitiator.setZip(uri);
        dfuServiceInitiator.setDisableNotification(true);
        dfuServiceInitiator.setForeground(false);
        dfuServiceInitiator.setNumberOfRetries(3);
        dfuServiceInitiator.setKeepBond(true);
        dfuServiceInitiator.setRestoreBond(false);
        dfuServiceInitiator.start(this.context, FirmwareService.class);
    }

    public final void resetInstallationState(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        this._installationStateFlow.setValue(new FirmwareInstallationState.Idle(deviceAddress));
    }

    private final void registerInstallationListener() {
        DfuServiceListenerHelper.registerProgressListener(this.context, this.installationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterInstallationListener() {
        DfuServiceListenerHelper.unregisterProgressListener(this.context, this.installationListener);
    }
}
