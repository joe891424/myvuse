package p000a.p001a.p002a.p003a.p004a.p009f;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* JADX INFO: renamed from: a.a.a.a.a.f.a */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0037a {
    @Headers({"Content-Type: application/json"})
    @GET
    /* JADX INFO: renamed from: a */
    Call<String> m248a(@Url String str);

    @Headers({"Content-Type: application/json"})
    @POST
    /* JADX INFO: renamed from: a */
    Call<String> m249a(@Url String str, @Body String str2);

    @Headers({"Content-Type: application/json"})
    @POST
    /* JADX INFO: renamed from: b */
    Call<String> m250b(@Url String str);
}
