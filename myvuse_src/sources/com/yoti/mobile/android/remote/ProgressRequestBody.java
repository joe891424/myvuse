package com.yoti.mobile.android.remote;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* JADX INFO: compiled from: ProgressRequestBody.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015BI\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012:\u0010\u0003\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u0005H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000RE\u0010\u0003\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/ProgressRequestBody;", "Lokhttp3/RequestBody;", "delegate", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "bytesWritten", "totalBytes", "", "Lcom/yoti/mobile/android/remote/ProgressRequestBodyListener;", "(Lokhttp3/RequestBody;Lkotlin/jvm/functions/Function2;)V", "getListener", "()Lkotlin/jvm/functions/Function2;", "contentLength", AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE, "Lokhttp3/MediaType;", "writeTo", "sink", "Lokio/BufferedSink;", "CountingSink", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ProgressRequestBody extends RequestBody {
    private final RequestBody delegate;
    private final Function2<Long, Long, Unit> listener;

    public final Function2<Long, Long, Unit> getListener() {
        return this.listener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProgressRequestBody(RequestBody delegate, Function2<? super Long, ? super Long, Unit> listener) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.delegate = delegate;
        this.listener = listener;
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentType */
    public MediaType getContentType() {
        return this.delegate.getContentType();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.delegate.contentLength();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(sink instanceof Buffer)) {
            sink = Okio.buffer(new CountingSink(this, sink));
        }
        this.delegate.writeTo(sink);
        sink.flush();
    }

    /* JADX INFO: compiled from: ProgressRequestBody.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/ProgressRequestBody$CountingSink;", "Lokio/ForwardingSink;", "delegate", "Lokio/Sink;", "(Lcom/yoti/mobile/android/remote/ProgressRequestBody;Lokio/Sink;)V", "bytesWritten", "", "write", "", "source", "Lokio/Buffer;", "byteCount", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public final class CountingSink extends ForwardingSink {
        private long bytesWritten;
        final /* synthetic */ ProgressRequestBody this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CountingSink(ProgressRequestBody progressRequestBody, Sink delegate) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.this$0 = progressRequestBody;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer source, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            super.write(source, byteCount);
            this.bytesWritten += byteCount;
            this.this$0.getListener().invoke(Long.valueOf(this.bytesWritten), Long.valueOf(this.this$0.contentLength()));
        }
    }
}
