package com.salesforce.marketingcloud.sfmcsdk;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: SFMCSdk.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/SFMCSdkInitializationStatus;", "Lcom/salesforce/marketingcloud/sfmcsdk/InitializationStatus;", FirebaseAnalytics.Param.SUCCESS, "", "(Z)V", "status", "", "getStatus", "()I", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SFMCSdkInitializationStatus implements InitializationStatus {
    private final boolean success;

    public SFMCSdkInitializationStatus(boolean z) {
        this.success = z;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.InitializationStatus
    public int getStatus() {
        return this.success ? 1 : -1;
    }
}
