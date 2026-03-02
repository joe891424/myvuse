package io.ktor.utils.p098io.internal;

import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.hermes.intl.Constants;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwt.ReservedClaimNames;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0006H\u0000\u001a\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u000f\u001a\u00020\t*\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0001H\u0000¨\u0006\u0012"}, m5598d2 = {"getIOIntProperty", "", "name", "", Constants.COLLATION_DEFAULT, "indexOfPartial", "Ljava/nio/ByteBuffer;", ReservedClaimNames.SUBJECT, "isEmpty", "", "putAtMost", ReactVideoViewManager.PROP_SRC, RsaJsonWebKey.MODULUS_MEMBER_NAME, "putLimited", "limit", "startsWith", "prefix", "prefixSkip", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class UtilsKt {
    public static final boolean isEmpty(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        return !byteBuffer.hasRemaining();
    }

    public static final int getIOIntProperty(String name, int i) {
        String property;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            property = System.getProperty(Intrinsics.stringPlus("io.ktor.utils.io.", name));
        } catch (SecurityException unused) {
            property = null;
        }
        return (property == null || (intOrNull = StringsKt.toIntOrNull(property)) == null) ? i : intOrNull.intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        return r4 - r9.position();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int indexOfPartial(java.nio.ByteBuffer r9, java.nio.ByteBuffer r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "sub"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = r10.position()
            int r1 = r10.remaining()
            byte r2 = r10.get(r0)
            int r3 = r9.limit()
            int r4 = r9.position()
            if (r4 >= r3) goto L4e
        L20:
            int r5 = r4 + 1
            byte r6 = r9.get(r4)
            if (r6 != r2) goto L49
            r6 = 1
            if (r6 >= r1) goto L43
        L2b:
            int r7 = r6 + 1
            int r8 = r4 + r6
            if (r8 != r3) goto L32
            goto L43
        L32:
            byte r8 = r9.get(r8)
            int r6 = r6 + r0
            byte r6 = r10.get(r6)
            if (r8 == r6) goto L3e
            goto L49
        L3e:
            if (r7 < r1) goto L41
            goto L43
        L41:
            r6 = r7
            goto L2b
        L43:
            int r9 = r9.position()
            int r4 = r4 - r9
            return r4
        L49:
            if (r5 < r3) goto L4c
            goto L4e
        L4c:
            r4 = r5
            goto L20
        L4e:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.internal.UtilsKt.indexOfPartial(java.nio.ByteBuffer, java.nio.ByteBuffer):int");
    }

    public static /* synthetic */ boolean startsWith$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return startsWith(byteBuffer, byteBuffer2, i);
    }

    public static final boolean startsWith(ByteBuffer byteBuffer, ByteBuffer prefix, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        int iMin = Math.min(byteBuffer.remaining(), prefix.remaining() - i);
        if (iMin <= 0) {
            return false;
        }
        int iPosition = byteBuffer.position();
        int iPosition2 = prefix.position() + i;
        if (iMin <= 0) {
            return true;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (byteBuffer.get(iPosition + i2) != prefix.get(i2 + iPosition2)) {
                return false;
            }
            if (i3 >= iMin) {
                return true;
            }
            i2 = i3;
        }
    }

    public static /* synthetic */ int putAtMost$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer2.remaining();
        }
        return putAtMost(byteBuffer, byteBuffer2, i);
    }

    public static final int putAtMost(ByteBuffer byteBuffer, ByteBuffer src, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        int iRemaining = byteBuffer.remaining();
        int iRemaining2 = src.remaining();
        if (iRemaining2 <= iRemaining && iRemaining2 <= i) {
            byteBuffer.put(src);
        } else {
            iRemaining2 = Math.min(iRemaining, Math.min(iRemaining2, i));
            int i2 = 1;
            if (1 <= iRemaining2) {
                while (true) {
                    int i3 = i2 + 1;
                    byteBuffer.put(src.get());
                    if (i2 == iRemaining2) {
                        break;
                    }
                    i2 = i3;
                }
            }
        }
        return iRemaining2;
    }

    public static /* synthetic */ int putLimited$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer.limit();
        }
        return putLimited(byteBuffer, byteBuffer2, i);
    }

    public static final int putLimited(ByteBuffer byteBuffer, ByteBuffer src, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        return putAtMost(byteBuffer, src, i - src.position());
    }
}
