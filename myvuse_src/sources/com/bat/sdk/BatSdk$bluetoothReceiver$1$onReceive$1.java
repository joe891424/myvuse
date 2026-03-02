package com.bat.sdk;

import com.bat.sdk.ble.BleDeviceData;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.client.LogsClient;
import com.bat.sdk.client.PuffsClient;
import com.yoti.mobile.android.facecapture.view.capture.util.FaceCaptureConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: BatSdk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.BatSdk$bluetoothReceiver$1$onReceive$1", m5608f = "BatSdk.kt", m5609i = {}, m5610l = {271}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
final class BatSdk$bluetoothReceiver$1$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    BatSdk$bluetoothReceiver$1$onReceive$1(Continuation<? super BatSdk$bluetoothReceiver$1$onReceive$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BatSdk$bluetoothReceiver$1$onReceive$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BatSdk$bluetoothReceiver$1$onReceive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        StateFlow<List<BleDeviceData>> devices;
        List<BleDeviceData> value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GattManager gattManager = BatSdk.INSTANCE.getGattManager();
            if (gattManager != null && (devices = gattManager.getDevices()) != null && (value = devices.getValue()) != null) {
                for (BleDeviceData bleDeviceData : value) {
                    PuffsClient puffsClient = BatSdk.INSTANCE.getPuffsClient();
                    if (puffsClient != null) {
                        puffsClient.setIndicationEnabled(bleDeviceData.getAddress(), false);
                    }
                    LogsClient logsClient = BatSdk.INSTANCE.getLogsClient();
                    if (logsClient != null) {
                        logsClient.setIndicationEnabled(bleDeviceData.getAddress(), false);
                    }
                }
            }
            this.label = 1;
            if (DelayKt.delay(FaceCaptureConstants.DURATION_FACE_DETECT_SHIMMER_ANIMATION_MS, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        GattManager gattManager2 = BatSdk.INSTANCE.getGattManager();
        if (gattManager2 != null) {
            gattManager2.closeGattAll();
        }
        return Unit.INSTANCE;
    }
}
