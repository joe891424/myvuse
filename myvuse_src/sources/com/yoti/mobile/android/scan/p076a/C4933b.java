package com.yoti.mobile.android.scan.p076a;

import android.graphics.Rect;
import android.graphics.RectF;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.yoti.mobile.android.commons.image.CameraxBuffer;
import com.yoti.mobile.android.commons.image.DirectBuffer;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import com.yoti.mobile.android.core.image.RotationBuffer;
import com.yoti.mobile.android.core.yuvtools.YuvTools;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.scan.a.b */
/* JADX INFO: loaded from: classes4.dex */
public final class C4933b implements ImageAnalysis.Analyzer {

    /* JADX INFO: renamed from: a */
    private final QRCodeReader f7415a;

    /* JADX INFO: renamed from: b */
    private final Function1<String, Unit> f7416b;

    /* JADX WARN: Multi-variable type inference failed */
    public C4933b(Function1<? super String, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.f7416b = callback;
        this.f7415a = new QRCodeReader();
    }

    /* JADX INFO: renamed from: a */
    private final ImageBuffer m5060a(ImageProxy imageProxy) {
        ImageBuffer buffer = CameraxBuffer.toBuffer(imageProxy);
        Rect cropRect = imageProxy.getCropRect();
        Intrinsics.checkExpressionValueIsNotNull(cropRect, "image.cropRect");
        ImageBuffer imageBufferM5061a = m5061a(buffer, cropRect);
        ImageInfo imageInfo = imageProxy.getImageInfo();
        Intrinsics.checkExpressionValueIsNotNull(imageInfo, "image.imageInfo");
        return new RotationBuffer(imageBufferM5061a, imageInfo.getRotationDegrees());
    }

    /* JADX INFO: renamed from: a */
    private final ImageBuffer m5061a(ImageBuffer imageBuffer, Rect rect) {
        if (rect.isEmpty()) {
            return imageBuffer;
        }
        if (rect.width() == imageBuffer.getWidth() && rect.height() == imageBuffer.getHeight()) {
            return imageBuffer;
        }
        DirectBuffer directBufferYuvCrop = YuvTools.yuvCrop(imageBuffer, new RectF(rect));
        Intrinsics.checkExpressionValueIsNotNull(directBufferYuvCrop, "YuvTools.yuvCrop(buffer, RectF(cropRect))");
        return directBufferYuvCrop;
    }

    /* JADX INFO: renamed from: b */
    private final PlanarYUVLuminanceSource m5062b(ImageBuffer imageBuffer) {
        return new PlanarYUVLuminanceSource(imageBuffer.getData(), imageBuffer.getWidth(), imageBuffer.getHeight(), 0, 0, imageBuffer.getWidth(), imageBuffer.getHeight(), false);
    }

    /* JADX INFO: renamed from: a */
    public final void m5063a(ImageBuffer image) {
        Intrinsics.checkParameterIsNotNull(image, "image");
        this.f7415a.reset();
        try {
            Result zxingRes = this.f7415a.decode(new BinaryBitmap(new HybridBinarizer(m5062b(image))));
            Function1<String, Unit> function1 = this.f7416b;
            Intrinsics.checkExpressionValueIsNotNull(zxingRes, "zxingRes");
            String text = zxingRes.getText();
            Intrinsics.checkExpressionValueIsNotNull(text, "zxingRes.text");
            function1.invoke(text);
        } catch (ChecksumException | FormatException | NotFoundException unused) {
        }
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(ImageProxy image) throws Exception {
        Intrinsics.checkParameterIsNotNull(image, "image");
        try {
            m5063a(m5060a(image));
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(image, null);
        } finally {
        }
    }
}
