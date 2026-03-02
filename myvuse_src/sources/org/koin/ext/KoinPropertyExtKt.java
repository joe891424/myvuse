package org.koin.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.koin.core.Koin;

/* JADX INFO: compiled from: KoinPropertyExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0019\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\t\u001a\u001a\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\b\u001a\u001a\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0001\u001a\u001a\u0010\r\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b¨\u0006\u000e"}, m5598d2 = {"getFloatProperty", "", "Lorg/koin/core/Koin;", "key", "", "(Lorg/koin/core/Koin;Ljava/lang/String;)Ljava/lang/Float;", "defaultValue", "getIntProperty", "", "(Lorg/koin/core/Koin;Ljava/lang/String;)Ljava/lang/Integer;", "setFloatProperty", "", "value", "setIntProperty", "koin-core"}, m5599k = 2, m5600mv = {1, 1, 16})
public final class KoinPropertyExtKt {
    public static final int getIntProperty(Koin getIntProperty, String key, int i) {
        Intrinsics.checkParameterIsNotNull(getIntProperty, "$this$getIntProperty");
        Intrinsics.checkParameterIsNotNull(key, "key");
        Integer intProperty = getIntProperty(getIntProperty, key);
        return intProperty != null ? intProperty.intValue() : i;
    }

    public static final Integer getIntProperty(Koin getIntProperty, String key) {
        Intrinsics.checkParameterIsNotNull(getIntProperty, "$this$getIntProperty");
        Intrinsics.checkParameterIsNotNull(key, "key");
        String property = getIntProperty.getProperty(key);
        if (property != null) {
            return StringsKt.toIntOrNull(property);
        }
        return null;
    }

    public static final void setIntProperty(Koin setIntProperty, String key, int i) {
        Intrinsics.checkParameterIsNotNull(setIntProperty, "$this$setIntProperty");
        Intrinsics.checkParameterIsNotNull(key, "key");
        setIntProperty.setProperty(key, String.valueOf(i));
    }

    public static final float getFloatProperty(Koin getFloatProperty, String key, float f) {
        Intrinsics.checkParameterIsNotNull(getFloatProperty, "$this$getFloatProperty");
        Intrinsics.checkParameterIsNotNull(key, "key");
        Float floatProperty = getFloatProperty(getFloatProperty, key);
        return floatProperty != null ? floatProperty.floatValue() : f;
    }

    public static final Float getFloatProperty(Koin getFloatProperty, String key) {
        Intrinsics.checkParameterIsNotNull(getFloatProperty, "$this$getFloatProperty");
        Intrinsics.checkParameterIsNotNull(key, "key");
        String property = getFloatProperty.getProperty(key);
        if (property != null) {
            return StringsKt.toFloatOrNull(property);
        }
        return null;
    }

    public static final void setFloatProperty(Koin setFloatProperty, String key, float f) {
        Intrinsics.checkParameterIsNotNull(setFloatProperty, "$this$setFloatProperty");
        Intrinsics.checkParameterIsNotNull(key, "key");
        setFloatProperty.setProperty(key, String.valueOf(f));
    }
}
