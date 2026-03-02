package com.qualtrics.digital;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes6.dex */
interface ILatencyReportingService {
    @POST("/rum/global")
    Call<Void> recordLatency(@Body LatencyReportBody latencyReportBody);
}
