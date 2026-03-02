package com.bat.sdk.persistence.dto;

import com.bat.sdk.domain.SdkLog;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkLogDto.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, m5598d2 = {"Lcom/bat/sdk/persistence/dto/SdkLogDto;", "", "id", "", "date", "Ljava/util/Date;", "message", "", "<init>", "(JLjava/util/Date;Ljava/lang/String;)V", "getId", "()J", "getDate", "()Ljava/util/Date;", "getMessage", "()Ljava/lang/String;", "toGeneralLog", "Lcom/bat/sdk/domain/SdkLog;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class SdkLogDto {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Date date;
    private final long id;
    private final String message;

    public static /* synthetic */ SdkLogDto copy$default(SdkLogDto sdkLogDto, long j, Date date, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = sdkLogDto.id;
        }
        if ((i & 2) != 0) {
            date = sdkLogDto.date;
        }
        if ((i & 4) != 0) {
            str = sdkLogDto.message;
        }
        return sdkLogDto.copy(j, date, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Date getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final SdkLogDto copy(long id, Date date, String message) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(message, "message");
        return new SdkLogDto(id, date, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SdkLogDto)) {
            return false;
        }
        SdkLogDto sdkLogDto = (SdkLogDto) other;
        return this.id == sdkLogDto.id && Intrinsics.areEqual(this.date, sdkLogDto.date) && Intrinsics.areEqual(this.message, sdkLogDto.message);
    }

    public int hashCode() {
        return (((Long.hashCode(this.id) * 31) + this.date.hashCode()) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "SdkLogDto(id=" + this.id + ", date=" + this.date + ", message=" + this.message + ')';
    }

    public SdkLogDto(long j, Date date, String message) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(message, "message");
        this.id = j;
        this.date = date;
        this.message = message;
    }

    public /* synthetic */ SdkLogDto(long j, Date date, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, date, str);
    }

    public final long getId() {
        return this.id;
    }

    public final Date getDate() {
        return this.date;
    }

    public final String getMessage() {
        return this.message;
    }

    public final SdkLog toGeneralLog() {
        return new SdkLog(this.date, this.message);
    }

    /* JADX INFO: compiled from: SdkLogDto.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/persistence/dto/SdkLogDto$Companion;", "", "<init>", "()V", "fromGeneralLog", "Lcom/bat/sdk/persistence/dto/SdkLogDto;", "log", "Lcom/bat/sdk/domain/SdkLog;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SdkLogDto fromGeneralLog(SdkLog log) {
            Intrinsics.checkNotNullParameter(log, "log");
            return new SdkLogDto(0L, log.getDate(), log.getMessage(), 1, null);
        }
    }
}
