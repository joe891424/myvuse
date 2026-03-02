package no.nordicsemi.android.dfu;

/* JADX INFO: loaded from: classes6.dex */
public class DfuProgressListenerAdapter implements DfuProgressListener {
    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDeviceConnected(final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDeviceConnecting(final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDeviceDisconnected(final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDeviceDisconnecting(final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDfuAborted(final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDfuCompleted(final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDfuProcessStarted(final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDfuProcessStarting(final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onEnablingDfuMode(final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onError(final String deviceAddress, final int error, final int errorType, final String message) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onFirmwareValidating(final String deviceAddress) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onProgressChanged(final String deviceAddress, final int percent, final float speed, final float avgSpeed, final int currentPart, final int partsTotal) {
    }
}
