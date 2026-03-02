package com.tinder;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: StateMachine.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010\u0004\u0018\u0001*\u0002H\u0002\"\b\b\u0002\u0010\u0002*\u00020\u0003\"\n\b\u0003\u0010\u0004 \u0001*\u0002H\u0002\"\b\b\u0004\u0010\u0005*\u00020\u0003\"\b\b\u0005\u0010\u0006*\u00020\u0003\"\b\b\u0006\u0010\u0007*\u00020\u0003*\u0002H\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, m5598d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "R", "STATE", "EVENT", "SIDE_EFFECT", "invoke", "(Ljava/lang/Object;)Z"}, m5599k = 3, m5600mv = {1, 1, 13})
public final class StateMachine$Matcher$Companion$eq$1<R> extends Lambda implements Function1<R, Boolean> {
    final /* synthetic */ Object $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateMachine$Matcher$Companion$eq$1(Object obj) {
        super(1);
        this.$value = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2(obj));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(R receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return Intrinsics.areEqual(receiver$0, this.$value);
    }
}
