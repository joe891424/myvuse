package p000a.p001a.p002a.p003a.p014b.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p014b.DataModels.VendorItem;
import p000a.p001a.p002a.p003a.p014b.DataModels.VendorListData;
import p000a.p001a.p002a.p003a.p014b.adapter.OTVendorGoogleAdapter;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p023g.C0154d;
import p000a.p001a.p002a.p003a.p027c.C0181d;

/* JADX INFO: renamed from: a.a.a.a.b.f.r, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 BO\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00126\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\t¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015H\u0016R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R>\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/adapter/OTVendorGoogleAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorItem;", "Lcom/onetrust/otpublishers/headless/UI/adapter/OTVendorGoogleAdapter$VendorViewHolder;", "vendorListData", "Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorListData;", "otConfiguration", "Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;", "onItemToggleCheckedChange", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "", "isChecked", "", "(Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorListData;Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;Lkotlin/jvm/functions/Function2;)V", "inflater", "Landroid/view/LayoutInflater;", "getItemCount", "", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", ViewProps.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "VendorViewHolder", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class OTVendorGoogleAdapter extends ListAdapter<VendorItem, a> {

    /* JADX INFO: renamed from: a */
    public final VendorListData f1108a;

    /* JADX INFO: renamed from: b */
    public final OTConfiguration f1109b;

    /* JADX INFO: renamed from: c */
    public final Function2<String, Boolean, Unit> f1110c;

    /* JADX INFO: renamed from: d */
    public LayoutInflater f1111d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OTVendorGoogleAdapter(VendorListData vendorListData, OTConfiguration oTConfiguration, Function2<? super String, ? super Boolean, Unit> onItemToggleCheckedChange) {
        super(new OTVendorDiffCallBack());
        Intrinsics.checkNotNullParameter(vendorListData, "vendorListData");
        Intrinsics.checkNotNullParameter(onItemToggleCheckedChange, "onItemToggleCheckedChange");
        this.f1108a = vendorListData;
        this.f1109b = oTConfiguration;
        this.f1110c = onItemToggleCheckedChange;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<VendorItem> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "currentList");
        VendorItem vendorItem = (VendorItem) CollectionsKt.getOrNull(currentList, i);
        boolean z = i == getTotalPages() - 1;
        C0181d c0181d = holder.f1112a;
        RelativeLayout vlItems = c0181d.f1619g;
        Intrinsics.checkNotNullExpressionValue(vlItems, "vlItems");
        vlItems.setVisibility(!z ? 0 : 8);
        View view3 = c0181d.f1617e;
        Intrinsics.checkNotNullExpressionValue(view3, "view3");
        view3.setVisibility(!z ? 0 : 8);
        SwitchCompat switchButton = c0181d.f1615c;
        Intrinsics.checkNotNullExpressionValue(switchButton, "switchButton");
        switchButton.setVisibility(!z ? 0 : 8);
        TextView viewPoweredByLogo = c0181d.f1618f;
        Intrinsics.checkNotNullExpressionValue(viewPoweredByLogo, "viewPoweredByLogo");
        viewPoweredByLogo.setVisibility(z ? 0 : 8);
        if (!z && vendorItem != null) {
            c0181d.f1616d.setText(vendorItem.f199b);
            c0181d.f1616d.setLabelFor(C3896R.id.switchButton);
            C0181d c0181d2 = holder.f1112a;
            C0106b0 c0106b0 = holder.f1113b.f216k;
            TextView vendorName = c0181d2.f1616d;
            Intrinsics.checkNotNullExpressionValue(vendorName, "vendorName");
            C0154d.m753a(vendorName, c0106b0, null, null, false, 6);
            ImageView gvShowMore = c0181d2.f1614b;
            Intrinsics.checkNotNullExpressionValue(gvShowMore, "gvShowMore");
            C0026u.m187b(gvShowMore, holder.f1113b.f228w);
            View view32 = c0181d2.f1617e;
            Intrinsics.checkNotNullExpressionValue(view32, "view3");
            C0026u.m171a(view32, holder.f1113b.f210e);
            holder.m751a(vendorItem);
            return;
        }
        TextView textView = holder.f1112a.f1618f;
        C0126t c0126t = holder.f1113b.f227v;
        if (c0126t == null || !c0126t.f838i) {
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(8);
            return;
        }
        C0106b0 c0106b02 = c0126t.f841l;
        Intrinsics.checkNotNullExpressionValue(c0106b02, "vendorListData.otPCUIPro…leDescriptionTextProperty");
        textView.setTextColor(Color.parseColor(c0106b02.f724c));
        Intrinsics.checkNotNullExpressionValue(textView, "");
        C0154d.m760c(textView, c0106b02.f722a.f751b);
        C0115i c0115i = c0106b02.f722a;
        Intrinsics.checkNotNullExpressionValue(c0115i, "descriptionTextProperty.fontProperty");
        C0154d.m755a(textView, c0115i, holder.f1114c);
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getTotalPages() {
        return super.getTotalPages() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(recyclerView.getContext());
        Intrinsics.checkNotNullExpressionValue(layoutInflaterFrom, "from(recyclerView.context)");
        this.f1111d = layoutInflaterFrom;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflater = this.f1111d;
        if (layoutInflater == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inflater");
            layoutInflater = null;
        }
        C0181d c0181dM1024a = C0181d.m1024a(layoutInflater, parent, false);
        Intrinsics.checkNotNullExpressionValue(c0181dM1024a, "inflate(inflater, parent, false)");
        return new a(c0181dM1024a, this.f1108a, this.f1109b, this.f1110c);
    }

    /* JADX INFO: renamed from: a.a.a.a.b.f.r$a */
    @Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00126\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\t¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u000eJ\b\u0010\u0016\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/adapter/OTVendorGoogleAdapter$VendorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/onetrust/otpublishers/headless/databinding/OtGoogleVendorListItemBinding;", "vendorListData", "Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorListData;", "otConfiguration", "Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;", "onItemToggleCheckedChange", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "", "isChecked", "", "(Lcom/onetrust/otpublishers/headless/databinding/OtGoogleVendorListItemBinding;Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorListData;Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;Lkotlin/jvm/functions/Function2;)V", "bind", "item", "Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorItem;", "isLastItem", "configureColors", "configurePoweredByLogo", "configureSwitchToggle", "setToggleColor", "isOn", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public final C0181d f1112a;

        /* JADX INFO: renamed from: b */
        public final VendorListData f1113b;

        /* JADX INFO: renamed from: c */
        public final OTConfiguration f1114c;

        /* JADX INFO: renamed from: d */
        public final Function2<String, Boolean, Unit> f1115d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(C0181d binding, VendorListData vendorListData, OTConfiguration oTConfiguration, Function2<? super String, ? super Boolean, Unit> onItemToggleCheckedChange) {
            super(binding.m1025a());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(vendorListData, "vendorListData");
            Intrinsics.checkNotNullParameter(onItemToggleCheckedChange, "onItemToggleCheckedChange");
            this.f1112a = binding;
            this.f1113b = vendorListData;
            this.f1114c = oTConfiguration;
            this.f1115d = onItemToggleCheckedChange;
        }

        /* JADX INFO: renamed from: a */
        public final void m751a(final VendorItem vendorItem) {
            SwitchCompat switchCompat = this.f1112a.f1615c;
            switchCompat.setOnCheckedChangeListener(null);
            int iOrdinal = vendorItem.f200c.ordinal();
            if (iOrdinal == 0) {
                switchCompat.setChecked(true);
                m752a(true);
            } else if (iOrdinal == 1) {
                switchCompat.setChecked(false);
                m752a(false);
            }
            switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.f.r$a$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    OTVendorGoogleAdapter.a.m750a(this.f$0, vendorItem, compoundButton, z);
                }
            });
            switchCompat.setContentDescription(this.f1113b.f222q);
        }

        /* JADX INFO: renamed from: a */
        public static final void m750a(a this$0, VendorItem item, CompoundButton compoundButton, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.f1115d.invoke(item.f198a, Boolean.valueOf(z));
            this$0.m752a(z);
        }

        /* JADX INFO: renamed from: a */
        public final void m752a(boolean z) {
            String str;
            SwitchCompat switchCompat = this.f1112a.f1615c;
            if (z) {
                str = this.f1113b.f212g;
            } else {
                str = this.f1113b.f213h;
            }
            Intrinsics.checkNotNullExpressionValue(switchCompat, "");
            C0026u.m176a(switchCompat, this.f1113b.f211f, str);
        }
    }
}
