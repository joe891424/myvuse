package androidx.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ViewModelStores {
    private ViewModelStores() {
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static ViewModelStore m1224of(FragmentActivity fragmentActivity) {
        return fragmentActivity.getViewModelStore();
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static ViewModelStore m1223of(Fragment fragment) {
        return fragment.getViewModelStore();
    }
}
