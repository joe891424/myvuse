package com.wheelpicker;

import android.graphics.Color;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.text.ReactFontManager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class WheelPickerManager extends SimpleViewManager<LoopView> implements LoopListener {
    public static final String REACT_CLASS = "WheelPicker";
    LoopView wheelPicker;

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public LoopView createViewInstance(ThemedReactContext themedReactContext) {
        LoopView loopView = new LoopView(themedReactContext);
        this.wheelPicker = loopView;
        loopView.setListener(this);
        return this.wheelPicker;
    }

    @ReactProp(name = "data")
    public void setData(LoopView loopView, ReadableArray readableArray) {
        if (loopView != null) {
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < readableArray.size(); i++) {
                        arrayList2.add(Integer.valueOf(readableArray.getInt(i)));
                    }
                    loopView.setArrayList(arrayList2);
                } catch (Exception unused) {
                    ArrayList arrayList3 = new ArrayList();
                    for (int i2 = 0; i2 < readableArray.size(); i2++) {
                        arrayList3.add(readableArray.getString(i2));
                    }
                    loopView.setArrayList(arrayList3);
                }
            } catch (Exception e) {
                e.printStackTrace();
                loopView.setArrayList(arrayList);
            }
        }
    }

    @ReactProp(name = "isCyclic")
    public void setCyclic(LoopView loopView, Boolean bool) {
        if (loopView != null) {
            loopView.setLoop(bool.booleanValue());
        }
    }

    @ReactProp(name = "lineSpacingMultiplier")
    public void setLineSpacingMultiplier(LoopView loopView, float f) {
        if (loopView != null) {
            loopView.setLineSpacingMultiplier(f);
        }
    }

    @ReactProp(name = "selectedItemTextColor")
    public void setSelectedItemTextColor(LoopView loopView, String str) {
        if (loopView != null) {
            loopView.setSelectedItemTextColor(convertColor(str));
        }
    }

    @ReactProp(name = "selectedItemTextSize")
    public void setSelectedItemTextSize(LoopView loopView, int i) {
        if (loopView != null) {
            loopView.setSelectedItemTextSize(i);
        }
    }

    @ReactProp(name = "selectedItemTextFontFamily")
    public void setSelectedItemFont(LoopView loopView, String str) {
        if (loopView != null) {
            loopView.setSelectedItemFont(ReactFontManager.getInstance().getTypeface(str, 0, loopView.getContext().getAssets()));
        }
    }

    @ReactProp(name = "indicatorWidth")
    public void setIndicatorWidth(LoopView loopView, int i) {
        if (loopView != null) {
            loopView.setIndicatorWidth(i);
        }
    }

    @ReactProp(name = "hideIndicator")
    public void setIndicator(LoopView loopView, Boolean bool) {
        if (loopView != null) {
            loopView.hideIndicator();
        }
    }

    @ReactProp(name = "indicatorColor")
    public void setIndicatorColor(LoopView loopView, String str) {
        if (loopView != null) {
            loopView.setIndicatorColor(convertColor(str));
        }
    }

    @ReactProp(name = "itemTextColor")
    public void setItemTextColor(LoopView loopView, String str) {
        if (loopView != null) {
            loopView.setItemTextColor(convertColor(str));
        }
    }

    @ReactProp(name = "itemTextSize")
    public void setItemTextSize(LoopView loopView, int i) {
        if (loopView != null) {
            loopView.setItemTextSize(i);
        }
    }

    @ReactProp(name = "itemTextFontFamily")
    public void setItemFont(LoopView loopView, String str) {
        if (loopView != null) {
            loopView.setItemFont(ReactFontManager.getInstance().getTypeface(str, 0, loopView.getContext().getAssets()));
        }
    }

    @ReactProp(name = "initPosition")
    public void setInitialPosition(LoopView loopView, int i) {
        if (loopView != null) {
            loopView.setInitPosition(i);
        }
    }

    @ReactProp(name = "backgroundColor")
    public void setBackgroundColor(LoopView loopView, String str) {
        if (loopView != null) {
            loopView.setBackgroundColor(convertColor(str));
        }
    }

    @ReactProp(name = "selectedItem")
    public void setSelectedItem(LoopView loopView, int i) {
        if (loopView != null) {
            loopView.setSelectedItem(i);
        }
    }

    @Override // com.wheelpicker.LoopListener
    public void onItemSelect(LoopView loopView, int i) {
        if (this.wheelPicker != null) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt(ViewProps.POSITION, i);
            ((RCTEventEmitter) ((ReactContext) this.wheelPicker.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(loopView.getId(), "topChange", writableMapCreateMap);
        }
    }

    private int convertColor(String str) {
        if (!str.startsWith("rgb")) {
            return Color.parseColor(str);
        }
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.length() - 1).split(",");
        return Color.argb((int) ((strArrSplit.length > 3 ? Double.parseDouble(strArrSplit[3].trim()) : 1.0d) * 255.0d), Integer.parseInt(strArrSplit[0].trim()), Integer.parseInt(strArrSplit[1].trim()), Integer.parseInt(strArrSplit[2].trim()));
    }
}
