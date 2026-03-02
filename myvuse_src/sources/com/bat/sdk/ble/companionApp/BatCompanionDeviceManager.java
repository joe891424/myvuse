package com.bat.sdk.ble.companionApp;

import android.app.Activity;
import android.companion.AssociationInfo;
import android.companion.AssociationRequest;
import android.companion.BluetoothDeviceFilter;
import android.companion.CompanionDeviceManager;
import android.content.Context;
import android.content.IntentSender;
import android.os.Build;
import android.os.Handler;
import com.bat.sdk.ble.companionApp.AssociationState;
import com.bat.sdk.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: BatCompanionDeviceManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0011J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0011J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0018\u001a\u00020\u0011H\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m5598d2 = {"Lcom/bat/sdk/ble/companionApp/BatCompanionDeviceManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "deviceManager", "Landroid/companion/CompanionDeviceManager;", "_associationStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bat/sdk/ble/companionApp/AssociationState;", "associationStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getAssociationStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "observedDevices", "", "", "associationCallback", "Lkotlin/Function1;", "Landroid/companion/CompanionDeviceManager$Callback;", "oldAssociationRequest", "isAssociated", "", "deviceAddress", "associate", "", "activity", "disassociate", "startObservingDevice", "stopObservingDevice", "getAssociationInfo", "Landroid/companion/AssociationInfo;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class BatCompanionDeviceManager {
    private final MutableStateFlow<AssociationState> _associationStateFlow;
    private final Function1<String, CompanionDeviceManager.Callback> associationCallback;
    private final StateFlow<AssociationState> associationStateFlow;
    private final Context context;
    private CompanionDeviceManager deviceManager;
    private final Set<String> observedDevices;
    private final Function1<String, CompanionDeviceManager.Callback> oldAssociationRequest;

    public BatCompanionDeviceManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object systemService = context.getSystemService("companiondevice");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.companion.CompanionDeviceManager");
        this.deviceManager = (CompanionDeviceManager) systemService;
        MutableStateFlow<AssociationState> MutableStateFlow = StateFlowKt.MutableStateFlow(AssociationState.AssociationIdle.INSTANCE);
        this._associationStateFlow = MutableStateFlow;
        this.associationStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.observedDevices = new LinkedHashSet();
        this.associationCallback = new Function1() { // from class: com.bat.sdk.ble.companionApp.BatCompanionDeviceManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BatCompanionDeviceManager.associationCallback$lambda$0(this.f$0, (String) obj);
            }
        };
        this.oldAssociationRequest = new Function1() { // from class: com.bat.sdk.ble.companionApp.BatCompanionDeviceManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BatCompanionDeviceManager.oldAssociationRequest$lambda$1(this.f$0, (String) obj);
            }
        };
    }

    public final StateFlow<AssociationState> getAssociationStateFlow() {
        return this.associationStateFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bat.sdk.ble.companionApp.BatCompanionDeviceManager$associationCallback$1$1] */
    public static final BatCompanionDeviceManager$associationCallback$1$1 associationCallback$lambda$0(final BatCompanionDeviceManager this$0, final String it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new CompanionDeviceManager.Callback() { // from class: com.bat.sdk.ble.companionApp.BatCompanionDeviceManager$associationCallback$1$1
            @Override // android.companion.CompanionDeviceManager.Callback
            public void onFailure(CharSequence error) {
                Logger logger = Logger.INSTANCE;
                String string = getClass().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                logger.log(string, "[cmpApp] error on device association " + ((Object) error));
                this.this$0._associationStateFlow.setValue(new AssociationState.AssociationError(it2, String.valueOf(error)));
            }

            @Override // android.companion.CompanionDeviceManager.Callback
            public void onAssociationPending(IntentSender intentSender) throws IntentSender.SendIntentException {
                Intrinsics.checkNotNullParameter(intentSender, "intentSender");
                super.onAssociationPending(intentSender);
                Logger logger = Logger.INSTANCE;
                String string = getClass().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                logger.log(string, "[cmpApp] association is pending");
                this.this$0._associationStateFlow.setValue(new AssociationState.AssociationPending(it2));
                this.this$0.context.startIntentSender(intentSender, null, 0, 0, 0);
            }

            @Override // android.companion.CompanionDeviceManager.Callback
            public void onAssociationCreated(AssociationInfo associationInfo) {
                Intrinsics.checkNotNullParameter(associationInfo, "associationInfo");
                super.onAssociationCreated(associationInfo);
                Logger logger = Logger.INSTANCE;
                String string = getClass().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                logger.log(string, "[cmpApp] association created");
                this.this$0._associationStateFlow.setValue(new AssociationState.AssociationCreated(it2, associationInfo));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bat.sdk.ble.companionApp.BatCompanionDeviceManager$oldAssociationRequest$1$1] */
    public static final BatCompanionDeviceManager$oldAssociationRequest$1$1 oldAssociationRequest$lambda$1(final BatCompanionDeviceManager this$0, final String it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new CompanionDeviceManager.Callback() { // from class: com.bat.sdk.ble.companionApp.BatCompanionDeviceManager$oldAssociationRequest$1$1
            @Override // android.companion.CompanionDeviceManager.Callback
            public void onDeviceFound(IntentSender chooserLauncher) throws IntentSender.SendIntentException {
                Intrinsics.checkNotNullParameter(chooserLauncher, "chooserLauncher");
                Logger logger = Logger.INSTANCE;
                String string = getClass().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                logger.log(string, "[cmpApp] onDeviceFound");
                this.this$0.context.startIntentSender(chooserLauncher, null, 0, 0, 0);
                this.this$0._associationStateFlow.setValue(new AssociationState.DeviceFound(it2));
            }

            @Override // android.companion.CompanionDeviceManager.Callback
            public void onFailure(CharSequence error) {
                Logger logger = Logger.INSTANCE;
                String string = getClass().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                logger.log(string, "[cmpApp] error on device association " + ((Object) error));
                this.this$0._associationStateFlow.setValue(new AssociationState.AssociationError(it2, String.valueOf(error)));
            }
        };
    }

    public final boolean isAssociated(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        if (Build.VERSION.SDK_INT < 33) {
            Logger.INSTANCE.log("[cmpApp] searching for associated device " + this.deviceManager.getAssociations());
            List<String> associations = this.deviceManager.getAssociations();
            Intrinsics.checkNotNullExpressionValue(associations, "getAssociations(...)");
            List<String> list = associations;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str : list) {
                Intrinsics.checkNotNull(str);
                String lowerCase = str.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                arrayList.add(lowerCase);
            }
            String lowerCase2 = deviceAddress.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return arrayList.contains(lowerCase2);
        }
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        List<AssociationInfo> myAssociations = this.deviceManager.getMyAssociations();
        Intrinsics.checkNotNullExpressionValue(myAssociations, "getMyAssociations(...)");
        List<AssociationInfo> list2 = myAssociations;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(String.valueOf(((AssociationInfo) it2.next()).getDeviceMacAddress()));
        }
        String lowerCase3 = deviceAddress.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return arrayList2.contains(lowerCase3);
    }

    public static /* synthetic */ void associate$default(BatCompanionDeviceManager batCompanionDeviceManager, String str, Context context, int i, Object obj) {
        if ((i & 2) != 0) {
            context = batCompanionDeviceManager.context;
        }
        batCompanionDeviceManager.associate(str, context);
    }

    public final void associate(String deviceAddress, Context activity) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!isAssociated(deviceAddress)) {
            BluetoothDeviceFilter bluetoothDeviceFilterBuild = new BluetoothDeviceFilter.Builder().setAddress(deviceAddress).build();
            Intrinsics.checkNotNullExpressionValue(bluetoothDeviceFilterBuild, "build(...)");
            AssociationRequest associationRequestBuild = new AssociationRequest.Builder().addDeviceFilter(bluetoothDeviceFilterBuild).setSingleDevice(true).build();
            Intrinsics.checkNotNullExpressionValue(associationRequestBuild, "build(...)");
            if (Build.VERSION.SDK_INT < 33 && (activity instanceof Activity)) {
                Logger logger = Logger.INSTANCE;
                String string = getClass().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                logger.log(string, "[cmpApp] associating a device on a lower android version");
                Object systemService = ((Activity) activity).getSystemService("companiondevice");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.companion.CompanionDeviceManager");
                CompanionDeviceManager companionDeviceManager = (CompanionDeviceManager) systemService;
                this.deviceManager = companionDeviceManager;
                companionDeviceManager.associate(associationRequestBuild, this.oldAssociationRequest.invoke(deviceAddress), (Handler) null);
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                Logger logger2 = Logger.INSTANCE;
                String string2 = getClass().toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                logger2.log(string2, "[cmpApp] associating a device on android >= 33");
                this.deviceManager.associate(associationRequestBuild, new Executor() { // from class: com.bat.sdk.ble.companionApp.BatCompanionDeviceManager$$ExternalSyntheticLambda2
                    @Override // java.util.concurrent.Executor
                    public final void execute(Runnable runnable) {
                        runnable.run();
                    }
                }, this.associationCallback.invoke(deviceAddress));
                return;
            }
            return;
        }
        Logger logger3 = Logger.INSTANCE;
        String string3 = getClass().toString();
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        logger3.log(string3, "[cmpApp] device already associated");
    }

    public final void disassociate(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        if (isAssociated(deviceAddress)) {
            if (this.observedDevices.contains(deviceAddress)) {
                stopObservingDevice(deviceAddress);
            }
            if (Build.VERSION.SDK_INT < 33) {
                Logger logger = Logger.INSTANCE;
                String string = getClass().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                logger.log(string, "[cmpApp] removed association with a device");
                CompanionDeviceManager companionDeviceManager = this.deviceManager;
                String lowerCase = deviceAddress.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                companionDeviceManager.disassociate(lowerCase);
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                Logger logger2 = Logger.INSTANCE;
                String string2 = getClass().toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                logger2.log(string2, "[cmpApp] removed association with a device on android >= 33");
                AssociationInfo associationInfo = getAssociationInfo(deviceAddress);
                if (associationInfo != null) {
                    this.deviceManager.disassociate(associationInfo.getId());
                }
            }
        }
    }

    public final void startObservingDevice(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Logger logger = Logger.INSTANCE;
        String string = getClass().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        logger.log(string, "[cmpApp] device observation supported? " + (Build.VERSION.SDK_INT >= 31) + " current sdk " + Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT < 31 || !isAssociated(deviceAddress)) {
            return;
        }
        Set<String> set = this.observedDevices;
        String lowerCase = deviceAddress.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (set.contains(lowerCase)) {
            return;
        }
        Logger logger2 = Logger.INSTANCE;
        String string2 = getClass().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        logger2.log(string2, "[cmpApp] starting device observation");
        this.deviceManager.startObservingDevicePresence(deviceAddress);
        Set<String> set2 = this.observedDevices;
        String lowerCase2 = deviceAddress.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        set2.add(lowerCase2);
    }

    public final void stopObservingDevice(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        if (Build.VERSION.SDK_INT < 31 || !isAssociated(deviceAddress)) {
            return;
        }
        Set<String> set = this.observedDevices;
        String lowerCase = deviceAddress.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (set.contains(lowerCase)) {
            Logger logger = Logger.INSTANCE;
            String string = getClass().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            logger.log(string, "[cmpApp] stopping device observation");
            this.deviceManager.stopObservingDevicePresence(deviceAddress);
            Set<String> set2 = this.observedDevices;
            String lowerCase2 = deviceAddress.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            set2.remove(lowerCase2);
            Logger logger2 = Logger.INSTANCE;
            String string2 = getClass().toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            logger2.log(string2, "[cmpApp] devices still in observation " + this.observedDevices);
        }
    }

    private final AssociationInfo getAssociationInfo(String deviceAddress) {
        Object next;
        List<AssociationInfo> myAssociations = this.deviceManager.getMyAssociations();
        Intrinsics.checkNotNullExpressionValue(myAssociations, "getMyAssociations(...)");
        Iterator<T> it2 = myAssociations.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            String strValueOf = String.valueOf(((AssociationInfo) next).getDeviceMacAddress());
            String lowerCase = deviceAddress.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (Intrinsics.areEqual(strValueOf, lowerCase)) {
                break;
            }
        }
        return (AssociationInfo) next;
    }
}
