package com.yoti.mobile.android.mrtd.p073di;

import com.yoti.mobile.android.mrtd.view.MrtdCaptureActivity;
import com.yoti.mobile.android.mrtd.view.MrtdErrorFragment;
import com.yoti.mobile.android.mrtd.view.MrtdGuidelinesFragment;
import com.yoti.mobile.android.mrtd.view.MrtdReadFragment;
import com.yoti.mobile.android.mrtd.view.MrtdScanFragment;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotisdkcore.feature.FeatureComponent;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Component(modules = {MrtdCoreModule.class, MrtdCaptureModule.class, ViewModelModule.class, CommonModule.class})
@Singleton
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\nH&¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/di/MrtdCaptureComponent;", "Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureComponent;", "inject", "", "activity", "Lcom/yoti/mobile/android/mrtd/view/MrtdCaptureActivity;", "fragment", "Lcom/yoti/mobile/android/mrtd/view/MrtdErrorFragment;", "Lcom/yoti/mobile/android/mrtd/view/MrtdGuidelinesFragment;", "Lcom/yoti/mobile/android/mrtd/view/MrtdReadFragment;", "Lcom/yoti/mobile/android/mrtd/view/MrtdScanFragment;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface MrtdCaptureComponent extends FeatureComponent {
    void inject(MrtdCaptureActivity activity);

    void inject(MrtdErrorFragment fragment);

    void inject(MrtdGuidelinesFragment fragment);

    void inject(MrtdReadFragment fragment);

    void inject(MrtdScanFragment fragment);
}
