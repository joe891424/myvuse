package p000a.p001a.p002a.p003a.p014b.fragment;

import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p000a.p001a.p002a.p003a.p014b.viewmodel.OTSDKListViewModel;

/* JADX INFO: renamed from: a.a.a.a.b.h.h */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, m5598d2 = {"<anonymous>", "", "id", "", "isChecked", "", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C0162h extends Lambda implements Function2<String, Boolean, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ OTSDKListFragment f1332a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0162h(OTSDKListFragment oTSDKListFragment) {
        super(2);
        this.f1332a = oTSDKListFragment;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(String str, Boolean bool) {
        String id = str;
        boolean zBooleanValue = bool.booleanValue();
        Intrinsics.checkNotNullParameter(id, "id");
        OTSDKListViewModel oTSDKListViewModelM869c = this.f1332a.m869c();
        oTSDKListViewModelM869c.getClass();
        Intrinsics.checkNotNullParameter(id, "id");
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = oTSDKListViewModelM869c.f1551b;
        if (oTPublishersHeadlessSDK != null) {
            oTPublishersHeadlessSDK.updateSDKConsentStatus(id, zBooleanValue);
        }
        oTSDKListViewModelM869c.f1561l.add(id);
        String strM191a = oTSDKListViewModelM869c.f1559j.m191a(id);
        if (strM191a != null) {
            oTSDKListViewModelM869c.f1562m.put(strM191a, oTSDKListViewModelM869c.f1561l);
        }
        oTSDKListViewModelM869c.m1007b();
        if (zBooleanValue) {
            oTSDKListViewModelM869c.m1010d();
        } else {
            oTSDKListViewModelM869c.f1567r.setValue(Boolean.FALSE);
        }
        return Unit.INSTANCE;
    }
}
