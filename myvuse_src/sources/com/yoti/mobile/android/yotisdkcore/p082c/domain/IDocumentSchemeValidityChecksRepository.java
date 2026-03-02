package com.yoti.mobile.android.yotisdkcore.p082c.domain;

import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.c.a.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\tJ%\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/IDocumentSchemeValidityChecksRepository;", "", "getChecks", "Lcom/yoti/mobile/android/commons/functional/Either;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/model/RequirementsEntity;", "documentSchemeAssessment", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/IDocumentSchemeValidityChecksRepository$DocumentSchemeAssessmentEntity;", "(Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/IDocumentSchemeValidityChecksRepository$DocumentSchemeAssessmentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DocumentSchemeAssessmentEntity", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IDocumentSchemeValidityChecksRepository {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.c.a.a$a */
    @Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/IDocumentSchemeValidityChecksRepository$DocumentSchemeAssessmentEntity;", "", "requirementId", "", "scheme", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentSchemeEntity;", "iso3Code", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "state", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentStateEntity;", "(Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentSchemeEntity;Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentStateEntity;)V", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "getIso3Code", "()Ljava/lang/String;", "getRequirementId", "getScheme", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentSchemeEntity;", "getState", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentStateEntity;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class a {

        /* JADX INFO: renamed from: a */
        private final String f7594a;

        /* JADX INFO: renamed from: b */
        private final DocumentResourceConfigEntity.AssessmentSchemeEntity f7595b;

        /* JADX INFO: renamed from: c */
        private final String f7596c;

        /* JADX INFO: renamed from: d */
        private final DocumentResourceConfigEntity.DocumentTypeEntity f7597d;

        /* JADX INFO: renamed from: e */
        private final DocumentResourceConfigEntity.AssessmentStateEntity f7598e;

        /* JADX INFO: renamed from: a, reason: from getter */
        public final DocumentResourceConfigEntity.DocumentTypeEntity getF7597d() {
            return this.f7597d;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getF7596c() {
            return this.f7596c;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final DocumentResourceConfigEntity.AssessmentSchemeEntity getF7595b() {
            return this.f7595b;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return Intrinsics.areEqual(this.f7594a, aVar.f7594a) && this.f7595b == aVar.f7595b && Intrinsics.areEqual(this.f7596c, aVar.f7596c) && this.f7597d == aVar.f7597d && this.f7598e == aVar.f7598e;
        }

        public int hashCode() {
            return (((((((this.f7594a.hashCode() * 31) + this.f7595b.hashCode()) * 31) + this.f7596c.hashCode()) * 31) + this.f7597d.hashCode()) * 31) + this.f7598e.hashCode();
        }

        public String toString() {
            return "DocumentSchemeAssessmentEntity(requirementId=" + this.f7594a + ", scheme=" + this.f7595b + ", iso3Code=" + this.f7596c + ", documentType=" + this.f7597d + ", state=" + this.f7598e + ')';
        }
    }
}
