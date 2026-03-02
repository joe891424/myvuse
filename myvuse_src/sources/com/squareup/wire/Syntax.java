package com.squareup.wire;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Syntax.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, m5598d2 = {"Lcom/squareup/wire/Syntax;", "", TypedValues.Custom.S_STRING, "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "PROTO_2", "PROTO_3", "Companion", "wire-runtime"}, m5599k = 1, m5600mv = {1, 4, 0})
public enum Syntax {
    PROTO_2("proto2"),
    PROTO_3("proto3");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String string;

    Syntax(String str) {
        this.string = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.string;
    }

    /* JADX INFO: compiled from: Syntax.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0002¨\u0006\u0007"}, m5598d2 = {"Lcom/squareup/wire/Syntax$Companion;", "", "()V", "get", "Lcom/squareup/wire/Syntax;", TypedValues.Custom.S_STRING, "", "wire-runtime"}, m5599k = 1, m5600mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Syntax get(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            for (Syntax syntax : Syntax.values()) {
                if (Intrinsics.areEqual(syntax.string, string)) {
                    return syntax;
                }
            }
            throw new IllegalArgumentException("unexpected syntax: " + string);
        }
    }
}
