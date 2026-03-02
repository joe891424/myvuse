package net.lingala.zip4j.p101io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.model.FileHeader;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SplitFileInputStream extends InputStream {
    public abstract void prepareExtractionForFileHeader(FileHeader fileHeader) throws IOException;
}
