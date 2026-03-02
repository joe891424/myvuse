package androidx.navigation.p033ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.p033ui.AppBarConfiguration;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import java.lang.ref.WeakReference;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class NavigationUI {
    private NavigationUI() {
    }

    public static boolean onNavDestinationSelected(MenuItem menuItem, NavController navController) {
        NavOptions.Builder popExitAnim = new NavOptions.Builder().setLaunchSingleTop(true).setEnterAnim(C1008R.anim.nav_default_enter_anim).setExitAnim(C1008R.anim.nav_default_exit_anim).setPopEnterAnim(C1008R.anim.nav_default_pop_enter_anim).setPopExitAnim(C1008R.anim.nav_default_pop_exit_anim);
        if ((menuItem.getOrder() & ProfileVerifier.CompilationStatus.f1830xf2722a21) == 0) {
            popExitAnim.setPopUpTo(findStartDestination(navController.getGraph()).getId(), false);
        }
        try {
            navController.navigate(menuItem.getItemId(), (Bundle) null, popExitAnim.build());
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static boolean navigateUp(NavController navController, DrawerLayout drawerLayout) {
        return navigateUp(navController, new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(drawerLayout).build());
    }

    public static boolean navigateUp(NavController navController, AppBarConfiguration appBarConfiguration) {
        DrawerLayout drawerLayout = appBarConfiguration.getDrawerLayout();
        NavDestination currentDestination = navController.getCurrentDestination();
        Set<Integer> topLevelDestinations = appBarConfiguration.getTopLevelDestinations();
        if (drawerLayout != null && currentDestination != null && matchDestinations(currentDestination, topLevelDestinations)) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        if (navController.navigateUp()) {
            return true;
        }
        if (appBarConfiguration.getFallbackOnNavigateUpListener() != null) {
            return appBarConfiguration.getFallbackOnNavigateUpListener().onNavigateUp();
        }
        return false;
    }

    public static void setupActionBarWithNavController(AppCompatActivity appCompatActivity, NavController navController) {
        setupActionBarWithNavController(appCompatActivity, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    public static void setupActionBarWithNavController(AppCompatActivity appCompatActivity, NavController navController, DrawerLayout drawerLayout) {
        setupActionBarWithNavController(appCompatActivity, navController, new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(drawerLayout).build());
    }

    public static void setupActionBarWithNavController(AppCompatActivity appCompatActivity, NavController navController, AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new ActionBarOnDestinationChangedListener(appCompatActivity, appBarConfiguration));
    }

    public static void setupWithNavController(Toolbar toolbar, NavController navController) {
        setupWithNavController(toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    public static void setupWithNavController(Toolbar toolbar, NavController navController, DrawerLayout drawerLayout) {
        setupWithNavController(toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(drawerLayout).build());
    }

    public static void setupWithNavController(Toolbar toolbar, final NavController navController, final AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new ToolbarOnDestinationChangedListener(toolbar, appBarConfiguration));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.navigation.ui.NavigationUI.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationUI.navigateUp(navController, appBarConfiguration);
            }
        });
    }

    public static void setupWithNavController(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController) {
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    public static void setupWithNavController(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController, DrawerLayout drawerLayout) {
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(drawerLayout).build());
    }

    public static void setupWithNavController(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, final NavController navController, final AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new CollapsingToolbarOnDestinationChangedListener(collapsingToolbarLayout, toolbar, appBarConfiguration));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.navigation.ui.NavigationUI.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationUI.navigateUp(navController, appBarConfiguration);
            }
        });
    }

    public static void setupWithNavController(final NavigationView navigationView, final NavController navController) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() { // from class: androidx.navigation.ui.NavigationUI.3
            @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean zOnNavDestinationSelected = NavigationUI.onNavDestinationSelected(menuItem, navController);
                if (zOnNavDestinationSelected) {
                    ViewParent parent = navigationView.getParent();
                    if (parent instanceof DrawerLayout) {
                        ((DrawerLayout) parent).closeDrawer(navigationView);
                    } else {
                        BottomSheetBehavior bottomSheetBehaviorFindBottomSheetBehavior = NavigationUI.findBottomSheetBehavior(navigationView);
                        if (bottomSheetBehaviorFindBottomSheetBehavior != null) {
                            bottomSheetBehaviorFindBottomSheetBehavior.setState(5);
                        }
                    }
                }
                return zOnNavDestinationSelected;
            }
        });
        final WeakReference weakReference = new WeakReference(navigationView);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: androidx.navigation.ui.NavigationUI.4
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public void onDestinationChanged(NavController navController2, NavDestination navDestination, Bundle bundle) {
                NavigationView navigationView2 = (NavigationView) weakReference.get();
                if (navigationView2 == null) {
                    navController.removeOnDestinationChangedListener(this);
                    return;
                }
                Menu menu = navigationView2.getMenu();
                int size = menu.size();
                for (int i = 0; i < size; i++) {
                    MenuItem item = menu.getItem(i);
                    item.setChecked(NavigationUI.matchDestination(navDestination, item.getItemId()));
                }
            }
        });
    }

    static BottomSheetBehavior findBottomSheetBehavior(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            Object parent = view.getParent();
            if (parent instanceof View) {
                return findBottomSheetBehavior((View) parent);
            }
            return null;
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (behavior instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behavior;
        }
        return null;
    }

    public static void setupWithNavController(BottomNavigationView bottomNavigationView, final NavController navController) {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { // from class: androidx.navigation.ui.NavigationUI.5
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                return NavigationUI.onNavDestinationSelected(menuItem, navController);
            }
        });
        final WeakReference weakReference = new WeakReference(bottomNavigationView);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: androidx.navigation.ui.NavigationUI.6
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public void onDestinationChanged(NavController navController2, NavDestination navDestination, Bundle bundle) {
                BottomNavigationView bottomNavigationView2 = (BottomNavigationView) weakReference.get();
                if (bottomNavigationView2 == null) {
                    navController.removeOnDestinationChangedListener(this);
                    return;
                }
                Menu menu = bottomNavigationView2.getMenu();
                int size = menu.size();
                for (int i = 0; i < size; i++) {
                    MenuItem item = menu.getItem(i);
                    if (NavigationUI.matchDestination(navDestination, item.getItemId())) {
                        item.setChecked(true);
                    }
                }
            }
        });
    }

    static boolean matchDestination(NavDestination navDestination, int i) {
        while (navDestination.getId() != i && navDestination.getParent() != null) {
            navDestination = navDestination.getParent();
        }
        return navDestination.getId() == i;
    }

    static boolean matchDestinations(NavDestination navDestination, Set<Integer> set) {
        while (!set.contains(Integer.valueOf(navDestination.getId()))) {
            navDestination = navDestination.getParent();
            if (navDestination == null) {
                return false;
            }
        }
        return true;
    }

    static NavDestination findStartDestination(NavGraph navGraph) {
        NavDestination navDestinationFindNode = navGraph;
        while (navDestinationFindNode instanceof NavGraph) {
            NavGraph navGraph2 = (NavGraph) navDestinationFindNode;
            navDestinationFindNode = navGraph2.findNode(navGraph2.getStartDestination());
        }
        return navDestinationFindNode;
    }
}
