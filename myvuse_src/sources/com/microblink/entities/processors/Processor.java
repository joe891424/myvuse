package com.microblink.entities.processors;

import android.os.Parcel;
import com.microblink.entities.Entity;
import com.microblink.entities.processors.Processor.Result;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Processor<T extends Result> extends Entity<T> {
    public static final String CLASS_NAME = "com.microblink.entities.processors.Processor";

    /* JADX INFO: compiled from: line */
    public static abstract class Result extends Entity.Result {

        /* JADX INFO: compiled from: line */
        public enum State {
            Empty,
            Invalid,
            Valid
        }

        protected Result(long j) {
            super(j);
        }

        private static native int nativeGetState(long j);

        public State getResultState() {
            return State.values()[nativeGetState(getNativeContext())];
        }

        @Override // com.microblink.entities.Entity.Result
        protected final boolean llIIlIlIIl() {
            return getResultState() == State.Empty;
        }
    }

    protected Processor(long j, T t) {
        super(j, t);
    }

    protected Processor(long j, T t, Parcel parcel) {
        super(j, t, parcel);
    }
}
