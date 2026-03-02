package com.yoti.mobile.android.documentscan.domain;

import android.content.Context;
import android.graphics.RectF;
import com.microblink.entities.recognizers.Recognizer;
import com.yoti.mobile.android.commons.image.DirectBuffer;
import com.yoti.mobile.android.documentscan.domain.transformer.C4732c;
import com.yoti.mobile.android.documentscan.domain.transformer.InterfaceC4730a;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.model.result.MetaData;
import com.yoti.mobile.android.documentscan.ui.helpers.scan.C4803d;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.p */
/* JADX INFO: loaded from: classes5.dex */
public final class C4727p {

    /* JADX INFO: renamed from: a */
    private final Action f6927a;

    /* JADX INFO: renamed from: b */
    private final Context f6928b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC4730a f6929c;

    /* JADX INFO: renamed from: d */
    private final C4803d f6930d;

    /* JADX INFO: renamed from: e */
    private final C4724m f6931e;

    /* JADX INFO: renamed from: f */
    private final C4721j f6932f;

    public C4727p(Context context, InterfaceC4730a scanResultTransformer, C4803d cameraCropHelper, C4724m frameStore, C4721j extractorFactory) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(scanResultTransformer, "scanResultTransformer");
        Intrinsics.checkParameterIsNotNull(cameraCropHelper, "cameraCropHelper");
        Intrinsics.checkParameterIsNotNull(frameStore, "frameStore");
        Intrinsics.checkParameterIsNotNull(extractorFactory, "extractorFactory");
        this.f6928b = context;
        this.f6929c = scanResultTransformer;
        this.f6930d = cameraCropHelper;
        this.f6931e = frameStore;
        this.f6932f = extractorFactory;
        this.f6927a = new C4726o(this);
    }

    /* JADX INFO: renamed from: a */
    private final RectF m4834a() {
        DirectBuffer directBufferM4826b = this.f6931e.m4826b();
        if (directBufferM4826b != null) {
            return this.f6930d.m5008a(directBufferM4826b.getF6626c(), directBufferM4826b.getF6625b());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final MetaData m4837b(int i, Recognizer.Result result) {
        C4732c c4732cMo4842b = this.f6929c.mo4842b(i, result);
        return new MetaData(c4732cMo4842b.m4847e(), c4732cMo4842b.m4845c(), m4834a(), c4732cMo4842b.m4843a(), c4732cMo4842b.m4844b(), c4732cMo4842b.m4846d());
    }

    /* JADX INFO: renamed from: a */
    public final Single<DocumentCaptureResult> m4838a(int i, Recognizer.Result result) {
        Single<DocumentCaptureResult> singleSubscribeOn = Single.fromCallable(new CallableC4725n(this, result, i)).doOnDispose(this.f6927a).subscribeOn(Schedulers.m5595io());
        Intrinsics.checkExpressionValueIsNotNull(singleSubscribeOn, "Single.fromCallable {\n  …scribeOn(Schedulers.io())");
        return singleSubscribeOn;
    }

    /* JADX INFO: renamed from: a */
    public final String m4839a(Recognizer.Result result) {
        return this.f6929c.mo4841a(0, result);
    }
}
