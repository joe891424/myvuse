package com.yoti.mobile.android.remote;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MimeTypeProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/MimeTypeProvider;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getFileExtension", "", "fileUri", "Landroid/net/Uri;", "getMimeType", "Lcom/yoti/mobile/android/remote/MimeType;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MimeTypeProvider {
    private final Context context;

    @Inject
    public MimeTypeProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final MimeType getMimeType(Uri fileUri) {
        Intrinsics.checkNotNullParameter(fileUri, "fileUri");
        return MimeType.INSTANCE.getMimeType(getFileExtension(fileUri));
    }

    public final String getFileExtension(Uri fileUri) {
        Intrinsics.checkNotNullParameter(fileUri, "fileUri");
        String scheme = fileUri.getScheme();
        if (scheme != null && scheme.hashCode() == 951530617 && scheme.equals("content")) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(this.context.getContentResolver().getType(fileUri));
        }
        return MimeTypeMap.getFileExtensionFromUrl(fileUri.toString());
    }
}
