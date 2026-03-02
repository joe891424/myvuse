package com.bat.sdk.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m5598d2 = {"Lcom/bat/sdk/domain/Configuration;", "", "saveLogs", "", "keepLastConnectionAliva", "<init>", "(ZZ)V", "getSaveLogs", "()Z", "getKeepLastConnectionAliva", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class Configuration {
    private final boolean keepLastConnectionAliva;
    private final boolean saveLogs;

    public static /* synthetic */ Configuration copy$default(Configuration configuration, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = configuration.saveLogs;
        }
        if ((i & 2) != 0) {
            z2 = configuration.keepLastConnectionAliva;
        }
        return configuration.copy(z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSaveLogs() {
        return this.saveLogs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getKeepLastConnectionAliva() {
        return this.keepLastConnectionAliva;
    }

    public final Configuration copy(boolean saveLogs, boolean keepLastConnectionAliva) {
        return new Configuration(saveLogs, keepLastConnectionAliva);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) other;
        return this.saveLogs == configuration.saveLogs && this.keepLastConnectionAliva == configuration.keepLastConnectionAliva;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.saveLogs) * 31) + Boolean.hashCode(this.keepLastConnectionAliva);
    }

    public String toString() {
        return "Configuration(saveLogs=" + this.saveLogs + ", keepLastConnectionAliva=" + this.keepLastConnectionAliva + ')';
    }

    public Configuration(boolean z, boolean z2) {
        this.saveLogs = z;
        this.keepLastConnectionAliva = z2;
    }

    public /* synthetic */ Configuration(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, z2);
    }

    public final boolean getSaveLogs() {
        return this.saveLogs;
    }

    public final boolean getKeepLastConnectionAliva() {
        return this.keepLastConnectionAliva;
    }
}
