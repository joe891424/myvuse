package com.bat.sdk.client.epen;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DeviceControlRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, m5598d2 = {"Lcom/bat/sdk/client/epen/DeviceControlRequest;", "", "<init>", "()V", "SoftReset", "ClearRecords", "Sleep", "EnableLED", "DisableLED", "InhibitBuffer", "UnInhibitBuffer", "ClearBleQueue", "StopRecords", "StartRecords", "Lcom/bat/sdk/client/epen/DeviceControlRequest$ClearBleQueue;", "Lcom/bat/sdk/client/epen/DeviceControlRequest$ClearRecords;", "Lcom/bat/sdk/client/epen/DeviceControlRequest$DisableLED;", "Lcom/bat/sdk/client/epen/DeviceControlRequest$EnableLED;", "Lcom/bat/sdk/client/epen/DeviceControlRequest$InhibitBuffer;", "Lcom/bat/sdk/client/epen/DeviceControlRequest$Sleep;", "Lcom/bat/sdk/client/epen/DeviceControlRequest$SoftReset;", "Lcom/bat/sdk/client/epen/DeviceControlRequest$StartRecords;", "Lcom/bat/sdk/client/epen/DeviceControlRequest$StopRecords;", "Lcom/bat/sdk/client/epen/DeviceControlRequest$UnInhibitBuffer;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class DeviceControlRequest {
    public /* synthetic */ DeviceControlRequest(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DeviceControlRequest() {
    }

    /* JADX INFO: compiled from: DeviceControlRequest.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/client/epen/DeviceControlRequest$SoftReset;", "Lcom/bat/sdk/client/epen/DeviceControlRequest;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class SoftReset extends DeviceControlRequest {
        public static final SoftReset INSTANCE = new SoftReset();

        private SoftReset() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DeviceControlRequest.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/client/epen/DeviceControlRequest$ClearRecords;", "Lcom/bat/sdk/client/epen/DeviceControlRequest;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class ClearRecords extends DeviceControlRequest {
        public static final ClearRecords INSTANCE = new ClearRecords();

        private ClearRecords() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DeviceControlRequest.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/client/epen/DeviceControlRequest$Sleep;", "Lcom/bat/sdk/client/epen/DeviceControlRequest;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Sleep extends DeviceControlRequest {
        public static final Sleep INSTANCE = new Sleep();

        private Sleep() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DeviceControlRequest.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/client/epen/DeviceControlRequest$EnableLED;", "Lcom/bat/sdk/client/epen/DeviceControlRequest;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class EnableLED extends DeviceControlRequest {
        public static final EnableLED INSTANCE = new EnableLED();

        private EnableLED() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DeviceControlRequest.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/client/epen/DeviceControlRequest$DisableLED;", "Lcom/bat/sdk/client/epen/DeviceControlRequest;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class DisableLED extends DeviceControlRequest {
        public static final DisableLED INSTANCE = new DisableLED();

        private DisableLED() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DeviceControlRequest.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/client/epen/DeviceControlRequest$InhibitBuffer;", "Lcom/bat/sdk/client/epen/DeviceControlRequest;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class InhibitBuffer extends DeviceControlRequest {
        public static final InhibitBuffer INSTANCE = new InhibitBuffer();

        private InhibitBuffer() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DeviceControlRequest.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/client/epen/DeviceControlRequest$UnInhibitBuffer;", "Lcom/bat/sdk/client/epen/DeviceControlRequest;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class UnInhibitBuffer extends DeviceControlRequest {
        public static final UnInhibitBuffer INSTANCE = new UnInhibitBuffer();

        private UnInhibitBuffer() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DeviceControlRequest.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/client/epen/DeviceControlRequest$ClearBleQueue;", "Lcom/bat/sdk/client/epen/DeviceControlRequest;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class ClearBleQueue extends DeviceControlRequest {
        public static final ClearBleQueue INSTANCE = new ClearBleQueue();

        private ClearBleQueue() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DeviceControlRequest.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/client/epen/DeviceControlRequest$StopRecords;", "Lcom/bat/sdk/client/epen/DeviceControlRequest;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class StopRecords extends DeviceControlRequest {
        public static final StopRecords INSTANCE = new StopRecords();

        private StopRecords() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DeviceControlRequest.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lcom/bat/sdk/client/epen/DeviceControlRequest$StartRecords;", "Lcom/bat/sdk/client/epen/DeviceControlRequest;", "number", "", "<init>", "(I)V", "getNumber", "()I", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class StartRecords extends DeviceControlRequest {
        private final int number;

        public StartRecords(int i) {
            super(null);
            this.number = i;
        }

        public final int getNumber() {
            return this.number;
        }
    }
}
