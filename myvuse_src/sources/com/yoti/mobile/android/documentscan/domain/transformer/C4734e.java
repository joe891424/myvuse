package com.yoti.mobile.android.documentscan.domain.transformer;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.microblink.entities.recognizers.Recognizer;
import com.yoti.mobile.android.commons.image.DirectBuffer;
import com.yoti.mobile.android.commons.util.FileManager;
import com.yoti.mobile.android.documentcapture.p055id.IdDocumentCaptureConstantsKt;
import com.yoti.mobile.android.documentscan.domain.C4724m;
import com.yoti.mobile.android.documentscan.domain.p059a.p061b.C4701c;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.transformer.e */
/* JADX INFO: loaded from: classes5.dex */
public final class C4734e implements InterfaceC4730a {

    /* JADX INFO: renamed from: a */
    private final Context f6946a;

    /* JADX INFO: renamed from: b */
    private final C4724m f6947b;

    /* JADX INFO: renamed from: c */
    private final C4701c f6948c;

    public C4734e(Context context, C4724m frameStore, C4701c croppedImageExtractor) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(frameStore, "frameStore");
        Intrinsics.checkParameterIsNotNull(croppedImageExtractor, "croppedImageExtractor");
        this.f6946a = context;
        this.f6947b = frameStore;
        this.f6948c = croppedImageExtractor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ C4734e(Context context, C4724m c4724m, C4701c c4701c, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            c4701c = new C4701c(null, 1, 0 == true ? 1 : 0);
        }
        this(context, c4724m, c4701c);
    }

    /* JADX INFO: renamed from: a */
    private final String m4852a(String str, DirectBuffer directBuffer) throws Throwable {
        String strSaveSerializedToFile = FileManager.saveSerializedToFile(this.f6946a, directBuffer, IdDocumentCaptureConstantsKt.TEMP_FILES_PATH, str);
        Intrinsics.checkExpressionValueIsNotNull(strSaveSerializedToFile, "FileManager.saveSerializ…       filename\n        )");
        return strSaveSerializedToFile;
    }

    /* JADX INFO: renamed from: a */
    private final List<String> m4853a(int i) {
        DirectBuffer[] directBufferArrM4829c = this.f6947b.m4829c();
        Intrinsics.checkExpressionValueIsNotNull(directBufferArrM4829c, "frameStore.sampledFrameImages");
        return m4854a(i, directBufferArrM4829c);
    }

    /* JADX INFO: renamed from: a */
    private final List<String> m4854a(int i, DirectBuffer[] directBufferArr) {
        ArrayList arrayList = new ArrayList();
        int length = directBufferArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add(m4852a("sample" + i + "-" + i2 + ImageFormat.YUV.getF6937b(), directBufferArr[i2]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    private final String m4855b(int i) {
        DirectBuffer directBufferM4826b = this.f6947b.m4826b();
        if (directBufferM4826b == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(directBufferM4826b, "frameStore.lastValidFrame ?: return null");
        return m4852a(TypedValues.AttributesType.S_FRAME + i + ImageFormat.YUV.getF6937b(), directBufferM4826b);
    }

    /* JADX INFO: renamed from: c */
    private final String m4856c(int i, Recognizer.Result result) {
        DirectBuffer directBufferM4744a = this.f6948c.m4744a(result);
        if (directBufferM4744a != null) {
            return m4852a(OptionalModuleUtils.FACE + i + ImageFormat.YUV.getF6937b(), directBufferM4744a);
        }
        return null;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.transformer.InterfaceC4730a
    /* JADX INFO: renamed from: a */
    public String mo4841a(int i, Recognizer.Result result) {
        DirectBuffer directBufferM4743a = this.f6948c.m4743a(i, result);
        if (directBufferM4743a != null) {
            return m4852a("document" + i + ImageFormat.YUV.getF6937b(), directBufferM4743a);
        }
        return null;
    }

    @Override // com.yoti.mobile.android.documentscan.domain.transformer.InterfaceC4730a
    /* JADX INFO: renamed from: b */
    public C4732c mo4842b(int i, Recognizer.Result result) {
        return new C4732c(m4855b(i), m4853a(i), mo4841a(i, result), m4856c(i, result), ImageFormat.YUV);
    }
}
