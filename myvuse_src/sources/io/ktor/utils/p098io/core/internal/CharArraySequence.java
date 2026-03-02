package io.ktor.utils.p098io.core.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UTF8.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0086\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0016\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lio/ktor/utils/io/core/internal/CharArraySequence;", "", "array", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "length", "([CII)V", "getLength", "()I", "get", "", FirebaseAnalytics.Param.INDEX, "indexOutOfBounds", "", "subSequence", "startIndex", "endIndex", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class CharArraySequence implements CharSequence {
    private final char[] array;
    private final int length;
    private final int offset;

    public CharArraySequence(char[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.array = array;
        this.offset = i;
        this.length = i2;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return this.length;
    }

    public final int getLength() {
        return this.length;
    }

    public final char get(int index) {
        if (index >= this.length) {
            indexOutOfBounds(index);
            throw new KotlinNothingValueException();
        }
        return this.array[index + this.offset];
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(final int startIndex, final int endIndex) {
        if (startIndex >= 0) {
            int i = this.length;
            if (!(startIndex <= i)) {
                new RequireFailureCapture() { // from class: io.ktor.utils.io.core.internal.CharArraySequence$subSequence$$inlined$require$2
                    @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                    public Void doFail() {
                        throw new IllegalArgumentException("startIndex is too large: " + startIndex + " > " + this.length());
                    }
                }.doFail();
                throw new KotlinNothingValueException();
            }
            if (!(startIndex + endIndex <= i)) {
                new RequireFailureCapture() { // from class: io.ktor.utils.io.core.internal.CharArraySequence$subSequence$$inlined$require$3
                    @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                    public Void doFail() {
                        throw new IllegalArgumentException("endIndex is too large: " + endIndex + " > " + this.length());
                    }
                }.doFail();
                throw new KotlinNothingValueException();
            }
            if (endIndex >= startIndex) {
                return new CharArraySequence(this.array, this.offset + startIndex, endIndex - startIndex);
            }
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.internal.CharArraySequence$subSequence$$inlined$require$4
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    throw new IllegalArgumentException("endIndex should be greater or equal to startIndex: " + startIndex + " > " + endIndex);
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.internal.CharArraySequence$subSequence$$inlined$require$1
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException(Intrinsics.stringPlus("startIndex shouldn't be negative: ", Integer.valueOf(startIndex)));
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    private final Void indexOutOfBounds(int index) {
        throw new IndexOutOfBoundsException("String index out of bounds: " + index + " > " + this.length);
    }
}
