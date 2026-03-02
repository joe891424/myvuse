package androidx.camera.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class TorchState {
    public static final int OFF = 0;

    /* JADX INFO: renamed from: ON */
    public static final int f1709ON = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    private TorchState() {
    }
}
