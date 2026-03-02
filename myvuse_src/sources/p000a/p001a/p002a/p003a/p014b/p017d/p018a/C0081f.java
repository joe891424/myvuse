package p000a.p001a.p002a.p003a.p014b.p017d.p018a;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0101l;

/* JADX INFO: renamed from: a.a.a.a.b.d.a.f */
/* JADX INFO: loaded from: classes.dex */
public class C0081f extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a */
    public final a f290a;

    /* JADX INFO: renamed from: b */
    public JSONArray f291b;

    /* JADX INFO: renamed from: c */
    public String f292c;

    /* JADX INFO: renamed from: d */
    public Map<String, String> f293d;

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.f$a */
    public interface a {
    }

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.f$b */
    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public final TextView f294a;

        /* JADX INFO: renamed from: b */
        public final CheckBox f295b;

        /* JADX INFO: renamed from: c */
        public final LinearLayout f296c;

        /* JADX INFO: renamed from: d */
        public CardView f297d;

        public b(View view) {
            super(view);
            this.f294a = (TextView) view.findViewById(C3896R.id.ot_tv_filter_purpose);
            this.f295b = (CheckBox) view.findViewById(C3896R.id.ot_tv_filter_item_cb);
            this.f296c = (LinearLayout) view.findViewById(C3896R.id.ot_tv_filter_item_layout);
            this.f297d = (CardView) view.findViewById(C3896R.id.ot_tv_filter_item_card);
        }
    }

    public C0081f(JSONArray jSONArray, String str, Map<String, String> map, a aVar) {
        this.f293d = new HashMap();
        this.f291b = jSONArray;
        this.f292c = str;
        this.f290a = aVar;
        this.f293d = new HashMap(map);
    }

    /* JADX INFO: renamed from: a */
    public Map<String, String> m448a() {
        OTLogger.m2743a(4, "OneTrust", "Purposes to pass on apply filters : " + this.f293d);
        return this.f293d;
    }

    /* JADX INFO: renamed from: a */
    public void m450a(CheckBox checkBox, int i) {
        checkBox.setButtonTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{i, i}));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f291b.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m449a((b) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_tv_purpose_filter_item, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m445a(b bVar, C0087c c0087c, String str, View view, boolean z) {
        if (z) {
            bVar.f296c.setBackgroundColor(Color.parseColor(c0087c.f378j.f854y.f736i));
            bVar.f294a.setTextColor(Color.parseColor(c0087c.f378j.f854y.f737j));
            m450a(bVar.f295b, Color.parseColor(c0087c.f378j.f854y.f737j));
            bVar.f297d.setCardElevation(6.0f);
            return;
        }
        bVar.f296c.setBackgroundColor(Color.parseColor(str));
        bVar.f294a.setTextColor(Color.parseColor(this.f292c));
        m450a(bVar.f295b, Color.parseColor(this.f292c));
        bVar.f297d.setCardElevation(1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ boolean m447a(b bVar, View view, int i, KeyEvent keyEvent) {
        if (C0072d.m382a(i, keyEvent) != 21) {
            return false;
        }
        bVar.f295b.setChecked(!r0.isChecked());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m446a(b bVar, String str, String str2, CompoundButton compoundButton, boolean z) {
        String str3;
        if (!bVar.f295b.isChecked()) {
            this.f293d.remove(str);
            ((ViewOnKeyListenerC0101l) this.f290a).f671g = this.f293d;
            str3 = "Purposes Removed : " + str;
        } else {
            if (this.f293d.containsKey(str)) {
                return;
            }
            this.f293d.put(str, str2);
            ((ViewOnKeyListenerC0101l) this.f290a).f671g = this.f293d;
            str3 = "Purposes Added : " + str;
        }
        OTLogger.m2743a(4, "OneTrust", str3);
    }

    /* JADX INFO: renamed from: a */
    public void m449a(final b bVar) {
        bVar.setIsRecyclable(false);
        try {
            final C0087c c0087cM482c = C0087c.m482c();
            JSONObject jSONObject = this.f291b.getJSONObject(bVar.getAdapterPosition());
            bVar.f294a.setText(jSONObject.getString("GroupName"));
            final String strOptString = jSONObject.optString("CustomGroupId", "");
            bVar.f295b.setChecked(m448a() != null ? m448a().containsKey(strOptString) : false);
            final String strM392a = new C0072d().m392a(c0087cM482c.m494b());
            bVar.f296c.setBackgroundColor(Color.parseColor(strM392a));
            bVar.f294a.setTextColor(Color.parseColor(this.f292c));
            m450a(bVar.f295b, Color.parseColor(this.f292c));
            bVar.f297d.setCardElevation(1.0f);
            bVar.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: a.a.a.a.b.d.a.f$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    this.f$0.m445a(bVar, c0087cM482c, strM392a, view, z);
                }
            });
            bVar.f297d.setOnKeyListener(new View.OnKeyListener() { // from class: a.a.a.a.b.d.a.f$$ExternalSyntheticLambda1
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    return C0081f.m447a(bVar, view, i, keyEvent);
                }
            });
            final String string = jSONObject.getString("Type");
            bVar.f295b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.d.a.f$$ExternalSyntheticLambda2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f$0.m446a(bVar, strOptString, string, compoundButton, z);
                }
            });
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while parsing " + e.getMessage());
        }
    }
}
