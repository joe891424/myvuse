package p000a.p001a.p002a.p003a.p014b.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.DataModels.SDKItem;
import p000a.p001a.p002a.p003a.p014b.DataModels.SDKListData;
import p000a.p001a.p002a.p003a.p014b.adapter.OTSDKAdapter;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p023g.C0154d;
import p000a.p001a.p002a.p003a.p027c.C0182e;

/* JADX INFO: renamed from: a.a.a.a.b.f.d, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!Bc\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/adapter/OTSDKAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/onetrust/otpublishers/headless/UI/DataModels/SDKItem;", "Lcom/onetrust/otpublishers/headless/UI/adapter/OTSDKAdapter$SDKViewHolder;", "sdkListData", "Lcom/onetrust/otpublishers/headless/UI/DataModels/SDKListData;", "otConfiguration", "Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;", "sdkLevelOptOut", "", "alwaysActiveText", "alwaysActiveTextColor", "onItemCheckedChange", "Lkotlin/Function2;", "", "", "isAlwaysActiveGroup", "Lkotlin/Function1;", "(Lcom/onetrust/otpublishers/headless/UI/DataModels/SDKListData;Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "inflater", "Landroid/view/LayoutInflater;", "getItemCount", "", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", ViewProps.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "SDKViewHolder", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class OTSDKAdapter extends ListAdapter<SDKItem, a> {

    /* JADX INFO: renamed from: a */
    public final SDKListData f978a;

    /* JADX INFO: renamed from: b */
    public final OTConfiguration f979b;

    /* JADX INFO: renamed from: c */
    public final String f980c;

    /* JADX INFO: renamed from: d */
    public final String f981d;

    /* JADX INFO: renamed from: e */
    public final String f982e;

    /* JADX INFO: renamed from: f */
    public final Function2<String, Boolean, Unit> f983f;

    /* JADX INFO: renamed from: g */
    public final Function1<String, Boolean> f984g;

    /* JADX INFO: renamed from: h */
    public LayoutInflater f985h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OTSDKAdapter(SDKListData sdkListData, OTConfiguration oTConfiguration, String str, String str2, String str3, Function2<? super String, ? super Boolean, Unit> onItemCheckedChange, Function1<? super String, Boolean> isAlwaysActiveGroup) {
        super(new OTSDKDiffCallBack());
        Intrinsics.checkNotNullParameter(sdkListData, "sdkListData");
        Intrinsics.checkNotNullParameter(onItemCheckedChange, "onItemCheckedChange");
        Intrinsics.checkNotNullParameter(isAlwaysActiveGroup, "isAlwaysActiveGroup");
        this.f978a = sdkListData;
        this.f979b = oTConfiguration;
        this.f980c = str;
        this.f981d = str2;
        this.f982e = str3;
        this.f983f = onItemCheckedChange;
        this.f984g = isAlwaysActiveGroup;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i) {
        int i2;
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z;
        SwitchCompat switchButton;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<SDKItem> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "currentList");
        SDKItem sDKItem = (SDKItem) CollectionsKt.getOrNull(currentList, i);
        boolean z2 = i == getTotalPages() - 1;
        C0182e c0182e = holder.f986a;
        RelativeLayout itemLayout = c0182e.f1622c;
        Intrinsics.checkNotNullExpressionValue(itemLayout, "itemLayout");
        itemLayout.setVisibility(!z2 ? 0 : 8);
        TextView viewPoweredByLogo = c0182e.f1628i;
        Intrinsics.checkNotNullExpressionValue(viewPoweredByLogo, "viewPoweredByLogo");
        viewPoweredByLogo.setVisibility(z2 ? 0 : 8);
        String str3 = "";
        if (z2 || sDKItem == null) {
            TextView textView = holder.f986a.f1628i;
            C0126t c0126t = holder.f987b.f197p;
            if (c0126t == null || !c0126t.f838i) {
                Intrinsics.checkNotNullExpressionValue(textView, "");
                textView.setVisibility(8);
                return;
            }
            C0106b0 c0106b0 = c0126t.f841l;
            Intrinsics.checkNotNullExpressionValue(c0106b0, "sdkListData.otPCUIProper…leDescriptionTextProperty");
            textView.setTextColor(Color.parseColor(c0106b0.f724c));
            Intrinsics.checkNotNullExpressionValue(textView, "");
            C0154d.m760c(textView, c0106b0.f722a.f751b);
            C0115i c0115i = c0106b0.f722a;
            Intrinsics.checkNotNullExpressionValue(c0115i, "descriptionTextProperty.fontProperty");
            C0154d.m755a(textView, c0115i, holder.f988c);
            return;
        }
        TextView textView2 = holder.f986a.f1625f;
        textView2.setText(sDKItem.f174b);
        C0106b0 c0106b02 = holder.f987b.f192k;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        C0154d.m753a(textView2, c0106b02, null, null, false, 6);
        TextView textView3 = holder.f986a.f1624e;
        Intrinsics.checkNotNullExpressionValue(textView3, "");
        String str4 = sDKItem.f175c;
        if (str4 == null || str4.length() == 0 || !holder.f987b.f182a || Intrinsics.areEqual("null", sDKItem.f175c)) {
            i2 = 8;
        } else {
            C0154d.m758a(textView3, sDKItem.f175c);
            i2 = 0;
        }
        textView3.setVisibility(i2);
        C0154d.m753a(textView3, holder.f987b.f193l, null, null, false, 6);
        holder.m710a(sDKItem);
        c0182e.f1625f.setLabelFor(C3896R.id.switchButton);
        View view3 = c0182e.f1627h;
        Intrinsics.checkNotNullExpressionValue(view3, "view3");
        C0026u.m171a(view3, holder.f987b.f187f);
        SwitchCompat switchButton2 = c0182e.f1626g;
        Intrinsics.checkNotNullExpressionValue(switchButton2, "switchButton");
        switchButton2.setVisibility(0);
        if (!Boolean.parseBoolean(holder.f989d)) {
            SwitchCompat switchButton3 = c0182e.f1626g;
            Intrinsics.checkNotNullExpressionValue(switchButton3, "switchButton");
            switchButton3.setVisibility(8);
            TextView alwaysActiveTextSdk = c0182e.f1621b;
            Intrinsics.checkNotNullExpressionValue(alwaysActiveTextSdk, "alwaysActiveTextSdk");
            alwaysActiveTextSdk.setVisibility(8);
            return;
        }
        C0182e c0182e2 = holder.f986a;
        Context context = c0182e2.f1620a.getContext();
        new JSONObject();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
            z = false;
        }
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            new SharedPreferencesC0047f(context, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
        }
        String str5 = sDKItem.f173a;
        try {
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString("OTT_INTERNAL_SDK_GROUP_MAP", ""));
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (jSONObject.get(next).toString().contains(str5)) {
                    str3 = next;
                }
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "SdkListHelper", "Error while fetching groupId by sdkId : " + e.getMessage());
        }
        if (str3 == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(str3, "SdkListHelper(root.conte…d(item.id) ?: return@with");
        if (holder.f993h.invoke(str3).booleanValue()) {
            SwitchCompat switchButton4 = c0182e2.f1626g;
            Intrinsics.checkNotNullExpressionValue(switchButton4, "switchButton");
            switchButton4.setVisibility(8);
            TextView alwaysActiveTextSdk2 = c0182e2.f1621b;
            Intrinsics.checkNotNullExpressionValue(alwaysActiveTextSdk2, "alwaysActiveTextSdk");
            alwaysActiveTextSdk2.setVisibility(0);
            c0182e2.f1621b.setText(holder.f990e);
            String str6 = holder.f991f;
            if (str6 == null || str6.length() == 0) {
                return;
            }
            c0182e2.f1621b.setTextColor(Color.parseColor(holder.f991f));
            return;
        }
        TextView alwaysActiveTextSdk3 = c0182e2.f1621b;
        Intrinsics.checkNotNullExpressionValue(alwaysActiveTextSdk3, "alwaysActiveTextSdk");
        alwaysActiveTextSdk3.setVisibility(8);
        int iOrdinal = sDKItem.f176d.ordinal();
        if (iOrdinal == 0) {
            c0182e2.f1626g.setChecked(true);
            switchButton = c0182e2.f1626g;
            Intrinsics.checkNotNullExpressionValue(switchButton, "switchButton");
            SDKListData sDKListData = holder.f987b;
            str = sDKListData.f190i;
            str2 = sDKListData.f188g;
        } else {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    return;
                }
                SwitchCompat switchButton5 = c0182e2.f1626g;
                Intrinsics.checkNotNullExpressionValue(switchButton5, "switchButton");
                switchButton5.setVisibility(8);
                return;
            }
            c0182e2.f1626g.setChecked(false);
            switchButton = c0182e2.f1626g;
            Intrinsics.checkNotNullExpressionValue(switchButton, "switchButton");
            SDKListData sDKListData2 = holder.f987b;
            str = sDKListData2.f190i;
            str2 = sDKListData2.f189h;
        }
        C0026u.m176a(switchButton, str, str2);
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
        this.f985h = layoutInflaterFrom;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View viewFindViewById;
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflater = this.f985h;
        if (layoutInflater == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inflater");
            layoutInflater = null;
        }
        View viewInflate = layoutInflater.inflate(C3896R.layout.ot_sdk_list_item, parent, false);
        int i2 = C3896R.id.alwaysActiveTextSdk;
        TextView textView = (TextView) viewInflate.findViewById(i2);
        if (textView != null) {
            i2 = C3896R.id.item_layout;
            RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(i2);
            if (relativeLayout != null) {
                i2 = C3896R.id.legit_int_switchButton;
                SwitchCompat switchCompat = (SwitchCompat) viewInflate.findViewById(i2);
                if (switchCompat != null) {
                    i2 = C3896R.id.sdk_description;
                    TextView textView2 = (TextView) viewInflate.findViewById(i2);
                    if (textView2 != null) {
                        FrameLayout frameLayout = (FrameLayout) viewInflate;
                        i2 = C3896R.id.sdk_name;
                        TextView textView3 = (TextView) viewInflate.findViewById(i2);
                        if (textView3 != null) {
                            i2 = C3896R.id.show_more;
                            ImageView imageView = (ImageView) viewInflate.findViewById(i2);
                            if (imageView != null) {
                                i2 = C3896R.id.switchButton;
                                SwitchCompat switchCompat2 = (SwitchCompat) viewInflate.findViewById(i2);
                                if (switchCompat2 != null && (viewFindViewById = viewInflate.findViewById((i2 = C3896R.id.view3))) != null) {
                                    i2 = C3896R.id.view_powered_by_logo;
                                    TextView textView4 = (TextView) viewInflate.findViewById(i2);
                                    if (textView4 != null) {
                                        C0182e c0182e = new C0182e(frameLayout, textView, relativeLayout, switchCompat, textView2, frameLayout, textView3, imageView, switchCompat2, viewFindViewById, textView4);
                                        Intrinsics.checkNotNullExpressionValue(c0182e, "inflate(inflater, parent, false)");
                                        return new a(c0182e, this.f978a, this.f979b, this.f980c, this.f981d, this.f982e, this.f983f, this.f984g);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    /* JADX INFO: renamed from: a.a.a.a.b.f.d$a */
    @Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000eJ\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000eH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/adapter/OTSDKAdapter$SDKViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/onetrust/otpublishers/headless/databinding/OtSdkListItemBinding;", "sdkListData", "Lcom/onetrust/otpublishers/headless/UI/DataModels/SDKListData;", "otConfiguration", "Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;", "sdkLevelOptOut", "", "alwaysActiveText", "alwaysActiveTextColor", "onItemCheckedChange", "Lkotlin/Function2;", "", "", "isAlwaysActiveGroup", "Lkotlin/Function1;", "(Lcom/onetrust/otpublishers/headless/databinding/OtSdkListItemBinding;Lcom/onetrust/otpublishers/headless/UI/DataModels/SDKListData;Lcom/onetrust/otpublishers/headless/Public/DataModel/OTConfiguration;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "bind", "item", "Lcom/onetrust/otpublishers/headless/UI/DataModels/SDKItem;", "isLastItem", "configureDescription", "configureName", "configureOTLogoProperty", "configureSdkToggleVisibility", "configureToggles", "setToggleColor", "isOn", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public final C0182e f986a;

        /* JADX INFO: renamed from: b */
        public final SDKListData f987b;

        /* JADX INFO: renamed from: c */
        public final OTConfiguration f988c;

        /* JADX INFO: renamed from: d */
        public final String f989d;

        /* JADX INFO: renamed from: e */
        public final String f990e;

        /* JADX INFO: renamed from: f */
        public final String f991f;

        /* JADX INFO: renamed from: g */
        public final Function2<String, Boolean, Unit> f992g;

        /* JADX INFO: renamed from: h */
        public final Function1<String, Boolean> f993h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(C0182e binding, SDKListData sdkListData, OTConfiguration oTConfiguration, String str, String str2, String str3, Function2<? super String, ? super Boolean, Unit> onItemCheckedChange, Function1<? super String, Boolean> isAlwaysActiveGroup) {
            super(binding.m1026a());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(sdkListData, "sdkListData");
            Intrinsics.checkNotNullParameter(onItemCheckedChange, "onItemCheckedChange");
            Intrinsics.checkNotNullParameter(isAlwaysActiveGroup, "isAlwaysActiveGroup");
            this.f986a = binding;
            this.f987b = sdkListData;
            this.f988c = oTConfiguration;
            this.f989d = str;
            this.f990e = str2;
            this.f991f = str3;
            this.f992g = onItemCheckedChange;
            this.f993h = isAlwaysActiveGroup;
        }

        /* JADX INFO: renamed from: a */
        public final void m710a(final SDKItem sDKItem) {
            C0182e c0182e = this.f986a;
            c0182e.f1626g.setOnCheckedChangeListener(null);
            SwitchCompat legitIntSwitchButton = c0182e.f1623d;
            Intrinsics.checkNotNullExpressionValue(legitIntSwitchButton, "legitIntSwitchButton");
            legitIntSwitchButton.setVisibility(8);
            c0182e.f1626g.setContentDescription(this.f987b.f191j);
            c0182e.f1626g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.f.d$a$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    OTSDKAdapter.a.m709a(this.f$0, sDKItem, compoundButton, z);
                }
            });
        }

        /* JADX INFO: renamed from: a */
        public static final void m709a(a this$0, SDKItem item, CompoundButton compoundButton, boolean z) {
            String str;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.f992g.invoke(item.f173a, Boolean.valueOf(z));
            SwitchCompat switchCompat = this$0.f986a.f1626g;
            if (z) {
                str = this$0.f987b.f188g;
            } else {
                str = this$0.f987b.f189h;
            }
            Intrinsics.checkNotNullExpressionValue(switchCompat, "");
            C0026u.m176a(switchCompat, this$0.f987b.f190i, str);
        }
    }
}
