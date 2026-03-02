package io.branch.referral;

import android.net.Uri;
import io.branch.referral.Defines;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ReferringUrlUtility.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0002J!\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0015\u001a\u00020\fH\u0001¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\tJ!\u0010\u001d\u001a\u00020\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0001¢\u0006\u0002\b\u001eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m5598d2 = {"Lio/branch/referral/ReferringUrlUtility;", "", "prefHelper", "Lio/branch/referral/PrefHelper;", "(Lio/branch/referral/PrefHelper;)V", "dateFormat", "Ljava/text/SimpleDateFormat;", "urlQueryParameters", "", "", "Lio/branch/referral/BranchUrlQueryParameter;", "addGclidValueFor", "Lorg/json/JSONObject;", "request", "Lio/branch/referral/ServerRequest;", "checkForAndMigrateOldGclid", "", "defaultValidityWindowForParam", "", "paramName", "deserializeFromJson", "json", "deserializeFromJson$Branch_SDK_release", "findUrlQueryParam", "getURLQueryParamsForRequest", "isSupportedQueryParameter", "", "parseReferringURL", "urlString", "serializeToJson", "serializeToJson$Branch_SDK_release", "Branch-SDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ReferringUrlUtility {
    private final SimpleDateFormat dateFormat;
    private PrefHelper prefHelper;
    private final Map<String, BranchUrlQueryParameter> urlQueryParameters;

    public ReferringUrlUtility(PrefHelper prefHelper) {
        Intrinsics.checkNotNullParameter(prefHelper, "prefHelper");
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        this.prefHelper = prefHelper;
        JSONObject referringURLQueryParameters = prefHelper.getReferringURLQueryParameters();
        Intrinsics.checkNotNullExpressionValue(referringURLQueryParameters, "prefHelper.referringURLQueryParameters");
        this.urlQueryParameters = deserializeFromJson$Branch_SDK_release(referringURLQueryParameters);
        checkForAndMigrateOldGclid();
    }

    public final void parseReferringURL(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        if (!Branch.getInstance().isTrackingDisabled()) {
            Uri uri = Uri.parse(urlString);
            for (String originalParamName : uri.getQueryParameterNames()) {
                Intrinsics.checkNotNullExpressionValue(originalParamName, "originalParamName");
                String lowerCase = originalParamName.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                String queryParameter = uri.getQueryParameter(originalParamName);
                BranchLogger.m5578v("Found URL Query Parameter - Key: " + lowerCase + ", Value: " + queryParameter);
                if (isSupportedQueryParameter(lowerCase)) {
                    BranchUrlQueryParameter branchUrlQueryParameterFindUrlQueryParam = findUrlQueryParam(lowerCase);
                    branchUrlQueryParameterFindUrlQueryParam.setValue(queryParameter);
                    branchUrlQueryParameterFindUrlQueryParam.setTimestamp(new Date());
                    branchUrlQueryParameterFindUrlQueryParam.setDeepLink(true);
                    if (branchUrlQueryParameterFindUrlQueryParam.getValidityWindow() == 0) {
                        branchUrlQueryParameterFindUrlQueryParam.setValidityWindow(defaultValidityWindowForParam(lowerCase));
                    }
                    this.urlQueryParameters.put(lowerCase, branchUrlQueryParameterFindUrlQueryParam);
                }
            }
            this.prefHelper.setReferringUrlQueryParameters(serializeToJson$Branch_SDK_release(this.urlQueryParameters));
            BranchLogger.m5578v("Current referringURLQueryParameters: " + this.prefHelper.getReferringURLQueryParameters());
            return;
        }
        BranchLogger.m5575d("Skipping referring URL query parameter parsing due to disabled tracking.");
    }

    public final JSONObject getURLQueryParamsForRequest(ServerRequest request) throws JSONException {
        Intrinsics.checkNotNullParameter(request, "request");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObjectAddGclidValueFor = addGclidValueFor(request);
        if (jSONObjectAddGclidValueFor.length() > 0) {
            Iterator<String> itKeys = jSONObjectAddGclidValueFor.keys();
            while (itKeys.hasNext()) {
                String key = itKeys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Object obj = jSONObjectAddGclidValueFor.get(key);
                Intrinsics.checkNotNullExpressionValue(obj, "gclid.get(key)");
                linkedHashMap.put(key, obj);
            }
        }
        return new JSONObject(linkedHashMap);
    }

    private final JSONObject addGclidValueFor(ServerRequest request) throws JSONException {
        BranchUrlQueryParameter branchUrlQueryParameter;
        JSONObject jSONObject = new JSONObject();
        if (((request instanceof ServerRequestLogEvent) || (request instanceof ServerRequestRegisterOpen)) && (branchUrlQueryParameter = this.urlQueryParameters.get(Defines.Jsonkey.Gclid.getKey())) != null && branchUrlQueryParameter.getValue() != null && !Intrinsics.areEqual(branchUrlQueryParameter.getValue(), PrefHelper.NO_STRING_VALUE)) {
            long time = new Date().getTime();
            Date timestamp = branchUrlQueryParameter.getTimestamp();
            Long lValueOf = timestamp != null ? Long.valueOf(timestamp.getTime()) : null;
            long validityWindow = branchUrlQueryParameter.getValidityWindow() * 1000;
            if (lValueOf != null) {
                if (branchUrlQueryParameter.getValidityWindow() == 0 || time < lValueOf.longValue() + validityWindow) {
                    jSONObject.put(Defines.Jsonkey.Gclid.getKey(), branchUrlQueryParameter.getValue());
                    if (request instanceof ServerRequestRegisterOpen) {
                        jSONObject.put(Defines.Jsonkey.IsDeeplinkGclid.getKey(), branchUrlQueryParameter.isDeepLink());
                    }
                    branchUrlQueryParameter.setDeepLink(false);
                    this.prefHelper.setReferringUrlQueryParameters(serializeToJson$Branch_SDK_release(this.urlQueryParameters));
                } else {
                    this.urlQueryParameters.remove(Defines.Jsonkey.Gclid.getKey());
                    this.prefHelper.setReferringUrlQueryParameters(serializeToJson$Branch_SDK_release(this.urlQueryParameters));
                }
            }
        }
        return jSONObject;
    }

    private final boolean isSupportedQueryParameter(String paramName) {
        String lowerCase = paramName.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return CollectionsKt.listOf(Defines.Jsonkey.Gclid.getKey()).contains(lowerCase);
    }

    private final BranchUrlQueryParameter findUrlQueryParam(String paramName) {
        BranchUrlQueryParameter branchUrlQueryParameter = this.urlQueryParameters.get(paramName);
        return branchUrlQueryParameter == null ? new BranchUrlQueryParameter(paramName, null, null, false, 0L, 30, null) : branchUrlQueryParameter;
    }

    private final long defaultValidityWindowForParam(String paramName) {
        if (Intrinsics.areEqual(paramName, Defines.Jsonkey.Gclid.getKey())) {
            return this.prefHelper.getReferrerGclidValidForWindow() / 1000;
        }
        return 0L;
    }

    public final JSONObject serializeToJson$Branch_SDK_release(Map<String, BranchUrlQueryParameter> urlQueryParameters) {
        Intrinsics.checkNotNullParameter(urlQueryParameters, "urlQueryParameters");
        JSONObject jSONObject = new JSONObject();
        try {
            for (BranchUrlQueryParameter branchUrlQueryParameter : urlQueryParameters.values()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("name", branchUrlQueryParameter.getName());
                Object value = branchUrlQueryParameter.getValue();
                if (value == null) {
                    value = JSONObject.NULL;
                }
                jSONObject2.put("value", value);
                Date timestamp = branchUrlQueryParameter.getTimestamp();
                jSONObject2.put("timestamp", timestamp != null ? this.dateFormat.format(timestamp) : null);
                jSONObject2.put("isDeeplink", branchUrlQueryParameter.isDeepLink());
                jSONObject2.put("validityWindow", branchUrlQueryParameter.getValidityWindow());
                jSONObject.put(String.valueOf(branchUrlQueryParameter.getName()), jSONObject2);
            }
        } catch (JSONException e) {
            BranchLogger.logException("Exception when serializing JSON for referring URL query parameters", e);
        }
        return jSONObject;
    }

    public final Map<String, BranchUrlQueryParameter> deserializeFromJson$Branch_SDK_release(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Iterator<String> itKeys = json.keys();
            while (itKeys.hasNext()) {
                JSONObject jSONObject = json.getJSONObject(itKeys.next());
                BranchUrlQueryParameter branchUrlQueryParameter = new BranchUrlQueryParameter(null, null, null, false, 0L, 31, null);
                branchUrlQueryParameter.setName(jSONObject.getString("name"));
                if (jSONObject.has("value")) {
                    branchUrlQueryParameter.setValue(jSONObject.getString("value"));
                }
                if (jSONObject.has("timestamp")) {
                    try {
                    } catch (ParseException e) {
                        e = e;
                    }
                    try {
                        try {
                            branchUrlQueryParameter.setTimestamp(this.dateFormat.parse(jSONObject.getString("timestamp")));
                        } catch (JSONException e2) {
                            e = e2;
                            BranchLogger.logException("Exception when deserializing JSON for referring URL query parameters", e);
                            return linkedHashMap;
                        }
                    } catch (ParseException e3) {
                        e = e3;
                        BranchLogger.logException("Exception when parsing referring URL query parameter timestamp", e);
                    }
                }
                if (jSONObject.has("validityWindow")) {
                    branchUrlQueryParameter.setValidityWindow(jSONObject.getLong("validityWindow"));
                }
                if (jSONObject.has("isDeeplink")) {
                    branchUrlQueryParameter.setDeepLink(jSONObject.getBoolean("isDeeplink"));
                } else {
                    branchUrlQueryParameter.setDeepLink(false);
                }
                String name = branchUrlQueryParameter.getName();
                if (name != null) {
                    linkedHashMap.put(name, branchUrlQueryParameter);
                }
            }
        } catch (JSONException e4) {
            e = e4;
        }
        return linkedHashMap;
    }

    private final void checkForAndMigrateOldGclid() {
        String referrerGclid;
        BranchUrlQueryParameter branchUrlQueryParameter = this.urlQueryParameters.get(Defines.Jsonkey.Gclid.getKey());
        if ((branchUrlQueryParameter != null ? branchUrlQueryParameter.getValue() : null) != null || (referrerGclid = this.prefHelper.getReferrerGclid()) == null || Intrinsics.areEqual(referrerGclid, PrefHelper.NO_STRING_VALUE)) {
            return;
        }
        BranchUrlQueryParameter branchUrlQueryParameter2 = new BranchUrlQueryParameter(Defines.Jsonkey.Gclid.getKey(), referrerGclid, new Date(), false, this.prefHelper.getReferrerGclidValidForWindow());
        Map<String, BranchUrlQueryParameter> map = this.urlQueryParameters;
        String key = Defines.Jsonkey.Gclid.getKey();
        Intrinsics.checkNotNullExpressionValue(key, "Gclid.key");
        map.put(key, branchUrlQueryParameter2);
        this.prefHelper.setReferringUrlQueryParameters(serializeToJson$Branch_SDK_release(this.urlQueryParameters));
        this.prefHelper.clearGclid();
        BranchLogger.m5578v("Updated old Gclid (" + referrerGclid + ") to new BranchUrlQueryParameter (" + branchUrlQueryParameter2 + ')');
    }
}
