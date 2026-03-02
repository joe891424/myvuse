package com.reactnativenavigation.viewcontrollers.overlay;

import android.content.res.Configuration;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.reactnativenavigation.react.CommandListener;
import com.reactnativenavigation.utils.CoordinatorLayoutUtils;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.BehaviourDelegate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\u001e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u000bJ\u0006\u0010\u001b\u001a\u00020\u000bJ\"\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u001d\u001a\u00020\u001eR\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/overlay/OverlayManager;", "", "()V", "isEmpty", "", "()Z", "overlayRegistry", "", "", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "destroy", "", "overlaysContainer", "Landroid/view/ViewGroup;", "destroyOverlay", "overlay", "dismiss", "componentId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/reactnativenavigation/react/CommandListener;", "dismissAll", "findControllerById", "id", "onConfigurationChanged", "configuration", "Landroid/content/res/Configuration;", "onHostPause", "onHostResume", "show", "size", "", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class OverlayManager {
    private final Map<String, ViewController<?>> overlayRegistry = new LinkedHashMap();

    public final void show(ViewGroup overlaysContainer, final ViewController<?> overlay, final CommandListener listener) {
        Intrinsics.checkNotNullParameter(overlaysContainer, "overlaysContainer");
        Intrinsics.checkNotNullParameter(overlay, "overlay");
        Intrinsics.checkNotNullParameter(listener, "listener");
        overlaysContainer.setVisibility(0);
        Map<String, ViewController<?>> map = this.overlayRegistry;
        String id = overlay.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        map.put(id, overlay);
        overlay.addOnAppearedListener(new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.overlay.OverlayManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OverlayManager.show$lambda$0(overlay, listener);
            }
        });
        overlaysContainer.addView(overlay.getView(), CoordinatorLayoutUtils.matchParentWithBehaviour(new BehaviourDelegate(overlay)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$0(ViewController overlay, CommandListener listener) {
        Intrinsics.checkNotNullParameter(overlay, "$overlay");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        overlay.onViewDidAppear();
        listener.onSuccess(overlay.getId());
    }

    public final void onConfigurationChanged(Configuration configuration) {
        Iterator<T> it2 = this.overlayRegistry.values().iterator();
        while (it2.hasNext()) {
            ((ViewController) it2.next()).onConfigurationChanged(configuration);
        }
    }

    public final void dismiss(ViewGroup overlaysContainer, String componentId, CommandListener listener) {
        Intrinsics.checkNotNullParameter(overlaysContainer, "overlaysContainer");
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ViewController<?> viewControllerRemove = this.overlayRegistry.remove(componentId);
        if (viewControllerRemove == null) {
            listener.onError("Could not dismiss Overlay. Overlay with id " + componentId + " was not found.");
        } else {
            destroyOverlay(overlaysContainer, viewControllerRemove);
            listener.onSuccess(componentId);
        }
    }

    public final void dismissAll(ViewGroup overlaysContainer, CommandListener listener) {
        Intrinsics.checkNotNullParameter(overlaysContainer, "overlaysContainer");
        Intrinsics.checkNotNullParameter(listener, "listener");
        destroy(overlaysContainer);
        listener.onSuccess("");
    }

    public final void destroy(ViewGroup overlaysContainer) {
        Intrinsics.checkNotNullParameter(overlaysContainer, "overlaysContainer");
        Collection<ViewController<?>> collectionValues = this.overlayRegistry.values();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionValues, 10));
        for (ViewController<?> viewController : collectionValues) {
            destroyOverlay(overlaysContainer, viewController);
            arrayList.add(viewController.getId());
        }
        Iterator it2 = CollectionsKt.toList(arrayList).iterator();
        while (it2.hasNext()) {
            this.overlayRegistry.remove((String) it2.next());
        }
    }

    public final int size() {
        return this.overlayRegistry.size();
    }

    public final ViewController<?> findControllerById(String id) {
        return this.overlayRegistry.get(id);
    }

    private final void destroyOverlay(ViewGroup overlaysContainer, ViewController<?> overlay) {
        overlay.destroy();
        if (isEmpty()) {
            overlaysContainer.setVisibility(8);
        }
    }

    private final boolean isEmpty() {
        return size() == 0;
    }

    public final void onHostPause() {
        Iterator<T> it2 = this.overlayRegistry.values().iterator();
        while (it2.hasNext()) {
            ((ViewController) it2.next()).onViewDisappear();
        }
    }

    public final void onHostResume() {
        Iterator<T> it2 = this.overlayRegistry.values().iterator();
        while (it2.hasNext()) {
            ((ViewController) it2.next()).onViewDidAppear();
        }
    }
}
