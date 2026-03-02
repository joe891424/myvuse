package com.bat.sdk.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: compiled from: GattManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.ble.GattManager$connect$btGattCallback$1$onServicesDiscovered$3", m5608f = "GattManager.kt", m5609i = {0}, m5610l = {172}, m5611m = "invokeSuspend", m5612n = {"$this$launch"}, m5613s = {"L$0"})
final class GattManager$connect$btGattCallback$1$onServicesDiscovered$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BluetoothGatt $gatt;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GattManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GattManager$connect$btGattCallback$1$onServicesDiscovered$3(GattManager gattManager, BluetoothGatt bluetoothGatt, Continuation<? super GattManager$connect$btGattCallback$1$onServicesDiscovered$3> continuation) {
        super(2, continuation);
        this.this$0 = gattManager;
        this.$gatt = bluetoothGatt;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GattManager$connect$btGattCallback$1$onServicesDiscovered$3 gattManager$connect$btGattCallback$1$onServicesDiscovered$3 = new GattManager$connect$btGattCallback$1$onServicesDiscovered$3(this.this$0, this.$gatt, continuation);
        gattManager$connect$btGattCallback$1$onServicesDiscovered$3.L$0 = obj;
        return gattManager$connect$btGattCallback$1$onServicesDiscovered$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GattManager$connect$btGattCallback$1$onServicesDiscovered$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Object next;
        CoroutineScope coroutineScope2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            List<BleDeviceData> value = this.this$0.getDevices().getValue();
            BluetoothGatt bluetoothGatt = this.$gatt;
            Iterator<T> it2 = value.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                String address = ((BleDeviceData) next).getAddress();
                Intrinsics.checkNotNull(bluetoothGatt);
                BluetoothDevice device = bluetoothGatt.getDevice();
                Intrinsics.checkNotNull(device);
                if (Intrinsics.areEqual(address, device.getAddress())) {
                    break;
                }
            }
            BleDeviceData bleDeviceData = (BleDeviceData) next;
            if (bleDeviceData != null) {
                MutableSharedFlow mutableSharedFlow = this.this$0._connectedDevice;
                this.L$0 = coroutineScope;
                this.label = 1;
                if (mutableSharedFlow.emit(bleDeviceData, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope2 = coroutineScope;
            }
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        coroutineScope2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(obj);
        coroutineScope = coroutineScope2;
        CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        return Unit.INSTANCE;
    }
}
