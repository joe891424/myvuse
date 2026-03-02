package com.squareup.wire.internal;

import com.google.firebase.messaging.Constants;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: FieldBinding.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B%\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u00101J\u001c\u00102\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\"\u001a\u00020\u000eH\u0002J(\u00103\u001a\u00020\u00112\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\"\u001a\u00020\u000e2\n\u00104\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002J\u0017\u00105\u001a\u0004\u0018\u00010/2\u0006\u00106\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00107J\u001f\u00108\u001a\u0002092\u0006\u00106\u001a\u00028\u00012\b\u0010:\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0002\u0010;J\u001d\u0010:\u001a\u0002092\u0006\u00106\u001a\u00028\u00012\u0006\u0010:\u001a\u00020/H\u0016¢\u0006\u0002\u0010;R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014R\u0014\u0010$\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0018\u0010&\u001a\u0006\u0012\u0002\b\u00030\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001cR\u0014\u0010(\u001a\u00020)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0014¨\u0006<"}, m5598d2 = {"Lcom/squareup/wire/internal/FieldBinding;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "wireField", "Lcom/squareup/wire/WireField;", "messageField", "Ljava/lang/reflect/Field;", "builderType", "Ljava/lang/Class;", "(Lcom/squareup/wire/WireField;Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "adapterString", "", "builderField", "builderMethod", "Ljava/lang/reflect/Method;", "declaredName", "getDeclaredName", "()Ljava/lang/String;", "isMap", "", "()Z", "isMessage", "keyAdapter", "Lcom/squareup/wire/ProtoAdapter;", "getKeyAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "keyAdapterString", Constants.ScionAnalytics.PARAM_LABEL, "Lcom/squareup/wire/WireField$Label;", "getLabel", "()Lcom/squareup/wire/WireField$Label;", "name", "getName", "redacted", "getRedacted", "singleAdapter", "getSingleAdapter", HeaderParameterNames.AUTHENTICATION_TAG, "", "getTag", "()I", "wireFieldJsonName", "getWireFieldJsonName", "get", "", "message", "(Lcom/squareup/wire/Message;)Ljava/lang/Object;", "getBuilderField", "getBuilderMethod", "type", "getFromBuilder", "builder", "(Lcom/squareup/wire/Message$Builder;)Ljava/lang/Object;", "set", "", "value", "(Lcom/squareup/wire/Message$Builder;Ljava/lang/Object;)V", "wire-runtime"}, m5599k = 1, m5600mv = {1, 4, 0})
public final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> extends FieldOrOneOfBinding<M, B> {
    private final String adapterString;
    private final Field builderField;
    private final Method builderMethod;
    private final String declaredName;
    private final String keyAdapterString;
    private final WireField.Label label;
    private final Field messageField;
    private final String name;
    private final boolean redacted;
    private final int tag;
    private final String wireFieldJsonName;

    public FieldBinding(WireField wireField, Field messageField, Class<B> builderType) {
        String strDeclaredName;
        Intrinsics.checkNotNullParameter(wireField, "wireField");
        Intrinsics.checkNotNullParameter(messageField, "messageField");
        Intrinsics.checkNotNullParameter(builderType, "builderType");
        this.messageField = messageField;
        this.label = wireField.label();
        String name = messageField.getName();
        Intrinsics.checkNotNullExpressionValue(name, "messageField.name");
        this.name = name;
        this.wireFieldJsonName = wireField.jsonName();
        if (wireField.declaredName().length() == 0) {
            strDeclaredName = messageField.getName();
            Intrinsics.checkNotNullExpressionValue(strDeclaredName, "messageField.name");
        } else {
            strDeclaredName = wireField.declaredName();
        }
        this.declaredName = strDeclaredName;
        this.tag = wireField.tag();
        this.keyAdapterString = wireField.keyAdapter();
        this.adapterString = wireField.adapter();
        this.redacted = wireField.redacted();
        this.builderField = getBuilderField(builderType, getName());
        String name2 = getName();
        Class<?> type = messageField.getType();
        Intrinsics.checkNotNullExpressionValue(type, "messageField.type");
        this.builderMethod = getBuilderMethod(builderType, name2, type);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public WireField.Label getLabel() {
        return this.label;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getName() {
        return this.name;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getWireFieldJsonName() {
        return this.wireFieldJsonName;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public String getDeclaredName() {
        return this.declaredName;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public int getTag() {
        return this.tag;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean getRedacted() {
        return this.redacted;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public ProtoAdapter<?> getKeyAdapter() {
        return ProtoAdapter.INSTANCE.get(this.keyAdapterString);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public ProtoAdapter<?> getSingleAdapter() {
        return ProtoAdapter.INSTANCE.get(this.adapterString);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean isMap() {
        return this.keyAdapterString.length() > 0;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean isMessage() {
        KClass<?> type = getSingleAdapter().getType();
        return Message.class.isAssignableFrom(type != null ? JvmClassMappingKt.getJavaObjectType(type) : null);
    }

    private final Field getBuilderField(Class<?> builderType, String name) {
        try {
            Field field = builderType.getField(name);
            Intrinsics.checkNotNullExpressionValue(field, "builderType.getField(name)");
            return field;
        } catch (NoSuchFieldException unused) {
            throw new AssertionError("No builder field " + builderType.getName() + '.' + name);
        }
    }

    private final Method getBuilderMethod(Class<?> builderType, String name, Class<?> type) {
        try {
            Method method = builderType.getMethod(name, type);
            Intrinsics.checkNotNullExpressionValue(method, "builderType.getMethod(name, type)");
            return method;
        } catch (NoSuchMethodException unused) {
            throw new AssertionError("No builder method " + builderType.getName() + '.' + name + '(' + type.getName() + ')');
        }
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public void value(B builder, Object value) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(value, "value");
        if (getLabel().isRepeated()) {
            Object fromBuilder = getFromBuilder((Message.Builder) builder);
            if (TypeIntrinsics.isMutableList(fromBuilder)) {
                if (fromBuilder == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any>");
                }
                TypeIntrinsics.asMutableList(fromBuilder).add(value);
                return;
            } else {
                if (fromBuilder instanceof List) {
                    List mutableList = CollectionsKt.toMutableList((Collection) fromBuilder);
                    mutableList.add(value);
                    set((Message.Builder) builder, (Object) mutableList);
                    return;
                }
                throw new ClassCastException("Expected a list type, got " + (fromBuilder != null ? fromBuilder.getClass() : null) + '.');
            }
        }
        if (this.keyAdapterString.length() > 0) {
            Object fromBuilder2 = getFromBuilder((Message.Builder) builder);
            if (TypeIntrinsics.isMutableMap(fromBuilder2)) {
                ((Map) fromBuilder2).putAll((Map) value);
                return;
            } else {
                if (fromBuilder2 instanceof Map) {
                    Map mutableMap = MapsKt.toMutableMap((Map) fromBuilder2);
                    mutableMap.putAll((Map) value);
                    set((Message.Builder) builder, (Object) mutableMap);
                    return;
                }
                throw new ClassCastException("Expected a map type, got " + (fromBuilder2 != null ? fromBuilder2.getClass() : null) + '.');
            }
        }
        set((Message.Builder) builder, value);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public void set(B builder, Object value) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (getLabel().isOneOf()) {
            this.builderMethod.invoke(builder, value);
        } else {
            this.builderField.set(builder, value);
        }
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public Object get(M message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return this.messageField.get(message);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public Object getFromBuilder(B builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return this.builderField.get(builder);
    }
}
