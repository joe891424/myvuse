package com.bat.sdk.persistence;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Converters.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007¨\u0006\n"}, m5598d2 = {"Lcom/bat/sdk/persistence/Converters;", "", "<init>", "()V", "fromTimeStamp", "Ljava/util/Date;", "value", "", "fromDate", "date", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class Converters {
    public final Date fromTimeStamp(long value) {
        return new Date(value);
    }

    public final long fromDate(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return date.getTime();
    }
}
