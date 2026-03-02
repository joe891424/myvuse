package com.bat.sdk.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import com.google.gson.Gson;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: Settings.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0019J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0015J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010 \u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J/\u0010\"\u001a\b\u0012\u0004\u0012\u0002H$0#\"\u0004\b\u0000\u0010$2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010%\u001a\u0002H$2\u0006\u0010&\u001a\u00020'¢\u0006\u0002\u0010(J'\u0010)\u001a\u0002H$\"\u0004\b\u0000\u0010$*\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010%\u001a\u0002H$H\u0002¢\u0006\u0002\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR#\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010¨\u0006+"}, m5598d2 = {"Lcom/bat/sdk/persistence/Settings;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs$delegate", "set", "", "key", "", "value", "", "", "", "", "getLong", "getBoolean", "getString", "getStringSet", "getInt", "has", "remove", "observeKey", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, Constants.COLLATION_DEFAULT, "dispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/flow/Flow;", "getItem", "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class Settings {
    private final Context context;

    /* JADX INFO: renamed from: gson$delegate, reason: from kotlin metadata */
    private final Lazy gson;

    /* JADX INFO: renamed from: prefs$delegate, reason: from kotlin metadata */
    private final Lazy prefs;

    public Settings(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.gson = LazyKt.lazy(new Function0() { // from class: com.bat.sdk.persistence.Settings$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Settings.gson_delegate$lambda$0();
            }
        });
        this.prefs = LazyKt.lazy(new Function0() { // from class: com.bat.sdk.persistence.Settings$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Settings.prefs_delegate$lambda$1(this.f$0);
            }
        });
    }

    private final Gson getGson() {
        return (Gson) this.gson.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson gson_delegate$lambda$0() {
        return new Gson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences getPrefs() {
        return (SharedPreferences) this.prefs.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferences prefs_delegate$lambda$1(Settings this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.context.getSharedPreferences("batsdk_prefs", 0);
    }

    public final void set(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        getPrefs().edit().putBoolean(key, value).apply();
    }

    public final void set(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        getPrefs().edit().putString(key, value).apply();
    }

    public final void set(String key, List<String> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        getPrefs().edit().putStringSet(key, CollectionsKt.toSet(value)).apply();
    }

    public final void set(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        getPrefs().edit().putInt(key, value).apply();
    }

    public final void set(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        getPrefs().edit().putLong(key, value).apply();
    }

    public final long getLong(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getPrefs().getLong(key, 0L);
    }

    public final boolean getBoolean(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getPrefs().getBoolean(key, false);
    }

    public final String getString(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getPrefs().getString(key, null);
    }

    public final List<String> getStringSet(String key) {
        List<String> list;
        Intrinsics.checkNotNullParameter(key, "key");
        Set<String> stringSet = getPrefs().getStringSet(key, null);
        return (stringSet == null || (list = CollectionsKt.toList(stringSet)) == null) ? CollectionsKt.emptyList() : list;
    }

    public final int getInt(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getPrefs().getInt(key, 0);
    }

    public final boolean has(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getPrefs().contains(key);
    }

    public final void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        getPrefs().edit().remove(key).apply();
    }

    public final <T> Flow<T> observeKey(String key, T t, CoroutineContext dispatcher) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        return FlowKt.flowOn(FlowKt.channelFlow(new Settings$observeKey$flow$1(this, key, t, null)), dispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T getItem(SharedPreferences sharedPreferences, String str, T t) {
        if (t instanceof String) {
            return (T) sharedPreferences.getString(str, (String) t);
        }
        if (t instanceof Integer) {
            return (T) Integer.valueOf(sharedPreferences.getInt(str, ((Number) t).intValue()));
        }
        if (t instanceof Long) {
            return (T) Long.valueOf(sharedPreferences.getLong(str, ((Number) t).longValue()));
        }
        if (t instanceof Boolean) {
            return (T) Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()));
        }
        if (t instanceof Float) {
            return (T) Float.valueOf(sharedPreferences.getFloat(str, ((Number) t).floatValue()));
        }
        if (t instanceof Set) {
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            return (T) sharedPreferences.getStringSet(str, (Set) t);
        }
        if (!TypeIntrinsics.isMutableSet(t)) {
            throw new IllegalArgumentException("cant handle " + str);
        }
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.String>");
        return (T) sharedPreferences.getStringSet(str, TypeIntrinsics.asMutableSet(t));
    }
}
