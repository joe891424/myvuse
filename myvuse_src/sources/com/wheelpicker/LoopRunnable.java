package com.wheelpicker;

/* JADX INFO: loaded from: classes6.dex */
final class LoopRunnable implements Runnable {
    final LoopView loopView;

    LoopRunnable(LoopView loopView) {
        this.loopView = loopView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LoopListener loopListener = this.loopView.loopListener;
        int selectedItem = LoopView.getSelectedItem(this.loopView);
        this.loopView.arrayList.get(selectedItem);
        loopListener.onItemSelect(this.loopView, selectedItem);
    }
}
