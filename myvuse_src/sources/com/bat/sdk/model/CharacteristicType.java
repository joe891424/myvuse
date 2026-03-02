package com.bat.sdk.model;

import com.facebook.fbreact.specs.NativeAppearanceSpec;
import com.facebook.fbreact.specs.NativeDeviceInfoSpec;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CharacteristicType.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 #2\u00020\u0001:\u001c\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u001b$%&'()*+,-./0123456789:;<=>¨\u0006?"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType;", "Ljava/io/Serializable;", "code", "", "<init>", "(I)V", "getCode", "()I", "Generic", "Battery", "Cloud", "Time", NativeDeviceInfoSpec.NAME, "LastError", "FindVape", "Haptic", "Led", "Lock", "Logs", "Puffs", "Reset", "Buzzer", "PodConnection", "ButtonlessDFUwithBonds", "DeviceName", NativeAppearanceSpec.NAME, "PeripheralPrefConnParameters", "CentralAddressResolution", "ServiceChanged", "BleTimeout", "PowerSaveMode", "UsageReminder", "SessionIndication", "RechargeReminders", "TimeoutAutoLock", "Companion", "Lcom/bat/sdk/model/CharacteristicType$Appearance;", "Lcom/bat/sdk/model/CharacteristicType$Battery;", "Lcom/bat/sdk/model/CharacteristicType$BleTimeout;", "Lcom/bat/sdk/model/CharacteristicType$ButtonlessDFUwithBonds;", "Lcom/bat/sdk/model/CharacteristicType$Buzzer;", "Lcom/bat/sdk/model/CharacteristicType$CentralAddressResolution;", "Lcom/bat/sdk/model/CharacteristicType$Cloud;", "Lcom/bat/sdk/model/CharacteristicType$DeviceInfo;", "Lcom/bat/sdk/model/CharacteristicType$DeviceName;", "Lcom/bat/sdk/model/CharacteristicType$FindVape;", "Lcom/bat/sdk/model/CharacteristicType$Generic;", "Lcom/bat/sdk/model/CharacteristicType$Haptic;", "Lcom/bat/sdk/model/CharacteristicType$LastError;", "Lcom/bat/sdk/model/CharacteristicType$Led;", "Lcom/bat/sdk/model/CharacteristicType$Lock;", "Lcom/bat/sdk/model/CharacteristicType$Logs;", "Lcom/bat/sdk/model/CharacteristicType$PeripheralPrefConnParameters;", "Lcom/bat/sdk/model/CharacteristicType$PodConnection;", "Lcom/bat/sdk/model/CharacteristicType$PowerSaveMode;", "Lcom/bat/sdk/model/CharacteristicType$Puffs;", "Lcom/bat/sdk/model/CharacteristicType$RechargeReminders;", "Lcom/bat/sdk/model/CharacteristicType$Reset;", "Lcom/bat/sdk/model/CharacteristicType$ServiceChanged;", "Lcom/bat/sdk/model/CharacteristicType$SessionIndication;", "Lcom/bat/sdk/model/CharacteristicType$Time;", "Lcom/bat/sdk/model/CharacteristicType$TimeoutAutoLock;", "Lcom/bat/sdk/model/CharacteristicType$UsageReminder;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class CharacteristicType implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int code;

    public /* synthetic */ CharacteristicType(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private CharacteristicType(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$Generic;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Generic extends CharacteristicType {
        public static final Generic INSTANCE = new Generic();

        private Generic() {
            super(0, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$Battery;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Battery extends CharacteristicType {
        public static final Battery INSTANCE = new Battery();

        private Battery() {
            super(1, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$Cloud;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Cloud extends CharacteristicType {
        public static final Cloud INSTANCE = new Cloud();

        private Cloud() {
            super(2, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$Time;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Time extends CharacteristicType {
        public static final Time INSTANCE = new Time();

        private Time() {
            super(3, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$DeviceInfo;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class DeviceInfo extends CharacteristicType {
        public static final DeviceInfo INSTANCE = new DeviceInfo();

        private DeviceInfo() {
            super(4, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$LastError;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class LastError extends CharacteristicType {
        public static final LastError INSTANCE = new LastError();

        private LastError() {
            super(5, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$FindVape;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class FindVape extends CharacteristicType {
        public static final FindVape INSTANCE = new FindVape();

        private FindVape() {
            super(6, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$Haptic;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Haptic extends CharacteristicType {
        public static final Haptic INSTANCE = new Haptic();

        private Haptic() {
            super(7, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$Led;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Led extends CharacteristicType {
        public static final Led INSTANCE = new Led();

        private Led() {
            super(8, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$Lock;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Lock extends CharacteristicType {
        public static final Lock INSTANCE = new Lock();

        private Lock() {
            super(9, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$Logs;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Logs extends CharacteristicType {
        public static final Logs INSTANCE = new Logs();

        private Logs() {
            super(10, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$Puffs;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Puffs extends CharacteristicType {
        public static final Puffs INSTANCE = new Puffs();

        private Puffs() {
            super(11, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$Reset;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Reset extends CharacteristicType {
        public static final Reset INSTANCE = new Reset();

        private Reset() {
            super(12, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$Buzzer;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Buzzer extends CharacteristicType {
        public static final Buzzer INSTANCE = new Buzzer();

        private Buzzer() {
            super(13, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$PodConnection;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class PodConnection extends CharacteristicType {
        public static final PodConnection INSTANCE = new PodConnection();

        private PodConnection() {
            super(14, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$ButtonlessDFUwithBonds;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class ButtonlessDFUwithBonds extends CharacteristicType {
        public static final ButtonlessDFUwithBonds INSTANCE = new ButtonlessDFUwithBonds();

        private ButtonlessDFUwithBonds() {
            super(15, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$DeviceName;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class DeviceName extends CharacteristicType {
        public static final DeviceName INSTANCE = new DeviceName();

        private DeviceName() {
            super(16, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$Appearance;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Appearance extends CharacteristicType {
        public static final Appearance INSTANCE = new Appearance();

        private Appearance() {
            super(17, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$PeripheralPrefConnParameters;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class PeripheralPrefConnParameters extends CharacteristicType {
        public static final PeripheralPrefConnParameters INSTANCE = new PeripheralPrefConnParameters();

        private PeripheralPrefConnParameters() {
            super(18, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$CentralAddressResolution;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class CentralAddressResolution extends CharacteristicType {
        public static final CentralAddressResolution INSTANCE = new CentralAddressResolution();

        private CentralAddressResolution() {
            super(19, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$ServiceChanged;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class ServiceChanged extends CharacteristicType {
        public static final ServiceChanged INSTANCE = new ServiceChanged();

        private ServiceChanged() {
            super(20, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$BleTimeout;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class BleTimeout extends CharacteristicType {
        public static final BleTimeout INSTANCE = new BleTimeout();

        private BleTimeout() {
            super(21, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$PowerSaveMode;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class PowerSaveMode extends CharacteristicType {
        public static final PowerSaveMode INSTANCE = new PowerSaveMode();

        private PowerSaveMode() {
            super(22, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$UsageReminder;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class UsageReminder extends CharacteristicType {
        public static final UsageReminder INSTANCE = new UsageReminder();

        private UsageReminder() {
            super(23, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$SessionIndication;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class SessionIndication extends CharacteristicType {
        public static final SessionIndication INSTANCE = new SessionIndication();

        private SessionIndication() {
            super(24, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$RechargeReminders;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class RechargeReminders extends CharacteristicType {
        public static final RechargeReminders INSTANCE = new RechargeReminders();

        private RechargeReminders() {
            super(25, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$TimeoutAutoLock;", "Lcom/bat/sdk/model/CharacteristicType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class TimeoutAutoLock extends CharacteristicType {
        public static final TimeoutAutoLock INSTANCE = new TimeoutAutoLock();

        private TimeoutAutoLock() {
            super(26, null);
        }
    }

    /* JADX INFO: compiled from: CharacteristicType.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/model/CharacteristicType$Companion;", "", "<init>", "()V", "fromCode", "Lcom/bat/sdk/model/CharacteristicType;", "code", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CharacteristicType fromCode(int code) {
            switch (code) {
                case 1:
                    return Battery.INSTANCE;
                case 2:
                    return Cloud.INSTANCE;
                case 3:
                    return Time.INSTANCE;
                case 4:
                    return DeviceInfo.INSTANCE;
                case 5:
                    return LastError.INSTANCE;
                case 6:
                    return FindVape.INSTANCE;
                case 7:
                    return Haptic.INSTANCE;
                case 8:
                    return Led.INSTANCE;
                case 9:
                    return Lock.INSTANCE;
                case 10:
                    return Logs.INSTANCE;
                case 11:
                    return Puffs.INSTANCE;
                case 12:
                    return Reset.INSTANCE;
                case 13:
                    return Buzzer.INSTANCE;
                case 14:
                    return PodConnection.INSTANCE;
                case 15:
                    return ButtonlessDFUwithBonds.INSTANCE;
                case 16:
                    return DeviceName.INSTANCE;
                case 17:
                    return Appearance.INSTANCE;
                case 18:
                    return PeripheralPrefConnParameters.INSTANCE;
                case 19:
                    return CentralAddressResolution.INSTANCE;
                case 20:
                    return ServiceChanged.INSTANCE;
                case 21:
                    return BleTimeout.INSTANCE;
                case 22:
                    return PowerSaveMode.INSTANCE;
                case 23:
                    return UsageReminder.INSTANCE;
                case 24:
                    return SessionIndication.INSTANCE;
                case 25:
                    return RechargeReminders.INSTANCE;
                case 26:
                    return TimeoutAutoLock.INSTANCE;
                default:
                    return Generic.INSTANCE;
            }
        }
    }
}
