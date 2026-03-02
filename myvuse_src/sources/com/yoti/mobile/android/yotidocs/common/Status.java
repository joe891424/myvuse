package com.yoti.mobile.android.yotidocs.common;

import androidx.exifinterface.media.ExifInterface;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/Status;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "Error", "Loading", "Success", "Lcom/yoti/mobile/android/yotidocs/common/Status$Loading;", "Lcom/yoti/mobile/android/yotidocs/common/Status$Success;", "Lcom/yoti/mobile/android/yotidocs/common/Status$Error;", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class Status<T> {

    @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/Status$Error;", "Lcom/yoti/mobile/android/yotidocs/common/Status;", "", "error", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;)V", "getError", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Error extends Status {

        /* JADX INFO: renamed from: a */
        private final YdsFailure f7473a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(YdsFailure error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.f7473a = error;
        }

        public static /* synthetic */ Error copy$default(Error error, YdsFailure ydsFailure, int i, Object obj) {
            if ((i & 1) != 0) {
                ydsFailure = error.f7473a;
            }
            return error.copy(ydsFailure);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final YdsFailure getF7473a() {
            return this.f7473a;
        }

        public final Error copy(YdsFailure error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.f7473a, ((Error) other).f7473a);
        }

        public final YdsFailure getError() {
            return this.f7473a;
        }

        public int hashCode() {
            return this.f7473a.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.f7473a + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/Status$Loading;", "Lcom/yoti/mobile/android/yotidocs/common/Status;", "", "()V", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Loading extends Status {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0001\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/Status$Success;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/yoti/mobile/android/yotidocs/common/Status;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/yoti/mobile/android/yotidocs/common/Status$Success;", "equals", "", "other", "hashCode", "", "toString", "", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Success<T> extends Status<T> {

        /* JADX INFO: renamed from: a */
        private final T f7474a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(T data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.f7474a = data;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.f7474a;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.f7474a;
        }

        public final Success<T> copy(T data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new Success<>(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.f7474a, ((Success) other).f7474a);
        }

        public final T getData() {
            return this.f7474a;
        }

        public int hashCode() {
            return this.f7474a.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.f7474a + ')';
        }
    }

    private Status() {
    }

    public /* synthetic */ Status(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
