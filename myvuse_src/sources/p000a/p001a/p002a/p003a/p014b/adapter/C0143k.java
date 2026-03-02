package p000a.p001a.p002a.p003a.p014b.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONException;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0031z;
import p000a.p001a.p002a.p003a.p014b.DataModels.C0062e;
import p000a.p001a.p002a.p003a.p014b.InterfaceC0075c;
import p000a.p001a.p002a.p003a.p014b.fragment.C0166l;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p021e.C0129w;
import p000a.p001a.p002a.p003a.p014b.p021e.C0130x;

/* JADX INFO: renamed from: a.a.a.a.b.f.k */
/* JADX INFO: loaded from: classes.dex */
public class C0143k extends RecyclerView.Adapter<a> implements InterfaceC0075c {

    /* JADX INFO: renamed from: a */
    public String f1044a;

    /* JADX INFO: renamed from: b */
    public Context f1045b;

    /* JADX INFO: renamed from: c */
    public String f1046c;

    /* JADX INFO: renamed from: d */
    public String f1047d;

    /* JADX INFO: renamed from: e */
    public ArrayList<C0062e> f1048e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC0075c f1049f;

    /* JADX INFO: renamed from: g */
    public C0031z f1050g;

    /* JADX INFO: renamed from: h */
    public C0130x f1051h;

    /* JADX INFO: renamed from: i */
    public C0129w f1052i;

    /* JADX INFO: renamed from: j */
    public boolean f1053j;

    /* JADX INFO: renamed from: k */
    public OTConfiguration f1054k;

    /* JADX INFO: renamed from: l */
    public C0126t f1055l;

    /* JADX INFO: renamed from: a.a.a.a.b.f.k$a */
    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f1056a;

        /* JADX INFO: renamed from: b */
        public TextView f1057b;

        /* JADX INFO: renamed from: c */
        public LinearLayout f1058c;

        public a(View view) {
            super(view);
            this.f1057b = (TextView) view.findViewById(C3896R.id.item_title);
            this.f1056a = (TextView) view.findViewById(C3896R.id.item_status);
            this.f1058c = (LinearLayout) view.findViewById(C3896R.id.main_layout);
        }
    }

    public C0143k(Context context, ArrayList<C0062e> arrayList, String str, String str2, C0126t c0126t, String str3, InterfaceC0075c interfaceC0075c, C0031z c0031z, boolean z, OTConfiguration oTConfiguration) {
        this.f1045b = context;
        this.f1048e = arrayList;
        this.f1047d = str;
        this.f1046c = str2;
        this.f1044a = str3;
        this.f1055l = c0126t;
        this.f1049f = interfaceC0075c;
        this.f1050g = c0031z;
        this.f1053j = z;
        try {
            this.f1051h = new C0130x(context);
            this.f1052i = this.f1051h.m672a(this.f1050g, C0074f.m394a(this.f1045b, oTConfiguration));
        } catch (JSONException e) {
            OTLogger.m2748b("OneTrust", "error in parsing ucp data " + e.getMessage());
        }
        this.f1054k = oTConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m730a(C0166l c0166l, a aVar, View view) {
        if (c0166l.isAdded()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("TOPIC_PREF_ARRAY", this.f1048e);
        bundle.putString("ITEM_LABEL", this.f1047d);
        bundle.putString("ITEM_DESC", this.f1046c);
        bundle.putInt("ITEM_POSITION", aVar.getAdapterPosition());
        bundle.putString("DESC_TEXT_COLOR", this.f1044a);
        bundle.putString("TITLE_TEXT_COLOR", this.f1044a);
        bundle.putBoolean("PURPOSE_TOGGLE_STATE", this.f1053j);
        c0166l.setArguments(bundle);
        c0166l.f1385r = this.f1050g;
        c0166l.f1378k = this.f1049f;
        c0166l.show(((FragmentActivity) Objects.requireNonNull((FragmentActivity) this.f1045b)).getSupportFragmentManager(), OTFragmentTags.OT_CONSENT_PREF_FRAGMENT_TAG);
    }

    @Override // p000a.p001a.p002a.p003a.p014b.InterfaceC0075c
    /* JADX INFO: renamed from: a */
    public void mo419a(int i) {
        InterfaceC0075c interfaceC0075c = this.f1049f;
        if (interfaceC0075c != null) {
            interfaceC0075c.mo419a(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getTotalPages() {
        return this.f1048e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m731a((a) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_uc_purposes_item_list, viewGroup, false));
    }

    /* JADX INFO: renamed from: a */
    public void m731a(final a aVar) {
        C0062e c0062e = this.f1048e.get(aVar.getAdapterPosition());
        String str = this.f1055l.f849t.f724c;
        String str2 = this.f1044a;
        if (C0048h.m305b(str)) {
            str = str2;
        }
        TextView textView = aVar.f1057b;
        String str3 = c0062e.f171a;
        if (str3 != null) {
            textView.setText(str3);
        }
        if (str != null) {
            textView.setTextColor(Color.parseColor(str));
        }
        TextView textView2 = aVar.f1057b;
        C0106b0 c0106b0 = this.f1055l.f841l;
        if (!C0048h.m305b(c0106b0.f722a.f751b)) {
            textView2.setTextSize(Float.parseFloat(c0106b0.f722a.f751b));
        }
        TextView textView3 = aVar.f1056a;
        String str4 = this.f1052i.f873b;
        if (str4 != null) {
            textView3.setText(str4);
        }
        if (str != null) {
            textView3.setTextColor(Color.parseColor(str));
        }
        TextView textView4 = aVar.f1056a;
        C0106b0 c0106b02 = this.f1055l.f841l;
        if (!C0048h.m305b(c0106b02.f722a.f751b)) {
            textView4.setTextSize(Float.parseFloat(c0106b02.f722a.f751b));
        }
        String str5 = this.f1055l.f836g;
        String str6 = this.f1044a;
        if (C0048h.m305b(str5)) {
            str5 = str6;
        }
        if (str5 != null) {
            C0072d.m385a(aVar.f1056a, str5);
        }
        OTConfiguration oTConfiguration = this.f1054k;
        final C0166l c0166l = new C0166l();
        Bundle bundle = new Bundle();
        bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_CONSENT_PREF_FRAGMENT_TAG);
        c0166l.setArguments(bundle);
        c0166l.f1390w = oTConfiguration;
        aVar.f1058c.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.f.k$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m730a(c0166l, aVar, view);
            }
        });
    }
}
