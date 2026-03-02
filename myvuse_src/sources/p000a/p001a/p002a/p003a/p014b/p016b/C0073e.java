package p000a.p001a.p002a.p003a.p014b.p016b;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: renamed from: a.a.a.a.b.b.e */
/* JADX INFO: loaded from: classes.dex */
public class C0073e extends ClickableSpan {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Context f235a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ URLSpan f236b;

    public C0073e(C0074f c0074f, Context context, URLSpan uRLSpan) {
        this.f235a = context;
        this.f236b = uRLSpan;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        C0048h.m304b(this.f235a, this.f236b.getURL());
    }
}
