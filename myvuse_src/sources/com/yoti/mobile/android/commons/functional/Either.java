package com.yoti.mobile.android.commons.functional;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Either.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003:\u0002\u0018\u0019B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005\"\u0004\b\u0002\u0010\u00012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\t\"\u0004\b\u0002\u0010\u00022\u0006\u0010\b\u001a\u00028\u0002¢\u0006\u0004\b\n\u0010\u000bJA\u0010\u0010\u001a\u00028\u0002\"\u0004\b\u0002\u0010\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\rH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u00020\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u00020\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014\u0082\u0001\u0002\u0005\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/functional/Either;", "FailureType", "SuccessType", "", "failResult", "Lcom/yoti/mobile/android/commons/functional/Either$Failure;", "failure", "(Ljava/lang/Object;)Lcom/yoti/mobile/android/commons/functional/Either$Failure;", "successResult", "Lcom/yoti/mobile/android/commons/functional/Either$Success;", FirebaseAnalytics.Param.SUCCESS, "(Ljava/lang/Object;)Lcom/yoti/mobile/android/commons/functional/Either$Success;", "R", "Lkotlin/Function1;", "fnFailure", "fnSuccess", "fold", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "isSuccess", "()Z", "isFailure", "<init>", "()V", "Failure", "Success", "commons-functional_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public abstract class Either<FailureType, SuccessType> {

    /* JADX INFO: compiled from: Either.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00028\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/functional/Either$Failure;", "FailureType", "Lcom/yoti/mobile/android/commons/functional/Either;", "", "component1", "()Ljava/lang/Object;", "failResult", "copy", "(Ljava/lang/Object;)Lcom/yoti/mobile/android/commons/functional/Either$Failure;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/Object;", "getFailResult", "<init>", "(Ljava/lang/Object;)V", "commons-functional_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final /* data */ class Failure<FailureType> extends Either {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final FailureType failResult;

        public Failure(FailureType failuretype) {
            super(null);
            this.failResult = failuretype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Failure copy$default(Failure failure, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = failure.failResult;
            }
            return failure.copy(obj);
        }

        public final FailureType component1() {
            return this.failResult;
        }

        public final Failure<FailureType> copy(FailureType failResult) {
            return new Failure<>(failResult);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Failure) && Intrinsics.areEqual(this.failResult, ((Failure) other).failResult);
            }
            return true;
        }

        public final FailureType getFailResult() {
            return this.failResult;
        }

        public int hashCode() {
            FailureType failuretype = this.failResult;
            if (failuretype != null) {
                return failuretype.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Failure(failResult=" + this.failResult + ")";
        }
    }

    /* JADX INFO: compiled from: Either.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00020\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00028\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/functional/Either$Success;", "SuccessType", "Lcom/yoti/mobile/android/commons/functional/Either;", "", "component1", "()Ljava/lang/Object;", "successResult", "copy", "(Ljava/lang/Object;)Lcom/yoti/mobile/android/commons/functional/Either$Success;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/Object;", "getSuccessResult", "<init>", "(Ljava/lang/Object;)V", "commons-functional_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final /* data */ class Success<SuccessType> extends Either {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final SuccessType successResult;

        public Success(SuccessType successtype) {
            super(null);
            this.successResult = successtype;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.successResult;
            }
            return success.copy(obj);
        }

        public final SuccessType component1() {
            return this.successResult;
        }

        public final Success<SuccessType> copy(SuccessType successResult) {
            return new Success<>(successResult);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Success) && Intrinsics.areEqual(this.successResult, ((Success) other).successResult);
            }
            return true;
        }

        public final SuccessType getSuccessResult() {
            return this.successResult;
        }

        public int hashCode() {
            SuccessType successtype = this.successResult;
            if (successtype != null) {
                return successtype.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Success(successResult=" + this.successResult + ")";
        }
    }

    private Either() {
    }

    public final <FailureType> Failure<FailureType> failure(FailureType failResult) {
        return new Failure<>(failResult);
    }

    public final boolean isFailure() {
        return this instanceof Failure;
    }

    public final boolean isSuccess() {
        return this instanceof Success;
    }

    public final <SuccessType> Success<SuccessType> success(SuccessType successResult) {
        return new Success<>(successResult);
    }

    public /* synthetic */ Either(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final <R> R fold(Function1<? super FailureType, ? extends R> fnFailure, Function1<? super SuccessType, ? extends R> fnSuccess) {
        Intrinsics.checkNotNullParameter(fnFailure, "fnFailure");
        Intrinsics.checkNotNullParameter(fnSuccess, "fnSuccess");
        if (this instanceof Failure) {
            return fnFailure.invoke((Object) ((Failure) this).getFailResult());
        }
        if (this instanceof Success) {
            return fnSuccess.invoke((Object) ((Success) this).getSuccessResult());
        }
        throw new NoWhenBranchMatchedException();
    }
}
