package com.onetrust.otpublishers.headless.Internal.Network;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.io.IOException;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p009f.InterfaceC0037a;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: classes6.dex */
public class ConsentUploadWorker extends Worker {

    /* JADX INFO: renamed from: a */
    public Context f4058a;

    public ConsentUploadWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f4058a = context;
        OTLogger.m2749c("CPWorker", "Consent logging");
    }

    /* JADX INFO: renamed from: a */
    public static void m2750a(String str, C0045d c0045d) {
        c0045d.m271a().edit().remove(str).apply();
        OTLogger.m2743a(3, "CPWorker", "payloadKeyId: " + str + ",data present in pref:" + c0045d.m271a().contains(str));
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        Response<String> responseExecute;
        OTLogger.m2743a(4, "CPWorker", "do work");
        String string = getInputData().getString("ott_consent_log_base_url");
        String string2 = getInputData().getString("ott_consent_log_end_point");
        String string3 = getInputData().getString("ott_payload_id");
        C0045d c0045d = new C0045d(this.f4058a, "OTT_DEFAULT_USER");
        String string4 = c0045d.m271a().getString(string3, "");
        OTLogger.m2743a(3, "CPWorker", ",data present in pref with payloadKeyId :" + string3 + " data: " + string4);
        if (C0048h.m305b(string) || C0048h.m305b(string2)) {
            return ListenableWorker.Result.failure();
        }
        new C0045d(this.f4058a, "OTT_DEFAULT_USER");
        Call<String> callM249a = ((InterfaceC0037a) new Retrofit.Builder().baseUrl(string).addConverterFactory(ScalarsConverterFactory.create()).client(new OkHttpClient.Builder().build()).build().create(InterfaceC0037a.class)).m249a(string2, string4);
        String str = null;
        try {
            responseExecute = callM249a.execute();
        } catch (IOException e) {
            e = e;
            responseExecute = null;
        }
        try {
            OTLogger.m2743a(4, "NetworkRequestHandler", "response = " + responseExecute.body());
            OTLogger.m2743a(4, "NetworkRequestHandler", "response code = " + responseExecute.code());
        } catch (IOException e2) {
            e = e2;
            OTLogger.m2743a(4, "NetworkRequestHandler", " network call response error out = " + e.getMessage());
        }
        OTLogger.m2743a(4, "CPWorker", "consentLoggingStatus = " + responseExecute);
        if (responseExecute == null) {
            OTLogger.m2743a(4, "CPWorker", " empty response");
            return ListenableWorker.Result.retry();
        }
        int iCode = responseExecute.code();
        if (iCode >= 200 && iCode < 300) {
            m2750a(string3, c0045d);
            String strBody = responseExecute.body();
            if (!C0048h.m305b(strBody)) {
                try {
                    str = (String) new JSONObject(strBody).get("receipt");
                } catch (JSONException e3) {
                    OTLogger.m2743a(6, "CPWorker", "consent receipt json error. error msg = " + e3.getMessage());
                }
            }
            OTLogger.m2743a(4, "CPWorker", "consentReceiptValue = " + str);
            if (!C0048h.m305b(str)) {
                c0045d.m271a().edit().putString("OTT_PROFILE_CONSENT_RECEIPT", str).apply();
            }
            return ListenableWorker.Result.success();
        }
        if (iCode >= 500 && iCode < 600) {
            OTLogger.m2743a(4, "CPWorker", " consent log? = " + responseExecute.body());
            return ListenableWorker.Result.retry();
        }
        if (iCode < 400 || iCode >= 500) {
            OTLogger.m2743a(4, "CPWorker", " consent log call returned unknown error " + responseExecute.body());
            return ListenableWorker.Result.retry();
        }
        OTLogger.m2743a(4, "CPWorker", " consent log? = " + responseExecute.body());
        m2750a(string3, c0045d);
        return ListenableWorker.Result.failure();
    }
}
