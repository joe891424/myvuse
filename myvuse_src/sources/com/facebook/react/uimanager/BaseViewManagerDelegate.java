package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T>> implements ViewManagerDelegate<T> {
    protected final U mViewManager;

    @Override // com.facebook.react.uimanager.ViewManagerDelegate
    public void receiveCommand(T t, String str, ReadableArray readableArray) {
    }

    public BaseViewManagerDelegate(U u) {
        this.mViewManager = u;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1721943862:
                if (str.equals(ViewProps.TRANSLATE_X)) {
                    b = 0;
                }
                break;
            case -1721943861:
                if (str.equals(ViewProps.TRANSLATE_Y)) {
                    b = 1;
                }
                break;
            case -1589741021:
                if (str.equals(ViewProps.SHADOW_COLOR)) {
                    b = 2;
                }
                break;
            case -1267206133:
                if (str.equals(ViewProps.OPACITY)) {
                    b = 3;
                }
                break;
            case -1228066334:
                if (str.equals(ViewProps.BORDER_TOP_LEFT_RADIUS)) {
                    b = 4;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b = 5;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b = 6;
                }
                break;
            case -877170387:
                if (str.equals(ViewProps.TEST_ID)) {
                    b = 7;
                }
                break;
            case -781597262:
                if (str.equals(ViewProps.TRANSFORM_ORIGIN)) {
                    b = 8;
                }
                break;
            case -731417480:
                if (str.equals(ViewProps.Z_INDEX)) {
                    b = 9;
                }
                break;
            case -101663499:
                if (str.equals(ViewProps.ACCESSIBILITY_HINT)) {
                    b = 10;
                }
                break;
            case -101359900:
                if (str.equals(ViewProps.ACCESSIBILITY_ROLE)) {
                    b = Ascii.f3760VT;
                }
                break;
            case -80891667:
                if (str.equals(ViewProps.RENDER_TO_HARDWARE_TEXTURE)) {
                    b = Ascii.f3749FF;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    b = Ascii.f3747CR;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b = Ascii.f3757SO;
                }
                break;
            case 3506294:
                if (str.equals(ViewProps.ROLE)) {
                    b = Ascii.f3756SI;
                }
                break;
            case 36255470:
                if (str.equals(ViewProps.ACCESSIBILITY_LIVE_REGION)) {
                    b = Ascii.DLE;
                }
                break;
            case 333432965:
                if (str.equals(ViewProps.BORDER_TOP_RIGHT_RADIUS)) {
                    b = 17;
                }
                break;
            case 581268560:
                if (str.equals(ViewProps.BORDER_BOTTOM_LEFT_RADIUS)) {
                    b = Ascii.DC2;
                }
                break;
            case 588239831:
                if (str.equals(ViewProps.BORDER_BOTTOM_RIGHT_RADIUS)) {
                    b = 19;
                }
                break;
            case 746986311:
                if (str.equals(ViewProps.IMPORTANT_FOR_ACCESSIBILITY)) {
                    b = Ascii.DC4;
                }
                break;
            case 1052666732:
                if (str.equals(ViewProps.TRANSFORM)) {
                    b = Ascii.NAK;
                }
                break;
            case 1146842694:
                if (str.equals(ViewProps.ACCESSIBILITY_LABEL)) {
                    b = Ascii.SYN;
                }
                break;
            case 1153872867:
                if (str.equals(ViewProps.ACCESSIBILITY_STATE)) {
                    b = Ascii.ETB;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    b = Ascii.CAN;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    b = Ascii.f3748EM;
                }
                break;
            case 1505602511:
                if (str.equals(ViewProps.ACCESSIBILITY_ACTIONS)) {
                    b = Ascii.SUB;
                }
                break;
            case 1761903244:
                if (str.equals(ViewProps.ACCESSIBILITY_COLLECTION)) {
                    b = Ascii.ESC;
                }
                break;
            case 1865277756:
                if (str.equals(ViewProps.ACCESSIBILITY_LABELLED_BY)) {
                    b = Ascii.f3750FS;
                }
                break;
            case 1993034687:
                if (str.equals(ViewProps.ACCESSIBILITY_COLLECTION_ITEM)) {
                    b = Ascii.f3751GS;
                }
                break;
            case 2045685618:
                if (str.equals(ViewProps.NATIVE_ID)) {
                    b = Ascii.f3755RS;
                }
                break;
        }
        switch (b) {
            case 0:
                this.mViewManager.setTranslateX(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 1:
                this.mViewManager.setTranslateY(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 2:
                this.mViewManager.setShadowColor(t, obj != null ? ColorPropConverter.getColor(obj, t.getContext()).intValue() : 0);
                break;
            case 3:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 4:
                this.mViewManager.setBorderTopLeftRadius(t, obj != null ? ((Double) obj).floatValue() : Float.NaN);
                break;
            case 5:
                this.mViewManager.setScaleX(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 6:
                this.mViewManager.setScaleY(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 7:
                this.mViewManager.setTestId(t, (String) obj);
                break;
            case 8:
                this.mViewManager.setTransformOrigin(t, (ReadableArray) obj);
                break;
            case 9:
                this.mViewManager.setZIndex(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 10:
                this.mViewManager.setAccessibilityHint(t, (String) obj);
                break;
            case 11:
                this.mViewManager.setAccessibilityRole(t, (String) obj);
                break;
            case 12:
                this.mViewManager.setRenderToHardwareTexture(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 13:
                this.mViewManager.setRotation(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 14:
                this.mViewManager.setElevation(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 15:
                this.mViewManager.setRole(t, (String) obj);
                break;
            case 16:
                this.mViewManager.setAccessibilityLiveRegion(t, (String) obj);
                break;
            case 17:
                this.mViewManager.setBorderTopRightRadius(t, obj != null ? ((Double) obj).floatValue() : Float.NaN);
                break;
            case 18:
                this.mViewManager.setBorderBottomLeftRadius(t, obj != null ? ((Double) obj).floatValue() : Float.NaN);
                break;
            case 19:
                this.mViewManager.setBorderBottomRightRadius(t, obj != null ? ((Double) obj).floatValue() : Float.NaN);
                break;
            case 20:
                this.mViewManager.setImportantForAccessibility(t, (String) obj);
                break;
            case 21:
                this.mViewManager.setTransform(t, (ReadableArray) obj);
                break;
            case 22:
                this.mViewManager.setAccessibilityLabel(t, (String) obj);
                break;
            case 23:
                this.mViewManager.setViewState(t, (ReadableMap) obj);
                break;
            case 24:
                this.mViewManager.setBackgroundColor(t, obj != null ? ColorPropConverter.getColor(obj, t.getContext()).intValue() : 0);
                break;
            case 25:
                this.mViewManager.setBorderRadius(t, obj != null ? ((Double) obj).floatValue() : Float.NaN);
                break;
            case 26:
                this.mViewManager.setAccessibilityActions(t, (ReadableArray) obj);
                break;
            case 27:
                this.mViewManager.setAccessibilityCollection(t, (ReadableMap) obj);
                break;
            case 28:
                this.mViewManager.setAccessibilityLabelledBy(t, new DynamicFromObject(obj));
                break;
            case 29:
                this.mViewManager.setAccessibilityCollectionItem(t, (ReadableMap) obj);
                break;
            case 30:
                this.mViewManager.setNativeId(t, (String) obj);
                break;
        }
    }
}
