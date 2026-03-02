package org.koin.core.instance;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.koin.core.Koin;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.error.InstanceCreationException;
import org.koin.core.logger.Level;

/* JADX INFO: compiled from: InstanceFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000 \u0013*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0013B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH&J\u0015\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\fH&¢\u0006\u0002\u0010\rJ\b\u0010\u0011\u001a\u00020\u0012H&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, m5598d2 = {"Lorg/koin/core/instance/InstanceFactory;", ExifInterface.GPS_DIRECTION_TRUE, "", "_koin", "Lorg/koin/core/Koin;", "beanDefinition", "Lorg/koin/core/definition/BeanDefinition;", "(Lorg/koin/core/Koin;Lorg/koin/core/definition/BeanDefinition;)V", "getBeanDefinition", "()Lorg/koin/core/definition/BeanDefinition;", "create", "context", "Lorg/koin/core/instance/InstanceContext;", "(Lorg/koin/core/instance/InstanceContext;)Ljava/lang/Object;", "drop", "", "get", "isCreated", "", "Companion", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
public abstract class InstanceFactory<T> {
    public static final String ERROR_SEPARATOR = "\n\t";
    private final Koin _koin;
    private final BeanDefinition<T> beanDefinition;

    public abstract void drop();

    public abstract T get(InstanceContext context);

    public abstract boolean isCreated();

    public InstanceFactory(Koin _koin, BeanDefinition<T> beanDefinition) {
        Intrinsics.checkParameterIsNotNull(_koin, "_koin");
        Intrinsics.checkParameterIsNotNull(beanDefinition, "beanDefinition");
        this._koin = _koin;
        this.beanDefinition = beanDefinition;
    }

    public final BeanDefinition<T> getBeanDefinition() {
        return this.beanDefinition;
    }

    public T create(InstanceContext context) throws InstanceCreationException {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (this._koin.get_logger().isAt(Level.DEBUG)) {
            this._koin.get_logger().debug("| create instance for " + this.beanDefinition);
        }
        try {
            return this.beanDefinition.getDefinition().invoke(context.getScope(), context.getParameters());
        } catch (Exception e) {
            StringBuilder sbAppend = new StringBuilder().append(e.toString()).append(ERROR_SEPARATOR);
            StackTraceElement[] stackTrace = e.getStackTrace();
            Intrinsics.checkExpressionValueIsNotNull(stackTrace, "e.stackTrace");
            ArrayList arrayList = new ArrayList();
            for (StackTraceElement it2 : stackTrace) {
                Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                String className = it2.getClassName();
                Intrinsics.checkExpressionValueIsNotNull(className, "it.className");
                if (StringsKt.contains$default((CharSequence) className, (CharSequence) "sun.reflect", false, 2, (Object) null)) {
                    break;
                }
                arrayList.add(it2);
            }
            this._koin.get_logger().error("Instance creation error : could not create instance for " + this.beanDefinition + ": " + sbAppend.append(CollectionsKt.joinToString$default(arrayList, ERROR_SEPARATOR, null, null, 0, null, null, 62, null)).toString());
            throw new InstanceCreationException("Could not create instance for " + this.beanDefinition, e);
        }
    }
}
