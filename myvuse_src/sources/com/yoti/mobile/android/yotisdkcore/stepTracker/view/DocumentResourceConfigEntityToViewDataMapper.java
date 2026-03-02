package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import com.google.android.material.timepicker.TimeModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoti.mobile.android.common.p049ui.components.utils.Demonym;
import com.yoti.mobile.android.common.p049ui.components.utils.IDemonymProvider;
import com.yoti.mobile.android.commonui.UiSessionConfiguration;
import com.yoti.mobile.android.remote.model.Session;
import com.yoti.mobile.android.yotisdkcore.C4957R;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.core.p085di.YdsDemonymProvider;
import com.yoti.mobile.android.yotisdkcore.core.view.CaptureObjectiveTypeViewData;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.view.ObjectiveEntityToViewDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.DocumentCaptureProperties;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.UiSessionProperties;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J.\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/DocumentResourceConfigEntityToViewDataMapper;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/ResourceConfigEntityToViewDataMapper;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "documentTypeEntityToViewDataMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeEntityToViewDataMapper;", "objectiveTypeToViewDataMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/view/ObjectiveEntityToViewDataMapper;", "documentCaptureStepEnumerator", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/DocumentCaptureStepEnumerator;", "demonymProvider", "Lcom/yoti/mobile/android/common/ui/components/utils/IDemonymProvider;", "session", "Lcom/yoti/mobile/android/remote/model/Session;", "captureProperties", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/DocumentCaptureProperties;", "uiSessionProperties", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/UiSessionProperties;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeEntityToViewDataMapper;Lcom/yoti/mobile/android/yotisdkcore/core/view/ObjectiveEntityToViewDataMapper;Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/DocumentCaptureStepEnumerator;Lcom/yoti/mobile/android/common/ui/components/utils/IDemonymProvider;Lcom/yoti/mobile/android/remote/model/Session;Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/DocumentCaptureProperties;Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/UiSessionProperties;)V", "mapResource", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/Step;", "resources", "", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/ResourceConfigurationEntity;", "resource", FirebaseAnalytics.Param.INDEX, "", "uiSessionConfiguration", "Lcom/yoti/mobile/android/commonui/UiSessionConfiguration;", "mapStepComposition", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/IStepComposition;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentResourceConfigEntityToViewDataMapper extends ResourceConfigEntityToViewDataMapper<DocumentResourceConfigEntity> {

    /* JADX INFO: renamed from: a */
    private final DocumentTypeEntityToViewDataMapper f7788a;

    /* JADX INFO: renamed from: b */
    private final ObjectiveEntityToViewDataMapper f7789b;

    /* JADX INFO: renamed from: c */
    private final DocumentCaptureStepEnumerator f7790c;

    /* JADX INFO: renamed from: d */
    private final IDemonymProvider f7791d;

    /* JADX INFO: renamed from: e */
    private final Session f7792e;

    /* JADX INFO: renamed from: f */
    private final DocumentCaptureProperties f7793f;

    /* JADX INFO: renamed from: g */
    private final UiSessionProperties f7794g;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.b$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f7795a;

        static {
            int[] iArr = new int[DocumentResourceConfigEntity.DocumentCaptureTypeEntity.values().length];
            iArr[DocumentResourceConfigEntity.DocumentCaptureTypeEntity.ID_DOCUMENT.ordinal()] = 1;
            iArr[DocumentResourceConfigEntity.DocumentCaptureTypeEntity.SUPPLEMENTARY_DOCUMENT.ordinal()] = 2;
            f7795a = iArr;
        }
    }

    @Inject
    public DocumentResourceConfigEntityToViewDataMapper(DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper, ObjectiveEntityToViewDataMapper objectiveTypeToViewDataMapper, DocumentCaptureStepEnumerator documentCaptureStepEnumerator, @YdsDemonymProvider IDemonymProvider demonymProvider, Session session, DocumentCaptureProperties captureProperties, UiSessionProperties uiSessionProperties) {
        Intrinsics.checkNotNullParameter(documentTypeEntityToViewDataMapper, "documentTypeEntityToViewDataMapper");
        Intrinsics.checkNotNullParameter(objectiveTypeToViewDataMapper, "objectiveTypeToViewDataMapper");
        Intrinsics.checkNotNullParameter(documentCaptureStepEnumerator, "documentCaptureStepEnumerator");
        Intrinsics.checkNotNullParameter(demonymProvider, "demonymProvider");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(captureProperties, "captureProperties");
        Intrinsics.checkNotNullParameter(uiSessionProperties, "uiSessionProperties");
        this.f7788a = documentTypeEntityToViewDataMapper;
        this.f7789b = objectiveTypeToViewDataMapper;
        this.f7790c = documentCaptureStepEnumerator;
        this.f7791d = demonymProvider;
        this.f7792e = session;
        this.f7793f = captureProperties;
        this.f7794g = uiSessionProperties;
    }

    /* JADX INFO: renamed from: a */
    private final IStepComposition m5227a(DocumentResourceConfigEntity documentResourceConfigEntity, List<? extends ResourceConfigurationEntity> list) {
        String iso3Code;
        Demonym demonym;
        DocumentTypeViewData map = this.f7788a.map(documentResourceConfigEntity.getDocument().getDocumentType());
        DocumentCaptureStepEnumerator documentCaptureStepEnumerator = this.f7790c;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof DocumentResourceConfigEntity) {
                arrayList.add(obj);
            }
        }
        Integer numM5226b = documentCaptureStepEnumerator.m5226b(arrayList, documentResourceConfigEntity);
        int i = a.f7795a[documentResourceConfigEntity.getType().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return new SupplementaryDocumentStepComposition(map, numM5226b);
            }
            throw new NoWhenBranchMatchedException();
        }
        DocumentResourceConfigEntity.CountryEntity country = documentResourceConfigEntity.getCountry();
        String name = null;
        String iso3Code2 = country != null ? country.getIso3Code() : null;
        DocumentResourceConfigEntity.CountryEntity country2 = documentResourceConfigEntity.getCountry();
        if (country2 != null && (iso3Code = country2.getIso3Code()) != null && (demonym = this.f7791d.getDemonym(iso3Code)) != null) {
            name = demonym.getName();
        }
        return new IdDocumentStepComposition(iso3Code2, name, map, numM5226b);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.view.ResourceConfigEntityToViewDataMapper
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ Step mo5228a(List list, ResourceConfigurationEntity resourceConfigurationEntity, int i, UiSessionConfiguration uiSessionConfiguration) {
        return m5229a((List<? extends ResourceConfigurationEntity>) list, (DocumentResourceConfigEntity) resourceConfigurationEntity, i, uiSessionConfiguration);
    }

    /* JADX INFO: renamed from: a */
    protected Step m5229a(List<? extends ResourceConfigurationEntity> resources, DocumentResourceConfigEntity resource, int i, UiSessionConfiguration uiSessionConfiguration) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(uiSessionConfiguration, "uiSessionConfiguration");
        DocumentCaptureConfiguration documentCaptureConfiguration = new DocumentCaptureConfiguration(uiSessionConfiguration, this.f7792e, resource.getRequirementId(), resources.size() == 1, resource.getSubType() == DocumentResourceConfigEntity.DocumentCaptureSubTypeEntity.SELECTABLE_DOCUMENT, this.f7793f.isSupplementaryDocumentUploadAllowed(), this.f7794g.isMoreAboutVerificationEnabled(), resource.getIsValidationAndGuidanceEnabled(), this.f7794g.isDoNotHaveDocumentOptionEnabled());
        CaptureObjectiveTypeViewData map = this.f7789b.map(resource.getObjective());
        IStepComposition iStepCompositionM5227a = m5227a(resource, resources);
        String str = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i + 1)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return new Step(new SignpostStep(iStepCompositionM5227a, str, CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(map.getStepTrackerMessage()), Integer.valueOf(C4957R.string.f7539x5a7eed1a)})), documentCaptureConfiguration, map, resource.getFeature().getLauncher(), resource.shouldRefreshConfigurationAfterComplete(resources), resource.isCompleted());
    }
}
