package org.jose4j.jwt;

import java.text.DateFormat;
import java.util.Date;
import org.jose4j.lang.Maths;

/* JADX INFO: loaded from: classes6.dex */
public class NumericDate {
    private static final long CONVERSION = 1000;
    private long value;

    private NumericDate(long j) {
        setValue(j);
    }

    public static NumericDate now() {
        return fromMilliseconds(System.currentTimeMillis());
    }

    public static NumericDate fromSeconds(long j) {
        return new NumericDate(j);
    }

    public static NumericDate fromMilliseconds(long j) {
        return fromSeconds(j / 1000);
    }

    public void addSeconds(long j) {
        setValue(Maths.add(this.value, j));
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long j) {
        this.value = j;
    }

    public long getValueInMillis() {
        long value = getValue();
        long j = 1000 * value;
        if (canConvertToMillis()) {
            return j;
        }
        throw new ArithmeticException("converting " + value + " seconds to milliseconds (x1000) resulted in long integer overflow (" + j + ")");
    }

    private boolean canConvertToMillis() {
        long value = getValue();
        long j = 1000 * value;
        if (value > 0 && j < value) {
            return false;
        }
        if (value >= 0 || j <= value) {
            return !(((value > 0L ? 1 : (value == 0L ? 0 : -1)) == 0) & ((j > 0L ? 1 : (j == 0L ? 0 : -1)) != 0));
        }
        return false;
    }

    public boolean isBefore(NumericDate numericDate) {
        return this.value < numericDate.getValue();
    }

    public boolean isOnOrAfter(NumericDate numericDate) {
        return !isBefore(numericDate);
    }

    public boolean isAfter(NumericDate numericDate) {
        return this.value > numericDate.getValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NumericDate{");
        sb.append(getValue());
        if (canConvertToMillis()) {
            sb.append(" -> ").append(DateFormat.getDateTimeInstance(2, 1).format(new Date(getValueInMillis())));
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof NumericDate) && this.value == ((NumericDate) obj).value);
    }

    public int hashCode() {
        long j = this.value;
        return (int) (j ^ (j >>> 32));
    }
}
