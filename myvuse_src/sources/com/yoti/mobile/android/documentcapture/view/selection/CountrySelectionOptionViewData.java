package com.yoti.mobile.android.documentcapture.view.selection;

import android.content.Context;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&\u0082\u0001\u0002\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;", "Landroid/os/Parcelable;", "()V", "getLabel", "", "context", "Landroid/content/Context;", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountryViewData;", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountryNotListedViewData;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class CountrySelectionOptionViewData implements Parcelable {
    private CountrySelectionOptionViewData() {
    }

    public /* synthetic */ CountrySelectionOptionViewData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getLabel(Context context);
}
