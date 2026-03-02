package com.bat.sdk.ble;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Parcel;
import android.os.Parcelable;
import com.bat.sdk.model.CharacteristicType;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatCharacteristic.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 >2\u00020\u0001:\u0001>B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\f\u0010\u0013J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\u0006\u0010-\u001a\u00020\tJ\u0006\u0010.\u001a\u00020\tJ\u000e\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u000201J\u000e\u0010/\u001a\u00020\t2\u0006\u00102\u001a\u000203J\u0018\u00104\u001a\u0002052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00106\u001a\u00020$H\u0016J\b\u00107\u001a\u00020$H\u0016J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\t\u0010<\u001a\u00020\u000bHÆ\u0003J=\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010&\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b)\u0010\u001dR\u0011\u0010*\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b*\u0010\u001dR\u0011\u0010+\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b+\u0010\u001dR\u0011\u0010,\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b,\u0010\u001d¨\u0006?"}, m5598d2 = {"Lcom/bat/sdk/ble/BatCharacteristic;", "Landroid/os/Parcelable;", "name", "", AnalyticsAttribute.UUID_ATTRIBUTE, "Ljava/util/UUID;", "gattCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "optional", "", "type", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "(Ljava/lang/String;Ljava/util/UUID;Landroid/bluetooth/BluetoothGattCharacteristic;ZLcom/bat/sdk/model/CharacteristicType;)V", "uuidString", "characteristicType", "(Ljava/lang/String;Ljava/lang/String;ZLcom/bat/sdk/model/CharacteristicType;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getName", "()Ljava/lang/String;", "getUuid", "()Ljava/util/UUID;", "getGattCharacteristic", "()Landroid/bluetooth/BluetoothGattCharacteristic;", "setGattCharacteristic", "(Landroid/bluetooth/BluetoothGattCharacteristic;)V", "getOptional", "()Z", "getType", "()Lcom/bat/sdk/model/CharacteristicType;", "equals", "other", "", "hashCode", "", "toString", "properties", "getProperties", "()I", "isReadSupported", "isWriteSupported", "isNotifySupported", "isIndicateSupported", "isNotifyEnabled", "isIndicateEnabled", "setup", "gattService", "Landroid/bluetooth/BluetoothGattService;", "batService", "Lcom/bat/sdk/ble/BatService;", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "copy", "CREATOR", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class BatCharacteristic implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private BluetoothGattCharacteristic gattCharacteristic;
    private final String name;
    private final boolean optional;
    private final CharacteristicType type;
    private final UUID uuid;

    public static /* synthetic */ BatCharacteristic copy$default(BatCharacteristic batCharacteristic, String str, UUID uuid, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, CharacteristicType characteristicType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = batCharacteristic.name;
        }
        if ((i & 2) != 0) {
            uuid = batCharacteristic.uuid;
        }
        UUID uuid2 = uuid;
        if ((i & 4) != 0) {
            bluetoothGattCharacteristic = batCharacteristic.gattCharacteristic;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic2 = bluetoothGattCharacteristic;
        if ((i & 8) != 0) {
            z = batCharacteristic.optional;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            characteristicType = batCharacteristic.type;
        }
        return batCharacteristic.copy(str, uuid2, bluetoothGattCharacteristic2, z2, characteristicType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UUID getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final BluetoothGattCharacteristic getGattCharacteristic() {
        return this.gattCharacteristic;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getOptional() {
        return this.optional;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final CharacteristicType getType() {
        return this.type;
    }

    public final BatCharacteristic copy(String name, UUID uuid, BluetoothGattCharacteristic gattCharacteristic, boolean optional, CharacteristicType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(type, "type");
        return new BatCharacteristic(name, uuid, gattCharacteristic, optional, type);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BatCharacteristic(String name, UUID uuid, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, CharacteristicType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(type, "type");
        this.name = name;
        this.uuid = uuid;
        this.gattCharacteristic = bluetoothGattCharacteristic;
        this.optional = z;
        this.type = type;
    }

    public final String getName() {
        return this.name;
    }

    public final UUID getUuid() {
        return this.uuid;
    }

    public final BluetoothGattCharacteristic getGattCharacteristic() {
        return this.gattCharacteristic;
    }

    public final void setGattCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.gattCharacteristic = bluetoothGattCharacteristic;
    }

    public final boolean getOptional() {
        return this.optional;
    }

    public /* synthetic */ BatCharacteristic(String str, UUID uuid, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, CharacteristicType.Generic generic, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, uuid, (i & 4) != 0 ? null : bluetoothGattCharacteristic, (i & 8) != 0 ? false : z, (i & 16) != 0 ? CharacteristicType.Generic.INSTANCE : generic);
    }

    public final CharacteristicType getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        BatCharacteristic batCharacteristic = other instanceof BatCharacteristic ? (BatCharacteristic) other : null;
        if (batCharacteristic == null) {
            return false;
        }
        return Intrinsics.areEqual(this.uuid, batCharacteristic.uuid);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.uuid.hashCode();
    }

    public String toString() {
        return this.name + ": " + this.uuid + " - " + this.gattCharacteristic;
    }

    public /* synthetic */ BatCharacteristic(String str, String str2, boolean z, CharacteristicType.Generic generic, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? CharacteristicType.Generic.INSTANCE : generic);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BatCharacteristic(String name, String uuidString, boolean z, CharacteristicType characteristicType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(uuidString, "uuidString");
        Intrinsics.checkNotNullParameter(characteristicType, "characteristicType");
        UUID uuidFromString = UUID.fromString(uuidString);
        Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
        this(name, uuidFromString, null, z, characteristicType, 4, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BatCharacteristic(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        Serializable serializable = parcel.readSerializable();
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type java.util.UUID");
        this(str, (UUID) serializable, (BluetoothGattCharacteristic) parcel.readParcelable(BluetoothGattCharacteristic.class.getClassLoader()), parcel.readByte() != 0, CharacteristicType.INSTANCE.fromCode(parcel.readInt()));
    }

    private final int getProperties() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.gattCharacteristic;
        if (bluetoothGattCharacteristic != null) {
            return bluetoothGattCharacteristic.getProperties();
        }
        return 0;
    }

    public final boolean isReadSupported() {
        return (getProperties() & 2) != 0;
    }

    public final boolean isWriteSupported() {
        return (getProperties() & 8) != 0;
    }

    public final boolean isNotifySupported() {
        return (getProperties() & 16) != 0;
    }

    public final boolean isIndicateSupported() {
        return (getProperties() & 32) != 0;
    }

    public final boolean isNotifyEnabled() {
        BluetoothGattDescriptor descriptor;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.gattCharacteristic;
        return Arrays.equals((bluetoothGattCharacteristic == null || (descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"))) == null) ? null : descriptor.getValue(), BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
    }

    public final boolean isIndicateEnabled() {
        BluetoothGattDescriptor descriptor;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.gattCharacteristic;
        return Arrays.equals((bluetoothGattCharacteristic == null || (descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"))) == null) ? null : descriptor.getValue(), BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
    }

    public final boolean setup(BluetoothGattService gattService) {
        Object next;
        Intrinsics.checkNotNullParameter(gattService, "gattService");
        List<BluetoothGattCharacteristic> characteristics = gattService.getCharacteristics();
        Intrinsics.checkNotNullExpressionValue(characteristics, "getCharacteristics(...)");
        Iterator<T> it2 = characteristics.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (Intrinsics.areEqual(((BluetoothGattCharacteristic) next).getUuid(), this.uuid)) {
                break;
            }
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) next;
        if (bluetoothGattCharacteristic == null) {
            return false;
        }
        this.gattCharacteristic = bluetoothGattCharacteristic;
        return true;
    }

    public final boolean setup(BatService batService) {
        Intrinsics.checkNotNullParameter(batService, "batService");
        BluetoothGattService gattService = batService.getGattService();
        if (gattService == null) {
            return false;
        }
        return setup(gattService);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeSerializable(this.uuid);
        parcel.writeParcelable(this.gattCharacteristic, flags);
        parcel.writeByte(this.optional ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.type.getCode());
    }

    /* JADX INFO: renamed from: com.bat.sdk.ble.BatCharacteristic$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: BatCharacteristic.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, m5598d2 = {"Lcom/bat/sdk/ble/BatCharacteristic$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/bat/sdk/ble/BatCharacteristic;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/bat/sdk/ble/BatCharacteristic;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion implements Parcelable.Creator<BatCharacteristic> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BatCharacteristic createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BatCharacteristic(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BatCharacteristic[] newArray(int size) {
            return new BatCharacteristic[size];
        }
    }
}
