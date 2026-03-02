package com.facebook.binaryresource;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;

/* JADX INFO: compiled from: BinaryResource.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m5598d2 = {"Lcom/facebook/binaryresource/BinaryResource;", "", "openStream", "Ljava/io/InputStream;", "read", "", "size", "", "imagepipeline-base_release"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
public interface BinaryResource {
    InputStream openStream() throws IOException;

    byte[] read() throws IOException;

    long size();
}
