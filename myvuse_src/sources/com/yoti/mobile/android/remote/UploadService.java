package com.yoti.mobile.android.remote;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: UploadService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0004¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/UploadService;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/remote/FlowableService;", "", "()V", "calculateUploadProgress", "bytesWritten", "", "contentLength", RemoteDefsKt.PATH_PAGE_INDEX_KEY, "", "numberOfPages", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class UploadService<T> extends FlowableService<Double, T> {
    protected final double calculateUploadProgress(long bytesWritten, long contentLength, int pageIndex, int numberOfPages) {
        return (((bytesWritten * 1.0d) / contentLength) + ((double) pageIndex)) / ((double) numberOfPages);
    }
}
