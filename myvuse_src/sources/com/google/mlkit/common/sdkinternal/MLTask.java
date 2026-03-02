package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTaskInput;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MLTask<T, S extends MLTaskInput> extends ModelResource {
    public abstract T run(S s) throws MlKitException;
}
