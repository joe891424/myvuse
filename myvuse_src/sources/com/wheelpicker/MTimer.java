package com.wheelpicker;

import java.util.TimerTask;

/* JADX INFO: loaded from: classes6.dex */
final class MTimer extends TimerTask {
    final LoopView loopView;
    int offset;
    int realTotalOffset = Integer.MAX_VALUE;
    int realOffset = 0;

    MTimer(LoopView loopView, int i) {
        this.loopView = loopView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.realTotalOffset == Integer.MAX_VALUE) {
            float f = this.loopView.lineSpacingMultiplier * this.loopView.maxTextHeight;
            int i = (int) ((this.offset + f) % f);
            this.offset = i;
            if (i > f / 2.0f) {
                this.realTotalOffset = (int) (f - i);
            } else {
                this.realTotalOffset = -i;
            }
        }
        int i2 = this.realTotalOffset;
        int i3 = (int) (i2 * 0.1f);
        this.realOffset = i3;
        if (i3 == 0) {
            if (i2 < 0) {
                this.realOffset = -1;
            } else {
                this.realOffset = 1;
            }
        }
        if (Math.abs(i2) <= 0) {
            this.loopView.cancelFuture();
            this.loopView.handler.sendEmptyMessage(3000);
        } else {
            this.loopView.totalScrollY += this.realOffset;
            this.loopView.handler.sendEmptyMessage(1000);
            this.realTotalOffset -= this.realOffset;
        }
    }
}
