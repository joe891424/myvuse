package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.documentcapture.C4597R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DoNotHaveDocumentsDialogViewData;", "", "textId", "", "positiveButtonId", "negativeButtonId", "(III)V", "getNegativeButtonId", "()I", "getPositiveButtonId", "getTextId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DoNotHaveDocumentsDialogViewData {
    private final int negativeButtonId;
    private final int positiveButtonId;
    private final int textId;

    public DoNotHaveDocumentsDialogViewData(int i, int i2, int i3) {
        this.textId = i;
        this.positiveButtonId = i2;
        this.negativeButtonId = i3;
    }

    public static /* synthetic */ DoNotHaveDocumentsDialogViewData copy$default(DoNotHaveDocumentsDialogViewData doNotHaveDocumentsDialogViewData, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = doNotHaveDocumentsDialogViewData.textId;
        }
        if ((i4 & 2) != 0) {
            i2 = doNotHaveDocumentsDialogViewData.positiveButtonId;
        }
        if ((i4 & 4) != 0) {
            i3 = doNotHaveDocumentsDialogViewData.negativeButtonId;
        }
        return doNotHaveDocumentsDialogViewData.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTextId() {
        return this.textId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPositiveButtonId() {
        return this.positiveButtonId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getNegativeButtonId() {
        return this.negativeButtonId;
    }

    public final DoNotHaveDocumentsDialogViewData copy(int textId, int positiveButtonId, int negativeButtonId) {
        return new DoNotHaveDocumentsDialogViewData(textId, positiveButtonId, negativeButtonId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DoNotHaveDocumentsDialogViewData)) {
            return false;
        }
        DoNotHaveDocumentsDialogViewData doNotHaveDocumentsDialogViewData = (DoNotHaveDocumentsDialogViewData) other;
        return this.textId == doNotHaveDocumentsDialogViewData.textId && this.positiveButtonId == doNotHaveDocumentsDialogViewData.positiveButtonId && this.negativeButtonId == doNotHaveDocumentsDialogViewData.negativeButtonId;
    }

    public final int getNegativeButtonId() {
        return this.negativeButtonId;
    }

    public final int getPositiveButtonId() {
        return this.positiveButtonId;
    }

    public final int getTextId() {
        return this.textId;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.textId) * 31) + Integer.hashCode(this.positiveButtonId)) * 31) + Integer.hashCode(this.negativeButtonId);
    }

    public String toString() {
        return "DoNotHaveDocumentsDialogViewData(textId=" + this.textId + ", positiveButtonId=" + this.positiveButtonId + ", negativeButtonId=" + this.negativeButtonId + ')';
    }

    public /* synthetic */ DoNotHaveDocumentsDialogViewData(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? C4597R.string.ios_android_yds_document_education_dont_own_one : i2, (i4 & 4) != 0 ? C4597R.string.ios_android_yds_common_cancel : i3);
    }
}
