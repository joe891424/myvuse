package com.yoti.mobile.android.documentcapture.sup;

import androidx.fragment.app.Fragment;
import com.yoti.mobile.android.documentcapture.sup.p057di.SupDocumentCaptureSession;
import com.yoti.mobile.android.yotisdkcore.core.view.FeatureLauncher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/SupDocumentCaptureLauncher;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/FeatureLauncher;", "()V", "start", "", "fragment", "Landroidx/fragment/app/Fragment;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentCaptureLauncher extends FeatureLauncher {
    @Override // com.yoti.mobile.android.yotisdkcore.core.view.FeatureLauncher
    public void start(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        SupDocumentCaptureSession.INSTANCE.getInstance().start(getFeatureConfiguration(), fragment, 1003);
    }
}
