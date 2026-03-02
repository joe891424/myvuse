package com.yoti.mobile.android.documentscan.ui;

import android.content.Context;
import com.microblink.MicroblinkSDK;
import com.microblink.licence.exception.InvalidLicenceKeyException;
import com.yoti.mobile.android.commons.util.C4588L;
import com.yoti.mobile.android.documentscan.model.BlinkIDLicense;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/BlinkIDLicenseHelper;", "", "()V", "Companion", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class BlinkIDLicenseHelper {

    /* JADX INFO: renamed from: a */
    public static final a f7023a = new a(null);

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.a$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: a */
        public final boolean m4936a(BlinkIDLicense blinkIDLicense, Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            if (blinkIDLicense != null) {
                try {
                    MicroblinkSDK.setShowTrialLicenseWarning(false);
                    String licenseeName = blinkIDLicense.getLicenseeName();
                    if (licenseeName != null) {
                        MicroblinkSDK.setLicenseKey(blinkIDLicense.getApiKey(), licenseeName, context);
                        return true;
                    }
                    a aVar = BlinkIDLicenseHelper.f7023a;
                    MicroblinkSDK.setLicenseKey(blinkIDLicense.getApiKey(), context);
                    return true;
                } catch (InvalidLicenceKeyException e) {
                    C4588L.logError("BlinkIDLicenseHelper", "Invalid BlinkID licence key!", e);
                }
            }
            return false;
        }
    }
}
