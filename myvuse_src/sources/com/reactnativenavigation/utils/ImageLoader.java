package com.reactnativenavigation.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.StrictMode;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.reactnativenavigation.C3967R;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ImageLoader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fH\u0002J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0002¨\u0006\u001e"}, m5598d2 = {"Lcom/reactnativenavigation/utils/ImageLoader;", "", "()V", "adjustThreadPolicyDebug", "Landroid/os/StrictMode$ThreadPolicy;", "context", "Landroid/content/Context;", "getBackButtonIcon", "Landroid/graphics/drawable/Drawable;", "Landroid/app/Activity;", "getDrawable", "source", "", "isLocalFile", "", "uri", "Landroid/net/Uri;", "loadFile", "loadIcon", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/reactnativenavigation/utils/ImageLoader$ImagesLoadingListener;", "loadIcons", "uris", "", "readJsDevImage", "restoreThreadPolicyDebug", "threadPolicy", "Companion", "ImagesLoadingListener", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class ImageLoader {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FILE_SCHEME = "file";

    /* JADX INFO: compiled from: ImageLoader.kt */
    @Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0006H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, m5598d2 = {"Lcom/reactnativenavigation/utils/ImageLoader$ImagesLoadingListener;", "", "onComplete", "", "drawable", "Landroid/graphics/drawable/Drawable;", "", "onError", "error", "", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public interface ImagesLoadingListener {
        void onComplete(Drawable drawable);

        void onComplete(List<? extends Drawable> drawable);

        void onError(Throwable error);
    }

    public Drawable getBackButtonIcon(Activity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View decorView = context.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        return ContextCompat.getDrawable(context, ViewExtensionsKt.isRTL(decorView) ? C3967R.drawable.ic_arrow_back_black_rtl_24dp : C3967R.drawable.ic_arrow_back_black_24dp);
    }

    public Drawable loadIcon(Context context, String uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uri == null) {
            return null;
        }
        try {
            return getDrawable(context, uri);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void loadIcon(Context context, String uri, ImagesLoadingListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            listener.onComplete(getDrawable(context, uri));
        } catch (IOException e) {
            listener.onError(e);
        }
    }

    public void loadIcons(Context context, List<String> uris, ImagesLoadingListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uris, "uris");
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it2 = uris.iterator();
            while (it2.hasNext()) {
                arrayList.add(getDrawable(context, it2.next()));
            }
            listener.onComplete(arrayList);
        } catch (IOException e) {
            listener.onError(e);
        }
    }

    private final Drawable getDrawable(Context context, String source) throws IOException {
        Drawable jsDevImage;
        Uri uri = Uri.parse(source);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        if (isLocalFile(uri)) {
            jsDevImage = loadFile(context, source);
        } else {
            Drawable drawableLoadResource = INSTANCE.loadResource(context, source);
            jsDevImage = (drawableLoadResource == null && ContextKt.isDebug(context)) ? readJsDevImage(context, source) : drawableLoadResource;
        }
        if (jsDevImage == null) {
            throw new RuntimeException("Could not load image " + source);
        }
        Drawable drawableMutate = jsDevImage.mutate();
        Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
        return drawableMutate;
    }

    private final Drawable readJsDevImage(Context context, String source) throws IOException {
        StrictMode.ThreadPolicy threadPolicyAdjustThreadPolicyDebug = adjustThreadPolicyDebug(context);
        Bitmap bitmapDecodeStream = BitmapFactoryInstrumentation.decodeStream(INSTANCE.openStream(context, source));
        restoreThreadPolicyDebug(context, threadPolicyAdjustThreadPolicyDebug);
        return new BitmapDrawable(context.getResources(), bitmapDecodeStream);
    }

    private final boolean isLocalFile(Uri uri) {
        return Intrinsics.areEqual("file", uri.getScheme());
    }

    private final Drawable loadFile(Context context, String uri) {
        return new BitmapDrawable(context.getResources(), BitmapFactoryInstrumentation.decodeFile(Uri.parse(uri).getPath()));
    }

    private final StrictMode.ThreadPolicy adjustThreadPolicyDebug(Context context) {
        if (!ContextKt.isDebug(context)) {
            return null;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        return threadPolicy;
    }

    private final void restoreThreadPolicyDebug(Context context, StrictMode.ThreadPolicy threadPolicy) {
        if (!ContextKt.isDebug(context) || threadPolicy == null) {
            return;
        }
        StrictMode.setThreadPolicy(threadPolicy);
    }

    /* JADX INFO: compiled from: ImageLoader.kt */
    @Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m5598d2 = {"Lcom/reactnativenavigation/utils/ImageLoader$Companion;", "", "()V", "FILE_SCHEME", "", "loadResource", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "iconSource", "localFile", "Ljava/io/InputStream;", "uri", "openStream", "remoteUrl", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Drawable loadResource(Context context, String iconSource) {
            return ResourceDrawableIdHelper.getInstance().getResourceDrawable(context, iconSource);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final InputStream openStream(Context context, String uri) throws IOException {
            return StringsKt.contains$default((CharSequence) uri, (CharSequence) "http", false, 2, (Object) null) ? remoteUrl(uri) : localFile(context, uri);
        }

        private final InputStream remoteUrl(String uri) throws IOException {
            InputStream inputStreamOpenStream = FirebasePerfUrlConnection.openStream(new URL(uri));
            Intrinsics.checkNotNullExpressionValue(inputStreamOpenStream, "openStream(...)");
            return inputStreamOpenStream;
        }

        private final InputStream localFile(Context context, String uri) throws FileNotFoundException {
            return context.getContentResolver().openInputStream(Uri.parse(uri));
        }
    }
}
