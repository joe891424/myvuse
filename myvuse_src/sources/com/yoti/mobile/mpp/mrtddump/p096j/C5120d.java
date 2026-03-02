package com.yoti.mobile.mpp.mrtddump.p096j;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.j.d */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\f0\u000ej\u0002`\u000fH\u0086\bø\u0001\u0000\u001a&\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\f0\u000ej\u0002`\u000fH\u0086\bø\u0001\u0000\u001a,\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\f0\u000ej\u0002`\u000fH\u0000\u001a&\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\f0\u000ej\u0002`\u000fH\u0086\bø\u0001\u0000\u001a&\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\f0\u000ej\u0002`\u000fH\u0086\bø\u0001\u0000\u001a0\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\f0\u000ej\u0002`\u000fH\u0086\bø\u0001\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b*\u0016\u0010\u0015\"\b\u0012\u0004\u0012\u00020\f0\u000e2\b\u0012\u0004\u0012\u00020\f0\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, m5598d2 = {"_logLevel", "Lkotlinx/atomicfu/AtomicInt;", "value", "", "loggerLevel", "getLoggerLevel", "()I", "setLoggerLevel", "(I)V", "logDebug", "", HeaderParameterNames.AUTHENTICATION_TAG, "", "buildMessage", "Lkotlin/Function0;", "Lcom/yoti/mobile/mpp/mrtddump/util/MessageBuilder;", "logError", "error", "", "logVerbose", "logWarning", "MessageBuilder", "mrtddump_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C5120d {

    /* JADX INFO: renamed from: a */
    private static final AtomicInt f8137a = AtomicFU.atomic(6);

    /* JADX INFO: renamed from: a */
    public static final int m5539a() {
        return f8137a.getValue();
    }

    /* JADX INFO: renamed from: a */
    public static final void m5540a(int i) {
        f8137a.setValue(i);
    }

    /* JADX INFO: renamed from: a */
    public static final void m5541a(String tag, Throwable th, Function0<String> buildMessage) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(buildMessage, "buildMessage");
        if (m5539a() <= 5) {
            C5119c.m5532a(tag, buildMessage.invoke(), th);
        }
    }
}
