package io.branch.coroutines;

import android.content.Context;
import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.miui.referrer.api.GetAppsReferrerClient;
import com.miui.referrer.api.GetAppsReferrerDetails;
import com.miui.referrer.api.GetAppsReferrerStateListener;
import io.branch.data.InstallReferrerResult;
import io.branch.referral.BranchLogger;
import io.branch.referral.Defines;
import io.branch.referral.util.DependencyUtilsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: InstallReferrers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m5598d2 = {"fetchLatestInstallReferrer", "Lio/branch/data/InstallReferrerResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGooglePlayStoreReferrerDetails", "getHuaweiAppGalleryReferrerDetails", "getLatestValidReferrerStore", "allReferrers", "", "getSamsungGalaxyStoreReferrerDetails", "getXiaomiGetAppsReferrerDetails", "Branch-SDK_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class InstallReferrersKt {

    /* JADX INFO: renamed from: io.branch.coroutines.InstallReferrersKt$getGooglePlayStoreReferrerDetails$2 */
    /* JADX INFO: compiled from: InstallReferrers.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Lio/branch/data/InstallReferrerResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.branch.coroutines.InstallReferrersKt$getGooglePlayStoreReferrerDetails$2", m5608f = "InstallReferrers.kt", m5609i = {}, m5610l = {60}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C51632 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InstallReferrerResult>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C51632(Context context, Continuation<? super C51632> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C51632(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InstallReferrerResult> continuation) {
            return ((C51632) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                    final InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(this.$context.getApplicationContext()).build();
                    installReferrerClientBuild.startConnection(new InstallReferrerStateListener() { // from class: io.branch.coroutines.InstallReferrersKt.getGooglePlayStoreReferrerDetails.2.1
                        @Override // com.android.installreferrer.api.InstallReferrerStateListener
                        public void onInstallReferrerSetupFinished(int responseInt) {
                            BranchLogger.m5575d("getGooglePlayStoreReferrerDetails onInstallReferrerSetupFinished response code: " + responseInt);
                            InstallReferrerResult installReferrerResult = null;
                            if (responseInt == 0) {
                                CompletableDeferred<InstallReferrerResult> completableDeferred = completableDeferredCompletableDeferred$default;
                                try {
                                    ReferrerDetails installReferrer = installReferrerClientBuild.getInstallReferrer();
                                    installReferrerResult = new InstallReferrerResult(Defines.Jsonkey.Google_Play_Store.getKey(), installReferrer.getInstallBeginTimestampSeconds(), installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds());
                                } catch (Exception e) {
                                    BranchLogger.m5575d("getGooglePlayStoreReferrerDetails installReferrer exception: " + e);
                                }
                                completableDeferred.complete(installReferrerResult);
                            } else {
                                completableDeferredCompletableDeferred$default.complete(null);
                            }
                            installReferrerClientBuild.endConnection();
                        }

                        @Override // com.android.installreferrer.api.InstallReferrerStateListener
                        public void onInstallReferrerServiceDisconnected() {
                            if (completableDeferredCompletableDeferred$default.isCompleted()) {
                                return;
                            }
                            completableDeferredCompletableDeferred$default.complete(null);
                        }
                    });
                    this.label = 1;
                    obj = completableDeferredCompletableDeferred$default.await(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return (InstallReferrerResult) obj;
            } catch (Exception e) {
                BranchLogger.m5575d("getGooglePlayStoreReferrerDetails exception: " + e);
                return null;
            }
        }
    }

    public static final Object getGooglePlayStoreReferrerDetails(Context context, Continuation<? super InstallReferrerResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new C51632(context, null), continuation);
    }

    /* JADX INFO: renamed from: io.branch.coroutines.InstallReferrersKt$getHuaweiAppGalleryReferrerDetails$2 */
    /* JADX INFO: compiled from: InstallReferrers.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Lio/branch/data/InstallReferrerResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.branch.coroutines.InstallReferrersKt$getHuaweiAppGalleryReferrerDetails$2", m5608f = "InstallReferrers.kt", m5609i = {}, m5610l = {113}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C51642 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InstallReferrerResult>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C51642(Context context, Continuation<? super C51642> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C51642(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InstallReferrerResult> continuation) {
            return ((C51642) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (DependencyUtilsKt.classExists(DependencyUtilsKt.huaweiInstallReferrerClass)) {
                        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                        final com.huawei.hms.ads.installreferrer.api.InstallReferrerClient installReferrerClientBuild = com.huawei.hms.ads.installreferrer.api.InstallReferrerClient.newBuilder(this.$context).build();
                        installReferrerClientBuild.startConnection(new com.huawei.hms.ads.installreferrer.api.InstallReferrerStateListener() { // from class: io.branch.coroutines.InstallReferrersKt.getHuaweiAppGalleryReferrerDetails.2.1
                            public void onInstallReferrerSetupFinished(int responseInt) {
                                BranchLogger.m5575d("getHuaweiAppGalleryReferrerDetails onInstallReferrerSetupFinished response code: " + responseInt);
                                InstallReferrerResult installReferrerResult = null;
                                if (responseInt == 0) {
                                    CompletableDeferred<InstallReferrerResult> completableDeferred = completableDeferredCompletableDeferred$default;
                                    try {
                                        com.huawei.hms.ads.installreferrer.api.ReferrerDetails installReferrer = installReferrerClientBuild.getInstallReferrer();
                                        installReferrerResult = new InstallReferrerResult(Defines.Jsonkey.Huawei_App_Gallery.getKey(), installReferrer.getInstallBeginTimestampSeconds(), installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds());
                                    } catch (Exception e) {
                                        BranchLogger.m5575d("getHuaweiAppGalleryReferrerDetails exception: " + e);
                                    }
                                    completableDeferred.complete(installReferrerResult);
                                } else {
                                    BranchLogger.m5575d("getHuaweiAppGalleryReferrerDetails response code: " + responseInt);
                                    completableDeferredCompletableDeferred$default.complete(null);
                                }
                                installReferrerClientBuild.endConnection();
                            }

                            public void onInstallReferrerServiceDisconnected() {
                                if (completableDeferredCompletableDeferred$default.isCompleted()) {
                                    return;
                                }
                                completableDeferredCompletableDeferred$default.complete(null);
                            }
                        });
                        this.label = 1;
                        obj = completableDeferredCompletableDeferred$default.await(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return null;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return (InstallReferrerResult) obj;
            } catch (Exception e) {
                BranchLogger.m5575d("getHuaweiAppGalleryReferrerDetails exception: " + e);
                return null;
            }
        }
    }

    public static final Object getHuaweiAppGalleryReferrerDetails(Context context, Continuation<? super InstallReferrerResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new C51642(context, null), continuation);
    }

    /* JADX INFO: renamed from: io.branch.coroutines.InstallReferrersKt$getSamsungGalaxyStoreReferrerDetails$2 */
    /* JADX INFO: compiled from: InstallReferrers.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Lio/branch/data/InstallReferrerResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.branch.coroutines.InstallReferrersKt$getSamsungGalaxyStoreReferrerDetails$2", m5608f = "InstallReferrers.kt", m5609i = {}, m5610l = {170}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C51652 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InstallReferrerResult>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C51652(Context context, Continuation<? super C51652> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C51652(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InstallReferrerResult> continuation) {
            return ((C51652) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (DependencyUtilsKt.classExists(DependencyUtilsKt.samsungInstallReferrerClass)) {
                        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                        final com.samsung.android.sdk.sinstallreferrer.api.InstallReferrerClient installReferrerClientBuild = com.samsung.android.sdk.sinstallreferrer.api.InstallReferrerClient.newBuilder(this.$context).build();
                        installReferrerClientBuild.startConnection(new com.samsung.android.sdk.sinstallreferrer.api.InstallReferrerStateListener() { // from class: io.branch.coroutines.InstallReferrersKt.getSamsungGalaxyStoreReferrerDetails.2.1
                            public void onInstallReferrerSetupFinished(int p0) {
                                BranchLogger.m5575d("getSamsungGalaxyStoreReferrerDetails onInstallReferrerSetupFinished response code: " + p0);
                                InstallReferrerResult installReferrerResult = null;
                                if (p0 == 0) {
                                    CompletableDeferred<InstallReferrerResult> completableDeferred = completableDeferredCompletableDeferred$default;
                                    try {
                                        com.samsung.android.sdk.sinstallreferrer.api.ReferrerDetails installReferrer = installReferrerClientBuild.getInstallReferrer();
                                        installReferrerResult = new InstallReferrerResult(Defines.Jsonkey.Samsung_Galaxy_Store.getKey(), installReferrer.getInstallBeginTimestampSeconds(), installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds());
                                    } catch (RemoteException e) {
                                        BranchLogger.m5575d("getSamsungGalaxyStoreReferrerDetails exception: " + e);
                                    }
                                    completableDeferred.complete(installReferrerResult);
                                } else {
                                    BranchLogger.m5575d("getSamsungGalaxyStoreReferrerDetails response code: " + p0);
                                    completableDeferredCompletableDeferred$default.complete(null);
                                }
                                installReferrerClientBuild.endConnection();
                            }

                            public void onInstallReferrerServiceDisconnected() {
                                if (completableDeferredCompletableDeferred$default.isCompleted()) {
                                    return;
                                }
                                completableDeferredCompletableDeferred$default.complete(null);
                            }
                        });
                        this.label = 1;
                        obj = completableDeferredCompletableDeferred$default.await(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return null;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return (InstallReferrerResult) obj;
            } catch (Exception e) {
                BranchLogger.m5575d("getSamsungGalaxyStoreReferrerDetails exception: " + e);
                return null;
            }
        }
    }

    public static final Object getSamsungGalaxyStoreReferrerDetails(Context context, Continuation<? super InstallReferrerResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new C51652(context, null), continuation);
    }

    /* JADX INFO: renamed from: io.branch.coroutines.InstallReferrersKt$getXiaomiGetAppsReferrerDetails$2 */
    /* JADX INFO: compiled from: InstallReferrers.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Lio/branch/data/InstallReferrerResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.branch.coroutines.InstallReferrersKt$getXiaomiGetAppsReferrerDetails$2", m5608f = "InstallReferrers.kt", m5609i = {}, m5610l = {221}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C51662 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InstallReferrerResult>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C51662(Context context, Continuation<? super C51662> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C51662(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InstallReferrerResult> continuation) {
            return ((C51662) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (DependencyUtilsKt.classExists(DependencyUtilsKt.xiaomiInstallReferrerClass)) {
                        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                        final GetAppsReferrerClient getAppsReferrerClientBuild = GetAppsReferrerClient.Companion.newBuilder(this.$context).build();
                        getAppsReferrerClientBuild.startConnection(new GetAppsReferrerStateListener() { // from class: io.branch.coroutines.InstallReferrersKt.getXiaomiGetAppsReferrerDetails.2.1
                            public void onGetAppsReferrerSetupFinished(int state) {
                                BranchLogger.m5575d("getXiaomiGetAppsReferrerDetails onInstallReferrerSetupFinished response code: " + state);
                                InstallReferrerResult installReferrerResult = null;
                                if (state == 0) {
                                    CompletableDeferred<InstallReferrerResult> completableDeferred = completableDeferredCompletableDeferred$default;
                                    try {
                                        GetAppsReferrerDetails installReferrer = getAppsReferrerClientBuild.getInstallReferrer();
                                        installReferrerResult = new InstallReferrerResult(Defines.Jsonkey.Xiaomi_Get_Apps.getKey(), installReferrer.getInstallBeginTimestampSeconds(), installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds());
                                    } catch (RemoteException e) {
                                        BranchLogger.m5575d("getXiaomiGetAppsReferrerDetails exception: " + e);
                                    }
                                    completableDeferred.complete(installReferrerResult);
                                } else {
                                    BranchLogger.m5575d("getXiaomiGetAppsReferrerDetails response code: " + state);
                                    completableDeferredCompletableDeferred$default.complete(null);
                                }
                                getAppsReferrerClientBuild.endConnection();
                            }

                            public void onGetAppsServiceDisconnected() {
                                if (completableDeferredCompletableDeferred$default.isCompleted()) {
                                    return;
                                }
                                completableDeferredCompletableDeferred$default.complete(null);
                            }
                        });
                        this.label = 1;
                        obj = completableDeferredCompletableDeferred$default.await(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return null;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return (InstallReferrerResult) obj;
            } catch (Exception e) {
                BranchLogger.m5575d("getXiaomiGetAppsReferrerDetails exception: " + e);
                return null;
            }
        }
    }

    public static final Object getXiaomiGetAppsReferrerDetails(Context context, Continuation<? super InstallReferrerResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new C51662(context, null), continuation);
    }

    /* JADX INFO: renamed from: io.branch.coroutines.InstallReferrersKt$fetchLatestInstallReferrer$2 */
    /* JADX INFO: compiled from: InstallReferrers.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Lio/branch/data/InstallReferrerResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.branch.coroutines.InstallReferrersKt$fetchLatestInstallReferrer$2", m5608f = "InstallReferrers.kt", m5609i = {0, 0, 0, 1, 1, 2}, m5610l = {244, 244, 244, 244}, m5611m = "invokeSuspend", m5612n = {"huaweiReferrer", "samsungReferrer", "xiaomiReferrer", "samsungReferrer", "xiaomiReferrer", "xiaomiReferrer"}, m5613s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
    static final class C51612 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InstallReferrerResult>, Object> {
        final /* synthetic */ Context $context;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C51612(Context context, Continuation<? super C51612> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C51612 c51612 = new C51612(this.$context, continuation);
            c51612.L$0 = obj;
            return c51612;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InstallReferrerResult> continuation) {
            return ((C51612) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0130 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x014a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x014b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 345
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.coroutines.InstallReferrersKt.C51612.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object fetchLatestInstallReferrer(Context context, Continuation<? super InstallReferrerResult> continuation) {
        return SupervisorKt.supervisorScope(new C51612(context, null), continuation);
    }

    public static final InstallReferrerResult getLatestValidReferrerStore(List<InstallReferrerResult> allReferrers) {
        Object obj;
        Intrinsics.checkNotNullParameter(allReferrers, "allReferrers");
        Iterator it2 = CollectionsKt.filterNotNull(allReferrers).iterator();
        if (it2.hasNext()) {
            Object next = it2.next();
            if (it2.hasNext()) {
                long latestInstallTimestamp = ((InstallReferrerResult) next).getLatestInstallTimestamp();
                do {
                    Object next2 = it2.next();
                    long latestInstallTimestamp2 = ((InstallReferrerResult) next2).getLatestInstallTimestamp();
                    if (latestInstallTimestamp < latestInstallTimestamp2) {
                        next = next2;
                        latestInstallTimestamp = latestInstallTimestamp2;
                    }
                } while (it2.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (InstallReferrerResult) obj;
    }
}
