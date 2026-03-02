package com.bat.sdk.asav.core;

import com.bat.sdk.ble.helper.BatAdvertiserHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: compiled from: IAsavBuckets.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R'\u0010\t\u001a\u0016\u0012\u0006\b\u0001\u0012\u00020\u00070\u000bj\n\u0012\u0006\b\u0001\u0012\u00020\u0007`\n¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/asav/core/UByteOutputBucket;", "Lcom/bat/sdk/asav/core/IAsavOutputBucket;", "input", "", "<init>", "(Ljava/lang/String;)V", "byteArray", "Lkotlin/UByteArray;", "([BLkotlin/jvm/internal/DefaultConstructorMarker;)V", "bucket", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getBucket", "()Ljava/util/ArrayList;", "Ljava/util/ArrayList;", NewHtcHomeBadger.COUNT, "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class UByteOutputBucket implements IAsavOutputBucket {
    private final ArrayList<? extends UByteArray> bucket;

    public /* synthetic */ UByteOutputBucket(byte[] bArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr);
    }

    public final ArrayList<? extends UByteArray> getBucket() {
        return this.bucket;
    }

    public UByteOutputBucket(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.bucket = new BatAdvertiserHelper(null, 1, null).convertData(input);
    }

    private UByteOutputBucket(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        this.bucket = CollectionsKt.arrayListOf(UByteArray.m7302boximpl(byteArray));
    }

    @Override // com.bat.sdk.asav.core.IAsavOutputBucket
    public int count() {
        return this.bucket.size();
    }
}
