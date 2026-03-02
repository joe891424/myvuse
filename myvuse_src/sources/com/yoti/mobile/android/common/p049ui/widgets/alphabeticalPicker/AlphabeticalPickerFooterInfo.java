package com.yoti.mobile.android.common.p049ui.widgets.alphabeticalPicker;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerFooterInfo;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerModel;", "component2", "()Ljava/util/List;", "title", FirebaseAnalytics.Param.ITEMS, "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/yoti/mobile/android/common/ui/widgets/alphabeticalPicker/AlphabeticalPickerFooterInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Ljava/util/List;", "getItems", "a", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final /* data */ class AlphabeticalPickerFooterInfo {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String title;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List<AlphabeticalPickerModel> items;

    /* JADX WARN: Multi-variable type inference failed */
    public AlphabeticalPickerFooterInfo(String title, List<? extends AlphabeticalPickerModel> items) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(items, "items");
        this.title = title;
        this.items = items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlphabeticalPickerFooterInfo copy$default(AlphabeticalPickerFooterInfo alphabeticalPickerFooterInfo, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = alphabeticalPickerFooterInfo.title;
        }
        if ((i & 2) != 0) {
            list = alphabeticalPickerFooterInfo.items;
        }
        return alphabeticalPickerFooterInfo.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final List<AlphabeticalPickerModel> component2() {
        return this.items;
    }

    public final AlphabeticalPickerFooterInfo copy(String title, List<? extends AlphabeticalPickerModel> items) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(items, "items");
        return new AlphabeticalPickerFooterInfo(title, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlphabeticalPickerFooterInfo)) {
            return false;
        }
        AlphabeticalPickerFooterInfo alphabeticalPickerFooterInfo = (AlphabeticalPickerFooterInfo) other;
        return Intrinsics.areEqual(this.title, alphabeticalPickerFooterInfo.title) && Intrinsics.areEqual(this.items, alphabeticalPickerFooterInfo.items);
    }

    public final List<AlphabeticalPickerModel> getItems() {
        return this.items;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<AlphabeticalPickerModel> list = this.items;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "AlphabeticalPickerFooterInfo(title=" + this.title + ", items=" + this.items + ")";
    }
}
