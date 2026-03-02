package com.reactnativenavigation.options;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import com.reactnativenavigation.NavigationApplication;
import com.reactnativenavigation.options.LayoutNode;
import com.reactnativenavigation.options.parsers.TypefaceLoader;
import com.reactnativenavigation.react.events.EventEmitter;
import com.reactnativenavigation.utils.Assertions;
import com.reactnativenavigation.utils.CollectionUtils;
import com.reactnativenavigation.utils.ImageLoader;
import com.reactnativenavigation.utils.RenderChecker;
import com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabPresenter;
import com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsAnimator;
import com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsController;
import com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsPresenter;
import com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.BottomTabsAttacher;
import com.reactnativenavigation.viewcontrollers.child.ChildControllersRegistry;
import com.reactnativenavigation.viewcontrollers.component.ComponentPresenter;
import com.reactnativenavigation.viewcontrollers.component.ComponentViewController;
import com.reactnativenavigation.viewcontrollers.externalcomponent.ExternalComponentCreator;
import com.reactnativenavigation.viewcontrollers.externalcomponent.ExternalComponentPresenter;
import com.reactnativenavigation.viewcontrollers.externalcomponent.ExternalComponentViewController;
import com.reactnativenavigation.viewcontrollers.sidemenu.SideMenuController;
import com.reactnativenavigation.viewcontrollers.sidemenu.SideMenuPresenter;
import com.reactnativenavigation.viewcontrollers.stack.StackControllerBuilder;
import com.reactnativenavigation.viewcontrollers.stack.StackPresenter;
import com.reactnativenavigation.viewcontrollers.stack.topbar.TopBarController;
import com.reactnativenavigation.viewcontrollers.stack.topbar.button.IconResolver;
import com.reactnativenavigation.viewcontrollers.toptabs.TopTabsController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.Presenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.component.ComponentViewCreator;
import com.reactnativenavigation.views.stack.topbar.TopBarBackgroundViewCreator;
import com.reactnativenavigation.views.stack.topbar.titlebar.TitleBarButtonCreator;
import com.reactnativenavigation.views.stack.topbar.titlebar.TitleBarReactViewCreator;
import com.reactnativenavigation.views.toptabs.TopTabsLayoutCreator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class LayoutFactory {
    private Activity activity;
    private ChildControllersRegistry childRegistry;
    private Options defaultOptions = new Options();
    private EventEmitter eventEmitter;
    private Map<String, ExternalComponentCreator> externalComponentCreators;
    private final ReactInstanceManager reactInstanceManager;
    private TypefaceLoader typefaceManager;

    public void setDefaultOptions(Options options) {
        Assertions.assertNotNull(options);
        this.defaultOptions = options;
    }

    public LayoutFactory(ReactInstanceManager reactInstanceManager) {
        this.reactInstanceManager = reactInstanceManager;
    }

    public void init(Activity activity, EventEmitter eventEmitter, ChildControllersRegistry childControllersRegistry, Map<String, ExternalComponentCreator> map) {
        this.activity = activity;
        this.eventEmitter = eventEmitter;
        this.childRegistry = childControllersRegistry;
        this.externalComponentCreators = map;
        this.typefaceManager = new TypefaceLoader(activity);
    }

    /* JADX INFO: renamed from: com.reactnativenavigation.options.LayoutFactory$1 */
    static /* synthetic */ class C39691 {
        static final /* synthetic */ int[] $SwitchMap$com$reactnativenavigation$options$LayoutNode$Type;

        static {
            int[] iArr = new int[LayoutNode.Type.values().length];
            $SwitchMap$com$reactnativenavigation$options$LayoutNode$Type = iArr;
            try {
                iArr[LayoutNode.Type.Component.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$LayoutNode$Type[LayoutNode.Type.ExternalComponent.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$LayoutNode$Type[LayoutNode.Type.Stack.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$LayoutNode$Type[LayoutNode.Type.BottomTabs.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$LayoutNode$Type[LayoutNode.Type.SideMenuRoot.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$LayoutNode$Type[LayoutNode.Type.SideMenuCenter.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$LayoutNode$Type[LayoutNode.Type.SideMenuLeft.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$LayoutNode$Type[LayoutNode.Type.SideMenuRight.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$LayoutNode$Type[LayoutNode.Type.TopTabs.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public ViewController<?> create(LayoutNode layoutNode) {
        ReactContext currentReactContext = this.reactInstanceManager.getCurrentReactContext();
        switch (C39691.$SwitchMap$com$reactnativenavigation$options$LayoutNode$Type[layoutNode.type.ordinal()]) {
            case 1:
                return createComponent(layoutNode);
            case 2:
                return createExternalComponent(currentReactContext, layoutNode);
            case 3:
                return createStack(layoutNode);
            case 4:
                return createBottomTabs(layoutNode);
            case 5:
                return createSideMenuRoot(layoutNode);
            case 6:
                return createSideMenuContent(layoutNode);
            case 7:
                return createSideMenuLeft(layoutNode);
            case 8:
                return createSideMenuRight(layoutNode);
            case 9:
                return createTopTabs(layoutNode);
            default:
                throw new IllegalArgumentException("Invalid node type: " + layoutNode.type);
        }
    }

    private ViewController<?> createSideMenuRoot(LayoutNode layoutNode) {
        SideMenuController sideMenuController = new SideMenuController(this.activity, this.childRegistry, layoutNode.f4202id, parseOptions(layoutNode.getOptions()), new SideMenuPresenter(), new Presenter(this.activity, this.defaultOptions));
        ViewController<?> viewControllerCreate = null;
        ViewController<?> viewControllerCreate2 = null;
        ViewController<?> viewControllerCreate3 = null;
        for (LayoutNode layoutNode2 : layoutNode.children) {
            int i = C39691.$SwitchMap$com$reactnativenavigation$options$LayoutNode$Type[layoutNode2.type.ordinal()];
            if (i == 6) {
                viewControllerCreate = create(layoutNode2);
                viewControllerCreate.setParentController(sideMenuController);
            } else if (i == 7) {
                viewControllerCreate2 = create(layoutNode2);
                viewControllerCreate2.setParentController(sideMenuController);
            } else if (i == 8) {
                viewControllerCreate3 = create(layoutNode2);
                viewControllerCreate3.setParentController(sideMenuController);
            } else {
                throw new IllegalArgumentException("Invalid node type in sideMenu: " + layoutNode.type);
            }
        }
        if (viewControllerCreate != null) {
            sideMenuController.setCenterController(viewControllerCreate);
        }
        if (viewControllerCreate2 != null) {
            sideMenuController.setLeftController(viewControllerCreate2);
        }
        if (viewControllerCreate3 != null) {
            sideMenuController.setRightController(viewControllerCreate3);
        }
        return sideMenuController;
    }

    private ViewController<?> createSideMenuContent(LayoutNode layoutNode) {
        return create(layoutNode.children.get(0));
    }

    private ViewController<?> createSideMenuLeft(LayoutNode layoutNode) {
        return create(layoutNode.children.get(0));
    }

    private ViewController<?> createSideMenuRight(LayoutNode layoutNode) {
        return create(layoutNode.children.get(0));
    }

    private ViewController<?> createComponent(LayoutNode layoutNode) {
        return new ComponentViewController(this.activity, this.childRegistry, layoutNode.f4202id, layoutNode.data.optString("name"), new ComponentViewCreator(this.reactInstanceManager), parseOptions(layoutNode.getOptions()), new Presenter(this.activity, this.defaultOptions), new ComponentPresenter(this.defaultOptions));
    }

    private ViewController<?> createExternalComponent(ReactContext reactContext, LayoutNode layoutNode) {
        ExternalComponent externalComponent = ExternalComponent.parse(layoutNode.data);
        return new ExternalComponentViewController(this.activity, this.childRegistry, layoutNode.f4202id, new Presenter(this.activity, this.defaultOptions), externalComponent, this.externalComponentCreators.get(externalComponent.name.get()), this.reactInstanceManager, new EventEmitter(reactContext), new ExternalComponentPresenter(), parseOptions(layoutNode.getOptions()));
    }

    private ViewController<?> createStack(LayoutNode layoutNode) {
        return new StackControllerBuilder(this.activity, this.eventEmitter).setChildren(createChildren(layoutNode.children)).setChildRegistry(this.childRegistry).setTopBarController(new TopBarController()).setId(layoutNode.f4202id).setInitialOptions(parseOptions(layoutNode.getOptions())).setStackPresenter(new StackPresenter(this.activity, new TitleBarReactViewCreator(this.reactInstanceManager), new TopBarBackgroundViewCreator(this.reactInstanceManager), new TitleBarButtonCreator(this.reactInstanceManager), new IconResolver(this.activity, new ImageLoader()), new TypefaceLoader(this.activity), new RenderChecker(), this.defaultOptions)).setPresenter(new Presenter(this.activity, this.defaultOptions)).build();
    }

    private List<ViewController<?>> createChildren(List<LayoutNode> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<LayoutNode> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(create(it2.next()));
        }
        return arrayList;
    }

    private ViewController<?> createBottomTabs(LayoutNode layoutNode) {
        ArrayList map = CollectionUtils.map(layoutNode.children, new CollectionUtils.Mapper() { // from class: com.reactnativenavigation.options.LayoutFactory$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.CollectionUtils.Mapper
            public final Object map(Object obj) {
                return this.f$0.create((LayoutNode) obj);
            }
        });
        BottomTabsPresenter bottomTabsPresenter = new BottomTabsPresenter(map, this.defaultOptions, new BottomTabsAnimator());
        return new BottomTabsController(this.activity, map, this.childRegistry, this.eventEmitter, new ImageLoader(), layoutNode.f4202id, parseOptions(layoutNode.getOptions()), new Presenter(this.activity, this.defaultOptions), new BottomTabsAttacher(map, bottomTabsPresenter, this.defaultOptions), bottomTabsPresenter, new BottomTabPresenter(this.activity, map, new ImageLoader(), new TypefaceLoader(this.activity), this.defaultOptions));
    }

    private ViewController<?> createTopTabs(LayoutNode layoutNode) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < layoutNode.children.size(); i++) {
            ViewController<?> viewControllerCreate = create(layoutNode.children.get(i));
            parseOptions(layoutNode.children.get(i).getOptions()).setTopTabIndex(i);
            arrayList.add(viewControllerCreate);
        }
        return new TopTabsController(this.activity, this.childRegistry, layoutNode.f4202id, arrayList, new TopTabsLayoutCreator(this.activity, arrayList), parseOptions(layoutNode.getOptions()), new Presenter(this.activity, this.defaultOptions));
    }

    private Options parseOptions(JSONObject jSONObject) {
        Context currentReactContext = this.reactInstanceManager.getCurrentReactContext();
        if (currentReactContext == null && (currentReactContext = this.activity) == null) {
            currentReactContext = NavigationApplication.instance;
        }
        if (this.typefaceManager == null) {
            this.typefaceManager = new TypefaceLoader(currentReactContext);
        }
        return Options.parse(currentReactContext, this.typefaceManager, jSONObject);
    }

    public Options getDefaultOptions() {
        return this.defaultOptions;
    }
}
