package org.jose4j.json.internal.json_simple;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
public class JSONObject extends HashMap implements Map, JSONAware, JSONStreamAware {
    private static final long serialVersionUID = -503443796854799292L;

    public JSONObject() {
    }

    public JSONObject(Map map) {
        super(map);
    }

    public static void writeJSONString(Map map, Writer writer) throws IOException {
        if (map == null) {
            writer.write("null");
            return;
        }
        writer.write(123);
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                writer.write(44);
            }
            writer.write(34);
            writer.write(escape(String.valueOf(entry.getKey())));
            writer.write(34);
            writer.write(58);
            JSONValue.writeJSONString(entry.getValue(), writer);
        }
        writer.write(125);
    }

    @Override // org.jose4j.json.internal.json_simple.JSONStreamAware
    public void writeJSONString(Writer writer) throws IOException {
        writeJSONString(this, writer);
    }

    public static String toJSONString(Map map) {
        StringWriter stringWriter = new StringWriter();
        try {
            writeJSONString(map, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.jose4j.json.internal.json_simple.JSONAware
    public String toJSONString() {
        return toJSONString(this);
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return toJSONString();
    }

    public static String toString(String str, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.quote);
        if (str == null) {
            sb.append("null");
        } else {
            JSONValue.escape(str, sb);
        }
        sb.append(Typography.quote).append(':');
        sb.append(JSONValue.toJSONString(obj));
        return sb.toString();
    }

    public static String escape(String str) {
        return JSONValue.escape(str);
    }
}
