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
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0102m;

/* JADX INFO: renamed from: a.a.a.a.b.d.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0076a extends RecyclerView.Adapter<c> {

    /* JADX INFO: renamed from: a */
    public b f240a;

    /* JADX INFO: renamed from: b */
    public OTPublishersHeadlessSDK f241b;

    /* JADX INFO: renamed from: c */
    public OTVendorUtils f242c;

    /* JADX INFO: renamed from: d */
    public C0087c f243d = C0087c.m482c();

    /* JADX INFO: renamed from: e */
    public int f244e;

    /* JADX INFO: renamed from: f */
    public JSONObject f245f;

    /* JADX INFO: renamed from: g */
    public List<JSONObject> f246g;

    /* JADX INFO: renamed from: h */
    public ArrayList<String> f247h;

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.a$a */
    public class a implements Comparator<JSONObject> {
        public a(C0076a c0076a) {
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
                    OTLogger.m2743a(6, "TVGoogleVendors", "error while sorting VL json object lists,err : " + e.toString());
                }
            } catch (JSONException e2) {
                e = e2;
                lowerCase = "";
            }
            return lowerCase.compareTo(lowerCase2);
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.a$b */
    public interface b {
    }

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.a$c */
    public static class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public final TextView f248a;

        /* JADX INFO: renamed from: b */
        public final LinearLayout f249b;

        public c(View view) {
            super(view);
            this.f248a = (TextView) view.findViewById(C3896R.id.tv_grp_name);
            this.f249b = (LinearLayout) view.findViewById(C3896R.id.tv_grp_layout);
        }
    }

    public C0076a(OTVendorUtils oTVendorUtils, b bVar, OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        this.f242c = oTVendorUtils;
        this.f240a = bVar;
        this.f241b = oTPublishersHeadlessSDK;
        oTVendorUtils.refreshList(OTVendorListMode.GOOGLE);
        oTVendorUtils.setVendorsListObject(OTVendorListMode.GOOGLE, m422a(), false);
    }

    /* JADX INFO: renamed from: a */
    public final JSONObject m422a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject vendorListUI = this.f241b.getVendorListUI(OTVendorListMode.GOOGLE);
        if (vendorListUI != null) {
            jSONObject = vendorListUI;
        }
        OTLogger.m2743a(3, "TVGoogleVendors", "Total Google vendors count: " + jSONObject.length());
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    public final void m424a(List<JSONObject> list, JSONObject jSONObject) {
        String lowerCase = jSONObject.getString("name").toLowerCase(Locale.ENGLISH);
        if (this.f247h.contains("A_F") && lowerCase.matches("(a|b|c|d|e|f]).*")) {
            list.add(jSONObject);
        }
        if (this.f247h.contains("G_L") && lowerCase.matches("(g|h|i|j|k|l]).*")) {
            list.add(jSONObject);
        }
        if (this.f247h.contains("M_R") && lowerCase.matches("(m|n|o|p|q|r]).*")) {
            list.add(jSONObject);
        }
        if (this.f247h.contains("S_Z") && lowerCase.matches("(s|t|u|v|w|x|y|z]).*")) {
            list.add(jSONObject);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m425b() {
        this.f242c.setVendorsListObject(OTVendorListMode.GOOGLE, m422a(), false);
        this.f245f = new JSONObject();
        this.f245f = this.f242c.getVendorsListObject(OTVendorListMode.GOOGLE);
        this.f246g = new ArrayList();
        if (this.f247h == null) {
            this.f247h = new ArrayList<>();
        }
        if (C0032d.m240a(this.f245f)) {
            OTLogger.m2743a(6, "TVGoogleVendors", "setVendorListObject: Empty data found for Vendors");
            return;
        }
        JSONArray jSONArrayNames = this.f245f.names();
        if (jSONArrayNames == null) {
            OTLogger.m2743a(6, "TVGoogleVendors", "setVendorListObject: Vendor data is empty");
            return;
        }
        for (int i = 0; i < this.f245f.length(); i++) {
            try {
                JSONObject jSONObject = this.f245f.getJSONObject(jSONArrayNames.get(i).toString());
                if (this.f247h.isEmpty()) {
                    this.f246g.add(jSONObject);
                } else {
                    m424a(this.f246g, jSONObject);
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "TVGoogleVendors", "error while constructing VL json object lists,err : " + e.toString());
            }
        }
        Collections.sort(this.f246g, new a(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getTotalPages() {
        return this.f246g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m423a((c) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_pc_list_item_tv, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        c cVar = (c) viewHolder;
        super.onViewAttachedToWindow(cVar);
        if (cVar.getAdapterPosition() == this.f244e) {
            cVar.itemView.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m420a(String str, c cVar, View view, boolean z) {
        if (!z) {
            cVar.f248a.setTextColor(Color.parseColor(this.f243d.f378j.f819B.f764b));
            cVar.f249b.setBackgroundColor(Color.parseColor(this.f243d.f378j.f819B.f763a));
            return;
        }
        ViewOnKeyListenerC0102m viewOnKeyListenerC0102m = (ViewOnKeyListenerC0102m) this.f240a;
        viewOnKeyListenerC0102m.f683I = false;
        viewOnKeyListenerC0102m.m600a(str);
        cVar.f248a.setTextColor(Color.parseColor(this.f243d.f378j.f819B.f766d));
        cVar.f249b.setBackgroundColor(Color.parseColor(this.f243d.f378j.f819B.f765c));
        if (cVar.getAdapterPosition() == -1 || cVar.getAdapterPosition() == this.f244e) {
            return;
        }
        this.f244e = cVar.getAdapterPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m421a(c cVar, View view, int i, KeyEvent keyEvent) {
        if (C0072d.m382a(i, keyEvent) == 22) {
            this.f244e = cVar.getAdapterPosition();
            ((ViewOnKeyListenerC0102m) this.f240a).m609c();
            cVar.f248a.setTextColor(Color.parseColor(this.f243d.f378j.f819B.f768f));
            cVar.f249b.setBackgroundColor(Color.parseColor(this.f243d.f378j.f819B.f767e));
            return true;
        }
        if (cVar.getAdapterPosition() != 0 || C0072d.m382a(i, keyEvent) != 25) {
            return false;
        }
        ((ViewOnKeyListenerC0102m) this.f240a).m607b();
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m423a(final c cVar) {
        int adapterPosition = cVar.getAdapterPosition();
        final String string = "";
        if (this.f245f.names() != null) {
            try {
                cVar.setIsRecyclable(false);
                JSONObject jSONObject = this.f246g.get(adapterPosition);
                string = jSONObject.getString("id");
                cVar.f248a.setText(jSONObject.getString("name"));
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "exception thrown when rendering vendors, err : " + e.getMessage());
            }
        }
        cVar.f248a.setTextColor(Color.parseColor(this.f243d.f378j.f819B.f764b));
        cVar.f249b.setBackgroundColor(Color.parseColor(this.f243d.f378j.f819B.f763a));
        cVar.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: a.a.a.a.b.d.a.a$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.f$0.m420a(string, cVar, view, z);
            }
        });
        cVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: a.a.a.a.b.d.a.a$$ExternalSyntheticLambda1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return this.f$0.m421a(cVar, view, i, keyEvent);
            }
        });
    }
}
