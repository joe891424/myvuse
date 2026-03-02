package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.EncodedImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: DecodeException.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m5598d2 = {"Lcom/facebook/imagepipeline/decoder/DecodeException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "encodedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "(Ljava/lang/String;Lcom/facebook/imagepipeline/image/EncodedImage;)V", RsaJsonWebKey.FACTOR_CRT_COEFFICIENT, "", "(Ljava/lang/String;Ljava/lang/Throwable;Lcom/facebook/imagepipeline/image/EncodedImage;)V", "getEncodedImage", "()Lcom/facebook/imagepipeline/image/EncodedImage;", "imagepipeline_release"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
public final class DecodeException extends RuntimeException {
    private final EncodedImage encodedImage;

    public final EncodedImage getEncodedImage() {
        return this.encodedImage;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecodeException(String str, EncodedImage encodedImage) {
        super(str);
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        this.encodedImage = encodedImage;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecodeException(String str, Throwable th, EncodedImage encodedImage) {
        super(str, th);
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        this.encodedImage = encodedImage;
    }
}
