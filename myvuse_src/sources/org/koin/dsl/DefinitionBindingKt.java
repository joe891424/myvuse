package org.koin.dsl;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Callbacks;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.scope.ScopeDefinition;

/* JADX INFO: compiled from: DefinitionBinding.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0086\b\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0086\u0004\u001a,\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001*\u0006\u0012\u0002\b\u00030\u00012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0007H\u0086\u0004¢\u0006\u0002\u0010\b\u001a?\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001e\u0010\t\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u0002H\u0002`\fH\u0086\u0004¨\u0006\r"}, m5598d2 = {"bind", "Lorg/koin/core/definition/BeanDefinition;", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Lkotlin/reflect/KClass;", "binds", "classes", "", "(Lorg/koin/core/definition/BeanDefinition;[Lkotlin/reflect/KClass;)Lorg/koin/core/definition/BeanDefinition;", "onClose", "Lkotlin/Function1;", "", "Lorg/koin/core/definition/OnCloseCallback;", "koin-core"}, m5599k = 2, m5600mv = {1, 1, 16})
public final class DefinitionBindingKt {
    public static final <T> BeanDefinition<T> bind(BeanDefinition<T> bind, KClass<?> clazz) throws DefinitionOverrideException {
        Intrinsics.checkParameterIsNotNull(bind, "$this$bind");
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        BeanDefinition<T> beanDefinitionCopy = bind.copy((479 & 1) != 0 ? bind.scopeDefinition : null, (479 & 2) != 0 ? bind.primaryType : null, (479 & 4) != 0 ? bind.qualifier : null, (479 & 8) != 0 ? bind.definition : null, (479 & 16) != 0 ? bind.kind : null, (479 & 32) != 0 ? bind.secondaryTypes : CollectionsKt.plus((Collection<? extends KClass<?>>) bind.getSecondaryTypes(), clazz), (479 & 64) != 0 ? bind.options : null, (479 & 128) != 0 ? bind.properties : null, (479 & 256) != 0 ? bind.callbacks : null);
        bind.getScopeDefinition().remove(bind);
        ScopeDefinition.save$default(bind.getScopeDefinition(), beanDefinitionCopy, false, 2, null);
        return beanDefinitionCopy;
    }

    public static final /* synthetic */ <T> BeanDefinition<?> bind(BeanDefinition<?> bind) {
        Intrinsics.checkParameterIsNotNull(bind, "$this$bind");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return bind(bind, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static final BeanDefinition<?> binds(BeanDefinition<?> binds, KClass<?>[] classes) {
        Intrinsics.checkParameterIsNotNull(binds, "$this$binds");
        Intrinsics.checkParameterIsNotNull(classes, "classes");
        BeanDefinition<?> beanDefinitionCopy = binds.copy((479 & 1) != 0 ? binds.scopeDefinition : null, (479 & 2) != 0 ? binds.primaryType : null, (479 & 4) != 0 ? binds.qualifier : null, (479 & 8) != 0 ? binds.definition : null, (479 & 16) != 0 ? binds.kind : null, (479 & 32) != 0 ? binds.secondaryTypes : CollectionsKt.plus((Collection) binds.getSecondaryTypes(), (Object[]) classes), (479 & 64) != 0 ? binds.options : null, (479 & 128) != 0 ? binds.properties : null, (479 & 256) != 0 ? binds.callbacks : null);
        binds.getScopeDefinition().remove(binds);
        ScopeDefinition.save$default(binds.getScopeDefinition(), beanDefinitionCopy, false, 2, null);
        return beanDefinitionCopy;
    }

    public static final <T> BeanDefinition<T> onClose(BeanDefinition<T> onClose, Function1<? super T, Unit> onClose2) throws DefinitionOverrideException {
        Intrinsics.checkParameterIsNotNull(onClose, "$this$onClose");
        Intrinsics.checkParameterIsNotNull(onClose2, "onClose");
        BeanDefinition<T> beanDefinitionCopy = onClose.copy((479 & 1) != 0 ? onClose.scopeDefinition : null, (479 & 2) != 0 ? onClose.primaryType : null, (479 & 4) != 0 ? onClose.qualifier : null, (479 & 8) != 0 ? onClose.definition : null, (479 & 16) != 0 ? onClose.kind : null, (479 & 32) != 0 ? onClose.secondaryTypes : null, (479 & 64) != 0 ? onClose.options : null, (479 & 128) != 0 ? onClose.properties : null, (479 & 256) != 0 ? onClose.callbacks : new Callbacks(onClose2));
        onClose.getScopeDefinition().remove(onClose);
        ScopeDefinition.save$default(onClose.getScopeDefinition(), beanDefinitionCopy, false, 2, null);
        return beanDefinitionCopy;
    }
}
