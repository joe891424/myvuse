package com.yoti.mobile.android.documentcapture.view;

import com.yoti.mobile.android.documentcapture.view.DocumentFeatureFailureType;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\bH\u0002¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentFailureTypeToErrorTagMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTag;", "()V", "map", "from", "mapDocumentFeatureFailureType", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentFailureTypeToErrorTagMapper implements Mapper<YdsFailureType, DocumentFeatureErrorTag> {
    @Inject
    public DocumentFailureTypeToErrorTagMapper() {
    }

    private final DocumentFeatureErrorTag mapDocumentFeatureFailureType(DocumentFeatureFailureType from) {
        if (from instanceof DocumentFeatureFailureType.DocumentResourceConfigFailureType) {
            return DocumentFeatureErrorTag.TAG_DOCUMENT_RESOURCE_CONFIGURATION_ERROR;
        }
        if (from instanceof DocumentFeatureFailureType.DocumentScanConfigFailureType) {
            return DocumentFeatureErrorTag.TAG_SCAN_CONFIGURATION_ERROR;
        }
        if (from instanceof DocumentFeatureFailureType.DocumentNotOwnedFailureType) {
            return DocumentFeatureErrorTag.TAG_DOES_NOT_HAVE_DOCUMENT_ERROR;
        }
        if (from instanceof DocumentFeatureFailureType.DocumentCountryNotListedFailureType) {
            return DocumentFeatureErrorTag.TAG_COUNTRY_NOT_LISTED_ERROR;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public DocumentFeatureErrorTag map(YdsFailureType from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (from instanceof DocumentFeatureFailureType) {
            return mapDocumentFeatureFailureType((DocumentFeatureFailureType) from);
        }
        throw new IllegalArgumentException("Cannot map " + from);
    }
}
