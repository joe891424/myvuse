package com.google.mlkit.vision.common.internal;

import androidx.lifecycle.LifecycleObserver;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import java.io.Closeable;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface Detector<DetectionResultT> extends Closeable, LifecycleObserver {
    Task<DetectionResultT> process(InputImage inputImage);
}
