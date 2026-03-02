package p000a.p001a.p002a.p003a.p014b.p023g;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: renamed from: a.a.a.a.b.g.a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J:\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, m5598d2 = {"com/onetrust/otpublishers/headless/UI/extensions/ImageViewKt$loadImage$requestListener$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C0151a implements RequestListener<Drawable> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f1116a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f1117b;

    public C0151a(String str, String str2) {
        this.f1116a = str;
        this.f1117b = str2;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(target, "target");
        OTLogger.m2743a(3, this.f1116a, "Logo shown for Banner failed for url " + this.f1117b);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(Drawable drawable, Object model, Target<Drawable> target, DataSource dataSource, boolean z) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        OTLogger.m2743a(3, this.f1116a, "Logo shown for Banner for url " + this.f1117b);
        return false;
    }
}
