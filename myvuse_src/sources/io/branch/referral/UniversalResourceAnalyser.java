package io.branch.referral;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class UniversalResourceAnalyser {
    private static final String SKIP_LIST_KEY = "uri_skip_list";
    private static final String SKIP_URL_FORMATS_KEY = "skip_url_format_key";
    private static final String UPDATE_URL_PATH = "%sdk/uriskiplist_v#.json";
    private static final String VERSION_KEY = "version";
    private static UniversalResourceAnalyser instance;
    private static JSONObject skipURLFormats;
    private final JSONObject DEFAULT_SKIP_URL_LIST;
    private final ArrayList<String> acceptURLFormats;

    public static UniversalResourceAnalyser getInstance(Context context) {
        if (instance == null) {
            instance = new UniversalResourceAnalyser(context);
        }
        return instance;
    }

    private UniversalResourceAnalyser(Context context) {
        JSONObject jSONObject = new JSONObject();
        this.DEFAULT_SKIP_URL_LIST = jSONObject;
        try {
            jSONObject.putOpt(VERSION_KEY, 0);
            JSONArray jSONArray = new JSONArray();
            jSONObject.putOpt(SKIP_LIST_KEY, jSONArray);
            jSONArray.put("^fb\\d+:((?!campaign_ids).)*$");
            jSONArray.put("^li\\d+:");
            jSONArray.put("^pdk\\d+:");
            jSONArray.put("^twitterkit-.*:");
            jSONArray.put("^com\\.googleusercontent\\.apps\\.\\d+-.*:\\/oauth");
            jSONArray.put("^(?i)(?!(http|https):).*(:|:.*\\b)(password|o?auth|o?auth.?token|access|access.?token)\\b");
            jSONArray.put("^(?i)((http|https):\\/\\/).*[\\/|?|#].*\\b(password|o?auth|o?auth.?token|access|access.?token)\\b");
        } catch (JSONException e) {
            BranchLogger.m5575d(e.getMessage());
        }
        skipURLFormats = retrieveSkipURLFormats(context);
        this.acceptURLFormats = new ArrayList<>();
    }

    private JSONObject retrieveSkipURLFormats(Context context) {
        PrefHelper prefHelper = PrefHelper.getInstance(context);
        JSONObject jSONObject = new JSONObject();
        String string = prefHelper.getString(SKIP_URL_FORMATS_KEY);
        if (TextUtils.isEmpty(string) || PrefHelper.NO_STRING_VALUE.equals(string)) {
            return this.DEFAULT_SKIP_URL_LIST;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException e) {
            BranchLogger.m5575d(e.getMessage());
            return jSONObject;
        }
    }

    void addToSkipURLFormats(String str) {
        JSONArray jSONArrayOptJSONArray = skipURLFormats.optJSONArray(SKIP_LIST_KEY);
        if (jSONArrayOptJSONArray == null) {
            try {
                jSONArrayOptJSONArray = new JSONArray();
                skipURLFormats.put(SKIP_LIST_KEY, jSONArrayOptJSONArray);
            } catch (Exception e) {
                BranchLogger.m5575d(e.getMessage());
                return;
            }
        }
        jSONArrayOptJSONArray.put(str);
    }

    void addToAcceptURLFormats(String str) {
        this.acceptURLFormats.add(str);
    }

    void addToAcceptURLFormats(List<String> list) {
        this.acceptURLFormats.addAll(list);
    }

    void checkAndUpdateSkipURLFormats(Context context) {
        try {
            new UrlSkipListUpdateTask(context).executeTask(new Void[0]);
        } catch (Exception e) {
            BranchLogger.m5575d(e.getMessage());
        }
    }

    String getStrippedURL(String str) {
        String string;
        try {
            JSONArray jSONArrayOptJSONArray = skipURLFormats.optJSONArray(SKIP_LIST_KEY);
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    try {
                        string = jSONArrayOptJSONArray.getString(i);
                    } catch (JSONException e) {
                        BranchLogger.m5575d(e.getMessage());
                    }
                    if (Pattern.compile(string).matcher(str).find()) {
                        break;
                    }
                }
                string = null;
            } else {
                string = null;
            }
            if (string == null) {
                if (this.acceptURLFormats.size() <= 0) {
                    return str;
                }
                Iterator<String> it2 = this.acceptURLFormats.iterator();
                while (it2.hasNext()) {
                    if (str.matches(it2.next())) {
                        return str;
                    }
                }
            }
            return string;
        } catch (Exception unused) {
            return str;
        }
    }

    private static class UrlSkipListUpdateTask extends BranchAsyncTask<Void, Void, JSONObject> {
        private final int TIME_OUT;
        private final PrefHelper prefHelper;

        private UrlSkipListUpdateTask(Context context) {
            this.TIME_OUT = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
            this.prefHelper = PrefHelper.getInstance(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Not initialized variable reg: 1, insn: 0x0089: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:24:0x0089 */
        /* JADX WARN: Removed duplicated region for block: B:26:0x008c  */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public org.json.JSONObject doInBackground(java.lang.Void... r8) throws java.lang.Throwable {
            /*
                r7 = this;
                r8 = 0
                android.net.TrafficStats.setThreadStatsTag(r8)
                org.json.JSONObject r8 = new org.json.JSONObject
                r8.<init>()
                r0 = 0
                java.lang.String r1 = "%sdk/uriskiplist_v#.json"
                java.lang.String r2 = "%"
                java.lang.String r3 = io.branch.referral.PrefHelper.getCDNBaseUrl()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                java.lang.String r1 = r1.replace(r2, r3)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                java.lang.String r3 = "#"
                org.json.JSONObject r4 = io.branch.referral.UniversalResourceAnalyser.access$100()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                java.lang.String r5 = "version"
                int r4 = r4.optInt(r5)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                int r4 = r4 + 1
                java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                java.lang.String r1 = r1.replace(r3, r4)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                r2.<init>(r1)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                java.net.URLConnection r1 = r2.openConnection()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                java.net.URLConnection r1 = com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation.openConnection(r1)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                r0 = 1500(0x5dc, float:2.102E-42)
                r1.setConnectTimeout(r0)     // Catch: java.lang.Exception -> L75 java.lang.Throwable -> L88
                r1.setReadTimeout(r0)     // Catch: java.lang.Exception -> L75 java.lang.Throwable -> L88
                int r0 = r1.getResponseCode()     // Catch: java.lang.Exception -> L75 java.lang.Throwable -> L88
                r2 = 200(0xc8, float:2.8E-43)
                if (r0 != r2) goto L6f
                java.io.InputStream r0 = r1.getInputStream()     // Catch: java.lang.Exception -> L75 java.lang.Throwable -> L88
                if (r0 == 0) goto L6f
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L75 java.lang.Throwable -> L88
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L75 java.lang.Throwable -> L88
                java.io.InputStream r3 = r1.getInputStream()     // Catch: java.lang.Exception -> L75 java.lang.Throwable -> L88
                r2.<init>(r3)     // Catch: java.lang.Exception -> L75 java.lang.Throwable -> L88
                r0.<init>(r2)     // Catch: java.lang.Exception -> L75 java.lang.Throwable -> L88
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L75 java.lang.Throwable -> L88
                java.lang.String r0 = r0.readLine()     // Catch: java.lang.Exception -> L75 java.lang.Throwable -> L88
                r2.<init>(r0)     // Catch: java.lang.Exception -> L75 java.lang.Throwable -> L88
                r8 = r2
            L6f:
                if (r1 == 0) goto L87
            L71:
                r1.disconnect()
                goto L87
            L75:
                r0 = move-exception
                goto L7d
            L77:
                r8 = move-exception
                goto L8a
            L79:
                r1 = move-exception
                r6 = r1
                r1 = r0
                r0 = r6
            L7d:
                java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L88
                io.branch.referral.BranchLogger.m5575d(r0)     // Catch: java.lang.Throwable -> L88
                if (r1 == 0) goto L87
                goto L71
            L87:
                return r8
            L88:
                r8 = move-exception
                r0 = r1
            L8a:
                if (r0 == 0) goto L8f
                r0.disconnect()
            L8f:
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.UniversalResourceAnalyser.UrlSkipListUpdateTask.doInBackground(java.lang.Void[]):org.json.JSONObject");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            if (jSONObject.optInt(UniversalResourceAnalyser.VERSION_KEY) > UniversalResourceAnalyser.skipURLFormats.optInt(UniversalResourceAnalyser.VERSION_KEY)) {
                JSONObject unused = UniversalResourceAnalyser.skipURLFormats = jSONObject;
                PrefHelper prefHelper = this.prefHelper;
                JSONObject jSONObject2 = UniversalResourceAnalyser.skipURLFormats;
                prefHelper.setString(UniversalResourceAnalyser.SKIP_URL_FORMATS_KEY, !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
            }
        }
    }
}
