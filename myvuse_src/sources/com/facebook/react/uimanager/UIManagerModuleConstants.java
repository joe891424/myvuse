package com.facebook.react.uimanager;

import android.widget.ImageView;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.events.TouchEventType;
import com.google.firebase.ktx.BuildConfig;
import com.reactnativecommunity.webview.events.TopLoadingErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingFinishEvent;
import com.reactnativecommunity.webview.events.TopLoadingStartEvent;
import com.reactnativecommunity.webview.events.TopMessageEvent;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class UIManagerModuleConstants {
    public static final String ACTION_DISMISSED = "dismissed";
    public static final String ACTION_ITEM_SELECTED = "itemSelected";

    UIManagerModuleConstants() {
    }

    static Map getBubblingEventTypeConstants() {
        return MapBuilder.builder().put("topChange", MapBuilder.m1349of("phasedRegistrationNames", MapBuilder.m1350of("bubbled", "onChange", "captured", "onChangeCapture"))).put("topSelect", MapBuilder.m1349of("phasedRegistrationNames", MapBuilder.m1350of("bubbled", "onSelect", "captured", "onSelectCapture"))).put(TouchEventType.getJSEventName(TouchEventType.START), MapBuilder.m1349of("phasedRegistrationNames", MapBuilder.m1350of("bubbled", "onTouchStart", "captured", "onTouchStartCapture"))).put(TouchEventType.getJSEventName(TouchEventType.MOVE), MapBuilder.m1349of("phasedRegistrationNames", MapBuilder.m1350of("bubbled", "onTouchMove", "captured", "onTouchMoveCapture"))).put(TouchEventType.getJSEventName(TouchEventType.END), MapBuilder.m1349of("phasedRegistrationNames", MapBuilder.m1350of("bubbled", "onTouchEnd", "captured", "onTouchEndCapture"))).put(TouchEventType.getJSEventName(TouchEventType.CANCEL), MapBuilder.m1349of("phasedRegistrationNames", MapBuilder.m1350of("bubbled", "onTouchCancel", "captured", "onTouchCancelCapture"))).build();
    }

    static Map getDirectEventTypeConstants() {
        return MapBuilder.builder().put("topContentSizeChange", MapBuilder.m1349of("registrationName", "onContentSizeChange")).put("topLayout", MapBuilder.m1349of("registrationName", ViewProps.ON_LAYOUT)).put(TopLoadingErrorEvent.EVENT_NAME, MapBuilder.m1349of("registrationName", "onLoadingError")).put(TopLoadingFinishEvent.EVENT_NAME, MapBuilder.m1349of("registrationName", "onLoadingFinish")).put(TopLoadingStartEvent.EVENT_NAME, MapBuilder.m1349of("registrationName", "onLoadingStart")).put("topSelectionChange", MapBuilder.m1349of("registrationName", "onSelectionChange")).put(TopMessageEvent.EVENT_NAME, MapBuilder.m1349of("registrationName", "onMessage")).put("topScrollBeginDrag", MapBuilder.m1349of("registrationName", "onScrollBeginDrag")).put("topScrollEndDrag", MapBuilder.m1349of("registrationName", "onScrollEndDrag")).put("topScroll", MapBuilder.m1349of("registrationName", "onScroll")).put("topMomentumScrollBegin", MapBuilder.m1349of("registrationName", "onMomentumScrollBegin")).put("topMomentumScrollEnd", MapBuilder.m1349of("registrationName", "onMomentumScrollEnd")).build();
    }

    public static Map<String, Object> getConstants() {
        HashMap mapNewHashMap = MapBuilder.newHashMap();
        mapNewHashMap.put("UIView", MapBuilder.m1349of("ContentMode", MapBuilder.m1351of("ScaleAspectFit", Integer.valueOf(ImageView.ScaleType.FIT_CENTER.ordinal()), "ScaleAspectFill", Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()), "ScaleAspectCenter", Integer.valueOf(ImageView.ScaleType.CENTER_INSIDE.ordinal()))));
        mapNewHashMap.put("StyleConstants", MapBuilder.m1349of("PointerEventsValues", MapBuilder.m1352of("none", Integer.valueOf(PointerEvents.NONE.ordinal()), "boxNone", Integer.valueOf(PointerEvents.BOX_NONE.ordinal()), "boxOnly", Integer.valueOf(PointerEvents.BOX_ONLY.ordinal()), BuildConfig.VERSION_NAME, Integer.valueOf(PointerEvents.AUTO.ordinal()))));
        mapNewHashMap.put("PopupMenu", MapBuilder.m1350of("dismissed", "dismissed", ACTION_ITEM_SELECTED, ACTION_ITEM_SELECTED));
        mapNewHashMap.put("AccessibilityEventTypes", MapBuilder.m1351of("typeWindowStateChanged", 32, "typeViewFocused", 8, "typeViewClicked", 1));
        return mapNewHashMap;
    }
}
