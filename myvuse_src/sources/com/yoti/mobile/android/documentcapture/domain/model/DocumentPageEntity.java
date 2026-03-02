package com.yoti.mobile.android.documentcapture.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentPageEntity;", "", "imagePath", "", "framePaths", "", "imageInfo", "Lcom/yoti/mobile/android/documentcapture/domain/model/PageInfoEntity;", "(Ljava/lang/String;Ljava/util/List;Lcom/yoti/mobile/android/documentcapture/domain/model/PageInfoEntity;)V", "getFramePaths", "()Ljava/util/List;", "getImageInfo", "()Lcom/yoti/mobile/android/documentcapture/domain/model/PageInfoEntity;", "getImagePath", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentPageEntity {
    private final List<String> framePaths;
    private final PageInfoEntity imageInfo;
    private final String imagePath;

    public DocumentPageEntity(String imagePath, List<String> framePaths, PageInfoEntity pageInfoEntity) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(framePaths, "framePaths");
        this.imagePath = imagePath;
        this.framePaths = framePaths;
        this.imageInfo = pageInfoEntity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocumentPageEntity copy$default(DocumentPageEntity documentPageEntity, String str, List list, PageInfoEntity pageInfoEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = documentPageEntity.imagePath;
        }
        if ((i & 2) != 0) {
            list = documentPageEntity.framePaths;
        }
        if ((i & 4) != 0) {
            pageInfoEntity = documentPageEntity.imageInfo;
        }
        return documentPageEntity.copy(str, list, pageInfoEntity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImagePath() {
        return this.imagePath;
    }

    public final List<String> component2() {
        return this.framePaths;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PageInfoEntity getImageInfo() {
        return this.imageInfo;
    }

    public final DocumentPageEntity copy(String imagePath, List<String> framePaths, PageInfoEntity imageInfo) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(framePaths, "framePaths");
        return new DocumentPageEntity(imagePath, framePaths, imageInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentPageEntity)) {
            return false;
        }
        DocumentPageEntity documentPageEntity = (DocumentPageEntity) other;
        return Intrinsics.areEqual(this.imagePath, documentPageEntity.imagePath) && Intrinsics.areEqual(this.framePaths, documentPageEntity.framePaths) && Intrinsics.areEqual(this.imageInfo, documentPageEntity.imageInfo);
    }

    public final List<String> getFramePaths() {
        return this.framePaths;
    }

    public final PageInfoEntity getImageInfo() {
        return this.imageInfo;
    }

    public final String getImagePath() {
        return this.imagePath;
    }

    public int hashCode() {
        int iHashCode = ((this.imagePath.hashCode() * 31) + this.framePaths.hashCode()) * 31;
        PageInfoEntity pageInfoEntity = this.imageInfo;
        return iHashCode + (pageInfoEntity == null ? 0 : pageInfoEntity.hashCode());
    }

    public String toString() {
        return "DocumentPageEntity(imagePath=" + this.imagePath + ", framePaths=" + this.framePaths + ", imageInfo=" + this.imageInfo + ')';
    }

    public /* synthetic */ DocumentPageEntity(String str, List list, PageInfoEntity pageInfoEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i & 4) != 0 ? null : pageInfoEntity);
    }
}
