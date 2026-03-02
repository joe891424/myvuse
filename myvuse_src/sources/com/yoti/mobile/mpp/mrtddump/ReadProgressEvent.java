package com.yoti.mobile.mpp.mrtddump;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/ReadProgressEvent;", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderEvent;", "progressPercentage", "", "(I)V", "getProgressPercentage", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ReadProgressEvent extends MrtdReaderEvent {
    private final int progressPercentage;

    public ReadProgressEvent(int i) {
        super(null);
        this.progressPercentage = i;
    }

    public static /* synthetic */ ReadProgressEvent copy$default(ReadProgressEvent readProgressEvent, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = readProgressEvent.progressPercentage;
        }
        return readProgressEvent.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getProgressPercentage() {
        return this.progressPercentage;
    }

    public final ReadProgressEvent copy(int progressPercentage) {
        return new ReadProgressEvent(progressPercentage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ReadProgressEvent) && this.progressPercentage == ((ReadProgressEvent) other).progressPercentage;
    }

    public final int getProgressPercentage() {
        return this.progressPercentage;
    }

    public int hashCode() {
        return Integer.hashCode(this.progressPercentage);
    }

    public String toString() {
        return "ReadProgressEvent(progressPercentage=" + this.progressPercentage + ')';
    }
}
