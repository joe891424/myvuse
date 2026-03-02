package p000a.p001a.p002a.p003a.p014b.DataModels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: a.a.a.a.b.a.f, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, m5598d2 = {"Lcom/onetrust/otpublishers/headless/UI/DataModels/SDKItem;", "", "id", "", "name", "description", "consentState", "Lcom/onetrust/otpublishers/headless/UI/DataModels/SDKItemConsentState;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onetrust/otpublishers/headless/UI/DataModels/SDKItemConsentState;)V", "getConsentState", "()Lcom/onetrust/otpublishers/headless/UI/DataModels/SDKItemConsentState;", "getDescription", "()Ljava/lang/String;", "getId", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "OTPublishersHeadlessSDK_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class SDKItem {

    /* JADX INFO: renamed from: a */
    public final String f173a;

    /* JADX INFO: renamed from: b */
    public final String f174b;

    /* JADX INFO: renamed from: c */
    public final String f175c;

    /* JADX INFO: renamed from: d */
    public final SDKItemConsentState f176d;

    public SDKItem(String id, String name, String str, SDKItemConsentState consentState) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(consentState, "consentState");
        this.f173a = id;
        this.f174b = name;
        this.f175c = str;
        this.f176d = consentState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SDKItem)) {
            return false;
        }
        SDKItem sDKItem = (SDKItem) other;
        return Intrinsics.areEqual(this.f173a, sDKItem.f173a) && Intrinsics.areEqual(this.f174b, sDKItem.f174b) && Intrinsics.areEqual(this.f175c, sDKItem.f175c) && this.f176d == sDKItem.f176d;
    }

    public int hashCode() {
        int iHashCode = ((this.f173a.hashCode() * 31) + this.f174b.hashCode()) * 31;
        String str = this.f175c;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f176d.hashCode();
    }

    public String toString() {
        return "SDKItem(id=" + this.f173a + ", name=" + this.f174b + ", description=" + this.f175c + ", consentState=" + this.f176d + ')';
    }
}
