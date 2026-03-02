package com.yoti.mobile.android.yotidocs.common.file;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p099io.CloseableKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/file/AssetToFileConverter;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dumpAssetIntoFile", "", "assetName", "", "file", "Ljava/io/File;", "getFile", "overrideIfExist", "", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AssetToFileConverter {

    /* JADX INFO: renamed from: a */
    private final Context f7507a;

    @Inject
    public AssetToFileConverter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f7507a = context;
    }

    /* JADX INFO: renamed from: a */
    private final void m5090a(String str, File file) throws IOException {
        FileOutputStream fileOutputStream;
        InputStream inputStreamOpen = this.f7507a.getAssets().open(str);
        try {
            fileOutputStream = new FileOutputStream(file);
        } finally {
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i == -1) {
                    fileOutputStream.flush();
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(inputStreamOpen, null);
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } finally {
        }
    }

    public static /* synthetic */ File getFile$default(AssetToFileConverter assetToFileConverter, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return assetToFileConverter.getFile(str, z);
    }

    public final File getFile(String assetName, boolean overrideIfExist) throws IOException {
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        File file = new File(this.f7507a.getCacheDir(), assetName);
        if (!file.exists() || overrideIfExist) {
            m5090a(assetName, file);
        }
        return file;
    }
}
