package com.yoti.mobile.android.commonui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.C2309R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import io.branch.rnbranch.RNBranchModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YotiBottomSheetDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/YotiBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "theme", "", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/content/Context;ILandroid/view/ViewGroup$LayoutParams;)V", "getParams", "()Landroid/view/ViewGroup$LayoutParams;", "setContentView", "", "view", "Landroid/view/View;", "Companion", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class YotiBottomSheetDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ViewGroup.LayoutParams params;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ YotiBottomSheetDialog(Context context, int i, ViewGroup.LayoutParams layoutParams, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 4) != 0) {
            Companion companion = INSTANCE;
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            layoutParams = companion.getDefaultBottomSheetLayoutParams(resources);
        }
        this(context, i, layoutParams);
    }

    public final ViewGroup.LayoutParams getParams() {
        return this.params;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiBottomSheetDialog(Context context, int i, ViewGroup.LayoutParams layoutParams) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.params = layoutParams;
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.yoti.mobile.android.commonui.YotiBottomSheetDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                YotiBottomSheetDialog.m6791_init_$lambda2(this.f$0, dialogInterface);
            }
        });
        setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: _init_$lambda-2, reason: not valid java name */
    public static final void m6791_init_$lambda2(YotiBottomSheetDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout frameLayout = (FrameLayout) this$0.findViewById(C2309R.id.design_bottom_sheet);
        if (frameLayout != null) {
            BottomSheetBehavior.from(frameLayout).setState(3);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setContentView(view, this.params);
    }

    /* JADX INFO: compiled from: YotiBottomSheetDialog.kt */
    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\f\u0010\u0007\u001a\u00020\b*\u00020\bH\u0002¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/YotiBottomSheetDialog$Companion;", "", "()V", "getDefaultBottomSheetLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "resources", "Landroid/content/res/Resources;", "toPx", "", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewGroup.LayoutParams getDefaultBottomSheetLayoutParams(Resources resources) {
            Intrinsics.checkNotNullParameter(resources, "resources");
            return new ViewGroup.LayoutParams(-1, resources.getDisplayMetrics().heightPixels - toPx(resources.getDimensionPixelSize(C4590R.dimen.yds_bottom_sheet_top_margin)));
        }

        private final int toPx(int i) {
            return (int) (i * Resources.getSystem().getDisplayMetrics().density);
        }
    }
}
