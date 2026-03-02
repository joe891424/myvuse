package com.bat.sdk.model;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BleTimeout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u001a\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, m5598d2 = {"Lcom/bat/sdk/model/BleTimeout;", "", "timeout", "Lkotlin/UInt;", "<init>", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTimeout-pVg5ArA", "()I", "I", "toString", "", "component1", "component1-pVg5ArA", "copy", "copy-WZ4Q5Ns", "(I)Lcom/bat/sdk/model/BleTimeout;", "equals", "", "other", "hashCode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class BleTimeout {
    private final int timeout;

    public /* synthetic */ BleTimeout(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    /* JADX INFO: renamed from: copy-WZ4Q5Ns$default, reason: not valid java name */
    public static /* synthetic */ BleTimeout m5914copyWZ4Q5Ns$default(BleTimeout bleTimeout, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleTimeout.timeout;
        }
        return bleTimeout.m5916copyWZ4Q5Ns(i);
    }

    /* JADX INFO: renamed from: component1-pVg5ArA, reason: not valid java name and from getter */
    public final int getTimeout() {
        return this.timeout;
    }

    /* JADX INFO: renamed from: copy-WZ4Q5Ns, reason: not valid java name */
    public final BleTimeout m5916copyWZ4Q5Ns(int timeout) {
        return new BleTimeout(timeout, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BleTimeout) && this.timeout == ((BleTimeout) other).timeout;
    }

    public int hashCode() {
        return UInt.m7340hashCodeimpl(this.timeout);
    }

    private BleTimeout(int i) {
        this.timeout = i;
    }

    public /* synthetic */ BleTimeout(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, null);
    }

    /* JADX INFO: renamed from: getTimeout-pVg5ArA, reason: not valid java name */
    public final int m5917getTimeoutpVg5ArA() {
        return this.timeout;
    }

    public String toString() {
        return "ble timeout=" + ((Object) UInt.m7374toStringimpl(this.timeout));
    }
}
