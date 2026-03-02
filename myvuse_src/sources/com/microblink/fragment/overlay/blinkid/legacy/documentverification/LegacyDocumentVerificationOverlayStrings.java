package com.microblink.fragment.overlay.blinkid.legacy.documentverification;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.fragment.overlay.OverlayStringsBuilder;
import com.microblink.library.C3714R;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class LegacyDocumentVerificationOverlayStrings implements Parcelable {
    public static final Parcelable.Creator<LegacyDocumentVerificationOverlayStrings> CREATOR = new Parcelable.Creator<LegacyDocumentVerificationOverlayStrings>() { // from class: com.microblink.fragment.overlay.blinkid.legacy.documentverification.LegacyDocumentVerificationOverlayStrings.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LegacyDocumentVerificationOverlayStrings createFromParcel(Parcel parcel) {
            return new LegacyDocumentVerificationOverlayStrings(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LegacyDocumentVerificationOverlayStrings[] newArray(int i) {
            return new LegacyDocumentVerificationOverlayStrings[i];
        }
    };
    final String IIlIIIllIl;
    final String IlIllIlIIl;
    final String IlIllIlllI;
    final String IllIIIIllI;
    final String IllIIIllII;
    final String IllIIlIIII;
    final String lIIIIIlIlI;
    final String lIIIIIllll;
    final String lIlIIIIlIl;
    final String llIIIlllll;
    final String llIIlIIlll;
    final String llIIlIlIIl;
    final String lllIIIlIlI;
    final String lllIlIlIIl;

    /* JADX INFO: compiled from: line */
    public static class Builder extends OverlayStringsBuilder<Builder, Key> {

        /* JADX INFO: compiled from: line */
        enum Key {
            FRONT_SIDE_INSTRUCTIONS,
            BACK_SIDE_INSTRUCTIONS,
            FRONT_SIDE_SPLASH,
            BACK_SIDE_SPLASH,
            NOT_MATCHING_TITLE,
            NOT_MATCHING_MESSAGE,
            NOT_MATCHING_SIDES_TITLE,
            NOT_MATCHING_SIDES_MESSAGE,
            DATA_MISMATCH_TITLE,
            DATA_MISMATCH_MESSAGE,
            UNSUPPORTED_DOC_TITLE,
            UNSUPPORTED_DOC_MESSAGE,
            RECOGNITION_TIMEOUT_TITLE,
            RECOGNITION_TIMEOUT_MESSAGE,
            RETRY_BUTTON,
            GLARE_MESSAGE
        }

        public Builder(Context context) {
            super(context);
            llIIlIlIIl(Key.FRONT_SIDE_INSTRUCTIONS, llIIlIlIIl(C3714R.string.mb_tooltip_front_id));
            llIIlIlIIl(Key.BACK_SIDE_INSTRUCTIONS, llIIlIlIIl(C3714R.string.mb_tooltip_back_id));
            llIIlIlIIl(Key.FRONT_SIDE_SPLASH, llIIlIlIIl(C3714R.string.mb_splash_msg_id_front));
            llIIlIlIIl(Key.BACK_SIDE_SPLASH, llIIlIlIIl(C3714R.string.mb_splash_msg_id_back));
            llIIlIlIIl(Key.NOT_MATCHING_SIDES_TITLE, llIIlIlIIl(C3714R.string.mb_data_not_match_title));
            llIIlIlIIl(Key.NOT_MATCHING_SIDES_MESSAGE, llIIlIlIIl(C3714R.string.mb_data_not_match_msg));
            llIIlIlIIl(Key.DATA_MISMATCH_TITLE, llIIlIlIIl(C3714R.string.mb_something_went_wrong));
            llIIlIlIIl(Key.DATA_MISMATCH_MESSAGE, llIIlIlIIl(C3714R.string.mb_try_scanning_again));
            llIIlIlIIl(Key.UNSUPPORTED_DOC_TITLE, llIIlIlIIl(C3714R.string.mb_unsupported_document_title));
            llIIlIlIIl(Key.UNSUPPORTED_DOC_MESSAGE, llIIlIlIIl(C3714R.string.mb_unsupported_document_message));
            llIIlIlIIl(Key.RECOGNITION_TIMEOUT_TITLE, llIIlIlIIl(C3714R.string.mb_recognition_timeout_dialog_title));
            llIIlIlIIl(Key.RECOGNITION_TIMEOUT_MESSAGE, llIIlIlIIl(C3714R.string.mb_recognition_timeout_dialog_message));
            llIIlIlIIl(Key.RETRY_BUTTON, llIIlIlIIl(C3714R.string.mb_data_not_match_retry_button));
            llIIlIlIIl(Key.GLARE_MESSAGE, llIIlIlIIl(C3714R.string.mb_tooltip_glare));
        }

        public LegacyDocumentVerificationOverlayStrings build() {
            return new LegacyDocumentVerificationOverlayStrings(llIIlIlIIl(Key.FRONT_SIDE_INSTRUCTIONS), llIIlIlIIl(Key.BACK_SIDE_INSTRUCTIONS), llIIlIlIIl(Key.FRONT_SIDE_SPLASH), llIIlIlIIl(Key.BACK_SIDE_SPLASH), llIIlIlIIl(Key.NOT_MATCHING_SIDES_TITLE), llIIlIlIIl(Key.NOT_MATCHING_SIDES_MESSAGE), llIIlIlIIl(Key.DATA_MISMATCH_TITLE), llIIlIlIIl(Key.DATA_MISMATCH_MESSAGE), llIIlIlIIl(Key.UNSUPPORTED_DOC_TITLE), llIIlIlIIl(Key.UNSUPPORTED_DOC_MESSAGE), llIIlIlIIl(Key.RECOGNITION_TIMEOUT_TITLE), llIIlIlIIl(Key.RECOGNITION_TIMEOUT_MESSAGE), llIIlIlIIl(Key.RETRY_BUTTON), llIIlIlIIl(Key.GLARE_MESSAGE));
        }

        @Override // com.microblink.fragment.overlay.OverlayStringsBuilder
        protected Builder llIIlIlIIl() {
            return this;
        }

        public Builder setBackSideInstructions(String str) {
            return llIIlIlIIl(Key.BACK_SIDE_INSTRUCTIONS, str);
        }

        public Builder setBackSideSplashText(String str) {
            return llIIlIlIIl(Key.BACK_SIDE_SPLASH, str);
        }

        public Builder setDataMismatchMessage(String str) {
            return llIIlIlIIl(Key.DATA_MISMATCH_MESSAGE, str);
        }

        public Builder setDataMismatchTitle(String str) {
            return llIIlIlIIl(Key.DATA_MISMATCH_TITLE, str);
        }

        public Builder setFrontSideInstructions(String str) {
            return llIIlIlIIl(Key.FRONT_SIDE_INSTRUCTIONS, str);
        }

        public Builder setFrontSideSplashText(String str) {
            return llIIlIlIIl(Key.FRONT_SIDE_SPLASH, str);
        }

        public Builder setGlareMessage(String str) {
            return llIIlIlIIl(Key.GLARE_MESSAGE, str);
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

    public static LegacyDocumentVerificationOverlayStrings createDefault(Context context) {
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
        parcel.writeString(this.lllIIIlIlI);
        parcel.writeString(this.IlIllIlllI);
        parcel.writeString(this.lllIlIlIIl);
        parcel.writeString(this.IllIIlIIII);
        parcel.writeString(this.lIIIIIlIlI);
    }

    LegacyDocumentVerificationOverlayStrings(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.llIIlIlIIl = str;
        this.IlIllIlIIl = str2;
        this.IllIIIllII = str3;
        this.llIIIlllll = str4;
        this.IllIIIIllI = str5;
        this.lIlIIIIlIl = str6;
        this.llIIlIIlll = str7;
        this.IIlIIIllIl = str8;
        this.lIIIIIllll = str9;
        this.lllIIIlIlI = str10;
        this.IlIllIlllI = str11;
        this.lllIlIlIIl = str12;
        this.IllIIlIIII = str13;
        this.lIIIIIlIlI = str14;
    }

    private LegacyDocumentVerificationOverlayStrings(Parcel parcel) {
        this.llIIlIlIIl = parcel.readString();
        this.IlIllIlIIl = parcel.readString();
        this.IllIIIllII = parcel.readString();
        this.llIIIlllll = parcel.readString();
        this.IllIIIIllI = parcel.readString();
        this.lIlIIIIlIl = parcel.readString();
        this.llIIlIIlll = parcel.readString();
        this.IIlIIIllIl = parcel.readString();
        this.lIIIIIllll = parcel.readString();
        this.lllIIIlIlI = parcel.readString();
        this.IlIllIlllI = parcel.readString();
        this.lllIlIlIIl = parcel.readString();
        this.IllIIlIIII = parcel.readString();
        this.lIIIIIlIlI = parcel.readString();
    }
}
