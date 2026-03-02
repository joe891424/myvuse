package com.yoti.mobile.android.documentscan.ui;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.documentscan.domain.C4715d;
import com.yoti.mobile.android.documentscan.domain.C4721j;
import com.yoti.mobile.android.documentscan.domain.C4722k;
import com.yoti.mobile.android.documentscan.domain.C4724m;
import com.yoti.mobile.android.documentscan.domain.C4727p;
import com.yoti.mobile.android.documentscan.domain.C4728q;
import com.yoti.mobile.android.documentscan.domain.transformer.ImageFormat;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedConfig;
import com.yoti.mobile.android.documentscan.ui.helpers.scan.C4803d;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.E */
/* JADX INFO: loaded from: classes5.dex */
public final class C4761E implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: a */
    private final Context f6983a;

    /* JADX INFO: renamed from: b */
    private final DocumentScanDetailedConfig f6984b;

    /* JADX INFO: renamed from: c */
    private final C4724m f6985c;

    /* JADX INFO: renamed from: d */
    private final C4803d f6986d;

    /* JADX INFO: renamed from: e */
    private final ImageFormat f6987e;

    public C4761E(Context context, DocumentScanDetailedConfig documentConfiguration, C4724m frameStore, C4803d cameraCropHelper, ImageFormat imageFormat) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(documentConfiguration, "documentConfiguration");
        Intrinsics.checkParameterIsNotNull(frameStore, "frameStore");
        Intrinsics.checkParameterIsNotNull(cameraCropHelper, "cameraCropHelper");
        Intrinsics.checkParameterIsNotNull(imageFormat, "imageFormat");
        this.f6983a = context;
        this.f6984b = documentConfiguration;
        this.f6985c = frameStore;
        this.f6986d = cameraCropHelper;
        this.f6987e = imageFormat;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) throws NoSuchMethodException {
        Intrinsics.checkParameterIsNotNull(modelClass, "modelClass");
        Constructor<T> constructor = modelClass.getConstructor(C4715d.class, C4769c.class, C4722k.class, C4727p.class);
        C4715d c4715d = new C4715d(null, 1, null);
        C4769c c4769c = new C4769c(this.f6984b);
        C4722k c4722k = new C4722k(this.f6985c, new C4728q());
        Context context = this.f6983a;
        return constructor.newInstance(c4715d, c4769c, c4722k, new C4727p(context, this.f6987e.getScanResultToImageTransformer$documentscan_release(context, this.f6985c), this.f6986d, this.f6985c, new C4721j()));
    }
}
