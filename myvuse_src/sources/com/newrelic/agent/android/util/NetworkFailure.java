package com.newrelic.agent.android.util;

import com.newrelic.agent.android.harvest.type.HarvestErrorCodes;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes6.dex */
public enum NetworkFailure {
    Unknown(-1),
    BadURL(-1000),
    TimedOut(HarvestErrorCodes.NSURLErrorTimedOut),
    CannotConnectToHost(HarvestErrorCodes.NSURLErrorCannotConnectToHost),
    DNSLookupFailed(HarvestErrorCodes.NSURLErrorDNSLookupFailed),
    BadServerResponse(HarvestErrorCodes.NSURLErrorBadServerResponse),
    SecureConnectionFailed(HarvestErrorCodes.NSURLErrorSecureConnectionFailed);

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private int errorCode;

    NetworkFailure(int i) {
        this.errorCode = i;
    }

    public static NetworkFailure exceptionToNetworkFailure(Exception exc) {
        log.error("NetworkFailure.exceptionToNetworkFailure: Attempting to convert network exception " + exc.getClass().getName() + " to error code.");
        NetworkFailure networkFailure = Unknown;
        try {
            if (exc instanceof ConnectTimeoutException) {
                networkFailure = TimedOut;
            } else if ((exc instanceof HttpResponseException) || (exc instanceof ClientProtocolException)) {
                networkFailure = BadServerResponse;
            }
        } catch (NoClassDefFoundError unused) {
            if (!(exc instanceof SocketTimeoutException)) {
                if (!(exc instanceof UnknownHostException)) {
                    if (!(exc instanceof ConnectException)) {
                        if (!(exc instanceof MalformedURLException)) {
                            if (!(exc instanceof SSLException)) {
                                return networkFailure;
                            }
                        }
                        return BadURL;
                    }
                    return CannotConnectToHost;
                }
                return DNSLookupFailed;
            }
            return TimedOut;
        } catch (Throwable th) {
            if (!(exc instanceof SocketTimeoutException) && !(exc instanceof UnknownHostException) && !(exc instanceof ConnectException) && !(exc instanceof MalformedURLException)) {
                boolean z = exc instanceof SSLException;
            }
            throw th;
        }
        if (!(exc instanceof SocketTimeoutException)) {
            if (!(exc instanceof UnknownHostException)) {
                if (!(exc instanceof ConnectException)) {
                    if (!(exc instanceof MalformedURLException)) {
                        if (!(exc instanceof SSLException)) {
                            return networkFailure;
                        }
                        return SecureConnectionFailed;
                    }
                    return BadURL;
                }
                return CannotConnectToHost;
            }
            return DNSLookupFailed;
        }
        return TimedOut;
    }

    public static int exceptionToErrorCode(Exception exc) {
        return exceptionToNetworkFailure(exc).getErrorCode();
    }

    public static NetworkFailure fromErrorCode(int i) {
        log.debug("fromErrorCode invoked with errorCode: " + i);
        for (NetworkFailure networkFailure : values()) {
            if (networkFailure.getErrorCode() == i) {
                log.debug("fromErrorCode found matching failure: " + String.valueOf(networkFailure));
                return networkFailure;
            }
        }
        return Unknown;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
