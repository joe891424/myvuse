package com.yoti.mobile.android.yotisdkcore.core.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentRequirements;", "", "dateFrom", "Ljava/util/Date;", "(Ljava/util/Date;)V", "getDateFrom", "()Ljava/util/Date;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentRequirements {

    @SerializedName("date_from")
    private final Date dateFrom;

    public DocumentRequirements(Date date) {
        this.dateFrom = date;
    }

    public static /* synthetic */ DocumentRequirements copy$default(DocumentRequirements documentRequirements, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            date = documentRequirements.dateFrom;
        }
        return documentRequirements.copy(date);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Date getDateFrom() {
        return this.dateFrom;
    }

    public final DocumentRequirements copy(Date dateFrom) {
        return new DocumentRequirements(dateFrom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DocumentRequirements) && Intrinsics.areEqual(this.dateFrom, ((DocumentRequirements) other).dateFrom);
    }

    public final Date getDateFrom() {
        return this.dateFrom;
    }

    public int hashCode() {
        Date date = this.dateFrom;
        if (date == null) {
            return 0;
        }
        return date.hashCode();
    }

    public String toString() {
        return "DocumentRequirements(dateFrom=" + this.dateFrom + ')';
    }
}
