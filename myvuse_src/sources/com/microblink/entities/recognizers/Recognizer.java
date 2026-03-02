package com.microblink.entities.recognizers;

import android.os.Parcel;
import com.microblink.entities.Entity;
import com.microblink.entities.recognizers.Recognizer.Result;
import com.microblink.entities.util.JsonizableEntity;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Recognizer<T extends Result> extends Entity<T> implements JsonizableEntity {

    /* JADX INFO: compiled from: line */
    public static abstract class Result extends Entity.Result {

        /* JADX INFO: compiled from: line */
        public enum State {
            Empty,
            Uncertain,
            Valid,
            StageValid
        }

        protected Result(long j) {
            super(j);
        }

        private static native int nativeGetState(long j);

        @Override // com.microblink.entities.Entity.Result
        /* JADX INFO: renamed from: clone */
        public abstract Result mo6354clone();

        public State getResultState() {
            return State.values()[nativeGetState(getNativeContext())];
        }

        @Override // com.microblink.entities.Entity.Result
        protected final boolean llIIlIlIIl() {
            return getResultState() == State.Empty;
        }
    }

    protected Recognizer(long j, T t) {
        super(j, t);
    }

    private static native String nativeGetType(long j);

    private static native boolean nativeIsExcludedFromPing(long j);

    private static native boolean nativeRequiresAutofocus(long j);

    private static native boolean nativeRequiresLandscapeMode(long j);

    protected static native SignedPayload signedJsonNativeGet(long j);

    @Override // com.microblink.entities.Entity
    /* JADX INFO: renamed from: clone */
    public abstract Recognizer mo6353clone();

    public String getName() {
        return nativeGetType(getNativeContext());
    }

    public boolean isExcludedFromPing() {
        return nativeIsExcludedFromPing(getNativeContext());
    }

    public boolean requiresAutofocus() {
        return nativeRequiresAutofocus(getNativeContext());
    }

    public boolean requiresLandscapeMode() {
        return nativeRequiresLandscapeMode(getNativeContext());
    }

    @Override // com.microblink.entities.util.JsonizableEntity
    public SignedPayload toSignedJson() {
        return signedJsonNativeGet(getNativeContext());
    }

    protected Recognizer(long j, T t, Parcel parcel) {
        super(j, t, parcel);
    }
}
