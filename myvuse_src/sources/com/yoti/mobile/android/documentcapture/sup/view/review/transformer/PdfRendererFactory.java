package com.yoti.mobile.android.documentcapture.sup.view.review.transformer;

import android.content.Context;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/PdfRendererFactory;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "create", "Landroid/graphics/pdf/PdfRenderer;", "filePath", "Landroid/net/Uri;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class PdfRendererFactory {
    private final Context context;

    @Inject
    public PdfRendererFactory(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final PdfRenderer create(Uri filePath) throws IOException, SecurityException {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.context.getContentResolver().openFileDescriptor(filePath, RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME);
        if (parcelFileDescriptorOpenFileDescriptor != null) {
            return new PdfRenderer(parcelFileDescriptorOpenFileDescriptor);
        }
        throw new IllegalArgumentException("Invalid filePath".toString());
    }
}
