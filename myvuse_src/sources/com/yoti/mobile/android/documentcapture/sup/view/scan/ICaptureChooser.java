package com.yoti.mobile.android.documentcapture.sup.view.scan;

import android.app.Activity;
import android.net.Uri;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/ICaptureChooser;", "", "showCameraAndFilePickerChooser", "Landroid/net/Uri;", "activity", "Landroid/app/Activity;", "showFilePicker", "", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ICaptureChooser {
    Uri showCameraAndFilePickerChooser(Activity activity);

    void showFilePicker(Activity activity);
}
