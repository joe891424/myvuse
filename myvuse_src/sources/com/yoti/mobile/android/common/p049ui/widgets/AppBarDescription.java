package com.yoti.mobile.android.common.p049ui.widgets;

import androidx.viewpager.widget.ViewPager;
import com.facebook.common.callercontext.ContextChain;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b=\b\u0086\b\u0018\u00002\u00020\u0001B}\b\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010!\u001a\u00020\f\u0012\b\b\u0003\u0010\"\u001a\u00020\u0005\u0012\b\b\u0003\u0010#\u001a\u00020\u0005¢\u0006\u0004\bJ\u0010KJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000eJ\u0010\u0010\u0017\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0007J\u0084\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0003\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0003\u0010\"\u001a\u00020\u00052\b\b\u0003\u0010#\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b&\u0010\nJ\u0010\u0010'\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b'\u0010\u0007J\u001a\u0010)\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u001b\u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0015R\"\u0010!\u001a\u00020\f8\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b.\u0010/\u0012\u0004\b1\u00102\u001a\u0004\b0\u0010\u000eR\u0019\u0010\u001b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\nR\u0019\u0010#\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u0007R\u0019\u0010\"\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b9\u00107\u001a\u0004\b:\u0010\u0007R\u0019\u0010\u001c\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b;\u00107\u001a\u0004\b<\u0010\u0007R\u0019\u0010\u001a\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b=\u00107\u001a\u0004\b>\u0010\u0007R\u0019\u0010\u001d\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010/\u001a\u0004\b@\u0010\u000eR\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\u0004R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\u0011R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010\u0013¨\u0006L"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/AppBarDescription;", "", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "component1", "()Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "", "component2", "()I", "", "component3", "()Ljava/lang/String;", "component4", "", "component5", "()Z", "Landroidx/viewpager/widget/ViewPager;", "component6", "()Landroidx/viewpager/widget/ViewPager;", "component7", "()Ljava/lang/Integer;", "component8", "()Ljava/lang/Boolean;", "component9", "component10", "component11", "navigationIcon", "title", "titleText", "titleGravity", "showTabLayout", "viewPager", "menuResId", "hideSeparator", "hideAppBar", "logoRes", "logoDescription", "copy", "(Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;ILjava/lang/String;IZLandroidx/viewpager/widget/ViewPager;Ljava/lang/Integer;Ljava/lang/Boolean;ZII)Lcom/yoti/mobile/android/common/ui/widgets/AppBarDescription;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "h", "Ljava/lang/Boolean;", "getHideSeparator", ContextChain.TAG_INFRA, "Z", "getHideAppBar", "getHideAppBar$annotations", "()V", "c", "Ljava/lang/String;", "getTitleText", OctetSequenceJsonWebKey.KEY_VALUE_MEMBER_NAME, "I", "getLogoDescription", "j", "getLogoRes", "d", "getTitleGravity", "b", "getTitle", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "getShowTabLayout", "a", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "getNavigationIcon", "f", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "g", "Ljava/lang/Integer;", "getMenuResId", "<init>", "(Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;ILjava/lang/String;IZLandroidx/viewpager/widget/ViewPager;Ljava/lang/Integer;Ljava/lang/Boolean;ZII)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final /* data */ class AppBarDescription {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final NavigationIcon navigationIcon;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int title;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String titleText;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int titleGravity;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final boolean showTabLayout;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final ViewPager viewPager;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Integer menuResId;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Boolean hideSeparator;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final boolean hideAppBar;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final int logoRes;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final int logoDescription;

    public AppBarDescription() {
        this(null, 0, null, 0, false, null, null, null, false, 0, 0, 2047, null);
    }

    public AppBarDescription(NavigationIcon navigationIcon) {
        this(navigationIcon, 0, null, 0, false, null, null, null, false, 0, 0, 2046, null);
    }

    public AppBarDescription(NavigationIcon navigationIcon, int i) {
        this(navigationIcon, i, null, 0, false, null, null, null, false, 0, 0, 2044, null);
    }

    public AppBarDescription(NavigationIcon navigationIcon, int i, String str) {
        this(navigationIcon, i, str, 0, false, null, null, null, false, 0, 0, 2040, null);
    }

    public AppBarDescription(NavigationIcon navigationIcon, int i, String str, int i2) {
        this(navigationIcon, i, str, i2, false, null, null, null, false, 0, 0, 2032, null);
    }

    public AppBarDescription(NavigationIcon navigationIcon, int i, String str, int i2, boolean z) {
        this(navigationIcon, i, str, i2, z, null, null, null, false, 0, 0, 2016, null);
    }

    public AppBarDescription(NavigationIcon navigationIcon, int i, String str, int i2, boolean z, ViewPager viewPager) {
        this(navigationIcon, i, str, i2, z, viewPager, null, null, false, 0, 0, 1984, null);
    }

    public AppBarDescription(NavigationIcon navigationIcon, int i, String str, int i2, boolean z, ViewPager viewPager, Integer num) {
        this(navigationIcon, i, str, i2, z, viewPager, num, null, false, 0, 0, 1920, null);
    }

    public AppBarDescription(NavigationIcon navigationIcon, int i, String str, int i2, boolean z, ViewPager viewPager, Integer num, Boolean bool) {
        this(navigationIcon, i, str, i2, z, viewPager, num, bool, false, 0, 0, 1792, null);
    }

    public AppBarDescription(NavigationIcon navigationIcon, int i, String str, int i2, boolean z, ViewPager viewPager, Integer num, Boolean bool, boolean z2) {
        this(navigationIcon, i, str, i2, z, viewPager, num, bool, z2, 0, 0, 1536, null);
    }

    public AppBarDescription(NavigationIcon navigationIcon, int i, String str, int i2, boolean z, ViewPager viewPager, Integer num, Boolean bool, boolean z2, int i3) {
        this(navigationIcon, i, str, i2, z, viewPager, num, bool, z2, i3, 0, 1024, null);
    }

    public AppBarDescription(NavigationIcon navigationIcon, int i, String titleText, int i2, boolean z, ViewPager viewPager, Integer num, Boolean bool, boolean z2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
        Intrinsics.checkNotNullParameter(titleText, "titleText");
        this.navigationIcon = navigationIcon;
        this.title = i;
        this.titleText = titleText;
        this.titleGravity = i2;
        this.showTabLayout = z;
        this.viewPager = viewPager;
        this.menuResId = num;
        this.hideSeparator = bool;
        this.hideAppBar = z2;
        this.logoRes = i3;
        this.logoDescription = i4;
    }

    public /* synthetic */ AppBarDescription(NavigationIcon navigationIcon, int i, String str, int i2, boolean z, ViewPager viewPager, Integer num, Boolean bool, boolean z2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? NavigationIcon.NONE : navigationIcon, (i5 & 2) != 0 ? 0 : i, (i5 & 4) != 0 ? "" : str, (i5 & 8) != 0 ? 1 : i2, (i5 & 16) != 0 ? false : z, (i5 & 32) != 0 ? null : viewPager, (i5 & 64) != 0 ? null : num, (i5 & 128) == 0 ? bool : null, (i5 & 256) != 0 ? false : z2, (i5 & 512) != 0 ? 0 : i3, (i5 & 1024) == 0 ? i4 : 0);
    }

    @Deprecated(message = "Please hide the toolbar from the activity host")
    public static /* synthetic */ void getHideAppBar$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final NavigationIcon getNavigationIcon() {
        return this.navigationIcon;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getLogoRes() {
        return this.logoRes;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getLogoDescription() {
        return this.logoDescription;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitleText() {
        return this.titleText;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTitleGravity() {
        return this.titleGravity;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowTabLayout() {
        return this.showTabLayout;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ViewPager getViewPager() {
        return this.viewPager;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getMenuResId() {
        return this.menuResId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getHideSeparator() {
        return this.hideSeparator;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getHideAppBar() {
        return this.hideAppBar;
    }

    public final AppBarDescription copy(NavigationIcon navigationIcon, int title, String titleText, int titleGravity, boolean showTabLayout, ViewPager viewPager, Integer menuResId, Boolean hideSeparator, boolean hideAppBar, int logoRes, int logoDescription) {
        Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
        Intrinsics.checkNotNullParameter(titleText, "titleText");
        return new AppBarDescription(navigationIcon, title, titleText, titleGravity, showTabLayout, viewPager, menuResId, hideSeparator, hideAppBar, logoRes, logoDescription);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppBarDescription)) {
            return false;
        }
        AppBarDescription appBarDescription = (AppBarDescription) other;
        return Intrinsics.areEqual(this.navigationIcon, appBarDescription.navigationIcon) && this.title == appBarDescription.title && Intrinsics.areEqual(this.titleText, appBarDescription.titleText) && this.titleGravity == appBarDescription.titleGravity && this.showTabLayout == appBarDescription.showTabLayout && Intrinsics.areEqual(this.viewPager, appBarDescription.viewPager) && Intrinsics.areEqual(this.menuResId, appBarDescription.menuResId) && Intrinsics.areEqual(this.hideSeparator, appBarDescription.hideSeparator) && this.hideAppBar == appBarDescription.hideAppBar && this.logoRes == appBarDescription.logoRes && this.logoDescription == appBarDescription.logoDescription;
    }

    public final boolean getHideAppBar() {
        return this.hideAppBar;
    }

    public final Boolean getHideSeparator() {
        return this.hideSeparator;
    }

    public final int getLogoDescription() {
        return this.logoDescription;
    }

    public final int getLogoRes() {
        return this.logoRes;
    }

    public final Integer getMenuResId() {
        return this.menuResId;
    }

    public final NavigationIcon getNavigationIcon() {
        return this.navigationIcon;
    }

    public final boolean getShowTabLayout() {
        return this.showTabLayout;
    }

    public final int getTitle() {
        return this.title;
    }

    public final int getTitleGravity() {
        return this.titleGravity;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final ViewPager getViewPager() {
        return this.viewPager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        NavigationIcon navigationIcon = this.navigationIcon;
        int iHashCode = (((navigationIcon != null ? navigationIcon.hashCode() : 0) * 31) + Integer.hashCode(this.title)) * 31;
        String str = this.titleText;
        int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.titleGravity)) * 31;
        boolean z = this.showTabLayout;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        ViewPager viewPager = this.viewPager;
        int iHashCode3 = (i + (viewPager != null ? viewPager.hashCode() : 0)) * 31;
        Integer num = this.menuResId;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Boolean bool = this.hideSeparator;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        boolean z2 = this.hideAppBar;
        return ((((iHashCode5 + (z2 ? 1 : z2)) * 31) + Integer.hashCode(this.logoRes)) * 31) + Integer.hashCode(this.logoDescription);
    }

    public String toString() {
        return "AppBarDescription(navigationIcon=" + this.navigationIcon + ", title=" + this.title + ", titleText=" + this.titleText + ", titleGravity=" + this.titleGravity + ", showTabLayout=" + this.showTabLayout + ", viewPager=" + this.viewPager + ", menuResId=" + this.menuResId + ", hideSeparator=" + this.hideSeparator + ", hideAppBar=" + this.hideAppBar + ", logoRes=" + this.logoRes + ", logoDescription=" + this.logoDescription + ")";
    }
}
