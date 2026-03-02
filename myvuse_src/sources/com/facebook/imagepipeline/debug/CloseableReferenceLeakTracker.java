package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* JADX INFO: compiled from: CloseableReferenceLeakTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\"\u0010\t\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u000f"}, m5598d2 = {"Lcom/facebook/imagepipeline/debug/CloseableReferenceLeakTracker;", "", "isSet", "", "()Z", "setListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/imagepipeline/debug/CloseableReferenceLeakTracker$Listener;", "trackCloseableReferenceLeak", "reference", "Lcom/facebook/common/references/SharedReference;", "stacktrace", "", "Listener", "imagepipeline_release"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
public interface CloseableReferenceLeakTracker {

    /* JADX INFO: compiled from: CloseableReferenceLeakTracker.kt */
    @Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, m5598d2 = {"Lcom/facebook/imagepipeline/debug/CloseableReferenceLeakTracker$Listener;", "", "onCloseableReferenceLeak", "", "reference", "Lcom/facebook/common/references/SharedReference;", "stacktrace", "", "imagepipeline_release"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
    public interface Listener {
        void onCloseableReferenceLeak(SharedReference<Object> reference, Throwable stacktrace);
    }

    boolean isSet();

    void setListener(Listener listener);

    void trackCloseableReferenceLeak(SharedReference<Object> reference, Throwable stacktrace);
}
