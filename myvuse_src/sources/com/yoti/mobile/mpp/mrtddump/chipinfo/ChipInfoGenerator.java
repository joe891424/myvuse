package com.yoti.mobile.mpp.mrtddump.chipinfo;

import com.yoti.mobile.mpp.mrtddump.MrtdReaderConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.f.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004J\u001c\u0010\b\u001a\u00020\u00042\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfoGenerator;", "", "()V", "generateDefault", "Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ChipInfo;", "config", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderConfig;", "generateExtended", "generateFromAtr", "atr", "", "Lcom/yoti/mobile/mpp/mrtddump/FileData;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ChipInfoGenerator {

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.f.b$a */
    @Metadata(m5597d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m5598d2 = {"<anonymous>", "", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    static final class a extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final a f8045a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "ATR parsing failed";
        }
    }

    /* JADX INFO: renamed from: a */
    public final ChipInfo m5454a() {
        return new ChipInfo(true, 1000, 1000, true);
    }

    /* JADX INFO: renamed from: a */
    public final ChipInfo m5455a(MrtdReaderConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return new ChipInfo(false, 255, config.getReadBlockSize(), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054 A[Catch: MrtdUnexpectedDataFormatException -> 0x009e, TryCatch #0 {MrtdUnexpectedDataFormatException -> 0x009e, blocks: (B:3:0x000c, B:15:0x0054, B:17:0x0060, B:28:0x0098, B:20:0x006f, B:23:0x0077, B:24:0x0086, B:26:0x008c, B:6:0x0026, B:9:0x002e, B:10:0x003d, B:12:0x0047), top: B:33:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060 A[Catch: MrtdUnexpectedDataFormatException -> 0x009e, TryCatch #0 {MrtdUnexpectedDataFormatException -> 0x009e, blocks: (B:3:0x000c, B:15:0x0054, B:17:0x0060, B:28:0x0098, B:20:0x006f, B:23:0x0077, B:24:0x0086, B:26:0x008c, B:6:0x0026, B:9:0x002e, B:10:0x003d, B:12:0x0047), top: B:33:0x000c }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfo m5456a(byte[] r7, com.yoti.mobile.mpp.mrtddump.MrtdReaderConfig r8) {
        /*
            r6 = this;
            java.lang.String r0 = "MrtdFileGenerator"
            java.lang.String r1 = "atr"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "config"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            com.yoti.mobile.mpp.mrtddump.e.e r1 = new com.yoti.mobile.mpp.mrtddump.e.e     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            r1.<init>(r7)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            java.util.Map r7 = r1.m5448c()     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            r1 = 71
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            java.lang.Object r1 = r7.get(r1)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            com.yoti.mobile.mpp.mrtddump.e.b r1 = (com.yoti.mobile.mpp.mrtddump.asn1.PartialTlvObject) r1     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L26
            goto L50
        L26:
            int r4 = com.yoti.mobile.mpp.mrtddump.p096j.C5120d.m5539a()     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            if (r4 > r2) goto L3d
            java.lang.String r4 = "Capabilities from ATR: "
            byte[] r5 = r1.getF8037b()     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            java.lang.String r5 = com.yoti.mobile.mpp.smartcard.extensions.ByteArrayKt.toStringHex(r5)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r5)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            com.yoti.mobile.mpp.mrtddump.p096j.C5119c.m5531a(r0, r4)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
        L3d:
            byte[] r1 = r1.getF8037b()     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            com.yoti.mobile.mpp.mrtddump.f.f r1 = com.yoti.mobile.mpp.mrtddump.chipinfo.C5092c.m5459a(r1)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            if (r1 == 0) goto L50
            boolean r4 = r1.getF8058b()     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            boolean r1 = r1.getF8057a()     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            goto L52
        L50:
            r1 = r3
            r4 = r1
        L52:
            if (r4 != 0) goto L60
            com.yoti.mobile.mpp.mrtddump.f.a r7 = new com.yoti.mobile.mpp.mrtddump.f.a     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            int r2 = r8.getReadBlockSize()     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            r4 = 255(0xff, float:3.57E-43)
            r7.<init>(r3, r4, r2, r1)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            return r7
        L60:
            r3 = 32614(0x7f66, float:4.5702E-41)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            java.lang.Object r7 = r7.get(r3)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            com.yoti.mobile.mpp.mrtddump.e.b r7 = (com.yoti.mobile.mpp.mrtddump.asn1.PartialTlvObject) r7     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            if (r7 != 0) goto L6f
            goto L95
        L6f:
            int r3 = com.yoti.mobile.mpp.mrtddump.p096j.C5120d.m5539a()     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            if (r3 > r2) goto L86
            java.lang.String r2 = "Extended info from ATR: "
            byte[] r3 = r7.getF8037b()     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            java.lang.String r3 = com.yoti.mobile.mpp.smartcard.extensions.ByteArrayKt.toStringHex(r3)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            com.yoti.mobile.mpp.mrtddump.p096j.C5119c.m5531a(r0, r2)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
        L86:
            com.yoti.mobile.mpp.mrtddump.f.e r7 = com.yoti.mobile.mpp.mrtddump.chipinfo.C5092c.m5458a(r7)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            if (r7 == 0) goto L95
            int r2 = r7.getF8055a()     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            int r7 = r7.getF8056b()     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            goto L98
        L95:
            r2 = 1000(0x3e8, float:1.401E-42)
            r7 = r2
        L98:
            com.yoti.mobile.mpp.mrtddump.f.a r3 = new com.yoti.mobile.mpp.mrtddump.f.a     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            r3.<init>(r4, r2, r7, r1)     // Catch: com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException -> L9e
            return r3
        L9e:
            r7 = move-exception
            com.yoti.mobile.mpp.mrtddump.f.b$a r1 = com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfoGenerator.a.f8045a
            com.yoti.mobile.mpp.mrtddump.p096j.C5120d.m5541a(r0, r7, r1)
            com.yoti.mobile.mpp.mrtddump.f.a r7 = r6.m5455a(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfoGenerator.m5456a(byte[], com.yoti.mobile.mpp.mrtddump.MrtdReaderConfig):com.yoti.mobile.mpp.mrtddump.f.a");
    }
}
