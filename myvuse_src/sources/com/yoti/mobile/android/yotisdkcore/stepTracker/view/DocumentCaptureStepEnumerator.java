package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0014\u0010\f\u001a\u00020\r*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0014\u0010\u000e\u001a\u00020\r*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J!\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\t¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/DocumentCaptureStepEnumerator;", "", "()V", "getStepNumber", "", "steps", "", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "step", "(Ljava/util/List;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;)Ljava/lang/Integer;", "enumerables", "item", "isCountryEqual", "", "isEnumerable", "number", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentCaptureStepEnumerator {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.a$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f7787a;

        static {
            int[] iArr = new int[DocumentResourceConfigEntity.DocumentCaptureTypeEntity.values().length];
            iArr[DocumentResourceConfigEntity.DocumentCaptureTypeEntity.ID_DOCUMENT.ordinal()] = 1;
            iArr[DocumentResourceConfigEntity.DocumentCaptureTypeEntity.SUPPLEMENTARY_DOCUMENT.ordinal()] = 2;
            f7787a = iArr;
        }
    }

    @Inject
    public DocumentCaptureStepEnumerator() {
    }

    /* JADX INFO: renamed from: a */
    private final List<DocumentResourceConfigEntity> m5222a(List<DocumentResourceConfigEntity> list, DocumentResourceConfigEntity documentResourceConfigEntity) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (m5224b((DocumentResourceConfigEntity) obj, documentResourceConfigEntity)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private final boolean m5223a(DocumentResourceConfigEntity documentResourceConfigEntity, DocumentResourceConfigEntity documentResourceConfigEntity2) {
        int i = a.f7787a[documentResourceConfigEntity.getType().ordinal()];
        if (i == 1) {
            DocumentResourceConfigEntity.CountryEntity country = documentResourceConfigEntity.getCountry();
            String iso3Code = country != null ? country.getIso3Code() : null;
            DocumentResourceConfigEntity.CountryEntity country2 = documentResourceConfigEntity2.getCountry();
            if (Intrinsics.areEqual(iso3Code, country2 != null ? country2.getIso3Code() : null)) {
                return true;
            }
            if (documentResourceConfigEntity.getCountry() != null && documentResourceConfigEntity2.getCountry() == null) {
                return true;
            }
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            if (Intrinsics.areEqual(documentResourceConfigEntity.getDocument(), documentResourceConfigEntity2.getDocument())) {
                return true;
            }
            DocumentResourceConfigEntity.DocumentTypeEntity documentType = documentResourceConfigEntity.getDocument().getDocumentType();
            DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity = DocumentResourceConfigEntity.DocumentTypeEntity.UNKNOWN;
            if (documentType != documentTypeEntity && documentResourceConfigEntity2.getDocument().getDocumentType() == documentTypeEntity) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    private final boolean m5224b(DocumentResourceConfigEntity documentResourceConfigEntity, DocumentResourceConfigEntity documentResourceConfigEntity2) {
        return documentResourceConfigEntity.getType() == documentResourceConfigEntity2.getType() && documentResourceConfigEntity.getObjective() == documentResourceConfigEntity2.getObjective() && m5223a(documentResourceConfigEntity, documentResourceConfigEntity2);
    }

    /* JADX INFO: renamed from: c */
    private final Integer m5225c(List<DocumentResourceConfigEntity> list, DocumentResourceConfigEntity documentResourceConfigEntity) {
        List<DocumentResourceConfigEntity> listM5222a = m5222a(list, documentResourceConfigEntity);
        if (listM5222a.size() == 1) {
            return null;
        }
        return Integer.valueOf(listM5222a.indexOf(documentResourceConfigEntity));
    }

    /* JADX INFO: renamed from: b */
    public final Integer m5226b(List<DocumentResourceConfigEntity> steps, DocumentResourceConfigEntity step) {
        Intrinsics.checkNotNullParameter(steps, "steps");
        Intrinsics.checkNotNullParameter(step, "step");
        return m5225c(steps, step);
    }
}
