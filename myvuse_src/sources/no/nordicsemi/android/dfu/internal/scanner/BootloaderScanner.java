package no.nordicsemi.android.dfu.internal.scanner;

import no.nordicsemi.android.dfu.DfuDeviceSelector;

/* JADX INFO: loaded from: classes6.dex */
public interface BootloaderScanner {
    String searchUsing(final DfuDeviceSelector selector, final long timeout);
}
