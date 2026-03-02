package com.salesforce.marketingcloud.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0001,B)\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b(\u0010)B!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b(\u0010*J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0014\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\nHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u0019\u001a\u00020\u0002HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\u0019\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b\u0005\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b\t\u0010\bR\u0017\u0010\r\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b\r\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b\u000f\u0010\u0004¨\u0006-"}, m5598d2 = {"Lcom/salesforce/marketingcloud/analytics/PiCartItem;", "Landroid/os/Parcelable;", "", "-deprecated_item", "()Ljava/lang/String;", "item", "", "-deprecated_quantity", "()I", FirebaseAnalytics.Param.QUANTITY, "", "-deprecated_price", "()D", FirebaseAnalytics.Param.PRICE, "-deprecated_uniqueId", "uniqueId", "Lorg/json/JSONObject;", "-toJson", "()Lorg/json/JSONObject;", "toJson", "component1", "component2", "component3", "component4", "copy", "toString", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Ljava/lang/String;", "I", "D", "<init>", "(Ljava/lang/String;IDLjava/lang/String;)V", "(Ljava/lang/String;ID)V", "Companion", "a", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0})
public final /* data */ class PiCartItem implements Parcelable {
    private final String item;
    private final double price;
    private final int quantity;
    private final String uniqueId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<PiCartItem> CREATOR = new C4099b();

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.PiCartItem$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to constructor", replaceWith = @ReplaceWith(expression = "PiCartItem(item, quantity, price)", imports = {}))
        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final PiCartItem m2875a(String item, int i, double d) {
            Intrinsics.checkNotNullParameter(item, "item");
            return new PiCartItem(item, i, d);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to constructor", replaceWith = @ReplaceWith(expression = "PiCartItem(item, quantity, price, uniqueId)", imports = {}))
        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final PiCartItem m2876a(String item, int i, double d, String str) {
            Intrinsics.checkNotNullParameter(item, "item");
            return new PiCartItem(item, i, d, str);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.PiCartItem$b */
    public static final class C4099b implements Parcelable.Creator<PiCartItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PiCartItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PiCartItem(parcel.readString(), parcel.readInt(), parcel.readDouble(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PiCartItem[] newArray(int i) {
            return new PiCartItem[i];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PiCartItem(String item, int i, double d) {
        this(item, i, d, null);
        Intrinsics.checkNotNullParameter(item, "item");
    }

    public static /* synthetic */ PiCartItem copy$default(PiCartItem piCartItem, String str, int i, double d, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = piCartItem.item;
        }
        if ((i2 & 2) != 0) {
            i = piCartItem.quantity;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            d = piCartItem.price;
        }
        double d2 = d;
        if ((i2 & 8) != 0) {
            str2 = piCartItem.uniqueId;
        }
        return piCartItem.copy(str, i3, d2, str2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to constructor", replaceWith = @ReplaceWith(expression = "PiCartItem(item, quantity, price)", imports = {}))
    @JvmStatic
    public static final PiCartItem create(String str, int i, double d) {
        return INSTANCE.m2875a(str, i, d);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "item", imports = {}))
    /* JADX INFO: renamed from: -deprecated_item, reason: not valid java name and from getter */
    public final String getItem() {
        return this.item;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = FirebaseAnalytics.Param.PRICE, imports = {}))
    /* JADX INFO: renamed from: -deprecated_price, reason: not valid java name and from getter */
    public final double getPrice() {
        return this.price;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = FirebaseAnalytics.Param.QUANTITY, imports = {}))
    /* JADX INFO: renamed from: -deprecated_quantity, reason: not valid java name and from getter */
    public final int getQuantity() {
        return this.quantity;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "uniqueId", imports = {}))
    /* JADX INFO: renamed from: -deprecated_uniqueId, reason: not valid java name and from getter */
    public final String getUniqueId() {
        return this.uniqueId;
    }

    /* JADX INFO: renamed from: -toJson, reason: not valid java name */
    public final JSONObject m6561toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("item", this.item);
        jSONObject.put(FirebaseAnalytics.Param.QUANTITY, this.quantity);
        jSONObject.put(FirebaseAnalytics.Param.PRICE, this.price);
        String str = this.uniqueId;
        if (str != null) {
            jSONObject.put("unique_id", str);
        }
        return jSONObject;
    }

    public final String component1() {
        return this.item;
    }

    public final int component2() {
        return this.quantity;
    }

    public final double component3() {
        return this.price;
    }

    public final String component4() {
        return this.uniqueId;
    }

    public final PiCartItem copy(String item, int quantity, double price, String uniqueId) {
        Intrinsics.checkNotNullParameter(item, "item");
        return new PiCartItem(item, quantity, price, uniqueId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PiCartItem)) {
            return false;
        }
        PiCartItem piCartItem = (PiCartItem) other;
        return Intrinsics.areEqual(this.item, piCartItem.item) && this.quantity == piCartItem.quantity && Double.compare(this.price, piCartItem.price) == 0 && Intrinsics.areEqual(this.uniqueId, piCartItem.uniqueId);
    }

    public int hashCode() {
        int iHashCode = ((((this.item.hashCode() * 31) + Integer.hashCode(this.quantity)) * 31) + Double.hashCode(this.price)) * 31;
        String str = this.uniqueId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String item() {
        return this.item;
    }

    public final double price() {
        return this.price;
    }

    public final int quantity() {
        return this.quantity;
    }

    public String toString() {
        return "PiCartItem(item=" + this.item + ", quantity=" + this.quantity + ", price=" + this.price + ", uniqueId=" + this.uniqueId + ")";
    }

    public final String uniqueId() {
        return this.uniqueId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.item);
        parcel.writeInt(this.quantity);
        parcel.writeDouble(this.price);
        parcel.writeString(this.uniqueId);
    }

    public PiCartItem(String item, int i, double d, String str) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.quantity = i;
        this.price = d;
        this.uniqueId = str;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to constructor", replaceWith = @ReplaceWith(expression = "PiCartItem(item, quantity, price, uniqueId)", imports = {}))
    @JvmStatic
    public static final PiCartItem create(String str, int i, double d, String str2) {
        return INSTANCE.m2876a(str, i, d, str2);
    }
}
