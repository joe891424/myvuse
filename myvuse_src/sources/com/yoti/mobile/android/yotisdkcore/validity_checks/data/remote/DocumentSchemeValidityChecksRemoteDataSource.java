package com.yoti.mobile.android.yotisdkcore.validity_checks.data.remote;

import com.yoti.mobile.android.yotisdkcore.validity_checks.data.IDocumentSchemeValidityChecksDataSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.data.remote.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/remote/DocumentSchemeValidityChecksRemoteDataSource;", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/IDocumentSchemeValidityChecksDataSource;", "documentSchemeValidityCheckApiService", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/remote/DocumentSchemeValidityChecksApiService;", "(Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/remote/DocumentSchemeValidityChecksApiService;)V", "getChecks", "Lcom/yoti/mobile/android/commons/functional/Either;", "Lcom/yoti/mobile/android/remote/exception/RemoteError;", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck;", "requestData", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/IDocumentSchemeValidityChecksDataSource$DocumentSchemeValidityCheckRequestData;", "(Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/IDocumentSchemeValidityChecksDataSource$DocumentSchemeValidityCheckRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentSchemeValidityChecksRemoteDataSource implements IDocumentSchemeValidityChecksDataSource {

    /* JADX INFO: renamed from: a */
    private final DocumentSchemeValidityChecksApiService f7893a;

    @Inject
    public DocumentSchemeValidityChecksRemoteDataSource(DocumentSchemeValidityChecksApiService documentSchemeValidityCheckApiService) {
        Intrinsics.checkNotNullParameter(documentSchemeValidityCheckApiService, "documentSchemeValidityCheckApiService");
        this.f7893a = documentSchemeValidityCheckApiService;
    }
}
