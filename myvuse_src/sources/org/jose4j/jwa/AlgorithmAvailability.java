package org.jose4j.jwa;

import java.security.Security;
import java.util.Iterator;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes6.dex */
public class AlgorithmAvailability {
    private static Logger log = LoggerFactory.getLogger((Class<?>) AlgorithmAvailability.class);

    public static boolean isAvailable(String str, String str2) {
        Set<String> algorithms = Security.getAlgorithms(str);
        Iterator<String> it2 = algorithms.iterator();
        while (it2.hasNext()) {
            if (it2.next().equalsIgnoreCase(str2)) {
                return true;
            }
        }
        log.debug("{} is NOT available for {}. Algorithms available from underlying JCE: {}", str2, str, algorithms);
        return false;
    }
}
