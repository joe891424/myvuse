package com.salesforce.marketingcloud.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.internal.C4190m;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.storage.p047db.C4350i;
import com.surajit.rnrg.RadialGradientManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 C2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002CDB\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005Bo\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\u0010\u0015J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\"J\u0011\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0000H\u0096\u0002J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jy\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0001J\t\u00100\u001a\u00020\u000bHÖ\u0001J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\b1J\u0013\u00102\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u000bHÖ\u0001J\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b5J\r\u0010\r\u001a\u00020\u000bH\u0007¢\u0006\u0002\b6J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0007¢\u0006\u0002\b7J\r\u0010\u000e\u001a\u00020\u000bH\u0007¢\u0006\u0002\b8J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\b9J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\b:J\r\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\b;J\r\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0002\b<J\t\u0010=\u001a\u00020\u0007HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0017R\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0017R,\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00198A@AX\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001d\u0010\u001fR\u0013\u0010\r\u001a\u00020\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010 R\u0019\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010!R\u0013\u0010\u000e\u001a\u00020\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010 R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0017R\u0013\u0010\n\u001a\u00020\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010 R\u0013\u0010\u000f\u001a\u00020\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010 ¨\u0006E"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/Region;", "Landroid/os/Parcelable;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "id", "", RadialGradientManager.PROP_CENTER, "Lcom/salesforce/marketingcloud/location/LatLon;", RadialGradientManager.PROP_RADIUS, "", "proximityUuid", "major", "minor", "regionType", "name", "description", C4350i.f5612e, "", "Lcom/salesforce/marketingcloud/messages/Message;", "(Ljava/lang/String;Lcom/salesforce/marketingcloud/location/LatLon;ILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "()Lcom/salesforce/marketingcloud/location/LatLon;", "()Ljava/lang/String;", "<set-?>", "", "isInside", "-isInside$annotations", "()V", "-isInside", "()Z", "(Z)V", "()I", "()Ljava/util/List;", "-deprecated_center", "compareTo", "other", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "-deprecated_description", "equals", "", "hashCode", "-deprecated_id", "-deprecated_major", "-deprecated_messages", "-deprecated_minor", "-deprecated_name", "-deprecated_proximityUuid", "-deprecated_radius", "-deprecated_regionType", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "RegionType", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final /* data */ class Region implements Parcelable, Comparable<Region> {
    public static final String MAGIC_REGION_ID = "~~m@g1c_f3nc3~~";
    public static final int REGION_TYPE_FENCE = 1;
    public static final int REGION_TYPE_PROXIMITY = 3;
    private final LatLon center;
    private final String description;
    private final String id;
    private boolean isInside;
    private final int major;
    private final List<Message> messages;
    private final int minor;
    private final String name;
    private final String proximityUuid;
    private final int radius;
    private final int regionType;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<Region> CREATOR = new C4231c();
    private static final String TAG = C4170g.m3197a("Region");

    @Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\u00048AX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/Region$Companion;", "", "()V", "MAGIC_REGION_ID", "", "REGION_TYPE_FENCE", "", "REGION_TYPE_PROXIMITY", "TAG", "-TAG", "()Ljava/lang/String;", "magicFence", "Lcom/salesforce/marketingcloud/messages/Region;", RadialGradientManager.PROP_CENTER, "Lcom/salesforce/marketingcloud/location/LatLon;", RadialGradientManager.PROP_RADIUS, "-magicFence", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: renamed from: -TAG, reason: not valid java name */
        public final String m6617TAG() {
            return Region.TAG;
        }

        /* JADX INFO: renamed from: -magicFence, reason: not valid java name */
        public final Region m6618magicFence(LatLon center, int radius) {
            Intrinsics.checkNotNullParameter(center, "center");
            return new Region(Region.MAGIC_REGION_ID, center, radius, null, 0, 0, -1, null, null, null, 952, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(m5597d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/Region$RegionType;", "", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RegionType {
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.Region$a */
    static final class C4229a extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final C4229a f5143a = new C4229a();

        C4229a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to parse Message from region payload.";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.Region$b */
    static final class C4230b extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final C4230b f5144a = new C4230b();

        C4230b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to parse region messages.";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.Region$c */
    public static final class C4231c implements Parcelable.Creator<Region> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Region createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            LatLon latLonCreateFromParcel = LatLon.CREATOR.createFromParcel(parcel);
            int i = parcel.readInt();
            String string2 = parcel.readString();
            int i2 = parcel.readInt();
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            int i5 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i5);
            for (int i6 = 0; i6 != i5; i6++) {
                arrayList.add(Message.CREATOR.createFromParcel(parcel));
            }
            return new Region(string, latLonCreateFromParcel, i, string2, i2, i3, i4, string3, string4, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Region[] newArray(int i) {
            return new Region[i];
        }
    }

    /* JADX INFO: renamed from: -isInside$annotations, reason: not valid java name */
    public static /* synthetic */ void m6604isInside$annotations() {
    }

    public Region(String id, LatLon center, int i, String str, int i2, int i3, int i4, String str2, String str3, List<Message> messages) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(center, "center");
        Intrinsics.checkNotNullParameter(messages, "messages");
        this.id = id;
        this.center = center;
        this.radius = i;
        this.proximityUuid = str;
        this.major = i2;
        this.minor = i3;
        this.regionType = i4;
        this.name = str2;
        this.description = str3;
        this.messages = messages;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = RadialGradientManager.PROP_CENTER, imports = {}))
    /* JADX INFO: renamed from: -deprecated_center, reason: not valid java name and from getter */
    public final LatLon getCenter() {
        return this.center;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "description", imports = {}))
    /* JADX INFO: renamed from: -deprecated_description, reason: not valid java name and from getter */
    public final String getDescription() {
        return this.description;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "id", imports = {}))
    /* JADX INFO: renamed from: -deprecated_id, reason: not valid java name and from getter */
    public final String getId() {
        return this.id;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "major", imports = {}))
    /* JADX INFO: renamed from: -deprecated_major, reason: not valid java name and from getter */
    public final int getMajor() {
        return this.major;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = C4350i.f5612e, imports = {}))
    /* JADX INFO: renamed from: -deprecated_messages, reason: not valid java name */
    public final List<Message> m6609deprecated_messages() {
        return this.messages;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "minor", imports = {}))
    /* JADX INFO: renamed from: -deprecated_minor, reason: not valid java name and from getter */
    public final int getMinor() {
        return this.minor;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "name", imports = {}))
    /* JADX INFO: renamed from: -deprecated_name, reason: not valid java name and from getter */
    public final String getName() {
        return this.name;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proximityUuid", imports = {}))
    /* JADX INFO: renamed from: -deprecated_proximityUuid, reason: not valid java name and from getter */
    public final String getProximityUuid() {
        return this.proximityUuid;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = RadialGradientManager.PROP_RADIUS, imports = {}))
    /* JADX INFO: renamed from: -deprecated_radius, reason: not valid java name and from getter */
    public final int getRadius() {
        return this.radius;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "regionType", imports = {}))
    /* JADX INFO: renamed from: -deprecated_regionType, reason: not valid java name and from getter */
    public final int getRegionType() {
        return this.regionType;
    }

    /* JADX INFO: renamed from: -isInside, reason: not valid java name */
    public final void m6615isInside(boolean z) {
        this.isInside = z;
    }

    public final LatLon center() {
        return this.center;
    }

    @Override // java.lang.Comparable
    public int compareTo(Region other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.id.compareTo(other.id);
    }

    public final String component1() {
        return this.id;
    }

    public final List<Message> component10() {
        return this.messages;
    }

    public final LatLon component2() {
        return this.center;
    }

    public final int component3() {
        return this.radius;
    }

    public final String component4() {
        return this.proximityUuid;
    }

    public final int component5() {
        return this.major;
    }

    public final int component6() {
        return this.minor;
    }

    public final int component7() {
        return this.regionType;
    }

    public final String component8() {
        return this.name;
    }

    public final String component9() {
        return this.description;
    }

    public final Region copy(String id, LatLon center, int radius, String proximityUuid, int major, int minor, int regionType, String name, String description, List<Message> messages) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(center, "center");
        Intrinsics.checkNotNullParameter(messages, "messages");
        return new Region(id, center, radius, proximityUuid, major, minor, regionType, name, description, messages);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String description() {
        return this.description;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Region)) {
            return false;
        }
        Region region = (Region) other;
        return Intrinsics.areEqual(this.id, region.id) && Intrinsics.areEqual(this.center, region.center) && this.radius == region.radius && Intrinsics.areEqual(this.proximityUuid, region.proximityUuid) && this.major == region.major && this.minor == region.minor && this.regionType == region.regionType && Intrinsics.areEqual(this.name, region.name) && Intrinsics.areEqual(this.description, region.description) && Intrinsics.areEqual(this.messages, region.messages);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.center.hashCode()) * 31) + Integer.hashCode(this.radius)) * 31;
        String str = this.proximityUuid;
        int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.major)) * 31) + Integer.hashCode(this.minor)) * 31) + Integer.hashCode(this.regionType)) * 31;
        String str2 = this.name;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        return ((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.messages.hashCode();
    }

    /* JADX INFO: renamed from: id */
    public final String m3630id() {
        return this.id;
    }

    public final int major() {
        return this.major;
    }

    public final List<Message> messages() {
        return this.messages;
    }

    public final int minor() {
        return this.minor;
    }

    public final String name() {
        return this.name;
    }

    public final String proximityUuid() {
        return this.proximityUuid;
    }

    public final int radius() {
        return this.radius;
    }

    public final int regionType() {
        return this.regionType;
    }

    public String toString() {
        return "Region(id=" + this.id + ", center=" + this.center + ", radius=" + this.radius + ", proximityUuid=" + this.proximityUuid + ", major=" + this.major + ", minor=" + this.minor + ", regionType=" + this.regionType + ", name=" + this.name + ", description=" + this.description + ", messages=" + this.messages + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        this.center.writeToParcel(parcel, flags);
        parcel.writeInt(this.radius);
        parcel.writeString(this.proximityUuid);
        parcel.writeInt(this.major);
        parcel.writeInt(this.minor);
        parcel.writeInt(this.regionType);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        List<Message> list = this.messages;
        parcel.writeInt(list.size());
        Iterator<Message> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ Region(String str, LatLon latLon, int i, String str2, int i2, int i3, int i4, String str3, String str4, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, latLon, i, (i5 & 8) != 0 ? null : str2, (i5 & 16) != 0 ? 0 : i2, (i5 & 32) != 0 ? 0 : i3, i4, (i5 & 128) != 0 ? null : str3, (i5 & 256) != 0 ? null : str4, (i5 & 512) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX INFO: renamed from: -isInside, reason: not valid java name and from getter */
    public final boolean getIsInside() {
        return this.isInside;
    }

    public Region(JSONObject json) throws JSONException {
        List listEmptyList;
        Message message;
        Object string;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(json, "json");
        String string2 = json.getString("id");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        JSONObject jSONObject2 = json.getJSONObject(RadialGradientManager.PROP_CENTER);
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "getJSONObject(...)");
        LatLon latLon = new LatLon(jSONObject2);
        int iOptInt = json.optInt(RadialGradientManager.PROP_RADIUS);
        String strOptString = json.optString("proximityUuid");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strM3408b = C4190m.m3408b(strOptString);
        int iOptInt2 = json.optInt("major");
        int iOptInt3 = json.optInt("minor");
        int i = json.getInt("locationType");
        String strOptString2 = json.optString("name");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strM3408b2 = C4190m.m3408b(strOptString2);
        String strOptString3 = json.optString("description");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strM3408b3 = C4190m.m3408b(strOptString3);
        try {
            JSONArray jSONArrayOptJSONArray = json.optJSONArray(C4350i.f5612e);
            if (jSONArrayOptJSONArray != null) {
                IntRange intRangeUntil = RangesKt.until(0, jSONArrayOptJSONArray.length());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
                Iterator<Integer> it2 = intRangeUntil.iterator();
                while (it2.hasNext()) {
                    int iNextInt = ((IntIterator) it2).nextInt();
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                        jSONObject = jSONArrayOptJSONArray.getJSONObject(iNextInt);
                        if (jSONObject == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            string = Integer.valueOf(jSONArrayOptJSONArray.getInt(iNextInt));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            string = Double.valueOf(jSONArrayOptJSONArray.getDouble(iNextInt));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            string = Long.valueOf(jSONArrayOptJSONArray.getLong(iNextInt));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            string = Boolean.valueOf(jSONArrayOptJSONArray.getBoolean(iNextInt));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            string = jSONArrayOptJSONArray.getString(iNextInt);
                            if (string == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                        } else {
                            string = jSONArrayOptJSONArray.get(iNextInt);
                            if (string == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                        }
                        jSONObject = (JSONObject) string;
                    }
                    arrayList.add(jSONObject);
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    try {
                        message = new Message((JSONObject) it3.next());
                    } catch (Exception e) {
                        C4170g.f4785a.m3223b(TAG, e, C4229a.f5143a);
                        message = null;
                    }
                    if (message != null) {
                        arrayList2.add(message);
                    }
                }
                listEmptyList = new ArrayList();
                for (Object obj : arrayList2) {
                    if (C4234b.m3639a((Message) obj)) {
                        listEmptyList.add(obj);
                    }
                }
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
        } catch (JSONException e2) {
            C4170g.f4785a.m3223b(TAG, e2, C4230b.f5144a);
            listEmptyList = CollectionsKt.emptyList();
        }
        this(string2, latLon, iOptInt, strM3408b, iOptInt2, iOptInt3, i, strM3408b2, strM3408b3, listEmptyList);
    }
}
