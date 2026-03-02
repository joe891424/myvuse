package com.wheelpicker;

import java.util.TimerTask;

/* JADX INFO: loaded from: classes6.dex */
final class LoopTimerTask extends TimerTask {

    /* JADX INFO: renamed from: a */
    float f5846a = 2.1474836E9f;
    final LoopView loopView;
    final float velocityY;

    LoopTimerTask(LoopView loopView, float f) {
        this.loopView = loopView;
        this.velocityY = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f5846a == 2.1474836E9f) {
            if (Math.abs(this.velocityY) <= 2000.0f) {
                this.f5846a = this.velocityY;
            } else if (this.velocityY > 0.0f) {
                this.f5846a = 2000.0f;
            } else {
                this.f5846a = -2000.0f;
            }
        }
        if (Math.abs(this.f5846a) >= 0.0f && Math.abs(this.f5846a) <= 20.0f) {
            this.loopView.cancelFuture();
            this.loopView.handler.sendEmptyMessage(2000);
            return;
        }
        this.loopView.totalScrollY -= (int) ((this.f5846a * 10.0f) / 1000.0f);
        if (!this.loopView.isLoop) {
            float f = this.loopView.lineSpacingMultiplier * this.loopView.maxTextHeight;
            if (this.loopView.totalScrollY <= ((int) ((-this.loopView.initPosition) * f))) {
                this.f5846a = 40.0f;
                this.loopView.totalScrollY = (int) ((-r3.initPosition) * f);
            } else if (this.loopView.totalScrollY >= ((int) (((this.loopView.arrayList.size() - 1) - this.loopView.initPosition) * f))) {
                this.loopView.totalScrollY = (int) (((r3.arrayList.size() - 1) - this.loopView.initPosition) * f);
                this.f5846a = -40.0f;
            }
        }
        float f2 = this.f5846a;
        if (f2 < 0.0f) {
            this.f5846a = f2 + 20.0f;
        } else {
            this.f5846a = f2 - 20.0f;
        }
        this.loopView.handler.sendEmptyMessage(1000);
    }
}
