package com.qualtrics.digital;

/* JADX INFO: loaded from: classes6.dex */
public class RequestInterceptorProvider {
    private static RequestInterceptorProvider instance;
    private IQualtricsRequestInterceptor requestHandler;

    public static RequestInterceptorProvider getInstance() {
        if (instance == null) {
            instance = new RequestInterceptorProvider();
        }
        return instance;
    }

    public void setRequestHandler(IQualtricsRequestInterceptor iQualtricsRequestInterceptor) {
        this.requestHandler = iQualtricsRequestInterceptor;
    }

    public IQualtricsRequestInterceptor getRequestHandler() {
        return this.requestHandler;
    }
}
