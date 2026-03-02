package com.bat.sdk;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.room.Room;
import androidx.work.WorkManager;
import com.bat.sdk.age.AgeVerificationCaller;
import com.bat.sdk.age.AgeVerifier;
import com.bat.sdk.asav.AsavModule;
import com.bat.sdk.asav.core.AsavSettings;
import com.bat.sdk.asav.core.Channels;
import com.bat.sdk.asav.core.IAsavChannels;
import com.bat.sdk.ble.BatScanner;
import com.bat.sdk.ble.Bonding;
import com.bat.sdk.ble.BtProximityUnlock;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.ble.companionApp.BatCompanionDeviceManager;
import com.bat.sdk.client.AgeChallengeClient;
import com.bat.sdk.client.AgeSignatureClient;
import com.bat.sdk.client.BatteryClient;
import com.bat.sdk.client.BleTimeoutClient;
import com.bat.sdk.client.BuzzerClient;
import com.bat.sdk.client.CloudClient;
import com.bat.sdk.client.DeviceInfoClient;
import com.bat.sdk.client.ErrorClient;
import com.bat.sdk.client.FindVapeClient;
import com.bat.sdk.client.HapticClient;
import com.bat.sdk.client.LedClient;
import com.bat.sdk.client.LockClient;
import com.bat.sdk.client.LogsClient;
import com.bat.sdk.client.PodConnectionClient;
import com.bat.sdk.client.PowerSaveModeClient;
import com.bat.sdk.client.PuffsClient;
import com.bat.sdk.client.RechargeRemindersClient;
import com.bat.sdk.client.ResetClient;
import com.bat.sdk.client.SessionIndicationClient;
import com.bat.sdk.client.TimeClient;
import com.bat.sdk.client.TimeoutAutoLockClient;
import com.bat.sdk.client.UsageReminderClient;
import com.bat.sdk.client.epen.DeviceControlClient;
import com.bat.sdk.client.epen.RecordsAvailableClient;
import com.bat.sdk.client.epen.RxClient;
import com.bat.sdk.client.ota.OtaControlClient;
import com.bat.sdk.client.ota.OtaNewClient;
import com.bat.sdk.client.ota.OtaPayloadClient;
import com.bat.sdk.client.payload.PayloadChallengeClient;
import com.bat.sdk.client.payload.PayloadClient;
import com.bat.sdk.client.payload.PayloadControlClient;
import com.bat.sdk.client.payload.PayloadVersionClient;
import com.bat.sdk.fota.FotaUploader;
import com.bat.sdk.payload.PayloadCaller;
import com.bat.sdk.payload.PayloadUploader;
import com.bat.sdk.persistence.MigrationsKt;
import com.bat.sdk.persistence.SdkDatabase;
import com.bat.sdk.persistence.Settings;
import com.bat.sdk.persistence.SettingsManager;
import com.bat.sdk.persistence.repository.BatDevicesRepository;
import com.bat.sdk.persistence.repository.ErrorRecordRepository;
import com.bat.sdk.persistence.repository.LogRecordRepository;
import com.bat.sdk.persistence.repository.PuffRecordRepository;
import com.bat.sdk.persistence.repository.SdkLogRepository;
import com.bat.sdk.remote.AuthenticationErrorInterceptor;
import com.bat.sdk.sync.EPenPuffValidator;
import com.bat.sdk.sync.EpenPuffReader;
import com.bat.sdk.sync.EpenPuffsSynchronizer;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Definitions;
import org.koin.core.definition.Kind;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.module.Module;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.core.scope.ScopeDefinition;
import org.koin.dsl.DefinitionBindingKt;
import org.koin.dsl.ModuleKt;

/* JADX INFO: compiled from: KoinModules.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/KoinModules;", "", "<init>", "()V", "sdkModule", "Lorg/koin/core/module/Module;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class KoinModules {
    public static final KoinModules INSTANCE = new KoinModules();

    private KoinModules() {
    }

    public final Module sdkModule() {
        return ModuleKt.module$default(false, false, new Function1() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda56
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KoinModules.sdkModule$lambda$60((Module) obj);
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PuffRecordRepository sdkModule$lambda$60$lambda$1(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new PuffRecordRepository((SdkDatabase) single.get(Reflection.getOrCreateKotlinClass(SdkDatabase.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LogRecordRepository sdkModule$lambda$60$lambda$2(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new LogRecordRepository((SdkDatabase) single.get(Reflection.getOrCreateKotlinClass(SdkDatabase.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ErrorRecordRepository sdkModule$lambda$60$lambda$3(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new ErrorRecordRepository((SdkDatabase) single.get(Reflection.getOrCreateKotlinClass(SdkDatabase.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SdkLogRepository sdkModule$lambda$60$lambda$4(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new SdkLogRepository((SdkDatabase) single.get(Reflection.getOrCreateKotlinClass(SdkDatabase.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BatDevicesRepository sdkModule$lambda$60$lambda$5(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new BatDevicesRepository((SdkDatabase) single.get(Reflection.getOrCreateKotlinClass(SdkDatabase.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Settings sdkModule$lambda$60$lambda$7(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new Settings((Context) single.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SettingsManager sdkModule$lambda$60$lambda$8(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new SettingsManager((Settings) single.get(Reflection.getOrCreateKotlinClass(Settings.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BatScanner sdkModule$lambda$60$lambda$9(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new BatScanner((Context) single.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bonding sdkModule$lambda$60$lambda$10(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new Bonding((Context) single.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BatCompanionDeviceManager sdkModule$lambda$60$lambda$11(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new BatCompanionDeviceManager((Context) single.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GattManager sdkModule$lambda$60$lambda$12(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new GattManager((Context) single.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeviceInfoClient sdkModule$lambda$60$lambda$13(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new DeviceInfoClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BatteryClient sdkModule$lambda$60$lambda$14(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new BatteryClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CloudClient sdkModule$lambda$60$lambda$15(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new CloudClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PowerSaveModeClient sdkModule$lambda$60$lambda$16(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new PowerSaveModeClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ErrorClient sdkModule$lambda$60$lambda$17(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new ErrorClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FindVapeClient sdkModule$lambda$60$lambda$18(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new FindVapeClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HapticClient sdkModule$lambda$60$lambda$19(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new HapticClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LedClient sdkModule$lambda$60$lambda$20(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new LedClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockClient sdkModule$lambda$60$lambda$21(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new LockClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BuzzerClient sdkModule$lambda$60$lambda$22(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new BuzzerClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PodConnectionClient sdkModule$lambda$60$lambda$23(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new PodConnectionClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LogsClient sdkModule$lambda$60$lambda$24(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new LogsClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PuffsClient sdkModule$lambda$60$lambda$25(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new PuffsClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UsageReminderClient sdkModule$lambda$60$lambda$26(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new UsageReminderClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimeClient sdkModule$lambda$60$lambda$27(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new TimeClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ResetClient sdkModule$lambda$60$lambda$28(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new ResetClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RechargeRemindersClient sdkModule$lambda$60$lambda$29(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new RechargeRemindersClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SessionIndicationClient sdkModule$lambda$60$lambda$30(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new SessionIndicationClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimeoutAutoLockClient sdkModule$lambda$60$lambda$31(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new TimeoutAutoLockClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OtaNewClient sdkModule$lambda$60$lambda$32(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new OtaNewClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OtaControlClient sdkModule$lambda$60$lambda$33(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new OtaControlClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OtaPayloadClient sdkModule$lambda$60$lambda$34(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new OtaPayloadClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PayloadVersionClient sdkModule$lambda$60$lambda$35(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new PayloadVersionClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PayloadControlClient sdkModule$lambda$60$lambda$36(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new PayloadControlClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PayloadClient sdkModule$lambda$60$lambda$37(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new PayloadClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PayloadChallengeClient sdkModule$lambda$60$lambda$38(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new PayloadChallengeClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AgeChallengeClient sdkModule$lambda$60$lambda$39(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new AgeChallengeClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AgeSignatureClient sdkModule$lambda$60$lambda$40(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new AgeSignatureClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AgeVerificationCaller sdkModule$lambda$60$lambda$41(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new AgeVerificationCaller();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AgeVerifier sdkModule$lambda$60$lambda$42(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new AgeVerifier((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (AgeVerificationCaller) single.get(Reflection.getOrCreateKotlinClass(AgeVerificationCaller.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (AgeChallengeClient) single.get(Reflection.getOrCreateKotlinClass(AgeChallengeClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (AgeSignatureClient) single.get(Reflection.getOrCreateKotlinClass(AgeSignatureClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PayloadCaller sdkModule$lambda$60$lambda$43(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new PayloadCaller();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PayloadUploader sdkModule$lambda$60$lambda$44(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new PayloadUploader((PayloadVersionClient) single.get(Reflection.getOrCreateKotlinClass(PayloadVersionClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (PayloadControlClient) single.get(Reflection.getOrCreateKotlinClass(PayloadControlClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (PayloadChallengeClient) single.get(Reflection.getOrCreateKotlinClass(PayloadChallengeClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (PayloadClient) single.get(Reflection.getOrCreateKotlinClass(PayloadClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (PayloadCaller) single.get(Reflection.getOrCreateKotlinClass(PayloadCaller.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FotaUploader sdkModule$lambda$60$lambda$45(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new FotaUploader((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (OtaNewClient) single.get(Reflection.getOrCreateKotlinClass(OtaNewClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (OtaControlClient) single.get(Reflection.getOrCreateKotlinClass(OtaControlClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (OtaPayloadClient) single.get(Reflection.getOrCreateKotlinClass(OtaPayloadClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirmwareManager sdkModule$lambda$60$lambda$46(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new FirmwareManager((Context) single.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthenticationErrorInterceptor sdkModule$lambda$60$lambda$47(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new AuthenticationErrorInterceptor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RxClient sdkModule$lambda$60$lambda$48(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new RxClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeviceControlClient sdkModule$lambda$60$lambda$49(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new DeviceControlClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecordsAvailableClient sdkModule$lambda$60$lambda$50(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new RecordsAvailableClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EpenPuffReader sdkModule$lambda$60$lambda$51(Scope factory, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(factory, "$this$factory");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new EpenPuffReader((DeviceControlClient) factory.get(Reflection.getOrCreateKotlinClass(DeviceControlClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (RxClient) factory.get(Reflection.getOrCreateKotlinClass(RxClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EPenPuffValidator sdkModule$lambda$60$lambda$52(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new EPenPuffValidator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EpenPuffsSynchronizer sdkModule$lambda$60$lambda$53(Scope factory, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(factory, "$this$factory");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new EpenPuffsSynchronizer((RecordsAvailableClient) factory.get(Reflection.getOrCreateKotlinClass(RecordsAvailableClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (EpenPuffReader) factory.get(Reflection.getOrCreateKotlinClass(EpenPuffReader.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (EPenPuffValidator) factory.get(Reflection.getOrCreateKotlinClass(EPenPuffValidator.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Lifecycle sdkModule$lambda$60$lambda$54(Scope factory, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(factory, "$this$factory");
        Intrinsics.checkNotNullParameter(it2, "it");
        return ProcessLifecycleOwner.get().getLifecycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Channels sdkModule$lambda$60$lambda$55(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new Channels();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsavSettings sdkModule$lambda$60$lambda$56(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new AsavSettings((IAsavChannels) single.get(Reflection.getOrCreateKotlinClass(IAsavChannels.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsavModule sdkModule$lambda$60$lambda$57(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new AsavModule((Context) single.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<DefinitionParameters>) null), (AsavSettings) single.get(Reflection.getOrCreateKotlinClass(AsavSettings.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BleTimeoutClient sdkModule$lambda$60$lambda$58(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new BleTimeoutClient((GattManager) single.get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BtProximityUnlock sdkModule$lambda$60$lambda$59(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new BtProximityUnlock((Context) single.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SdkDatabase sdkModule$lambda$60$lambda$0(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        Context applicationContext = ((Context) single.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<DefinitionParameters>) null)).getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return (SdkDatabase) Room.databaseBuilder(applicationContext, SdkDatabase.class, "bat-sdk-db.sqlite").addMigrations(MigrationsKt.getMIGRATION_1_2(), MigrationsKt.getMIGRATION_2_3(), MigrationsKt.getMIGRATION_3_4()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkManager sdkModule$lambda$60$lambda$6(Scope single, DefinitionParameters it2) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it2, "it");
        return WorkManager.getInstance((Context) single.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sdkModule$lambda$60(Module module) throws DefinitionOverrideException {
        Intrinsics.checkNotNullParameter(module, "$this$module");
        Function2 function2 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$0((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions = Definitions.INSTANCE;
        ScopeDefinition rootScope = module.getRootScope();
        ScopeDefinition.save$default(rootScope, new BeanDefinition(rootScope, Reflection.getOrCreateKotlinClass(SdkDatabase.class), null, function2, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function22 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$1((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions2 = Definitions.INSTANCE;
        ScopeDefinition rootScope2 = module.getRootScope();
        ScopeDefinition.save$default(rootScope2, new BeanDefinition(rootScope2, Reflection.getOrCreateKotlinClass(PuffRecordRepository.class), null, function22, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function23 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$2((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions3 = Definitions.INSTANCE;
        ScopeDefinition rootScope3 = module.getRootScope();
        ScopeDefinition.save$default(rootScope3, new BeanDefinition(rootScope3, Reflection.getOrCreateKotlinClass(LogRecordRepository.class), null, function23, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function24 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$3((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions4 = Definitions.INSTANCE;
        ScopeDefinition rootScope4 = module.getRootScope();
        ScopeDefinition.save$default(rootScope4, new BeanDefinition(rootScope4, Reflection.getOrCreateKotlinClass(ErrorRecordRepository.class), null, function24, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function25 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$4((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions5 = Definitions.INSTANCE;
        ScopeDefinition rootScope5 = module.getRootScope();
        ScopeDefinition.save$default(rootScope5, new BeanDefinition(rootScope5, Reflection.getOrCreateKotlinClass(SdkLogRepository.class), null, function25, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function26 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda50
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$5((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions6 = Definitions.INSTANCE;
        ScopeDefinition rootScope6 = module.getRootScope();
        ScopeDefinition.save$default(rootScope6, new BeanDefinition(rootScope6, Reflection.getOrCreateKotlinClass(BatDevicesRepository.class), null, function26, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function27 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda51
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$6((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions7 = Definitions.INSTANCE;
        ScopeDefinition rootScope7 = module.getRootScope();
        ScopeDefinition.save$default(rootScope7, new BeanDefinition(rootScope7, Reflection.getOrCreateKotlinClass(WorkManager.class), null, function27, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function28 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda52
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$7((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions8 = Definitions.INSTANCE;
        ScopeDefinition rootScope8 = module.getRootScope();
        ScopeDefinition.save$default(rootScope8, new BeanDefinition(rootScope8, Reflection.getOrCreateKotlinClass(Settings.class), null, function28, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function29 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda53
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$8((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions9 = Definitions.INSTANCE;
        ScopeDefinition rootScope9 = module.getRootScope();
        ScopeDefinition.save$default(rootScope9, new BeanDefinition(rootScope9, Reflection.getOrCreateKotlinClass(SettingsManager.class), null, function29, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function210 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda54
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$9((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions10 = Definitions.INSTANCE;
        ScopeDefinition rootScope10 = module.getRootScope();
        ScopeDefinition.save$default(rootScope10, new BeanDefinition(rootScope10, Reflection.getOrCreateKotlinClass(BatScanner.class), null, function210, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function211 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$10((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions11 = Definitions.INSTANCE;
        ScopeDefinition rootScope11 = module.getRootScope();
        ScopeDefinition.save$default(rootScope11, new BeanDefinition(rootScope11, Reflection.getOrCreateKotlinClass(Bonding.class), null, function211, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function212 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$11((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions12 = Definitions.INSTANCE;
        ScopeDefinition rootScope12 = module.getRootScope();
        ScopeDefinition.save$default(rootScope12, new BeanDefinition(rootScope12, Reflection.getOrCreateKotlinClass(BatCompanionDeviceManager.class), null, function212, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function213 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$12((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions13 = Definitions.INSTANCE;
        ScopeDefinition rootScope13 = module.getRootScope();
        ScopeDefinition.save$default(rootScope13, new BeanDefinition(rootScope13, Reflection.getOrCreateKotlinClass(GattManager.class), null, function213, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function214 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$13((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions14 = Definitions.INSTANCE;
        ScopeDefinition rootScope14 = module.getRootScope();
        ScopeDefinition.save$default(rootScope14, new BeanDefinition(rootScope14, Reflection.getOrCreateKotlinClass(DeviceInfoClient.class), null, function214, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function215 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda55
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$14((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions15 = Definitions.INSTANCE;
        ScopeDefinition rootScope15 = module.getRootScope();
        ScopeDefinition.save$default(rootScope15, new BeanDefinition(rootScope15, Reflection.getOrCreateKotlinClass(BatteryClient.class), null, function215, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function216 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda57
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$15((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions16 = Definitions.INSTANCE;
        ScopeDefinition rootScope16 = module.getRootScope();
        ScopeDefinition.save$default(rootScope16, new BeanDefinition(rootScope16, Reflection.getOrCreateKotlinClass(CloudClient.class), null, function216, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function217 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda58
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$16((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions17 = Definitions.INSTANCE;
        ScopeDefinition rootScope17 = module.getRootScope();
        ScopeDefinition.save$default(rootScope17, new BeanDefinition(rootScope17, Reflection.getOrCreateKotlinClass(PowerSaveModeClient.class), null, function217, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function218 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda59
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$17((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions18 = Definitions.INSTANCE;
        ScopeDefinition rootScope18 = module.getRootScope();
        ScopeDefinition.save$default(rootScope18, new BeanDefinition(rootScope18, Reflection.getOrCreateKotlinClass(ErrorClient.class), null, function218, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function219 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda60
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$18((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions19 = Definitions.INSTANCE;
        ScopeDefinition rootScope19 = module.getRootScope();
        ScopeDefinition.save$default(rootScope19, new BeanDefinition(rootScope19, Reflection.getOrCreateKotlinClass(FindVapeClient.class), null, function219, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function220 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$19((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions20 = Definitions.INSTANCE;
        ScopeDefinition rootScope20 = module.getRootScope();
        ScopeDefinition.save$default(rootScope20, new BeanDefinition(rootScope20, Reflection.getOrCreateKotlinClass(HapticClient.class), null, function220, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function221 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$20((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions21 = Definitions.INSTANCE;
        ScopeDefinition rootScope21 = module.getRootScope();
        ScopeDefinition.save$default(rootScope21, new BeanDefinition(rootScope21, Reflection.getOrCreateKotlinClass(LedClient.class), null, function221, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function222 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$21((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions22 = Definitions.INSTANCE;
        ScopeDefinition rootScope22 = module.getRootScope();
        ScopeDefinition.save$default(rootScope22, new BeanDefinition(rootScope22, Reflection.getOrCreateKotlinClass(LockClient.class), null, function222, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function223 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$22((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions23 = Definitions.INSTANCE;
        ScopeDefinition rootScope23 = module.getRootScope();
        ScopeDefinition.save$default(rootScope23, new BeanDefinition(rootScope23, Reflection.getOrCreateKotlinClass(BuzzerClient.class), null, function223, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function224 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$23((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions24 = Definitions.INSTANCE;
        ScopeDefinition rootScope24 = module.getRootScope();
        ScopeDefinition.save$default(rootScope24, new BeanDefinition(rootScope24, Reflection.getOrCreateKotlinClass(PodConnectionClient.class), null, function224, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function225 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$24((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions25 = Definitions.INSTANCE;
        ScopeDefinition rootScope25 = module.getRootScope();
        ScopeDefinition.save$default(rootScope25, new BeanDefinition(rootScope25, Reflection.getOrCreateKotlinClass(LogsClient.class), null, function225, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function226 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$25((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions26 = Definitions.INSTANCE;
        ScopeDefinition rootScope26 = module.getRootScope();
        ScopeDefinition.save$default(rootScope26, new BeanDefinition(rootScope26, Reflection.getOrCreateKotlinClass(PuffsClient.class), null, function226, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function227 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$26((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions27 = Definitions.INSTANCE;
        ScopeDefinition rootScope27 = module.getRootScope();
        ScopeDefinition.save$default(rootScope27, new BeanDefinition(rootScope27, Reflection.getOrCreateKotlinClass(UsageReminderClient.class), null, function227, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function228 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$27((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions28 = Definitions.INSTANCE;
        ScopeDefinition rootScope28 = module.getRootScope();
        ScopeDefinition.save$default(rootScope28, new BeanDefinition(rootScope28, Reflection.getOrCreateKotlinClass(TimeClient.class), null, function228, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function229 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$28((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions29 = Definitions.INSTANCE;
        ScopeDefinition rootScope29 = module.getRootScope();
        ScopeDefinition.save$default(rootScope29, new BeanDefinition(rootScope29, Reflection.getOrCreateKotlinClass(ResetClient.class), null, function229, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function230 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$29((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions30 = Definitions.INSTANCE;
        ScopeDefinition rootScope30 = module.getRootScope();
        ScopeDefinition.save$default(rootScope30, new BeanDefinition(rootScope30, Reflection.getOrCreateKotlinClass(RechargeRemindersClient.class), null, function230, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function231 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$30((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions31 = Definitions.INSTANCE;
        ScopeDefinition rootScope31 = module.getRootScope();
        ScopeDefinition.save$default(rootScope31, new BeanDefinition(rootScope31, Reflection.getOrCreateKotlinClass(SessionIndicationClient.class), null, function231, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function232 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$31((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions32 = Definitions.INSTANCE;
        ScopeDefinition rootScope32 = module.getRootScope();
        ScopeDefinition.save$default(rootScope32, new BeanDefinition(rootScope32, Reflection.getOrCreateKotlinClass(TimeoutAutoLockClient.class), null, function232, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function233 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$32((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions33 = Definitions.INSTANCE;
        ScopeDefinition rootScope33 = module.getRootScope();
        ScopeDefinition.save$default(rootScope33, new BeanDefinition(rootScope33, Reflection.getOrCreateKotlinClass(OtaNewClient.class), null, function233, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function234 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$33((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions34 = Definitions.INSTANCE;
        ScopeDefinition rootScope34 = module.getRootScope();
        ScopeDefinition.save$default(rootScope34, new BeanDefinition(rootScope34, Reflection.getOrCreateKotlinClass(OtaControlClient.class), null, function234, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function235 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$34((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions35 = Definitions.INSTANCE;
        ScopeDefinition rootScope35 = module.getRootScope();
        ScopeDefinition.save$default(rootScope35, new BeanDefinition(rootScope35, Reflection.getOrCreateKotlinClass(OtaPayloadClient.class), null, function235, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function236 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$35((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions36 = Definitions.INSTANCE;
        ScopeDefinition rootScope36 = module.getRootScope();
        ScopeDefinition.save$default(rootScope36, new BeanDefinition(rootScope36, Reflection.getOrCreateKotlinClass(PayloadVersionClient.class), null, function236, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function237 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$36((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions37 = Definitions.INSTANCE;
        ScopeDefinition rootScope37 = module.getRootScope();
        ScopeDefinition.save$default(rootScope37, new BeanDefinition(rootScope37, Reflection.getOrCreateKotlinClass(PayloadControlClient.class), null, function237, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function238 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$37((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions38 = Definitions.INSTANCE;
        ScopeDefinition rootScope38 = module.getRootScope();
        ScopeDefinition.save$default(rootScope38, new BeanDefinition(rootScope38, Reflection.getOrCreateKotlinClass(PayloadClient.class), null, function238, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function239 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$38((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions39 = Definitions.INSTANCE;
        ScopeDefinition rootScope39 = module.getRootScope();
        ScopeDefinition.save$default(rootScope39, new BeanDefinition(rootScope39, Reflection.getOrCreateKotlinClass(PayloadChallengeClient.class), null, function239, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function240 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$39((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions40 = Definitions.INSTANCE;
        ScopeDefinition rootScope40 = module.getRootScope();
        ScopeDefinition.save$default(rootScope40, new BeanDefinition(rootScope40, Reflection.getOrCreateKotlinClass(AgeChallengeClient.class), null, function240, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function241 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$40((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions41 = Definitions.INSTANCE;
        ScopeDefinition rootScope41 = module.getRootScope();
        ScopeDefinition.save$default(rootScope41, new BeanDefinition(rootScope41, Reflection.getOrCreateKotlinClass(AgeSignatureClient.class), null, function241, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function242 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$41((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions42 = Definitions.INSTANCE;
        ScopeDefinition rootScope42 = module.getRootScope();
        ScopeDefinition.save$default(rootScope42, new BeanDefinition(rootScope42, Reflection.getOrCreateKotlinClass(AgeVerificationCaller.class), null, function242, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function243 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$42((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions43 = Definitions.INSTANCE;
        ScopeDefinition rootScope43 = module.getRootScope();
        ScopeDefinition.save$default(rootScope43, new BeanDefinition(rootScope43, Reflection.getOrCreateKotlinClass(AgeVerifier.class), null, function243, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function244 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$43((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions44 = Definitions.INSTANCE;
        ScopeDefinition rootScope44 = module.getRootScope();
        ScopeDefinition.save$default(rootScope44, new BeanDefinition(rootScope44, Reflection.getOrCreateKotlinClass(PayloadCaller.class), null, function244, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function245 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$44((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions45 = Definitions.INSTANCE;
        ScopeDefinition rootScope45 = module.getRootScope();
        ScopeDefinition.save$default(rootScope45, new BeanDefinition(rootScope45, Reflection.getOrCreateKotlinClass(PayloadUploader.class), null, function245, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function246 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$45((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions46 = Definitions.INSTANCE;
        ScopeDefinition rootScope46 = module.getRootScope();
        ScopeDefinition.save$default(rootScope46, new BeanDefinition(rootScope46, Reflection.getOrCreateKotlinClass(FotaUploader.class), null, function246, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function247 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$46((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions47 = Definitions.INSTANCE;
        ScopeDefinition rootScope47 = module.getRootScope();
        ScopeDefinition.save$default(rootScope47, new BeanDefinition(rootScope47, Reflection.getOrCreateKotlinClass(FirmwareManager.class), null, function247, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function248 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$47((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions48 = Definitions.INSTANCE;
        ScopeDefinition rootScope48 = module.getRootScope();
        ScopeDefinition.save$default(rootScope48, new BeanDefinition(rootScope48, Reflection.getOrCreateKotlinClass(AuthenticationErrorInterceptor.class), null, function248, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function249 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$48((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions49 = Definitions.INSTANCE;
        ScopeDefinition rootScope49 = module.getRootScope();
        ScopeDefinition.save$default(rootScope49, new BeanDefinition(rootScope49, Reflection.getOrCreateKotlinClass(RxClient.class), null, function249, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function250 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$49((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions50 = Definitions.INSTANCE;
        ScopeDefinition rootScope50 = module.getRootScope();
        ScopeDefinition.save$default(rootScope50, new BeanDefinition(rootScope50, Reflection.getOrCreateKotlinClass(DeviceControlClient.class), null, function250, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function251 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$50((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions51 = Definitions.INSTANCE;
        ScopeDefinition rootScope51 = module.getRootScope();
        ScopeDefinition.save$default(rootScope51, new BeanDefinition(rootScope51, Reflection.getOrCreateKotlinClass(RecordsAvailableClient.class), null, function251, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function252 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$51((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions52 = Definitions.INSTANCE;
        ScopeDefinition rootScope52 = module.getRootScope();
        ScopeDefinition.save$default(rootScope52, new BeanDefinition(rootScope52, Reflection.getOrCreateKotlinClass(EpenPuffReader.class), null, function252, Kind.Factory, CollectionsKt.emptyList(), Module.makeOptions$default(module, false, false, 2, null), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function253 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$52((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions53 = Definitions.INSTANCE;
        ScopeDefinition rootScope53 = module.getRootScope();
        ScopeDefinition.save$default(rootScope53, new BeanDefinition(rootScope53, Reflection.getOrCreateKotlinClass(EPenPuffValidator.class), null, function253, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function254 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$53((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions54 = Definitions.INSTANCE;
        ScopeDefinition rootScope54 = module.getRootScope();
        ScopeDefinition.save$default(rootScope54, new BeanDefinition(rootScope54, Reflection.getOrCreateKotlinClass(EpenPuffsSynchronizer.class), null, function254, Kind.Factory, CollectionsKt.emptyList(), Module.makeOptions$default(module, false, false, 2, null), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function255 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$54((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions55 = Definitions.INSTANCE;
        ScopeDefinition rootScope55 = module.getRootScope();
        ScopeDefinition.save$default(rootScope55, new BeanDefinition(rootScope55, Reflection.getOrCreateKotlinClass(Lifecycle.class), null, function255, Kind.Factory, CollectionsKt.emptyList(), Module.makeOptions$default(module, false, false, 2, null), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function256 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$55((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions56 = Definitions.INSTANCE;
        ScopeDefinition rootScope56 = module.getRootScope();
        BeanDefinition beanDefinition = new BeanDefinition(rootScope56, Reflection.getOrCreateKotlinClass(Channels.class), null, function256, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null);
        ScopeDefinition.save$default(rootScope56, beanDefinition, false, 2, null);
        DefinitionBindingKt.binds(beanDefinition, new KClass[]{Reflection.getOrCreateKotlinClass(IAsavChannels.class)});
        Function2 function257 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda46
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$56((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions57 = Definitions.INSTANCE;
        ScopeDefinition rootScope57 = module.getRootScope();
        ScopeDefinition.save$default(rootScope57, new BeanDefinition(rootScope57, Reflection.getOrCreateKotlinClass(AsavSettings.class), null, function257, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function258 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda47
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$57((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions58 = Definitions.INSTANCE;
        ScopeDefinition rootScope58 = module.getRootScope();
        ScopeDefinition.save$default(rootScope58, new BeanDefinition(rootScope58, Reflection.getOrCreateKotlinClass(AsavModule.class), null, function258, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function259 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda48
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$58((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions59 = Definitions.INSTANCE;
        ScopeDefinition rootScope59 = module.getRootScope();
        ScopeDefinition.save$default(rootScope59, new BeanDefinition(rootScope59, Reflection.getOrCreateKotlinClass(BleTimeoutClient.class), null, function259, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        Function2 function260 = new Function2() { // from class: com.bat.sdk.KoinModules$$ExternalSyntheticLambda49
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return KoinModules.sdkModule$lambda$60$lambda$59((Scope) obj, (DefinitionParameters) obj2);
            }
        };
        Definitions definitions60 = Definitions.INSTANCE;
        ScopeDefinition rootScope60 = module.getRootScope();
        ScopeDefinition.save$default(rootScope60, new BeanDefinition(rootScope60, Reflection.getOrCreateKotlinClass(BtProximityUnlock.class), null, function260, Kind.Single, CollectionsKt.emptyList(), module.makeOptions(false, false), null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
        return Unit.INSTANCE;
    }
}
