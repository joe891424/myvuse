package androidx.camera.core.impl.utils;

import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract boolean equals(Object object);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    /* JADX INFO: renamed from: or */
    public abstract Optional<T> mo1153or(Optional<? extends T> secondChoice);

    /* JADX INFO: renamed from: or */
    public abstract T mo1154or(Supplier<? extends T> supplier);

    /* JADX INFO: renamed from: or */
    public abstract T mo1155or(T defaultValue);

    public abstract T orNull();

    public abstract String toString();

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    /* JADX INFO: renamed from: of */
    public static <T> Optional<T> m1156of(T reference) {
        return new Present(Preconditions.checkNotNull(reference));
    }

    public static <T> Optional<T> fromNullable(T nullableReference) {
        return nullableReference == null ? absent() : new Present(nullableReference);
    }

    Optional() {
    }
}
