package com.facebook.fresco.p037ui.common;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: VitoUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/facebook/fresco/ui/common/VitoUtils;", "", "()V", "idCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "generateIdentifier", "", "getStringId", "", "id", "ui-common_release"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
public final class VitoUtils {
    public static final VitoUtils INSTANCE = new VitoUtils();
    private static final AtomicLong idCounter = new AtomicLong();

    private VitoUtils() {
    }

    @JvmStatic
    public static final long generateIdentifier() {
        return idCounter.incrementAndGet();
    }

    @JvmStatic
    public static final String getStringId(long id) {
        return "v" + id;
    }
}
