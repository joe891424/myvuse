package p000a.p001a.p002a.p003a.p014b.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import java.util.ArrayList;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0031z;
import p000a.p001a.p002a.p003a.p014b.DataModels.C0059b;
import p000a.p001a.p002a.p003a.p014b.DataModels.C0060c;
import p000a.p001a.p002a.p003a.p014b.DataModels.C0061d;
import p000a.p001a.p002a.p003a.p014b.DataModels.C0062e;
import p000a.p001a.p002a.p003a.p014b.InterfaceC0075c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p021e.C0129w;

/* JADX INFO: renamed from: a.a.a.a.b.f.h */
/* JADX INFO: loaded from: classes.dex */
public class C0140h extends RecyclerView.Adapter<a> implements InterfaceC0075c {

    /* JADX INFO: renamed from: a */
    public final InterfaceC0075c f1002a;

    /* JADX INFO: renamed from: b */
    public String f1003b;

    /* JADX INFO: renamed from: c */
    public String f1004c;

    /* JADX INFO: renamed from: d */
    public Context f1005d;

    /* JADX INFO: renamed from: e */
    public String f1006e;

    /* JADX INFO: renamed from: f */
    public ArrayList<C0060c> f1007f;

    /* JADX INFO: renamed from: g */
    public C0129w f1008g;

    /* JADX INFO: renamed from: h */
    public C0031z f1009h;

    /* JADX INFO: renamed from: i */
    public OTConfiguration f1010i = null;

    /* JADX INFO: renamed from: j */
    public C0126t f1011j;

    /* JADX INFO: renamed from: a.a.a.a.b.f.h$a */
    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public TextView f1012a;

        /* JADX INFO: renamed from: b */
        public TextView f1013b;

        /* JADX INFO: renamed from: c */
        public SwitchCompat f1014c;

        /* JADX INFO: renamed from: d */
        public RecyclerView f1015d;

        /* JADX INFO: renamed from: e */
        public RecyclerView f1016e;

        /* JADX INFO: renamed from: f */
        public View f1017f;

        public a(View view) {
            super(view);
            this.f1013b = (TextView) view.findViewById(C3896R.id.purpose_name);
            this.f1012a = (TextView) view.findViewById(C3896R.id.purpose_description);
            this.f1016e = (RecyclerView) view.findViewById(C3896R.id.consent_preferences_list_child);
            this.f1015d = (RecyclerView) view.findViewById(C3896R.id.consent_preferences_list_topic);
            this.f1014c = (SwitchCompat) view.findViewById(C3896R.id.purpose_toggle);
            this.f1017f = view.findViewById(C3896R.id.purpose_divider);
        }
    }

    public C0140h(Context context, C0129w c0129w, C0126t c0126t, String str, InterfaceC0075c interfaceC0075c, C0031z c0031z, OTConfiguration oTConfiguration) {
        this.f1005d = context;
        this.f1008g = c0129w;
        this.f1011j = c0126t;
        this.f1007f = c0129w.m669a();
        this.f1006e = str;
        this.f1002a = interfaceC0075c;
        this.f1009h = c0031z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m716a(C0060c c0060c, a aVar, int i, View view) {
        this.f1009h.m225a(c0060c.f148a, aVar.f1014c.isChecked());
        if (aVar.f1014c.isChecked()) {
            m721b(aVar.f1014c);
            this.f1007f.get(i).f158k = "ACTIVE";
            m718a(aVar, c0060c, true);
            return;
        }
        m720a(aVar.f1014c);
        this.f1007f.get(i).f158k = "OPT_OUT";
        m718a(aVar, c0060c, false);
        ArrayList<C0062e> arrayList = c0060c.f156i;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ArrayList<C0061d> arrayList2 = arrayList.get(i2).f172b;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                arrayList2.get(i3).f166h = "OPT_OUT";
            }
        }
        ArrayList<C0059b> arrayList3 = c0060c.f157j;
        for (int i4 = 0; i4 < arrayList3.size(); i4++) {
            ArrayList<C0061d> arrayList4 = arrayList3.get(i4).f147f;
            for (int i5 = 0; i5 < arrayList4.size(); i5++) {
                arrayList4.get(i5).f166h = "OPT_OUT";
            }
        }
    }

    @Override // p000a.p001a.p002a.p003a.p014b.InterfaceC0075c
    /* JADX INFO: renamed from: a */
    public void mo419a(int i) {
        InterfaceC0075c interfaceC0075c = this.f1002a;
        if (interfaceC0075c != null) {
            interfaceC0075c.mo419a(i);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m721b(SwitchCompat switchCompat) {
        Drawable thumbDrawable;
        int color;
        switchCompat.getTrackDrawable().setTint(ContextCompat.getColor(this.f1005d, C3896R.color.light_greyOT));
        if (C0048h.m305b(this.f1011j.f832c)) {
            thumbDrawable = switchCompat.getThumbDrawable();
            color = ContextCompat.getColor(this.f1005d, C3896R.color.colorPrimaryOT);
        } else {
            thumbDrawable = switchCompat.getThumbDrawable();
            color = Color.parseColor(this.f1011j.f832c);
        }
        thumbDrawable.setTint(color);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getTotalPages() {
        return this.f1007f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m717a((a) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_uc_purposes_list, viewGroup, false));
    }

    /* JADX INFO: renamed from: a */
    public void m717a(final a aVar) {
        final int adapterPosition = aVar.getAdapterPosition();
        final C0060c c0060c = this.f1007f.get(adapterPosition);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(aVar.f1016e.getContext(), 1, false);
        linearLayoutManager.setInitialPrefetchItemCount(c0060c.f157j.size());
        aVar.f1016e.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(aVar.f1015d.getContext(), 1, false);
        linearLayoutManager2.setInitialPrefetchItemCount(c0060c.f156i.size());
        aVar.f1015d.setLayoutManager(linearLayoutManager2);
        if (!C0048h.m305b(c0060c.f149b)) {
            this.f1003b = c0060c.f149b;
        }
        if (!C0048h.m305b(c0060c.f150c)) {
            this.f1004c = c0060c.f150c;
        }
        OTLogger.m2743a(3, "OTConsentPreferencesAdapter", "error in setting subgroup consent parent " + c0060c.f156i.size());
        aVar.f1016e.setRecycledViewPool(null);
        aVar.f1015d.setRecycledViewPool(null);
        boolean z = this.f1009h.m237d(c0060c.f148a) == 1;
        aVar.f1014c.setChecked(z);
        String str = this.f1011j.f831b;
        if (!C0048h.m305b(str)) {
            aVar.f1017f.setBackgroundColor(Color.parseColor(str));
        }
        if (z) {
            m721b(aVar.f1014c);
        } else {
            m720a(aVar.f1014c);
        }
        m719a(aVar.f1013b, this.f1011j.f849t, this.f1003b);
        m719a(aVar.f1012a, this.f1011j.f849t, this.f1004c);
        TextView textView = aVar.f1012a;
        C0106b0 c0106b0 = this.f1011j.f841l;
        if (!C0048h.m305b(c0106b0.f722a.f751b)) {
            textView.setTextSize(Float.parseFloat(c0106b0.f722a.f751b));
        }
        aVar.f1014c.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.f.h$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m716a(c0060c, aVar, adapterPosition, view);
            }
        });
        m718a(aVar, c0060c, aVar.f1014c.isChecked());
    }

    /* JADX INFO: renamed from: a */
    public final void m718a(a aVar, C0060c c0060c, boolean z) {
        C0143k c0143k = new C0143k(this.f1005d, c0060c.f156i, this.f1003b, this.f1004c, this.f1011j, this.f1006e, this.f1002a, this.f1009h, z, this.f1010i);
        C0141i c0141i = new C0141i(this.f1005d, c0060c.f157j, this.f1003b, this.f1004c, this.f1011j, this.f1006e, this.f1002a, this.f1009h, z, this.f1010i);
        aVar.f1015d.setAdapter(c0143k);
        aVar.f1016e.setAdapter(c0141i);
    }

    /* JADX INFO: renamed from: a */
    public final void m720a(SwitchCompat switchCompat) {
        Drawable thumbDrawable;
        int color;
        switchCompat.getTrackDrawable().setTint(ContextCompat.getColor(this.f1005d, C3896R.color.light_greyOT));
        if (C0048h.m305b(this.f1011j.f833d)) {
            thumbDrawable = switchCompat.getThumbDrawable();
            color = ContextCompat.getColor(this.f1005d, C3896R.color.contentTextColorOT);
        } else {
            thumbDrawable = switchCompat.getThumbDrawable();
            color = Color.parseColor(this.f1011j.f833d);
        }
        thumbDrawable.setTint(color);
    }

    /* JADX INFO: renamed from: a */
    public final void m719a(TextView textView, C0106b0 c0106b0, String str) {
        String str2 = c0106b0.f724c;
        if (C0048h.m305b(str2)) {
            str2 = this.f1006e;
        }
        textView.setTextColor(Color.parseColor(str2));
        textView.setText(str);
        if (C0048h.m305b(c0106b0.f722a.f751b)) {
            return;
        }
        textView.setTextSize(Float.parseFloat(c0106b0.f722a.f751b));
    }
}
