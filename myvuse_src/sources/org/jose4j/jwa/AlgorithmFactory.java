package org.jose4j.jwa;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.jose4j.jwa.Algorithm;
import org.jose4j.lang.ExceptionHelp;
import org.jose4j.lang.InvalidAlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes6.dex */
public class AlgorithmFactory<A extends Algorithm> {
    private final Map<String, A> algorithms = new LinkedHashMap();
    private final Logger log;
    private String parameterName;

    public AlgorithmFactory(String str, Class<A> cls) {
        this.parameterName = str;
        this.log = LoggerFactory.getLogger(getClass().getName() + "->" + cls.getSimpleName());
    }

    public A getAlgorithm(String str) throws InvalidAlgorithmException {
        A a2 = this.algorithms.get(str);
        if (a2 != null) {
            return a2;
        }
        throw new InvalidAlgorithmException(str + " is an unknown, unsupported or unavailable " + this.parameterName + " algorithm (not one of " + getSupportedAlgorithms() + ").");
    }

    public boolean isAvailable(String str) {
        return this.algorithms.containsKey(str);
    }

    public Set<String> getSupportedAlgorithms() {
        return Collections.unmodifiableSet(this.algorithms.keySet());
    }

    public void registerAlgorithm(A a2) {
        String algorithmIdentifier = a2.getAlgorithmIdentifier();
        if (isAvailable(a2)) {
            this.algorithms.put(algorithmIdentifier, a2);
            this.log.debug("{} registered for {} algorithm {}", a2, this.parameterName, algorithmIdentifier);
        } else {
            this.log.debug("{} is unavailable so will not be registered for {} algorithms.", algorithmIdentifier, this.parameterName);
        }
    }

    private boolean isAvailable(A a2) {
        try {
            return a2.isAvailable();
        } catch (Throwable th) {
            this.log.debug("Unexpected problem checking for availability of " + a2.getAlgorithmIdentifier() + " algorithm: " + ExceptionHelp.toStringWithCauses(th));
            return false;
        }
    }

    public void unregisterAlgorithm(String str) {
        this.algorithms.remove(str);
    }
}
