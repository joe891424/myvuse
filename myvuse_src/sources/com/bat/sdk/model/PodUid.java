package com.bat.sdk.model;

import com.bat.sdk.logging.Logger;
import com.bat.sdk.presentation.ConversionExtensionsKt;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PodUid.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001e\u001a\u00020\tH\u0016J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\"\u001a\u00020\rH\u0016J \u0010#\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0013\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0018\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0011\u0010\u001a\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0011\u0010\u001c\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000b¨\u0006&"}, m5598d2 = {"Lcom/bat/sdk/model/PodUid;", "", "podUidRawData", "", "<init>", "([B)V", "getPodUidRawData", "()[B", "podUidHex", "", "getPodUidHex", "()Ljava/lang/String;", "year", "", "getYear", "()I", "month", "getMonth", "day", "getDay", "site", "getSite", "line", "getLine", "counter", "getCounter", "manufactureDate", "getManufactureDate", "assembly", "getAssembly", "toString", "equals", "", "other", "hashCode", "decodeManufactureDate", "component1", "copy", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class PodUid {
    private final String assembly;
    private final transient int counter;
    private final transient int day;
    private final transient int line;
    private final String manufactureDate;
    private final transient int month;
    private final String podUidHex;
    private final transient byte[] podUidRawData;
    private final transient int site;
    private final transient int year;

    public static /* synthetic */ PodUid copy$default(PodUid podUid, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = podUid.podUidRawData;
        }
        return podUid.copy(bArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final byte[] getPodUidRawData() {
        return this.podUidRawData;
    }

    public final PodUid copy(byte[] podUidRawData) {
        Intrinsics.checkNotNullParameter(podUidRawData, "podUidRawData");
        return new PodUid(podUidRawData);
    }

    public PodUid(byte[] podUidRawData) {
        Intrinsics.checkNotNullParameter(podUidRawData, "podUidRawData");
        this.podUidRawData = podUidRawData;
        this.podUidHex = ConversionExtensionsKt.toHex(podUidRawData);
        byte b = podUidRawData[0];
        int i = ((b >> 3) & 31) + 2023;
        this.year = i;
        byte b2 = podUidRawData[1];
        int i2 = ((b & 7) << 1) | ((b2 >> 7) & 1);
        this.month = i2;
        int i3 = (b2 >> 2) & 31;
        this.day = i3;
        byte b3 = podUidRawData[2];
        int i4 = (1 & (b3 >> 7)) | ((b2 & 3) << 1);
        this.site = i4;
        int i5 = (b3 >> 3) & 15;
        this.line = i5;
        int i6 = (podUidRawData[3] & 255) << 8;
        int i7 = (podUidRawData[4] & 255) | i6 | ((b3 & 7) << 16);
        this.counter = i7;
        this.manufactureDate = decodeManufactureDate(i, i2, i3);
        this.assembly = new StringBuilder().append(i4).append('.').append(i5).append('.').append(i7).toString();
    }

    public final byte[] getPodUidRawData() {
        return this.podUidRawData;
    }

    public final String getPodUidHex() {
        return this.podUidHex;
    }

    public final int getYear() {
        return this.year;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getDay() {
        return this.day;
    }

    public final int getSite() {
        return this.site;
    }

    public final int getLine() {
        return this.line;
    }

    public final int getCounter() {
        return this.counter;
    }

    public final String getManufactureDate() {
        return this.manufactureDate;
    }

    public final String getAssembly() {
        return this.assembly;
    }

    public String toString() {
        return "PodUid(year=" + this.year + ", month=" + this.month + ", day=" + this.day + ", site=" + this.site + ", line=" + this.line + ", counter=" + this.counter + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.PodUid");
        PodUid podUid = (PodUid) other;
        return Arrays.equals(this.podUidRawData, podUid.podUidRawData) && this.year == podUid.year && this.month == podUid.month && this.day == podUid.day && this.site == podUid.site && this.line == podUid.line && this.counter == podUid.counter;
    }

    public int hashCode() {
        return (((((((((((Arrays.hashCode(this.podUidRawData) * 31) + this.year) * 31) + this.month) * 31) + this.day) * 31) + this.site) * 31) + this.line) * 31) + this.counter;
    }

    private final String decodeManufactureDate(int year, int month, int day) {
        if (month == 0 || day == 0 || month > 12 || day > 31) {
            return "";
        }
        Logger.INSTANCE.log("[POD] month = " + month + " day = " + day);
        String str = LocalDate.of(year, month, day).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
