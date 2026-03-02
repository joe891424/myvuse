package com.yoti.mobile.android.yotisdkcore.feature;

import android.app.Activity;
import android.os.Bundle;
import com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.FeatureComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0002\u0010\bJ\u001d\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H$¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0004J\u001d\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019R$\u0010\n\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00008F@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/SingleComponentFeatureSession;", "COMPONENT", "Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureComponent;", "ACTIVITY", "Landroid/app/Activity;", "Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureSession;", "rootActivityClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "value", "featureComponent", "getFeatureComponent", "()Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureComponent;", "setFeatureComponent", "(Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureComponent;)V", "buildFeatureComponent", "activity", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "(Landroid/app/Activity;Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;)Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureComponent;", "buildFeatureComponents", "", "initComponent", "savedInstanceState", "Landroid/os/Bundle;", "(Landroid/app/Activity;Landroid/os/Bundle;)Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureComponent;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class SingleComponentFeatureSession<COMPONENT extends FeatureComponent, ACTIVITY extends Activity> extends FeatureSession<ACTIVITY> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleComponentFeatureSession(KClass<ACTIVITY> rootActivityClass) {
        super(rootActivityClass);
        Intrinsics.checkNotNullParameter(rootActivityClass, "rootActivityClass");
    }

    protected abstract COMPONENT buildFeatureComponent(Activity activity, IFeatureConfiguration featureConfiguration);

    @Override // com.yoti.mobile.android.yotisdkcore.feature.FeatureSession
    protected final List<FeatureComponent> buildFeatureComponents(Activity activity, IFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        return CollectionsKt.listOf(buildFeatureComponent(activity, featureConfiguration));
    }

    public final COMPONENT getFeatureComponent() {
        return (COMPONENT) super.getFeatureComponents().get(0);
    }

    public final COMPONENT initComponent(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return (COMPONENT) initComponents(activity, savedInstanceState).get(0);
    }

    public final void setFeatureComponent(COMPONENT value) {
        Intrinsics.checkNotNullParameter(value, "value");
        super.setFeatureComponents(CollectionsKt.listOf(value));
    }
}
