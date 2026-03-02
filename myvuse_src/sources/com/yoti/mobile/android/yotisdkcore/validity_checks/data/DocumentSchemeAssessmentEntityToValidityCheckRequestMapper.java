package com.yoti.mobile.android.yotisdkcore.validity_checks.data;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.core.data.model.AssessmentScheme;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import com.yoti.mobile.android.yotisdkcore.p082c.domain.IDocumentSchemeValidityChecksRepository;
import com.yoti.mobile.android.yotisdkcore.validity_checks.data.IDocumentSchemeValidityChecksDataSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.data.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/DocumentSchemeAssessmentEntityToValidityCheckRequestMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/IDocumentSchemeValidityChecksRepository$DocumentSchemeAssessmentEntity;", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/IDocumentSchemeValidityChecksDataSource$DocumentSchemeValidityCheckRequestData;", "documentTypeEntityToDataMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeEntityToDataMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeEntityToDataMapper;)V", "map", "from", "mapSchemeType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentScheme;", "schemeEntity", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentSchemeEntity;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentSchemeAssessmentEntityToValidityCheckRequestMapper implements Mapper<IDocumentSchemeValidityChecksRepository.a, IDocumentSchemeValidityChecksDataSource.a> {

    /* JADX INFO: renamed from: a */
    private final DocumentTypeEntityToDataMapper f7879a;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.data.a$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f7880a;

        static {
            int[] iArr = new int[DocumentResourceConfigEntity.AssessmentSchemeEntity.values().length];
            iArr[DocumentResourceConfigEntity.AssessmentSchemeEntity.UK_DBS.ordinal()] = 1;
            iArr[DocumentResourceConfigEntity.AssessmentSchemeEntity.UK_GDS.ordinal()] = 2;
            f7880a = iArr;
        }
    }

    @Inject
    public DocumentSchemeAssessmentEntityToValidityCheckRequestMapper(DocumentTypeEntityToDataMapper documentTypeEntityToDataMapper) {
        Intrinsics.checkNotNullParameter(documentTypeEntityToDataMapper, "documentTypeEntityToDataMapper");
        this.f7879a = documentTypeEntityToDataMapper;
    }

    /* JADX INFO: renamed from: a */
    private final AssessmentScheme m5348a(DocumentResourceConfigEntity.AssessmentSchemeEntity assessmentSchemeEntity) {
        int i = a.f7880a[assessmentSchemeEntity.ordinal()];
        return i != 1 ? i != 2 ? AssessmentScheme.UNKNOWN : AssessmentScheme.UK_GDS : AssessmentScheme.UK_DBS;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public IDocumentSchemeValidityChecksDataSource.a map(IDocumentSchemeValidityChecksRepository.a from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return new IDocumentSchemeValidityChecksDataSource.a(m5348a(from.getF7595b()), from.getF7596c(), this.f7879a.map(from.getF7597d()));
    }
}
