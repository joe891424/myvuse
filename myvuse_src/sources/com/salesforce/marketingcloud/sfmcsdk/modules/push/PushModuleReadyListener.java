package com.salesforce.marketingcloud.sfmcsdk.modules.push;

import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleInterface;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushModuleInterface.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/modules/push/PushModuleReadyListener;", "Lcom/salesforce/marketingcloud/sfmcsdk/modules/ModuleReadyListener;", "ready", "", "module", "Lcom/salesforce/marketingcloud/sfmcsdk/modules/ModuleInterface;", "Lcom/salesforce/marketingcloud/sfmcsdk/modules/push/PushModuleInterface;", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface PushModuleReadyListener extends ModuleReadyListener {
    void ready(PushModuleInterface module);

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyListener
    default void ready(ModuleInterface module) {
        Intrinsics.checkNotNullParameter(module, "module");
        ready((PushModuleInterface) module);
    }
}
