package com.reactnativenavigation.views.element.animators;

import android.animation.Animator;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.reactnativenavigation.options.SharedElementTransitionOptions;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PropertyAnimatorCreator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0017\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0012\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\u001d\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u001aR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b8BX\u0082\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0002X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0002X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/animators/PropertyAnimatorCreator;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "", "from", TypedValues.TransitionType.S_TO, "(Landroid/view/View;Landroid/view/View;)V", "childClass", "Ljava/lang/Class;", "getChildClass$annotations", "()V", "getChildClass", "()Ljava/lang/Class;", "getFrom", "()Landroid/view/View;", "getTo", "create", "Landroid/animation/Animator;", "options", "Lcom/reactnativenavigation/options/SharedElementTransitionOptions;", "excludedViews", "", "shouldAnimateProperty", "", "fromChild", "toChild", "(Landroid/view/View;Landroid/view/View;)Z", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public abstract class PropertyAnimatorCreator<T extends View> {
    private final View from;
    private final View to;

    private static /* synthetic */ void getChildClass$annotations() {
    }

    public abstract Animator create(SharedElementTransitionOptions options);

    protected abstract boolean shouldAnimateProperty(T fromChild, T toChild);

    public PropertyAnimatorCreator(View from, View to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        this.from = from;
        this.to = to;
    }

    protected final View getFrom() {
        return this.from;
    }

    protected final View getTo() {
        return this.to;
    }

    public final boolean shouldAnimateProperty() {
        Class<T> childClass = getChildClass();
        if (childClass.isInstance(this.from) && childClass.isInstance(this.to) && !excludedViews().contains(this.from.getClass()) && !excludedViews().contains(this.to.getClass())) {
            View view = this.from;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type T of com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator");
            View view2 = this.to;
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type T of com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator");
            if (shouldAnimateProperty(view, view2)) {
                return true;
            }
        }
        return false;
    }

    protected List<Class<?>> excludedViews() {
        return CollectionsKt.emptyList();
    }

    private final Class<T> getChildClass() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<T of com.reactnativenavigation.views.element.animators.PropertyAnimatorCreator>");
        return (Class) type;
    }
}
