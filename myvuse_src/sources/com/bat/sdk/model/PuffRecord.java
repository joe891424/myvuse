package com.bat.sdk.model;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: compiled from: PuffRecord.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, m5598d2 = {"Lcom/bat/sdk/model/PuffRecord;", "", "<init>", "()V", "StartOfFile", "Data", "EndOfFile", "DataList", "Lcom/bat/sdk/model/PuffRecord$Data;", "Lcom/bat/sdk/model/PuffRecord$DataList;", "Lcom/bat/sdk/model/PuffRecord$EndOfFile;", "Lcom/bat/sdk/model/PuffRecord$StartOfFile;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class PuffRecord {
    public /* synthetic */ PuffRecord(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PuffRecord() {
    }

    /* JADX INFO: compiled from: PuffRecord.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/model/PuffRecord$StartOfFile;", "Lcom/bat/sdk/model/PuffRecord;", NewHtcHomeBadger.COUNT, "", "<init>", "(I)V", "getCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class StartOfFile extends PuffRecord {
        private final int count;

        public static /* synthetic */ StartOfFile copy$default(StartOfFile startOfFile, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = startOfFile.count;
            }
            return startOfFile.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final StartOfFile copy(int count) {
            return new StartOfFile(count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StartOfFile) && this.count == ((StartOfFile) other).count;
        }

        public int hashCode() {
            return Integer.hashCode(this.count);
        }

        public String toString() {
            return "StartOfFile(count=" + this.count + ')';
        }

        public StartOfFile(int i) {
            super(null);
            this.count = i;
        }

        public final int getCount() {
            return this.count;
        }
    }

    /* JADX INFO: compiled from: PuffRecord.kt */
    @Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0096\u0002J\b\u00100\u001a\u00020\u0003H\u0016J\b\u00101\u001a\u00020\u0014H\u0016J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\nHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010=\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0094\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010?R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b'\u0010%R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b(\u0010%R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010&\u001a\u0004\b)\u0010%R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006@"}, m5598d2 = {"Lcom/bat/sdk/model/PuffRecord$Data;", "Lcom/bat/sdk/model/PuffRecord;", NewHtcHomeBadger.COUNT, "", "timestamp", "Ljava/util/Date;", "duration", "Ljava/time/Duration;", "powerLevel", "data", "", "podUid", "Lcom/bat/sdk/model/PodUid;", "liquidInformation", "Lcom/bat/sdk/model/LiquidInformation;", "remainingVolume", "podPuffCount", "syncIndication", "apiVersion", "skuInformation", "", "<init>", "(ILjava/util/Date;Ljava/time/Duration;I[BLcom/bat/sdk/model/PodUid;Lcom/bat/sdk/model/LiquidInformation;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getCount", "()I", "getTimestamp", "()Ljava/util/Date;", "getDuration", "()Ljava/time/Duration;", "getPowerLevel", "getData", "()[B", "getPodUid", "()Lcom/bat/sdk/model/PodUid;", "getLiquidInformation", "()Lcom/bat/sdk/model/LiquidInformation;", "getRemainingVolume", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPodPuffCount", "getSyncIndication", "getApiVersion", "getSkuInformation", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(ILjava/util/Date;Ljava/time/Duration;I[BLcom/bat/sdk/model/PodUid;Lcom/bat/sdk/model/LiquidInformation;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bat/sdk/model/PuffRecord$Data;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Data extends PuffRecord {
        private final Integer apiVersion;
        private final int count;
        private final byte[] data;
        private final Duration duration;
        private final LiquidInformation liquidInformation;
        private final Integer podPuffCount;
        private final PodUid podUid;
        private final int powerLevel;
        private final Integer remainingVolume;
        private final String skuInformation;
        private final Integer syncIndication;
        private final Date timestamp;

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getSyncIndication() {
            return this.syncIndication;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getApiVersion() {
            return this.apiVersion;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getSkuInformation() {
            return this.skuInformation;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Date getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Duration getDuration() {
            return this.duration;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getPowerLevel() {
            return this.powerLevel;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final byte[] getData() {
            return this.data;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final PodUid getPodUid() {
            return this.podUid;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final LiquidInformation getLiquidInformation() {
            return this.liquidInformation;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getRemainingVolume() {
            return this.remainingVolume;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getPodPuffCount() {
            return this.podPuffCount;
        }

        public final Data copy(int count, Date timestamp, Duration duration, int powerLevel, byte[] data, PodUid podUid, LiquidInformation liquidInformation, Integer remainingVolume, Integer podPuffCount, Integer syncIndication, Integer apiVersion, String skuInformation) {
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            Intrinsics.checkNotNullParameter(duration, "duration");
            Intrinsics.checkNotNullParameter(data, "data");
            return new Data(count, timestamp, duration, powerLevel, data, podUid, liquidInformation, remainingVolume, podPuffCount, syncIndication, apiVersion, skuInformation);
        }

        public /* synthetic */ Data(int i, Date date, Duration duration, int i2, byte[] bArr, PodUid podUid, LiquidInformation liquidInformation, Integer num, Integer num2, Integer num3, Integer num4, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, date, duration, i2, bArr, (i3 & 32) != 0 ? null : podUid, (i3 & 64) != 0 ? null : liquidInformation, (i3 & 128) != 0 ? null : num, (i3 & 256) != 0 ? null : num2, (i3 & 512) != 0 ? null : num3, (i3 & 1024) != 0 ? null : num4, (i3 & 2048) != 0 ? null : str);
        }

        public final int getCount() {
            return this.count;
        }

        public final Date getTimestamp() {
            return this.timestamp;
        }

        public final Duration getDuration() {
            return this.duration;
        }

        public final int getPowerLevel() {
            return this.powerLevel;
        }

        public final byte[] getData() {
            return this.data;
        }

        public final PodUid getPodUid() {
            return this.podUid;
        }

        public final LiquidInformation getLiquidInformation() {
            return this.liquidInformation;
        }

        public final Integer getRemainingVolume() {
            return this.remainingVolume;
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Data(int i, Date timestamp, Duration duration, int i2, byte[] data, PodUid podUid, LiquidInformation liquidInformation, Integer num, Integer num2, Integer num3, Integer num4, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            Intrinsics.checkNotNullParameter(duration, "duration");
            Intrinsics.checkNotNullParameter(data, "data");
            this.count = i;
            this.timestamp = timestamp;
            this.duration = duration;
            this.powerLevel = i2;
            this.data = data;
            this.podUid = podUid;
            this.liquidInformation = liquidInformation;
            this.remainingVolume = num;
            this.podPuffCount = num2;
            this.syncIndication = num3;
            this.apiVersion = num4;
            this.skuInformation = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.PuffRecord.Data");
            Data data = (Data) other;
            return this.count == data.count && Intrinsics.areEqual(this.timestamp, data.timestamp) && Intrinsics.areEqual(this.duration, data.duration) && this.powerLevel == data.powerLevel && Arrays.equals(this.data, data.data);
        }

        public int hashCode() {
            return (((((((this.count * 31) + this.timestamp.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.powerLevel) * 31) + Arrays.hashCode(this.data);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Data(count=");
            StringBuilder sbAppend = sb.append(this.count).append(", timestamp=").append(this.timestamp).append(", duration=").append(this.duration).append(", powerLevel=").append(this.powerLevel).append(", data=");
            String string = Arrays.toString(this.data);
            Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
            sbAppend.append(string).append(", podUID=").append(this.podUid).append(", liquidInformation=").append(this.liquidInformation).append(", remainedVolume=").append(this.remainingVolume).append(", podPuffCount=").append(this.podPuffCount).append(", syncIndication=").append(this.syncIndication).append(", apiVersion=").append(this.apiVersion).append(", skuInformation=");
            sb.append(this.skuInformation).append(')');
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: PuffRecord.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/PuffRecord$EndOfFile;", "Lcom/bat/sdk/model/PuffRecord;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class EndOfFile extends PuffRecord {
        public static final EndOfFile INSTANCE = new EndOfFile();

        private EndOfFile() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PuffRecord.kt */
    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m5598d2 = {"Lcom/bat/sdk/model/PuffRecord$DataList;", "Lcom/bat/sdk/model/PuffRecord;", "puffsList", "", "<init>", "(Ljava/util/List;)V", "getPuffsList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class DataList extends PuffRecord {
        private final List<PuffRecord> puffsList;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataList copy$default(DataList dataList, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = dataList.puffsList;
            }
            return dataList.copy(list);
        }

        public final List<PuffRecord> component1() {
            return this.puffsList;
        }

        public final DataList copy(List<? extends PuffRecord> puffsList) {
            Intrinsics.checkNotNullParameter(puffsList, "puffsList");
            return new DataList(puffsList);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataList) && Intrinsics.areEqual(this.puffsList, ((DataList) other).puffsList);
        }

        public int hashCode() {
            return this.puffsList.hashCode();
        }

        public String toString() {
            return "DataList(puffsList=" + this.puffsList + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public DataList(List<? extends PuffRecord> puffsList) {
            super(null);
            Intrinsics.checkNotNullParameter(puffsList, "puffsList");
            this.puffsList = puffsList;
        }

        public final List<PuffRecord> getPuffsList() {
            return this.puffsList;
        }
    }
}
