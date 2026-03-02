package com.yoti.mobile.android.remote;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.io.FileNotFoundException;
import java.io.InputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p099io.CloseableKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: InputStreamRequestBody.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u000eH\u0016J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/InputStreamRequestBody;", "Lokhttp3/RequestBody;", AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE, "Lokhttp3/MediaType;", "contentResolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "(Lokhttp3/MediaType;Landroid/content/ContentResolver;Landroid/net/Uri;)V", "getContentResolver", "()Landroid/content/ContentResolver;", "getContentType", "()Lokhttp3/MediaType;", "length", "", "getLength", "()J", "length$delegate", "Lkotlin/Lazy;", "getUri", "()Landroid/net/Uri;", "contentLength", "writeTo", "", "sink", "Lokio/BufferedSink;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class InputStreamRequestBody extends RequestBody {
    private final ContentResolver contentResolver;
    private final MediaType contentType;

    /* JADX INFO: renamed from: length$delegate, reason: from kotlin metadata */
    private final Lazy length;
    private final Uri uri;

    public final MediaType getContentType() {
        return this.contentType;
    }

    public final ContentResolver getContentResolver() {
        return this.contentResolver;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public InputStreamRequestBody(MediaType mediaType, ContentResolver contentResolver, Uri uri) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.contentType = mediaType;
        this.contentResolver = contentResolver;
        this.uri = uri;
        this.length = LazyKt.lazy(new Function0<Long>() { // from class: com.yoti.mobile.android.remote.InputStreamRequestBody$length$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() throws FileNotFoundException {
                long length;
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.this$0.getContentResolver().openAssetFileDescriptor(this.this$0.getUri(), RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME);
                if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                    AssetFileDescriptor assetFileDescriptor = assetFileDescriptorOpenAssetFileDescriptor;
                    try {
                        length = assetFileDescriptor.getLength();
                        CloseableKt.closeFinally(assetFileDescriptor, null);
                    } finally {
                    }
                } else {
                    length = -1;
                }
                return Long.valueOf(length);
            }
        });
    }

    private final long getLength() {
        return ((Number) this.length.getValue()).longValue();
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentType, reason: from getter */
    public MediaType getContentType() {
        return this.contentType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws FileNotFoundException {
        return getLength();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        InputStream inputStreamOpenInputStream = this.contentResolver.openInputStream(this.uri);
        if (inputStreamOpenInputStream != null) {
            InputStream inputStream = inputStreamOpenInputStream;
            try {
                Long.valueOf(sink.writeAll(Okio.source(inputStream)));
                CloseableKt.closeFinally(inputStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        }
    }
}
