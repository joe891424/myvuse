package com.bat.sdk.persistence;

import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Settings.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m5598d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ProducerScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.persistence.Settings$observeKey$flow$1", m5608f = "Settings.kt", m5609i = {}, m5610l = {83}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
final class Settings$observeKey$flow$1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ T $default;
    final /* synthetic */ String $key;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Settings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Settings$observeKey$flow$1(Settings settings, String str, T t, Continuation<? super Settings$observeKey$flow$1> continuation) {
        super(2, continuation);
        this.this$0 = settings;
        this.$key = str;
        this.$default = t;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Settings$observeKey$flow$1 settings$observeKey$flow$1 = new Settings$observeKey$flow$1(this.this$0, this.$key, this.$default, continuation);
        settings$observeKey$flow$1.L$0 = obj;
        return settings$observeKey$flow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return ((Settings$observeKey$flow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            Settings settings = this.this$0;
            SharedPreferences prefs = settings.getPrefs();
            Intrinsics.checkNotNullExpressionValue(prefs, "access$getPrefs(...)");
            producerScope.mo8737trySendJP2dKIU(settings.getItem(prefs, this.$key, this.$default));
            final String str = this.$key;
            final Settings settings2 = this.this$0;
            final T t = this.$default;
            final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.bat.sdk.persistence.Settings$observeKey$flow$1$$ExternalSyntheticLambda0
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str2) {
                    Settings$observeKey$flow$1.invokeSuspend$lambda$0(str, producerScope, settings2, t, sharedPreferences, str2);
                }
            };
            this.this$0.getPrefs().registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            final Settings settings3 = this.this$0;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0() { // from class: com.bat.sdk.persistence.Settings$observeKey$flow$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Settings$observeKey$flow$1.invokeSuspend$lambda$1(settings3, onSharedPreferenceChangeListener);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(String str, ProducerScope producerScope, Settings settings, Object obj, SharedPreferences sharedPreferences, String str2) {
        if (Intrinsics.areEqual(str, str2)) {
            SharedPreferences prefs = settings.getPrefs();
            Intrinsics.checkNotNullExpressionValue(prefs, "access$getPrefs(...)");
            Object item = settings.getItem(prefs, str, obj);
            Intrinsics.checkNotNull(item);
            producerScope.mo8737trySendJP2dKIU(item);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(Settings settings, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        settings.getPrefs().unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        return Unit.INSTANCE;
    }
}
