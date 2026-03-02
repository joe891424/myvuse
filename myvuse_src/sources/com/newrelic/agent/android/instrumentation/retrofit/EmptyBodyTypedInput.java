package com.newrelic.agent.android.instrumentation.retrofit;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import retrofit.mime.TypedInput;

/* JADX INFO: loaded from: classes6.dex */
public class EmptyBodyTypedInput implements TypedInput {
    public long length() {
        return 0L;
    }

    public String mimeType() {
        return "text/html;charset=utf-8";
    }

    /* JADX INFO: renamed from: in */
    public InputStream m2737in() throws IOException {
        return new ByteArrayInputStream(new byte[0]);
    }
}
