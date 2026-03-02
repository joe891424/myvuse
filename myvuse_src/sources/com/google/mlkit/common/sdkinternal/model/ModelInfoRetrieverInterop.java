package com.google.mlkit.common.sdkinternal.model;

import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelInfo;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface ModelInfoRetrieverInterop {
    ModelInfo retrieveRemoteModelInfo(RemoteModel remoteModel) throws MlKitException;
}
