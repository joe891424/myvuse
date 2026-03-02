package com.yoti.mobile.android.documentcapture.sup.domain;

import android.content.Context;
import com.yoti.mobile.android.documentcapture.domain.IDocumentCleanupInteractor;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentFileProvider;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.ForIo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/domain/SupDocumentCleanupInteractor;", "Lcom/yoti/mobile/android/documentcapture/domain/IDocumentCleanupInteractor;", "context", "Landroid/content/Context;", "fileProvider", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentFileProvider;", "ioContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentFileProvider;Lkotlin/coroutines/CoroutineContext;)V", "cleanupResources", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentCleanupInteractor implements IDocumentCleanupInteractor {
    private final Context context;
    private final SupDocumentFileProvider fileProvider;
    private final CoroutineContext ioContext;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.domain.SupDocumentCleanupInteractor$cleanupResources$2 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.sup.domain.SupDocumentCleanupInteractor$cleanupResources$2", m5608f = "SupDocumentCleanupInteractor.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46682 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C46682(Continuation<? super C46682> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SupDocumentCleanupInteractor.this.new C46682(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46682) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SupDocumentCleanupInteractor.this.fileProvider.cleanUpFileDirectory(SupDocumentCleanupInteractor.this.context);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public SupDocumentCleanupInteractor(Context context, SupDocumentFileProvider fileProvider, @ForIo CoroutineContext ioContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileProvider, "fileProvider");
        Intrinsics.checkNotNullParameter(ioContext, "ioContext");
        this.context = context;
        this.fileProvider = fileProvider;
        this.ioContext = ioContext;
    }

    @Override // com.yoti.mobile.android.documentcapture.domain.IDocumentCleanupInteractor
    public Object cleanupResources(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioContext, new C46682(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
