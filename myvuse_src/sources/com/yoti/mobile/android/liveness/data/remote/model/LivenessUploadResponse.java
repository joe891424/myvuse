package com.yoti.mobile.android.liveness.data.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/data/remote/model/LivenessUploadResponse;", "", "accepted", "", "retriesRemaining", "", "(ZI)V", "getAccepted", "()Z", "getRetriesRemaining", "()I", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class LivenessUploadResponse {

    @SerializedName("accepted")
    private final boolean accepted;

    @SerializedName("retries_remaining")
    private final int retriesRemaining;

    public LivenessUploadResponse(boolean z, int i) {
        this.accepted = z;
        this.retriesRemaining = i;
    }

    public final boolean getAccepted() {
        return this.accepted;
    }

    public final int getRetriesRemaining() {
        return this.retriesRemaining;
    }
}
