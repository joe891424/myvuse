package androidx.navigation.p033ui;

import androidx.navigation.p033ui.AppBarConfiguration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 */
/* JADX INFO: compiled from: AppBarConfiguration.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 15})
public final class C1001x56421ee5 implements AppBarConfiguration.OnNavigateUpListener {
    private final /* synthetic */ Function0 function;

    public C1001x56421ee5(Function0 function0) {
        this.function = function0;
    }

    @Override // androidx.navigation.ui.AppBarConfiguration.OnNavigateUpListener
    public final /* synthetic */ boolean onNavigateUp() {
        Object objInvoke = this.function.invoke();
        Intrinsics.checkExpressionValueIsNotNull(objInvoke, "invoke(...)");
        return ((Boolean) objInvoke).booleanValue();
    }
}
