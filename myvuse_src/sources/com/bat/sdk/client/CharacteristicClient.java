package com.bat.sdk.client;

import android.bluetooth.BluetoothGattCharacteristic;
import com.bat.sdk.ble.BatCharacteristic;
import com.bat.sdk.ble.BatService;
import com.bat.sdk.ble.BleDeviceData;
import com.bat.sdk.ble.BleExtensionsKt;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: CharacteristicClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u00016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\b\b\u0002\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0012J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0015J\u000e\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\u0015J\u0010\u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020\u0015H\u0002J\u000e\u0010,\u001a\u00020*2\u0006\u0010(\u001a\u00020\u0015J\u0018\u0010-\u001a\u0004\u0018\u00018\u00012\u0006\u0010(\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010.J\u001d\u0010/\u001a\u00020*2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u0016\u00101\u001a\u00020*2\u0006\u0010(\u001a\u00020\u00152\u0006\u00102\u001a\u00020'J\u0016\u00103\u001a\u00020*2\u0006\u0010(\u001a\u00020\u00152\u0006\u00102\u001a\u00020'J\u0016\u00104\u001a\u00020*2\u0006\u0010(\u001a\u00020\u00152\u0006\u00102\u001a\u00020'J\u000e\u00105\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u0018\u0012\u0014\u0012\u00120\u001eR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u00120\u001eR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, m5598d2 = {"Lcom/bat/sdk/client/CharacteristicClient;", "REQUEST", "RESPONSE", "", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "<init>", "(Lcom/bat/sdk/ble/GattManager;)V", "getGattManager", "()Lcom/bat/sdk/ble/GattManager;", "encode", "", "request", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "(Ljava/lang/Object;Lcom/bat/sdk/model/DeviceType;)[B", "decode", "bytes", "([BLcom/bat/sdk/model/DeviceType;)Ljava/lang/Object;", "characteristicUuids", "", "", "getCharacteristicUuids", "()Ljava/util/List;", "characteristics", "", "", "Lcom/bat/sdk/ble/BatCharacteristic;", "_flow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "flow", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "devicesInHistoryModePuffRecord", "", "devicesInHistoryModeLogRecord", "isReady", "", "deviceAddress", "clean", "", "setup", "enqueueRead", "read", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "write", "(Ljava/lang/String;Ljava/lang/Object;)V", "setNotificationEnabled", "value", "setIndicationEnabled", "setSubscriptionEnabled", "isAvailable", "Response", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class CharacteristicClient<REQUEST, RESPONSE> {
    private final MutableSharedFlow<CharacteristicClient<REQUEST, RESPONSE>.Response> _flow;
    private final Map<String, Set<BatCharacteristic>> characteristics;
    private final Set<String> devicesInHistoryModeLogRecord;
    private final Set<String> devicesInHistoryModePuffRecord;
    private final Flow<CharacteristicClient<REQUEST, RESPONSE>.Response> flow;
    private final GattManager gattManager;

    public abstract RESPONSE decode(byte[] bytes, DeviceType deviceType);

    public abstract byte[] encode(REQUEST request, DeviceType deviceType);

    protected abstract List<String> getCharacteristicUuids();

    public CharacteristicClient(GattManager gattManager) {
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        this.gattManager = gattManager;
        this.characteristics = new LinkedHashMap();
        MutableSharedFlow<CharacteristicClient<REQUEST, RESPONSE>.Response> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this._flow = mutableSharedFlowMutableSharedFlow$default;
        this.flow = mutableSharedFlowMutableSharedFlow$default;
        this.devicesInHistoryModePuffRecord = new LinkedHashSet();
        this.devicesInHistoryModeLogRecord = new LinkedHashSet();
    }

    public final GattManager getGattManager() {
        return this.gattManager;
    }

    public static /* synthetic */ byte[] encode$default(CharacteristicClient characteristicClient, Object obj, DeviceType deviceType, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
        }
        if ((i & 2) != 0) {
            deviceType = DeviceType.Unknown.INSTANCE;
        }
        return characteristicClient.encode(obj, deviceType);
    }

    public static /* synthetic */ Object decode$default(CharacteristicClient characteristicClient, byte[] bArr, DeviceType deviceType, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i & 2) != 0) {
            deviceType = DeviceType.Unknown.INSTANCE;
        }
        return characteristicClient.decode(bArr, deviceType);
    }

    public final Flow<CharacteristicClient<REQUEST, RESPONSE>.Response> getFlow() {
        return this.flow;
    }

    public final boolean isReady(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        setup(deviceAddress);
        Set<BatCharacteristic> set = this.characteristics.get(deviceAddress);
        if (set == null) {
            return false;
        }
        Set<BatCharacteristic> set2 = set;
        if ((set2 instanceof Collection) && set2.isEmpty()) {
            return false;
        }
        Iterator<T> it2 = set2.iterator();
        while (it2.hasNext()) {
            if (((BatCharacteristic) it2.next()).getGattCharacteristic() != null) {
                return true;
            }
        }
        return false;
    }

    public final void clean(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        this.characteristics.remove(deviceAddress);
    }

    private final void setup(String deviceAddress) {
        Object obj;
        Object next;
        List<BatService> services;
        final DeviceType.Unknown deviceType;
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "setup " + deviceAddress);
        Set<BatCharacteristic> set = this.characteristics.get(deviceAddress);
        if (set != null && !set.isEmpty()) {
            Set<BatCharacteristic> set2 = set;
            if (!(set2 instanceof Collection) || !set2.isEmpty()) {
                Iterator<T> it2 = set2.iterator();
                while (it2.hasNext()) {
                    if (((BatCharacteristic) it2.next()).getGattCharacteristic() != null) {
                        Logger logger2 = Logger.INSTANCE;
                        String name2 = getClass().getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                        logger2.log(name2, "setup return");
                        return;
                    }
                }
            }
        }
        Iterator<T> it3 = this.gattManager.getDevices().getValue().iterator();
        while (true) {
            obj = null;
            if (it3.hasNext()) {
                next = it3.next();
                if (Intrinsics.areEqual(((BleDeviceData) next).getAddress(), deviceAddress)) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        BleDeviceData bleDeviceData = (BleDeviceData) next;
        if (bleDeviceData == null || (services = bleDeviceData.getServices()) == null) {
            return;
        }
        List<BatService> list = services;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it4 = list.iterator();
        while (it4.hasNext()) {
            arrayList.add(((BatService) it4.next()).getCharacteristics());
        }
        List listFlatten = CollectionsKt.flatten(arrayList);
        if (listFlatten != null) {
            List list2 = listFlatten;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it5 = list2.iterator();
            while (it5.hasNext()) {
                String string = ((BatCharacteristic) it5.next()).getUuid().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                String lowerCase = string.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                arrayList2.add(lowerCase);
            }
            ArrayList arrayList3 = arrayList2;
            List<String> characteristicUuids = getCharacteristicUuids();
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(characteristicUuids, 10));
            Iterator<T> it6 = characteristicUuids.iterator();
            while (it6.hasNext()) {
                String lowerCase2 = ((String) it6.next()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                arrayList4.add(lowerCase2);
            }
            Set setIntersect = CollectionsKt.intersect(arrayList3, CollectionsKt.toSet(arrayList4));
            Map<String, Set<BatCharacteristic>> map = this.characteristics;
            ArrayList arrayList5 = new ArrayList();
            for (Object obj2 : list2) {
                if (setIntersect.contains(((BatCharacteristic) obj2).getUuid().toString())) {
                    arrayList5.add(obj2);
                }
            }
            map.put(deviceAddress, CollectionsKt.toSet(arrayList5));
            Iterator<T> it7 = this.gattManager.getDevices().getValue().iterator();
            while (true) {
                if (!it7.hasNext()) {
                    break;
                }
                Object next2 = it7.next();
                if (Intrinsics.areEqual(((BleDeviceData) next2).getAddress(), deviceAddress)) {
                    obj = next2;
                    break;
                }
            }
            BleDeviceData bleDeviceData2 = (BleDeviceData) obj;
            if (bleDeviceData2 == null || (deviceType = bleDeviceData2.getDeviceType()) == null) {
                deviceType = DeviceType.Unknown.INSTANCE;
            }
            Set<BatCharacteristic> set3 = this.characteristics.get(deviceAddress);
            if (set3 != null) {
                for (final BatCharacteristic batCharacteristic : set3) {
                    Logger logger3 = Logger.INSTANCE;
                    String name3 = getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                    logger3.log(name3, "setup " + deviceAddress + " listenTo:" + batCharacteristic.getName());
                    this.gattManager.listenTo(deviceAddress, batCharacteristic, true, new Function2() { // from class: com.bat.sdk.client.CharacteristicClient$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return CharacteristicClient.setup$lambda$9$lambda$8(this.f$0, deviceType, batCharacteristic, (String) obj3, (byte[]) obj4);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setup$lambda$9$lambda$8(CharacteristicClient this$0, DeviceType deviceType, BatCharacteristic characteristic, String deviceAddress, byte[] raw) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(deviceType, "$deviceType");
        Intrinsics.checkNotNullParameter(characteristic, "$characteristic");
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(raw, "raw");
        Object objDecode = this$0.decode(raw, deviceType);
        if (objDecode != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new CharacteristicClient$setup$3$1$1(characteristic, objDecode, this$0, deviceAddress, null), 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void enqueueRead(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        setup(deviceAddress);
        Set<BatCharacteristic> set = this.characteristics.get(deviceAddress);
        Object obj = null;
        if (set != null) {
            Iterator<T> it2 = set.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (((BatCharacteristic) next).getGattCharacteristic() != null) {
                    obj = next;
                    break;
                }
            }
            obj = (BatCharacteristic) obj;
        }
        BatCharacteristic batCharacteristic = obj;
        if (batCharacteristic == 0) {
            Logger logger = Logger.INSTANCE;
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            logger.log(name, "gatt characteristic not found for reading");
            return;
        }
        GattManager.enqueueRead$default(this.gattManager, deviceAddress, batCharacteristic, null, 4, null);
    }

    public final Object read(final String str, Continuation<? super RESPONSE> continuation) throws Throwable {
        BatCharacteristic batCharacteristic;
        Object next;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        setup(str);
        Set<BatCharacteristic> set = this.characteristics.get(str);
        if (set != null) {
            Iterator<T> it2 = set.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (((BatCharacteristic) next).getGattCharacteristic() != null) {
                    break;
                }
            }
            batCharacteristic = (BatCharacteristic) next;
        } else {
            batCharacteristic = null;
        }
        if (batCharacteristic == null) {
            Logger logger = Logger.INSTANCE;
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            logger.log(name, "gat characteristic not found for reading");
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m7233constructorimpl(null));
        } else {
            this.gattManager.enqueueRead(str, batCharacteristic, (Function1) new Function1<byte[], Unit>(this) { // from class: com.bat.sdk.client.CharacteristicClient$read$2$1
                final /* synthetic */ CharacteristicClient<REQUEST, RESPONSE> this$0;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr) {
                    invoke2(bArr);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(byte[] bytes) {
                    Object next2;
                    DeviceType.Unknown deviceType;
                    Intrinsics.checkNotNullParameter(bytes, "bytes");
                    List<BleDeviceData> value = this.this$0.getGattManager().getDevices().getValue();
                    String str2 = str;
                    Iterator<T> it3 = value.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            next2 = null;
                            break;
                        } else {
                            next2 = it3.next();
                            if (Intrinsics.areEqual(((BleDeviceData) next2).getAddress(), str2)) {
                                break;
                            }
                        }
                    }
                    BleDeviceData bleDeviceData = (BleDeviceData) next2;
                    if (bleDeviceData == null || (deviceType = bleDeviceData.getDeviceType()) == null) {
                        deviceType = DeviceType.Unknown.INSTANCE;
                    }
                    Object objDecode = this.this$0.decode(bytes, deviceType);
                    Continuation<RESPONSE> continuation2 = safeContinuation2;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m7233constructorimpl(objDecode));
                }
            });
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public void write(String deviceAddress, REQUEST request) {
        BatCharacteristic batCharacteristic;
        DeviceType.Unknown deviceType;
        Object next;
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        setup(deviceAddress);
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "writing " + request);
        Set<BatCharacteristic> set = this.characteristics.get(deviceAddress);
        Object obj = null;
        if (set != null) {
            Iterator<T> it2 = set.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (((BatCharacteristic) next).getGattCharacteristic() != null) {
                        break;
                    }
                }
            }
            batCharacteristic = (BatCharacteristic) next;
        } else {
            batCharacteristic = null;
        }
        if (batCharacteristic == null) {
            Map<String, Set<BatCharacteristic>> map = this.characteristics;
            final Function2 function2 = new Function2() { // from class: com.bat.sdk.client.CharacteristicClient$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return CharacteristicClient.write$lambda$15(this.f$0, (String) obj2, (Set) obj3);
                }
            };
            map.forEach(new BiConsumer() { // from class: com.bat.sdk.client.CharacteristicClient$$ExternalSyntheticLambda2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj2, Object obj3) {
                    CharacteristicClient.write$lambda$16(function2, obj2, obj3);
                }
            });
            Logger logger2 = Logger.INSTANCE;
            String name2 = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            logger2.log(name2, "gatt characteristic not found for writing, " + deviceAddress);
            return;
        }
        Iterator<T> it3 = this.gattManager.getDevices().getValue().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next2 = it3.next();
            if (Intrinsics.areEqual(((BleDeviceData) next2).getAddress(), deviceAddress)) {
                obj = next2;
                break;
            }
        }
        BleDeviceData bleDeviceData = (BleDeviceData) obj;
        if (bleDeviceData == null || (deviceType = bleDeviceData.getDeviceType()) == null) {
            deviceType = DeviceType.Unknown.INSTANCE;
        }
        this.gattManager.enqueueWrite(deviceAddress, batCharacteristic, encode(request, deviceType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void write$lambda$16(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit write$lambda$15(CharacteristicClient this$0, String t, Set u) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(u, "u");
        Iterator it2 = u.iterator();
        while (it2.hasNext()) {
            BatCharacteristic batCharacteristic = (BatCharacteristic) it2.next();
            Logger logger = Logger.INSTANCE;
            String name = this$0.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            logger.log(name, "address:" + t + ", batchar:" + batCharacteristic + ", " + batCharacteristic.getUuid());
        }
        return Unit.INSTANCE;
    }

    public final void setNotificationEnabled(String deviceAddress, boolean value) {
        BatCharacteristic batCharacteristic;
        Object next;
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        setup(deviceAddress);
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "enabling notifications");
        Set<BatCharacteristic> set = this.characteristics.get(deviceAddress);
        if (set != null) {
            Iterator<T> it2 = set.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (((BatCharacteristic) next).getGattCharacteristic() != null) {
                        break;
                    }
                }
            }
            batCharacteristic = (BatCharacteristic) next;
        } else {
            batCharacteristic = null;
        }
        if (batCharacteristic != null) {
            BluetoothGattCharacteristic gattCharacteristic = batCharacteristic.getGattCharacteristic();
            if (gattCharacteristic != null && BleExtensionsKt.isNotifySupported(gattCharacteristic)) {
                this.gattManager.enqueueNotify(deviceAddress, batCharacteristic, value);
                return;
            }
            Logger logger2 = Logger.INSTANCE;
            String name2 = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            StringBuilder sb = new StringBuilder("IsNotifiable: ");
            BluetoothGattCharacteristic gattCharacteristic2 = batCharacteristic.getGattCharacteristic();
            logger2.log(name2, sb.append(gattCharacteristic2 != null ? Boolean.valueOf(BleExtensionsKt.isNotifySupported(gattCharacteristic2)) : null).toString());
            return;
        }
        Logger logger3 = Logger.INSTANCE;
        String name3 = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
        logger3.log(name3, "gatt characteristic not found for notifications");
    }

    public final void setIndicationEnabled(String deviceAddress, boolean value) {
        BatCharacteristic batCharacteristic;
        Object next;
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        setup(deviceAddress);
        Logger logger = Logger.INSTANCE;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.log(name, "enabling indications");
        Set<BatCharacteristic> set = this.characteristics.get(deviceAddress);
        if (set != null) {
            Iterator<T> it2 = set.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (((BatCharacteristic) next).getGattCharacteristic() != null) {
                        break;
                    }
                }
            }
            batCharacteristic = (BatCharacteristic) next;
        } else {
            batCharacteristic = null;
        }
        if (batCharacteristic != null) {
            BluetoothGattCharacteristic gattCharacteristic = batCharacteristic.getGattCharacteristic();
            if (gattCharacteristic != null && BleExtensionsKt.isIndicateSupported(gattCharacteristic)) {
                if (Intrinsics.areEqual(batCharacteristic.getName(), "Led")) {
                    Logger.INSTANCE.log("[LedClient] characteristic supports indication");
                }
                this.gattManager.enqueueIndicate(deviceAddress, batCharacteristic, value);
                return;
            } else {
                Logger logger2 = Logger.INSTANCE;
                String name2 = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                StringBuilder sb = new StringBuilder("IsIndictable: ");
                BluetoothGattCharacteristic gattCharacteristic2 = batCharacteristic.getGattCharacteristic();
                logger2.log(name2, sb.append(gattCharacteristic2 != null ? Boolean.valueOf(BleExtensionsKt.isIndicateSupported(gattCharacteristic2)) : null).toString());
                return;
            }
        }
        Logger logger3 = Logger.INSTANCE;
        String name3 = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
        logger3.log(name3, "gatt characteristic not found for indications");
    }

    public final void setSubscriptionEnabled(String deviceAddress, boolean value) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        setup(deviceAddress);
        Set<BatCharacteristic> set = this.characteristics.get(deviceAddress);
        BatCharacteristic batCharacteristic = null;
        Object obj = null;
        if (set != null) {
            Iterator<T> it2 = set.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (((BatCharacteristic) next).getGattCharacteristic() != null) {
                    obj = next;
                    break;
                }
            }
            batCharacteristic = (BatCharacteristic) obj;
        }
        if (batCharacteristic != null) {
            if (batCharacteristic.isNotifySupported()) {
                setNotificationEnabled(deviceAddress, value);
                return;
            }
            if (batCharacteristic.isIndicateSupported()) {
                setIndicationEnabled(deviceAddress, value);
                return;
            }
            Logger logger = Logger.INSTANCE;
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            logger.log(name, "neither indications nor notifications are supported, nothing to subscribe to. device:" + deviceAddress + ", char:" + batCharacteristic.getName());
            return;
        }
        Logger logger2 = Logger.INSTANCE;
        String name2 = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        logger2.log(name2, "characteristic not found for subscriptions");
    }

    public final boolean isAvailable(String deviceAddress) {
        Set<BatCharacteristic> set;
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        setup(deviceAddress);
        if (this.characteristics.get(deviceAddress) != null && (!r0.isEmpty()) && (set = this.characteristics.get(deviceAddress)) != null) {
            Set<BatCharacteristic> set2 = set;
            if ((set2 instanceof Collection) && set2.isEmpty()) {
                return true;
            }
            Iterator<T> it2 = set2.iterator();
            while (it2.hasNext()) {
                if (((BatCharacteristic) it2.next()).getGattCharacteristic() != null) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: compiled from: CharacteristicClient.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, m5598d2 = {"Lcom/bat/sdk/client/CharacteristicClient$Response;", "", "deviceAddress", "", "data", "<init>", "(Lcom/bat/sdk/client/CharacteristicClient;Ljava/lang/String;Ljava/lang/Object;)V", "getDeviceAddress", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public final class Response {
        private final RESPONSE data;
        private final String deviceAddress;
        final /* synthetic */ CharacteristicClient<REQUEST, RESPONSE> this$0;

        public Response(CharacteristicClient characteristicClient, String deviceAddress, RESPONSE response) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.this$0 = characteristicClient;
            this.deviceAddress = deviceAddress;
            this.data = response;
        }

        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final RESPONSE getData() {
            return this.data;
        }
    }
}
