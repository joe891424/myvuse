package com.yoti.mobile.mpp.mrtddump;

import com.yoti.mobile.mpp.mrtddump.auth.MrtdAuthentication;
import com.yoti.mobile.mpp.mrtddump.auth.NullAuthentication;
import com.yoti.mobile.mpp.mrtddump.reader.MrtdFileType;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001+BE\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\u000fHÆ\u0003JU\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010&\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\nHÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderConfig;", "", "authentication", "Lcom/yoti/mobile/mpp/mrtddump/auth/MrtdAuthentication;", "requiredFiles", "", "Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileType;", "readTimeoutMs", "", "readBlockSize", "", "extendedLengthSupport", "Lcom/yoti/mobile/mpp/mrtddump/ExtendedLengthSetting;", "minLevelToLog", "reusable", "", "(Lcom/yoti/mobile/mpp/mrtddump/auth/MrtdAuthentication;Ljava/util/Collection;JILcom/yoti/mobile/mpp/mrtddump/ExtendedLengthSetting;IZ)V", "getAuthentication", "()Lcom/yoti/mobile/mpp/mrtddump/auth/MrtdAuthentication;", "getExtendedLengthSupport", "()Lcom/yoti/mobile/mpp/mrtddump/ExtendedLengthSetting;", "getMinLevelToLog", "()I", "getReadBlockSize", "getReadTimeoutMs", "()J", "getRequiredFiles", "()Ljava/util/Collection;", "getReusable", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "Builder", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class MrtdReaderConfig {
    private final MrtdAuthentication authentication;
    private final ExtendedLengthSetting extendedLengthSupport;
    private final int minLevelToLog;
    private final int readBlockSize;
    private final long readTimeoutMs;
    private final Collection<MrtdFileType> requiredFiles;
    private final boolean reusable;

    @Metadata(m5597d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010.\u001a\u00020/R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00060"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderConfig$Builder;", "", "()V", "authentication", "Lcom/yoti/mobile/mpp/mrtddump/auth/MrtdAuthentication;", "getAuthentication", "()Lcom/yoti/mobile/mpp/mrtddump/auth/MrtdAuthentication;", "setAuthentication", "(Lcom/yoti/mobile/mpp/mrtddump/auth/MrtdAuthentication;)V", "blockSize", "Lcom/yoti/mobile/mpp/mrtddump/BlockSizeSetting;", "getBlockSize", "()Lcom/yoti/mobile/mpp/mrtddump/BlockSizeSetting;", "setBlockSize", "(Lcom/yoti/mobile/mpp/mrtddump/BlockSizeSetting;)V", "extendedSetting", "Lcom/yoti/mobile/mpp/mrtddump/ExtendedLengthSetting;", "getExtendedSetting", "()Lcom/yoti/mobile/mpp/mrtddump/ExtendedLengthSetting;", "setExtendedSetting", "(Lcom/yoti/mobile/mpp/mrtddump/ExtendedLengthSetting;)V", "logLevel", "Lcom/yoti/mobile/mpp/mrtddump/LogLevel;", "getLogLevel", "()Lcom/yoti/mobile/mpp/mrtddump/LogLevel;", "setLogLevel", "(Lcom/yoti/mobile/mpp/mrtddump/LogLevel;)V", "readTimeoutMs", "", "getReadTimeoutMs", "()J", "setReadTimeoutMs", "(J)V", "requiredFiles", "", "Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileType;", "getRequiredFiles", "()Ljava/util/Collection;", "setRequiredFiles", "(Ljava/util/Collection;)V", "reusable", "", "getReusable", "()Z", "setReusable", "(Z)V", "build", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderConfig;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Builder {
        private MrtdAuthentication authentication = new NullAuthentication();
        private Collection<? extends MrtdFileType> requiredFiles = CollectionsKt.emptyList();
        private long readTimeoutMs = C5083d.f8011a;
        private BlockSizeSetting blockSize = BlockSizeSetting.DEFAULT;
        private ExtendedLengthSetting extendedSetting = ExtendedLengthSetting.DEFAULT;
        private LogLevel logLevel = LogLevel.NONE;
        private boolean reusable = true;

        public final MrtdReaderConfig build() {
            return new MrtdReaderConfig(this.authentication, this.requiredFiles, this.readTimeoutMs, this.blockSize.getSizeInBytes(), this.extendedSetting, this.logLevel.getMinLevelToLog(), this.reusable, null);
        }

        public final MrtdAuthentication getAuthentication() {
            return this.authentication;
        }

        public final BlockSizeSetting getBlockSize() {
            return this.blockSize;
        }

        public final ExtendedLengthSetting getExtendedSetting() {
            return this.extendedSetting;
        }

        public final LogLevel getLogLevel() {
            return this.logLevel;
        }

        public final long getReadTimeoutMs() {
            return this.readTimeoutMs;
        }

        public final Collection<MrtdFileType> getRequiredFiles() {
            return this.requiredFiles;
        }

        public final boolean getReusable() {
            return this.reusable;
        }

        public final void setAuthentication(MrtdAuthentication mrtdAuthentication) {
            Intrinsics.checkNotNullParameter(mrtdAuthentication, "<set-?>");
            this.authentication = mrtdAuthentication;
        }

        public final void setBlockSize(BlockSizeSetting blockSizeSetting) {
            Intrinsics.checkNotNullParameter(blockSizeSetting, "<set-?>");
            this.blockSize = blockSizeSetting;
        }

        public final void setExtendedSetting(ExtendedLengthSetting extendedLengthSetting) {
            Intrinsics.checkNotNullParameter(extendedLengthSetting, "<set-?>");
            this.extendedSetting = extendedLengthSetting;
        }

        public final void setLogLevel(LogLevel logLevel) {
            Intrinsics.checkNotNullParameter(logLevel, "<set-?>");
            this.logLevel = logLevel;
        }

        public final void setReadTimeoutMs(long j) {
            this.readTimeoutMs = j;
        }

        public final void setRequiredFiles(Collection<? extends MrtdFileType> collection) {
            Intrinsics.checkNotNullParameter(collection, "<set-?>");
            this.requiredFiles = collection;
        }

        public final void setReusable(boolean z) {
            this.reusable = z;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MrtdReaderConfig(MrtdAuthentication mrtdAuthentication, Collection<? extends MrtdFileType> collection, long j, int i, ExtendedLengthSetting extendedLengthSetting, int i2, boolean z) {
        this.authentication = mrtdAuthentication;
        this.requiredFiles = collection;
        this.readTimeoutMs = j;
        this.readBlockSize = i;
        this.extendedLengthSupport = extendedLengthSetting;
        this.minLevelToLog = i2;
        this.reusable = z;
    }

    public /* synthetic */ MrtdReaderConfig(MrtdAuthentication mrtdAuthentication, Collection collection, long j, int i, ExtendedLengthSetting extendedLengthSetting, int i2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(mrtdAuthentication, collection, j, i, extendedLengthSetting, i2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MrtdAuthentication getAuthentication() {
        return this.authentication;
    }

    public final Collection<MrtdFileType> component2() {
        return this.requiredFiles;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getReadTimeoutMs() {
        return this.readTimeoutMs;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getReadBlockSize() {
        return this.readBlockSize;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ExtendedLengthSetting getExtendedLengthSupport() {
        return this.extendedLengthSupport;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getMinLevelToLog() {
        return this.minLevelToLog;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getReusable() {
        return this.reusable;
    }

    public final MrtdReaderConfig copy(MrtdAuthentication authentication, Collection<? extends MrtdFileType> requiredFiles, long readTimeoutMs, int readBlockSize, ExtendedLengthSetting extendedLengthSupport, int minLevelToLog, boolean reusable) {
        Intrinsics.checkNotNullParameter(authentication, "authentication");
        Intrinsics.checkNotNullParameter(requiredFiles, "requiredFiles");
        Intrinsics.checkNotNullParameter(extendedLengthSupport, "extendedLengthSupport");
        return new MrtdReaderConfig(authentication, requiredFiles, readTimeoutMs, readBlockSize, extendedLengthSupport, minLevelToLog, reusable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MrtdReaderConfig)) {
            return false;
        }
        MrtdReaderConfig mrtdReaderConfig = (MrtdReaderConfig) other;
        return Intrinsics.areEqual(this.authentication, mrtdReaderConfig.authentication) && Intrinsics.areEqual(this.requiredFiles, mrtdReaderConfig.requiredFiles) && this.readTimeoutMs == mrtdReaderConfig.readTimeoutMs && this.readBlockSize == mrtdReaderConfig.readBlockSize && this.extendedLengthSupport == mrtdReaderConfig.extendedLengthSupport && this.minLevelToLog == mrtdReaderConfig.minLevelToLog && this.reusable == mrtdReaderConfig.reusable;
    }

    public final MrtdAuthentication getAuthentication() {
        return this.authentication;
    }

    public final ExtendedLengthSetting getExtendedLengthSupport() {
        return this.extendedLengthSupport;
    }

    public final int getMinLevelToLog() {
        return this.minLevelToLog;
    }

    public final int getReadBlockSize() {
        return this.readBlockSize;
    }

    public final long getReadTimeoutMs() {
        return this.readTimeoutMs;
    }

    public final Collection<MrtdFileType> getRequiredFiles() {
        return this.requiredFiles;
    }

    public final boolean getReusable() {
        return this.reusable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public int hashCode() {
        int iHashCode = ((((((((((this.authentication.hashCode() * 31) + this.requiredFiles.hashCode()) * 31) + Long.hashCode(this.readTimeoutMs)) * 31) + Integer.hashCode(this.readBlockSize)) * 31) + this.extendedLengthSupport.hashCode()) * 31) + Integer.hashCode(this.minLevelToLog)) * 31;
        boolean z = this.reusable;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "MrtdReaderConfig(authentication=" + this.authentication + ", requiredFiles=" + this.requiredFiles + ", readTimeoutMs=" + this.readTimeoutMs + ", readBlockSize=" + this.readBlockSize + ", extendedLengthSupport=" + this.extendedLengthSupport + ", minLevelToLog=" + this.minLevelToLog + ", reusable=" + this.reusable + ')';
    }
}
