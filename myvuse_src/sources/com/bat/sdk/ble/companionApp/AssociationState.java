package com.bat.sdk.ble.companionApp;

import android.companion.AssociationInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatCompanionDeviceManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\f"}, m5598d2 = {"Lcom/bat/sdk/ble/companionApp/AssociationState;", "", "AssociationError", "AssociationPending", "AssociationIdle", "AssociationCreated", "DeviceFound", "Lcom/bat/sdk/ble/companionApp/AssociationState$AssociationCreated;", "Lcom/bat/sdk/ble/companionApp/AssociationState$AssociationError;", "Lcom/bat/sdk/ble/companionApp/AssociationState$AssociationIdle;", "Lcom/bat/sdk/ble/companionApp/AssociationState$AssociationPending;", "Lcom/bat/sdk/ble/companionApp/AssociationState$DeviceFound;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface AssociationState {

    /* JADX INFO: compiled from: BatCompanionDeviceManager.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m5598d2 = {"Lcom/bat/sdk/ble/companionApp/AssociationState$AssociationError;", "Lcom/bat/sdk/ble/companionApp/AssociationState;", "deviceAddress", "", "error", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "getError", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class AssociationError implements AssociationState {
        private final String deviceAddress;
        private final String error;

        public static /* synthetic */ AssociationError copy$default(AssociationError associationError, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = associationError.deviceAddress;
            }
            if ((i & 2) != 0) {
                str2 = associationError.error;
            }
            return associationError.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getError() {
            return this.error;
        }

        public final AssociationError copy(String deviceAddress, String error) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(error, "error");
            return new AssociationError(deviceAddress, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AssociationError)) {
                return false;
            }
            AssociationError associationError = (AssociationError) other;
            return Intrinsics.areEqual(this.deviceAddress, associationError.deviceAddress) && Intrinsics.areEqual(this.error, associationError.error);
        }

        public int hashCode() {
            return (this.deviceAddress.hashCode() * 31) + this.error.hashCode();
        }

        public String toString() {
            return "AssociationError(deviceAddress=" + this.deviceAddress + ", error=" + this.error + ')';
        }

        public AssociationError(String deviceAddress, String error) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(error, "error");
            this.deviceAddress = deviceAddress;
            this.error = error;
        }

        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final String getError() {
            return this.error;
        }
    }

    /* JADX INFO: compiled from: BatCompanionDeviceManager.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/ble/companionApp/AssociationState$AssociationPending;", "Lcom/bat/sdk/ble/companionApp/AssociationState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class AssociationPending implements AssociationState {
        private final String deviceAddress;

        public static /* synthetic */ AssociationPending copy$default(AssociationPending associationPending, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = associationPending.deviceAddress;
            }
            return associationPending.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final AssociationPending copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new AssociationPending(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AssociationPending) && Intrinsics.areEqual(this.deviceAddress, ((AssociationPending) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "AssociationPending(deviceAddress=" + this.deviceAddress + ')';
        }

        public AssociationPending(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        public final String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: BatCompanionDeviceManager.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m5598d2 = {"Lcom/bat/sdk/ble/companionApp/AssociationState$AssociationIdle;", "Lcom/bat/sdk/ble/companionApp/AssociationState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class AssociationIdle implements AssociationState {
        public static final AssociationIdle INSTANCE = new AssociationIdle();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AssociationIdle)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2000058717;
        }

        public String toString() {
            return "AssociationIdle";
        }

        private AssociationIdle() {
        }
    }

    /* JADX INFO: compiled from: BatCompanionDeviceManager.kt */
    @Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m5598d2 = {"Lcom/bat/sdk/ble/companionApp/AssociationState$AssociationCreated;", "Lcom/bat/sdk/ble/companionApp/AssociationState;", "deviceAddress", "", "associationInfo", "Landroid/companion/AssociationInfo;", "<init>", "(Ljava/lang/String;Landroid/companion/AssociationInfo;)V", "getDeviceAddress", "()Ljava/lang/String;", "getAssociationInfo", "()Landroid/companion/AssociationInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class AssociationCreated implements AssociationState {
        private final AssociationInfo associationInfo;
        private final String deviceAddress;

        public static /* synthetic */ AssociationCreated copy$default(AssociationCreated associationCreated, String str, AssociationInfo associationInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                str = associationCreated.deviceAddress;
            }
            if ((i & 2) != 0) {
                associationInfo = associationCreated.associationInfo;
            }
            return associationCreated.copy(str, associationInfo);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final AssociationInfo getAssociationInfo() {
            return this.associationInfo;
        }

        public final AssociationCreated copy(String deviceAddress, AssociationInfo associationInfo) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(associationInfo, "associationInfo");
            return new AssociationCreated(deviceAddress, associationInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AssociationCreated)) {
                return false;
            }
            AssociationCreated associationCreated = (AssociationCreated) other;
            return Intrinsics.areEqual(this.deviceAddress, associationCreated.deviceAddress) && Intrinsics.areEqual(this.associationInfo, associationCreated.associationInfo);
        }

        public int hashCode() {
            return (this.deviceAddress.hashCode() * 31) + this.associationInfo.hashCode();
        }

        public String toString() {
            return "AssociationCreated(deviceAddress=" + this.deviceAddress + ", associationInfo=" + this.associationInfo + ')';
        }

        public AssociationCreated(String deviceAddress, AssociationInfo associationInfo) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(associationInfo, "associationInfo");
            this.deviceAddress = deviceAddress;
            this.associationInfo = associationInfo;
        }

        public final AssociationInfo getAssociationInfo() {
            return this.associationInfo;
        }

        public final String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: BatCompanionDeviceManager.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/ble/companionApp/AssociationState$DeviceFound;", "Lcom/bat/sdk/ble/companionApp/AssociationState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class DeviceFound implements AssociationState {
        private final String deviceAddress;

        public static /* synthetic */ DeviceFound copy$default(DeviceFound deviceFound, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deviceFound.deviceAddress;
            }
            return deviceFound.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final DeviceFound copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new DeviceFound(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DeviceFound) && Intrinsics.areEqual(this.deviceAddress, ((DeviceFound) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "DeviceFound(deviceAddress=" + this.deviceAddress + ')';
        }

        public DeviceFound(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        public final String getDeviceAddress() {
            return this.deviceAddress;
        }
    }
}
