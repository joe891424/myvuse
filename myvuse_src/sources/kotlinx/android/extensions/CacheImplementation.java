package kotlinx.android.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CacheImplementation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, m5598d2 = {"Lkotlinx/android/extensions/CacheImplementation;", "", "(Ljava/lang/String;I)V", "SPARSE_ARRAY", "HASH_MAP", "NO_CACHE", "Companion", "kotlin-android-extensions-runtime"}, m5599k = 1, m5600mv = {1, 4, 1}, m5602xi = 48)
public enum CacheImplementation {
    SPARSE_ARRAY,
    HASH_MAP,
    NO_CACHE;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final CacheImplementation DEFAULT;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static CacheImplementation[] valuesCustom() {
        CacheImplementation[] cacheImplementationArrValuesCustom = values();
        CacheImplementation[] cacheImplementationArr = new CacheImplementation[cacheImplementationArrValuesCustom.length];
        System.arraycopy(cacheImplementationArrValuesCustom, 0, cacheImplementationArr, 0, cacheImplementationArrValuesCustom.length);
        return cacheImplementationArr;
    }

    static {
        CacheImplementation cacheImplementation = HASH_MAP;
        INSTANCE = new Companion(null);
        DEFAULT = cacheImplementation;
    }

    /* JADX INFO: compiled from: CacheImplementation.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5598d2 = {"Lkotlinx/android/extensions/CacheImplementation$Companion;", "", "()V", "DEFAULT", "Lkotlinx/android/extensions/CacheImplementation;", "getDEFAULT", "()Lkotlinx/android/extensions/CacheImplementation;", "kotlin-android-extensions-runtime"}, m5599k = 1, m5600mv = {1, 4, 1}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CacheImplementation getDEFAULT() {
            return CacheImplementation.DEFAULT;
        }
    }
}
