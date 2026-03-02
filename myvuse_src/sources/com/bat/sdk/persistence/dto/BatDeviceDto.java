package com.bat.sdk.persistence.dto;

import com.bat.sdk.ble.BatDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatDeviceDto.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001b"}, m5598d2 = {"Lcom/bat/sdk/persistence/dto/BatDeviceDto;", "", "id", "", "name", "", "address", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getAddress", "toBatDevice", "Lcom/bat/sdk/ble/BatDevice;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class BatDeviceDto {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String address;
    private final long id;
    private final String name;

    public static /* synthetic */ BatDeviceDto copy$default(BatDeviceDto batDeviceDto, long j, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = batDeviceDto.id;
        }
        if ((i & 2) != 0) {
            str = batDeviceDto.name;
        }
        if ((i & 4) != 0) {
            str2 = batDeviceDto.address;
        }
        return batDeviceDto.copy(j, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    public final BatDeviceDto copy(long id, String name, String address) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(address, "address");
        return new BatDeviceDto(id, name, address);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatDeviceDto)) {
            return false;
        }
        BatDeviceDto batDeviceDto = (BatDeviceDto) other;
        return this.id == batDeviceDto.id && Intrinsics.areEqual(this.name, batDeviceDto.name) && Intrinsics.areEqual(this.address, batDeviceDto.address);
    }

    public int hashCode() {
        return (((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.address.hashCode();
    }

    public String toString() {
        return "BatDeviceDto(id=" + this.id + ", name=" + this.name + ", address=" + this.address + ')';
    }

    public BatDeviceDto(long j, String name, String address) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(address, "address");
        this.id = j;
        this.name = name;
        this.address = address;
    }

    public /* synthetic */ BatDeviceDto(long j, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, str2);
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAddress() {
        return this.address;
    }

    public final BatDevice toBatDevice() {
        return new BatDevice(this.name, this.address, 0, null, 8, null);
    }

    /* JADX INFO: compiled from: BatDeviceDto.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/persistence/dto/BatDeviceDto$Companion;", "", "<init>", "()V", "fromBatDevice", "Lcom/bat/sdk/persistence/dto/BatDeviceDto;", "device", "Lcom/bat/sdk/ble/BatDevice;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BatDeviceDto fromBatDevice(BatDevice device) {
            Intrinsics.checkNotNullParameter(device, "device");
            return new BatDeviceDto(0L, device.getName(), device.getAddress(), 1, null);
        }
    }
}
