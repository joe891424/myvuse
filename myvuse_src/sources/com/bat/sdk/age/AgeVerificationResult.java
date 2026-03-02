package com.bat.sdk.age;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AgeVerificationResult.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\n\u000b\f\r\u000eB!\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u0082\u0001\u0005\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, m5598d2 = {"Lcom/bat/sdk/age/AgeVerificationResult;", "", "deviceAddress", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "getMessage", "Unknown", "Locked", "Unlocked", "Success", "Error", "Lcom/bat/sdk/age/AgeVerificationResult$Error;", "Lcom/bat/sdk/age/AgeVerificationResult$Locked;", "Lcom/bat/sdk/age/AgeVerificationResult$Success;", "Lcom/bat/sdk/age/AgeVerificationResult$Unknown;", "Lcom/bat/sdk/age/AgeVerificationResult$Unlocked;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class AgeVerificationResult {
    private final String deviceAddress;
    private final String message;

    public /* synthetic */ AgeVerificationResult(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    private AgeVerificationResult(String str, String str2) {
        this.deviceAddress = str;
        this.message = str2;
    }

    public /* synthetic */ AgeVerificationResult(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, null);
    }

    public String getDeviceAddress() {
        return this.deviceAddress;
    }

    public String getMessage() {
        return this.message;
    }

    /* JADX INFO: compiled from: AgeVerificationResult.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/age/AgeVerificationResult$Unknown;", "Lcom/bat/sdk/age/AgeVerificationResult;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Unknown extends AgeVerificationResult {
        private final String deviceAddress;

        public static /* synthetic */ Unknown copy$default(Unknown unknown, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknown.deviceAddress;
            }
            return unknown.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final Unknown copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new Unknown(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Unknown) && Intrinsics.areEqual(this.deviceAddress, ((Unknown) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "Unknown(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Unknown(String deviceAddress) {
            super(deviceAddress, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.age.AgeVerificationResult
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: AgeVerificationResult.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/age/AgeVerificationResult$Locked;", "Lcom/bat/sdk/age/AgeVerificationResult;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Locked extends AgeVerificationResult {
        private final String deviceAddress;

        public static /* synthetic */ Locked copy$default(Locked locked, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = locked.deviceAddress;
            }
            return locked.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final Locked copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new Locked(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Locked) && Intrinsics.areEqual(this.deviceAddress, ((Locked) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "Locked(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Locked(String deviceAddress) {
            super(deviceAddress, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.age.AgeVerificationResult
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: AgeVerificationResult.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/age/AgeVerificationResult$Unlocked;", "Lcom/bat/sdk/age/AgeVerificationResult;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Unlocked extends AgeVerificationResult {
        private final String deviceAddress;

        public static /* synthetic */ Unlocked copy$default(Unlocked unlocked, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unlocked.deviceAddress;
            }
            return unlocked.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        public final Unlocked copy(String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new Unlocked(deviceAddress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Unlocked) && Intrinsics.areEqual(this.deviceAddress, ((Unlocked) other).deviceAddress);
        }

        public int hashCode() {
            return this.deviceAddress.hashCode();
        }

        public String toString() {
            return "Unlocked(deviceAddress=" + this.deviceAddress + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Unlocked(String deviceAddress) {
            super(deviceAddress, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
        }

        @Override // com.bat.sdk.age.AgeVerificationResult
        public String getDeviceAddress() {
            return this.deviceAddress;
        }
    }

    /* JADX INFO: compiled from: AgeVerificationResult.kt */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m5598d2 = {"Lcom/bat/sdk/age/AgeVerificationResult$Success;", "Lcom/bat/sdk/age/AgeVerificationResult;", "deviceAddress", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "getMessage", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final /* data */ class Success extends AgeVerificationResult {
        private final String deviceAddress;
        private final String message;

        public static /* synthetic */ Success copy$default(Success success, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.deviceAddress;
            }
            if ((i & 2) != 0) {
                str2 = success.message;
            }
            return success.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceAddress() {
            return this.deviceAddress;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Success copy(String deviceAddress, String message) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            return new Success(deviceAddress, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.deviceAddress, success.deviceAddress) && Intrinsics.areEqual(this.message, success.message);
        }

        public int hashCode() {
            int iHashCode = this.deviceAddress.hashCode() * 31;
            String str = this.message;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Success(deviceAddress=" + this.deviceAddress + ", message=" + this.message + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String deviceAddress, String str) {
            super(deviceAddress, str, null);
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            this.deviceAddress = deviceAddress;
            this.message = str;
        }

        @Override // com.bat.sdk.age.AgeVerificationResult
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        @Override // com.bat.sdk.age.AgeVerificationResult
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: AgeVerificationResult.kt */
    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0015\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, m5598d2 = {"Lcom/bat/sdk/age/AgeVerificationResult$Error;", "Lcom/bat/sdk/age/AgeVerificationResult;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "CharacteristicsAreNotReady", "Generic", "ErrorAPI", "Lcom/bat/sdk/age/AgeVerificationResult$Error$CharacteristicsAreNotReady;", "Lcom/bat/sdk/age/AgeVerificationResult$Error$ErrorAPI;", "Lcom/bat/sdk/age/AgeVerificationResult$Error$Generic;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static abstract class Error extends AgeVerificationResult {
        private final String deviceAddress;

        public /* synthetic */ Error(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Error(String str) {
            super(str, null, 2, 0 == true ? 1 : 0);
            this.deviceAddress = str;
        }

        public /* synthetic */ Error(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, null);
        }

        @Override // com.bat.sdk.age.AgeVerificationResult
        public String getDeviceAddress() {
            return this.deviceAddress;
        }

        /* JADX INFO: compiled from: AgeVerificationResult.kt */
        @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/age/AgeVerificationResult$Error$CharacteristicsAreNotReady;", "Lcom/bat/sdk/age/AgeVerificationResult$Error;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final /* data */ class CharacteristicsAreNotReady extends Error {
            private final String deviceAddress;

            public static /* synthetic */ CharacteristicsAreNotReady copy$default(CharacteristicsAreNotReady characteristicsAreNotReady, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = characteristicsAreNotReady.deviceAddress;
                }
                return characteristicsAreNotReady.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getDeviceAddress() {
                return this.deviceAddress;
            }

            public final CharacteristicsAreNotReady copy(String deviceAddress) {
                Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
                return new CharacteristicsAreNotReady(deviceAddress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CharacteristicsAreNotReady) && Intrinsics.areEqual(this.deviceAddress, ((CharacteristicsAreNotReady) other).deviceAddress);
            }

            public int hashCode() {
                return this.deviceAddress.hashCode();
            }

            public String toString() {
                return "CharacteristicsAreNotReady(deviceAddress=" + this.deviceAddress + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CharacteristicsAreNotReady(String deviceAddress) {
                super(deviceAddress, null);
                Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
                this.deviceAddress = deviceAddress;
            }

            @Override // com.bat.sdk.age.AgeVerificationResult.Error, com.bat.sdk.age.AgeVerificationResult
            public String getDeviceAddress() {
                return this.deviceAddress;
            }
        }

        /* JADX INFO: compiled from: AgeVerificationResult.kt */
        @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/age/AgeVerificationResult$Error$Generic;", "Lcom/bat/sdk/age/AgeVerificationResult$Error;", "deviceAddress", "", "<init>", "(Ljava/lang/String;)V", "getDeviceAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final /* data */ class Generic extends Error {
            private final String deviceAddress;

            public static /* synthetic */ Generic copy$default(Generic generic, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = generic.deviceAddress;
                }
                return generic.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getDeviceAddress() {
                return this.deviceAddress;
            }

            public final Generic copy(String deviceAddress) {
                Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
                return new Generic(deviceAddress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Generic) && Intrinsics.areEqual(this.deviceAddress, ((Generic) other).deviceAddress);
            }

            public int hashCode() {
                return this.deviceAddress.hashCode();
            }

            public String toString() {
                return "Generic(deviceAddress=" + this.deviceAddress + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Generic(String deviceAddress) {
                super(deviceAddress, null);
                Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
                this.deviceAddress = deviceAddress;
            }

            @Override // com.bat.sdk.age.AgeVerificationResult.Error, com.bat.sdk.age.AgeVerificationResult
            public String getDeviceAddress() {
                return this.deviceAddress;
            }
        }

        /* JADX INFO: compiled from: AgeVerificationResult.kt */
        @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/age/AgeVerificationResult$Error$ErrorAPI;", "Lcom/bat/sdk/age/AgeVerificationResult$Error;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final /* data */ class ErrorAPI extends Error {
            private final String message;

            public static /* synthetic */ ErrorAPI copy$default(ErrorAPI errorAPI, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = errorAPI.message;
                }
                return errorAPI.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public final ErrorAPI copy(String message) {
                return new ErrorAPI(message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ErrorAPI) && Intrinsics.areEqual(this.message, ((ErrorAPI) other).message);
            }

            public int hashCode() {
                String str = this.message;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "ErrorAPI(message=" + this.message + ')';
            }

            public ErrorAPI(String str) {
                super(str, null);
                this.message = str;
            }

            @Override // com.bat.sdk.age.AgeVerificationResult
            public String getMessage() {
                return this.message;
            }
        }
    }
}
