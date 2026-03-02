package com.bat.sdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SessionIndication.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, m5598d2 = {"Lcom/bat/sdk/model/SessionIndication;", "", "sessionEnabled", "", "times", "", "sessionReached", "<init>", "(ZIZ)V", "getSessionEnabled", "()Z", "getTimes", "()I", "getSessionReached", "toString", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class SessionIndication {
    private final boolean sessionEnabled;
    private final boolean sessionReached;
    private final int times;

    public SessionIndication() {
        this(false, 0, false, 7, null);
    }

    public static /* synthetic */ SessionIndication copy$default(SessionIndication sessionIndication, boolean z, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = sessionIndication.sessionEnabled;
        }
        if ((i2 & 2) != 0) {
            i = sessionIndication.times;
        }
        if ((i2 & 4) != 0) {
            z2 = sessionIndication.sessionReached;
        }
        return sessionIndication.copy(z, i, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSessionEnabled() {
        return this.sessionEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTimes() {
        return this.times;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSessionReached() {
        return this.sessionReached;
    }

    public final SessionIndication copy(boolean sessionEnabled, int times, boolean sessionReached) {
        return new SessionIndication(sessionEnabled, times, sessionReached);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionIndication)) {
            return false;
        }
        SessionIndication sessionIndication = (SessionIndication) other;
        return this.sessionEnabled == sessionIndication.sessionEnabled && this.times == sessionIndication.times && this.sessionReached == sessionIndication.sessionReached;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.sessionEnabled) * 31) + Integer.hashCode(this.times)) * 31) + Boolean.hashCode(this.sessionReached);
    }

    public SessionIndication(boolean z, int i, boolean z2) {
        this.sessionEnabled = z;
        this.times = i;
        this.sessionReached = z2;
    }

    public /* synthetic */ SessionIndication(boolean z, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 10 : i, (i2 & 4) != 0 ? false : z2);
    }

    public final boolean getSessionEnabled() {
        return this.sessionEnabled;
    }

    public final int getTimes() {
        return this.times;
    }

    public final boolean getSessionReached() {
        return this.sessionReached;
    }

    public String toString() {
        return "SessionIndication(sessionIndicationEnabled=" + this.sessionEnabled + ", times=" + this.times + ", sessionReached=" + this.sessionReached + ')';
    }
}
