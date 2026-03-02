package com.newrelic.agent.android.instrumentation.androidx.navigation;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.instrumentation.InstrumentationDelegate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class NavigationController extends InstrumentationDelegate {
    private static Set<FeatureFlag> requiredFeatures = new HashSet<FeatureFlag>() { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController.1
        {
            add(FeatureFlag.Jetpack);
        }
    };

    public static void navigate$default(NavController navController, final String str, final NavOptions navOptions, final Navigator.Extras extras, int i, Object obj) {
        navController.navigate(str, navOptions, extras);
        submit(requiredFeatures, new Runnable() { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                NavigationController.lambda$navigate$default$0(str, navOptions, extras);
            }
        });
    }

    static /* synthetic */ void lambda$navigate$default$0(String str, NavOptions navOptions, Navigator.Extras extras) {
        log.debug("navigate$default(NavController, String, NavOptions, Navigator.Extras, int, Object)");
        analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(str, navOptions, extras) { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController.2
            final /* synthetic */ Navigator.Extras val$extras;
            final /* synthetic */ NavOptions val$options;
            final /* synthetic */ String val$route;

            {
                this.val$route = str;
                this.val$options = navOptions;
                this.val$extras = extras;
                put("span", "navigate");
                put("route", str);
                if (navOptions != null) {
                    put("restoreState", Boolean.valueOf(navOptions.shouldRestoreState()));
                    put("popUpToInclusive", Boolean.valueOf(navOptions.isPopUpToInclusive()));
                    put("popUpToSaveState", Boolean.valueOf(navOptions.shouldPopUpToSaveState()));
                    if (navOptions.getPopUpToRoute() != null) {
                        put("options.popUpToRoute", navOptions.getPopUpToRoute());
                    }
                    if (-1 != navOptions.getEnterAnim()) {
                        put("options.enterAnim", Integer.valueOf(navOptions.getEnterAnim()));
                    }
                    if (-1 != navOptions.getExitAnim()) {
                        put("options.exitAnim", Integer.valueOf(navOptions.getExitAnim()));
                    }
                    if (-1 != navOptions.getPopEnterAnim()) {
                        put("options.popEnterAnim", Integer.valueOf(navOptions.getPopEnterAnim()));
                    }
                    if (-1 != navOptions.getPopExitAnim()) {
                        put("options.popExitAnim", Integer.valueOf(navOptions.getPopExitAnim()));
                    }
                }
                if (extras != null) {
                    put("extras", extras);
                }
            }
        });
    }

    public static void invoke(NavHostController navHostController, final NavBackStackEntry navBackStackEntry, final Composer composer, int i) {
        navHostController.navigate(navBackStackEntry.getDestination().getId(), navBackStackEntry.getArguments());
        executor.submit(new Runnable() { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                NavigationController.lambda$invoke$1(navBackStackEntry, composer);
            }
        });
    }

    static /* synthetic */ void lambda$invoke$1(NavBackStackEntry navBackStackEntry, Composer composer) {
        log.debug("invoke(NavController, NavBackStackEntry, Composer, int)");
        analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(composer) { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController.3
            final /* synthetic */ Composer val$composer;

            {
                this.val$composer = composer;
                put("span", "invoke");
                put("navBackStackEntry.id", Integer.valueOf(this.val$navBackStackEntry.getDestination().getId()));
                if (this.val$navBackStackEntry.getArguments() != null) {
                    put("navBackStackEntry.arguments", this.val$navBackStackEntry.getArguments().toString());
                }
                put("composer.rememberedValue", composer.rememberedValue());
            }
        });
    }

    public static void navigate(NavController navController, final int i, Bundle bundle, final NavOptions navOptions, final Navigator.Extras extras) {
        navController.navigate(i, bundle, navOptions, extras);
        submit(requiredFeatures, new Runnable() { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                NavigationController.lambda$navigate$2(i, navOptions, extras);
            }
        });
    }

    static /* synthetic */ void lambda$navigate$2(int i, NavOptions navOptions, Navigator.Extras extras) {
        log.debug("navigate(NavController, int, Bundle, NavOptions, Navigator.Extras)");
        analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(i, navOptions, extras) { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController.4
            final /* synthetic */ Navigator.Extras val$extras;
            final /* synthetic */ NavOptions val$options;
            final /* synthetic */ int val$resId;

            {
                this.val$resId = i;
                this.val$options = navOptions;
                this.val$extras = extras;
                put("span", "navigate");
                put("resId", Integer.valueOf(i));
                if (navOptions.getPopUpToRoute() != null) {
                    put("options.popUpToRoute", navOptions.getPopUpToRoute());
                }
                if (-1 != navOptions.getEnterAnim()) {
                    put("options.enterAnim", Integer.valueOf(navOptions.getEnterAnim()));
                }
                if (-1 != navOptions.getExitAnim()) {
                    put("options.exitAnim", Integer.valueOf(navOptions.getExitAnim()));
                }
                if (-1 != navOptions.getPopEnterAnim()) {
                    put("options.popEnterAnim", Integer.valueOf(navOptions.getPopEnterAnim()));
                }
                if (-1 != navOptions.getPopExitAnim()) {
                    put("options.popExitAnim", Integer.valueOf(navOptions.getPopExitAnim()));
                }
                put("extras", extras == null ? "null" : extras.toString());
            }
        });
    }

    public static boolean navigateUp(NavController navController) {
        final boolean zNavigateUp = navController.navigateUp();
        submit(requiredFeatures, new Runnable() { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                NavigationController.lambda$navigateUp$3(zNavigateUp);
            }
        });
        return zNavigateUp;
    }

    static /* synthetic */ void lambda$navigateUp$3(boolean z) {
        log.debug("navigateUp(NavController)");
        analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(z) { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController.5
            final /* synthetic */ boolean val$rc;

            {
                this.val$rc = z;
                put("span", "navigateUp");
                put("result", Boolean.valueOf(z));
            }
        });
    }

    public static void popBackStack$default(NavController navController, final String str, final boolean z, final boolean z2, int i, Object obj) {
        navController.popBackStack(str, z, z2);
        submit(requiredFeatures, new Runnable() { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                NavigationController.lambda$popBackStack$default$4(str, z, z2);
            }
        });
    }

    static /* synthetic */ void lambda$popBackStack$default$4(String str, boolean z, boolean z2) {
        log.debug("popBackStack$default(NavController, String, boolean, boolean, int, Object)");
        analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(str, z, z2) { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController.6
            final /* synthetic */ boolean val$inclusive;
            final /* synthetic */ String val$route;
            final /* synthetic */ boolean val$saveState;

            {
                this.val$route = str;
                this.val$inclusive = z;
                this.val$saveState = z2;
                put("span", "popBackStack");
                put("route", str);
                put("inclusive", Boolean.valueOf(z));
                put("saveState", Boolean.valueOf(z2));
            }
        });
    }

    public static boolean popBackStack(NavController navController, final int i, final boolean z, final boolean z2) {
        final boolean zPopBackStack = navController.popBackStack(i, z, z2);
        submit(requiredFeatures, new Runnable() { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                NavigationController.lambda$popBackStack$5(i, z, z2, zPopBackStack);
            }
        });
        return zPopBackStack;
    }

    static /* synthetic */ void lambda$popBackStack$5(int i, boolean z, boolean z2, boolean z3) {
        log.debug("popBackStack(NavController, int, boolean, boolean)");
        analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(i, z, z2, z3) { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController.7
            final /* synthetic */ int val$destinationId;
            final /* synthetic */ boolean val$inclusive;
            final /* synthetic */ boolean val$rc;
            final /* synthetic */ boolean val$saveState;

            {
                this.val$destinationId = i;
                this.val$inclusive = z;
                this.val$saveState = z2;
                this.val$rc = z3;
                put("span", "popBackStack");
                put("destinationId", Integer.valueOf(i));
                put("inclusive", Boolean.valueOf(z));
                put("saveState", Boolean.valueOf(z2));
                put("result", Boolean.valueOf(z3));
            }
        });
    }

    public static boolean popBackStack(NavController navController, final String str, final boolean z, final boolean z2) {
        final boolean zPopBackStack = navController.popBackStack(str, z, z2);
        submit(requiredFeatures, new Runnable() { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NavigationController.lambda$popBackStack$6(str, z, z2, zPopBackStack);
            }
        });
        return zPopBackStack;
    }

    static /* synthetic */ void lambda$popBackStack$6(String str, boolean z, boolean z2, boolean z3) {
        log.debug("popBackStack(NavController, String, boolean, boolean) ");
        analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(str, z, z2, z3) { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController.8
            final /* synthetic */ boolean val$inclusive;
            final /* synthetic */ boolean val$rc;
            final /* synthetic */ String val$route;
            final /* synthetic */ boolean val$saveState;

            {
                this.val$route = str;
                this.val$inclusive = z;
                this.val$saveState = z2;
                this.val$rc = z3;
                put("span", "popBackStack");
                put("route", str);
                put("inclusive", Boolean.valueOf(z));
                put("saveState", Boolean.valueOf(z2));
                put("result", Boolean.valueOf(z3));
            }
        });
    }

    public static boolean popBackStack(NavHostController navHostController) {
        final boolean zPopBackStack = navHostController.popBackStack();
        submit(requiredFeatures, new Runnable() { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                NavigationController.lambda$popBackStack$7(zPopBackStack);
            }
        });
        return zPopBackStack;
    }

    static /* synthetic */ void lambda$popBackStack$7(boolean z) {
        log.debug("boolean popBackStack(NavHostController)");
        analyticsController.recordBreadcrumb("Compose", new HashMap<String, Object>(z) { // from class: com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController.9
            final /* synthetic */ boolean val$rc;

            {
                this.val$rc = z;
                put("span", "popBackStack");
                put("result", Boolean.valueOf(z));
            }
        });
    }
}
