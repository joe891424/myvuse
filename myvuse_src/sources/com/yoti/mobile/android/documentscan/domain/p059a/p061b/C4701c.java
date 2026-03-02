package com.yoti.mobile.android.documentscan.domain.p059a.p061b;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkid.imageresult.EncodedFaceImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.FaceImageResult;
import com.microblink.image.Image;
import com.yoti.mobile.android.commons.image.DirectBuffer;
import com.yoti.mobile.android.documentscan.domain.C4715d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.a.b.c */
/* JADX INFO: loaded from: classes5.dex */
public final class C4701c {

    /* JADX INFO: renamed from: a */
    private final C4715d f6873a;

    public C4701c(C4715d blinkImageConverter) {
        Intrinsics.checkParameterIsNotNull(blinkImageConverter, "blinkImageConverter");
        this.f6873a = blinkImageConverter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ C4701c(C4715d c4715d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C4715d(null, 1, 0 == true ? 1 : 0) : c4715d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.yoti.mobile.android.commons.image.DirectBuffer m4743a(int r4, com.microblink.entities.recognizers.Recognizer.Result r5) {
        /*
            r3 = this;
            r0 = 0
            if (r5 == 0) goto L24
            boolean r1 = r5 instanceof com.microblink.entities.recognizers.blinkid.imageresult.CombinedFullDocumentImageResult
            if (r1 == 0) goto L16
            r1 = r5
            com.microblink.entities.recognizers.blinkid.imageresult.CombinedFullDocumentImageResult r1 = (com.microblink.entities.recognizers.blinkid.imageresult.CombinedFullDocumentImageResult) r1
            if (r4 == 0) goto L11
            com.microblink.image.Image r1 = r1.getFullDocumentBackImage()
            goto L25
        L11:
            com.microblink.image.Image r1 = r1.getFullDocumentFrontImage()
            goto L25
        L16:
            boolean r1 = r5 instanceof com.microblink.entities.recognizers.blinkid.imageresult.FullDocumentImageResult
            if (r1 == 0) goto L24
            if (r4 != 0) goto L24
            r1 = r5
            com.microblink.entities.recognizers.blinkid.imageresult.FullDocumentImageResult r1 = (com.microblink.entities.recognizers.blinkid.imageresult.FullDocumentImageResult) r1
            com.microblink.image.Image r1 = r1.getFullDocumentImage()
            goto L25
        L24:
            r1 = r0
        L25:
            if (r1 == 0) goto L2e
            com.yoti.mobile.android.documentscan.a.d r2 = r3.f6873a
            com.yoti.mobile.android.commons.image.DirectBuffer r1 = r2.m4791a(r1)
            goto L2f
        L2e:
            r1 = r0
        L2f:
            if (r1 != 0) goto L4a
            if (r4 != 0) goto L4a
            boolean r4 = r5 instanceof com.microblink.entities.recognizers.blinkid.imageresult.EncodedFullDocumentImageResult
            if (r4 == 0) goto L4a
            com.microblink.entities.recognizers.blinkid.imageresult.EncodedFullDocumentImageResult r5 = (com.microblink.entities.recognizers.blinkid.imageresult.EncodedFullDocumentImageResult) r5
            byte[] r4 = r5.getEncodedFullDocumentImage()
            if (r4 == 0) goto L4a
            com.yoti.mobile.android.documentscan.a.d r5 = r3.f6873a
            java.lang.String r1 = "rawJpeg"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r1)
            com.yoti.mobile.android.commons.image.DirectBuffer r1 = r5.m4792a(r4)
        L4a:
            if (r1 == 0) goto L52
            com.yoti.mobile.android.commons.image.DirectBuffer$Companion r4 = com.yoti.mobile.android.commons.image.DirectBuffer.INSTANCE
            com.yoti.mobile.android.commons.image.DirectBuffer r0 = r4.convert(r1)
        L52:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentscan.domain.p059a.p061b.C4701c.m4743a(int, com.microblink.entities.recognizers.Recognizer$Result):com.yoti.mobile.android.commons.image.DirectBuffer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public final DirectBuffer m4744a(Recognizer.Result result) {
        DirectBuffer directBufferM4791a;
        byte[] rawJpeg;
        Image faceImage;
        if (!(result instanceof FaceImageResult) || (faceImage = ((FaceImageResult) result).getFaceImage()) == null) {
            directBufferM4791a = null;
        } else {
            C4715d c4715d = this.f6873a;
            Intrinsics.checkExpressionValueIsNotNull(faceImage, "faceImage");
            directBufferM4791a = c4715d.m4791a(faceImage);
        }
        if (directBufferM4791a != null || !(result instanceof EncodedFaceImageResult) || (rawJpeg = ((EncodedFaceImageResult) result).getEncodedFaceImage()) == null) {
            return directBufferM4791a;
        }
        C4715d c4715d2 = this.f6873a;
        Intrinsics.checkExpressionValueIsNotNull(rawJpeg, "rawJpeg");
        return c4715d2.m4792a(rawJpeg);
    }
}
