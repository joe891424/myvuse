package com.newrelic.com.google.gson;

import com.newrelic.com.google.gson.stream.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public interface ToNumberStrategy {
    Number readNumber(JsonReader jsonReader) throws IOException;
}
