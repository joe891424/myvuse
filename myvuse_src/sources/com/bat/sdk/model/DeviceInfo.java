package com.bat.sdk.model;

import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\b\u00105\u001a\u00020\bH\u0016J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00109\u001a\u00020\u0003H\u0016J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\t\u0010?\u001a\u00020\nHÆ\u0003J\t\u0010@\u001a\u00020\bHÆ\u0003J\t\u0010A\u001a\u00020\bHÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010)J\u0082\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010FR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b/\u0010)\"\u0004\b0\u0010+R\u0011\u00101\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b2\u0010\u001dR\u0011\u00103\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b4\u0010\u001d¨\u0006G"}, m5598d2 = {"Lcom/bat/sdk/model/DeviceInfo;", "", "firmwareMajor", "", "firmwareMinor", "swRevision", "boardClassification", "serialNumber", "", "serialNumber0x", "", "responseHex", "advertisingName", "bootloaderVersion", "uiSection1Version", "uiSection2Version", "<init>", "(IIIILjava/lang/String;[BLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getFirmwareMajor", "()I", "setFirmwareMajor", "(I)V", "getFirmwareMinor", "setFirmwareMinor", "getSwRevision", "setSwRevision", "getBoardClassification", "setBoardClassification", "getSerialNumber", "()Ljava/lang/String;", "setSerialNumber", "(Ljava/lang/String;)V", "getSerialNumber0x", "()[B", "setSerialNumber0x", "([B)V", "getResponseHex", "setResponseHex", "getAdvertisingName", "setAdvertisingName", "getBootloaderVersion", "()Ljava/lang/Integer;", "setBootloaderVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUiSection1Version", "setUiSection1Version", "getUiSection2Version", "setUiSection2Version", "firmwareVersion", "getFirmwareVersion", "version", "getVersion", "toString", "equals", "", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(IIIILjava/lang/String;[BLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bat/sdk/model/DeviceInfo;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class DeviceInfo {
    private String advertisingName;
    private int boardClassification;
    private Integer bootloaderVersion;
    private int firmwareMajor;
    private int firmwareMinor;
    private String responseHex;
    private String serialNumber;
    private byte[] serialNumber0x;
    private int swRevision;
    private Integer uiSection1Version;
    private Integer uiSection2Version;

    public DeviceInfo() {
        this(0, 0, 0, 0, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFirmwareMajor() {
        return this.firmwareMajor;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getUiSection1Version() {
        return this.uiSection1Version;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getUiSection2Version() {
        return this.uiSection2Version;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFirmwareMinor() {
        return this.firmwareMinor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSwRevision() {
        return this.swRevision;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBoardClassification() {
        return this.boardClassification;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSerialNumber() {
        return this.serialNumber;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final byte[] getSerialNumber0x() {
        return this.serialNumber0x;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getResponseHex() {
        return this.responseHex;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAdvertisingName() {
        return this.advertisingName;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getBootloaderVersion() {
        return this.bootloaderVersion;
    }

    public final DeviceInfo copy(int firmwareMajor, int firmwareMinor, int swRevision, int boardClassification, String serialNumber, byte[] serialNumber0x, String responseHex, String advertisingName, Integer bootloaderVersion, Integer uiSection1Version, Integer uiSection2Version) {
        Intrinsics.checkNotNullParameter(serialNumber, "serialNumber");
        Intrinsics.checkNotNullParameter(serialNumber0x, "serialNumber0x");
        Intrinsics.checkNotNullParameter(responseHex, "responseHex");
        Intrinsics.checkNotNullParameter(advertisingName, "advertisingName");
        return new DeviceInfo(firmwareMajor, firmwareMinor, swRevision, boardClassification, serialNumber, serialNumber0x, responseHex, advertisingName, bootloaderVersion, uiSection1Version, uiSection2Version);
    }

    public DeviceInfo(int i, int i2, int i3, int i4, String serialNumber, byte[] serialNumber0x, String responseHex, String advertisingName, Integer num, Integer num2, Integer num3) {
        Intrinsics.checkNotNullParameter(serialNumber, "serialNumber");
        Intrinsics.checkNotNullParameter(serialNumber0x, "serialNumber0x");
        Intrinsics.checkNotNullParameter(responseHex, "responseHex");
        Intrinsics.checkNotNullParameter(advertisingName, "advertisingName");
        this.firmwareMajor = i;
        this.firmwareMinor = i2;
        this.swRevision = i3;
        this.boardClassification = i4;
        this.serialNumber = serialNumber;
        this.serialNumber0x = serialNumber0x;
        this.responseHex = responseHex;
        this.advertisingName = advertisingName;
        this.bootloaderVersion = num;
        this.uiSection1Version = num2;
        this.uiSection2Version = num3;
    }

    public /* synthetic */ DeviceInfo(int i, int i2, int i3, int i4, String str, byte[] bArr, String str2, String str3, Integer num, Integer num2, Integer num3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4, (i5 & 16) != 0 ? "" : str, (i5 & 32) != 0 ? new byte[0] : bArr, (i5 & 64) != 0 ? "" : str2, (i5 & 128) == 0 ? str3 : "", (i5 & 256) != 0 ? null : num, (i5 & 512) != 0 ? null : num2, (i5 & 1024) == 0 ? num3 : null);
    }

    public final int getFirmwareMajor() {
        return this.firmwareMajor;
    }

    public final void setFirmwareMajor(int i) {
        this.firmwareMajor = i;
    }

    public final int getFirmwareMinor() {
        return this.firmwareMinor;
    }

    public final void setFirmwareMinor(int i) {
        this.firmwareMinor = i;
    }

    public final int getSwRevision() {
        return this.swRevision;
    }

    public final void setSwRevision(int i) {
        this.swRevision = i;
    }

    public final int getBoardClassification() {
        return this.boardClassification;
    }

    public final void setBoardClassification(int i) {
        this.boardClassification = i;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final void setSerialNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serialNumber = str;
    }

    public final byte[] getSerialNumber0x() {
        return this.serialNumber0x;
    }

    public final void setSerialNumber0x(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.serialNumber0x = bArr;
    }

    public final String getResponseHex() {
        return this.responseHex;
    }

    public final void setResponseHex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.responseHex = str;
    }

    public final String getAdvertisingName() {
        return this.advertisingName;
    }

    public final void setAdvertisingName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.advertisingName = str;
    }

    public final Integer getBootloaderVersion() {
        return this.bootloaderVersion;
    }

    public final void setBootloaderVersion(Integer num) {
        this.bootloaderVersion = num;
    }

    public final Integer getUiSection1Version() {
        return this.uiSection1Version;
    }

    public final void setUiSection1Version(Integer num) {
        this.uiSection1Version = num;
    }

    public final Integer getUiSection2Version() {
        return this.uiSection2Version;
    }

    public final void setUiSection2Version(Integer num) {
        this.uiSection2Version = num;
    }

    public final String getFirmwareVersion() {
        return this.firmwareMajor + '.' + this.firmwareMinor + '(' + this.swRevision + ")[" + this.boardClassification + ']';
    }

    public final String getVersion() {
        return new StringBuilder().append(this.firmwareMajor).append('.').append(this.firmwareMinor).append('.').append(this.swRevision).append('.').append(this.boardClassification).toString();
    }

    public String toString() {
        return this.firmwareMajor + '.' + this.firmwareMinor + '.' + this.swRevision + '.' + this.boardClassification + SafeJsonPrimitive.NULL_CHAR + this.serialNumber + SafeJsonPrimitive.NULL_CHAR + this.advertisingName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.DeviceInfo");
        DeviceInfo deviceInfo = (DeviceInfo) other;
        return this.firmwareMajor == deviceInfo.firmwareMajor && this.firmwareMinor == deviceInfo.firmwareMinor && this.swRevision == deviceInfo.swRevision && this.boardClassification == deviceInfo.boardClassification && Intrinsics.areEqual(this.serialNumber, deviceInfo.serialNumber) && Arrays.equals(this.serialNumber0x, deviceInfo.serialNumber0x) && Intrinsics.areEqual(this.advertisingName, deviceInfo.advertisingName);
    }

    public int hashCode() {
        return (((((((((((this.firmwareMajor * 31) + this.firmwareMinor) * 31) + this.swRevision) * 31) + this.boardClassification) * 31) + this.serialNumber.hashCode()) * 31) + Arrays.hashCode(this.serialNumber0x)) * 31) + this.advertisingName.hashCode();
    }
}
