package com.yoti.mobile.android.documentscan.ui;

import com.newrelic.agent.android.agentdata.HexAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u001f\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006\u0082\u0001\u0005\f\r\u000e\u000f\u0010¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException;", "Ljava/lang/Exception;", "message", "", HexAttribute.HEX_ATTR_CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "AadhaarQrCodeNotRecognizedException", "BlinkCameraEventException", "CameraViewException", "DocumentCaptureFailedException", "ScanResultConversionException", "Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException$CameraViewException;", "Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException$BlinkCameraEventException;", "Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException$ScanResultConversionException;", "Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException$DocumentCaptureFailedException;", "Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException$AadhaarQrCodeNotRecognizedException;", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public abstract class DocumentCaptureException extends Exception {

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException$AadhaarQrCodeNotRecognizedException;", "Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException;", "messageResId", "", "message", "", HexAttribute.HEX_ATTR_CAUSE, "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getMessageResId", "()I", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
    public static final class AadhaarQrCodeNotRecognizedException extends DocumentCaptureException {
        private final int messageResId;

        public AadhaarQrCodeNotRecognizedException(int i, String str, Throwable th) {
            super(str, th, null);
            this.messageResId = i;
        }

        public /* synthetic */ AadhaarQrCodeNotRecognizedException(int i, String str, Throwable th, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : th);
        }

        public final int getMessageResId() {
            return this.messageResId;
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException$BlinkCameraEventException;", "Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException;", HexAttribute.HEX_ATTR_CAUSE, "", "(Ljava/lang/Throwable;)V", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
    public static final class BlinkCameraEventException extends DocumentCaptureException {
        /* JADX WARN: Multi-variable type inference failed */
        public BlinkCameraEventException() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BlinkCameraEventException(Throwable th) {
            super(null, th, 1, 0 == true ? 1 : 0);
        }

        public /* synthetic */ BlinkCameraEventException(Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : th);
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException$CameraViewException;", "Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException;", HexAttribute.HEX_ATTR_CAUSE, "", "(Ljava/lang/Throwable;)V", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
    public static final class CameraViewException extends DocumentCaptureException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public CameraViewException(Throwable cause) {
            super(null, cause, 1, 0 == true ? 1 : 0);
            Intrinsics.checkParameterIsNotNull(cause, "cause");
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException$DocumentCaptureFailedException;", "Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException;", "message", "", HexAttribute.HEX_ATTR_CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
    public static final class DocumentCaptureFailedException extends DocumentCaptureException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DocumentCaptureFailedException(String message, Throwable th) {
            super(message, th, null);
            Intrinsics.checkParameterIsNotNull(message, "message");
        }

        public /* synthetic */ DocumentCaptureFailedException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : th);
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException$ScanResultConversionException;", "Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException;", HexAttribute.HEX_ATTR_CAUSE, "", "(Ljava/lang/Throwable;)V", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
    public static final class ScanResultConversionException extends DocumentCaptureException {
        /* JADX WARN: Multi-variable type inference failed */
        public ScanResultConversionException() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ScanResultConversionException(Throwable th) {
            super(null, th, 1, 0 == true ? 1 : 0);
        }

        public /* synthetic */ ScanResultConversionException(Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : th);
        }
    }

    private DocumentCaptureException(String str, Throwable th) {
        super(str, th);
    }

    /* synthetic */ DocumentCaptureException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
    }

    public /* synthetic */ DocumentCaptureException(String str, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th);
    }
}
