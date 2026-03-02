package com.bat.sdk.model;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: TimeoutAutoLock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m5598d2 = {"Lcom/bat/sdk/model/TimeoutAutoLock;", "", ViewProps.ENABLED, "", "<init>", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class TimeoutAutoLock {
    private final boolean enabled;

    public static /* synthetic */ TimeoutAutoLock copy$default(TimeoutAutoLock timeoutAutoLock, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = timeoutAutoLock.enabled;
        }
        return timeoutAutoLock.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final TimeoutAutoLock copy(boolean enabled) {
        return new TimeoutAutoLock(enabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TimeoutAutoLock) && this.enabled == ((TimeoutAutoLock) other).enabled;
    }

    public int hashCode() {
        return Boolean.hashCode(this.enabled);
    }

    public String toString() {
        return "TimeoutAutoLock(enabled=" + this.enabled + ')';
    }

    public TimeoutAutoLock(boolean z) {
        this.enabled = z;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }
}
