package com.bat.sdk.ble;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DiscoveryServicesState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, m5598d2 = {"Lcom/bat/sdk/ble/DiscoveryServicesState;", "", "<init>", "()V", "NotDiscovered", "ServiceDiscoveryFailed", "ServiceDiscovering", "ServicesDiscovered", "Lcom/bat/sdk/ble/DiscoveryServicesState$NotDiscovered;", "Lcom/bat/sdk/ble/DiscoveryServicesState$ServiceDiscovering;", "Lcom/bat/sdk/ble/DiscoveryServicesState$ServiceDiscoveryFailed;", "Lcom/bat/sdk/ble/DiscoveryServicesState$ServicesDiscovered;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class DiscoveryServicesState {
    public /* synthetic */ DiscoveryServicesState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DiscoveryServicesState() {
    }

    /* JADX INFO: compiled from: DiscoveryServicesState.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/ble/DiscoveryServicesState$NotDiscovered;", "Lcom/bat/sdk/ble/DiscoveryServicesState;", "<init>", "()V", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class NotDiscovered extends DiscoveryServicesState {
        public static final NotDiscovered INSTANCE = new NotDiscovered();

        private NotDiscovered() {
            super(null);
        }

        public String toString() {
            return "notDiscovered";
        }
    }

    /* JADX INFO: compiled from: DiscoveryServicesState.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/ble/DiscoveryServicesState$ServiceDiscoveryFailed;", "Lcom/bat/sdk/ble/DiscoveryServicesState;", "<init>", "()V", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class ServiceDiscoveryFailed extends DiscoveryServicesState {
        public static final ServiceDiscoveryFailed INSTANCE = new ServiceDiscoveryFailed();

        private ServiceDiscoveryFailed() {
            super(null);
        }

        public String toString() {
            return "failed";
        }
    }

    /* JADX INFO: compiled from: DiscoveryServicesState.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/ble/DiscoveryServicesState$ServiceDiscovering;", "Lcom/bat/sdk/ble/DiscoveryServicesState;", "<init>", "()V", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class ServiceDiscovering extends DiscoveryServicesState {
        public static final ServiceDiscovering INSTANCE = new ServiceDiscovering();

        private ServiceDiscovering() {
            super(null);
        }

        public String toString() {
            return "discovering";
        }
    }

    /* JADX INFO: compiled from: DiscoveryServicesState.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/ble/DiscoveryServicesState$ServicesDiscovered;", "Lcom/bat/sdk/ble/DiscoveryServicesState;", "<init>", "()V", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class ServicesDiscovered extends DiscoveryServicesState {
        public static final ServicesDiscovered INSTANCE = new ServicesDiscovered();

        private ServicesDiscovered() {
            super(null);
        }

        public String toString() {
            return "discovered";
        }
    }
}
