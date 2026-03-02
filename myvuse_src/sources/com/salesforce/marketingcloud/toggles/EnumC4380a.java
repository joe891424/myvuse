package com.salesforce.marketingcloud.toggles;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: com.salesforce.marketingcloud.toggles.a */
/* JADX INFO: loaded from: classes6.dex */
public final class EnumC4380a {

    /* JADX INFO: renamed from: a */
    public static final EnumC4380a f5738a = new EnumC4380a("UNKNOWN", 0);

    /* JADX INFO: renamed from: b */
    public static final EnumC4380a f5739b = new EnumC4380a("ENABLED", 1);

    /* JADX INFO: renamed from: c */
    public static final EnumC4380a f5740c = new EnumC4380a("DISABLED", 2);

    /* JADX INFO: renamed from: d */
    private static final /* synthetic */ EnumC4380a[] f5741d;

    /* JADX INFO: renamed from: e */
    private static final /* synthetic */ EnumEntries f5742e;

    static {
        EnumC4380a[] enumC4380aArrM4247a = m4247a();
        f5741d = enumC4380aArrM4247a;
        f5742e = EnumEntriesKt.enumEntries(enumC4380aArrM4247a);
    }

    private EnumC4380a(String str, int i) {
    }

    /* JADX INFO: renamed from: a */
    private static final /* synthetic */ EnumC4380a[] m4247a() {
        return new EnumC4380a[]{f5738a, f5739b, f5740c};
    }

    /* JADX INFO: renamed from: b */
    public static EnumEntries<EnumC4380a> m4248b() {
        return f5742e;
    }

    public static EnumC4380a valueOf(String str) {
        return (EnumC4380a) Enum.valueOf(EnumC4380a.class, str);
    }

    public static EnumC4380a[] values() {
        return (EnumC4380a[]) f5741d.clone();
    }
}
