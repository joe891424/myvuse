package com.bat.sdk.asav.core;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: IAsavBuckets.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J#\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u0002H\u0007H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m5598d2 = {"Lcom/bat/sdk/asav/core/IAsavInputBucket;", "", "isFull", "", "isEmpty", "add", "", ExifInterface.GPS_DIRECTION_TRUE, FirebaseAnalytics.Param.INDEX, "", "data", "(ILjava/lang/Object;)V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface IAsavInputBucket {
    <T> void add(int index, T data);

    boolean isEmpty();

    boolean isFull();
}
