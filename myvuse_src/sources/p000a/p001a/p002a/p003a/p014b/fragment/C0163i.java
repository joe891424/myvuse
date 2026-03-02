package p000a.p001a.p002a.p003a.p014b.fragment;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p000a.p001a.p002a.p003a.p014b.viewmodel.OTSDKListViewModel;

/* JADX INFO: renamed from: a.a.a.a.b.h.i */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m5598d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C0163i extends Lambda implements Function1<String, Boolean> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ OTSDKListFragment f1333a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0163i(OTSDKListFragment oTSDKListFragment) {
        super(1);
        this.f1333a = oTSDKListFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(String str) {
        String it2 = str;
        Intrinsics.checkNotNullParameter(it2, "it");
        OTSDKListViewModel oTSDKListViewModelM869c = this.f1333a.m869c();
        oTSDKListViewModelM869c.getClass();
        return Boolean.valueOf(it2 == null ? false : oTSDKListViewModelM869c.f1550a.m277b(it2));
    }
}
