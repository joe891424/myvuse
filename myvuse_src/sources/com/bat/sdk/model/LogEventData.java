package com.bat.sdk.model;

import com.bat.sdk.presentation.ConversionExtensionsKt;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogRecord.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0006\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u0082\u0001\t\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, m5598d2 = {"Lcom/bat/sdk/model/LogEventData;", "", "<init>", "()V", "toJsonString", "", "BootEventData", "BatteryEventData", "BluetoothEventData", "PowerSettingEventData", "AuthenticatedPodEventData", "UsageReminderEventData", "RechargeReminderEventData", "PowerSaveModeEventData", "HeatingComponentsFailureError", "Lcom/bat/sdk/model/LogEventData$AuthenticatedPodEventData;", "Lcom/bat/sdk/model/LogEventData$BatteryEventData;", "Lcom/bat/sdk/model/LogEventData$BluetoothEventData;", "Lcom/bat/sdk/model/LogEventData$BootEventData;", "Lcom/bat/sdk/model/LogEventData$HeatingComponentsFailureError;", "Lcom/bat/sdk/model/LogEventData$PowerSaveModeEventData;", "Lcom/bat/sdk/model/LogEventData$PowerSettingEventData;", "Lcom/bat/sdk/model/LogEventData$RechargeReminderEventData;", "Lcom/bat/sdk/model/LogEventData$UsageReminderEventData;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class LogEventData {
    public /* synthetic */ LogEventData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LogEventData() {
    }

    public final String toJsonString() {
        Gson gson = new Gson();
        String json = !(gson instanceof Gson) ? gson.toJson(this) : GsonInstrumentation.toJson(gson, this);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    /* JADX INFO: compiled from: LogRecord.kt */
    @Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u001d"}, m5598d2 = {"Lcom/bat/sdk/model/LogEventData$BootEventData;", "Lcom/bat/sdk/model/LogEventData;", "data", "", "<init>", "([B)V", "fwVerMsb", "", "getFwVerMsb", "()I", "fwVerLsb", "getFwVerLsb", "boardId", "getBoardId", "uiSection1Version", "getUiSection1Version", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "uiSection2Version", "getUiSection2Version", "equals", "", "other", "", "hashCode", "toString", "", "component1", "copy", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class BootEventData extends LogEventData {
        private final int boardId;
        private final transient byte[] data;
        private final int fwVerLsb;
        private final int fwVerMsb;
        private final Integer uiSection1Version;
        private final Integer uiSection2Version;

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final byte[] getData() {
            return this.data;
        }

        public static /* synthetic */ BootEventData copy$default(BootEventData bootEventData, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = bootEventData.data;
            }
            return bootEventData.copy(bArr);
        }

        public final BootEventData copy(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new BootEventData(data);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public BootEventData(byte[] data) {
            super(0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.fwVerMsb = data[0];
            this.fwVerLsb = data[1];
            this.boardId = (int) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(data, 2, 4), 0, 1, null);
            this.uiSection1Version = data.length > 4 ? Integer.valueOf(data[4]) : null;
            this.uiSection2Version = data.length > 4 ? Integer.valueOf(data[5]) : null;
        }

        public final int getFwVerMsb() {
            return this.fwVerMsb;
        }

        public final int getFwVerLsb() {
            return this.fwVerLsb;
        }

        public final int getBoardId() {
            return this.boardId;
        }

        public final Integer getUiSection1Version() {
            return this.uiSection1Version;
        }

        public final Integer getUiSection2Version() {
            return this.uiSection2Version;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.LogEventData.BootEventData");
            BootEventData bootEventData = (BootEventData) other;
            return Arrays.equals(this.data, bootEventData.data) && this.fwVerMsb == bootEventData.fwVerMsb && this.fwVerLsb == bootEventData.fwVerLsb && this.boardId == bootEventData.boardId;
        }

        public int hashCode() {
            return (((((Arrays.hashCode(this.data) * 31) + this.fwVerMsb) * 31) + this.fwVerLsb) * 31) + this.boardId;
        }

        public String toString() {
            return "BootEventData(fwVerMsb=" + this.fwVerMsb + ", fwVerLsb=" + this.fwVerLsb + ", boardId=" + this.boardId + ", uiSection1Version=" + this.uiSection1Version + ", uiSection2Version=" + this.uiSection2Version + ')';
        }
    }

    /* JADX INFO: compiled from: LogRecord.kt */
    @Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, m5598d2 = {"Lcom/bat/sdk/model/LogEventData$BatteryEventData;", "Lcom/bat/sdk/model/LogEventData;", "data", "", "<init>", "([B)V", "batteryPercentage", "", "getBatteryPercentage", "()I", "chargingStatus", "getChargingStatus", "thermalResLow", "", "getThermalResLow", "()Z", "thermalResHigh", "getThermalResHigh", "batteryVoltage", "getBatteryVoltage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "equals", "other", "", "hashCode", "toString", "", "component1", "copy", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class BatteryEventData extends LogEventData {
        private final int batteryPercentage;
        private final Integer batteryVoltage;
        private final int chargingStatus;
        private final transient byte[] data;
        private final boolean thermalResHigh;
        private final boolean thermalResLow;

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final byte[] getData() {
            return this.data;
        }

        public static /* synthetic */ BatteryEventData copy$default(BatteryEventData batteryEventData, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = batteryEventData.data;
            }
            return batteryEventData.copy(bArr);
        }

        public final BatteryEventData copy(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new BatteryEventData(data);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public BatteryEventData(byte[] data) {
            super(0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.batteryPercentage = data[0];
            this.chargingStatus = data[1];
            this.thermalResLow = data[2] == 1;
            this.thermalResHigh = data[3] == 1;
            this.batteryVoltage = data.length > 3 ? Integer.valueOf(ConversionExtensionsKt.toUIntLittleEndian(ArraysKt.copyOfRange(data, 4, 6))) : null;
        }

        public final int getBatteryPercentage() {
            return this.batteryPercentage;
        }

        public final int getChargingStatus() {
            return this.chargingStatus;
        }

        public final boolean getThermalResLow() {
            return this.thermalResLow;
        }

        public final boolean getThermalResHigh() {
            return this.thermalResHigh;
        }

        public final Integer getBatteryVoltage() {
            return this.batteryVoltage;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.LogEventData.BatteryEventData");
            BatteryEventData batteryEventData = (BatteryEventData) other;
            return Arrays.equals(this.data, batteryEventData.data) && this.batteryPercentage == batteryEventData.batteryPercentage && this.chargingStatus == batteryEventData.chargingStatus && this.thermalResLow == batteryEventData.thermalResLow && this.thermalResHigh == batteryEventData.thermalResHigh;
        }

        public int hashCode() {
            return (((((((Arrays.hashCode(this.data) * 31) + this.batteryPercentage) * 31) + Integer.hashCode(this.chargingStatus)) * 31) + Boolean.hashCode(this.thermalResLow)) * 31) + Boolean.hashCode(this.thermalResHigh);
        }

        public String toString() {
            return "BatteryEventData(percentage=" + this.batteryPercentage + ", charging=" + this.chargingStatus + ", thermalResLow=" + this.thermalResLow + ", thermalResHigh=" + this.thermalResHigh + ", batteryVoltage=" + this.batteryVoltage + ')';
        }
    }

    /* JADX INFO: compiled from: LogRecord.kt */
    @Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, m5598d2 = {"Lcom/bat/sdk/model/LogEventData$BluetoothEventData;", "Lcom/bat/sdk/model/LogEventData;", "data", "", "<init>", "([B)V", "failedReason", "", "getFailedReason", "()I", "equals", "", "other", "", "hashCode", "toString", "", "component1", "copy", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class BluetoothEventData extends LogEventData {
        private final transient byte[] data;
        private final int failedReason;

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final byte[] getData() {
            return this.data;
        }

        public static /* synthetic */ BluetoothEventData copy$default(BluetoothEventData bluetoothEventData, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = bluetoothEventData.data;
            }
            return bluetoothEventData.copy(bArr);
        }

        public final BluetoothEventData copy(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new BluetoothEventData(data);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BluetoothEventData(byte[] data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.failedReason = data[0];
        }

        public final int getFailedReason() {
            return this.failedReason;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.LogEventData.BluetoothEventData");
            BluetoothEventData bluetoothEventData = (BluetoothEventData) other;
            return Arrays.equals(this.data, bluetoothEventData.data) && this.failedReason == bluetoothEventData.failedReason;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.data) * 31) + this.failedReason;
        }

        public String toString() {
            return "BluetoothEventData(failedReason=" + this.failedReason + ')';
        }
    }

    /* JADX INFO: compiled from: LogRecord.kt */
    @Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, m5598d2 = {"Lcom/bat/sdk/model/LogEventData$PowerSettingEventData;", "Lcom/bat/sdk/model/LogEventData;", "data", "", "<init>", "([B)V", "powerLevel", "", "getPowerLevel", "()I", "equals", "", "other", "", "hashCode", "toString", "", "component1", "copy", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class PowerSettingEventData extends LogEventData {
        private final transient byte[] data;
        private final int powerLevel;

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final byte[] getData() {
            return this.data;
        }

        public static /* synthetic */ PowerSettingEventData copy$default(PowerSettingEventData powerSettingEventData, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = powerSettingEventData.data;
            }
            return powerSettingEventData.copy(bArr);
        }

        public final PowerSettingEventData copy(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new PowerSettingEventData(data);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PowerSettingEventData(byte[] data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.powerLevel = data[0];
        }

        public final int getPowerLevel() {
            return this.powerLevel;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.LogEventData.PowerSettingEventData");
            return this.powerLevel == ((PowerSettingEventData) other).powerLevel;
        }

        public int hashCode() {
            return this.powerLevel;
        }

        public String toString() {
            return "PowerSettingEventData(level=" + this.powerLevel + ')';
        }
    }

    /* JADX INFO: compiled from: LogRecord.kt */
    @Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\t\u0010$\u001a\u00020\u0003HÂ\u0003J\u0013\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019¨\u0006&"}, m5598d2 = {"Lcom/bat/sdk/model/LogEventData$AuthenticatedPodEventData;", "Lcom/bat/sdk/model/LogEventData;", "data", "", "<init>", "([B)V", "podApiVersion", "", "getPodApiVersion", "()I", "podUid", "Lcom/bat/sdk/model/PodUid;", "getPodUid", "()Lcom/bat/sdk/model/PodUid;", "liquidInformation", "Lcom/bat/sdk/model/LiquidInformation;", "getLiquidInformation", "()Lcom/bat/sdk/model/LiquidInformation;", "skuNumber", "", "getSkuNumber", "()Ljava/lang/Long;", "Ljava/lang/Long;", "remainingLiquidPercentage", "getRemainingLiquidPercentage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "podPuffCount", "getPodPuffCount", "equals", "", "other", "", "hashCode", "toString", "", "component1", "copy", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class AuthenticatedPodEventData extends LogEventData {
        private final transient byte[] data;
        private final LiquidInformation liquidInformation;
        private final int podApiVersion;
        private final Integer podPuffCount;
        private final PodUid podUid;
        private final Integer remainingLiquidPercentage;
        private final Long skuNumber;

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final byte[] getData() {
            return this.data;
        }

        public static /* synthetic */ AuthenticatedPodEventData copy$default(AuthenticatedPodEventData authenticatedPodEventData, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = authenticatedPodEventData.data;
            }
            return authenticatedPodEventData.copy(bArr);
        }

        public final AuthenticatedPodEventData copy(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new AuthenticatedPodEventData(data);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AuthenticatedPodEventData(byte[] data) {
            super(0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.podApiVersion = data[0];
            this.podUid = data.length == 1 ? null : new PodUid(ArraysKt.copyOfRange(data, 1, 6));
            this.liquidInformation = data.length == 1 ? null : new LiquidInformation(ArraysKt.copyOfRange(data, 6, 11));
            this.skuNumber = data.length == 1 ? null : Long.valueOf(ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(data, 11, 15), 0, 1, null));
            this.remainingLiquidPercentage = data.length == 1 ? null : Integer.valueOf(data[15]);
            this.podPuffCount = data.length != 1 ? Integer.valueOf((int) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(data, 16, 18), 0, 1, null)) : null;
        }

        public final int getPodApiVersion() {
            return this.podApiVersion;
        }

        public final PodUid getPodUid() {
            return this.podUid;
        }

        public final LiquidInformation getLiquidInformation() {
            return this.liquidInformation;
        }

        public final Long getSkuNumber() {
            return this.skuNumber;
        }

        public final Integer getRemainingLiquidPercentage() {
            return this.remainingLiquidPercentage;
        }

        public final Integer getPodPuffCount() {
            return this.podPuffCount;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.LogEventData.AuthenticatedPodEventData");
            AuthenticatedPodEventData authenticatedPodEventData = (AuthenticatedPodEventData) other;
            return this.podApiVersion == authenticatedPodEventData.podApiVersion && Intrinsics.areEqual(this.podUid, authenticatedPodEventData.podUid) && Intrinsics.areEqual(this.liquidInformation, authenticatedPodEventData.liquidInformation) && Intrinsics.areEqual(this.skuNumber, authenticatedPodEventData.skuNumber) && Intrinsics.areEqual(this.remainingLiquidPercentage, authenticatedPodEventData.remainingLiquidPercentage) && Intrinsics.areEqual(this.podPuffCount, authenticatedPodEventData.podPuffCount);
        }

        public int hashCode() {
            int i = this.podApiVersion * 31;
            PodUid podUid = this.podUid;
            int iHashCode = (i + (podUid != null ? podUid.hashCode() : 0)) * 31;
            LiquidInformation liquidInformation = this.liquidInformation;
            int iHashCode2 = (iHashCode + (liquidInformation != null ? liquidInformation.hashCode() : 0)) * 31;
            Long l = this.skuNumber;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            Integer num = this.remainingLiquidPercentage;
            int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.podPuffCount;
            return iHashCode4 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return this.podUid == null ? "AuthenticatedPodEventData(apiVersion=" + this.podApiVersion + ')' : "AuthenticatedPodEventData(apiVersion=" + this.podApiVersion + ", podUid=" + this.podUid + ", liquidInformation=" + this.liquidInformation + ", skuInformation='" + this.skuNumber + "', remainingVolume=" + this.remainingLiquidPercentage + ", podPuffCount=" + this.podPuffCount + ')';
        }
    }

    /* JADX INFO: compiled from: LogRecord.kt */
    @Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, m5598d2 = {"Lcom/bat/sdk/model/LogEventData$UsageReminderEventData;", "Lcom/bat/sdk/model/LogEventData;", "data", "", "<init>", "([B)V", "puffCounter", "", "getPuffCounter", "()I", "usageGoal", "getUsageGoal", "equals", "", "other", "", "hashCode", "toString", "", "component1", "copy", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class UsageReminderEventData extends LogEventData {
        private final transient byte[] data;
        private final int puffCounter;
        private final int usageGoal;

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final byte[] getData() {
            return this.data;
        }

        public static /* synthetic */ UsageReminderEventData copy$default(UsageReminderEventData usageReminderEventData, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = usageReminderEventData.data;
            }
            return usageReminderEventData.copy(bArr);
        }

        public final UsageReminderEventData copy(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new UsageReminderEventData(data);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UsageReminderEventData(byte[] data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.puffCounter = ConversionExtensionsKt.toUIntLittleEndian(ArraysKt.copyOfRange(data, 0, 2));
            this.usageGoal = ConversionExtensionsKt.toUIntLittleEndian(ArraysKt.copyOfRange(data, 2, 4));
        }

        public final int getPuffCounter() {
            return this.puffCounter;
        }

        public final int getUsageGoal() {
            return this.usageGoal;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.LogEventData.UsageReminderEventData");
            UsageReminderEventData usageReminderEventData = (UsageReminderEventData) other;
            return Arrays.equals(this.data, usageReminderEventData.data) && this.puffCounter == usageReminderEventData.puffCounter && this.usageGoal == usageReminderEventData.usageGoal;
        }

        public int hashCode() {
            return (((Arrays.hashCode(this.data) * 31) + this.puffCounter) * 31) + this.usageGoal;
        }

        public String toString() {
            return "UsageReminderEventData(puffCounter=" + this.puffCounter + ", usageGoal=" + this.usageGoal + ')';
        }
    }

    /* JADX INFO: compiled from: LogRecord.kt */
    @Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\t¨\u0006\u001d"}, m5598d2 = {"Lcom/bat/sdk/model/LogEventData$RechargeReminderEventData;", "Lcom/bat/sdk/model/LogEventData;", "data", "", "<init>", "([B)V", "batteryPower", "", "getBatteryPower", "()I", "minBatteryThreshold", "getMinBatteryThreshold", "maxBatteryThreshold", "getMaxBatteryThreshold", "alertType", "getAlertType", "alertTrigger", "getAlertTrigger", "actualAlertTrigger", "getActualAlertTrigger", "equals", "", "other", "", "hashCode", "toString", "", "component1", "copy", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class RechargeReminderEventData extends LogEventData {
        private final int actualAlertTrigger;
        private final int alertTrigger;
        private final int alertType;
        private final int batteryPower;
        private final transient byte[] data;
        private final int maxBatteryThreshold;
        private final int minBatteryThreshold;

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final byte[] getData() {
            return this.data;
        }

        public static /* synthetic */ RechargeReminderEventData copy$default(RechargeReminderEventData rechargeReminderEventData, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = rechargeReminderEventData.data;
            }
            return rechargeReminderEventData.copy(bArr);
        }

        public final RechargeReminderEventData copy(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new RechargeReminderEventData(data);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RechargeReminderEventData(byte[] data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.batteryPower = data[0];
            this.minBatteryThreshold = data[1];
            this.maxBatteryThreshold = data[2];
            this.alertType = data[3];
            this.alertTrigger = data[4];
            this.actualAlertTrigger = data[5];
        }

        public final int getBatteryPower() {
            return this.batteryPower;
        }

        public final int getMinBatteryThreshold() {
            return this.minBatteryThreshold;
        }

        public final int getMaxBatteryThreshold() {
            return this.maxBatteryThreshold;
        }

        public final int getAlertType() {
            return this.alertType;
        }

        public final int getAlertTrigger() {
            return this.alertTrigger;
        }

        public final int getActualAlertTrigger() {
            return this.actualAlertTrigger;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.LogEventData.RechargeReminderEventData");
            RechargeReminderEventData rechargeReminderEventData = (RechargeReminderEventData) other;
            return Arrays.equals(this.data, rechargeReminderEventData.data) && this.batteryPower == rechargeReminderEventData.batteryPower && this.minBatteryThreshold == rechargeReminderEventData.minBatteryThreshold && this.maxBatteryThreshold == rechargeReminderEventData.maxBatteryThreshold && this.alertType == rechargeReminderEventData.alertType && this.alertTrigger == rechargeReminderEventData.alertTrigger && this.actualAlertTrigger == rechargeReminderEventData.actualAlertTrigger;
        }

        public int hashCode() {
            return (((((((((((Arrays.hashCode(this.data) * 31) + this.batteryPower) * 31) + this.minBatteryThreshold) * 31) + this.maxBatteryThreshold) * 31) + this.alertType) * 31) + this.alertTrigger) * 31) + this.actualAlertTrigger;
        }

        public String toString() {
            return "RechargeReminderEventData(batteryPower=" + this.batteryPower + ", minBatteryThr=" + this.minBatteryThreshold + ", maxBatteryThr=" + this.maxBatteryThreshold + ", alertType=" + this.alertType + ", alertTrigger=" + this.alertTrigger + ", actualAlertTrigger=" + this.actualAlertTrigger + ')';
        }
    }

    /* JADX INFO: compiled from: LogRecord.kt */
    @Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, m5598d2 = {"Lcom/bat/sdk/model/LogEventData$PowerSaveModeEventData;", "Lcom/bat/sdk/model/LogEventData;", "data", "", "<init>", "([B)V", "powerLevelBefore", "", "getPowerLevelBefore", "()I", "powerLevelAfter", "getPowerLevelAfter", "equals", "", "other", "", "hashCode", "toString", "", "component1", "copy", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class PowerSaveModeEventData extends LogEventData {
        private final byte[] data;
        private final int powerLevelAfter;
        private final int powerLevelBefore;

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final byte[] getData() {
            return this.data;
        }

        public static /* synthetic */ PowerSaveModeEventData copy$default(PowerSaveModeEventData powerSaveModeEventData, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = powerSaveModeEventData.data;
            }
            return powerSaveModeEventData.copy(bArr);
        }

        public final PowerSaveModeEventData copy(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new PowerSaveModeEventData(data);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PowerSaveModeEventData(byte[] data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.powerLevelBefore = data[0];
            this.powerLevelAfter = data[1];
        }

        public final int getPowerLevelBefore() {
            return this.powerLevelBefore;
        }

        public final int getPowerLevelAfter() {
            return this.powerLevelAfter;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.LogEventData.PowerSaveModeEventData");
            PowerSaveModeEventData powerSaveModeEventData = (PowerSaveModeEventData) other;
            return this.powerLevelBefore == powerSaveModeEventData.powerLevelBefore && this.powerLevelAfter == powerSaveModeEventData.powerLevelAfter;
        }

        public int hashCode() {
            return (this.powerLevelBefore * 31) + this.powerLevelAfter;
        }

        public String toString() {
            return "PowerSaveModeEventData(powerLevelBefore=" + this.powerLevelBefore + ", powerLevelAfter=" + this.powerLevelAfter + ')';
        }
    }

    /* JADX INFO: compiled from: LogRecord.kt */
    @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\t\u0010\u001b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\t¨\u0006\u001d"}, m5598d2 = {"Lcom/bat/sdk/model/LogEventData$HeatingComponentsFailureError;", "Lcom/bat/sdk/model/LogEventData;", "data", "", "<init>", "([B)V", "batteryPercentage", "", "getBatteryPercentage", "()I", "chargingStatus", "getChargingStatus", "thermalResLow", "getThermalResLow", "thermalResHigh", "getThermalResHigh", "batteryVoltage", "getBatteryVoltage", "pinVoltage", "getPinVoltage", "toString", "", "equals", "", "other", "", "hashCode", "component1", "copy", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class HeatingComponentsFailureError extends LogEventData {
        private final int batteryPercentage;
        private final int batteryVoltage;
        private final int chargingStatus;
        private final byte[] data;
        private final int pinVoltage;
        private final int thermalResHigh;
        private final int thermalResLow;

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final byte[] getData() {
            return this.data;
        }

        public static /* synthetic */ HeatingComponentsFailureError copy$default(HeatingComponentsFailureError heatingComponentsFailureError, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = heatingComponentsFailureError.data;
            }
            return heatingComponentsFailureError.copy(bArr);
        }

        public final HeatingComponentsFailureError copy(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new HeatingComponentsFailureError(data);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeatingComponentsFailureError(byte[] data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.batteryPercentage = data[0];
            this.chargingStatus = data[1];
            this.thermalResLow = data[2];
            this.thermalResHigh = data[3];
            this.batteryVoltage = (int) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(data, 4, 6), 0, 1, null);
            this.pinVoltage = (int) ConversionExtensionsKt.toLongBigEndian$default(ArraysKt.copyOfRange(data, 6, 8), 0, 1, null);
        }

        public final int getBatteryPercentage() {
            return this.batteryPercentage;
        }

        public final int getChargingStatus() {
            return this.chargingStatus;
        }

        public final int getThermalResLow() {
            return this.thermalResLow;
        }

        public final int getThermalResHigh() {
            return this.thermalResHigh;
        }

        public final int getBatteryVoltage() {
            return this.batteryVoltage;
        }

        public final int getPinVoltage() {
            return this.pinVoltage;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("HeatingComponentsFailureError(data=");
            String string = Arrays.toString(this.data);
            Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
            return sb.append(string).append(", batteryPercentage=").append(this.batteryPercentage).append(", chargingStatus=").append(this.chargingStatus).append(", thermalResLow=").append(this.thermalResLow).append(", thermalResHigh=").append(this.thermalResHigh).append(", batteryVoltage=").append(this.batteryVoltage).append(", pinVoltage=").append(this.pinVoltage).append(')').toString();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.LogEventData.HeatingComponentsFailureError");
            HeatingComponentsFailureError heatingComponentsFailureError = (HeatingComponentsFailureError) other;
            return this.batteryPercentage == heatingComponentsFailureError.batteryPercentage && this.chargingStatus == heatingComponentsFailureError.chargingStatus && this.thermalResLow == heatingComponentsFailureError.thermalResLow && this.thermalResHigh == heatingComponentsFailureError.thermalResHigh && this.batteryVoltage == heatingComponentsFailureError.batteryVoltage && this.pinVoltage == heatingComponentsFailureError.pinVoltage;
        }

        public int hashCode() {
            return (((((((((this.batteryPercentage * 31) + this.chargingStatus) * 31) + this.thermalResLow) * 31) + this.thermalResHigh) * 31) + this.batteryVoltage) * 31) + this.pinVoltage;
        }
    }
}
