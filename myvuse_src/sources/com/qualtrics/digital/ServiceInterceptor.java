package com.qualtrics.digital;

import com.google.common.net.HttpHeaders;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes6.dex */
public class ServiceInterceptor implements Interceptor {
    private static final int ALLOWED_RETRY_ATTEMPTS = 2;
    private String mAppName;

    public ServiceInterceptor(String str) {
        this.mAppName = str;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request requestBuild;
        try {
            Request.Builder builderAddHeader = chain.request().newBuilder().addHeader(HttpHeaders.REFERER, this.mAppName);
            if (builderAddHeader instanceof Request.Builder) {
                Request.Builder builder = builderAddHeader;
                requestBuild = OkHttp3Instrumentation.build(builderAddHeader);
            } else {
                requestBuild = builderAddHeader.build();
            }
            Response responseProceed = chain.proceed(requestBuild);
            int i = 0;
            while (i < 2 && !responseProceed.isSuccessful()) {
                i++;
                responseProceed.close();
                responseProceed = chain.proceed(requestBuild);
            }
            if (responseProceed.isSuccessful()) {
                return responseProceed;
            }
            throw new IOException(String.format(Locale.US, "Invalid response received from requested url: %s. ResponseBody: %s, ResponseCode:%d", requestBuild.url(), responseProceed.body(), Integer.valueOf(responseProceed.code())));
        } catch (Throwable th) {
            logCrash(th);
            throw th;
        }
    }

    public void logCrash(Throwable th) {
        try {
            QualtricsLog.logError(th.getMessage() + "\\n" + stacktraceToString(th));
        } catch (Exception unused) {
            LogInstrumentation.m2728e("Qualtrics", "Unknown Error from okhttp");
        }
    }

    private String stacktraceToString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
