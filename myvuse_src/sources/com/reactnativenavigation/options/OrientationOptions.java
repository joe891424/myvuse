package com.reactnativenavigation.options;

import com.brentvatne.react.ReactVideoView;
import com.facebook.hermes.intl.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class OrientationOptions {
    List<Orientation> orientations = new ArrayList();

    public static OrientationOptions parse(JSONObject jSONObject) {
        OrientationOptions orientationOptions = new OrientationOptions();
        if (jSONObject == null) {
            return orientationOptions;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ReactVideoView.EVENT_PROP_ORIENTATION);
        if (jSONArrayOptJSONArray == null) {
            orientationOptions.orientations.add(Orientation.fromString(jSONObject.optString(ReactVideoView.EVENT_PROP_ORIENTATION, Orientation.Default.name)));
        } else {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                Orientation orientationFromString = Orientation.fromString(jSONArrayOptJSONArray.optString(i, Constants.COLLATION_DEFAULT));
                if (orientationFromString != null) {
                    arrayList.add(orientationFromString);
                }
            }
            orientationOptions.orientations = arrayList;
        }
        return orientationOptions;
    }

    public int getValue() {
        if (!hasValue()) {
            return Orientation.Default.orientationCode;
        }
        int i = C39701.$SwitchMap$com$reactnativenavigation$options$Orientation[this.orientations.get(0).ordinal()];
        if (i == 1) {
            return (this.orientations.contains(Orientation.Portrait) ? Orientation.PortraitLandscape : Orientation.Landscape).orientationCode;
        }
        if (i == 2) {
            return (this.orientations.contains(Orientation.Landscape) ? Orientation.PortraitLandscape : Orientation.Portrait).orientationCode;
        }
        if (i == 3) {
            return Orientation.SensorLandscape.orientationCode;
        }
        if (i == 4) {
            return Orientation.SensorPortrait.orientationCode;
        }
        return Orientation.Default.orientationCode;
    }

    /* JADX INFO: renamed from: com.reactnativenavigation.options.OrientationOptions$1 */
    static /* synthetic */ class C39701 {
        static final /* synthetic */ int[] $SwitchMap$com$reactnativenavigation$options$Orientation;

        static {
            int[] iArr = new int[Orientation.values().length];
            $SwitchMap$com$reactnativenavigation$options$Orientation = iArr;
            try {
                iArr[Orientation.Landscape.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$Orientation[Orientation.Portrait.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$Orientation[Orientation.SensorLandscape.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$Orientation[Orientation.SensorPortrait.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$Orientation[Orientation.Default.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public boolean hasValue() {
        if (this.orientations.isEmpty()) {
            return false;
        }
        return (this.orientations.size() == 1 && this.orientations.get(0) == Orientation.Default) ? false : true;
    }

    public OrientationOptions copy() {
        OrientationOptions orientationOptions = new OrientationOptions();
        orientationOptions.orientations = new ArrayList(this.orientations);
        return orientationOptions;
    }

    public OrientationOptions mergeWithDefault(OrientationOptions orientationOptions) {
        if (!hasValue()) {
            this.orientations = orientationOptions.orientations;
        }
        return this;
    }

    public String toString() {
        return hasValue() ? Arrays.toString(this.orientations.toArray(new Orientation[0])) : Orientation.Default.toString();
    }
}
