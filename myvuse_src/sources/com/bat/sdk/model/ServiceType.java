package com.bat.sdk.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ServiceType.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00112\u00020\u0001:\n\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\t\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, m5598d2 = {"Lcom/bat/sdk/model/ServiceType;", "Ljava/io/Serializable;", "code", "", "<init>", "(I)V", "getCode", "()I", "Generic", "Vaping", "Log", "DeviceManagement", "AgeVerification", "Fota", "ButtonlessSecureDFU", "GenericAccess", "GenericAttribute", "Companion", "Lcom/bat/sdk/model/ServiceType$AgeVerification;", "Lcom/bat/sdk/model/ServiceType$ButtonlessSecureDFU;", "Lcom/bat/sdk/model/ServiceType$DeviceManagement;", "Lcom/bat/sdk/model/ServiceType$Fota;", "Lcom/bat/sdk/model/ServiceType$Generic;", "Lcom/bat/sdk/model/ServiceType$GenericAccess;", "Lcom/bat/sdk/model/ServiceType$GenericAttribute;", "Lcom/bat/sdk/model/ServiceType$Log;", "Lcom/bat/sdk/model/ServiceType$Vaping;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class ServiceType implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int code;

    public /* synthetic */ ServiceType(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private ServiceType(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: compiled from: ServiceType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/ServiceType$Generic;", "Lcom/bat/sdk/model/ServiceType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Generic extends ServiceType {
        public static final Generic INSTANCE = new Generic();

        private Generic() {
            super(0, null);
        }
    }

    /* JADX INFO: compiled from: ServiceType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/ServiceType$Vaping;", "Lcom/bat/sdk/model/ServiceType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Vaping extends ServiceType {
        public static final Vaping INSTANCE = new Vaping();

        private Vaping() {
            super(1, null);
        }
    }

    /* JADX INFO: compiled from: ServiceType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/ServiceType$Log;", "Lcom/bat/sdk/model/ServiceType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Log extends ServiceType {
        public static final Log INSTANCE = new Log();

        private Log() {
            super(2, null);
        }
    }

    /* JADX INFO: compiled from: ServiceType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/ServiceType$DeviceManagement;", "Lcom/bat/sdk/model/ServiceType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class DeviceManagement extends ServiceType {
        public static final DeviceManagement INSTANCE = new DeviceManagement();

        private DeviceManagement() {
            super(3, null);
        }
    }

    /* JADX INFO: compiled from: ServiceType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/ServiceType$AgeVerification;", "Lcom/bat/sdk/model/ServiceType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class AgeVerification extends ServiceType {
        public static final AgeVerification INSTANCE = new AgeVerification();

        private AgeVerification() {
            super(4, null);
        }
    }

    /* JADX INFO: compiled from: ServiceType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/ServiceType$Fota;", "Lcom/bat/sdk/model/ServiceType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Fota extends ServiceType {
        public static final Fota INSTANCE = new Fota();

        private Fota() {
            super(5, null);
        }
    }

    /* JADX INFO: compiled from: ServiceType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/ServiceType$ButtonlessSecureDFU;", "Lcom/bat/sdk/model/ServiceType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class ButtonlessSecureDFU extends ServiceType {
        public static final ButtonlessSecureDFU INSTANCE = new ButtonlessSecureDFU();

        private ButtonlessSecureDFU() {
            super(6, null);
        }
    }

    /* JADX INFO: compiled from: ServiceType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/ServiceType$GenericAccess;", "Lcom/bat/sdk/model/ServiceType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class GenericAccess extends ServiceType {
        public static final GenericAccess INSTANCE = new GenericAccess();

        private GenericAccess() {
            super(7, null);
        }
    }

    /* JADX INFO: compiled from: ServiceType.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/ServiceType$GenericAttribute;", "Lcom/bat/sdk/model/ServiceType;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class GenericAttribute extends ServiceType {
        public static final GenericAttribute INSTANCE = new GenericAttribute();

        private GenericAttribute() {
            super(8, null);
        }
    }

    /* JADX INFO: compiled from: ServiceType.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/model/ServiceType$Companion;", "", "<init>", "()V", "fromCode", "Lcom/bat/sdk/model/ServiceType;", "code", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ServiceType fromCode(int code) {
            switch (code) {
                case 1:
                    return Vaping.INSTANCE;
                case 2:
                    return Log.INSTANCE;
                case 3:
                    return DeviceManagement.INSTANCE;
                case 4:
                    return AgeVerification.INSTANCE;
                case 5:
                    return Fota.INSTANCE;
                case 6:
                    return ButtonlessSecureDFU.INSTANCE;
                case 7:
                    return GenericAccess.INSTANCE;
                case 8:
                    return GenericAttribute.INSTANCE;
                default:
                    return Generic.INSTANCE;
            }
        }
    }
}
