package com.reactnativenavigation.views.bottomtabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.reactnativenavigation.C3967R;
import com.reactnativenavigation.options.LayoutDirection;
import com.reactnativenavigation.utils.CollectionUtils;
import com.reactnativenavigation.utils.ViewUtils;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController$$ExternalSyntheticLambda4;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class BottomTabs extends AHBottomNavigation {
    private boolean itemsCreationEnabled;
    private List<Runnable> onItemCreationEnabled;
    private boolean shouldCreateItems;

    public BottomTabs(Context context) {
        super(context);
        this.itemsCreationEnabled = true;
        this.shouldCreateItems = true;
        this.onItemCreationEnabled = new ArrayList();
        setId(C3967R.id.bottomTabs);
        setDefaultBackgroundColor(0);
    }

    public void disableItemsCreation() {
        this.itemsCreationEnabled = false;
    }

    public void enableItemsCreation() {
        this.itemsCreationEnabled = true;
        if (this.shouldCreateItems) {
            this.shouldCreateItems = false;
            createItems();
            CollectionUtils.forEach((List) this.onItemCreationEnabled, (CollectionUtils.Apply) new ViewController$$ExternalSyntheticLambda4());
            this.onItemCreationEnabled.clear();
        }
    }

    @Override // com.aurelhubert.ahbottomnavigation.AHBottomNavigation, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (hasItemsAndIsMeasured(i, i2, i3, i4)) {
            createItems();
        }
    }

    @Override // com.aurelhubert.ahbottomnavigation.AHBottomNavigation
    protected void createItems() {
        if (this.itemsCreationEnabled) {
            superCreateItems();
        } else {
            this.shouldCreateItems = true;
        }
    }

    public void superCreateItems() {
        super.createItems();
    }

    @Override // com.aurelhubert.ahbottomnavigation.AHBottomNavigation
    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    @Override // com.aurelhubert.ahbottomnavigation.AHBottomNavigation
    public void setCurrentItem(final int i, final boolean z) {
        if (this.itemsCreationEnabled) {
            super.setCurrentItem(i, z);
        } else {
            this.onItemCreationEnabled.add(new Runnable() { // from class: com.reactnativenavigation.views.bottomtabs.BottomTabs$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setCurrentItem$0(i, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCurrentItem$0(int i, boolean z) {
        super.setCurrentItem(i, z);
    }

    @Override // com.aurelhubert.ahbottomnavigation.AHBottomNavigation
    public void setTitleState(AHBottomNavigation.TitleState titleState) {
        if (getTitleState() != titleState) {
            super.setTitleState(titleState);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (getDefaultBackgroundColor() != i) {
            setDefaultBackgroundColor(i);
        }
    }

    @Override // com.aurelhubert.ahbottomnavigation.AHBottomNavigation
    public void restoreBottomNavigation(boolean z) {
        super.restoreBottomNavigation(z);
        if (z) {
            return;
        }
        setVisibility(0);
    }

    @Override // com.aurelhubert.ahbottomnavigation.AHBottomNavigation
    public void hideBottomNavigation(boolean z) {
        super.hideBottomNavigation(z);
        if (z) {
            return;
        }
        setVisibility(8);
    }

    public void setText(int i, String str) {
        AHBottomNavigationItem item = getItem(i);
        if (item.getTitle(getContext()).equals(str)) {
            return;
        }
        item.setTitle(str);
        refresh();
    }

    public void setIcon(int i, Drawable drawable) {
        AHBottomNavigationItem item = getItem(i);
        if (item.getDrawable(getContext()).equals(drawable)) {
            return;
        }
        item.setIcon(drawable);
        refresh();
    }

    public void setSelectedIcon(int i, Drawable drawable) {
        AHBottomNavigationItem item = getItem(i);
        if (item.getDrawable(getContext()).equals(drawable)) {
            return;
        }
        item.setSelectedIcon(drawable);
        refresh();
    }

    public void setLayoutDirection(LayoutDirection layoutDirection) {
        LinearLayout linearLayout = (LinearLayout) ViewUtils.findChildByClass(this, LinearLayout.class);
        if (linearLayout != null) {
            linearLayout.setLayoutDirection(layoutDirection.get());
        }
    }

    private boolean hasItemsAndIsMeasured(int i, int i2, int i3, int i4) {
        return (i == 0 || i2 == 0 || (i == i3 && i2 == i4) || getItemsCount() <= 0) ? false : true;
    }
}
