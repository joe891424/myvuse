package com.newrelic.agent.android.harvest;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;

/* JADX INFO: loaded from: classes6.dex */
public class HarvestResponse {
    private static final String DISABLE_STRING = "DISABLE_NEW_RELIC";
    private String responseBody;
    private long responseTime;
    private int statusCode;

    public enum Code {
        OK(200),
        ACCEPTED(OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_RE_CONSENT),
        UNAUTHORIZED(TypedValues.CycleType.TYPE_CURVE_FIT),
        FORBIDDEN(TypedValues.CycleType.TYPE_ALPHA),
        REQUEST_TIMEOUT(408),
        CONFIGURATION_UPDATE(409),
        ENTITY_TOO_LARGE(413),
        UNSUPPORTED_MEDIA_TYPE(415),
        TOO_MANY_REQUESTS(429),
        INVALID_AGENT_ID(450),
        INTERNAL_SERVER_ERROR(500),
        UNKNOWN(-1);

        int statusCode;

        Code(int i) {
            this.statusCode = i;
        }

        public int getStatusCode() {
            return this.statusCode;
        }

        public boolean isError() {
            return !isOK();
        }

        public boolean isOK() {
            int i = C37481.f4036xa09b1364[ordinal()];
            return i == 1 || i == 2;
        }
    }

    /* JADX INFO: renamed from: com.newrelic.agent.android.harvest.HarvestResponse$1 */
    static /* synthetic */ class C37481 {

        /* JADX INFO: renamed from: $SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code */
        static final /* synthetic */ int[] f4036xa09b1364;

        static {
            int[] iArr = new int[Code.values().length];
            f4036xa09b1364 = iArr;
            try {
                iArr[Code.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4036xa09b1364[Code.ACCEPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public Code getResponseCode() {
        for (Code code : Code.values()) {
            if (code.getStatusCode() == this.statusCode) {
                return code;
            }
        }
        return Code.UNKNOWN;
    }

    public boolean isDisableCommand() {
        return Code.FORBIDDEN == getResponseCode() && DISABLE_STRING.equals(getResponseBody());
    }

    public boolean isError() {
        return this.statusCode >= 400;
    }

    public boolean isNetworkError() {
        return getResponseCode() == Code.UNKNOWN || getResponseCode() == Code.REQUEST_TIMEOUT || getResponseCode() == Code.TOO_MANY_REQUESTS;
    }

    public boolean isUnknown() {
        return getResponseCode() == Code.UNKNOWN;
    }

    public boolean isOK() {
        int i = this.statusCode;
        return i == 200 || i == 201;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public void setResponseBody(String str) {
        this.responseBody = str;
    }

    public long getResponseTime() {
        return this.responseTime;
    }

    public void setResponseTime(long j) {
        this.responseTime = j;
    }
}
