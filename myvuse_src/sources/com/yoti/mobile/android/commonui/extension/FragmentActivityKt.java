package com.yoti.mobile.android.commonui.extension;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FragmentActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\u0012\u0010\t\u001a\u00020\u0007*\u00020\b2\u0006\u0010\n\u001a\u00020\u0001\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\b\u001aB\u0010\r\u001a\u0002H\u000e\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u000f*\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0014H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, m5598d2 = {"RESULT_CLOSE_YOTIDOCSDK", "", "getRESULT_CLOSE_YOTIDOCSDK", "()I", "RESULT_FLOW_CANCELED", "getRESULT_FLOW_CANCELED", "closeYotiDocSDK", "", "Landroidx/fragment/app/FragmentActivity;", "finishWithResult", "resultCode", "getDisplayMetrics", "Landroid/util/DisplayMetrics;", "viewModel", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/fragment/app/FragmentActivity;Landroidx/lifecycle/ViewModelProvider$Factory;Lkotlin/jvm/functions/Function1;)Landroidx/lifecycle/ViewModel;", "commonUI_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FragmentActivityKt {
    private static final int RESULT_CLOSE_YOTIDOCSDK = 2;
    private static final int RESULT_FLOW_CANCELED = 3;

    public static final int getRESULT_CLOSE_YOTIDOCSDK() {
        return RESULT_CLOSE_YOTIDOCSDK;
    }

    public static final int getRESULT_FLOW_CANCELED() {
        return RESULT_FLOW_CANCELED;
    }

    public static final void finishWithResult(FragmentActivity fragmentActivity, int i) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        fragmentActivity.setResult(i);
        fragmentActivity.finish();
    }

    public static final void closeYotiDocSDK(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        finishWithResult(fragmentActivity, RESULT_CLOSE_YOTIDOCSDK);
    }

    public static final /* synthetic */ <T extends ViewModel> T viewModel(FragmentActivity fragmentActivity, ViewModelProvider.Factory factory, Function1<? super T, Unit> body) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(body, "body");
        ViewModelProvider viewModelProvider = new ViewModelProvider(fragmentActivity, factory);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ViewModel viewModel = viewModelProvider.get(ViewModel.class);
        body.invoke(viewModel);
        return viewModel;
    }

    public static final DisplayMetrics getDisplayMetrics(FragmentActivity fragmentActivity) {
        Display defaultDisplay;
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = fragmentActivity.getWindowManager();
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics;
    }
}
