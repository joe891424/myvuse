package com.yoti.mobile.android.documentcapture.sup.view.review;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentCaptureReviewViewData;", "", "bitmap", "Landroid/graphics/Bitmap;", "page", "", "pages", "(Landroid/graphics/Bitmap;II)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getPage", "()I", "getPages", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentCaptureReviewViewData {
    private final Bitmap bitmap;
    private final int page;
    private final int pages;

    public DocumentCaptureReviewViewData(Bitmap bitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.bitmap = bitmap;
        this.page = i;
        this.pages = i2;
    }

    public static /* synthetic */ DocumentCaptureReviewViewData copy$default(DocumentCaptureReviewViewData documentCaptureReviewViewData, Bitmap bitmap, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bitmap = documentCaptureReviewViewData.bitmap;
        }
        if ((i3 & 2) != 0) {
            i = documentCaptureReviewViewData.page;
        }
        if ((i3 & 4) != 0) {
            i2 = documentCaptureReviewViewData.pages;
        }
        return documentCaptureReviewViewData.copy(bitmap, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPages() {
        return this.pages;
    }

    public final DocumentCaptureReviewViewData copy(Bitmap bitmap, int page, int pages) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return new DocumentCaptureReviewViewData(bitmap, page, pages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentCaptureReviewViewData)) {
            return false;
        }
        DocumentCaptureReviewViewData documentCaptureReviewViewData = (DocumentCaptureReviewViewData) other;
        return Intrinsics.areEqual(this.bitmap, documentCaptureReviewViewData.bitmap) && this.page == documentCaptureReviewViewData.page && this.pages == documentCaptureReviewViewData.pages;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPages() {
        return this.pages;
    }

    public int hashCode() {
        return (((this.bitmap.hashCode() * 31) + Integer.hashCode(this.page)) * 31) + Integer.hashCode(this.pages);
    }

    public String toString() {
        return "DocumentCaptureReviewViewData(bitmap=" + this.bitmap + ", page=" + this.page + ", pages=" + this.pages + ')';
    }
}
