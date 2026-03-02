package p000a.p001a.p002a.p003a.p014b.p023g;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: renamed from: a.a.a.a.b.g.b */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5598d2 = {"com/onetrust/otpublishers/headless/UI/extensions/StringKt$convertLinkToClickable$clickable$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "view", "Landroid/view/View;", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C0152b extends ClickableSpan {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Context f1118a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ URLSpan f1119b;

    public C0152b(Context context, URLSpan uRLSpan) {
        this.f1118a = context;
        this.f1119b = uRLSpan;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        C0048h.m304b(this.f1118a, this.f1119b.getURL());
    }
}
