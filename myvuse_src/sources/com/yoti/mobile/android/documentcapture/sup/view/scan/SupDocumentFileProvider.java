package com.yoti.mobile.android.documentcapture.sup.view.scan;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Environment;
import androidx.core.content.FileProvider;
import com.yoti.mobile.android.commons.util.C4588L;
import com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecConstantsKt;
import java.io.File;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p099io.FilesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentFileProvider;", "Landroidx/core/content/FileProvider;", "()V", "attachInfo", "", "context", "Landroid/content/Context;", "info", "Landroid/content/pm/ProviderInfo;", "cleanUpFileDirectory", "createFile", "Ljava/io/File;", "kotlin.jvm.PlatformType", "createFileUri", "Landroid/net/Uri;", "isSupDocumentFileUri", "", "uri", "Companion", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentFileProvider extends FileProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static String authority;

    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentFileProvider$Companion;", "", "()V", "authority", "", "getAuthority$annotations", "getAuthority", "()Ljava/lang/String;", "setAuthority", "(Ljava/lang/String;)V", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getAuthority$annotations() {
        }

        public final String getAuthority() {
            String str = SupDocumentFileProvider.authority;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("authority");
            return null;
        }

        public final void setAuthority(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            SupDocumentFileProvider.authority = str;
        }
    }

    @Inject
    public SupDocumentFileProvider() {
    }

    private final File createFile(Context context) {
        return File.createTempFile("yds_supdoc_" + UUID.randomUUID(), FaceTecConstantsKt.IMAGE_FILE_EXTENSION, context.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        super.attachInfo(context, info);
        Companion companion = INSTANCE;
        String str = info.authority;
        Intrinsics.checkNotNullExpressionValue(str, "info.authority");
        companion.setAuthority(str);
    }

    public final void cleanUpFileDirectory(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            if (externalFilesDir == null || !externalFilesDir.exists()) {
                return;
            }
            FilesKt.deleteRecursively(externalFilesDir);
        } catch (SecurityException e) {
            C4588L.logError$default("SupDocumentFileProvider", "An error occurred when cleaning up the temp file directory: " + e, null, 4, null);
        }
    }

    public final Uri createFileUri(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uriForFile = FileProvider.getUriForFile(context, INSTANCE.getAuthority(), createFile(context));
        Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(\n         …createFile(context)\n    )");
        return uriForFile;
    }

    public final boolean isSupDocumentFileUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual(uri.getAuthority(), INSTANCE.getAuthority());
    }
}
