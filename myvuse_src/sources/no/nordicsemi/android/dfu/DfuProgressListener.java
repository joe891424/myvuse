package no.nordicsemi.android.dfu;

/* JADX INFO: loaded from: classes6.dex */
public interface DfuProgressListener {
    void onDeviceConnected(final String deviceAddress);

    void onDeviceConnecting(final String deviceAddress);

    void onDeviceDisconnected(final String deviceAddress);

    void onDeviceDisconnecting(final String deviceAddress);

    void onDfuAborted(final String deviceAddress);

    void onDfuCompleted(final String deviceAddress);

    void onDfuProcessStarted(final String deviceAddress);

    void onDfuProcessStarting(final String deviceAddress);

    void onEnablingDfuMode(final String deviceAddress);

    void onError(final String deviceAddress, final int error, final int errorType, final String message);

    void onFirmwareValidating(final String deviceAddress);

    void onProgressChanged(final String deviceAddress, final int percent, final float speed, final float avgSpeed, final int currentPart, final int partsTotal);
}
