package org.koin.core;

import kotlin.Metadata;
import org.koin.core.context.KoinContextHandler;

/* JADX INFO: compiled from: KoinComponent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m5598d2 = {"Lorg/koin/core/KoinComponent;", "", "getKoin", "Lorg/koin/core/Koin;", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
public interface KoinComponent {
    Koin getKoin();

    /* JADX INFO: compiled from: KoinComponent.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 16})
    public static final class DefaultImpls {
        public static Koin getKoin(KoinComponent koinComponent) {
            return KoinContextHandler.INSTANCE.get();
        }
    }
}
