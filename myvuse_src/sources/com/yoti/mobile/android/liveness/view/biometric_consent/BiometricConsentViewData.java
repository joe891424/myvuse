package com.yoti.mobile.android.liveness.view.biometric_consent;

import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.liveness.C4871R;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u0019\u001a\u001bB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData;", "", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "locKeys", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$BiometricConsentLocKeys;", "privacyPolicyUrl", "", "(Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$BiometricConsentLocKeys;Ljava/lang/String;)V", "getLocKeys", "()Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$BiometricConsentLocKeys;", "getNavigationIcon", "()Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "getPrivacyPolicyUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "BiometricConsentLocKeys", "Factory", "ListItem", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class BiometricConsentViewData {
    private final BiometricConsentLocKeys locKeys;
    private final NavigationIcon navigationIcon;
    private final String privacyPolicyUrl;

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$BiometricConsentLocKeys;", "", "title", "", "listItems", "", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem;", "(ILjava/util/List;)V", "getListItems", "()Ljava/util/List;", "getTitle", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class BiometricConsentLocKeys {
        private final List<ListItem> listItems;
        private final int title;

        /* JADX WARN: Multi-variable type inference failed */
        public BiometricConsentLocKeys(int i, List<? extends ListItem> listItems) {
            Intrinsics.checkNotNullParameter(listItems, "listItems");
            this.title = i;
            this.listItems = listItems;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BiometricConsentLocKeys copy$default(BiometricConsentLocKeys biometricConsentLocKeys, int i, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = biometricConsentLocKeys.title;
            }
            if ((i2 & 2) != 0) {
                list = biometricConsentLocKeys.listItems;
            }
            return biometricConsentLocKeys.copy(i, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTitle() {
            return this.title;
        }

        public final List<ListItem> component2() {
            return this.listItems;
        }

        public final BiometricConsentLocKeys copy(int title, List<? extends ListItem> listItems) {
            Intrinsics.checkNotNullParameter(listItems, "listItems");
            return new BiometricConsentLocKeys(title, listItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BiometricConsentLocKeys)) {
                return false;
            }
            BiometricConsentLocKeys biometricConsentLocKeys = (BiometricConsentLocKeys) other;
            return this.title == biometricConsentLocKeys.title && Intrinsics.areEqual(this.listItems, biometricConsentLocKeys.listItems);
        }

        public final List<ListItem> getListItems() {
            return this.listItems;
        }

        public final int getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (Integer.hashCode(this.title) * 31) + this.listItems.hashCode();
        }

        public String toString() {
            return "BiometricConsentLocKeys(title=" + this.title + ", listItems=" + this.listItems + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$Factory;", "", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;)V", "create", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData;", "createBiometricConsentLocKeys", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$BiometricConsentLocKeys;", "hasPrivacyPolicyUrl", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Factory {
        private final LivenessFeatureConfiguration featureConfiguration;

        @Inject
        public Factory(LivenessFeatureConfiguration featureConfiguration) {
            Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
            this.featureConfiguration = featureConfiguration;
        }

        private final BiometricConsentLocKeys createBiometricConsentLocKeys(boolean hasPrivacyPolicyUrl) {
            int i = C4871R.string.yds_biometric_consent_face_title;
            List listMutableListOf = CollectionsKt.mutableListOf(new ListItem.Paragraph(C4871R.string.yds_biometric_consent_face_security), new ListItem.BulletedParagraph(C4871R.string.yds_biometric_consent_face_anti_spoofing), new ListItem.BulletedParagraph(C4871R.string.yds_biometric_consent_face_match_id), new ListItem.BulletedParagraph(C4871R.string.yds_biometric_consent_face_delete_image), new ListItem.BulletedParagraph(C4871R.string.yds_biometric_consent_face_delete_image_id_check), new ListItem.Paragraph(C4871R.string.ios_android_yds_biometric_consent_face_requirement), new ListItem.Paragraph(C4871R.string.ios_android_yds_biometric_consent_us_biometric_policy));
            if (hasPrivacyPolicyUrl) {
                listMutableListOf.add(ListItem.WebLink.PrivacyPolicy.INSTANCE);
            }
            listMutableListOf.add(ListItem.WebLink.BiometricPolicyUs.INSTANCE);
            return new BiometricConsentLocKeys(i, listMutableListOf);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewData create() {
            /*
                r5 = this;
                com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration r0 = r5.featureConfiguration
                com.yoti.mobile.android.commonui.UiSessionConfiguration r0 = r0.getUiSessionConfiguration()
                java.lang.String r0 = r0.getPrivacyPolicyUrl()
                com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewData r1 = new com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewData
                com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration r2 = r5.featureConfiguration
                boolean r2 = r2.isSingleStepFlow()
                if (r2 == 0) goto L17
                com.yoti.mobile.android.common.ui.widgets.NavigationIcon r2 = com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon.BACK_BLUE
                goto L19
            L17:
                com.yoti.mobile.android.common.ui.widgets.NavigationIcon r2 = com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon.CLOSE_BLUE
            L19:
                if (r0 == 0) goto L24
                boolean r3 = kotlin.text.StringsKt.isBlank(r0)
                r4 = 1
                r3 = r3 ^ r4
                if (r3 != r4) goto L24
                goto L25
            L24:
                r4 = 0
            L25:
                com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewData$BiometricConsentLocKeys r3 = r5.createBiometricConsentLocKeys(r4)
                r1.<init>(r2, r3, r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewData.Factory.create():com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewData");
        }
    }

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0004\u0007\b\t\nB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem;", "", "viewTypeId", "", "(I)V", "getViewTypeId", "()I", "BulletedParagraph", "Companion", "Paragraph", "WebLink", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem$Paragraph;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem$BulletedParagraph;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem$WebLink;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class ListItem {
        public static final int BULLETED_PARAGRAPH_VIEW_TYPE_ID = 1;
        public static final int PARAGRAPH_VIEW_TYPE_ID = 0;
        public static final int WEB_LINK_VIEW_TYPE_ID = 2;
        private final int viewTypeId;

        @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem$BulletedParagraph;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem;", "textId", "", "(I)V", "getTextId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class BulletedParagraph extends ListItem {
            private final int textId;

            public BulletedParagraph(int i) {
                super(1, null);
                this.textId = i;
            }

            public static /* synthetic */ BulletedParagraph copy$default(BulletedParagraph bulletedParagraph, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = bulletedParagraph.textId;
                }
                return bulletedParagraph.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getTextId() {
                return this.textId;
            }

            public final BulletedParagraph copy(int textId) {
                return new BulletedParagraph(textId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof BulletedParagraph) && this.textId == ((BulletedParagraph) other).textId;
            }

            public final int getTextId() {
                return this.textId;
            }

            public int hashCode() {
                return Integer.hashCode(this.textId);
            }

            public String toString() {
                return "BulletedParagraph(textId=" + this.textId + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem$Paragraph;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem;", "textId", "", "(I)V", "getTextId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class Paragraph extends ListItem {
            private final int textId;

            public Paragraph(int i) {
                super(0, null);
                this.textId = i;
            }

            public static /* synthetic */ Paragraph copy$default(Paragraph paragraph, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = paragraph.textId;
                }
                return paragraph.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getTextId() {
                return this.textId;
            }

            public final Paragraph copy(int textId) {
                return new Paragraph(textId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Paragraph) && this.textId == ((Paragraph) other).textId;
            }

            public final int getTextId() {
                return this.textId;
            }

            public int hashCode() {
                return Integer.hashCode(this.textId);
            }

            public String toString() {
                return "Paragraph(textId=" + this.textId + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0019\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem$WebLink;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem;", "labelId", "", "viewTypeId", "(II)V", "getLabelId", "()I", "BiometricPolicyUs", "PrivacyPolicy", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem$WebLink$PrivacyPolicy;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem$WebLink$BiometricPolicyUs;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static abstract class WebLink extends ListItem {
            private final int labelId;

            @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem$WebLink$BiometricPolicyUs;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem$WebLink;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class BiometricPolicyUs extends WebLink {
                public static final BiometricPolicyUs INSTANCE = new BiometricPolicyUs();

                private BiometricPolicyUs() {
                    super(C4871R.string.ios_android_yds_biometric_consent_us_biometric_policy_cta, 2, null);
                }
            }

            @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem$WebLink$PrivacyPolicy;", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData$ListItem$WebLink;", "()V", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class PrivacyPolicy extends WebLink {
                public static final PrivacyPolicy INSTANCE = new PrivacyPolicy();

                private PrivacyPolicy() {
                    super(C4871R.string.ios_android_yds_biometric_consent_privacy_policy_cta, 2, null);
                }
            }

            private WebLink(int i, int i2) {
                super(i2, null);
                this.labelId = i;
            }

            public /* synthetic */ WebLink(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, i2);
            }

            public final int getLabelId() {
                return this.labelId;
            }
        }

        private ListItem(int i) {
            this.viewTypeId = i;
        }

        public /* synthetic */ ListItem(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }

        public final int getViewTypeId() {
            return this.viewTypeId;
        }
    }

    public BiometricConsentViewData(NavigationIcon navigationIcon, BiometricConsentLocKeys locKeys, String str) {
        Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
        Intrinsics.checkNotNullParameter(locKeys, "locKeys");
        this.navigationIcon = navigationIcon;
        this.locKeys = locKeys;
        this.privacyPolicyUrl = str;
    }

    public static /* synthetic */ BiometricConsentViewData copy$default(BiometricConsentViewData biometricConsentViewData, NavigationIcon navigationIcon, BiometricConsentLocKeys biometricConsentLocKeys, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            navigationIcon = biometricConsentViewData.navigationIcon;
        }
        if ((i & 2) != 0) {
            biometricConsentLocKeys = biometricConsentViewData.locKeys;
        }
        if ((i & 4) != 0) {
            str = biometricConsentViewData.privacyPolicyUrl;
        }
        return biometricConsentViewData.copy(navigationIcon, biometricConsentLocKeys, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final NavigationIcon getNavigationIcon() {
        return this.navigationIcon;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final BiometricConsentLocKeys getLocKeys() {
        return this.locKeys;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public final BiometricConsentViewData copy(NavigationIcon navigationIcon, BiometricConsentLocKeys locKeys, String privacyPolicyUrl) {
        Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
        Intrinsics.checkNotNullParameter(locKeys, "locKeys");
        return new BiometricConsentViewData(navigationIcon, locKeys, privacyPolicyUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BiometricConsentViewData)) {
            return false;
        }
        BiometricConsentViewData biometricConsentViewData = (BiometricConsentViewData) other;
        return this.navigationIcon == biometricConsentViewData.navigationIcon && Intrinsics.areEqual(this.locKeys, biometricConsentViewData.locKeys) && Intrinsics.areEqual(this.privacyPolicyUrl, biometricConsentViewData.privacyPolicyUrl);
    }

    public final BiometricConsentLocKeys getLocKeys() {
        return this.locKeys;
    }

    public final NavigationIcon getNavigationIcon() {
        return this.navigationIcon;
    }

    public final String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public int hashCode() {
        int iHashCode = ((this.navigationIcon.hashCode() * 31) + this.locKeys.hashCode()) * 31;
        String str = this.privacyPolicyUrl;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BiometricConsentViewData(navigationIcon=" + this.navigationIcon + ", locKeys=" + this.locKeys + ", privacyPolicyUrl=" + this.privacyPolicyUrl + ')';
    }

    public /* synthetic */ BiometricConsentViewData(NavigationIcon navigationIcon, BiometricConsentLocKeys biometricConsentLocKeys, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(navigationIcon, biometricConsentLocKeys, (i & 4) != 0 ? null : str);
    }
}
