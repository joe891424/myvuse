package com.squareup.wire.internal;

import com.google.firebase.messaging.Constants;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: FieldOrOneOfBinding.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010%\u001a\u0004\u0018\u00010\u00032\u0006\u0010&\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010'J\u0017\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00028\u0001H&¢\u0006\u0002\u0010'J\u0018\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0003J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,H\u0002J\u001f\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00028\u00012\b\u0010-\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u00101J\u001d\u0010-\u001a\u0002002\u0006\u0010)\u001a\u00028\u00012\u0006\u0010-\u001a\u00020\u0003H&¢\u0006\u0002\u00101R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000eR\u0012\u0010\u001b\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R\u0016\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\bR\u0012\u0010\u001f\u001a\u00020 X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u000e¨\u00062"}, m5598d2 = {"Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "M", "B", "", "()V", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "getAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "declaredName", "", "getDeclaredName", "()Ljava/lang/String;", "isMap", "", "()Z", "isMessage", "keyAdapter", "getKeyAdapter", Constants.ScionAnalytics.PARAM_LABEL, "Lcom/squareup/wire/WireField$Label;", "getLabel", "()Lcom/squareup/wire/WireField$Label;", "name", "getName", "redacted", "getRedacted", "singleAdapter", "getSingleAdapter", HeaderParameterNames.AUTHENTICATION_TAG, "", "getTag", "()I", "wireFieldJsonName", "getWireFieldJsonName", "get", "message", "(Ljava/lang/Object;)Ljava/lang/Object;", "getFromBuilder", "builder", "omitFromJson", "syntax", "Lcom/squareup/wire/Syntax;", "value", "omitIdentity", "set", "", "(Ljava/lang/Object;Ljava/lang/Object;)V", "wire-runtime"}, m5599k = 1, m5600mv = {1, 4, 0})
public abstract class FieldOrOneOfBinding<M, B> {

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter = LazyKt.lazy(new Function0<ProtoAdapter<Object>>() { // from class: com.squareup.wire.internal.FieldOrOneOfBinding$adapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ProtoAdapter<Object> invoke() {
            ProtoAdapter<?> protoAdapterWithLabel$wire_runtime;
            if (this.this$0.isMap()) {
                ProtoAdapter.Companion companion = ProtoAdapter.INSTANCE;
                ProtoAdapter<?> keyAdapter = this.this$0.getKeyAdapter();
                if (keyAdapter == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
                }
                ProtoAdapter<?> singleAdapter = this.this$0.getSingleAdapter();
                if (singleAdapter != null) {
                    protoAdapterWithLabel$wire_runtime = companion.newMapAdapter(keyAdapter, singleAdapter);
                    if (protoAdapterWithLabel$wire_runtime == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
                }
            } else {
                protoAdapterWithLabel$wire_runtime = this.this$0.getSingleAdapter().withLabel$wire_runtime(this.this$0.getLabel());
                if (protoAdapterWithLabel$wire_runtime == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
                }
            }
            return protoAdapterWithLabel$wire_runtime;
        }
    });

    public abstract Object get(M message);

    public final ProtoAdapter<Object> getAdapter() {
        return (ProtoAdapter) this.adapter.getValue();
    }

    public abstract String getDeclaredName();

    public abstract Object getFromBuilder(B builder);

    public abstract ProtoAdapter<?> getKeyAdapter();

    public abstract WireField.Label getLabel();

    public abstract String getName();

    public abstract boolean getRedacted();

    public abstract ProtoAdapter<?> getSingleAdapter();

    public abstract int getTag();

    public abstract String getWireFieldJsonName();

    public abstract boolean isMap();

    public abstract boolean isMessage();

    public abstract void set(B builder, Object value);

    public abstract void value(B builder, Object value);

    public final boolean omitFromJson(Syntax syntax, Object value) {
        Intrinsics.checkNotNullParameter(syntax, "syntax");
        if (value == null) {
            return true;
        }
        return omitIdentity(syntax) && Intrinsics.areEqual(value, getAdapter().getIdentity());
    }

    private final boolean omitIdentity(Syntax syntax) {
        if (getLabel() == WireField.Label.OMIT_IDENTITY) {
            return true;
        }
        if (getLabel().isRepeated() && syntax == Syntax.PROTO_3) {
            return true;
        }
        return isMap() && syntax == Syntax.PROTO_3;
    }
}
