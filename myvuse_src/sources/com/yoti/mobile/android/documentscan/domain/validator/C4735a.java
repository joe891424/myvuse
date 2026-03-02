package com.yoti.mobile.android.documentscan.domain.validator;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.a */
/* JADX INFO: loaded from: classes5.dex */
final class C4735a {

    /* JADX INFO: renamed from: a */
    private final boolean f6950a;

    /* JADX INFO: renamed from: b */
    private final Map<String, C4735a> f6951b;

    public C4735a(boolean z, Map<String, C4735a> map) {
        this.f6950a = z;
        this.f6951b = map;
    }

    public /* synthetic */ C4735a(boolean z, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : map);
    }

    /* JADX INFO: renamed from: a */
    public final Map<String, C4735a> m4874a() {
        return this.f6951b;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m4875b() {
        return this.f6950a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4735a)) {
            return false;
        }
        C4735a c4735a = (C4735a) obj;
        return this.f6950a == c4735a.f6950a && Intrinsics.areEqual(this.f6951b, c4735a.f6951b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.f6950a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        Map<String, C4735a> map = this.f6951b;
        return i + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "SalutationNode(isComplete=" + this.f6950a + ", children=" + this.f6951b + ")";
    }
}
