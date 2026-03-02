package com.yoti.mobile.android.documentcapture.sup.view.review;

import com.yoti.mobile.android.remote.RemoteDefsKt;
import javax.inject.Inject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/PageNumberIndicatorFormatter;", "", "()V", "format", "", RemoteDefsKt.PATH_PAGE_INDEX_KEY, "", "pageCount", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class PageNumberIndicatorFormatter {
    @Inject
    public PageNumberIndicatorFormatter() {
    }

    public final String format(int pageIndex, int pageCount) {
        Integer numValueOf = Integer.valueOf(pageCount);
        if (numValueOf.intValue() <= 1) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            return null;
        }
        return new StringBuilder().append(pageIndex + 1).append('/').append(numValueOf.intValue()).toString();
    }
}
