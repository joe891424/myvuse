package okio;

import com.newrelic.agent.android.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: okio.-GzipSinkExtensions, reason: invalid class name */
/* JADX INFO: compiled from: GzipSink.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b¨\u0006\u0003"}, m5598d2 = {Constants.Network.Encoding.GZIP, "Lokio/GzipSink;", "Lokio/Sink;", "okio"}, m5599k = 2, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class GzipSinkExtensions {
    public static final GzipSink gzip(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "<this>");
        return new GzipSink(sink);
    }
}
