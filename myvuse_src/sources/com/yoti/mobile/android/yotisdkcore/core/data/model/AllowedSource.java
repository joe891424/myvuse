package com.yoti.mobile.android.yotisdkcore.core.data.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AllowedSource;", "", "_sourceType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/SourceType;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/model/SourceType;)V", "get_sourceType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/SourceType;", "sourceType", "getSourceType", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class AllowedSource {

    @SerializedName("type")
    private final SourceType _sourceType;

    /* JADX WARN: Multi-variable type inference failed */
    public AllowedSource() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public AllowedSource(SourceType sourceType) {
        this._sourceType = sourceType;
    }

    public /* synthetic */ AllowedSource(SourceType sourceType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sourceType);
    }

    public static /* synthetic */ AllowedSource copy$default(AllowedSource allowedSource, SourceType sourceType, int i, Object obj) {
        if ((i & 1) != 0) {
            sourceType = allowedSource._sourceType;
        }
        return allowedSource.copy(sourceType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SourceType get_sourceType() {
        return this._sourceType;
    }

    public final AllowedSource copy(SourceType _sourceType) {
        return new AllowedSource(_sourceType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AllowedSource) && this._sourceType == ((AllowedSource) other)._sourceType;
    }

    public final SourceType getSourceType() {
        SourceType sourceType = this._sourceType;
        return sourceType == null ? SourceType.UNKNOWN : sourceType;
    }

    public final SourceType get_sourceType() {
        return this._sourceType;
    }

    public int hashCode() {
        SourceType sourceType = this._sourceType;
        if (sourceType == null) {
            return 0;
        }
        return sourceType.hashCode();
    }

    public String toString() {
        return "AllowedSource(_sourceType=" + this._sourceType + ')';
    }
}
