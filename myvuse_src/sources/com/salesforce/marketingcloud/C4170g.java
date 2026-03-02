package com.salesforce.marketingcloud;

import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.g */
/* JADX INFO: loaded from: classes6.dex */
public final class C4170g {

    /* JADX INFO: renamed from: b */
    private static final int f4786b = 23;

    /* JADX INFO: renamed from: c */
    private static String f4787c;

    /* JADX INFO: renamed from: d */
    private static String f4788d;

    /* JADX INFO: renamed from: e */
    private static String f4789e;

    /* JADX INFO: renamed from: g */
    private static MCLogListener f4791g;

    /* JADX INFO: renamed from: a */
    public static final C4170g f4785a = new C4170g();

    /* JADX INFO: renamed from: f */
    private static int f4790f = 6;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.g$a */
    static final class a extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f4792a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Object[] f4793b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr) {
            super(0);
            this.f4792a = str;
            this.f4793b = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            C4170g c4170g = C4170g.f4785a;
            String str = this.f4792a;
            Object[] objArr = this.f4793b;
            return c4170g.m3198a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.g$b */
    static final class b extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f4794a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Object[] f4795b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr) {
            super(0);
            this.f4794a = str;
            this.f4795b = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            C4170g c4170g = C4170g.f4785a;
            String str = this.f4794a;
            Object[] objArr = this.f4795b;
            return c4170g.m3198a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.g$c */
    static final class c extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f4796a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Object[] f4797b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr) {
            super(0);
            this.f4796a = str;
            this.f4797b = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            C4170g c4170g = C4170g.f4785a;
            String str = this.f4796a;
            Object[] objArr = this.f4797b;
            return c4170g.m3198a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.g$d */
    static final class d extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f4798a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Object[] f4799b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr) {
            super(0);
            this.f4798a = str;
            this.f4799b = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            C4170g c4170g = C4170g.f4785a;
            String str = this.f4798a;
            Object[] objArr = this.f4799b;
            return c4170g.m3198a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.g$e */
    static final class e extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Function0<String> f4800a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Function0<String> function0) {
            super(0);
            this.f4800a = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return ((Object) this.f4800a.invoke()) + " - Sdk Version: " + MarketingCloudSdk.getSdkVersionName();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.g$f */
    static final class f extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f4801a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Object[] f4802b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr) {
            super(0);
            this.f4801a = str;
            this.f4802b = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            C4170g c4170g = C4170g.f4785a;
            String str = this.f4801a;
            Object[] objArr = this.f4802b;
            return c4170g.m3198a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.g$g */
    static final class g extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f4803a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Object[] f4804b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, Object[] objArr) {
            super(0);
            this.f4803a = str;
            this.f4804b = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            C4170g c4170g = C4170g.f4785a;
            String str = this.f4803a;
            Object[] objArr = this.f4804b;
            return c4170g.m3198a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.g$h */
    static final class h extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f4805a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Object[] f4806b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, Object[] objArr) {
            super(0);
            this.f4805a = str;
            this.f4806b = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            C4170g c4170g = C4170g.f4785a;
            String str = this.f4805a;
            Object[] objArr = this.f4806b;
            return c4170g.m3198a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.g$i */
    static final class i extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f4807a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Object[] f4808b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str, Object[] objArr) {
            super(0);
            this.f4807a = str;
            this.f4808b = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            C4170g c4170g = C4170g.f4785a;
            String str = this.f4807a;
            Object[] objArr = this.f4808b;
            return c4170g.m3198a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.g$j */
    static final class j extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f4809a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Object[] f4810b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str, Object[] objArr) {
            super(0);
            this.f4809a = str;
            this.f4810b = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            C4170g c4170g = C4170g.f4785a;
            String str = this.f4809a;
            Object[] objArr = this.f4810b;
            return c4170g.m3198a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.g$k */
    static final class k extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f4811a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Object[] f4812b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str, Object[] objArr) {
            super(0);
            this.f4811a = str;
            this.f4812b = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            C4170g c4170g = C4170g.f4785a;
            String str = this.f4811a;
            Object[] objArr = this.f4812b;
            return c4170g.m3198a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    private C4170g() {
    }

    /* JADX INFO: renamed from: a */
    public final void m3221a(String tag, Throwable th, Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        m3199a(3, tag, th, lazyMsg);
    }

    /* JADX INFO: renamed from: b */
    public final void m3223b(String tag, Throwable th, Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        m3199a(6, tag, th, new e(lazyMsg));
    }

    /* JADX INFO: renamed from: c */
    public final void m3224c(String tag, Throwable th, Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        m3199a(4, tag, th, lazyMsg);
    }

    /* JADX INFO: renamed from: d */
    public final void m3225d(String tag, Throwable th, Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        m3199a(2, tag, th, lazyMsg);
    }

    /* JADX INFO: renamed from: e */
    public final void m3226e(String tag, Throwable th, Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        m3199a(5, tag, th, lazyMsg);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m3200a(C4170g c4170g, String str, Throwable th, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        c4170g.m3221a(str, th, (Function0<String>) function0);
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ void m3205b(C4170g c4170g, String str, Throwable th, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        c4170g.m3223b(str, th, (Function0<String>) function0);
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ void m3209c(C4170g c4170g, String str, Throwable th, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        c4170g.m3224c(str, th, (Function0<String>) function0);
    }

    /* JADX INFO: renamed from: d */
    public static /* synthetic */ void m3212d(C4170g c4170g, String str, Throwable th, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        c4170g.m3225d(str, th, (Function0<String>) function0);
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ void m3215e(C4170g c4170g, String str, Throwable th, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        c4170g.m3226e(str, th, (Function0<String>) function0);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    /* JADX INFO: renamed from: b */
    public static final void m3206b(String tag, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        m3205b(f4785a, tag, null, new c(msg, args), 2, null);
    }

    /* JADX INFO: renamed from: c */
    private final String m3208c(String str) {
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "~!", false, 2, (Object) null)) {
            str = "~!" + str;
        }
        return str.length() <= 23 ? str : str.subSequence(0, 23).toString();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m3213d(String tag, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        m3212d(f4785a, tag, null, new h(msg, args), 2, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m3216e(String tag, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        m3215e(f4785a, tag, null, new j(msg, args), 2, null);
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final String m3197a(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return f4785a.m3208c(tag);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    /* JADX INFO: renamed from: b */
    public static final void m3207b(String tag, Throwable throwable, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        f4785a.m3223b(tag, throwable, new d(msg, args));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    /* JADX INFO: renamed from: c */
    public static final void m3210c(String tag, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        m3209c(f4785a, tag, null, new f(msg, args), 2, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    /* JADX INFO: renamed from: d */
    public static final void m3214d(String tag, Throwable throwable, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        f4785a.m3225d(tag, throwable, new i(msg, args));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    /* JADX INFO: renamed from: e */
    public static final void m3217e(String tag, Throwable throwable, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        f4785a.m3226e(tag, throwable, new k(msg, args));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final void m3202a(String tag, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        m3200a(f4785a, tag, null, new a(msg, args), 2, null);
    }

    /* JADX INFO: renamed from: b */
    private final String m3204b(String str) {
        String strReplace$default;
        String strReplace$default2;
        String strReplace$default3;
        if (TextUtils.getTrimmedLength(str) == 0) {
            return "Log message was empty";
        }
        String str2 = f4787c;
        if (str2 != null && (strReplace$default3 = StringsKt.replace$default(str, str2, "████████-████-████-████-████████████", false, 4, (Object) null)) != null) {
            str = strReplace$default3;
        }
        String str3 = f4788d;
        if (str3 != null && (strReplace$default2 = StringsKt.replace$default(str, str3, "███████████████████████", false, 4, (Object) null)) != null) {
            str = strReplace$default2;
        }
        String str4 = f4789e;
        return (str4 == null || (strReplace$default = StringsKt.replace$default(str, str4, "████████", false, 4, (Object) null)) == null) ? str : strReplace$default;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    /* JADX INFO: renamed from: c */
    public static final void m3211c(String tag, Throwable throwable, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        f4785a.m3224c(tag, throwable, new g(msg, args));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final void m3203a(String tag, Throwable throwable, String msg, Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        f4785a.m3221a(tag, throwable, new b(msg, args));
    }

    /* JADX INFO: renamed from: b */
    public final int m3222b() {
        return f4790f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final String m3198a(String str, Object... objArr) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.ENGLISH;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str2 = String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        Intrinsics.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
        return str2;
    }

    /* JADX INFO: renamed from: a */
    public final MCLogListener m3218a() {
        return f4791g;
    }

    /* JADX INFO: renamed from: a */
    private final void m3199a(int i2, String str, Throwable th, Function0<String> function0) {
        MCLogListener mCLogListener = f4791g;
        if (mCLogListener == null || i2 < f4790f) {
            return;
        }
        try {
            mCLogListener.out(i2, m3208c(str), m3204b(function0.invoke()), th);
        } catch (Exception e2) {
            LogInstrumentation.m2729e("~!Logger", "Exception was thrown by " + mCLogListener.getClass().getName(), e2);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3220a(MCLogListener mCLogListener) {
        f4791g = mCLogListener;
    }

    /* JADX INFO: renamed from: a */
    public final void m3219a(int i2) {
        f4790f = i2;
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final void m3201a(String str, String str2, String str3) {
        f4787c = str;
        f4788d = str2;
        f4789e = str3;
    }
}
