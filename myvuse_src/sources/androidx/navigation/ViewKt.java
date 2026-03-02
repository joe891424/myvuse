package androidx.navigation;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m5598d2 = {"findNavController", "Landroidx/navigation/NavController;", "Landroid/view/View;", "navigation-runtime-ktx_release"}, m5599k = 2, m5600mv = {1, 1, 16})
public final class ViewKt {
    public static final NavController findNavController(View findNavController) {
        Intrinsics.checkParameterIsNotNull(findNavController, "$this$findNavController");
        NavController navControllerFindNavController = Navigation.findNavController(findNavController);
        Intrinsics.checkExpressionValueIsNotNull(navControllerFindNavController, "Navigation.findNavController(this)");
        return navControllerFindNavController;
    }
}
