package androidx.privacysandbox.ads.adservices.adid;

import androidx.privacysandbox.ads.adservices.adid.AdIdManager;
import com.facebook.soloader.Elf64_Ehdr;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AdIdManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5599k = 3, m5600mv = {1, 8, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl", m5608f = "AdIdManager.kt", m5609i = {}, m5610l = {Elf64_Ehdr.e_shstrndx}, m5611m = "getAdId", m5612n = {}, m5613s = {})
final class AdIdManager$Api33Ext4Impl$getAdId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdIdManager.Api33Ext4Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdIdManager$Api33Ext4Impl$getAdId$1(AdIdManager.Api33Ext4Impl api33Ext4Impl, Continuation<? super AdIdManager$Api33Ext4Impl$getAdId$1> continuation) {
        super(continuation);
        this.this$0 = api33Ext4Impl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAdId(this);
    }
}
