package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes.dex */
public class HuaweiMediaStoreLocationValidationQuirk implements Quirk {
    public boolean canSaveToMediaStore() {
        return true;
    }

    static boolean load() {
        return "HUAWEI".equals(Build.BRAND.toUpperCase()) || "HONOR".equals(Build.BRAND.toUpperCase());
    }
}
