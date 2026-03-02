package com.bat.sdk.ble;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.work.WorkRequest;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BleRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t#$%&'()*+B'\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0084\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0017X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u001f\u0082\u0001\t,-./01234¨\u00065"}, m5598d2 = {"Lcom/bat/sdk/ble/BleRequest;", "", "deviceAddress", "", "batCharacteristic", "Lcom/bat/sdk/ble/BatCharacteristic;", "timeout", "", "<init>", "(Ljava/lang/String;Lcom/bat/sdk/ble/BatCharacteristic;J)V", "getDeviceAddress", "()Ljava/lang/String;", "getBatCharacteristic", "()Lcom/bat/sdk/ble/BatCharacteristic;", "getTimeout", "()J", "descriptorUuid", "Ljava/util/UUID;", "kotlin.jvm.PlatformType", "getDescriptorUuid", "()Ljava/util/UUID;", "Ljava/util/UUID;", "needsPending", "", "getNeedsPending", "()Z", "canSkip", "getCanSkip", "millisCount", "getMillisCount", "setMillisCount", "(J)V", "execute", "gatt", "Landroid/bluetooth/BluetoothGatt;", "ReadRssi", "DiscoverServices", "Mtu", "Read", "Write", "EnableNotification", "DisableNotification", "EnableIndication", "DisableIndication", "Lcom/bat/sdk/ble/BleRequest$DisableIndication;", "Lcom/bat/sdk/ble/BleRequest$DisableNotification;", "Lcom/bat/sdk/ble/BleRequest$DiscoverServices;", "Lcom/bat/sdk/ble/BleRequest$EnableIndication;", "Lcom/bat/sdk/ble/BleRequest$EnableNotification;", "Lcom/bat/sdk/ble/BleRequest$Mtu;", "Lcom/bat/sdk/ble/BleRequest$Read;", "Lcom/bat/sdk/ble/BleRequest$ReadRssi;", "Lcom/bat/sdk/ble/BleRequest$Write;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class BleRequest {
    private final BatCharacteristic batCharacteristic;
    private final boolean canSkip;
    private final UUID descriptorUuid;
    private final String deviceAddress;
    private long millisCount;
    private final boolean needsPending;
    private final long timeout;

    public /* synthetic */ BleRequest(String str, BatCharacteristic batCharacteristic, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, batCharacteristic, j);
    }

    public abstract boolean execute(BluetoothGatt gatt);

    private BleRequest(String str, BatCharacteristic batCharacteristic, long j) {
        this.deviceAddress = str;
        this.batCharacteristic = batCharacteristic;
        this.timeout = j;
        this.descriptorUuid = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        this.needsPending = true;
    }

    public /* synthetic */ BleRequest(String str, BatCharacteristic batCharacteristic, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : batCharacteristic, (i & 4) != 0 ? WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS : j, null);
    }

    public final String getDeviceAddress() {
        return this.deviceAddress;
    }

    public final BatCharacteristic getBatCharacteristic() {
        return this.batCharacteristic;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    protected final UUID getDescriptorUuid() {
        return this.descriptorUuid;
    }

    public boolean getNeedsPending() {
        return this.needsPending;
    }

    public boolean getCanSkip() {
        return this.canSkip;
    }

    public final long getMillisCount() {
        return this.millisCount;
    }

    public final void setMillisCount(long j) {
        this.millisCount = j;
    }

    /* JADX INFO: compiled from: BleRequest.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, m5598d2 = {"Lcom/bat/sdk/ble/BleRequest$ReadRssi;", "Lcom/bat/sdk/ble/BleRequest;", "deviceAddress", "", "timeout", "", "<init>", "(Ljava/lang/String;J)V", "canSkip", "", "getCanSkip", "()Z", "toString", "execute", "gatt", "Landroid/bluetooth/BluetoothGatt;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class ReadRssi extends BleRequest {
        private final boolean canSkip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReadRssi(String deviceAddress, long j) {
            super(deviceAddress, null, j, 2, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.canSkip = true;
        }

        @Override // com.bat.sdk.ble.BleRequest
        public boolean getCanSkip() {
            return this.canSkip;
        }

        public String toString() {
            return "read rssi";
        }

        @Override // com.bat.sdk.ble.BleRequest
        public boolean execute(BluetoothGatt gatt) {
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            return gatt.readRemoteRssi();
        }
    }

    /* JADX INFO: compiled from: BleRequest.kt */
    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, m5598d2 = {"Lcom/bat/sdk/ble/BleRequest$DiscoverServices;", "Lcom/bat/sdk/ble/BleRequest;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "toString", "execute", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class DiscoverServices extends BleRequest {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DiscoverServices(String deviceAddress) {
            super(deviceAddress, null, 0L, 6, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        }

        public String toString() {
            return "discover services";
        }

        @Override // com.bat.sdk.ble.BleRequest
        public boolean execute(BluetoothGatt gatt) {
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            return gatt.discoverServices();
        }
    }

    /* JADX INFO: compiled from: BleRequest.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, m5598d2 = {"Lcom/bat/sdk/ble/BleRequest$Mtu;", "Lcom/bat/sdk/ble/BleRequest;", "deviceAddress", "", "size", "", "<init>", "(Ljava/lang/String;I)V", "getSize", "()I", "toString", "execute", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Mtu extends BleRequest {
        private final int size;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Mtu(String deviceAddress, int i) {
            super(deviceAddress, null, 0L, 6, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.size = i;
        }

        public final int getSize() {
            return this.size;
        }

        public String toString() {
            return "setting mtu to " + this.size;
        }

        @Override // com.bat.sdk.ble.BleRequest
        public boolean execute(BluetoothGatt gatt) {
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            return gatt.requestMtu(this.size);
        }
    }

    /* JADX INFO: compiled from: BleRequest.kt */
    @Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, m5598d2 = {"Lcom/bat/sdk/ble/BleRequest$Read;", "Lcom/bat/sdk/ble/BleRequest;", "deviceAddress", "", "batCharacteristic", "Lcom/bat/sdk/ble/BatCharacteristic;", "callback", "Lkotlin/Function1;", "", "", "<init>", "(Ljava/lang/String;Lcom/bat/sdk/ble/BatCharacteristic;Lkotlin/jvm/functions/Function1;)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "toString", "execute", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Read extends BleRequest {
        private final Function1<byte[], Unit> callback;

        public final Function1<byte[], Unit> getCallback() {
            return this.callback;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Read(String deviceAddress, BatCharacteristic batCharacteristic, Function1<? super byte[], Unit> callback) {
            super(deviceAddress, batCharacteristic, 0L, 4, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(batCharacteristic, "batCharacteristic");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callback = callback;
        }

        public String toString() {
            return "read from " + getBatCharacteristic();
        }

        @Override // com.bat.sdk.ble.BleRequest
        public boolean execute(BluetoothGatt gatt) {
            BluetoothGattCharacteristic gattCharacteristic;
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            BatCharacteristic batCharacteristic = getBatCharacteristic();
            if (batCharacteristic == null || (gattCharacteristic = batCharacteristic.getGattCharacteristic()) == null || !getBatCharacteristic().isReadSupported()) {
                return false;
            }
            return gatt.readCharacteristic(gattCharacteristic);
        }
    }

    /* JADX INFO: compiled from: BleRequest.kt */
    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/ble/BleRequest$Write;", "Lcom/bat/sdk/ble/BleRequest;", "deviceAddress", "", "batCharacteristic", "Lcom/bat/sdk/ble/BatCharacteristic;", "bytes", "", "<init>", "(Ljava/lang/String;Lcom/bat/sdk/ble/BatCharacteristic;[B)V", "getBytes", "()[B", "toString", "execute", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Write extends BleRequest {
        private final byte[] bytes;

        public final byte[] getBytes() {
            return this.bytes;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Write(String deviceAddress, BatCharacteristic batCharacteristic, byte[] bytes) {
            super(deviceAddress, batCharacteristic, 0L, 4, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(batCharacteristic, "batCharacteristic");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            this.bytes = bytes;
        }

        public String toString() {
            return "write to " + getBatCharacteristic();
        }

        @Override // com.bat.sdk.ble.BleRequest
        public boolean execute(BluetoothGatt gatt) {
            BluetoothGattCharacteristic gattCharacteristic;
            BluetoothGattCharacteristic gattCharacteristic2;
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            Logger logger = Logger.INSTANCE;
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            StringBuilder sbAppend = new StringBuilder("executing write to ").append(gatt.getDevice().getAddress()).append(" ,").append(getBatCharacteristic()).append(",  ");
            BatCharacteristic batCharacteristic = getBatCharacteristic();
            StringBuilder sbAppend2 = sbAppend.append(batCharacteristic != null ? batCharacteristic.getName() : null).append(SafeJsonPrimitive.NULL_CHAR);
            BatCharacteristic batCharacteristic2 = getBatCharacteristic();
            StringBuilder sbAppend3 = sbAppend2.append(batCharacteristic2 != null ? batCharacteristic2.getUuid() : null).append(", ");
            BatCharacteristic batCharacteristic3 = getBatCharacteristic();
            logger.log(name, sbAppend3.append((batCharacteristic3 == null || (gattCharacteristic2 = batCharacteristic3.getGattCharacteristic()) == null) ? null : gattCharacteristic2.getUuid()).append(", value:").append(ConversionExtensionsKt.toHex(this.bytes)).toString());
            BatCharacteristic batCharacteristic4 = getBatCharacteristic();
            if (batCharacteristic4 == null || (gattCharacteristic = batCharacteristic4.getGattCharacteristic()) == null) {
                return false;
            }
            if (!getBatCharacteristic().isWriteSupported()) {
                Logger logger2 = Logger.INSTANCE;
                String name2 = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                logger2.log(name2, "write is not supported for " + getBatCharacteristic().getName() + ", value:" + ConversionExtensionsKt.toHex(this.bytes));
                return false;
            }
            Logger logger3 = Logger.INSTANCE;
            String name3 = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
            StringBuilder sbAppend4 = new StringBuilder("write to ").append(getBatCharacteristic().getName()).append(" valueOld :");
            byte[] value = gattCharacteristic.getValue();
            StringBuilder sbAppend5 = sbAppend4.append(value != null ? ConversionExtensionsKt.toHex(value) : null).append(", bytearray:").append(gattCharacteristic.getValue()).append(", size:");
            byte[] value2 = gattCharacteristic.getValue();
            logger3.log(name3, sbAppend5.append(value2 != null ? Integer.valueOf(value2.length) : null).append(" bytes:").append(ConversionExtensionsKt.toHex(this.bytes)).toString());
            gattCharacteristic.setWriteType(2);
            gattCharacteristic.setValue(this.bytes);
            Logger logger4 = Logger.INSTANCE;
            String name4 = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
            logger4.log(name4, "req: " + this + ", gatt:" + gatt + ", char:" + gattCharacteristic);
            boolean zWriteCharacteristic = gatt.writeCharacteristic(gattCharacteristic);
            if (!zWriteCharacteristic) {
                Logger logger5 = Logger.INSTANCE;
                String name5 = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name5, "getName(...)");
                logger5.log(name5, "write to " + getBatCharacteristic().getName() + " failed value:" + ConversionExtensionsKt.toHex(this.bytes) + ", bytearray:" + this.bytes + '.');
            }
            return zWriteCharacteristic;
        }
    }

    /* JADX INFO: compiled from: BleRequest.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, m5598d2 = {"Lcom/bat/sdk/ble/BleRequest$EnableNotification;", "Lcom/bat/sdk/ble/BleRequest;", "deviceAddress", "", "batCharacteristic", "Lcom/bat/sdk/ble/BatCharacteristic;", "<init>", "(Ljava/lang/String;Lcom/bat/sdk/ble/BatCharacteristic;)V", "toString", "execute", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class EnableNotification extends BleRequest {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnableNotification(String deviceAddress, BatCharacteristic batCharacteristic) {
            super(deviceAddress, batCharacteristic, 0L, 4, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(batCharacteristic, "batCharacteristic");
        }

        public String toString() {
            return "enable notifications from " + getBatCharacteristic();
        }

        @Override // com.bat.sdk.ble.BleRequest
        public boolean execute(BluetoothGatt gatt) {
            BluetoothGattCharacteristic gattCharacteristic;
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            BatCharacteristic batCharacteristic = getBatCharacteristic();
            if (batCharacteristic == null || (gattCharacteristic = batCharacteristic.getGattCharacteristic()) == null || !getBatCharacteristic().isNotifySupported() || !gatt.setCharacteristicNotification(gattCharacteristic, true)) {
                return false;
            }
            BluetoothGattDescriptor descriptor = gattCharacteristic.getDescriptor(getDescriptorUuid());
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            return gatt.writeDescriptor(descriptor);
        }
    }

    /* JADX INFO: compiled from: BleRequest.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, m5598d2 = {"Lcom/bat/sdk/ble/BleRequest$DisableNotification;", "Lcom/bat/sdk/ble/BleRequest;", "deviceAddress", "", "batCharacteristic", "Lcom/bat/sdk/ble/BatCharacteristic;", "<init>", "(Ljava/lang/String;Lcom/bat/sdk/ble/BatCharacteristic;)V", "canSkip", "", "getCanSkip", "()Z", "toString", "execute", "gatt", "Landroid/bluetooth/BluetoothGatt;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class DisableNotification extends BleRequest {
        private final boolean canSkip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DisableNotification(String deviceAddress, BatCharacteristic batCharacteristic) {
            super(deviceAddress, batCharacteristic, 0L, 4, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(batCharacteristic, "batCharacteristic");
            this.canSkip = true;
        }

        @Override // com.bat.sdk.ble.BleRequest
        public boolean getCanSkip() {
            return this.canSkip;
        }

        public String toString() {
            return "disable notifications for " + getBatCharacteristic();
        }

        @Override // com.bat.sdk.ble.BleRequest
        public boolean execute(BluetoothGatt gatt) {
            BluetoothGattCharacteristic gattCharacteristic;
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            BatCharacteristic batCharacteristic = getBatCharacteristic();
            if (batCharacteristic == null || (gattCharacteristic = batCharacteristic.getGattCharacteristic()) == null || !getBatCharacteristic().isNotifySupported() || !gatt.setCharacteristicNotification(gattCharacteristic, false)) {
                return false;
            }
            BluetoothGattDescriptor descriptor = gattCharacteristic.getDescriptor(getDescriptorUuid());
            descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            return gatt.writeDescriptor(descriptor);
        }
    }

    /* JADX INFO: compiled from: BleRequest.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, m5598d2 = {"Lcom/bat/sdk/ble/BleRequest$EnableIndication;", "Lcom/bat/sdk/ble/BleRequest;", "deviceAddress", "", "batCharacteristic", "Lcom/bat/sdk/ble/BatCharacteristic;", "<init>", "(Ljava/lang/String;Lcom/bat/sdk/ble/BatCharacteristic;)V", "toString", "execute", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class EnableIndication extends BleRequest {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnableIndication(String deviceAddress, BatCharacteristic batCharacteristic) {
            super(deviceAddress, batCharacteristic, 0L, 4, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(batCharacteristic, "batCharacteristic");
        }

        public String toString() {
            return "enable indications for " + getBatCharacteristic();
        }

        @Override // com.bat.sdk.ble.BleRequest
        public boolean execute(BluetoothGatt gatt) {
            BluetoothGattCharacteristic gattCharacteristic;
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            BatCharacteristic batCharacteristic = getBatCharacteristic();
            if (batCharacteristic == null || (gattCharacteristic = batCharacteristic.getGattCharacteristic()) == null || !getBatCharacteristic().isIndicateSupported() || !gatt.setCharacteristicNotification(gattCharacteristic, true)) {
                return false;
            }
            BluetoothGattDescriptor descriptor = gattCharacteristic.getDescriptor(getDescriptorUuid());
            if (descriptor != null) {
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
                return gatt.writeDescriptor(descriptor);
            }
            Logger.INSTANCE.log("could not get descriptor from " + getBatCharacteristic().getName());
            return false;
        }
    }

    /* JADX INFO: compiled from: BleRequest.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, m5598d2 = {"Lcom/bat/sdk/ble/BleRequest$DisableIndication;", "Lcom/bat/sdk/ble/BleRequest;", "deviceAddress", "", "batCharacteristic", "Lcom/bat/sdk/ble/BatCharacteristic;", "<init>", "(Ljava/lang/String;Lcom/bat/sdk/ble/BatCharacteristic;)V", "canSkip", "", "getCanSkip", "()Z", "toString", "execute", "gatt", "Landroid/bluetooth/BluetoothGatt;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class DisableIndication extends BleRequest {
        private final boolean canSkip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DisableIndication(String deviceAddress, BatCharacteristic batCharacteristic) {
            super(deviceAddress, batCharacteristic, 0L, 4, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(batCharacteristic, "batCharacteristic");
            this.canSkip = true;
        }

        @Override // com.bat.sdk.ble.BleRequest
        public boolean getCanSkip() {
            return this.canSkip;
        }

        public String toString() {
            return "disable indications for " + getBatCharacteristic();
        }

        @Override // com.bat.sdk.ble.BleRequest
        public boolean execute(BluetoothGatt gatt) {
            BluetoothGattCharacteristic gattCharacteristic;
            Intrinsics.checkNotNullParameter(gatt, "gatt");
            BatCharacteristic batCharacteristic = getBatCharacteristic();
            if (batCharacteristic == null || (gattCharacteristic = batCharacteristic.getGattCharacteristic()) == null || !getBatCharacteristic().isIndicateSupported() || !gatt.setCharacteristicNotification(gattCharacteristic, false)) {
                return false;
            }
            BluetoothGattDescriptor descriptor = gattCharacteristic.getDescriptor(getDescriptorUuid());
            descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            return gatt.writeDescriptor(descriptor);
        }
    }
}
