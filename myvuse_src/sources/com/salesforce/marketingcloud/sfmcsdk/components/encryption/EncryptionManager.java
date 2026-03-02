package com.salesforce.marketingcloud.sfmcsdk.components.encryption;

import android.content.Context;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: EncryptionManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0007\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/components/encryption/EncryptionManager;", "", "context", "Landroid/content/Context;", "moduleApplicationId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "encryptionKey", "getEncryptionKey$sfmcsdk_release", "()Ljava/lang/String;", "decrypt", "data", "encrypt", HeaderParameterNames.INITIALIZATION_VECTOR, "", "generateIV", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class EncryptionManager {
    private final String encryptionKey;

    public EncryptionManager(Context context, String moduleApplicationId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moduleApplicationId, "moduleApplicationId");
        String encryptionKey = new SalesforceKeyGenerator(context, new KeyStoreWrapper(context)).getEncryptionKey(moduleApplicationId);
        Intrinsics.checkNotNullExpressionValue(encryptionKey, "salesforceKeyGenerator.g…nKey(moduleApplicationId)");
        this.encryptionKey = encryptionKey;
    }

    /* JADX INFO: renamed from: getEncryptionKey$sfmcsdk_release, reason: from getter */
    public final String getEncryptionKey() {
        return this.encryptionKey;
    }

    public final byte[] generateIV() throws NoSuchAlgorithmException {
        byte[] bArrGenerateInitVector = Encryptor.generateInitVector();
        Intrinsics.checkNotNullExpressionValue(bArrGenerateInitVector, "generateInitVector()");
        return bArrGenerateInitVector;
    }

    public final String encrypt(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return Encryptor.encrypt(data, this.encryptionKey);
    }

    public final String encrypt(String data, byte[] iv) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(iv, "iv");
        return Encryptor.encrypt(data, this.encryptionKey, iv);
    }

    public final String decrypt(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return Encryptor.decrypt(data, this.encryptionKey);
    }
}
