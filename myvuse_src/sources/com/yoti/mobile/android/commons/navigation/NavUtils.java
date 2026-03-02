package com.yoti.mobile.android.commons.navigation;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/navigation/NavUtils;", "", "<init>", "()V", "Companion", "commons-navigation_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class NavUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: NavigationUtils.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JE\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\r\u0010\u0012¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/navigation/NavUtils$Companion;", "", "Landroidx/navigation/NavController;", "navController", "", "resId", "Landroid/os/Bundle;", "args", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navExtras", "", "navigateSafe", "(Landroidx/navigation/NavController;ILandroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavDirections;", "navDirection", "navigatorExtras", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDirections;Landroidx/navigation/Navigator$Extras;)V", "<init>", "()V", "commons-navigation_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void navigateSafe$default(Companion companion, NavController navController, int i, Bundle bundle, NavOptions navOptions, Navigator.Extras extras, int i2, Object obj) {
            companion.navigateSafe(navController, i, (i2 & 4) != 0 ? null : bundle, (i2 & 8) != 0 ? null : navOptions, (i2 & 16) != 0 ? null : extras);
        }

        @JvmStatic
        public final void navigateSafe(NavController navController, int i) {
            navigateSafe$default(this, navController, i, null, null, null, 28, null);
        }

        @JvmStatic
        public final void navigateSafe(NavController navController, int i, Bundle bundle) {
            navigateSafe$default(this, navController, i, bundle, null, null, 24, null);
        }

        @JvmStatic
        public final void navigateSafe(NavController navController, int i, Bundle bundle, NavOptions navOptions) {
            navigateSafe$default(this, navController, i, bundle, navOptions, null, 16, null);
        }

        @JvmStatic
        public final void navigateSafe(NavController navController, int resId, Bundle args, NavOptions navOptions, Navigator.Extras navExtras) {
            Intrinsics.checkNotNullParameter(navController, "navController");
            NavigationUtilsKt.navigateSafe(navController, resId, args, navOptions, navExtras);
        }

        @JvmStatic
        public final void navigateSafe(NavController navController, NavDirections navDirections) {
            navigateSafe$default(this, navController, navDirections, null, 4, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void navigateSafe$default(Companion companion, NavController navController, NavDirections navDirections, Navigator.Extras extras, int i, Object obj) {
            if ((i & 4) != 0) {
                extras = null;
            }
            companion.navigateSafe(navController, navDirections, extras);
        }

        @JvmStatic
        public final void navigateSafe(NavController navController, NavDirections navDirection, Navigator.Extras navigatorExtras) {
            Intrinsics.checkNotNullParameter(navController, "navController");
            Intrinsics.checkNotNullParameter(navDirection, "navDirection");
            NavigationUtilsKt.navigateSafe(navController, navDirection, navigatorExtras);
        }
    }

    @JvmStatic
    public static final void navigateSafe(NavController navController, int i) {
        Companion.navigateSafe$default(INSTANCE, navController, i, null, null, null, 28, null);
    }

    @JvmStatic
    public static final void navigateSafe(NavController navController, int i, Bundle bundle) {
        Companion.navigateSafe$default(INSTANCE, navController, i, bundle, null, null, 24, null);
    }

    @JvmStatic
    public static final void navigateSafe(NavController navController, int i, Bundle bundle, NavOptions navOptions) {
        Companion.navigateSafe$default(INSTANCE, navController, i, bundle, navOptions, null, 16, null);
    }

    @JvmStatic
    public static final void navigateSafe(NavController navController, int i, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        INSTANCE.navigateSafe(navController, i, bundle, navOptions, extras);
    }

    @JvmStatic
    public static final void navigateSafe(NavController navController, NavDirections navDirections) {
        Companion.navigateSafe$default(INSTANCE, navController, navDirections, null, 4, null);
    }

    @JvmStatic
    public static final void navigateSafe(NavController navController, NavDirections navDirections, Navigator.Extras extras) {
        INSTANCE.navigateSafe(navController, navDirections, extras);
    }
}
