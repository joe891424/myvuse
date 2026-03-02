package com.yoti.mobile.android.documentcapture.data.remote.model;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/data/remote/model/DocumentPage;", "", "image", "Ljava/io/File;", "frames", "", "imageInfo", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/PageInfo;", "(Ljava/io/File;Ljava/util/List;Lcom/yoti/mobile/android/documentcapture/data/remote/model/PageInfo;)V", "getFrames", "()Ljava/util/List;", "getImage", "()Ljava/io/File;", "getImageInfo", "()Lcom/yoti/mobile/android/documentcapture/data/remote/model/PageInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentPage {
    private final List<File> frames;
    private final File image;
    private final PageInfo imageInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public DocumentPage(File image, List<? extends File> frames, PageInfo pageInfo) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(frames, "frames");
        this.image = image;
        this.frames = frames;
        this.imageInfo = pageInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocumentPage copy$default(DocumentPage documentPage, File file, List list, PageInfo pageInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            file = documentPage.image;
        }
        if ((i & 2) != 0) {
            list = documentPage.frames;
        }
        if ((i & 4) != 0) {
            pageInfo = documentPage.imageInfo;
        }
        return documentPage.copy(file, list, pageInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final File getImage() {
        return this.image;
    }

    public final List<File> component2() {
        return this.frames;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PageInfo getImageInfo() {
        return this.imageInfo;
    }

    public final DocumentPage copy(File image, List<? extends File> frames, PageInfo imageInfo) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(frames, "frames");
        return new DocumentPage(image, frames, imageInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentPage)) {
            return false;
        }
        DocumentPage documentPage = (DocumentPage) other;
        return Intrinsics.areEqual(this.image, documentPage.image) && Intrinsics.areEqual(this.frames, documentPage.frames) && Intrinsics.areEqual(this.imageInfo, documentPage.imageInfo);
    }

    public final List<File> getFrames() {
        return this.frames;
    }

    public final File getImage() {
        return this.image;
    }

    public final PageInfo getImageInfo() {
        return this.imageInfo;
    }

    public int hashCode() {
        int iHashCode = ((this.image.hashCode() * 31) + this.frames.hashCode()) * 31;
        PageInfo pageInfo = this.imageInfo;
        return iHashCode + (pageInfo == null ? 0 : pageInfo.hashCode());
    }

    public String toString() {
        return "DocumentPage(image=" + this.image + ", frames=" + this.frames + ", imageInfo=" + this.imageInfo + ')';
    }
}
