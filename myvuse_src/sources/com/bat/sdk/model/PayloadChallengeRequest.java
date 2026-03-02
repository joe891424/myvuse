package com.bat.sdk.model;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PayloadChallengeRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, m5598d2 = {"Lcom/bat/sdk/model/PayloadChallengeRequest;", "", "payloadCode", "Lkotlin/UShort;", "<init>", "(SLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPayloadCode-Mh2AYeg", "()S", ExifInterface.LATITUDE_SOUTH, "component1", "component1-Mh2AYeg", "copy", "copy-xj2QHRw", "(S)Lcom/bat/sdk/model/PayloadChallengeRequest;", "equals", "", "other", "hashCode", "", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class PayloadChallengeRequest {
    private final short payloadCode;

    public /* synthetic */ PayloadChallengeRequest(short s, DefaultConstructorMarker defaultConstructorMarker) {
        this(s);
    }

    /* JADX INFO: renamed from: copy-xj2QHRw$default, reason: not valid java name */
    public static /* synthetic */ PayloadChallengeRequest m5919copyxj2QHRw$default(PayloadChallengeRequest payloadChallengeRequest, short s, int i, Object obj) {
        if ((i & 1) != 0) {
            s = payloadChallengeRequest.payloadCode;
        }
        return payloadChallengeRequest.m5921copyxj2QHRw(s);
    }

    /* JADX INFO: renamed from: component1-Mh2AYeg, reason: not valid java name and from getter */
    public final short getPayloadCode() {
        return this.payloadCode;
    }

    /* JADX INFO: renamed from: copy-xj2QHRw, reason: not valid java name */
    public final PayloadChallengeRequest m5921copyxj2QHRw(short payloadCode) {
        return new PayloadChallengeRequest(payloadCode, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PayloadChallengeRequest) && this.payloadCode == ((PayloadChallengeRequest) other).payloadCode;
    }

    public int hashCode() {
        return UShort.m7526hashCodeimpl(this.payloadCode);
    }

    public String toString() {
        return "PayloadChallengeRequest(payloadCode=" + ((Object) UShort.m7558toStringimpl(this.payloadCode)) + ')';
    }

    private PayloadChallengeRequest(short s) {
        this.payloadCode = s;
    }

    /* JADX INFO: renamed from: getPayloadCode-Mh2AYeg, reason: not valid java name */
    public final short m5922getPayloadCodeMh2AYeg() {
        return this.payloadCode;
    }
}
