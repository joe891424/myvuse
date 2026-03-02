package org.jose4j.jwt.consumer;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jose4j.jwt.consumer.ErrorCodeValidator;

/* JADX INFO: loaded from: classes6.dex */
public class InvalidJwtException extends Exception {
    private List<ErrorCodeValidator.Error> details;
    private JwtContext jwtContext;

    public InvalidJwtException(String str, List<ErrorCodeValidator.Error> list, JwtContext jwtContext) {
        super(str);
        Collections.emptyList();
        this.details = list;
        this.jwtContext = jwtContext;
    }

    public InvalidJwtException(String str, ErrorCodeValidator.Error error, Throwable th, JwtContext jwtContext) {
        super(str, th);
        this.details = Collections.emptyList();
        this.jwtContext = jwtContext;
        this.details = Collections.singletonList(error);
    }

    public boolean hasErrorCode(int i) {
        Iterator<ErrorCodeValidator.Error> it2 = this.details.iterator();
        while (it2.hasNext()) {
            if (i == it2.next().getErrorCode()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasExpired() {
        return hasErrorCode(1);
    }

    public List<ErrorCodeValidator.Error> getErrorDetails() {
        return this.details;
    }

    public JwtContext getJwtContext() {
        return this.jwtContext;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getMessage());
        if (!this.details.isEmpty()) {
            sb.append(" Additional details: ");
            sb.append(this.details);
        }
        return sb.toString();
    }
}
