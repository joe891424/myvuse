package org.jose4j.jwe.kdf;

import com.google.common.base.Ascii;
import org.jose4j.lang.HashUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes6.dex */
class ConcatKeyDerivationFunctionFactory {
    private static Class<ConcatenationKeyDerivationFunctionWithSha256> customKdfClass;
    private static final Logger log;

    ConcatKeyDerivationFunctionFactory() {
    }

    static {
        Logger logger = LoggerFactory.getLogger((Class<?>) ConcatKeyDerivationFunctionFactory.class);
        log = logger;
        String property = System.getProperty("org.jose4j.jwe.kdf.ConcatenationKeyDerivationFunctionWithSha256");
        if (property != null) {
            try {
                Class cls = Class.forName(property);
                customKdfClass = cls;
                ConcatenationKeyDerivationFunctionWithSha256 concatenationKeyDerivationFunctionWithSha256 = (ConcatenationKeyDerivationFunctionWithSha256) cls.newInstance();
                concatenationKeyDerivationFunctionWithSha256.kdf(new byte[]{124, -81, 43, Ascii.f3757SO, -71, -72, -84, 75, 115, 73, -52, -39, 74, -58, 77, -83}, 512, new byte[8]);
                logger.debug("Using custom ConcatenationKeyDerivationFunctionWithSha256 implementation: " + concatenationKeyDerivationFunctionWithSha256.getClass());
            } catch (Throwable th) {
                customKdfClass = null;
                log.debug("Using jose4j's concatenation key derivation function implementation because of problems with " + property, th);
            }
        }
    }

    static ConcatenationKeyDerivationFunctionWithSha256 make(String str) {
        Class<ConcatenationKeyDerivationFunctionWithSha256> cls = customKdfClass;
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                log.debug("Unable to create new instance of " + customKdfClass, (Throwable) e);
            }
        }
        return new ConcatKeyDerivationFunction(HashUtil.SHA_256, str);
    }
}
