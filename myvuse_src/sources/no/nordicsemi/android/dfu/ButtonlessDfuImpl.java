package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import androidx.work.Data;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.Locale;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.error.SecureDfuError;

/* JADX INFO: loaded from: classes6.dex */
abstract class ButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    private static final int DFU_STATUS_SUCCESS = 1;
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1};
    private static final int OP_CODE_ENTER_BOOTLOADER_KEY = 1;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 32;

    protected abstract BluetoothGattCharacteristic getButtonlessDfuCharacteristic();

    protected abstract int getResponseType();

    protected abstract boolean shouldScanForBootloader();

    ButtonlessDfuImpl(final Intent intent, final DfuBaseService service) {
        super(intent, service);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(final Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        byte[] notificationResponse;
        this.mProgressInfo.setProgress(-2);
        LogInstrumentation.m2730i("ButtonlessDfu", "performing ButtonlessDfu");
        BluetoothGatt bluetoothGatt = this.mGatt;
        this.mService.sendLogBroadcast(15, "Application with buttonless update found");
        this.mService.sendLogBroadcast(1, "Jumping to the DFU Bootloader...");
        BluetoothGattCharacteristic buttonlessDfuCharacteristic = getButtonlessDfuCharacteristic();
        int responseType = getResponseType();
        enableCCCD(buttonlessDfuCharacteristic, getResponseType());
        this.mService.sendLogBroadcast(10, (responseType == 2 ? "Indications" : "Notifications").concat(" enabled"));
        try {
            this.mProgressInfo.setProgress(-3);
            logi("Sending Enter Bootloader (Op Code = 1)");
            writeOpCode(buttonlessDfuCharacteristic, OP_CODE_ENTER_BOOTLOADER, true);
            this.mService.sendLogBroadcast(10, "Enter bootloader sent (Op Code = 1)");
            try {
                notificationResponse = readNotificationResponse();
            } catch (DeviceDisconnectedException unused) {
                notificationResponse = this.mReceivedData;
            }
            if (notificationResponse != null) {
                int statusCode = getStatusCode(notificationResponse, 1);
                logi("Response received (Op Code = " + ((int) notificationResponse[1]) + ", Status = " + statusCode + ")");
                this.mService.sendLogBroadcast(10, "Response received (Op Code = " + ((int) notificationResponse[1]) + ", Status = " + statusCode + ")");
                if (statusCode != 1) {
                    throw new RemoteDfuException("Device returned error after sending Enter Bootloader", statusCode);
                }
                if (shouldScanForBootloader()) {
                    this.mService.disconnect(bluetoothGatt);
                } else {
                    this.mService.waitUntilDisconnected();
                    LogInstrumentation.m2730i("ButtonlessDfu", "Device successfully disconnected");
                    this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
                }
                logi("Device disconnected");
            } else {
                logi("Device disconnected before receiving notification");
            }
            finalize(intent, false, shouldScanForBootloader());
        } catch (RemoteDfuException e) {
            int errorNumber = e.getErrorNumber();
            loge(e.getMessage());
            this.mService.sendLogBroadcast(20, String.format(Locale.US, "Remote DFU error: %s", SecureDfuError.parseButtonlessError(errorNumber | 2048)));
            this.mService.terminateConnection(bluetoothGatt, errorNumber | Data.MAX_DATA_BYTES);
        } catch (UnknownResponseException e2) {
            loge(e2.getMessage());
            this.mService.sendLogBroadcast(20, e2.getMessage());
            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_INVALID_RESPONSE);
        }
    }

    private int getStatusCode(final byte[] response, final int request) throws UnknownResponseException {
        byte b;
        if (response != null && response.length >= 3 && response[0] == 32 && response[1] == request && ((b = response[2]) == 1 || b == 2 || b == 4)) {
            return b;
        }
        throw new UnknownResponseException("Invalid response received", response, 32, request);
    }
}
