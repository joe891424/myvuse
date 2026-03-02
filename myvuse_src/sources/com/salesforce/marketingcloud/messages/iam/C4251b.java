package com.salesforce.marketingcloud.messages.iam;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.salesforce.marketingcloud.C4089R;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import java.util.List;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.b */
/* JADX INFO: loaded from: classes6.dex */
class C4251b extends AbstractC4253d {

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.b$a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f5226a;

        static {
            int[] iArr = new int[InAppMessage.Size.values().length];
            f5226a = iArr;
            try {
                iArr[InAppMessage.Size.f5216l.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5226a[InAppMessage.Size.f5217m.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5226a[InAppMessage.Size.f5218s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    C4251b(View.OnClickListener onClickListener, Typeface typeface) {
        super(onClickListener, typeface);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: a */
    protected void mo3709a(View view, String str) {
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: b */
    protected float mo3711b(Resources resources, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.f5218s;
        }
        int i = a.f5226a[size.ordinal()];
        return resources.getDimension(i != 1 ? i != 2 ? C4089R.dimen.mcsdk_iam_banner_btn_font_small : C4089R.dimen.mcsdk_iam_banner_btn_font_medium : C4089R.dimen.mcsdk_iam_banner_btn_font_large);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: c */
    protected int mo3716c() {
        return C4089R.id.mcsdk_iam_close;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: d */
    protected int mo3717d() {
        return C4089R.id.mcsdk_iam_media;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: e */
    protected int mo3718e() {
        return C4089R.id.mcsdk_iam_media;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: f */
    protected int mo3719f() {
        return C4089R.id.mcsdk_iam_container;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: g */
    protected int mo3720g() {
        return C4089R.id.mcsdk_iam_parent;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: h */
    protected int mo3721h() {
        return C4089R.id.mcsdk_iam_title;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: a */
    protected float mo3706a(Resources resources, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.f5218s;
        }
        int i = a.f5226a[size.ordinal()];
        return resources.getDimension(i != 1 ? i != 2 ? C4089R.dimen.mcsdk_iam_banner_body_font_small : C4089R.dimen.mcsdk_iam_banner_body_font_medium : C4089R.dimen.mcsdk_iam_banner_body_font_large);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: b */
    protected int mo3712b() {
        return C4089R.id.mcsdk_iam_buttons;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: c */
    protected float mo3715c(Resources resources, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.f5218s;
        }
        int i = a.f5226a[size.ordinal()];
        return resources.getDimension((i == 1 || i == 2) ? C4089R.dimen.mcsdk_iam_banner_title_font_large : C4089R.dimen.mcsdk_iam_banner_title_font_small);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: a */
    protected int mo3707a() {
        return C4089R.id.mcsdk_iam_body;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: b */
    protected float mo3710b(Resources resources) {
        return resources.getDimension(C4089R.dimen.mcsdk_button_group_horizontal_divider);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: c */
    protected float mo3714c(Resources resources) {
        return resources.getDimension(C4089R.dimen.mcsdk_button_group_vertical_divider);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: a */
    protected float mo3705a(Resources resources) {
        return resources.getDimension(C4089R.dimen.mcsdk_iam_banner_closebtn_hitbox_increase);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: b */
    protected void mo3713b(View view, C4260k c4260k) {
        ConstraintLayout constraintLayout;
        super.mo3713b(view, c4260k);
        InAppMessage inAppMessageM3771d = c4260k.m3771d();
        if (inAppMessageM3771d.closeButton() == null || AbstractC4253d.m3730a(inAppMessageM3771d.title()) || (constraintLayout = (ConstraintLayout) view.findViewById(mo3719f())) == null) {
            return;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(mo3707a(), 7, mo3716c(), 6);
        constraintSet.applyTo(constraintLayout);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: a */
    protected void mo3708a(View view, InAppMessage.ButtonConfig buttonConfig, List<InAppMessage.Button> list) {
        super.mo3708a(view, InAppMessage.ButtonConfig.twoUp, list);
    }
}
