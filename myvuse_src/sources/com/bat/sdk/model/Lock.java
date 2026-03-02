package com.bat.sdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Lock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0019JR\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, m5598d2 = {"Lcom/bat/sdk/model/Lock;", "", "locked", "", "lockMode", "", "bleTimeout", "", "outOfRange", "autoLockEnabled", "lockedValue", "<init>", "(ZILjava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getLocked", "()Z", "getLockMode", "()I", "getBleTimeout", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOutOfRange", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAutoLockEnabled", "getLockedValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "toString", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZILjava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/bat/sdk/model/Lock;", "equals", "other", "hashCode", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class Lock {
    public static final int AV_ENABLED_MODE = 2;
    private final Boolean autoLockEnabled;
    private final Long bleTimeout;
    private final int lockMode;
    private final boolean locked;
    private final Integer lockedValue;
    private final Boolean outOfRange;

    public Lock() {
        this(false, 0, null, null, null, null, 63, null);
    }

    public static /* synthetic */ Lock copy$default(Lock lock, boolean z, int i, Long l, Boolean bool, Boolean bool2, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = lock.locked;
        }
        if ((i2 & 2) != 0) {
            i = lock.lockMode;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            l = lock.bleTimeout;
        }
        Long l2 = l;
        if ((i2 & 8) != 0) {
            bool = lock.outOfRange;
        }
        Boolean bool3 = bool;
        if ((i2 & 16) != 0) {
            bool2 = lock.autoLockEnabled;
        }
        Boolean bool4 = bool2;
        if ((i2 & 32) != 0) {
            num = lock.lockedValue;
        }
        return lock.copy(z, i3, l2, bool3, bool4, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLocked() {
        return this.locked;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLockMode() {
        return this.lockMode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getBleTimeout() {
        return this.bleTimeout;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getOutOfRange() {
        return this.outOfRange;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getAutoLockEnabled() {
        return this.autoLockEnabled;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getLockedValue() {
        return this.lockedValue;
    }

    public final Lock copy(boolean locked, int lockMode, Long bleTimeout, Boolean outOfRange, Boolean autoLockEnabled, Integer lockedValue) {
        return new Lock(locked, lockMode, bleTimeout, outOfRange, autoLockEnabled, lockedValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Lock)) {
            return false;
        }
        Lock lock = (Lock) other;
        return this.locked == lock.locked && this.lockMode == lock.lockMode && Intrinsics.areEqual(this.bleTimeout, lock.bleTimeout) && Intrinsics.areEqual(this.outOfRange, lock.outOfRange) && Intrinsics.areEqual(this.autoLockEnabled, lock.autoLockEnabled) && Intrinsics.areEqual(this.lockedValue, lock.lockedValue);
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.locked) * 31) + Integer.hashCode(this.lockMode)) * 31;
        Long l = this.bleTimeout;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Boolean bool = this.outOfRange;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.autoLockEnabled;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.lockedValue;
        return iHashCode4 + (num != null ? num.hashCode() : 0);
    }

    public Lock(boolean z, int i, Long l, Boolean bool, Boolean bool2, Integer num) {
        this.locked = z;
        this.lockMode = i;
        this.bleTimeout = l;
        this.outOfRange = bool;
        this.autoLockEnabled = bool2;
        this.lockedValue = num;
    }

    public /* synthetic */ Lock(boolean z, int i, Long l, Boolean bool, Boolean bool2, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) == 0 ? i : 0, (i2 & 4) != 0 ? null : l, (i2 & 8) != 0 ? null : bool, (i2 & 16) != 0 ? null : bool2, (i2 & 32) != 0 ? null : num);
    }

    public final boolean getLocked() {
        return this.locked;
    }

    public final int getLockMode() {
        return this.lockMode;
    }

    public final Long getBleTimeout() {
        return this.bleTimeout;
    }

    public final Boolean getOutOfRange() {
        return this.outOfRange;
    }

    public final Boolean getAutoLockEnabled() {
        return this.autoLockEnabled;
    }

    public final Integer getLockedValue() {
        return this.lockedValue;
    }

    public String toString() {
        return "Lock(locked=" + this.locked + ", lockMode=" + this.lockMode + ", bleTimeout=" + this.bleTimeout + ", outOfRange=" + this.outOfRange + ", autoLockEnabled=" + this.autoLockEnabled + ", lockedValue=" + this.lockedValue + ')';
    }
}
