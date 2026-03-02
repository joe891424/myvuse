package com.yoti.mobile.android.remote;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.squareup.wire.Message;
import java.io.File;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: MultipartFormDataFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JP\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2@\b\u0002\u0010\u000b\u001a:\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\u0004\u0018\u0001`\u0013JX\u0010\u0007\u001a\u00020\b2\u000e\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00152@\b\u0002\u0010\u000b\u001a:\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\u0004\u0018\u0001`\u0013JP\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172@\b\u0002\u0010\u000b\u001a:\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\u0004\u0018\u0001`\u0013JZ\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u000f\u001a\u00020\u00192@\b\u0002\u0010\u001a\u001a:\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\u0004\u0018\u0001`\u0013J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\nH\u0002JX\u0010 \u001a\u00020\b*\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00192@\b\u0002\u0010\u001a\u001a:\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\u0004\u0018\u0001`\u0013H\u0002JL\u0010#\u001a\u00020!*\u00020!2>\u0010\u001a\u001a:\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\u0004\u0018\u0001`\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/MultiPartBodyFactory;", "", "context", "Landroid/content/Context;", "mimeTypeProvider", "Lcom/yoti/mobile/android/remote/MimeTypeProvider;", "(Landroid/content/Context;Lcom/yoti/mobile/android/remote/MimeTypeProvider;)V", "create", "Lokhttp3/MultipartBody$Part;", "uri", "Landroid/net/Uri;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "bytesWritten", "totalBytes", "", "Lcom/yoti/mobile/android/remote/ProgressRequestBodyListener;", "message", "Lcom/squareup/wire/Message;", "file", "Ljava/io/File;", "json", "", "progressListener", "getMediaType", "Lokhttp3/MediaType;", "fileUri", "getMimeType", "Lcom/yoti/mobile/android/remote/MimeType;", "multipartBinaryContent", "Lokhttp3/RequestBody;", "fileName", "transformToProgressRequestBody", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MultiPartBodyFactory {
    private final Context context;
    private final MimeTypeProvider mimeTypeProvider;

    @Inject
    public MultiPartBodyFactory(Context context, MimeTypeProvider mimeTypeProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mimeTypeProvider, "mimeTypeProvider");
        this.context = context;
        this.mimeTypeProvider = mimeTypeProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultipartBody.Part create$default(MultiPartBodyFactory multiPartBodyFactory, File file, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        return multiPartBodyFactory.create(file, (Function2<? super Long, ? super Long, Unit>) function2);
    }

    public final MultipartBody.Part create(File file, Function2<? super Long, ? super Long, Unit> listener) {
        Intrinsics.checkNotNullParameter(file, "file");
        RequestBody.Companion companion = RequestBody.INSTANCE;
        Uri uriFromFile = Uri.fromFile(file);
        Intrinsics.checkNotNullExpressionValue(uriFromFile, "fromFile(file)");
        RequestBody requestBodyCreate = companion.create(file, getMediaType(uriFromFile));
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        return multipartBinaryContent(requestBodyCreate, name, listener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultipartBody.Part create$default(MultiPartBodyFactory multiPartBodyFactory, Uri uri, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        return multiPartBodyFactory.create(uri, (Function2<? super Long, ? super Long, Unit>) function2);
    }

    public final MultipartBody.Part create(Uri uri, Function2<? super Long, ? super Long, Unit> listener) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        MediaType mediaType = getMediaType(uri);
        ContentResolver contentResolver = this.context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        return multipartBinaryContent$default(this, new InputStreamRequestBody(mediaType, contentResolver, uri), null, listener, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultipartBody.Part create$default(MultiPartBodyFactory multiPartBodyFactory, Message message, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        return multiPartBodyFactory.create((Message<?, ?>) message, (Function2<? super Long, ? super Long, Unit>) function2);
    }

    public final MultipartBody.Part create(Message<?, ?> message, Function2<? super Long, ? super Long, Unit> listener) {
        Intrinsics.checkNotNullParameter(message, "message");
        return multipartBinaryContent$default(this, RequestBody.Companion.create$default(RequestBody.INSTANCE, message.encode(), MediaType.INSTANCE.parse(MimeType.UNKNOWN.getMediaType()), 0, 0, 6, (Object) null), null, listener, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultipartBody.Part create$default(MultiPartBodyFactory multiPartBodyFactory, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "descriptor";
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        return multiPartBodyFactory.create(str, str2, function2);
    }

    public final MultipartBody.Part create(String json, String name, Function2<? super Long, ? super Long, Unit> progressListener) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        return MultipartBody.Part.INSTANCE.createFormData(name, null, transformToProgressRequestBody(RequestBody.INSTANCE.create(json, MediaType.INSTANCE.parse(MimeType.JSON.getMediaType())), progressListener));
    }

    private final MediaType getMediaType(Uri fileUri) {
        return MediaType.INSTANCE.parse(getMimeType(fileUri).getMediaType());
    }

    private final MimeType getMimeType(Uri fileUri) {
        return this.mimeTypeProvider.getMimeType(fileUri);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ MultipartBody.Part multipartBinaryContent$default(MultiPartBodyFactory multiPartBodyFactory, RequestBody requestBody, String str, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        return multiPartBodyFactory.multipartBinaryContent(requestBody, str, function2);
    }

    private final MultipartBody.Part multipartBinaryContent(RequestBody requestBody, String str, Function2<? super Long, ? super Long, Unit> function2) {
        return MultipartBody.Part.INSTANCE.createFormData("binary-content", str, transformToProgressRequestBody(requestBody, function2));
    }

    private final RequestBody transformToProgressRequestBody(RequestBody requestBody, Function2<? super Long, ? super Long, Unit> function2) {
        return function2 != null ? new ProgressRequestBody(requestBody, function2) : requestBody;
    }
}
