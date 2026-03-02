package no.nordicsemi.android.dfu.internal.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuDeviceSelector;

/* JADX INFO: loaded from: classes6.dex */
class BootloaderScannerLollipop extends ScanCallback implements BootloaderScanner {
    private String mBootloaderAddress;
    private final String mDeviceAddress;
    private final String mDeviceAddressIncremented;
    private boolean mFound;
    private final Object mLock = new Object();
    private DfuDeviceSelector mSelector;

    BootloaderScannerLollipop(final String deviceAddress, final String deviceAddressIncremented) {
        this.mDeviceAddress = deviceAddress;
        this.mDeviceAddressIncremented = deviceAddressIncremented;
    }

    @Override // no.nordicsemi.android.dfu.internal.scanner.BootloaderScanner
    public String searchUsing(DfuDeviceSelector selector, final long timeout) {
        BluetoothLeScanner bluetoothLeScanner;
        this.mSelector = selector;
        this.mBootloaderAddress = null;
        this.mFound = false;
        new Thread(new Runnable() { // from class: no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerLollipop$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5625x4ce227c(timeout);
            }
        }, "Scanner timer").start();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.getState() != 12 || (bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner()) == null) {
            return null;
        }
        ScanSettings scanSettingsBuild = new ScanSettings.Builder().setScanMode(2).build();
        if (defaultAdapter.isOffloadedFilteringSupported() && Build.VERSION.SDK_INT >= 27) {
            bluetoothLeScanner.startScan(new ArrayList(), scanSettingsBuild, this);
        } else {
            bluetoothLeScanner.startScan((List<ScanFilter>) null, scanSettingsBuild, this);
        }
        try {
            synchronized (this.mLock) {
                while (!this.mFound) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException unused) {
        }
        bluetoothLeScanner.stopScan(this);
        return this.mBootloaderAddress;
    }

    /* JADX INFO: renamed from: lambda$searchUsing$0$no-nordicsemi-android-dfu-internal-scanner-BootloaderScannerLollipop */
    /* synthetic */ void m5625x4ce227c(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
        if (this.mFound) {
            return;
        }
        this.mBootloaderAddress = null;
        this.mFound = true;
        synchronized (this.mLock) {
            this.mLock.notifyAll();
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanResult(final int callbackType, final ScanResult result) {
        String address = result.getDevice().getAddress();
        if (this.mFound || !this.mSelector.matches(result.getDevice(), result.getRssi(), result.getScanRecord().getBytes(), this.mDeviceAddress, this.mDeviceAddressIncremented)) {
            return;
        }
        this.mBootloaderAddress = address;
        this.mFound = true;
        synchronized (this.mLock) {
            this.mLock.notifyAll();
        }
    }
}
