package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: compiled from: FastServiceLoader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, m5599k = 2, m5600mv = {1, 8, 0}, m5602xi = 48)
public final class FastServiceLoaderKt {
    private static final boolean ANDROID_DETECTED;

    static {
        Object objM7233constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7233constructorimpl = Result.m7233constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7233constructorimpl = Result.m7233constructorimpl(ResultKt.createFailure(th));
        }
        ANDROID_DETECTED = Result.m7240isSuccessimpl(objM7233constructorimpl);
    }

    public static final boolean getANDROID_DETECTED() {
        return ANDROID_DETECTED;
    }
}
