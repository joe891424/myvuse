package com.salesforce.marketingcloud.http;

import android.os.Bundle;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.http.C4175d;
import com.salesforce.marketingcloud.internal.C4190m;
import com.yoti.mobile.android.remote.debug.RemoteDebugPreferencesKt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.p099io.CloseableKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.http.b */
/* JADX INFO: loaded from: classes6.dex */
public final class C4173b {

    /* JADX INFO: renamed from: i */
    public static final b f4841i = new b(null);

    /* JADX INFO: renamed from: j */
    private static final String f4842j = C4170g.m3197a("Request");

    /* JADX INFO: renamed from: k */
    public static final String f4843k = "GET";

    /* JADX INFO: renamed from: l */
    public static final String f4844l = "POST";

    /* JADX INFO: renamed from: m */
    public static final String f4845m = "PATCH";

    /* JADX INFO: renamed from: n */
    public static final int f4846n = -100;

    /* JADX INFO: renamed from: o */
    private static final int f4847o = 30000;

    /* JADX INFO: renamed from: a */
    private final String f4848a;

    /* JADX INFO: renamed from: b */
    private final String f4849b;

    /* JADX INFO: renamed from: c */
    private final int f4850c;

    /* JADX INFO: renamed from: d */
    private final String f4851d;

    /* JADX INFO: renamed from: e */
    private final String f4852e;

    /* JADX INFO: renamed from: f */
    private final List<String> f4853f;

    /* JADX INFO: renamed from: g */
    private final EnumC4172a f4854g;

    /* JADX INFO: renamed from: h */
    private String f4855h;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.http.b$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        private String f4856a;

        /* JADX INFO: renamed from: b */
        private String f4857b;

        /* JADX INFO: renamed from: d */
        private String f4859d;

        /* JADX INFO: renamed from: e */
        private String f4860e;

        /* JADX INFO: renamed from: f */
        private EnumC4172a f4861f;

        /* JADX INFO: renamed from: h */
        private List<String> f4863h;

        /* JADX INFO: renamed from: c */
        private int f4858c = 30000;

        /* JADX INFO: renamed from: g */
        private Map<String, String> f4862g = new LinkedHashMap();

        /* JADX INFO: renamed from: a */
        public final a m3285a(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f4862g.put(key, StringsKt.trim((CharSequence) value).toString());
            return this;
        }

        /* JADX INFO: renamed from: b */
        public final a m3288b(String method) {
            Intrinsics.checkNotNullParameter(method, "method");
            this.f4856a = method;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public final a m3289c(String requestBody) {
            Intrinsics.checkNotNullParameter(requestBody, "requestBody");
            this.f4859d = requestBody;
            return this;
        }

        /* JADX INFO: renamed from: d */
        public final a m3290d(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.f4857b = url;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final C4173b m3286a() {
            List<String> list;
            List<String> listEmptyList = this.f4863h;
            if (listEmptyList != null) {
                list = listEmptyList;
            } else if (this.f4862g.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
                list = listEmptyList;
            } else {
                Map<String, String> map = this.f4862g;
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    CollectionsKt.addAll(arrayList, CollectionsKt.plus((Collection<? extends String>) CollectionsKt.listOf(key), entry.getValue()));
                }
                list = arrayList;
            }
            String str = this.f4859d;
            if (str == null) {
                this.f4860e = "";
            }
            String str2 = this.f4856a;
            if (str2 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            String str3 = this.f4857b;
            if (str3 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            int i = this.f4858c;
            String str4 = this.f4860e;
            if (str4 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            EnumC4172a enumC4172a = this.f4861f;
            if (enumC4172a != null) {
                return new C4173b(str2, str, i, str4, str3, list, enumC4172a);
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        /* JADX INFO: renamed from: a */
        public final a m3282a(int i) {
            this.f4858c = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final a m3284a(String contentType) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            this.f4860e = contentType;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final void m3287a(List<String> headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.f4863h = headers;
        }

        /* JADX INFO: renamed from: a */
        public final a m3283a(EnumC4172a requestId) {
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            this.f4861f = requestId;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.http.b$b */
    public static final class b {
        private b() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final a m3291a() {
            return new a();
        }

        /* JADX INFO: renamed from: b */
        public final String m3293b() {
            return C4173b.f4842j;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final C4173b m3292a(Bundle data) {
            Intrinsics.checkNotNullParameter(data, "data");
            a aVarM3291a = C4173b.f4841i.m3291a();
            String string = data.getString("method");
            if (string != null) {
                Intrinsics.checkNotNull(string);
                aVarM3291a.m3288b(string);
            }
            String string2 = data.getString("requestBody");
            if (string2 != null) {
                Intrinsics.checkNotNull(string2);
                aVarM3291a.m3289c(string2);
            }
            aVarM3291a.m3282a(data.getInt("connectionTimeout"));
            String string3 = data.getString(AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
            if (string3 != null) {
                Intrinsics.checkNotNull(string3);
                aVarM3291a.m3284a(string3);
            }
            String string4 = data.getString("url");
            if (string4 != null) {
                Intrinsics.checkNotNull(string4);
                aVarM3291a.m3290d(string4);
            }
            ArrayList<String> stringArrayList = data.getStringArrayList("headers");
            if (stringArrayList != null) {
                Intrinsics.checkNotNull(stringArrayList);
                aVarM3291a.m3287a(stringArrayList);
            }
            aVarM3291a.m3283a(EnumC4172a.values()[data.getInt("mcRequestId", 0)]);
            C4173b c4173bM3286a = aVarM3291a.m3286a();
            c4173bM3286a.m3264a(data.getString(HeaderParameterNames.AUTHENTICATION_TAG));
            return c4173bM3286a;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.http.b$c */
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface c {
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.http.b$d */
    static final class d extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final d f4864a = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to complete request";
        }
    }

    public C4173b(String method, String str, int i, String contentType, String url, List<String> headers, EnumC4172a requestId) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        this.f4848a = method;
        this.f4849b = str;
        this.f4850c = i;
        this.f4851d = contentType;
        this.f4852e = url;
        this.f4853f = headers;
        this.f4854g = requestId;
    }

    @JvmStatic
    /* JADX INFO: renamed from: b */
    public static final a m3262b() {
        return f4841i.m3291a();
    }

    /* JADX INFO: renamed from: c */
    public final String m3265c() {
        return this.f4848a;
    }

    /* JADX INFO: renamed from: d */
    public final String m3266d() {
        return this.f4849b;
    }

    /* JADX INFO: renamed from: e */
    public final int m3267e() {
        return this.f4850c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4173b)) {
            return false;
        }
        C4173b c4173b = (C4173b) obj;
        return Intrinsics.areEqual(this.f4848a, c4173b.f4848a) && Intrinsics.areEqual(this.f4849b, c4173b.f4849b) && this.f4850c == c4173b.f4850c && Intrinsics.areEqual(this.f4851d, c4173b.f4851d) && Intrinsics.areEqual(this.f4852e, c4173b.f4852e) && Intrinsics.areEqual(this.f4853f, c4173b.f4853f) && this.f4854g == c4173b.f4854g;
    }

    /* JADX INFO: renamed from: f */
    public final String m3268f() {
        return this.f4851d;
    }

    /* JADX INFO: renamed from: g */
    public final String m3269g() {
        return this.f4852e;
    }

    /* JADX INFO: renamed from: h */
    public final List<String> m3270h() {
        return this.f4853f;
    }

    public int hashCode() {
        int iHashCode = this.f4848a.hashCode() * 31;
        String str = this.f4849b;
        return ((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.f4850c)) * 31) + this.f4851d.hashCode()) * 31) + this.f4852e.hashCode()) * 31) + this.f4853f.hashCode()) * 31) + this.f4854g.hashCode();
    }

    /* JADX INFO: renamed from: i */
    public final EnumC4172a m3271i() {
        return this.f4854g;
    }

    /* JADX INFO: renamed from: j */
    public final C4175d m3272j() throws Throwable {
        C4175d c4175dM3317a;
        HttpsURLConnection httpsURLConnection;
        long jCurrentTimeMillis = System.currentTimeMillis();
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            try {
                URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(new URL(this.f4852e).openConnection()));
                Intrinsics.checkNotNull(uRLConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                httpsURLConnection = (HttpsURLConnection) uRLConnection;
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpsURLConnection.setRequestMethod(this.f4848a);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setAllowUserInteraction(false);
            httpsURLConnection.setConnectTimeout(this.f4850c);
            IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, this.f4853f.size()), 2);
            int first = intProgressionStep.getFirst();
            int last = intProgressionStep.getLast();
            int step = intProgressionStep.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    httpsURLConnection.setRequestProperty(this.f4853f.get(first), this.f4853f.get(first + 1));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
            String str = this.f4849b;
            if (str != null) {
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setRequestProperty("Content-Type", this.f4851d);
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                try {
                    byte[] bytes = str.getBytes(C4190m.m3409b());
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    outputStream.write(bytes);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(outputStream, null);
                } finally {
                }
            }
            C4175d.a aVarM3316a = C4175d.f4882g.m3316a();
            aVarM3316a.m3309a(httpsURLConnection.getResponseCode());
            String responseMessage = httpsURLConnection.getResponseMessage();
            Intrinsics.checkNotNullExpressionValue(responseMessage, "getResponseMessage(...)");
            aVarM3316a.m3315b(responseMessage);
            Map<String, List<String>> headerFields = httpsURLConnection.getHeaderFields();
            Intrinsics.checkNotNullExpressionValue(headerFields, "getHeaderFields(...)");
            aVarM3316a.m3312a(headerFields);
            try {
                String strM3261a = m3261a(httpsURLConnection.getInputStream());
                if (strM3261a != null) {
                    aVarM3316a.m3311a(strM3261a);
                }
            } catch (IOException unused) {
                String strM3261a2 = m3261a(httpsURLConnection.getErrorStream());
                if (strM3261a2 != null) {
                    aVarM3316a.m3311a(strM3261a2);
                }
            }
            aVarM3316a.m3314b(jCurrentTimeMillis);
            aVarM3316a.m3310a(System.currentTimeMillis());
            c4175dM3317a = aVarM3316a.m3313a();
            httpsURLConnection.disconnect();
        } catch (Exception e2) {
            e = e2;
            httpsURLConnection2 = httpsURLConnection;
            C4170g.f4785a.m3223b(f4842j, e, d.f4864a);
            c4175dM3317a = C4175d.f4882g.m3317a(RemoteDebugPreferencesKt.DEBUG_OPTIONS_REMOTE_BEHAVIOUR_ERROR, -100);
            if (httpsURLConnection2 != null) {
                httpsURLConnection2.disconnect();
            }
        } catch (Throwable th2) {
            th = th2;
            httpsURLConnection2 = httpsURLConnection;
            if (httpsURLConnection2 != null) {
                httpsURLConnection2.disconnect();
            }
            throw th;
        }
        return c4175dM3317a;
    }

    /* JADX INFO: renamed from: k */
    public final int m3273k() {
        return this.f4850c;
    }

    /* JADX INFO: renamed from: l */
    public final String m3274l() {
        return this.f4851d;
    }

    /* JADX INFO: renamed from: m */
    public final List<String> m3275m() {
        return this.f4853f;
    }

    /* JADX INFO: renamed from: n */
    public final String m3276n() {
        return this.f4848a;
    }

    /* JADX INFO: renamed from: o */
    public final String m3277o() {
        return this.f4849b;
    }

    /* JADX INFO: renamed from: p */
    public final EnumC4172a m3278p() {
        return this.f4854g;
    }

    /* JADX INFO: renamed from: q */
    public final String m3279q() {
        return this.f4855h;
    }

    /* JADX INFO: renamed from: r */
    public final String m3280r() {
        return this.f4852e;
    }

    /* JADX INFO: renamed from: s */
    public final Bundle m3281s() {
        Bundle bundle = new Bundle();
        bundle.putString("method", this.f4848a);
        bundle.putString("requestBody", this.f4849b);
        bundle.putInt("connectionTimeout", this.f4850c);
        bundle.putString(AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE, this.f4851d);
        bundle.putString("url", this.f4852e);
        List<String> list = this.f4853f;
        bundle.putStringArrayList("headers", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(this.f4853f));
        bundle.putInt("mcRequestId", this.f4854g.ordinal());
        bundle.putString(HeaderParameterNames.AUTHENTICATION_TAG, this.f4855h);
        return bundle;
    }

    public String toString() {
        return "Request(method=" + this.f4848a + ", requestBody=" + this.f4849b + ", connectionTimeout=" + this.f4850c + ", contentType=" + this.f4851d + ", url=" + this.f4852e + ", headers=" + this.f4853f + ", requestId=" + this.f4854g + ")";
    }

    /* JADX INFO: renamed from: a */
    public final C4173b m3263a(String method, String str, int i, String contentType, String url, List<String> headers, EnumC4172a requestId) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        return new C4173b(method, str, i, contentType, url, headers, requestId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ C4173b m3259a(C4173b c4173b, String str, String str2, int i, String str3, String str4, List list, EnumC4172a enumC4172a, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c4173b.f4848a;
        }
        if ((i2 & 2) != 0) {
            str2 = c4173b.f4849b;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            i = c4173b.f4850c;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = c4173b.f4851d;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = c4173b.f4852e;
        }
        String str7 = str4;
        if ((i2 & 32) != 0) {
            list = c4173b.f4853f;
        }
        List list2 = list;
        if ((i2 & 64) != 0) {
            enumC4172a = c4173b.f4854g;
        }
        return c4173b.m3263a(str, str5, i3, str6, str7, list2, enumC4172a);
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final C4173b m3258a(Bundle bundle) {
        return f4841i.m3292a(bundle);
    }

    /* JADX INFO: renamed from: a */
    private final String m3261a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, C4190m.m3409b()));
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    String string = sb.toString();
                    CloseableKt.closeFinally(bufferedReader, null);
                    return string;
                }
                sb.append(line).append('\n');
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3264a(String str) {
        this.f4855h = str;
    }
}
