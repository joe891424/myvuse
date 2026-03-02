package com.facebook.memory.helper;

import com.facebook.react.animated.InterpolationAnimatedNode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: HashCode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/facebook/memory/helper/HashCode;", "", "()V", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND, "", "current", "obj", "fbcore_release"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
public final class HashCode {
    public static final HashCode INSTANCE = new HashCode();

    private HashCode() {
    }

    @JvmStatic
    public static final int extend(int current, Object obj) {
        return (current * 31) + (obj != null ? obj.hashCode() : 0);
    }
}
