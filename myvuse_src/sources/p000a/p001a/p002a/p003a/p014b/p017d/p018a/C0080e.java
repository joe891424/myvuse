package p000a.p001a.p002a.p003a.p014b.p017d.p018a;

import android.content.Context;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.p007c.C0006b;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0088d;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0098i;

/* JADX INFO: renamed from: a.a.a.a.b.d.a.e */
/* JADX INFO: loaded from: classes.dex */
public class C0080e extends RecyclerView.Adapter<c> {

    /* JADX INFO: renamed from: i */
    public static final Pattern f276i = Pattern.compile("([a-f]).*");

    /* JADX INFO: renamed from: j */
    public static final Pattern f277j = Pattern.compile("([g-l]).*");

    /* JADX INFO: renamed from: k */
    public static final Pattern f278k = Pattern.compile("([m-r]).*");

    /* JADX INFO: renamed from: l */
    public static final Pattern f279l = Pattern.compile("([s-z]).*");

    /* JADX INFO: renamed from: a */
    public b f280a;

    /* JADX INFO: renamed from: d */
    public List<String> f283d;

    /* JADX INFO: renamed from: e */
    public int f284e;

    /* JADX INFO: renamed from: f */
    public List<JSONObject> f285f;

    /* JADX INFO: renamed from: g */
    public ArrayList<String> f286g;

    /* JADX INFO: renamed from: h */
    public Context f287h;

    /* JADX INFO: renamed from: c */
    public C0087c f282c = C0087c.m482c();

    /* JADX INFO: renamed from: b */
    public JSONArray f281b = C0088d.m503b().m507c();

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.e$a */
    public class a implements Comparator<JSONObject> {
        public a(C0080e c0080e) {
        }

        @Override // java.util.Comparator
        public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
            String lowerCase;
            JSONObject jSONObject3 = jSONObject2;
            String lowerCase2 = "";
            try {
                String string = jSONObject.getString("Name");
                Locale locale = Locale.ENGLISH;
                lowerCase = string.toLowerCase(locale);
                try {
                    lowerCase2 = jSONObject3.getString("Name").toLowerCase(locale);
                } catch (JSONException e) {
                    e = e;
                    OTLogger.m2743a(6, "TVSdkList", "error while sorting VL json object lists,err : " + e.toString());
                }
            } catch (JSONException e2) {
                e = e2;
                lowerCase = "";
            }
            return lowerCase.compareTo(lowerCase2);
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.e$b */
    public interface b {
    }

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.e$c */
    public static class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public final TextView f288a;

        /* JADX INFO: renamed from: b */
        public final LinearLayout f289b;

        public c(View view) {
            super(view);
            this.f288a = (TextView) view.findViewById(C3896R.id.tv_grp_name);
            this.f289b = (LinearLayout) view.findViewById(C3896R.id.tv_grp_layout);
        }
    }

    public C0080e(Context context, b bVar, List<String> list) {
        this.f283d = new ArrayList();
        this.f280a = bVar;
        this.f283d = list;
        this.f287h = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m440a(JSONObject jSONObject, c cVar, View view, boolean z) {
        if (!z) {
            cVar.f288a.setTextColor(Color.parseColor(this.f282c.f378j.f819B.f764b));
            cVar.f289b.setBackgroundColor(Color.parseColor(this.f282c.f378j.f819B.f763a));
            return;
        }
        ViewOnKeyListenerC0098i viewOnKeyListenerC0098i = (ViewOnKeyListenerC0098i) this.f280a;
        viewOnKeyListenerC0098i.f606B = false;
        viewOnKeyListenerC0098i.m576a(jSONObject);
        cVar.f288a.setTextColor(Color.parseColor(this.f282c.f378j.f819B.f766d));
        cVar.f289b.setBackgroundColor(Color.parseColor(this.f282c.f378j.f819B.f765c));
        if (cVar.getAdapterPosition() == -1 || cVar.getAdapterPosition() == this.f284e) {
            return;
        }
        this.f284e = cVar.getAdapterPosition();
    }

    /* JADX INFO: renamed from: a */
    public final void m444a(List<JSONObject> list, JSONObject jSONObject) {
        String strTrim = jSONObject.getString("Name").toLowerCase(Locale.ENGLISH).trim();
        if (this.f286g.contains("A_F") && f276i.matcher(strTrim).matches()) {
            list.add(jSONObject);
        }
        if (this.f286g.contains("G_L") && f277j.matcher(strTrim).matches()) {
            list.add(jSONObject);
        }
        if (this.f286g.contains("M_R") && f278k.matcher(strTrim).matches()) {
            list.add(jSONObject);
        }
        if (this.f286g.contains("S_Z") && f279l.matcher(strTrim).matches()) {
            list.add(jSONObject);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getTotalPages() {
        return this.f285f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m443a((c) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_pc_list_item_tv, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        c cVar = (c) viewHolder;
        super.onViewAttachedToWindow(cVar);
        if (cVar.getAdapterPosition() == this.f284e) {
            cVar.itemView.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m441a(c cVar, View view, int i, KeyEvent keyEvent) {
        Button button;
        if (C0072d.m382a(i, keyEvent) == 22) {
            this.f284e = cVar.getAdapterPosition();
            ViewOnKeyListenerC0098i viewOnKeyListenerC0098i = (ViewOnKeyListenerC0098i) this.f280a;
            viewOnKeyListenerC0098i.f606B = true;
            viewOnKeyListenerC0098i.f622o.m564a();
            viewOnKeyListenerC0098i.f625r.clearFocus();
            viewOnKeyListenerC0098i.f624q.clearFocus();
            viewOnKeyListenerC0098i.f623p.clearFocus();
            cVar.f288a.setTextColor(Color.parseColor(this.f282c.f378j.f819B.f768f));
            cVar.f289b.setBackgroundColor(Color.parseColor(this.f282c.f378j.f819B.f767e));
            return true;
        }
        if (cVar.getAdapterPosition() != 0 || C0072d.m382a(i, keyEvent) != 25) {
            return false;
        }
        ViewOnKeyListenerC0098i viewOnKeyListenerC0098i2 = (ViewOnKeyListenerC0098i) this.f280a;
        if (viewOnKeyListenerC0098i2.f632y.equals("A_F")) {
            button = viewOnKeyListenerC0098i2.f626s;
        } else if (viewOnKeyListenerC0098i2.f632y.equals("G_L")) {
            button = viewOnKeyListenerC0098i2.f627t;
        } else {
            if (!viewOnKeyListenerC0098i2.f632y.equals("M_R")) {
                if (viewOnKeyListenerC0098i2.f632y.equals("S_Z")) {
                    button = viewOnKeyListenerC0098i2.f629v;
                }
                return true;
            }
            button = viewOnKeyListenerC0098i2.f628u;
        }
        button.requestFocus();
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m443a(final c cVar) {
        JSONException e;
        JSONObject jSONObject;
        int adapterPosition = cVar.getAdapterPosition();
        OTLogger.m2743a(2, "TVSdkList", "filtered sdks count " + this.f285f.size());
        final JSONObject jSONObject2 = new JSONObject();
        if (this.f285f != null) {
            try {
                cVar.setIsRecyclable(false);
                jSONObject = this.f285f.get(adapterPosition);
                try {
                    new C0074f().m412a(cVar.f289b.getContext(), cVar.f288a, jSONObject.getString("Name"));
                } catch (JSONException e2) {
                    e = e2;
                    OTLogger.m2743a(6, "OneTrust", "exception thrown when rendering SDKs, err : " + e.getMessage());
                }
            } catch (JSONException e3) {
                e = e3;
                jSONObject = jSONObject2;
            }
            jSONObject2 = jSONObject;
        }
        cVar.f288a.setTextColor(Color.parseColor(this.f282c.f378j.f819B.f764b));
        cVar.f289b.setBackgroundColor(Color.parseColor(this.f282c.f378j.f819B.f763a));
        cVar.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: a.a.a.a.b.d.a.e$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.f$0.m440a(jSONObject2, cVar, view, z);
            }
        });
        cVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: a.a.a.a.b.d.a.e$$ExternalSyntheticLambda1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return this.f$0.m441a(cVar, view, i, keyEvent);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public List<JSONObject> m442a() {
        JSONArray jSONArrayM21a = new C0006b(this.f287h).m21a(this.f283d, this.f281b);
        this.f285f = new ArrayList();
        if (this.f286g == null) {
            this.f286g = new ArrayList<>();
        }
        if (C0032d.m239a(jSONArrayM21a)) {
            OTLogger.m2743a(6, "TVSdkList", "setSDKListData: Empty data found for SDKs");
            return null;
        }
        for (int i = 0; i < jSONArrayM21a.length(); i++) {
            try {
                JSONObject jSONObject = jSONArrayM21a.getJSONObject(i);
                if (this.f286g.isEmpty()) {
                    this.f285f.add(jSONObject);
                } else {
                    m444a(this.f285f, jSONObject);
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "TVSdkList", "error while constructing SDK List json object lists,err : " + e.toString());
            }
        }
        Collections.sort(this.f285f, new a(this));
        return this.f285f;
    }
}
