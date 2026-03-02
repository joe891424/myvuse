package it.sephiroth.android.library.xtooltip;

import android.content.Context;
import android.graphics.Typeface;
import android.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: Typefaces.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0086\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lit/sephiroth/android/library/xtooltip/Typefaces;", "", "()V", "FONT_CACHE", "Landroid/util/LruCache;", "", "Landroid/graphics/Typeface;", "get", "c", "Landroid/content/Context;", "assetPath", "xtooltip_release"}, m5599k = 1, m5600mv = {1, 1, 13})
public final class Typefaces {
    public static final Typefaces INSTANCE = new Typefaces();
    private static final LruCache<String, Typeface> FONT_CACHE = new LruCache<>(4);

    private Typefaces() {
    }

    public final Typeface get(Context c, String assetPath) {
        Typeface typefaceCreateFromAsset;
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(assetPath, "assetPath");
        LruCache<String, Typeface> lruCache = FONT_CACHE;
        synchronized (lruCache) {
            typefaceCreateFromAsset = lruCache.get(assetPath);
            if (typefaceCreateFromAsset == null) {
                try {
                    typefaceCreateFromAsset = Typeface.createFromAsset(c.getAssets(), assetPath);
                    lruCache.put(assetPath, typefaceCreateFromAsset);
                } catch (Exception e) {
                    Timber.m5653e("Could not get typeface '" + assetPath + "' because " + e.getMessage(), new Object[0]);
                    return null;
                }
            }
        }
        return typefaceCreateFromAsset;
    }
}
