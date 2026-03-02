package com.salesforce.marketingcloud.events;

import com.salesforce.marketingcloud.extensions.PushExtensionsKt;
import com.salesforce.marketingcloud.internal.C4190m;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.h */
/* JADX INFO: loaded from: classes6.dex */
public final class C4157h {

    /* JADX INFO: renamed from: a */
    private final String f4763a;

    /* JADX INFO: renamed from: b */
    private final String f4764b;

    /* JADX INFO: renamed from: c */
    private final Date f4765c;

    /* JADX INFO: renamed from: d */
    private final List<C4156g> f4766d;

    /* JADX INFO: renamed from: e */
    private final List<C4154e> f4767e;

    /* JADX INFO: renamed from: f */
    private String f4768f;

    public C4157h(String id, String key, Date date, List<C4156g> list, List<C4154e> outcomes, String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(outcomes, "outcomes");
        this.f4763a = id;
        this.f4764b = key;
        this.f4765c = date;
        this.f4766d = list;
        this.f4767e = outcomes;
        this.f4768f = str;
    }

    /* JADX INFO: renamed from: a */
    public final String m3172a() {
        return this.f4763a;
    }

    /* JADX INFO: renamed from: b */
    public final String m3174b() {
        return this.f4764b;
    }

    /* JADX INFO: renamed from: c */
    public final Date m3175c() {
        return this.f4765c;
    }

    /* JADX INFO: renamed from: d */
    public final List<C4156g> m3176d() {
        return this.f4766d;
    }

    /* JADX INFO: renamed from: e */
    public final List<C4154e> m3177e() {
        return this.f4767e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4157h)) {
            return false;
        }
        C4157h c4157h = (C4157h) obj;
        return Intrinsics.areEqual(this.f4763a, c4157h.f4763a) && Intrinsics.areEqual(this.f4764b, c4157h.f4764b) && Intrinsics.areEqual(this.f4765c, c4157h.f4765c) && Intrinsics.areEqual(this.f4766d, c4157h.f4766d) && Intrinsics.areEqual(this.f4767e, c4157h.f4767e) && Intrinsics.areEqual(this.f4768f, c4157h.f4768f);
    }

    /* JADX INFO: renamed from: f */
    public final String m3178f() {
        return this.f4768f;
    }

    /* JADX INFO: renamed from: g */
    public final String m3179g() {
        return this.f4768f;
    }

    /* JADX INFO: renamed from: h */
    public final String m3180h() {
        return this.f4763a;
    }

    public int hashCode() {
        int iHashCode = ((this.f4763a.hashCode() * 31) + this.f4764b.hashCode()) * 31;
        Date date = this.f4765c;
        int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
        List<C4156g> list = this.f4766d;
        int iHashCode3 = (((iHashCode2 + (list == null ? 0 : list.hashCode())) * 31) + this.f4767e.hashCode()) * 31;
        String str = this.f4768f;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i */
    public final String m3181i() {
        return this.f4764b;
    }

    /* JADX INFO: renamed from: j */
    public final List<C4154e> m3182j() {
        return this.f4767e;
    }

    /* JADX INFO: renamed from: k */
    public final List<C4156g> m3183k() {
        return this.f4766d;
    }

    /* JADX INFO: renamed from: l */
    public final Date m3184l() {
        return this.f4765c;
    }

    /* JADX INFO: renamed from: m */
    public final JSONObject m3185m() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f4763a);
        jSONObject.put("key", this.f4764b);
        Date date = this.f4765c;
        if (date != null) {
            jSONObject.put("startDateUtc", C4190m.m3403a(date));
        }
        List<C4156g> list = this.f4766d;
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                jSONArray.put(((C4156g) it2.next()).m3165k());
            }
            Unit unit = Unit.INSTANCE;
            jSONObject.put("rules", jSONArray);
        }
        JSONArray jSONArray2 = new JSONArray();
        Iterator<T> it3 = this.f4767e.iterator();
        while (it3.hasNext()) {
            jSONArray2.put(((C4154e) it3.next()).m3152g());
        }
        Unit unit2 = Unit.INSTANCE;
        jSONObject.put("outcomes", jSONArray2);
        String str = this.f4768f;
        if (str != null) {
            jSONObject.put("evalLogic", str);
        }
        return jSONObject;
    }

    public String toString() {
        return "Trigger(id=" + this.f4763a + ", key=" + this.f4764b + ", startDateUtc=" + this.f4765c + ", rules=" + this.f4766d + ", outcomes=" + this.f4767e + ", evalLogic=" + this.f4768f + ")";
    }

    public /* synthetic */ C4157h(String str, String str2, Date date, List list, List list2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : date, (i & 8) != 0 ? null : list, list2, (i & 32) != 0 ? null : str3);
    }

    /* JADX INFO: renamed from: a */
    public final C4157h m3171a(String id, String key, Date date, List<C4156g> list, List<C4154e> outcomes, String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(outcomes, "outcomes");
        return new C4157h(id, key, date, list, outcomes, str);
    }

    public C4157h(JSONObject json) throws JSONException {
        ArrayList arrayList;
        String strReplace$default;
        C4154e c4154e;
        Object string;
        JSONObject jSONObject;
        C4156g c4156g;
        Object string2;
        JSONObject jSONObject2;
        Intrinsics.checkNotNullParameter(json, "json");
        String string3 = json.getString("id");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = json.getString("key");
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String strOptString = json.optString("startDateUtc");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strM3408b = C4190m.m3408b(strOptString);
        Date dateM3404a = strM3408b != null ? C4190m.m3404a(strM3408b) : null;
        JSONArray jSONArrayOptJSONArray = json.optJSONArray("rules");
        if (jSONArrayOptJSONArray != null) {
            IntRange intRangeUntil = RangesKt.until(0, jSONArrayOptJSONArray.length());
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it2 = intRangeUntil.iterator();
            while (it2.hasNext()) {
                int iNextInt = ((IntIterator) it2).nextInt();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                    jSONObject2 = jSONArrayOptJSONArray.getJSONObject(iNextInt);
                    if (jSONObject2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        string2 = Integer.valueOf(jSONArrayOptJSONArray.getInt(iNextInt));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        string2 = Double.valueOf(jSONArrayOptJSONArray.getDouble(iNextInt));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        string2 = Long.valueOf(jSONArrayOptJSONArray.getLong(iNextInt));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        string2 = Boolean.valueOf(jSONArrayOptJSONArray.getBoolean(iNextInt));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        string2 = jSONArrayOptJSONArray.getString(iNextInt);
                        if (string2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                    } else {
                        string2 = jSONArrayOptJSONArray.get(iNextInt);
                        if (string2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                    }
                    jSONObject2 = (JSONObject) string2;
                }
                arrayList2.add(jSONObject2);
            }
            arrayList = new ArrayList();
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                try {
                    c4156g = new C4156g((JSONObject) it3.next());
                } catch (Exception unused) {
                    c4156g = null;
                }
                if (c4156g != null) {
                    arrayList.add(c4156g);
                }
            }
        } else {
            arrayList = null;
        }
        JSONArray jSONArray = json.getJSONArray("outcomes");
        Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
        IntRange intRangeUntil2 = RangesKt.until(0, jSONArray.length());
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil2, 10));
        Iterator<Integer> it4 = intRangeUntil2.iterator();
        while (it4.hasNext()) {
            int iNextInt2 = ((IntIterator) it4).nextInt();
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JSONObject.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                jSONObject = jSONArray.getJSONObject(iNextInt2);
                if (jSONObject == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    string = Integer.valueOf(jSONArray.getInt(iNextInt2));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    string = Double.valueOf(jSONArray.getDouble(iNextInt2));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    string = Long.valueOf(jSONArray.getLong(iNextInt2));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    string = Boolean.valueOf(jSONArray.getBoolean(iNextInt2));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    string = jSONArray.getString(iNextInt2);
                    if (string == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                } else {
                    string = jSONArray.get(iNextInt2);
                    if (string == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                }
                jSONObject = (JSONObject) string;
            }
            arrayList3.add(jSONObject);
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            try {
                c4154e = new C4154e((JSONObject) it5.next());
            } catch (Exception unused2) {
                c4154e = null;
            }
            if (c4154e != null) {
                arrayList4.add(c4154e);
            }
        }
        String stringOrNull = PushExtensionsKt.getStringOrNull(json, "evalLogic");
        if (stringOrNull != null) {
            boolean z = true;
            List listSplit$default = StringsKt.split$default((CharSequence) stringOrNull, new String[]{"&&"}, false, 0, 6, (Object) null);
            List listSplit$default2 = StringsKt.split$default((CharSequence) stringOrNull, new String[]{"||"}, false, 0, 6, (Object) null);
            if (StringsKt.isBlank(stringOrNull) || (listSplit$default.size() > 1 && listSplit$default2.size() > 1)) {
                throw new IllegalArgumentException("evalLogic was blank or contained both && and || operators");
            }
            ArrayList arrayList5 = new ArrayList();
            if (listSplit$default.size() > 1) {
                arrayList5.addAll(listSplit$default);
            } else {
                arrayList5.addAll(listSplit$default2);
            }
            Iterator it6 = arrayList5.iterator();
            while (it6.hasNext()) {
                String string5 = StringsKt.trim((CharSequence) it6.next()).toString();
                if (StringsKt.isBlank(string5) || StringsKt.toLongOrNull(string5) == null || Long.parseLong(string5) < 0) {
                    z = false;
                }
            }
            if (!z) {
                throw new IllegalArgumentException("evalLogic contained non-numeric indexes.");
            }
            strReplace$default = StringsKt.replace$default(stringOrNull, " ", "", false, 4, (Object) null);
        } else {
            strReplace$default = null;
        }
        this(string3, string4, dateM3404a, arrayList, arrayList4, strReplace$default);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ C4157h m3170a(C4157h c4157h, String str, String str2, Date date, List list, List list2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c4157h.f4763a;
        }
        if ((i & 2) != 0) {
            str2 = c4157h.f4764b;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            date = c4157h.f4765c;
        }
        Date date2 = date;
        if ((i & 8) != 0) {
            list = c4157h.f4766d;
        }
        List list3 = list;
        if ((i & 16) != 0) {
            list2 = c4157h.f4767e;
        }
        List list4 = list2;
        if ((i & 32) != 0) {
            str3 = c4157h.f4768f;
        }
        return c4157h.m3171a(str, str4, date2, list3, list4, str3);
    }

    /* JADX INFO: renamed from: a */
    public final void m3173a(String str) {
        this.f4768f = str;
    }
}
