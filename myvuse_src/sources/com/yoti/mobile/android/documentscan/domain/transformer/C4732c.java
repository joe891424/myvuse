package com.yoti.mobile.android.documentscan.domain.transformer;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.transformer.c */
/* JADX INFO: loaded from: classes5.dex */
public final class C4732c {

    /* JADX INFO: renamed from: a */
    private final String f6938a;

    /* JADX INFO: renamed from: b */
    private final List<String> f6939b;

    /* JADX INFO: renamed from: c */
    private final String f6940c;

    /* JADX INFO: renamed from: d */
    private final String f6941d;

    /* JADX INFO: renamed from: e */
    private final ImageFormat f6942e;

    public C4732c(String str, List<String> holograms, String str2, String str3, ImageFormat imageFormat) {
        Intrinsics.checkParameterIsNotNull(holograms, "holograms");
        Intrinsics.checkParameterIsNotNull(imageFormat, "imageFormat");
        this.f6938a = str;
        this.f6939b = holograms;
        this.f6940c = str2;
        this.f6941d = str3;
        this.f6942e = imageFormat;
    }

    /* JADX INFO: renamed from: a */
    public final String m4843a() {
        return this.f6940c;
    }

    /* JADX INFO: renamed from: b */
    public final String m4844b() {
        return this.f6941d;
    }

    /* JADX INFO: renamed from: c */
    public final List<String> m4845c() {
        return this.f6939b;
    }

    /* JADX INFO: renamed from: d */
    public final ImageFormat m4846d() {
        return this.f6942e;
    }

    /* JADX INFO: renamed from: e */
    public final String m4847e() {
        return this.f6938a;
    }
}
