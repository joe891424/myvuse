package com.bat.sdk.ble;

import android.content.Context;
import androidx.core.text.HtmlCompat;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import com.bat.sdk.BatSdk;
import com.bat.sdk.ble.reconnect.BtReconnectWorkerDirectConnection;
import com.bat.sdk.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: BtProximityUnlock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0017J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0010J\u0006\u0010 \u001a\u00020\u0019J\b\u0010!\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0011j\b\u0012\u0004\u0012\u00020\u0010`\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R \u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0011j\b\u0012\u0004\u0012\u00020\u0010`\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R \u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0011j\b\u0012\u0004\u0012\u00020\u0010`\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R \u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0011j\b\u0012\u0004\u0012\u00020\u0010`\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m5598d2 = {"Lcom/bat/sdk/ble/BtProximityUnlock;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "reconnectJob", "Lkotlinx/coroutines/Job;", "connectJob", "autoUnlockJob", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "workManager", "Landroidx/work/WorkManager;", BtReconnectWorkerDirectConnection.INPUT_DATA_KEY_ADDRESS_LIST, "Lkotlin/collections/ArrayList;", "", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "lockedAddressList", "unlockedAddressList", "disconnectedAddressList", "check", "", "startReconnection", "", "deviceAddress", "intervalInSeconds", "", "autoUnlock", "stopReconnectionForAddress", "address", "stopReconnection", "cancelAllWork", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class BtProximityUnlock {
    private static final String JOB_TAG = "JOBTEST";
    private static final String TAG;
    private ArrayList<String> addressList;
    private Job autoUnlockJob;
    private boolean check;
    private Job connectJob;
    private final Context context;
    private ArrayList<String> disconnectedAddressList;
    private GattManager gattManager;
    private ArrayList<String> lockedAddressList;
    private Job reconnectJob;
    private ArrayList<String> unlockedAddressList;
    private WorkManager workManager;

    public BtProximityUnlock(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.gattManager = BatSdk.INSTANCE.getGattManager();
        WorkManager workManager = WorkManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(...)");
        this.workManager = workManager;
        this.addressList = new ArrayList<>();
        this.lockedAddressList = new ArrayList<>();
        this.unlockedAddressList = new ArrayList<>();
        this.disconnectedAddressList = new ArrayList<>();
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        TAG = companion.getClass().getName().toString();
    }

    public static /* synthetic */ void startReconnection$default(BtProximityUnlock btProximityUnlock, String str, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 5;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        btProximityUnlock.startReconnection(str, j, z);
    }

    public final void startReconnection(String deviceAddress, long intervalInSeconds, boolean autoUnlock) {
        Object next;
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Logger.INSTANCE.log(TAG, "SDK - Start reconnection job flow, address:" + deviceAddress + ", interval:" + intervalInSeconds + ", autoUnlock:" + autoUnlock);
        Iterator<T> it2 = this.addressList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            } else {
                next = it2.next();
                if (Intrinsics.areEqual((String) next, deviceAddress)) {
                    break;
                }
            }
        }
        if (next == null) {
            synchronized (this.addressList) {
                this.addressList.add(deviceAddress);
            }
            if (autoUnlock && !this.lockedAddressList.contains(deviceAddress)) {
                synchronized (this.lockedAddressList) {
                    this.lockedAddressList.add(deviceAddress);
                }
            }
        }
        BatSdk.INSTANCE.getSettingsManager().saveDeviceAddress(deviceAddress);
        BatSdk.INSTANCE.getSettingsManager().saveAutoUnlockJobStart(deviceAddress, autoUnlock);
        if (!this.check) {
            this.autoUnlockJob = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C14974(deviceAddress, null), 3, null);
        }
        this.connectJob = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C14985(intervalInSeconds, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.sdk.ble.BtProximityUnlock$startReconnection$4 */
    /* JADX INFO: compiled from: BtProximityUnlock.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.ble.BtProximityUnlock$startReconnection$4", m5608f = "BtProximityUnlock.kt", m5609i = {1, 1, 1}, m5610l = {HtmlCompat.FROM_HTML_MODE_COMPACT, 84}, m5611m = "invokeSuspend", m5612n = {"list", "address", "deviceType"}, m5613s = {"L$0", "L$4", "L$5"})
    static final class C14974 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14974(String str, Continuation<? super C14974> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BtProximityUnlock.this.new C14974(this.$deviceAddress, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14974) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0141, code lost:
        
            com.bat.sdk.logging.Logger.INSTANCE.log("PROXIMITY: device reconnected to be unlocked " + r6);
            r2 = r9.gattManager;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0159, code lost:
        
            if (r2 == null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x015b, code lost:
        
            r2 = r2.getDevices();
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x015f, code lost:
        
            if (r2 == null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0161, code lost:
        
            r2 = r2.getValue();
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0167, code lost:
        
            if (r2 == null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0169, code lost:
        
            r2 = r2.iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0173, code lost:
        
            if (r2.hasNext() == false) goto L99;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0175, code lost:
        
            r11 = r2.next();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0184, code lost:
        
            if (kotlin.jvm.internal.Intrinsics.areEqual(((com.bat.sdk.ble.BleDeviceData) r11).getAddress(), r8) == false) goto L101;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0187, code lost:
        
            r11 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0188, code lost:
        
            r11 = (com.bat.sdk.ble.BleDeviceData) r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x018a, code lost:
        
            if (r11 == null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x018c, code lost:
        
            r2 = r11.getDeviceType();
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0191, code lost:
        
            r2 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0192, code lost:
        
            r11 = com.bat.sdk.BatSdk.INSTANCE.getLockClient();
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0198, code lost:
        
            if (r11 == null) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x019a, code lost:
        
            r20.L$0 = r10;
            r20.L$1 = r9;
            r20.L$2 = r8;
            r20.L$3 = r7;
            r20.L$4 = r6;
            r20.L$5 = r2;
            r20.label = 2;
            r11 = r11.read(r6, r20);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x01ac, code lost:
        
            if (r11 != r0) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x01ae, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x01b2, code lost:
        
            r11 = null;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x005d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x012d  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x02c4  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x010d -> B:86:0x02b8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x010f -> B:29:0x0127). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01ac -> B:55:0x01af). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x01b2 -> B:57:0x01b3). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 727
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.ble.BtProximityUnlock.C14974.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.bat.sdk.ble.BtProximityUnlock$startReconnection$5 */
    /* JADX INFO: compiled from: BtProximityUnlock.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.ble.BtProximityUnlock$startReconnection$5", m5608f = "BtProximityUnlock.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14985 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $intervalInSeconds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14985(long j, Continuation<? super C14985> continuation) {
            super(2, continuation);
            this.$intervalInSeconds = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BtProximityUnlock.this.new C14985(this.$intervalInSeconds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14985) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Logger.INSTANCE.log(BtProximityUnlock.TAG, "SDK - Start reconnection job");
                if (BtProximityUnlock.this.reconnectJob != null) {
                    Logger.INSTANCE.log(BtProximityUnlock.TAG, "SDK - reconnect job already present");
                    return Unit.INSTANCE;
                }
                BtProximityUnlock.this.reconnectJob = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(BtProximityUnlock.this, this.$intervalInSeconds, null), 3, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: com.bat.sdk.ble.BtProximityUnlock$startReconnection$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: BtProximityUnlock.kt */
        @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.sdk.ble.BtProximityUnlock$startReconnection$5$1", m5608f = "BtProximityUnlock.kt", m5609i = {}, m5610l = {167, 171}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $intervalInSeconds;
            int label;
            final /* synthetic */ BtProximityUnlock this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(BtProximityUnlock btProximityUnlock, long j, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = btProximityUnlock;
                this.$intervalInSeconds = j;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$intervalInSeconds, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList = this.this$0.addressList;
                    BtProximityUnlock btProximityUnlock = this.this$0;
                    synchronized (arrayList) {
                        for (String str : btProximityUnlock.addressList) {
                            Logger logger = Logger.INSTANCE;
                            String str2 = BtProximityUnlock.TAG;
                            StringBuilder sbAppend = new StringBuilder().append("device ").append(str).append(" is connected: ");
                            GattManager gattManager = btProximityUnlock.gattManager;
                            logger.log(str2, sbAppend.append(gattManager != null ? Boxing.boxBoolean(gattManager.isDeviceConnected(str)) : null).toString());
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.cancelAllWork();
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                while (true) {
                    this.this$0.disconnectedAddressList.clear();
                    ArrayList arrayList2 = this.this$0.addressList;
                    BtProximityUnlock btProximityUnlock2 = this.this$0;
                    synchronized (arrayList2) {
                        for (String str3 : btProximityUnlock2.addressList) {
                            GattManager gattManager2 = btProximityUnlock2.gattManager;
                            Intrinsics.checkNotNull(gattManager2);
                            if (!gattManager2.isDeviceConnected(str3)) {
                                Logger.INSTANCE.log(BtProximityUnlock.TAG, "add to disconnetedAddressList " + str3 + ", size:" + (btProximityUnlock2.disconnectedAddressList.size() + 1));
                                btProximityUnlock2.disconnectedAddressList.add(str3);
                            }
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                    if (this.this$0.disconnectedAddressList.size() > 0) {
                        Logger.INSTANCE.log(BtProximityUnlock.TAG, "SDK - relaunch job");
                        Data.Builder builder = new Data.Builder();
                        builder.putStringArray(BtReconnectWorkerDirectConnection.INPUT_DATA_KEY_ADDRESS_LIST, (String[]) this.this$0.disconnectedAddressList.toArray(new String[0]));
                        builder.putLong(BtReconnectWorkerDirectConnection.INPUT_DATA_KEY_RECONNECT_INTERVAL, this.$intervalInSeconds - 1);
                        PeriodicWorkRequest periodicWorkRequestBuild = new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) BtReconnectWorkerDirectConnection.class, this.$intervalInSeconds, TimeUnit.SECONDS).addTag(BtProximityUnlock.JOB_TAG).setInputData(builder.build()).build();
                        Intrinsics.checkNotNullExpressionValue(periodicWorkRequestBuild, "build(...)");
                        this.this$0.workManager.enqueueUniquePeriodicWork("proximiytUnlock_workName", ExistingPeriodicWorkPolicy.REPLACE, periodicWorkRequestBuild);
                        long j = 1000;
                        Logger.INSTANCE.log(BtProximityUnlock.TAG, "SDK - delay :" + ((this.$intervalInSeconds - 1) * j));
                        this.label = 1;
                        if (DelayKt.delay((this.$intervalInSeconds - 1) * j, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this.this$0.cancelAllWork();
                    } else {
                        this.label = 2;
                        if (DelayKt.delay(this.$intervalInSeconds * ((long) 1000), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            }
        }
    }

    public final void stopReconnectionForAddress(final String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Logger logger = Logger.INSTANCE;
        String str = TAG;
        logger.log(str, "SDK - Stop Reconnection for device " + address + ", addressList.size:" + this.addressList.size());
        synchronized (this.addressList) {
            ArrayList<String> arrayList = this.addressList;
            final Function1 function1 = new Function1() { // from class: com.bat.sdk.ble.BtProximityUnlock$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(BtProximityUnlock.stopReconnectionForAddress$lambda$5$lambda$3(address, (String) obj));
                }
            };
            arrayList.removeIf(new Predicate() { // from class: com.bat.sdk.ble.BtProximityUnlock$$ExternalSyntheticLambda1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BtProximityUnlock.stopReconnectionForAddress$lambda$5$lambda$4(function1, obj);
                }
            });
        }
        synchronized (this.lockedAddressList) {
            ArrayList<String> arrayList2 = this.lockedAddressList;
            final Function1 function12 = new Function1() { // from class: com.bat.sdk.ble.BtProximityUnlock$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(BtProximityUnlock.stopReconnectionForAddress$lambda$8$lambda$6(address, (String) obj));
                }
            };
            arrayList2.removeIf(new Predicate() { // from class: com.bat.sdk.ble.BtProximityUnlock$$ExternalSyntheticLambda3
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BtProximityUnlock.stopReconnectionForAddress$lambda$8$lambda$7(function12, obj);
                }
            });
        }
        Logger.INSTANCE.log(str, "SDK - After stop Reconnection for device " + address + ", addressList.size:" + this.addressList.size());
        if (this.addressList.isEmpty()) {
            Logger.INSTANCE.log(str, "SDK - addressList.size:" + this.addressList.size() + " is empty so the reconnection flow is stopped");
            stopReconnection();
        } else {
            BatSdk.INSTANCE.getSettingsManager().cleanDeviceAddresses(address);
            BatSdk.INSTANCE.getSettingsManager().cleanAutoUnlockJobStart(address);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stopReconnectionForAddress$lambda$5$lambda$3(String address, String it2) {
        Intrinsics.checkNotNullParameter(address, "$address");
        Intrinsics.checkNotNullParameter(it2, "it");
        return Intrinsics.areEqual(it2, address);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stopReconnectionForAddress$lambda$5$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stopReconnectionForAddress$lambda$8$lambda$6(String address, String it2) {
        Intrinsics.checkNotNullParameter(address, "$address");
        Intrinsics.checkNotNullParameter(it2, "it");
        return Intrinsics.areEqual(it2, address);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stopReconnectionForAddress$lambda$8$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public final void stopReconnection() {
        Logger.INSTANCE.log(TAG, "SDK - Stop Reconnection FLOW");
        Job job = this.connectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.connectJob = null;
        Job job2 = this.reconnectJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.reconnectJob = null;
        Job job3 = this.autoUnlockJob;
        if (job3 != null) {
            Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
        }
        this.autoUnlockJob = null;
        this.check = false;
        synchronized (this.addressList) {
            this.addressList.clear();
            Unit unit = Unit.INSTANCE;
        }
        synchronized (this.lockedAddressList) {
            this.lockedAddressList.clear();
            Unit unit2 = Unit.INSTANCE;
        }
        this.unlockedAddressList.clear();
        this.disconnectedAddressList.clear();
        BatSdk.INSTANCE.getSettingsManager().cleanDeviceAddresses();
        BatSdk.INSTANCE.getSettingsManager().cleanAutoUnlockJobStart();
        cancelAllWork();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelAllWork() {
        Logger logger = Logger.INSTANCE;
        String str = TAG;
        logger.log(str, "SDK - before cancel actual jobs:" + WorkManager.getInstance(this.context).getWorkInfosByTag(JOB_TAG));
        this.workManager.cancelAllWorkByTag(JOB_TAG);
        Logger.INSTANCE.log(str, "SDK - after cancel actual jobs:" + WorkManager.getInstance(this.context).getWorkInfosByTag(JOB_TAG));
    }
}
