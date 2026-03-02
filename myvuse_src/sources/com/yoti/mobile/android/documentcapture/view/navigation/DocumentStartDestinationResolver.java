package com.yoti.mobile.android.documentcapture.view.navigation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.FragmentKt;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentStartDestinationResolver;", "", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;)V", "startDestinationId", "", "resolve", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "navHostFragmentId", "navGraphId", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentStartDestinationResolver {
    private final int startDestinationId;

    @Inject
    public DocumentStartDestinationResolver(DocumentCaptureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.startDestinationId = featureConfiguration.getIsSelectableDocumentFlow() ? C4597R.id.documentSelectionFragment : featureConfiguration.getIsValidationAndGuidanceEnabled() ? C4597R.id.documentRequirementsFragment : C4597R.id.documentEducationalFragment;
    }

    public final void resolve(FragmentManager fragmentManager, int navHostFragmentId, int navGraphId) {
        NavController navControllerFindNavController;
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(navHostFragmentId);
        if (fragmentFindFragmentById == null || (navControllerFindNavController = FragmentKt.findNavController(fragmentFindFragmentById)) == null) {
            return;
        }
        NavGraph navGraphInflate = navControllerFindNavController.getNavInflater().inflate(navGraphId);
        NavDestination navDestinationFindNode = navGraphInflate.findNode(C4597R.id.document_selection_nav_graph);
        if (navDestinationFindNode == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavGraph");
        }
        ((NavGraph) navDestinationFindNode).setStartDestination(this.startDestinationId);
        navControllerFindNavController.setGraph(navGraphInflate);
    }
}
