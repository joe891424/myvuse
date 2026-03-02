package com.yoti.mobile.mpp.mrtddump;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/MrtdCombinedAuthErrorsException;", "Lcom/yoti/mobile/mpp/mrtddump/MrtdAuthException;", "errors", "", "Lcom/yoti/mobile/mpp/mrtddump/MrtdException;", "(Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "toString", "", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdCombinedAuthErrorsException extends MrtdAuthException {
    private final List<MrtdException> errors;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MrtdCombinedAuthErrorsException(List<? extends MrtdException> errors) {
        super(null, null, 3, null);
        Intrinsics.checkNotNullParameter(errors, "errors");
        this.errors = errors;
    }

    public final List<MrtdException> getErrors() {
        return this.errors;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder("Multiple exceptions occurred:");
        Iterator<T> it2 = this.errors.iterator();
        while (it2.hasNext()) {
            sb.append("\t" + ((MrtdException) it2.next()) + ',');
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }
}
