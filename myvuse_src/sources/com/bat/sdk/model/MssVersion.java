package com.bat.sdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MssVersion.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, m5598d2 = {"Lcom/bat/sdk/model/MssVersion;", "", "code", "", "codeHex", "", "payload", "payloadHex", "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "getCode", "()I", "getCodeHex", "()Ljava/lang/String;", "getPayload", "getPayloadHex", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class MssVersion {
    private final int code;
    private final String codeHex;
    private final int payload;
    private final String payloadHex;

    public static /* synthetic */ MssVersion copy$default(MssVersion mssVersion, int i, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mssVersion.code;
        }
        if ((i3 & 2) != 0) {
            str = mssVersion.codeHex;
        }
        if ((i3 & 4) != 0) {
            i2 = mssVersion.payload;
        }
        if ((i3 & 8) != 0) {
            str2 = mssVersion.payloadHex;
        }
        return mssVersion.copy(i, str, i2, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCodeHex() {
        return this.codeHex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPayload() {
        return this.payload;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPayloadHex() {
        return this.payloadHex;
    }

    public final MssVersion copy(int code, String codeHex, int payload, String payloadHex) {
        Intrinsics.checkNotNullParameter(codeHex, "codeHex");
        Intrinsics.checkNotNullParameter(payloadHex, "payloadHex");
        return new MssVersion(code, codeHex, payload, payloadHex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MssVersion)) {
            return false;
        }
        MssVersion mssVersion = (MssVersion) other;
        return this.code == mssVersion.code && Intrinsics.areEqual(this.codeHex, mssVersion.codeHex) && this.payload == mssVersion.payload && Intrinsics.areEqual(this.payloadHex, mssVersion.payloadHex);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.code) * 31) + this.codeHex.hashCode()) * 31) + Integer.hashCode(this.payload)) * 31) + this.payloadHex.hashCode();
    }

    public String toString() {
        return "MssVersion(code=" + this.code + ", codeHex=" + this.codeHex + ", payload=" + this.payload + ", payloadHex=" + this.payloadHex + ')';
    }

    public MssVersion(int i, String codeHex, int i2, String payloadHex) {
        Intrinsics.checkNotNullParameter(codeHex, "codeHex");
        Intrinsics.checkNotNullParameter(payloadHex, "payloadHex");
        this.code = i;
        this.codeHex = codeHex;
        this.payload = i2;
        this.payloadHex = payloadHex;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getCodeHex() {
        return this.codeHex;
    }

    public final int getPayload() {
        return this.payload;
    }

    public final String getPayloadHex() {
        return this.payloadHex;
    }
}
