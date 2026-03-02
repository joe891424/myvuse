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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0097h;

/* JADX INFO: renamed from: a.a.a.a.b.d.a.d */
/* JADX INFO: loaded from: classes.dex */
public class C0079d extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a */
    public final a f268a;

    /* JADX INFO: renamed from: b */
    public JSONArray f269b;

    /* JADX INFO: renamed from: c */
    public String f270c;

    /* JADX INFO: renamed from: d */
    public List<String> f271d;

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.d$a */
    public interface a {
    }

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.d$b */
    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public final TextView f272a;

        /* JADX INFO: renamed from: b */
        public final CheckBox f273b;

        /* JADX INFO: renamed from: c */
        public final LinearLayout f274c;

        /* JADX INFO: renamed from: d */
        public CardView f275d;

        public b(View view) {
            super(view);
            this.f272a = (TextView) view.findViewById(C3896R.id.ot_tv_filter_purpose);
            this.f273b = (CheckBox) view.findViewById(C3896R.id.ot_tv_filter_item_cb);
            this.f274c = (LinearLayout) view.findViewById(C3896R.id.ot_tv_filter_item_layout);
            this.f275d = (CardView) view.findViewById(C3896R.id.ot_tv_filter_item_card);
        }
    }

    public C0079d(JSONArray jSONArray, String str, List<String> list, a aVar) {
        new ArrayList();
        this.f269b = jSONArray;
        this.f270c = str;
        this.f268a = aVar;
        this.f271d = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m435a(b bVar, C0087c c0087c, String str, View view, boolean z) {
        if (z) {
            bVar.f274c.setBackgroundColor(Color.parseColor(c0087c.f378j.f854y.f736i));
            bVar.f272a.setTextColor(Color.parseColor(c0087c.f378j.f854y.f737j));
            m439a(bVar.f273b, Color.parseColor(c0087c.f378j.f854y.f737j));
            bVar.f275d.setCardElevation(6.0f);
            return;
        }
        bVar.f274c.setBackgroundColor(Color.parseColor(str));
        bVar.f272a.setTextColor(Color.parseColor(this.f270c));
        m439a(bVar.f273b, Color.parseColor(this.f270c));
        bVar.f275d.setCardElevation(1.0f);
    }

    /* JADX INFO: renamed from: a */
    public void m439a(CheckBox checkBox, int i) {
        checkBox.setButtonTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{i, i}));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f269b.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m438a((b) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_tv_purpose_filter_item, viewGroup, false));
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ boolean m437a(b bVar, View view, int i, KeyEvent keyEvent) {
        if (C0072d.m382a(i, keyEvent) != 21) {
            return false;
        }
        bVar.f273b.setChecked(!r0.isChecked());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m436a(b bVar, String str, CompoundButton compoundButton, boolean z) {
        String str2;
        if (!bVar.f273b.isChecked()) {
            this.f271d.remove(str);
            ((ViewOnKeyListenerC0097h) this.f268a).f601g = this.f271d;
            str2 = "Purposes Removed : " + str;
        } else {
            if (this.f271d.contains(str)) {
                return;
            }
            this.f271d.add(str);
            ((ViewOnKeyListenerC0097h) this.f268a).f601g = this.f271d;
            str2 = "Purposes Added : " + str;
        }
        OTLogger.m2743a(4, "OneTrust", str2);
    }

    /* JADX INFO: renamed from: a */
    public void m438a(final b bVar) {
        boolean z = false;
        bVar.setIsRecyclable(false);
        try {
            final C0087c c0087cM482c = C0087c.m482c();
            JSONObject jSONObject = this.f269b.getJSONObject(bVar.getAdapterPosition());
            bVar.f272a.setText(jSONObject.getString("GroupName"));
            final String strOptString = jSONObject.optString("CustomGroupId", "");
            int i = 0;
            while (true) {
                if (i >= this.f271d.size()) {
                    break;
                }
                if (this.f271d.get(i).trim().equals(strOptString)) {
                    z = true;
                    break;
                }
                i++;
            }
            bVar.f273b.setChecked(z);
            final String strM392a = new C0072d().m392a(c0087cM482c.m494b());
            bVar.f274c.setBackgroundColor(Color.parseColor(strM392a));
            bVar.f272a.setTextColor(Color.parseColor(this.f270c));
            m439a(bVar.f273b, Color.parseColor(this.f270c));
            bVar.f275d.setCardElevation(1.0f);
            bVar.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: a.a.a.a.b.d.a.d$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z2) {
                    this.f$0.m435a(bVar, c0087cM482c, strM392a, view, z2);
                }
            });
            bVar.f275d.setOnKeyListener(new View.OnKeyListener() { // from class: a.a.a.a.b.d.a.d$$ExternalSyntheticLambda1
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                    return C0079d.m437a(bVar, view, i2, keyEvent);
                }
            });
            bVar.f273b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.d.a.d$$ExternalSyntheticLambda2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    this.f$0.m436a(bVar, strOptString, compoundButton, z2);
                }
            });
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while parsing " + e.getMessage());
        }
    }
}
