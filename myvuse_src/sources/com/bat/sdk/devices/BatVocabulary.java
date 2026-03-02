package com.bat.sdk.devices;

import kotlin.Metadata;

/* JADX INFO: compiled from: BatVocabulary.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u000b\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u000f"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary;", "", "<init>", "()V", "EPod", "Alto2", "Aquila", "AquilaNS", "EPod2", "EPod3", "EPen", "VPro", "DFU", "SmartBox", "SmartBoxUS", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class BatVocabulary {
    public static final BatVocabulary INSTANCE = new BatVocabulary();

    private BatVocabulary() {
    }

    /* JADX INFO: compiled from: BatVocabulary.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$EPod;", "", "<init>", "()V", "Services", "Characteristics", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class EPod {
        public static final EPod INSTANCE = new EPod();

        private EPod() {
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$EPod$Services;", "", "<init>", "()V", "vapingService", "", "logService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Services {
            public static final Services INSTANCE = new Services();
            public static final String logService = "6CD6C8B5-E378-0103-000B-1B9740683449";
            public static final String vapingService = "6CD6C8B5-E378-0103-000A-1B9740683449";

            private Services() {
            }
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$EPod$Characteristics;", "", "<init>", "()V", "deviceInfoCharacteristic", "", "timeCharacteristic", "lockCharacteristic", "batteryCharacteristic", "puffsCharacteristic", "cloudCharacteristic", "findCharacteristic", "ledCharacteristic", "resetCharacteristic", "errorCharacteristic", "logCharacteristic", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Characteristics {
            public static final Characteristics INSTANCE = new Characteristics();
            public static final String batteryCharacteristic = "6CD6C8B5-E378-0103-030A-1B9740683449";
            public static final String cloudCharacteristic = "6CD6C8B5-E378-0103-0C0A-1B9740683449";
            public static final String deviceInfoCharacteristic = "6CD6C8B5-E378-0103-010A-1B9740683449";
            public static final String errorCharacteristic = "6CD6C8B5-E378-0103-010B-1B9740683449";
            public static final String findCharacteristic = "6CD6C8B5-E378-0103-090A-1B9740683449";
            public static final String ledCharacteristic = "6CD6C8B5-E378-0103-0A0A-1B9740683449";
            public static final String lockCharacteristic = "6CD6C8B5-E378-0103-040A-1B9740683449";
            public static final String logCharacteristic = "6CD6C8B5-E378-0103-030B-1B9740683449";
            public static final String puffsCharacteristic = "6CD6C8B5-E378-0103-060A-1B9740683449";
            public static final String resetCharacteristic = "6CD6C8B5-E378-0103-0B0A-1B9740683449";
            public static final String timeCharacteristic = "6CD6C8B5-E378-0103-020A-1B9740683449";

            private Characteristics() {
            }
        }
    }

    /* JADX INFO: compiled from: BatVocabulary.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$Alto2;", "", "<init>", "()V", "Services", "Characteristics", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Alto2 {
        public static final Alto2 INSTANCE = new Alto2();

        private Alto2() {
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$Alto2$Services;", "", "<init>", "()V", "vapingService", "", "logService", "ageVerificationService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Services {
            public static final Services INSTANCE = new Services();
            public static final String ageVerificationService = "6CD6C8B5-E378-0107-000D-1B9740683449";
            public static final String logService = "6CD6C8B5-E378-0107-000B-1B9740683449";
            public static final String vapingService = "6CD6C8B5-E378-0107-000A-1B9740683449";

            private Services() {
            }
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$Alto2$Characteristics;", "", "<init>", "()V", "deviceInfoCharacteristic", "", "timeCharacteristic", "batteryCharacteristic", "lockCharacteristic", "findCharacteristic", "ledCharacteristic", "resetCharacteristic", "hapticCharacteristic", "bleTimeoutCharacteristic", "errorCharacteristic", "logCharacteristic", "ageChallengeCharacteristic", "ageSignatureCharacteristic", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Characteristics {
            public static final Characteristics INSTANCE = new Characteristics();
            public static final String ageChallengeCharacteristic = "6CD6C8B5-E378-0107-010D-1B9740683449";
            public static final String ageSignatureCharacteristic = "6CD6C8B5-E378-0107-020D-1B9740683449";
            public static final String batteryCharacteristic = "6CD6C8B5-E378-0107-030A-1B9740683449";
            public static final String bleTimeoutCharacteristic = "6CD6C8B5-E378-0107-0E0A-1B9740683449";
            public static final String deviceInfoCharacteristic = "6CD6C8B5-E378-0107-010A-1B9740683449";
            public static final String errorCharacteristic = "6CD6C8B5-E378-0107-010B-1B9740683449";
            public static final String findCharacteristic = "6CD6C8B5-E378-0107-090A-1B9740683449";
            public static final String hapticCharacteristic = "6CD6C8B5-E378-0107-0D0A-1B9740683449";
            public static final String ledCharacteristic = "6CD6C8B5-E378-0107-0A0A-1B9740683449";
            public static final String lockCharacteristic = "6CD6C8B5-E378-0107-040A-1B9740683449";
            public static final String logCharacteristic = "6CD6C8B5-E378-0107-030B-1B9740683449";
            public static final String resetCharacteristic = "6CD6C8B5-E378-0107-0B0A-1B9740683449";
            public static final String timeCharacteristic = "6CD6C8B5-E378-0107-020A-1B9740683449";

            private Characteristics() {
            }
        }
    }

    /* JADX INFO: compiled from: BatVocabulary.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$Aquila;", "", "<init>", "()V", "Services", "Characteristics", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Aquila {
        public static final Aquila INSTANCE = new Aquila();

        private Aquila() {
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$Aquila$Services;", "", "<init>", "()V", "vapingService", "", "logService", "ageVerificationService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Services {
            public static final Services INSTANCE = new Services();
            public static final String ageVerificationService = "6CD6C8B5-E378-010C-000D-1B9740683449";
            public static final String logService = "6CD6C8B5-E378-010C-000B-1B9740683449";
            public static final String vapingService = "6CD6C8B5-E378-010C-000A-1B9740683449";

            private Services() {
            }
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$Aquila$Characteristics;", "", "<init>", "()V", "deviceInfoCharacteristic", "", "timeCharacteristic", "batteryCharacteristic", "lockCharacteristic", "findCharacteristic", "ledCharacteristic", "resetCharacteristic", "hapticCharacteristic", "bleTimeoutCharacteristic", "errorCharacteristic", "logCharacteristic", "ageChallengeCharacteristic", "ageSignatureCharacteristic", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Characteristics {
            public static final Characteristics INSTANCE = new Characteristics();
            public static final String ageChallengeCharacteristic = "6CD6C8B5-E378-010C-010D-1B9740683449";
            public static final String ageSignatureCharacteristic = "6CD6C8B5-E378-010C-020D-1B9740683449";
            public static final String batteryCharacteristic = "6CD6C8B5-E378-010C-030A-1B9740683449";
            public static final String bleTimeoutCharacteristic = "6CD6C8B5-E378-010C-0E0A-1B9740683449";
            public static final String deviceInfoCharacteristic = "6CD6C8B5-E378-010C-010A-1B9740683449";
            public static final String errorCharacteristic = "6CD6C8B5-E378-010C-010B-1B9740683449";
            public static final String findCharacteristic = "6CD6C8B5-E378-010C-090A-1B9740683449";
            public static final String hapticCharacteristic = "6CD6C8B5-E378-010C-0D0A-1B9740683449";
            public static final String ledCharacteristic = "6CD6C8B5-E378-010C-0A0A-1B9740683449";
            public static final String lockCharacteristic = "6CD6C8B5-E378-010C-040A-1B9740683449";
            public static final String logCharacteristic = "6CD6C8B5-E378-010C-030B-1B9740683449";
            public static final String resetCharacteristic = "6CD6C8B5-E378-010C-0B0A-1B9740683449";
            public static final String timeCharacteristic = "6CD6C8B5-E378-010C-020A-1B9740683449";

            private Characteristics() {
            }
        }
    }

    /* JADX INFO: compiled from: BatVocabulary.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$AquilaNS;", "", "<init>", "()V", "Services", "Characteristics", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class AquilaNS {
        public static final AquilaNS INSTANCE = new AquilaNS();

        private AquilaNS() {
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$AquilaNS$Services;", "", "<init>", "()V", "vapingService", "", "logService", "ageVerificationService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Services {
            public static final Services INSTANCE = new Services();
            public static final String ageVerificationService = "6CD6C8B5-E378-010F-000D-1B9740683449";
            public static final String logService = "6CD6C8B5-E378-010F-000B-1B9740683449";
            public static final String vapingService = "6CD6C8B5-E378-010F-000A-1B9740683449";

            private Services() {
            }
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$AquilaNS$Characteristics;", "", "<init>", "()V", "deviceInfoCharacteristic", "", "timeCharacteristic", "batteryCharacteristic", "lockCharacteristic", "autoLockEnableCharacteristic", "puffsCharacteristic", "powerSaveModeCharacteristic", "findCharacteristic", "ledCharacteristic", "resetCharacteristic", "cloudCharacteristic", "hapticCharacteristic", "bleTimeoutCharacteristic", "rechargeRemindersCharacteristic", "errorCharacteristic", "logCharacteristic", "ageChallengeCharacteristic", "ageSignatureCharacteristic", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Characteristics {
            public static final Characteristics INSTANCE = new Characteristics();
            public static final String ageChallengeCharacteristic = "6CD6C8B5-E378-010F-010D-1B9740683449";
            public static final String ageSignatureCharacteristic = "6CD6C8B5-E378-010F-020D-1B9740683449";
            public static final String autoLockEnableCharacteristic = "6CD6C8B5-E378-010F-050A-1B9740683449";
            public static final String batteryCharacteristic = "6CD6C8B5-E378-010F-030A-1B9740683449";
            public static final String bleTimeoutCharacteristic = "6CD6C8B5-E378-010F-0E0A-1B9740683449";
            public static final String cloudCharacteristic = "6CD6C8B5-E378-010F-0C0A-1B9740683449";
            public static final String deviceInfoCharacteristic = "6CD6C8B5-E378-010F-010A-1B9740683449";
            public static final String errorCharacteristic = "6CD6C8B5-E378-010F-010B-1B9740683449";
            public static final String findCharacteristic = "6CD6C8B5-E378-010F-090A-1B9740683449";
            public static final String hapticCharacteristic = "6CD6C8B5-E378-010F-0D0A-1B9740683449";
            public static final String ledCharacteristic = "6CD6C8B5-E378-010F-0A0A-1B9740683449";
            public static final String lockCharacteristic = "6CD6C8B5-E378-010F-040A-1B9740683449";
            public static final String logCharacteristic = "6CD6C8B5-E378-010F-030B-1B9740683449";
            public static final String powerSaveModeCharacteristic = "6CD6C8B5-E378-010F-070A-1B9740683449";
            public static final String puffsCharacteristic = "6CD6C8B5-E378-010F-060A-1B9740683449";
            public static final String rechargeRemindersCharacteristic = "6CD6C8B5-E378-010F-0F0A-1B9740683449";
            public static final String resetCharacteristic = "6CD6C8B5-E378-010F-0B0A-1B9740683449";
            public static final String timeCharacteristic = "6CD6C8B5-E378-010F-020A-1B9740683449";

            private Characteristics() {
            }
        }
    }

    /* JADX INFO: compiled from: BatVocabulary.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$EPod2;", "", "<init>", "()V", "Services", "Characteristics", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class EPod2 {
        public static final EPod2 INSTANCE = new EPod2();

        private EPod2() {
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$EPod2$Services;", "", "<init>", "()V", "vapingService", "", "logService", "deviceManagementService", "ageVerificationService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Services {
            public static final Services INSTANCE = new Services();
            public static final String ageVerificationService = "6CD6C8B5-E378-0104-000D-1B9740683449";
            public static final String deviceManagementService = "6CD6C8B5-E378-0104-000C-1B9740683449";
            public static final String logService = "6CD6C8B5-E378-0104-000B-1B9740683449";
            public static final String vapingService = "6CD6C8B5-E378-0104-000A-1B9740683449";

            private Services() {
            }
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$EPod2$Characteristics;", "", "<init>", "()V", "deviceInfoCharacteristic", "", "timeCharacteristic", "batteryCharacteristic", "lockCharacteristic", "puffsCharacteristic", "cloudCharacteristic", "findCharacteristic", "ledCharacteristic", "resetCharacteristic", "hapticCharacteristic", "errorCharacteristic", "logCharacteristic", "versionCharacteristic", "controlCharacteristic", "payloadCharacteristic", "payloadChallengeCharacteristic", "ageChallengeCharacteristic", "ageSignatureCharacteristic", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Characteristics {
            public static final Characteristics INSTANCE = new Characteristics();
            public static final String ageChallengeCharacteristic = "6CD6C8B5-E378-0104-010D-1B9740683449";
            public static final String ageSignatureCharacteristic = "6CD6C8B5-E378-0104-020D-1B9740683449";
            public static final String batteryCharacteristic = "6CD6C8B5-E378-0104-030A-1B9740683449";
            public static final String cloudCharacteristic = "6CD6C8B5-E378-0104-0C0A-1B9740683449";
            public static final String controlCharacteristic = "6CD6C8B5-E378-0104-020C-1B9740683449";
            public static final String deviceInfoCharacteristic = "6CD6C8B5-E378-0104-010A-1B9740683449";
            public static final String errorCharacteristic = "6CD6C8B5-E378-0104-010B-1B9740683449";
            public static final String findCharacteristic = "6CD6C8B5-E378-0104-090A-1B9740683449";
            public static final String hapticCharacteristic = "6CD6C8B5-E378-0104-0D0A-1B9740683449";
            public static final String ledCharacteristic = "6CD6C8B5-E378-0104-0A0A-1B9740683449";
            public static final String lockCharacteristic = "6CD6C8B5-E378-0104-040A-1B9740683449";
            public static final String logCharacteristic = "6CD6C8B5-E378-0104-030B-1B9740683449";
            public static final String payloadChallengeCharacteristic = "6CD6C8B5-E378-0104-040C-1B9740683449";
            public static final String payloadCharacteristic = "6CD6C8B5-E378-0104-030C-1B9740683449";
            public static final String puffsCharacteristic = "6CD6C8B5-E378-0104-060A-1B9740683449";
            public static final String resetCharacteristic = "6CD6C8B5-E378-0104-0B0A-1B9740683449";
            public static final String timeCharacteristic = "6CD6C8B5-E378-0104-020A-1B9740683449";
            public static final String versionCharacteristic = "6CD6C8B5-E378-0104-010C-1B9740683449";

            private Characteristics() {
            }
        }
    }

    /* JADX INFO: compiled from: BatVocabulary.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$EPod3;", "", "<init>", "()V", "Services", "Characteristics", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class EPod3 {
        public static final EPod3 INSTANCE = new EPod3();

        private EPod3() {
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$EPod3$Services;", "", "<init>", "()V", "vapingService", "", "logService", "deviceManagementService", "ageVerificationService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Services {
            public static final Services INSTANCE = new Services();
            public static final String ageVerificationService = "6CD6C8B5-E378-0106-000D-1B9740683449";
            public static final String deviceManagementService = "6CD6C8B5-E378-0106-000C-1B9740683449";
            public static final String logService = "6CD6C8B5-E378-0106-000B-1B9740683449";
            public static final String vapingService = "6CD6C8B5-E378-0106-000A-1B9740683449";

            private Services() {
            }
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$EPod3$Characteristics;", "", "<init>", "()V", "deviceInfoCharacteristic", "", "timeCharacteristic", "batteryCharacteristic", "lockCharacteristic", "puffsCharacteristic", "usageReminderCharacteristic", "cloudCharacteristic", "findCharacteristic", "ledCharacteristic", "resetCharacteristic", "hapticCharacteristic", "buzzerCharacteristic", "podCharacteristic", "errorCharacteristic", "logCharacteristic", "versionCharacteristic", "controlCharacteristic", "payloadCharacteristic", "payloadChallengeCharacteristic", "ageChallengeCharacteristic", "ageSignatureCharacteristic", "rechargeRemindersCharacteristic", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Characteristics {
            public static final Characteristics INSTANCE = new Characteristics();
            public static final String ageChallengeCharacteristic = "6CD6C8B5-E378-0106-010D-1B9740683449";
            public static final String ageSignatureCharacteristic = "6CD6C8B5-E378-0106-020D-1B9740683449";
            public static final String batteryCharacteristic = "6CD6C8B5-E378-0106-030A-1B9740683449";
            public static final String buzzerCharacteristic = "6CD6C8B5-E378-0106-0E0A-1B9740683449";
            public static final String cloudCharacteristic = "6CD6C8B5-E378-0106-0C0A-1B9740683449";
            public static final String controlCharacteristic = "6CD6C8B5-E378-0106-020C-1B9740683449";
            public static final String deviceInfoCharacteristic = "6CD6C8B5-E378-0106-010A-1B9740683449";
            public static final String errorCharacteristic = "6CD6C8B5-E378-0106-010B-1B9740683449";
            public static final String findCharacteristic = "6CD6C8B5-E378-0106-090A-1B9740683449";
            public static final String hapticCharacteristic = "6CD6C8B5-E378-0106-0D0A-1B9740683449";
            public static final String ledCharacteristic = "6CD6C8B5-E378-0106-0A0A-1B9740683449";
            public static final String lockCharacteristic = "6CD6C8B5-E378-0106-040A-1B9740683449";
            public static final String logCharacteristic = "6CD6C8B5-E378-0106-030B-1B9740683449";
            public static final String payloadChallengeCharacteristic = "6CD6C8B5-E378-0106-040C-1B9740683449";
            public static final String payloadCharacteristic = "6CD6C8B5-E378-0106-030C-1B9740683449";
            public static final String podCharacteristic = "6CD6C8B5-E378-0106-0F0A-1B9740683449";
            public static final String puffsCharacteristic = "6CD6C8B5-E378-0106-060A-1B9740683449";
            public static final String rechargeRemindersCharacteristic = "6CD6C8B5-E378-0106-100A-1B9740683449";
            public static final String resetCharacteristic = "6CD6C8B5-E378-0106-0B0A-1B9740683449";
            public static final String timeCharacteristic = "6CD6C8B5-E378-0106-020A-1B9740683449";
            public static final String usageReminderCharacteristic = "6CD6C8B5-E378-0106-110A-1B9740683449";
            public static final String versionCharacteristic = "6CD6C8B5-E378-0106-010C-1B9740683449";

            private Characteristics() {
            }
        }
    }

    /* JADX INFO: compiled from: BatVocabulary.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$EPen;", "", "<init>", "()V", "Services", "Characteristics", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class EPen {
        public static final EPen INSTANCE = new EPen();

        private EPen() {
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$EPen$Services;", "", "<init>", "()V", "deviceInfoService", "", "batteryService", "sensorDataService", "cartomiserService", "accelerometerService", "vapeDeviceService", "uartService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Services {
            public static final Services INSTANCE = new Services();
            public static final String accelerometerService = "97cedcb4-984c-11ea-bb37-0242ac130002";
            public static final String batteryService = "0000180f-0000-1000-8000-00805f9b34fb";
            public static final String cartomiserService = "97cedbce-984c-11ea-bb37-0242ac130002";
            public static final String deviceInfoService = "0000180a-0000-1000-8000-00805f9b34fb";
            public static final String sensorDataService = "97ceda70-984c-11ea-bb37-0242ac130002";
            public static final String uartService = "6e400001-b5a3-f393-e0a9-e50e24dcca9e";
            public static final String vapeDeviceService = "97cedf7a-984c-11ea-bb37-0242ac130002";

            private Services() {
            }
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b#\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006("}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$EPen$Characteristics;", "", "<init>", "()V", "modelCharacteristic", "", "serialNumberCharacteristic", "firmwareRevisionCharacteristic", "hardwareRevisionCharacteristic", "softwareRevisionCharacteristic", "manufacturerCharacteristic", "batteryLevelCharacteristic", "coilActivationCharacteristic", "pressureSensorCharacteristic", "pressureThresholdCharacteristic", "bufferTimeoutCharacteristic", "cartomiserIdCharacteristic", "flavourIdCharacteristic", "joulesRemainingCharacteristic", "totalPuffsCharacteristic", "totalUseTimeCharacteristic", "devicePowerLevelCharacteristic", "cartomiserPresentCharacteristic", "accelerometerXCharacteristic", "accelerometerYCharacteristic", "accelerometerZCharacteristic", "accelerometerSensitivityCharacteristic", "rotationXCharacteristic", "rotationYCharacteristic", "rotationZCharacteristic", "gyroscopeSensitivityCharacteristic", "accelerometerInterruptCharacteristic", "deviceControlCharacteristic", "deviceTimeCharacteristic", "deviceStateCharacteristic", "recordsAvailableCharacteristic", "eventsAvailableCharacteristic", "deviceChargingCharacteristic", "rxCharacteristic", "txCharacteristic", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Characteristics {
            public static final Characteristics INSTANCE = new Characteristics();
            public static final String accelerometerInterruptCharacteristic = "97cedcbd-984c-11ea-bb37-0242ac130002";
            public static final String accelerometerSensitivityCharacteristic = "97cedcb8-984c-11ea-bb37-0242ac130002";
            public static final String accelerometerXCharacteristic = "97cedcb5-984c-11ea-bb37-0242ac130002";
            public static final String accelerometerYCharacteristic = "97cedcb6-984c-11ea-bb37-0242ac130002";
            public static final String accelerometerZCharacteristic = "97cedcb7-984c-11ea-bb37-0242ac130002";
            public static final String batteryLevelCharacteristic = "00002a19-0000-1000-8000-00805f9b34fb";
            public static final String bufferTimeoutCharacteristic = "97ceda74-984c-11ea-bb37-0242ac130002";
            public static final String cartomiserIdCharacteristic = "97cedbcf-984c-11ea-bb37-0242ac130002";
            public static final String cartomiserPresentCharacteristic = "97cedbd5-984c-11ea-bb37-0242ac130002";
            public static final String coilActivationCharacteristic = "97ceda71-984c-11ea-bb37-0242ac130002";
            public static final String deviceChargingCharacteristic = "97cedf80-984c-11ea-bb37-0242ac130002";
            public static final String deviceControlCharacteristic = "97cedf7b-984c-11ea-bb37-0242ac130002";
            public static final String devicePowerLevelCharacteristic = "97cedbd4-984c-11ea-bb37-0242ac130002";
            public static final String deviceStateCharacteristic = "97cedf7d-984c-11ea-bb37-0242ac130002";
            public static final String deviceTimeCharacteristic = "97cedf7c-984c-11ea-bb37-0242ac130002";
            public static final String eventsAvailableCharacteristic = "97cedf7f-984c-11ea-bb37-0242ac130002";
            public static final String firmwareRevisionCharacteristic = "00002a26-0000-1000-8000-00805f9b34fb";
            public static final String flavourIdCharacteristic = "97cedbd0-984c-11ea-bb37-0242ac130002";
            public static final String gyroscopeSensitivityCharacteristic = "97cedcbc-984c-11ea-bb37-0242ac130002";
            public static final String hardwareRevisionCharacteristic = "00002a27-0000-1000-8000-00805f9b34fb";
            public static final String joulesRemainingCharacteristic = "97cedbd1-984c-11ea-bb37-0242ac130002";
            public static final String manufacturerCharacteristic = "00002a29-0000-1000-8000-00805f9b34fb";
            public static final String modelCharacteristic = "00002a24-0000-1000-8000-00805f9b34fb";
            public static final String pressureSensorCharacteristic = "97ceda72-984c-11ea-bb37-0242ac130002";
            public static final String pressureThresholdCharacteristic = "97ceda73-984c-11ea-bb37-0242ac130002";
            public static final String recordsAvailableCharacteristic = "97cedf7e-984c-11ea-bb37-0242ac130002";
            public static final String rotationXCharacteristic = "97cedcb9-984c-11ea-bb37-0242ac130002";
            public static final String rotationYCharacteristic = "97cedcba-984c-11ea-bb37-0242ac130002";
            public static final String rotationZCharacteristic = "97cedcbb-984c-11ea-bb37-0242ac130002";
            public static final String rxCharacteristic = "6e400002-b5a3-f393-e0a9-e50e24dcca9e";
            public static final String serialNumberCharacteristic = "00002a25-0000-1000-8000-00805f9b34fb";
            public static final String softwareRevisionCharacteristic = "00002a28-0000-1000-8000-00805f9b34fb";
            public static final String totalPuffsCharacteristic = "97cedbd2-984c-11ea-bb37-0242ac130002";
            public static final String totalUseTimeCharacteristic = "97cedbd3-984c-11ea-bb37-0242ac130002";
            public static final String txCharacteristic = "6e400003-b5a3-f393-e0a9-e50e24dcca9e";

            private Characteristics() {
            }
        }
    }

    /* JADX INFO: compiled from: BatVocabulary.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$VPro;", "", "<init>", "()V", "Services", "Characteristics", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class VPro {
        public static final VPro INSTANCE = new VPro();

        private VPro() {
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$VPro$Services;", "", "<init>", "()V", "vapingService", "", "logsService", "fotaService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Services {
            public static final Services INSTANCE = new Services();
            public static final String fotaService = "6CD6C8B5-E378-0105-000C-1B9740683449";
            public static final String logsService = "6CD6C8B5-E378-0105-000B-1B9740683449";
            public static final String vapingService = "6CD6C8B5-E378-0105-000A-1B9740683449";

            private Services() {
            }
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$VPro$Characteristics;", "", "<init>", "()V", "deviceInfoCharacteristic", "", "timeCharacteristic", "lockCharacteristic", "batteryCharacteristic", "puffsCharacteristic", "findCharacteristic", "ledCharacteristic", "cloudCharacteristic", "errorCharacteristic", "logCharacteristic", "otaNewCharacteristic", "otaControlCharacteristic", "otaPayloadCharacteristic", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Characteristics {
            public static final Characteristics INSTANCE = new Characteristics();
            public static final String batteryCharacteristic = "6CD6C8B5-E378-0105-030A-1B9740683449";
            public static final String cloudCharacteristic = "6CD6C8B5-E378-0105-0C0A-1B9740683449";
            public static final String deviceInfoCharacteristic = "6CD6C8B5-E378-0105-010A-1B9740683449";
            public static final String errorCharacteristic = "6CD6C8B5-E378-0105-010B-1B9740683449";
            public static final String findCharacteristic = "6CD6C8B5-E378-0105-090A-1B9740683449";
            public static final String ledCharacteristic = "6CD6C8B5-E378-0105-0A0A-1B9740683449";
            public static final String lockCharacteristic = "6CD6C8B5-E378-0105-040A-1B9740683449";
            public static final String logCharacteristic = "6CD6C8B5-E378-0105-020B-1B9740683449";
            public static final String otaControlCharacteristic = "6CD6C8B5-E378-0105-020C-1B9740683449";
            public static final String otaNewCharacteristic = "6CD6C8B5-E378-0105-010C-1B9740683449";
            public static final String otaPayloadCharacteristic = "6CD6C8B5-E378-0105-030C-1B9740683449";
            public static final String puffsCharacteristic = "6CD6C8B5-E378-0105-060A-1B9740683449";
            public static final String timeCharacteristic = "6CD6C8B5-E378-0105-020A-1B9740683449";

            private Characteristics() {
            }
        }
    }

    /* JADX INFO: compiled from: BatVocabulary.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$DFU;", "", "<init>", "()V", "Services", "Characteristics", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class DFU {
        public static final DFU INSTANCE = new DFU();

        private DFU() {
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$DFU$Services;", "", "<init>", "()V", "genericAccessService", "", "buttonlessSecureDFUService", "genericAttributeService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Services {
            public static final Services INSTANCE = new Services();
            public static final String buttonlessSecureDFUService = "0000fe59-0000-1000-8000-00805f9b34fb";
            public static final String genericAccessService = "00001800-0000-1000-8000-00805f9b34fb";
            public static final String genericAttributeService = "00001801-0000-1000-8000-00805f9b34fb";

            private Services() {
            }
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$DFU$Characteristics;", "", "<init>", "()V", "deviceName", "", "appearance", "peripheralPrefConnParameters", "centralAddressResolution", "serviceChanged", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Characteristics {
            public static final Characteristics INSTANCE = new Characteristics();
            public static final String appearance = "00002A01-0000-1000-8000-00805f9b34fb";
            public static final String centralAddressResolution = "00002A06-0000-1000-8000-00805f9b34fb";
            public static final String deviceName = "00002A00-0000-1000-8000-00805f9b34fb";
            public static final String peripheralPrefConnParameters = "00002A04-0000-1000-8000-00805f9b34fb";
            public static final String serviceChanged = "00002A05-0000-1000-8000-00805f9b34fb";

            private Characteristics() {
            }
        }
    }

    /* JADX INFO: compiled from: BatVocabulary.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$SmartBox;", "", "<init>", "()V", "Services", "Characteristics", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class SmartBox {
        public static final SmartBox INSTANCE = new SmartBox();

        private SmartBox() {
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$SmartBox$Services;", "", "<init>", "()V", "vapingService", "", "logService", "deviceManagementService", "ageVerificationService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Services {
            public static final Services INSTANCE = new Services();
            public static final String ageVerificationService = "6CD6C8B5-E378-0109-000D-1B9740683449";
            public static final String deviceManagementService = "6CD6C8B5-E378-0109-000C-1B9740683449";
            public static final String logService = "6CD6C8B5-E378-0109-000B-1B9740683449";
            public static final String vapingService = "6CD6C8B5-E378-0109-000A-1B9740683449";

            private Services() {
            }
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$SmartBox$Characteristics;", "", "<init>", "()V", "deviceInfoCharacteristic", "", "timeCharacteristic", "batteryCharacteristic", "lockCharacteristic", "puffsCharacteristic", "cloudCharacteristic", "powerSaveModeCharacteristic", "findCharacteristic", "ledCharacteristic", "resetCharacteristic", "hapticCharacteristic", "buzzerCharacteristic", "podCharacteristic", "sessionIndicationCharacteristic", "usageReminderCharacteristic", "errorCharacteristic", "logCharacteristic", "versionCharacteristic", "controlCharacteristic", "payloadCharacteristic", "payloadChallengeCharacteristic", "ageChallengeCharacteristic", "ageSignatureCharacteristic", "rechargeRemindersCharacteristic", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Characteristics {
            public static final Characteristics INSTANCE = new Characteristics();
            public static final String ageChallengeCharacteristic = "6CD6C8B5-E378-0109-010D-1B9740683449";
            public static final String ageSignatureCharacteristic = "6CD6C8B5-E378-0109-020D-1B9740683449";
            public static final String batteryCharacteristic = "6CD6C8B5-E378-0109-030A-1B9740683449";
            public static final String buzzerCharacteristic = "6CD6C8B5-E378-0109-0E0A-1B9740683449";
            public static final String cloudCharacteristic = "6CD6C8B5-E378-0109-0C0A-1B9740683449";
            public static final String controlCharacteristic = "6CD6C8B5-E378-0109-020C-1B9740683449";
            public static final String deviceInfoCharacteristic = "6CD6C8B5-E378-0109-010A-1B9740683449";
            public static final String errorCharacteristic = "6CD6C8B5-E378-0109-010B-1B9740683449";
            public static final String findCharacteristic = "6CD6C8B5-E378-0109-090A-1B9740683449";
            public static final String hapticCharacteristic = "6CD6C8B5-E378-0109-0D0A-1B9740683449";
            public static final String ledCharacteristic = "6CD6C8B5-E378-0109-0A0A-1B9740683449";
            public static final String lockCharacteristic = "6CD6C8B5-E378-0109-040A-1B9740683449";
            public static final String logCharacteristic = "6CD6C8B5-E378-0109-030B-1B9740683449";
            public static final String payloadChallengeCharacteristic = "6CD6C8B5-E378-0109-040C-1B9740683449";
            public static final String payloadCharacteristic = "6CD6C8B5-E378-0109-030C-1B9740683449";
            public static final String podCharacteristic = "6CD6C8B5-E378-0109-0F0A-1B9740683449";
            public static final String powerSaveModeCharacteristic = "6CD6C8B5-E378-0109-100A-1B9740683449";
            public static final String puffsCharacteristic = "6CD6C8B5-E378-0109-060A-1B9740683449";
            public static final String rechargeRemindersCharacteristic = "6CD6C8B5-E378-0109-120A-1B9740683449";
            public static final String resetCharacteristic = "6CD6C8B5-E378-0109-0B0A-1B9740683449";
            public static final String sessionIndicationCharacteristic = "6CD6C8B5-E378-0109-110A-1B9740683449";
            public static final String timeCharacteristic = "6CD6C8B5-E378-0109-020A-1B9740683449";
            public static final String usageReminderCharacteristic = "6CD6C8B5-E378-0109-130A-1B9740683449";
            public static final String versionCharacteristic = "6CD6C8B5-E378-0109-010C-1B9740683449";

            private Characteristics() {
            }
        }
    }

    /* JADX INFO: compiled from: BatVocabulary.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$SmartBoxUS;", "", "<init>", "()V", "Services", "Characteristics", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class SmartBoxUS {
        public static final SmartBoxUS INSTANCE = new SmartBoxUS();

        private SmartBoxUS() {
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$SmartBoxUS$Services;", "", "<init>", "()V", "vapingService", "", "logService", "ageVerificationService", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Services {
            public static final Services INSTANCE = new Services();
            public static final String ageVerificationService = "6CD6C8B5-E378-010D-000D-1B9740683449";
            public static final String logService = "6CD6C8B5-E378-010D-000B-1B9740683449";
            public static final String vapingService = "6CD6C8B5-E378-010D-000A-1B9740683449";

            private Services() {
            }
        }

        /* JADX INFO: compiled from: BatVocabulary.kt */
        @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m5598d2 = {"Lcom/bat/sdk/devices/BatVocabulary$SmartBoxUS$Characteristics;", "", "<init>", "()V", "deviceInfoCharacteristic", "", "timeCharacteristic", "batteryCharacteristic", "lockCharacteristic", "puffsCharacteristic", "findCharacteristic", "ledCharacteristic", "resetCharacteristic", "cloudCharacteristic", "hapticCharacteristic", "buzzerCharacteristic", "podCharacteristic", "powerSaveModeCharacteristic", "rechargeRemindersCharacteristic", "errorCharacteristic", "logCharacteristic", "versionCharacteristic", "controlCharacteristic", "payloadCharacteristic", "payloadChallengeCharacteristic", "ageChallengeCharacteristic", "ageSignatureCharacteristic", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
        public static final class Characteristics {
            public static final Characteristics INSTANCE = new Characteristics();
            public static final String ageChallengeCharacteristic = "6CD6C8B5-E378-010D-010D-1B9740683449";
            public static final String ageSignatureCharacteristic = "6CD6C8B5-E378-010D-020D-1B9740683449";
            public static final String batteryCharacteristic = "6CD6C8B5-E378-010D-030A-1B9740683449";
            public static final String buzzerCharacteristic = "6CD6C8B5-E378-010D-0E0A-1B9740683449";
            public static final String cloudCharacteristic = "6CD6C8B5-E378-010D-0C0A-1B9740683449";
            public static final String controlCharacteristic = "6CD6C8B5-E378-010D-020C-1B9740683449";
            public static final String deviceInfoCharacteristic = "6CD6C8B5-E378-010D-010A-1B9740683449";
            public static final String errorCharacteristic = "6CD6C8B5-E378-010D-010B-1B9740683449";
            public static final String findCharacteristic = "6CD6C8B5-E378-010D-090A-1B9740683449";
            public static final String hapticCharacteristic = "6CD6C8B5-E378-010D-0D0A-1B9740683449";
            public static final String ledCharacteristic = "6CD6C8B5-E378-010D-0A0A-1B9740683449";
            public static final String lockCharacteristic = "6CD6C8B5-E378-010D-040A-1B9740683449";
            public static final String logCharacteristic = "6CD6C8B5-E378-010D-030B-1B9740683449";
            public static final String payloadChallengeCharacteristic = "6CD6C8B5-E378-010D-040C-1B9740683449";
            public static final String payloadCharacteristic = "6CD6C8B5-E378-010D-030C-1B9740683449";
            public static final String podCharacteristic = "6CD6C8B5-E378-010D-0F0A-1B9740683449";
            public static final String powerSaveModeCharacteristic = "6CD6C8B5-E378-010D-100A-1B9740683449";
            public static final String puffsCharacteristic = "6CD6C8B5-E378-010D-060A-1B9740683449";
            public static final String rechargeRemindersCharacteristic = "6CD6C8B5-E378-010D-120A-1B9740683449";
            public static final String resetCharacteristic = "6CD6C8B5-E378-010D-0B0A-1B9740683449";
            public static final String timeCharacteristic = "6CD6C8B5-E378-010D-020A-1B9740683449";
            public static final String versionCharacteristic = "6CD6C8B5-E378-010D-010C-1B9740683449";

            private Characteristics() {
            }
        }
    }
}
