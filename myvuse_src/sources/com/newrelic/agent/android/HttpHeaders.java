package com.newrelic.agent.android;

import com.newrelic.agent.android.util.Constants;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public class HttpHeaders {
    public static final String OPERATION_ID = "operationId";
    public static final String OPERATION_NAME = "operationName";
    public static final String OPERATION_TYPE = "operationType";
    protected static final AtomicReference<HttpHeaders> instance = new AtomicReference<>(new HttpHeaders());
    private final Set<String> httpHeaders;

    private HttpHeaders() {
        HashSet hashSet = new HashSet();
        this.httpHeaders = hashSet;
        hashSet.add(Constants.ApolloGraphQLHeader.OPERATION_NAME);
        hashSet.add(Constants.ApolloGraphQLHeader.OPERATION_ID);
        hashSet.add(Constants.ApolloGraphQLHeader.OPERATION_TYPE);
    }

    public static HttpHeaders getInstance() {
        return instance.get();
    }

    public void addHttpHeaderAsAttribute(String str) {
        this.httpHeaders.add(str);
    }

    public void removeHttpHeaderAsAttribute(String str) {
        if (Constants.ApolloGraphQLHeader.OPERATION_ID.equalsIgnoreCase(str) || Constants.ApolloGraphQLHeader.OPERATION_NAME.equalsIgnoreCase(str) || Constants.ApolloGraphQLHeader.OPERATION_TYPE.equalsIgnoreCase(str)) {
            return;
        }
        this.httpHeaders.remove(str);
    }

    public boolean addHttpHeadersAsAttributes(List<String> list) {
        return this.httpHeaders.addAll(list);
    }

    public Set<String> getHttpHeaders() {
        return this.httpHeaders;
    }

    public static String translateApolloHeader(String str) {
        str.hashCode();
        switch (str) {
            case "X-APOLLO-OPERATION-NAME":
                return OPERATION_NAME;
            case "X-APOLLO-OPERATION-TYPE":
                return OPERATION_TYPE;
            case "X-APOLLO-OPERATION-ID":
                return OPERATION_ID;
            default:
                return str;
        }
    }
}
