package com.yoti.mobile.android.yotisdkcore.core.domain.model;

import com.facebook.hermes.intl.Constants;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v2 com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType, still in use, count: 1, list:
  (r0v2 com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType) from 0x0198: SPUT (r0v2 com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType) com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType.default com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\b\u0086\u0001\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001&B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006'"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatusType;", "", "code", "", "description", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getDescription", "()Ljava/lang/String;", "SESSION_FINISHED_WITH_SUCCESS", "SESSION_FINISHED_BUT_STILL_OPEN", "USER_CANCELLED_SESSION", "UNAUTHORISED_REQUEST", "SESSION_NOT_FOUND", "SESSION_EXPIRED", "NO_SESSION_TOKEN", "NO_SESSION_ID", "SERVICE_DOWN", "NETWORK_ERROR", "NO_NETWORK", "NO_CAMERA_PERMISSION", "USER_WRONG_SUBMISSION", "NO_CAMERA", "UNSUPPORTED_BY_LIVENESS", "NO_LOCAL_TRIES_FOR_LIVENESS", "SDK_OUT_OF_DATE", "UNEXPECTED_INTERNAL_ERROR", "UNEXPECTED_DOCUMENT_SCANNING_ERROR", "UNEXPECTED_LIVENESS_ERROR", "UNSUPPORTED_CONFIGURATION", "STORAGE_ERROR", "DOCUMENT_CAPTURE_NOT_FOUND_ERROR", "ZOOM_LIVENESS_NOT_FOUND_ERROR", "SUPPLEMENTARY_DOCUMENT_NOT_FOUND_ERROR", "FACE_CAPTURE_NOT_FOUND_ERROR", "MANDATORY_DOCUMENT_NOT_PROVIDED", "Companion", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SessionStatusType {
    SESSION_FINISHED_WITH_SUCCESS(0, "Result with success"),
    SESSION_FINISHED_BUT_STILL_OPEN(-1, "All steps have been completed but session is still open"),
    USER_CANCELLED_SESSION(1000, "No error occurred - the end-user cancelled the session for an unknown reason."),
    UNAUTHORISED_REQUEST(2000, "Unauthorised request (wrong or expired session token)."),
    SESSION_NOT_FOUND(2001, "Session not found."),
    SESSION_EXPIRED(2002, "Session expired."),
    NO_SESSION_TOKEN(2003, "SDK launched without session Token."),
    NO_SESSION_ID(2004, "SDK launched without session ID."),
    SERVICE_DOWN(3000, "Yoti's services are down or unable to process the request."),
    NETWORK_ERROR(AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN, "An error occurred during a network request"),
    NO_NETWORK(AuthApiStatusCodes.AUTH_API_CLIENT_ERROR, "User has no network"),
    NO_CAMERA_PERMISSION(4000, "The user did not grant permissions to the camera"),
    USER_WRONG_SUBMISSION(4001, "User wrong submission: user has submitted a wrong document too many times and there are no more attempts left"),
    NO_CAMERA(5000, "No camera.(When user's camera was not found and file upload is not allowed)"),
    UNSUPPORTED_BY_LIVENESS(5001, "Unsupported browser/platform by the liveness flow"),
    NO_LOCAL_TRIES_FOR_LIVENESS(5002, "No more local tries for the liveness flow"),
    SDK_OUT_OF_DATE(5003, "SDK is out-of-date - please update the SDK to the latest version"),
    UNEXPECTED_INTERNAL_ERROR(5004, "Unexpected internal error"),
    UNEXPECTED_DOCUMENT_SCANNING_ERROR(5005, "Unexpected document scanning error"),
    UNEXPECTED_LIVENESS_ERROR(5006, "Unexpected liveness error"),
    UNSUPPORTED_CONFIGURATION(5008, "Unsupported configuration"),
    STORAGE_ERROR(5009, "Storage error: could not read/write on device app cache"),
    DOCUMENT_CAPTURE_NOT_FOUND_ERROR(6000, "Document Capture dependency not found error"),
    ZOOM_LIVENESS_NOT_FOUND_ERROR(6001, "Zoom Liveness dependency not found error"),
    SUPPLEMENTARY_DOCUMENT_NOT_FOUND_ERROR(6002, "Supplementary document dependency not found error"),
    FACE_CAPTURE_NOT_FOUND_ERROR(6003, "Face capture dependency not found error"),
    MANDATORY_DOCUMENT_NOT_PROVIDED(7000, "The user does not have the required documents to complete the session");


    /* JADX INFO: renamed from: default, reason: not valid java name */
    private static final SessionStatusType f8376default = new SessionStatusType(1000, "No error occurred - the end-user cancelled the session for an unknown reason.");
    private final int code;
    private final String description;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatusType$Companion;", "", "()V", Constants.COLLATION_DEFAULT, "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatusType;", "getDefault", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatusType;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SessionStatusType getDefault() {
            return SessionStatusType.f8376default;
        }
    }

    static {
    }

    private SessionStatusType(int i, String str) {
        this.code = i;
        this.description = str;
    }

    public static SessionStatusType valueOf(String str) {
        return (SessionStatusType) Enum.valueOf(SessionStatusType.class, str);
    }

    public static SessionStatusType[] values() {
        return (SessionStatusType[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }
}
