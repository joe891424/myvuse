package io.branch.coroutines;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import io.branch.referral.BranchLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AdvertisingIds.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m5598d2 = {"getAmazonFireAdvertisingInfoObject", "Lkotlin/Pair;", "", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGoogleAdvertisingInfoObject", "Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;", "getHuaweiAdvertisingInfoObject", "Lcom/huawei/hms/ads/identifier/AdvertisingIdClient$Info;", "Branch-SDK_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AdvertisingIdsKt {

    /* JADX INFO: renamed from: io.branch.coroutines.AdvertisingIdsKt$getGoogleAdvertisingInfoObject$2 */
    /* JADX INFO: compiled from: AdvertisingIds.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.branch.coroutines.AdvertisingIdsKt$getGoogleAdvertisingInfoObject$2", m5608f = "AdvertisingIds.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C51592 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AdvertisingIdClient.Info>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C51592(Context context, Continuation<? super C51592> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C51592(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AdvertisingIdClient.Info> continuation) {
            return ((C51592) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                return AdvertisingIdClient.getAdvertisingIdInfo(this.$context);
            } catch (Exception e) {
                BranchLogger.m5575d("getGoogleAdvertisingInfoObject exception: " + e);
                return null;
            }
        }
    }

    public static final Object getGoogleAdvertisingInfoObject(Context context, Continuation<? super AdvertisingIdClient.Info> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new C51592(context, null), continuation);
    }

    /* JADX INFO: renamed from: io.branch.coroutines.AdvertisingIdsKt$getHuaweiAdvertisingInfoObject$2 */
    /* JADX INFO: compiled from: AdvertisingIds.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Lcom/huawei/hms/ads/identifier/AdvertisingIdClient$Info;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.branch.coroutines.AdvertisingIdsKt$getHuaweiAdvertisingInfoObject$2", m5608f = "AdvertisingIds.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C51602 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AdvertisingIdClient.Info>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C51602(Context context, Continuation<? super C51602> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C51602(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AdvertisingIdClient.Info> continuation) {
            return ((C51602) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                return com.huawei.hms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(this.$context);
            } catch (Exception e) {
                BranchLogger.m5575d("getHuaweiAdvertisingInfoObject exception: " + e);
                return null;
            }
        }
    }

    public static final Object getHuaweiAdvertisingInfoObject(Context context, Continuation<? super AdvertisingIdClient.Info> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new C51602(context, null), continuation);
    }

    /* JADX INFO: renamed from: io.branch.coroutines.AdvertisingIdsKt$getAmazonFireAdvertisingInfoObject$2 */
    /* JADX INFO: compiled from: AdvertisingIds.kt */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u0001*\u00020\u0005H\u008a@"}, m5598d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.branch.coroutines.AdvertisingIdsKt$getAmazonFireAdvertisingInfoObject$2", m5608f = "AdvertisingIds.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C51582 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Integer, ? extends String>>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C51582(Context context, Continuation<? super C51582> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C51582(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Integer, ? extends String>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Pair<Integer, String>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<Integer, String>> continuation) {
            return ((C51582) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                ContentResolver contentResolver = this.$context.getContentResolver();
                return new Pair(Boxing.boxInt(Settings.Secure.getInt(contentResolver, "limit_ad_tracking")), Settings.Secure.getString(contentResolver, "advertising_id"));
            } catch (Exception e) {
                BranchLogger.m5575d("getAmazonFireAdvertisingInfo exception: " + e);
                return null;
            }
        }
    }

    public static final Object getAmazonFireAdvertisingInfoObject(Context context, Continuation<? super Pair<Integer, String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new C51582(context, null), continuation);
    }
}
