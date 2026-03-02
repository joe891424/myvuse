package no.nordicsemi.android.dfu;

/* JADX INFO: loaded from: classes6.dex */
public interface DfuLogListener {
    void onLogEvent(final String deviceAddress, final int level, final String message);
}
