package com.bat.sdk.fota;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FirmwareUploadResult.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, m5598d2 = {"Lcom/bat/sdk/fota/FirmwareUploadResult;", "", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "Success", "Error", "Lcom/bat/sdk/fota/FirmwareUploadResult$Error;", "Lcom/bat/sdk/fota/FirmwareUploadResult$Success;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class FirmwareUploadResult {
    private final String deviceAddress;

    public /* synthetic */ FirmwareUploadResult(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private FirmwareUploadResult(String str) {
        this.deviceAddress = str;
    }

    public String getDeviceAddress() {
        return this.deviceAddress;
    }

    /* JADX INFO: compiled from: FirmwareUploadResult.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/fota/FirmwareUploadResult$Success;", "Lcom/bat/sdk/fota/FirmwareUploadResult;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Success extends FirmwareUploadResult {
        private final String deviceAddress;

        public static /* synthetic */ Success copy$default(Success success, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.deviceAddress;
            }
            return success.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final Success copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new Success(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.deviceAddress, ((Success) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.fota.FirmwareUploadResult
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        public String toString() {
            return FirebaseAnalytics.Param.SUCCESS;
        }
    }

    /* JADX INFO: compiled from: FirmwareUploadResult.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/fota/FirmwareUploadResult$Error;", "Lcom/bat/sdk/fota/FirmwareUploadResult;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Error extends FirmwareUploadResult {
        private final String deviceAddress;

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.deviceAddress;
            }
            return error.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final Error copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new Error(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.deviceAddress, ((Error) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.fota.FirmwareUploadResult
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        public String toString() {
            return "error";
        }
    }
}
