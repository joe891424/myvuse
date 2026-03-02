package com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes;

import android.view.ViewGroup;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.utils.CollectionUtils;
import com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsPresenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class AfterInitialTab extends AttachMode {
    private final Runnable attachOtherTabs;

    public AfterInitialTab(ViewGroup viewGroup, List<ViewController<?>> list, BottomTabsPresenter bottomTabsPresenter, Options options) {
        super(viewGroup, list, bottomTabsPresenter, options);
        this.attachOtherTabs = new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes.AfterInitialTab$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        CollectionUtils.forEach((List) otherTabs(), new CollectionUtils.Apply() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes.AfterInitialTab$$ExternalSyntheticLambda1
            @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
            /* JADX INFO: renamed from: on */
            public final void mo2796on(Object obj) {
                this.f$0.attach((ViewController) obj);
            }
        });
    }

    @Override // com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes.AttachMode
    public void attach() {
        this.initialTab.addOnAppearedListener(this.attachOtherTabs);
        attach(this.initialTab);
    }

    @Override // com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes.AttachMode
    public void destroy() {
        this.initialTab.removeOnAppearedListener(this.attachOtherTabs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$otherTabs$1(ViewController viewController) {
        return viewController != this.initialTab;
    }

    private List<ViewController<?>> otherTabs() {
        return CollectionUtils.filter(this.tabs, new CollectionUtils.Filter() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes.AfterInitialTab$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.CollectionUtils.Filter
            public final boolean filter(Object obj) {
                return this.f$0.lambda$otherTabs$1((ViewController) obj);
            }
        });
    }
}
