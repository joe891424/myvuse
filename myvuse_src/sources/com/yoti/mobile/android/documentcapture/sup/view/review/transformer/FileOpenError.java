package com.yoti.mobile.android.documentcapture.sup.view.review.transformer;

import com.newrelic.agent.android.agentdata.HexAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/FileOpenError;", "", HexAttribute.HEX_ATTR_CAUSE, "", "(Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class FileOpenError {
    private final Throwable cause;

    public FileOpenError(Throwable cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        this.cause = cause;
    }

    public static /* synthetic */ FileOpenError copy$default(FileOpenError fileOpenError, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = fileOpenError.cause;
        }
        return fileOpenError.copy(th);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Throwable getCause() {
        return this.cause;
    }

    public final FileOpenError copy(Throwable cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        return new FileOpenError(cause);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FileOpenError) && Intrinsics.areEqual(this.cause, ((FileOpenError) other).cause);
    }

    public final Throwable getCause() {
        return this.cause;
    }

    public int hashCode() {
        return this.cause.hashCode();
    }

    public String toString() {
        return "FileOpenError(cause=" + this.cause + ')';
    }
}
