package com.yoti.mobile.android.mrtd.view;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import com.yoti.mobile.android.mrtd.C4900R;
import com.yoti.mobile.android.mrtd.MrtdNavGraphDirections;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdReadFragmentDirections;", "", "()V", "ActionNfcDetectError", "ActionNfcDetectFailed", "ActionNfcReadError", "ActionNfcReadFailed", "Companion", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdReadFragmentDirections {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdReadFragmentDirections$ActionNfcDetectError;", "Landroidx/navigation/NavDirections;", "titleResId", "", "(I)V", "getTitleResId", "()I", "component1", "copy", "equals", "", "other", "", "getActionId", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private static final /* data */ class ActionNfcDetectError implements NavDirections {
        private final int titleResId;

        public ActionNfcDetectError() {
            this(0, 1, null);
        }

        public ActionNfcDetectError(int i) {
            this.titleResId = i;
        }

        public /* synthetic */ ActionNfcDetectError(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? C4900R.string.ios_android_yds_cant_detect_chip_guidelines_header_detect : i);
        }

        public static /* synthetic */ ActionNfcDetectError copy$default(ActionNfcDetectError actionNfcDetectError, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = actionNfcDetectError.titleResId;
            }
            return actionNfcDetectError.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTitleResId() {
            return this.titleResId;
        }

        public final ActionNfcDetectError copy(int titleResId) {
            return new ActionNfcDetectError(titleResId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ActionNfcDetectError) && this.titleResId == ((ActionNfcDetectError) other).titleResId;
        }

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return C4900R.id.action_nfc_detect_error;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putInt("titleResId", this.titleResId);
            return bundle;
        }

        public final int getTitleResId() {
            return this.titleResId;
        }

        public int hashCode() {
            return Integer.hashCode(this.titleResId);
        }

        public String toString() {
            return "ActionNfcDetectError(titleResId=" + this.titleResId + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001f"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdReadFragmentDirections$ActionNfcDetectFailed;", "Landroidx/navigation/NavDirections;", "titleResId", "", "headerImgResId", "contentResId", "buttonTextResId", "actionButtonIconResId", "(IIIII)V", "getActionButtonIconResId", "()I", "getButtonTextResId", "getContentResId", "getHeaderImgResId", "getTitleResId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getActionId", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private static final /* data */ class ActionNfcDetectFailed implements NavDirections {
        private final int actionButtonIconResId;
        private final int buttonTextResId;
        private final int contentResId;
        private final int headerImgResId;
        private final int titleResId;

        public ActionNfcDetectFailed() {
            this(0, 0, 0, 0, 0, 31, null);
        }

        public ActionNfcDetectFailed(int i, int i2, int i3, int i4, int i5) {
            this.titleResId = i;
            this.headerImgResId = i2;
            this.contentResId = i3;
            this.buttonTextResId = i4;
            this.actionButtonIconResId = i5;
        }

        public /* synthetic */ ActionNfcDetectFailed(int i, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? C4900R.string.ios_android_yds_invalid_nfc_process_header_detect : i, (i6 & 2) != 0 ? C4900R.drawable.yds_ic_error : i2, (i6 & 4) != 0 ? C4900R.string.ios_android_yds_invalid_nfc_process_description : i3, (i6 & 8) != 0 ? C4900R.string.ios_android_yds_invalid_nfc_process_primary_cta : i4, (i6 & 16) != 0 ? C4900R.drawable.yds_ico_upload : i5);
        }

        public static /* synthetic */ ActionNfcDetectFailed copy$default(ActionNfcDetectFailed actionNfcDetectFailed, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = actionNfcDetectFailed.titleResId;
            }
            if ((i6 & 2) != 0) {
                i2 = actionNfcDetectFailed.headerImgResId;
            }
            int i7 = i2;
            if ((i6 & 4) != 0) {
                i3 = actionNfcDetectFailed.contentResId;
            }
            int i8 = i3;
            if ((i6 & 8) != 0) {
                i4 = actionNfcDetectFailed.buttonTextResId;
            }
            int i9 = i4;
            if ((i6 & 16) != 0) {
                i5 = actionNfcDetectFailed.actionButtonIconResId;
            }
            return actionNfcDetectFailed.copy(i, i7, i8, i9, i5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTitleResId() {
            return this.titleResId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getHeaderImgResId() {
            return this.headerImgResId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getContentResId() {
            return this.contentResId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getButtonTextResId() {
            return this.buttonTextResId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getActionButtonIconResId() {
            return this.actionButtonIconResId;
        }

        public final ActionNfcDetectFailed copy(int titleResId, int headerImgResId, int contentResId, int buttonTextResId, int actionButtonIconResId) {
            return new ActionNfcDetectFailed(titleResId, headerImgResId, contentResId, buttonTextResId, actionButtonIconResId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionNfcDetectFailed)) {
                return false;
            }
            ActionNfcDetectFailed actionNfcDetectFailed = (ActionNfcDetectFailed) other;
            return this.titleResId == actionNfcDetectFailed.titleResId && this.headerImgResId == actionNfcDetectFailed.headerImgResId && this.contentResId == actionNfcDetectFailed.contentResId && this.buttonTextResId == actionNfcDetectFailed.buttonTextResId && this.actionButtonIconResId == actionNfcDetectFailed.actionButtonIconResId;
        }

        public final int getActionButtonIconResId() {
            return this.actionButtonIconResId;
        }

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return C4900R.id.action_nfc_detect_failed;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putInt("titleResId", this.titleResId);
            bundle.putInt("headerImgResId", this.headerImgResId);
            bundle.putInt("contentResId", this.contentResId);
            bundle.putInt("buttonTextResId", this.buttonTextResId);
            bundle.putInt("actionButtonIconResId", this.actionButtonIconResId);
            return bundle;
        }

        public final int getButtonTextResId() {
            return this.buttonTextResId;
        }

        public final int getContentResId() {
            return this.contentResId;
        }

        public final int getHeaderImgResId() {
            return this.headerImgResId;
        }

        public final int getTitleResId() {
            return this.titleResId;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.titleResId) * 31) + Integer.hashCode(this.headerImgResId)) * 31) + Integer.hashCode(this.contentResId)) * 31) + Integer.hashCode(this.buttonTextResId)) * 31) + Integer.hashCode(this.actionButtonIconResId);
        }

        public String toString() {
            return "ActionNfcDetectFailed(titleResId=" + this.titleResId + ", headerImgResId=" + this.headerImgResId + ", contentResId=" + this.contentResId + ", buttonTextResId=" + this.buttonTextResId + ", actionButtonIconResId=" + this.actionButtonIconResId + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdReadFragmentDirections$ActionNfcReadError;", "Landroidx/navigation/NavDirections;", "titleResId", "", "(I)V", "getTitleResId", "()I", "component1", "copy", "equals", "", "other", "", "getActionId", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private static final /* data */ class ActionNfcReadError implements NavDirections {
        private final int titleResId;

        public ActionNfcReadError() {
            this(0, 1, null);
        }

        public ActionNfcReadError(int i) {
            this.titleResId = i;
        }

        public /* synthetic */ ActionNfcReadError(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? C4900R.string.ios_android_yds_cant_detect_chip_guidelines_header_read : i);
        }

        public static /* synthetic */ ActionNfcReadError copy$default(ActionNfcReadError actionNfcReadError, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = actionNfcReadError.titleResId;
            }
            return actionNfcReadError.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTitleResId() {
            return this.titleResId;
        }

        public final ActionNfcReadError copy(int titleResId) {
            return new ActionNfcReadError(titleResId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ActionNfcReadError) && this.titleResId == ((ActionNfcReadError) other).titleResId;
        }

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return C4900R.id.action_nfc_read_error;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putInt("titleResId", this.titleResId);
            return bundle;
        }

        public final int getTitleResId() {
            return this.titleResId;
        }

        public int hashCode() {
            return Integer.hashCode(this.titleResId);
        }

        public String toString() {
            return "ActionNfcReadError(titleResId=" + this.titleResId + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001f"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdReadFragmentDirections$ActionNfcReadFailed;", "Landroidx/navigation/NavDirections;", "titleResId", "", "headerImgResId", "contentResId", "buttonTextResId", "actionButtonIconResId", "(IIIII)V", "getActionButtonIconResId", "()I", "getButtonTextResId", "getContentResId", "getHeaderImgResId", "getTitleResId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getActionId", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private static final /* data */ class ActionNfcReadFailed implements NavDirections {
        private final int actionButtonIconResId;
        private final int buttonTextResId;
        private final int contentResId;
        private final int headerImgResId;
        private final int titleResId;

        public ActionNfcReadFailed() {
            this(0, 0, 0, 0, 0, 31, null);
        }

        public ActionNfcReadFailed(int i, int i2, int i3, int i4, int i5) {
            this.titleResId = i;
            this.headerImgResId = i2;
            this.contentResId = i3;
            this.buttonTextResId = i4;
            this.actionButtonIconResId = i5;
        }

        public /* synthetic */ ActionNfcReadFailed(int i, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? C4900R.string.ios_android_yds_invalid_nfc_process_header_read : i, (i6 & 2) != 0 ? C4900R.drawable.yds_ic_error : i2, (i6 & 4) != 0 ? C4900R.string.ios_android_yds_invalid_nfc_process_description : i3, (i6 & 8) != 0 ? C4900R.string.ios_android_yds_invalid_nfc_process_primary_cta : i4, (i6 & 16) != 0 ? C4900R.drawable.yds_ico_upload : i5);
        }

        public static /* synthetic */ ActionNfcReadFailed copy$default(ActionNfcReadFailed actionNfcReadFailed, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = actionNfcReadFailed.titleResId;
            }
            if ((i6 & 2) != 0) {
                i2 = actionNfcReadFailed.headerImgResId;
            }
            int i7 = i2;
            if ((i6 & 4) != 0) {
                i3 = actionNfcReadFailed.contentResId;
            }
            int i8 = i3;
            if ((i6 & 8) != 0) {
                i4 = actionNfcReadFailed.buttonTextResId;
            }
            int i9 = i4;
            if ((i6 & 16) != 0) {
                i5 = actionNfcReadFailed.actionButtonIconResId;
            }
            return actionNfcReadFailed.copy(i, i7, i8, i9, i5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTitleResId() {
            return this.titleResId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getHeaderImgResId() {
            return this.headerImgResId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getContentResId() {
            return this.contentResId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getButtonTextResId() {
            return this.buttonTextResId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getActionButtonIconResId() {
            return this.actionButtonIconResId;
        }

        public final ActionNfcReadFailed copy(int titleResId, int headerImgResId, int contentResId, int buttonTextResId, int actionButtonIconResId) {
            return new ActionNfcReadFailed(titleResId, headerImgResId, contentResId, buttonTextResId, actionButtonIconResId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionNfcReadFailed)) {
                return false;
            }
            ActionNfcReadFailed actionNfcReadFailed = (ActionNfcReadFailed) other;
            return this.titleResId == actionNfcReadFailed.titleResId && this.headerImgResId == actionNfcReadFailed.headerImgResId && this.contentResId == actionNfcReadFailed.contentResId && this.buttonTextResId == actionNfcReadFailed.buttonTextResId && this.actionButtonIconResId == actionNfcReadFailed.actionButtonIconResId;
        }

        public final int getActionButtonIconResId() {
            return this.actionButtonIconResId;
        }

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return C4900R.id.action_nfc_read_failed;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putInt("titleResId", this.titleResId);
            bundle.putInt("headerImgResId", this.headerImgResId);
            bundle.putInt("contentResId", this.contentResId);
            bundle.putInt("buttonTextResId", this.buttonTextResId);
            bundle.putInt("actionButtonIconResId", this.actionButtonIconResId);
            return bundle;
        }

        public final int getButtonTextResId() {
            return this.buttonTextResId;
        }

        public final int getContentResId() {
            return this.contentResId;
        }

        public final int getHeaderImgResId() {
            return this.headerImgResId;
        }

        public final int getTitleResId() {
            return this.titleResId;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.titleResId) * 31) + Integer.hashCode(this.headerImgResId)) * 31) + Integer.hashCode(this.contentResId)) * 31) + Integer.hashCode(this.buttonTextResId)) * 31) + Integer.hashCode(this.actionButtonIconResId);
        }

        public String toString() {
            return "ActionNfcReadFailed(titleResId=" + this.titleResId + ", headerImgResId=" + this.headerImgResId + ", contentResId=" + this.contentResId + ", buttonTextResId=" + this.buttonTextResId + ", actionButtonIconResId=" + this.actionButtonIconResId + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J8\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006J\u0010\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J8\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0004¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdReadFragmentDirections$Companion;", "", "()V", "actionNfcDetectError", "Landroidx/navigation/NavDirections;", "titleResId", "", "actionNfcDetectFailed", "headerImgResId", "contentResId", "buttonTextResId", "actionButtonIconResId", "actionNfcReadError", "actionNfcReadFailed", "actionRestartFlow", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavDirections actionNfcDetectError$default(Companion companion, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = C4900R.string.ios_android_yds_cant_detect_chip_guidelines_header_detect;
            }
            return companion.actionNfcDetectError(i);
        }

        public static /* synthetic */ NavDirections actionNfcDetectFailed$default(Companion companion, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = C4900R.string.ios_android_yds_invalid_nfc_process_header_detect;
            }
            if ((i6 & 2) != 0) {
                i2 = C4900R.drawable.yds_ic_error;
            }
            int i7 = i2;
            if ((i6 & 4) != 0) {
                i3 = C4900R.string.ios_android_yds_invalid_nfc_process_description;
            }
            int i8 = i3;
            if ((i6 & 8) != 0) {
                i4 = C4900R.string.ios_android_yds_invalid_nfc_process_primary_cta;
            }
            int i9 = i4;
            if ((i6 & 16) != 0) {
                i5 = C4900R.drawable.yds_ico_upload;
            }
            return companion.actionNfcDetectFailed(i, i7, i8, i9, i5);
        }

        public static /* synthetic */ NavDirections actionNfcReadError$default(Companion companion, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = C4900R.string.ios_android_yds_cant_detect_chip_guidelines_header_read;
            }
            return companion.actionNfcReadError(i);
        }

        public static /* synthetic */ NavDirections actionNfcReadFailed$default(Companion companion, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = C4900R.string.ios_android_yds_invalid_nfc_process_header_read;
            }
            if ((i6 & 2) != 0) {
                i2 = C4900R.drawable.yds_ic_error;
            }
            int i7 = i2;
            if ((i6 & 4) != 0) {
                i3 = C4900R.string.ios_android_yds_invalid_nfc_process_description;
            }
            int i8 = i3;
            if ((i6 & 8) != 0) {
                i4 = C4900R.string.ios_android_yds_invalid_nfc_process_primary_cta;
            }
            int i9 = i4;
            if ((i6 & 16) != 0) {
                i5 = C4900R.drawable.yds_ico_upload;
            }
            return companion.actionNfcReadFailed(i, i7, i8, i9, i5);
        }

        public final NavDirections actionNfcDetectError(int titleResId) {
            return new ActionNfcDetectError(titleResId);
        }

        public final NavDirections actionNfcDetectFailed(int titleResId, int headerImgResId, int contentResId, int buttonTextResId, int actionButtonIconResId) {
            return new ActionNfcDetectFailed(titleResId, headerImgResId, contentResId, buttonTextResId, actionButtonIconResId);
        }

        public final NavDirections actionNfcReadError(int titleResId) {
            return new ActionNfcReadError(titleResId);
        }

        public final NavDirections actionNfcReadFailed(int titleResId, int headerImgResId, int contentResId, int buttonTextResId, int actionButtonIconResId) {
            return new ActionNfcReadFailed(titleResId, headerImgResId, contentResId, buttonTextResId, actionButtonIconResId);
        }

        public final NavDirections actionRestartFlow() {
            return MrtdNavGraphDirections.INSTANCE.actionRestartFlow();
        }
    }

    private MrtdReadFragmentDirections() {
    }
}
