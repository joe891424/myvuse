package com.yoti.mobile.android.yotisdkcore.feature;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H$J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0019H$J\u001a\u0010\u001d\u001a\u0002H\u001e\"\n\b\u0001\u0010\u001e\u0018\u0001*\u00020\tH\u0086\b¢\u0006\u0002\u0010\u001fJ\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u001bJ\u001a\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0018\u0010(\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u001bH\u0016J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0002H\u0016J\u001e\u0010+\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010,\u001a\u00020-J\u001e\u0010+\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/2\u0006\u0010,\u001a\u00020-R*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u0013X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureSession;", ExifInterface.LONGITUDE_EAST, "Landroid/app/Activity;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "rootActivityClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "featureComponents", "", "Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureComponent;", "getFeatureComponents$annotations", "()V", "getFeatureComponents", "()Ljava/util/List;", "setFeatureComponents", "(Ljava/util/List;)V", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "featureConfigurationKey", "", "getFeatureConfigurationKey", "()Ljava/lang/String;", "buildFeatureComponents", "activity", "createFeatureComponents", "", "bundle", "Landroid/os/Bundle;", "destroy", "getComponent", "COMPONENT", "()Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureComponent;", "initComponents", "savedInstanceState", "onActivityCreated", "p0", "p1", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "start", "requestCode", "", "fragment", "Landroidx/fragment/app/Fragment;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class FeatureSession<E extends Activity> implements Application.ActivityLifecycleCallbacks {
    private List<? extends FeatureComponent> featureComponents;
    private IFeatureConfiguration featureConfiguration;
    private final KClass<E> rootActivityClass;

    public FeatureSession(KClass<E> rootActivityClass) {
        Intrinsics.checkNotNullParameter(rootActivityClass, "rootActivityClass");
        this.rootActivityClass = rootActivityClass;
        this.featureComponents = CollectionsKt.emptyList();
    }

    private final void createFeatureComponents(Activity activity, Bundle bundle) {
        activity.getApplication().registerActivityLifecycleCallbacks(this);
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(activity.getClass()), this.rootActivityClass) && bundle != null) {
            Object obj = bundle.get(getF7754b());
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration");
            }
            this.featureConfiguration = (IFeatureConfiguration) obj;
        }
        IFeatureConfiguration iFeatureConfiguration = this.featureConfiguration;
        if (iFeatureConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("featureConfiguration");
            iFeatureConfiguration = null;
        }
        this.featureComponents = buildFeatureComponents(activity, iFeatureConfiguration);
    }

    public static /* synthetic */ void getFeatureComponents$annotations() {
    }

    protected abstract List<FeatureComponent> buildFeatureComponents(Activity activity, IFeatureConfiguration featureConfiguration);

    protected abstract void destroy();

    public final /* synthetic */ <COMPONENT extends FeatureComponent> COMPONENT getComponent() {
        List<FeatureComponent> featureComponents = getFeatureComponents();
        ArrayList arrayList = new ArrayList();
        for (Object obj : featureComponents) {
            Intrinsics.reifiedOperationMarker(3, "COMPONENT");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return (COMPONENT) arrayList.get(0);
    }

    public final List<FeatureComponent> getFeatureComponents() {
        return this.featureComponents;
    }

    /* JADX INFO: renamed from: getFeatureConfigurationKey */
    protected abstract String getF7754b();

    public final List<FeatureComponent> initComponents(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.featureComponents.isEmpty()) {
            createFeatureComponents(activity, savedInstanceState);
        }
        return this.featureComponents;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(p0.getClass()), this.rootActivityClass)) {
            p0.getApplication().unregisterActivityLifecycleCallbacks(this);
            this.featureComponents = CollectionsKt.emptyList();
            destroy();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(p0.getClass()), this.rootActivityClass)) {
            String featureConfigurationKey = getF7754b();
            IFeatureConfiguration iFeatureConfiguration = this.featureConfiguration;
            if (iFeatureConfiguration == null) {
                Intrinsics.throwUninitializedPropertyAccessException("featureConfiguration");
                iFeatureConfiguration = null;
            }
            p1.putParcelable(featureConfigurationKey, iFeatureConfiguration);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
    }

    public final void setFeatureComponents(List<? extends FeatureComponent> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.featureComponents = list;
    }

    public final void start(IFeatureConfiguration featureConfiguration, Activity activity, int requestCode) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.featureConfiguration = featureConfiguration;
        activity.startActivityForResult(new Intent(activity, (Class<?>) JvmClassMappingKt.getJavaClass((KClass) this.rootActivityClass)), requestCode);
    }

    public final void start(IFeatureConfiguration featureConfiguration, Fragment fragment, int requestCode) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.featureConfiguration = featureConfiguration;
        fragment.startActivityForResult(new Intent(fragment.requireContext(), (Class<?>) JvmClassMappingKt.getJavaClass((KClass) this.rootActivityClass)), requestCode);
    }
}
