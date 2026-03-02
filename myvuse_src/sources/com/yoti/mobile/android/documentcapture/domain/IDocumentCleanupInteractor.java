package com.yoti.mobile.android.documentcapture.domain;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/IDocumentCleanupInteractor;", "", "cleanupResources", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IDocumentCleanupInteractor {
    Object cleanupResources(Continuation<? super Unit> continuation);
}
