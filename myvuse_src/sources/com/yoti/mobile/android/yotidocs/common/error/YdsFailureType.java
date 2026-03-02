package com.yoti.mobile.android.yotidocs.common.error;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.yotidocs.common.C4951R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u000b\f\r\u000e\u000f\u0010\u0011B%\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u0082\u0001\u0007\u0012\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "Landroid/os/Parcelable;", "icon", "", "messageTitleId", "messageTextId", "(III)V", "getIcon", "()I", "getMessageTextId", "getMessageTitleId", "FeatureFailureType", "InconsistencyError", "NetworkNotAvailable", "SessionError", "SessionExpired", "SomethingWentWrong", "TechnicalProblem", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$NetworkNotAvailable;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$TechnicalProblem;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$SomethingWentWrong;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$SessionError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$SessionExpired;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$InconsistencyError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$FeatureFailureType;", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class YdsFailureType implements Parcelable {

    /* JADX INFO: renamed from: a */
    private final int f7488a;

    /* JADX INFO: renamed from: b */
    private final int f7489b;

    /* JADX INFO: renamed from: c */
    private final int f7490c;

    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$FeatureFailureType;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "icon", "", "messageTitleId", "messageTextId", "(III)V", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class FeatureFailureType extends YdsFailureType {
        public FeatureFailureType(int i, int i2, int i3) {
            super(i, i2, i3, null);
        }
    }

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$InconsistencyError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class InconsistencyError extends YdsFailureType {
        public static final InconsistencyError INSTANCE = new InconsistencyError();
        public static final Parcelable.Creator<InconsistencyError> CREATOR = new Creator();

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<InconsistencyError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final InconsistencyError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return InconsistencyError.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final InconsistencyError[] newArray(int i) {
                return new InconsistencyError[i];
            }
        }

        private InconsistencyError() {
            super(C4951R.drawable.yds_ic_error, C4951R.string.ios_android_yds_technical_problem_title, C4951R.string.ios_android_yds_technical_problem_description, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$NetworkNotAvailable;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class NetworkNotAvailable extends YdsFailureType {
        public static final NetworkNotAvailable INSTANCE = new NetworkNotAvailable();
        public static final Parcelable.Creator<NetworkNotAvailable> CREATOR = new Creator();

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<NetworkNotAvailable> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NetworkNotAvailable createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return NetworkNotAvailable.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NetworkNotAvailable[] newArray(int i) {
                return new NetworkNotAvailable[i];
            }
        }

        private NetworkNotAvailable() {
            super(C4951R.drawable.yds_ic_error, C4951R.string.ios_android_yds_no_internet_connection_title, C4951R.string.ios_android_yds_no_internet_connection_description, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$SessionError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class SessionError extends YdsFailureType {
        public static final SessionError INSTANCE = new SessionError();
        public static final Parcelable.Creator<SessionError> CREATOR = new Creator();

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<SessionError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SessionError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return SessionError.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SessionError[] newArray(int i) {
                return new SessionError[i];
            }
        }

        private SessionError() {
            super(C4951R.drawable.yds_ic_blocked, C4951R.string.yds_invalid_verification_process_header, C4951R.string.yds_invalid_id_or_token_description, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$SessionExpired;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class SessionExpired extends YdsFailureType {
        public static final SessionExpired INSTANCE = new SessionExpired();
        public static final Parcelable.Creator<SessionExpired> CREATOR = new Creator();

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<SessionExpired> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SessionExpired createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return SessionExpired.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SessionExpired[] newArray(int i) {
                return new SessionExpired[i];
            }
        }

        private SessionExpired() {
            super(C4951R.drawable.yds_ic_blocked, C4951R.string.yds_session_expired_header, C4951R.string.ios_android_yds_session_expired_description, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$SomethingWentWrong;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class SomethingWentWrong extends YdsFailureType {
        public static final SomethingWentWrong INSTANCE = new SomethingWentWrong();
        public static final Parcelable.Creator<SomethingWentWrong> CREATOR = new Creator();

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<SomethingWentWrong> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SomethingWentWrong createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return SomethingWentWrong.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SomethingWentWrong[] newArray(int i) {
                return new SomethingWentWrong[i];
            }
        }

        private SomethingWentWrong() {
            super(C4951R.drawable.yds_ic_error, C4951R.string.yds_invalid_verification_process_header, C4951R.string.ios_android_yds_invalid_verification_process_description, null);
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

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$TechnicalProblem;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class TechnicalProblem extends YdsFailureType {
        public static final TechnicalProblem INSTANCE = new TechnicalProblem();
        public static final Parcelable.Creator<TechnicalProblem> CREATOR = new Creator();

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<TechnicalProblem> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TechnicalProblem createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return TechnicalProblem.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TechnicalProblem[] newArray(int i) {
                return new TechnicalProblem[i];
            }
        }

        private TechnicalProblem() {
            super(C4951R.drawable.yds_ic_error, C4951R.string.ios_android_yds_technical_problem_title, C4951R.string.ios_android_yds_technical_problem_description, null);
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

    private YdsFailureType(int i, int i2, int i3) {
        this.f7488a = i;
        this.f7489b = i2;
        this.f7490c = i3;
    }

    public /* synthetic */ YdsFailureType(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    /* JADX INFO: renamed from: getIcon, reason: from getter */
    public final int getF7488a() {
        return this.f7488a;
    }

    /* JADX INFO: renamed from: getMessageTextId, reason: from getter */
    public final int getF7490c() {
        return this.f7490c;
    }

    /* JADX INFO: renamed from: getMessageTitleId, reason: from getter */
    public final int getF7489b() {
        return this.f7489b;
    }
}
