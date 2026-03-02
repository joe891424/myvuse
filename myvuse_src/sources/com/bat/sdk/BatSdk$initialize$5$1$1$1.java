package com.bat.sdk;

import com.bat.sdk.client.TimeClient;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceTime;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BatSdk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.BatSdk$initialize$5$1$1$1", m5608f = "BatSdk.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
final class BatSdk$initialize$5$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<DeviceTime> $actualDeviceTime;
    final /* synthetic */ String $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BatSdk$initialize$5$1$1$1(Ref.ObjectRef<DeviceTime> objectRef, String str, Continuation<? super BatSdk$initialize$5$1$1$1> continuation) {
        super(2, continuation);
        this.$actualDeviceTime = objectRef;
        this.$it = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BatSdk$initialize$5$1$1$1(this.$actualDeviceTime, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BatSdk$initialize$5$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r5v18, types: [T, com.bat.sdk.model.DeviceTime] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DeviceTime deviceTimeCopy$default;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        DeviceTime deviceTime = this.$actualDeviceTime.element;
        if ((deviceTime != null ? deviceTime.getTimeZone() : null) != null) {
            int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 60000;
            Logger.INSTANCE.log("[TZ] setting device time zone to " + offset);
            Ref.ObjectRef<DeviceTime> objectRef = this.$actualDeviceTime;
            DeviceTime deviceTime2 = objectRef.element;
            Intrinsics.checkNotNull(deviceTime2);
            objectRef.element = DeviceTime.copy$default(deviceTime2, null, Boxing.boxShort((short) offset), 1, null);
        }
        Logger.INSTANCE.log("[Deb] writing device time in debounce");
        DeviceTime deviceTime3 = this.$actualDeviceTime.element;
        if (deviceTime3 != null && (deviceTimeCopy$default = DeviceTime.copy$default(deviceTime3, new Date(), null, 2, null)) != null) {
            String str = this.$it;
            TimeClient timeClient = BatSdk.INSTANCE.getTimeClient();
            if (timeClient != null) {
                timeClient.write(str, deviceTimeCopy$default);
            }
        }
        return Unit.INSTANCE;
    }
}
