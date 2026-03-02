package com.bat.sdk.asav.core;

import kotlin.Metadata;

/* JADX INFO: compiled from: IAsavChannel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J \u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\nH&¨\u0006\u0012"}, m5598d2 = {"Lcom/bat/sdk/asav/core/IAsavChannel;", "", "newInputBucket", "Lcom/bat/sdk/asav/core/IAsavInputBucket;", "data", "", "addToBucket", "", "bucket", "newOutputBucket", "Lcom/bat/sdk/asav/core/IAsavOutputBucket;", "challengeRequestBucket", "unlockAckBucket", "toUUID", "seq", "", "num", "payload", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface IAsavChannel {
    void addToBucket(String data, IAsavInputBucket bucket);

    IAsavOutputBucket challengeRequestBucket();

    IAsavInputBucket newInputBucket(String data);

    IAsavOutputBucket newOutputBucket(String data);

    String toUUID(int seq, int num, IAsavOutputBucket payload);

    IAsavOutputBucket unlockAckBucket();
}
