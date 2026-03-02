package com.salesforce.marketingcloud.messages.iam;

import android.os.CountDownTimer;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.a */
/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractCountDownTimerC4250a extends CountDownTimer {

    /* JADX INFO: renamed from: a */
    private long f5224a;

    /* JADX INFO: renamed from: b */
    private long f5225b;

    AbstractCountDownTimerC4250a(long j, long j2) {
        super(j - j2, 500L);
        this.f5225b = j;
    }

    /* JADX INFO: renamed from: a */
    public long m3704a() {
        return this.f5225b - this.f5224a;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f5224a = 0L;
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        this.f5224a = j;
    }
}
