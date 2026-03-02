package com.salesforce.marketingcloud.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import com.salesforce.marketingcloud.C4170g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003J\u0019\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0015\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000fHÖ\u0001R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u0006\u0010\u0005¨\u0006 "}, m5598d2 = {"Lcom/salesforce/marketingcloud/analytics/PiCart;", "Landroid/os/Parcelable;", "", "Lcom/salesforce/marketingcloud/analytics/PiCartItem;", "-deprecated_cartItems", "()Ljava/util/List;", "cartItems", "Lorg/json/JSONArray;", "-toJson", "()Lorg/json/JSONArray;", "toJson", "component1", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "Companion", "a", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0})
public final /* data */ class PiCart implements Parcelable {
    private final List<PiCartItem> cartItems;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<PiCart> CREATOR = new C4096b();

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.PiCart$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to constructor", replaceWith = @ReplaceWith(expression = "PiCart(cartItems)", imports = {}))
        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final PiCart m2871a(List<PiCartItem> cartItems) {
            Intrinsics.checkNotNullParameter(cartItems, "cartItems");
            return new PiCart(cartItems);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.PiCart$b */
    public static final class C4096b implements Parcelable.Creator<PiCart> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PiCart createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(PiCartItem.CREATOR.createFromParcel(parcel));
            }
            return new PiCart(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PiCart[] newArray(int i) {
            return new PiCart[i];
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.PiCart$c */
    static final class C4097c extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final C4097c f4352a = new C4097c();

        C4097c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to convert List<PiCartItem> into JSONArray for PiCart payload.";
        }
    }

    public PiCart(List<PiCartItem> cartItems) {
        Intrinsics.checkNotNullParameter(cartItems, "cartItems");
        this.cartItems = cartItems;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PiCart copy$default(PiCart piCart, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = piCart.cartItems;
        }
        return piCart.copy(list);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to constructor", replaceWith = @ReplaceWith(expression = "PiCart(cartItems)", imports = {}))
    @JvmStatic
    public static final PiCart create(List<PiCartItem> list) {
        return INSTANCE.m2871a(list);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cartItems", imports = {}))
    /* JADX INFO: renamed from: -deprecated_cartItems, reason: not valid java name */
    public final List<PiCartItem> m6555deprecated_cartItems() {
        return this.cartItems;
    }

    /* JADX INFO: renamed from: -toJson, reason: not valid java name */
    public final JSONArray m6556toJson() {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<T> it2 = this.cartItems.iterator();
            while (it2.hasNext()) {
                jSONArray.put(((PiCartItem) it2.next()).m6561toJson());
            }
        } catch (JSONException e) {
            C4170g c4170g = C4170g.f4785a;
            String TAG = AnalyticsManager.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            c4170g.m3223b(TAG, e, C4097c.f4352a);
        }
        return jSONArray;
    }

    public final List<PiCartItem> cartItems() {
        return this.cartItems;
    }

    public final List<PiCartItem> component1() {
        return this.cartItems;
    }

    public final PiCart copy(List<PiCartItem> cartItems) {
        Intrinsics.checkNotNullParameter(cartItems, "cartItems");
        return new PiCart(cartItems);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PiCart) && Intrinsics.areEqual(this.cartItems, ((PiCart) other).cartItems);
    }

    public int hashCode() {
        return this.cartItems.hashCode();
    }

    public String toString() {
        return "PiCart(cartItems=" + this.cartItems + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<PiCartItem> list = this.cartItems;
        parcel.writeInt(list.size());
        Iterator<PiCartItem> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
    }
}
