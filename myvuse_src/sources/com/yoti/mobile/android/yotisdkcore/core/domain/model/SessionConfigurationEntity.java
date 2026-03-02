package com.yoti.mobile.android.yotisdkcore.core.domain.model;

import com.yoti.mobile.android.yotidocs.common.error.YotiDocsExpiredSessionError;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001:\u0001.BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÂ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003JS\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0006\u0010)\u001a\u00020\u0013J\u0006\u0010*\u001a\u00020\u0013J\u000e\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\bJ\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity;", "", "sessionTokenTtl", "", "sessionId", "", "_steps", "", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/ResourceConfigurationEntity;", "checks", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/CheckTypeEntity;", "uiSessionConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity$UiSessionConfigurationEntity;", "userPriceEntity", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/UserPriceEntity;", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity$UiSessionConfigurationEntity;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/UserPriceEntity;)V", "getChecks", "()Ljava/util/List;", "isSessionCompleted", "", "()Z", "getSessionId", "()Ljava/lang/String;", "getSessionTokenTtl", "()I", "steps", "getSteps", "getUiSessionConfiguration", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity$UiSessionConfigurationEntity;", "getUserPriceEntity", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/UserPriceEntity;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "shouldPerformDocumentSchemeValidityCheck", "shouldPerformIbvVisualReviewCheck", "shouldShowIdentityCheck", "step", "toString", "UiSessionConfigurationEntity", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class SessionConfigurationEntity {
    private final List<ResourceConfigurationEntity> _steps;
    private final List<CheckTypeEntity> checks;
    private final String sessionId;
    private final int sessionTokenTtl;
    private final List<ResourceConfigurationEntity> steps;
    private final UiSessionConfigurationEntity uiSessionConfiguration;
    private final UserPriceEntity userPriceEntity;

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity$UiSessionConfigurationEntity;", "", "hideLogo", "", "privacyPolicyUrl", "", "(ZLjava/lang/String;)V", "getHideLogo", "()Z", "getPrivacyPolicyUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class UiSessionConfigurationEntity {
        private final boolean hideLogo;
        private final String privacyPolicyUrl;

        /* JADX WARN: Multi-variable type inference failed */
        public UiSessionConfigurationEntity() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        public UiSessionConfigurationEntity(boolean z, String str) {
            this.hideLogo = z;
            this.privacyPolicyUrl = str;
        }

        public /* synthetic */ UiSessionConfigurationEntity(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str);
        }

        public static /* synthetic */ UiSessionConfigurationEntity copy$default(UiSessionConfigurationEntity uiSessionConfigurationEntity, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = uiSessionConfigurationEntity.hideLogo;
            }
            if ((i & 2) != 0) {
                str = uiSessionConfigurationEntity.privacyPolicyUrl;
            }
            return uiSessionConfigurationEntity.copy(z, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getHideLogo() {
            return this.hideLogo;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPrivacyPolicyUrl() {
            return this.privacyPolicyUrl;
        }

        public final UiSessionConfigurationEntity copy(boolean hideLogo, String privacyPolicyUrl) {
            return new UiSessionConfigurationEntity(hideLogo, privacyPolicyUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UiSessionConfigurationEntity)) {
                return false;
            }
            UiSessionConfigurationEntity uiSessionConfigurationEntity = (UiSessionConfigurationEntity) other;
            return this.hideLogo == uiSessionConfigurationEntity.hideLogo && Intrinsics.areEqual(this.privacyPolicyUrl, uiSessionConfigurationEntity.privacyPolicyUrl);
        }

        public final boolean getHideLogo() {
            return this.hideLogo;
        }

        public final String getPrivacyPolicyUrl() {
            return this.privacyPolicyUrl;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z = this.hideLogo;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            String str = this.privacyPolicyUrl;
            return i + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "UiSessionConfigurationEntity(hideLogo=" + this.hideLogo + ", privacyPolicyUrl=" + this.privacyPolicyUrl + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SessionConfigurationEntity(int i, String sessionId, List<? extends ResourceConfigurationEntity> _steps, List<? extends CheckTypeEntity> checks, UiSessionConfigurationEntity uiSessionConfiguration, UserPriceEntity userPriceEntity) throws YotiDocsExpiredSessionError {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(_steps, "_steps");
        Intrinsics.checkNotNullParameter(checks, "checks");
        Intrinsics.checkNotNullParameter(uiSessionConfiguration, "uiSessionConfiguration");
        this.sessionTokenTtl = i;
        this.sessionId = sessionId;
        this._steps = _steps;
        this.checks = checks;
        this.uiSessionConfiguration = uiSessionConfiguration;
        this.userPriceEntity = userPriceEntity;
        if (i <= 0) {
            throw new YotiDocsExpiredSessionError(null, 1, 0 == true ? 1 : 0);
        }
        Iterator it2 = _steps.iterator();
        while (it2.hasNext()) {
            ((ResourceConfigurationEntity) it2.next()).getFeature().validate();
        }
        this.steps = CollectionsKt.sortedWith(_steps, new Comparator() { // from class: com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity$special$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Boolean.valueOf(((ResourceConfigurationEntity) t2).isCompleted()), Boolean.valueOf(((ResourceConfigurationEntity) t).isCompleted()));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ SessionConfigurationEntity(int i, String str, List list, List list2, UiSessionConfigurationEntity uiSessionConfigurationEntity, UserPriceEntity userPriceEntity, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, list, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 16) != 0 ? new UiSessionConfigurationEntity(false, null, 3, 0 == true ? 1 : 0) : uiSessionConfigurationEntity, (i2 & 32) != 0 ? null : userPriceEntity);
    }

    private final List<ResourceConfigurationEntity> component3() {
        return this._steps;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SessionConfigurationEntity copy$default(SessionConfigurationEntity sessionConfigurationEntity, int i, String str, List list, List list2, UiSessionConfigurationEntity uiSessionConfigurationEntity, UserPriceEntity userPriceEntity, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = sessionConfigurationEntity.sessionTokenTtl;
        }
        if ((i2 & 2) != 0) {
            str = sessionConfigurationEntity.sessionId;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            list = sessionConfigurationEntity._steps;
        }
        List list3 = list;
        if ((i2 & 8) != 0) {
            list2 = sessionConfigurationEntity.checks;
        }
        List list4 = list2;
        if ((i2 & 16) != 0) {
            uiSessionConfigurationEntity = sessionConfigurationEntity.uiSessionConfiguration;
        }
        UiSessionConfigurationEntity uiSessionConfigurationEntity2 = uiSessionConfigurationEntity;
        if ((i2 & 32) != 0) {
            userPriceEntity = sessionConfigurationEntity.userPriceEntity;
        }
        return sessionConfigurationEntity.copy(i, str2, list3, list4, uiSessionConfigurationEntity2, userPriceEntity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSessionTokenTtl() {
        return this.sessionTokenTtl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final List<CheckTypeEntity> component4() {
        return this.checks;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final UiSessionConfigurationEntity getUiSessionConfiguration() {
        return this.uiSessionConfiguration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final UserPriceEntity getUserPriceEntity() {
        return this.userPriceEntity;
    }

    public final SessionConfigurationEntity copy(int sessionTokenTtl, String sessionId, List<? extends ResourceConfigurationEntity> _steps, List<? extends CheckTypeEntity> checks, UiSessionConfigurationEntity uiSessionConfiguration, UserPriceEntity userPriceEntity) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(_steps, "_steps");
        Intrinsics.checkNotNullParameter(checks, "checks");
        Intrinsics.checkNotNullParameter(uiSessionConfiguration, "uiSessionConfiguration");
        return new SessionConfigurationEntity(sessionTokenTtl, sessionId, _steps, checks, uiSessionConfiguration, userPriceEntity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionConfigurationEntity)) {
            return false;
        }
        SessionConfigurationEntity sessionConfigurationEntity = (SessionConfigurationEntity) other;
        return this.sessionTokenTtl == sessionConfigurationEntity.sessionTokenTtl && Intrinsics.areEqual(this.sessionId, sessionConfigurationEntity.sessionId) && Intrinsics.areEqual(this._steps, sessionConfigurationEntity._steps) && Intrinsics.areEqual(this.checks, sessionConfigurationEntity.checks) && Intrinsics.areEqual(this.uiSessionConfiguration, sessionConfigurationEntity.uiSessionConfiguration) && Intrinsics.areEqual(this.userPriceEntity, sessionConfigurationEntity.userPriceEntity);
    }

    public final List<CheckTypeEntity> getChecks() {
        return this.checks;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getSessionTokenTtl() {
        return this.sessionTokenTtl;
    }

    public final List<ResourceConfigurationEntity> getSteps() {
        return this.steps;
    }

    public final UiSessionConfigurationEntity getUiSessionConfiguration() {
        return this.uiSessionConfiguration;
    }

    public final UserPriceEntity getUserPriceEntity() {
        return this.userPriceEntity;
    }

    public int hashCode() {
        int iHashCode = ((((((((Integer.hashCode(this.sessionTokenTtl) * 31) + this.sessionId.hashCode()) * 31) + this._steps.hashCode()) * 31) + this.checks.hashCode()) * 31) + this.uiSessionConfiguration.hashCode()) * 31;
        UserPriceEntity userPriceEntity = this.userPriceEntity;
        return iHashCode + (userPriceEntity == null ? 0 : userPriceEntity.hashCode());
    }

    public final boolean isSessionCompleted() {
        List<ResourceConfigurationEntity> list = this.steps;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (!((ResourceConfigurationEntity) it2.next()).isCompleted()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean shouldPerformDocumentSchemeValidityCheck() {
        return this.checks.contains(CheckTypeEntity.DOCUMENT_SCHEME_VALIDITY_CHECK);
    }

    public final boolean shouldPerformIbvVisualReviewCheck() {
        return this.checks.contains(CheckTypeEntity.IBV_VISUAL_REVIEW_CHECK);
    }

    public final boolean shouldShowIdentityCheck(ResourceConfigurationEntity step) {
        Intrinsics.checkNotNullParameter(step, "step");
        if (this.checks.contains(CheckTypeEntity.THIRD_PARTY_IDENTITY)) {
            for (Object obj : this.steps) {
                if (((ResourceConfigurationEntity) obj) instanceof DocumentResourceConfigEntity) {
                    if (Intrinsics.areEqual(obj, step)) {
                        return true;
                    }
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        return false;
    }

    public String toString() {
        return "SessionConfigurationEntity(sessionTokenTtl=" + this.sessionTokenTtl + ", sessionId=" + this.sessionId + ", _steps=" + this._steps + ", checks=" + this.checks + ", uiSessionConfiguration=" + this.uiSessionConfiguration + ", userPriceEntity=" + this.userPriceEntity + ')';
    }
}
