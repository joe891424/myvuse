package com.yoti.mobile.android.documentcapture.sup.data.cache;

import com.yoti.mobile.android.documentcapture.sup.data.remote.model.SupDocumentScanConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/data/cache/SupDocumentScanConfigurationCacheDataSource;", "", "()V", "supDocumentScanConfigFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/SupDocumentScanConfiguration;", "getSupDocumentScanConfigurationFlow", "Lkotlinx/coroutines/flow/Flow;", "invalidate", "", "setSupDocumentScanConfiguration", "supDocumentScanConfiguration", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentScanConfigurationCacheDataSource {
    public static final SupDocumentScanConfigurationCacheDataSource INSTANCE = new SupDocumentScanConfigurationCacheDataSource();
    private static final MutableStateFlow<SupDocumentScanConfiguration> supDocumentScanConfigFlow = StateFlowKt.MutableStateFlow(null);

    private SupDocumentScanConfigurationCacheDataSource() {
    }

    public final Flow<SupDocumentScanConfiguration> getSupDocumentScanConfigurationFlow() {
        return supDocumentScanConfigFlow;
    }

    public final void invalidate() {
        supDocumentScanConfigFlow.setValue(null);
    }

    public final void setSupDocumentScanConfiguration(SupDocumentScanConfiguration supDocumentScanConfiguration) {
        Intrinsics.checkNotNullParameter(supDocumentScanConfiguration, "supDocumentScanConfiguration");
        supDocumentScanConfigFlow.setValue(supDocumentScanConfiguration);
    }
}
