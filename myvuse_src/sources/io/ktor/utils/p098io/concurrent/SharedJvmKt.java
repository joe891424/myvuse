package io.ktor.utils.p098io.concurrent;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: SharedJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001a-\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u0002H\u0003H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m5598d2 = {"shared", "Lkotlin/properties/ReadWriteProperty;", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "(Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", "threadLocal", "Lkotlin/properties/ReadOnlyProperty;", "(Ljava/lang/Object;)Lkotlin/properties/ReadOnlyProperty;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class SharedJvmKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: threadLocal$lambda-0, reason: not valid java name */
    public static final Object m7096threadLocal$lambda0(Object value, Object thisRef, KProperty property) {
        Intrinsics.checkNotNullParameter(value, "$value");
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        return value;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: io.ktor.utils.io.concurrent.SharedJvmKt$shared$1 */
    /* JADX INFO: compiled from: SharedJvm.kt */
    @Metadata(m5597d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001J\"\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0096\u0002¢\u0006\u0002\u0010\tJ*\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0003\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\fR\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\r"}, m5598d2 = {"io/ktor/utils/io/concurrent/SharedJvmKt$shared$1", "Lkotlin/properties/ReadWriteProperty;", "", "value", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class C53371<T> implements ReadWriteProperty<Object, T> {
        final /* synthetic */ T $value;
        private T value;

        public C53371(T t) {
            this.$value = t;
            this.value = t;
        }

        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        public T getValue(Object thisRef, KProperty<?> property) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(property, "property");
            return this.value;
        }

        @Override // kotlin.properties.ReadWriteProperty
        public void setValue(Object thisRef, KProperty<?> property, T value) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(property, "property");
            this.value = value;
        }
    }

    @DangerousInternalIoApi
    public static final <T> ReadWriteProperty<Object, T> shared(T t) {
        return new C53371(t);
    }

    @DangerousInternalIoApi
    public static final <T> ReadOnlyProperty<Object, T> threadLocal(final T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new ReadOnlyProperty() { // from class: io.ktor.utils.io.concurrent.SharedJvmKt$$ExternalSyntheticLambda0
            @Override // kotlin.properties.ReadOnlyProperty
            public final Object getValue(Object obj, KProperty kProperty) {
                return SharedJvmKt.m7096threadLocal$lambda0(value, obj, kProperty);
            }
        };
    }
}
