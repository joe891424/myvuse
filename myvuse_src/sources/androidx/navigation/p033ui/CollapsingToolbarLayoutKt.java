package androidx.navigation.p033ui;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.p033ui.AppBarConfiguration;
import androidx.navigation.p033ui.AppBarConfigurationKt;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollapsingToolbarLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u000b"}, m5598d2 = {"setupWithNavController", "", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "navController", "Landroidx/navigation/NavController;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "navigation-ui-ktx_release"}, m5599k = 2, m5600mv = {1, 1, 15})
public final class CollapsingToolbarLayoutKt {
    public static final void setupWithNavController(CollapsingToolbarLayout setupWithNavController, Toolbar toolbar, NavController navController, DrawerLayout drawerLayout) {
        Intrinsics.checkParameterIsNotNull(setupWithNavController, "$this$setupWithNavController");
        Intrinsics.checkParameterIsNotNull(toolbar, "toolbar");
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
        NavigationUI.setupWithNavController(setupWithNavController, toolbar, navController, appBarConfigurationBuild);
    }

    public static /* synthetic */ void setupWithNavController$default(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
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
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, appBarConfiguration);
    }

    public static final void setupWithNavController(CollapsingToolbarLayout setupWithNavController, Toolbar toolbar, NavController navController, AppBarConfiguration configuration) {
        Intrinsics.checkParameterIsNotNull(setupWithNavController, "$this$setupWithNavController");
        Intrinsics.checkParameterIsNotNull(toolbar, "toolbar");
        Intrinsics.checkParameterIsNotNull(navController, "navController");
        Intrinsics.checkParameterIsNotNull(configuration, "configuration");
        NavigationUI.setupWithNavController(setupWithNavController, toolbar, navController, configuration);
    }
}
