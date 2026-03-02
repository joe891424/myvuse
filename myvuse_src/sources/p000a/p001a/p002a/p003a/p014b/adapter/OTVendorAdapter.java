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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p014b.DataModels.VendorItem;
import p000a.p001a.p002a.p003a.p014b.DataModels.VendorListData;
import p000a.p001a.p002a.p003a.p014b.adapter.OTVendorAdapter;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p023g.C0154d;
import p000a.p001a.p002a.p003a.p027c.C0184g;

/* JADX INFO: renamed from: a.a.a.a.b.f.l, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"Br\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00126\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\t\u0012!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017H\u0016R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R)\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00100\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/adapter/OTVendorAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorItem;", "Lcom/onetrust/otpublishers/headless/UI/adapter/OTVendorAdapter$VendorViewHolder;", "vendorListData", "Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorListData;", "otConfiguration", "Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;", "onItemToggleCheckedChange", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "", "isChecked", "", "onItemClicked", "Lkotlin/Function1;", "(Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorListData;Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "inflater", "Landroid/view/LayoutInflater;", "getItemCount", "", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", ViewProps.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "VendorViewHolder", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class OTVendorAdapter extends ListAdapter<VendorItem, a> {

    /* JADX INFO: renamed from: a */
    public final VendorListData f1059a;

    /* JADX INFO: renamed from: b */
    public final OTConfiguration f1060b;

    /* JADX INFO: renamed from: c */
    public final Function2<String, Boolean, Unit> f1061c;

    /* JADX INFO: renamed from: d */
    public final Function1<String, Unit> f1062d;

    /* JADX INFO: renamed from: e */
    public LayoutInflater f1063e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OTVendorAdapter(VendorListData vendorListData, OTConfiguration oTConfiguration, Function2<? super String, ? super Boolean, Unit> onItemToggleCheckedChange, Function1<? super String, Unit> onItemClicked) {
        super(new OTVendorDiffCallBack());
        Intrinsics.checkNotNullParameter(vendorListData, "vendorListData");
        Intrinsics.checkNotNullParameter(onItemToggleCheckedChange, "onItemToggleCheckedChange");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.f1059a = vendorListData;
        this.f1060b = oTConfiguration;
        this.f1061c = onItemToggleCheckedChange;
        this.f1062d = onItemClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<VendorItem> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "currentList");
        holder.m736a((VendorItem) CollectionsKt.getOrNull(currentList, i), i == getTotalPages() - 1);
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getTotalPages() {
        return getCurrentList().size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(recyclerView.getContext());
        Intrinsics.checkNotNullExpressionValue(layoutInflaterFrom, "from(recyclerView.context)");
        this.f1063e = layoutInflaterFrom;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View viewFindViewById;
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflater = this.f1063e;
        if (layoutInflater == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inflater");
            layoutInflater = null;
        }
        View viewInflate = layoutInflater.inflate(C3896R.layout.ot_vendors_list_item, parent, false);
        int i2 = C3896R.id.legit_int_switchButton;
        SwitchCompat switchCompat = (SwitchCompat) viewInflate.findViewById(i2);
        if (switchCompat != null) {
            i2 = C3896R.id.show_more;
            ImageView imageView = (ImageView) viewInflate.findViewById(i2);
            if (imageView != null) {
                i2 = C3896R.id.switchButton;
                SwitchCompat switchCompat2 = (SwitchCompat) viewInflate.findViewById(i2);
                if (switchCompat2 != null) {
                    i2 = C3896R.id.vendor_name;
                    TextView textView = (TextView) viewInflate.findViewById(i2);
                    if (textView != null) {
                        i2 = C3896R.id.vendors_privacy_notice;
                        TextView textView2 = (TextView) viewInflate.findViewById(i2);
                        if (textView2 != null && (viewFindViewById = viewInflate.findViewById((i2 = C3896R.id.view3))) != null) {
                            i2 = C3896R.id.view_powered_by_logo;
                            TextView textView3 = (TextView) viewInflate.findViewById(i2);
                            if (textView3 != null) {
                                i2 = C3896R.id.vl_items;
                                RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(i2);
                                if (relativeLayout != null) {
                                    C0184g c0184g = new C0184g((RelativeLayout) viewInflate, switchCompat, imageView, switchCompat2, textView, textView2, viewFindViewById, textView3, relativeLayout);
                                    Intrinsics.checkNotNullExpressionValue(c0184g, "inflate(inflater, parent, false)");
                                    return new a(c0184g, this.f1059a, this.f1060b, this.f1061c, this.f1062d);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    /* JADX INFO: renamed from: a.a.a.a.b.f.l$a */
    @Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bz\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00126\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\t\u0012!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000eJ\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00100\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/adapter/OTVendorAdapter$VendorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/onetrust/otpublishers/headless/databinding/OtVendorsListItemBinding;", "vendorListData", "Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorListData;", "otConfiguration", "Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;", "onItemToggleCheckedChange", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "", "isChecked", "", "onItemClicked", "Lkotlin/Function1;", "(Lcom/onetrust/otpublishers/headless/databinding/OtVendorsListItemBinding;Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorListData;Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "bind", "item", "Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorItem;", "isLastItem", "configureColors", "configurePoweredByLogo", "configureSwitchToggle", "setToggleColor", "isOn", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public final C0184g f1064a;

        /* JADX INFO: renamed from: b */
        public final VendorListData f1065b;

        /* JADX INFO: renamed from: c */
        public final OTConfiguration f1066c;

        /* JADX INFO: renamed from: d */
        public final Function2<String, Boolean, Unit> f1067d;

        /* JADX INFO: renamed from: e */
        public final Function1<String, Unit> f1068e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(C0184g binding, VendorListData vendorListData, OTConfiguration oTConfiguration, Function2<? super String, ? super Boolean, Unit> onItemToggleCheckedChange, Function1<? super String, Unit> onItemClicked) {
            super(binding.m1027a());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(vendorListData, "vendorListData");
            Intrinsics.checkNotNullParameter(onItemToggleCheckedChange, "onItemToggleCheckedChange");
            Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
            this.f1064a = binding;
            this.f1065b = vendorListData;
            this.f1066c = oTConfiguration;
            this.f1067d = onItemToggleCheckedChange;
            this.f1068e = onItemClicked;
        }

        /* JADX INFO: renamed from: a */
        public final void m736a(final VendorItem vendorItem, boolean z) {
            C0184g c0184g = this.f1064a;
            RelativeLayout vlItems = c0184g.f1646h;
            Intrinsics.checkNotNullExpressionValue(vlItems, "vlItems");
            vlItems.setVisibility(!z ? 0 : 8);
            View view3 = c0184g.f1644f;
            Intrinsics.checkNotNullExpressionValue(view3, "view3");
            view3.setVisibility(!z ? 0 : 8);
            SwitchCompat switchButton = c0184g.f1642d;
            Intrinsics.checkNotNullExpressionValue(switchButton, "switchButton");
            switchButton.setVisibility(!z ? 0 : 8);
            SwitchCompat legitIntSwitchButton = c0184g.f1640b;
            Intrinsics.checkNotNullExpressionValue(legitIntSwitchButton, "legitIntSwitchButton");
            legitIntSwitchButton.setVisibility(!z ? 0 : 8);
            TextView viewPoweredByLogo = c0184g.f1645g;
            Intrinsics.checkNotNullExpressionValue(viewPoweredByLogo, "viewPoweredByLogo");
            viewPoweredByLogo.setVisibility(z ? 0 : 8);
            if (z || vendorItem == null) {
                TextView textView = this.f1064a.f1645g;
                C0126t c0126t = this.f1065b.f227v;
                if (c0126t == null || !c0126t.f838i) {
                    Intrinsics.checkNotNullExpressionValue(textView, "");
                    textView.setVisibility(8);
                    return;
                }
                C0106b0 c0106b0 = c0126t.f841l;
                Intrinsics.checkNotNullExpressionValue(c0106b0, "vendorListData.otPCUIPro…leDescriptionTextProperty");
                textView.setTextColor(Color.parseColor(c0106b0.f724c));
                Intrinsics.checkNotNullExpressionValue(textView, "");
                C0154d.m760c(textView, c0106b0.f722a.f751b);
                C0115i c0115i = c0106b0.f722a;
                Intrinsics.checkNotNullExpressionValue(c0115i, "descriptionTextProperty.fontProperty");
                C0154d.m755a(textView, c0115i, this.f1066c);
                return;
            }
            c0184g.f1643e.setText(vendorItem.f199b);
            c0184g.f1643e.setLabelFor(C3896R.id.switchButton);
            SwitchCompat legitIntSwitchButton2 = c0184g.f1640b;
            Intrinsics.checkNotNullExpressionValue(legitIntSwitchButton2, "legitIntSwitchButton");
            legitIntSwitchButton2.setVisibility(8);
            c0184g.f1646h.setOnClickListener(null);
            c0184g.f1646h.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.f.l$a$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OTVendorAdapter.a.m733a(this.f$0, vendorItem, view);
                }
            });
            C0184g c0184g2 = this.f1064a;
            C0106b0 c0106b02 = this.f1065b.f216k;
            TextView vendorName = c0184g2.f1643e;
            Intrinsics.checkNotNullExpressionValue(vendorName, "vendorName");
            C0154d.m753a(vendorName, c0106b02, null, null, false, 6);
            ImageView showMore = c0184g2.f1641c;
            Intrinsics.checkNotNullExpressionValue(showMore, "showMore");
            C0026u.m187b(showMore, this.f1065b.f228w);
            View view32 = c0184g2.f1644f;
            Intrinsics.checkNotNullExpressionValue(view32, "view3");
            C0026u.m171a(view32, this.f1065b.f210e);
            m735a(vendorItem);
        }

        /* JADX INFO: renamed from: a */
        public static final void m733a(a this$0, VendorItem vendorItem, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.f1068e.invoke(vendorItem.f198a);
        }

        /* JADX INFO: renamed from: a */
        public final void m735a(final VendorItem vendorItem) {
            SwitchCompat switchCompat = this.f1064a.f1642d;
            switchCompat.setOnCheckedChangeListener(null);
            int iOrdinal = vendorItem.f200c.ordinal();
            if (iOrdinal == 0) {
                switchCompat.setChecked(true);
                m737a(true);
            } else if (iOrdinal == 1) {
                switchCompat.setChecked(false);
                m737a(false);
            } else if (iOrdinal == 2) {
                Intrinsics.checkNotNullExpressionValue(switchCompat, "");
                switchCompat.setVisibility(8);
            }
            switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.f.l$a$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    OTVendorAdapter.a.m734a(this.f$0, vendorItem, compoundButton, z);
                }
            });
            switchCompat.setContentDescription(this.f1065b.f222q);
        }

        /* JADX INFO: renamed from: a */
        public static final void m734a(a this$0, VendorItem item, CompoundButton compoundButton, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.f1067d.invoke(item.f198a, Boolean.valueOf(z));
            this$0.m737a(z);
        }

        /* JADX INFO: renamed from: a */
        public final void m737a(boolean z) {
            String str;
            SwitchCompat switchCompat = this.f1064a.f1642d;
            if (z) {
                str = this.f1065b.f212g;
            } else {
                str = this.f1065b.f213h;
            }
            Intrinsics.checkNotNullExpressionValue(switchCompat, "");
            C0026u.m176a(switchCompat, this.f1065b.f211f, str);
        }
    }
}
