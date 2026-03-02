package com.qualtrics.digital;

import com.google.gson.JsonObject;
import com.salesforce.marketingcloud.UrlHandler;
import okhttp3.ResponseBody;
import org.jose4j.jwk.RsaJsonWebKey;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes6.dex */
interface ISiteInterceptService {
    @GET("WRSiteInterceptEngine/AssetVersions.php")
    Call<ProjectAssetVersions> getAssetVersions(@Query("Q_InterceptID") String str, @Query("Q_CLIENTTYPE") String str2, @Query("Q_CLIENTVERSION") String str3, @Query("Q_DEVICEOS") String str4, @Query("Q_DEVICETYPE") String str5);

    @GET("WRSiteInterceptEngine/Asset.php")
    Call<JsonObject> getCreativeDefinition(@Query("Module") String str, @Query("Version") int i, @Query("Q_InterceptID") String str2, @Query("Q_CLIENTTYPE") String str3, @Query("Q_CLIENTVERSION") String str4, @Query("Q_DEVICEOS") String str5, @Query("Q_DEVICETYPE") String str6);

    @GET("WRSiteInterceptEngine/Asset.php")
    Call<Intercept> getInterceptDefinition(@Query("Module") String str, @Query("Version") int i, @Query("Q_FULL_DEFINITION") boolean z, @Query("Q_CLIENTTYPE") String str2, @Query("Q_CLIENTVERSION") String str3, @Query("Q_DEVICEOS") String str4, @Query("Q_DEVICETYPE") String str5);

    @FormUrlEncoded
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("WRSiteInterceptEngine/MobileTargeting")
    Call<TargetingResponse> getMobileTargeting(@Query("Q_ZoneID") String str, @Field("extRef") String str2, @Query("extRef") String str3, @Query("Q_CLIENTTYPE") String str4, @Query("Q_CLIENTVERSION") String str5, @Query("Q_DEVICEOS") String str6, @Query("Q_DEVICETYPE") String str7);

    @FormUrlEncoded
    @POST("WRSiteInterceptEngine/")
    Call<Void> interceptRecordPageView(@Query("Q_PageView") int i, @Query("Q_SIID") String str, @Query("Q_CID") String str2, @Query("Q_ASID") String str3, @Query("Q_LOC") String str4, @Query(RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME) String str5, @Query("Q_CLIENTTYPE") String str6, @Query("Q_CLIENTVERSION") String str7, @Query("Q_DEVICEOS") String str8, @Query("Q_DEVICETYPE") String str9, @Field("BrandID") String str10, @Field("ZoneID") String str11);

    @FormUrlEncoded
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("WRSiteInterceptEngine/Ajax.php")
    Call<Void> postErrorLog(@Field("LevelName") String str, @Field("Message") String str2, @Query(UrlHandler.ACTION) String str3, @Query("Q_CLIENTTYPE") String str4, @Query("Q_CLIENTVERSION") String str5, @Query("Q_DEVICEOS") String str6, @Query("Q_DEVICETYPE") String str7);

    @FormUrlEncoded
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST
    Call<ResponseBody> postSurveyResponse(@Url String str, @Query("SurveyId") String str2, @Query("InterceptId") String str3, @Field("Q_PostResponse") String str4, @Field("ED") String str5);

    @FormUrlEncoded
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("WRSiteInterceptEngine/")
    Call<Void> recordClick(@Query("Q_Click") int i, @Query("Q_SIID") String str, @Query("Q_CID") String str2, @Query("Q_ASID") String str3, @Query("Q_LOC") String str4, @Query(RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME) String str5, @Query("Q_CLIENTTYPE") String str6, @Query("Q_CLIENTVERSION") String str7, @Query("Q_DEVICEOS") String str8, @Query("Q_DEVICETYPE") String str9, @Field("ZoneID") String str10, @Field("BrandID") String str11);

    @FormUrlEncoded
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("WRSiteInterceptEngine/")
    Call<Void> recordImpression(@Query("Q_Impress") int i, @Query("Q_SIID") String str, @Query("Q_CID") String str2, @Query("Q_ASID") String str3, @Query("Q_LOC") String str4, @Query(RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME) String str5, @Query("Q_CLIENTTYPE") String str6, @Query("Q_CLIENTVERSION") String str7, @Query("Q_DEVICEOS") String str8, @Query("Q_DEVICETYPE") String str9, @Field("BrandDC") String str10, @Field("ExtRef") String str11, @Field("DistributionID") String str12, @Field("ContactID") String str13, @Field("DirectoryID") String str14, @Field("SurveyID") String str15, @Field("ZoneID") String str16, @Field("BrandID") String str17);

    @FormUrlEncoded
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("WRSiteInterceptEngine/MobileXmdDcfEval")
    Call<ContactFrequencyResponse> requestXMDContactFrequency(@Query("Q_ZoneID") String str, @Field("extRef") String str2, @Field("ContactFrequencyDebugIntercepts") String str3, @Query("Q_CLIENTTYPE") String str4, @Query("Q_CLIENTVERSION") String str5, @Query("Q_DEVICEOS") String str6, @Query("Q_DEVICETYPE") String str7);

    @POST
    Call<JsonObject> startSurveySession(@Url String str, @Body JsonObject jsonObject);

    @Headers({"Content-Type: application/json"})
    @POST
    Call<ResponseBody> updateSurveySession(@Url String str, @Body JsonObject jsonObject);

    @FormUrlEncoded
    @POST("WRSiteInterceptEngine/")
    Call<Void> zoneRecordPageView(@Query("Q_PageView") int i, @Query("Q_ZID") String str, @Query("Q_LOC") String str2, @Query(RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME) String str3, @Query("Q_CLIENTTYPE") String str4, @Query("Q_CLIENTVERSION") String str5, @Query("Q_DEVICEOS") String str6, @Query("Q_DEVICETYPE") String str7, @Field("BrandID") String str8, @Field("ZoneID") String str9);
}
