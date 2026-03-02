package com.google.common.base;

import java.nio.charset.Charset;
import net.lingala.zip4j.util.InternalZipConstants;
import org.jose4j.lang.StringUtil;

/* JADX INFO: loaded from: classes2.dex */
@ElementTypesAreNonnullByDefault
public final class Charsets {
    public static final Charset US_ASCII = Charset.forName(StringUtil.US_ASCII);
    public static final Charset ISO_8859_1 = Charset.forName(InternalZipConstants.AES_HASH_CHARSET);
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
    public static final Charset UTF_16LE = Charset.forName("UTF-16LE");
    public static final Charset UTF_16 = Charset.forName("UTF-16");

    private Charsets() {
    }
}
