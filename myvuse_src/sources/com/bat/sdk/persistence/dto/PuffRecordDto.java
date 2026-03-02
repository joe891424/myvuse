package com.bat.sdk.persistence.dto;

import com.bat.sdk.model.LiquidInformation;
import com.bat.sdk.model.PodUid;
import com.bat.sdk.model.PuffRecord;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: compiled from: PuffRecordDto.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0001CB\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010,\u001a\u00020-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00101\u001a\u00020\u0005H\u0016J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010?\u001a\u0004\u0018\u00010\rHÆ\u0003J¨\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010AJ\t\u0010B\u001a\u00020\rHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010'\u001a\u0004\b(\u0010&R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010'\u001a\u0004\b)\u0010&R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010'\u001a\u0004\b*\u0010&R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"¨\u0006D"}, m5598d2 = {"Lcom/bat/sdk/persistence/dto/PuffRecordDto;", "", "id", "", NewHtcHomeBadger.COUNT, "", "time", "Ljava/util/Date;", "duration", FirebaseAnalytics.Param.LEVEL, "data", "", "deviceAddress", "", "podUid", "liquidInformation", "remainedVolume", "podPuffCount", "syncIndication", "apiVersion", "skuInformation", "<init>", "(JILjava/util/Date;JI[BLjava/lang/String;[B[BLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()J", "getCount", "()I", "getTime", "()Ljava/util/Date;", "getDuration", "getLevel", "getData", "()[B", "getDeviceAddress", "()Ljava/lang/String;", "getPodUid", "getLiquidInformation", "getRemainedVolume", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPodPuffCount", "getSyncIndication", "getApiVersion", "getSkuInformation", "toPuffRecord", "Lcom/bat/sdk/model/PuffRecord$Data;", "equals", "", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(JILjava/util/Date;JI[BLjava/lang/String;[B[BLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bat/sdk/persistence/dto/PuffRecordDto;", "toString", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class PuffRecordDto {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer apiVersion;
    private final int count;
    private final byte[] data;
    private final String deviceAddress;
    private final long duration;
    private final long id;
    private final int level;
    private final byte[] liquidInformation;
    private final Integer podPuffCount;
    private final byte[] podUid;
    private final Integer remainedVolume;
    private final String skuInformation;
    private final Integer syncIndication;
    private final Date time;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getRemainedVolume() {
        return this.remainedVolume;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getPodPuffCount() {
        return this.podPuffCount;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Integer getSyncIndication() {
        return this.syncIndication;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Integer getApiVersion() {
        return this.apiVersion;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getSkuInformation() {
        return this.skuInformation;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDeviceAddress() {
        return this.deviceAddress;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final byte[] getPodUid() {
        return this.podUid;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final byte[] getLiquidInformation() {
        return this.liquidInformation;
    }

    public final PuffRecordDto copy(long id, int count, Date time, long duration, int level, byte[] data, String deviceAddress, byte[] podUid, byte[] liquidInformation, Integer remainedVolume, Integer podPuffCount, Integer syncIndication, Integer apiVersion, String skuInformation) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        return new PuffRecordDto(id, count, time, duration, level, data, deviceAddress, podUid, liquidInformation, remainedVolume, podPuffCount, syncIndication, apiVersion, skuInformation);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PuffRecordDto(id=");
        sb.append(this.id).append(", count=").append(this.count).append(", time=").append(this.time).append(", duration=").append(this.duration).append(", level=").append(this.level).append(", data=").append(Arrays.toString(this.data)).append(", deviceAddress=").append(this.deviceAddress).append(", podUid=").append(Arrays.toString(this.podUid)).append(", liquidInformation=").append(Arrays.toString(this.liquidInformation)).append(", remainedVolume=").append(this.remainedVolume).append(", podPuffCount=").append(this.podPuffCount).append(", syncIndication=");
        sb.append(this.syncIndication).append(", apiVersion=").append(this.apiVersion).append(", skuInformation=").append(this.skuInformation).append(')');
        return sb.toString();
    }

    public PuffRecordDto(long j, int i, Date time, long j2, int i2, byte[] data, String deviceAddress, byte[] bArr, byte[] bArr2, Integer num, Integer num2, Integer num3, Integer num4, String str) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        this.id = j;
        this.count = i;
        this.time = time;
        this.duration = j2;
        this.level = i2;
        this.data = data;
        this.deviceAddress = deviceAddress;
        this.podUid = bArr;
        this.liquidInformation = bArr2;
        this.remainedVolume = num;
        this.podPuffCount = num2;
        this.syncIndication = num3;
        this.apiVersion = num4;
        this.skuInformation = str;
    }

    public /* synthetic */ PuffRecordDto(long j, int i, Date date, long j2, int i2, byte[] bArr, String str, byte[] bArr2, byte[] bArr3, Integer num, Integer num2, Integer num3, Integer num4, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, i, date, j2, i2, bArr, str, bArr2, bArr3, num, num2, num3, num4, str2);
    }

    public final long getId() {
        return this.id;
    }

    public final int getCount() {
        return this.count;
    }

    public final Date getTime() {
        return this.time;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getLevel() {
        return this.level;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getDeviceAddress() {
        return this.deviceAddress;
    }

    public final byte[] getPodUid() {
        return this.podUid;
    }

    public final byte[] getLiquidInformation() {
        return this.liquidInformation;
    }

    public final Integer getRemainedVolume() {
        return this.remainedVolume;
    }

    public final Integer getPodPuffCount() {
        return this.podPuffCount;
    }

    public final Integer getSyncIndication() {
        return this.syncIndication;
    }

    public final Integer getApiVersion() {
        return this.apiVersion;
    }

    public final String getSkuInformation() {
        return this.skuInformation;
    }

    public final PuffRecord.Data toPuffRecord() {
        int i = this.count;
        Date date = this.time;
        Duration durationOfMillis = Duration.ofMillis(this.duration);
        Intrinsics.checkNotNullExpressionValue(durationOfMillis, "ofMillis(...)");
        int i2 = this.level;
        byte[] bArr = this.data;
        byte[] bArr2 = this.podUid;
        PodUid podUid = bArr2 != null ? new PodUid(bArr2) : null;
        byte[] bArr3 = this.liquidInformation;
        return new PuffRecord.Data(i, date, durationOfMillis, i2, bArr, podUid, bArr3 != null ? new LiquidInformation(bArr3) : null, this.remainedVolume, this.podPuffCount, this.syncIndication, this.apiVersion, this.skuInformation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.persistence.dto.PuffRecordDto");
        PuffRecordDto puffRecordDto = (PuffRecordDto) other;
        if (this.id != puffRecordDto.id || this.count != puffRecordDto.count || !Intrinsics.areEqual(this.time, puffRecordDto.time) || this.duration != puffRecordDto.duration || this.level != puffRecordDto.level || !Arrays.equals(this.data, puffRecordDto.data) || !Intrinsics.areEqual(this.deviceAddress, puffRecordDto.deviceAddress)) {
            return false;
        }
        byte[] bArr = this.podUid;
        if (bArr != null) {
            byte[] bArr2 = puffRecordDto.podUid;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (puffRecordDto.podUid != null) {
            return false;
        }
        byte[] bArr3 = this.liquidInformation;
        if (bArr3 != null) {
            byte[] bArr4 = puffRecordDto.liquidInformation;
            if (bArr4 == null || !Arrays.equals(bArr3, bArr4)) {
                return false;
            }
        } else if (puffRecordDto.liquidInformation != null) {
            return false;
        }
        return Intrinsics.areEqual(this.remainedVolume, puffRecordDto.remainedVolume) && Intrinsics.areEqual(this.podPuffCount, puffRecordDto.podPuffCount) && Intrinsics.areEqual(this.syncIndication, puffRecordDto.syncIndication);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((Long.hashCode(this.id) * 31) + this.count) * 31) + this.time.hashCode()) * 31) + Long.hashCode(this.duration)) * 31) + this.level) * 31) + Arrays.hashCode(this.data)) * 31) + this.deviceAddress.hashCode()) * 31;
        byte[] bArr = this.podUid;
        int iHashCode2 = (iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        byte[] bArr2 = this.liquidInformation;
        int iHashCode3 = (iHashCode2 + (bArr2 != null ? Arrays.hashCode(bArr2) : 0)) * 31;
        Integer num = this.remainedVolume;
        int iIntValue = (iHashCode3 + (num != null ? num.intValue() : 0)) * 31;
        Integer num2 = this.podPuffCount;
        int iIntValue2 = (iIntValue + (num2 != null ? num2.intValue() : 0)) * 31;
        Integer num3 = this.syncIndication;
        return iIntValue2 + (num3 != null ? num3.intValue() : 0);
    }

    /* JADX INFO: compiled from: PuffRecordDto.kt */
    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, m5598d2 = {"Lcom/bat/sdk/persistence/dto/PuffRecordDto$Companion;", "", "<init>", "()V", "fromPuffRecord", "Lcom/bat/sdk/persistence/dto/PuffRecordDto;", "record", "Lcom/bat/sdk/model/PuffRecord;", "deviceAddress", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PuffRecordDto fromPuffRecord(PuffRecord record, String deviceAddress) {
            Intrinsics.checkNotNullParameter(record, "record");
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            if (!(record instanceof PuffRecord.Data)) {
                return null;
            }
            PuffRecord.Data data = (PuffRecord.Data) record;
            int count = data.getCount();
            Date timestamp = data.getTimestamp();
            long millis = data.getDuration().toMillis();
            int powerLevel = data.getPowerLevel();
            byte[] data2 = data.getData();
            PodUid podUid = data.getPodUid();
            byte[] podUidRawData = podUid != null ? podUid.getPodUidRawData() : null;
            LiquidInformation liquidInformation = data.getLiquidInformation();
            return new PuffRecordDto(0L, count, timestamp, millis, powerLevel, data2, deviceAddress, podUidRawData, liquidInformation != null ? liquidInformation.getPodLiquidInformationRawData() : null, data.getRemainingVolume(), data.getPodPuffCount(), data.getSyncIndication(), data.getApiVersion(), data.getSkuInformation(), 1, null);
        }
    }
}
