package com.bat.sdk.model;

import com.bat.sdk.presentation.ConversionExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: compiled from: PuffRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0013\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, m5598d2 = {"Lcom/bat/sdk/model/PuffRequest;", "", "bytes", "", "<init>", "([B)V", "getBytes", "()[B", "Dummy", "Clear", "Empty", "Lcom/bat/sdk/model/PuffRequest$Clear;", "Lcom/bat/sdk/model/PuffRequest$Dummy;", "Lcom/bat/sdk/model/PuffRequest$Empty;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class PuffRequest {
    private final byte[] bytes;

    public /* synthetic */ PuffRequest(byte[] bArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr);
    }

    private PuffRequest(byte[] bArr) {
        this.bytes = bArr;
    }

    public /* synthetic */ PuffRequest(byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new byte[0] : bArr, null);
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    /* JADX INFO: compiled from: PuffRequest.kt */
    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m5598d2 = {"Lcom/bat/sdk/model/PuffRequest$Dummy;", "Lcom/bat/sdk/model/PuffRequest;", NewHtcHomeBadger.COUNT, "", "<init>", "(I)V", "getCount", "()I", "bytes", "", "getBytes", "()[B", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Dummy extends PuffRequest {
        private final byte[] bytes;
        private final int count;

        public final int getCount() {
            return this.count;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Dummy(int i) {
            super(null, 1, 0 == true ? 1 : 0);
            this.count = i;
            this.bytes = ConversionExtensionsKt.toByteArrayBigEndian(RangesKt.coerceIn(i, 0, 4095));
        }

        @Override // com.bat.sdk.model.PuffRequest
        public byte[] getBytes() {
            return this.bytes;
        }
    }

    /* JADX INFO: compiled from: PuffRequest.kt */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/model/PuffRequest$Clear;", "Lcom/bat/sdk/model/PuffRequest;", "<init>", "()V", "bytes", "", "getBytes", "()[B", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Clear extends PuffRequest {
        private final byte[] bytes;

        /* JADX WARN: Multi-variable type inference failed */
        public Clear() {
            super(null, 1, 0 == true ? 1 : 0);
            this.bytes = ConversionExtensionsKt.toByteArrayBigEndian$default(4294967293L, 0, 1, null);
        }

        @Override // com.bat.sdk.model.PuffRequest
        public byte[] getBytes() {
            return this.bytes;
        }
    }

    /* JADX INFO: compiled from: PuffRequest.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/PuffRequest$Empty;", "Lcom/bat/sdk/model/PuffRequest;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Empty extends PuffRequest {
        public static final Empty INSTANCE = new Empty();

        /* JADX WARN: Multi-variable type inference failed */
        private Empty() {
            super(null, 1, 0 == true ? 1 : 0);
        }
    }
}
