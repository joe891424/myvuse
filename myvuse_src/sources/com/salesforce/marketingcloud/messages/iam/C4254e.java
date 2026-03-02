package com.salesforce.marketingcloud.messages.iam;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import com.salesforce.marketingcloud.C4089R;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.e */
/* JADX INFO: loaded from: classes6.dex */
class C4254e extends AbstractC4253d {

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.e$a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f5238a;

        static {
            int[] iArr = new int[InAppMessage.Size.values().length];
            f5238a = iArr;
            try {
                iArr[InAppMessage.Size.f5216l.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5238a[InAppMessage.Size.f5217m.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5238a[InAppMessage.Size.f5218s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    C4254e(View.OnClickListener onClickListener, Typeface typeface) {
        super(onClickListener, typeface);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: a */
    protected void mo3709a(View view, String str) {
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: a */
    protected void mo3736a(View view, String str, String str2, InAppMessage.Size size, InAppMessage.Size size2) {
        View viewFindViewById = view.findViewById(mo3719f());
        if (str == null || viewFindViewById == null) {
            return;
        }
        viewFindViewById.setBackgroundColor(C4256g.m3747a(view.getContext(), str, C4089R.color.mcsdk_iam_default_message_background));
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: b */
    protected float mo3711b(Resources resources, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.f5218s;
        }
        int i = a.f5238a[size.ordinal()];
        return resources.getDimension(i != 1 ? i != 2 ? C4089R.dimen.mcsdk_iam_fs_btn_font_small : C4089R.dimen.mcsdk_iam_fs_btn_font_medium : C4089R.dimen.mcsdk_iam_fs_btn_font_large);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: c */
    protected int mo3716c() {
        return C4089R.id.mcsdk_iam_close;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: d */
    protected int mo3717d() {
        return C4089R.id.mcsdk_iam_media_group;
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
        return 0;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: h */
    protected int mo3721h() {
        return C4089R.id.mcsdk_iam_title;
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
        int i = a.f5238a[size.ordinal()];
        return resources.getDimension((i == 1 || i == 2) ? C4089R.dimen.mcsdk_iam_fs_title_font_large : C4089R.dimen.mcsdk_iam_fs_title_font_small);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: a */
    protected float mo3706a(Resources resources, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.f5218s;
        }
        int i = a.f5238a[size.ordinal()];
        return resources.getDimension(i != 1 ? i != 2 ? C4089R.dimen.mcsdk_iam_fs_body_font_small : C4089R.dimen.mcsdk_iam_fs_body_font_medium : C4089R.dimen.mcsdk_iam_fs_body_font_large);
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
    protected int mo3707a() {
        return C4089R.id.mcsdk_iam_body;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.AbstractC4253d
    /* JADX INFO: renamed from: a */
    protected float mo3705a(Resources resources) {
        return resources.getDimension(C4089R.dimen.mcsdk_iam_fs_closebtn_hitbox_increase);
    }
}
