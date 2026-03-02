package com.yoti.mobile.android.documentscan.domain.transformer;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.microblink.entities.recognizers.Recognizer;
import com.yoti.mobile.android.commons.image.BufferHelper;
import com.yoti.mobile.android.commons.image.DirectBuffer;
import com.yoti.mobile.android.documentcapture.p055id.IdDocumentCaptureConstantsKt;
import com.yoti.mobile.android.documentscan.domain.C4724m;
import com.yoti.mobile.android.documentscan.domain.p059a.p061b.C4701c;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p099io.CloseableKt;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.transformer.d */
/* JADX INFO: loaded from: classes5.dex */
public final class C4733d implements InterfaceC4730a {

    /* JADX INFO: renamed from: a */
    private final Context f6943a;

    /* JADX INFO: renamed from: b */
    private final C4724m f6944b;

    /* JADX INFO: renamed from: c */
    private final C4701c f6945c;

    public C4733d(Context context, C4724m frameStore, C4701c croppedImageExtractor) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(frameStore, "frameStore");
        Intrinsics.checkParameterIsNotNull(croppedImageExtractor, "croppedImageExtractor");
        this.f6943a = context;
        this.f6944b = frameStore;
        this.f6945c = croppedImageExtractor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ C4733d(Context context, C4724m c4724m, C4701c c4701c, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            c4701c = new C4701c(null, 1, 0 == true ? 1 : 0);
        }
        this(context, c4724m, c4701c);
    }

    /* JADX INFO: renamed from: a */
    private final List<String> m4848a(int i) {
        DirectBuffer[] directBufferArrM4829c = this.f6944b.m4829c();
        Intrinsics.checkExpressionValueIsNotNull(directBufferArrM4829c, "frameStore.sampledFrameImages");
        ArrayList arrayList = new ArrayList(directBufferArrM4829c.length);
        int length = directBufferArrM4829c.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            DirectBuffer directBuffer = directBufferArrM4829c[i2];
            int i4 = i3 + 1;
            String str = "sample" + i + "-" + i3 + ImageFormat.JPEG.getF6937b();
            Intrinsics.checkExpressionValueIsNotNull(directBuffer, "directBuffer");
            arrayList.add(m4851a(directBuffer, str));
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    private final String m4849b(int i) {
        DirectBuffer directBufferM4826b = this.f6944b.m4826b();
        if (directBufferM4826b != null) {
            return m4851a(directBufferM4826b, TypedValues.AttributesType.S_FRAME + i + ImageFormat.JPEG.getF6937b());
        }
        throw new IllegalArgumentException("Main image has not been captured");
    }

    /* JADX INFO: renamed from: c */
    private final String m4850c(int i, Recognizer.Result result) {
        DirectBuffer directBufferM4744a = this.f6945c.m4744a(result);
        if (directBufferM4744a != null) {
            return m4851a(directBufferM4744a, OptionalModuleUtils.FACE + i + ImageFormat.JPEG.getF6937b());
        }
        return null;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.transformer.InterfaceC4730a
    /* JADX INFO: renamed from: a */
    public String mo4841a(int i, Recognizer.Result result) {
        DirectBuffer directBufferM4743a = this.f6945c.m4743a(i, result);
        if (directBufferM4743a != null) {
            return m4851a(directBufferM4743a, "document" + i + ImageFormat.JPEG.getF6937b());
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final String m4851a(DirectBuffer saveToJpegFile, String filePath) {
        Intrinsics.checkParameterIsNotNull(saveToJpegFile, "$this$saveToJpegFile");
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        File file = new File(this.f6943a.getDir(IdDocumentCaptureConstantsKt.TEMP_FILES_PATH, 0), filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            Bitmap bitmapFast = BufferHelper.toBitmapFast(saveToJpegFile, this.f6943a);
            if (bitmapFast != null) {
                bitmapFast.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            }
            fileOutputStream.flush();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
            return absolutePath;
        } finally {
        }
    }

    @Override // com.yoti.mobile.android.documentscan.domain.transformer.InterfaceC4730a
    /* JADX INFO: renamed from: b */
    public C4732c mo4842b(int i, Recognizer.Result result) {
        return new C4732c(m4849b(i), m4848a(i), mo4841a(i, result), m4850c(i, result), ImageFormat.JPEG);
    }
}
