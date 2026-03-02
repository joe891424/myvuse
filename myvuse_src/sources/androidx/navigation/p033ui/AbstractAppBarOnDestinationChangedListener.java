package androidx.navigation.p033ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
abstract class AbstractAppBarOnDestinationChangedListener implements NavController.OnDestinationChangedListener {
    private ValueAnimator mAnimator;
    private DrawerArrowDrawable mArrowDrawable;
    private final Context mContext;
    private final WeakReference<DrawerLayout> mDrawerLayoutWeakReference;
    private final Set<Integer> mTopLevelDestinations;

    protected abstract void setNavigationIcon(Drawable drawable, int i);

    protected abstract void setTitle(CharSequence charSequence);

    AbstractAppBarOnDestinationChangedListener(Context context, AppBarConfiguration appBarConfiguration) {
        this.mContext = context;
        this.mTopLevelDestinations = appBarConfiguration.getTopLevelDestinations();
        DrawerLayout drawerLayout = appBarConfiguration.getDrawerLayout();
        if (drawerLayout != null) {
            this.mDrawerLayoutWeakReference = new WeakReference<>(drawerLayout);
        } else {
            this.mDrawerLayoutWeakReference = null;
        }
    }

    @Override // androidx.navigation.NavController.OnDestinationChangedListener
    public void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
        if (navDestination instanceof FloatingWindow) {
            return;
        }
        WeakReference<DrawerLayout> weakReference = this.mDrawerLayoutWeakReference;
        DrawerLayout drawerLayout = weakReference != null ? weakReference.get() : null;
        if (this.mDrawerLayoutWeakReference != null && drawerLayout == null) {
            navController.removeOnDestinationChangedListener(this);
            return;
        }
        CharSequence label = navDestination.getLabel();
        if (!TextUtils.isEmpty(label)) {
            StringBuffer stringBuffer = new StringBuffer();
            Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(label);
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                if (bundle != null && bundle.containsKey(strGroup)) {
                    matcher.appendReplacement(stringBuffer, "");
                    stringBuffer.append(bundle.get(strGroup).toString());
                } else {
                    throw new IllegalArgumentException("Could not find " + strGroup + " in " + bundle + " to fill label " + ((Object) label));
                }
            }
            matcher.appendTail(stringBuffer);
            setTitle(stringBuffer);
        }
        boolean zMatchDestinations = NavigationUI.matchDestinations(navDestination, this.mTopLevelDestinations);
        if (drawerLayout == null && zMatchDestinations) {
            setNavigationIcon(null, 0);
        } else {
            setActionBarUpIndicator(drawerLayout != null && zMatchDestinations);
        }
    }

    private void setActionBarUpIndicator(boolean z) {
        boolean z2;
        if (this.mArrowDrawable == null) {
            this.mArrowDrawable = new DrawerArrowDrawable(this.mContext);
            z2 = false;
        } else {
            z2 = true;
        }
        setNavigationIcon(this.mArrowDrawable, z ? C1008R.string.nav_app_bar_open_drawer_description : C1008R.string.nav_app_bar_navigate_up_description);
        float f = z ? 0.0f : 1.0f;
        if (z2) {
            float progress = this.mArrowDrawable.getProgress();
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mArrowDrawable, "progress", progress, f);
            this.mAnimator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.start();
            return;
        }
        this.mArrowDrawable.setProgress(f);
    }
}
