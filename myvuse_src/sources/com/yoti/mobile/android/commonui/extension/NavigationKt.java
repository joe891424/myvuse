package com.yoti.mobile.android.commonui.extension;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Navigation.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u001a \u0010\u000e\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u0010"}, m5598d2 = {"navigateSafe", "", "Landroidx/navigation/NavController;", "navDirection", "Landroidx/navigation/NavDirections;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "resId", "", "args", "Landroid/os/Bundle;", "navOptions", "Landroidx/navigation/NavOptions;", "navExtras", "navigateSafeToNavGraph", "navGraphNavigationRes", "commonUI_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NavigationKt {
    public static /* synthetic */ void navigateSafe$default(NavController navController, int i, Bundle bundle, NavOptions navOptions, Navigator.Extras extras, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        if ((i2 & 4) != 0) {
            navOptions = null;
        }
        if ((i2 & 8) != 0) {
            extras = null;
        }
        navigateSafe(navController, i, bundle, navOptions, extras);
    }

    public static final void navigateSafe(NavController navController, int i, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination == null || currentDestination.getAction(i) == null) {
            return;
        }
        if (navController instanceof NavController) {
            NavigationController.navigate(navController, i, bundle, navOptions, extras);
        } else {
            navController.navigate(i, bundle, navOptions, extras);
        }
    }

    public static /* synthetic */ void navigateSafe$default(NavController navController, NavDirections navDirections, Navigator.Extras extras, int i, Object obj) {
        if ((i & 2) != 0) {
            extras = null;
        }
        navigateSafe(navController, navDirections, extras);
    }

    public static final void navigateSafe(NavController navController, NavDirections navDirection, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        Intrinsics.checkNotNullParameter(navDirection, "navDirection");
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination == null || currentDestination.getAction(navDirection.getActionId()) == null) {
            return;
        }
        if (extras != null) {
            navController.navigate(navDirection, extras);
        } else {
            navController.navigate(navDirection);
        }
    }

    public static /* synthetic */ void navigateSafeToNavGraph$default(NavController navController, int i, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        navigateSafeToNavGraph(navController, i, bundle);
    }

    public static final void navigateSafeToNavGraph(NavController navController, int i, Bundle bundle) {
        NavGraph parent;
        Intrinsics.checkNotNullParameter(navController, "<this>");
        int id = navController.getNavInflater().inflate(i).getId();
        NavDestination currentDestination = navController.getCurrentDestination();
        if (currentDestination == null || (parent = currentDestination.getParent()) == null || parent.getId() != id) {
            navController.navigate(id, bundle);
        }
    }
}
