package no.nordicsemi.android.dfu.internal.exception;

import com.google.common.base.Ascii;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class UnknownResponseException extends Exception {
    private static final char[] HEX_ARRAY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final long serialVersionUID = -8716125467309979289L;
    private final int mExpectedOpCode;
    private final int mExpectedReturnCode;
    private final byte[] mResponse;

    public UnknownResponseException(final String message, final byte[] response, final int expectedReturnCode, final int expectedOpCode) {
        super(message);
        this.mResponse = response == null ? new byte[0] : response;
        this.mExpectedReturnCode = expectedReturnCode;
        this.mExpectedOpCode = expectedOpCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Locale locale = Locale.US;
        String message = super.getMessage();
        byte[] bArr = this.mResponse;
        return String.format(locale, "%s (response: %s, expected: 0x%02X%02X..)", message, bytesToHex(bArr, 0, bArr.length), Integer.valueOf(this.mExpectedReturnCode), Integer.valueOf(this.mExpectedOpCode));
    }

    public static String bytesToHex(final byte[] bytes, final int start, final int length) {
        if (bytes == null || bytes.length <= start || length <= 0) {
            return "";
        }
        int iMin = Math.min(length, bytes.length - start);
        char[] cArr = new char[iMin * 2];
        for (int i = 0; i < iMin; i++) {
            byte b = bytes[start + i];
            int i2 = i * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.f3756SI];
        }
        return "0x".concat(new String(cArr));
    }
}
