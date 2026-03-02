package com.yoti.mobile.mpp.mrtddump;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/BlockSizeSetting;", "", "sizeInBytes", "", "(Ljava/lang/String;II)V", "getSizeInBytes", "()I", "SMALL", "DEFAULT", "MAX", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public enum BlockSizeSetting {
    SMALL(223),
    DEFAULT(231),
    MAX(255);

    private final int sizeInBytes;

    BlockSizeSetting(int i) {
        this.sizeInBytes = i;
    }

    public final int getSizeInBytes() {
        return this.sizeInBytes;
    }
}
