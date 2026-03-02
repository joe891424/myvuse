package com.newrelic.agent.android.util;

import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.AgentHealthException;
import com.newrelic.agent.android.harvest.type.HarvestErrorCodes;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes6.dex */
public class ExceptionHelper implements HarvestErrorCodes {
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public static int exceptionToErrorCode(Exception exc) {
        log.debug("ExceptionHelper: exception " + exc.getClass().getName() + " to error code.");
        if (exc instanceof UnknownHostException) {
            return HarvestErrorCodes.NSURLErrorDNSLookupFailed;
        }
        if (exc instanceof SocketTimeoutException) {
            return HarvestErrorCodes.NSURLErrorTimedOut;
        }
        if (exc instanceof ConnectException) {
            return HarvestErrorCodes.NSURLErrorCannotConnectToHost;
        }
        if (exc instanceof MalformedURLException) {
            return -1000;
        }
        if (exc instanceof SSLException) {
            return HarvestErrorCodes.NSURLErrorSecureConnectionFailed;
        }
        if (exc instanceof FileNotFoundException) {
            return HarvestErrorCodes.NRURLErrorFileDoesNotExist;
        }
        if (exc instanceof EOFException) {
            return HarvestErrorCodes.NSURLErrorRequestBodyStreamExhausted;
        }
        if (exc instanceof IOException) {
            recordSupportabilityMetric(exc, "IOException");
        } else if (exc instanceof RuntimeException) {
            recordSupportabilityMetric(exc, "RuntimeException");
        }
        return -1;
    }

    public static void recordSupportabilityMetric(Exception exc, String str) {
        AgentHealthException agentHealthException = new AgentHealthException(exc);
        if ((agentHealthException.getStackTrace() != null) && (agentHealthException.getStackTrace().length > 0)) {
            StackTraceElement stackTraceElement = agentHealthException.getStackTrace()[0];
            log.error(String.format("ExceptionHelper: %s:%s(%s:%s) %s[%s] %s", agentHealthException.getSourceClass(), agentHealthException.getSourceMethod(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber()), str, agentHealthException.getExceptionClass(), agentHealthException.getMessage()));
            AgentHealth.noticeException(agentHealthException, str);
        }
    }
}
