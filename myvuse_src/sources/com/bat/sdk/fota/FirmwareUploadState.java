package com.bat.sdk.fota;

import com.bat.sdk.model.FotaVersion;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FirmwareUploadState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, m5598d2 = {"Lcom/bat/sdk/fota/FirmwareUploadState;", "", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "Idle", "Started", "WaitingForChunkAcceptance", "Finishing", "Lcom/bat/sdk/fota/FirmwareUploadState$Finishing;", "Lcom/bat/sdk/fota/FirmwareUploadState$Idle;", "Lcom/bat/sdk/fota/FirmwareUploadState$Started;", "Lcom/bat/sdk/fota/FirmwareUploadState$WaitingForChunkAcceptance;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class FirmwareUploadState {
    private final String deviceAddress;

    public /* synthetic */ FirmwareUploadState(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private FirmwareUploadState(String str) {
        this.deviceAddress = str;
    }

    public String getDeviceAddress() {
        return this.deviceAddress;
    }

    /* JADX INFO: compiled from: FirmwareUploadState.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/fota/FirmwareUploadState$Idle;", "Lcom/bat/sdk/fota/FirmwareUploadState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Idle extends FirmwareUploadState {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Idle(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.fota.FirmwareUploadState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        public String toString() {
            return "idle";
        }
    }

    /* JADX INFO: compiled from: FirmwareUploadState.kt */
    @Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0003H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, m5598d2 = {"Lcom/bat/sdk/fota/FirmwareUploadState$Started;", "Lcom/bat/sdk/fota/FirmwareUploadState;", "deviceAddress", "", "filename", "fotaVersion", "Lcom/bat/sdk/model/FotaVersion;", "chunks", "", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bat/sdk/model/FotaVersion;Ljava/util/List;)V", "getDeviceAddress", "()Ljava/lang/String;", "getFilename", "getFotaVersion", "()Lcom/bat/sdk/model/FotaVersion;", "getChunks", "()Ljava/util/List;", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Started extends FirmwareUploadState {
        private final List<byte[]> chunks;
        private final String deviceAddress;
        private final String filename;
        private final FotaVersion fotaVersion;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Started copy$default(Started started, String str, String str2, FotaVersion fotaVersion, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = started.deviceAddress;
            }
            if ((i & 2) != 0) {
                str2 = started.filename;
            }
            if ((i & 4) != 0) {
                fotaVersion = started.fotaVersion;
            }
            if ((i & 8) != 0) {
                list = started.chunks;
            }
            return started.copy(str, str2, fotaVersion, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFilename() {
            return this.filename;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final FotaVersion getFotaVersion() {
            return this.fotaVersion;
        }

        public final List<byte[]> component4() {
            return this.chunks;
        }

        public final Started copy(String deviceAddress, String filename, FotaVersion fotaVersion, List<byte[]> chunks) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(filename, "filename");
            Intrinsics.checkNotNullParameter(fotaVersion, "fotaVersion");
            Intrinsics.checkNotNullParameter(chunks, "chunks");
            return new Started(deviceAddress, filename, fotaVersion, chunks);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Started)) {
                return false;
            }
            Started started = (Started) other;
            return Intrinsics.areEqual(this.deviceAddress, started.deviceAddress) && Intrinsics.areEqual(this.filename, started.filename) && Intrinsics.areEqual(this.fotaVersion, started.fotaVersion) && Intrinsics.areEqual(this.chunks, started.chunks);
        }

        public int hashCode() {
            return (((((this.deviceAddress.hashCode() * 31) + this.filename.hashCode()) * 31) + this.fotaVersion.hashCode()) * 31) + this.chunks.hashCode();
        }

        @Override // com.bat.sdk.fota.FirmwareUploadState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final String getFilename() {
            return this.filename;
        }

        public final FotaVersion getFotaVersion() {
            return this.fotaVersion;
        }

        public final List<byte[]> getChunks() {
            return this.chunks;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Started(String deviceAddress, String filename, FotaVersion fotaVersion, List<byte[]> chunks) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(filename, "filename");
            Intrinsics.checkNotNullParameter(fotaVersion, "fotaVersion");
            Intrinsics.checkNotNullParameter(chunks, "chunks");
            this.deviceAddress = deviceAddress;
            this.filename = filename;
            this.fotaVersion = fotaVersion;
            this.chunks = chunks;
        }

        public String toString() {
            return "upload started: " + this.chunks.size();
        }
    }

    /* JADX INFO: compiled from: FirmwareUploadState.kt */
    @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0003H\u0016J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m5598d2 = {"Lcom/bat/sdk/fota/FirmwareUploadState$WaitingForChunkAcceptance;", "Lcom/bat/sdk/fota/FirmwareUploadState;", "deviceAddress", "", "chunks", "", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getDeviceAddress", "()Ljava/lang/String;", "getChunks", "()Ljava/util/List;", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class WaitingForChunkAcceptance extends FirmwareUploadState {
        private final List<byte[]> chunks;
        private final String deviceAddress;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WaitingForChunkAcceptance copy$default(WaitingForChunkAcceptance waitingForChunkAcceptance, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = waitingForChunkAcceptance.deviceAddress;
            }
            if ((i & 2) != 0) {
                list = waitingForChunkAcceptance.chunks;
            }
            return waitingForChunkAcceptance.copy(str, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final List<byte[]> component2() {
            return this.chunks;
        }

        public final WaitingForChunkAcceptance copy(String deviceAddress, List<byte[]> chunks) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(chunks, "chunks");
            return new WaitingForChunkAcceptance(deviceAddress, chunks);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WaitingForChunkAcceptance)) {
                return false;
            }
            WaitingForChunkAcceptance waitingForChunkAcceptance = (WaitingForChunkAcceptance) other;
            return Intrinsics.areEqual(this.deviceAddress, waitingForChunkAcceptance.deviceAddress) && Intrinsics.areEqual(this.chunks, waitingForChunkAcceptance.chunks);
        }

        public int hashCode() {
            return (this.deviceAddress.hashCode() * 31) + this.chunks.hashCode();
        }

        @Override // com.bat.sdk.fota.FirmwareUploadState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final List<byte[]> getChunks() {
            return this.chunks;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WaitingForChunkAcceptance(String deviceAddress, List<byte[]> chunks) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(chunks, "chunks");
            this.deviceAddress = deviceAddress;
            this.chunks = chunks;
        }

        public String toString() {
            return "chunk sent, remaining " + this.chunks.size();
        }
    }

    /* JADX INFO: compiled from: FirmwareUploadState.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/fota/FirmwareUploadState$Finishing;", "Lcom/bat/sdk/fota/FirmwareUploadState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Finishing extends FirmwareUploadState {
        private final String deviceAddress;

        public static /* synthetic */ Finishing copy$default(Finishing finishing, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = finishing.deviceAddress;
            }
            return finishing.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final Finishing copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new Finishing(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Finishing) && Intrinsics.areEqual(this.deviceAddress, ((Finishing) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Finishing(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.fota.FirmwareUploadState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        public String toString() {
            return "finishing";
        }
    }
}
