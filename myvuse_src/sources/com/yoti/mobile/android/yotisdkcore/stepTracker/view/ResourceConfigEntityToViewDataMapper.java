package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoti.mobile.android.commonui.UiSessionConfiguration;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.C4957R;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.h, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J3\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H$¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/ResourceConfigEntityToViewDataMapper;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/ResourceConfigurationEntity;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/ResourceConfigEntityToViewDataMapper$MapperParams;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/Step;", "()V", "map", "from", "mapResource", "resources", "", "resource", FirebaseAnalytics.Param.INDEX, "", "uiSessionConfiguration", "Lcom/yoti/mobile/android/commonui/UiSessionConfiguration;", "(Ljava/util/List;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/ResourceConfigurationEntity;ILcom/yoti/mobile/android/commonui/UiSessionConfiguration;)Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/Step;", "MapperParams", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class ResourceConfigEntityToViewDataMapper<T extends ResourceConfigurationEntity> implements Mapper<a<T>, Step> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.h$a */
    @Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\r\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\bJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0005\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/ResourceConfigEntityToViewDataMapper$MapperParams;", ExifInterface.GPS_DIRECTION_TRUE, "", "sessionConfigurationEntity", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity;", "resource", "(Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity;Ljava/lang/Object;)V", "getResource", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSessionConfigurationEntity", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity;", "component1", "component2", "copy", "(Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity;Ljava/lang/Object;)Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/ResourceConfigEntityToViewDataMapper$MapperParams;", "equals", "", "other", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class a<T> {

        /* JADX INFO: renamed from: a */
        private final SessionConfigurationEntity f7816a;

        /* JADX INFO: renamed from: b */
        private final T f7817b;

        public a(SessionConfigurationEntity sessionConfigurationEntity, T t) {
            Intrinsics.checkNotNullParameter(sessionConfigurationEntity, "sessionConfigurationEntity");
            this.f7816a = sessionConfigurationEntity;
            this.f7817b = t;
        }

        /* JADX INFO: renamed from: a */
        public final T m5258a() {
            return this.f7817b;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final SessionConfigurationEntity getF7816a() {
            return this.f7816a;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return Intrinsics.areEqual(this.f7816a, aVar.f7816a) && Intrinsics.areEqual(this.f7817b, aVar.f7817b);
        }

        public int hashCode() {
            int iHashCode = this.f7816a.hashCode() * 31;
            T t = this.f7817b;
            return iHashCode + (t == null ? 0 : t.hashCode());
        }

        public String toString() {
            return "MapperParams(sessionConfigurationEntity=" + this.f7816a + ", resource=" + this.f7817b + ')';
        }
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Step map(a<T> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        T tM5258a = from.m5258a();
        return mo5228a(from.getF7816a().getSteps(), tM5258a, from.getF7816a().getSteps().indexOf(tM5258a), new UiSessionConfiguration(from.getF7816a().getUiSessionConfiguration().getHideLogo() ? null : Integer.valueOf(C4957R.drawable.yds_ic_powered_by), from.getF7816a().getUiSessionConfiguration().getPrivacyPolicyUrl(), from.getF7816a().shouldShowIdentityCheck(tM5258a)));
    }

    /* JADX INFO: renamed from: a */
    protected abstract Step mo5228a(List<? extends ResourceConfigurationEntity> list, T t, int i, UiSessionConfiguration uiSessionConfiguration);
}
