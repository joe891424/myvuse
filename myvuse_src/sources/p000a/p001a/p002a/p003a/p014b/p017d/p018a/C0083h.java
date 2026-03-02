package p000a.p001a.p002a.p003a.p014b.p017d.p018a;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.brentvatne.react.ReactVideoView;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.jose4j.jwk.JsonWebKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0088d;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0089e;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0100k;

/* JADX INFO: renamed from: a.a.a.a.b.d.a.h */
/* JADX INFO: loaded from: classes.dex */
public class C0083h extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a */
    public JSONObject f301a;

    /* JADX INFO: renamed from: b */
    public final C0088d f302b = C0088d.m503b();

    /* JADX INFO: renamed from: c */
    public c f303c;

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.h$a */
    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f304a;

        /* JADX INFO: renamed from: b */
        public TextView f305b;

        /* JADX INFO: renamed from: c */
        public TextView f306c;

        /* JADX INFO: renamed from: d */
        public TextView f307d;

        /* JADX INFO: renamed from: e */
        public TextView f308e;

        /* JADX INFO: renamed from: f */
        public TextView f309f;

        /* JADX INFO: renamed from: g */
        public TextView f310g;

        /* JADX INFO: renamed from: h */
        public TextView f311h;

        /* JADX INFO: renamed from: i */
        public TextView f312i;

        /* JADX INFO: renamed from: j */
        public RecyclerView f313j;

        /* JADX INFO: renamed from: k */
        public LinearLayout f314k;

        /* JADX INFO: renamed from: l */
        public LinearLayout f315l;

        /* JADX INFO: renamed from: m */
        public LinearLayout f316m;

        /* JADX INFO: renamed from: n */
        public LinearLayout f317n;

        /* JADX INFO: renamed from: o */
        public LinearLayout f318o;

        public a(View view) {
            super(view);
            this.f304a = (TextView) view.findViewById(C3896R.id.disclosure_id_label);
            this.f305b = (TextView) view.findViewById(C3896R.id.disclosure_type_label);
            this.f306c = (TextView) view.findViewById(C3896R.id.disclosure_ls_label);
            this.f307d = (TextView) view.findViewById(C3896R.id.disclosure_domain_label);
            this.f308e = (TextView) view.findViewById(C3896R.id.disclosure_purpose_label);
            this.f309f = (TextView) view.findViewById(C3896R.id.disclosure_id_val);
            this.f310g = (TextView) view.findViewById(C3896R.id.disclosure_type_val);
            this.f311h = (TextView) view.findViewById(C3896R.id.disclosure_ls_val);
            this.f312i = (TextView) view.findViewById(C3896R.id.disclosure_domain_val);
            this.f313j = (RecyclerView) view.findViewById(C3896R.id.disclosure_purpose_listview);
            this.f314k = (LinearLayout) view.findViewById(C3896R.id.disclosure_id_lyt);
            this.f315l = (LinearLayout) view.findViewById(C3896R.id.disclosure_type_lyt);
            this.f316m = (LinearLayout) view.findViewById(C3896R.id.disclosure_ls_lyt);
            this.f317n = (LinearLayout) view.findViewById(C3896R.id.disclosure_domain_lyt);
            this.f318o = (LinearLayout) view.findViewById(C3896R.id.disclosure_purpose_lyt);
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.h$b */
    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f319a;

        /* JADX INFO: renamed from: b */
        public TextView f320b;

        /* JADX INFO: renamed from: c */
        public TextView f321c;

        /* JADX INFO: renamed from: d */
        public TextView f322d;

        public b(View view) {
            super(view);
            this.f319a = (TextView) view.findViewById(C3896R.id.domain_label);
            this.f320b = (TextView) view.findViewById(C3896R.id.domain_value);
            this.f321c = (TextView) view.findViewById(C3896R.id.used_label);
            this.f322d = (TextView) view.findViewById(C3896R.id.used_val);
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.h$c */
    public interface c {
    }

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.h$d */
    public static class d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f323a;

        public d(View view) {
            super(view);
            this.f323a = (TextView) view.findViewById(C3896R.id.tv_vd_purpose_item);
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.h$e */
    public static class e extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f324a;

        public e(View view) {
            super(view);
            this.f324a = (TextView) view.findViewById(C3896R.id.tv_vd_purpose_title);
        }
    }

    public C0083h(JSONObject jSONObject, c cVar) {
        this.f301a = jSONObject;
        this.f303c = cVar;
    }

    /* JADX INFO: renamed from: a */
    public static void m451a(TextView textView, String str, TextView textView2, String str2, LinearLayout linearLayout) {
        if (C0048h.m305b(str2)) {
            linearLayout.setVisibility(8);
        } else {
            textView.setText(str);
            textView2.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ boolean m452a(a aVar, View view, int i, KeyEvent keyEvent) {
        if (C0072d.m382a(i, keyEvent) != 24) {
            return false;
        }
        ((ViewOnKeyListenerC0100k) this.f303c).m589b();
        aVar.itemView.setFocusable(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ boolean m453a(b bVar, View view, int i, KeyEvent keyEvent) {
        if (C0072d.m382a(i, keyEvent) != 24) {
            return false;
        }
        ((ViewOnKeyListenerC0100k) this.f303c).m589b();
        bVar.itemView.setFocusable(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ boolean m454a(d dVar, View view, int i, KeyEvent keyEvent) {
        if (C0072d.m382a(i, keyEvent) != 24) {
            return false;
        }
        ((ViewOnKeyListenerC0100k) this.f303c).m589b();
        dVar.itemView.setFocusable(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ boolean m455a(e eVar, View view, int i, KeyEvent keyEvent) {
        if (C0072d.m382a(i, keyEvent) != 24) {
            return false;
        }
        ((ViewOnKeyListenerC0100k) this.f303c).m589b();
        eVar.itemView.setFocusable(false);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final void m457a(final b bVar, int i) {
        JSONArray jSONArrayNames = this.f301a.names();
        if (jSONArrayNames == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(jSONArrayNames.optString(i));
            C0089e c0089eM509a = C0089e.m509a();
            if (!C0032d.m240a(jSONObject)) {
                if (!jSONObject.has("domain") || C0048h.m305b(jSONObject.optString("domain"))) {
                    bVar.f319a.setVisibility(8);
                    bVar.f320b.setVisibility(8);
                } else {
                    m460a(bVar.f319a, c0089eM509a.f410s);
                    m460a(bVar.f320b, jSONObject.optString("domain"));
                }
                if (!jSONObject.has(JsonWebKey.USE_PARAMETER) || C0048h.m305b(jSONObject.optString(JsonWebKey.USE_PARAMETER))) {
                    bVar.f321c.setVisibility(8);
                    bVar.f322d.setVisibility(8);
                } else {
                    m460a(bVar.f321c, c0089eM509a.f413v);
                    m460a(bVar.f322d, jSONObject.optString(JsonWebKey.USE_PARAMETER));
                }
            }
            bVar.itemView.setFocusable(true);
            bVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: a.a.a.a.b.d.a.h$$ExternalSyntheticLambda0
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                    return this.f$0.m453a(bVar, view, i2, keyEvent);
                }
            });
        } catch (Exception e2) {
            OTLogger.m2743a(6, "OneTrust", "Error on populating disclosures, err : " + e2.getMessage());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        JSONObject jSONObject = this.f301a;
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        try {
            JSONArray jSONArrayNames = this.f301a.names();
            if (jSONArrayNames != null) {
                return this.f301a.getInt(jSONArrayNames.get(i).toString());
            }
        } catch (Exception e2) {
            OTLogger.m2743a(6, "OneTrust", "error while getting view type " + e2.getMessage());
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 1) {
            m459a((e) viewHolder, i);
            return;
        }
        if (itemViewType == 2) {
            m458a((d) viewHolder, i);
        } else if (itemViewType == 3) {
            m456a((a) viewHolder, i);
        } else {
            if (itemViewType != 4) {
                return;
            }
            m457a((b) viewHolder, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new e(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_tv_vendor_details_purpose_title_item, viewGroup, false));
        }
        if (i == 2) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_tv_vendor_details_purpose_item, viewGroup, false));
        }
        if (i == 3) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_tv_vendor_disclosure_item, viewGroup, false));
        }
        if (i == 4) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_tv_vendor_domains_used_item, viewGroup, false));
        }
        throw new RuntimeException("Invalid view type found");
    }

    /* JADX INFO: renamed from: a */
    public final void m459a(final e eVar, int i) {
        JSONArray jSONArrayNames = this.f301a.names();
        if (jSONArrayNames == null) {
            return;
        }
        eVar.f324a.setText(jSONArrayNames.optString(i));
        eVar.f324a.setTextColor(Color.parseColor(this.f302b.f385b));
        eVar.itemView.setFocusable(true);
        eVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: a.a.a.a.b.d.a.h$$ExternalSyntheticLambda3
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                return this.f$0.m455a(eVar, view, i2, keyEvent);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final void m456a(final a aVar, int i) {
        boolean z;
        SharedPreferencesC0047f sharedPreferencesC0047f;
        JSONArray jSONArrayNames = this.f301a.names();
        if (jSONArrayNames == null) {
            return;
        }
        String strOptString = jSONArrayNames.optString(i);
        C0089e c0089eM509a = C0089e.m509a();
        String str = this.f302b.f385b;
        aVar.itemView.setFocusable(true);
        try {
            JSONObject jSONObject = new JSONObject(strOptString);
            long jOptLong = jSONObject.optLong("maxAgeSeconds");
            Context context = aVar.f313j.getContext();
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z = true;
            } else {
                z = false;
                sharedPreferencesC0047f = null;
            }
            if (z) {
                sharedPreferences = sharedPreferencesC0047f;
            }
            String string = sharedPreferences.getString("OT_IAB_PURPOSES_TRANSLATED", "");
            if (C0048h.m305b(string)) {
                aVar.f318o.setVisibility(8);
            } else {
                JSONObject jSONObject2 = new JSONObject(string);
                JSONObject jSONObject3 = jSONObject2.has("purposes") ? jSONObject2.getJSONObject("purposes") : null;
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("purposes");
                if (!C0032d.m239a(jSONArrayOptJSONArray) && !C0032d.m240a(jSONObject3)) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        jSONArray.put(jSONObject3.getJSONObject(jSONArrayOptJSONArray.get(i2).toString()));
                    }
                    C0082g c0082g = new C0082g(jSONArray, str);
                    aVar.f308e.setText(c0089eM509a.f411t);
                    aVar.f308e.setTextColor(Color.parseColor(str));
                    RecyclerView recyclerView = aVar.f313j;
                    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                    aVar.f313j.setAdapter(c0082g);
                }
            }
            m451a(aVar.f304a, c0089eM509a.f407p, aVar.f309f, (jSONObject.has(ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER) || jSONObject.has("name")) ? jSONObject.optString(ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER).isEmpty() ? jSONObject.optString("name") : jSONObject.optString(ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER) : "", aVar.f314k);
            m451a(aVar.f305b, c0089eM509a.f408q, aVar.f310g, jSONObject.optString("type"), aVar.f315l);
            m451a(aVar.f307d, c0089eM509a.f410s, aVar.f312i, jSONObject.optString("domain"), aVar.f317n);
            m451a(aVar.f306c, c0089eM509a.f409r, aVar.f311h, new C0074f().m407a(jOptLong, this.f302b.m505a(aVar.itemView.getContext())), aVar.f316m);
            aVar.f308e.setTextColor(Color.parseColor(str));
            aVar.f304a.setTextColor(Color.parseColor(str));
            aVar.f307d.setTextColor(Color.parseColor(str));
            aVar.f306c.setTextColor(Color.parseColor(str));
            aVar.f305b.setTextColor(Color.parseColor(str));
            aVar.f309f.setTextColor(Color.parseColor(str));
            aVar.f312i.setTextColor(Color.parseColor(str));
            aVar.f311h.setTextColor(Color.parseColor(str));
            aVar.f310g.setTextColor(Color.parseColor(str));
            aVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: a.a.a.a.b.d.a.h$$ExternalSyntheticLambda1
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                    return this.f$0.m452a(aVar, view, i3, keyEvent);
                }
            });
        } catch (JSONException e2) {
            OTLogger.m2743a(6, "OneTrust", "exception thrown while populating disclosure items, err : " + e2.toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m458a(final d dVar, int i) {
        JSONArray jSONArrayNames = this.f301a.names();
        if (jSONArrayNames == null) {
            return;
        }
        dVar.f323a.setText(jSONArrayNames.optString(i));
        dVar.f323a.setTextColor(Color.parseColor(this.f302b.f385b));
        C0072d.m385a(dVar.f323a, this.f302b.f385b);
        dVar.itemView.setFocusable(true);
        dVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: a.a.a.a.b.d.a.h$$ExternalSyntheticLambda2
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                return this.f$0.m454a(dVar, view, i2, keyEvent);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final void m460a(TextView textView, String str) {
        String str2 = this.f302b.f385b;
        if (!C0048h.m305b(str)) {
            textView.setText(str);
        }
        textView.setTextColor(Color.parseColor(str2));
    }
}
