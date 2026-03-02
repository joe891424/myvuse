package no.nordicsemi.android.dfu;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes6.dex */
class DfuProgressInfo {
    private int bytesReceived;
    private int bytesSent;
    private int currentPart;
    private int imageSizeInBytes;
    private int initialBytesSent;
    private int lastBytesSent;
    private long lastProgressTime;
    private final ProgressListener mListener;
    private int maxObjectSizeInBytes;
    private int progress;
    private long timeStart;
    private int totalParts;

    interface ProgressListener {
        void updateProgressNotification();
    }

    DfuProgressInfo(final ProgressListener listener) {
        this.mListener = listener;
    }

    void init(final int imageSizeInBytes, final int currentPart, final int totalParts) {
        this.imageSizeInBytes = imageSizeInBytes;
        this.maxObjectSizeInBytes = Integer.MAX_VALUE;
        this.currentPart = currentPart;
        this.totalParts = totalParts;
    }

    DfuProgressInfo setTotalPart(final int totalParts) {
        this.totalParts = totalParts;
        return this;
    }

    void setProgress(final int progress) {
        this.progress = progress;
        this.mListener.updateProgressNotification();
    }

    void setBytesSent(final int bytesSent) {
        if (this.timeStart == 0) {
            this.timeStart = SystemClock.elapsedRealtime();
            this.initialBytesSent = bytesSent;
        }
        this.bytesSent = bytesSent;
        this.progress = (int) ((bytesSent * 100.0f) / this.imageSizeInBytes);
        this.mListener.updateProgressNotification();
    }

    void addBytesSent(final int increment) {
        setBytesSent(this.bytesSent + increment);
    }

    void setBytesReceived(final int bytesReceived) {
        this.bytesReceived = bytesReceived;
    }

    void setMaxObjectSizeInBytes(final int bytes) {
        this.maxObjectSizeInBytes = bytes;
    }

    boolean isComplete() {
        return this.bytesSent == this.imageSizeInBytes;
    }

    boolean isObjectComplete() {
        return this.bytesSent % this.maxObjectSizeInBytes == 0;
    }

    int getAvailableObjectSizeIsBytes() {
        int i = this.imageSizeInBytes;
        int i2 = this.bytesSent;
        int i3 = this.maxObjectSizeInBytes;
        return Math.min(i - i2, i3 - (i2 % i3));
    }

    int getProgress() {
        return this.progress;
    }

    int getBytesSent() {
        return this.bytesSent;
    }

    int getBytesReceived() {
        return this.bytesReceived;
    }

    int getImageSizeInBytes() {
        return this.imageSizeInBytes;
    }

    float getSpeed() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        float f = jElapsedRealtime - this.timeStart != 0 ? (this.bytesSent - this.lastBytesSent) / (jElapsedRealtime - this.lastProgressTime) : 0.0f;
        this.lastProgressTime = jElapsedRealtime;
        this.lastBytesSent = this.bytesSent;
        return f;
    }

    float getAverageSpeed() {
        if (SystemClock.elapsedRealtime() - this.timeStart != 0) {
            return (this.bytesSent - this.initialBytesSent) / (r0 - r2);
        }
        return 0.0f;
    }

    int getCurrentPart() {
        return this.currentPart;
    }

    int getTotalParts() {
        return this.totalParts;
    }

    boolean isLastPart() {
        return this.currentPart == this.totalParts;
    }
}
