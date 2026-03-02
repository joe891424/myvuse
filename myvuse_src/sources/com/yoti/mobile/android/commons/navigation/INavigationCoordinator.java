package com.yoti.mobile.android.commons.navigation;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* JADX INFO: compiled from: INavigationCoordinator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/navigation/INavigationCoordinator;", "", "Lcom/yoti/mobile/android/commons/navigation/NavigationEvent;", NotificationCompat.CATEGORY_EVENT, "", "onNavigationEvent", "(Lcom/yoti/mobile/android/commons/navigation/NavigationEvent;)Z", "commons-navigation_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public interface INavigationCoordinator {
    boolean onNavigationEvent(NavigationEvent event);
}
