package com.bat.sdk.payload;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PayloadUploadState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\b\t\n\u000b\f\rB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0006\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadUploadState;", "", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "Idle", "ReadingChallenge", "WaitingForPayload", "WaitingForStart", "WaitingForChunkAcceptance", "Finishing", "Lcom/bat/sdk/payload/PayloadUploadState$Finishing;", "Lcom/bat/sdk/payload/PayloadUploadState$Idle;", "Lcom/bat/sdk/payload/PayloadUploadState$ReadingChallenge;", "Lcom/bat/sdk/payload/PayloadUploadState$WaitingForChunkAcceptance;", "Lcom/bat/sdk/payload/PayloadUploadState$WaitingForPayload;", "Lcom/bat/sdk/payload/PayloadUploadState$WaitingForStart;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class PayloadUploadState {
    private final String deviceAddress;

    public /* synthetic */ PayloadUploadState(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private PayloadUploadState(String str) {
        this.deviceAddress = str;
    }

    public String getDeviceAddress() {
        return this.deviceAddress;
    }

    /* JADX INFO: compiled from: PayloadUploadState.kt */
    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadUploadState$Idle;", "Lcom/bat/sdk/payload/PayloadUploadState;", "deviceAddress", "", "lastResult", "Lcom/bat/sdk/payload/PayloadUploadResult;", "<init>", "(Ljava/lang/String;Lcom/bat/sdk/payload/PayloadUploadResult;)V", "getDeviceAddress", "()Ljava/lang/String;", "getLastResult", "()Lcom/bat/sdk/payload/PayloadUploadResult;", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Idle extends PayloadUploadState {
        private final String deviceAddress;
        private final PayloadUploadResult lastResult;

        public static /* synthetic */ Idle copy$default(Idle idle, String str, PayloadUploadResult payloadUploadResult, int i, Object obj) {
            if ((i & 1) != 0) {
                str = idle.deviceAddress;
            }
            if ((i & 2) != 0) {
                payloadUploadResult = idle.lastResult;
            }
            return idle.copy(str, payloadUploadResult);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PayloadUploadResult getLastResult() {
            return this.lastResult;
        }

        public final Idle copy(String deviceAddress, PayloadUploadResult lastResult) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new Idle(deviceAddress, lastResult);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Idle)) {
                return false;
            }
            Idle idle = (Idle) other;
            return Intrinsics.areEqual(this.deviceAddress, idle.deviceAddress) && Intrinsics.areEqual(this.lastResult, idle.lastResult);
        }

        public int hashCode() {
            int iHashCode = this.deviceAddress.hashCode() * 31;
            PayloadUploadResult payloadUploadResult = this.lastResult;
            return iHashCode + (payloadUploadResult == null ? 0 : payloadUploadResult.hashCode());
        }

        public /* synthetic */ Idle(String str, PayloadUploadResult payloadUploadResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : payloadUploadResult);
        }

        @Override // com.bat.sdk.payload.PayloadUploadState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final PayloadUploadResult getLastResult() {
            return this.lastResult;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Idle(String deviceAddress, PayloadUploadResult payloadUploadResult) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
            this.lastResult = payloadUploadResult;
        }

        public String toString() {
            return "idle. last resdult " + this.lastResult;
        }
    }

    /* JADX INFO: compiled from: PayloadUploadState.kt */
    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J.\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001d"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadUploadState$ReadingChallenge;", "Lcom/bat/sdk/payload/PayloadUploadState;", "deviceAddress", "", "payloadCode", "Lkotlin/UShort;", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "<init>", "(Ljava/lang/String;SLjava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDeviceAddress", "()Ljava/lang/String;", "getPayloadCode-Mh2AYeg", "()S", ExifInterface.LATITUDE_SOUTH, "getCountryCode", "toString", "component1", "component2", "component2-Mh2AYeg", "component3", "copy", "copy-qEOnv9Y", "(Ljava/lang/String;SLjava/lang/String;)Lcom/bat/sdk/payload/PayloadUploadState$ReadingChallenge;", "equals", "", "other", "", "hashCode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class ReadingChallenge extends PayloadUploadState {
        private final String countryCode;
        private final String deviceAddress;
        private final short payloadCode;

        public /* synthetic */ ReadingChallenge(String str, short s, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, s, str2);
        }

        /* JADX INFO: renamed from: copy-qEOnv9Y$default, reason: not valid java name */
        public static /* synthetic */ ReadingChallenge m5923copyqEOnv9Y$default(ReadingChallenge readingChallenge, String str, short s, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = readingChallenge.deviceAddress;
            }
            if ((i & 2) != 0) {
                s = readingChallenge.payloadCode;
            }
            if ((i & 4) != 0) {
                str2 = readingChallenge.countryCode;
            }
            return readingChallenge.m5925copyqEOnv9Y(str, s, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        /* JADX INFO: renamed from: component2-Mh2AYeg, reason: not valid java name and from getter */
        public final short getPayloadCode() {
            return this.payloadCode;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCountryCode() {
            return this.countryCode;
        }

        /* JADX INFO: renamed from: copy-qEOnv9Y, reason: not valid java name */
        public final ReadingChallenge m5925copyqEOnv9Y(String deviceAddress, short payloadCode, String countryCode) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(countryCode, "countryCode");
            return new ReadingChallenge(deviceAddress, payloadCode, countryCode, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReadingChallenge)) {
                return false;
            }
            ReadingChallenge readingChallenge = (ReadingChallenge) other;
            return Intrinsics.areEqual(this.deviceAddress, readingChallenge.deviceAddress) && this.payloadCode == readingChallenge.payloadCode && Intrinsics.areEqual(this.countryCode, readingChallenge.countryCode);
        }

        public int hashCode() {
            return (((this.deviceAddress.hashCode() * 31) + UShort.m7526hashCodeimpl(this.payloadCode)) * 31) + this.countryCode.hashCode();
        }

        @Override // com.bat.sdk.payload.PayloadUploadState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        /* JADX INFO: renamed from: getPayloadCode-Mh2AYeg, reason: not valid java name */
        public final short m5926getPayloadCodeMh2AYeg() {
            return this.payloadCode;
        }

        public final String getCountryCode() {
            return this.countryCode;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private ReadingChallenge(String deviceAddress, short s, String countryCode) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(countryCode, "countryCode");
            this.deviceAddress = deviceAddress;
            this.payloadCode = s;
            this.countryCode = countryCode;
        }

        public String toString() {
            return "reading challenge for " + ((Object) UShort.m7558toStringimpl(this.payloadCode)) + ", " + this.countryCode;
        }
    }

    /* JADX INFO: compiled from: PayloadUploadState.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadUploadState$WaitingForPayload;", "Lcom/bat/sdk/payload/PayloadUploadState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class WaitingForPayload extends PayloadUploadState {
        private final String deviceAddress;

        public static /* synthetic */ WaitingForPayload copy$default(WaitingForPayload waitingForPayload, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = waitingForPayload.deviceAddress;
            }
            return waitingForPayload.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final WaitingForPayload copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new WaitingForPayload(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WaitingForPayload) && Intrinsics.areEqual(this.deviceAddress, ((WaitingForPayload) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        @Override // com.bat.sdk.payload.PayloadUploadState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WaitingForPayload(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        public String toString() {
            return "waiting for payload";
        }
    }

    /* JADX INFO: compiled from: PayloadUploadState.kt */
    @Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadUploadState$WaitingForStart;", "Lcom/bat/sdk/payload/PayloadUploadState;", "deviceAddress", "", "chunks", "", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getDeviceAddress", "()Ljava/lang/String;", "getChunks", "()Ljava/util/List;", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class WaitingForStart extends PayloadUploadState {
        private final List<byte[]> chunks;
        private final String deviceAddress;

        @Override // com.bat.sdk.payload.PayloadUploadState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final List<byte[]> getChunks() {
            return this.chunks;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WaitingForStart(String deviceAddress, List<byte[]> chunks) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(chunks, "chunks");
            this.deviceAddress = deviceAddress;
            this.chunks = chunks;
        }

        public String toString() {
            return "waiting for start, chunks: " + this.chunks.size();
        }
    }

    /* JADX INFO: compiled from: PayloadUploadState.kt */
    @Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadUploadState$WaitingForChunkAcceptance;", "Lcom/bat/sdk/payload/PayloadUploadState;", "deviceAddress", "", "remainingChunks", "", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getDeviceAddress", "()Ljava/lang/String;", "getRemainingChunks", "()Ljava/util/List;", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class WaitingForChunkAcceptance extends PayloadUploadState {
        private final String deviceAddress;
        private final List<byte[]> remainingChunks;

        @Override // com.bat.sdk.payload.PayloadUploadState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final List<byte[]> getRemainingChunks() {
            return this.remainingChunks;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WaitingForChunkAcceptance(String deviceAddress, List<byte[]> remainingChunks) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            Intrinsics.checkNotNullParameter(remainingChunks, "remainingChunks");
            this.deviceAddress = deviceAddress;
            this.remainingChunks = remainingChunks;
        }

        public String toString() {
            return "waiting for chunk acceptance, remaining chunks " + this.remainingChunks.size();
        }
    }

    /* JADX INFO: compiled from: PayloadUploadState.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadUploadState$Finishing;", "Lcom/bat/sdk/payload/PayloadUploadState;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Finishing extends PayloadUploadState {
        private final String deviceAddress;

        public static /* synthetic */ Finishing copy$default(Finishing finishing, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = finishing.deviceAddress;
            }
            return finishing.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final Finishing copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new Finishing(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Finishing) && Intrinsics.areEqual(this.deviceAddress, ((Finishing) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        @Override // com.bat.sdk.payload.PayloadUploadState
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Finishing(String deviceAddress) {
            super(deviceAddress, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        public String toString() {
            return "finishing";
        }
    }
}
