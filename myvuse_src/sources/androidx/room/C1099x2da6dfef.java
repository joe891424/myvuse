package androidx.room;

import androidx.sqlite.p034db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2 */
/* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5599k = 3, m5600mv = {1, 8, 0}, m5602xi = 48)
/* synthetic */ class C1099x2da6dfef extends FunctionReferenceImpl implements Function1<SupportSQLiteDatabase, Boolean> {
    public static final C1099x2da6dfef INSTANCE = new C1099x2da6dfef();

    C1099x2da6dfef() {
        super(1, SupportSQLiteDatabase.class, "yieldIfContendedSafely", "yieldIfContendedSafely()Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(SupportSQLiteDatabase p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return Boolean.valueOf(p0.yieldIfContendedSafely());
    }
}
