package androidx.camera.view;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PreviewView$1$$ExternalSyntheticBackportWithForwarding0 {
    /* JADX INFO: renamed from: m */
    public static /* synthetic */ boolean m1161m(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }
}
