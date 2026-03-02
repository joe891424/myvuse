package com.bat.sdk.asav.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsavSettings.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001'B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\t\u0010 \u001a\u00020!H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001a\u001a\u00060\u001bR\u00020\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\t\u0010\"\u001a\u00020#X\u0096\u0005R\t\u0010$\u001a\u00020#X\u0096\u0005R\t\u0010%\u001a\u00020#X\u0096\u0005R\t\u0010&\u001a\u00020#X\u0096\u0005¨\u0006("}, m5598d2 = {"Lcom/bat/sdk/asav/core/AsavSettings;", "Lcom/bat/sdk/asav/core/IAsavChannels;", "channels", "<init>", "(Lcom/bat/sdk/asav/core/IAsavChannels;)V", "RSSIthreshold", "", "getRSSIthreshold", "()I", "setRSSIthreshold", "(I)V", "advTimeInterval", "", "getAdvTimeInterval", "()J", "setAdvTimeInterval", "(J)V", "signerBaseUrl", "", "getSignerBaseUrl", "()Ljava/lang/String;", "setSignerBaseUrl", "(Ljava/lang/String;)V", "signerUrl", "getSignerUrl", "setSignerUrl", "customer", "Lcom/bat/sdk/asav/core/AsavSettings$Customer;", "getCustomer", "()Lcom/bat/sdk/asav/core/AsavSettings$Customer;", "setCustomer", "(Lcom/bat/sdk/asav/core/AsavSettings$Customer;)V", "init", "", "challengeRequestChannel", "Lcom/bat/sdk/asav/core/IAsavChannel;", "challengeResponseChannel", "signatureRequestChannel", "signatureResponseChannel", "Customer", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavSettings implements IAsavChannels {
    private int RSSIthreshold;
    private long advTimeInterval;
    private final IAsavChannels channels;
    private Customer customer;
    private String signerBaseUrl;
    private String signerUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public AsavSettings() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.bat.sdk.asav.core.IAsavChannels
    public IAsavChannel getChallengeRequestChannel() {
        return this.channels.getChallengeRequestChannel();
    }

    @Override // com.bat.sdk.asav.core.IAsavChannels
    public IAsavChannel getChallengeResponseChannel() {
        return this.channels.getChallengeResponseChannel();
    }

    @Override // com.bat.sdk.asav.core.IAsavChannels
    public IAsavChannel getSignatureRequestChannel() {
        return this.channels.getSignatureRequestChannel();
    }

    @Override // com.bat.sdk.asav.core.IAsavChannels
    public IAsavChannel getSignatureResponseChannel() {
        return this.channels.getSignatureResponseChannel();
    }

    @Override // com.bat.sdk.asav.core.IAsavChannels
    public void init() {
        this.channels.init();
    }

    public AsavSettings(IAsavChannels channels) {
        Intrinsics.checkNotNullParameter(channels, "channels");
        this.channels = channels;
        this.RSSIthreshold = -50;
        this.advTimeInterval = 500L;
        this.signerBaseUrl = "https://d1ceh6namax7gj.cloudfront.net";
        this.signerUrl = "/v1.0/secure-av";
        this.customer = new Customer(this, "test", "test", "0tthlu8zqv8ktggcpaq2x7z2bhzxgjpo", null, 8, null);
    }

    public /* synthetic */ AsavSettings(Channels channels, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Channels() : channels);
    }

    public final int getRSSIthreshold() {
        return this.RSSIthreshold;
    }

    public final void setRSSIthreshold(int i) {
        this.RSSIthreshold = i;
    }

    public final long getAdvTimeInterval() {
        return this.advTimeInterval;
    }

    public final void setAdvTimeInterval(long j) {
        this.advTimeInterval = j;
    }

    public final String getSignerBaseUrl() {
        return this.signerBaseUrl;
    }

    public final void setSignerBaseUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.signerBaseUrl = str;
    }

    public final String getSignerUrl() {
        return this.signerUrl;
    }

    public final void setSignerUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.signerUrl = str;
    }

    public final Customer getCustomer() {
        return this.customer;
    }

    public final void setCustomer(Customer customer) {
        Intrinsics.checkNotNullParameter(customer, "<set-?>");
        this.customer = customer;
    }

    /* JADX INFO: compiled from: AsavSettings.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, m5598d2 = {"Lcom/bat/sdk/asav/core/AsavSettings$Customer;", "", "id", "", "token", "tenant", "accessToken", "<init>", "(Lcom/bat/sdk/asav/core/AsavSettings;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getToken", "setToken", "getTenant", "setTenant", "getAccessToken", "setAccessToken", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public final class Customer {
        private String accessToken;
        private String id;
        private String tenant;
        final /* synthetic */ AsavSettings this$0;
        private String token;

        public Customer(AsavSettings asavSettings, String id, String token, String str, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(token, "token");
            this.this$0 = asavSettings;
            this.id = id;
            this.token = token;
            this.tenant = str;
            this.accessToken = str2;
        }

        public /* synthetic */ Customer(AsavSettings asavSettings, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(asavSettings, str, str2, str3, (i & 8) != 0 ? null : str4);
        }

        public final String getAccessToken() {
            return this.accessToken;
        }

        public final String getId() {
            return this.id;
        }

        public final String getTenant() {
            return this.tenant;
        }

        public final String getToken() {
            return this.token;
        }

        public final void setAccessToken(String str) {
            this.accessToken = str;
        }

        public final void setId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.id = str;
        }

        public final void setTenant(String str) {
            this.tenant = str;
        }

        public final void setToken(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.token = str;
        }
    }
}
