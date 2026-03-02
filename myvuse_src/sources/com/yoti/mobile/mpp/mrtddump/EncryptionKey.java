package com.yoti.mobile.mpp.mrtddump;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/EncryptionKey;", "Lcom/yoti/mobile/mpp/mrtddump/Key;", "value", "", "([B)V", "isMatchingClass", "", "other", "", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class EncryptionKey extends Key {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncryptionKey(byte[] value) {
        super(value, null);
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // com.yoti.mobile.mpp.mrtddump.Key
    /* JADX INFO: renamed from: a */
    public boolean mo5381a(Object obj) {
        return obj instanceof EncryptionKey;
    }
}
