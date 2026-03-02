package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.documentcapture.data.PageInfoEntityToDataMapper;
import com.yoti.mobile.android.documentcapture.data.remote.model.DocumentPage;
import com.yoti.mobile.android.documentcapture.data.remote.model.DocumentResourceInfo;
import com.yoti.mobile.android.documentcapture.domain.model.DocumentPageEntity;
import com.yoti.mobile.android.documentcapture.domain.model.PageInfoEntity;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.IdDocument;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.OcrResult;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.OcrResultEntity;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/DocumentEntityToDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentEntity;", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/IdDocument;", "pageInfoEntityToDataMapper", "Lcom/yoti/mobile/android/documentcapture/data/PageInfoEntityToDataMapper;", "ocrResultEntityToDataMapper", "Lcom/yoti/mobile/android/documentcapture/id/data/OcrResultEntityToDataMapper;", "documentTypeMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeEntityToDataMapper;", "mrtdEntityToDataMapper", "Lcom/yoti/mobile/android/documentcapture/id/data/NfcEntityToDataMapper;", "(Lcom/yoti/mobile/android/documentcapture/data/PageInfoEntityToDataMapper;Lcom/yoti/mobile/android/documentcapture/id/data/OcrResultEntityToDataMapper;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeEntityToDataMapper;Lcom/yoti/mobile/android/documentcapture/id/data/NfcEntityToDataMapper;)V", "map", "from", "mapPages", "", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/DocumentPage;", "pages", "Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentPageEntity;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentEntityToDataMapper implements Mapper<IdDocumentEntity, IdDocument> {
    private final DocumentTypeEntityToDataMapper documentTypeMapper;
    private final NfcEntityToDataMapper mrtdEntityToDataMapper;
    private final OcrResultEntityToDataMapper ocrResultEntityToDataMapper;
    private final PageInfoEntityToDataMapper pageInfoEntityToDataMapper;

    @Inject
    public DocumentEntityToDataMapper(PageInfoEntityToDataMapper pageInfoEntityToDataMapper, OcrResultEntityToDataMapper ocrResultEntityToDataMapper, DocumentTypeEntityToDataMapper documentTypeMapper, NfcEntityToDataMapper mrtdEntityToDataMapper) {
        Intrinsics.checkNotNullParameter(pageInfoEntityToDataMapper, "pageInfoEntityToDataMapper");
        Intrinsics.checkNotNullParameter(ocrResultEntityToDataMapper, "ocrResultEntityToDataMapper");
        Intrinsics.checkNotNullParameter(documentTypeMapper, "documentTypeMapper");
        Intrinsics.checkNotNullParameter(mrtdEntityToDataMapper, "mrtdEntityToDataMapper");
        this.pageInfoEntityToDataMapper = pageInfoEntityToDataMapper;
        this.ocrResultEntityToDataMapper = ocrResultEntityToDataMapper;
        this.documentTypeMapper = documentTypeMapper;
        this.mrtdEntityToDataMapper = mrtdEntityToDataMapper;
    }

    private final List<DocumentPage> mapPages(List<DocumentPageEntity> pages) {
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pages, 10));
        for (DocumentPageEntity documentPageEntity : pages) {
            File file = new File(documentPageEntity.getImagePath());
            List<String> framePaths = documentPageEntity.getFramePaths();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(framePaths, 10));
            Iterator<T> it2 = framePaths.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new File((String) it2.next()));
            }
            PageInfoEntity imageInfo = documentPageEntity.getImageInfo();
            arrayList.add(new DocumentPage(file, arrayList2, imageInfo != null ? this.pageInfoEntityToDataMapper.map(imageInfo) : null));
        }
        return arrayList;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public IdDocument map(IdDocumentEntity from) {
        Intrinsics.checkNotNullParameter(from, "from");
        DocumentResourceInfo documentResourceInfo = new DocumentResourceInfo(from.getResourceInfo().getId(), this.documentTypeMapper.map(from.getResourceInfo().getDocumentType()), from.getResourceInfo().getCountryIso3Code());
        List<DocumentPage> listMapPages = mapPages(from.getPages());
        OcrResultEntity ocrData = from.getOcrData();
        OcrResult map = ocrData != null ? this.ocrResultEntityToDataMapper.map(ocrData) : null;
        Map<Integer, byte[]> chipData = from.getChipData();
        return new IdDocument(documentResourceInfo, listMapPages, map, chipData != null ? this.mrtdEntityToDataMapper.map2(chipData) : null);
    }
}
