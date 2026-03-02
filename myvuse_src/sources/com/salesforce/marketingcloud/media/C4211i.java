package com.salesforce.marketingcloud.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.salesforce.marketingcloud.media.AbstractC4223u;
import com.salesforce.marketingcloud.media.C4217o;
import java.io.IOException;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.i */
/* JADX INFO: loaded from: classes6.dex */
class C4211i extends AbstractC4223u {

    /* JADX INFO: renamed from: c */
    private static final String f5054c = "drawable";

    /* JADX INFO: renamed from: a */
    private final Context f5055a;

    /* JADX INFO: renamed from: b */
    private int f5056b;

    C4211i(Context context) {
        this.f5055a = context;
    }

    @Override // com.salesforce.marketingcloud.media.AbstractC4223u
    /* JADX INFO: renamed from: a */
    public boolean mo3539a(C4221s c4221s) {
        if (f5054c.equalsIgnoreCase(c4221s.f5107a.getScheme())) {
            this.f5056b = this.f5055a.getResources().getIdentifier(c4221s.f5107a.getHost(), f5054c, this.f5055a.getPackageName());
        }
        return this.f5056b > 0;
    }

    @Override // com.salesforce.marketingcloud.media.AbstractC4223u
    /* JADX INFO: renamed from: a */
    public void mo3538a(C4217o c4217o, C4221s c4221s, AbstractC4223u.a aVar) throws IOException {
        Drawable drawable = ContextCompat.getDrawable(this.f5055a, this.f5056b);
        if (drawable == null) {
            aVar.mo3561a(new IllegalStateException("Invalid res id for drawable"));
        } else {
            aVar.mo3560a(new AbstractC4223u.b(drawable, C4217o.b.MEMORY));
        }
    }
}
