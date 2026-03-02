package com.squareup.wire.internal;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InstantJsonFormatter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u00020\t2\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\n"}, m5598d2 = {"Lcom/squareup/wire/internal/InstantJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "Ljava/time/Instant;", "Lcom/squareup/wire/Instant;", "()V", "fromString", "value", "", "toStringOrNumber", "", "wire-runtime"}, m5599k = 1, m5600mv = {1, 4, 0})
public final class InstantJsonFormatter implements JsonFormatter<Instant> {
    public static final InstantJsonFormatter INSTANCE = new InstantJsonFormatter();

    private InstantJsonFormatter() {
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    public Object toStringOrNumber(Instant value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String str = DateTimeFormatter.ISO_INSTANT.format(value);
        Intrinsics.checkNotNullExpressionValue(str, "ISO_INSTANT.format(value)");
        return str;
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    public Instant fromString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Instant instantFrom = Instant.from(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(value));
        Intrinsics.checkNotNullExpressionValue(instantFrom, "Instant.from(parsed)");
        return instantFrom;
    }
}
