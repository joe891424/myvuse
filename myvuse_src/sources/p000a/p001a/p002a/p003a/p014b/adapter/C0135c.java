package p000a.p001a.p002a.p003a.p014b.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0160f;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0132z;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;

/* JADX INFO: renamed from: a.a.a.a.b.f.c */
/* JADX INFO: loaded from: classes.dex */
public class C0135c extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a */
    public final OTConfiguration f970a;

    /* JADX INFO: renamed from: b */
    public final a f971b;

    /* JADX INFO: renamed from: c */
    public JSONArray f972c;

    /* JADX INFO: renamed from: d */
    public Map<String, String> f973d = new HashMap();

    /* JADX INFO: renamed from: e */
    public C0132z f974e;

    /* JADX INFO: renamed from: a.a.a.a.b.f.c$a */
    public interface a {
    }

    /* JADX INFO: renamed from: a.a.a.a.b.f.c$b */
    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f975a;

        /* JADX INFO: renamed from: b */
        public CheckBox f976b;

        /* JADX INFO: renamed from: c */
        public View f977c;

        public b(View view) {
            super(view);
            this.f975a = (TextView) view.findViewById(C3896R.id.purpose_name);
            this.f976b = (CheckBox) view.findViewById(C3896R.id.purpose_select);
            this.f977c = view.findViewById(C3896R.id.purpose_name_divider);
        }
    }

    public C0135c(JSONArray jSONArray, Map<String, String> map, C0132z c0132z, OTConfiguration oTConfiguration, a aVar) {
        this.f972c = jSONArray;
        this.f974e = c0132z;
        this.f970a = oTConfiguration;
        this.f971b = aVar;
        m707a(map);
    }

    /* JADX INFO: renamed from: a */
    public Map<String, String> m704a() {
        OTLogger.m2743a(4, "OneTrust", "Purposes to pass on apply filters : " + this.f973d);
        return this.f973d;
    }

    /* JADX INFO: renamed from: a */
    public final void m707a(Map<String, String> map) {
        this.f973d = new HashMap(map);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f972c.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m705a((b) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_purpose_list_item, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m703a(b bVar, String str, String str2, View view) {
        String str3;
        boolean zIsChecked = bVar.f976b.isChecked();
        C0132z c0132z = this.f974e;
        if (c0132z != null && !C0048h.m305b(c0132z.f904h) && !C0048h.m305b(this.f974e.f909m.f724c)) {
            C0170b.m954a(bVar.f976b, Color.parseColor(this.f974e.f904h), Color.parseColor(this.f974e.f909m.f724c));
        }
        if (!zIsChecked) {
            this.f973d.remove(str);
            ((ViewOnClickListenerC0160f) this.f971b).f1310l = this.f973d;
            str3 = "Purposes Removed : " + str;
        } else {
            if (this.f973d.containsKey(str)) {
                return;
            }
            this.f973d.put(str, str2);
            ((ViewOnClickListenerC0160f) this.f971b).f1310l = this.f973d;
            str3 = "Purposes Added : " + str;
        }
        OTLogger.m2743a(4, "OneTrust", str3);
    }

    /* JADX INFO: renamed from: a */
    public void m705a(final b bVar) {
        bVar.setIsRecyclable(false);
        try {
            JSONObject jSONObject = this.f972c.getJSONObject(bVar.getAdapterPosition());
            final String string = jSONObject.getString("Type");
            bVar.f975a.setText(jSONObject.getString("GroupName"));
            final String string2 = jSONObject.getString("CustomGroupId");
            boolean zContainsKey = m704a().containsKey(string2);
            OTLogger.m2743a(3, "OTPurposeListAdapter", "purpose status : " + zContainsKey);
            bVar.f976b.setChecked(zContainsKey);
            bVar.f976b.setContentDescription("Filter");
            bVar.f975a.setLabelFor(C3896R.id.purpose_select);
            C0132z c0132z = this.f974e;
            if (c0132z != null) {
                m706a(bVar.f975a, c0132z.f909m);
                if (!C0048h.m305b(this.f974e.f904h) && !C0048h.m305b(this.f974e.f909m.f724c)) {
                    C0170b.m954a(bVar.f976b, Color.parseColor(this.f974e.f904h), Color.parseColor(this.f974e.f909m.f724c));
                }
                String str = this.f974e.f898b;
                C0170b.m953a(bVar.f977c, str);
                if (bVar.getAdapterPosition() == 0) {
                    OTLogger.m2743a(3, "OT_Automation", "setLineBreakColor Vendor Filter List: " + str);
                }
            }
            bVar.f976b.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.f.c$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m703a(bVar, string2, string, view);
                }
            });
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while parsing " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m706a(TextView textView, C0106b0 c0106b0) {
        Typeface typeface;
        Typeface otTypeFaceMap;
        C0115i c0115i = c0106b0.f722a;
        OTConfiguration oTConfiguration = this.f970a;
        String str = c0115i.f753d;
        if (C0048h.m305b(str) || oTConfiguration == null || (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str)) == null) {
            int style = c0115i.f752c;
            if (style == -1 && (typeface = textView.getTypeface()) != null) {
                style = typeface.getStyle();
            }
            textView.setTypeface(!C0048h.m305b(c0115i.f750a) ? Typeface.create(c0115i.f750a, style) : Typeface.create(textView.getTypeface(), style));
        } else {
            textView.setTypeface(otTypeFaceMap);
        }
        if (!C0048h.m305b(c0115i.f751b)) {
            textView.setTextSize(Float.parseFloat(c0115i.f751b));
        }
        if (!C0048h.m305b(c0106b0.f724c)) {
            textView.setTextColor(Color.parseColor(c0106b0.f724c));
        }
        if (C0048h.m305b(c0106b0.f723b)) {
            return;
        }
        C0074f.m401a(textView, Integer.parseInt(c0106b0.f723b));
    }
}
