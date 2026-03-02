package com.yoti.mobile.android.commonui;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCaller;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GuidelinesFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0014¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/NestedGuidelinesFragment;", "Lcom/yoti/mobile/android/commonui/GuidelinesFragment;", "()V", "navigateBack", "", "onAttach", "context", "Landroid/content/Context;", "onPrimaryButtonClick", "Companion", "Listener", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NestedGuidelinesFragment extends GuidelinesFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: GuidelinesFragment.kt */
    @Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/NestedGuidelinesFragment$Listener;", "", "onNavigateBack", "", "onPrimaryButtonClick", "", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public interface Listener {

        /* JADX INFO: compiled from: GuidelinesFragment.kt */
        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class DefaultImpls {
            public static boolean onNavigateBack(Listener listener) {
                return false;
            }
        }

        boolean onNavigateBack();

        void onPrimaryButtonClick();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(getParentFragment() instanceof Listener)) {
            throw new IllegalArgumentException("Parent Fragment does not implement the Listener interface!".toString());
        }
    }

    @Override // com.yoti.mobile.android.commonui.GuidelinesFragment
    protected void onPrimaryButtonClick() {
        ActivityResultCaller parentFragment = getParentFragment();
        if (parentFragment == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.commonui.NestedGuidelinesFragment.Listener");
        }
        ((Listener) parentFragment).onPrimaryButtonClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.commonui.BaseFragment
    public void navigateBack() {
        ActivityResultCaller parentFragment = getParentFragment();
        if (parentFragment == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.commonui.NestedGuidelinesFragment.Listener");
        }
        if (((Listener) parentFragment).onNavigateBack()) {
            return;
        }
        super.navigateBack();
    }

    /* JADX INFO: compiled from: GuidelinesFragment.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/NestedGuidelinesFragment$Companion;", "", "()V", "newInstance", "Lcom/yoti/mobile/android/commonui/NestedGuidelinesFragment;", "viewData", "Lcom/yoti/mobile/android/commonui/GuidelinesViewData;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NestedGuidelinesFragment newInstance(GuidelinesViewData viewData) {
            Intrinsics.checkNotNullParameter(viewData, "viewData");
            NestedGuidelinesFragment nestedGuidelinesFragment = new NestedGuidelinesFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_GUIDELINES_VIEW_DATA", viewData);
            nestedGuidelinesFragment.setArguments(bundle);
            return nestedGuidelinesFragment;
        }
    }
}
