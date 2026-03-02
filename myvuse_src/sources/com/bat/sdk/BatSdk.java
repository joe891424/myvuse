package com.bat.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.bat.sdk.age.AgeVerifier;
import com.bat.sdk.asav.AsavModule;
import com.bat.sdk.ble.BatScanner;
import com.bat.sdk.ble.BleDeviceData;
import com.bat.sdk.ble.Bonding;
import com.bat.sdk.ble.BtProximityUnlock;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.ble.companionApp.BatCompanionDeviceManager;
import com.bat.sdk.client.AgeChallengeClient;
import com.bat.sdk.client.AgeSignatureClient;
import com.bat.sdk.client.BatteryClient;
import com.bat.sdk.client.BleTimeoutClient;
import com.bat.sdk.client.BuzzerClient;
import com.bat.sdk.client.CharacteristicClient;
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
import com.bat.sdk.client.RawClient;
import com.bat.sdk.client.RechargeRemindersClient;
import com.bat.sdk.client.ResetClient;
import com.bat.sdk.client.SessionIndicationClient;
import com.bat.sdk.client.TimeClient;
import com.bat.sdk.client.TimeoutAutoLockClient;
import com.bat.sdk.client.UsageReminderClient;
import com.bat.sdk.client.epen.DeviceControlClient;
import com.bat.sdk.client.ota.OtaNewClient;
import com.bat.sdk.client.payload.PayloadChallengeClient;
import com.bat.sdk.client.payload.PayloadClient;
import com.bat.sdk.client.payload.PayloadControlClient;
import com.bat.sdk.client.payload.PayloadVersionClient;
import com.bat.sdk.domain.Configuration;
import com.bat.sdk.fota.FotaUploader;
import com.bat.sdk.logging.Logger;
import com.bat.sdk.model.DeviceTime;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.PuffRecord;
import com.bat.sdk.model.PuffRequest;
import com.bat.sdk.payload.PayloadUploader;
import com.bat.sdk.persistence.SettingsManager;
import com.bat.sdk.persistence.repository.BatDevicesRepository;
import com.bat.sdk.persistence.repository.ErrorRecordRepository;
import com.bat.sdk.persistence.repository.LogRecordRepository;
import com.bat.sdk.persistence.repository.PuffRecordRepository;
import com.bat.sdk.persistence.repository.SdkLogRepository;
import com.bat.sdk.remote.AuthenticationErrorInterceptor;
import com.bat.sdk.sync.EpenPuffsSynchronizer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.koin.android.ext.koin.KoinExtKt;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.context.ContextFunctionsKt;
import org.koin.core.context.KoinContext;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;

/* JADX INFO: compiled from: BatSdk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000ê\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002Ý\u0001\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010ó\u0001\u001a\u00030ô\u00012\u0016\u0010õ\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030»\u00010ö\u0001\"\u00030»\u0001¢\u0006\u0003\u0010÷\u0001J\u001c\u0010ø\u0001\u001a\u00030ù\u00012\b\u0010ú\u0001\u001a\u00030û\u00012\b\u0010ü\u0001\u001a\u00030ý\u0001J\b\u0010þ\u0001\u001a\u00030ù\u0001R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0013\u0010(\u001a\u0004\u0018\u00010)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010-8F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0013\u00100\u001a\u0004\u0018\u0001018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u0001058F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0013\u00108\u001a\u0004\u0018\u0001098F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0013\u0010<\u001a\u0004\u0018\u00010=8F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0013\u0010@\u001a\u0004\u0018\u00010A8F¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0013\u0010D\u001a\u0004\u0018\u00010E8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0013\u0010H\u001a\u0004\u0018\u00010I8F¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0013\u0010L\u001a\u0004\u0018\u00010M8F¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0013\u0010P\u001a\u0004\u0018\u00010Q8F¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0013\u0010T\u001a\u0004\u0018\u00010U8F¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0013\u0010X\u001a\u0004\u0018\u00010Y8F¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0013\u0010\\\u001a\u0004\u0018\u00010]8F¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0013\u0010`\u001a\u0004\u0018\u00010a8F¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0013\u0010d\u001a\u0004\u0018\u00010e8F¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0013\u0010h\u001a\u0004\u0018\u00010i8F¢\u0006\u0006\u001a\u0004\bj\u0010kR\u0013\u0010l\u001a\u0004\u0018\u00010m8F¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0013\u0010p\u001a\u0004\u0018\u00010q8F¢\u0006\u0006\u001a\u0004\br\u0010sR\u0013\u0010t\u001a\u0004\u0018\u00010u8F¢\u0006\u0006\u001a\u0004\bv\u0010wR\u0013\u0010x\u001a\u0004\u0018\u00010y8F¢\u0006\u0006\u001a\u0004\bz\u0010{R\u0013\u0010|\u001a\u0004\u0018\u00010}8F¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR\u0017\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00018F¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0017\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u00018F¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0017\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00018F¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0017\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u00018F¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0017\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00018F¢\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0017\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00018F¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0017\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00018F¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0017\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u00018F¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0017\u0010 \u0001\u001a\u0005\u0018\u00010¡\u00018F¢\u0006\b\u001a\u0006\b¢\u0001\u0010£\u0001R\u0017\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u00018F¢\u0006\b\u001a\u0006\b¦\u0001\u0010§\u0001R\u000f\u0010¨\u0001\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001X\u0086\u000e¢\u0006\u0015\n\u0003\u0010¯\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R\"\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b²\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R\u001e\u0010¶\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b·\u0001\u0010\u0007\"\u0006\b¸\u0001\u0010¹\u0001R\"\u0010º\u0001\u001a\u0005\u0018\u00010»\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R\u001c\u0010À\u0001\u001a\n\u0012\u0005\u0012\u00030Â\u00010Á\u0001¢\u0006\n\n\u0000\u001a\u0006\bÃ\u0001\u0010Ä\u0001R \u0010Å\u0001\u001a\u00030Æ\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R\"\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R\u0017\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ò\u00018F¢\u0006\b\u001a\u0006\bÓ\u0001\u0010Ô\u0001R\u0012\u0010Õ\u0001\u001a\u0005\u0018\u00010Ö\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010×\u0001\u001a\u0005\u0018\u00010Ö\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ø\u0001\u001a\u0005\u0018\u00010Ö\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010«\u0001\u001a\u0005\u0018\u00010Ö\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ù\u0001\u001a\u0005\u0018\u00010Ö\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ú\u0001\u001a\u0005\u0018\u00010Ö\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Û\u0001\u001a\u0005\u0018\u00010Ö\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Ü\u0001\u001a\u00030Ý\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Þ\u0001R\u0017\u0010ß\u0001\u001a\u0005\u0018\u00010à\u00018F¢\u0006\b\u001a\u0006\bá\u0001\u0010â\u0001R\u0017\u0010ã\u0001\u001a\u0005\u0018\u00010ä\u00018F¢\u0006\b\u001a\u0006\bå\u0001\u0010æ\u0001R\u0017\u0010ç\u0001\u001a\u0005\u0018\u00010è\u00018F¢\u0006\b\u001a\u0006\bé\u0001\u0010ê\u0001R\u0017\u0010ë\u0001\u001a\u0005\u0018\u00010ì\u00018F¢\u0006\b\u001a\u0006\bí\u0001\u0010î\u0001R\u0017\u0010ï\u0001\u001a\u0005\u0018\u00010ð\u00018F¢\u0006\b\u001a\u0006\bñ\u0001\u0010ò\u0001¨\u0006ÿ\u0001"}, m5598d2 = {"Lcom/bat/sdk/BatSdk;", "", "<init>", "()V", "value", "", "isInitialized", "()Z", "firmwareManager", "Lcom/bat/sdk/FirmwareManager;", "getFirmwareManager", "()Lcom/bat/sdk/FirmwareManager;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "getGattManager", "()Lcom/bat/sdk/ble/GattManager;", "scanner", "Lcom/bat/sdk/ble/BatScanner;", "getScanner", "()Lcom/bat/sdk/ble/BatScanner;", "bonding", "Lcom/bat/sdk/ble/Bonding;", "getBonding", "()Lcom/bat/sdk/ble/Bonding;", "companionDeviceManager", "Lcom/bat/sdk/ble/companionApp/BatCompanionDeviceManager;", "getCompanionDeviceManager", "()Lcom/bat/sdk/ble/companionApp/BatCompanionDeviceManager;", "deviceInfoClient", "Lcom/bat/sdk/client/DeviceInfoClient;", "getDeviceInfoClient", "()Lcom/bat/sdk/client/DeviceInfoClient;", "batteryClient", "Lcom/bat/sdk/client/BatteryClient;", "getBatteryClient", "()Lcom/bat/sdk/client/BatteryClient;", "usageReminderClient", "Lcom/bat/sdk/client/UsageReminderClient;", "getUsageReminderClient", "()Lcom/bat/sdk/client/UsageReminderClient;", "cloudClient", "Lcom/bat/sdk/client/CloudClient;", "getCloudClient", "()Lcom/bat/sdk/client/CloudClient;", "powerSaveModeClient", "Lcom/bat/sdk/client/PowerSaveModeClient;", "getPowerSaveModeClient", "()Lcom/bat/sdk/client/PowerSaveModeClient;", "errorClient", "Lcom/bat/sdk/client/ErrorClient;", "getErrorClient", "()Lcom/bat/sdk/client/ErrorClient;", "findVapeClient", "Lcom/bat/sdk/client/FindVapeClient;", "getFindVapeClient", "()Lcom/bat/sdk/client/FindVapeClient;", "hapticClient", "Lcom/bat/sdk/client/HapticClient;", "getHapticClient", "()Lcom/bat/sdk/client/HapticClient;", "ledClient", "Lcom/bat/sdk/client/LedClient;", "getLedClient", "()Lcom/bat/sdk/client/LedClient;", "lockClient", "Lcom/bat/sdk/client/LockClient;", "getLockClient", "()Lcom/bat/sdk/client/LockClient;", "buzzerClient", "Lcom/bat/sdk/client/BuzzerClient;", "getBuzzerClient", "()Lcom/bat/sdk/client/BuzzerClient;", "podConnectionClient", "Lcom/bat/sdk/client/PodConnectionClient;", "getPodConnectionClient", "()Lcom/bat/sdk/client/PodConnectionClient;", "logsClient", "Lcom/bat/sdk/client/LogsClient;", "getLogsClient", "()Lcom/bat/sdk/client/LogsClient;", "puffsClient", "Lcom/bat/sdk/client/PuffsClient;", "getPuffsClient", "()Lcom/bat/sdk/client/PuffsClient;", "timeClient", "Lcom/bat/sdk/client/TimeClient;", "getTimeClient", "()Lcom/bat/sdk/client/TimeClient;", "resetClient", "Lcom/bat/sdk/client/ResetClient;", "getResetClient", "()Lcom/bat/sdk/client/ResetClient;", "sessionIndicationClient", "Lcom/bat/sdk/client/SessionIndicationClient;", "getSessionIndicationClient", "()Lcom/bat/sdk/client/SessionIndicationClient;", "otaNewClient", "Lcom/bat/sdk/client/ota/OtaNewClient;", "getOtaNewClient", "()Lcom/bat/sdk/client/ota/OtaNewClient;", "payloadUploader", "Lcom/bat/sdk/payload/PayloadUploader;", "getPayloadUploader", "()Lcom/bat/sdk/payload/PayloadUploader;", "fotaUploader", "Lcom/bat/sdk/fota/FotaUploader;", "getFotaUploader", "()Lcom/bat/sdk/fota/FotaUploader;", "ageChallengeClient", "Lcom/bat/sdk/client/AgeChallengeClient;", "getAgeChallengeClient", "()Lcom/bat/sdk/client/AgeChallengeClient;", "ageSignatureClient", "Lcom/bat/sdk/client/AgeSignatureClient;", "getAgeSignatureClient", "()Lcom/bat/sdk/client/AgeSignatureClient;", "ageVerifier", "Lcom/bat/sdk/age/AgeVerifier;", "getAgeVerifier", "()Lcom/bat/sdk/age/AgeVerifier;", "deviceControlClient", "Lcom/bat/sdk/client/epen/DeviceControlClient;", "getDeviceControlClient", "()Lcom/bat/sdk/client/epen/DeviceControlClient;", "ePenSynchronizer", "Lcom/bat/sdk/sync/EpenPuffsSynchronizer;", "getEPenSynchronizer", "()Lcom/bat/sdk/sync/EpenPuffsSynchronizer;", "asavModule", "Lcom/bat/sdk/asav/AsavModule;", "getAsavModule", "()Lcom/bat/sdk/asav/AsavModule;", "bleTimeoutClient", "Lcom/bat/sdk/client/BleTimeoutClient;", "getBleTimeoutClient", "()Lcom/bat/sdk/client/BleTimeoutClient;", "payloadVersionClient", "Lcom/bat/sdk/client/payload/PayloadVersionClient;", "getPayloadVersionClient", "()Lcom/bat/sdk/client/payload/PayloadVersionClient;", "payloadControlClient", "Lcom/bat/sdk/client/payload/PayloadControlClient;", "getPayloadControlClient", "()Lcom/bat/sdk/client/payload/PayloadControlClient;", "payloadClient", "Lcom/bat/sdk/client/payload/PayloadClient;", "getPayloadClient", "()Lcom/bat/sdk/client/payload/PayloadClient;", "payloadChallengeClient", "Lcom/bat/sdk/client/payload/PayloadChallengeClient;", "getPayloadChallengeClient", "()Lcom/bat/sdk/client/payload/PayloadChallengeClient;", "btProximityUnlock", "Lcom/bat/sdk/ble/BtProximityUnlock;", "getBtProximityUnlock", "()Lcom/bat/sdk/ble/BtProximityUnlock;", "rechargeRemindersClient", "Lcom/bat/sdk/client/RechargeRemindersClient;", "getRechargeRemindersClient", "()Lcom/bat/sdk/client/RechargeRemindersClient;", "timeoutAutoLockClient", "Lcom/bat/sdk/client/TimeoutAutoLockClient;", "getTimeoutAutoLockClient", "()Lcom/bat/sdk/client/TimeoutAutoLockClient;", "authenticationErrorInterceptor", "Lcom/bat/sdk/remote/AuthenticationErrorInterceptor;", "getAuthenticationErrorInterceptor", "()Lcom/bat/sdk/remote/AuthenticationErrorInterceptor;", "checkDeviceTimeUnix", "deviceTimeUnix", "", "getDeviceTimeUnix", "()Ljava/lang/Long;", "setDeviceTimeUnix", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "deviceTimeObj", "Lcom/bat/sdk/model/DeviceTime;", "getDeviceTimeObj", "()Lcom/bat/sdk/model/DeviceTime;", "setDeviceTimeObj", "(Lcom/bat/sdk/model/DeviceTime;)V", "monitoringRssi", "getMonitoringRssi", "setMonitoringRssi", "(Z)V", "address", "", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "currentDeviceTypeStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bat/sdk/model/DeviceType;", "getCurrentDeviceTypeStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "settingsManager", "Lcom/bat/sdk/persistence/SettingsManager;", "getSettingsManager", "()Lcom/bat/sdk/persistence/SettingsManager;", "setSettingsManager", "(Lcom/bat/sdk/persistence/SettingsManager;)V", "koin", "Lorg/koin/core/Koin;", "getKoin$sdk_release", "()Lorg/koin/core/Koin;", "setKoin$sdk_release", "(Lorg/koin/core/Koin;)V", "logger", "Lcom/bat/sdk/logging/Logger;", "getLogger", "()Lcom/bat/sdk/logging/Logger;", "gattProcessingJob", "Lkotlinx/coroutines/Job;", "servicesObservationJob", "rssiJob", "connectionGuardJob", "setDeviceTimeAtReconnection", "collectDevicesPuffs", "bluetoothReceiver", "com/bat/sdk/BatSdk$bluetoothReceiver$1", "Lcom/bat/sdk/BatSdk$bluetoothReceiver$1;", "errorsRepository", "Lcom/bat/sdk/persistence/repository/ErrorRecordRepository;", "getErrorsRepository", "()Lcom/bat/sdk/persistence/repository/ErrorRecordRepository;", "logsRepository", "Lcom/bat/sdk/persistence/repository/LogRecordRepository;", "getLogsRepository", "()Lcom/bat/sdk/persistence/repository/LogRecordRepository;", "puffsRepository", "Lcom/bat/sdk/persistence/repository/PuffRecordRepository;", "getPuffsRepository", "()Lcom/bat/sdk/persistence/repository/PuffRecordRepository;", "batDevicesRepository", "Lcom/bat/sdk/persistence/repository/BatDevicesRepository;", "getBatDevicesRepository", "()Lcom/bat/sdk/persistence/repository/BatDevicesRepository;", "sdkLogsRepository", "Lcom/bat/sdk/persistence/repository/SdkLogRepository;", "getSdkLogsRepository", "()Lcom/bat/sdk/persistence/repository/SdkLogRepository;", "createRawClientFor", "Lcom/bat/sdk/client/RawClient;", "characteristicUuids", "", "([Ljava/lang/String;)Lcom/bat/sdk/client/RawClient;", "initialize", "", "context", "Landroid/content/Context;", "configuration", "Lcom/bat/sdk/domain/Configuration;", "dispose", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class BatSdk {
    private static String address;
    private static boolean checkDeviceTimeUnix;
    private static Job collectDevicesPuffs;
    private static Job connectionGuardJob;
    private static DeviceTime deviceTimeObj;
    private static Long deviceTimeUnix;
    private static Job gattProcessingJob;
    private static Job getDeviceTimeUnix;
    private static boolean isInitialized;
    private static Koin koin;
    private static boolean monitoringRssi;
    private static Job rssiJob;
    private static Job servicesObservationJob;
    private static Job setDeviceTimeAtReconnection;
    public static SettingsManager settingsManager;
    public static final BatSdk INSTANCE = new BatSdk();
    private static final MutableStateFlow<DeviceType> currentDeviceTypeStateFlow = StateFlowKt.MutableStateFlow(DeviceType.Unknown.INSTANCE);
    private static final BatSdk$bluetoothReceiver$1 bluetoothReceiver = new BroadcastReceiver() { // from class: com.bat.sdk.BatSdk$bluetoothReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent == null || (action = intent.getAction()) == null || !Intrinsics.areEqual(action, "android.bluetooth.adapter.action.STATE_CHANGED") || intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) != 13) {
                return;
            }
            Logger logger = Logger.INSTANCE;
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            logger.log(name, "BluetoothAdapter.ACTION_STATE_CHANGED was changed to STATE_TURNING_OFF, forcing manual disconnection...");
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new BatSdk$bluetoothReceiver$1$onReceive$1(null), 3, null);
        }
    };

    private BatSdk() {
    }

    public final boolean isInitialized() {
        return isInitialized;
    }

    public final FirmwareManager getFirmwareManager() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (FirmwareManager) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(FirmwareManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final GattManager getGattManager() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (GattManager) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(GattManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final BatScanner getScanner() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (BatScanner) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(BatScanner.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final Bonding getBonding() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (Bonding) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(Bonding.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final BatCompanionDeviceManager getCompanionDeviceManager() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (BatCompanionDeviceManager) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(BatCompanionDeviceManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final DeviceInfoClient getDeviceInfoClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (DeviceInfoClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(DeviceInfoClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final BatteryClient getBatteryClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (BatteryClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(BatteryClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final UsageReminderClient getUsageReminderClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (UsageReminderClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(UsageReminderClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final CloudClient getCloudClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (CloudClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(CloudClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final PowerSaveModeClient getPowerSaveModeClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (PowerSaveModeClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(PowerSaveModeClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final ErrorClient getErrorClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (ErrorClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(ErrorClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final FindVapeClient getFindVapeClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (FindVapeClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(FindVapeClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final HapticClient getHapticClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (HapticClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(HapticClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final LedClient getLedClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (LedClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(LedClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final LockClient getLockClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (LockClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(LockClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final BuzzerClient getBuzzerClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (BuzzerClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(BuzzerClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final PodConnectionClient getPodConnectionClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (PodConnectionClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(PodConnectionClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final LogsClient getLogsClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (LogsClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(LogsClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final PuffsClient getPuffsClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (PuffsClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(PuffsClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final TimeClient getTimeClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (TimeClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(TimeClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final ResetClient getResetClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (ResetClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(ResetClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final SessionIndicationClient getSessionIndicationClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (SessionIndicationClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(SessionIndicationClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final OtaNewClient getOtaNewClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (OtaNewClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(OtaNewClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final PayloadUploader getPayloadUploader() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (PayloadUploader) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(PayloadUploader.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final FotaUploader getFotaUploader() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (FotaUploader) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(FotaUploader.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final AgeChallengeClient getAgeChallengeClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (AgeChallengeClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(AgeChallengeClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final AgeSignatureClient getAgeSignatureClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (AgeSignatureClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(AgeSignatureClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final AgeVerifier getAgeVerifier() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (AgeVerifier) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(AgeVerifier.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final DeviceControlClient getDeviceControlClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (DeviceControlClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(DeviceControlClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final EpenPuffsSynchronizer getEPenSynchronizer() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (EpenPuffsSynchronizer) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(EpenPuffsSynchronizer.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final AsavModule getAsavModule() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (AsavModule) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(AsavModule.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final BleTimeoutClient getBleTimeoutClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (BleTimeoutClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(BleTimeoutClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final PayloadVersionClient getPayloadVersionClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (PayloadVersionClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(PayloadVersionClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final PayloadControlClient getPayloadControlClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (PayloadControlClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(PayloadControlClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final PayloadClient getPayloadClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (PayloadClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(PayloadClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final PayloadChallengeClient getPayloadChallengeClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (PayloadChallengeClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(PayloadChallengeClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final BtProximityUnlock getBtProximityUnlock() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (BtProximityUnlock) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(BtProximityUnlock.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final RechargeRemindersClient getRechargeRemindersClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (RechargeRemindersClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(RechargeRemindersClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final TimeoutAutoLockClient getTimeoutAutoLockClient() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (TimeoutAutoLockClient) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(TimeoutAutoLockClient.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final AuthenticationErrorInterceptor getAuthenticationErrorInterceptor() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (AuthenticationErrorInterceptor) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(AuthenticationErrorInterceptor.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final Long getDeviceTimeUnix() {
        return deviceTimeUnix;
    }

    public final void setDeviceTimeUnix(Long l) {
        deviceTimeUnix = l;
    }

    public final DeviceTime getDeviceTimeObj() {
        return deviceTimeObj;
    }

    public final void setDeviceTimeObj(DeviceTime deviceTime) {
        deviceTimeObj = deviceTime;
    }

    public final boolean getMonitoringRssi() {
        return monitoringRssi;
    }

    public final void setMonitoringRssi(boolean z) {
        monitoringRssi = z;
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(String str) {
        address = str;
    }

    public final MutableStateFlow<DeviceType> getCurrentDeviceTypeStateFlow() {
        return currentDeviceTypeStateFlow;
    }

    public final SettingsManager getSettingsManager() {
        SettingsManager settingsManager2 = settingsManager;
        if (settingsManager2 != null) {
            return settingsManager2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("settingsManager");
        return null;
    }

    public final void setSettingsManager(SettingsManager settingsManager2) {
        Intrinsics.checkNotNullParameter(settingsManager2, "<set-?>");
        settingsManager = settingsManager2;
    }

    public final Koin getKoin$sdk_release() {
        return koin;
    }

    public final void setKoin$sdk_release(Koin koin2) {
        koin = koin2;
    }

    public final Logger getLogger() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (Logger) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(Logger.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final ErrorRecordRepository getErrorsRepository() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (ErrorRecordRepository) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(ErrorRecordRepository.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final LogRecordRepository getLogsRepository() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (LogRecordRepository) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(LogRecordRepository.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final PuffRecordRepository getPuffsRepository() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (PuffRecordRepository) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(PuffRecordRepository.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final BatDevicesRepository getBatDevicesRepository() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (BatDevicesRepository) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(BatDevicesRepository.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final SdkLogRepository getSdkLogsRepository() {
        Koin koin2 = koin;
        if (koin2 != null) {
            return (SdkLogRepository) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(SdkLogRepository.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        }
        return null;
    }

    public final RawClient createRawClientFor(String... characteristicUuids) {
        Intrinsics.checkNotNullParameter(characteristicUuids, "characteristicUuids");
        GattManager gattManager = getGattManager();
        Intrinsics.checkNotNull(gattManager);
        return new RawClient(gattManager, ArraysKt.toList(characteristicUuids));
    }

    public final void initialize(final Context context, Configuration configuration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (isInitialized) {
            return;
        }
        isInitialized = true;
        Koin koin2 = ContextFunctionsKt.startKoin$default((KoinContext) null, new Function1() { // from class: com.bat.sdk.BatSdk$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BatSdk.initialize$lambda$0(context, (KoinApplication) obj);
            }
        }, 1, (Object) null).getKoin();
        koin = koin2;
        if (koin2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        setSettingsManager((SettingsManager) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(SettingsManager.class), (Qualifier) null, (Function0<DefinitionParameters>) null));
        getSettingsManager().applyConfiguration(configuration);
        SdkLogRepository sdkLogsRepository = getSdkLogsRepository();
        if (sdkLogsRepository != null) {
            sdkLogsRepository.setSaveLogs(configuration.getSaveLogs());
        }
        gattProcessingJob = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new C14782(null), 2, null);
        rssiJob = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new C14793(null), 2, null);
        if (configuration.getKeepLastConnectionAliva()) {
            connectionGuardJob = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new C14804(null), 2, null);
        }
        setDeviceTimeAtReconnection = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), null, new C14815(null), 2, null);
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        if (Build.VERSION.SDK_INT > 33) {
            context.registerReceiver(bluetoothReceiver, intentFilter, 4);
        } else {
            context.registerReceiver(bluetoothReceiver, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialize$lambda$0(Context context, KoinApplication startKoin) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(startKoin, "$this$startKoin");
        KoinExtKt.androidContext(startKoin, context);
        startKoin.modules(KoinModules.INSTANCE.sdkModule());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.bat.sdk.BatSdk$initialize$2 */
    /* JADX INFO: compiled from: BatSdk.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.BatSdk$initialize$2", m5608f = "BatSdk.kt", m5609i = {0, 0}, m5610l = {336}, m5611m = "invokeSuspend", m5612n = {"$this$launch", "gattManager"}, m5613s = {"L$0", "L$1"})
    static final class C14782 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C14782(Continuation<? super C14782> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14782 c14782 = new C14782(continuation);
            c14782.L$0 = obj;
            return c14782;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14782) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x003e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003c -> B:12:0x003f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 10
                r4 = 1
                if (r1 == 0) goto L21
                if (r1 != r4) goto L19
                java.lang.Object r1 = r8.L$1
                com.bat.sdk.ble.GattManager r1 = (com.bat.sdk.ble.GattManager) r1
                java.lang.Object r5 = r8.L$0
                kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                kotlin.ResultKt.throwOnFailure(r9)
                goto L3f
            L19:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L21:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.Object r9 = r8.L$0
                kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
                com.bat.sdk.BatSdk r1 = com.bat.sdk.BatSdk.INSTANCE
                com.bat.sdk.ble.GattManager r1 = r1.getGattManager()
                r5 = r9
            L2f:
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r8.L$0 = r5
                r8.L$1 = r1
                r8.label = r4
                java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r2, r9)
                if (r9 != r0) goto L3f
                return r0
            L3f:
                if (r1 == 0) goto L2f
                r1.process(r2)     // Catch: android.os.DeadObjectException -> L45
                goto L2f
            L45:
                if (r1 == 0) goto L4a
                r1.disconnectAll()
            L4a:
                com.bat.sdk.logging.Logger r9 = com.bat.sdk.logging.Logger.INSTANCE
                java.lang.Class r6 = r5.getClass()
                java.lang.String r6 = r6.getName()
                java.lang.String r7 = "getName(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                java.lang.String r7 = "DeadObjectException -> disconnecting all devices"
                r9.log(r6, r7)
                goto L2f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.BatSdk.C14782.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.bat.sdk.BatSdk$initialize$3 */
    /* JADX INFO: compiled from: BatSdk.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.BatSdk$initialize$3", m5608f = "BatSdk.kt", m5609i = {0}, m5610l = {364}, m5611m = "invokeSuspend", m5612n = {"gattManager"}, m5613s = {"L$0"})
    static final class C14793 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C14793(Continuation<? super C14793> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C14793(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14793) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0034 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0032 -> B:12:0x0035). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r7.L$0
                com.bat.sdk.ble.GattManager r1 = (com.bat.sdk.ble.GattManager) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L35
            L13:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1b:
                kotlin.ResultKt.throwOnFailure(r8)
                com.bat.sdk.BatSdk r8 = com.bat.sdk.BatSdk.INSTANCE
                com.bat.sdk.ble.GattManager r8 = r8.getGattManager()
                r1 = r8
            L25:
                r8 = r7
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r7.L$0 = r1
                r7.label = r2
                r3 = 10000(0x2710, double:4.9407E-320)
                java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r3, r8)
                if (r8 != r0) goto L35
                return r0
            L35:
                com.bat.sdk.BatSdk r8 = com.bat.sdk.BatSdk.INSTANCE
                boolean r8 = r8.getMonitoringRssi()
                if (r8 != 0) goto L40
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            L40:
                if (r1 == 0) goto L25
                kotlinx.coroutines.flow.StateFlow r8 = r1.getDevices()
                if (r8 == 0) goto L25
                java.lang.Object r8 = r8.getValue()
                java.util.List r8 = (java.util.List) r8
                if (r8 == 0) goto L25
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                java.util.Iterator r8 = r8.iterator()
            L56:
                boolean r3 = r8.hasNext()
                if (r3 == 0) goto L25
                java.lang.Object r3 = r8.next()
                com.bat.sdk.ble.BleDeviceData r3 = (com.bat.sdk.ble.BleDeviceData) r3
                com.bat.sdk.ble.ConnectionState r4 = r3.getConnectionState()
                boolean r4 = r4 instanceof com.bat.sdk.ble.ConnectionState.Connected
                if (r4 == 0) goto L56
                com.bat.sdk.ble.BleRequest$ReadRssi r4 = new com.bat.sdk.ble.BleRequest$ReadRssi
                java.lang.String r3 = r3.getAddress()
                r5 = 2000(0x7d0, double:9.88E-321)
                r4.<init>(r3, r5)
                com.bat.sdk.ble.BleRequest r4 = (com.bat.sdk.ble.BleRequest) r4
                r1.enqueue(r4)
                goto L56
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.BatSdk.C14793.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.bat.sdk.BatSdk$initialize$4 */
    /* JADX INFO: compiled from: BatSdk.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.BatSdk$initialize$4", m5608f = "BatSdk.kt", m5609i = {0}, m5610l = {426}, m5611m = "invokeSuspend", m5612n = {"gattManager"}, m5613s = {"L$0"})
    static final class C14804 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C14804(Continuation<? super C14804> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C14804(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14804) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0034 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0032 -> B:12:0x0035). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r7.L$0
                com.bat.sdk.ble.GattManager r1 = (com.bat.sdk.ble.GattManager) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L35
            L13:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1b:
                kotlin.ResultKt.throwOnFailure(r8)
                com.bat.sdk.BatSdk r8 = com.bat.sdk.BatSdk.INSTANCE
                com.bat.sdk.ble.GattManager r8 = r8.getGattManager()
                r1 = r8
            L25:
                r8 = r7
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r7.L$0 = r1
                r7.label = r2
                r3 = 10000(0x2710, double:4.9407E-320)
                java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r3, r8)
                if (r8 != r0) goto L35
                return r0
            L35:
                if (r1 == 0) goto L25
                kotlinx.coroutines.flow.StateFlow r8 = r1.getDevices()
                if (r8 == 0) goto L25
                java.lang.Object r8 = r8.getValue()
                java.util.List r8 = (java.util.List) r8
                if (r8 == 0) goto L25
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                java.util.Iterator r8 = r8.iterator()
            L4b:
                boolean r3 = r8.hasNext()
                if (r3 == 0) goto L25
                java.lang.Object r3 = r8.next()
                com.bat.sdk.ble.BleDeviceData r3 = (com.bat.sdk.ble.BleDeviceData) r3
                java.lang.String r4 = r3.getAddress()
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                int r4 = r4.length()
                if (r4 != 0) goto L64
                goto L4b
            L64:
                com.bat.sdk.ble.ConnectionState r4 = r3.getConnectionState()
                com.bat.sdk.ble.ConnectionState$Disconnected r5 = com.bat.sdk.ble.ConnectionState.Disconnected.INSTANCE
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
                if (r4 == 0) goto L4b
                com.bat.sdk.logging.Logger r4 = com.bat.sdk.logging.Logger.INSTANCE
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                java.lang.String r6 = "keep connection: reconnecting "
                r5.<init>(r6)
                java.lang.String r6 = r3.getAddress()
                java.lang.StringBuilder r5 = r5.append(r6)
                java.lang.String r5 = r5.toString()
                r4.log(r5)
                java.lang.String r3 = r3.getAddress()
                r4 = 2
                r5 = 0
                r6 = 0
                com.bat.sdk.ble.GattManager.connect$default(r1, r3, r6, r4, r5)
                goto L4b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.BatSdk.C14804.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.bat.sdk.BatSdk$initialize$5 */
    /* JADX INFO: compiled from: BatSdk.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.BatSdk$initialize$5", m5608f = "BatSdk.kt", m5609i = {}, m5610l = {445}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14815 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C14815(Continuation<? super C14815> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C14815(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14815) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SharedFlow<BleDeviceData> connectedDevice;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                ArrayList arrayList = new ArrayList();
                GattManager gattManager = BatSdk.INSTANCE.getGattManager();
                if (gattManager == null || (connectedDevice = gattManager.getConnectedDevice()) == null) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                if (connectedDevice.collect(new AnonymousClass1(linkedHashMap, arrayList), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }

        /* JADX INFO: renamed from: com.bat.sdk.BatSdk$initialize$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: BatSdk.kt */
        @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ List<String> $devicesInSync;
            final /* synthetic */ Map<String, Function1<String, Unit>> $setDeviceTimeFunctions;

            AnonymousClass1(Map<String, Function1<String, Unit>> map, List<String> list) {
                this.$setDeviceTimeFunctions = map;
                this.$devicesInSync = list;
            }

            /* JADX WARN: Removed duplicated region for block: B:29:0x00f8  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0105  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.bat.sdk.ble.BleDeviceData r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
                /*
                    Method dump skipped, instruction units count: 294
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.BatSdk.C14815.AnonymousClass1.emit(com.bat.sdk.ble.BleDeviceData, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((BleDeviceData) obj, (Continuation<? super Unit>) continuation);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit emit$lambda$0(Ref.ObjectRef actualDeviceTime, String it2) {
                Intrinsics.checkNotNullParameter(actualDeviceTime, "$actualDeviceTime");
                Intrinsics.checkNotNullParameter(it2, "it");
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new BatSdk$initialize$5$1$1$1(actualDeviceTime, it2, null), 3, null);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.bat.sdk.BatSdk$initialize$5$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: BatSdk.kt */
            @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
            @DebugMetadata(m5607c = "com.bat.sdk.BatSdk$initialize$5$1$3", m5608f = "BatSdk.kt", m5609i = {}, m5610l = {475}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
            static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ List<String> $devicesInSync;
                final /* synthetic */ Map<String, Function1<String, Unit>> $setDeviceTimeFunctions;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(List<String> list, Map<String, Function1<String, Unit>> map, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.$devicesInSync = list;
                    this.$setDeviceTimeFunctions = map;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.$devicesInSync, this.$setDeviceTimeFunctions, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Flow<CharacteristicClient<PuffRequest, PuffRecord>.Response> flow;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Logger logger = Logger.INSTANCE;
                        StringBuilder sb = new StringBuilder("[Deb] collect puffs launched ");
                        PuffsClient puffsClient = BatSdk.INSTANCE.getPuffsClient();
                        logger.log(sb.append((puffsClient != null ? puffsClient.getFlow() : null) == null).toString());
                        PuffsClient puffsClient2 = BatSdk.INSTANCE.getPuffsClient();
                        if (puffsClient2 != null && (flow = puffsClient2.getFlow()) != null) {
                            final List<String> list = this.$devicesInSync;
                            final Map<String, Function1<String, Unit>> map = this.$setDeviceTimeFunctions;
                            this.label = 1;
                            if (flow.collect(new FlowCollector() { // from class: com.bat.sdk.BatSdk.initialize.5.1.3.1
                                @Override // kotlinx.coroutines.flow.FlowCollector
                                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                                    return emit((CharacteristicClient<PuffRequest, PuffRecord>.Response) obj2, (Continuation<? super Unit>) continuation);
                                }

                                public final Object emit(CharacteristicClient<PuffRequest, PuffRecord>.Response response, Continuation<? super Unit> continuation) {
                                    PuffRecord data = response.getData();
                                    if (data instanceof PuffRecord.StartOfFile) {
                                        list.add(response.getDeviceAddress());
                                        Logger.INSTANCE.log("[Deb] Received start of file for address " + response.getDeviceAddress() + " calling debounced function");
                                        Function1<String, Unit> function1 = map.get(response.getDeviceAddress());
                                        if (function1 != null) {
                                            function1.invoke(response.getDeviceAddress());
                                        }
                                    } else if ((data instanceof PuffRecord.Data) || (data instanceof PuffRecord.DataList)) {
                                        if (list.contains(response.getDeviceAddress())) {
                                            Logger.INSTANCE.log("[Deb] Received Data for address " + response.getDeviceAddress() + " in history mode so calling debounced function");
                                            Function1<String, Unit> function12 = map.get(response.getDeviceAddress());
                                            if (function12 != null) {
                                                function12.invoke(response.getDeviceAddress());
                                            }
                                        }
                                    } else if (data instanceof PuffRecord.EndOfFile) {
                                        Logger.INSTANCE.log("[Deb] Received end of file for address " + response.getDeviceAddress() + " so removing it from history mode");
                                        list.remove(response.getDeviceAddress());
                                    } else if (data != null) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        }
    }

    public final void dispose() {
        Context context;
        Context applicationContext;
        if (isInitialized) {
            Koin koin2 = koin;
            if (koin2 != null && (context = (Context) koin2.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<DefinitionParameters>) null)) != null && (applicationContext = context.getApplicationContext()) != null) {
                applicationContext.unregisterReceiver(bluetoothReceiver);
            }
            ContextFunctionsKt.stopKoin();
            koin = null;
            isInitialized = false;
            Job job = gattProcessingJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            gattProcessingJob = null;
            Job job2 = servicesObservationJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            servicesObservationJob = null;
            Job job3 = rssiJob;
            if (job3 != null) {
                Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
            }
            rssiJob = null;
            Job job4 = setDeviceTimeAtReconnection;
            if (job4 != null) {
                Job.DefaultImpls.cancel$default(job4, (CancellationException) null, 1, (Object) null);
            }
            setDeviceTimeAtReconnection = null;
            Job job5 = collectDevicesPuffs;
            if (job5 != null) {
                Job.DefaultImpls.cancel$default(job5, (CancellationException) null, 1, (Object) null);
            }
            collectDevicesPuffs = null;
        }
    }
}
