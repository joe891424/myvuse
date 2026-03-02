package com.salesforce.marketingcloud.messages.geofence;

import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.C4233a;
import com.salesforce.marketingcloud.messages.MessageResponse;
import com.salesforce.marketingcloud.messages.Region;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
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
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0002\b\u0010J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0011J\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0012R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000f¨\u0006\u0013"}, m5598d2 = {"Lcom/salesforce/marketingcloud/messages/geofence/GeofenceMessageResponse;", "Lcom/salesforce/marketingcloud/messages/MessageResponse;", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "refreshCenter", "Lcom/salesforce/marketingcloud/location/LatLon;", "refreshRadius", "", "fences", "", "Lcom/salesforce/marketingcloud/messages/Region;", "(Lcom/salesforce/marketingcloud/location/LatLon;ILjava/util/List;)V", "()Ljava/util/List;", "()Lcom/salesforce/marketingcloud/location/LatLon;", "()I", "-deprecated_fences", "-deprecated_refreshCenter", "-deprecated_refreshRadius", "sdk_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class GeofenceMessageResponse implements MessageResponse {
    private final List<Region> fences;
    private final LatLon refreshCenter;
    private final int refreshRadius;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.geofence.GeofenceMessageResponse$a */
    static final class C4237a extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final C4237a f5183a = new C4237a();

        C4237a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to parse Region from geofence message payload.";
        }
    }

    public GeofenceMessageResponse(LatLon refreshCenter, int i, List<Region> fences) {
        Intrinsics.checkNotNullParameter(refreshCenter, "refreshCenter");
        Intrinsics.checkNotNullParameter(fences, "fences");
        this.refreshCenter = refreshCenter;
        this.refreshRadius = i;
        this.fences = fences;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fences", imports = {}))
    /* JADX INFO: renamed from: -deprecated_fences, reason: not valid java name */
    public final List<Region> m6619deprecated_fences() {
        return this.fences;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "refreshCenter", imports = {}))
    /* JADX INFO: renamed from: -deprecated_refreshCenter, reason: not valid java name */
    public final LatLon m6620deprecated_refreshCenter() {
        return getRefreshCenter();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "refreshRadius", imports = {}))
    /* JADX INFO: renamed from: -deprecated_refreshRadius, reason: not valid java name */
    public final int m6621deprecated_refreshRadius() {
        return getRefreshRadius();
    }

    public final List<Region> fences() {
        return this.fences;
    }

    @Override // com.salesforce.marketingcloud.messages.MessageResponse
    /* JADX INFO: renamed from: refreshCenter, reason: from getter */
    public LatLon getRefreshCenter() {
        return this.refreshCenter;
    }

    @Override // com.salesforce.marketingcloud.messages.MessageResponse
    /* JADX INFO: renamed from: refreshRadius, reason: from getter */
    public int getRefreshRadius() {
        return this.refreshRadius;
    }

    public GeofenceMessageResponse(JSONObject json) throws JSONException {
        List listEmptyList;
        Region region;
        Object string;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(json, "json");
        LatLon latLonM3635a = C4233a.m3635a(json);
        int iM3636b = C4233a.m3636b(json);
        JSONArray jSONArrayOptJSONArray = json.optJSONArray("fences");
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
            listEmptyList = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                try {
                    region = new Region((JSONObject) it3.next());
                } catch (Exception e) {
                    C4170g.f4785a.m3223b(Region.INSTANCE.m6617TAG(), e, C4237a.f5183a);
                    region = null;
                }
                if (region != null) {
                    listEmptyList.add(region);
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        this(latLonM3635a, iM3636b, listEmptyList);
    }
}
