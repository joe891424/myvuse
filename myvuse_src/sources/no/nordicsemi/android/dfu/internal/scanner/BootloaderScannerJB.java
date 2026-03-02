package no.nordicsemi.android.dfu.internal.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.dfu.DfuDeviceSelector;

/* JADX INFO: loaded from: classes6.dex */
public class BootloaderScannerJB implements BootloaderScanner, BluetoothAdapter.LeScanCallback {
    private String mBootloaderAddress;
    private final String mDeviceAddress;
    private final String mDeviceAddressIncremented;
    private boolean mFound;
    private final Object mLock = new Object();
    private DfuDeviceSelector mSelector;

    BootloaderScannerJB(final String deviceAddress, final String deviceAddressIncremented) {
        this.mDeviceAddress = deviceAddress;
        this.mDeviceAddressIncremented = deviceAddressIncremented;
    }

    @Override // no.nordicsemi.android.dfu.internal.scanner.BootloaderScanner
    public String searchUsing(DfuDeviceSelector selector, final long timeout) {
        this.mSelector = selector;
        this.mBootloaderAddress = null;
        this.mFound = false;
        new Thread(new Runnable() { // from class: no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerJB$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5624xbd243e49(timeout);
            }
        }, "Scanner timer").start();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.getState() != 12) {
            return null;
        }
        defaultAdapter.startLeScan(this);
        try {
            synchronized (this.mLock) {
                while (!this.mFound) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException unused) {
        }
        defaultAdapter.stopLeScan(this);
        return this.mBootloaderAddress;
    }

    /* JADX INFO: renamed from: lambda$searchUsing$0$no-nordicsemi-android-dfu-internal-scanner-BootloaderScannerJB */
    /* synthetic */ void m5624xbd243e49(long j) {
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

    @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
    public void onLeScan(final BluetoothDevice device, final int rssi, final byte[] scanRecord) {
        String address = device.getAddress();
        if (this.mFound || !this.mSelector.matches(device, rssi, scanRecord, this.mDeviceAddress, this.mDeviceAddressIncremented)) {
            return;
        }
        this.mBootloaderAddress = address;
        this.mFound = true;
        synchronized (this.mLock) {
            this.mLock.notifyAll();
        }
    }
}
