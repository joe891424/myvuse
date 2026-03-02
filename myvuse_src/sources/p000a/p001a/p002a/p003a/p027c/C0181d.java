package p000a.p001a.p002a.p003a.p027c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import com.onetrust.otpublishers.headless.C3896R;

/* JADX INFO: renamed from: a.a.a.a.c.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0181d implements ViewBinding {

    /* JADX INFO: renamed from: a */
    public final RelativeLayout f1613a;

    /* JADX INFO: renamed from: b */
    public final ImageView f1614b;

    /* JADX INFO: renamed from: c */
    public final SwitchCompat f1615c;

    /* JADX INFO: renamed from: d */
    public final TextView f1616d;

    /* JADX INFO: renamed from: e */
    public final View f1617e;

    /* JADX INFO: renamed from: f */
    public final TextView f1618f;

    /* JADX INFO: renamed from: g */
    public final RelativeLayout f1619g;

    public C0181d(RelativeLayout relativeLayout, ImageView imageView, SwitchCompat switchCompat, TextView textView, View view, TextView textView2, RelativeLayout relativeLayout2) {
        this.f1613a = relativeLayout;
        this.f1614b = imageView;
        this.f1615c = switchCompat;
        this.f1616d = textView;
        this.f1617e = view;
        this.f1618f = textView2;
        this.f1619g = relativeLayout2;
    }

    /* JADX INFO: renamed from: a */
    public static C0181d m1024a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewFindViewById;
        View viewInflate = layoutInflater.inflate(C3896R.layout.ot_google_vendor_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        int i = C3896R.id.gv_show_more;
        ImageView imageView = (ImageView) viewInflate.findViewById(i);
        if (imageView != null) {
            i = C3896R.id.switchButton;
            SwitchCompat switchCompat = (SwitchCompat) viewInflate.findViewById(i);
            if (switchCompat != null) {
                i = C3896R.id.vendor_name;
                TextView textView = (TextView) viewInflate.findViewById(i);
                if (textView != null && (viewFindViewById = viewInflate.findViewById((i = C3896R.id.view3))) != null) {
                    i = C3896R.id.view_powered_by_logo;
                    TextView textView2 = (TextView) viewInflate.findViewById(i);
                    if (textView2 != null) {
                        i = C3896R.id.vl_items;
                        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(i);
                        if (relativeLayout != null) {
                            return new C0181d((RelativeLayout) viewInflate, imageView, switchCompat, textView, viewFindViewById, textView2, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public RelativeLayout m1025a() {
        return this.f1613a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f1613a;
    }
}
