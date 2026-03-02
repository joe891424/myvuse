package com.qualtrics.digital;

import com.qualtrics.BuildConfig;
import java.util.Locale;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes6.dex */
class LatencyReportingService {
    private static LatencyReportingService mInstance;
    private String mAppName;
    private double mBenchmarkSampleRate = 0.0d;
    private String mBrandID;
    private String mInterceptID;
    private ILatencyReportingService mService;
    private String mZoneID;

    private LatencyReportingService() {
    }

    static LatencyReportingService instance() {
        if (mInstance == null) {
            mInstance = new LatencyReportingService();
        }
        return mInstance;
    }

    void initialize(String str, String str2, String str3, String str4) {
        this.mAppName = str;
        this.mBrandID = str2;
        this.mZoneID = str3;
        this.mInterceptID = str4;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        if (QualtricsLog.mLogLevel == QualtricsLogLevel.INFO) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        this.mService = (ILatencyReportingService) new Retrofit.Builder().baseUrl("https://survey.qualtrics.com").client(new OkHttpClient.Builder().addInterceptor(new ServiceInterceptor(this.mAppName)).addInterceptor(httpLoggingInterceptor).addInterceptor(new RequestInterceptor()).build()).addConverterFactory(GsonConverterFactory.create()).build().create(ILatencyReportingService.class);
    }

    void setBenchmarkSampleRate(double d) {
        this.mBenchmarkSampleRate = d;
    }

    void reportLatency(String str, String str2, long j) {
        if (this.mService == null) {
            QualtricsLog.logError("Service not initialized, report latency network request cannot be performed");
        } else if (SamplingUtil.checkSampling(Double.valueOf(this.mBenchmarkSampleRate))) {
            this.mService.recordLatency(new LatencyReportBody(String.format(Locale.US, "si.androidSDK.%s.%s.%s.%s.%s.%s", BuildConfig.VERSION_NAME, this.mAppName, this.mBrandID, this.mZoneID, this.mInterceptID, str), str2, j)).enqueue(new Callback<Void>() { // from class: com.qualtrics.digital.LatencyReportingService.1
                @Override // retrofit2.Callback
                public void onResponse(Call<Void> call, Response<Void> response) {
                    QualtricsLog.logInfo("Latency recorded");
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<Void> call, Throwable th) {
                    QualtricsLog.logError("Error recording latency: " + th.getMessage());
                }
            });
        }
    }
}
