package no.nordicsemi.android.dfu.internal.exception;

/* JADX INFO: loaded from: classes6.dex */
public class DfuException extends Exception {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mError;

    public DfuException(final String message, final int state) {
        super(message);
        this.mError = state;
    }

    public int getErrorNumber() {
        return this.mError;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " (error " + (this.mError & (-16385)) + ")";
    }
}
