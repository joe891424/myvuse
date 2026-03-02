package org.koin.core.registry;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p099io.TextStreamsKt;
import kotlin.text.Charsets;
import org.koin.core.Koin;
import org.koin.core.error.NoPropertyFileFoundException;
import org.koin.core.logger.Level;
import org.koin.ext.StringExtKt;

/* JADX INFO: compiled from: PropertyRegistry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0013J\u001a\u0010\u0015\u001a\u00020\u000b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0017J\u001d\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m5598d2 = {"Lorg/koin/core/registry/PropertyRegistry;", "", "_koin", "Lorg/koin/core/Koin;", "(Lorg/koin/core/Koin;)V", "get_koin", "()Lorg/koin/core/Koin;", "_values", "", "", "close", "", "deleteProperty", "key", "getProperty", "loadEnvironmentProperties", "loadPropertiesFromFile", "fileName", "readDataFromFile", "Ljava/util/Properties;", "content", "saveProperties", "properties", "", "saveProperty", "value", "saveProperty$koin_core", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class PropertyRegistry {
    private final Koin _koin;
    private final Map<String, String> _values;

    public PropertyRegistry(Koin _koin) {
        Intrinsics.checkParameterIsNotNull(_koin, "_koin");
        this._koin = _koin;
        this._values = new ConcurrentHashMap();
    }

    public final Koin get_koin() {
        return this._koin;
    }

    public final void saveProperties(Map<String, String> properties) {
        Intrinsics.checkParameterIsNotNull(properties, "properties");
        if (this._koin.get_logger().isAt(Level.DEBUG)) {
            this._koin.get_logger().debug("load " + properties.size() + " properties");
        }
        this._values.putAll(properties);
    }

    public final void saveProperties(Properties properties) {
        Intrinsics.checkParameterIsNotNull(properties, "properties");
        if (this._koin.get_logger().isAt(Level.DEBUG)) {
            this._koin.get_logger().debug("load " + properties.size() + " properties");
        }
        Map map = MapsKt.toMap(properties);
        if (map == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        }
        for (Map.Entry entry : map.entrySet()) {
            saveProperty$koin_core((String) entry.getKey(), StringExtKt.quoted((String) entry.getValue()));
        }
    }

    public final void saveProperty$koin_core(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        this._values.put(key, value);
    }

    public final void deleteProperty(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this._values.remove(key);
    }

    public final String getProperty(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return this._values.get(key);
    }

    public final void loadPropertiesFromFile(String fileName) {
        String str;
        Intrinsics.checkParameterIsNotNull(fileName, "fileName");
        if (this._koin.get_logger().isAt(Level.DEBUG)) {
            this._koin.get_logger().debug("load properties from " + fileName);
        }
        URL resource = Koin.class.getResource(fileName);
        if (resource != null) {
            str = new String(TextStreamsKt.readBytes(resource), Charsets.UTF_8);
        } else {
            str = null;
        }
        if (str != null) {
            if (this._koin.get_logger().isAt(Level.INFO)) {
                this._koin.get_logger().info("loaded properties from file:'" + fileName + '\'');
            }
            saveProperties(readDataFromFile(str));
            return;
        }
        throw new NoPropertyFileFoundException("No properties found for file '" + fileName + '\'');
    }

    private final Properties readDataFromFile(String content) throws IOException {
        Properties properties = new Properties();
        Charset charset = Charsets.UTF_8;
        if (content == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = content.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        properties.load(new ByteArrayInputStream(bytes));
        return properties;
    }

    public final void loadEnvironmentProperties() {
        if (this._koin.get_logger().isAt(Level.DEBUG)) {
            this._koin.get_logger().debug("load properties from environment");
        }
        Properties sysProperties = System.getProperties();
        Intrinsics.checkExpressionValueIsNotNull(sysProperties, "sysProperties");
        saveProperties(sysProperties);
        Map<String, String> map = System.getenv();
        Intrinsics.checkExpressionValueIsNotNull(map, "System.getenv()");
        Properties properties = new Properties();
        properties.putAll(map);
        saveProperties(properties);
    }

    public final void close() {
        this._values.clear();
    }
}
