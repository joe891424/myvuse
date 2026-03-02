package com.yoti.mobile.mpp.mrtddump.asn1;

import com.yoti.mobile.mpp.mrtddump.p096j.C5117a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.e.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/asn1/PartialTlvObject;", "Lcom/yoti/mobile/mpp/mrtddump/asn1/TlvObject;", HeaderParameterNames.AUTHENTICATION_TAG, "", "length", "value", "", "Lcom/yoti/mobile/mpp/mrtddump/GenericData;", "(II[B)V", "getLength", "()I", "appendBytes", "", "newData", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class PartialTlvObject extends TlvObject {

    /* JADX INFO: renamed from: c */
    private final int f8013c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PartialTlvObject(int i, int i2, byte[] value) {
        super(i, value);
        Intrinsics.checkNotNullParameter(value, "value");
        this.f8013c = i2;
    }

    /* JADX INFO: renamed from: b */
    public final void m5422b(byte[] newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        m5438a(C5117a.m5524b(m5443e(), newData));
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getF8013c() {
        return this.f8013c;
    }
}
