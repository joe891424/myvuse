package com.qualtrics.digital;

import com.google.gson.JsonObject;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class DecoderUtils {
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.qualtrics.digital.Creative getDecodedCreativeDefinition(retrofit2.Response<com.google.gson.JsonObject> r7) {
        /*
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            r1 = 0
            if (r7 == 0) goto L9d
            java.lang.Object r2 = r7.body()
            if (r2 != 0) goto L10
            goto L9d
        L10:
            java.lang.Object r2 = r7.body()
            com.google.gson.JsonObject r2 = (com.google.gson.JsonObject) r2
            java.lang.String r7 = getCreativeType(r7)
            if (r7 != 0) goto L1d
            return r1
        L1d:
            int r3 = r7.hashCode()     // Catch: com.google.gson.JsonSyntaxException -> L98
            r4 = -1037615855(0xffffffffc2273d11, float:-41.809635)
            r5 = 2
            r6 = 1
            if (r3 == r4) goto L47
            r4 = -555333939(0xffffffffdee646cd, float:-8.2965876E18)
            if (r3 == r4) goto L3d
            r4 = 427650979(0x197d6fa3, float:1.3102338E-23)
            if (r3 == r4) goto L33
            goto L51
        L33:
            java.lang.String r3 = "MobilePopOver"
            boolean r7 = r7.equals(r3)     // Catch: com.google.gson.JsonSyntaxException -> L98
            if (r7 == 0) goto L51
            r7 = r6
            goto L52
        L3d:
            java.lang.String r3 = "MobileNotification"
            boolean r7 = r7.equals(r3)     // Catch: com.google.gson.JsonSyntaxException -> L98
            if (r7 == 0) goto L51
            r7 = 0
            goto L52
        L47:
            java.lang.String r3 = "MobileEmbeddedFeedback"
            boolean r7 = r7.equals(r3)     // Catch: com.google.gson.JsonSyntaxException -> L98
            if (r7 == 0) goto L51
            r7 = r5
            goto L52
        L51:
            r7 = -1
        L52:
            if (r7 == 0) goto L83
            if (r7 == r6) goto L6e
            if (r7 == r5) goto L59
            return r1
        L59:
            java.lang.Class<com.qualtrics.digital.EmbeddedFeedbackCreative> r7 = com.qualtrics.digital.EmbeddedFeedbackCreative.class
            boolean r3 = r0 instanceof com.google.gson.Gson     // Catch: com.google.gson.JsonSyntaxException -> L98
            if (r3 != 0) goto L64
            java.lang.Object r7 = r0.fromJson(r2, r7)     // Catch: com.google.gson.JsonSyntaxException -> L98
            goto L6b
        L64:
            r3 = r0
            com.google.gson.Gson r3 = (com.google.gson.Gson) r3     // Catch: com.google.gson.JsonSyntaxException -> L98
            java.lang.Object r7 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson(r0, r2, r7)     // Catch: com.google.gson.JsonSyntaxException -> L98
        L6b:
            com.qualtrics.digital.Creative r7 = (com.qualtrics.digital.Creative) r7     // Catch: com.google.gson.JsonSyntaxException -> L98
            goto L97
        L6e:
            java.lang.Class<com.qualtrics.digital.PopOverCreative> r7 = com.qualtrics.digital.PopOverCreative.class
            boolean r3 = r0 instanceof com.google.gson.Gson     // Catch: com.google.gson.JsonSyntaxException -> L98
            if (r3 != 0) goto L79
            java.lang.Object r7 = r0.fromJson(r2, r7)     // Catch: com.google.gson.JsonSyntaxException -> L98
            goto L80
        L79:
            r3 = r0
            com.google.gson.Gson r3 = (com.google.gson.Gson) r3     // Catch: com.google.gson.JsonSyntaxException -> L98
            java.lang.Object r7 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson(r0, r2, r7)     // Catch: com.google.gson.JsonSyntaxException -> L98
        L80:
            com.qualtrics.digital.Creative r7 = (com.qualtrics.digital.Creative) r7     // Catch: com.google.gson.JsonSyntaxException -> L98
            goto L97
        L83:
            java.lang.Class<com.qualtrics.digital.NotificationCreative> r7 = com.qualtrics.digital.NotificationCreative.class
            boolean r3 = r0 instanceof com.google.gson.Gson     // Catch: com.google.gson.JsonSyntaxException -> L98
            if (r3 != 0) goto L8e
            java.lang.Object r7 = r0.fromJson(r2, r7)     // Catch: com.google.gson.JsonSyntaxException -> L98
            goto L95
        L8e:
            r3 = r0
            com.google.gson.Gson r3 = (com.google.gson.Gson) r3     // Catch: com.google.gson.JsonSyntaxException -> L98
            java.lang.Object r7 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson(r0, r2, r7)     // Catch: com.google.gson.JsonSyntaxException -> L98
        L95:
            com.qualtrics.digital.Creative r7 = (com.qualtrics.digital.Creative) r7     // Catch: com.google.gson.JsonSyntaxException -> L98
        L97:
            return r7
        L98:
            java.lang.String r7 = "Error decoding creative"
            com.qualtrics.digital.QualtricsLog.logError(r7)
        L9d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qualtrics.digital.DecoderUtils.getDecodedCreativeDefinition(retrofit2.Response):com.qualtrics.digital.Creative");
    }

    public static String getCreativeType(Response<JsonObject> response) {
        JsonObject jsonObjectBody = response.body();
        JsonObject asJsonObject = jsonObjectBody.getAsJsonObject("CreativeDefinition");
        if (asJsonObject == null || asJsonObject.get("Type") == null) {
            return null;
        }
        return jsonObjectBody.getAsJsonObject("CreativeDefinition").get("Type").getAsString();
    }
}
