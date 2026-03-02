package com.bat.sdk.ble;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ConnectionState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, m5598d2 = {"Lcom/bat/sdk/ble/ConnectionState;", "", "<init>", "()V", "Connected", "Connecting", "Disconnecting", "Disconnected", "Lcom/bat/sdk/ble/ConnectionState$Connected;", "Lcom/bat/sdk/ble/ConnectionState$Connecting;", "Lcom/bat/sdk/ble/ConnectionState$Disconnected;", "Lcom/bat/sdk/ble/ConnectionState$Disconnecting;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class ConnectionState {
    public /* synthetic */ ConnectionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ConnectionState() {
    }

    /* JADX INFO: compiled from: ConnectionState.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/ble/ConnectionState$Connected;", "Lcom/bat/sdk/ble/ConnectionState;", "<init>", "()V", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Connected extends ConnectionState {
        public static final Connected INSTANCE = new Connected();

        private Connected() {
            super(null);
        }

        public String toString() {
            return "connected";
        }
    }

    /* JADX INFO: compiled from: ConnectionState.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/ble/ConnectionState$Connecting;", "Lcom/bat/sdk/ble/ConnectionState;", "<init>", "()V", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Connecting extends ConnectionState {
        public static final Connecting INSTANCE = new Connecting();

        private Connecting() {
            super(null);
        }

        public String toString() {
            return "connecting";
        }
    }

    /* JADX INFO: compiled from: ConnectionState.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/ble/ConnectionState$Disconnecting;", "Lcom/bat/sdk/ble/ConnectionState;", "<init>", "()V", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Disconnecting extends ConnectionState {
        public static final Disconnecting INSTANCE = new Disconnecting();

        private Disconnecting() {
            super(null);
        }

        public String toString() {
            return "disconnecting";
        }
    }

    /* JADX INFO: compiled from: ConnectionState.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/ble/ConnectionState$Disconnected;", "Lcom/bat/sdk/ble/ConnectionState;", "<init>", "()V", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Disconnected extends ConnectionState {
        public static final Disconnected INSTANCE = new Disconnected();

        private Disconnected() {
            super(null);
        }

        public String toString() {
            return "disconnected";
        }
    }
}
