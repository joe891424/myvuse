package com.bat.myvuse.mobile.rncomponents.nodes;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.net.Uri;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.webkit.Profile;
import com.bat.sdk.BatSdk;
import com.bat.sdk.FirmwareManager;
import com.bat.sdk.age.AgeVerifier;
import com.bat.sdk.asav.AsavModule;
import com.bat.sdk.asav.core.AsavException;
import com.bat.sdk.asav.core.AsavSettings;
import com.bat.sdk.asav.response.IAsavResultListener;
import com.bat.sdk.ble.BatDevice;
import com.bat.sdk.ble.BatScanner;
import com.bat.sdk.ble.BatService;
import com.bat.sdk.ble.BleDeviceData;
import com.bat.sdk.ble.BondState;
import com.bat.sdk.ble.Bonding;
import com.bat.sdk.ble.BtProximityUnlock;
import com.bat.sdk.ble.ConnectionState;
import com.bat.sdk.ble.GattError;
import com.bat.sdk.ble.GattManager;
import com.bat.sdk.ble.advertising.DeviceAdvertisingData;
import com.bat.sdk.ble.companionApp.AssociationState;
import com.bat.sdk.ble.companionApp.BatCompanionDeviceManager;
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
import com.bat.sdk.client.RechargeRemindersClient;
import com.bat.sdk.client.ResetClient;
import com.bat.sdk.client.TimeClient;
import com.bat.sdk.client.TimeoutAutoLockClient;
import com.bat.sdk.client.UsageReminderClient;
import com.bat.sdk.domain.device.FirmwareInstallationState;
import com.bat.sdk.model.Battery;
import com.bat.sdk.model.Buzzer;
import com.bat.sdk.model.Cloud;
import com.bat.sdk.model.DeviceInfo;
import com.bat.sdk.model.DeviceTime;
import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.ErrorRecord;
import com.bat.sdk.model.FindVape;
import com.bat.sdk.model.Haptic;
import com.bat.sdk.model.Led;
import com.bat.sdk.model.LiquidInformation;
import com.bat.sdk.model.Lock;
import com.bat.sdk.model.LogRecord;
import com.bat.sdk.model.MssVersion;
import com.bat.sdk.model.PodConnection;
import com.bat.sdk.model.PodUid;
import com.bat.sdk.model.PowerSaveMode;
import com.bat.sdk.model.PuffRecord;
import com.bat.sdk.model.PuffRequest;
import com.bat.sdk.model.RechargeReminder;
import com.bat.sdk.model.UsageReminder;
import com.bat.sdk.payload.PayloadUploadState;
import com.bat.sdk.payload.PayloadUploader;
import com.bat.sdk.persistence.SettingsManager;
import com.bat.sdk.persistence.repository.BatDevicesRepository;
import com.bat.sdk.persistence.repository.PuffRecordRepository;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.api.common.CarrierType;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import com.yoti.mobile.android.common.p049ui.widgets.date.entry.DatesArrayBuilder;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import javax.inject.Inject;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: NodesModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bÿ\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020)\u0012\u0006\u0010*\u001a\u00020+\u0012\u0006\u0010,\u001a\u00020-\u0012\u0006\u0010.\u001a\u00020/\u0012\u0006\u00100\u001a\u000201\u0012\u0006\u00102\u001a\u000203\u0012\u0006\u00104\u001a\u000205\u0012\u0006\u00106\u001a\u000207\u0012\u0006\u00108\u001a\u000209\u0012\u0006\u0010:\u001a\u00020;\u0012\u0006\u0010<\u001a\u00020=\u0012\u0006\u0010>\u001a\u00020?¢\u0006\u0002\u0010@J&\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020B2\u0006\u0010R\u001a\u00020B2\u0006\u0010S\u001a\u00020B2\u0006\u0010T\u001a\u00020BJ\u0016\u0010U\u001a\u00020P2\u0006\u0010V\u001a\u00020BH\u0086@¢\u0006\u0002\u0010WJ\u000e\u0010X\u001a\u00020PH\u0086@¢\u0006\u0002\u0010YJ \u0010Z\u001a\u00020P2\u0006\u0010[\u001a\u00020B2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\"\u0010_\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\b\b\u0002\u0010`\u001a\u00020a2\u0006\u0010]\u001a\u00020^H\u0007J\u0010\u0010b\u001a\u00020P2\u0006\u0010\\\u001a\u00020BH\u0007J\b\u0010c\u001a\u00020PH\u0007J0\u0010d\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010e\u001a\u00020B2\u0006\u0010S\u001a\u00020B2\u0006\u0010T\u001a\u00020B2\u0006\u0010f\u001a\u00020BH\u0007J\u0018\u0010g\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J(\u0010h\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010V\u001a\u00020B2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0007J\u0018\u0010l\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J \u0010m\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0007J\b\u0010n\u001a\u0004\u0018\u00010DJ\u0018\u0010o\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J \u0010p\u001a\u00020P2\u0006\u0010V\u001a\u00020B2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u0018\u0010q\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u0018\u0010r\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u0018\u0010s\u001a\u00020P2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0007J\u0018\u0010t\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u0018\u0010u\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J \u0010v\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010w\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u0018\u0010x\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\b\u0010y\u001a\u00020BH\u0016J\u0018\u0010z\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u0018\u0010{\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u0018\u0010|\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u0018\u0010}\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u0018\u0010~\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u0018\u0010\u007f\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u001b\u0010\u0080\u0001\u001a\u00020P2\u0007\u0010\u0081\u0001\u001a\u00020B2\u0007\u0010\u0082\u0001\u001a\u00020jH\u0007J\u0019\u0010\u0083\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u0019\u0010\u0084\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u0019\u0010\u0085\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J!\u0010\u0086\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0007J\u0019\u0010\u0087\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u0019\u0010\u0088\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u000f\u0010\u0089\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020BJ\u0019\u0010\u0089\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\"\u0010\u008a\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0007\u0010\u008b\u0001\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J2\u0010\u008c\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0007\u0010\u008d\u0001\u001a\u00020a2\u0006\u0010V\u001a\u00020B2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0007J*\u0010\u008e\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0007\u0010\u008f\u0001\u001a\u00020B2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0007J\"\u0010\u0090\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020a2\u0006\u0010]\u001a\u00020^H\u0007J\u001a\u0010\u0092\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0007\u0010\u0093\u0001\u001a\u00020aH\u0007J#\u0010\u0094\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0006\u0010]\u001a\u00020^H\u0007J#\u0010\u0097\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\b\u0010\u0098\u0001\u001a\u00030\u0096\u00012\u0006\u0010]\u001a\u00020^H\u0007J#\u0010\u0099\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\b\u0010\u009a\u0001\u001a\u00030\u0096\u00012\u0006\u0010]\u001a\u00020^H\u0007Jv\u0010\u009b\u0001\u001a\u00020P2\u0006\u0010V\u001a\u00020B2\u0006\u0010\\\u001a\u00020B2\b\u0010\u009c\u0001\u001a\u00030\u0096\u00012\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u0096\u00012\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u0096\u00012\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0096\u00012\t\u0010 \u0001\u001a\u0004\u0018\u00010a2\t\u0010¡\u0001\u001a\u0004\u0018\u00010a2\t\u0010¢\u0001\u001a\u0004\u0018\u00010a2\u0006\u0010]\u001a\u00020^H\u0007¢\u0006\u0003\u0010£\u0001J4\u0010¤\u0001\u001a\u00020P2\u0006\u0010V\u001a\u00020B2\u0006\u0010\\\u001a\u00020B2\u0007\u0010¥\u0001\u001a\u00020a2\b\u0010¦\u0001\u001a\u00030\u0096\u00012\u0006\u0010]\u001a\u00020^H\u0007J#\u0010§\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\b\u0010¨\u0001\u001a\u00030\u0096\u00012\u0006\u0010]\u001a\u00020^H\u0007J+\u0010©\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\b\u0010\u009c\u0001\u001a\u00030\u0096\u00012\u0006\u0010w\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J2\u0010ª\u0001\u001a\u00020P2\u0006\u0010V\u001a\u00020B2\u0006\u0010\\\u001a\u00020B2\u0007\u0010«\u0001\u001a\u00020a2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0007J,\u0010¬\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\b\u0010\u00ad\u0001\u001a\u00030\u0096\u00012\u0007\u0010®\u0001\u001a\u00020a2\u0006\u0010]\u001a\u00020^H\u0007J#\u0010¯\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\b\u0010\u0098\u0001\u001a\u00030\u0096\u00012\u0006\u0010]\u001a\u00020^H\u0007J#\u0010°\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\b\u0010±\u0001\u001a\u00030\u0096\u00012\u0006\u0010]\u001a\u00020^H\u0007J)\u0010²\u0001\u001a\u00020P2\u0006\u0010Q\u001a\u00020B2\u0006\u0010R\u001a\u00020B2\u0006\u0010S\u001a\u00020B2\u0006\u0010T\u001a\u00020BH\u0007J\"\u0010³\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0007\u0010´\u0001\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007JL\u0010µ\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0007\u0010¶\u0001\u001a\u00020B2\u0007\u0010·\u0001\u001a\u00020B2\u0006\u0010e\u001a\u00020B2\u0006\u0010S\u001a\u00020B2\u0006\u0010T\u001a\u00020B2\u0007\u0010¸\u0001\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J*\u0010¹\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0007\u0010º\u0001\u001a\u00020a2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0007J\u0019\u0010»\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020^H\u0007J\u0011\u0010¼\u0001\u001a\u00020P2\u0006\u0010V\u001a\u00020BH\u0007J\t\u0010½\u0001\u001a\u00020PH\u0007J\u0019\u0010¾\u0001\u001a\u00020P2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0007J!\u0010¿\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0007J\t\u0010À\u0001\u001a\u00020PH\u0007J!\u0010Á\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0007J!\u0010Â\u0001\u001a\u00020P2\u0006\u0010\\\u001a\u00020B2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020jH\u0007J:\u0010Ã\u0001\u001a\u00030Ä\u00012*\u0010Å\u0001\u001a\u0016\u0012\u0011\b\u0001\u0012\r\u0012\u0004\u0012\u00020B\u0012\u0002\b\u00030Ç\u00010Æ\u0001\"\r\u0012\u0004\u0012\u00020B\u0012\u0002\b\u00030Ç\u0001¢\u0006\u0003\u0010È\u0001R\u000e\u0010A\u001a\u00020BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010E\u001a&\u0012\f\u0012\n G*\u0004\u0018\u00010B0B G*\u0012\u0012\f\u0012\n G*\u0004\u0018\u00010B0B\u0018\u00010H0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010I\u001a\u00020B*\u00020J8F¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0015\u0010I\u001a\u00020B*\u00020M8F¢\u0006\u0006\u001a\u0004\bK\u0010N¨\u0006É\u0001"}, m5598d2 = {"Lcom/bat/myvuse/mobile/rncomponents/nodes/NodesModule;", "Lcom/bat/myvuse/mobile/rncomponents/nodes/NodesBaseModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "batteryClient", "Lcom/bat/sdk/client/BatteryClient;", "cloudClient", "Lcom/bat/sdk/client/CloudClient;", "deviceInfoClient", "Lcom/bat/sdk/client/DeviceInfoClient;", "errorClient", "Lcom/bat/sdk/client/ErrorClient;", "findVapeClient", "Lcom/bat/sdk/client/FindVapeClient;", "lockClient", "Lcom/bat/sdk/client/LockClient;", "puffsClient", "Lcom/bat/sdk/client/PuffsClient;", "logsClient", "Lcom/bat/sdk/client/LogsClient;", "timeClient", "Lcom/bat/sdk/client/TimeClient;", "scanner", "Lcom/bat/sdk/ble/BatScanner;", "gattManager", "Lcom/bat/sdk/ble/GattManager;", "puffsRepository", "Lcom/bat/sdk/persistence/repository/PuffRecordRepository;", "bonding", "Lcom/bat/sdk/ble/Bonding;", "batDevicesRepository", "Lcom/bat/sdk/persistence/repository/BatDevicesRepository;", "ageVerifier", "Lcom/bat/sdk/age/AgeVerifier;", "payloadUploader", "Lcom/bat/sdk/payload/PayloadUploader;", "ledClient", "Lcom/bat/sdk/client/LedClient;", "firmwareManager", "Lcom/bat/sdk/FirmwareManager;", "resetClient", "Lcom/bat/sdk/client/ResetClient;", "hapticClient", "Lcom/bat/sdk/client/HapticClient;", "asavModule", "Lcom/bat/sdk/asav/AsavModule;", "btProximityUnlock", "Lcom/bat/sdk/ble/BtProximityUnlock;", "settingsManager", "Lcom/bat/sdk/persistence/SettingsManager;", "podConnectionClient", "Lcom/bat/sdk/client/PodConnectionClient;", "powerSaveModeClient", "Lcom/bat/sdk/client/PowerSaveModeClient;", "buzzerClient", "Lcom/bat/sdk/client/BuzzerClient;", "rechargeRemindersClient", "Lcom/bat/sdk/client/RechargeRemindersClient;", "usageReminderClient", "Lcom/bat/sdk/client/UsageReminderClient;", "bleTimeoutClient", "Lcom/bat/sdk/client/BleTimeoutClient;", "timeoutAutoLockClient", "Lcom/bat/sdk/client/TimeoutAutoLockClient;", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/bat/sdk/client/BatteryClient;Lcom/bat/sdk/client/CloudClient;Lcom/bat/sdk/client/DeviceInfoClient;Lcom/bat/sdk/client/ErrorClient;Lcom/bat/sdk/client/FindVapeClient;Lcom/bat/sdk/client/LockClient;Lcom/bat/sdk/client/PuffsClient;Lcom/bat/sdk/client/LogsClient;Lcom/bat/sdk/client/TimeClient;Lcom/bat/sdk/ble/BatScanner;Lcom/bat/sdk/ble/GattManager;Lcom/bat/sdk/persistence/repository/PuffRecordRepository;Lcom/bat/sdk/ble/Bonding;Lcom/bat/sdk/persistence/repository/BatDevicesRepository;Lcom/bat/sdk/age/AgeVerifier;Lcom/bat/sdk/payload/PayloadUploader;Lcom/bat/sdk/client/LedClient;Lcom/bat/sdk/FirmwareManager;Lcom/bat/sdk/client/ResetClient;Lcom/bat/sdk/client/HapticClient;Lcom/bat/sdk/asav/AsavModule;Lcom/bat/sdk/ble/BtProximityUnlock;Lcom/bat/sdk/persistence/SettingsManager;Lcom/bat/sdk/client/PodConnectionClient;Lcom/bat/sdk/client/PowerSaveModeClient;Lcom/bat/sdk/client/BuzzerClient;Lcom/bat/sdk/client/RechargeRemindersClient;Lcom/bat/sdk/client/UsageReminderClient;Lcom/bat/sdk/client/BleTimeoutClient;Lcom/bat/sdk/client/TimeoutAutoLockClient;)V", "TAG", "", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "historyModeDevices", "", "kotlin.jvm.PlatformType", "", "displayName", "Lcom/bat/sdk/ble/BondState;", "getDisplayName", "(Lcom/bat/sdk/ble/BondState;)Ljava/lang/String;", "Lcom/bat/sdk/ble/ConnectionState;", "(Lcom/bat/sdk/ble/ConnectionState;)Ljava/lang/String;", "_startAsav", "", "signerBaseUrl", "signerUrl", AnalyticsAttribute.USER_ID_ATTRIBUTE, "token", "_startScanner", "ePodType", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "_stopAsav", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bondDevice", "deviceName", "deviceAddress", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "connect", "skipCheck", "", "disconnect", "disconnectAll", "doSecureAV", "url", "tenant", "getAdvertisingNameAvailable", "getAutoLockEnabled", "onSuccess", "Lcom/facebook/react/bridge/Callback;", "onError", "getBatteryInfo", "getBleTimeoutInfo", "getBluetoothAdapter", "getBuzzLevel", "getCloudInfo", "getDeviceInfo", "getDeviceMss", "getDeviceTime", "getHapticLevel", "getHistorySyncStatus", "getLed", "deviceType", "getLockInfo", "getName", "getPodData", "getRechargeRemindersData", "getRunCycle", "getUsageAlertType", "getUsageGoal", "isBackgroundSyncEnabled", "isDeviceAvailable", "addresses", "onResult", "isDeviceBonded", "isUASupported", "isVrrSupported", "lock", "previewBatteryAlert", "previewUsageAlert", "refreshCache", "setAdvertisingName", "advertisingName", "setAutoLockEnabled", Constants.ENABLE_DISABLE, "setAutolock", "bleTimeout", "setAutotune", "isActive", "setBackgroundSyncEnabled", ViewProps.ENABLED, "setBatteryAlertThreshold", "maxBatteryThr", "", "setBatteryAlertType", "alertType", "setBuzzLevel", ReactVideoViewManager.PROP_VOLUME, "setCloudInfo", FirebaseAnalytics.Param.LEVEL, "batterySavingEnabled", "batterySavingThresholdValue", "batterySavingPowerLevel", "batterySaverEnabled", "lowPowerMode", "powerSaveModeEnable", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/facebook/react/bridge/Promise;)V", "setFindVapeConfig", "isAlerting", "seconds", "setHapticLevel", "intensity", "setLed", "setLockInfo", "locked", "setRunCycle", "runCycle", "timezoneBoolean", "setUsageAlertType", "setUsageGoal", "usageGoal", "startAsav", "startFOTA", "uri", "startMarketEnable", "payloadCode", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "tenantId", "startProximityUnlock", "autoUnlock", "startReset", "startScanner", "stopAsav", "stopProximityUnlock", "stopProximityUnlockForAddress", "stopScanner", "unlock", "updateDeviceTime", "writableMapOf", "Lcom/facebook/react/bridge/WritableMap;", "values", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lcom/facebook/react/bridge/WritableMap;", "app_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class NodesModule extends NodesBaseModule {
    private String TAG;
    private final AgeVerifier ageVerifier;
    private final AsavModule asavModule;
    private final BatDevicesRepository batDevicesRepository;
    private final BatteryClient batteryClient;
    private final BleTimeoutClient bleTimeoutClient;
    private BluetoothAdapter bluetoothAdapter;
    private final Bonding bonding;
    private final BtProximityUnlock btProximityUnlock;
    private final BuzzerClient buzzerClient;
    private final CloudClient cloudClient;
    private final DeviceInfoClient deviceInfoClient;
    private final ErrorClient errorClient;
    private final FindVapeClient findVapeClient;
    private final FirmwareManager firmwareManager;
    private final GattManager gattManager;
    private final HapticClient hapticClient;
    private final Set<String> historyModeDevices;
    private final LedClient ledClient;
    private final LockClient lockClient;
    private final LogsClient logsClient;
    private final PayloadUploader payloadUploader;
    private final PodConnectionClient podConnectionClient;
    private final PowerSaveModeClient powerSaveModeClient;
    private final PuffsClient puffsClient;
    private final PuffRecordRepository puffsRepository;
    private final ReactApplicationContext reactContext;
    private final RechargeRemindersClient rechargeRemindersClient;
    private final ResetClient resetClient;
    private final BatScanner scanner;
    private final SettingsManager settingsManager;
    private final TimeClient timeClient;
    private final TimeoutAutoLockClient timeoutAutoLockClient;
    private final UsageReminderClient usageReminderClient;

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$_startScanner$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {1086}, m5611m = "_startScanner", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C14301 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14301(Continuation<? super C14301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NodesModule.this._startScanner(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NodesModule(ReactApplicationContext reactContext, BatteryClient batteryClient, CloudClient cloudClient, DeviceInfoClient deviceInfoClient, ErrorClient errorClient, FindVapeClient findVapeClient, LockClient lockClient, PuffsClient puffsClient, LogsClient logsClient, TimeClient timeClient, BatScanner scanner, GattManager gattManager, PuffRecordRepository puffsRepository, Bonding bonding, BatDevicesRepository batDevicesRepository, AgeVerifier ageVerifier, PayloadUploader payloadUploader, LedClient ledClient, FirmwareManager firmwareManager, ResetClient resetClient, HapticClient hapticClient, AsavModule asavModule, BtProximityUnlock btProximityUnlock, SettingsManager settingsManager, PodConnectionClient podConnectionClient, PowerSaveModeClient powerSaveModeClient, BuzzerClient buzzerClient, RechargeRemindersClient rechargeRemindersClient, UsageReminderClient usageReminderClient, BleTimeoutClient bleTimeoutClient, TimeoutAutoLockClient timeoutAutoLockClient) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(batteryClient, "batteryClient");
        Intrinsics.checkNotNullParameter(cloudClient, "cloudClient");
        Intrinsics.checkNotNullParameter(deviceInfoClient, "deviceInfoClient");
        Intrinsics.checkNotNullParameter(errorClient, "errorClient");
        Intrinsics.checkNotNullParameter(findVapeClient, "findVapeClient");
        Intrinsics.checkNotNullParameter(lockClient, "lockClient");
        Intrinsics.checkNotNullParameter(puffsClient, "puffsClient");
        Intrinsics.checkNotNullParameter(logsClient, "logsClient");
        Intrinsics.checkNotNullParameter(timeClient, "timeClient");
        Intrinsics.checkNotNullParameter(scanner, "scanner");
        Intrinsics.checkNotNullParameter(gattManager, "gattManager");
        Intrinsics.checkNotNullParameter(puffsRepository, "puffsRepository");
        Intrinsics.checkNotNullParameter(bonding, "bonding");
        Intrinsics.checkNotNullParameter(batDevicesRepository, "batDevicesRepository");
        Intrinsics.checkNotNullParameter(ageVerifier, "ageVerifier");
        Intrinsics.checkNotNullParameter(payloadUploader, "payloadUploader");
        Intrinsics.checkNotNullParameter(ledClient, "ledClient");
        Intrinsics.checkNotNullParameter(firmwareManager, "firmwareManager");
        Intrinsics.checkNotNullParameter(resetClient, "resetClient");
        Intrinsics.checkNotNullParameter(hapticClient, "hapticClient");
        Intrinsics.checkNotNullParameter(asavModule, "asavModule");
        Intrinsics.checkNotNullParameter(btProximityUnlock, "btProximityUnlock");
        Intrinsics.checkNotNullParameter(settingsManager, "settingsManager");
        Intrinsics.checkNotNullParameter(podConnectionClient, "podConnectionClient");
        Intrinsics.checkNotNullParameter(powerSaveModeClient, "powerSaveModeClient");
        Intrinsics.checkNotNullParameter(buzzerClient, "buzzerClient");
        Intrinsics.checkNotNullParameter(rechargeRemindersClient, "rechargeRemindersClient");
        Intrinsics.checkNotNullParameter(usageReminderClient, "usageReminderClient");
        Intrinsics.checkNotNullParameter(bleTimeoutClient, "bleTimeoutClient");
        Intrinsics.checkNotNullParameter(timeoutAutoLockClient, "timeoutAutoLockClient");
        this.reactContext = reactContext;
        this.batteryClient = batteryClient;
        this.cloudClient = cloudClient;
        this.deviceInfoClient = deviceInfoClient;
        this.errorClient = errorClient;
        this.findVapeClient = findVapeClient;
        this.lockClient = lockClient;
        this.puffsClient = puffsClient;
        this.logsClient = logsClient;
        this.timeClient = timeClient;
        this.scanner = scanner;
        this.gattManager = gattManager;
        this.puffsRepository = puffsRepository;
        this.bonding = bonding;
        this.batDevicesRepository = batDevicesRepository;
        this.ageVerifier = ageVerifier;
        this.payloadUploader = payloadUploader;
        this.ledClient = ledClient;
        this.firmwareManager = firmwareManager;
        this.resetClient = resetClient;
        this.hapticClient = hapticClient;
        this.asavModule = asavModule;
        this.btProximityUnlock = btProximityUnlock;
        this.settingsManager = settingsManager;
        this.podConnectionClient = podConnectionClient;
        this.powerSaveModeClient = powerSaveModeClient;
        this.buzzerClient = buzzerClient;
        this.rechargeRemindersClient = rechargeRemindersClient;
        this.usageReminderClient = usageReminderClient;
        this.bleTimeoutClient = bleTimeoutClient;
        this.timeoutAutoLockClient = timeoutAutoLockClient;
        this.TAG = "NodesModule";
        this.historyModeDevices = Collections.synchronizedSet(new LinkedHashSet());
        LogInstrumentation.m2726d(this.TAG, "[NodesModule.init()] *client.initialize(GlobalScope);");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14111(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14212(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14223(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14234(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14245(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14256(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14267(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14278(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14289(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C141210(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C141311(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C141412(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C141513(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C141614(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C141715(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C141816(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C141917(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C142018(null), 2, null);
    }

    public final String getDisplayName(ConnectionState connectionState) {
        Intrinsics.checkNotNullParameter(connectionState, "<this>");
        if (Intrinsics.areEqual(connectionState, ConnectionState.Connecting.INSTANCE)) {
            return "Connecting";
        }
        if (connectionState instanceof ConnectionState.Connected) {
            return "Connected";
        }
        if (connectionState instanceof ConnectionState.Disconnecting) {
            return "Disconnecting";
        }
        if (connectionState instanceof ConnectionState.Disconnected) {
            return "Disconnected";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String getDisplayName(BondState bondState) {
        Intrinsics.checkNotNullParameter(bondState, "<this>");
        if (Intrinsics.areEqual(bondState, BondState.Bonding.INSTANCE)) {
            return "Bonding";
        }
        if (bondState instanceof BondState.Default) {
            return Profile.DEFAULT_PROFILE_NAME;
        }
        if (bondState instanceof BondState.Bonded) {
            return "Bonded";
        }
        if (bondState instanceof BondState.Failed) {
            return "Failed";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {127}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C14111(Continuation<? super C14111> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14111(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [T, java.util.HashMap] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CollectionsKt.emptyList();
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = new HashMap();
                    StateFlow<List<BleDeviceData>> devices = NodesModule.this.gattManager.getDevices();
                    final NodesModule nodesModule = NodesModule.this;
                    this.label = 1;
                    if (devices.collect(new FlowCollector() { // from class: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<BleDeviceData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<BleDeviceData> list, Continuation<? super Unit> continuation) {
                            String str;
                            Ref.ObjectRef<Map<String, BleDeviceData>> objectRef2 = objectRef;
                            ArrayList arrayList = new ArrayList();
                            for (T t : list) {
                                BleDeviceData bleDeviceData = (BleDeviceData) t;
                                if (!objectRef2.element.containsKey(bleDeviceData.getAddress()) || !Intrinsics.areEqual(objectRef2.element.get(bleDeviceData.getAddress()), bleDeviceData)) {
                                    arrayList.add(t);
                                }
                            }
                            ArrayList<BleDeviceData> arrayList2 = arrayList;
                            LogInstrumentation.m2726d(nodesModule.TAG, "[gattManager.devices] devices number list:" + arrayList2.size());
                            for (BleDeviceData bleDeviceData2 : arrayList2) {
                                LogInstrumentation.m2726d(nodesModule.TAG, "[gattManager.devices] device=" + bleDeviceData2.getAddress() + " state=" + bleDeviceData2.getConnectionState() + " deviceType=" + bleDeviceData2.getDeviceType());
                                objectRef.element.put(bleDeviceData2.getAddress(), bleDeviceData2);
                                ConnectionState connectionState = bleDeviceData2.getConnectionState();
                                if (!Intrinsics.areEqual(connectionState, ConnectionState.Connected.INSTANCE) && !Intrinsics.areEqual(connectionState, ConnectionState.Disconnected.INSTANCE) && Intrinsics.areEqual(connectionState, ConnectionState.Disconnecting.INSTANCE)) {
                                    nodesModule.gattManager.clearRequestsForDevice(bleDeviceData2.getAddress());
                                }
                                DeviceType deviceType = bleDeviceData2.getDeviceType();
                                if (Intrinsics.areEqual(deviceType, DeviceType.EPod.INSTANCE)) {
                                    str = "ePod";
                                } else if (Intrinsics.areEqual(deviceType, DeviceType.EPod2.INSTANCE)) {
                                    str = "ePod 2";
                                } else if (Intrinsics.areEqual(deviceType, DeviceType.EPod3.INSTANCE)) {
                                    str = "ePod 3";
                                } else if (Intrinsics.areEqual(deviceType, DeviceType.DFU.INSTANCE)) {
                                    str = "DFU";
                                } else if (Intrinsics.areEqual(deviceType, DeviceType.VPro.INSTANCE)) {
                                    str = "vPro";
                                } else if (Intrinsics.areEqual(deviceType, DeviceType.EPen.INSTANCE)) {
                                    str = "ePen";
                                } else if (Intrinsics.areEqual(deviceType, DeviceType.Alto2.INSTANCE)) {
                                    str = "Alto2";
                                } else {
                                    str = Intrinsics.areEqual(deviceType, DeviceType.SmartBox.INSTANCE) ? "SmartBox" : "Unrecognized Device";
                                }
                                if (nodesModule.reactContext.hasActiveCatalystInstance() && ((Intrinsics.areEqual(bleDeviceData2.getDeviceType(), DeviceType.Unknown.INSTANCE) && Intrinsics.areEqual(bleDeviceData2.getConnectionState(), ConnectionState.Disconnected.INSTANCE)) || ((Intrinsics.areEqual(bleDeviceData2.getDeviceType(), DeviceType.Unknown.INSTANCE) && Intrinsics.areEqual(bleDeviceData2.getConnectionState(), ConnectionState.Connected.INSTANCE)) || !Intrinsics.areEqual(bleDeviceData2.getDeviceType(), DeviceType.Unknown.INSTANCE) || !Intrinsics.areEqual(bleDeviceData2.getDeviceType(), DeviceType.DFU.INSTANCE)))) {
                                    if (bleDeviceData2.getServices() != null) {
                                        List<BatService> services = bleDeviceData2.getServices();
                                        Intrinsics.checkNotNull(services);
                                        if (services.size() > 0) {
                                            List<BatService> services2 = bleDeviceData2.getServices();
                                            Intrinsics.checkNotNull(services2);
                                            for (BatService batService : services2) {
                                                LogInstrumentation.m2726d(nodesModule.TAG, "[gattManager.devices.services] device=" + bleDeviceData2.getAddress() + "  state=" + bleDeviceData2.getConnectionState() + "  service.name=" + batService.getName() + "  service.serviceType=" + batService.getServiceType() + " ");
                                            }
                                        }
                                    }
                                    if (!Intrinsics.areEqual(bleDeviceData2.getDeviceType(), DeviceType.Unknown.INSTANCE) && Intrinsics.areEqual(bleDeviceData2.getConnectionState(), ConnectionState.Connected.INSTANCE) && bleDeviceData2.getDiscoveryServicesState().toString().equals("discovered")) {
                                        LogInstrumentation.m2726d(nodesModule.TAG, "[gattManager.devices] Subscribe to client for device:" + bleDeviceData2.getAddress());
                                    }
                                    WritableMap writableMapWritableMapOf = nodesModule.writableMapOf(new Pair[0]);
                                    writableMapWritableMapOf.putString("connectionState", bleDeviceData2.getConnectionState().toString());
                                    writableMapWritableMapOf.putString("deviceType", str);
                                    writableMapWritableMapOf.putString("discoveryServicesState", bleDeviceData2.getDiscoveryServicesState().toString());
                                    writableMapWritableMapOf.putString("deviceAddress", bleDeviceData2.getAddress().toString());
                                    LogInstrumentation.m2726d(nodesModule.TAG, "[onConnectionStateChange] " + bleDeviceData2.getAddress() + " " + bleDeviceData2.getConnectionState());
                                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) nodesModule.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onConnectionStateChange", writableMapWritableMapOf);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[batClient.connectionFlow] Exception from the flow: " + th);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$2 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$2", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_CONSENT_EXPIRED}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C14212(Continuation<? super C14212> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14212(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14212) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (FlowKt.collectLatest(NodesModule.this.bonding.getBondStateFlow(), new AnonymousClass1(NodesModule.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[bonding.bondStateFlow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m5598d2 = {"<anonymous>", "", "it", "Lcom/bat/sdk/ble/BondState;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$2$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<BondState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NodesModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NodesModule nodesModule, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = nodesModule;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(BondState bondState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(bondState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    BondState bondState = (BondState) this.L$0;
                    LogInstrumentation.m2726d(this.this$0.TAG, "[bonding.bondStateFlow] bondState=" + this.this$0.getDisplayName(bondState));
                    if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                        WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                        writableMapWritableMapOf.putString("bondState", this.this$0.getDisplayName(bondState));
                        LogInstrumentation.m2726d(this.this$0.TAG, "[bonding.bondStateFlow]  bondState=" + this.this$0.getDisplayName(bondState));
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onBondStateChange", writableMapWritableMapOf);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$3 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$3", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {228}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14223 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C14223(Continuation<? super C14223> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14223(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14223) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<GattError> gatErrorStateFlow = NodesModule.this.gattManager.getGatErrorStateFlow();
                    final NodesModule nodesModule = NodesModule.this;
                    this.label = 1;
                    if (gatErrorStateFlow.collect(new FlowCollector() { // from class: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule.3.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((GattError) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(GattError gattError, Continuation<? super Unit> continuation) {
                            String characteristicUUID;
                            LogInstrumentation.m2726d(nodesModule.TAG, "[gattManager.gatErrorStateFlow] device=" + (gattError != null ? gattError.getAddress() : null) + "   characteristic=" + ((gattError == null || (characteristicUUID = gattError.getCharacteristicUUID()) == null) ? null : characteristicUUID.toString()));
                            if (nodesModule.reactContext.hasActiveCatalystInstance()) {
                                WritableMap writableMapWritableMapOf = nodesModule.writableMapOf(new Pair[0]);
                                writableMapWritableMapOf.putString("state", "Error");
                                writableMapWritableMapOf.putString("address", gattError != null ? gattError.getAddress() : null);
                                ((DeviceEventManagerModule.RCTDeviceEventEmitter) nodesModule.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onMarketEnableStateChange", writableMapWritableMapOf);
                            }
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[gattManager.gatErrorStateFlow] Exception from the flow: " + th);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$4 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$4", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {252}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14234 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C14234(Continuation<? super C14234> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14234(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14234) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (FlowKt.collectLatest(NodesModule.this.payloadUploader.getUploadStateFlow(), new AnonymousClass1(NodesModule.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[payloadUploader.uploadStateFlow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m5598d2 = {"<anonymous>", "", "it", "Lcom/bat/sdk/payload/PayloadUploadState;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$4$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<PayloadUploadState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NodesModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NodesModule nodesModule, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = nodesModule;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(PayloadUploadState payloadUploadState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(payloadUploadState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    PayloadUploadState payloadUploadState = (PayloadUploadState) this.L$0;
                    LogInstrumentation.m2726d(this.this$0.TAG, "[payloadUploader.uploadStateFlow] device=" + payloadUploadState.getDeviceAddress() + "  state=" + payloadUploadState);
                    if ((payloadUploadState instanceof PayloadUploadState.Finishing) && this.this$0.reactContext.hasActiveCatalystInstance()) {
                        WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                        writableMapWritableMapOf.putString("state", "Finishing");
                        writableMapWritableMapOf.putString("address", payloadUploadState.getDeviceAddress());
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onMarketEnableStateChange", writableMapWritableMapOf);
                    }
                    if ((payloadUploadState instanceof PayloadUploadState.Idle) && this.this$0.reactContext.hasActiveCatalystInstance()) {
                        WritableMap writableMapWritableMapOf2 = this.this$0.writableMapOf(new Pair[0]);
                        writableMapWritableMapOf2.putString("state", "Idle");
                        writableMapWritableMapOf2.putString("address", payloadUploadState.getDeviceAddress());
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onMarketEnableStateChange", writableMapWritableMapOf2);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$5 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$5", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {289}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14245 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C14245(Continuation<? super C14245> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14245(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14245) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (FlowKt.collectLatest(NodesModule.this.firmwareManager.getInstallationStateFlow(), new AnonymousClass1(NodesModule.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[firmwareManager.installationStateFlow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m5598d2 = {"<anonymous>", "", "state", "Lcom/bat/sdk/domain/device/FirmwareInstallationState;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$5$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<FirmwareInstallationState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NodesModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NodesModule nodesModule, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = nodesModule;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(FirmwareInstallationState firmwareInstallationState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(firmwareInstallationState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                FirmwareInstallationState firmwareInstallationState = (FirmwareInstallationState) this.L$0;
                String deviceAddress = firmwareInstallationState.getDeviceAddress();
                LogInstrumentation.m2726d(this.this$0.TAG, "[firmwareManager.installationStateFlow] state=" + firmwareInstallationState + " deviceAddress=" + deviceAddress);
                if (firmwareInstallationState instanceof FirmwareInstallationState.Progress) {
                    LogInstrumentation.m2726d(this.this$0.TAG, "[FirmwareInstallationState] Progress: " + firmwareInstallationState + ".percent");
                    if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                        WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                        writableMapWritableMapOf.putInt("percent", ((FirmwareInstallationState.Progress) firmwareInstallationState).getPercent());
                        writableMapWritableMapOf.putString("deviceAddress", deviceAddress);
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onFirmwareInstallationProgress", writableMapWritableMapOf);
                    }
                } else if (firmwareInstallationState instanceof FirmwareInstallationState.DfuProcessStarted) {
                    LogInstrumentation.m2726d(this.this$0.TAG, "[FirmwareInstallationState] DfuProcessStarted");
                    WritableMap writableMapWritableMapOf2 = this.this$0.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf2.putString("deviceAddress", deviceAddress);
                    if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onFirmwareInstallationDfuStarted", writableMapWritableMapOf2);
                    }
                } else if (firmwareInstallationState instanceof FirmwareInstallationState.DfuProcessStarting) {
                    LogInstrumentation.m2726d(this.this$0.TAG, "[FirmwareInstallationState] DfuProcessStarting");
                    WritableMap writableMapWritableMapOf3 = this.this$0.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf3.putString("deviceAddress", deviceAddress);
                    if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onFirmwareInstallationDfuStarting", writableMapWritableMapOf3);
                    }
                } else if (firmwareInstallationState instanceof FirmwareInstallationState.DfuCompleted) {
                    LogInstrumentation.m2726d(this.this$0.TAG, "[FirmwareInstallationState] UpdateFinished");
                    WritableMap writableMapWritableMapOf4 = this.this$0.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf4.putString("deviceAddress", deviceAddress);
                    if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onFirmwareInstallationDfuCompleted", writableMapWritableMapOf4);
                    }
                } else if (firmwareInstallationState instanceof FirmwareInstallationState.Error) {
                    LogInstrumentation.m2726d(this.this$0.TAG, "[FirmwareInstallationState] Error: " + firmwareInstallationState + ".message");
                    if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                        WritableMap writableMapWritableMapOf5 = this.this$0.writableMapOf(new Pair[0]);
                        writableMapWritableMapOf5.putString("message", firmwareInstallationState.toString());
                        writableMapWritableMapOf5.putString("deviceAddress", deviceAddress);
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onFirmwareInstallationError", writableMapWritableMapOf5);
                    }
                } else if (firmwareInstallationState instanceof FirmwareInstallationState.Idle) {
                    LogInstrumentation.m2726d(this.this$0.TAG, "[FirmwareInstallationState] Idle");
                    WritableMap writableMapWritableMapOf6 = this.this$0.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf6.putString("deviceAddress", deviceAddress);
                    if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onFirmwareInstallationIdle", writableMapWritableMapOf6);
                    }
                } else {
                    LogInstrumentation.m2726d(this.this$0.TAG, "[FirmwareInstallationState] " + firmwareInstallationState);
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$6 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$6", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14256 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C14256(Continuation<? super C14256> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14256(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14256) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    this.label = 1;
                    if (NodesModule.this.puffsClient.getFlow().collect(new AnonymousClass1(NodesModule.this, linkedHashMap, linkedHashMap2), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[puffsClient.flow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$6$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u00140\u0003R\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, m5598d2 = {"<anonymous>", "", "record", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/PuffRequest;", "Lcom/bat/sdk/model/PuffRecord;", "emit", "(Lcom/bat/sdk/client/CharacteristicClient$Response;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ Map<String, Integer> $puffRecordsCounters;
            final /* synthetic */ Map<String, Boolean> $puffRecordsXdevice;
            final /* synthetic */ NodesModule this$0;

            AnonymousClass1(NodesModule nodesModule, Map<String, Boolean> map, Map<String, Integer> map2) {
                this.this$0 = nodesModule;
                this.$puffRecordsXdevice = map;
                this.$puffRecordsCounters = map2;
            }

            /* JADX WARN: Removed duplicated region for block: B:205:0x034b A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:42:0x019b  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
            /* JADX WARN: Removed duplicated region for block: B:97:0x030f  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.bat.sdk.client.CharacteristicClient<com.bat.sdk.model.PuffRequest, com.bat.sdk.model.PuffRecord>.Response r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
                /*
                    Method dump skipped, instruction units count: 1967
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule.C14256.AnonymousClass1.emit(com.bat.sdk.client.CharacteristicClient$Response, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((CharacteristicClient<PuffRequest, PuffRecord>.Response) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$7 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$7", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {554}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14267 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C14267(Continuation<? super C14267> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14267(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14267) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    this.label = 1;
                    if (NodesModule.this.logsClient.getFlow().collect(new AnonymousClass1(NodesModule.this, linkedHashSet), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[logsClient.flow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$7$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u00140\u0003R\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, m5598d2 = {"<anonymous>", "", "record", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/LogRecord;", "emit", "(Lcom/bat/sdk/client/CharacteristicClient$Response;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ Set<String> $devicesInHistoryMode;
            final /* synthetic */ NodesModule this$0;

            AnonymousClass1(NodesModule nodesModule, Set<String> set) {
                this.this$0 = nodesModule;
                this.$devicesInHistoryMode = set;
            }

            /* JADX WARN: Removed duplicated region for block: B:35:0x00b2  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00df  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x01b7  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x025b  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x02b0  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
            /* JADX WARN: Removed duplicated region for block: B:87:0x04ed  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.bat.sdk.client.CharacteristicClient<kotlin.Unit, com.bat.sdk.model.LogRecord>.Response r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
                /*
                    Method dump skipped, instruction units count: 1265
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule.C14267.AnonymousClass1.emit(com.bat.sdk.client.CharacteristicClient$Response, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((CharacteristicClient<Unit, LogRecord>.Response) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$8 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$8", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {681}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14278 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C14278(Continuation<? super C14278> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14278(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14278) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (FlowKt.collectLatest(FlowKt.combine(NodesModule.this.scanner.getResultsStateFlow(), NodesModule.this.gattManager.getDevices(), NodesModule.this.scanner.getScanningStateFlow(), new AnonymousClass1(null)), new AnonymousClass2(NodesModule.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[scanner] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$8$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\bH\u008a@"}, m5598d2 = {"<anonymous>", "Lcom/bat/myvuse/mobile/rncomponents/nodes/ScanningState;", "devices", "", "Lcom/bat/sdk/ble/BatDevice;", "devicesList", "Lcom/bat/sdk/ble/BleDeviceData;", "isScanning", ""}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$8$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function4<List<? extends BatDevice>, List<? extends BleDeviceData>, Boolean, Continuation<? super ScanningState>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            /* synthetic */ boolean Z$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(4, continuation);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(List<? extends BatDevice> list, List<? extends BleDeviceData> list2, Boolean bool, Continuation<? super ScanningState> continuation) {
                return invoke((List<BatDevice>) list, (List<BleDeviceData>) list2, bool.booleanValue(), continuation);
            }

            public final Object invoke(List<BatDevice> list, List<BleDeviceData> list2, boolean z, Continuation<? super ScanningState> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = list;
                anonymousClass1.L$1 = list2;
                anonymousClass1.Z$0 = z;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return new ScanningState((List) this.L$0, (List) this.L$1, this.Z$0);
            }
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$8$2, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m5598d2 = {"<anonymous>", "", "state", "Lcom/bat/myvuse/mobile/rncomponents/nodes/ScanningState;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$8$2", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {684}, m5611m = "invokeSuspend", m5612n = {"state"}, m5613s = {"L$0"})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<ScanningState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NodesModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(NodesModule nodesModule, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = nodesModule;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(ScanningState scanningState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(scanningState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                ScanningState scanningState;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ScanningState scanningState2 = (ScanningState) this.L$0;
                    this.L$0 = scanningState2;
                    this.label = 1;
                    if (DelayKt.delay(3L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    scanningState = scanningState2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    scanningState = (ScanningState) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                LogInstrumentation.m2726d(this.this$0.TAG, "[scanner] device=" + scanningState.getDevice() + ", isScanning=" + scanningState.getIsScanning());
                if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                    WritableArray writableArrayCreateArray = Arguments.createArray();
                    for (BatDevice batDevice : scanningState.getDevice()) {
                        WritableMap writableMapCreateMap = Arguments.createMap();
                        writableMapCreateMap.putString("deviceAddress", batDevice.getAddress().toString());
                        writableMapCreateMap.putString("deviceName", batDevice.getName().toString());
                        writableMapCreateMap.putInt("deviceRssi", batDevice.getRssi());
                        if (batDevice.getAdvertisingData() != null && (batDevice.getAdvertisingData() instanceof DeviceAdvertisingData.SmartBoxAdvertisingData)) {
                            DeviceAdvertisingData advertisingData = batDevice.getAdvertisingData();
                            Intrinsics.checkNotNull(advertisingData, "null cannot be cast to non-null type com.bat.sdk.ble.advertising.DeviceAdvertisingData.SmartBoxAdvertisingData");
                            writableMapCreateMap.putInt("deviceColor", ((DeviceAdvertisingData.SmartBoxAdvertisingData) advertisingData).getDeviceColor());
                            DeviceAdvertisingData advertisingData2 = batDevice.getAdvertisingData();
                            Intrinsics.checkNotNull(advertisingData2, "null cannot be cast to non-null type com.bat.sdk.ble.advertising.DeviceAdvertisingData.SmartBoxAdvertisingData");
                            writableMapCreateMap.putInt("deviceTypeId", ((DeviceAdvertisingData.SmartBoxAdvertisingData) advertisingData2).getDeviceType());
                        }
                        writableArrayCreateArray.pushMap(writableMapCreateMap);
                    }
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onScanResult", writableArrayCreateArray);
                    WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf.putBoolean("scanning", scanningState.getIsScanning());
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onScanStatusChange", writableMapWritableMapOf);
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$9 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$9", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {736}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14289 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C14289(Continuation<? super C14289> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14289(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14289) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (FlowKt.collectLatest(NodesModule.this.batteryClient.getFlow(), new AnonymousClass1(NodesModule.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[batteryClient.flow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$9$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u00120\u0003R\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, m5598d2 = {"<anonymous>", "", "battery", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/Battery;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$9$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {737}, m5611m = "invokeSuspend", m5612n = {"battery"}, m5613s = {"L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CharacteristicClient<Unit, Battery>.Response, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NodesModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NodesModule nodesModule, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = nodesModule;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CharacteristicClient<Unit, Battery>.Response response, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(response, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CharacteristicClient.Response response;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CharacteristicClient.Response response2 = (CharacteristicClient.Response) this.L$0;
                    this.L$0 = response2;
                    this.label = 1;
                    if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    response = response2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    response = (CharacteristicClient.Response) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                LogInstrumentation.m2726d(this.this$0.TAG, "[batteryClient.flow] isCharging=" + ((Battery) response.getData()).getChargingState());
                LogInstrumentation.m2726d(this.this$0.TAG, "[batteryClient.flow] level=" + ((Battery) response.getData()).getLevel());
                if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                    WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf.putInt(FirebaseAnalytics.Param.LEVEL, ((Battery) response.getData()).getLevel());
                    writableMapWritableMapOf.putBoolean("isCharging", ((Battery) response.getData()).getChargingState() != 0);
                    writableMapWritableMapOf.putString("deviceAddress", response.getDeviceAddress());
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onBatteryInfoChange", writableMapWritableMapOf);
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$10 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$10", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {761}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C141210 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C141210(Continuation<? super C141210> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C141210(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C141210) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (FlowKt.collectLatest(NodesModule.this.lockClient.getFlow(), new AnonymousClass1(NodesModule.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[lockClient.flow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$10$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u00120\u0003R\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, m5598d2 = {"<anonymous>", "", "it", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/Lock;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$10$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {762}, m5611m = "invokeSuspend", m5612n = {"it"}, m5613s = {"L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CharacteristicClient<Lock, Lock>.Response, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NodesModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NodesModule nodesModule, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = nodesModule;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CharacteristicClient<Lock, Lock>.Response response, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(response, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CharacteristicClient.Response response;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CharacteristicClient.Response response2 = (CharacteristicClient.Response) this.L$0;
                    this.L$0 = response2;
                    this.label = 1;
                    if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    response = response2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    response = (CharacteristicClient.Response) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                LogInstrumentation.m2726d(this.this$0.TAG, "[lockClient.flow] locked=" + ((Lock) response.getData()).getLocked());
                if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                    WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf.putBoolean("locked", ((Lock) response.getData()).getLocked());
                    writableMapWritableMapOf.putString("deviceAddress", response.getDeviceAddress());
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onLockInfoChange", writableMapWritableMapOf);
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$11 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$11", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {784}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C141311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C141311(Continuation<? super C141311> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C141311(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C141311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (FlowKt.collectLatest(NodesModule.this.cloudClient.getFlow(), new AnonymousClass1(NodesModule.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[cloudClient.flow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$11$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u00120\u0003R\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, m5598d2 = {"<anonymous>", "", "it", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/Cloud;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$11$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CharacteristicClient<Cloud, Cloud>.Response, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NodesModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NodesModule nodesModule, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = nodesModule;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CharacteristicClient<Cloud, Cloud>.Response response, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(response, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                String str;
                StateFlow<List<BleDeviceData>> devices;
                List<BleDeviceData> value;
                Object next;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    CharacteristicClient.Response response = (CharacteristicClient.Response) this.L$0;
                    LogInstrumentation.m2726d(this.this$0.TAG, "[cloudClient.flow] level=" + ((Cloud) response.getData()).getLevel());
                    LogInstrumentation.m2726d(this.this$0.TAG, "[cloudClient.flow] currentLevel=" + ((Cloud) response.getData()).getCurrentLevel());
                    LogInstrumentation.m2726d(this.this$0.TAG, "[cloudClient.flow] batterySavingOn=" + ((Cloud) response.getData()).getBatterySavingOn());
                    LogInstrumentation.m2726d(this.this$0.TAG, "[cloudClient.flow] batterySavingPowerLevel=" + ((Cloud) response.getData()).getBatterySavingPowerLevel());
                    LogInstrumentation.m2726d(this.this$0.TAG, "[cloudClient.flow] batterySavingEnabled=" + ((Cloud) response.getData()).getBatterySavingEnabled());
                    LogInstrumentation.m2726d(this.this$0.TAG, "[cloudClient.flow] batterySavingThresholdValue=" + ((Cloud) response.getData()).getBatterySavingThresholdValue());
                    if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                        WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                        if (((Cloud) response.getData()).getCurrentLevel() != null) {
                            Integer currentLevel = ((Cloud) response.getData()).getCurrentLevel();
                            Intrinsics.checkNotNull(currentLevel);
                            writableMapWritableMapOf.putInt("cloudLevel", currentLevel.intValue());
                        } else {
                            writableMapWritableMapOf.putInt("cloudLevel", ((Cloud) response.getData()).getLevel());
                        }
                        if (((Cloud) response.getData()).getHeatingPowerMode() != null) {
                            Integer heatingPowerMode = ((Cloud) response.getData()).getHeatingPowerMode();
                            Intrinsics.checkNotNull(heatingPowerMode);
                            writableMapWritableMapOf.putBoolean("autotuneOn", heatingPowerMode.intValue() == 0);
                        }
                        if (((Cloud) response.getData()).getBatterySavingOn() != null) {
                            Integer batterySavingOn = ((Cloud) response.getData()).getBatterySavingOn();
                            Intrinsics.checkNotNull(batterySavingOn);
                            writableMapWritableMapOf.putInt("batterySavingOn", batterySavingOn.intValue());
                        }
                        if (((Cloud) response.getData()).getBatterySavingPowerLevel() != null) {
                            Integer batterySavingPowerLevel = ((Cloud) response.getData()).getBatterySavingPowerLevel();
                            Intrinsics.checkNotNull(batterySavingPowerLevel);
                            writableMapWritableMapOf.putInt("batterySavingPowerLevel", batterySavingPowerLevel.intValue());
                        }
                        if (((Cloud) response.getData()).getBatterySavingEnabled() != null) {
                            Integer batterySavingEnabled = ((Cloud) response.getData()).getBatterySavingEnabled();
                            Intrinsics.checkNotNull(batterySavingEnabled);
                            writableMapWritableMapOf.putInt("batterySavingEnabled", batterySavingEnabled.intValue());
                        }
                        if (((Cloud) response.getData()).getBatterySavingThresholdValue() != null) {
                            Integer batterySavingThresholdValue = ((Cloud) response.getData()).getBatterySavingThresholdValue();
                            Intrinsics.checkNotNull(batterySavingThresholdValue);
                            writableMapWritableMapOf.putInt("batterySavingThresholdValue", batterySavingThresholdValue.intValue());
                        }
                        String deviceAddress = response.getDeviceAddress();
                        GattManager gattManager = BatSdk.INSTANCE.getGattManager();
                        DeviceType deviceType = null;
                        if (gattManager != null && (devices = gattManager.getDevices()) != null && (value = devices.getValue()) != null) {
                            Iterator<T> it2 = value.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it2.next();
                                if (Intrinsics.areEqual(((BleDeviceData) next).getAddress(), deviceAddress)) {
                                    break;
                                }
                            }
                            BleDeviceData bleDeviceData = (BleDeviceData) next;
                            if (bleDeviceData != null) {
                                deviceType = bleDeviceData.getDeviceType();
                            }
                        }
                        if (Intrinsics.areEqual(deviceType, DeviceType.Unknown.INSTANCE)) {
                            str = "Unrecognized Device";
                        } else if (Intrinsics.areEqual(deviceType, DeviceType.EPod.INSTANCE)) {
                            str = "ePod";
                        } else if (Intrinsics.areEqual(deviceType, DeviceType.EPod2.INSTANCE)) {
                            str = "ePod 2";
                        } else if (Intrinsics.areEqual(deviceType, DeviceType.EPod3.INSTANCE)) {
                            str = "ePod 3";
                        } else if (Intrinsics.areEqual(deviceType, DeviceType.DFU.INSTANCE)) {
                            str = "DFU";
                        } else if (Intrinsics.areEqual(deviceType, DeviceType.VPro.INSTANCE)) {
                            str = "vPro";
                        } else if (Intrinsics.areEqual(deviceType, DeviceType.EPen.INSTANCE)) {
                            str = "ePen";
                        } else if (Intrinsics.areEqual(deviceType, DeviceType.Alto2.INSTANCE)) {
                            str = "Alto2";
                        } else {
                            str = Intrinsics.areEqual(deviceType, DeviceType.SmartBox.INSTANCE) ? "SmartBox" : "";
                        }
                        writableMapWritableMapOf.putString("deviceAddress", deviceAddress);
                        LogInstrumentation.m2726d(this.this$0.TAG, "[cloudClient.flow] deviceType=".concat(str));
                        writableMapWritableMapOf.putString("deviceType", str);
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onCloudInfoChange", writableMapWritableMapOf);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$12 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$12", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {848}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C141412 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C141412(Continuation<? super C141412> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C141412(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C141412) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (FlowKt.collectLatest(NodesModule.this.powerSaveModeClient.getFlow(), new AnonymousClass1(NodesModule.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[cloudClient.flow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$12$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u00120\u0003R\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, m5598d2 = {"<anonymous>", "", "it", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/PowerSaveMode;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$12$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CharacteristicClient<PowerSaveMode, PowerSaveMode>.Response, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NodesModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NodesModule nodesModule, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = nodesModule;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CharacteristicClient<PowerSaveMode, PowerSaveMode>.Response response, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(response, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    CharacteristicClient.Response response = (CharacteristicClient.Response) this.L$0;
                    LogInstrumentation.m2726d(this.this$0.TAG, "[powerSaveModeClient.flow] powerSaveModeSetting=" + ((PowerSaveMode) response.getData()).getPowerSaveModeSetting());
                    LogInstrumentation.m2726d(this.this$0.TAG, "[powerSaveModeClient.flow] powerSaveModeEnable=" + ((PowerSaveMode) response.getData()).getPowerSaveModeEnable());
                    LogInstrumentation.m2726d(this.this$0.TAG, "[powerSaveModeClient.flow] batteryThreshold=" + ((PowerSaveMode) response.getData()).getBatteryThreshold());
                    LogInstrumentation.m2726d(this.this$0.TAG, "[powerSaveModeClient.flow] manualPowerSaveModeEnabled=" + ((PowerSaveMode) response.getData()).getManualPowerSaveModeEnabled());
                    LogInstrumentation.m2726d(this.this$0.TAG, "[powerSaveModeClient.flow] autoPowerSaveModeEnabled=" + ((PowerSaveMode) response.getData()).getAutoPowerSaveModeEnabled());
                    if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                        WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                        writableMapWritableMapOf.putInt("batterySavingOn", ((PowerSaveMode) response.getData()).getPowerSaveModeEnable() ? 1 : 0);
                        writableMapWritableMapOf.putInt("batterySavingThresholdValue", ((PowerSaveMode) response.getData()).getBatteryThreshold());
                        if (((PowerSaveMode) response.getData()).getPowerSaveModeSetting() != null) {
                            Integer powerSaveModeSetting = ((PowerSaveMode) response.getData()).getPowerSaveModeSetting();
                            writableMapWritableMapOf.putBoolean("batterySavingEnabled", powerSaveModeSetting == null || powerSaveModeSetting.intValue() != 0);
                        } else {
                            writableMapWritableMapOf.putBoolean("batterySavingEnabled", ((PowerSaveMode) response.getData()).getAutoPowerSaveModeEnabled());
                        }
                        writableMapWritableMapOf.putBoolean("manualPowerSaveModeEnabled", ((PowerSaveMode) response.getData()).getManualPowerSaveModeEnabled());
                        writableMapWritableMapOf.putString("deviceAddress", response.getDeviceAddress());
                        LogInstrumentation.m2726d(this.this$0.TAG, "[powerSaveModeClient.flow] data=" + writableMapWritableMapOf);
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onPowerSaveModeInfoChange", writableMapWritableMapOf);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$13 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$13", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {885}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C141513 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C141513(Continuation<? super C141513> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C141513(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C141513) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (FlowKt.collectLatest(NodesModule.this.findVapeClient.getFlow(), new AnonymousClass1(NodesModule.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[findVapeClient.flow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$13$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u00120\u0003R\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, m5598d2 = {"<anonymous>", "", "it", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/FindVape;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$13$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CharacteristicClient<FindVape, FindVape>.Response, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NodesModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NodesModule nodesModule, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = nodesModule;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CharacteristicClient<FindVape, FindVape>.Response response, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(response, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    CharacteristicClient.Response response = (CharacteristicClient.Response) this.L$0;
                    LogInstrumentation.m2726d(this.this$0.TAG, "[findVapeClient.flow] isAlerting=" + ((FindVape) response.getData()).isAlerting());
                    LogInstrumentation.m2726d(this.this$0.TAG, "[findVapeClient.flow] seconds=" + ((FindVape) response.getData()).getSeconds());
                    if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                        WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                        writableMapWritableMapOf.putBoolean("isAlerting", ((FindVape) response.getData()).isAlerting());
                        writableMapWritableMapOf.putInt("seconds", ((FindVape) response.getData()).getSeconds());
                        writableMapWritableMapOf.putString("deviceAddress", response.getDeviceAddress());
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onFindVapeInfo", writableMapWritableMapOf);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$14 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$14", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {908}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C141614 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C141614(Continuation<? super C141614> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C141614(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C141614) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (FlowKt.collectLatest(NodesModule.this.ledClient.getFlow(), new AnonymousClass1(NodesModule.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[ledClient.flow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$14$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u00120\u0003R\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, m5598d2 = {"<anonymous>", "", "it", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/Led;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$14$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {909}, m5611m = "invokeSuspend", m5612n = {"it"}, m5613s = {"L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CharacteristicClient<Led, Led>.Response, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NodesModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NodesModule nodesModule, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = nodesModule;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CharacteristicClient<Led, Led>.Response response, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(response, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CharacteristicClient.Response response;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CharacteristicClient.Response response2 = (CharacteristicClient.Response) this.L$0;
                    this.L$0 = response2;
                    this.label = 1;
                    if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    response = response2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    response = (CharacteristicClient.Response) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                    WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                    if (((Led) response.getData()).getScreenSettingBrightness() != null) {
                        LogInstrumentation.m2726d(this.this$0.TAG, "[ledClient.flow] ledLevel=" + ((Led) response.getData()).getScreenSettingBrightness());
                        Integer screenSettingBrightness = ((Led) response.getData()).getScreenSettingBrightness();
                        Intrinsics.checkNotNull(screenSettingBrightness);
                        writableMapWritableMapOf.putInt("ledLevel", screenSettingBrightness.intValue());
                    } else {
                        LogInstrumentation.m2726d(this.this$0.TAG, "[ledClient.flow] ledLevel=" + ((Led) response.getData()).getBrightnessLevel());
                        writableMapWritableMapOf.putInt("ledLevel", ((Led) response.getData()).getBrightnessLevel());
                    }
                    writableMapWritableMapOf.putString("deviceAddress", response.getDeviceAddress());
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onLedChange", writableMapWritableMapOf);
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$15 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$15", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {936}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C141715 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C141715(Continuation<? super C141715> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C141715(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C141715) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (FlowKt.collectLatest(NodesModule.this.hapticClient.getFlow(), new AnonymousClass1(NodesModule.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[hapticClient.flow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$15$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u00120\u0003R\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, m5598d2 = {"<anonymous>", "", "it", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/Haptic;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$15$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CharacteristicClient<Haptic, Haptic>.Response, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NodesModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NodesModule nodesModule, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = nodesModule;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CharacteristicClient<Haptic, Haptic>.Response response, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(response, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    CharacteristicClient.Response response = (CharacteristicClient.Response) this.L$0;
                    LogInstrumentation.m2726d(this.this$0.TAG, "[hapticClient.flow] hapticLevel=" + ((Haptic) response.getData()).getLevel());
                    if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                        WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                        writableMapWritableMapOf.putInt("hapticLevel", ((Haptic) response.getData()).getLevel());
                        writableMapWritableMapOf.putString("deviceAddress", response.getDeviceAddress());
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onHapticChange", writableMapWritableMapOf);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$16 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$16", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {956}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C141816 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C141816(Continuation<? super C141816> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C141816(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C141816) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (FlowKt.collectLatest(NodesModule.this.buzzerClient.getFlow(), new AnonymousClass1(NodesModule.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[buzzerClient.flow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$16$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u00120\u0003R\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, m5598d2 = {"<anonymous>", "", "it", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/Buzzer;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$16$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CharacteristicClient<Buzzer, Buzzer>.Response, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NodesModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NodesModule nodesModule, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = nodesModule;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CharacteristicClient<Buzzer, Buzzer>.Response response, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(response, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    CharacteristicClient.Response response = (CharacteristicClient.Response) this.L$0;
                    LogInstrumentation.m2726d(this.this$0.TAG, "[hapticClient.flow] buzzLevel=" + ((Buzzer) response.getData()).getLoudness());
                    if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                        WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                        writableMapWritableMapOf.putInt("buzzLevel", ((Buzzer) response.getData()).getLoudness());
                        writableMapWritableMapOf.putString("deviceAddress", response.getDeviceAddress());
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onBuzzChange", writableMapWritableMapOf);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$17 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$17", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {976}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C141917 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C141917(Continuation<? super C141917> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C141917(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C141917) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (FlowKt.collectLatest(NodesModule.this.errorClient.getFlow(), new AnonymousClass1(NodesModule.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[errorClient.flow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$17$1, reason: invalid class name */
        /* JADX INFO: compiled from: NodesModule.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u00140\u0003R\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u008a@"}, m5598d2 = {"<anonymous>", "", "it", "Lcom/bat/sdk/client/CharacteristicClient$Response;", "Lcom/bat/sdk/client/CharacteristicClient;", "Lcom/bat/sdk/model/ErrorRecord;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$17$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CharacteristicClient<Unit, ErrorRecord>.Response, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NodesModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NodesModule nodesModule, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = nodesModule;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CharacteristicClient<Unit, ErrorRecord>.Response response, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(response, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                CharacteristicClient.Response response = (CharacteristicClient.Response) this.L$0;
                if (response.getData() != null && response.getData() != null) {
                    String str = this.this$0.TAG;
                    Object data = response.getData();
                    Intrinsics.checkNotNull(data);
                    LogInstrumentation.m2726d(str, "[errorClient.flow] code=" + ((ErrorRecord) data).getCode());
                    String str2 = this.this$0.TAG;
                    Object data2 = response.getData();
                    Intrinsics.checkNotNull(data2);
                    LogInstrumentation.m2726d(str2, "[errorClient.flow] description=" + ((ErrorRecord) data2).getDescription());
                    String str3 = this.this$0.TAG;
                    Object data3 = response.getData();
                    Intrinsics.checkNotNull(data3);
                    LogInstrumentation.m2726d(str3, "[errorClient.flow] timestamp=" + ((ErrorRecord) data3).getTimestamp());
                    if (this.this$0.reactContext.hasActiveCatalystInstance()) {
                        WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                        writableMapWritableMapOf.putInt("eventCount", -1);
                        writableMapWritableMapOf.putInt(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE, 2);
                        writableMapWritableMapOf.putString("eventTypeDescription", LogRecord.Companion.typeToString$default(LogRecord.INSTANCE, 2, null, 2, null));
                        Object data4 = response.getData();
                        Intrinsics.checkNotNull(data4);
                        writableMapWritableMapOf.putInt("eventCode", ((ErrorRecord) data4).getCode());
                        Object data5 = response.getData();
                        Intrinsics.checkNotNull(data5);
                        writableMapWritableMapOf.putString("eventCodeDescription", ((ErrorRecord) data5).getDescription());
                        Object data6 = response.getData();
                        Intrinsics.checkNotNull(data6);
                        writableMapWritableMapOf.putString("eventTimestamp", ((ErrorRecord) data6).getTimestamp().toString());
                        writableMapWritableMapOf.putString("eventData", "null");
                        writableMapWritableMapOf.putString("deviceAddress", response.getDeviceAddress());
                        writableMapWritableMapOf.putBoolean("errorBanner", true);
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onLiveLogData", writableMapWritableMapOf);
                    }
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$18 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$18", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {PointerIconCompat.TYPE_VERTICAL_TEXT}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C142018 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C142018(Continuation<? super C142018> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C142018(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C142018) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow<CharacteristicClient<Unit, PodConnection>.Response> flow = NodesModule.this.podConnectionClient.getFlow();
                    final NodesModule nodesModule = NodesModule.this;
                    this.label = 1;
                    if (flow.collect(new FlowCollector() { // from class: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule.18.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((CharacteristicClient<Unit, PodConnection>.Response) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(CharacteristicClient<Unit, PodConnection>.Response response, Continuation<? super Unit> continuation) {
                            String hex;
                            byte[] podUidRawData;
                            LogInstrumentation.m2726d(nodesModule.TAG, "[podConnection.flow] connected=" + response.getData().getConnected());
                            LogInstrumentation.m2726d(nodesModule.TAG, "[podConnection.flow] recognized=" + response.getData().getRecognized());
                            LogInstrumentation.m2726d(nodesModule.TAG, "[podConnection.flow] type=" + response.getData().getType());
                            LogInstrumentation.m2726d(nodesModule.TAG, "[podConnection.flow] apiVersion=" + response.getData().getApiVersion());
                            LogInstrumentation.m2726d(nodesModule.TAG, "[podConnection.flow] podUid=" + response.getData().getPodUid());
                            String str = nodesModule.TAG;
                            PodUid podUid = response.getData().getPodUid();
                            String lowerCase = null;
                            LogInstrumentation.m2726d(str, "[podConnection.flow] podUidRawData toHex=" + ((podUid == null || (podUidRawData = podUid.getPodUidRawData()) == null) ? null : ConversionExtensionsKt.toHex(podUidRawData)));
                            String str2 = nodesModule.TAG;
                            PodUid podUid2 = response.getData().getPodUid();
                            LogInstrumentation.m2726d(str2, "[podConnection.flow] podUid.manufactureDate=" + (podUid2 != null ? podUid2.getManufactureDate() : null));
                            String str3 = nodesModule.TAG;
                            PodUid podUid3 = response.getData().getPodUid();
                            LogInstrumentation.m2726d(str3, "[podConnection.flow] podUid.assembly=" + (podUid3 != null ? podUid3.getAssembly() : null));
                            LogInstrumentation.m2726d(nodesModule.TAG, "[podConnection.flow] liquidInformation=" + response.getData().getLiquidInformation());
                            String str4 = nodesModule.TAG;
                            LiquidInformation liquidInformation = response.getData().getLiquidInformation();
                            LogInstrumentation.m2726d(str4, "[podConnection.flow] liquidInformation.fillCapacity=" + (liquidInformation != null ? Boxing.boxDouble(liquidInformation.getFillCapacity()) : null));
                            String str5 = nodesModule.TAG;
                            LiquidInformation liquidInformation2 = response.getData().getLiquidInformation();
                            LogInstrumentation.m2726d(str5, "[podConnection.flow] liquidInformation.flavorGroup=" + (liquidInformation2 != null ? Boxing.boxInt(liquidInformation2.getFlavorGroup()) : null));
                            String str6 = nodesModule.TAG;
                            LiquidInformation liquidInformation3 = response.getData().getLiquidInformation();
                            LogInstrumentation.m2726d(str6, "[podConnection.flow] liquidInformation.nicotineStrength=" + (liquidInformation3 != null ? Boxing.boxInt(liquidInformation3.getNicotineStrength()) : null));
                            String str7 = nodesModule.TAG;
                            LiquidInformation liquidInformation4 = response.getData().getLiquidInformation();
                            LogInstrumentation.m2726d(str7, "[podConnection.flow] liquidInformation.heatingPower=" + (liquidInformation4 != null ? Boxing.boxInt(liquidInformation4.getHeatingPower()) : null));
                            LogInstrumentation.m2726d(nodesModule.TAG, "[podConnection.flow] skuInformation=" + response.getData().getSkuInformation());
                            LogInstrumentation.m2726d(nodesModule.TAG, "[podConnection.flow] remainingVolume=" + response.getData().getRemainingVolume());
                            LogInstrumentation.m2726d(nodesModule.TAG, "[podConnection.flow] podPuffCount=" + response.getData().getPodPuffCount());
                            LogInstrumentation.m2726d(nodesModule.TAG, "[podConnection.flow] deviceAddress=" + response.getDeviceAddress());
                            if (nodesModule.reactContext.hasActiveCatalystInstance()) {
                                WritableMap writableMapWritableMapOf = nodesModule.writableMapOf(new Pair[0]);
                                writableMapWritableMapOf.putString("deviceAddress", response.getDeviceAddress());
                                writableMapWritableMapOf.putBoolean("connected", response.getData().getConnected());
                                writableMapWritableMapOf.putBoolean("recognized", response.getData().getRecognized());
                                Integer type = response.getData().getType();
                                if (type != null && type.intValue() == 2) {
                                    Integer type2 = response.getData().getType();
                                    Intrinsics.checkNotNull(type2);
                                    writableMapWritableMapOf.putInt("type", type2.intValue());
                                    Integer apiVersion = response.getData().getApiVersion();
                                    Intrinsics.checkNotNull(apiVersion);
                                    writableMapWritableMapOf.putInt("apiVersion", apiVersion.intValue());
                                    PodUid podUid4 = response.getData().getPodUid();
                                    Intrinsics.checkNotNull(podUid4);
                                    byte[] podUidRawData2 = podUid4.getPodUidRawData();
                                    if (podUidRawData2 != null && (hex = ConversionExtensionsKt.toHex(podUidRawData2)) != null) {
                                        lowerCase = hex.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    }
                                    writableMapWritableMapOf.putString("uid", lowerCase);
                                    PodUid podUid5 = response.getData().getPodUid();
                                    Intrinsics.checkNotNull(podUid5);
                                    writableMapWritableMapOf.putString("manufactureDate", podUid5.getManufactureDate());
                                    PodUid podUid6 = response.getData().getPodUid();
                                    Intrinsics.checkNotNull(podUid6);
                                    writableMapWritableMapOf.putString("assembly", podUid6.getAssembly());
                                    LiquidInformation liquidInformation5 = response.getData().getLiquidInformation();
                                    Intrinsics.checkNotNull(liquidInformation5);
                                    writableMapWritableMapOf.putDouble("fillCapacity", liquidInformation5.getFillCapacity());
                                    LiquidInformation liquidInformation6 = response.getData().getLiquidInformation();
                                    Intrinsics.checkNotNull(liquidInformation6);
                                    writableMapWritableMapOf.putInt("flavorGroup", liquidInformation6.getFlavorGroup());
                                    LiquidInformation liquidInformation7 = response.getData().getLiquidInformation();
                                    Intrinsics.checkNotNull(liquidInformation7);
                                    writableMapWritableMapOf.putInt("nicotineStrength", liquidInformation7.getNicotineStrength());
                                    LiquidInformation liquidInformation8 = response.getData().getLiquidInformation();
                                    Intrinsics.checkNotNull(liquidInformation8);
                                    writableMapWritableMapOf.putInt("heatingPower", liquidInformation8.getHeatingPower());
                                    writableMapWritableMapOf.putString("skuInformation", response.getData().getSkuInformation());
                                    Integer remainingVolume = response.getData().getRemainingVolume();
                                    Intrinsics.checkNotNull(remainingVolume);
                                    writableMapWritableMapOf.putInt("remainingVolume", remainingVolume.intValue());
                                    Integer podPuffCount = response.getData().getPodPuffCount();
                                    Intrinsics.checkNotNull(podPuffCount);
                                    writableMapWritableMapOf.putInt("podPuffCount", podPuffCount.intValue());
                                }
                                ((DeviceEventManagerModule.RCTDeviceEventEmitter) nodesModule.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onPodConnectionChange", writableMapWritableMapOf);
                            }
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[cloudClient.flow] Exception from the flow: " + th);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object _startScanner(java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule._startScanner(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$startScanner$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$startScanner$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {1098}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $ePodType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14731(String str, Continuation<? super C14731> continuation) {
            super(2, continuation);
            this.$ePodType = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14731(this.$ePodType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (NodesModule.this._startScanner(this.$ePodType, this) == coroutine_suspended) {
                    return coroutine_suspended;
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

    @ReactMethod
    public final void startScanner(String ePodType) {
        Intrinsics.checkNotNullParameter(ePodType, "ePodType");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14731(ePodType, null), 3, null);
    }

    @ReactMethod
    public final void stopScanner() {
        LogInstrumentation.m2726d(this.TAG, "[stopScanner] Stopping scanner");
        BatScanner.stop$default(this.scanner, null, 1, null);
    }

    public final void _startAsav(String signerBaseUrl, String signerUrl, String userId, String token) {
        Intrinsics.checkNotNullParameter(signerBaseUrl, "signerBaseUrl");
        Intrinsics.checkNotNullParameter(signerUrl, "signerUrl");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(token, "token");
        LogInstrumentation.m2726d(this.TAG, "[_startAsav] Starting ASAV");
        LogInstrumentation.m2726d(this.TAG, "[_startAsav] signerBaseUrl=" + signerBaseUrl);
        LogInstrumentation.m2726d(this.TAG, "[_startAsav] signerUrl=" + signerUrl);
        try {
            AsavSettings asavSettings = this.asavModule.settings();
            asavSettings.setRSSIthreshold(-60);
            asavSettings.setAdvTimeInterval(500L);
            asavSettings.setSignerBaseUrl(signerBaseUrl);
            asavSettings.setSignerUrl(signerUrl);
            AsavSettings.Customer customer = asavSettings.getCustomer();
            customer.setId(userId);
            customer.setToken(token);
            this.asavModule.start(new IAsavResultListener() { // from class: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule._startAsav.2
                @Override // com.bat.sdk.asav.response.IAsavResultListener
                public void onSuccess(BatDevice batDevice) {
                    LogInstrumentation.m2726d(NodesModule.this.TAG, "[asavListener] onSuccess");
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf.putBoolean(FirebaseAnalytics.Param.SUCCESS, true);
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) NodesModule.this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onAsavSuccess", writableMapWritableMapOf);
                }

                @Override // com.bat.sdk.asav.response.IAsavResultListener
                public void onFailure(BatDevice batDevice, AsavException exception) {
                    LogInstrumentation.m2726d(NodesModule.this.TAG, "[asavListener] onFailure");
                    LogInstrumentation.m2728e(NodesModule.this.TAG, "Exception: " + (exception != null ? exception.getMessage() : null));
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf.putBoolean("failure", true);
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) NodesModule.this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onAsavFailure", writableMapWritableMapOf);
                }

                @Override // com.bat.sdk.asav.response.IAsavResultListener
                public void onTimeout() {
                    LogInstrumentation.m2726d(NodesModule.this.TAG, "[asavListener] onTimeout");
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf.putBoolean("timeout", true);
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) NodesModule.this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onAsavTimeout", writableMapWritableMapOf);
                }

                @Override // com.bat.sdk.asav.response.IAsavResultListener
                public void onAlreadyUnlocked() {
                    LogInstrumentation.m2726d(NodesModule.this.TAG, "[asavListener] onAlreadyUnlocked");
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf.putBoolean("alreadyUnlocked", true);
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) NodesModule.this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onAsavAlreadyUnlocked", writableMapWritableMapOf);
                }
            });
        } catch (Exception e) {
            LogInstrumentation.m2726d(this.TAG, "[_startAsav] " + e);
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$startAsav$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$startAsav$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $signerBaseUrl;
        final /* synthetic */ String $signerUrl;
        final /* synthetic */ String $token;
        final /* synthetic */ String $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14701(String str, String str2, String str3, String str4, Continuation<? super C14701> continuation) {
            super(2, continuation);
            this.$signerBaseUrl = str;
            this.$signerUrl = str2;
            this.$userId = str3;
            this.$token = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14701(this.$signerBaseUrl, this.$signerUrl, this.$userId, this.$token, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NodesModule.this._startAsav(this.$signerBaseUrl, this.$signerUrl, this.$userId, this.$token);
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void startAsav(String signerBaseUrl, String signerUrl, String userId, String token) {
        Intrinsics.checkNotNullParameter(signerBaseUrl, "signerBaseUrl");
        Intrinsics.checkNotNullParameter(signerUrl, "signerUrl");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(token, "token");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14701(signerBaseUrl, signerUrl, userId, token, null), 2, null);
    }

    public final Object _stopAsav(Continuation<? super Unit> continuation) {
        LogInstrumentation.m2726d(this.TAG, "[_stopAsav] Stopping ASAV");
        try {
            this.asavModule.stop();
        } catch (Exception e) {
            LogInstrumentation.m2726d(this.TAG, "[_stopAsav] " + e);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$stopAsav$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$stopAsav$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {1191}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C14741(Continuation<? super C14741> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14741(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (NodesModule.this._stopAsav(this) == coroutine_suspended) {
                    return coroutine_suspended;
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

    @ReactMethod
    public final void stopAsav() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14741(null), 2, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setLockInfo$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setLockInfo$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {1201}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ String $ePodType;
        final /* synthetic */ boolean $locked;
        final /* synthetic */ Callback $onError;
        final /* synthetic */ Callback $onSuccess;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14661(String str, boolean z, String str2, Callback callback, Callback callback2, Continuation<? super C14661> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$locked = z;
            this.$ePodType = str2;
            this.$onSuccess = callback;
            this.$onError = callback2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14661(this.$deviceAddress, this.$locked, this.$ePodType, this.$onSuccess, this.$onError, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    LogInstrumentation.m2726d(NodesModule.this.TAG, "[setLockInfo]set lock info");
                    this.label = 1;
                    obj = NodesModule.this.lockClient.read(this.$deviceAddress, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Lock lock = (Lock) obj;
                Lock lockCopy$default = lock != null ? Lock.copy$default(lock, this.$locked, 0, null, null, null, null, 62, null) : null;
                if (Intrinsics.areEqual(this.$ePodType, "ePod3")) {
                    lockCopy$default = lockCopy$default != null ? Lock.copy$default(lockCopy$default, this.$locked, 0, null, Boxing.boxBoolean(false), null, null, 54, null) : null;
                }
                LockClient lockClient = NodesModule.this.lockClient;
                String str = this.$deviceAddress;
                Intrinsics.checkNotNull(lockCopy$default);
                lockClient.write(str, lockCopy$default);
                WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                writableMapWritableMapOf.putBoolean("locked", lockCopy$default.getLocked());
                this.$onSuccess.invoke(writableMapWritableMapOf);
            } catch (Exception e) {
                WritableMap writableMapWritableMapOf2 = NodesModule.this.writableMapOf(new Pair[0]);
                writableMapWritableMapOf2.putString("error", e.toString());
                this.$onError.invoke(writableMapWritableMapOf2);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void setLockInfo(String ePodType, String deviceAddress, boolean locked, Callback onSuccess, Callback onError) {
        Intrinsics.checkNotNullParameter(ePodType, "ePodType");
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14661(deviceAddress, locked, ePodType, onSuccess, onError, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setAutolock$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setAutolock$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {1235}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bleTimeout;
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Callback $onError;
        final /* synthetic */ Callback $onSuccess;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14561(String str, String str2, Callback callback, Callback callback2, Continuation<? super C14561> continuation) {
            super(2, continuation);
            this.$bleTimeout = str;
            this.$deviceAddress = str2;
            this.$onSuccess = callback;
            this.$onError = callback2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14561(this.$bleTimeout, this.$deviceAddress, this.$onSuccess, this.$onError, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00c5 A[Catch: Exception -> 0x0011, TryCatch #0 {Exception -> 0x0011, blocks: (B:5:0x000c, B:55:0x00f2, B:57:0x00f7, B:58:0x0118, B:12:0x001f, B:14:0x0028, B:16:0x002e, B:18:0x0036, B:19:0x003e, B:21:0x0044, B:25:0x0057, B:27:0x005b, B:29:0x0061, B:35:0x009f, B:52:0x00de, B:42:0x00b3, B:51:0x00ce, B:45:0x00bc, B:48:0x00c5, B:32:0x008f, B:34:0x0097), top: B:63:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00ce A[Catch: Exception -> 0x0011, TryCatch #0 {Exception -> 0x0011, blocks: (B:5:0x000c, B:55:0x00f2, B:57:0x00f7, B:58:0x0118, B:12:0x001f, B:14:0x0028, B:16:0x002e, B:18:0x0036, B:19:0x003e, B:21:0x0044, B:25:0x0057, B:27:0x005b, B:29:0x0061, B:35:0x009f, B:52:0x00de, B:42:0x00b3, B:51:0x00ce, B:45:0x00bc, B:48:0x00c5, B:32:0x008f, B:34:0x0097), top: B:63:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00f1 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 365
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule.C14561.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @ReactMethod
    public final void setAutolock(String deviceAddress, String bleTimeout, Callback onSuccess, Callback onError) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(bleTimeout, "bleTimeout");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14561(bleTimeout, deviceAddress, onSuccess, onError, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getBleTimeoutInfo$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getBleTimeoutInfo$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {1262}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Callback $onError;
        final /* synthetic */ Callback $onSuccess;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14341(String str, Callback callback, Callback callback2, Continuation<? super C14341> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$onSuccess = callback;
            this.$onError = callback2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14341(this.$deviceAddress, this.$onSuccess, this.$onError, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Long bleTimeout;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    LogInstrumentation.m2726d(NodesModule.this.TAG, "[getBleTimeoutInfo] Reading ble timeout info for " + this.$deviceAddress);
                    this.label = 1;
                    obj = NodesModule.this.lockClient.read(this.$deviceAddress, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Lock lock = (Lock) obj;
                String string = (lock == null || (bleTimeout = lock.getBleTimeout()) == null) ? null : bleTimeout.toString();
                WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                writableMapWritableMapOf.putString("bleTimeout", string);
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getBleTimeoutInfo] data " + writableMapWritableMapOf);
                this.$onSuccess.invoke(writableMapWritableMapOf);
            } catch (Exception e) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getBleTimeoutInfo] error " + e);
                WritableMap writableMapWritableMapOf2 = NodesModule.this.writableMapOf(new Pair[0]);
                writableMapWritableMapOf2.putString("error", e.toString());
                this.$onError.invoke(writableMapWritableMapOf2);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void getBleTimeoutInfo(String deviceAddress, Callback onSuccess, Callback onError) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14341(deviceAddress, onSuccess, onError, null), 2, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$startProximityUnlock$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$startProximityUnlock$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $autoUnlock;
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Callback $onError;
        final /* synthetic */ Callback $onSuccess;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14711(boolean z, String str, Callback callback, Callback callback2, Continuation<? super C14711> continuation) {
            super(2, continuation);
            this.$autoUnlock = z;
            this.$deviceAddress = str;
            this.$onSuccess = callback;
            this.$onError = callback2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14711(this.$autoUnlock, this.$deviceAddress, this.$onSuccess, this.$onError, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    LogInstrumentation.m2726d(NodesModule.this.TAG, "[setLockInfo] autoUnlock " + this.$autoUnlock);
                    LogInstrumentation.m2726d(NodesModule.this.TAG, "[setLockInfo] deviceAddress " + this.$deviceAddress);
                    BtProximityUnlock.startReconnection$default(NodesModule.this.btProximityUnlock, this.$deviceAddress, 0L, this.$autoUnlock, 2, null);
                    this.$onSuccess.invoke(null);
                } catch (Exception e) {
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf.putString("error", e.toString());
                    this.$onError.invoke(writableMapWritableMapOf);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @ReactMethod
    public final void startProximityUnlock(String deviceAddress, boolean autoUnlock, Callback onSuccess, Callback onError) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14711(autoUnlock, deviceAddress, onSuccess, onError, null), 2, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$stopProximityUnlock$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$stopProximityUnlock$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Callback $onError;
        final /* synthetic */ Callback $onSuccess;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14751(Callback callback, Callback callback2, Continuation<? super C14751> continuation) {
            super(2, continuation);
            this.$onSuccess = callback;
            this.$onError = callback2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14751(this.$onSuccess, this.$onError, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    NodesModule.this.btProximityUnlock.stopReconnection();
                    NodesModule.this.settingsManager.cleanDeviceAddresses();
                    NodesModule.this.settingsManager.cleanAutoUnlockJobStart();
                    this.$onSuccess.invoke(null);
                } catch (Exception e) {
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf.putString("error", e.toString());
                    this.$onError.invoke(writableMapWritableMapOf);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @ReactMethod
    public final void stopProximityUnlock(Callback onSuccess, Callback onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14751(onSuccess, onError, null), 2, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$stopProximityUnlockForAddress$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$stopProximityUnlockForAddress$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Callback $onError;
        final /* synthetic */ Callback $onSuccess;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14761(String str, Callback callback, Callback callback2, Continuation<? super C14761> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$onSuccess = callback;
            this.$onError = callback2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14761(this.$deviceAddress, this.$onSuccess, this.$onError, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    NodesModule.this.btProximityUnlock.stopReconnectionForAddress(this.$deviceAddress);
                    NodesModule.this.settingsManager.cleanDeviceAddresses(this.$deviceAddress);
                    NodesModule.this.settingsManager.cleanAutoUnlockJobStart(this.$deviceAddress);
                    this.$onSuccess.invoke(null);
                } catch (Exception e) {
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf.putString("error", e.toString());
                    this.$onError.invoke(writableMapWritableMapOf);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @ReactMethod
    public final void stopProximityUnlockForAddress(String deviceAddress, Callback onSuccess, Callback onError) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14761(deviceAddress, onSuccess, onError, null), 2, null);
    }

    @ReactMethod
    public final void lock(String deviceAddress, Callback onSuccess, Callback onError) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        try {
            Lock lock = new Lock(true, 0, null, null, null, null, 62, null);
            this.lockClient.write(deviceAddress, lock);
            WritableMap writableMapWritableMapOf = writableMapOf(new Pair[0]);
            writableMapWritableMapOf.putBoolean("locked", lock.getLocked());
            onSuccess.invoke(writableMapWritableMapOf);
        } catch (Exception e) {
            WritableMap writableMapWritableMapOf2 = writableMapOf(new Pair[0]);
            writableMapWritableMapOf2.putString("error", e.toString());
            onError.invoke(writableMapWritableMapOf2);
        }
    }

    @ReactMethod
    public final void unlock(String deviceAddress, Callback onSuccess, Callback onError) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        try {
            Lock lock = new Lock(false, 0, null, null, null, null, 62, null);
            this.lockClient.write(deviceAddress, lock);
            WritableMap writableMapWritableMapOf = writableMapOf(new Pair[0]);
            writableMapWritableMapOf.putBoolean("locked", lock.getLocked());
            onSuccess.invoke(writableMapWritableMapOf);
        } catch (Exception e) {
            WritableMap writableMapWritableMapOf2 = writableMapOf(new Pair[0]);
            writableMapWritableMapOf2.putString("error", e.toString());
            onError.invoke(writableMapWritableMapOf2);
        }
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getDeviceInfo$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getDeviceInfo$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {1389}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14371(String str, Promise promise, Continuation<? super C14371> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14371(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:6:0x0011, B:17:0x0043, B:19:0x004a, B:21:0x0062, B:23:0x0096, B:24:0x00a7, B:26:0x00ad, B:27:0x00be, B:29:0x00c4, B:30:0x00cd, B:11:0x0020, B:13:0x0031), top: B:36:0x0009 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                Method dump skipped, instruction units count: 222
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule.C14371.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @ReactMethod
    public final void getDeviceInfo(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14371(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getAdvertisingNameAvailable$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getAdvertisingNameAvailable$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {1423}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14311(String str, Promise promise, Continuation<? super C14311> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14311(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    Object obj2 = NodesModule.this.deviceInfoClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                    obj = obj2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                DeviceInfo deviceInfo = (DeviceInfo) obj;
                Boolean boolBoxBoolean = deviceInfo != null ? Boxing.boxBoolean(NodesModule.this.deviceInfoClient.isAdvertisingNameAvailable(deviceInfo)) : null;
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getAdvertisingNameAvailable] data " + boolBoxBoolean);
                if (boolBoxBoolean != null) {
                    writableMap.putBoolean("isAdvertisingNameAvailable", boolBoxBoolean.booleanValue());
                }
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void getAdvertisingNameAvailable(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14311(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getDeviceMss$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getDeviceMss$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {1445}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14381(String str, Promise promise, Continuation<? super C14381> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14381(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14381) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    Object deviceMSSPayload = NodesModule.this.deviceInfoClient.getDeviceMSSPayload(this.$deviceAddress, this);
                    if (deviceMSSPayload == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                    obj = deviceMSSPayload;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                MssVersion mssVersion = (MssVersion) obj;
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getDeviceMss] data " + mssVersion);
                if (mssVersion != null) {
                    writableMap.putInt("code", mssVersion.getCode());
                    writableMap.putString("codeHex", mssVersion.getCodeHex());
                    writableMap.putInt("payload", mssVersion.getPayload());
                    writableMap.putString("payloadHex", mssVersion.getPayloadHex());
                }
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void getDeviceMss(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14381(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getLockInfo$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getLockInfo$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {1468}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14421(String str, Promise promise, Continuation<? super C14421> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14421(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    Object obj2 = NodesModule.this.lockClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                    obj = obj2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Lock lock = (Lock) obj;
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getLockInfo] data " + lock);
                if (lock != null) {
                    writableMap.putBoolean("locked", lock.getLocked());
                }
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void getLockInfo(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14421(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getBatteryInfo$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getBatteryInfo$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {1487}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14331(String str, Promise promise, Continuation<? super C14331> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14331(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    Object obj2 = NodesModule.this.batteryClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                    obj = obj2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Battery battery = (Battery) obj;
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getBatteryInfo] data " + battery);
                if (battery != null) {
                    writableMap.putInt(FirebaseAnalytics.Param.LEVEL, battery.getLevel());
                    writableMap.putBoolean("isCharging", battery.getChargingState() != 0);
                }
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void getBatteryInfo(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14331(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getCloudInfo$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getCloudInfo$1", m5608f = "NodesModule.kt", m5609i = {0, 1, 1}, m5610l = {1507, 1510}, m5611m = "invokeSuspend", m5612n = {"data", "data", "cloudInfoData"}, m5613s = {"L$0", "L$0", "L$1"})
    static final class C14361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ String $ePodType;
        final /* synthetic */ Promise $promise;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14361(String str, String str2, Promise promise, Continuation<? super C14361> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$ePodType = str2;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14361(this.$deviceAddress, this.$ePodType, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00f2 A[Catch: Exception -> 0x0210, TryCatch #0 {Exception -> 0x0210, blocks: (B:7:0x0026, B:24:0x0085, B:27:0x00a1, B:29:0x00ab, B:31:0x00b8, B:34:0x00c7, B:36:0x00d1, B:40:0x00f2, B:42:0x00fc, B:43:0x0106, B:45:0x0124, B:47:0x012a, B:49:0x0142, B:51:0x0148, B:53:0x0160, B:55:0x0166, B:57:0x017e, B:58:0x0182, B:60:0x0194, B:63:0x019c, B:65:0x01b2, B:67:0x01b8, B:68:0x01c8, B:70:0x01ce, B:71:0x01de, B:73:0x01e4, B:74:0x01f4, B:76:0x01fa, B:64:0x01ab, B:77:0x020a, B:12:0x0039, B:18:0x0060, B:20:0x006c, B:15:0x0042), top: B:83:0x0018 }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0124 A[Catch: Exception -> 0x0210, TryCatch #0 {Exception -> 0x0210, blocks: (B:7:0x0026, B:24:0x0085, B:27:0x00a1, B:29:0x00ab, B:31:0x00b8, B:34:0x00c7, B:36:0x00d1, B:40:0x00f2, B:42:0x00fc, B:43:0x0106, B:45:0x0124, B:47:0x012a, B:49:0x0142, B:51:0x0148, B:53:0x0160, B:55:0x0166, B:57:0x017e, B:58:0x0182, B:60:0x0194, B:63:0x019c, B:65:0x01b2, B:67:0x01b8, B:68:0x01c8, B:70:0x01ce, B:71:0x01de, B:73:0x01e4, B:74:0x01f4, B:76:0x01fa, B:64:0x01ab, B:77:0x020a, B:12:0x0039, B:18:0x0060, B:20:0x006c, B:15:0x0042), top: B:83:0x0018 }] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0142 A[Catch: Exception -> 0x0210, TryCatch #0 {Exception -> 0x0210, blocks: (B:7:0x0026, B:24:0x0085, B:27:0x00a1, B:29:0x00ab, B:31:0x00b8, B:34:0x00c7, B:36:0x00d1, B:40:0x00f2, B:42:0x00fc, B:43:0x0106, B:45:0x0124, B:47:0x012a, B:49:0x0142, B:51:0x0148, B:53:0x0160, B:55:0x0166, B:57:0x017e, B:58:0x0182, B:60:0x0194, B:63:0x019c, B:65:0x01b2, B:67:0x01b8, B:68:0x01c8, B:70:0x01ce, B:71:0x01de, B:73:0x01e4, B:74:0x01f4, B:76:0x01fa, B:64:0x01ab, B:77:0x020a, B:12:0x0039, B:18:0x0060, B:20:0x006c, B:15:0x0042), top: B:83:0x0018 }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0147  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0160 A[Catch: Exception -> 0x0210, TryCatch #0 {Exception -> 0x0210, blocks: (B:7:0x0026, B:24:0x0085, B:27:0x00a1, B:29:0x00ab, B:31:0x00b8, B:34:0x00c7, B:36:0x00d1, B:40:0x00f2, B:42:0x00fc, B:43:0x0106, B:45:0x0124, B:47:0x012a, B:49:0x0142, B:51:0x0148, B:53:0x0160, B:55:0x0166, B:57:0x017e, B:58:0x0182, B:60:0x0194, B:63:0x019c, B:65:0x01b2, B:67:0x01b8, B:68:0x01c8, B:70:0x01ce, B:71:0x01de, B:73:0x01e4, B:74:0x01f4, B:76:0x01fa, B:64:0x01ab, B:77:0x020a, B:12:0x0039, B:18:0x0060, B:20:0x006c, B:15:0x0042), top: B:83:0x0018 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x017e A[Catch: Exception -> 0x0210, TryCatch #0 {Exception -> 0x0210, blocks: (B:7:0x0026, B:24:0x0085, B:27:0x00a1, B:29:0x00ab, B:31:0x00b8, B:34:0x00c7, B:36:0x00d1, B:40:0x00f2, B:42:0x00fc, B:43:0x0106, B:45:0x0124, B:47:0x012a, B:49:0x0142, B:51:0x0148, B:53:0x0160, B:55:0x0166, B:57:0x017e, B:58:0x0182, B:60:0x0194, B:63:0x019c, B:65:0x01b2, B:67:0x01b8, B:68:0x01c8, B:70:0x01ce, B:71:0x01de, B:73:0x01e4, B:74:0x01f4, B:76:0x01fa, B:64:0x01ab, B:77:0x020a, B:12:0x0039, B:18:0x0060, B:20:0x006c, B:15:0x0042), top: B:83:0x0018 }] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0194 A[Catch: Exception -> 0x0210, TRY_LEAVE, TryCatch #0 {Exception -> 0x0210, blocks: (B:7:0x0026, B:24:0x0085, B:27:0x00a1, B:29:0x00ab, B:31:0x00b8, B:34:0x00c7, B:36:0x00d1, B:40:0x00f2, B:42:0x00fc, B:43:0x0106, B:45:0x0124, B:47:0x012a, B:49:0x0142, B:51:0x0148, B:53:0x0160, B:55:0x0166, B:57:0x017e, B:58:0x0182, B:60:0x0194, B:63:0x019c, B:65:0x01b2, B:67:0x01b8, B:68:0x01c8, B:70:0x01ce, B:71:0x01de, B:73:0x01e4, B:74:0x01f4, B:76:0x01fa, B:64:0x01ab, B:77:0x020a, B:12:0x0039, B:18:0x0060, B:20:0x006c, B:15:0x0042), top: B:83:0x0018 }] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 539
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule.C14361.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @ReactMethod
    public final void getCloudInfo(String ePodType, String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(ePodType, "ePodType");
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14361(deviceAddress, ePodType, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getHistorySyncStatus$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getHistorySyncStatus$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14401(String str, Promise promise, Continuation<? super C14401> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14401(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                Set set = NodesModule.this.historyModeDevices;
                Intrinsics.checkNotNullExpressionValue(set, "access$getHistoryModeDevices$p(...)");
                NodesModule nodesModule = NodesModule.this;
                String str = this.$deviceAddress;
                synchronized (set) {
                    booleanRef.element = nodesModule.historyModeDevices.contains(str);
                    Unit unit = Unit.INSTANCE;
                }
                writableMapWritableMapOf.putString("deviceAddress", this.$deviceAddress);
                writableMapWritableMapOf.putBoolean("isSyncingHistory", booleanRef.element);
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getHistorySyncStatus] data: " + writableMapWritableMapOf);
                this.$promise.resolve(writableMapWritableMapOf);
            } catch (Exception e) {
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getHistorySyncStatus] e: " + e);
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void getHistorySyncStatus(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14401(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setCloudInfo$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setCloudInfo$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {1595}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Boolean $batterySaverEnabled;
        final /* synthetic */ Integer $batterySavingEnabled;
        final /* synthetic */ Integer $batterySavingPowerLevel;
        final /* synthetic */ Integer $batterySavingThresholdValue;
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ String $ePodType;
        final /* synthetic */ int $level;
        final /* synthetic */ Boolean $lowPowerMode;
        final /* synthetic */ Boolean $powerSaveModeEnable;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14621(String str, Integer num, Integer num2, Integer num3, int i, Boolean bool, String str2, Boolean bool2, Boolean bool3, Promise promise, Continuation<? super C14621> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$batterySavingEnabled = num;
            this.$batterySavingThresholdValue = num2;
            this.$batterySavingPowerLevel = num3;
            this.$level = i;
            this.$powerSaveModeEnable = bool;
            this.$ePodType = str2;
            this.$batterySaverEnabled = bool2;
            this.$lowPowerMode = bool3;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14621(this.$deviceAddress, this.$batterySavingEnabled, this.$batterySavingThresholdValue, this.$batterySavingPowerLevel, this.$level, this.$powerSaveModeEnable, this.$ePodType, this.$batterySaverEnabled, this.$lowPowerMode, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0139  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x01e4  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r43) {
            /*
                Method dump skipped, instruction units count: 762
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule.C14621.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @ReactMethod
    public final void setCloudInfo(String ePodType, String deviceAddress, int level, Integer batterySavingEnabled, Integer batterySavingThresholdValue, Integer batterySavingPowerLevel, Boolean batterySaverEnabled, Boolean lowPowerMode, Boolean powerSaveModeEnable, Promise promise) {
        Intrinsics.checkNotNullParameter(ePodType, "ePodType");
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14621(deviceAddress, batterySavingEnabled, batterySavingThresholdValue, batterySavingPowerLevel, level, powerSaveModeEnable, ePodType, batterySaverEnabled, lowPowerMode, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setAutotune$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setAutotune$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {1674}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ boolean $isActive;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14571(String str, boolean z, Promise promise, Continuation<? super C14571> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$isActive = z;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14571(this.$deviceAddress, this.$isActive, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    obj2 = NodesModule.this.cloudClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                }
                Cloud cloud = (Cloud) obj2;
                Cloud cloudCopy$default = cloud != null ? Cloud.copy$default(cloud, 0, null, null, null, null, Boxing.boxInt(!this.$isActive ? 1 : 0), null, 95, null) : null;
                CloudClient cloudClient = NodesModule.this.cloudClient;
                String str = this.$deviceAddress;
                Intrinsics.checkNotNull(cloudCopy$default);
                cloudClient.write(str, cloudCopy$default);
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[setAutotune] data " + NodesModule.this.cloudClient);
                Integer heatingPowerMode = cloudCopy$default.getHeatingPowerMode();
                Intrinsics.checkNotNull(heatingPowerMode);
                writableMap.putInt("heatingPowerMode", heatingPowerMode.intValue());
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void setAutotune(String deviceAddress, boolean isActive, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14571(deviceAddress, isActive, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setFindVapeConfig$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setFindVapeConfig$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {1701}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ String $ePodType;
        final /* synthetic */ boolean $isAlerting;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $seconds;
        Object L$0;
        int label;
        final /* synthetic */ NodesModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14631(String str, boolean z, int i, NodesModule nodesModule, String str2, Promise promise, Continuation<? super C14631> continuation) {
            super(2, continuation);
            this.$ePodType = str;
            this.$isAlerting = z;
            this.$seconds = i;
            this.this$0 = nodesModule;
            this.$deviceAddress = str2;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C14631(this.$ePodType, this.$isAlerting, this.$seconds, this.this$0, this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMapWritableMapOf;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.findVapeClient.write(this.$deviceAddress, (Intrinsics.areEqual(this.$ePodType, "ePod3") || Intrinsics.areEqual(this.$ePodType, "SmartBox")) ? new FindVape(this.$isAlerting, this.$seconds, Boxing.boxInt(0)) : new FindVape(this.$isAlerting, this.$seconds, null, 4, null));
                    LogInstrumentation.m2726d(this.this$0.TAG, "[setFindVapeConfig] isAlerting=" + this.$isAlerting + " | seconds=" + this.$seconds);
                    writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    obj = this.this$0.findVapeClient.read(this.$deviceAddress, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMapWritableMapOf = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                FindVape findVape = (FindVape) obj;
                LogInstrumentation.m2726d(this.this$0.TAG, "[setFindVapeConfig] data " + findVape);
                if (findVape != null) {
                    writableMapWritableMapOf.putBoolean("isAlerting", findVape.isAlerting());
                    writableMapWritableMapOf.putInt("seconds", findVape.getSeconds());
                }
                this.$promise.resolve(writableMapWritableMapOf);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void setFindVapeConfig(String ePodType, String deviceAddress, boolean isAlerting, int seconds, Promise promise) {
        Intrinsics.checkNotNullParameter(ePodType, "ePodType");
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14631(ePodType, isAlerting, seconds, this, deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setLed$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setLed$1", m5608f = "NodesModule.kt", m5609i = {1, 1}, m5610l = {1720, 1737}, m5611m = "invokeSuspend", m5612n = {"ledData", "data"}, m5613s = {"L$0", "L$1"})
    static final class C14651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ String $deviceType;
        final /* synthetic */ int $level;
        final /* synthetic */ Promise $promise;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14651(String str, String str2, int i, Promise promise, Continuation<? super C14651> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$deviceType = str2;
            this.$level = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14651(this.$deviceAddress, this.$deviceType, this.$level, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMapWritableMapOf;
            Led ledCopy$default;
            Led led;
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = NodesModule.this.ledClient.read(this.$deviceAddress, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$1;
                    led = (Led) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    writableMap.putInt("ledLevel", led.getBrightnessLevel());
                    writableMapWritableMapOf = writableMap;
                    this.$promise.resolve(writableMapWritableMapOf);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            Led led2 = (Led) obj;
            writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
            if (led2 != null) {
                if (Intrinsics.areEqual(this.$deviceType, "SmartBox")) {
                    ledCopy$default = Led.copy$default(led2, 0, Boxing.boxInt(25), Boxing.boxInt(this.$level), 1, null);
                } else {
                    ledCopy$default = Led.copy$default(led2, this.$level, null, null, 6, null);
                }
                NodesModule.this.ledClient.write(this.$deviceAddress, ledCopy$default);
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[setLed] data " + ledCopy$default);
                if (!Intrinsics.areEqual(this.$deviceType, "SmartBox")) {
                    this.L$0 = ledCopy$default;
                    this.L$1 = writableMapWritableMapOf;
                    this.label = 2;
                    Object obj2 = NodesModule.this.ledClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    led = ledCopy$default;
                    writableMap = writableMapWritableMapOf;
                    obj = obj2;
                    writableMap.putInt("ledLevel", led.getBrightnessLevel());
                    writableMapWritableMapOf = writableMap;
                } else {
                    Integer screenSettingBrightness = ledCopy$default.getScreenSettingBrightness();
                    if (screenSettingBrightness != null) {
                        writableMapWritableMapOf.putInt("ledLevel", screenSettingBrightness.intValue());
                    }
                }
            }
            this.$promise.resolve(writableMapWritableMapOf);
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void setLed(String deviceAddress, int level, String deviceType, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14651(deviceAddress, deviceType, level, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getLed$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getLed$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {1753}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ String $deviceType;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14411(String str, String str2, Promise promise, Continuation<? super C14411> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$deviceType = str2;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14411(this.$deviceAddress, this.$deviceType, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    Object obj2 = NodesModule.this.ledClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                    obj = obj2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Led led = (Led) obj;
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getLed] data " + led);
                if (led != null) {
                    if (Intrinsics.areEqual(this.$deviceType, "SmartBox")) {
                        Integer screenSettingBrightness = led.getScreenSettingBrightness();
                        if (screenSettingBrightness != null) {
                            writableMap.putInt("ledLevel", screenSettingBrightness.intValue());
                        }
                    } else {
                        writableMap.putInt("ledLevel", led.getBrightnessLevel());
                    }
                }
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void getLed(String deviceAddress, String deviceType, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14411(deviceAddress, deviceType, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setHapticLevel$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setHapticLevel$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {1780}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ int $intensity;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;
        final /* synthetic */ NodesModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14641(int i, NodesModule nodesModule, String str, Promise promise, Continuation<? super C14641> continuation) {
            super(2, continuation);
            this.$intensity = i;
            this.this$0 = nodesModule;
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C14641(this.$intensity, this.this$0, this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.hapticClient.write(this.$deviceAddress, new Haptic(this.$intensity));
                    WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    Object obj2 = this.this$0.hapticClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                    obj = obj2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Haptic haptic = (Haptic) obj;
                LogInstrumentation.m2726d(this.this$0.TAG, "[setHapticLevel] data " + haptic);
                if (haptic != null) {
                    writableMap.putInt("hapticLevel", haptic.getLevel());
                }
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void setHapticLevel(String deviceAddress, int intensity, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14641(intensity, this, deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getHapticLevel$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getHapticLevel$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {1800}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14391(String str, Promise promise, Continuation<? super C14391> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14391(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    Object obj2 = NodesModule.this.hapticClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                    obj = obj2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Haptic haptic = (Haptic) obj;
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getHapticLevel] data " + haptic);
                if (haptic != null) {
                    writableMap.putInt("hapticLevel", haptic.getLevel());
                }
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void getHapticLevel(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14391(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setBuzzLevel$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setBuzzLevel$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {1823}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $volume;
        Object L$0;
        int label;
        final /* synthetic */ NodesModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14611(int i, NodesModule nodesModule, String str, Promise promise, Continuation<? super C14611> continuation) {
            super(2, continuation);
            this.$volume = i;
            this.this$0 = nodesModule;
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C14611(this.$volume, this.this$0, this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.buzzerClient.write(this.$deviceAddress, new Buzzer(this.$volume));
                    WritableMap writableMapWritableMapOf = this.this$0.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    Object obj2 = this.this$0.buzzerClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                    obj = obj2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Buzzer buzzer = (Buzzer) obj;
                LogInstrumentation.m2726d(this.this$0.TAG, "[setBuzzLevel] data " + buzzer);
                if (buzzer != null) {
                    writableMap.putInt("buzzLevel", buzzer.getLoudness());
                }
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void setBuzzLevel(String deviceAddress, int volume, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14611(volume, this, deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getBuzzLevel$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getBuzzLevel$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {1843}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14351(String str, Promise promise, Continuation<? super C14351> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14351(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    Object obj2 = NodesModule.this.buzzerClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                    obj = obj2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Buzzer buzzer = (Buzzer) obj;
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getBuzzLevel] data " + buzzer);
                if (buzzer != null) {
                    writableMap.putInt("buzzLevel", buzzer.getLoudness());
                }
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void getBuzzLevel(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14351(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$isVrrSupported$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$isVrrSupported$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14511(String str, Promise promise, Continuation<? super C14511> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14511(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    boolean zIsAvailable = NodesModule.this.rechargeRemindersClient.isAvailable(this.$deviceAddress);
                    LogInstrumentation.m2726d(NodesModule.this.TAG, "[isVrrSupported] " + zIsAvailable);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf.putBoolean("isSupported", zIsAvailable);
                    this.$promise.resolve(writableMapWritableMapOf);
                } catch (Exception e) {
                    this.$promise.reject(e);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @ReactMethod
    public final void isVrrSupported(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14511(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$isUASupported$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$isUASupported$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14501(String str, Promise promise, Continuation<? super C14501> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14501(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    boolean zIsAvailable = NodesModule.this.usageReminderClient.isAvailable(this.$deviceAddress);
                    LogInstrumentation.m2726d(NodesModule.this.TAG, "[isUASupported] " + zIsAvailable);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    writableMapWritableMapOf.putBoolean("isSupported", zIsAvailable);
                    this.$promise.resolve(writableMapWritableMapOf);
                } catch (Exception e) {
                    this.$promise.reject(e);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @ReactMethod
    public final void isUASupported(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14501(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getUsageGoal$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getUsageGoal$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {DatesArrayBuilder.MINIMUM_YEAR_DEFAULT}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14471(String str, Promise promise, Continuation<? super C14471> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14471(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    Object obj2 = NodesModule.this.usageReminderClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                    obj = obj2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                UsageReminder usageReminder = (UsageReminder) obj;
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getUsageGoal] data " + usageReminder);
                if (usageReminder != null) {
                    writableMap.putInt("usageGoal", usageReminder.getUsageGoal());
                }
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void getUsageGoal(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14471(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setUsageGoal$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setUsageGoal$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {1919}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $usageGoal;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14691(String str, int i, Promise promise, Continuation<? super C14691> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$usageGoal = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14691(this.$deviceAddress, this.$usageGoal, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj2 = NodesModule.this.usageReminderClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                }
                UsageReminder usageReminder = (UsageReminder) obj2;
                UsageReminder usageReminderCopy = usageReminder != null ? usageReminder.copy((4063 & 1) != 0 ? usageReminder.usageGoal : this.$usageGoal, (4063 & 2) != 0 ? usageReminder.runCycle : 0, (4063 & 4) != 0 ? usageReminder.timeZone : null, (4063 & 8) != 0 ? usageReminder.alertType : 0, (4063 & 16) != 0 ? usageReminder.alertDuration : 0, (4063 & 32) != 0 ? usageReminder.alertDemo : false, (4063 & 64) != 0 ? usageReminder.soundPattern : 0, (4063 & 128) != 0 ? usageReminder.ledColor : null, (4063 & 256) != 0 ? usageReminder.ledOnDuration : null, (4063 & 512) != 0 ? usageReminder.ledOffDuration : null, (4063 & 1024) != 0 ? usageReminder.hapticOnDuration : 0, (4063 & 2048) != 0 ? usageReminder.hapticOffDuration : 0) : null;
                String str = NodesModule.this.TAG;
                Intrinsics.checkNotNull(usageReminderCopy);
                LogInstrumentation.m2726d(str, "[setUsageGoal] data " + usageReminderCopy);
                NodesModule.this.usageReminderClient.write(this.$deviceAddress, usageReminderCopy);
                WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[setUsageGoal] usageGoal " + usageReminderCopy.getUsageGoal());
                writableMapWritableMapOf.putInt("usageGoal", usageReminderCopy.getUsageGoal());
                this.$promise.resolve(writableMapWritableMapOf);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void setUsageGoal(String deviceAddress, int usageGoal, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14691(deviceAddress, usageGoal, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getRunCycle$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getRunCycle$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {1944}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14451(String str, Promise promise, Continuation<? super C14451> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14451(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    Object obj2 = NodesModule.this.usageReminderClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                    obj = obj2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                UsageReminder usageReminder = (UsageReminder) obj;
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[runCycle] data " + usageReminder);
                if (usageReminder != null) {
                    writableMap.putInt("runCycle", usageReminder.getRunCycle());
                }
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void getRunCycle(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14451(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setRunCycle$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setRunCycle$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {1963}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $runCycle;
        final /* synthetic */ boolean $timezoneBoolean;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14671(String str, boolean z, int i, Promise promise, Continuation<? super C14671> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$timezoneBoolean = z;
            this.$runCycle = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14671(this.$deviceAddress, this.$timezoneBoolean, this.$runCycle, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj2 = NodesModule.this.usageReminderClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                }
                UsageReminder usageReminderCopy = (UsageReminder) obj2;
                int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 60000;
                if (this.$timezoneBoolean) {
                    Intrinsics.checkNotNull(usageReminderCopy);
                    usageReminderCopy = usageReminderCopy.copy((4063 & 1) != 0 ? usageReminderCopy.usageGoal : 0, (4063 & 2) != 0 ? usageReminderCopy.runCycle : 0, (4063 & 4) != 0 ? usageReminderCopy.timeZone : Boxing.boxShort((short) offset), (4063 & 8) != 0 ? usageReminderCopy.alertType : 0, (4063 & 16) != 0 ? usageReminderCopy.alertDuration : 0, (4063 & 32) != 0 ? usageReminderCopy.alertDemo : false, (4063 & 64) != 0 ? usageReminderCopy.soundPattern : 0, (4063 & 128) != 0 ? usageReminderCopy.ledColor : null, (4063 & 256) != 0 ? usageReminderCopy.ledOnDuration : null, (4063 & 512) != 0 ? usageReminderCopy.ledOffDuration : null, (4063 & 1024) != 0 ? usageReminderCopy.hapticOnDuration : 0, (4063 & 2048) != 0 ? usageReminderCopy.hapticOffDuration : 0);
                }
                UsageReminder usageReminder = usageReminderCopy;
                UsageReminder usageReminderCopy2 = usageReminder != null ? usageReminder.copy((4063 & 1) != 0 ? usageReminder.usageGoal : 0, (4063 & 2) != 0 ? usageReminder.runCycle : this.$runCycle, (4063 & 4) != 0 ? usageReminder.timeZone : null, (4063 & 8) != 0 ? usageReminder.alertType : 0, (4063 & 16) != 0 ? usageReminder.alertDuration : 0, (4063 & 32) != 0 ? usageReminder.alertDemo : false, (4063 & 64) != 0 ? usageReminder.soundPattern : 0, (4063 & 128) != 0 ? usageReminder.ledColor : null, (4063 & 256) != 0 ? usageReminder.ledOnDuration : null, (4063 & 512) != 0 ? usageReminder.ledOffDuration : null, (4063 & 1024) != 0 ? usageReminder.hapticOnDuration : 0, (4063 & 2048) != 0 ? usageReminder.hapticOffDuration : 0) : null;
                String str = NodesModule.this.TAG;
                Intrinsics.checkNotNull(usageReminderCopy2);
                LogInstrumentation.m2726d(str, "[setRunCycle] data " + usageReminderCopy2);
                NodesModule.this.usageReminderClient.write(this.$deviceAddress, usageReminderCopy2);
                WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[setRunCycle] runCycle " + usageReminderCopy2.getRunCycle());
                if (this.$timezoneBoolean) {
                    LogInstrumentation.m2726d(NodesModule.this.TAG, "[setRunCycle] timeZone " + usageReminderCopy2.getTimeZone());
                }
                writableMapWritableMapOf.putInt("runCycle", usageReminderCopy2.getRunCycle());
                this.$promise.resolve(writableMapWritableMapOf);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void setRunCycle(String deviceAddress, int runCycle, boolean timezoneBoolean, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14671(deviceAddress, timezoneBoolean, runCycle, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setBatteryAlertThreshold$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setBatteryAlertThreshold$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {1997}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ int $maxBatteryThr;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14591(String str, int i, Promise promise, Continuation<? super C14591> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$maxBatteryThr = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14591(this.$deviceAddress, this.$maxBatteryThr, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = NodesModule.this.rechargeRemindersClient.read(this.$deviceAddress, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                RechargeReminder rechargeReminder = (RechargeReminder) obj;
                RechargeReminder rechargeReminderCopy = rechargeReminder != null ? rechargeReminder.copy((255 & 1) != 0 ? rechargeReminder.minBatteryThr : 0, (255 & 2) != 0 ? rechargeReminder.maxBatteryThr : this.$maxBatteryThr, (255 & 4) != 0 ? rechargeReminder.ledColorMin : null, (255 & 8) != 0 ? rechargeReminder.ledColorMid : null, (255 & 16) != 0 ? rechargeReminder.ledColorMax : null, (255 & 32) != 0 ? rechargeReminder.alertType : 0, (255 & 64) != 0 ? rechargeReminder.alertTrigger : 0, (255 & 128) != 0 ? rechargeReminder.alertDuration : 0, (255 & 256) != 0 ? rechargeReminder.alertDemo : false) : null;
                RechargeRemindersClient rechargeRemindersClient = NodesModule.this.rechargeRemindersClient;
                String str = this.$deviceAddress;
                Intrinsics.checkNotNull(rechargeReminderCopy);
                rechargeRemindersClient.write(str, rechargeReminderCopy);
                WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[setBatteryAlertThreshold] data " + rechargeReminderCopy.getMaxBatteryThr());
                writableMapWritableMapOf.putInt("maxBatteryThr", rechargeReminderCopy.getMaxBatteryThr());
                this.$promise.resolve(writableMapWritableMapOf);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void setBatteryAlertThreshold(String deviceAddress, int maxBatteryThr, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14591(deviceAddress, maxBatteryThr, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setUsageAlertType$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setUsageAlertType$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {2019}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $alertType;
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14681(String str, int i, Promise promise, Continuation<? super C14681> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$alertType = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14681(this.$deviceAddress, this.$alertType, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj2 = NodesModule.this.usageReminderClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                }
                UsageReminder usageReminder = (UsageReminder) obj2;
                UsageReminder usageReminderCopy = usageReminder != null ? usageReminder.copy((4063 & 1) != 0 ? usageReminder.usageGoal : 0, (4063 & 2) != 0 ? usageReminder.runCycle : 0, (4063 & 4) != 0 ? usageReminder.timeZone : null, (4063 & 8) != 0 ? usageReminder.alertType : this.$alertType, (4063 & 16) != 0 ? usageReminder.alertDuration : 0, (4063 & 32) != 0 ? usageReminder.alertDemo : false, (4063 & 64) != 0 ? usageReminder.soundPattern : 0, (4063 & 128) != 0 ? usageReminder.ledColor : null, (4063 & 256) != 0 ? usageReminder.ledOnDuration : null, (4063 & 512) != 0 ? usageReminder.ledOffDuration : null, (4063 & 1024) != 0 ? usageReminder.hapticOnDuration : 0, (4063 & 2048) != 0 ? usageReminder.hapticOffDuration : 0) : null;
                UsageReminderClient usageReminderClient = NodesModule.this.usageReminderClient;
                String str = this.$deviceAddress;
                Intrinsics.checkNotNull(usageReminderCopy);
                usageReminderClient.write(str, usageReminderCopy);
                WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[setUsageAlertType] data " + usageReminderCopy.getAlertType());
                writableMapWritableMapOf.putInt("alertType", usageReminderCopy.getAlertType());
                this.$promise.resolve(writableMapWritableMapOf);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void setUsageAlertType(String deviceAddress, int alertType, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14681(deviceAddress, alertType, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getUsageAlertType$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getUsageAlertType$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {2044}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14461(String str, Promise promise, Continuation<? super C14461> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14461(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    Object obj2 = NodesModule.this.usageReminderClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                    obj = obj2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                UsageReminder usageReminder = (UsageReminder) obj;
                if (usageReminder != null) {
                    writableMap.putInt("alertType", usageReminder.getAlertType());
                }
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getUsageAlertType] data " + writableMap);
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void getUsageAlertType(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14461(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setBatteryAlertType$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setBatteryAlertType$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {2064}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $alertType;
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14601(String str, int i, Promise promise, Continuation<? super C14601> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$alertType = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14601(this.$deviceAddress, this.$alertType, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = NodesModule.this.rechargeRemindersClient.read(this.$deviceAddress, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                RechargeReminder rechargeReminder = (RechargeReminder) obj;
                RechargeReminder rechargeReminderCopy = rechargeReminder != null ? rechargeReminder.copy((255 & 1) != 0 ? rechargeReminder.minBatteryThr : 0, (255 & 2) != 0 ? rechargeReminder.maxBatteryThr : 0, (255 & 4) != 0 ? rechargeReminder.ledColorMin : null, (255 & 8) != 0 ? rechargeReminder.ledColorMid : null, (255 & 16) != 0 ? rechargeReminder.ledColorMax : null, (255 & 32) != 0 ? rechargeReminder.alertType : this.$alertType, (255 & 64) != 0 ? rechargeReminder.alertTrigger : 0, (255 & 128) != 0 ? rechargeReminder.alertDuration : 0, (255 & 256) != 0 ? rechargeReminder.alertDemo : false) : null;
                RechargeRemindersClient rechargeRemindersClient = NodesModule.this.rechargeRemindersClient;
                String str = this.$deviceAddress;
                Intrinsics.checkNotNull(rechargeReminderCopy);
                rechargeRemindersClient.write(str, rechargeReminderCopy);
                WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[setBatteryAlertType] data " + rechargeReminderCopy.getAlertType());
                writableMapWritableMapOf.putInt("alertType", rechargeReminderCopy.getAlertType());
                this.$promise.resolve(writableMapWritableMapOf);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void setBatteryAlertType(String deviceAddress, int alertType, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14601(deviceAddress, alertType, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getRechargeRemindersData$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getRechargeRemindersData$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {2089}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14441(String str, Promise promise, Continuation<? super C14441> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14441(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    Object obj2 = NodesModule.this.rechargeRemindersClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                    obj = obj2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                RechargeReminder rechargeReminder = (RechargeReminder) obj;
                if (rechargeReminder != null) {
                    writableMap.putInt("alertType", rechargeReminder.getAlertType());
                    writableMap.putInt("maxBatteryThr", rechargeReminder.getMaxBatteryThr());
                }
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getRechargeRemindersData] data " + writableMap);
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void getRechargeRemindersData(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14441(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$previewBatteryAlert$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$previewBatteryAlert$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {2110}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14521(String str, Promise promise, Continuation<? super C14521> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14521(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            RechargeReminder rechargeReminderCopy;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj2 = NodesModule.this.rechargeRemindersClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                }
                RechargeReminder rechargeReminder = (RechargeReminder) obj2;
                if (rechargeReminder != null) {
                    rechargeReminderCopy = rechargeReminder.copy((255 & 1) != 0 ? rechargeReminder.minBatteryThr : 0, (255 & 2) != 0 ? rechargeReminder.maxBatteryThr : 0, (255 & 4) != 0 ? rechargeReminder.ledColorMin : null, (255 & 8) != 0 ? rechargeReminder.ledColorMid : null, (255 & 16) != 0 ? rechargeReminder.ledColorMax : null, (255 & 32) != 0 ? rechargeReminder.alertType : 0, (255 & 64) != 0 ? rechargeReminder.alertTrigger : 0, (255 & 128) != 0 ? rechargeReminder.alertDuration : 0, (255 & 256) != 0 ? rechargeReminder.alertDemo : true);
                } else {
                    rechargeReminderCopy = null;
                }
                RechargeRemindersClient rechargeRemindersClient = NodesModule.this.rechargeRemindersClient;
                String str = this.$deviceAddress;
                Intrinsics.checkNotNull(rechargeReminderCopy);
                rechargeRemindersClient.write(str, rechargeReminderCopy);
                WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[previewBatteryAlert]");
                writableMapWritableMapOf.putBoolean("alertDemo", true);
                this.$promise.resolve(writableMapWritableMapOf);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void previewBatteryAlert(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14521(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$previewUsageAlert$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$previewUsageAlert$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {2132}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14531(String str, Promise promise, Continuation<? super C14531> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14531(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            UsageReminder usageReminderCopy;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj2 = NodesModule.this.usageReminderClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                }
                UsageReminder usageReminder = (UsageReminder) obj2;
                if (usageReminder != null) {
                    usageReminderCopy = usageReminder.copy((4063 & 1) != 0 ? usageReminder.usageGoal : 0, (4063 & 2) != 0 ? usageReminder.runCycle : 0, (4063 & 4) != 0 ? usageReminder.timeZone : null, (4063 & 8) != 0 ? usageReminder.alertType : 0, (4063 & 16) != 0 ? usageReminder.alertDuration : 0, (4063 & 32) != 0 ? usageReminder.alertDemo : true, (4063 & 64) != 0 ? usageReminder.soundPattern : 0, (4063 & 128) != 0 ? usageReminder.ledColor : null, (4063 & 256) != 0 ? usageReminder.ledOnDuration : null, (4063 & 512) != 0 ? usageReminder.ledOffDuration : null, (4063 & 1024) != 0 ? usageReminder.hapticOnDuration : 0, (4063 & 2048) != 0 ? usageReminder.hapticOffDuration : 0);
                } else {
                    usageReminderCopy = null;
                }
                UsageReminderClient usageReminderClient = NodesModule.this.usageReminderClient;
                String str = this.$deviceAddress;
                Intrinsics.checkNotNull(usageReminderCopy);
                usageReminderClient.write(str, usageReminderCopy);
                WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[previewUsageAlert]");
                writableMapWritableMapOf.putBoolean("alertDemo", true);
                this.$promise.resolve(writableMapWritableMapOf);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void previewUsageAlert(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14531(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getPodData$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getPodData$1", m5608f = "NodesModule.kt", m5609i = {0}, m5610l = {2155}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14431(String str, Promise promise, Continuation<? super C14431> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14431(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            String str2;
            Object obj2;
            WritableMap writableMap;
            Integer type;
            LiquidInformation liquidInformation;
            LiquidInformation liquidInformation2;
            LiquidInformation liquidInformation3;
            LiquidInformation liquidInformation4;
            PodUid podUid;
            PodUid podUid2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    str = "[getPodData]  liquidInformation.heatingPower=";
                    str2 = "[getPodData]  liquidInformation.nicotineStrength=";
                    this.L$0 = writableMapWritableMapOf;
                    this.label = 1;
                    obj2 = NodesModule.this.podConnectionClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                    str = "[getPodData]  liquidInformation.heatingPower=";
                    str2 = "[getPodData]  liquidInformation.nicotineStrength=";
                }
                PodConnection podConnection = (PodConnection) obj2;
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getPodData] data " + podConnection);
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getPodData]  connected=" + (podConnection != null ? Boxing.boxBoolean(podConnection.getConnected()) : null));
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getPodData]  type=" + (podConnection != null ? podConnection.getType() : null));
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getPodData]  apiVersion=" + (podConnection != null ? podConnection.getApiVersion() : null));
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getPodData]  podUid=" + (podConnection != null ? podConnection.getPodUid() : null));
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getPodData]  podUid.manufactureDate=" + ((podConnection == null || (podUid2 = podConnection.getPodUid()) == null) ? null : podUid2.getManufactureDate()));
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getPodData]  podUid.assembly=" + ((podConnection == null || (podUid = podConnection.getPodUid()) == null) ? null : podUid.getAssembly()));
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getPodData]  liquidInformation=" + (podConnection != null ? podConnection.getLiquidInformation() : null));
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getPodData]  liquidInformation.fillCapacity=" + ((podConnection == null || (liquidInformation4 = podConnection.getLiquidInformation()) == null) ? null : Boxing.boxDouble(liquidInformation4.getFillCapacity())));
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getPodData]  liquidInformation.flavorGroup=" + ((podConnection == null || (liquidInformation3 = podConnection.getLiquidInformation()) == null) ? null : Boxing.boxInt(liquidInformation3.getFlavorGroup())));
                LogInstrumentation.m2726d(NodesModule.this.TAG, str2 + ((podConnection == null || (liquidInformation2 = podConnection.getLiquidInformation()) == null) ? null : Boxing.boxInt(liquidInformation2.getNicotineStrength())));
                LogInstrumentation.m2726d(NodesModule.this.TAG, str + ((podConnection == null || (liquidInformation = podConnection.getLiquidInformation()) == null) ? null : Boxing.boxInt(liquidInformation.getHeatingPower())));
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getPodData]  skuInformation=" + (podConnection != null ? podConnection.getSkuInformation() : null));
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getPodData]  remainingVolume=" + (podConnection != null ? podConnection.getRemainingVolume() : null));
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[getPodData]  podPuffCount=" + (podConnection != null ? podConnection.getPodPuffCount() : null));
                if (podConnection != null && (type = podConnection.getType()) != null && type.intValue() == 2) {
                    writableMap.putBoolean("connected", podConnection.getConnected());
                    Integer type2 = podConnection.getType();
                    Intrinsics.checkNotNull(type2);
                    writableMap.putInt("type", type2.intValue());
                    Integer apiVersion = podConnection.getApiVersion();
                    Intrinsics.checkNotNull(apiVersion);
                    writableMap.putInt("apiVersion", apiVersion.intValue());
                    PodUid podUid3 = podConnection.getPodUid();
                    Intrinsics.checkNotNull(podUid3);
                    writableMap.putString("manufactureDate", podUid3.getManufactureDate());
                    PodUid podUid4 = podConnection.getPodUid();
                    Intrinsics.checkNotNull(podUid4);
                    writableMap.putString("assembly", podUid4.getAssembly());
                    LiquidInformation liquidInformation5 = podConnection.getLiquidInformation();
                    Intrinsics.checkNotNull(liquidInformation5);
                    writableMap.putDouble("fillCapacity", liquidInformation5.getFillCapacity());
                    LiquidInformation liquidInformation6 = podConnection.getLiquidInformation();
                    Intrinsics.checkNotNull(liquidInformation6);
                    writableMap.putInt("flavorGroup", liquidInformation6.getFlavorGroup());
                    LiquidInformation liquidInformation7 = podConnection.getLiquidInformation();
                    Intrinsics.checkNotNull(liquidInformation7);
                    writableMap.putInt("nicotineStrength", liquidInformation7.getNicotineStrength());
                    LiquidInformation liquidInformation8 = podConnection.getLiquidInformation();
                    Intrinsics.checkNotNull(liquidInformation8);
                    writableMap.putInt("heatingPower", liquidInformation8.getHeatingPower());
                    writableMap.putString("skuInformation", podConnection.getSkuInformation());
                    Integer remainingVolume = podConnection.getRemainingVolume();
                    Intrinsics.checkNotNull(remainingVolume);
                    writableMap.putInt("remainingVolume", remainingVolume.intValue());
                    Integer podPuffCount = podConnection.getPodPuffCount();
                    Intrinsics.checkNotNull(podPuffCount);
                    writableMap.putInt("podPuffCount", podPuffCount.intValue());
                }
                this.$promise.resolve(writableMap);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void getPodData(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14431(deviceAddress, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setAdvertisingName$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setAdvertisingName$1", m5608f = "NodesModule.kt", m5609i = {1}, m5610l = {2210, 2215}, m5611m = "invokeSuspend", m5612n = {"data"}, m5613s = {"L$0"})
    static final class C14541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $advertisingName;
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14541(String str, String str2, Promise promise, Continuation<? super C14541> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$advertisingName = str2;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14541(this.$deviceAddress, this.$advertisingName, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x007f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x009a A[Catch: Exception -> 0x0026, Error -> 0x0029, TryCatch #2 {Error -> 0x0029, Exception -> 0x0026, blocks: (B:7:0x0016, B:28:0x0080, B:30:0x009a, B:32:0x00ce, B:33:0x00d7, B:11:0x0022, B:23:0x0047, B:25:0x004b, B:18:0x002f, B:20:0x0037), top: B:39:0x000c }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instruction units count: 287
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule.C14541.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @ReactMethod
    public final void setAdvertisingName(String deviceAddress, String advertisingName, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(advertisingName, "advertisingName");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14541(deviceAddress, advertisingName, promise, null), 3, null);
    }

    @ReactMethod
    public final void startMarketEnable(String deviceAddress, String payloadCode, String countryCode, String url, String userId, String token, String tenantId, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(payloadCode, "payloadCode");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(tenantId, "tenantId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        LogInstrumentation.m2726d(this.TAG, "[startMarketEnable] Starting market enable");
        try {
            this.payloadUploader.m5928uploadzvoA_rg(deviceAddress, UStringsKt.toUShort(payloadCode), countryCode, url, userId, token, tenantId, (128 & 128) != 0 ? null : null);
            promise.resolve(true);
        } catch (Exception e) {
            LogInstrumentation.m2728e("[startMarketEnable] Error: ", e.getLocalizedMessage());
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void startFOTA(String deviceAddress, String uri, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(promise, "promise");
        LogInstrumentation.m2726d(this.TAG, "[startFOTA] uri: " + uri + " - deviceAddress: " + deviceAddress);
        try {
            Uri uriFromFile = Uri.fromFile(new File(uri));
            Intrinsics.checkNotNullExpressionValue(uriFromFile, "fromFile(...)");
            LogInstrumentation.m2726d(this.TAG, "[startFOTA] parsedUri: " + uriFromFile);
            this.firmwareManager.install(deviceAddress, uriFromFile);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void startReset(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        LogInstrumentation.m2726d(this.TAG, "[startReset]");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14721(deviceAddress, promise, null), 2, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$startReset$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$startReset$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14721(String str, Promise promise, Continuation<? super C14721> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14721(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    NodesModule.this.gattManager.clearRequestsForDevice(this.$deviceAddress);
                    NodesModule.this.resetClient.write(this.$deviceAddress, Unit.INSTANCE);
                    this.$promise.resolve(Boxing.boxBoolean(true));
                } catch (Exception e) {
                    this.$promise.reject(e);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @ReactMethod
    public final void isDeviceBonded(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        LogInstrumentation.m2726d(this.TAG, "[isDeviceBonded]");
        try {
            BluetoothAdapter bluetoothAdapter = getBluetoothAdapter();
            Intrinsics.checkNotNull(bluetoothAdapter);
            Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
            Intrinsics.checkNotNullExpressionValue(bondedDevices, "getBondedDevices(...)");
            Iterator<BluetoothDevice> it2 = bondedDevices.iterator();
            while (it2.hasNext()) {
                String address = it2.next().getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                if (StringsKt.contains((CharSequence) address, (CharSequence) deviceAddress, true)) {
                    promise.resolve(true);
                }
            }
            promise.resolve(false);
        } catch (Exception e) {
            promise.reject("isDeviceBonded exception", e);
        }
    }

    @ReactMethod
    public final void bondDevice(String deviceName, String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.bonding.bond(new BatDevice(deviceName, deviceAddress, 0, null, 8, null));
    }

    public static /* synthetic */ void connect$default(NodesModule nodesModule, String str, boolean z, Promise promise, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        nodesModule.connect(str, z, promise);
    }

    @ReactMethod
    public final void connect(String deviceAddress, boolean skipCheck, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            LogInstrumentation.m2726d(this.TAG, "[connect] invoked for: " + deviceAddress);
            GattManager.connect$default(this.gattManager, deviceAddress, false, 2, null);
        } catch (Exception e) {
            LogInstrumentation.m2726d(this.TAG, "[connect] connect exception  " + e);
        }
    }

    @ReactMethod
    public final void doSecureAV(String deviceAddress, String url, String userId, String token, String tenant) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(tenant, "tenant");
        this.ageVerifier.verify(deviceAddress, url, userId, token, tenant, (96 & 32) != 0, (96 & 64) != 0 ? null : null);
    }

    @ReactMethod
    public final void disconnect(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        this.gattManager.disconnect(deviceAddress);
    }

    @ReactMethod
    public final void disconnectAll() {
        this.gattManager.disconnectAll();
    }

    @ReactMethod
    public final void getDeviceTime(Callback onSuccess, Callback onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogInstrumentation.m2726d(this.TAG, "[getDeviceTime]");
    }

    @ReactMethod
    public final void updateDeviceTime(String deviceAddress, Callback onSuccess, Callback onError) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        LogInstrumentation.m2726d(this.TAG, "[setDeviceTime]");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14771(deviceAddress, onSuccess, onError, null), 2, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$updateDeviceTime$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$updateDeviceTime$1", m5608f = "NodesModule.kt", m5609i = {0, 0}, m5610l = {2411}, m5611m = "invokeSuspend", m5612n = {"cal", "data"}, m5613s = {"L$0", "L$1"})
    static final class C14771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Callback $onError;
        final /* synthetic */ Callback $onSuccess;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14771(String str, Callback callback, Callback callback2, Continuation<? super C14771> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$onSuccess = callback;
            this.$onError = callback2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14771(this.$deviceAddress, this.$onSuccess, this.$onError, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Calendar calendar;
            WritableMap writableMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    calendar = Calendar.getInstance();
                    calendar.setTime(new Date());
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH).format(calendar.getTime());
                    WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                    this.L$0 = calendar;
                    this.L$1 = writableMapWritableMapOf;
                    this.label = 1;
                    Object obj2 = NodesModule.this.timeClient.read(this.$deviceAddress, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writableMap = writableMapWritableMapOf;
                    obj = obj2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writableMap = (WritableMap) this.L$1;
                    calendar = (Calendar) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                DeviceTime deviceTime = (DeviceTime) obj;
                DeviceTime deviceTimeCopy$default = null;
                if (deviceTime != null) {
                    Date time = calendar.getTime();
                    Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
                    deviceTimeCopy$default = DeviceTime.copy$default(deviceTime, time, null, 2, null);
                }
                if (deviceTimeCopy$default != null) {
                    NodesModule.this.timeClient.write(this.$deviceAddress, deviceTimeCopy$default);
                    writableMap.putString("datetime", deviceTimeCopy$default.getDateTime().toString());
                }
                this.$onSuccess.invoke(writableMap);
            } catch (Exception e) {
                WritableMap writableMapWritableMapOf2 = NodesModule.this.writableMapOf(new Pair[0]);
                writableMapWritableMapOf2.putString("error", e.toString());
                this.$onError.invoke(writableMapWritableMapOf2);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void refreshCache(String deviceAddress, Promise promise) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method;
        Object next;
        Class<?> cls;
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        LogInstrumentation.m2726d(this.TAG, "[refreshCache] refreshing cache");
        Iterator<T> it2 = this.gattManager.getDevices().getValue().iterator();
        while (true) {
            method = null;
            if (!it2.hasNext()) {
                next = null;
                break;
            } else {
                next = it2.next();
                if (Intrinsics.areEqual(((BleDeviceData) next).getAddress(), deviceAddress)) {
                    break;
                }
            }
        }
        BleDeviceData bleDeviceData = (BleDeviceData) next;
        BluetoothGatt gatt = bleDeviceData != null ? bleDeviceData.getGatt() : null;
        if (gatt != null && (cls = gatt.getClass()) != null) {
            method = cls.getMethod("refresh", new Class[0]);
        }
        if (method != null) {
            method.invoke(gatt, new Object[0]);
        }
        promise.resolve(true);
    }

    @ReactMethod
    public final void isDeviceAvailable(final String addresses, final Callback onResult) {
        Intrinsics.checkNotNullParameter(addresses, "addresses");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ScanCallback scanCallback = new ScanCallback() { // from class: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$isDeviceAvailable$scanCallback$1
            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(int callbackType, ScanResult result) {
                super.onScanResult(callbackType, result);
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onBatchScanResults(List<ScanResult> results) {
                super.onBatchScanResults(results);
                List listSplit$default = StringsKt.split$default((CharSequence) addresses, new char[]{','}, false, 0, 6, (Object) null);
                WritableMap writableMapWritableMapOf = this.writableMapOf(new Pair[0]);
                int size = listSplit$default.size();
                LogInstrumentation.m2726d(this.TAG, "[isDeviceAvailable] size " + size);
                for (int i = 0; i < size; i++) {
                    String str = (String) listSplit$default.get(i);
                    Object obj = null;
                    LogInstrumentation.m2726d(this.TAG, "[isDeviceAvailable] results size " + (results != null ? Integer.valueOf(results.size()) : null));
                    if (results != null) {
                        Iterator<T> it2 = results.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next = it2.next();
                            if (Intrinsics.areEqual(((ScanResult) next).getDevice().getAddress(), str)) {
                                obj = next;
                                break;
                            }
                        }
                        obj = (ScanResult) obj;
                    }
                    if (obj != null) {
                        LogInstrumentation.m2726d(this.TAG, "[isDeviceAvailable] Scanlist " + str + " found");
                        writableMapWritableMapOf.putBoolean(str, true);
                    } else {
                        LogInstrumentation.m2726d(this.TAG, "[isDeviceAvailable] Scanlist " + str + " NOT found");
                        writableMapWritableMapOf.putBoolean(str, false);
                    }
                }
                onResult.invoke(writableMapWritableMapOf);
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanFailed(int errorCode) {
                super.onScanFailed(errorCode);
            }
        };
        ScanSettings scanSettingsBuild = new ScanSettings.Builder().setScanMode(2).setReportDelay(100L).build();
        List listListOf = CollectionUtils.listOf();
        Intrinsics.checkNotNullExpressionValue(listListOf, "listOf(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), Dispatchers.getMain(), null, new C14491(scanSettingsBuild, listListOf, scanCallback, null), 2, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$isDeviceAvailable$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$isDeviceAvailable$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {2487}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ScanFilter> $filters;
        final /* synthetic */ ScanCallback $scanCallback;
        final /* synthetic */ ScanSettings $scanSettings;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14491(ScanSettings scanSettings, List<ScanFilter> list, ScanCallback scanCallback, Continuation<? super C14491> continuation) {
            super(2, continuation);
            this.$scanSettings = scanSettings;
            this.$filters = list;
            this.$scanCallback = scanCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14491(this.$scanSettings, this.$filters, this.$scanCallback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[isDeviceAvailable] start scan");
                BatScanner scanner = BatSdk.INSTANCE.getScanner();
                if (scanner != null) {
                    ScanSettings scanSettings = this.$scanSettings;
                    Intrinsics.checkNotNullExpressionValue(scanSettings, "$scanSettings");
                    scanner.start(scanSettings, this.$filters, this.$scanCallback);
                }
                this.label = 1;
                if (DelayKt.delay(200L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BatScanner scanner2 = BatSdk.INSTANCE.getScanner();
            if (scanner2 != null) {
                scanner2.stop(this.$scanCallback);
            }
            LogInstrumentation.m2726d(NodesModule.this.TAG, "[isDeviceAvailable] stop scan");
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void setBackgroundSyncEnabled(String deviceAddress, boolean enabled) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        WritableMap writableMapWritableMapOf = writableMapOf(new Pair[0]);
        writableMapWritableMapOf.putString("deviceAddress", deviceAddress);
        if (enabled) {
            BatCompanionDeviceManager companionDeviceManager = BatSdk.INSTANCE.getCompanionDeviceManager();
            if (companionDeviceManager != null) {
                BatCompanionDeviceManager.associate$default(companionDeviceManager, deviceAddress, null, 2, null);
            }
            BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14581(deviceAddress, writableMapWritableMapOf, null), 3, null);
            return;
        }
        BatCompanionDeviceManager companionDeviceManager2 = BatSdk.INSTANCE.getCompanionDeviceManager();
        if (companionDeviceManager2 != null) {
            companionDeviceManager2.disassociate(deviceAddress);
        }
        writableMapWritableMapOf.putBoolean("backgroundSyncEnabled", false);
        LogInstrumentation.m2726d(this.TAG, "[setBackgroundSyncEnabled] background sync association set to false");
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onEnableBackgroundSync", writableMapWritableMapOf);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setBackgroundSyncEnabled$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setBackgroundSyncEnabled$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {2502}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WritableMap $data;
        final /* synthetic */ String $deviceAddress;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14581(String str, WritableMap writableMap, Continuation<? super C14581> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$data = writableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14581 c14581 = NodesModule.this.new C14581(this.$deviceAddress, this.$data, continuation);
            c14581.L$0 = obj;
            return c14581;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            StateFlow<AssociationState> associationStateFlow;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                BatCompanionDeviceManager companionDeviceManager = BatSdk.INSTANCE.getCompanionDeviceManager();
                if (companionDeviceManager == null || (associationStateFlow = companionDeviceManager.getAssociationStateFlow()) == null) {
                    return Unit.INSTANCE;
                }
                final NodesModule nodesModule = NodesModule.this;
                final String str = this.$deviceAddress;
                final WritableMap writableMap = this.$data;
                this.label = 1;
                if (associationStateFlow.collect(new FlowCollector() { // from class: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule.setBackgroundSyncEnabled.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((AssociationState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(AssociationState associationState, Continuation<? super Unit> continuation) {
                        if (associationState instanceof AssociationState.AssociationCreated) {
                            LogInstrumentation.m2726d(nodesModule.TAG, "[setBackgroundSyncEnabled] background sync association set to true");
                            if (Intrinsics.areEqual(((AssociationState.AssociationCreated) associationState).getDeviceAddress(), str)) {
                                writableMap.putString("syncPermissionChoice", "granted");
                                writableMap.putBoolean("backgroundSyncEnabled", true);
                                ((DeviceEventManagerModule.RCTDeviceEventEmitter) nodesModule.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onEnableBackgroundSync", writableMap);
                                CoroutineScopeKt.cancel$default(coroutineScope, "association created", null, 2, null);
                            }
                        } else if (associationState instanceof AssociationState.AssociationError) {
                            LogInstrumentation.m2726d(nodesModule.TAG, "[setBackgroundSyncEnabled] background sync association errored");
                            if (Intrinsics.areEqual(((AssociationState.AssociationError) associationState).getDeviceAddress(), str)) {
                                writableMap.putString("syncPermissionChoice", "denied");
                                writableMap.putBoolean("backgroundSyncEnabled", false);
                                ((DeviceEventManagerModule.RCTDeviceEventEmitter) nodesModule.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onEnableBackgroundSync", writableMap);
                                CoroutineScopeKt.cancel$default(coroutineScope, "association errored", null, 2, null);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$isBackgroundSyncEnabled$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$isBackgroundSyncEnabled$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14481(String str, Promise promise, Continuation<? super C14481> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14481(this.$deviceAddress, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                WritableMap writableMapWritableMapOf = NodesModule.this.writableMapOf(new Pair[0]);
                BatCompanionDeviceManager companionDeviceManager = BatSdk.INSTANCE.getCompanionDeviceManager();
                Boolean boolBoxBoolean = companionDeviceManager != null ? Boxing.boxBoolean(companionDeviceManager.isAssociated(this.$deviceAddress)) : null;
                LogInstrumentation.m2726d(NodesModule.this.TAG, "[isBackgroundSyncEnabled] " + boolBoxBoolean);
                if (boolBoxBoolean != null) {
                    writableMapWritableMapOf.putBoolean("backgroundSyncEnabled", boolBoxBoolean.booleanValue());
                } else {
                    writableMapWritableMapOf.putBoolean("backgroundSyncEnabled", false);
                }
                this.$promise.resolve(writableMapWritableMapOf);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void isBackgroundSyncEnabled(String deviceAddress, Promise promise) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14481(deviceAddress, promise, null), 3, null);
    }

    public final void refreshCache(String deviceAddress) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method;
        Object next;
        Class<?> cls;
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        LogInstrumentation.m2726d(this.TAG, "[refreshCache] refreshing cache");
        Iterator<T> it2 = this.gattManager.getDevices().getValue().iterator();
        while (true) {
            method = null;
            if (!it2.hasNext()) {
                next = null;
                break;
            } else {
                next = it2.next();
                if (Intrinsics.areEqual(((BleDeviceData) next).getAddress(), deviceAddress)) {
                    break;
                }
            }
        }
        BleDeviceData bleDeviceData = (BleDeviceData) next;
        BluetoothGatt gatt = bleDeviceData != null ? bleDeviceData.getGatt() : null;
        if (gatt != null && (cls = gatt.getClass()) != null) {
            method = cls.getMethod("refresh", new Class[0]);
        }
        if (method != null) {
            method.invoke(gatt, new Object[0]);
        }
    }

    public final BluetoothAdapter getBluetoothAdapter() {
        if (this.bluetoothAdapter == null) {
            Object systemService = this.reactContext.getSystemService(CarrierType.BLUETOOTH);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
            this.bluetoothAdapter = ((BluetoothManager) systemService).getAdapter();
        }
        return this.bluetoothAdapter;
    }

    @Override // com.bat.myvuse.mobile.rncomponents.nodes.NodesBaseModule, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "NodesSDK";
    }

    public final WritableMap writableMapOf(Pair<String, ?>... values) {
        Intrinsics.checkNotNullParameter(values, "values");
        WritableMap writableMapCreateMap = Arguments.createMap();
        for (Pair<String, ?> pair : values) {
            String strComponent1 = pair.component1();
            Object objComponent2 = pair.component2();
            if (objComponent2 == null) {
                writableMapCreateMap.putNull(strComponent1);
            } else if (objComponent2 instanceof Boolean) {
                writableMapCreateMap.putBoolean(strComponent1, ((Boolean) objComponent2).booleanValue());
            } else if (objComponent2 instanceof Double) {
                writableMapCreateMap.putDouble(strComponent1, ((Number) objComponent2).doubleValue());
            } else if (objComponent2 instanceof Integer) {
                writableMapCreateMap.putInt(strComponent1, ((Number) objComponent2).intValue());
            } else if (objComponent2 instanceof String) {
                writableMapCreateMap.putString(strComponent1, (String) objComponent2);
            } else if (objComponent2 instanceof WritableMap) {
                writableMapCreateMap.putMap(strComponent1, (ReadableMap) objComponent2);
            } else {
                if (!(objComponent2 instanceof WritableArray)) {
                    throw new IllegalArgumentException("Unsupported value type " + objComponent2.getClass().getName() + " for key [" + strComponent1 + "]");
                }
                writableMapCreateMap.putArray(strComponent1, (ReadableArray) objComponent2);
            }
        }
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setAutoLockEnabled$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$setAutoLockEnabled$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {2621, 2635}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ String $ePodType;
        final /* synthetic */ boolean $isEnabled;
        final /* synthetic */ Callback $onError;
        final /* synthetic */ Callback $onSuccess;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14551(boolean z, String str, String str2, Callback callback, Callback callback2, Continuation<? super C14551> continuation) {
            super(2, continuation);
            this.$isEnabled = z;
            this.$deviceAddress = str;
            this.$ePodType = str2;
            this.$onError = callback;
            this.$onSuccess = callback2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14551(this.$isEnabled, this.$deviceAddress, this.$ePodType, this.$onError, this.$onSuccess, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00bb A[Catch: Exception -> 0x0034, TryCatch #0 {Exception -> 0x0034, blocks: (B:6:0x001f, B:28:0x0130, B:29:0x015a, B:31:0x015e, B:32:0x017a, B:10:0x002e, B:20:0x00a0, B:22:0x00bb, B:23:0x00de, B:15:0x003a, B:17:0x008c, B:25:0x011c), top: B:37:0x0019 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00de A[Catch: Exception -> 0x0034, TryCatch #0 {Exception -> 0x0034, blocks: (B:6:0x001f, B:28:0x0130, B:29:0x015a, B:31:0x015e, B:32:0x017a, B:10:0x002e, B:20:0x00a0, B:22:0x00bb, B:23:0x00de, B:15:0x003a, B:17:0x008c, B:25:0x011c), top: B:37:0x0019 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                Method dump skipped, instruction units count: 461
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule.C14551.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @ReactMethod
    public final void setAutoLockEnabled(String deviceAddress, boolean isEnabled, String ePodType, Callback onSuccess, Callback onError) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(ePodType, "ePodType");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14551(isEnabled, deviceAddress, ePodType, onError, onSuccess, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getAutoLockEnabled$1 */
    /* JADX INFO: compiled from: NodesModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$getAutoLockEnabled$1", m5608f = "NodesModule.kt", m5609i = {}, m5610l = {2666, 2668}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ String $ePodType;
        final /* synthetic */ Callback $onError;
        final /* synthetic */ Callback $onSuccess;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14321(String str, String str2, Callback callback, Callback callback2, Continuation<? super C14321> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
            this.$ePodType = str2;
            this.$onSuccess = callback;
            this.$onError = callback2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NodesModule.this.new C14321(this.$deviceAddress, this.$ePodType, this.$onSuccess, this.$onError, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0086 A[Catch: Exception -> 0x0021, TryCatch #0 {Exception -> 0x0021, blocks: (B:6:0x0011, B:29:0x0082, B:32:0x008a, B:31:0x0086, B:10:0x001d, B:20:0x005d, B:22:0x0061, B:24:0x0067, B:15:0x0027, B:17:0x0049, B:26:0x006e), top: B:37:0x000b }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                Method dump skipped, instruction units count: 221
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bat.myvuse.mobile.rncomponents.nodes.NodesModule.C14321.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @ReactMethod
    public final void getAutoLockEnabled(String deviceAddress, String ePodType, Callback onSuccess, Callback onError) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(ePodType, "ePodType");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(ProcessLifecycleOwner.INSTANCE.get().getLifecycle()), null, null, new C14321(deviceAddress, ePodType, onSuccess, onError, null), 3, null);
    }
}
