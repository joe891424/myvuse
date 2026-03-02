package com.bat.sdk.presentation;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PresentationUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, m5598d2 = {"Lcom/bat/sdk/presentation/PresentationUtils;", "", "<init>", "()V", "extractFilename", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class PresentationUtils {
    public static final PresentationUtils INSTANCE = new PresentationUtils();

    private PresentationUtils() {
    }

    public final String extractFilename(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = contentResolver != null ? contentResolver.query(uri, null, null, null, null) : null;
        if (cursorQuery == null) {
            return null;
        }
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        cursorQuery.close();
        return string;
    }
}
