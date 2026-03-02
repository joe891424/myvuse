package com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes;

import android.view.ViewGroup;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.utils.CollectionUtils;
import com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsPresenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Together extends AttachMode {
    public Together(ViewGroup viewGroup, List<ViewController<?>> list, BottomTabsPresenter bottomTabsPresenter, Options options) {
        super(viewGroup, list, bottomTabsPresenter, options);
    }

    @Override // com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes.AttachMode
    public void attach() {
        CollectionUtils.forEach((List) this.tabs, new CollectionUtils.Apply() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes.Together$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
            /* JADX INFO: renamed from: on */
            public final void mo2796on(Object obj) {
                this.f$0.attach((ViewController) obj);
            }
        });
    }
}
