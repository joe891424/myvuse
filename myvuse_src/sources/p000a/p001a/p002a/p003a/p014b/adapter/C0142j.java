package p000a.p001a.p002a.p003a.p014b.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.C3896R;
import java.util.List;
import java.util.Objects;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0031z;
import p000a.p001a.p002a.p003a.p014b.DataModels.C0061d;
import p000a.p001a.p002a.p003a.p014b.InterfaceC0075c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;

/* JADX INFO: renamed from: a.a.a.a.b.f.j */
/* JADX INFO: loaded from: classes.dex */
public class C0142j extends RecyclerView.Adapter<a> implements InterfaceC0075c {

    /* JADX INFO: renamed from: a */
    public String f1033a;

    /* JADX INFO: renamed from: b */
    public String f1034b;

    /* JADX INFO: renamed from: c */
    public int f1035c = -1;

    /* JADX INFO: renamed from: d */
    public RadioButton f1036d;

    /* JADX INFO: renamed from: e */
    public List<C0061d> f1037e;

    /* JADX INFO: renamed from: f */
    public C0031z f1038f;

    /* JADX INFO: renamed from: g */
    public boolean f1039g;

    /* JADX INFO: renamed from: h */
    public String f1040h;

    /* JADX INFO: renamed from: i */
    public C0126t f1041i;

    /* JADX INFO: renamed from: a.a.a.a.b.f.j$a */
    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public CheckBox f1042a;

        /* JADX INFO: renamed from: b */
        public RadioButton f1043b;

        public a(View view) {
            super(view);
            this.f1042a = (CheckBox) view.findViewById(C3896R.id.multi_selection);
            this.f1043b = (RadioButton) view.findViewById(C3896R.id.single_selection);
        }
    }

    public C0142j(List<C0061d> list, String str, String str2, C0031z c0031z, boolean z, String str3, C0126t c0126t) {
        this.f1037e = list;
        this.f1034b = str;
        this.f1033a = str2;
        this.f1038f = c0031z;
        this.f1039g = z;
        this.f1041i = c0126t;
        this.f1040h = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m726a(a aVar, View view) {
        RadioButton radioButton = this.f1036d;
        if (radioButton != null) {
            radioButton.setChecked(false);
        }
        aVar.f1043b.setChecked(true);
        this.f1036d = aVar.f1043b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m727b(a aVar, int i, View view) {
        C0061d c0061d;
        String str;
        if (aVar.f1042a.isChecked()) {
            this.f1038f.m224a(this.f1037e.get(i).f169k, this.f1037e.get(i).f167i, true, this.f1037e.get(i).f159a);
            c0061d = this.f1037e.get(i);
            str = "OPT_IN";
        } else {
            this.f1038f.m224a(this.f1037e.get(i).f169k, this.f1037e.get(i).f167i, false, this.f1037e.get(i).f159a);
            c0061d = this.f1037e.get(i);
            str = "OPT_OUT";
        }
        c0061d.f166h = str;
    }

    @Override // p000a.p001a.p002a.p003a.p014b.InterfaceC0075c
    /* JADX INFO: renamed from: a */
    public void mo419a(int i) {
        if (i == 4) {
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f1037e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m728a((a) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(C3896R.layout.ot_uc_purposes_options_item, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m725a(a aVar, int i, View view) {
        C0061d c0061d;
        String str;
        if (aVar.f1042a.isChecked()) {
            this.f1038f.m236c(this.f1037e.get(i).f170l, (String) Objects.requireNonNull(this.f1037e.get(i).f159a), true);
            c0061d = this.f1037e.get(i);
            str = "OPT_IN";
        } else {
            this.f1038f.m236c(this.f1037e.get(i).f170l, (String) Objects.requireNonNull(this.f1037e.get(i).f159a), false);
            c0061d = this.f1037e.get(i);
            str = "OPT_OUT";
        }
        c0061d.f166h = str;
    }

    /* JADX INFO: renamed from: a */
    public void m728a(final a aVar) {
        final int adapterPosition = aVar.getAdapterPosition();
        aVar.f1042a.setEnabled(this.f1039g);
        C0106b0 c0106b0 = this.f1041i.f841l;
        m724a(c0106b0, this.f1040h, aVar.f1042a);
        m724a(c0106b0, this.f1040h, aVar.f1043b);
        if (this.f1039g) {
            C0170b.m954a(aVar.f1042a, Color.parseColor(this.f1040h), Color.parseColor(this.f1040h));
        }
        C0170b.m954a(aVar.f1043b, Color.parseColor(this.f1040h), Color.parseColor(this.f1040h));
        if (!this.f1034b.equals("customPrefOptionType")) {
            if (this.f1034b.equals("topicOptionType") && this.f1033a.equals("null")) {
                aVar.f1043b.setVisibility(8);
                aVar.f1042a.setVisibility(0);
                aVar.f1042a.setText(this.f1037e.get(adapterPosition).f161c);
                aVar.f1042a.setChecked(this.f1038f.m218a(this.f1037e.get(adapterPosition).f159a, this.f1037e.get(adapterPosition).f168j) == 1);
                aVar.f1042a.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.f.j$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.m725a(aVar, adapterPosition, view);
                    }
                });
                return;
            }
            return;
        }
        if ("MULTI_CHOICE".equals(this.f1033a)) {
            aVar.f1043b.setVisibility(8);
            aVar.f1042a.setVisibility(0);
            aVar.f1042a.setText(this.f1037e.get(adapterPosition).f163e);
            aVar.f1042a.setChecked(this.f1038f.m219a(this.f1037e.get(adapterPosition).f159a, this.f1037e.get(adapterPosition).f168j, this.f1037e.get(adapterPosition).f169k) == 1);
            m729a(aVar, adapterPosition);
        } else if ("SINGLE_CHOICE".equals(this.f1033a)) {
            aVar.f1043b.setText(this.f1037e.get(adapterPosition).f163e);
            aVar.f1043b.setTag(Integer.valueOf(adapterPosition));
            aVar.f1043b.setChecked(adapterPosition == this.f1035c);
            aVar.f1042a.setVisibility(8);
            aVar.f1043b.setVisibility(0);
            if (this.f1036d == null) {
                aVar.f1043b.setChecked(this.f1037e.get(adapterPosition).f166h.equals("OPT_IN"));
                this.f1036d = aVar.f1043b;
            }
        }
        aVar.f1043b.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.f.j$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m726a(aVar, view);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final void m729a(final a aVar, final int i) {
        aVar.f1042a.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.f.j$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m727b(aVar, i, view);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m724a(C0106b0 c0106b0, String str, TextView textView) {
        if (!C0048h.m305b(str)) {
            textView.setTextColor(Color.parseColor(str));
        }
        String str2 = c0106b0.f722a.f751b;
        if (C0048h.m305b(str2)) {
            return;
        }
        textView.setTextSize(Float.parseFloat(str2));
    }
}
