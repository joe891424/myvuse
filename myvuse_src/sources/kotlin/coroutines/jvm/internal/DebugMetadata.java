package kotlin.coroutines.jvm.internal;

import com.facebook.common.callercontext.ContextChain;
import com.newrelic.agent.android.agentdata.HexAttribute;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes6.dex */
@Target({ElementType.TYPE})
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0011\b\u0081\u0002\u0018\u00002\u00020\u0001B\\\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005R\u0011\u0010\r\u001a\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u00078\u0007¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0007¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0007¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, m5598d2 = {"Lkotlin/coroutines/jvm/internal/DebugMetadata;", "", "version", "", "sourceFile", "", "lineNumbers", "", "localNames", "", "spilled", "indexToLabel", "methodName", HexAttribute.HEX_ATTR_CLASS_NAME, "c", "()Ljava/lang/String;", ContextChain.TAG_INFRA, "()[I", "l", RsaJsonWebKey.MODULUS_MEMBER_NAME, "()[Ljava/lang/String;", "m", "f", "s", "v", "()I", "kotlin-stdlib"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
public @interface DebugMetadata {
    /* JADX INFO: renamed from: c */
    String m5607c() default "";

    /* JADX INFO: renamed from: f */
    String m5608f() default "";

    /* JADX INFO: renamed from: i */
    int[] m5609i() default {};

    /* JADX INFO: renamed from: l */
    int[] m5610l() default {};

    /* JADX INFO: renamed from: m */
    String m5611m() default "";

    /* JADX INFO: renamed from: n */
    String[] m5612n() default {};

    /* JADX INFO: renamed from: s */
    String[] m5613s() default {};

    /* JADX INFO: renamed from: v */
    int m5614v() default 1;
}
