package com.bat.sdk.ble.reconnect;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.bat.sdk.logging.Logger;
import java.time.Duration;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BtReconnectWorkerDirectConnection.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\u000bj\b\u0012\u0004\u0012\u00020\n`\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m5598d2 = {"Lcom/bat/sdk/ble/reconnect/BtReconnectWorkerDirectConnection;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "deviceAddressList", "Lkotlin/collections/ArrayList;", "", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "coroutineCancellationDelay", "", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "printInfos", "", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class BtReconnectWorkerDirectConnection extends CoroutineWorker {
    public static final String INPUT_DATA_KEY_ADDRESS_LIST = "addressList";
    public static final String INPUT_DATA_KEY_RECONNECT_INTERVAL = "reconnectInterval";
    private static final String TAG;
    private long coroutineCancellationDelay;
    private ArrayList<String> deviceAddressList;
    private final WorkerParameters workerParams;

    /* JADX INFO: renamed from: com.bat.sdk.ble.reconnect.BtReconnectWorkerDirectConnection$doWork$1 */
    /* JADX INFO: compiled from: BtReconnectWorkerDirectConnection.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.ble.reconnect.BtReconnectWorkerDirectConnection", m5608f = "BtReconnectWorkerDirectConnection.kt", m5609i = {0}, m5610l = {81}, m5611m = "doWork", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C15011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C15011(Continuation<? super C15011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BtReconnectWorkerDirectConnection.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BtReconnectWorkerDirectConnection(Context appContext, WorkerParameters workerParams) {
        ArrayList<String> arrayList;
        super(appContext, workerParams);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.workerParams = workerParams;
        this.deviceAddressList = new ArrayList<>();
        Logger.INSTANCE.log(TAG, "init btReconnectWorkerDirectconnection");
        String[] stringArray = getInputData().getStringArray(INPUT_DATA_KEY_ADDRESS_LIST);
        this.deviceAddressList = (stringArray == null || (arrayList = (ArrayList) ArraysKt.toCollection(stringArray, new ArrayList())) == null) ? new ArrayList<>() : arrayList;
        this.coroutineCancellationDelay = getInputData().getLong(INPUT_DATA_KEY_RECONNECT_INTERVAL, 30L) * ((long) 1000);
    }

    static {
        String name = Companion.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        TAG = name;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r10) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.ble.reconnect.BtReconnectWorkerDirectConnection.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void printInfos() {
        Object systemService = getApplicationContext().getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager powerManager = (PowerManager) systemService;
        Logger logger = Logger.INSTANCE;
        String str = TAG;
        logger.log(str, "isDeviceIdleMode:" + powerManager.isDeviceIdleMode() + '}');
        if (Build.VERSION.SDK_INT >= 31) {
            Logger logger2 = Logger.INSTANCE;
            StringBuilder sb = new StringBuilder("batteryDischargePrediction (min):");
            Duration batteryDischargePrediction = powerManager.getBatteryDischargePrediction();
            logger2.log(str, sb.append(batteryDischargePrediction != null ? Long.valueOf(batteryDischargePrediction.toMinutes()) : null).toString());
        }
    }
}
