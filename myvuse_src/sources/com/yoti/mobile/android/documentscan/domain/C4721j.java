package com.yoti.mobile.android.documentscan.domain;

import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer;
import com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.entities.recognizers.blinkid.passport.PassportRecognizer;
import com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import com.yoti.mobile.android.documentscan.domain.p059a.p063d.C4704b;
import com.yoti.mobile.android.documentscan.domain.p059a.p063d.C4706d;
import com.yoti.mobile.android.documentscan.domain.utils.BlinkDateUtils;
import com.yoti.mobile.android.documentscan.domain.utils.DateChecker;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.j */
/* JADX INFO: loaded from: classes5.dex */
public final class C4721j {

    /* JADX INFO: renamed from: a */
    private final DateChecker f6906a;

    /* JADX INFO: renamed from: b */
    private final BlinkDateUtils f6907b;

    /* JADX INFO: renamed from: c */
    private final C4706d f6908c;

    /* JADX INFO: renamed from: d */
    private final C4704b f6909d;

    /* JADX INFO: renamed from: e */
    private final Map<KClass<? extends Recognizer.Result>, Function0<AbstractC4696a<?>>> f6910e;

    public C4721j() {
        DateChecker dateChecker = new DateChecker();
        this.f6906a = dateChecker;
        this.f6907b = new BlinkDateUtils(dateChecker);
        this.f6908c = new C4706d();
        this.f6909d = new C4704b();
        this.f6910e = MapsKt.mapOf(TuplesKt.m5605to(Reflection.getOrCreateKotlinClass(MrtdRecognizer.Result.class), new C4716e(this)), TuplesKt.m5605to(Reflection.getOrCreateKotlinClass(UsdlCombinedRecognizer.Result.class), new C4717f(this)), TuplesKt.m5605to(Reflection.getOrCreateKotlinClass(BlinkIdCombinedRecognizer.Result.class), new C4718g(this)), TuplesKt.m5605to(Reflection.getOrCreateKotlinClass(IdBarcodeRecognizer.Result.class), new C4719h(this)), TuplesKt.m5605to(Reflection.getOrCreateKotlinClass(PassportRecognizer.Result.class), new C4720i(this)));
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC4696a<Recognizer.Result> m4797a(KClass<? extends Recognizer.Result> clazz) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        Function0<AbstractC4696a<?>> function0 = this.f6910e.get(clazz);
        AbstractC4696a<?> abstractC4696aInvoke = function0 != null ? function0.invoke() : null;
        return (AbstractC4696a) (abstractC4696aInvoke instanceof AbstractC4696a ? abstractC4696aInvoke : null);
    }
}
