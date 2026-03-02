package com.yoti.mobile.android.documentcapture.p055id.view.scan.automation;

import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.p055id.databinding.YdsFragmentAutomationDocumentScanOverlayBinding;
import com.yoti.mobile.android.documentcapture.p055id.p056di.IdDocumentCaptureSession;
import com.yoti.mobile.android.documentscan.domain.transformer.ImageFormat;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedConfig;
import com.yoti.mobile.android.documentscan.model.result.MetaData;
import com.yoti.mobile.android.documentscan.ui.IScanDocument;
import com.yoti.mobile.android.documentscan.ui.ScanMultiSideDocumentListener;
import com.yoti.mobile.android.yotidocs.common.file.AssetToFileConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u0005¢\u0006\u0002\u0010\u0003J6\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u001fH\u0002J\u0010\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020%2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020%2\u0006\u00104\u001a\u0002052\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00106\u001a\u00020%H\u0002J\f\u00107\u001a\u00020**\u00020\u001aH\u0002J\f\u00108\u001a\u00020'*\u00020\u001aH\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/automation/AutomationScanFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/yoti/mobile/android/documentscan/ui/IScanDocument;", "()V", "assetToFileConverter", "Lcom/yoti/mobile/android/yotidocs/common/file/AssetToFileConverter;", "getAssetToFileConverter", "()Lcom/yoti/mobile/android/yotidocs/common/file/AssetToFileConverter;", "setAssetToFileConverter", "(Lcom/yoti/mobile/android/yotidocs/common/file/AssetToFileConverter;)V", "binding", "Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsFragmentAutomationDocumentScanOverlayBinding;", "getBinding", "()Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsFragmentAutomationDocumentScanOverlayBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "captureBack", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "captureFront", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "getListener", "()Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "setListener", "(Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;)V", "scanConfig", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "scanResults", "", "compoundScanResult", "mainImage", "", "holograms", "", "croppedDocumentImage", "croppedFaceImage", "configureTitle", "", "side", "", "documentPageReviewed", "approved", "", "getFilePath", "assetName", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "processCapture", "isSingleSide", "sides", "Companion", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AutomationScanFragment extends Fragment implements IScanDocument, TraceFieldInterface {
    private static final String ARG_PARAM_SCAN_CONFIGURATION = "ARG_PARAM_SCAN_CONFIGURATION";
    public Trace _nr_trace;

    @Inject
    public AssetToFileConverter assetToFileConverter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;
    private DocumentCaptureResult captureBack;
    private DocumentCaptureResult captureFront;
    private ScanMultiSideDocumentListener listener;
    private DocumentScanDetailedConfig scanConfig;
    private final List<DocumentCaptureResult> scanResults;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AutomationScanFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsFragmentAutomationDocumentScanOverlayBinding;", 0))};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/automation/AutomationScanFragment$Companion;", "", "()V", "ARG_PARAM_SCAN_CONFIGURATION", "", "getInstance", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/automation/AutomationScanFragment;", "scanConfig", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AutomationScanFragment getInstance(DocumentScanDetailedConfig scanConfig) {
            Intrinsics.checkNotNullParameter(scanConfig, "scanConfig");
            AutomationScanFragment automationScanFragment = new AutomationScanFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_PARAM_SCAN_CONFIGURATION", scanConfig);
            automationScanFragment.setArguments(bundle);
            return automationScanFragment;
        }
    }

    public AutomationScanFragment() {
        super(C4608R.layout.yds_fragment_automation_document_scan_overlay);
        this.scanResults = new ArrayList();
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentAutomationDocumentScanOverlayBinding>() { // from class: com.yoti.mobile.android.documentcapture.id.view.scan.automation.AutomationScanFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentAutomationDocumentScanOverlayBinding invoke() {
                return YdsFragmentAutomationDocumentScanOverlayBinding.bind(this.this$0.requireView());
            }
        });
    }

    private final DocumentCaptureResult compoundScanResult(String mainImage, List<String> holograms, String croppedDocumentImage, String croppedFaceImage) {
        String filePath = getFilePath(mainImage);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(holograms, 10));
        Iterator<T> it2 = holograms.iterator();
        while (it2.hasNext()) {
            arrayList.add(getFilePath((String) it2.next()));
        }
        return new DocumentCaptureResult(null, new MetaData(filePath, arrayList, new RectF(36.0f, 333.0f, 1044.0f, 968.6523f), croppedDocumentImage != null ? getFilePath(croppedDocumentImage) : null, croppedFaceImage != null ? getFilePath(croppedFaceImage) : null, ImageFormat.JPEG), null, null, null);
    }

    static /* synthetic */ DocumentCaptureResult compoundScanResult$default(AutomationScanFragment automationScanFragment, String str, List list, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return automationScanFragment.compoundScanResult(str, list, str2, str3);
    }

    private final void configureTitle(int side) {
        int i;
        if (side == 1) {
            DocumentScanDetailedConfig documentScanDetailedConfig = this.scanConfig;
            if (documentScanDetailedConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
                documentScanDetailedConfig = null;
            }
            i = sides(documentScanDetailedConfig) == side ? C4608R.string.yds_automation_scan_text_single_sided : C4608R.string.yds_automation_scan_text_double_sided_side1;
        } else {
            i = C4608R.string.yds_automation_scan_text_double_sided_side2;
        }
        getBinding().scanTextSubTitle.setText(i);
    }

    private final YdsFragmentAutomationDocumentScanOverlayBinding getBinding() {
        return (YdsFragmentAutomationDocumentScanOverlayBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final String getFilePath(String assetName) {
        String absolutePath = AssetToFileConverter.getFile$default(getAssetToFileConverter(), assetName, false, 2, null).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "assetToFileConverter.get…e(assetName).absolutePath");
        return absolutePath;
    }

    private final boolean isSingleSide(DocumentScanDetailedConfig documentScanDetailedConfig) {
        return sides(documentScanDetailedConfig) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-1, reason: not valid java name */
    public static final void m6820onViewCreated$lambda1(AutomationScanFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.processCapture();
    }

    private final void processCapture() {
        if (this.scanResults.size() != 0) {
            this.captureBack = compoundScanResult$default(this, "frame0.jpeg", CollectionsKt.listOf((Object[]) new String[]{"sample0-0.jpeg", "sample0-1.jpeg"}), null, null, 12, null);
            ScanMultiSideDocumentListener listener = getF7137b();
            if (listener != null) {
                DocumentCaptureResult documentCaptureResult = this.captureBack;
                Intrinsics.checkNotNull(documentCaptureResult);
                listener.onBackSideScanned(documentCaptureResult);
                return;
            }
            return;
        }
        this.captureFront = compoundScanResult("frame0.jpeg", CollectionsKt.listOf((Object[]) new String[]{"sample0-0.jpeg", "sample0-1.jpeg"}), "document0.jpeg", "face0.jpeg");
        ScanMultiSideDocumentListener listener2 = getF7137b();
        if (listener2 != null) {
            DocumentCaptureResult documentCaptureResult2 = this.captureFront;
            if (documentCaptureResult2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("captureFront");
                documentCaptureResult2 = null;
            }
            listener2.onFrontSideScanned(documentCaptureResult2);
        }
    }

    private final int sides(DocumentScanDetailedConfig documentScanDetailedConfig) {
        return documentScanDetailedConfig.getPageConfigs().size();
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    public void documentPageReviewed(boolean approved) {
        DocumentScanDetailedConfig documentScanDetailedConfig = null;
        DocumentCaptureResult documentCaptureResult = null;
        if (approved) {
            if (this.scanResults.size() == 0) {
                List<DocumentCaptureResult> list = this.scanResults;
                DocumentCaptureResult documentCaptureResult2 = this.captureFront;
                if (documentCaptureResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("captureFront");
                    documentCaptureResult2 = null;
                }
                list.add(documentCaptureResult2);
            } else {
                List<DocumentCaptureResult> list2 = this.scanResults;
                DocumentCaptureResult documentCaptureResult3 = this.captureBack;
                Intrinsics.checkNotNull(documentCaptureResult3);
                list2.add(documentCaptureResult3);
            }
        }
        int size = this.scanResults.size();
        DocumentScanDetailedConfig documentScanDetailedConfig2 = this.scanConfig;
        if (documentScanDetailedConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
            documentScanDetailedConfig2 = null;
        }
        if (size == sides(documentScanDetailedConfig2)) {
            ScanMultiSideDocumentListener listener = getF7137b();
            if (listener != null) {
                DocumentCaptureResult documentCaptureResult4 = this.captureFront;
                if (documentCaptureResult4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("captureFront");
                } else {
                    documentCaptureResult = documentCaptureResult4;
                }
                listener.onScanCompleted(documentCaptureResult, this.captureBack);
                return;
            }
            return;
        }
        if (approved) {
            DocumentScanDetailedConfig documentScanDetailedConfig3 = this.scanConfig;
            if (documentScanDetailedConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
            } else {
                documentScanDetailedConfig = documentScanDetailedConfig3;
            }
            if (isSingleSide(documentScanDetailedConfig)) {
                return;
            }
            configureTitle(2);
        }
    }

    public final AssetToFileConverter getAssetToFileConverter() {
        AssetToFileConverter assetToFileConverter = this.assetToFileConverter;
        if (assetToFileConverter != null) {
            return assetToFileConverter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("assetToFileConverter");
        return null;
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    /* JADX INFO: renamed from: getListener, reason: from getter */
    public ScanMultiSideDocumentListener getF7137b() {
        return this.listener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IdDocumentCaptureSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        TraceMachine.startTracing("AutomationScanFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "AutomationScanFragment#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "AutomationScanFragment#onCreate", null);
        }
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Parcelable parcelable = arguments.getParcelable("ARG_PARAM_SCAN_CONFIGURATION");
            Intrinsics.checkNotNull(parcelable);
            this.scanConfig = (DocumentScanDetailedConfig) parcelable;
        }
        TraceMachine.exitMethod();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().manualCaptureBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.id.view.scan.automation.AutomationScanFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AutomationScanFragment.m6820onViewCreated$lambda1(this.f$0, view2);
            }
        });
        configureTitle(1);
    }

    public final void setAssetToFileConverter(AssetToFileConverter assetToFileConverter) {
        Intrinsics.checkNotNullParameter(assetToFileConverter, "<set-?>");
        this.assetToFileConverter = assetToFileConverter;
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    public void setListener(ScanMultiSideDocumentListener scanMultiSideDocumentListener) {
        this.listener = scanMultiSideDocumentListener;
    }
}
