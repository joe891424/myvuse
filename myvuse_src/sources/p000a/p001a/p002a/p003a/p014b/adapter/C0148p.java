package p000a.p001a.p002a.p003a.p014b.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.jose4j.jwk.JsonWebKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0131y;

/* JADX INFO: renamed from: a.a.a.a.b.f.p */
/* JADX INFO: loaded from: classes.dex */
public class C0148p extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a */
    public JSONArray f1089a;

    /* JADX INFO: renamed from: b */
    public C0131y f1090b;

    /* JADX INFO: renamed from: c */
    public JSONObject f1091c;

    /* JADX INFO: renamed from: a.a.a.a.b.f.p$a */
    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f1092a;

        /* JADX INFO: renamed from: b */
        public TextView f1093b;

        /* JADX INFO: renamed from: c */
        public TextView f1094c;

        /* JADX INFO: renamed from: d */
        public TextView f1095d;

        public a(View view) {
            super(view);
            this.f1092a = (TextView) view.findViewById(C3896R.id.domain_label);
            this.f1093b = (TextView) view.findViewById(C3896R.id.domain_value);
            this.f1094c = (TextView) view.findViewById(C3896R.id.used_label);
            this.f1095d = (TextView) view.findViewById(C3896R.id.used_val);
        }
    }

    public C0148p(JSONArray jSONArray, JSONObject jSONObject, C0131y c0131y) {
        this.f1089a = jSONArray;
        this.f1091c = jSONObject;
        this.f1090b = c0131y;
    }

    /* JADX INFO: renamed from: a */
    public final void m742a(TextView textView, String str) {
        Typeface typeface;
        C0131y c0131y = this.f1090b;
        if (c0131y == null) {
            return;
        }
        C0106b0 c0106b0 = c0131y.f892g;
        if (!C0048h.m305b(str)) {
            textView.setText(str);
        }
        textView.setTextColor(Color.parseColor(!C0048h.m305b(c0106b0.f724c) ? c0106b0.f724c : this.f1091c.optString("PcTextColor")));
        if (!C0048h.m305b(c0106b0.f723b)) {
            textView.setTextAlignment(Integer.parseInt(c0106b0.f723b));
        }
        if (!C0048h.m305b(c0106b0.f722a.f751b)) {
            textView.setTextSize(Float.parseFloat(c0106b0.f722a.f751b));
        }
        C0115i c0115i = c0106b0.f722a;
        C0048h.m305b(c0115i.f753d);
        int style = c0115i.f752c;
        if (style == -1 && (typeface = textView.getTypeface()) != null) {
            style = typeface.getStyle();
        }
        textView.setTypeface(!C0048h.m305b(c0115i.f750a) ? Typeface.create(c0115i.f750a, style) : Typeface.create(textView.getTypeface(), style));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        try {
            return this.f1089a.length();
        } catch (Exception unused) {
            OTLogger.m2743a(6, "OneTrust", "Error on populating domains used");
            return 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        try {
            JSONObject jSONObject = this.f1089a.getJSONObject(aVar.getAdapterPosition());
            if (this.f1091c == null || C0032d.m240a(jSONObject)) {
                return;
            }
            if (!jSONObject.has("domain") || C0048h.m305b(jSONObject.optString("domain"))) {
                aVar.f1092a.setVisibility(8);
                aVar.f1093b.setVisibility(8);
            } else {
                m742a(aVar.f1092a, this.f1091c.optString("PCenterVendorListStorageDomain"));
                m742a(aVar.f1093b, jSONObject.optString("domain"));
            }
            if (!jSONObject.has(JsonWebKey.USE_PARAMETER) || C0048h.m305b(jSONObject.optString(JsonWebKey.USE_PARAMETER))) {
                aVar.f1094c.setVisibility(8);
                aVar.f1095d.setVisibility(8);
            } else {
                m742a(aVar.f1094c, this.f1091c.optString("PCVLSUse"));
                m742a(aVar.f1095d, jSONObject.optString(JsonWebKey.USE_PARAMETER));
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "Error on populating disclosures, err : " + e.getMessage());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_vendor_domains_used_item, viewGroup, false));
    }
}
