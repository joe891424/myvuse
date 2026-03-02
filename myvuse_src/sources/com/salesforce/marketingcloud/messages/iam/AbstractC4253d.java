package com.salesforce.marketingcloud.messages.iam;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.salesforce.marketingcloud.C4089R;
import com.salesforce.marketingcloud.internal.C4178a;
import com.salesforce.marketingcloud.media.C4217o;
import com.salesforce.marketingcloud.media.C4222t;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.d */
/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractC4253d {

    /* JADX INFO: renamed from: a */
    private final View.OnClickListener f5230a;

    /* JADX INFO: renamed from: b */
    private final Typeface f5231b;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.d$a */
    class a implements Comparator<InAppMessage.Button> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(InAppMessage.Button button, InAppMessage.Button button2) {
            return button.index() - button2.index();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.d$b */
    class b implements Runnable {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ View f5233a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f5234b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ View f5235c;

        b(View view, int i, View view2) {
            this.f5233a = view;
            this.f5234b = i;
            this.f5235c = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            this.f5233a.getHitRect(rect);
            int i = rect.top;
            int i2 = this.f5234b;
            rect.top = i - i2;
            rect.left -= i2;
            rect.bottom += i2;
            rect.right += i2;
            this.f5235c.setTouchDelegate(new TouchDelegate(rect, this.f5233a));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.d$c */
    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f5237a;

        static {
            int[] iArr = new int[InAppMessage.Size.values().length];
            f5237a = iArr;
            try {
                iArr[InAppMessage.Size.f5216l.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5237a[InAppMessage.Size.f5217m.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5237a[InAppMessage.Size.f5218s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    AbstractC4253d(View.OnClickListener onClickListener, Typeface typeface) {
        this.f5230a = onClickListener;
        this.f5231b = typeface;
    }

    /* JADX INFO: renamed from: a */
    private void m3729a(ViewGroup viewGroup) {
        Space space = new Space(viewGroup.getContext());
        space.setLayoutParams(new LinearLayout.LayoutParams(Math.round(mo3710b(viewGroup.getResources())), -1));
        viewGroup.addView(space);
    }

    /* JADX INFO: renamed from: b */
    private void m3734b(ViewGroup viewGroup) {
        Space space = new Space(viewGroup.getContext());
        space.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(mo3714c(viewGroup.getResources()))));
        viewGroup.addView(space);
    }

    /* JADX INFO: renamed from: a */
    protected abstract float mo3705a(Resources resources);

    /* JADX INFO: renamed from: a */
    protected abstract float mo3706a(Resources resources, InAppMessage.Size size);

    /* JADX INFO: renamed from: a */
    protected abstract int mo3707a();

    /* JADX INFO: renamed from: b */
    protected abstract float mo3710b(Resources resources);

    /* JADX INFO: renamed from: b */
    protected abstract float mo3711b(Resources resources, InAppMessage.Size size);

    /* JADX INFO: renamed from: b */
    protected abstract int mo3712b();

    /* JADX INFO: renamed from: b */
    protected void mo3713b(View view, C4260k c4260k) {
    }

    /* JADX INFO: renamed from: c */
    protected abstract float mo3714c(Resources resources);

    /* JADX INFO: renamed from: c */
    protected abstract float mo3715c(Resources resources, InAppMessage.Size size);

    /* JADX INFO: renamed from: c */
    protected abstract int mo3716c();

    /* JADX INFO: renamed from: d */
    protected abstract int mo3717d();

    /* JADX INFO: renamed from: e */
    protected abstract int mo3718e();

    /* JADX INFO: renamed from: f */
    protected abstract int mo3719f();

    /* JADX INFO: renamed from: g */
    protected abstract int mo3720g();

    /* JADX INFO: renamed from: h */
    protected abstract int mo3721h();

    /* JADX INFO: renamed from: a */
    private void m3728a(View view, InAppMessage.TextField textField) {
        TextView textView = (TextView) view.findViewById(mo3707a());
        if (textView == null) {
            return;
        }
        if (!m3730a(textField)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        Typeface typeface = this.f5231b;
        if (typeface != null) {
            textView.setTypeface(typeface, 0);
        }
        C4256g.m3750a(textView, textField.text(), C4256g.m3747a(view.getContext(), textField.fontColor(), C4089R.color.mcsdk_iam_default_font_color), mo3706a(view.getContext().getResources(), textField.fontSize()), C4256g.m3748a(textField.alignment()));
    }

    /* JADX INFO: renamed from: b */
    private void m3733b(View view, InAppMessage.TextField textField) {
        TextView textView = (TextView) view.findViewById(mo3721h());
        if (textView == null) {
            return;
        }
        if (!m3730a(textField)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        Typeface typeface = this.f5231b;
        if (typeface != null) {
            textView.setTypeface(typeface, 1);
        }
        C4256g.m3750a(textView, textField.text(), C4256g.m3747a(view.getContext(), textField.fontColor(), C4089R.color.mcsdk_iam_default_font_color), mo3715c(view.getContext().getResources(), textField.fontSize()), C4256g.m3748a(textField.alignment()));
    }

    /* JADX INFO: renamed from: a */
    private void m3725a(View view) {
        if (view == null) {
            return;
        }
        View view2 = (View) view.getParent();
        view2.post(new b(view, Math.round(mo3705a(view.getContext().getResources())), view2));
    }

    /* JADX INFO: renamed from: b */
    private float m3732b(Context context, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.f5218s;
        }
        Resources resources = context.getResources();
        int i = c.f5237a[size.ordinal()];
        return resources.getDimension(i != 1 ? i != 2 ? C4089R.dimen.mcsdk_corner_radius_small : C4089R.dimen.mcsdk_corner_radius_medium : C4089R.dimen.mcsdk_corner_radius_large);
    }

    /* JADX INFO: renamed from: a */
    private void m3726a(View view, C4217o c4217o, InAppMessage.Media media, InAppMessage.Type type) {
        ImageView imageView = (ImageView) view.findViewById(mo3718e());
        if (imageView == null) {
            return;
        }
        Context context = view.getContext();
        if (media == null) {
            View viewFindViewById = view.findViewById(mo3717d());
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
                return;
            } else {
                imageView.setVisibility(8);
                return;
            }
        }
        if (c4217o != null) {
            imageView.setVisibility(0);
            C4222t c4222tM3613d = c4217o.m3574b(media.url()).m3613d();
            if (type == InAppMessage.Type.fullImageFill) {
                c4222tM3613d.m3611b();
            } else {
                c4222tM3613d.m3603a();
            }
            c4222tM3613d.m3604a(m3732b(context, media.cornerRadius()), m3724a(context, media.borderWidth()), C4256g.m3747a(context, media.borderColor(), C4089R.color.mcsdk_iam_default_border)).m3608a(imageView);
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo3736a(View view, String str, String str2, InAppMessage.Size size, InAppMessage.Size size2) {
        View viewFindViewById = view.findViewById(mo3719f());
        if (viewFindViewById == null) {
            return;
        }
        Context context = view.getContext();
        float fM3732b = m3732b(context, size2);
        float fM3724a = m3724a(context, size);
        ViewCompat.setBackground(viewFindViewById, C4256g.m3749a(C4256g.m3747a(context, str, C4089R.color.mcsdk_iam_default_message_background), fM3732b, C4256g.m3747a(context, str2, C4089R.color.mcsdk_iam_default_border), fM3724a));
        if (viewFindViewById instanceof ClippingConstraintLayout) {
            ((ClippingConstraintLayout) viewFindViewById).setClippingDetails(fM3724a, fM3732b);
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo3709a(View view, String str) {
        View viewFindViewById = view.findViewById(mo3720g());
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setBackgroundColor(C4256g.m3747a(view.getContext(), str, C4089R.color.mcsdk_iam_default_window_background));
    }

    /* JADX INFO: renamed from: a */
    private float m3724a(Context context, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.f5218s;
        }
        Resources resources = context.getResources();
        int i = c.f5237a[size.ordinal()];
        return resources.getDimension(i != 1 ? i != 2 ? C4089R.dimen.mcsdk_border_width_small : C4089R.dimen.mcsdk_border_width_medium : C4089R.dimen.mcsdk_border_width_large);
    }

    /* JADX INFO: renamed from: a */
    void m3735a(View view, C4260k c4260k) {
        if (c4260k == null || view == null) {
            return;
        }
        InAppMessage inAppMessageM3771d = c4260k.m3771d();
        mo3709a(view, inAppMessageM3771d.windowColor());
        mo3736a(view, inAppMessageM3771d.backgroundColor(), inAppMessageM3771d.borderColor(), inAppMessageM3771d.borderWidth(), inAppMessageM3771d.cornerRadius());
        m3733b(view, inAppMessageM3771d.title());
        m3728a(view, inAppMessageM3771d.body());
        m3727a(view, m3731a(inAppMessageM3771d) ? inAppMessageM3771d.closeButton() : C4178a.m3324a());
        List<InAppMessage.Button> listButtons = inAppMessageM3771d.buttons();
        if (listButtons == null || listButtons.isEmpty()) {
            View viewFindViewById = view.findViewById(mo3712b());
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
        } else {
            ArrayList arrayList = new ArrayList(listButtons);
            Collections.sort(arrayList, new a());
            mo3708a(view, inAppMessageM3771d.buttonConfiguration(), arrayList);
        }
        m3726a(view, c4260k.m3772e(), inAppMessageM3771d.media(), inAppMessageM3771d.type());
        mo3713b(view, c4260k);
    }

    /* JADX INFO: renamed from: a */
    private void m3727a(View view, InAppMessage.CloseButton closeButton) {
        ImageButton imageButton = (ImageButton) view.findViewById(mo3716c());
        if (imageButton == null) {
            return;
        }
        if (closeButton == null) {
            imageButton.setVisibility(8);
            return;
        }
        ViewCompat.setTranslationZ(imageButton, 1.0f);
        imageButton.setVisibility(0);
        imageButton.setTag(closeButton);
        imageButton.setOnClickListener(this.f5230a);
        m3725a(imageButton);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX INFO: renamed from: a */
    protected void mo3708a(View view, InAppMessage.ButtonConfig buttonConfig, List<InAppMessage.Button> list) {
        int i;
        Context context = view.getContext();
        LinearLayout linearLayout = (LinearLayout) view.findViewById(mo3712b());
        ?? r6 = 0;
        if (buttonConfig == InAppMessage.ButtonConfig.stacked) {
            linearLayout.setOrientation(1);
            i = C4089R.layout.mcsdk_iam_stacked_button;
        } else {
            linearLayout.setOrientation(0);
            i = C4089R.layout.mcsdk_iam_sbs_button;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        int size = list.size();
        int i2 = 0;
        while (i2 < 2 && i2 < size) {
            InAppMessage.Button button = list.get(i2);
            Button button2 = (Button) layoutInflaterFrom.inflate(i, linearLayout, (boolean) r6);
            Typeface typeface = this.f5231b;
            if (typeface != null) {
                button2.setTypeface(typeface, r6);
            }
            C4256g.m3750a(button2, button.text(), C4256g.m3747a(context, button.fontColor(), C4089R.color.mcsdk_iam_default_font_color), mo3711b(context.getResources(), button.fontSize()), C4256g.m3748a(InAppMessage.Alignment.center));
            ViewCompat.setBackground(button2, C4256g.m3749a(C4256g.m3747a(context, button.backgroundColor(), C4089R.color.mcsdk_iam_default_btn_background), m3732b(context, button.cornerRadius()), C4256g.m3747a(context, button.borderColor(), C4089R.color.mcsdk_iam_default_border), m3724a(context, button.borderWidth())));
            button2.setTag(button);
            button2.setOnClickListener(this.f5230a);
            linearLayout.addView(button2);
            if (i2 == 0 && size > 1) {
                if (buttonConfig == InAppMessage.ButtonConfig.stacked) {
                    m3734b(linearLayout);
                } else {
                    m3729a((ViewGroup) linearLayout);
                }
            }
            i2++;
            r6 = 0;
        }
    }

    /* JADX INFO: renamed from: a */
    static boolean m3731a(InAppMessage inAppMessage) {
        return ((inAppMessage.type() == InAppMessage.Type.full || inAppMessage.type() == InAppMessage.Type.modal) && inAppMessage.closeButton() == null && (inAppMessage.buttons() == null || inAppMessage.buttons().isEmpty())) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    static boolean m3730a(InAppMessage.TextField textField) {
        return (textField == null || TextUtils.isEmpty(textField.text())) ? false : true;
    }
}
