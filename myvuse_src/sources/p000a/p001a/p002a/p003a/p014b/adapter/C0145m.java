package p000a.p001a.p002a.p003a.p014b.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import org.json.JSONArray;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0131y;

/* JADX INFO: renamed from: a.a.a.a.b.f.m */
/* JADX INFO: loaded from: classes.dex */
public class C0145m extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a */
    public final OTConfiguration f1069a;

    /* JADX INFO: renamed from: b */
    public JSONArray f1070b;

    /* JADX INFO: renamed from: c */
    public String f1071c;

    /* JADX INFO: renamed from: d */
    public C0131y f1072d;

    /* JADX INFO: renamed from: e */
    public String f1073e;

    /* JADX INFO: renamed from: a.a.a.a.b.f.m$a */
    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f1074a;

        public a(View view) {
            super(view);
            this.f1074a = (TextView) view.findViewById(C3896R.id.vd_purpose_item);
        }
    }

    public C0145m(JSONArray jSONArray, String str, C0131y c0131y, OTConfiguration oTConfiguration, String str2) {
        this.f1070b = jSONArray;
        this.f1071c = str;
        this.f1072d = c0131y;
        this.f1069a = oTConfiguration;
        this.f1073e = str2;
    }

    /* JADX INFO: renamed from: a */
    public final void m738a(a aVar) {
        Typeface typeface;
        Typeface otTypeFaceMap;
        if (!C0048h.m305b(this.f1072d.f892g.f722a.f751b)) {
            aVar.f1074a.setTextSize(Float.parseFloat(this.f1072d.f892g.f722a.f751b));
        }
        if (!C0048h.m305b(this.f1072d.f892g.f723b)) {
            aVar.f1074a.setTextAlignment(Integer.parseInt(this.f1072d.f892g.f723b));
        }
        C0115i c0115i = this.f1072d.f892g.f722a;
        TextView textView = aVar.f1074a;
        OTConfiguration oTConfiguration = this.f1069a;
        String str = c0115i.f753d;
        if (!C0048h.m305b(str) && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str)) != null) {
            textView.setTypeface(otTypeFaceMap);
            return;
        }
        int style = c0115i.f752c;
        if (style == -1 && (typeface = textView.getTypeface()) != null) {
            style = typeface.getStyle();
        }
        textView.setTypeface(!C0048h.m305b(c0115i.f750a) ? Typeface.create(c0115i.f750a, style) : Typeface.create(textView.getTypeface(), style));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f1070b.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        aVar.setIsRecyclable(false);
        try {
            aVar.f1074a.setText(this.f1070b.getJSONObject(aVar.getAdapterPosition()).getString(OTVendorListMode.GENERAL.equalsIgnoreCase(this.f1073e) ? "Name" : "name"));
            aVar.f1074a.setTextColor(Color.parseColor(this.f1071c));
            TextView textView = aVar.f1074a;
            String str = this.f1071c;
            for (Drawable drawable : textView.getCompoundDrawablesRelative()) {
                if (drawable != null) {
                    drawable.setColorFilter(new PorterDuffColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_IN));
                }
            }
            if (this.f1072d != null) {
                m738a(aVar);
            }
        } catch (Exception e) {
            OTLogger.m2743a(6, "OneTrust", "error while rendering purpose items in Vendor detail screen " + e.getMessage());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_vendor_details_purpose_item, viewGroup, false));
    }
}
