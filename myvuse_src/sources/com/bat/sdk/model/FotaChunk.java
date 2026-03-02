package com.bat.sdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FotaChunk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/model/FotaChunk;", "", "chunk", "", "<init>", "([B)V", "getChunk", "()[B", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class FotaChunk {
    private final byte[] chunk;

    public FotaChunk(byte[] chunk) {
        Intrinsics.checkNotNullParameter(chunk, "chunk");
        this.chunk = chunk;
    }

    public final byte[] getChunk() {
        return this.chunk;
    }
}
