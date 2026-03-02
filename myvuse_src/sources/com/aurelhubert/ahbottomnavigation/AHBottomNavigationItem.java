package com.aurelhubert.ahbottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.reactnativenavigation.views.stack.topbar.TopBar;

/* JADX INFO: loaded from: classes.dex */
public class AHBottomNavigationItem {
    private int color;
    private int colorRes;
    private Drawable icon;
    private int iconRes;
    private Drawable selectedIcon;
    private int selectedIconRes;
    private String tag;
    private String title;
    private int titleRes;

    public AHBottomNavigationItem(String str, int i) {
        this.color = TopBar.DEFAULT_SUBTITLE_COLOR;
        this.selectedIconRes = 0;
        this.titleRes = 0;
        this.colorRes = 0;
        this.title = str;
        this.iconRes = i;
    }

    @Deprecated
    public AHBottomNavigationItem(String str, int i, int i2) {
        this.selectedIconRes = 0;
        this.titleRes = 0;
        this.colorRes = 0;
        this.title = str;
        this.iconRes = i;
        this.color = i2;
    }

    public AHBottomNavigationItem(int i, int i2, int i3) {
        this.title = "";
        this.color = TopBar.DEFAULT_SUBTITLE_COLOR;
        this.selectedIconRes = 0;
        this.titleRes = i;
        this.iconRes = i2;
        this.colorRes = i3;
    }

    public AHBottomNavigationItem(int i, int i2) {
        this.title = "";
        this.color = TopBar.DEFAULT_SUBTITLE_COLOR;
        this.selectedIconRes = 0;
        this.colorRes = 0;
        this.titleRes = i;
        this.iconRes = i2;
    }

    public AHBottomNavigationItem(String str, Drawable drawable) {
        this.color = TopBar.DEFAULT_SUBTITLE_COLOR;
        this.iconRes = 0;
        this.selectedIconRes = 0;
        this.titleRes = 0;
        this.colorRes = 0;
        this.title = str;
        this.icon = drawable;
    }

    public AHBottomNavigationItem(String str, Drawable drawable, Drawable drawable2, String str2) {
        this.color = TopBar.DEFAULT_SUBTITLE_COLOR;
        this.iconRes = 0;
        this.selectedIconRes = 0;
        this.titleRes = 0;
        this.colorRes = 0;
        this.title = str;
        this.icon = drawable;
        this.selectedIcon = drawable2;
        this.tag = str2;
    }

    public AHBottomNavigationItem(String str, Drawable drawable, int i) {
        this.iconRes = 0;
        this.selectedIconRes = 0;
        this.titleRes = 0;
        this.colorRes = 0;
        this.title = str;
        this.icon = drawable;
        this.color = i;
    }

    public String getTitle(Context context) {
        int i = this.titleRes;
        if (i != 0) {
            return context.getString(i);
        }
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
        this.titleRes = 0;
    }

    public void setTitle(int i) {
        this.titleRes = i;
        this.title = "";
    }

    public int getColor(Context context) {
        int i = this.colorRes;
        if (i != 0) {
            return ContextCompat.getColor(context, i);
        }
        return this.color;
    }

    public void setColor(int i) {
        this.color = i;
        this.colorRes = 0;
    }

    public void setColorRes(int i) {
        this.colorRes = i;
        this.color = 0;
    }

    public Drawable getDrawable(Context context) {
        Drawable resourceDrawable = this.icon;
        if (resourceDrawable == null) {
            resourceDrawable = getResourceDrawable(context, this.iconRes);
        }
        Drawable resourceDrawable2 = this.selectedIcon;
        if (resourceDrawable2 == null) {
            resourceDrawable2 = getResourceDrawable(context, this.selectedIconRes);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (resourceDrawable2 != null) {
            stateListDrawable.addState(new int[]{android.R.attr.state_selected}, resourceDrawable2);
        }
        stateListDrawable.addState(new int[0], resourceDrawable);
        return stateListDrawable;
    }

    public void setIcon(int i) {
        this.iconRes = i;
        this.icon = null;
    }

    public void setIcon(Drawable drawable) {
        this.icon = drawable;
        this.iconRes = 0;
    }

    public void setSelectedIcon(Drawable drawable) {
        this.selectedIcon = drawable;
    }

    public void setSelectedIcon(int i) {
        this.selectedIconRes = i;
    }

    public String getTag() {
        return this.tag;
    }

    private Drawable getResourceDrawable(Context context, int i) {
        if (i == 0) {
            return null;
        }
        try {
            return AppCompatResources.getDrawable(context, i);
        } catch (Resources.NotFoundException unused) {
            return ContextCompat.getDrawable(context, i);
        }
    }

    public boolean hasIcon() {
        return (this.icon == null && this.iconRes == 0 && this.selectedIcon == null && this.selectedIconRes == 0) ? false : true;
    }
}
