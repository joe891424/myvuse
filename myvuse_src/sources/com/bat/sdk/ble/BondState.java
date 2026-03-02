package com.bat.sdk.ble;

import androidx.webkit.Profile;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BondState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, m5598d2 = {"Lcom/bat/sdk/ble/BondState;", "", "<init>", "()V", Profile.DEFAULT_PROFILE_NAME, "Bonding", "Bonded", "Failed", "Lcom/bat/sdk/ble/BondState$Bonded;", "Lcom/bat/sdk/ble/BondState$Bonding;", "Lcom/bat/sdk/ble/BondState$Default;", "Lcom/bat/sdk/ble/BondState$Failed;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class BondState {
    public /* synthetic */ BondState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BondState() {
    }

    /* JADX INFO: compiled from: BondState.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/ble/BondState$Default;", "Lcom/bat/sdk/ble/BondState;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Default extends BondState {
        public static final Default INSTANCE = new Default();

        private Default() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: BondState.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/ble/BondState$Bonding;", "Lcom/bat/sdk/ble/BondState;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Bonding extends BondState {
        public static final Bonding INSTANCE = new Bonding();

        private Bonding() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: BondState.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/ble/BondState$Bonded;", "Lcom/bat/sdk/ble/BondState;", "device", "Lcom/bat/sdk/ble/BatDevice;", "<init>", "(Lcom/bat/sdk/ble/BatDevice;)V", "getDevice", "()Lcom/bat/sdk/ble/BatDevice;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Bonded extends BondState {
        private final BatDevice device;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Bonded(BatDevice device) {
            super(null);
            Intrinsics.checkNotNullParameter(device, "device");
            this.device = device;
        }

        public final BatDevice getDevice() {
            return this.device;
        }
    }

    /* JADX INFO: compiled from: BondState.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/ble/BondState$Failed;", "Lcom/bat/sdk/ble/BondState;", AnalyticsAttribute.APP_EXIT_REASON_ATTRIBUTE, "", "<init>", "(I)V", "getReason", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Failed extends BondState {
        private final int reason;

        public static /* synthetic */ Failed copy$default(Failed failed, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = failed.reason;
            }
            return failed.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getReason() {
            return this.reason;
        }

        public final Failed copy(int reason) {
            return new Failed(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failed) && this.reason == ((Failed) other).reason;
        }

        public int hashCode() {
            return Integer.hashCode(this.reason);
        }

        public String toString() {
            return "Failed(reason=" + this.reason + ')';
        }

        public Failed(int i) {
            super(null);
            this.reason = i;
        }

        public final int getReason() {
            return this.reason;
        }
    }
}
