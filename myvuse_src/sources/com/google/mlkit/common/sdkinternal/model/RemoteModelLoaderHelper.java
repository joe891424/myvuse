package com.google.mlkit.common.sdkinternal.model;

import com.google.mlkit.common.MlKitException;
import java.nio.MappedByteBuffer;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface RemoteModelLoaderHelper {
    MappedByteBuffer loadModelAtPath(String str) throws MlKitException;
}
