package no.nordicsemi.android.dfu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerFactory;
import no.nordicsemi.android.error.GattError;

/* JADX INFO: loaded from: classes6.dex */
public class DfuServiceListenerHelper {
    private static LogBroadcastReceiver mLogBroadcastReceiver;
    private static ProgressBroadcastsReceiver mProgressBroadcastReceiver;

    private static class LogBroadcastReceiver extends BroadcastReceiver {
        private DfuLogListener mGlobalLogListener;
        private final Map<String, DfuLogListener> mListeners;

        private LogBroadcastReceiver() {
            this.mListeners = new HashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLogListener(final DfuLogListener globalLogListener) {
            this.mGlobalLogListener = globalLogListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLogListener(final String deviceAddress, final DfuLogListener listener) {
            this.mListeners.put(deviceAddress, listener);
            this.mListeners.put(BootloaderScannerFactory.getIncrementedAddress(deviceAddress), listener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean removeLogListener(final DfuLogListener listener) {
            if (this.mGlobalLogListener == listener) {
                this.mGlobalLogListener = null;
            }
            Iterator<Map.Entry<String, DfuLogListener>> it2 = this.mListeners.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<String, DfuLogListener> next = it2.next();
                if (next.getValue() == listener) {
                    this.mListeners.remove(next.getKey());
                    break;
                }
            }
            Iterator<Map.Entry<String, DfuLogListener>> it3 = this.mListeners.entrySet().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Map.Entry<String, DfuLogListener> next2 = it3.next();
                if (next2.getValue() == listener) {
                    this.mListeners.remove(next2.getKey());
                    break;
                }
            }
            return this.mGlobalLogListener == null && this.mListeners.isEmpty();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, final Intent intent) {
            String stringExtra = intent.getStringExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS);
            DfuLogListener dfuLogListener = this.mGlobalLogListener;
            DfuLogListener dfuLogListener2 = this.mListeners.get(stringExtra);
            if (dfuLogListener == null && dfuLogListener2 == null) {
                return;
            }
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_LOG_LEVEL, 0);
            String stringExtra2 = intent.getStringExtra(DfuBaseService.EXTRA_LOG_MESSAGE);
            if (dfuLogListener != null) {
                dfuLogListener.onLogEvent(stringExtra, intExtra, stringExtra2);
            }
            if (dfuLogListener2 != null) {
                dfuLogListener2.onLogEvent(stringExtra, intExtra, stringExtra2);
            }
        }
    }

    private static class ProgressBroadcastsReceiver extends BroadcastReceiver {
        private DfuProgressListener mGlobalProgressListener;
        private final Map<String, DfuProgressListener> mListeners;

        private ProgressBroadcastsReceiver() {
            this.mListeners = new HashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProgressListener(final DfuProgressListener globalProgressListener) {
            this.mGlobalProgressListener = globalProgressListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProgressListener(final String deviceAddress, final DfuProgressListener listener) {
            this.mListeners.put(deviceAddress, listener);
            this.mListeners.put(BootloaderScannerFactory.getIncrementedAddress(deviceAddress), listener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean removeProgressListener(final DfuProgressListener listener) {
            if (this.mGlobalProgressListener == listener) {
                this.mGlobalProgressListener = null;
            }
            Iterator<Map.Entry<String, DfuProgressListener>> it2 = this.mListeners.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<String, DfuProgressListener> next = it2.next();
                if (next.getValue() == listener) {
                    this.mListeners.remove(next.getKey());
                    break;
                }
            }
            Iterator<Map.Entry<String, DfuProgressListener>> it3 = this.mListeners.entrySet().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Map.Entry<String, DfuProgressListener> next2 = it3.next();
                if (next2.getValue() == listener) {
                    this.mListeners.remove(next2.getKey());
                    break;
                }
            }
            return this.mGlobalProgressListener == null && this.mListeners.isEmpty();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, final Intent intent) {
            String action;
            String stringExtra = intent.getStringExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS);
            if (stringExtra == null) {
            }
            DfuProgressListener dfuProgressListener = this.mGlobalProgressListener;
            DfuProgressListener dfuProgressListener2 = this.mListeners.get(stringExtra);
            if ((dfuProgressListener == null && dfuProgressListener2 == null) || (action = intent.getAction()) == null) {
                return;
            }
            action.hashCode();
            if (!action.equals(DfuBaseService.BROADCAST_PROGRESS)) {
                if (action.equals(DfuBaseService.BROADCAST_ERROR)) {
                    int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_DATA, 0);
                    int intExtra2 = intent.getIntExtra(DfuBaseService.EXTRA_ERROR_TYPE, 0);
                    if (dfuProgressListener != null) {
                        dfuProgressListener.onDeviceDisconnected(stringExtra);
                    }
                    if (dfuProgressListener2 != null) {
                        dfuProgressListener2.onDeviceDisconnected(stringExtra);
                    }
                    if (intExtra2 == 1) {
                        if (dfuProgressListener != null) {
                            dfuProgressListener.onError(stringExtra, intExtra, intExtra2, GattError.parseConnectionError(intExtra));
                        }
                        if (dfuProgressListener2 != null) {
                            dfuProgressListener2.onError(stringExtra, intExtra, intExtra2, GattError.parseConnectionError(intExtra));
                            return;
                        }
                        return;
                    }
                    if (intExtra2 != 3) {
                        if (dfuProgressListener != null) {
                            dfuProgressListener.onError(stringExtra, intExtra, intExtra2, GattError.parse(intExtra));
                        }
                        if (dfuProgressListener2 != null) {
                            dfuProgressListener2.onError(stringExtra, intExtra, intExtra2, GattError.parse(intExtra));
                            return;
                        }
                        return;
                    }
                    if (dfuProgressListener != null) {
                        dfuProgressListener.onError(stringExtra, intExtra, intExtra2, GattError.parseDfuRemoteError(intExtra));
                    }
                    if (dfuProgressListener2 != null) {
                        dfuProgressListener2.onError(stringExtra, intExtra, intExtra2, GattError.parseDfuRemoteError(intExtra));
                        return;
                    }
                    return;
                }
                return;
            }
            int intExtra3 = intent.getIntExtra(DfuBaseService.EXTRA_DATA, 0);
            float floatExtra = intent.getFloatExtra(DfuBaseService.EXTRA_SPEED_B_PER_MS, 0.0f);
            float floatExtra2 = intent.getFloatExtra(DfuBaseService.EXTRA_AVG_SPEED_B_PER_MS, 0.0f);
            int intExtra4 = intent.getIntExtra(DfuBaseService.EXTRA_PART_CURRENT, 0);
            int intExtra5 = intent.getIntExtra(DfuBaseService.EXTRA_PARTS_TOTAL, 0);
            switch (intExtra3) {
                case DfuBaseService.PROGRESS_ABORTED /* -7 */:
                    if (dfuProgressListener != null) {
                        dfuProgressListener.onDeviceDisconnected(stringExtra);
                        dfuProgressListener.onDfuAborted(stringExtra);
                    }
                    if (dfuProgressListener2 != null) {
                        dfuProgressListener2.onDeviceDisconnected(stringExtra);
                        dfuProgressListener2.onDfuAborted(stringExtra);
                    }
                    break;
                case DfuBaseService.PROGRESS_COMPLETED /* -6 */:
                    if (dfuProgressListener != null) {
                        dfuProgressListener.onDeviceDisconnected(stringExtra);
                        dfuProgressListener.onDfuCompleted(stringExtra);
                    }
                    if (dfuProgressListener2 != null) {
                        dfuProgressListener2.onDeviceDisconnected(stringExtra);
                        dfuProgressListener2.onDfuCompleted(stringExtra);
                    }
                    break;
                case DfuBaseService.PROGRESS_DISCONNECTING /* -5 */:
                    if (dfuProgressListener != null) {
                        dfuProgressListener.onDeviceDisconnecting(stringExtra);
                    }
                    if (dfuProgressListener2 != null) {
                        dfuProgressListener2.onDeviceDisconnecting(stringExtra);
                    }
                    break;
                case -4:
                    if (dfuProgressListener != null) {
                        dfuProgressListener.onFirmwareValidating(stringExtra);
                    }
                    if (dfuProgressListener2 != null) {
                        dfuProgressListener2.onFirmwareValidating(stringExtra);
                    }
                    break;
                case -3:
                    if (dfuProgressListener != null) {
                        dfuProgressListener.onEnablingDfuMode(stringExtra);
                    }
                    if (dfuProgressListener2 != null) {
                        dfuProgressListener2.onEnablingDfuMode(stringExtra);
                    }
                    break;
                case -2:
                    if (dfuProgressListener != null) {
                        dfuProgressListener.onDeviceConnected(stringExtra);
                        dfuProgressListener.onDfuProcessStarting(stringExtra);
                    }
                    if (dfuProgressListener2 != null) {
                        dfuProgressListener2.onDeviceConnected(stringExtra);
                        dfuProgressListener2.onDfuProcessStarting(stringExtra);
                    }
                    break;
                case -1:
                    if (dfuProgressListener != null) {
                        dfuProgressListener.onDeviceConnecting(stringExtra);
                    }
                    if (dfuProgressListener2 != null) {
                        dfuProgressListener2.onDeviceConnecting(stringExtra);
                    }
                    break;
                default:
                    if (intExtra3 == 0) {
                        if (dfuProgressListener != null) {
                            dfuProgressListener.onDfuProcessStarted(stringExtra);
                        }
                        if (dfuProgressListener2 != null) {
                            dfuProgressListener2.onDfuProcessStarted(stringExtra);
                        }
                    }
                    if (dfuProgressListener != null) {
                        dfuProgressListener.onProgressChanged(stringExtra, intExtra3, floatExtra, floatExtra2, intExtra4, intExtra5);
                    }
                    if (dfuProgressListener2 != null) {
                        dfuProgressListener2.onProgressChanged(stringExtra, intExtra3, floatExtra, floatExtra2, intExtra4, intExtra5);
                    }
                    break;
            }
        }
    }

    public static void registerProgressListener(final Context context, final DfuProgressListener listener) {
        if (mProgressBroadcastReceiver == null) {
            mProgressBroadcastReceiver = new ProgressBroadcastsReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(DfuBaseService.BROADCAST_PROGRESS);
            intentFilter.addAction(DfuBaseService.BROADCAST_ERROR);
            LocalBroadcastManager.getInstance(context).registerReceiver(mProgressBroadcastReceiver, intentFilter);
        }
        mProgressBroadcastReceiver.setProgressListener(listener);
    }

    public static void registerProgressListener(final Context context, final DfuProgressListener listener, final String deviceAddress) {
        if (mProgressBroadcastReceiver == null) {
            mProgressBroadcastReceiver = new ProgressBroadcastsReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(DfuBaseService.BROADCAST_PROGRESS);
            intentFilter.addAction(DfuBaseService.BROADCAST_ERROR);
            LocalBroadcastManager.getInstance(context).registerReceiver(mProgressBroadcastReceiver, intentFilter);
        }
        mProgressBroadcastReceiver.setProgressListener(deviceAddress, listener);
    }

    public static void unregisterProgressListener(final Context context, final DfuProgressListener listener) {
        ProgressBroadcastsReceiver progressBroadcastsReceiver = mProgressBroadcastReceiver;
        if (progressBroadcastsReceiver == null || !progressBroadcastsReceiver.removeProgressListener(listener)) {
            return;
        }
        LocalBroadcastManager.getInstance(context).unregisterReceiver(mProgressBroadcastReceiver);
        mProgressBroadcastReceiver = null;
    }

    public static void registerLogListener(final Context context, final DfuLogListener listener) {
        if (mLogBroadcastReceiver == null) {
            mLogBroadcastReceiver = new LogBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(DfuBaseService.BROADCAST_LOG);
            LocalBroadcastManager.getInstance(context).registerReceiver(mLogBroadcastReceiver, intentFilter);
        }
        mLogBroadcastReceiver.setLogListener(listener);
    }

    public static void registerLogListener(final Context context, final DfuLogListener listener, final String deviceAddress) {
        if (mLogBroadcastReceiver == null) {
            mLogBroadcastReceiver = new LogBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(DfuBaseService.BROADCAST_LOG);
            LocalBroadcastManager.getInstance(context).registerReceiver(mLogBroadcastReceiver, intentFilter);
        }
        mLogBroadcastReceiver.setLogListener(deviceAddress, listener);
    }

    public static void unregisterLogListener(final Context context, final DfuLogListener listener) {
        LogBroadcastReceiver logBroadcastReceiver = mLogBroadcastReceiver;
        if (logBroadcastReceiver == null || !logBroadcastReceiver.removeLogListener(listener)) {
            return;
        }
        LocalBroadcastManager.getInstance(context).unregisterReceiver(mLogBroadcastReceiver);
        mLogBroadcastReceiver = null;
    }
}
