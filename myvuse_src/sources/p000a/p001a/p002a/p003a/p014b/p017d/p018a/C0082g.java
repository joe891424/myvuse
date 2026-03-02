package p000a.p001a.p002a.p003a.p014b.p017d.p018a;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONArray;

/* JADX INFO: renamed from: a.a.a.a.b.d.a.g */
/* JADX INFO: loaded from: classes.dex */
public class C0082g extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a */
    public JSONArray f298a;

    /* JADX INFO: renamed from: b */
    public String f299b;

    /* JADX INFO: renamed from: a.a.a.a.b.d.a.g$a */
    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f300a;

        public a(View view) {
            super(view);
            this.f300a = (TextView) view.findViewById(C3896R.id.tv_vd_purpose_item);
        }
    }

    public C0082g(JSONArray jSONArray, String str) {
        this.f298a = jSONArray;
        this.f299b = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f298a.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        aVar.setIsRecyclable(false);
        try {
            aVar.f300a.setText(this.f298a.getJSONObject(aVar.getAdapterPosition()).getString("name"));
            aVar.f300a.setTextColor(Color.parseColor(this.f299b));
            TextView textView = aVar.f300a;
            String str = this.f299b;
            for (Drawable drawable : textView.getCompoundDrawables()) {
                if (drawable != null) {
                    drawable.setColorFilter(new PorterDuffColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_IN));
                }
            }
        } catch (Exception e) {
            OTLogger.m2743a(6, "OneTrust", "error while rendering purpose items in Vendor detail screen " + e.getMessage());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_tv_vendor_details_purpose_item, viewGroup, false));
    }
}
