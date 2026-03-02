package com.newrelic.agent.android.util;

import android.util.Base64;

/* JADX INFO: loaded from: classes6.dex */
public class AndroidEncoder implements Encoder {
    @Override // com.newrelic.agent.android.util.Encoder
    public String encode(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }

    @Override // com.newrelic.agent.android.util.Encoder
    public String encodeNoWrap(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }
}
