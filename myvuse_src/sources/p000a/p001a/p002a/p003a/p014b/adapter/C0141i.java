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
import p000a.p001a.p002a.p003a.p014b.DataModels.C0059b;
import p000a.p001a.p002a.p003a.p014b.InterfaceC0075c;
import p000a.p001a.p002a.p003a.p014b.fragment.C0166l;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p021e.C0129w;
import p000a.p001a.p002a.p003a.p014b.p021e.C0130x;

/* JADX INFO: renamed from: a.a.a.a.b.f.i */
/* JADX INFO: loaded from: classes.dex */
public class C0141i extends RecyclerView.Adapter<a> implements InterfaceC0075c {

    /* JADX INFO: renamed from: a */
    public final InterfaceC0075c f1018a;

    /* JADX INFO: renamed from: b */
    public String f1019b;

    /* JADX INFO: renamed from: c */
    public Context f1020c;

    /* JADX INFO: renamed from: d */
    public String f1021d;

    /* JADX INFO: renamed from: e */
    public String f1022e;

    /* JADX INFO: renamed from: f */
    public C0031z f1023f;

    /* JADX INFO: renamed from: g */
    public ArrayList<C0059b> f1024g;

    /* JADX INFO: renamed from: h */
    public C0130x f1025h;

    /* JADX INFO: renamed from: i */
    public C0129w f1026i;

    /* JADX INFO: renamed from: j */
    public boolean f1027j;

    /* JADX INFO: renamed from: k */
    public OTConfiguration f1028k;

    /* JADX INFO: renamed from: l */
    public C0126t f1029l;

    /* JADX INFO: renamed from: a.a.a.a.b.f.i$a */
    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f1030a;

        /* JADX INFO: renamed from: b */
        public TextView f1031b;

        /* JADX INFO: renamed from: c */
        public LinearLayout f1032c;

        public a(View view) {
            super(view);
            this.f1031b = (TextView) view.findViewById(C3896R.id.item_title);
            this.f1030a = (TextView) view.findViewById(C3896R.id.item_status);
            this.f1032c = (LinearLayout) view.findViewById(C3896R.id.main_layout);
        }
    }

    public C0141i(Context context, ArrayList<C0059b> arrayList, String str, String str2, C0126t c0126t, String str3, InterfaceC0075c interfaceC0075c, C0031z c0031z, boolean z, OTConfiguration oTConfiguration) {
        this.f1020c = context;
        this.f1024g = arrayList;
        this.f1022e = str;
        this.f1021d = str2;
        this.f1019b = str3;
        this.f1029l = c0126t;
        this.f1018a = interfaceC0075c;
        this.f1023f = c0031z;
        this.f1027j = z;
        try {
            this.f1025h = new C0130x(context);
            this.f1026i = this.f1025h.m672a(this.f1023f, C0074f.m394a(this.f1020c, oTConfiguration));
        } catch (JSONException e) {
            OTLogger.m2748b("OneTrust", "error in parsing ucp data " + e.getMessage());
        }
        this.f1028k = oTConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m722a(C0166l c0166l, a aVar, View view) {
        if (c0166l.isAdded()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("CUSTOM_PREF_ARRAY", this.f1024g);
        bundle.putString("ITEM_LABEL", this.f1022e);
        bundle.putString("ITEM_DESC", this.f1021d);
        bundle.putInt("ITEM_POSITION", aVar.getAdapterPosition());
        bundle.putString("DESC_TEXT_COLOR", this.f1019b);
        bundle.putString("TITLE_TEXT_COLOR", null);
        bundle.putBoolean("PURPOSE_TOGGLE_STATE", this.f1027j);
        c0166l.setArguments(bundle);
        c0166l.f1385r = this.f1023f;
        c0166l.f1378k = this.f1018a;
        c0166l.show(((FragmentActivity) Objects.requireNonNull((FragmentActivity) this.f1020c)).getSupportFragmentManager(), OTFragmentTags.OT_CONSENT_PREF_OPTION_FRAGMENT_TAG);
    }

    @Override // p000a.p001a.p002a.p003a.p014b.InterfaceC0075c
    /* JADX INFO: renamed from: a */
    public void mo419a(int i) {
        InterfaceC0075c interfaceC0075c = this.f1018a;
        if (interfaceC0075c != null) {
            interfaceC0075c.mo419a(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getTotalPages() {
        return this.f1024g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m723a((a) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_uc_purposes_item_list, viewGroup, false));
    }

    /* JADX INFO: renamed from: a */
    public void m723a(final a aVar) {
        C0059b c0059b = this.f1024g.get(aVar.getAdapterPosition());
        String str = this.f1029l.f849t.f724c;
        String str2 = this.f1019b;
        if (C0048h.m305b(str)) {
            str = str2;
        }
        TextView textView = aVar.f1031b;
        String str3 = c0059b.f143b;
        if (str3 != null) {
            textView.setText(str3);
        }
        if (str != null) {
            textView.setTextColor(Color.parseColor(str));
        }
        TextView textView2 = aVar.f1031b;
        C0106b0 c0106b0 = this.f1029l.f841l;
        if (!C0048h.m305b(c0106b0.f722a.f751b)) {
            textView2.setTextSize(Float.parseFloat(c0106b0.f722a.f751b));
        }
        TextView textView3 = aVar.f1030a;
        String str4 = this.f1026i.f873b;
        if (str4 != null) {
            textView3.setText(str4);
        }
        if (str != null) {
            textView3.setTextColor(Color.parseColor(str));
        }
        TextView textView4 = aVar.f1030a;
        C0106b0 c0106b02 = this.f1029l.f841l;
        if (!C0048h.m305b(c0106b02.f722a.f751b)) {
            textView4.setTextSize(Float.parseFloat(c0106b02.f722a.f751b));
        }
        String str5 = this.f1029l.f836g;
        String str6 = this.f1019b;
        if (C0048h.m305b(str5)) {
            str5 = str6;
        }
        if (str5 != null) {
            C0072d.m385a(aVar.f1030a, str5);
        }
        OTConfiguration oTConfiguration = this.f1028k;
        final C0166l c0166l = new C0166l();
        Bundle bundle = new Bundle();
        bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_CONSENT_PREF_OPTION_FRAGMENT_TAG);
        c0166l.setArguments(bundle);
        c0166l.f1390w = oTConfiguration;
        aVar.f1032c.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.f.i$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m722a(c0166l, aVar, view);
            }
        });
    }
}
