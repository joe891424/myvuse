package p000a.p001a.p002a.p003a.p014b.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0131y;

/* JADX INFO: renamed from: a.a.a.a.b.f.o */
/* JADX INFO: loaded from: classes.dex */
public class C0147o extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a */
    public JSONObject f1075a;

    /* JADX INFO: renamed from: b */
    public OTPublishersHeadlessSDK f1076b;

    /* JADX INFO: renamed from: c */
    public C0131y f1077c;

    /* JADX INFO: renamed from: d */
    public JSONObject f1078d;

    /* JADX INFO: renamed from: a.a.a.a.b.f.o$a */
    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f1079a;

        /* JADX INFO: renamed from: b */
        public TextView f1080b;

        /* JADX INFO: renamed from: c */
        public TextView f1081c;

        /* JADX INFO: renamed from: d */
        public TextView f1082d;

        /* JADX INFO: renamed from: e */
        public TextView f1083e;

        /* JADX INFO: renamed from: f */
        public TextView f1084f;

        /* JADX INFO: renamed from: g */
        public TextView f1085g;

        /* JADX INFO: renamed from: h */
        public TextView f1086h;

        /* JADX INFO: renamed from: i */
        public TextView f1087i;

        /* JADX INFO: renamed from: j */
        public RecyclerView f1088j;

        public a(View view) {
            super(view);
            this.f1080b = (TextView) view.findViewById(C3896R.id.disclosure_id_label);
            this.f1083e = (TextView) view.findViewById(C3896R.id.disclosure_type_label);
            this.f1081c = (TextView) view.findViewById(C3896R.id.disclosure_ls_label);
            this.f1082d = (TextView) view.findViewById(C3896R.id.disclosure_domain_label);
            this.f1079a = (TextView) view.findViewById(C3896R.id.disclosure_purpose_label);
            this.f1084f = (TextView) view.findViewById(C3896R.id.disclosure_id_val);
            this.f1085g = (TextView) view.findViewById(C3896R.id.disclosure_type_val);
            this.f1086h = (TextView) view.findViewById(C3896R.id.disclosure_ls_val);
            this.f1087i = (TextView) view.findViewById(C3896R.id.disclosure_domain_val);
            this.f1088j = (RecyclerView) view.findViewById(C3896R.id.disclosure_purpose_listview);
        }
    }

    public C0147o(JSONObject jSONObject, OTPublishersHeadlessSDK oTPublishersHeadlessSDK, C0131y c0131y, JSONObject jSONObject2) {
        this.f1075a = jSONObject;
        this.f1076b = oTPublishersHeadlessSDK;
        this.f1077c = c0131y;
        this.f1078d = jSONObject2;
    }

    /* JADX INFO: renamed from: a */
    public final void m740a(a aVar, JSONObject jSONObject, JSONArray jSONArray) {
        if (C0032d.m239a(jSONArray) || C0032d.m240a(this.f1078d)) {
            aVar.f1079a.setVisibility(8);
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        JSONObject jSONObject2 = this.f1078d;
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.getInt(i) <= 10) {
                jSONArray2.put(jSONObject2.getJSONObject(jSONArray.get(i).toString()));
            }
        }
        C0106b0 c0106b0 = this.f1077c.f892g;
        C0145m c0145m = new C0145m(jSONArray2, !C0048h.m305b(c0106b0.f724c) ? c0106b0.f724c : jSONObject.optString("PcTextColor"), this.f1077c, null, OTVendorListMode.IAB);
        RecyclerView recyclerView = aVar.f1088j;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        aVar.f1088j.setAdapter(c0145m);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getTotalPages() {
        try {
            return this.f1075a.getJSONArray("disclosures").length();
        } catch (JSONException unused) {
            OTLogger.m2743a(6, "OneTrust", "Error on populating disclosures");
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0086 A[Catch: Exception -> 0x0107, TryCatch #0 {Exception -> 0x0107, blocks: (B:3:0x000b, B:5:0x001b, B:7:0x0039, B:11:0x005f, B:13:0x006d, B:15:0x0086, B:17:0x009e, B:19:0x00b3, B:21:0x00cb, B:20:0x00c1, B:16:0x0094, B:8:0x0044, B:10:0x0052, B:12:0x0063), top: B:26:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094 A[Catch: Exception -> 0x0107, TryCatch #0 {Exception -> 0x0107, blocks: (B:3:0x000b, B:5:0x001b, B:7:0x0039, B:11:0x005f, B:13:0x006d, B:15:0x0086, B:17:0x009e, B:19:0x00b3, B:21:0x00cb, B:20:0x00c1, B:16:0x0094, B:8:0x0044, B:10:0x0052, B:12:0x0063), top: B:26:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b3 A[Catch: Exception -> 0x0107, TryCatch #0 {Exception -> 0x0107, blocks: (B:3:0x000b, B:5:0x001b, B:7:0x0039, B:11:0x005f, B:13:0x006d, B:15:0x0086, B:17:0x009e, B:19:0x00b3, B:21:0x00cb, B:20:0x00c1, B:16:0x0094, B:8:0x0044, B:10:0x0052, B:12:0x0063), top: B:26:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c1 A[Catch: Exception -> 0x0107, TryCatch #0 {Exception -> 0x0107, blocks: (B:3:0x000b, B:5:0x001b, B:7:0x0039, B:11:0x005f, B:13:0x006d, B:15:0x0086, B:17:0x009e, B:19:0x00b3, B:21:0x00cb, B:20:0x00c1, B:16:0x0094, B:8:0x0044, B:10:0x0052, B:12:0x0063), top: B:26:0x000b }] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r10, int r11) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.adapter.C0147o.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_vendor_disclosure_item, viewGroup, false));
    }

    /* JADX INFO: renamed from: a */
    public static void m739a(a aVar, C0131y c0131y) {
        if (C0048h.m305b(c0131y.f892g.f723b)) {
            return;
        }
        int i = Integer.parseInt(c0131y.f892g.f723b);
        aVar.f1080b.setTextAlignment(i);
        aVar.f1084f.setTextAlignment(i);
        aVar.f1083e.setTextAlignment(i);
        aVar.f1085g.setTextAlignment(i);
        aVar.f1082d.setTextAlignment(i);
        aVar.f1087i.setTextAlignment(i);
        aVar.f1081c.setTextAlignment(i);
        aVar.f1086h.setTextAlignment(i);
        aVar.f1079a.setTextAlignment(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m741a(JSONObject jSONObject, a aVar) {
        String strOptString;
        try {
            C0131y c0131y = this.f1077c;
            if (c0131y != null) {
                C0106b0 c0106b0 = c0131y.f892g;
                if (!C0048h.m305b(c0106b0.f724c)) {
                    strOptString = c0106b0.f724c;
                } else {
                    strOptString = jSONObject.optString("PcTextColor");
                }
                if (!C0048h.m305b(this.f1077c.f892g.f722a.f751b)) {
                    float f = Float.parseFloat(this.f1077c.f892g.f722a.f751b);
                    aVar.f1080b.setTextSize(f);
                    aVar.f1084f.setTextSize(f);
                    aVar.f1083e.setTextSize(f);
                    aVar.f1085g.setTextSize(f);
                    aVar.f1082d.setTextSize(f);
                    aVar.f1087i.setTextSize(f);
                    aVar.f1081c.setTextSize(f);
                    aVar.f1086h.setTextSize(f);
                    aVar.f1079a.setTextSize(f);
                }
                m739a(aVar, this.f1077c);
                C0074f c0074f = new C0074f();
                C0115i c0115i = this.f1077c.f892g.f722a;
                c0074f.m417a(aVar.f1080b, c0115i, (OTConfiguration) null);
                c0074f.m417a(aVar.f1084f, c0115i, (OTConfiguration) null);
                c0074f.m417a(aVar.f1083e, c0115i, (OTConfiguration) null);
                c0074f.m417a(aVar.f1085g, c0115i, (OTConfiguration) null);
                c0074f.m417a(aVar.f1082d, c0115i, (OTConfiguration) null);
                c0074f.m417a(aVar.f1087i, c0115i, (OTConfiguration) null);
                c0074f.m417a(aVar.f1081c, c0115i, (OTConfiguration) null);
                c0074f.m417a(aVar.f1086h, c0115i, (OTConfiguration) null);
                c0074f.m417a(aVar.f1079a, c0115i, (OTConfiguration) null);
            } else {
                strOptString = jSONObject.optString("PcTextColor");
            }
            aVar.f1080b.setTextColor(Color.parseColor(strOptString));
            aVar.f1084f.setTextColor(Color.parseColor(strOptString));
            aVar.f1083e.setTextColor(Color.parseColor(strOptString));
            aVar.f1085g.setTextColor(Color.parseColor(strOptString));
            aVar.f1082d.setTextColor(Color.parseColor(strOptString));
            aVar.f1087i.setTextColor(Color.parseColor(strOptString));
            aVar.f1081c.setTextColor(Color.parseColor(strOptString));
            aVar.f1086h.setTextColor(Color.parseColor(strOptString));
            aVar.f1079a.setTextColor(Color.parseColor(strOptString));
        } catch (Exception e) {
            OTLogger.m2743a(6, "OneTrust", "Error while applying styles to Vendor disclosures, err : " + e.getMessage());
        }
    }
}
