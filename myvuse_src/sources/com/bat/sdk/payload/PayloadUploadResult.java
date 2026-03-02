package com.bat.sdk.payload;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PayloadUploadResult.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadUploadResult;", "", "<init>", "()V", "Success", "DeviceError", "BackendError", "Lcom/bat/sdk/payload/PayloadUploadResult$BackendError;", "Lcom/bat/sdk/payload/PayloadUploadResult$DeviceError;", "Lcom/bat/sdk/payload/PayloadUploadResult$Success;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class PayloadUploadResult {
    public /* synthetic */ PayloadUploadResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PayloadUploadResult() {
    }

    /* JADX INFO: compiled from: PayloadUploadResult.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadUploadResult$Success;", "Lcom/bat/sdk/payload/PayloadUploadResult;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Success extends PayloadUploadResult {
        public static final Success INSTANCE = new Success();

        private Success() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PayloadUploadResult.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadUploadResult$DeviceError;", "Lcom/bat/sdk/payload/PayloadUploadResult;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class DeviceError extends PayloadUploadResult {
        public static final DeviceError INSTANCE = new DeviceError();

        private DeviceError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PayloadUploadResult.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadUploadResult$BackendError;", "Lcom/bat/sdk/payload/PayloadUploadResult;", "<init>", "()V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class BackendError extends PayloadUploadResult {
        public static final BackendError INSTANCE = new BackendError();

        private BackendError() {
            super(null);
        }
    }
}
