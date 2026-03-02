package p000a.p001a.p002a.p003a.p014b.DataModels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: a.a.a.a.b.a.i, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorItem;", "", "id", "", "name", "consentState", "Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorItemConsentState;", "(Ljava/lang/String;Ljava/lang/String;Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorItemConsentState;)V", "getConsentState", "()Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorItemConsentState;", "setConsentState", "(Lcom/onetrust/otpublishers/headless/UI/DataModels/VendorItemConsentState;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class VendorItem {

    /* JADX INFO: renamed from: a */
    public final String f198a;

    /* JADX INFO: renamed from: b */
    public final String f199b;

    /* JADX INFO: renamed from: c */
    public VendorItemConsentState f200c;

    public VendorItem(String id, String name, VendorItemConsentState consentState) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(consentState, "consentState");
        this.f198a = id;
        this.f199b = name;
        this.f200c = consentState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VendorItem)) {
            return false;
        }
        VendorItem vendorItem = (VendorItem) other;
        return Intrinsics.areEqual(this.f198a, vendorItem.f198a) && Intrinsics.areEqual(this.f199b, vendorItem.f199b) && this.f200c == vendorItem.f200c;
    }

    public int hashCode() {
        return (((this.f198a.hashCode() * 31) + this.f199b.hashCode()) * 31) + this.f200c.hashCode();
    }

    public String toString() {
        return "VendorItem(id=" + this.f198a + ", name=" + this.f199b + ", consentState=" + this.f200c + ')';
    }
}
