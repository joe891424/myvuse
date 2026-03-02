package com.yoti.mobile.android.remote.model;

import android.os.Build;
import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.yoti.mobile.android.remote.ip_tracking.domain.IIpRepository;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: DeviceMetadata.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001:\u0001.Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003Jo\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\nHÖ\u0001J\u0006\u0010,\u001a\u00020\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006/"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/model/DeviceMetadata;", "", "manufacture_name", "", "model_name", "os_name", "Lcom/yoti/mobile/android/remote/model/ClientType;", "os_version", "client_version", "product", "", "browser_name", "browser_version", "locale", "ip", "(Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/remote/model/ClientType;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrowser_name", "()Ljava/lang/String;", "getBrowser_version", "getClient_version", "getIp", "getLocale", "getManufacture_name", "getModel_name", "getOs_name", "()Lcom/yoti/mobile/android/remote/model/ClientType;", "getOs_version", "getProduct", "()I", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toBase64", "toString", "Factory", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DeviceMetadata {

    @SerializedName("browser_name")
    private final String browser_name;

    @SerializedName("browser_version")
    private final String browser_version;

    @SerializedName("client_version")
    private final String client_version;

    @SerializedName("ip_address")
    private final String ip;

    @SerializedName("locale")
    private final String locale;

    @SerializedName("manufacture_name")
    private final String manufacture_name;

    @SerializedName("model_name")
    private final String model_name;

    @SerializedName("os_name")
    private final ClientType os_name;

    @SerializedName("os_version")
    private final String os_version;

    @SerializedName("product")
    private final int product;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getManufacture_name() {
        return this.manufacture_name;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getIp() {
        return this.ip;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getModel_name() {
        return this.model_name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ClientType getOs_name() {
        return this.os_name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOs_version() {
        return this.os_version;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getClient_version() {
        return this.client_version;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getProduct() {
        return this.product;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getBrowser_name() {
        return this.browser_name;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBrowser_version() {
        return this.browser_version;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getLocale() {
        return this.locale;
    }

    public final DeviceMetadata copy(String manufacture_name, String model_name, ClientType os_name, String os_version, String client_version, int product, String browser_name, String browser_version, String locale, String ip) {
        Intrinsics.checkNotNullParameter(manufacture_name, "manufacture_name");
        Intrinsics.checkNotNullParameter(model_name, "model_name");
        Intrinsics.checkNotNullParameter(os_name, "os_name");
        Intrinsics.checkNotNullParameter(os_version, "os_version");
        Intrinsics.checkNotNullParameter(client_version, "client_version");
        Intrinsics.checkNotNullParameter(browser_name, "browser_name");
        Intrinsics.checkNotNullParameter(browser_version, "browser_version");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new DeviceMetadata(manufacture_name, model_name, os_name, os_version, client_version, product, browser_name, browser_version, locale, ip);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceMetadata)) {
            return false;
        }
        DeviceMetadata deviceMetadata = (DeviceMetadata) other;
        return Intrinsics.areEqual(this.manufacture_name, deviceMetadata.manufacture_name) && Intrinsics.areEqual(this.model_name, deviceMetadata.model_name) && this.os_name == deviceMetadata.os_name && Intrinsics.areEqual(this.os_version, deviceMetadata.os_version) && Intrinsics.areEqual(this.client_version, deviceMetadata.client_version) && this.product == deviceMetadata.product && Intrinsics.areEqual(this.browser_name, deviceMetadata.browser_name) && Intrinsics.areEqual(this.browser_version, deviceMetadata.browser_version) && Intrinsics.areEqual(this.locale, deviceMetadata.locale) && Intrinsics.areEqual(this.ip, deviceMetadata.ip);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.manufacture_name.hashCode() * 31) + this.model_name.hashCode()) * 31) + this.os_name.hashCode()) * 31) + this.os_version.hashCode()) * 31) + this.client_version.hashCode()) * 31) + Integer.hashCode(this.product)) * 31) + this.browser_name.hashCode()) * 31) + this.browser_version.hashCode()) * 31) + this.locale.hashCode()) * 31;
        String str = this.ip;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DeviceMetadata(manufacture_name=" + this.manufacture_name + ", model_name=" + this.model_name + ", os_name=" + this.os_name + ", os_version=" + this.os_version + ", client_version=" + this.client_version + ", product=" + this.product + ", browser_name=" + this.browser_name + ", browser_version=" + this.browser_version + ", locale=" + this.locale + ", ip=" + this.ip + ')';
    }

    public DeviceMetadata(String manufacture_name, String model_name, ClientType os_name, String os_version, String client_version, int i, String browser_name, String browser_version, String locale, String str) {
        Intrinsics.checkNotNullParameter(manufacture_name, "manufacture_name");
        Intrinsics.checkNotNullParameter(model_name, "model_name");
        Intrinsics.checkNotNullParameter(os_name, "os_name");
        Intrinsics.checkNotNullParameter(os_version, "os_version");
        Intrinsics.checkNotNullParameter(client_version, "client_version");
        Intrinsics.checkNotNullParameter(browser_name, "browser_name");
        Intrinsics.checkNotNullParameter(browser_version, "browser_version");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.manufacture_name = manufacture_name;
        this.model_name = model_name;
        this.os_name = os_name;
        this.os_version = os_version;
        this.client_version = client_version;
        this.product = i;
        this.browser_name = browser_name;
        this.browser_version = browser_version;
        this.locale = locale;
        this.ip = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DeviceMetadata(String str, String str2, ClientType clientType, String str3, String str4, int i, String str5, String str6, String str7, String str8, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        String str9;
        String str10;
        String str11;
        if ((i2 & 1) != 0) {
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            str9 = MANUFACTURER;
        } else {
            str9 = str;
        }
        if ((i2 & 2) != 0) {
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            str10 = MODEL;
        } else {
            str10 = str2;
        }
        ClientType clientType2 = (i2 & 4) != 0 ? ClientType.ANDROID : clientType;
        String strValueOf = (i2 & 8) != 0 ? String.valueOf(Build.VERSION.SDK_INT) : str3;
        String str12 = (i2 & 16) != 0 ? "3.1.0" : str4;
        int i3 = (i2 & 32) != 0 ? 3 : i;
        String str13 = (i2 & 64) != 0 ? "" : str5;
        String str14 = (i2 & 128) != 0 ? "" : str6;
        if ((i2 & 256) != 0) {
            String languageTag = Locale.getDefault().toLanguageTag();
            Intrinsics.checkNotNullExpressionValue(languageTag, "getDefault().toLanguageTag()");
            str11 = languageTag;
        } else {
            str11 = str7;
        }
        this(str9, str10, clientType2, strValueOf, str12, i3, str13, str14, str11, str8);
    }

    public final String getManufacture_name() {
        return this.manufacture_name;
    }

    public final String getModel_name() {
        return this.model_name;
    }

    public final ClientType getOs_name() {
        return this.os_name;
    }

    public final String getOs_version() {
        return this.os_version;
    }

    public final String getClient_version() {
        return this.client_version;
    }

    public final int getProduct() {
        return this.product;
    }

    public final String getBrowser_name() {
        return this.browser_name;
    }

    public final String getBrowser_version() {
        return this.browser_version;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getIp() {
        return this.ip;
    }

    public final String toBase64() {
        Gson gson = new Gson();
        String json = !(gson instanceof Gson) ? gson.toJson(this) : GsonInstrumentation.toJson(gson, this);
        Intrinsics.checkNotNullExpressionValue(json, "json");
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(json.toByteArray(), Base64.NO_WRAP)");
        return strEncodeToString;
    }

    /* JADX INFO: compiled from: DeviceMetadata.kt */
    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/model/DeviceMetadata$Factory;", "", "session", "Lcom/yoti/mobile/android/remote/model/Session;", "ipRepository", "Lcom/yoti/mobile/android/remote/ip_tracking/domain/IIpRepository;", "(Lcom/yoti/mobile/android/remote/model/Session;Lcom/yoti/mobile/android/remote/ip_tracking/domain/IIpRepository;)V", "create", "Lcom/yoti/mobile/android/remote/model/DeviceMetadata;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Factory {
        private final IIpRepository ipRepository;
        private final Session session;

        @Inject
        public Factory(Session session, IIpRepository ipRepository) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(ipRepository, "ipRepository");
            this.session = session;
            this.ipRepository = ipRepository;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object create(kotlin.coroutines.Continuation<? super com.yoti.mobile.android.remote.model.DeviceMetadata> r15) {
            /*
                r14 = this;
                boolean r0 = r15 instanceof com.yoti.mobile.android.remote.model.DeviceMetadata$Factory$create$1
                if (r0 == 0) goto L14
                r0 = r15
                com.yoti.mobile.android.remote.model.DeviceMetadata$Factory$create$1 r0 = (com.yoti.mobile.android.remote.model.DeviceMetadata$Factory$create$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r15 = r0.label
                int r15 = r15 - r2
                r0.label = r15
                goto L19
            L14:
                com.yoti.mobile.android.remote.model.DeviceMetadata$Factory$create$1 r0 = new com.yoti.mobile.android.remote.model.DeviceMetadata$Factory$create$1
                r0.<init>(r14, r15)
            L19:
                java.lang.Object r15 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L36
                if (r2 != r3) goto L2e
                java.lang.Object r0 = r0.L$0
                com.yoti.mobile.android.remote.model.DeviceMetadata$Factory r0 = (com.yoti.mobile.android.remote.model.DeviceMetadata.Factory) r0
                kotlin.ResultKt.throwOnFailure(r15)
                goto L47
            L2e:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L36:
                kotlin.ResultKt.throwOnFailure(r15)
                com.yoti.mobile.android.remote.ip_tracking.domain.IIpRepository r15 = r14.ipRepository
                r0.L$0 = r14
                r0.label = r3
                java.lang.Object r15 = r15.getIp(r0)
                if (r15 != r1) goto L46
                return r1
            L46:
                r0 = r14
            L47:
                r11 = r15
                java.lang.String r11 = (java.lang.String) r11
                com.yoti.mobile.android.remote.model.Session r15 = r0.session
                com.yoti.mobile.android.remote.model.ClientType r4 = r15.getClientType()
                com.yoti.mobile.android.remote.model.DeviceMetadata r15 = new com.yoti.mobile.android.remote.model.DeviceMetadata
                r12 = 507(0x1fb, float:7.1E-43)
                r13 = 0
                r2 = 0
                r3 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r1 = r15
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.remote.model.DeviceMetadata.Factory.create(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
