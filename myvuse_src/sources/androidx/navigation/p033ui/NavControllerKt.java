package androidx.navigation.p033ui;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.p033ui.AppBarConfiguration;
import androidx.navigation.p033ui.AppBarConfigurationKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavController.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m5598d2 = {"navigateUp", "", "Landroidx/navigation/NavController;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "appBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "navigation-ui-ktx_release"}, m5599k = 2, m5600mv = {1, 1, 15})
public final class NavControllerKt {
    public static final boolean navigateUp(NavController navigateUp, DrawerLayout drawerLayout) {
        Intrinsics.checkParameterIsNotNull(navigateUp, "$this$navigateUp");
        NavGraph graph = navigateUp.getGraph();
        Intrinsics.checkExpressionValueIsNotNull(graph, "graph");
        AppBarConfigurationKt.C09981 c09981 = AppBarConfigurationKt.C09981.INSTANCE;
        AppBarConfiguration.Builder drawerLayout2 = new AppBarConfiguration.Builder(graph).setDrawerLayout(drawerLayout);
        Object c1001x56421ee5 = c09981;
        if (c09981 != null) {
            c1001x56421ee5 = new C1001x56421ee5(c09981);
        }
        AppBarConfiguration appBarConfigurationBuild = drawerLayout2.setFallbackOnNavigateUpListener((AppBarConfiguration.OnNavigateUpListener) c1001x56421ee5).build();
        Intrinsics.checkExpressionValueIsNotNull(appBarConfigurationBuild, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return NavigationUI.navigateUp(navigateUp, appBarConfigurationBuild);
    }

    public static final boolean navigateUp(NavController navigateUp, AppBarConfiguration appBarConfiguration) {
        Intrinsics.checkParameterIsNotNull(navigateUp, "$this$navigateUp");
        Intrinsics.checkParameterIsNotNull(appBarConfiguration, "appBarConfiguration");
        return NavigationUI.navigateUp(navigateUp, appBarConfiguration);
    }
}
