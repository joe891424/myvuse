package com.google.mlkit.common.sdkinternal.model;

import com.google.mlkit.common.MlKitException;
import java.io.File;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface RemoteModelFileMover {
    File getModelFileDestination() throws MlKitException;

    File moveAllFilesFromPrivateTempToPrivateDestination(File file) throws MlKitException;
}
