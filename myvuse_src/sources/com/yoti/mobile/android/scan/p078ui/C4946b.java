package com.yoti.mobile.android.scan.p078ui;

/* JADX INFO: renamed from: com.yoti.mobile.android.scan.ui.b */
/* JADX INFO: loaded from: classes4.dex */
public final class C4946b {

    /* JADX INFO: renamed from: a */
    private final boolean f7437a;

    public C4946b(boolean z) {
        this.f7437a = z;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m5073a() {
        return this.f7437a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof C4946b) && this.f7437a == ((C4946b) obj).f7437a;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.f7437a;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "ScannerViewData(showInstructions=" + this.f7437a + ")";
    }
}
