package p000a.p001a.p002a.p003a.p014b.p017d.p018a;

import android.content.Context;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0086b;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0119m;

/* JADX INFO: renamed from: a.a.a.a.b.d.a.c */
/* JADX INFO: loaded from: classes.dex */
public class C0078c extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a */
    public a f257a;

    /* JADX INFO: renamed from: b */
    public JSONArray f258b;

    /* JADX INFO: renamed from: c */
    public Context f259c;

    /* JADX INFO: renamed from: d */
    public OTPublishersHeadlessSDK f260d;

    /* JADX INFO: renamed from: e */
    public C0086b f261e = C0086b.m475a();

    /* JADX INFO: renamed from: f */
    public C0087c f262f = C0087c.m482c();

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.c$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo433a();

        /* JADX INFO: renamed from: a */
        void mo434a(JSONObject jSONObject, boolean z);
    }

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.c$b */
    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f263a;

        /* JADX INFO: renamed from: b */
        public TextView f264b;

        /* JADX INFO: renamed from: c */
        public TextView f265c;

        /* JADX INFO: renamed from: d */
        public ImageView f266d;

        /* JADX INFO: renamed from: e */
        public LinearLayout f267e;

        public b(View view) {
            super(view);
            this.f264b = (TextView) view.findViewById(C3896R.id.tv_grp_name);
            this.f265c = (TextView) view.findViewById(C3896R.id.always_active_textview);
            this.f263a = (TextView) view.findViewById(C3896R.id.group_status_text);
            this.f266d = (ImageView) view.findViewById(C3896R.id.group_show_more);
            this.f267e = (LinearLayout) view.findViewById(C3896R.id.tv_grp_layout);
        }
    }

    public C0078c(JSONArray jSONArray, Context context, OTPublishersHeadlessSDK oTPublishersHeadlessSDK, a aVar) {
        this.f259c = context;
        this.f258b = jSONArray;
        this.f260d = oTPublishersHeadlessSDK;
        this.f257a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m429a(b bVar, String str, View view, boolean z) {
        String strM498d;
        if (z) {
            C0119m c0119m = this.f262f.f378j.f819B;
            strM498d = c0119m.f766d;
            str = c0119m.f765c;
        } else {
            strM498d = this.f262f.m498d();
        }
        m430a(bVar, strM498d, str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getTotalPages() {
        JSONArray jSONArray = this.f258b;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.f259c).inflate(C3896R.layout.ot_pc_groupitem_tv, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m431a(b bVar, View view, int i, KeyEvent keyEvent) {
        if (C0072d.m382a(i, keyEvent) == 22 || C0072d.m382a(i, keyEvent) == 21) {
            try {
                this.f257a.mo434a(this.f258b.getJSONObject(bVar.getAdapterPosition()), true);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "Error in navigating to subgroups : " + e.getMessage());
            }
        }
        if (C0072d.m382a(i, keyEvent) != 24) {
            return false;
        }
        this.f257a.mo433a();
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final b bVar, int i) {
        String str;
        try {
            if (!this.f258b.getJSONObject(bVar.getAdapterPosition()).getString("Status").contains(ReactScrollViewHelper.OVER_SCROLL_ALWAYS) && !this.f258b.getJSONObject(bVar.getAdapterPosition()).getString("Type").equals("IAB2_SPL_PURPOSE") && !this.f258b.getJSONObject(bVar.getAdapterPosition()).getString("Type").equals("IAB2_FEATURE")) {
                bVar.f265c.setVisibility(8);
                bVar.f263a.setVisibility(0);
            } else {
                bVar.f265c.setVisibility(0);
                bVar.f265c.setText(C0087c.m482c().m487a());
                bVar.f263a.setVisibility(8);
            }
            C0074f c0074f = new C0074f();
            Context context = this.f259c;
            TextView textView = bVar.f264b;
            JSONObject jSONObject = this.f258b.getJSONObject(bVar.getAdapterPosition());
            c0074f.m412a(context, textView, jSONObject.optString(C0048h.m305b(jSONObject.optString("GroupNameOTT")) ? "GroupName" : "GroupNameOTT"));
            bVar.f266d.setVisibility(0);
            if (this.f260d.getPurposeConsentLocal(this.f258b.getJSONObject(i).optString("CustomGroupId", "")) == 1) {
                str = this.f261e.f347b;
            } else {
                str = this.f261e.f348c;
            }
            bVar.f263a.setText(str);
            final String strM392a = new C0072d().m392a(this.f262f.m494b());
            m430a(bVar, this.f262f.m498d(), strM392a);
            bVar.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: a.a.a.a.b.d.a.c$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    this.f$0.m429a(bVar, strM392a, view, z);
                }
            });
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "Error while rendering subgroup " + e.getMessage());
        }
        bVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: a.a.a.a.b.d.a.c$$ExternalSyntheticLambda1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                return this.f$0.m431a(bVar, view, i2, keyEvent);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m430a(b bVar, String str, String str2) {
        bVar.f267e.setBackgroundColor(Color.parseColor(str2));
        bVar.f264b.setTextColor(Color.parseColor(str));
        bVar.f263a.setTextColor(Color.parseColor(str));
        bVar.f265c.setTextColor(Color.parseColor(str));
        bVar.f266d.getDrawable().setTint(Color.parseColor(str));
    }
}
