package com.yoti.mobile.android.commonui;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SingleEvent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u000bH\u0002J\u0013\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u001a\u0010\u000e\u001a\u00020\t2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u000bJ\u000b\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/SingleEvent;", ExifInterface.GPS_DIRECTION_TRUE, "", "content", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "hasBeenHandled", "", "consume", "", "callback", "Lkotlin/Function1;", "equals", "other", "getContentIfNotHandled", "handleContent", "peekContent", "()Ljava/lang/Object;", "toString", "", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class SingleEvent<T> {
    private final T content;
    private boolean hasBeenHandled;

    public SingleEvent(T t) {
        this.content = t;
    }

    public final T peekContent() {
        return this.content;
    }

    public final void getContentIfNotHandled(final Function1<? super T, Unit> handleContent) {
        Intrinsics.checkNotNullParameter(handleContent, "handleContent");
        consume(new Function1<T, Unit>() { // from class: com.yoti.mobile.android.commonui.SingleEvent.getContentIfNotHandled.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T t) {
                handleContent.invoke((T) ((SingleEvent) this).content);
            }
        });
    }

    private final void consume(Function1<? super T, Unit> callback) {
        if (this.hasBeenHandled) {
            return;
        }
        this.hasBeenHandled = true;
        callback.invoke(this.content);
    }

    public boolean equals(Object other) {
        SingleEvent singleEvent = other instanceof SingleEvent ? (SingleEvent) other : null;
        if (singleEvent != null) {
            T t = this.content;
            Boolean boolValueOf = t != null ? Boolean.valueOf(t.equals(singleEvent.content)) : null;
            if (boolValueOf != null) {
                return boolValueOf.booleanValue();
            }
        }
        return false;
    }

    public String toString() {
        return "Event: {" + peekContent() + '}';
    }
}
