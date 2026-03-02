package org.koin.core.instance;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.definition.BeanDefinition;

/* JADX INFO: compiled from: FactoryInstanceFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0015\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, m5598d2 = {"Lorg/koin/core/instance/FactoryInstanceFactory;", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/koin/core/instance/InstanceFactory;", "koin", "Lorg/koin/core/Koin;", "beanDefinition", "Lorg/koin/core/definition/BeanDefinition;", "(Lorg/koin/core/Koin;Lorg/koin/core/definition/BeanDefinition;)V", "drop", "", "get", "context", "Lorg/koin/core/instance/InstanceContext;", "(Lorg/koin/core/instance/InstanceContext;)Ljava/lang/Object;", "isCreated", "", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class FactoryInstanceFactory<T> extends InstanceFactory<T> {
    @Override // org.koin.core.instance.InstanceFactory
    public boolean isCreated() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FactoryInstanceFactory(Koin koin, BeanDefinition<T> beanDefinition) {
        super(koin, beanDefinition);
        Intrinsics.checkParameterIsNotNull(koin, "koin");
        Intrinsics.checkParameterIsNotNull(beanDefinition, "beanDefinition");
    }

    @Override // org.koin.core.instance.InstanceFactory
    public void drop() {
        Function1<T, Unit> onClose = getBeanDefinition().getCallbacks().getOnClose();
        if (onClose != null) {
            onClose.invoke(null);
        }
    }

    @Override // org.koin.core.instance.InstanceFactory
    public T get(InstanceContext context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return create(context);
    }
}
