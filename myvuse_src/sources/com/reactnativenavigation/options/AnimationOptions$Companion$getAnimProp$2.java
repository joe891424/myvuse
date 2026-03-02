package com.reactnativenavigation.options;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimationOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
/* synthetic */ class AnimationOptions$Companion$getAnimProp$2 extends FunctionReferenceImpl implements Function1<View, Float> {
    public static final AnimationOptions$Companion$getAnimProp$2 INSTANCE = new AnimationOptions$Companion$getAnimProp$2();

    AnimationOptions$Companion$getAnimProp$2() {
        super(1, View.class, "getY", "getY()F", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Float invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return Float.valueOf(p0.getY());
    }
}
