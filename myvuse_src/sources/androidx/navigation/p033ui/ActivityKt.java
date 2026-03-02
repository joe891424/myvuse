package androidx.navigation.p033ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.p033ui.AppBarConfiguration;
import androidx.navigation.p033ui.AppBarConfigurationKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Activity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, m5598d2 = {"setupActionBarWithNavController", "", "Landroidx/appcompat/app/AppCompatActivity;", "navController", "Landroidx/navigation/NavController;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "navigation-ui-ktx_release"}, m5599k = 2, m5600mv = {1, 1, 15})
public final class ActivityKt {
    public static final void setupActionBarWithNavController(AppCompatActivity setupActionBarWithNavController, NavController navController, DrawerLayout drawerLayout) {
        Intrinsics.checkParameterIsNotNull(setupActionBarWithNavController, "$this$setupActionBarWithNavController");
        Intrinsics.checkParameterIsNotNull(navController, "navController");
        NavGraph graph = navController.getGraph();
        Intrinsics.checkExpressionValueIsNotNull(graph, "navController.graph");
        AppBarConfigurationKt.C09981 c09981 = AppBarConfigurationKt.C09981.INSTANCE;
        AppBarConfiguration.Builder drawerLayout2 = new AppBarConfiguration.Builder(graph).setDrawerLayout(drawerLayout);
        Object c1001x56421ee5 = c09981;
        if (c09981 != null) {
            c1001x56421ee5 = new C1001x56421ee5(c09981);
        }
        AppBarConfiguration appBarConfigurationBuild = drawerLayout2.setFallbackOnNavigateUpListener((AppBarConfiguration.OnNavigateUpListener) c1001x56421ee5).build();
        Intrinsics.checkExpressionValueIsNotNull(appBarConfigurationBuild, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        NavigationUI.setupActionBarWithNavController(setupActionBarWithNavController, navController, appBarConfigurationBuild);
    }

    public static /* synthetic */ void setupActionBarWithNavController$default(AppCompatActivity appCompatActivity, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            NavGraph graph = navController.getGraph();
            Intrinsics.checkExpressionValueIsNotNull(graph, "navController.graph");
            AppBarConfigurationKt.C09981 c09981 = AppBarConfigurationKt.C09981.INSTANCE;
            AppBarConfiguration.Builder drawerLayout = new AppBarConfiguration.Builder(graph).setDrawerLayout(null);
            Object c1001x56421ee5 = c09981;
            if (c09981 != null) {
                c1001x56421ee5 = new C1001x56421ee5(c09981);
            }
            appBarConfiguration = drawerLayout.setFallbackOnNavigateUpListener((AppBarConfiguration.OnNavigateUpListener) c1001x56421ee5).build();
            Intrinsics.checkExpressionValueIsNotNull(appBarConfiguration, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        }
        setupActionBarWithNavController(appCompatActivity, navController, appBarConfiguration);
    }

    public static final void setupActionBarWithNavController(AppCompatActivity setupActionBarWithNavController, NavController navController, AppBarConfiguration configuration) {
        Intrinsics.checkParameterIsNotNull(setupActionBarWithNavController, "$this$setupActionBarWithNavController");
        Intrinsics.checkParameterIsNotNull(navController, "navController");
        Intrinsics.checkParameterIsNotNull(configuration, "configuration");
        NavigationUI.setupActionBarWithNavController(setupActionBarWithNavController, navController, configuration);
    }
}
