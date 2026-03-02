package com.reactnativenavigation.options;

import com.facebook.hermes.intl.Constants;

/* JADX INFO: loaded from: classes6.dex */
public enum Orientation {
    Default(Constants.COLLATION_DEFAULT, -1),
    Landscape("landscape", 0),
    Portrait("portrait", 1),
    PortraitLandscape("sensor", 2),
    SensorLandscape("sensorLandscape", 6),
    SensorPortrait("sensorPortrait", 7);

    public String name;
    public int orientationCode;

    Orientation(String str, int i) {
        this.name = str;
        this.orientationCode = i;
    }

    public static Orientation fromString(String str) {
        for (Orientation orientation : values()) {
            if (orientation.name.equals(str)) {
                return orientation;
            }
        }
        return null;
    }
}
