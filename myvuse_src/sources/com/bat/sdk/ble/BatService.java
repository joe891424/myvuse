package com.bat.sdk.ble;

import android.bluetooth.BluetoothGattService;
import android.os.Parcel;
import android.os.Parcelable;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.ServiceType;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00013B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\r\u0010\u0011B/\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u0013J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020%H\u0016J\u0014\u0010&\u001a\u00020!2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u000bJ\u0018\u0010(\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010*\u001a\u00020%H\u0016J\b\u0010+\u001a\u00020%H\u0016J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JC\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00064"}, m5598d2 = {"Lcom/bat/sdk/ble/BatService;", "Landroid/os/Parcelable;", AnalyticsAttribute.UUID_ATTRIBUTE, "Ljava/util/UUID;", "name", "", "serviceType", "Lcom/bat/sdk/model/ServiceType;", "gattService", "Landroid/bluetooth/BluetoothGattService;", "characteristics", "", "Lcom/bat/sdk/ble/BatCharacteristic;", "<init>", "(Ljava/util/UUID;Ljava/lang/String;Lcom/bat/sdk/model/ServiceType;Landroid/bluetooth/BluetoothGattService;Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "uuidString", "(Ljava/lang/String;Ljava/lang/String;Lcom/bat/sdk/model/ServiceType;Ljava/util/List;)V", "getUuid", "()Ljava/util/UUID;", "getName", "()Ljava/lang/String;", "getServiceType", "()Lcom/bat/sdk/model/ServiceType;", "getGattService", "()Landroid/bluetooth/BluetoothGattService;", "setGattService", "(Landroid/bluetooth/BluetoothGattService;)V", "getCharacteristics", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "", "setup", "gattServices", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "copy", "toString", "CREATOR", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class BatService implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<BatCharacteristic> characteristics;
    private BluetoothGattService gattService;
    private final String name;
    private final ServiceType serviceType;
    private final UUID uuid;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BatService copy$default(BatService batService, UUID uuid, String str, ServiceType serviceType, BluetoothGattService bluetoothGattService, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            uuid = batService.uuid;
        }
        if ((i & 2) != 0) {
            str = batService.name;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            serviceType = batService.serviceType;
        }
        ServiceType serviceType2 = serviceType;
        if ((i & 8) != 0) {
            bluetoothGattService = batService.gattService;
        }
        BluetoothGattService bluetoothGattService2 = bluetoothGattService;
        if ((i & 16) != 0) {
            list = batService.characteristics;
        }
        return batService.copy(uuid, str2, serviceType2, bluetoothGattService2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UUID getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ServiceType getServiceType() {
        return this.serviceType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final BluetoothGattService getGattService() {
        return this.gattService;
    }

    public final List<BatCharacteristic> component5() {
        return this.characteristics;
    }

    public final BatService copy(UUID uuid, String name, ServiceType serviceType, BluetoothGattService gattService, List<BatCharacteristic> characteristics) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        Intrinsics.checkNotNullParameter(characteristics, "characteristics");
        return new BatService(uuid, name, serviceType, gattService, characteristics);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "BatService(uuid=" + this.uuid + ", name=" + this.name + ", serviceType=" + this.serviceType + ", gattService=" + this.gattService + ", characteristics=" + this.characteristics + ')';
    }

    public BatService(UUID uuid, String name, ServiceType serviceType, BluetoothGattService bluetoothGattService, List<BatCharacteristic> characteristics) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        Intrinsics.checkNotNullParameter(characteristics, "characteristics");
        this.uuid = uuid;
        this.name = name;
        this.serviceType = serviceType;
        this.gattService = bluetoothGattService;
        this.characteristics = characteristics;
    }

    public final UUID getUuid() {
        return this.uuid;
    }

    public final String getName() {
        return this.name;
    }

    public final ServiceType getServiceType() {
        return this.serviceType;
    }

    public final BluetoothGattService getGattService() {
        return this.gattService;
    }

    public final void setGattService(BluetoothGattService bluetoothGattService) {
        this.gattService = bluetoothGattService;
    }

    public final List<BatCharacteristic> getCharacteristics() {
        return this.characteristics;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BatService(Parcel parcel) {
        List list;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Serializable serializable = parcel.readSerializable();
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type java.util.UUID");
        UUID uuid = (UUID) serializable;
        String string = parcel.readString();
        String str = string == null ? "" : string;
        ServiceType serviceTypeFromCode = ServiceType.INSTANCE.fromCode(parcel.readInt());
        BluetoothGattService bluetoothGattService = (BluetoothGattService) parcel.readParcelable(BluetoothGattService.class.getClassLoader());
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(BatCharacteristic.INSTANCE);
        this(uuid, str, serviceTypeFromCode, bluetoothGattService, (arrayListCreateTypedArrayList == null || (list = CollectionsKt.toList(arrayListCreateTypedArrayList)) == null) ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BatService(String name, String uuidString, ServiceType serviceType, List<BatCharacteristic> characteristics) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(uuidString, "uuidString");
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        Intrinsics.checkNotNullParameter(characteristics, "characteristics");
        UUID uuidFromString = UUID.fromString(uuidString);
        Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
        this(uuidFromString, name, serviceType, null, characteristics);
    }

    public boolean equals(Object other) {
        BatService batService = other instanceof BatService ? (BatService) other : null;
        if (batService == null) {
            return false;
        }
        return Intrinsics.areEqual(this.uuid, batService.uuid);
    }

    public int hashCode() {
        return this.uuid.hashCode();
    }

    public final boolean setup(List<? extends BluetoothGattService> gattServices) {
        Object next;
        Intrinsics.checkNotNullParameter(gattServices, "gattServices");
        Iterator<T> it2 = gattServices.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (Intrinsics.areEqual(((BluetoothGattService) next).getUuid(), this.uuid)) {
                break;
            }
        }
        BluetoothGattService bluetoothGattService = (BluetoothGattService) next;
        if (bluetoothGattService == null) {
            Logger logger = Logger.INSTANCE;
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            logger.log(name, this.name + ": gatt service not found");
            return false;
        }
        this.gattService = bluetoothGattService;
        for (BatCharacteristic batCharacteristic : this.characteristics) {
            if (!batCharacteristic.setup(this) && !batCharacteristic.getOptional()) {
                Logger logger2 = Logger.INSTANCE;
                String name2 = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                logger2.log(name2, batCharacteristic.getName() + " is not setup");
                return false;
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeSerializable(this.uuid);
        parcel.writeString(this.name);
        parcel.writeInt(this.serviceType.getCode());
        parcel.writeParcelable(this.gattService, flags);
        parcel.writeTypedList(this.characteristics);
    }

    /* JADX INFO: renamed from: com.bat.sdk.ble.BatService$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: BatService.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, m5598d2 = {"Lcom/bat/sdk/ble/BatService$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/bat/sdk/ble/BatService;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/bat/sdk/ble/BatService;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion implements Parcelable.Creator<BatService> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BatService createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BatService(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BatService[] newArray(int size) {
            return new BatService[size];
        }
    }
}
