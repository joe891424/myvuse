package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentscan.ui.IScanView;
import com.yoti.mobile.android.documentscan.ui.IScanViewConfiguration;
import com.yoti.mobile.android.documentscan.ui.helpers.scan.DocumentScanOverlayView;
import com.yoti.mobile.android.documentscan.ui.helpers.scan.RoundedCornerRectangleFrameShape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J&\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\"H\u0016J\b\u0010#\u001a\u00020\u001aH\u0016J\b\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u001aH\u0014J\b\u0010&\u001a\u00020\u001aH\u0016J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u0006-"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/OverlayScanView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/yoti/mobile/android/documentscan/ui/IScanView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnManualCapture", "Landroid/view/View;", "logo", "Landroid/widget/ImageView;", "scanArea", "Landroid/graphics/RectF;", "getScanArea", "()Landroid/graphics/RectF;", "scanOverlay", "Lcom/yoti/mobile/android/documentscan/ui/helpers/scan/DocumentScanOverlayView;", "scanTextSubTitle", "Landroid/widget/TextView;", "scanTextTitle", "viewConfiguration", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "bindViews", "", "displayDocumentDetected", "displayErrorState", "displayManualCaptureMode", "pageNumber", "hasCaptureTimedOut", "", "manualCaptureBehavior", "Lkotlin/Function0;", "hideDocumentDetected", "initScanOverlay", "onFinishInflate", "reset", "setupView", "viewConfig", "Lcom/yoti/mobile/android/documentscan/ui/IScanViewConfiguration;", "updateForPage", "documentConfigKey", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class OverlayScanView extends ConstraintLayout implements IScanView {
    private View btnManualCapture;
    private ImageView logo;
    private DocumentScanOverlayView scanOverlay;
    private TextView scanTextSubTitle;
    private TextView scanTextTitle;
    private IdScanConfigurationViewData viewConfiguration;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OverlayScanView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OverlayScanView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ OverlayScanView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void bindViews() {
        View viewFindViewById = findViewById(C4608R.id.scanOverlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.scanOverlay)");
        this.scanOverlay = (DocumentScanOverlayView) viewFindViewById;
        View viewFindViewById2 = findViewById(C4608R.id.manualCaptureBtn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.manualCaptureBtn)");
        this.btnManualCapture = viewFindViewById2;
        View viewFindViewById3 = findViewById(C4608R.id.scanTextTitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.scanTextTitle)");
        this.scanTextTitle = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(C4608R.id.scanTextSubTitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(R.id.scanTextSubTitle)");
        this.scanTextSubTitle = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(C4608R.id.logo);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(R.id.logo)");
        this.logo = (ImageView) viewFindViewById5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: displayManualCaptureMode$lambda-3, reason: not valid java name */
    public static final void m6819displayManualCaptureMode$lambda3(Function0 manualCaptureBehavior, View view) {
        Intrinsics.checkNotNullParameter(manualCaptureBehavior, "$manualCaptureBehavior");
        manualCaptureBehavior.invoke();
    }

    private final void initScanOverlay() {
        DocumentScanOverlayView documentScanOverlayView = this.scanOverlay;
        if (documentScanOverlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanOverlay");
            documentScanOverlayView = null;
        }
        documentScanOverlayView.setScanFrameMargins(documentScanOverlayView.getResources().getDimension(C4608R.dimen.yds_document_reader_scan_vertical_margin_top), documentScanOverlayView.getResources().getDimension(C4608R.dimen.yds_document_reader_scan_vertical_margin_bottom), documentScanOverlayView.getResources().getDimension(C4608R.dimen.yds_document_reader_scan_horizontal_margin));
        Context context = documentScanOverlayView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        documentScanOverlayView.setScanFrameShape(new RoundedCornerRectangleFrameShape(context));
        documentScanOverlayView.setBackground(Integer.valueOf(C4608R.attr.background_overlay_scan));
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanView
    public void displayDocumentDetected() {
        DocumentScanOverlayView documentScanOverlayView = this.scanOverlay;
        if (documentScanOverlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanOverlay");
            documentScanOverlayView = null;
        }
        documentScanOverlayView.setActive(true);
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanView
    public void displayErrorState() {
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanView
    public void displayManualCaptureMode(int pageNumber, boolean hasCaptureTimedOut, final Function0<Unit> manualCaptureBehavior) {
        Intrinsics.checkNotNullParameter(manualCaptureBehavior, "manualCaptureBehavior");
        IdScanConfigurationViewData idScanConfigurationViewData = this.viewConfiguration;
        View view = null;
        if (idScanConfigurationViewData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewConfiguration");
            idScanConfigurationViewData = null;
        }
        if (hasCaptureTimedOut) {
            TextView textView = this.scanTextTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanTextTitle");
                textView = null;
            }
            textView.setText(idScanConfigurationViewData.getScanTimedOutTitle());
            TextView textView2 = this.scanTextSubTitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanTextSubTitle");
                textView2 = null;
            }
            textView2.setText(idScanConfigurationViewData.getScanTimedOutSubtitle());
        } else {
            TextView textView3 = this.scanTextTitle;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanTextTitle");
                textView3 = null;
            }
            IdScanConfigurationViewData idScanConfigurationViewData2 = this.viewConfiguration;
            if (idScanConfigurationViewData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewConfiguration");
                idScanConfigurationViewData2 = null;
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            textView3.setText(idScanConfigurationViewData2.getManualCaptureTitle(context, pageNumber));
            TextView textView4 = this.scanTextSubTitle;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanTextSubTitle");
                textView4 = null;
            }
            textView4.setText(idScanConfigurationViewData.getManualCaptureSubtitle());
        }
        View view2 = this.btnManualCapture;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnManualCapture");
            view2 = null;
        }
        view2.setVisibility(0);
        View view3 = this.btnManualCapture;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnManualCapture");
        } else {
            view = view3;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.id.view.scan.OverlayScanView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                OverlayScanView.m6819displayManualCaptureMode$lambda3(manualCaptureBehavior, view4);
            }
        });
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanView
    public RectF getScanArea() {
        DocumentScanOverlayView documentScanOverlayView = this.scanOverlay;
        if (documentScanOverlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanOverlay");
            documentScanOverlayView = null;
        }
        RectF scanWindowPosition = documentScanOverlayView.getScanWindowPosition();
        Intrinsics.checkNotNullExpressionValue(scanWindowPosition, "scanOverlay.scanWindowPosition");
        return scanWindowPosition;
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanView
    public void hideDocumentDetected() {
        DocumentScanOverlayView documentScanOverlayView = this.scanOverlay;
        if (documentScanOverlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanOverlay");
            documentScanOverlayView = null;
        }
        documentScanOverlayView.setActive(false);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bindViews();
        initScanOverlay();
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanView
    public void reset() {
        View view = this.btnManualCapture;
        DocumentScanOverlayView documentScanOverlayView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnManualCapture");
            view = null;
        }
        view.setVisibility(8);
        DocumentScanOverlayView documentScanOverlayView2 = this.scanOverlay;
        if (documentScanOverlayView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanOverlay");
        } else {
            documentScanOverlayView = documentScanOverlayView2;
        }
        documentScanOverlayView.setActive(false);
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanView
    public void setupView(IScanViewConfiguration viewConfig) {
        Intrinsics.checkNotNullParameter(viewConfig, "viewConfig");
        ImageView imageView = null;
        IdScanConfigurationViewData idScanConfigurationViewData = viewConfig instanceof IdScanConfigurationViewData ? (IdScanConfigurationViewData) viewConfig : null;
        if (idScanConfigurationViewData != null) {
            this.viewConfiguration = idScanConfigurationViewData;
        }
        DocumentScanOverlayView documentScanOverlayView = this.scanOverlay;
        if (documentScanOverlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanOverlay");
            documentScanOverlayView = null;
        }
        documentScanOverlayView.setDocumentRatio(viewConfig.getF6988a());
        IdScanConfigurationViewData idScanConfigurationViewData2 = this.viewConfiguration;
        if (idScanConfigurationViewData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewConfiguration");
            idScanConfigurationViewData2 = null;
        }
        Integer logo = idScanConfigurationViewData2.getLogo();
        if (logo != null) {
            int iIntValue = logo.intValue();
            ImageView imageView2 = this.logo;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logo");
            } else {
                imageView = imageView2;
            }
            imageView.setImageResource(iIntValue);
        }
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanView
    public void updateForPage(int pageNumber, String documentConfigKey) {
        Intrinsics.checkNotNullParameter(documentConfigKey, "documentConfigKey");
        IdScanConfigurationViewData idScanConfigurationViewData = this.viewConfiguration;
        TextView textView = null;
        if (idScanConfigurationViewData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewConfiguration");
            idScanConfigurationViewData = null;
        }
        TextView textView2 = this.scanTextTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTextTitle");
            textView2 = null;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView2.setText(idScanConfigurationViewData.getScanTitle(context, pageNumber));
        TextView textView3 = this.scanTextSubTitle;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTextSubTitle");
        } else {
            textView = textView3;
        }
        textView.setText(idScanConfigurationViewData.getScanSubTitle());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayScanView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
