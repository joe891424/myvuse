package com.salesforce.marketingcloud.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.salesforce.marketingcloud.media.AbstractC4223u;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.l */
/* JADX INFO: loaded from: classes6.dex */
public final class C4214l extends BitmapDrawable {
    public C4214l(Context context, Bitmap bitmap) {
        super(context.getResources(), bitmap);
    }

    /* JADX INFO: renamed from: a */
    static void m3540a(ImageView imageView, Context context, AbstractC4223u.b bVar) {
        if (bVar.m3622d()) {
            imageView.setImageDrawable(new C4214l(context, bVar.m3619a()));
        } else if (bVar.m3623e()) {
            imageView.setImageDrawable(bVar.m3620b());
        }
    }
}
