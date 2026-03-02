package com.microblink.fragment.overlay.blinkid.reticleui;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.fragment.overlay.OverlayStringsBuilder;
import com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions;
import com.microblink.library.C3714R;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class ReticleOverlayStrings implements Parcelable {
    public static final Parcelable.Creator<ReticleOverlayStrings> CREATOR = new Parcelable.Creator<ReticleOverlayStrings>() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.ReticleOverlayStrings.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReticleOverlayStrings createFromParcel(Parcel parcel) {
            return new ReticleOverlayStrings(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReticleOverlayStrings[] newArray(int i) {
            return new ReticleOverlayStrings[i];
        }
    };
    public final String backSideBarcodeInstructions;
    public final String backSideInstructions;
    public final String dataMismatchMessage;
    public final String dataMismatchTitle;
    public final String errorDocumentNotFullyVisible;
    public final String errorDocumentTooCloseToEdge;
    public final String errorMoveCloser;
    public final String errorMoveFarther;
    public final String firstSideInstructions;
    public final String flashlightWarning;
    public final String flipInstructions;
    public final String recognitionTimeoutMessage;
    public final String recognitionTimeoutTitle;
    public final String retryButton;
    public final String sidesNotMatchingMessage;
    public final String sidesNotMatchingTitle;
    public final String unsupportedDocumentMessage;
    public final String unsupportedDocumentTitle;

    /* JADX INFO: compiled from: line */
    public static class Builder extends OverlayStringsBuilder<Builder, Key> implements ReticleOverlayStringsOptions<Builder> {

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
            RETRY_BUTTON,
            FIRST_SIDE_INSTRUCTIONS,
            FLIP_INSTRUCTIONS,
            BACK_SIDE_INSTRUCTIONS,
            BACK_SIDE_BARCODE_INSTRUCTIONS,
            ERROR_MOVE_CLOSER,
            ERROR_MOVE_FARTHER,
            ERROR_DOCUMENT_TOO_CLOSE_TO_EDGE,
            ERROR_DOCUMENT_NOT_FULLY_VISIBLE,
            FLASHLIGHT_WARNING_MESSAGE
        }

        public Builder(Context context) {
            super(context);
            llIIlIlIIl(Key.NOT_MATCHING_SIDES_TITLE, llIIlIlIIl(C3714R.string.mb_data_not_match_title));
            llIIlIlIIl(Key.NOT_MATCHING_SIDES_MESSAGE, llIIlIlIIl(C3714R.string.mb_data_not_match_msg));
            llIIlIlIIl(Key.DATA_MISMATCH_TITLE, llIIlIlIIl(C3714R.string.mb_something_went_wrong));
            llIIlIlIIl(Key.DATA_MISMATCH_MESSAGE, llIIlIlIIl(C3714R.string.mb_try_scanning_again));
            llIIlIlIIl(Key.RETRY_BUTTON, llIIlIlIIl(C3714R.string.mb_data_not_match_retry_button));
            llIIlIlIIl(Key.FIRST_SIDE_INSTRUCTIONS, llIIlIlIIl(C3714R.string.mb_blinkid_front_instructions));
            llIIlIlIIl(Key.FLIP_INSTRUCTIONS, llIIlIlIIl(C3714R.string.mb_blinkid_camera_flip_document));
            llIIlIlIIl(Key.BACK_SIDE_INSTRUCTIONS, llIIlIlIIl(C3714R.string.mb_blinkid_back_instructions));
            llIIlIlIIl(Key.BACK_SIDE_BARCODE_INSTRUCTIONS, llIIlIlIIl(C3714R.string.mb_blinkid_back_instructions_barcode));
            llIIlIlIIl(Key.ERROR_MOVE_CLOSER, llIIlIlIIl(C3714R.string.mb_error_camera_high));
            llIIlIlIIl(Key.ERROR_MOVE_FARTHER, llIIlIlIIl(C3714R.string.mb_error_camera_near));
            llIIlIlIIl(Key.ERROR_DOCUMENT_TOO_CLOSE_TO_EDGE, llIIlIlIIl(C3714R.string.mb_blinkid_document_too_close_to_edge));
            llIIlIlIIl(Key.ERROR_DOCUMENT_NOT_FULLY_VISIBLE, llIIlIlIIl(C3714R.string.mb_blinkid_document_not_fully_visible));
            llIIlIlIIl(Key.UNSUPPORTED_DOC_TITLE, llIIlIlIIl(C3714R.string.mb_unsupported_document_title));
            llIIlIlIIl(Key.UNSUPPORTED_DOC_MESSAGE, llIIlIlIIl(C3714R.string.mb_unsupported_document_message));
            llIIlIlIIl(Key.RECOGNITION_TIMEOUT_TITLE, llIIlIlIIl(C3714R.string.mb_recognition_timeout_dialog_title));
            llIIlIlIIl(Key.RECOGNITION_TIMEOUT_MESSAGE, llIIlIlIIl(C3714R.string.mb_recognition_timeout_dialog_message));
            llIIlIlIIl(Key.FLASHLIGHT_WARNING_MESSAGE, llIIlIlIIl(C3714R.string.mb_flashlight_warning_message));
        }

        public ReticleOverlayStrings build() {
            return new ReticleOverlayStrings(llIIlIlIIl(Key.NOT_MATCHING_SIDES_TITLE), llIIlIlIIl(Key.NOT_MATCHING_SIDES_MESSAGE), llIIlIlIIl(Key.DATA_MISMATCH_TITLE), llIIlIlIIl(Key.DATA_MISMATCH_MESSAGE), llIIlIlIIl(Key.UNSUPPORTED_DOC_TITLE), llIIlIlIIl(Key.UNSUPPORTED_DOC_MESSAGE), llIIlIlIIl(Key.RECOGNITION_TIMEOUT_TITLE), llIIlIlIIl(Key.RECOGNITION_TIMEOUT_MESSAGE), llIIlIlIIl(Key.RETRY_BUTTON), llIIlIlIIl(Key.FIRST_SIDE_INSTRUCTIONS), llIIlIlIIl(Key.FLIP_INSTRUCTIONS), llIIlIlIIl(Key.BACK_SIDE_INSTRUCTIONS), llIIlIlIIl(Key.BACK_SIDE_BARCODE_INSTRUCTIONS), llIIlIlIIl(Key.ERROR_MOVE_CLOSER), llIIlIlIIl(Key.ERROR_MOVE_FARTHER), llIIlIlIIl(Key.ERROR_DOCUMENT_TOO_CLOSE_TO_EDGE), llIIlIlIIl(Key.ERROR_DOCUMENT_NOT_FULLY_VISIBLE), llIIlIlIIl(Key.FLASHLIGHT_WARNING_MESSAGE));
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

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setBackSideBarcodeInstructions(String str) {
            return llIIlIlIIl(Key.BACK_SIDE_BARCODE_INSTRUCTIONS, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setBackSideInstructions(String str) {
            return llIIlIlIIl(Key.BACK_SIDE_INSTRUCTIONS, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setErrorDocumentNotFullyVisible(String str) {
            return llIIlIlIIl(Key.ERROR_DOCUMENT_NOT_FULLY_VISIBLE, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setErrorDocumentTooCloseToEdge(String str) {
            return llIIlIlIIl(Key.ERROR_DOCUMENT_TOO_CLOSE_TO_EDGE, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setErrorMoveCloser(String str) {
            return llIIlIlIIl(Key.ERROR_MOVE_CLOSER, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setErrorMoveFarther(String str) {
            return llIIlIlIIl(Key.ERROR_MOVE_FARTHER, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setFirstSideInstructionsText(String str) {
            return llIIlIlIIl(Key.FIRST_SIDE_INSTRUCTIONS, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setFlashlightWarningMessage(String str) {
            return llIIlIlIIl(Key.FLASHLIGHT_WARNING_MESSAGE, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setFlipInstructions(String str) {
            return llIIlIlIIl(Key.FLIP_INSTRUCTIONS, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setRecognitionTimeoutMessage(String str) {
            return llIIlIlIIl(Key.RECOGNITION_TIMEOUT_MESSAGE, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setRecognitionTimeoutTitle(String str) {
            return llIIlIlIIl(Key.RECOGNITION_TIMEOUT_TITLE, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setRetryButtonText(String str) {
            return llIIlIlIIl(Key.RETRY_BUTTON, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setSidesNotMatchingMessage(String str) {
            return llIIlIlIIl(Key.NOT_MATCHING_SIDES_MESSAGE, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setSidesNotMatchingTitle(String str) {
            return llIIlIlIIl(Key.NOT_MATCHING_SIDES_TITLE, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setUnsupportedDocumentMessage(String str) {
            return llIIlIlIIl(Key.UNSUPPORTED_DOC_MESSAGE, str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.reticleui.strings.options.ReticleOverlayStringsOptions
        public Builder setUnsupportedDocumentTitle(String str) {
            return llIIlIlIIl(Key.UNSUPPORTED_DOC_TITLE, str);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sidesNotMatchingTitle);
        parcel.writeString(this.sidesNotMatchingMessage);
        parcel.writeString(this.dataMismatchTitle);
        parcel.writeString(this.dataMismatchMessage);
        parcel.writeString(this.retryButton);
        parcel.writeString(this.firstSideInstructions);
        parcel.writeString(this.flipInstructions);
        parcel.writeString(this.backSideInstructions);
        parcel.writeString(this.backSideBarcodeInstructions);
        parcel.writeString(this.errorMoveCloser);
        parcel.writeString(this.errorMoveFarther);
        parcel.writeString(this.errorDocumentTooCloseToEdge);
        parcel.writeString(this.unsupportedDocumentTitle);
        parcel.writeString(this.unsupportedDocumentMessage);
        parcel.writeString(this.recognitionTimeoutTitle);
        parcel.writeString(this.recognitionTimeoutMessage);
        parcel.writeString(this.flashlightWarning);
        parcel.writeString(this.errorDocumentNotFullyVisible);
    }

    private ReticleOverlayStrings(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18) {
        this.sidesNotMatchingTitle = str;
        this.sidesNotMatchingMessage = str2;
        this.dataMismatchTitle = str3;
        this.dataMismatchMessage = str4;
        this.unsupportedDocumentTitle = str5;
        this.unsupportedDocumentMessage = str6;
        this.recognitionTimeoutTitle = str7;
        this.recognitionTimeoutMessage = str8;
        this.retryButton = str9;
        this.firstSideInstructions = str10;
        this.flipInstructions = str11;
        this.backSideInstructions = str12;
        this.backSideBarcodeInstructions = str13;
        this.errorMoveCloser = str14;
        this.errorMoveFarther = str15;
        this.errorDocumentTooCloseToEdge = str16;
        this.errorDocumentNotFullyVisible = str17;
        this.flashlightWarning = str18;
    }

    private ReticleOverlayStrings(Parcel parcel) {
        this.sidesNotMatchingTitle = parcel.readString();
        this.sidesNotMatchingMessage = parcel.readString();
        this.dataMismatchTitle = parcel.readString();
        this.dataMismatchMessage = parcel.readString();
        this.retryButton = parcel.readString();
        this.firstSideInstructions = parcel.readString();
        this.flipInstructions = parcel.readString();
        this.backSideInstructions = parcel.readString();
        this.backSideBarcodeInstructions = parcel.readString();
        this.errorMoveCloser = parcel.readString();
        this.errorMoveFarther = parcel.readString();
        this.errorDocumentTooCloseToEdge = parcel.readString();
        this.unsupportedDocumentTitle = parcel.readString();
        this.unsupportedDocumentMessage = parcel.readString();
        this.recognitionTimeoutTitle = parcel.readString();
        this.recognitionTimeoutMessage = parcel.readString();
        this.flashlightWarning = parcel.readString();
        this.errorDocumentNotFullyVisible = parcel.readString();
    }
}
