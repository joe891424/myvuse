package com.yoti.mobile.android.remote.authentication;

import android.content.Context;
import android.security.KeyChain;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyChainManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/authentication/KeyChainManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getCertificateChain", "", "Ljava/security/cert/X509Certificate;", "alias", "", "(Ljava/lang/String;)[Ljava/security/cert/X509Certificate;", "getPrivateKey", "Ljava/security/PrivateKey;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class KeyChainManager {
    private final Context context;

    public KeyChainManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final X509Certificate[] getCertificateChain(String alias) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        return KeyChain.getCertificateChain(this.context, alias);
    }

    public final PrivateKey getPrivateKey(String alias) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        return KeyChain.getPrivateKey(this.context, alias);
    }
}
