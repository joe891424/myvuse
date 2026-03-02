package dev.mcodex.RNSensitiveInfo;

import android.content.SharedPreferences;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import android.util.Base64;
import android.util.Log;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.stats.CodePackage;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import dev.mcodex.RNSensitiveInfo.utils.AppConstants;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.UnrecoverableKeyException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.jose4j.keys.AesKey;

/* JADX INFO: loaded from: classes4.dex */
public class RNSensitiveInfoModule extends ReactContextBaseJavaModule {
    private static final String AES_DEFAULT_TRANSFORMATION = "AES/CBC/PKCS7Padding";
    private static final String AES_GCM = "AES/GCM/NoPadding";
    private static final String ANDROID_KEYSTORE_PROVIDER = "AndroidKeyStore";
    private static final String DELIMITER = "]";
    private static final byte[] FIXED_IV = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1};
    private static final String KEY_ALIAS = "MySharedPreferenceKeyAlias";
    private static final String KEY_ALIAS_AES = "MyAesKeyAlias";
    private static final String RSA_ECB = "RSA/ECB/PKCS1Padding";
    private boolean invalidateEnrollment;
    private CancellationSignal mCancellationSignal;
    private FingerprintManager mFingerprintManager;
    private KeyStore mKeyStore;

    public RNSensitiveInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.invalidateEnrollment = true;
        try {
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEYSTORE_PROVIDER);
            this.mKeyStore = keyStore;
            keyStore.load(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        initKeyStore();
        try {
            this.mFingerprintManager = (FingerprintManager) reactApplicationContext.getSystemService(AnalyticsAttribute.APP_EXIT_FINGERPRINT_ATTRIBUTE);
            initFingerprintKeyStore();
        } catch (Exception unused) {
            LogInstrumentation.m2726d("RNSensitiveInfo", "Fingerprint not supported");
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNSensitiveInfo";
    }

    private boolean hasSetupBiometricCredential() {
        try {
            return BiometricManager.from(getReactApplicationContext()).canAuthenticate() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    @ReactMethod
    public void setInvalidatedByBiometricEnrollment(boolean z, Promise promise) {
        this.invalidateEnrollment = z;
        try {
            prepareKey();
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void hasEnrolledFingerprints(Promise promise) {
        FingerprintManager fingerprintManager = this.mFingerprintManager;
        if (fingerprintManager != null) {
            promise.resolve(Boolean.valueOf(fingerprintManager.hasEnrolledFingerprints()));
        } else {
            promise.resolve(false);
        }
    }

    @ReactMethod
    public void isSensorAvailable(Promise promise) {
        promise.resolve(Boolean.valueOf(hasSetupBiometricCredential()));
    }

    @ReactMethod
    public void getItem(String str, ReadableMap readableMap, Promise promise) {
        String string = prefs(sharedPreferences(readableMap)).getString(str, null);
        if (string != null && readableMap.hasKey("touchID") && readableMap.getBoolean("touchID")) {
            decryptWithAes(string, readableMap.hasKey("showModal") && readableMap.getBoolean("showModal"), readableMap.hasKey("strings") ? readableMap.getMap("strings").toHashMap() : new HashMap<>(), promise, null);
            return;
        }
        if (string != null) {
            try {
                promise.resolve(decrypt(string));
                return;
            } catch (Exception e) {
                promise.reject(e);
                return;
            }
        }
        promise.resolve(string);
    }

    @ReactMethod
    public void setItem(String str, String str2, ReadableMap readableMap, Promise promise) {
        String strSharedPreferences = sharedPreferences(readableMap);
        if (readableMap.hasKey("touchID") && readableMap.getBoolean("touchID")) {
            putExtraWithAES(str, str2, prefs(strSharedPreferences), readableMap.hasKey("showModal") && readableMap.getBoolean("showModal"), readableMap.hasKey("strings") ? readableMap.getMap("strings").toHashMap() : new HashMap<>(), promise, null);
        } else {
            try {
                putExtra(str, encrypt(str2), prefs(strSharedPreferences));
                promise.resolve(str2);
            } catch (Exception e) {
                e.printStackTrace();
                promise.reject(e);
            }
        }
    }

    @ReactMethod
    public void deleteItem(String str, ReadableMap readableMap, Promise promise) {
        prefs(sharedPreferences(readableMap)).edit().remove(str).apply();
        promise.resolve(null);
    }

    @ReactMethod
    public void getAllItems(ReadableMap readableMap, Promise promise) {
        Map<String, ?> all = prefs(sharedPreferences(readableMap)).getAll();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String string = entry.getValue().toString();
            try {
                string = decrypt(string);
            } catch (Exception e) {
                LogInstrumentation.m2726d("RNSensitiveInfo", Log.getStackTraceString(e));
            }
            writableNativeMap.putString(entry.getKey(), string);
        }
        promise.resolve(writableNativeMap);
    }

    @ReactMethod
    public void cancelFingerprintAuth() {
        CancellationSignal cancellationSignal = this.mCancellationSignal;
        if (cancellationSignal == null || cancellationSignal.isCanceled()) {
            return;
        }
        this.mCancellationSignal.cancel();
    }

    private SharedPreferences prefs(String str) {
        return getReactApplicationContext().getSharedPreferences(str, 0);
    }

    private String sharedPreferences(ReadableMap readableMap) {
        String string = readableMap.hasKey("sharedPreferencesName") ? readableMap.getString("sharedPreferencesName") : "shared_preferences";
        return string == null ? "shared_preferences" : string;
    }

    private void putExtra(String str, String str2, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putString(str, str2).apply();
    }

    private void initKeyStore() {
        try {
            if (this.mKeyStore.containsAlias(KEY_ALIAS)) {
                return;
            }
            KeyGenerator keyGenerator = KeyGenerator.getInstance(AesKey.ALGORITHM, ANDROID_KEYSTORE_PROVIDER);
            keyGenerator.init(new KeyGenParameterSpec.Builder(KEY_ALIAS, 3).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").setRandomizedEncryptionRequired(false).build());
            keyGenerator.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showDialog(final HashMap map, final BiometricPrompt.CryptoObject cryptoObject, final BiometricPrompt.AuthenticationCallback authenticationCallback) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: dev.mcodex.RNSensitiveInfo.RNSensitiveInfoModule.1
            @Override // java.lang.Runnable
            public void run() {
                if (RNSensitiveInfoModule.this.getCurrentActivity() == null) {
                    authenticationCallback.onAuthenticationError(5, map.containsKey("cancelled") ? map.get("cancelled").toString() : "Authentication was cancelled");
                } else {
                    new BiometricPrompt((FragmentActivity) RNSensitiveInfoModule.this.getCurrentActivity(), Executors.newSingleThreadExecutor(), authenticationCallback).authenticate(new BiometricPrompt.PromptInfo.Builder().setDeviceCredentialAllowed(false).setNegativeButtonText(map.containsKey("cancel") ? map.get("cancel").toString() : "Cancel").setDescription(map.containsKey("description") ? map.get("description").toString() : null).setTitle(map.containsKey("header") ? map.get("header").toString() : "Unlock with your fingerprint").build(), cryptoObject);
                }
            }
        });
    }

    private void initFingerprintKeyStore() {
        try {
            if (this.mKeyStore.containsAlias(KEY_ALIAS_AES)) {
                return;
            }
            prepareKey();
        } catch (Exception unused) {
        }
    }

    private void prepareKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AesKey.ALGORITHM, ANDROID_KEYSTORE_PROVIDER);
        KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(KEY_ALIAS_AES, 3);
        builder.setBlockModes("CBC").setKeySize(256).setEncryptionPaddings("PKCS7Padding").setUserAuthenticationRequired(true);
        try {
            builder.setInvalidatedByBiometricEnrollment(this.invalidateEnrollment);
        } catch (Exception e) {
            LogInstrumentation.m2726d("RNSensitiveInfo", "Error setting setInvalidatedByBiometricEnrollment: " + e.getMessage());
        }
        keyGenerator.init(builder.build());
        keyGenerator.generateKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putExtraWithAES(final String str, final String str2, final SharedPreferences sharedPreferences, boolean z, final HashMap map, final Promise promise, Cipher cipher) {
        if (hasSetupBiometricCredential()) {
            try {
                if (cipher == null) {
                    SecretKey secretKey = (SecretKey) this.mKeyStore.getKey(KEY_ALIAS_AES, null);
                    Cipher cipher2 = Cipher.getInstance(AES_DEFAULT_TRANSFORMATION);
                    cipher2.init(1, secretKey);
                    KeyInfo keyInfo = (KeyInfo) SecretKeyFactory.getInstance(secretKey.getAlgorithm(), ANDROID_KEYSTORE_PROVIDER).getKeySpec(secretKey, KeyInfo.class);
                    if (!keyInfo.isUserAuthenticationRequired() || keyInfo.getUserAuthenticationValidityDurationSeconds() > 0) {
                        return;
                    }
                    if (z) {
                        showDialog(map, new BiometricPrompt.CryptoObject(cipher2), new BiometricPrompt.AuthenticationCallback() { // from class: dev.mcodex.RNSensitiveInfo.RNSensitiveInfoModule.1PutExtraWithAESCallback
                            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
                            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
                                RNSensitiveInfoModule.this.putExtraWithAES(str, str2, sharedPreferences, true, map, promise, authenticationResult.getCryptoObject().getCipher());
                            }

                            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
                            public void onAuthenticationError(int i, CharSequence charSequence) {
                                promise.reject(String.valueOf(i), charSequence.toString());
                            }

                            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
                            public void onAuthenticationFailed() {
                                ((DeviceEventManagerModule.RCTDeviceEventEmitter) RNSensitiveInfoModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(AppConstants.E_AUTHENTICATION_NOT_RECOGNIZED, "Authentication not recognized.");
                            }
                        });
                        return;
                    } else {
                        this.mCancellationSignal = new CancellationSignal();
                        this.mFingerprintManager.authenticate(new FingerprintManager.CryptoObject(cipher2), this.mCancellationSignal, 0, new FingerprintManager.AuthenticationCallback() { // from class: dev.mcodex.RNSensitiveInfo.RNSensitiveInfoModule.2
                            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
                            public void onAuthenticationFailed() {
                                super.onAuthenticationFailed();
                                ((DeviceEventManagerModule.RCTDeviceEventEmitter) RNSensitiveInfoModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(AppConstants.E_AUTHENTICATION_NOT_RECOGNIZED, "Fingerprint not recognized.");
                            }

                            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
                            public void onAuthenticationError(int i, CharSequence charSequence) {
                                super.onAuthenticationError(i, charSequence);
                                promise.reject(String.valueOf(i), charSequence.toString());
                            }

                            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
                            public void onAuthenticationHelp(int i, CharSequence charSequence) {
                                super.onAuthenticationHelp(i, charSequence);
                                ((DeviceEventManagerModule.RCTDeviceEventEmitter) RNSensitiveInfoModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(AppConstants.FINGERPRINT_AUTHENTICATION_HELP, charSequence.toString());
                            }

                            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
                            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                                super.onAuthenticationSucceeded(authenticationResult);
                                RNSensitiveInfoModule.this.putExtraWithAES(str, str2, sharedPreferences, false, map, promise, authenticationResult.getCryptoObject().getCipher());
                            }
                        }, null);
                        return;
                    }
                }
                byte[] bArrDoFinal = cipher.doFinal(str2.getBytes());
                putExtra(str, Base64.encodeToString(cipher.getIV(), 0) + DELIMITER + Base64.encodeToString(bArrDoFinal, 0), sharedPreferences);
                promise.resolve(str2);
                return;
            } catch (SecurityException e) {
                promise.reject(e);
                return;
            } catch (InvalidKeyException e2) {
                e = e2;
                Throwable th = e;
                try {
                    this.mKeyStore.deleteEntry(KEY_ALIAS_AES);
                    prepareKey();
                } catch (Exception e3) {
                    promise.reject(e3);
                }
                promise.reject(th);
                return;
            } catch (UnrecoverableKeyException e4) {
                e = e4;
                Throwable th2 = e;
                this.mKeyStore.deleteEntry(KEY_ALIAS_AES);
                prepareKey();
                promise.reject(th2);
                return;
            } catch (IllegalBlockSizeException e5) {
                if (e5.getCause() != null && e5.getCause().getMessage().contains("Key user not authenticated")) {
                    try {
                        this.mKeyStore.deleteEntry(KEY_ALIAS_AES);
                        prepareKey();
                        promise.reject(AppConstants.KM_ERROR_KEY_USER_NOT_AUTHENTICATED, e5.getCause().getMessage());
                        return;
                    } catch (Exception e6) {
                        promise.reject(e6);
                        return;
                    }
                }
                promise.reject(e5);
                return;
            } catch (Exception e7) {
                promise.reject(e7);
                return;
            }
        }
        promise.reject(AppConstants.E_BIOMETRIC_NOT_SUPPORTED, "Biometrics not supported");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decryptWithAes(final String str, boolean z, final HashMap map, final Promise promise, Cipher cipher) {
        if (hasSetupBiometricCredential()) {
            String[] strArrSplit = str.split(DELIMITER);
            if (strArrSplit.length < 2) {
                promise.reject("DecryptionFailed", "DecryptionFailed");
            }
            try {
                byte[] bArrDecode = Base64.decode(strArrSplit[0], 0);
                byte[] bArrDecode2 = Base64.decode(strArrSplit[1], 0);
                if (cipher == null) {
                    SecretKey secretKey = (SecretKey) this.mKeyStore.getKey(KEY_ALIAS_AES, null);
                    Cipher cipher2 = Cipher.getInstance(AES_DEFAULT_TRANSFORMATION);
                    cipher2.init(2, secretKey, new IvParameterSpec(bArrDecode));
                    KeyInfo keyInfo = (KeyInfo) SecretKeyFactory.getInstance(secretKey.getAlgorithm(), ANDROID_KEYSTORE_PROVIDER).getKeySpec(secretKey, KeyInfo.class);
                    if (!keyInfo.isUserAuthenticationRequired() || keyInfo.getUserAuthenticationValidityDurationSeconds() > 0) {
                        return;
                    }
                    if (z) {
                        showDialog(map, new BiometricPrompt.CryptoObject(cipher2), new BiometricPrompt.AuthenticationCallback() { // from class: dev.mcodex.RNSensitiveInfo.RNSensitiveInfoModule.1DecryptWithAesCallback
                            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
                            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
                                RNSensitiveInfoModule.this.decryptWithAes(str, true, map, promise, authenticationResult.getCryptoObject().getCipher());
                            }

                            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
                            public void onAuthenticationError(int i, CharSequence charSequence) {
                                promise.reject(String.valueOf(i), charSequence.toString());
                            }

                            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
                            public void onAuthenticationFailed() {
                                ((DeviceEventManagerModule.RCTDeviceEventEmitter) RNSensitiveInfoModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(AppConstants.E_AUTHENTICATION_NOT_RECOGNIZED, "Authentication not recognized.");
                            }
                        });
                        return;
                    } else {
                        this.mCancellationSignal = new CancellationSignal();
                        this.mFingerprintManager.authenticate(new FingerprintManager.CryptoObject(cipher2), this.mCancellationSignal, 0, new FingerprintManager.AuthenticationCallback() { // from class: dev.mcodex.RNSensitiveInfo.RNSensitiveInfoModule.3
                            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
                            public void onAuthenticationFailed() {
                                super.onAuthenticationFailed();
                                ((DeviceEventManagerModule.RCTDeviceEventEmitter) RNSensitiveInfoModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(AppConstants.E_AUTHENTICATION_NOT_RECOGNIZED, "Fingerprint not recognized.");
                            }

                            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
                            public void onAuthenticationError(int i, CharSequence charSequence) {
                                super.onAuthenticationError(i, charSequence);
                                promise.reject(String.valueOf(i), charSequence.toString());
                            }

                            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
                            public void onAuthenticationHelp(int i, CharSequence charSequence) {
                                super.onAuthenticationHelp(i, charSequence);
                                ((DeviceEventManagerModule.RCTDeviceEventEmitter) RNSensitiveInfoModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(AppConstants.FINGERPRINT_AUTHENTICATION_HELP, charSequence.toString());
                            }

                            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
                            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                                super.onAuthenticationSucceeded(authenticationResult);
                                RNSensitiveInfoModule.this.decryptWithAes(str, false, map, promise, authenticationResult.getCryptoObject().getCipher());
                            }
                        }, null);
                        return;
                    }
                }
                promise.resolve(new String(cipher.doFinal(bArrDecode2)));
                return;
            } catch (SecurityException e) {
                promise.reject(e);
                return;
            } catch (InvalidKeyException e2) {
                e = e2;
                try {
                    this.mKeyStore.deleteEntry(KEY_ALIAS_AES);
                    prepareKey();
                } catch (Exception e3) {
                    promise.reject(e3);
                }
                promise.reject(e);
                return;
            } catch (UnrecoverableKeyException e4) {
                e = e4;
                this.mKeyStore.deleteEntry(KEY_ALIAS_AES);
                prepareKey();
                promise.reject(e);
                return;
            } catch (IllegalBlockSizeException e5) {
                if (e5.getCause() != null && e5.getCause().getMessage().contains("Key user not authenticated")) {
                    try {
                        this.mKeyStore.deleteEntry(KEY_ALIAS_AES);
                        prepareKey();
                        promise.reject(AppConstants.KM_ERROR_KEY_USER_NOT_AUTHENTICATED, e5.getCause().getMessage());
                        return;
                    } catch (Exception e6) {
                        promise.reject(e6);
                        return;
                    }
                }
                promise.reject(e5);
                return;
            } catch (Exception e7) {
                promise.reject(e7);
                return;
            }
        }
        promise.reject(AppConstants.E_BIOMETRIC_NOT_SUPPORTED, "Biometrics not supported");
    }

    public String encrypt(String str) throws Exception {
        byte[] bytes = str.getBytes();
        SecretKey secretKey = ((KeyStore.SecretKeyEntry) this.mKeyStore.getEntry(KEY_ALIAS, null)).getSecretKey();
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKey, new GCMParameterSpec(128, FIXED_IV));
        return Base64.encodeToString(cipher.doFinal(bytes), 0);
    }

    public String decrypt(String str) throws Exception {
        if (str == null) {
            throw new RuntimeException("encrypted argument can't be null", new RuntimeException("Invalid argument at decrypt function"));
        }
        SecretKey secretKey = ((KeyStore.SecretKeyEntry) this.mKeyStore.getEntry(KEY_ALIAS, null)).getSecretKey();
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, secretKey, new GCMParameterSpec(128, FIXED_IV));
        return new String(cipher.doFinal(Base64.decode(str, 0)));
    }
}
