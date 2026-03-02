package com.bat.sdk.asav.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AsavStatus.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, m5598d2 = {"Lcom/bat/sdk/asav/core/AsavStatus;", "", "<init>", "()V", "Idle", "ChallengeRequest", "ChallengeResponse", "SignatureRequest", "SignatureResponse", "Lcom/bat/sdk/asav/core/AsavStatus$ChallengeRequest;", "Lcom/bat/sdk/asav/core/AsavStatus$ChallengeResponse;", "Lcom/bat/sdk/asav/core/AsavStatus$Idle;", "Lcom/bat/sdk/asav/core/AsavStatus$SignatureRequest;", "Lcom/bat/sdk/asav/core/AsavStatus$SignatureResponse;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class AsavStatus {
    public /* synthetic */ AsavStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: AsavStatus.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/asav/core/AsavStatus$Idle;", "Lcom/bat/sdk/asav/core/AsavStatus;", "<init>", "()V", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Idle extends AsavStatus {
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }

        public String toString() {
            return "<Idle>";
        }
    }

    private AsavStatus() {
    }

    /* JADX INFO: compiled from: AsavStatus.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/asav/core/AsavStatus$ChallengeRequest;", "Lcom/bat/sdk/asav/core/AsavStatus;", "<init>", "()V", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class ChallengeRequest extends AsavStatus {
        public static final ChallengeRequest INSTANCE = new ChallengeRequest();

        private ChallengeRequest() {
            super(null);
        }

        public String toString() {
            return "<Challenge request>";
        }
    }

    /* JADX INFO: compiled from: AsavStatus.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/asav/core/AsavStatus$ChallengeResponse;", "Lcom/bat/sdk/asav/core/AsavStatus;", "<init>", "()V", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class ChallengeResponse extends AsavStatus {
        public static final ChallengeResponse INSTANCE = new ChallengeResponse();

        private ChallengeResponse() {
            super(null);
        }

        public String toString() {
            return "<Challenge response>";
        }
    }

    /* JADX INFO: compiled from: AsavStatus.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/asav/core/AsavStatus$SignatureRequest;", "Lcom/bat/sdk/asav/core/AsavStatus;", "<init>", "()V", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class SignatureRequest extends AsavStatus {
        public static final SignatureRequest INSTANCE = new SignatureRequest();

        private SignatureRequest() {
            super(null);
        }

        public String toString() {
            return "<Signature request>";
        }
    }

    /* JADX INFO: compiled from: AsavStatus.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/asav/core/AsavStatus$SignatureResponse;", "Lcom/bat/sdk/asav/core/AsavStatus;", "<init>", "()V", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class SignatureResponse extends AsavStatus {
        public static final SignatureResponse INSTANCE = new SignatureResponse();

        private SignatureResponse() {
            super(null);
        }

        public String toString() {
            return "<Signature response>";
        }
    }
}
