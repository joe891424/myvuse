package com.yoti.mobile.android.mrtd.view;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.yoti.mobile.android.mrtd.C4900R;
import com.yoti.mobile.android.mrtd.MrtdNavGraphDirections;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdScanFragmentDirections;", "", "()V", "Companion", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdScanFragmentDirections {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdScanFragmentDirections$Companion;", "", "()V", "actionEnableNfc", "Landroidx/navigation/NavDirections;", "actionReadNfc", "actionRestartFlow", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDirections actionEnableNfc() {
            return new ActionOnlyNavDirections(C4900R.id.action_enable_nfc);
        }

        public final NavDirections actionReadNfc() {
            return new ActionOnlyNavDirections(C4900R.id.action_read_nfc);
        }

        public final NavDirections actionRestartFlow() {
            return MrtdNavGraphDirections.INSTANCE.actionRestartFlow();
        }
    }

    private MrtdScanFragmentDirections() {
    }
}
