package com.bat.sdk.asav.core;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IAsavBuckets.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J#\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u0002H\u0014H\u0016¢\u0006\u0002\u0010\u0015R'\u0010\t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\n¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, m5598d2 = {"Lcom/bat/sdk/asav/core/UByteInputBucket;", "Lcom/bat/sdk/asav/core/IAsavInputBucket;", "size", "", FirebaseAnalytics.Param.INDEX, "data", "Lkotlin/UByteArray;", "<init>", "(II[BLkotlin/jvm/internal/DefaultConstructorMarker;)V", "bucket", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getBucket", "()Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "isFull", "", "isEmpty", "add", "", ExifInterface.GPS_DIRECTION_TRUE, "(ILjava/lang/Object;)V", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class UByteInputBucket implements IAsavInputBucket {
    private static final String TAG = "UByteInputBucket";
    private final ArrayList<UByteArray> bucket;

    public /* synthetic */ UByteInputBucket(int i, int i2, byte[] bArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, bArr);
    }

    private UByteInputBucket(int i, int i2, byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.bucket = new ArrayList<>(ArraysKt.toMutableList(new UByteArray[i]));
        add(i2, UByteArray.m7302boximpl(data));
    }

    public final ArrayList<UByteArray> getBucket() {
        return this.bucket;
    }

    @Override // com.bat.sdk.asav.core.IAsavInputBucket
    public boolean isFull() {
        ArrayList<UByteArray> arrayList = this.bucket;
        boolean z = true;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                UByteArray uByteArray = (UByteArray) it2.next();
                if ((uByteArray != null ? uByteArray.getStorage() : null) == null) {
                    z = false;
                    break;
                }
            }
        }
        AsavLogKt.getLogger().console(TAG, "bucket " + this.bucket + " is full? " + z + SafeJsonPrimitive.NULL_CHAR);
        return z;
    }

    @Override // com.bat.sdk.asav.core.IAsavInputBucket
    public boolean isEmpty() {
        ArrayList<UByteArray> arrayList = this.bucket;
        boolean z = true;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                UByteArray uByteArray = (UByteArray) it2.next();
                if ((uByteArray != null ? uByteArray.getStorage() : null) != null) {
                    z = false;
                    break;
                }
            }
        }
        AsavLogKt.getLogger().console(TAG, "bucket " + this.bucket + " is empty? " + z + SafeJsonPrimitive.NULL_CHAR);
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bat.sdk.asav.core.IAsavInputBucket
    public <T> void add(int index, T data) {
        ArrayList<UByteArray> arrayList = this.bucket;
        byte[] storage = data instanceof UByteArray ? ((UByteArray) data).getStorage() : null;
        arrayList.set(index, storage != null ? UByteArray.m7302boximpl(storage) : null);
        AsavLogKt.getLogger().console(TAG, "data as UByteArray " + data + " added to bucket " + this.bucket + SafeJsonPrimitive.NULL_CHAR);
    }
}
