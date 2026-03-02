package com.shazam.android.widget.text.reflow;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes6.dex */
class Run {
    private final Rect end;
    private final boolean endVisible;
    private final Rect start;
    private final boolean startVisible;

    Run(Rect rect, boolean z, Rect rect2, boolean z2) {
        this.start = rect;
        this.startVisible = z;
        this.end = rect2;
        this.endVisible = z2;
    }

    Rect getStart() {
        return this.start;
    }

    boolean isStartVisible() {
        return this.startVisible;
    }

    Rect getEnd() {
        return this.end;
    }

    boolean isEndVisible() {
        return this.endVisible;
    }
}
