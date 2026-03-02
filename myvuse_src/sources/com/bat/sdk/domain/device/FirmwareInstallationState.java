package com.bat.sdk.domain.device;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FirmwareInstallationState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000e\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u000e\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#¨\u0006$"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "Idle", "DeviceConnecting", "DeviceConnected", "DfuProcessStarting", "DfuProcessStarted", "EnablingDfuMode", "Progress", "FirmwareValidating", "DeviceDisconnecting", "DeviceDisconnected", "DfuCompleted", "UpdateFinished", "DfuAborted", "Error", "Lcom/bat/sdk/domain/device/FirmwareInstallationState$DeviceConnected;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState$DeviceConnecting;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState$DeviceDisconnected;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState$DeviceDisconnecting;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState$DfuAborted;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState$DfuCompleted;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState$DfuProcessStarted;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState$DfuProcessStarting;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState$EnablingDfuMode;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState$Error;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState$FirmwareValidating;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState$Idle;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState$Progress;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState$UpdateFinished;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class FirmwareInstallationState {
    private final String deviceAddress;

    public /* synthetic */ FirmwareInstallationState(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private FirmwareInstallationState(String str) {
        this.deviceAddress = str;
    }

    public String getDeviceAddress() {
        return this.deviceAddress;
    }

    /* JADX INFO: compiled from: FirmwareInstallationState.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState$Idle;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Idle extends FirmwareInstallationState {
        private final String deviceAddress;

        public static /* synthetic */ Idle copy$default(Idle idle, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = idle.deviceAddress;
            }
            return idle.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final Idle copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new Idle(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Idle) && Intrinsics.areEqual(this.deviceAddress, ((Idle) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "Idle(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Idle(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.domain.device.FirmwareInstallationState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: FirmwareInstallationState.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState$DeviceConnecting;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class DeviceConnecting extends FirmwareInstallationState {
        private final String deviceAddress;

        public static /* synthetic */ DeviceConnecting copy$default(DeviceConnecting deviceConnecting, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deviceConnecting.deviceAddress;
            }
            return deviceConnecting.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final DeviceConnecting copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new DeviceConnecting(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DeviceConnecting) && Intrinsics.areEqual(this.deviceAddress, ((DeviceConnecting) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "DeviceConnecting(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceConnecting(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.domain.device.FirmwareInstallationState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: FirmwareInstallationState.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState$DeviceConnected;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class DeviceConnected extends FirmwareInstallationState {
        private final String deviceAddress;

        public static /* synthetic */ DeviceConnected copy$default(DeviceConnected deviceConnected, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deviceConnected.deviceAddress;
            }
            return deviceConnected.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final DeviceConnected copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new DeviceConnected(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DeviceConnected) && Intrinsics.areEqual(this.deviceAddress, ((DeviceConnected) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "DeviceConnected(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceConnected(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.domain.device.FirmwareInstallationState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: FirmwareInstallationState.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState$DfuProcessStarting;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class DfuProcessStarting extends FirmwareInstallationState {
        private final String deviceAddress;

        public static /* synthetic */ DfuProcessStarting copy$default(DfuProcessStarting dfuProcessStarting, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dfuProcessStarting.deviceAddress;
            }
            return dfuProcessStarting.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final DfuProcessStarting copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new DfuProcessStarting(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DfuProcessStarting) && Intrinsics.areEqual(this.deviceAddress, ((DfuProcessStarting) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "DfuProcessStarting(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DfuProcessStarting(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.domain.device.FirmwareInstallationState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: FirmwareInstallationState.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState$DfuProcessStarted;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class DfuProcessStarted extends FirmwareInstallationState {
        private final String deviceAddress;

        public static /* synthetic */ DfuProcessStarted copy$default(DfuProcessStarted dfuProcessStarted, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dfuProcessStarted.deviceAddress;
            }
            return dfuProcessStarted.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final DfuProcessStarted copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new DfuProcessStarted(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DfuProcessStarted) && Intrinsics.areEqual(this.deviceAddress, ((DfuProcessStarted) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "DfuProcessStarted(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DfuProcessStarted(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.domain.device.FirmwareInstallationState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: FirmwareInstallationState.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState$EnablingDfuMode;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class EnablingDfuMode extends FirmwareInstallationState {
        private final String deviceAddress;

        public static /* synthetic */ EnablingDfuMode copy$default(EnablingDfuMode enablingDfuMode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = enablingDfuMode.deviceAddress;
            }
            return enablingDfuMode.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final EnablingDfuMode copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new EnablingDfuMode(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EnablingDfuMode) && Intrinsics.areEqual(this.deviceAddress, ((EnablingDfuMode) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "EnablingDfuMode(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnablingDfuMode(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.domain.device.FirmwareInstallationState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: FirmwareInstallationState.kt */
    @Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006#"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState$Progress;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "deviceAddress", "", "percent", "", "speed", "", "averageSpeed", "currentPart", "totalParts", "<init>", "(Ljava/lang/String;IFFII)V", "getDeviceAddress", "()Ljava/lang/String;", "getPercent", "()I", "getSpeed", "()F", "getAverageSpeed", "getCurrentPart", "getTotalParts", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Progress extends FirmwareInstallationState {
        private final float averageSpeed;
        private final int currentPart;
        private final String deviceAddress;
        private final int percent;
        private final float speed;
        private final int totalParts;

        public static /* synthetic */ Progress copy$default(Progress progress, String str, int i, float f, float f2, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = progress.deviceAddress;
            }
            if ((i4 & 2) != 0) {
                i = progress.percent;
            }
            int i5 = i;
            if ((i4 & 4) != 0) {
                f = progress.speed;
            }
            float f3 = f;
            if ((i4 & 8) != 0) {
                f2 = progress.averageSpeed;
            }
            float f4 = f2;
            if ((i4 & 16) != 0) {
                i2 = progress.currentPart;
            }
            int i6 = i2;
            if ((i4 & 32) != 0) {
                i3 = progress.totalParts;
            }
            return progress.copy(str, i5, f3, f4, i6, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPercent() {
            return this.percent;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getSpeed() {
            return this.speed;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getAverageSpeed() {
            return this.averageSpeed;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getCurrentPart() {
            return this.currentPart;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getTotalParts() {
            return this.totalParts;
        }

        public final Progress copy(String deviceAddress, int percent, float speed, float averageSpeed, int currentPart, int totalParts) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new Progress(deviceAddress, percent, speed, averageSpeed, currentPart, totalParts);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Progress)) {
                return false;
            }
            Progress progress = (Progress) other;
            return Intrinsics.areEqual(this.deviceAddress, progress.deviceAddress) && this.percent == progress.percent && Float.compare(this.speed, progress.speed) == 0 && Float.compare(this.averageSpeed, progress.averageSpeed) == 0 && this.currentPart == progress.currentPart && this.totalParts == progress.totalParts;
        }

        public int hashCode() {
            return (((((((((this.deviceAddress.hashCode() * 31) + Integer.hashCode(this.percent)) * 31) + Float.hashCode(this.speed)) * 31) + Float.hashCode(this.averageSpeed)) * 31) + Integer.hashCode(this.currentPart)) * 31) + Integer.hashCode(this.totalParts);
        }

        public String toString() {
            return "Progress(deviceAddress=" + this.deviceAddress + ", percent=" + this.percent + ", speed=" + this.speed + ", averageSpeed=" + this.averageSpeed + ", currentPart=" + this.currentPart + ", totalParts=" + this.totalParts + ')';
        }

        public /* synthetic */ Progress(String str, int i, float f, float f2, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0.0f : f, (i4 & 8) == 0 ? f2 : 0.0f, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) == 0 ? i3 : 0);
        }

        @Override // com.bat.sdk.domain.device.FirmwareInstallationState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final int getPercent() {
            return this.percent;
        }

        public final float getSpeed() {
            return this.speed;
        }

        public final float getAverageSpeed() {
            return this.averageSpeed;
        }

        public final int getCurrentPart() {
            return this.currentPart;
        }

        public final int getTotalParts() {
            return this.totalParts;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Progress(String deviceAddress, int i, float f, float f2, int i2, int i3) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
            this.percent = i;
            this.speed = f;
            this.averageSpeed = f2;
            this.currentPart = i2;
            this.totalParts = i3;
        }
    }

    /* JADX INFO: compiled from: FirmwareInstallationState.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState$FirmwareValidating;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class FirmwareValidating extends FirmwareInstallationState {
        private final String deviceAddress;

        public static /* synthetic */ FirmwareValidating copy$default(FirmwareValidating firmwareValidating, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = firmwareValidating.deviceAddress;
            }
            return firmwareValidating.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final FirmwareValidating copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new FirmwareValidating(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FirmwareValidating) && Intrinsics.areEqual(this.deviceAddress, ((FirmwareValidating) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "FirmwareValidating(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FirmwareValidating(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.domain.device.FirmwareInstallationState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: FirmwareInstallationState.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState$DeviceDisconnecting;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class DeviceDisconnecting extends FirmwareInstallationState {
        private final String deviceAddress;

        public static /* synthetic */ DeviceDisconnecting copy$default(DeviceDisconnecting deviceDisconnecting, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deviceDisconnecting.deviceAddress;
            }
            return deviceDisconnecting.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final DeviceDisconnecting copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new DeviceDisconnecting(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DeviceDisconnecting) && Intrinsics.areEqual(this.deviceAddress, ((DeviceDisconnecting) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "DeviceDisconnecting(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceDisconnecting(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.domain.device.FirmwareInstallationState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: FirmwareInstallationState.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState$DeviceDisconnected;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class DeviceDisconnected extends FirmwareInstallationState {
        private final String deviceAddress;

        public static /* synthetic */ DeviceDisconnected copy$default(DeviceDisconnected deviceDisconnected, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deviceDisconnected.deviceAddress;
            }
            return deviceDisconnected.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final DeviceDisconnected copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new DeviceDisconnected(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DeviceDisconnected) && Intrinsics.areEqual(this.deviceAddress, ((DeviceDisconnected) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "DeviceDisconnected(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceDisconnected(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.domain.device.FirmwareInstallationState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: FirmwareInstallationState.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState$DfuCompleted;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class DfuCompleted extends FirmwareInstallationState {
        private final String deviceAddress;

        public static /* synthetic */ DfuCompleted copy$default(DfuCompleted dfuCompleted, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dfuCompleted.deviceAddress;
            }
            return dfuCompleted.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final DfuCompleted copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new DfuCompleted(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DfuCompleted) && Intrinsics.areEqual(this.deviceAddress, ((DfuCompleted) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "DfuCompleted(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DfuCompleted(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.domain.device.FirmwareInstallationState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: FirmwareInstallationState.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState$UpdateFinished;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class UpdateFinished extends FirmwareInstallationState {
        private final String deviceAddress;

        public static /* synthetic */ UpdateFinished copy$default(UpdateFinished updateFinished, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateFinished.deviceAddress;
            }
            return updateFinished.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final UpdateFinished copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new UpdateFinished(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UpdateFinished) && Intrinsics.areEqual(this.deviceAddress, ((UpdateFinished) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "UpdateFinished(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateFinished(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.domain.device.FirmwareInstallationState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: FirmwareInstallationState.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState$DfuAborted;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class DfuAborted extends FirmwareInstallationState {
        private final String deviceAddress;

        public static /* synthetic */ DfuAborted copy$default(DfuAborted dfuAborted, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dfuAborted.deviceAddress;
            }
            return dfuAborted.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final DfuAborted copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new DfuAborted(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DfuAborted) && Intrinsics.areEqual(this.deviceAddress, ((DfuAborted) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "DfuAborted(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DfuAborted(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.domain.device.FirmwareInstallationState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: FirmwareInstallationState.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, m5598d2 = {"Lcom/bat/sdk/domain/device/FirmwareInstallationState$Error;", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;", "deviceAddress", "", "error", "", "errorType", "message", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "getError", "()I", "getErrorType", "getMessage", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Error extends FirmwareInstallationState {
        public static final int ERROR_BLE_LINK_LOSS = 4106;
        public static final int ERROR_BLE_LINK_LOSS_GATT = 133;
        public static final String ERROR_DFU_REMOTE_DESC = "Dfu Remote";
        public static final int ERROR_FLAT_BATTERY = 2052;
        public static final int ERROR_NOT_ENOUGH_MEMORY = 516;
        public static final String ERROR_OTHER_DESC = "Other";
        public static final int ERROR_POSTVALIDATION = 1036;
        public static final int ERROR_PREVALIDATION = 517;
        public static final int ERROR_TYPE_COMMUNICATION = 2;
        public static final String ERROR_TYPE_COMMUNICATION_DESC = "Communication";
        public static final int ERROR_TYPE_COMMUNICATION_STATE = 1;
        public static final String ERROR_TYPE_COMMUNICATION_STATE_DESC = "Communication State";
        public static final int ERROR_TYPE_DFU_REMOTE = 3;
        public static final int ERROR_TYPE_OTHER = 0;
        public static final String ERROR_UNKNOWN_DESC = "Unknown";
        private final String deviceAddress;
        private final int error;
        private final int errorType;
        private final String message;

        public static /* synthetic */ Error copy$default(Error error, String str, int i, int i2, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = error.deviceAddress;
            }
            if ((i3 & 2) != 0) {
                i = error.error;
            }
            if ((i3 & 4) != 0) {
                i2 = error.errorType;
            }
            if ((i3 & 8) != 0) {
                str2 = error.message;
            }
            return error.copy(str, i, i2, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getErrorType() {
            return this.errorType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Error copy(String deviceAddress, int error, int errorType, String message) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new Error(deviceAddress, error, errorType, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.deviceAddress, error.deviceAddress) && this.error == error.error && this.errorType == error.errorType && Intrinsics.areEqual(this.message, error.message);
        }

        public int hashCode() {
            int iHashCode = ((((this.deviceAddress.hashCode() * 31) + Integer.hashCode(this.error)) * 31) + Integer.hashCode(this.errorType)) * 31;
            String str = this.message;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        @Override // com.bat.sdk.domain.device.FirmwareInstallationState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final int getError() {
            return this.error;
        }

        public final int getErrorType() {
            return this.errorType;
        }

        public final String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String deviceAddress, int i, int i2, String str) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
            this.error = i;
            this.errorType = i2;
            this.message = str;
        }

        public String toString() {
            int i = this.errorType;
            if (i == 0) {
                if (this.error == 4106) {
                    return "ERROR_BLE_LINK_LOSS";
                }
                return ERROR_OTHER_DESC;
            }
            if (i == 1) {
                return ERROR_TYPE_COMMUNICATION_STATE_DESC;
            }
            if (i == 2) {
                if (this.error == 133) {
                    return "ERROR_BLE_LINK_LOSS_GATT_ERROR";
                }
                return ERROR_TYPE_COMMUNICATION_DESC;
            }
            if (i == 3) {
                int i2 = this.error;
                if (i2 == 516) {
                    return "ERROR_NOT_ENOUGH_MEMORY";
                }
                if (i2 == 517) {
                    return "ERROR_PREVALIDATION_FAILED";
                }
                if (i2 == 1036) {
                    return "ERROR_POSTVALIDATION_FAILED";
                }
                if (i2 == 2052) {
                    return "ERROR_FLAT_BATTERY";
                }
                return ERROR_DFU_REMOTE_DESC;
            }
            return "Unknown";
        }
    }
}
