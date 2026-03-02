package com.bat.sdk.asav.core;

import kotlin.Metadata;

/* JADX INFO: compiled from: IAsavChannels.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\u000e"}, m5598d2 = {"Lcom/bat/sdk/asav/core/IAsavChannels;", "", "challengeRequestChannel", "Lcom/bat/sdk/asav/core/IAsavChannel;", "getChallengeRequestChannel", "()Lcom/bat/sdk/asav/core/IAsavChannel;", "challengeResponseChannel", "getChallengeResponseChannel", "signatureRequestChannel", "getSignatureRequestChannel", "signatureResponseChannel", "getSignatureResponseChannel", "init", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface IAsavChannels {
    IAsavChannel getChallengeRequestChannel();

    IAsavChannel getChallengeResponseChannel();

    IAsavChannel getSignatureRequestChannel();

    IAsavChannel getSignatureResponseChannel();

    void init();
}
