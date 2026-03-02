package com.yoti.mobile.mpp.mrtddump.chipinfo;

import com.google.common.primitives.SignedBytes;
import com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException;
import com.yoti.mobile.mpp.mrtddump.asn1.PartialTlvObject;
import com.yoti.mobile.mpp.mrtddump.asn1.TlvObject;
import com.yoti.mobile.mpp.mrtddump.asn1.TlvParser;
import com.yoti.mobile.mpp.mrtddump.p096j.C5119c;
import com.yoti.mobile.mpp.mrtddump.p096j.C5120d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.f.c */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"MAX_LENGTH_EXTENDED", "", "MAX_LENGTH_NOT_EXTENDED", "TAG", "", "TAG_CARD_CAPABILITIES", "TAG_EXTENDED_INFO", "TAG_EXTENDED_INFO_INTERNAL", "parseExtendedLengthInformation", "Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ExtendedLengthInfo;", "extendedInfo", "Lcom/yoti/mobile/mpp/mrtddump/asn1/TlvObject;", "parseThirdFunctionTable", "Lcom/yoti/mobile/mpp/mrtddump/chipinfo/ThirdFunctionTable;", "capabilities", "", "Lcom/yoti/mobile/mpp/mrtddump/FileData;", "mrtddump_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C5092c {

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.f.c$a */
    @Metadata(m5597d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m5598d2 = {"<anonymous>", "", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    static final class a extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final a f8046a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Extended info parsing failed";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static final ExtendedLengthInfo m5460b(TlvObject tlvObject) {
        TlvParser tlvParser = new TlvParser(tlvObject);
        try {
            PartialTlvObject partialTlvObjectM5447b = tlvParser.m5447b();
            if (partialTlvObjectM5447b == null) {
                return null;
            }
            if (partialTlvObjectM5447b.getF8036a() != 2) {
                if (C5120d.m5539a() <= 5) {
                    C5119c.m5533a("MrtdFileGenerator", Intrinsics.stringPlus("Unexpected tag in extended info ", Integer.valueOf(partialTlvObjectM5447b.getF8036a())), null, 4, null);
                }
                return null;
            }
            PartialTlvObject partialTlvObjectM5447b2 = tlvParser.m5447b();
            if (partialTlvObjectM5447b2 == null) {
                return null;
            }
            if (partialTlvObjectM5447b2.getF8036a() == 2) {
                return new ExtendedLengthInfo(partialTlvObjectM5447b.m5441c(), partialTlvObjectM5447b2.m5441c());
            }
            if (C5120d.m5539a() <= 5) {
                C5119c.m5533a("MrtdFileGenerator", Intrinsics.stringPlus("Unexpected tag in extended info ", Integer.valueOf(partialTlvObjectM5447b2.getF8036a())), null, 4, null);
            }
            return null;
        } catch (MrtdUnexpectedDataFormatException e) {
            C5120d.m5541a("MrtdFileGenerator", e, a.f8046a);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static final ThirdFunctionTable m5461b(byte[] bArr) {
        if (bArr.length >= 3) {
            byte b = bArr[2];
            return new ThirdFunctionTable((b & 128) != 0, (b & SignedBytes.MAX_POWER_OF_TWO) != 0, (b & 32) != 0);
        }
        if (C5120d.m5539a() <= 4) {
            C5119c.m5537c("MrtdFileGenerator", "ATR missing third software function table", null, 4, null);
        }
        return null;
    }
}
