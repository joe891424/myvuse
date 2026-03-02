package com.yoti.mobile.mpp.mrtddump.reader;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\nj\u0002`\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0016\u0010\t\u001a\u00060\nj\u0002`\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileBuilder;", "", "currentSize", "", "getCurrentSize", "()I", "isComplete", "", "()Z", "rawValue", "", "Lcom/yoti/mobile/mpp/mrtddump/FileData;", "getRawValue", "()[B", "remainingBytes", "getRemainingBytes", "requiredSize", "getRequiredSize", "appendBytes", "", "newBytes", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface MrtdFileBuilder {

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.a$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a {
        /* JADX INFO: renamed from: a */
        public static int m5553a(MrtdFileBuilder mrtdFileBuilder) {
            Intrinsics.checkNotNullParameter(mrtdFileBuilder, "this");
            return mrtdFileBuilder.mo5549b() - mrtdFileBuilder.mo5552e();
        }

        /* JADX INFO: renamed from: b */
        public static boolean m5554b(MrtdFileBuilder mrtdFileBuilder) {
            Intrinsics.checkNotNullParameter(mrtdFileBuilder, "this");
            return mrtdFileBuilder.mo5549b() > 0 && mrtdFileBuilder.mo5551d() <= 0;
        }
    }

    /* JADX INFO: renamed from: a */
    void mo5547a(byte[] bArr);

    /* JADX INFO: renamed from: a */
    boolean mo5548a();

    /* JADX INFO: renamed from: b */
    int mo5549b();

    /* JADX INFO: renamed from: c */
    byte[] mo5550c();

    /* JADX INFO: renamed from: d */
    int mo5551d();

    /* JADX INFO: renamed from: e */
    int mo5552e();
}
