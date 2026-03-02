package com.yoti.mobile.mpp.mrtddump.reader;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.f, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/reader/TransparentFileType;", "", "fileId", "", "(Ljava/lang/String;II)V", "getFileId", "()I", "EF_ATR", "EF_CARDSECURITY", "EF_DIR", "EF_CARDACCESS", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public enum TransparentFileType {
    EF_ATR(12033),
    EF_CARDSECURITY(285),
    EF_DIR(12032),
    EF_CARDACCESS(284);


    /* JADX INFO: renamed from: f */
    private final int f8192f;

    TransparentFileType(int i) {
        this.f8192f = i;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getF8192f() {
        return this.f8192f;
    }
}
