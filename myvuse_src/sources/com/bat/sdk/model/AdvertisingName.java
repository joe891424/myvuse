package com.bat.sdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdvertisingName.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, m5598d2 = {"Lcom/bat/sdk/model/AdvertisingName;", "", "codeHex", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCodeHex", "()Ljava/lang/String;", "getName", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AdvertisingName {
    private final String codeHex;
    private final String name;

    public AdvertisingName(String codeHex, String name) {
        Intrinsics.checkNotNullParameter(codeHex, "codeHex");
        Intrinsics.checkNotNullParameter(name, "name");
        this.codeHex = codeHex;
        this.name = name;
    }

    public final String getCodeHex() {
        return this.codeHex;
    }

    public final String getName() {
        return this.name;
    }
}
