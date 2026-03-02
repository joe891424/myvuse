package com.microblink.fragment.overlay.blinkid.document;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.fragment.overlay.OverlayStringsBuilder;
import com.microblink.library.C3714R;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentOverlayStrings implements Parcelable {
    public static final Parcelable.Creator<DocumentOverlayStrings> CREATOR = new Parcelable.Creator<DocumentOverlayStrings>() { // from class: com.microblink.fragment.overlay.blinkid.document.DocumentOverlayStrings.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocumentOverlayStrings createFromParcel(Parcel parcel) {
            return new DocumentOverlayStrings(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocumentOverlayStrings[] newArray(int i) {
            return new DocumentOverlayStrings[i];
        }
    };
    final String IIlIIIllIl;
    final String IlIllIlIIl;
    final String IllIIIIllI;
    final String IllIIIllII;
    final String lIIIIIllll;
    final String lIlIIIIlIl;
    final String llIIIlllll;
    final String llIIlIIlll;
    final String llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    public static class Builder extends OverlayStringsBuilder<Builder, Key> {

        /* JADX INFO: compiled from: line */
        enum Key {
            NOT_MATCHING_SIDES_TITLE,
            NOT_MATCHING_SIDES_MESSAGE,
            DATA_MISMATCH_TITLE,
            DATA_MISMATCH_MESSAGE,
            UNSUPPORTED_DOC_TITLE,
            UNSUPPORTED_DOC_MESSAGE,
            RECOGNITION_TIMEOUT_TITLE,
            RECOGNITION_TIMEOUT_MESSAGE,
            RETRY_BUTTON
        }

        public Builder(Context context) {
            super(context);
            llIIlIlIIl(Key.NOT_MATCHING_SIDES_TITLE, llIIlIlIIl(C3714R.string.mb_data_not_match_title));
            llIIlIlIIl(Key.NOT_MATCHING_SIDES_MESSAGE, llIIlIlIIl(C3714R.string.mb_data_not_match_msg));
            llIIlIlIIl(Key.DATA_MISMATCH_TITLE, llIIlIlIIl(C3714R.string.mb_something_went_wrong));
            llIIlIlIIl(Key.DATA_MISMATCH_MESSAGE, llIIlIlIIl(C3714R.string.mb_try_scanning_again));
            llIIlIlIIl(Key.UNSUPPORTED_DOC_TITLE, llIIlIlIIl(C3714R.string.mb_unsupported_document_title));
            llIIlIlIIl(Key.UNSUPPORTED_DOC_MESSAGE, llIIlIlIIl(C3714R.string.mb_unsupported_document_message));
            llIIlIlIIl(Key.RECOGNITION_TIMEOUT_TITLE, llIIlIlIIl(C3714R.string.mb_recognition_timeout_dialog_title));
            llIIlIlIIl(Key.RECOGNITION_TIMEOUT_MESSAGE, llIIlIlIIl(C3714R.string.mb_recognition_timeout_dialog_message));
            llIIlIlIIl(Key.RETRY_BUTTON, llIIlIlIIl(C3714R.string.mb_data_not_match_retry_button));
        }

        public DocumentOverlayStrings build() {
            return new DocumentOverlayStrings(llIIlIlIIl(Key.NOT_MATCHING_SIDES_TITLE), llIIlIlIIl(Key.NOT_MATCHING_SIDES_MESSAGE), llIIlIlIIl(Key.DATA_MISMATCH_TITLE), llIIlIlIIl(Key.DATA_MISMATCH_MESSAGE), llIIlIlIIl(Key.UNSUPPORTED_DOC_TITLE), llIIlIlIIl(Key.UNSUPPORTED_DOC_MESSAGE), llIIlIlIIl(Key.RECOGNITION_TIMEOUT_TITLE), llIIlIlIIl(Key.RECOGNITION_TIMEOUT_MESSAGE), llIIlIlIIl(Key.RETRY_BUTTON));
        }

        @Override // com.microblink.fragment.overlay.OverlayStringsBuilder
        protected Builder llIIlIlIIl() {
            return this;
        }

        public Builder setDataMismatchMessage(String str) {
            return llIIlIlIIl(Key.DATA_MISMATCH_MESSAGE, str);
        }

        public Builder setDataMismatchTitle(String str) {
            return llIIlIlIIl(Key.DATA_MISMATCH_TITLE, str);
        }

        public Builder setRecognitionTimeoutMessage(String str) {
            return llIIlIlIIl(Key.RECOGNITION_TIMEOUT_MESSAGE, str);
        }

        public Builder setRecognitionTimeoutTitle(String str) {
            return llIIlIlIIl(Key.RECOGNITION_TIMEOUT_TITLE, str);
        }

        public Builder setRetryButtonText(String str) {
            return llIIlIlIIl(Key.RETRY_BUTTON, str);
        }

        public Builder setSidesNotMatchingMessage(String str) {
            return llIIlIlIIl(Key.NOT_MATCHING_SIDES_MESSAGE, str);
        }

        public Builder setSidesNotMatchingTitle(String str) {
            return llIIlIlIIl(Key.NOT_MATCHING_SIDES_TITLE, str);
        }

        public Builder setUnsupportedDocumentMessage(String str) {
            return llIIlIlIIl(Key.UNSUPPORTED_DOC_MESSAGE, str);
        }

        public Builder setUnsupportedDocumentTitle(String str) {
            return llIIlIlIIl(Key.UNSUPPORTED_DOC_TITLE, str);
        }
    }

    public static DocumentOverlayStrings createDefault(Context context) {
        return new Builder(context).build();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.llIIlIlIIl);
        parcel.writeString(this.IlIllIlIIl);
        parcel.writeString(this.IllIIIllII);
        parcel.writeString(this.llIIIlllll);
        parcel.writeString(this.IllIIIIllI);
        parcel.writeString(this.lIlIIIIlIl);
        parcel.writeString(this.llIIlIIlll);
        parcel.writeString(this.IIlIIIllIl);
        parcel.writeString(this.lIIIIIllll);
    }

    DocumentOverlayStrings(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.llIIlIlIIl = str;
        this.IlIllIlIIl = str2;
        this.IllIIIllII = str3;
        this.llIIIlllll = str4;
        this.IllIIIIllI = str5;
        this.lIlIIIIlIl = str6;
        this.llIIlIIlll = str7;
        this.IIlIIIllIl = str8;
        this.lIIIIIllll = str9;
    }

    private DocumentOverlayStrings(Parcel parcel) {
        this.llIIlIlIIl = parcel.readString();
        this.IlIllIlIIl = parcel.readString();
        this.IllIIIllII = parcel.readString();
        this.llIIIlllll = parcel.readString();
        this.IllIIIIllI = parcel.readString();
        this.lIlIIIIlIl = parcel.readString();
        this.llIIlIIlll = parcel.readString();
        this.IIlIIIllIl = parcel.readString();
        this.lIIIIIllll = parcel.readString();
    }
}
