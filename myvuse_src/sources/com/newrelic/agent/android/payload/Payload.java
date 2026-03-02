package com.newrelic.agent.android.payload;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonObject;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: loaded from: classes6.dex */
public class Payload {
    protected boolean isPersistable;
    protected ByteBuffer payload;
    protected long timestamp;
    protected String uuid;

    public Payload() {
        this.uuid = UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
        this.isPersistable = true;
        this.payload = ByteBuffer.wrap("".getBytes());
    }

    public Payload(byte[] bArr) {
        this();
        this.payload = ByteBuffer.wrap(bArr);
    }

    public byte[] getBytes() {
        return this.payload.array();
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isStale(long j) {
        return getTimestamp() + j <= System.currentTimeMillis();
    }

    public void putBytes(byte[] bArr) {
        this.payload = ByteBuffer.wrap(bArr);
    }

    public void setPersisted(boolean z) {
        this.isPersistable = z;
    }

    public boolean isPersisted() {
        return this.isPersistable;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Payload)) {
            return false;
        }
        return this.uuid.equalsIgnoreCase(((Payload) obj).uuid);
    }

    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("timestamp", SafeJsonPrimitive.factory(Long.valueOf(this.timestamp)));
        jsonObject.add(AnalyticsAttribute.UUID_ATTRIBUTE, SafeJsonPrimitive.factory(this.uuid));
        return jsonObject;
    }

    public String asJsonMeta() {
        return asJsonObject().toString();
    }

    public long size() {
        return this.payload.array().length;
    }
}
