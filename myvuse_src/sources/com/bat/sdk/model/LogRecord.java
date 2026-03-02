package com.bat.sdk.model;

import com.bat.sdk.model.DeviceType;
import com.bat.sdk.model.LogEventData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: compiled from: LogRecord.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\t\n\u000b\f¨\u0006\r"}, m5598d2 = {"Lcom/bat/sdk/model/LogRecord;", "", "<init>", "()V", "StartOfFile", "Data", "EndOfFile", "DataList", "Companion", "Lcom/bat/sdk/model/LogRecord$Data;", "Lcom/bat/sdk/model/LogRecord$DataList;", "Lcom/bat/sdk/model/LogRecord$EndOfFile;", "Lcom/bat/sdk/model/LogRecord$StartOfFile;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class LogRecord {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ LogRecord(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LogRecord() {
    }

    /* JADX INFO: compiled from: LogRecord.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/model/LogRecord$StartOfFile;", "Lcom/bat/sdk/model/LogRecord;", NewHtcHomeBadger.COUNT, "", "<init>", "(I)V", "getCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class StartOfFile extends LogRecord {
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

    /* JADX INFO: compiled from: LogRecord.kt */
    @Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018JV\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, m5598d2 = {"Lcom/bat/sdk/model/LogRecord$Data;", "Lcom/bat/sdk/model/LogRecord;", FirebaseAnalytics.Param.INDEX, "", "timestamp", "Ljava/util/Date;", "type", "code", "data", "", "originalData", "timestampSyncIndication", "<init>", "(ILjava/util/Date;II[B[BLjava/lang/Integer;)V", "getIndex", "()I", "getTimestamp", "()Ljava/util/Date;", "getType", "getCode", "getData", "()[B", "getOriginalData", "getTimestampSyncIndication", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/util/Date;II[B[BLjava/lang/Integer;)Lcom/bat/sdk/model/LogRecord$Data;", "equals", "", "other", "", "hashCode", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Data extends LogRecord {
        private final int code;
        private final byte[] data;
        private final int index;
        private final byte[] originalData;
        private final Date timestamp;
        private final Integer timestampSyncIndication;
        private final int type;

        public static /* synthetic */ Data copy$default(Data data, int i, Date date, int i2, int i3, byte[] bArr, byte[] bArr2, Integer num, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = data.index;
            }
            if ((i4 & 2) != 0) {
                date = data.timestamp;
            }
            Date date2 = date;
            if ((i4 & 4) != 0) {
                i2 = data.type;
            }
            int i5 = i2;
            if ((i4 & 8) != 0) {
                i3 = data.code;
            }
            int i6 = i3;
            if ((i4 & 16) != 0) {
                bArr = data.data;
            }
            byte[] bArr3 = bArr;
            if ((i4 & 32) != 0) {
                bArr2 = data.originalData;
            }
            byte[] bArr4 = bArr2;
            if ((i4 & 64) != 0) {
                num = data.timestampSyncIndication;
            }
            return data.copy(i, date2, i5, i6, bArr3, bArr4, num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Date getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final byte[] getData() {
            return this.data;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final byte[] getOriginalData() {
            return this.originalData;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getTimestampSyncIndication() {
            return this.timestampSyncIndication;
        }

        public final Data copy(int index, Date timestamp, int type, int code, byte[] data, byte[] originalData, Integer timestampSyncIndication) {
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(originalData, "originalData");
            return new Data(index, timestamp, type, code, data, originalData, timestampSyncIndication);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return this.index == data.index && Intrinsics.areEqual(this.timestamp, data.timestamp) && this.type == data.type && this.code == data.code && Intrinsics.areEqual(this.data, data.data) && Intrinsics.areEqual(this.originalData, data.originalData) && Intrinsics.areEqual(this.timestampSyncIndication, data.timestampSyncIndication);
        }

        public int hashCode() {
            int iHashCode = ((((((((((Integer.hashCode(this.index) * 31) + this.timestamp.hashCode()) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.code)) * 31) + Arrays.hashCode(this.data)) * 31) + Arrays.hashCode(this.originalData)) * 31;
            Integer num = this.timestampSyncIndication;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "Data(index=" + this.index + ", timestamp=" + this.timestamp + ", type=" + this.type + ", code=" + this.code + ", data=" + Arrays.toString(this.data) + ", originalData=" + Arrays.toString(this.originalData) + ", timestampSyncIndication=" + this.timestampSyncIndication + ')';
        }

        public /* synthetic */ Data(int i, Date date, int i2, int i3, byte[] bArr, byte[] bArr2, Integer num, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, date, i2, (i4 & 8) != 0 ? 0 : i3, bArr, bArr2, (i4 & 64) != 0 ? null : num);
        }

        public final int getIndex() {
            return this.index;
        }

        public final Date getTimestamp() {
            return this.timestamp;
        }

        public final int getType() {
            return this.type;
        }

        public final int getCode() {
            return this.code;
        }

        public final byte[] getData() {
            return this.data;
        }

        public final byte[] getOriginalData() {
            return this.originalData;
        }

        public final Integer getTimestampSyncIndication() {
            return this.timestampSyncIndication;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Data(int i, Date timestamp, int i2, int i3, byte[] data, byte[] originalData, Integer num) {
            super(null);
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(originalData, "originalData");
            this.index = i;
            this.timestamp = timestamp;
            this.type = i2;
            this.code = i3;
            this.data = data;
            this.originalData = originalData;
            this.timestampSyncIndication = num;
        }
    }

    /* JADX INFO: compiled from: LogRecord.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/model/LogRecord$EndOfFile;", "Lcom/bat/sdk/model/LogRecord;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class EndOfFile extends LogRecord {
        public static final EndOfFile INSTANCE = new EndOfFile();

        private EndOfFile() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: LogRecord.kt */
    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m5598d2 = {"Lcom/bat/sdk/model/LogRecord$DataList;", "Lcom/bat/sdk/model/LogRecord;", "logsList", "", "<init>", "(Ljava/util/List;)V", "getLogsList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class DataList extends LogRecord {
        private final List<LogRecord> logsList;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataList copy$default(DataList dataList, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = dataList.logsList;
            }
            return dataList.copy(list);
        }

        public final List<LogRecord> component1() {
            return this.logsList;
        }

        public final DataList copy(List<? extends LogRecord> logsList) {
            Intrinsics.checkNotNullParameter(logsList, "logsList");
            return new DataList(logsList);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataList) && Intrinsics.areEqual(this.logsList, ((DataList) other).logsList);
        }

        public int hashCode() {
            return this.logsList.hashCode();
        }

        public String toString() {
            return "DataList(logsList=" + this.logsList + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public DataList(List<? extends LogRecord> logsList) {
            super(null);
            Intrinsics.checkNotNullParameter(logsList, "logsList");
            this.logsList = logsList;
        }

        public final List<LogRecord> getLogsList() {
            return this.logsList;
        }
    }

    /* JADX INFO: compiled from: LogRecord.kt */
    @Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ\"\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ,\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\u0010"}, m5598d2 = {"Lcom/bat/sdk/model/LogRecord$Companion;", "", "<init>", "()V", "typeToString", "", "type", "", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "codeToString", "code", "decodeEventData", "Lcom/bat/sdk/model/LogEventData;", "data", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ String typeToString$default(Companion companion, int i, DeviceType deviceType, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                deviceType = null;
            }
            return companion.typeToString(i, deviceType);
        }

        public final String typeToString(int type, DeviceType deviceType) {
            switch (type) {
                case 0:
                    return "Boot";
                case 1:
                    return "Power";
                case 2:
                    return "Error";
                case 3:
                    return "Battery";
                case 4:
                    return "Device lock";
                case 5:
                    return "Bluetooth";
                case 6:
                    return Intrinsics.areEqual(deviceType, DeviceType.SmartBox.INSTANCE) ? "Pod" : Intrinsics.areEqual(deviceType, DeviceType.EPod3.INSTANCE) ? "Usage Reminder" : Intrinsics.areEqual(deviceType, DeviceType.AquilaNS.INSTANCE) ? "Auto-Lock" : "";
                case 7:
                    return Intrinsics.areEqual(deviceType, DeviceType.SmartBox.INSTANCE) ? "Power Setting" : Intrinsics.areEqual(deviceType, DeviceType.EPod3.INSTANCE) ? "Recharge Reminder" : "";
                case 8:
                    return "Session Indication";
                case 9:
                    return "Usage Goal";
                case 10:
                    return "Recharge Reminder";
                case 11:
                    return "Auto Power-Off";
                case 12:
                    return "Power Save Mode";
                default:
                    return "";
            }
        }

        public static /* synthetic */ String codeToString$default(Companion companion, int i, int i2, DeviceType deviceType, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                deviceType = null;
            }
            return companion.codeToString(i, i2, deviceType);
        }

        public final String codeToString(int type, int code, DeviceType deviceType) {
            switch (type) {
                case 0:
                default:
                    return "";
                case 1:
                    if (code == 0) {
                        return "Power on";
                    }
                    if (code != 1) {
                        return code != 2 ? "" : "Power activity timeout";
                    }
                    return "Power off";
                case 2:
                    switch (code) {
                        case 0:
                            return "None";
                        case 1:
                            return "Bad state";
                        case 2:
                            return "VBATT low";
                        case 3:
                            return "VBATT high";
                        case 4:
                            return "VBATT Load Low";
                        case 5:
                            return "VUSB High";
                        case 6:
                            return "VCART Low";
                        case 7:
                            return "VCART High";
                        case 8:
                            return "VDCDC Low";
                        case 9:
                            return "VDCDC High";
                        case 10:
                            return "ICART Low";
                        case 11:
                            return "ICART High";
                        case 12:
                            return "Temp Low";
                        case 13:
                            return "Temp High";
                        case 14:
                            return "Failed Charge";
                        case 15:
                            return "Coarse Vape Abuse";
                        case 16:
                            return "BLE Pairing Disallowed";
                        case 17:
                            return "Vape too long";
                        case 18:
                            return "External flash failed";
                        case 19:
                            return "Charge IC failed";
                        case 20:
                            return "Fuel gauge failed";
                        case 21:
                            return "Pressure sensor failed";
                        case 22:
                            return "FOTA Failed due to Low Battery";
                        case 23:
                            return "Reserved";
                        case 24:
                            return "Pod high resistance";
                        case 25:
                            return "Smart Pod Authentication Process Error";
                        case 26:
                            return "Smart Pod Read Data Process Error";
                        case 27:
                            return "UI Resource Update Failed";
                        case 28:
                            return "Heating Components Failure";
                        default:
                            return "";
                    }
                case 3:
                    return "Battery";
                case 4:
                    if (code == 0) {
                        return "Locked";
                    }
                    if (code == 1) {
                        return "Unlocked";
                    }
                    if (code != 2) {
                        return code != 3 ? "" : "Manual Unlock";
                    }
                    return "Manual Lock";
                case 5:
                    if (code == 0) {
                        return "Pairing Success";
                    }
                    if (code == 1) {
                        return "Pairing Failed";
                    }
                    if (code != 2) {
                        return code != 3 ? "" : "Pairing window timeout";
                    }
                    return "User created bond";
                case 6:
                    if (Intrinsics.areEqual(deviceType, DeviceType.SmartBox.INSTANCE)) {
                        if (code == 0) {
                            return "Pod Disconnected";
                        }
                        if (code == 1) {
                            return "Pod Connected and Recognizing";
                        }
                        if (code == 2) {
                            return "Non-Authenticated Pod Detected";
                        }
                        if (code != 3) {
                            return code != 4 ? "" : "Supported Authenticated Smart Pod Detected";
                        }
                        return "Non-Supported Authenticated Smart Pod Detected";
                    }
                    if (!Intrinsics.areEqual(deviceType, DeviceType.EPod3.INSTANCE)) {
                        if (!Intrinsics.areEqual(deviceType, DeviceType.AquilaNS.INSTANCE)) {
                            return "";
                        }
                        if (code != 0) {
                            return code != 1 ? "" : "Auto-Lock enabled";
                        }
                        return "Auto-Lock disabled";
                    }
                    if (code != 0) {
                        return "";
                    }
                    break;
                case 7:
                    if (!Intrinsics.areEqual(deviceType, DeviceType.SmartBox.INSTANCE)) {
                        return (Intrinsics.areEqual(deviceType, DeviceType.EPod3.INSTANCE) && code == 0) ? "Battery Alert" : "";
                    }
                    if (code == 0) {
                        return "Mobile App";
                    }
                    if (code == 1) {
                        return "Device Button";
                    }
                    if (code != 2) {
                        return code != 3 ? "" : "Opt-In";
                    }
                    return "Opt-Autotune";
                case 8:
                    return code == 1 ? "Puff Session Being Reached" : "";
                case 9:
                    if (code != 0) {
                        return "";
                    }
                    break;
                case 10:
                    return code == 0 ? "Battery Alert" : "";
                case 11:
                    return code == 0 ? "Auto Power-Off when Battery is low" : "";
                case 12:
                    if (code != 0) {
                        return code != 1 ? "" : "Power Save Mode ON";
                    }
                    return "Power Save Mode OFF";
            }
            return "Usage Goal reached";
        }

        public static /* synthetic */ LogEventData decodeEventData$default(Companion companion, int i, int i2, byte[] bArr, DeviceType deviceType, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                deviceType = null;
            }
            return companion.decodeEventData(i, i2, bArr, deviceType);
        }

        public final LogEventData decodeEventData(int type, int code, byte[] data, DeviceType deviceType) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (type == 0) {
                return new LogEventData.BootEventData(data);
            }
            if (type == 12) {
                return new LogEventData.PowerSaveModeEventData(data);
            }
            if (type == 2) {
                return code == 28 ? new LogEventData.HeatingComponentsFailureError(data) : null;
            }
            if (type == 3) {
                return new LogEventData.BatteryEventData(data);
            }
            if (type == 5) {
                return code == 5 ? new LogEventData.BluetoothEventData(data) : null;
            }
            if (type == 6) {
                if (Intrinsics.areEqual(deviceType, DeviceType.SmartBox.INSTANCE)) {
                    if (code == 3 || code == 4) {
                        authenticatedPodEventData = new LogEventData.AuthenticatedPodEventData(data);
                    }
                    return authenticatedPodEventData;
                }
                if (Intrinsics.areEqual(deviceType, DeviceType.EPod3.INSTANCE)) {
                    return new LogEventData.UsageReminderEventData(data);
                }
                return null;
            }
            if (type != 7) {
                if (type == 9) {
                    return new LogEventData.UsageReminderEventData(data);
                }
                if (type != 10) {
                    return null;
                }
                return new LogEventData.RechargeReminderEventData(data);
            }
            if (Intrinsics.areEqual(deviceType, DeviceType.SmartBox.INSTANCE)) {
                return new LogEventData.PowerSettingEventData(data);
            }
            if (Intrinsics.areEqual(deviceType, DeviceType.EPod3.INSTANCE)) {
                return new LogEventData.RechargeReminderEventData(data);
            }
            return null;
        }
    }
}
