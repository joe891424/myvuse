package com.yoti.mobile.android.documentcapture.sup.domain;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidationResult;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.ForIo;
import java.io.FileNotFoundException;
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
import kotlin.p099io.CloseableKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\f\u0010\f\u001a\u00020\r*\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/domain/FileSizeValidator;", "", "context", "Landroid/content/Context;", "ioContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "validate", "Lcom/yoti/mobile/android/documentcapture/sup/domain/FileSizeValidationResult;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFileSizeValid", "", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FileSizeValidator {
    private final Context context;
    private final CoroutineContext ioContext;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidator$validate$2 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Lcom/yoti/mobile/android/documentcapture/sup/domain/FileSizeValidationResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.sup.domain.FileSizeValidator$validate$2", m5608f = "FileSizeValidator.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46672 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FileSizeValidationResult>, Object> {
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C46672(Uri uri, Continuation<? super C46672> continuation) {
            super(2, continuation);
            this.$uri = uri;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileSizeValidator.this.new C46672(this.$uri, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FileSizeValidationResult> continuation) {
            return ((C46672) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                return FileSizeValidator.this.isFileSizeValid(this.$uri) ? FileSizeValidationResult.ValidSize.INSTANCE : FileSizeValidationResult.InvalidSize.INSTANCE;
            } catch (FileNotFoundException e) {
                return new FileSizeValidationResult.Error(e);
            }
        }
    }

    @Inject
    public FileSizeValidator(Context context, @ForIo CoroutineContext ioContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ioContext, "ioContext");
        this.context = context;
        this.ioContext = ioContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFileSizeValid(Uri uri) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.context.getContentResolver().openAssetFileDescriptor(uri, RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME);
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            try {
                z = assetFileDescriptorOpenAssetFileDescriptor.getLength() < 10485760;
                CloseableKt.closeFinally(assetFileDescriptorOpenAssetFileDescriptor, null);
            } finally {
            }
        }
        return z;
    }

    public final Object validate(Uri uri, Continuation<? super FileSizeValidationResult> continuation) {
        return BuildersKt.withContext(this.ioContext, new C46672(uri, null), continuation);
    }
}
