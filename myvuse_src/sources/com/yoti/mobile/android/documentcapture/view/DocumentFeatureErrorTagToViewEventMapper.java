package com.yoti.mobile.android.documentcapture.view;

import com.yoti.mobile.android.documentcapture.view.DocumentViewEvent;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0007B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper$MapperParams;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "()V", "map", "from", "MapperParams", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentFeatureErrorTagToViewEventMapper implements Mapper<MapperParams, DocumentViewEvent> {

    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper$MapperParams;", "", "errorTag", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTag;", "isPositiveAction", "", "isCameraPermissionNeeded", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTag;ZZ)V", "getErrorTag", "()Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTag;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class MapperParams {
        private final DocumentFeatureErrorTag errorTag;
        private final boolean isCameraPermissionNeeded;
        private final boolean isPositiveAction;

        public MapperParams(DocumentFeatureErrorTag errorTag, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(errorTag, "errorTag");
            this.errorTag = errorTag;
            this.isPositiveAction = z;
            this.isCameraPermissionNeeded = z2;
        }

        public static /* synthetic */ MapperParams copy$default(MapperParams mapperParams, DocumentFeatureErrorTag documentFeatureErrorTag, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                documentFeatureErrorTag = mapperParams.errorTag;
            }
            if ((i & 2) != 0) {
                z = mapperParams.isPositiveAction;
            }
            if ((i & 4) != 0) {
                z2 = mapperParams.isCameraPermissionNeeded;
            }
            return mapperParams.copy(documentFeatureErrorTag, z, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentFeatureErrorTag getErrorTag() {
            return this.errorTag;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsPositiveAction() {
            return this.isPositiveAction;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsCameraPermissionNeeded() {
            return this.isCameraPermissionNeeded;
        }

        public final MapperParams copy(DocumentFeatureErrorTag errorTag, boolean isPositiveAction, boolean isCameraPermissionNeeded) {
            Intrinsics.checkNotNullParameter(errorTag, "errorTag");
            return new MapperParams(errorTag, isPositiveAction, isCameraPermissionNeeded);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MapperParams)) {
                return false;
            }
            MapperParams mapperParams = (MapperParams) other;
            return this.errorTag == mapperParams.errorTag && this.isPositiveAction == mapperParams.isPositiveAction && this.isCameraPermissionNeeded == mapperParams.isCameraPermissionNeeded;
        }

        public final DocumentFeatureErrorTag getErrorTag() {
            return this.errorTag;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int iHashCode = this.errorTag.hashCode() * 31;
            boolean z = this.isPositiveAction;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            int i = (iHashCode + r1) * 31;
            boolean z2 = this.isCameraPermissionNeeded;
            return i + (z2 ? 1 : z2);
        }

        public final boolean isCameraPermissionNeeded() {
            return this.isCameraPermissionNeeded;
        }

        public final boolean isPositiveAction() {
            return this.isPositiveAction;
        }

        public String toString() {
            return "MapperParams(errorTag=" + this.errorTag + ", isPositiveAction=" + this.isPositiveAction + ", isCameraPermissionNeeded=" + this.isCameraPermissionNeeded + ')';
        }
    }

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DocumentFeatureErrorTag.values().length];
            iArr[DocumentFeatureErrorTag.TAG_DOCUMENT_RESOURCE_CONFIGURATION_ERROR.ordinal()] = 1;
            iArr[DocumentFeatureErrorTag.TAG_SCAN_CONFIGURATION_ERROR.ordinal()] = 2;
            iArr[DocumentFeatureErrorTag.TAG_DOES_NOT_HAVE_DOCUMENT_ERROR.ordinal()] = 3;
            iArr[DocumentFeatureErrorTag.TAG_COUNTRY_NOT_LISTED_ERROR.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public DocumentFeatureErrorTagToViewEventMapper() {
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public DocumentViewEvent map(MapperParams from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int i = WhenMappings.$EnumSwitchMapping$0[from.getErrorTag().ordinal()];
        if (i == 1) {
            return from.isPositiveAction() ? DocumentViewEvent.RetryGetDocumentResourceConfig.INSTANCE : DocumentViewEvent.CancelGetDocumentResourceConfig.INSTANCE;
        }
        if (i == 2) {
            return from.isPositiveAction() ? new DocumentViewEvent.RetryGetScanConfiguration(from.isCameraPermissionNeeded()) : DocumentViewEvent.CancelGetScanConfiguration.INSTANCE;
        }
        if (i == 3) {
            return from.isPositiveAction() ? DocumentViewEvent.ConfirmDoNotHaveDocument.INSTANCE : DocumentViewEvent.CancelDoNotHaveDocument.INSTANCE;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException("No view events (and no dialog) exist for country not listed! Implement as needed!");
    }
}
