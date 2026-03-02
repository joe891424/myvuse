package no.nordicsemi.android.dfu.internal.scanner;

import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public final class BootloaderScannerFactory {
    private static final int ADDRESS_DIFF = 1;

    private BootloaderScannerFactory() {
    }

    public static String getIncrementedAddress(final String deviceAddress) {
        return deviceAddress.substring(0, 15) + String.format(Locale.US, "%02X", Integer.valueOf((Integer.valueOf(deviceAddress.substring(15), 16).intValue() + 1) & 255));
    }

    public static BootloaderScanner getScanner(final String deviceAddress) {
        return new BootloaderScannerLollipop(deviceAddress, getIncrementedAddress(deviceAddress));
    }
}
