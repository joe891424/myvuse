package com.aurelhubert.ahbottomnavigation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.aurelhubert.ahbottomnavigation.AHHelper;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.aurelhubert.ahbottomnavigation.notification.AHNotificationHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class AHBottomNavigation extends FrameLayout {
    public static final int CURRENT_ITEM_NONE = -1;
    private static final String EXCEPTION_INDEX_OUT_OF_BOUNDS = "The position (%d) is out of bounds of the items (%d elements)";
    private static final int MAX_ITEMS = 5;
    private static final int MIN_ITEMS = 3;
    private static String TAG = "AHBottomNavigation";
    public static final int UPDATE_ALL_NOTIFICATIONS = -1;
    private int activeMarginTop;
    private int activePaddingTop;
    private boolean animateTabSelection;
    private View backgroundColorView;
    private boolean behaviorTranslationEnabled;
    private AHBottomNavigationBehavior<AHBottomNavigation> bottomNavigationBehavior;
    private int bottomNavigationHeight;
    private Animator circleRevealAnim;
    private boolean colored;
    private ArrayList<Integer> coloredTitleColorActive;
    private ArrayList<Integer> coloredTitleColorInactive;
    private Context context;
    private int currentColor;
    private int currentItem;
    private int defaultBackgroundColor;
    private int defaultBackgroundResource;
    private int defaultIconHeight;
    private int defaultIconWidth;
    private int defaultNotificationElevation;
    private boolean forceTint;
    private boolean hideBottomNavigationWithAnimation;
    private ArrayList<Integer> iconActiveColor;
    private ArrayList<Integer> iconDisableColor;
    private ArrayList<Integer> iconHeight;
    private ArrayList<Integer> iconInactiveColor;
    private ArrayList<Integer> iconWidth;
    private boolean isBehaviorTranslationSet;
    private ArrayList<AHBottomNavigationItem> items;
    private Boolean[] itemsEnabledStates;
    private LinearLayout linearLayoutContainer;
    private int navigationBarHeight;
    private OnNavigationPositionListener navigationPositionListener;
    private boolean needHideBottomNavigation;
    private float notSelectedItemWidth;
    private int notificationActiveMarginLeft;
    private int notificationActiveMarginTop;
    private long notificationAnimationDuration;
    private int notificationBackgroundColor;
    private Drawable notificationBackgroundDrawable;
    private int notificationInactiveMarginLeft;
    private int notificationInactiveMarginTop;
    private int notificationTextColor;
    private Typeface notificationTypeface;
    private List<AHNotification> notifications;
    private boolean preferLargeIcons;
    private Resources resources;
    private boolean selectedBackgroundVisible;
    private float selectedItemWidth;
    private boolean soundEffectsEnabled;
    private OnTabSelectedListener tabSelectedListener;
    private ArrayList<Integer> titleActiveColor;
    private ArrayList<Float> titleActiveTextSize;
    private ArrayList<Integer> titleDisableColor;
    private ArrayList<Integer> titleInactiveColor;
    private ArrayList<Float> titleInactiveTextSize;
    private TitleState titleState;
    private ArrayList<Typeface> titleTypeface;
    private boolean translucentNavigationEnabled;
    private ArrayList<View> views;
    private float widthDifference;

    public interface OnNavigationPositionListener {
        void onPositionChange(int i);
    }

    public interface OnTabSelectedListener {
        boolean onTabSelected(int i, boolean z);
    }

    public enum TitleState {
        SHOW_WHEN_ACTIVE,
        SHOW_WHEN_ACTIVE_FORCE,
        ALWAYS_SHOW,
        ALWAYS_HIDE
    }

    public AHBottomNavigation(Context context) {
        super(context);
        this.items = new ArrayList<>();
        this.views = new ArrayList<>();
        this.colored = false;
        this.selectedBackgroundVisible = false;
        this.notifications = AHNotification.generateEmptyList(5);
        this.itemsEnabledStates = new Boolean[]{true, true, true, true, true};
        this.isBehaviorTranslationSet = false;
        this.currentItem = 0;
        this.currentColor = 0;
        this.behaviorTranslationEnabled = true;
        this.needHideBottomNavigation = false;
        this.hideBottomNavigationWithAnimation = false;
        this.soundEffectsEnabled = true;
        this.titleTypeface = new ArrayList<>();
        this.defaultBackgroundColor = -1;
        this.defaultBackgroundResource = 0;
        this.iconActiveColor = new ArrayList<>(5);
        this.iconInactiveColor = new ArrayList<>(5);
        this.iconHeight = new ArrayList<>(5);
        this.iconWidth = new ArrayList<>(5);
        this.titleActiveColor = new ArrayList<>(5);
        this.titleInactiveColor = new ArrayList<>(5);
        this.iconDisableColor = new ArrayList<>(5);
        this.titleDisableColor = new ArrayList<>(5);
        this.coloredTitleColorActive = new ArrayList<>(5);
        this.coloredTitleColorInactive = new ArrayList<>(5);
        this.titleActiveTextSize = new ArrayList<>(5);
        this.titleInactiveTextSize = new ArrayList<>(5);
        this.navigationBarHeight = 0;
        this.forceTint = false;
        this.preferLargeIcons = false;
        this.titleState = TitleState.SHOW_WHEN_ACTIVE;
        this.animateTabSelection = true;
        init(context, null);
    }

    public AHBottomNavigation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.items = new ArrayList<>();
        this.views = new ArrayList<>();
        this.colored = false;
        this.selectedBackgroundVisible = false;
        this.notifications = AHNotification.generateEmptyList(5);
        this.itemsEnabledStates = new Boolean[]{true, true, true, true, true};
        this.isBehaviorTranslationSet = false;
        this.currentItem = 0;
        this.currentColor = 0;
        this.behaviorTranslationEnabled = true;
        this.needHideBottomNavigation = false;
        this.hideBottomNavigationWithAnimation = false;
        this.soundEffectsEnabled = true;
        this.titleTypeface = new ArrayList<>();
        this.defaultBackgroundColor = -1;
        this.defaultBackgroundResource = 0;
        this.iconActiveColor = new ArrayList<>(5);
        this.iconInactiveColor = new ArrayList<>(5);
        this.iconHeight = new ArrayList<>(5);
        this.iconWidth = new ArrayList<>(5);
        this.titleActiveColor = new ArrayList<>(5);
        this.titleInactiveColor = new ArrayList<>(5);
        this.iconDisableColor = new ArrayList<>(5);
        this.titleDisableColor = new ArrayList<>(5);
        this.coloredTitleColorActive = new ArrayList<>(5);
        this.coloredTitleColorInactive = new ArrayList<>(5);
        this.titleActiveTextSize = new ArrayList<>(5);
        this.titleInactiveTextSize = new ArrayList<>(5);
        this.navigationBarHeight = 0;
        this.forceTint = false;
        this.preferLargeIcons = false;
        this.titleState = TitleState.SHOW_WHEN_ACTIVE;
        this.animateTabSelection = true;
        init(context, attributeSet);
    }

    public AHBottomNavigation(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.items = new ArrayList<>();
        this.views = new ArrayList<>();
        this.colored = false;
        this.selectedBackgroundVisible = false;
        this.notifications = AHNotification.generateEmptyList(5);
        this.itemsEnabledStates = new Boolean[]{true, true, true, true, true};
        this.isBehaviorTranslationSet = false;
        this.currentItem = 0;
        this.currentColor = 0;
        this.behaviorTranslationEnabled = true;
        this.needHideBottomNavigation = false;
        this.hideBottomNavigationWithAnimation = false;
        this.soundEffectsEnabled = true;
        this.titleTypeface = new ArrayList<>();
        this.defaultBackgroundColor = -1;
        this.defaultBackgroundResource = 0;
        this.iconActiveColor = new ArrayList<>(5);
        this.iconInactiveColor = new ArrayList<>(5);
        this.iconHeight = new ArrayList<>(5);
        this.iconWidth = new ArrayList<>(5);
        this.titleActiveColor = new ArrayList<>(5);
        this.titleInactiveColor = new ArrayList<>(5);
        this.iconDisableColor = new ArrayList<>(5);
        this.titleDisableColor = new ArrayList<>(5);
        this.coloredTitleColorActive = new ArrayList<>(5);
        this.coloredTitleColorInactive = new ArrayList<>(5);
        this.titleActiveTextSize = new ArrayList<>(5);
        this.titleInactiveTextSize = new ArrayList<>(5);
        this.navigationBarHeight = 0;
        this.forceTint = false;
        this.preferLargeIcons = false;
        this.titleState = TitleState.SHOW_WHEN_ACTIVE;
        this.animateTabSelection = true;
        init(context, attributeSet);
    }

    @Override // android.view.View
    public void setSoundEffectsEnabled(boolean z) {
        super.setSoundEffectsEnabled(z);
        this.soundEffectsEnabled = z;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        createItems();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.isBehaviorTranslationSet) {
            return;
        }
        setBehaviorTranslationEnabled(this.behaviorTranslationEnabled);
        this.isBehaviorTranslationSet = true;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putInt("current_item", this.currentItem);
        bundle.putParcelableArrayList("notifications", new ArrayList<>(this.notifications));
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.currentItem = bundle.getInt("current_item");
            this.notifications = bundle.getParcelableArrayList("notifications");
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void init(final Context context, AttributeSet attributeSet) {
        this.context = context;
        Resources resources = context.getResources();
        this.resources = resources;
        this.defaultNotificationElevation = resources.getDimensionPixelSize(C1405R.dimen.bottom_navigation_notification_elevation);
        this.activePaddingTop = (int) this.resources.getDimension(C1405R.dimen.bottom_navigation_margin_top_active);
        this.activeMarginTop = (int) this.resources.getDimension(C1405R.dimen.bottom_navigation_small_margin_top_active);
        this.widthDifference = this.resources.getDimension(C1405R.dimen.bottom_navigation_small_selected_width_difference);
        this.defaultIconHeight = this.resources.getDimensionPixelSize(C1405R.dimen.bottom_navigation_icon);
        this.defaultIconWidth = this.resources.getDimensionPixelSize(C1405R.dimen.bottom_navigation_icon);
        AHHelper.fill(this.iconActiveColor, 5, null);
        AHHelper.fill(this.iconInactiveColor, 5, null);
        AHHelper.fill(this.iconDisableColor, 5, null);
        AHHelper.fill(this.titleActiveColor, 5, null);
        AHHelper.fill(this.titleInactiveColor, 5, null);
        AHHelper.fill(this.titleDisableColor, 5, null);
        AHHelper.fill(this.iconWidth, 5, null);
        AHHelper.fill(this.iconHeight, 5, null);
        AHHelper.fill(this.titleTypeface, 5, null);
        AHHelper.fill(this.titleActiveTextSize, 5, null);
        AHHelper.fill(this.titleInactiveTextSize, 5, null);
        AHHelper.fill(this.coloredTitleColorActive, 5, Integer.valueOf(ContextCompat.getColor(context, C1405R.color.colorBottomNavigationActiveColored)));
        AHHelper.fill(this.coloredTitleColorInactive, 5, Integer.valueOf(ContextCompat.getColor(context, C1405R.color.colorBottomNavigationInactiveColored)));
        if (attributeSet != null) {
            final TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1405R.styleable.AHBottomNavigationBehavior_Params, 0, 0);
            try {
                this.selectedBackgroundVisible = typedArrayObtainStyledAttributes.getBoolean(C1405R.styleable.AHBottomNavigationBehavior_Params_selectedBackgroundVisible, false);
                this.translucentNavigationEnabled = typedArrayObtainStyledAttributes.getBoolean(C1405R.styleable.AHBottomNavigationBehavior_Params_translucentNavigationEnabled, false);
                AHHelper.map(this.titleActiveColor, new AHHelper.Mapper() { // from class: com.aurelhubert.ahbottomnavigation.AHBottomNavigation$$ExternalSyntheticLambda2
                    @Override // com.aurelhubert.ahbottomnavigation.AHHelper.Mapper
                    public final Object map(Object obj) {
                        return Integer.valueOf(typedArrayObtainStyledAttributes.getColor(C1405R.styleable.AHBottomNavigationBehavior_Params_accentColor, ContextCompat.getColor(context, C1405R.color.colorBottomNavigationAccent)));
                    }
                });
                AHHelper.map(this.titleInactiveColor, new AHHelper.Mapper() { // from class: com.aurelhubert.ahbottomnavigation.AHBottomNavigation$$ExternalSyntheticLambda3
                    @Override // com.aurelhubert.ahbottomnavigation.AHHelper.Mapper
                    public final Object map(Object obj) {
                        return Integer.valueOf(typedArrayObtainStyledAttributes.getColor(C1405R.styleable.AHBottomNavigationBehavior_Params_inactiveColor, ContextCompat.getColor(context, C1405R.color.colorBottomNavigationInactive)));
                    }
                });
                AHHelper.map(this.iconDisableColor, new AHHelper.Mapper() { // from class: com.aurelhubert.ahbottomnavigation.AHBottomNavigation$$ExternalSyntheticLambda4
                    @Override // com.aurelhubert.ahbottomnavigation.AHHelper.Mapper
                    public final Object map(Object obj) {
                        return Integer.valueOf(typedArrayObtainStyledAttributes.getColor(C1405R.styleable.AHBottomNavigationBehavior_Params_disableColor, ContextCompat.getColor(context, C1405R.color.colorBottomNavigationDisable)));
                    }
                });
                AHHelper.map(this.coloredTitleColorActive, new AHHelper.Mapper() { // from class: com.aurelhubert.ahbottomnavigation.AHBottomNavigation$$ExternalSyntheticLambda5
                    @Override // com.aurelhubert.ahbottomnavigation.AHHelper.Mapper
                    public final Object map(Object obj) {
                        return Integer.valueOf(typedArrayObtainStyledAttributes.getColor(C1405R.styleable.AHBottomNavigationBehavior_Params_coloredActive, ContextCompat.getColor(context, C1405R.color.colorBottomNavigationActiveColored)));
                    }
                });
                AHHelper.map(this.coloredTitleColorInactive, new AHHelper.Mapper() { // from class: com.aurelhubert.ahbottomnavigation.AHBottomNavigation$$ExternalSyntheticLambda6
                    @Override // com.aurelhubert.ahbottomnavigation.AHHelper.Mapper
                    public final Object map(Object obj) {
                        return Integer.valueOf(typedArrayObtainStyledAttributes.getColor(C1405R.styleable.AHBottomNavigationBehavior_Params_coloredInactive, ContextCompat.getColor(context, C1405R.color.colorBottomNavigationInactiveColored)));
                    }
                });
                this.colored = typedArrayObtainStyledAttributes.getBoolean(C1405R.styleable.AHBottomNavigationBehavior_Params_colored, false);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.notificationTextColor = ContextCompat.getColor(context, android.R.color.white);
        this.bottomNavigationHeight = (int) this.resources.getDimension(C1405R.dimen.bottom_navigation_height);
        this.notificationActiveMarginLeft = (int) this.resources.getDimension(C1405R.dimen.bottom_navigation_notification_margin_left_active);
        this.notificationInactiveMarginLeft = (int) this.resources.getDimension(C1405R.dimen.bottom_navigation_notification_margin_left);
        this.notificationActiveMarginTop = (int) this.resources.getDimension(C1405R.dimen.bottom_navigation_notification_margin_top_active);
        this.notificationInactiveMarginTop = (int) this.resources.getDimension(C1405R.dimen.bottom_navigation_notification_margin_top);
        this.notificationAnimationDuration = 150L;
        ViewCompat.setElevation(this, this.resources.getDimension(C1405R.dimen.bottom_navigation_elevation));
        setClipToPadding(false);
        setLayoutParams(new ViewGroup.LayoutParams(-1, this.bottomNavigationHeight));
    }

    protected void createItems() {
        if (this.items.size() < 3) {
            LogInstrumentation.m2734w(TAG, "The items list should have at least 3 items");
        } else if (this.items.size() > 5) {
            LogInstrumentation.m2734w(TAG, "The items list should not have more than 5 items");
        }
        int dimension = (int) this.resources.getDimension(C1405R.dimen.bottom_navigation_height);
        removeAllViews();
        this.views.clear();
        this.backgroundColorView = new View(this.context);
        addView(this.backgroundColorView, new FrameLayout.LayoutParams(-1, calculateHeight(dimension)));
        this.bottomNavigationHeight = dimension;
        LinearLayout linearLayout = new LinearLayout(this.context);
        this.linearLayoutContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.linearLayoutContainer.setGravity(17);
        addView(this.linearLayoutContainer, new FrameLayout.LayoutParams(-1, dimension));
        if (isClassic()) {
            createClassicItems(this.linearLayoutContainer);
        } else {
            createSmallItems(this.linearLayoutContainer);
        }
        post(new Runnable() { // from class: com.aurelhubert.ahbottomnavigation.AHBottomNavigation$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.requestLayout();
            }
        });
    }

    private boolean isClassic() {
        if (this.preferLargeIcons && this.items.size() == 3) {
            return true;
        }
        return (this.titleState == TitleState.ALWAYS_HIDE || this.titleState == TitleState.SHOW_WHEN_ACTIVE_FORCE || (this.items.size() != 3 && this.titleState != TitleState.ALWAYS_SHOW)) ? false : true;
    }

    private int calculateHeight(int i) {
        if (!this.translucentNavigationEnabled) {
            return i;
        }
        int identifier = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.navigationBarHeight = this.resources.getDimensionPixelSize(identifier);
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{android.R.attr.fitsSystemWindows, android.R.attr.windowTranslucentNavigation});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(1, true);
        if (hasImmersive() && z) {
            i += this.navigationBarHeight;
        }
        typedArrayObtainStyledAttributes.recycle();
        return i;
    }

    public boolean hasImmersive() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i2 > displayMetrics2.widthPixels || i > displayMetrics2.heightPixels;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.LayoutInflater] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v9 */
    private void createClassicItems(LinearLayout linearLayout) {
        boolean z;
        ?? r1 = (LayoutInflater) this.context.getSystemService("layout_inflater");
        float dimension = this.resources.getDimension(C1405R.dimen.bottom_navigation_height);
        float dimension2 = this.resources.getDimension(C1405R.dimen.bottom_navigation_min_width);
        float dimension3 = this.resources.getDimension(C1405R.dimen.bottom_navigation_max_width);
        int i = 3;
        if (this.titleState == TitleState.ALWAYS_SHOW && this.items.size() > 3) {
            dimension2 = this.resources.getDimension(C1405R.dimen.bottom_navigation_small_inactive_min_width);
            dimension3 = this.resources.getDimension(C1405R.dimen.bottom_navigation_small_inactive_max_width);
        }
        int width = getWidth();
        if (width == 0 || this.items.size() == 0) {
            return;
        }
        float size = width / this.items.size();
        if (size >= dimension2) {
            dimension2 = size > dimension3 ? dimension3 : size;
        }
        ?? r4 = 0;
        final int i2 = 0;
        while (i2 < this.items.size()) {
            ?? r6 = this.currentItem == i2 ? 1 : r4;
            AHBottomNavigationItem aHBottomNavigationItem = this.items.get(i2);
            View viewInflate = r1.inflate(C1405R.layout.bottom_navigation_item, this, r4);
            FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(C1405R.id.bottom_navigation_container);
            ImageView imageView = (ImageView) viewInflate.findViewById(C1405R.id.bottom_navigation_item_icon);
            AHTextView aHTextView = (AHTextView) viewInflate.findViewById(C1405R.id.bottom_navigation_item_title);
            AHTextView aHTextView2 = (AHTextView) viewInflate.findViewById(C1405R.id.bottom_navigation_notification);
            imageView.getLayoutParams().width = getIconWidth(i2);
            imageView.getLayoutParams().height = getIconHeight(i2);
            imageView.setImageDrawable(aHBottomNavigationItem.getDrawable(this.context));
            if (this.titleState == TitleState.ALWAYS_HIDE || aHBottomNavigationItem.getTitle(this.context).isEmpty()) {
                aHTextView.setVisibility(8);
                if (!this.animateTabSelection) {
                    AHHelper.updateMargin(imageView, r4, r4, r4, r4);
                }
                ((FrameLayout.LayoutParams) imageView.getLayoutParams()).gravity = 17;
                ((ViewGroup.MarginLayoutParams) aHTextView2.getLayoutParams()).topMargin = ((this.bottomNavigationHeight - getIconHeight(i2)) / 2) - dpToPx(4);
            } else {
                aHTextView.setText(aHBottomNavigationItem.getTitle(this.context));
            }
            aHTextView.setTypeface(this.titleTypeface.get(i2));
            if (this.titleState == TitleState.ALWAYS_SHOW && this.items.size() > i) {
                frameLayout.setPadding(0, frameLayout.getPaddingTop(), 0, frameLayout.getPaddingBottom());
            }
            if (r6 != 0) {
                if (this.selectedBackgroundVisible) {
                    z = true;
                    viewInflate.setSelected(true);
                } else {
                    z = true;
                }
                imageView.setSelected(z);
                if ((viewInflate.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.animateTabSelection) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, this.activePaddingTop, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) aHTextView2.getLayoutParams();
                    marginLayoutParams2.setMargins(this.notificationActiveMarginLeft, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    viewInflate.requestLayout();
                }
            } else {
                imageView.setSelected(false);
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) aHTextView2.getLayoutParams();
                marginLayoutParams3.setMargins(this.notificationInactiveMarginLeft, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
            }
            if (!this.colored) {
                int i3 = this.defaultBackgroundResource;
                if (i3 != 0) {
                    setBackgroundResource(i3);
                } else {
                    setBackgroundColor(this.defaultBackgroundColor);
                }
            } else if (r6 != 0) {
                setBackgroundColor(aHBottomNavigationItem.getColor(this.context));
                this.currentColor = aHBottomNavigationItem.getColor(this.context);
            }
            aHTextView.setTextSize(0, r6 != 0 ? getActiveTextSize(i2) : getInactiveTextSize(i2));
            if (this.itemsEnabledStates[i2].booleanValue()) {
                viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.aurelhubert.ahbottomnavigation.AHBottomNavigation$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.m1244x147d2bdf(i2, view);
                    }
                });
                imageView.setImageDrawable(AHHelper.getTintDrawable(this.items.get(i2).getDrawable(this.context), (r6 != 0 ? this.iconActiveColor : this.iconInactiveColor).get(i2), this.forceTint));
                aHTextView.setTextColor((r6 != 0 ? this.titleActiveColor : this.titleInactiveColor).get(i2));
                viewInflate.setSoundEffectsEnabled(this.soundEffectsEnabled);
            } else {
                imageView.setImageDrawable(AHHelper.getTintDrawable(this.items.get(i2).getDrawable(this.context), this.iconDisableColor.get(i2), this.forceTint));
                aHTextView.setTextColor(this.titleDisableColor.get(i2));
            }
            if (aHBottomNavigationItem.getTag() != null) {
                viewInflate.setTag(aHBottomNavigationItem.getTag());
            }
            linearLayout.addView(viewInflate, new FrameLayout.LayoutParams((int) dimension2, (int) dimension));
            this.views.add(viewInflate);
            setTabAccessibilityLabel(i2, this.currentItem);
            i2++;
            r4 = 0;
            i = 3;
        }
        updateNotifications(true, -1);
    }

    /* JADX INFO: renamed from: lambda$createClassicItems$5$com-aurelhubert-ahbottomnavigation-AHBottomNavigation */
    /* synthetic */ void m1244x147d2bdf(int i, View view) {
        updateItems(i, true);
    }

    private int getIconHeight(int i) {
        return this.iconHeight.get(i) == null ? this.defaultIconHeight : dpToPx(this.iconHeight.get(i).intValue());
    }

    private int getIconWidth(int i) {
        return this.iconWidth.get(i) == null ? this.defaultIconWidth : dpToPx(this.iconWidth.get(i).intValue());
    }

    private float getInactiveTextSize(int i) {
        if (this.titleInactiveTextSize.get(i) != null) {
            return this.titleInactiveTextSize.get(i).floatValue();
        }
        if (this.titleState == TitleState.ALWAYS_SHOW && this.items.size() > 3) {
            return this.resources.getDimension(C1405R.dimen.bottom_navigation_text_size_forced_inactive);
        }
        return this.resources.getDimension(C1405R.dimen.bottom_navigation_text_size_inactive);
    }

    private float getActiveTextSize(int i) {
        if (this.titleActiveTextSize.get(i) != null) {
            return this.titleActiveTextSize.get(i).floatValue();
        }
        if (this.titleState == TitleState.ALWAYS_SHOW && this.items.size() > 3) {
            return this.resources.getDimension(C1405R.dimen.bottom_navigation_text_size_forced_active);
        }
        return this.resources.getDimension(C1405R.dimen.bottom_navigation_text_size_active);
    }

    private void createSmallItems(LinearLayout linearLayout) {
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        float dimension = this.resources.getDimension(C1405R.dimen.bottom_navigation_height);
        float dimension2 = this.resources.getDimension(C1405R.dimen.bottom_navigation_small_inactive_min_width);
        float dimension3 = this.resources.getDimension(C1405R.dimen.bottom_navigation_small_inactive_max_width);
        int width = getWidth();
        if (width == 0 || this.items.size() == 0) {
            return;
        }
        float size = width / this.items.size();
        if (size >= dimension2) {
            dimension2 = size > dimension3 ? dimension3 : size;
        }
        float size2 = this.items.size();
        float f = this.widthDifference;
        this.selectedItemWidth = (size2 * f) + dimension2;
        float f2 = dimension2 - f;
        this.notSelectedItemWidth = f2;
        final int i = 0;
        while (i < this.items.size()) {
            boolean z = this.currentItem == i;
            AHBottomNavigationItem aHBottomNavigationItem = this.items.get(i);
            View viewInflate = layoutInflater.inflate(C1405R.layout.bottom_navigation_small_item, (ViewGroup) this, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(C1405R.id.bottom_navigation_small_item_icon);
            AHTextView aHTextView = (AHTextView) viewInflate.findViewById(C1405R.id.bottom_navigation_small_item_title);
            AHTextView aHTextView2 = (AHTextView) viewInflate.findViewById(C1405R.id.bottom_navigation_notification);
            imageView.setImageDrawable(aHBottomNavigationItem.getDrawable(this.context));
            imageView.getLayoutParams().width = getIconWidth(i);
            imageView.getLayoutParams().height = getIconHeight(i);
            if (this.titleState != TitleState.ALWAYS_HIDE) {
                aHTextView.setText(aHBottomNavigationItem.getTitle(this.context));
            }
            if ((this.titleState == TitleState.ALWAYS_HIDE || aHBottomNavigationItem.getTitle(this.context).isEmpty()) && this.titleState != TitleState.SHOW_WHEN_ACTIVE && this.titleState != TitleState.SHOW_WHEN_ACTIVE_FORCE) {
                aHTextView.setVisibility(8);
                ((FrameLayout.LayoutParams) imageView.getLayoutParams()).gravity = 17;
                AHHelper.updateMargin(imageView, 0, 0, 0, 0);
            }
            float activeTextSize = getActiveTextSize(i);
            if (activeTextSize != 0.0f) {
                aHTextView.setTextSize(0, activeTextSize);
            }
            aHTextView.setTypeface(this.titleTypeface.get(i));
            if (z) {
                if (this.selectedBackgroundVisible) {
                    viewInflate.setSelected(true);
                }
                imageView.setSelected(true);
                if (this.titleState != TitleState.ALWAYS_HIDE && this.animateTabSelection && (viewInflate.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, this.activeMarginTop, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) aHTextView2.getLayoutParams();
                    marginLayoutParams2.setMargins(this.notificationActiveMarginLeft, this.notificationActiveMarginTop, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    viewInflate.requestLayout();
                }
            } else {
                imageView.setSelected(false);
                if (this.animateTabSelection) {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) aHTextView2.getLayoutParams();
                    marginLayoutParams3.setMargins(this.notificationInactiveMarginLeft, this.notificationInactiveMarginTop, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                }
            }
            if (this.colored) {
                if (i == this.currentItem) {
                    setBackgroundColor(aHBottomNavigationItem.getColor(this.context));
                    this.currentColor = aHBottomNavigationItem.getColor(this.context);
                }
            } else {
                int i2 = this.defaultBackgroundResource;
                if (i2 != 0) {
                    setBackgroundResource(i2);
                } else {
                    setBackgroundColor(this.defaultBackgroundColor);
                }
            }
            if (this.itemsEnabledStates[i].booleanValue()) {
                imageView.setImageDrawable(AHHelper.getTintDrawable(this.items.get(i).getDrawable(this.context), (this.currentItem == i ? this.iconActiveColor : this.iconInactiveColor).get(i), this.forceTint));
                aHTextView.setTextColor((this.currentItem == i ? this.titleActiveColor : this.titleInactiveColor).get(i));
                aHTextView.setAlpha(this.currentItem == i ? 1.0f : 0.0f);
                viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.aurelhubert.ahbottomnavigation.AHBottomNavigation$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.m1245x1e3fdb0b(i, view);
                    }
                });
                viewInflate.setSoundEffectsEnabled(this.soundEffectsEnabled);
            } else {
                imageView.setImageDrawable(AHHelper.getTintDrawable(this.items.get(i).getDrawable(this.context), this.iconDisableColor.get(i), this.forceTint));
                aHTextView.setTextColor(this.titleDisableColor.get(i));
                aHTextView.setAlpha(0.0f);
            }
            int i3 = i == this.currentItem ? (int) this.selectedItemWidth : (int) f2;
            if (this.titleState == TitleState.ALWAYS_HIDE) {
                i3 = (int) (((double) f2) * 1.16d);
            }
            if (aHBottomNavigationItem.getTag() != null) {
                viewInflate.setTag(aHBottomNavigationItem.getTag());
            }
            linearLayout.addView(viewInflate, new FrameLayout.LayoutParams(i3, (int) dimension));
            this.views.add(viewInflate);
            setTabAccessibilityLabel(i, this.currentItem);
            i++;
        }
        updateNotifications(true, -1);
    }

    /* JADX INFO: renamed from: lambda$createSmallItems$6$com-aurelhubert-ahbottomnavigation-AHBottomNavigation */
    /* synthetic */ void m1245x1e3fdb0b(int i, View view) {
        updateSmallItems(i, true);
    }

    private void setTabAccessibilityLabel(int i, int i2) {
        AHBottomNavigationItem aHBottomNavigationItem = this.items.get(i);
        String str = i2 == i ? "selected, " : "";
        if (aHBottomNavigationItem.getTitle(this.context) != null) {
            str = str + aHBottomNavigationItem.getTitle(this.context) + ", ";
        }
        if (AHHelper.isInteger(this.notifications.get(i).getReadableText())) {
            int i3 = Integer.parseInt(this.notifications.get(i).getReadableText());
            str = str + i3 + " new item" + (i3 != 1 ? "s" : "") + ", ";
        }
        this.views.get(i).setContentDescription(str + "tab, " + (i + 1) + " out of " + getItemsCount());
    }

    private void updateItems(final int i, boolean z) {
        for (int i2 = 0; i2 < this.views.size(); i2++) {
            setTabAccessibilityLabel(i2, i);
        }
        if (this.currentItem == i) {
            OnTabSelectedListener onTabSelectedListener = this.tabSelectedListener;
            if (onTabSelectedListener == null || !z) {
                return;
            }
            onTabSelectedListener.onTabSelected(i, true);
            return;
        }
        OnTabSelectedListener onTabSelectedListener2 = this.tabSelectedListener;
        if (onTabSelectedListener2 == null || !z || onTabSelectedListener2.onTabSelected(i, false)) {
            int dimension = (int) this.resources.getDimension(C1405R.dimen.bottom_navigation_margin_top_active);
            int dimension2 = (int) this.resources.getDimension(C1405R.dimen.bottom_navigation_margin_top_inactive);
            int i3 = 0;
            while (i3 < this.views.size()) {
                View view = this.views.get(i3);
                if (this.selectedBackgroundVisible) {
                    view.setSelected(i3 == i);
                }
                if (i3 == i) {
                    AHTextView aHTextView = (AHTextView) view.findViewById(C1405R.id.bottom_navigation_item_title);
                    ImageView imageView = (ImageView) view.findViewById(C1405R.id.bottom_navigation_item_icon);
                    AHTextView aHTextView2 = (AHTextView) view.findViewById(C1405R.id.bottom_navigation_notification);
                    imageView.setSelected(true);
                    if (this.animateTabSelection) {
                        AHHelper.updateTopMargin(imageView, dimension2, dimension);
                        AHHelper.updateLeftMargin(aHTextView2, this.notificationInactiveMarginLeft, this.notificationActiveMarginLeft);
                        AHHelper.updateTextSize(aHTextView, getInactiveTextSize(i3), getActiveTextSize(i3));
                    }
                    AHHelper.updateTextColor(aHTextView, this.titleInactiveColor.get(i3), this.titleActiveColor.get(i3));
                    AHHelper.updateDrawableColor(this.items.get(i).getDrawable(this.context), imageView, this.iconInactiveColor.get(i3), this.iconActiveColor.get(i3), this.forceTint);
                    boolean z2 = this.colored;
                    if (z2) {
                        int iMax = Math.max(getWidth(), getHeight());
                        int x = ((int) view.getX()) + (view.getWidth() / 2);
                        int height = view.getHeight() / 2;
                        Animator animator = this.circleRevealAnim;
                        if (animator != null && animator.isRunning()) {
                            this.circleRevealAnim.cancel();
                            setBackgroundColor(this.items.get(i).getColor(this.context));
                            this.backgroundColorView.setBackgroundColor(0);
                        }
                        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(this.backgroundColorView, x, height, 0.0f, iMax);
                        this.circleRevealAnim = animatorCreateCircularReveal;
                        animatorCreateCircularReveal.setStartDelay(5L);
                        this.circleRevealAnim.addListener(new Animator.AnimatorListener() { // from class: com.aurelhubert.ahbottomnavigation.AHBottomNavigation.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                                AHBottomNavigation.this.backgroundColorView.setBackgroundColor(((AHBottomNavigationItem) AHBottomNavigation.this.items.get(i)).getColor(AHBottomNavigation.this.context));
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                AHBottomNavigation aHBottomNavigation = AHBottomNavigation.this;
                                aHBottomNavigation.setBackgroundColor(((AHBottomNavigationItem) aHBottomNavigation.items.get(i)).getColor(AHBottomNavigation.this.context));
                                AHBottomNavigation.this.backgroundColorView.setBackgroundColor(0);
                            }
                        });
                        this.circleRevealAnim.start();
                    } else if (z2) {
                        AHHelper.updateViewBackgroundColor(this, this.currentColor, this.items.get(i).getColor(this.context));
                    } else {
                        int i4 = this.defaultBackgroundResource;
                        if (i4 != 0) {
                            setBackgroundResource(i4);
                        } else {
                            setBackgroundColor(this.defaultBackgroundColor);
                        }
                        this.backgroundColorView.setBackgroundColor(0);
                    }
                } else if (i3 == this.currentItem) {
                    AHTextView aHTextView3 = (AHTextView) view.findViewById(C1405R.id.bottom_navigation_item_title);
                    ImageView imageView2 = (ImageView) view.findViewById(C1405R.id.bottom_navigation_item_icon);
                    AHTextView aHTextView4 = (AHTextView) view.findViewById(C1405R.id.bottom_navigation_notification);
                    imageView2.setSelected(false);
                    if (this.animateTabSelection) {
                        AHHelper.updateTopMargin(imageView2, dimension, dimension2);
                        AHHelper.updateLeftMargin(aHTextView4, this.notificationActiveMarginLeft, this.notificationInactiveMarginLeft);
                        AHHelper.updateTextSize(aHTextView3, getActiveTextSize(i3), getInactiveTextSize(i3));
                    }
                    AHHelper.updateTextColor(aHTextView3, this.titleActiveColor.get(i3), this.titleInactiveColor.get(i3));
                    AHHelper.updateDrawableColor(this.items.get(this.currentItem).getDrawable(this.context), imageView2, this.iconActiveColor.get(i3), this.iconInactiveColor.get(i3), this.forceTint);
                }
                i3++;
            }
            this.currentItem = i;
            if (i > 0 && i < this.items.size()) {
                this.currentColor = this.items.get(this.currentItem).getColor(this.context);
                return;
            }
            if (this.currentItem == -1) {
                int i5 = this.defaultBackgroundResource;
                if (i5 != 0) {
                    setBackgroundResource(i5);
                } else {
                    setBackgroundColor(this.defaultBackgroundColor);
                }
                this.backgroundColorView.setBackgroundColor(0);
            }
        }
    }

    private void updateSmallItems(final int i, boolean z) {
        if (this.currentItem == i) {
            OnTabSelectedListener onTabSelectedListener = this.tabSelectedListener;
            if (onTabSelectedListener == null || !z) {
                return;
            }
            onTabSelectedListener.onTabSelected(i, true);
            return;
        }
        OnTabSelectedListener onTabSelectedListener2 = this.tabSelectedListener;
        if (onTabSelectedListener2 == null || !z || onTabSelectedListener2.onTabSelected(i, false)) {
            int dimension = (int) this.resources.getDimension(C1405R.dimen.bottom_navigation_small_margin_top_active);
            int dimension2 = (int) this.resources.getDimension(C1405R.dimen.bottom_navigation_small_margin_top);
            int i2 = 0;
            while (i2 < this.views.size()) {
                View view = this.views.get(i2);
                if (this.selectedBackgroundVisible) {
                    view.setSelected(i2 == i);
                }
                if (i2 == i) {
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(C1405R.id.bottom_navigation_small_container);
                    AHTextView aHTextView = (AHTextView) view.findViewById(C1405R.id.bottom_navigation_small_item_title);
                    ImageView imageView = (ImageView) view.findViewById(C1405R.id.bottom_navigation_small_item_icon);
                    AHTextView aHTextView2 = (AHTextView) view.findViewById(C1405R.id.bottom_navigation_notification);
                    imageView.setSelected(true);
                    if (this.titleState != TitleState.ALWAYS_HIDE) {
                        AHHelper.updateTopMargin(imageView, dimension2, dimension);
                        AHHelper.updateLeftMargin(aHTextView2, this.notificationInactiveMarginLeft, this.notificationActiveMarginLeft);
                        AHHelper.updateTopMargin(aHTextView2, this.notificationInactiveMarginTop, this.notificationActiveMarginTop);
                        AHHelper.updateTextColor(aHTextView, this.iconInactiveColor.get(i2), this.iconActiveColor.get(i2));
                        AHHelper.updateWidth(frameLayout, this.notSelectedItemWidth, this.selectedItemWidth);
                    }
                    AHHelper.updateAlpha(aHTextView, 0.0f, 1.0f);
                    AHHelper.updateDrawableColor(this.items.get(i).getDrawable(this.context), imageView, this.iconInactiveColor.get(i2), this.iconActiveColor.get(i2), this.forceTint);
                    boolean z2 = this.colored;
                    if (z2) {
                        int iMax = Math.max(getWidth(), getHeight());
                        int x = ((int) this.views.get(i).getX()) + (this.views.get(i).getWidth() / 2);
                        int height = this.views.get(i).getHeight() / 2;
                        Animator animator = this.circleRevealAnim;
                        if (animator != null && animator.isRunning()) {
                            this.circleRevealAnim.cancel();
                            setBackgroundColor(this.items.get(i).getColor(this.context));
                            this.backgroundColorView.setBackgroundColor(0);
                        }
                        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(this.backgroundColorView, x, height, 0.0f, iMax);
                        this.circleRevealAnim = animatorCreateCircularReveal;
                        animatorCreateCircularReveal.setStartDelay(5L);
                        this.circleRevealAnim.addListener(new Animator.AnimatorListener() { // from class: com.aurelhubert.ahbottomnavigation.AHBottomNavigation.2
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator2) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator2) {
                                AHBottomNavigation.this.backgroundColorView.setBackgroundColor(((AHBottomNavigationItem) AHBottomNavigation.this.items.get(i)).getColor(AHBottomNavigation.this.context));
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                AHBottomNavigation aHBottomNavigation = AHBottomNavigation.this;
                                aHBottomNavigation.setBackgroundColor(((AHBottomNavigationItem) aHBottomNavigation.items.get(i)).getColor(AHBottomNavigation.this.context));
                                AHBottomNavigation.this.backgroundColorView.setBackgroundColor(0);
                            }
                        });
                        this.circleRevealAnim.start();
                    } else if (z2) {
                        AHHelper.updateViewBackgroundColor(this, this.currentColor, this.items.get(i).getColor(this.context));
                    } else {
                        int i3 = this.defaultBackgroundResource;
                        if (i3 != 0) {
                            setBackgroundResource(i3);
                        } else {
                            setBackgroundColor(this.defaultBackgroundColor);
                        }
                        this.backgroundColorView.setBackgroundColor(0);
                    }
                } else if (i2 == this.currentItem) {
                    View viewFindViewById = view.findViewById(C1405R.id.bottom_navigation_small_container);
                    AHTextView aHTextView3 = (AHTextView) view.findViewById(C1405R.id.bottom_navigation_small_item_title);
                    ImageView imageView2 = (ImageView) view.findViewById(C1405R.id.bottom_navigation_small_item_icon);
                    AHTextView aHTextView4 = (AHTextView) view.findViewById(C1405R.id.bottom_navigation_notification);
                    imageView2.setSelected(false);
                    if (this.titleState != TitleState.ALWAYS_HIDE) {
                        AHHelper.updateTopMargin(imageView2, dimension, dimension2);
                        AHHelper.updateLeftMargin(aHTextView4, this.notificationActiveMarginLeft, this.notificationInactiveMarginLeft);
                        AHHelper.updateTopMargin(aHTextView4, this.notificationActiveMarginTop, this.notificationInactiveMarginTop);
                        AHHelper.updateTextColor(aHTextView3, this.iconActiveColor.get(i2), this.iconInactiveColor.get(i2));
                        AHHelper.updateWidth(viewFindViewById, this.selectedItemWidth, this.notSelectedItemWidth);
                    }
                    AHHelper.updateAlpha(aHTextView3, 1.0f, 0.0f);
                    AHHelper.updateDrawableColor(this.items.get(this.currentItem).getDrawable(this.context), imageView2, this.iconActiveColor.get(i2), this.iconInactiveColor.get(i2), this.forceTint);
                }
                i2++;
            }
            this.currentItem = i;
            if (i > 0 && i < this.items.size()) {
                this.currentColor = this.items.get(this.currentItem).getColor(this.context);
                return;
            }
            if (this.currentItem == -1) {
                int i4 = this.defaultBackgroundResource;
                if (i4 != 0) {
                    setBackgroundResource(i4);
                } else {
                    setBackgroundColor(this.defaultBackgroundColor);
                }
                this.backgroundColorView.setBackgroundColor(0);
            }
        }
    }

    private void updateNotifications(boolean z, int i) {
        for (int i2 = 0; i2 < this.views.size() && i2 < this.notifications.size(); i2++) {
            if (i == -1 || i == i2) {
                AHNotification aHNotification = this.notifications.get(i2);
                int textColor = AHNotificationHelper.getTextColor(aHNotification, this.notificationTextColor);
                int backgroundColor = AHNotificationHelper.getBackgroundColor(aHNotification, this.notificationBackgroundColor);
                AHTextView aHTextView = (AHTextView) this.views.get(i2).findViewById(C1405R.id.bottom_navigation_notification);
                if (z) {
                    aHTextView.setElevation(aHNotification.isDot() ? 0.0f : this.defaultNotificationElevation);
                    aHTextView.setTextColor(textColor);
                    Typeface typeface = this.notificationTypeface;
                    if (typeface != null) {
                        aHTextView.setTypeface(typeface);
                    } else {
                        aHTextView.setTypeface(null, 1);
                    }
                    if (this.notificationBackgroundDrawable != null) {
                        aHTextView.setBackground(this.notificationBackgroundDrawable.getConstantState().newDrawable());
                    } else if (backgroundColor != 0) {
                        aHTextView.setBackground(AHHelper.getTintDrawable(ContextCompat.getDrawable(this.context, C1405R.drawable.notification_background), Integer.valueOf(backgroundColor), this.forceTint));
                    }
                }
                if (aHNotification.isEmpty()) {
                    hideNotification(aHNotification, aHTextView);
                } else {
                    showNotification(aHNotification, aHTextView);
                }
            }
        }
    }

    private void showNotification(AHNotification aHNotification, AHTextView aHTextView) {
        aHTextView.setText(aHNotification.getReadableText());
        updateNotificationSize(aHNotification, aHTextView);
        if (aHTextView.getAlpha() != 1.0f) {
            if (shouldAnimateNotification(aHNotification)) {
                animateNotificationShow(aHTextView);
                aHNotification.setAnimate(false);
            } else {
                aHTextView.setScaleX(1.0f);
                aHTextView.setScaleY(1.0f);
                aHTextView.setAlpha(1.0f);
            }
        }
    }

    private void animateNotificationShow(AHTextView aHTextView) {
        aHTextView.setScaleX(0.0f);
        aHTextView.setScaleY(0.0f);
        aHTextView.setAlpha(0.0f);
        aHTextView.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setInterpolator(new OvershootInterpolator()).setDuration(this.notificationAnimationDuration).start();
    }

    private void hideNotification(AHNotification aHNotification, AHTextView aHTextView) {
        if (aHTextView.getAlpha() != 0.0f) {
            if (shouldAnimateNotification(aHNotification)) {
                animateHideNotification(aHTextView);
                aHNotification.setAnimate(false);
            } else {
                aHTextView.setScaleX(0.0f);
                aHTextView.setScaleY(0.0f);
                aHTextView.setAlpha(0.0f);
            }
        }
    }

    private void animateHideNotification(final AHTextView aHTextView) {
        aHTextView.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: com.aurelhubert.ahbottomnavigation.AHBottomNavigation.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aHTextView.getAlpha() == 0.0f) {
                    aHTextView.setText("");
                }
            }
        }).setDuration(this.notificationAnimationDuration).start();
    }

    private void updateNotificationSize(AHNotification aHNotification, AHTextView aHTextView) {
        ViewGroup.LayoutParams layoutParams = aHTextView.getLayoutParams();
        layoutParams.width = (aHNotification.getSize() < 0 || aHNotification.hasText()) ? -2 : aHNotification.getSize();
        layoutParams.height = aHNotification.getSize() >= 0 ? aHNotification.getSize() : getResources().getDimensionPixelSize(C1405R.dimen.bottom_navigation_notification_height);
        aHTextView.requestLayout();
    }

    private boolean shouldAnimateNotification(AHNotification aHNotification) {
        return aHNotification.shouldAnimate() && this.animateTabSelection;
    }

    public void addItem(AHBottomNavigationItem aHBottomNavigationItem) {
        if (this.items.size() > 5) {
            LogInstrumentation.m2734w(TAG, "The items list should not have more than 5 items");
        }
        this.items.add(aHBottomNavigationItem);
        createItems();
    }

    public void addItems(List<AHBottomNavigationItem> list) {
        if (list.size() > 5 || this.items.size() + list.size() > 5) {
            LogInstrumentation.m2734w(TAG, "The items list should not have more than 5 items");
        }
        this.items.addAll(list);
        createItems();
    }

    public void removeItemAtIndex(int i) {
        if (i < this.items.size()) {
            this.items.remove(i);
            createItems();
        }
    }

    public void removeAllItems() {
        this.items.clear();
        createItems();
    }

    public void refresh() {
        createItems();
    }

    public int getItemsCount() {
        return this.items.size();
    }

    public boolean isColored() {
        return this.colored;
    }

    public void setColored(boolean z) {
        this.colored = z;
        this.iconActiveColor = z ? this.coloredTitleColorActive : this.titleActiveColor;
        this.iconInactiveColor = z ? this.coloredTitleColorInactive : this.titleInactiveColor;
        createItems();
    }

    public int getDefaultBackgroundColor() {
        return this.defaultBackgroundColor;
    }

    public void setDefaultBackgroundColor(int i) {
        this.defaultBackgroundColor = i;
        createItems();
    }

    public void setDefaultBackgroundResource(int i) {
        this.defaultBackgroundResource = i;
        createItems();
    }

    public void setAnimateTabSelection(boolean z) {
        this.animateTabSelection = z;
    }

    public Integer getIconActiveColor(int i) {
        return this.iconActiveColor.get(i);
    }

    public void setIconActiveColor(int i, Integer num) {
        if (AHHelper.equals(this.iconActiveColor.get(i), num)) {
            return;
        }
        this.iconActiveColor.set(i, num);
        createItems();
    }

    public void setIconWidth(int i, Integer num) {
        if (AHHelper.equals(this.iconWidth.get(i), num)) {
            return;
        }
        this.iconWidth.set(i, num);
        createItems();
    }

    public void setIconHeight(int i, Integer num) {
        if (AHHelper.equals(this.iconHeight.get(i), num)) {
            return;
        }
        this.iconHeight.set(i, num);
        createItems();
    }

    public void setTitleActiveColor(int i, Integer num) {
        if (AHHelper.equals(this.titleActiveColor.get(i), num)) {
            return;
        }
        this.titleActiveColor.set(i, num);
        createItems();
    }

    public Integer getIconInactiveColor(int i) {
        return this.iconInactiveColor.get(i);
    }

    public Integer getTitleInactiveColor(int i) {
        return this.titleInactiveColor.get(i);
    }

    public void setIconInactiveColor(int i, Integer num) {
        if (AHHelper.equals(this.iconInactiveColor.get(i), num)) {
            return;
        }
        this.iconInactiveColor.set(i, num);
        createItems();
    }

    public void setTitleInactiveColor(int i, Integer num) {
        if (AHHelper.equals(this.titleInactiveColor.get(i), num)) {
            return;
        }
        this.titleInactiveColor.set(i, num);
        createItems();
    }

    public void setColoredModeColors(int i, int i2, int i3) {
        this.coloredTitleColorActive.set(i, Integer.valueOf(i2));
        this.coloredTitleColorInactive.set(i, Integer.valueOf(i3));
        createItems();
    }

    public void setSelectedBackgroundVisible(boolean z) {
        this.selectedBackgroundVisible = z;
        createItems();
    }

    public void setTitleTypeface(int i, Typeface typeface) {
        if (this.titleTypeface.get(i) == typeface) {
            return;
        }
        this.titleTypeface.set(i, typeface);
        createItems();
    }

    public void setTitleActiveTextSize(int i, Float f) {
        if (AHHelper.equals(this.titleActiveTextSize.get(i), f)) {
            return;
        }
        this.titleActiveTextSize.set(i, f);
        createItems();
    }

    public void setTitleInactiveTextSize(int i, Float f) {
        if (AHHelper.equals(this.titleInactiveTextSize.get(i), f)) {
            return;
        }
        this.titleInactiveTextSize.set(i, f);
        createItems();
    }

    public void setTitleActiveTextSizeInSp(int i, Float f) {
        if (AHHelper.equals(this.titleActiveTextSize.get(i), f)) {
            return;
        }
        this.titleActiveTextSize.set(i, Float.valueOf(TypedValue.applyDimension(2, f.floatValue(), this.resources.getDisplayMetrics())));
        createItems();
    }

    public void setTitleInactiveTextSizeInSp(int i, Float f) {
        if (AHHelper.equals(this.titleInactiveTextSize.get(i), f)) {
            return;
        }
        this.titleInactiveTextSize.set(i, Float.valueOf(TypedValue.applyDimension(2, f.floatValue(), this.resources.getDisplayMetrics())));
        createItems();
    }

    public void setTag(int i, String str) {
        if (i < 0 || i >= this.views.size()) {
            return;
        }
        this.views.get(i).setTag(str);
    }

    public AHBottomNavigationItem getItem(int i) {
        if (i < 0 || i > this.items.size() - 1) {
            LogInstrumentation.m2734w(TAG, "The position is out of bounds of the items (" + this.items.size() + " elements)");
            return null;
        }
        return this.items.get(i);
    }

    public int getCurrentItem() {
        return this.currentItem;
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    public void setCurrentItem(int i, boolean z) {
        if (i >= this.items.size()) {
            LogInstrumentation.m2734w(TAG, "The position is out of bounds of the items (" + this.items.size() + " elements)");
        } else if (isClassic()) {
            updateItems(i, z);
        } else {
            updateSmallItems(i, z);
        }
    }

    public boolean isBehaviorTranslationEnabled() {
        return this.behaviorTranslationEnabled;
    }

    public void setBehaviorTranslationEnabled(boolean z) {
        this.behaviorTranslationEnabled = z;
        if (getParent() instanceof CoordinatorLayout) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            AHBottomNavigationBehavior<AHBottomNavigation> aHBottomNavigationBehavior = this.bottomNavigationBehavior;
            if (aHBottomNavigationBehavior == null) {
                this.bottomNavigationBehavior = new AHBottomNavigationBehavior<>(z, this.navigationBarHeight);
            } else {
                aHBottomNavigationBehavior.setBehaviorTranslationEnabled(z, this.navigationBarHeight);
            }
            OnNavigationPositionListener onNavigationPositionListener = this.navigationPositionListener;
            if (onNavigationPositionListener != null) {
                this.bottomNavigationBehavior.setOnNavigationPositionListener(onNavigationPositionListener);
            }
            ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(this.bottomNavigationBehavior);
            if (this.needHideBottomNavigation) {
                this.needHideBottomNavigation = false;
                this.bottomNavigationBehavior.hideView(this, this.bottomNavigationHeight, this.hideBottomNavigationWithAnimation);
            }
        }
    }

    public void manageFloatingActionButtonBehavior(FloatingActionButton floatingActionButton) {
        if (floatingActionButton.getParent() instanceof CoordinatorLayout) {
            ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).setBehavior(new AHBottomNavigationFABBehavior(this.navigationBarHeight));
        }
    }

    public void hideBottomNavigation() {
        hideBottomNavigation(true);
    }

    public void hideBottomNavigation(boolean z) {
        AHBottomNavigationBehavior<AHBottomNavigation> aHBottomNavigationBehavior = this.bottomNavigationBehavior;
        if (aHBottomNavigationBehavior != null) {
            aHBottomNavigationBehavior.hideView(this, this.bottomNavigationHeight, z);
        } else if (getParent() instanceof CoordinatorLayout) {
            this.needHideBottomNavigation = true;
            this.hideBottomNavigationWithAnimation = z;
        } else {
            ViewCompat.animate(this).translationY(this.bottomNavigationHeight).setInterpolator(new LinearOutSlowInInterpolator()).setDuration(z ? 300L : 0L).start();
        }
    }

    public void restoreBottomNavigation() {
        restoreBottomNavigation(true);
    }

    public void restoreBottomNavigation(boolean z) {
        AHBottomNavigationBehavior<AHBottomNavigation> aHBottomNavigationBehavior = this.bottomNavigationBehavior;
        if (aHBottomNavigationBehavior != null) {
            aHBottomNavigationBehavior.resetOffset(this, z);
        } else {
            ViewCompat.animate(this).translationY(0.0f).setInterpolator(new LinearOutSlowInInterpolator()).setDuration(z ? 300L : 0L).start();
        }
    }

    public boolean isTranslucentNavigationEnabled() {
        return this.translucentNavigationEnabled;
    }

    public void setTranslucentNavigationEnabled(boolean z) {
        this.translucentNavigationEnabled = z;
    }

    public boolean isForceTint() {
        return this.forceTint;
    }

    public void setForceTint(boolean z) {
        this.forceTint = z;
        createItems();
    }

    public TitleState getTitleState() {
        return this.titleState;
    }

    public void setTitleState(TitleState titleState) {
        this.titleState = titleState;
        createItems();
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.tabSelectedListener = onTabSelectedListener;
    }

    public void removeOnTabSelectedListener() {
        this.tabSelectedListener = null;
    }

    public void setOnNavigationPositionListener(OnNavigationPositionListener onNavigationPositionListener) {
        this.navigationPositionListener = onNavigationPositionListener;
        AHBottomNavigationBehavior<AHBottomNavigation> aHBottomNavigationBehavior = this.bottomNavigationBehavior;
        if (aHBottomNavigationBehavior != null) {
            aHBottomNavigationBehavior.setOnNavigationPositionListener(onNavigationPositionListener);
        }
    }

    public void removeOnNavigationPositionListener() {
        this.navigationPositionListener = null;
        AHBottomNavigationBehavior<AHBottomNavigation> aHBottomNavigationBehavior = this.bottomNavigationBehavior;
        if (aHBottomNavigationBehavior != null) {
            aHBottomNavigationBehavior.removeOnNavigationPositionListener();
        }
    }

    @Deprecated
    public void setNotification(int i, int i2) {
        if (i2 < 0 || i2 > this.items.size() - 1) {
            throw new IndexOutOfBoundsException(String.format(Locale.US, EXCEPTION_INDEX_OUT_OF_BOUNDS, Integer.valueOf(i2), Integer.valueOf(this.items.size())));
        }
        this.notifications.set(i2, AHNotification.justText(i == 0 ? "" : String.valueOf(i)));
        updateNotifications(false, i2);
    }

    public void setNotification(String str, int i) {
        if (i < 0 || i > this.items.size() - 1) {
            throw new IndexOutOfBoundsException(String.format(Locale.US, EXCEPTION_INDEX_OUT_OF_BOUNDS, Integer.valueOf(i), Integer.valueOf(this.items.size())));
        }
        this.notifications.set(i, AHNotification.justText(str));
        updateNotifications(false, i);
    }

    public void setNotification(AHNotification aHNotification, int i) {
        if (i < 0 || i > this.items.size() - 1) {
            throw new IndexOutOfBoundsException(String.format(Locale.US, EXCEPTION_INDEX_OUT_OF_BOUNDS, Integer.valueOf(i), Integer.valueOf(this.items.size())));
        }
        if (aHNotification == null) {
            aHNotification = new AHNotification();
        }
        this.notifications.set(i, aHNotification);
        updateNotifications(true, i);
    }

    public void setNotificationSize(int i, Integer num) {
        if (AHHelper.equals(Integer.valueOf(this.notifications.get(i).getSize()), num)) {
            return;
        }
        this.notifications.get(i).setSize(num.intValue());
        updateNotifications(true, i);
    }

    public void setNotificationTextColor(int i) {
        if (this.notificationTextColor == i) {
            return;
        }
        this.notificationTextColor = i;
        updateNotifications(true, -1);
    }

    public void setNotificationTextColorResource(int i) {
        this.notificationTextColor = ContextCompat.getColor(this.context, i);
        updateNotifications(true, -1);
    }

    public void setNotificationBackground(Drawable drawable) {
        this.notificationBackgroundDrawable = drawable;
        updateNotifications(true, -1);
    }

    public void setNotificationBackgroundColor(int i) {
        if (this.notificationBackgroundColor == i) {
            return;
        }
        this.notificationBackgroundColor = i;
        updateNotifications(true, -1);
    }

    public void setNotificationBackgroundColorResource(int i) {
        this.notificationBackgroundColor = ContextCompat.getColor(this.context, i);
        updateNotifications(true, -1);
    }

    public void setNotificationTypeface(Typeface typeface) {
        this.notificationTypeface = typeface;
        updateNotifications(true, -1);
    }

    public void setNotificationAnimationDuration(long j) {
        this.notificationAnimationDuration = j;
        updateNotifications(true, -1);
    }

    public void setNotificationMarginLeft(int i, int i2) {
        this.notificationActiveMarginLeft = i;
        this.notificationInactiveMarginLeft = i2;
        createItems();
    }

    public void setUseElevation(boolean z) {
        ViewCompat.setElevation(this, z ? this.resources.getDimension(C1405R.dimen.bottom_navigation_elevation) : 0.0f);
        setClipToPadding(false);
    }

    public void setUseElevation(boolean z, float f) {
        if (!z) {
            f = 0.0f;
        }
        ViewCompat.setElevation(this, f);
        setClipToPadding(false);
    }

    public boolean isHidden() {
        AHBottomNavigationBehavior<AHBottomNavigation> aHBottomNavigationBehavior = this.bottomNavigationBehavior;
        if (aHBottomNavigationBehavior != null) {
            return aHBottomNavigationBehavior.isHidden();
        }
        return false;
    }

    public View getViewAtPosition(int i) {
        LinearLayout linearLayout = this.linearLayoutContainer;
        if (linearLayout == null || i < 0 || i >= linearLayout.getChildCount()) {
            return null;
        }
        return this.linearLayoutContainer.getChildAt(i);
    }

    public void enableItemAtPosition(int i) {
        if (i < 0 || i > this.items.size() - 1) {
            LogInstrumentation.m2734w(TAG, "The position is out of bounds of the items (" + this.items.size() + " elements)");
        } else {
            this.itemsEnabledStates[i] = true;
            createItems();
        }
    }

    public void disableItemAtPosition(int i) {
        if (i < 0 || i > this.items.size() - 1) {
            LogInstrumentation.m2734w(TAG, "The position is out of bounds of the items (" + this.items.size() + " elements)");
        } else {
            this.itemsEnabledStates[i] = false;
            createItems();
        }
    }

    public void setIconDisableColor(int i, int i2) {
        this.iconDisableColor.set(i, Integer.valueOf(i2));
    }

    public void setPreferLargeIcons(boolean z) {
        this.preferLargeIcons = z;
    }

    private int dpToPx(int i) {
        return i * (getResources().getDisplayMetrics().densityDpi / 160);
    }
}
