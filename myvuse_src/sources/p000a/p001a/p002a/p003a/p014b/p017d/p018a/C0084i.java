package p000a.p001a.p002a.p003a.p014b.p017d.p018a;

import android.graphics.Color;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0102m;

/* JADX INFO: renamed from: a.a.a.a.b.d.a.i */
/* JADX INFO: loaded from: classes.dex */
public class C0084i extends RecyclerView.Adapter<c> {

    /* JADX INFO: renamed from: a */
    public b f325a;

    /* JADX INFO: renamed from: b */
    public OTPublishersHeadlessSDK f326b;

    /* JADX INFO: renamed from: c */
    public OTVendorUtils f327c;

    /* JADX INFO: renamed from: d */
    public C0087c f328d = C0087c.m482c();

    /* JADX INFO: renamed from: e */
    public boolean f329e;

    /* JADX INFO: renamed from: f */
    public Map<String, String> f330f;

    /* JADX INFO: renamed from: g */
    public int f331g;

    /* JADX INFO: renamed from: h */
    public JSONObject f332h;

    /* JADX INFO: renamed from: i */
    public List<JSONObject> f333i;

    /* JADX INFO: renamed from: j */
    public ArrayList<String> f334j;

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.i$a */
    public class a implements Comparator<JSONObject> {
        public a(C0084i c0084i) {
        }

        @Override // java.util.Comparator
        public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
            String lowerCase;
            JSONObject jSONObject3 = jSONObject2;
            String lowerCase2 = "";
            try {
                String string = jSONObject.getString("name");
                Locale locale = Locale.ENGLISH;
                lowerCase = string.toLowerCase(locale);
                try {
                    lowerCase2 = jSONObject3.getString("name").toLowerCase(locale);
                } catch (JSONException e) {
                    e = e;
                    OTLogger.m2743a(6, "TVVendorlist", "error while sorting VL json object lists,err : " + e.toString());
                }
            } catch (JSONException e2) {
                e = e2;
                lowerCase = "";
            }
            return lowerCase.compareTo(lowerCase2);
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.i$b */
    public interface b {
    }

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.i$c */
    public static class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public final TextView f335a;

        /* JADX INFO: renamed from: b */
        public final LinearLayout f336b;

        public c(View view) {
            super(view);
            this.f335a = (TextView) view.findViewById(C3896R.id.tv_grp_name);
            this.f336b = (LinearLayout) view.findViewById(C3896R.id.tv_grp_layout);
        }
    }

    public C0084i(OTVendorUtils oTVendorUtils, b bVar, OTPublishersHeadlessSDK oTPublishersHeadlessSDK, boolean z, Map<String, String> map) {
        this.f330f = new HashMap();
        this.f327c = oTVendorUtils;
        this.f325a = bVar;
        this.f326b = oTPublishersHeadlessSDK;
        this.f329e = z;
        this.f330f = map;
        oTVendorUtils.refreshList(OTVendorListMode.IAB);
        oTVendorUtils.setVendorsListObject(OTVendorListMode.IAB, m463a(), false);
    }

    /* JADX INFO: renamed from: a */
    public final JSONObject m463a() {
        JSONObject jSONObject = new JSONObject();
        if (this.f329e) {
            JSONObject vendorsByPurpose = this.f327c.getVendorsByPurpose(this.f330f, this.f326b.getVendorListUI(OTVendorListMode.IAB));
            OTLogger.m2743a(3, "TVVendorlist", "Total vendors count with filtered purpose : " + vendorsByPurpose.length());
            return vendorsByPurpose;
        }
        JSONObject vendorListUI = this.f326b.getVendorListUI(OTVendorListMode.IAB);
        if (vendorListUI != null) {
            jSONObject = vendorListUI;
        }
        OTLogger.m2743a(3, "TVVendorlist", "Total IAB vendors count without filter : " + jSONObject.length());
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    public final void m465a(List<JSONObject> list, JSONObject jSONObject) {
        String lowerCase = jSONObject.getString("name").toLowerCase(Locale.ENGLISH);
        if (this.f334j.contains("A_F") && lowerCase.matches("(a|b|c|d|e|f).*")) {
            list.add(jSONObject);
        }
        if (this.f334j.contains("G_L") && lowerCase.matches("(g|h|i|j|k|l).*")) {
            list.add(jSONObject);
        }
        if (this.f334j.contains("M_R") && lowerCase.matches("(m|n|o|p|q|r).*")) {
            list.add(jSONObject);
        }
        if (this.f334j.contains("S_Z") && lowerCase.matches("(s|t|u|v|w|x|y|z).*")) {
            list.add(jSONObject);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m466b() {
        this.f327c.setVendorsListObject(OTVendorListMode.IAB, m463a(), false);
        this.f332h = new JSONObject();
        this.f332h = this.f327c.getVendorsListObject(OTVendorListMode.IAB);
        this.f333i = new ArrayList();
        if (this.f334j == null) {
            this.f334j = new ArrayList<>();
        }
        if (C0032d.m240a(this.f332h)) {
            OTLogger.m2743a(6, "TVVendorlist", "setVendorListObject: Empty data found for Vendors");
            return;
        }
        JSONArray jSONArrayNames = this.f332h.names();
        if (jSONArrayNames == null) {
            OTLogger.m2743a(6, "TVVendorlist", "setVendorListObject: Vendor data is empty");
            return;
        }
        for (int i = 0; i < this.f332h.length(); i++) {
            try {
                JSONObject jSONObject = this.f332h.getJSONObject(jSONArrayNames.get(i).toString());
                if (this.f334j.isEmpty()) {
                    this.f333i.add(jSONObject);
                } else {
                    m465a(this.f333i, jSONObject);
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "TVVendorlist", "error while constructing VL json object lists,err : " + e.toString());
            }
        }
        Collections.sort(this.f333i, new a(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getTotalPages() {
        return this.f333i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m464a((c) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_pc_list_item_tv, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        c cVar = (c) viewHolder;
        super.onViewAttachedToWindow(cVar);
        if (cVar.getAdapterPosition() == this.f331g) {
            cVar.itemView.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m461a(String str, c cVar, View view, boolean z) {
        if (z) {
            ViewOnKeyListenerC0102m viewOnKeyListenerC0102m = (ViewOnKeyListenerC0102m) this.f325a;
            viewOnKeyListenerC0102m.f683I = false;
            viewOnKeyListenerC0102m.m600a(str);
            cVar.f335a.setTextColor(Color.parseColor(this.f328d.f378j.f819B.f766d));
            cVar.f336b.setBackgroundColor(Color.parseColor(this.f328d.f378j.f819B.f765c));
            if (cVar.getAdapterPosition() == -1 || cVar.getAdapterPosition() == this.f331g) {
                return;
            }
            this.f331g = cVar.getAdapterPosition();
            return;
        }
        cVar.f335a.setTextColor(Color.parseColor(this.f328d.f378j.f819B.f764b));
        cVar.f336b.setBackgroundColor(Color.parseColor(this.f328d.f378j.f819B.f763a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m462a(c cVar, View view, int i, KeyEvent keyEvent) {
        if (C0072d.m382a(i, keyEvent) == 22) {
            this.f331g = cVar.getAdapterPosition();
            ((ViewOnKeyListenerC0102m) this.f325a).m609c();
            cVar.f335a.setTextColor(Color.parseColor(this.f328d.f378j.f819B.f768f));
            cVar.f336b.setBackgroundColor(Color.parseColor(this.f328d.f378j.f819B.f767e));
            return true;
        }
        if (cVar.getAdapterPosition() != 0 || C0072d.m382a(i, keyEvent) != 25) {
            return false;
        }
        ((ViewOnKeyListenerC0102m) this.f325a).m607b();
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m464a(final c cVar) {
        int adapterPosition = cVar.getAdapterPosition();
        OTLogger.m2743a(2, "TVVendorlist", "filtered vendors count " + this.f333i.size());
        final String string = "";
        if (this.f332h.names() != null) {
            try {
                cVar.setIsRecyclable(false);
                JSONObject jSONObject = this.f333i.get(adapterPosition);
                string = jSONObject.getString("id");
                cVar.f335a.setText(jSONObject.getString("name"));
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "exception thrown when rendering vendors, err : " + e.getMessage());
            }
        }
        cVar.f335a.setTextColor(Color.parseColor(this.f328d.f378j.f819B.f764b));
        cVar.f336b.setBackgroundColor(Color.parseColor(this.f328d.f378j.f819B.f763a));
        cVar.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: a.a.a.a.b.d.a.i$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.f$0.m461a(string, cVar, view, z);
            }
        });
        cVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: a.a.a.a.b.d.a.i$$ExternalSyntheticLambda1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return this.f$0.m462a(cVar, view, i, keyEvent);
            }
        });
    }
}
