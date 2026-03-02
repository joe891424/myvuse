package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import com.yoti.mobile.android.yotidocs.common.CompletableUseCase;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsUnauthorizedSessionError;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.FinishSessionInteractor;
import io.reactivex.observers.DisposableCompletableObserver;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.HttpException;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.c, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\rJ\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\tH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper;", "", "finishSessionInteractor", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/FinishSessionInteractor;", "sessionStatusRepository", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionStatusRepository;", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/FinishSessionInteractor;Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionStatusRepository;)V", "_state", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State;", "previouslyCancelled", "", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "clear", "", "execute", "init", "handle", "setState", "FinishSessionObserver", "State", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FinishSessionHelper {

    /* JADX INFO: renamed from: a */
    private final FinishSessionInteractor f7796a;

    /* JADX INFO: renamed from: b */
    private final ISessionStatusRepository f7797b;

    /* JADX INFO: renamed from: c */
    private SavedStateHandle f7798c;

    /* JADX INFO: renamed from: d */
    private boolean f7799d;

    /* JADX INFO: renamed from: e */
    private final MutableLiveData<b> f7800e;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.c$a */
    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\f\u0010\b\u001a\u00020\t*\u00020\u0007H\u0002¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$FinishSessionObserver;", "Lio/reactivex/observers/DisposableCompletableObserver;", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper;)V", "onComplete", "", "onError", "throwable", "", "isHttpUnauthorizedError", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private final class a extends DisposableCompletableObserver {
        public a() {
        }

        /* JADX INFO: renamed from: a */
        private final boolean m5238a(Throwable th) {
            YotiDocsUnauthorizedSessionError yotiDocsUnauthorizedSessionError = th instanceof YotiDocsUnauthorizedSessionError ? (YotiDocsUnauthorizedSessionError) th : null;
            Throwable error = yotiDocsUnauthorizedSessionError != null ? yotiDocsUnauthorizedSessionError.getError() : null;
            HttpException httpException = error instanceof HttpException ? (HttpException) error : null;
            return httpException != null && httpException.code() == 401;
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            FinishSessionHelper.this.m5230a(b.C6027b.f7803a);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            if (!FinishSessionHelper.this.f7799d || !m5238a(throwable)) {
                FinishSessionHelper.this.m5230a(new b.c(throwable));
            } else {
                FinishSessionHelper.this.f7797b.setSessionStatus(SessionStatusType.SESSION_FINISHED_WITH_SUCCESS);
                FinishSessionHelper.this.m5230a(b.C6027b.f7803a);
            }
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.c$b */
    @Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State;", "Landroid/os/Parcelable;", "()V", "Cancelled", "Completed", "Error", "Idle", "InProgress", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State$Idle;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State$InProgress;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State$Cancelled;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State$Completed;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State$Error;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class b implements Parcelable {

        /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.c$b$a */
        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State$Cancelled;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class a extends b {

            /* JADX INFO: renamed from: a */
            public static final a f7802a = new a();
            public static final Parcelable.Creator<a> CREATOR = new C6026a();

            /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.c$b$a$a, reason: collision with other inner class name */
            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class C6026a implements Parcelable.Creator<a> {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final a createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return a.f7802a;
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final a[] newArray(int i) {
                    return new a[i];
                }
            }

            private a() {
                super(null);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(1);
            }
        }

        /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.c$b$b, reason: collision with other inner class name */
        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State$Completed;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class C6027b extends b {

            /* JADX INFO: renamed from: a */
            public static final C6027b f7803a = new C6027b();
            public static final Parcelable.Creator<C6027b> CREATOR = new a();

            /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.c$b$b$a */
            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class a implements Parcelable.Creator<C6027b> {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final C6027b createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return C6027b.f7803a;
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final C6027b[] newArray(int i) {
                    return new C6027b[i];
                }
            }

            private C6027b() {
                super(null);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(1);
            }
        }

        /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.c$b$c */
        @Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State$Error;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class c extends b {
            public static final Parcelable.Creator<c> CREATOR = new a();

            /* JADX INFO: renamed from: a */
            private final Throwable f7804a;

            /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.c$b$c$a */
            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class a implements Parcelable.Creator<c> {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final c createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new c((Throwable) parcel.readSerializable());
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final c[] newArray(int i) {
                    return new c[i];
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Throwable throwable) {
                super(null);
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                this.f7804a = throwable;
            }

            /* JADX INFO: renamed from: a, reason: from getter */
            public final Throwable getF7804a() {
                return this.f7804a;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof c) && Intrinsics.areEqual(this.f7804a, ((c) other).f7804a);
            }

            public int hashCode() {
                return this.f7804a.hashCode();
            }

            public String toString() {
                return "Error(throwable=" + this.f7804a + ')';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeSerializable(this.f7804a);
            }
        }

        /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.c$b$d */
        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State$Idle;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class d extends b {

            /* JADX INFO: renamed from: a */
            public static final d f7805a = new d();
            public static final Parcelable.Creator<d> CREATOR = new a();

            /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.c$b$d$a */
            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class a implements Parcelable.Creator<d> {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final d createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return d.f7805a;
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final d[] newArray(int i) {
                    return new d[i];
                }
            }

            private d() {
                super(null);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(1);
            }
        }

        /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.c$b$e */
        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State$InProgress;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/FinishSessionHelper$State;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class e extends b {

            /* JADX INFO: renamed from: a */
            public static final e f7806a = new e();
            public static final Parcelable.Creator<e> CREATOR = new a();

            /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.c$b$e$a */
            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class a implements Parcelable.Creator<e> {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final e createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return e.f7806a;
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final e[] newArray(int i) {
                    return new e[i];
                }
            }

            private e() {
                super(null);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(1);
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public FinishSessionHelper(FinishSessionInteractor finishSessionInteractor, ISessionStatusRepository sessionStatusRepository) {
        Intrinsics.checkNotNullParameter(finishSessionInteractor, "finishSessionInteractor");
        Intrinsics.checkNotNullParameter(sessionStatusRepository, "sessionStatusRepository");
        this.f7796a = finishSessionInteractor;
        this.f7797b = sessionStatusRepository;
        this.f7800e = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m5230a(b bVar) {
        SavedStateHandle savedStateHandle = this.f7798c;
        if (savedStateHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle = null;
        }
        savedStateHandle.set("KEY_FINISH_SESSION_STATE", bVar);
        this.f7800e.setValue(bVar);
    }

    /* JADX INFO: renamed from: a */
    public final void m5234a() {
        this.f7796a.clear();
    }

    /* JADX INFO: renamed from: a */
    public final void m5235a(SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.f7798c = handle;
        if (handle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            handle = null;
        }
        b bVar = (b) handle.get("KEY_FINISH_SESSION_STATE");
        if (bVar == null) {
            bVar = b.d.f7805a;
        } else if (Intrinsics.areEqual(bVar, b.e.f7806a)) {
            this.f7799d = true;
            bVar = b.a.f7802a;
        }
        m5230a(bVar);
    }

    /* JADX INFO: renamed from: b */
    public final void m5236b() {
        m5230a(b.e.f7806a);
        CompletableUseCase.execute$default(this.f7796a, new a(), null, 2, null);
    }

    /* JADX INFO: renamed from: c */
    public final LiveData<b> m5237c() {
        return this.f7800e;
    }
}
