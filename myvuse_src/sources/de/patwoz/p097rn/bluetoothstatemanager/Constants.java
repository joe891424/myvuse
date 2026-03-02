package de.patwoz.p097rn.bluetoothstatemanager;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class Constants {

    @Retention(RetentionPolicy.SOURCE)
    @interface BluetoothState {
        public static final String POWERED_OFF = "PoweredOff";
        public static final String POWERED_ON = "PoweredOn";
        public static final String RESETTING = "Resetting";
        public static final String UNAUTHORIZED = "Unauthorized";
        public static final String UNKNOWN = "Unknown";
        public static final String UNSUPPORTED = "Unsupported";
    }
}
