package com.yoti.mobile.android.yotisdkcore.validity_checks.data;

import com.yoti.mobile.android.yotisdkcore.core.data.model.AssessmentScheme;
import com.yoti.mobile.android.yotisdkcore.core.data.model.DocumentType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.data.d, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\tJ%\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/IDocumentSchemeValidityChecksDataSource;", "", "getChecks", "Lcom/yoti/mobile/android/commons/functional/Either;", "Lcom/yoti/mobile/android/remote/exception/RemoteError;", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck;", "requestData", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/IDocumentSchemeValidityChecksDataSource$DocumentSchemeValidityCheckRequestData;", "(Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/IDocumentSchemeValidityChecksDataSource$DocumentSchemeValidityCheckRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DocumentSchemeValidityCheckRequestData", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IDocumentSchemeValidityChecksDataSource {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.data.d$a */
    @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/IDocumentSchemeValidityChecksDataSource$DocumentSchemeValidityCheckRequestData;", "", "scheme", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentScheme;", "iso3Code", "", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentScheme;Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;)V", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "getIso3Code", "()Ljava/lang/String;", "getScheme", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentScheme;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class a {

        /* JADX INFO: renamed from: a */
        private final AssessmentScheme f7883a;

        /* JADX INFO: renamed from: b */
        private final String f7884b;

        /* JADX INFO: renamed from: c */
        private final DocumentType f7885c;

        public a(AssessmentScheme scheme, String iso3Code, DocumentType documentType) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
            Intrinsics.checkNotNullParameter(documentType, "documentType");
            this.f7883a = scheme;
            this.f7884b = iso3Code;
            this.f7885c = documentType;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return this.f7883a == aVar.f7883a && Intrinsics.areEqual(this.f7884b, aVar.f7884b) && this.f7885c == aVar.f7885c;
        }

        public int hashCode() {
            return (((this.f7883a.hashCode() * 31) + this.f7884b.hashCode()) * 31) + this.f7885c.hashCode();
        }

        public String toString() {
            return "DocumentSchemeValidityCheckRequestData(scheme=" + this.f7883a + ", iso3Code=" + this.f7884b + ", documentType=" + this.f7885c + ')';
        }
    }
}
