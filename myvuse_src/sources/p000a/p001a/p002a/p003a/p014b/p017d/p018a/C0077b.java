package p000a.p001a.p002a.p003a.p014b.p017d.p018a;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0095f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0119m;

/* JADX INFO: renamed from: a.a.a.a.b.d.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0077b extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a */
    public a f250a;

    /* JADX INFO: renamed from: b */
    public JSONArray f251b;

    /* JADX INFO: renamed from: c */
    public C0087c f252c = C0087c.m482c();

    /* JADX INFO: renamed from: d */
    public int f253d;

    /* JADX INFO: renamed from: e */
    public final JSONObject f254e;

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.b$a */
    public interface a {
    }

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.b$b */
    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f255a;

        /* JADX INFO: renamed from: b */
        public LinearLayout f256b;

        public b(View view) {
            super(view);
            this.f255a = (TextView) view.findViewById(C3896R.id.tv_grp_name);
            this.f256b = (LinearLayout) view.findViewById(C3896R.id.tv_grp_layout);
        }
    }

    public C0077b(Context context, JSONArray jSONArray, a aVar) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        JSONObject jSONObject;
        this.f251b = jSONArray;
        this.f250a = aVar;
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
        }
        String string = (z ? sharedPreferencesC0047f : sharedPreferences).getString("OT_VENDOR_COUNT_FOR_CATEGORIES", "");
        OTLogger.m2743a(3, "IAB2V2Flow", "Getting vendorCountForCategoryString = " + string);
        if (C0048h.m305b(string)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OTSPUtils", "Error on getting vendor count for categories : " + e.getMessage());
                jSONObject = new JSONObject();
            }
        }
        this.f254e = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m426a(JSONObject jSONObject, b bVar, C0119m c0119m, View view, boolean z) {
        if (!z) {
            bVar.f256b.setBackgroundColor(Color.parseColor(c0119m.f763a));
            bVar.f255a.setTextColor(Color.parseColor(c0119m.f764b));
            return;
        }
        a aVar = this.f250a;
        int adapterPosition = bVar.getAdapterPosition();
        ViewOnKeyListenerC0095f viewOnKeyListenerC0095f = (ViewOnKeyListenerC0095f) aVar;
        viewOnKeyListenerC0095f.m563b(jSONObject, false);
        if (adapterPosition != -1) {
            C0077b c0077b = viewOnKeyListenerC0095f.f570p;
            if (adapterPosition != c0077b.f253d) {
                c0077b.f253d = adapterPosition;
                viewOnKeyListenerC0095f.f571q = false;
            }
        }
        bVar.f256b.setBackgroundColor(Color.parseColor(c0119m.f765c));
        bVar.f255a.setTextColor(Color.parseColor(c0119m.f766d));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getTotalPages() {
        return this.f251b.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_pc_list_item_tv, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        b bVar = (b) viewHolder;
        super.onViewAttachedToWindow(bVar);
        if (bVar.getAdapterPosition() == this.f253d) {
            bVar.itemView.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m427a(b bVar, C0119m c0119m, int i, View view, int i2, KeyEvent keyEvent) {
        if (C0072d.m382a(i2, keyEvent) == 22) {
            int adapterPosition = bVar.getAdapterPosition();
            this.f253d = adapterPosition;
            ViewOnKeyListenerC0095f viewOnKeyListenerC0095f = (ViewOnKeyListenerC0095f) this.f250a;
            viewOnKeyListenerC0095f.f571q = true;
            viewOnKeyListenerC0095f.f567m.m530c();
            Bundle bundle = new Bundle();
            bundle.putInt("OT_FOCUSED_PC_LIST_ITEM", adapterPosition);
            viewOnKeyListenerC0095f.setArguments(bundle);
            bVar.f256b.setBackgroundColor(Color.parseColor(c0119m.f767e));
            bVar.f255a.setTextColor(Color.parseColor(c0119m.f768f));
            return true;
        }
        if (C0072d.m382a(i2, keyEvent) == 24) {
            ((ViewOnKeyListenerC0095f) this.f250a).f570p.notifyDataSetChanged();
        }
        if (bVar.getAdapterPosition() == 0 && C0072d.m382a(i2, keyEvent) == 25) {
            bVar.f256b.requestFocus();
            return true;
        }
        if (i != this.f251b.length() - 1 || C0072d.m382a(i2, keyEvent) != 26) {
            return false;
        }
        ViewOnKeyListenerC0095f viewOnKeyListenerC0095f2 = (ViewOnKeyListenerC0095f) this.f250a;
        viewOnKeyListenerC0095f2.f571q = false;
        viewOnKeyListenerC0095f2.f559e.requestFocus();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final b bVar, final int i) {
        StringBuilder sbAppend;
        try {
            final C0119m c0119m = this.f252c.f378j.f819B;
            final JSONObject jSONObject = this.f251b.getJSONObject(bVar.getAdapterPosition());
            bVar.f255a.setTextColor(Color.parseColor(this.f252c.f378j.f819B.f764b));
            bVar.f256b.setBackgroundColor(Color.parseColor(c0119m.f763a));
            C0074f c0074f = new C0074f();
            Context context = bVar.f256b.getContext();
            TextView textView = bVar.f255a;
            JSONObject jSONObject2 = this.f254e;
            C0087c c0087c = this.f252c;
            c0074f.m412a(context, textView, new C0074f().m410a(jSONObject2, jSONObject, c0087c.f374f, c0087c.f373e, jSONObject.optString(C0048h.m305b(jSONObject.optString("GroupNameOTT")) ? "GroupName" : "GroupNameOTT")));
            bVar.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: a.a.a.a.b.d.a.b$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    this.f$0.m426a(jSONObject, bVar, c0119m, view, z);
                }
            });
            bVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: a.a.a.a.b.d.a.b$$ExternalSyntheticLambda1
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                    return this.f$0.m427a(bVar, c0119m, i, view, i2, keyEvent);
                }
            });
        } catch (StringIndexOutOfBoundsException e) {
            sbAppend = new StringBuilder("TV PC: error in rendering groups due to corrupted data,  ").append(e);
            OTLogger.m2743a(6, "OneTrust", sbAppend.toString());
        } catch (JSONException e2) {
            sbAppend = new StringBuilder("TV PC: error in rendering groups ").append(e2.getMessage());
            OTLogger.m2743a(6, "OneTrust", sbAppend.toString());
        }
    }
}
