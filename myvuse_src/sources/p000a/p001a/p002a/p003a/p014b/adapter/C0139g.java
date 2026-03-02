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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0164j;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0128v;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;
import p000a.p001a.p002a.p003a.p014b.p025i.C0173e;

/* JADX INFO: renamed from: a.a.a.a.b.f.g */
/* JADX INFO: loaded from: classes.dex */
public class C0139g extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a */
    public final OTConfiguration f994a;

    /* JADX INFO: renamed from: b */
    public JSONArray f995b;

    /* JADX INFO: renamed from: c */
    public List<String> f996c;

    /* JADX INFO: renamed from: d */
    public C0128v f997d;

    /* JADX INFO: renamed from: e */
    public a f998e;

    /* JADX INFO: renamed from: a.a.a.a.b.f.g$a */
    public interface a {
    }

    /* JADX INFO: renamed from: a.a.a.a.b.f.g$b */
    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f999a;

        /* JADX INFO: renamed from: b */
        public CheckBox f1000b;

        /* JADX INFO: renamed from: c */
        public View f1001c;

        public b(View view) {
            super(view);
            this.f999a = (TextView) view.findViewById(C3896R.id.category_name);
            this.f1000b = (CheckBox) view.findViewById(C3896R.id.category_select);
            this.f1001c = view.findViewById(C3896R.id.sdk_name_divider);
        }
    }

    public C0139g(JSONArray jSONArray, List<String> list, OTConfiguration oTConfiguration, C0173e c0173e, a aVar) {
        this.f995b = jSONArray;
        this.f997d = c0173e.m990a();
        this.f994a = oTConfiguration;
        this.f998e = aVar;
        m715a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m712a(b bVar, String str, String str2, String str3, View view) {
        String str4;
        boolean zIsChecked = bVar.f1000b.isChecked();
        C0170b.m954a(bVar.f1000b, Color.parseColor(str), Color.parseColor(str2));
        if (!zIsChecked) {
            boolean zRemove = this.f996c.remove(str3);
            a aVar = this.f998e;
            List<String> list = this.f996c;
            ViewOnClickListenerC0164j viewOnClickListenerC0164j = (ViewOnClickListenerC0164j) aVar;
            viewOnClickListenerC0164j.getClass();
            viewOnClickListenerC0164j.f1345l = Collections.unmodifiableList(list);
            str4 = "onClick remove:" + str3 + ", status : " + zRemove;
        } else {
            if (this.f996c.contains(str3)) {
                return;
            }
            this.f996c.add(str3);
            a aVar2 = this.f998e;
            List<String> list2 = this.f996c;
            ViewOnClickListenerC0164j viewOnClickListenerC0164j2 = (ViewOnClickListenerC0164j) aVar2;
            viewOnClickListenerC0164j2.getClass();
            viewOnClickListenerC0164j2.f1345l = Collections.unmodifiableList(list2);
            str4 = "onClick add:" + str3;
        }
        OTLogger.m2743a(4, "OTPurposeListAdapter", str4);
    }

    /* JADX INFO: renamed from: a */
    public final void m715a(List<String> list) {
        this.f996c = new ArrayList(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f995b.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m713a((b) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_sdk_list_filter_item, viewGroup, false));
    }

    /* JADX INFO: renamed from: a */
    public void m713a(final b bVar) {
        boolean z = false;
        bVar.setIsRecyclable(false);
        try {
            JSONObject jSONObject = this.f995b.getJSONObject(bVar.getAdapterPosition());
            String string = jSONObject.getString("GroupName");
            bVar.f999a.setText(string);
            if (this.f997d == null) {
                return;
            }
            bVar.f999a.setLabelFor(C3896R.id.category_select);
            C0128v c0128v = this.f997d;
            final String str = c0128v.f866j;
            final String str2 = c0128v.f868l.f724c;
            final String string2 = jSONObject.getString("CustomGroupId");
            int i = 0;
            while (true) {
                if (i >= this.f996c.size()) {
                    break;
                }
                if (this.f996c.get(i).trim().equals(string2)) {
                    z = true;
                    break;
                }
                i++;
            }
            OTLogger.m2743a(3, "OTPurposeListAdapter", "CategoryName : " + string + ", purpose status : " + z);
            bVar.f1000b.setChecked(z);
            m714a(bVar.f999a, this.f997d.f868l);
            C0170b.m954a(bVar.f1000b, Color.parseColor(str), Color.parseColor(str2));
            String str3 = this.f997d.f858b;
            C0170b.m953a(bVar.f1001c, str3);
            if (bVar.getAdapterPosition() == 0) {
                OTLogger.m2743a(3, "OT_Automation", "setLineBreakColor SDK Filter List: " + str3);
            }
            bVar.f1000b.setContentDescription("Filter");
            bVar.f1000b.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.f.g$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m712a(bVar, str, str2, string2, view);
                }
            });
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while parsing " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m714a(TextView textView, C0106b0 c0106b0) {
        Typeface typeface;
        Typeface otTypeFaceMap;
        C0115i c0115i = c0106b0.f722a;
        OTConfiguration oTConfiguration = this.f994a;
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
